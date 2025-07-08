package com.example.eventlistener.listener;

import com.example.eventlistener.pojo.Order;
import com.example.eventlistener.pojo.Person;
import com.example.eventlistener.pojo.event.BaseEvent;
import com.example.eventlistener.pojo.event.OrderEvent;
import com.example.eventlistener.pojo.event.PersonEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventListenerService {

//    @EventListener
//    public void handlePersonEvent(PersonEvent personEvent) {
//        log.info("监听到PersonEvent: {}", personEvent);
//    }
//
//    @EventListener
//    public void handleOrderEvent(OrderEvent orderEvent){
//        log.info("监听到OrderEvent:{}", orderEvent);
//    }
    @EventListener
    public void handlePersonEvent(BaseEvent<Person> personEvent) {
        log.info("监听到PersonEvent: {}", personEvent);
    }

    @EventListener
    public void handleOrderEvent(BaseEvent<Order> orderEvent){
        log.info("监听到OrderEvent:{}", orderEvent);
    }

}
