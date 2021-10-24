package com.endryha.aws;

import com.endryha.aws.dto.Star;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class SpaceController {

    private final Faker faker;

    public SpaceController(Faker faker) {
        this.faker = faker;
    }

    @GetMapping("/stars")
    public List<Star> getStars(@RequestParam(value = "n", defaultValue = "10") int n) throws JsonProcessingException {
        List<Star> stars = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            stars.add(new Star(UUID.randomUUID().toString(), faker.space().star()));
        }
        return stars;
    }
}
