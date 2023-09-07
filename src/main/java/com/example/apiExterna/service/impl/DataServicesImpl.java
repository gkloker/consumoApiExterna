package com.example.apiExterna.service.impl;

import com.example.apiExterna.DTO.DataDTO;
import com.example.apiExterna.config.DataProperties;
import com.example.apiExterna.service.DataServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class DataServicesImpl implements DataServices {
    private static final Logger LOG = LoggerFactory.getLogger(DataServicesImpl.class);

    @Autowired
    private DataProperties dataProperties;

    private final RestTemplate restTemplate;

    public DataServicesImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public DataDTO[] getData() {
        String path = dataProperties.getPath();
        String url = UriComponentsBuilder.fromHttpUrl(path).toUriString();

        //HttpHeaders headers = new HttpHeaders();
        //headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        //HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        try {
            DataDTO[] response = restTemplate.getForObject(url, DataDTO[].class);

            return response;
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

        return null;
    }
}
