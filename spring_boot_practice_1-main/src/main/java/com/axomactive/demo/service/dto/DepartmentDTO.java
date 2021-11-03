package com.axomactive.demo.service.dto;

import com.axomactive.demo.entity.LocationEnum;
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
