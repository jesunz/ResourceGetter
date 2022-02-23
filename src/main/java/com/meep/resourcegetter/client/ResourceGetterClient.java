package com.meep.resourcegetter.client;

import com.meep.resourcegetter.entity.ResourceInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${resourceGetter.feign.client.name}", url = "${resourceGetter.feign.client.url}", path = "${resourceGetter.feign.client.path}", fallback = ResourceGetterClientFallback.class)
public interface ResourceGetterClient {

    @GetMapping(value = "/resources", consumes = "application/json")
    List<ResourceInfo> getServerFirstServiceData(@RequestParam String lowerLeftLatLon,
                                                 @RequestParam String upperRightLatLon,
                                                 @RequestParam String companyZoneIds);
}
