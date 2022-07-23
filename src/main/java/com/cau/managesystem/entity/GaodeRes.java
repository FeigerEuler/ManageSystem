package com.cau.managesystem.entity;

import lombok.Data;

import java.util.List;

@Data
public class GaodeRes {
           private String status;
           private String info;
           private String infoCode;
           private List<District> districts;
}
