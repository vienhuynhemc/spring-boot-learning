import { Injectable } from '@angular/core';
import { Observable, Observer, Subject } from 'rxjs';
import * as Rx from 'rxjs'
@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  private subject: Rx.Subject<MessageEvent> | undefined

  constructor() { }

  // Connect
  public connect(url:any): Subject<MessageEvent> {
    if (!this.subject) {
      this.subject = this.create(url);
    }
    return this.subject;
  }

  private create(url:any): Subject<MessageEvent> {
    let ws = new WebSocket(url);
    let observable = Observable.create(
      (obs: Observer<MessageEvent>) => {
        ws.onmessage = obs.next.bind(obs);
        ws.onerror = obs.error.bind(obs);
        ws.onclose = obs.complete.bind(obs);
        return ws.close.bind(ws);
      }
    )
    let observer = {
      next: (data: Object) => {
        if (ws.readyState === WebSocket.OPEN) {
          ws.send(JSON.stringify(data));
        }
      }
    }
    return Subject.create(observer, observable);
  }


}
