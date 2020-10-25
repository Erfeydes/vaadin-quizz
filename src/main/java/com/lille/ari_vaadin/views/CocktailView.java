package com.lille.ari_vaadin.views;

import com.lille.ari_vaadin.models.Cocktail;
import com.lille.ari_vaadin.ressource.CocktailResource;
import com.lille.ari_vaadin.services.CocktailService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route(value = "cocktail")
public class CocktailView  extends VerticalLayout {

    CocktailService cocktailService;

    Grid<Cocktail> cocktailGrid;
    List<Cocktail> cocktailList;

    @Autowired
    public CocktailView(CocktailService cocktailService){
        this.cocktailService = cocktailService;

        this.cocktailList = new ArrayList<>();
        this.cocktailList.add(cocktailService.getRandomCocktail());

        this.cocktailGrid = new Grid<>(Cocktail.class);
        cocktailGrid.setItems(this.cocktailList);
        cocktailGrid.removeColumnByKey("strDrinkThumb");

        cocktailGrid.addComponentColumn(cocktail -> {
            Image cocktailImage = new Image(cocktail.getStrDrinkThumb(),"alt");
            cocktailImage.setMaxHeight("50%");
            cocktailImage.setMaxWidth("50%");
            return cocktailImage;
        });

        Button button = new Button("New random cocktail");
        button.addClickListener(buttonClickEvent -> {
            cocktailList.add(cocktailService.getRandomCocktail());
            this.cocktailGrid.getDataProvider().refreshAll();
            this.cocktailGrid.recalculateColumnWidths();
        });

        add(button, cocktailGrid);
    }

}
