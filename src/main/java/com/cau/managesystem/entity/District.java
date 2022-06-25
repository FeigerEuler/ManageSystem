package com.cau.managesystem.entity;

import lombok.Data;

import java.util.List;

@Data
public class District {
           private String  citycode;
            private String adcode;
            private String level;
            private String name;

            private List<District> districts;
}
