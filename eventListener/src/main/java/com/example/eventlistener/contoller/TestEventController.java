package com.example.eventlistener.contoller;

import com.example.eventlistener.pojo.Order;
import com.example.eventlistener.pojo.Person;
import com.example.eventlistener.pojo.event.BaseEvent;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestEventController {

    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("/publishEvent")
    public void publishEvent() {
        applicationContext.publishEvent(new BaseEvent<>(new Person("why"), "add"));
        applicationContext.publishEvent(new BaseEvent<>(new Order("why"), "update"));
    }
}
