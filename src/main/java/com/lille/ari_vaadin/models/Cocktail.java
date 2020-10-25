package com.lille.ari_vaadin.models;

public class Cocktail {

    private String strDrink;
    private String strInstructions;
    private String strDrinkThumb;

    public Cocktail() {
    }

    public Cocktail(String strDrink, String strInstructions, String strDrinkThumb) {
        this.strDrink = strDrink;
        this.strInstructions = strInstructions;
        this.strDrinkThumb = strDrinkThumb;
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "strDrink='" + strDrink + '\'' +
                ", strInstructions='" + strInstructions + '\'' +
                ", strDrinkThumb='" + strDrinkThumb + '\'' +
                '}';
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }
}
