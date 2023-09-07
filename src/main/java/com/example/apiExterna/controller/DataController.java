package com.example.apiExterna.controller;

import com.example.apiExterna.DTO.DataDTO;
import com.example.apiExterna.service.DataServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DataController {
    private static final Logger LOG = LoggerFactory.getLogger(DataController.class);

    @Autowired
    private DataServices dataServices;


    @GetMapping("/get")
    public DataDTO[] getData() {
        LOG.info("ConsumerApi/get, Request{}");
        return dataServices.getData();
    }
}
