package com.endryha.aws;

import com.github.javafaker.Faker;
import com.martensigwart.fakeload.FakeLoadExecutor;
import com.martensigwart.fakeload.FakeLoadExecutors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class SpringBootAwsAutoscaleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAwsAutoscaleAppApplication.class, args);
    }

    @Bean
    Faker faker() {
        return new Faker();
    }

    @Bean
    FakeLoadExecutor fakeLoadExecutor() {
        return FakeLoadExecutors.newDefaultExecutor();
    }
}
