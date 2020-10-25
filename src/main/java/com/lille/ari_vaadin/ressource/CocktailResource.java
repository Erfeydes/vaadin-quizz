package com.lille.ari_vaadin.ressource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lille.ari_vaadin.models.Cocktail;
import com.lille.ari_vaadin.models.CocktailList;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Repository
public class CocktailResource {

    private static final String URL_COCKTAIL_API = "https://www.thecocktaildb.com/api/json/v1/1/";
    private static final String ENDPOINT_RANDOM_COCKTAIL = "random.php";

    private RestTemplate restTemplate;

    public CocktailResource(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Cocktail getRandomCocktail() {
        try {
            StringBuilder request = new StringBuilder(URL_COCKTAIL_API);
            request.append("/").append(ENDPOINT_RANDOM_COCKTAIL);
            return this.restTemplate.getForEntity(request.toString(), CocktailList.class).getBody().getDrinks().get(0);
        } catch (HttpClientErrorException e) {
            return null;
        }
    }
}
