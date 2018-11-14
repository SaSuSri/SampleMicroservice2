package com.sairam.practice.sampledata.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ExternalRequestController {

    @Value ("${sampleMS1.uri}")
    String sampleMS1URI;

    @RequestMapping(value="/listdata", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void receiveStringFromAnotherMS(){
        List<String> list = null;

        list = new RestTemplate().getForObject(sampleMS1URI,List.class);

        System.out.println(list.toString());
        System.out.println("-->"+list);
    }
}
