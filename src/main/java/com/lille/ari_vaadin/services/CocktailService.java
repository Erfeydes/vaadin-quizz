package com.lille.ari_vaadin.services;

import com.lille.ari_vaadin.models.Cocktail;
import com.lille.ari_vaadin.ressource.CocktailResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocktailService {

    private CocktailResource cocktailResource;

    @Autowired
    public void CocktailService(CocktailResource cocktailResource){
        this.cocktailResource = cocktailResource;
    }

    public Cocktail getRandomCocktail() {
        return cocktailResource.getRandomCocktail();
    }

}
