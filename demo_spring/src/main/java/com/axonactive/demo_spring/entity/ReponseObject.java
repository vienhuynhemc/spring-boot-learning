package com.axonactive.demo_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseObject {
    private String status;
    private String message;
    private Object data;
}
