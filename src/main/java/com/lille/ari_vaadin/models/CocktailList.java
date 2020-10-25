package com.lille.ari_vaadin.models;

import java.util.List;


public class CocktailList {

    private List<Cocktail> drinks;

    public CocktailList() {
    }

    public CocktailList(List<Cocktail> drinks) {
        this.drinks = drinks;
    }

    public List<Cocktail> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Cocktail> drinks) {
        this.drinks = drinks;
    }
}
