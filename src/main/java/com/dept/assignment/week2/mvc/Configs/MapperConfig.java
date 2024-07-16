package com.dept.assignment.week2.mvc.Configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // it indicates this class is source of bean definition
public class MapperConfig {
@Bean
public ModelMapper getModelMapper(){
    return new ModelMapper();
}
}
