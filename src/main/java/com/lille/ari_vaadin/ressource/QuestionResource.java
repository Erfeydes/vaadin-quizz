package com.lille.ari_vaadin.ressource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lille.ari_vaadin.models.CocktailList;
import com.lille.ari_vaadin.models.ResponseAPI;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Repository
public class QuestionResource {

    private RestTemplate restTemplate;

    public QuestionResource(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseAPI getQuestion(int quantity) {
        try {
            return this.restTemplate.getForEntity("https://opentdb.com/api.php?amount="+quantity,
                    ResponseAPI.class).getBody();
        } catch (HttpClientErrorException e) {
            return null;
        }
    }
}
