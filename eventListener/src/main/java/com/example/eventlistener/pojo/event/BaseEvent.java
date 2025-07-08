package com.example.eventlistener.pojo.event;

import lombok.Data;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

@Data
public class BaseEvent<T> implements ResolvableTypeProvider {
    private T data;
    private String addOrUpdate;

    public BaseEvent(T data, String addOrUpdate){
        this.data = data;
        this.addOrUpdate = addOrUpdate;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getData()));
    }
}
