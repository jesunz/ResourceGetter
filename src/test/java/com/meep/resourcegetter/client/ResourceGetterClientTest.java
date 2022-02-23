package com.meep.resourcegetter.client;

import com.meep.resourcegetter.entity.ResourceInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ResourceGetterClientTest {

    @Value("${resourceGetter.lowerLeftLatLon}")
    private String lowerLeftLatLon;

    @Value("${resourceGetter.upperRightLatLon}")
    private String upperRightLatLon;

    @Value("${resourceGetter.companyZoneIds}")
    private String companyZoneIds;

    @Autowired
    private ResourceGetterClient resourceGetterClient;

    @Test
    public void shouldLoadAllPosts() {
        List<ResourceInfo> resources = resourceGetterClient.getServerFirstServiceData(lowerLeftLatLon, upperRightLatLon, companyZoneIds);
        assertNotNull(resources);
        assertFalse(resources.isEmpty());
    }

}
