package com.meep.resourcegetter.entity;

import lombok.Data;

import java.util.List;

@Data
public class ResourceInfo {

    private String id;
    private String name;
    private float x;
    private float y;
    private String licencePlate;
    private int range;
    private int batteryLevel;
    private String helmets;
    private String model;
    private String resourceImageId;
    private List<String> resourcesImagesUrls;
    private boolean realTimeData;
    private String resourceType;
    private int companyZoneId;
}
