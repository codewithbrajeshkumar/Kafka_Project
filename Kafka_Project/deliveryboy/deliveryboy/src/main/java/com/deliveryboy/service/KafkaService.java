package com.deliveryboy.service;

import com.deliveryboy.config.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaService {

    private Logger logger = Logger.getLogger(String.valueOf(KafkaService.class));

    @Autowired
    private KafkaTemplate<String, String> KafkaTemplate;

    public boolean updateLocation(String location) {

        this.KafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
        for (int i = 0; i <= 100; i++) {
            this.KafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
            this.logger.info("message produced" + i);
            System.out.println("----------------------");
        }
        return true;
    }
}
