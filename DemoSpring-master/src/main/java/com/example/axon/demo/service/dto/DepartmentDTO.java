package com.example.axon.demo.service.dto;

import com.example.axon.demo.entity.LocationEnum;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
public class DepartmentDTO {
    private String name;
    private LocationEnum location;
}
