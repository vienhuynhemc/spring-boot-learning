import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

// Lottie
import player from 'lottie-web';
import { LottieModule } from 'ngx-lottie';
export function playerFactory() {
  return player;
}
// thư viện get request
import { HttpClientModule } from '@angular/common/http';
// tooltip
import { MatTooltipModule } from '@angular/material/tooltip';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import { NotFoundPageComponent } from './view/not-found-page/not-found-page.component';
import { MainPageComponent } from './view/main-page/main-page.component';
import { DepartmentPageComponent } from './view/main-page/department-page/department-page.component';
import { EmployeePageComponent } from './view/main-page/employee-page/employee-page.component';

@NgModule({
  declarations: [
    AppComponent,
    NotFoundPageComponent,
    MainPageComponent,
    DepartmentPageComponent,
    EmployeePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // http
    HttpClientModule,
    // lottie
    LottieModule.forRoot({ player: playerFactory }),
    // tooltip
    MatTooltipModule,
    NoopAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
