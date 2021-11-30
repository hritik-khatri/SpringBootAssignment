package com.example.accessingdatamysql;

import com.example.accessingdatamysql.Employee.EmployeeServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.accessingdatamysql.Employee")
public class temp {

    @Bean
    public EmployeeServices em(){
        return new EmployeeServices();
    }
}
