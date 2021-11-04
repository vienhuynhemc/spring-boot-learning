package com.axonactive.demo_spring.service.dto;

import com.axonactive.demo_spring.entity.LocationEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DepartmentDTO {
    private String name;
    private LocationEnum location;
}
