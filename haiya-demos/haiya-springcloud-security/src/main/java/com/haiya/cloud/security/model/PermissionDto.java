package com.haiya.cloud.security.model;

import lombok.Data;

@Data
public class PermissionDto {
    private String id;
    private String code;
    private String description;
    private String url;
}
