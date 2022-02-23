package com.meep.resourcegetter.service.impl;

import com.meep.resourcegetter.client.ResourceGetterClient;
import com.meep.resourcegetter.entity.ResourceInfo;
import com.meep.resourcegetter.service.ResourceGetterService;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ResourceGetterServiceImpl implements ResourceGetterService {

    @Value("${resourceGetter.lowerLeftLatLon}")
    private String lowerLeftLatLon;

    @Value("${resourceGetter.upperRightLatLon}")
    private String upperRightLatLon;

    @Value("${resourceGetter.companyZoneIds}")
    private String companyZoneIds;

    private final ResourceGetterClient resourceGetterClient;

    public ResourceGetterServiceImpl(ResourceGetterClient resourceGetterClient) {
        this.resourceGetterClient = resourceGetterClient;
    }

    @Override
    @Scheduled(fixedRateString = "${resourceGetter.fixed.rate}")
    public void getResourceInfo() {
        try {
            List<ResourceInfo> resourceInfos = resourceGetterClient.getServerFirstServiceData(lowerLeftLatLon, upperRightLatLon, companyZoneIds);
            log.info("Total resources received {}:\n{}", resourceInfos.size(), resourceInfos);
        } catch (FeignException e) {
            log.error("Feign error happened: ", e);
        }
    }
}
