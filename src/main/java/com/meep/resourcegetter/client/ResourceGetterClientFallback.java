package com.meep.resourcegetter.client;

import com.meep.resourcegetter.entity.ResourceInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResourceGetterClientFallback implements ResourceGetterClient{
    @Override
    public List<ResourceInfo> getServerFirstServiceData(String lowerLeftLatLon, String upperRightLatLon, String companyZoneIds) {
        return new ArrayList<>();
    }
}
