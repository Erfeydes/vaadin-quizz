package com.lille.ari_vaadin.views;

import java.util.List;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.NumberField;
import org.springframework.beans.factory.annotation.Autowired;

import com.lille.ari_vaadin.models.Question;
import com.lille.ari_vaadin.services.CocktailService;
import com.lille.ari_vaadin.services.QuestionService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route("")
@PWA(name = "Vaadin Application", shortName = "Vaadin App", description = "This is an example Vaadin application.", enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class HomeView extends VerticalLayout {

	/**
	 * The questions for the quizz
	 */
	public static List<Question> questions;

	/**
	 * Service to CocktailView
	 */
	private CocktailService cocktailService;

	/**
	 * Service to MainView
	 */
	private QuestionService questionService;

	/**
	 * Construct the Vaadin Home page
	 * 
	 * @param questionService the question service
	 * @param cocktailService the cocktail service
	 */
	@Autowired
	public HomeView(QuestionService questionService, CocktailService cocktailService) {
		this.cocktailService = cocktailService;
		this.questionService = questionService;

		HorizontalLayout menu = new HorizontalLayout();

		Button buttonQuizz = new Button("Quizz");
		buttonQuizz.addClickListener(e -> startQuizz().open());
		//menu.addAndExpand(buttonQuizz);
		buttonQuizz.addThemeVariants(ButtonVariant.LUMO_LARGE);
		buttonQuizz.setClassName("buttonResponse");
		menu.add(buttonQuizz);

		//Button buttonCocktail = new Button("Random coktail");
		//buttonCocktail.addClickListener(e -> buttonCocktail.getUI().ifPresent(ui -> ui.navigate("cocktail")));
		//menu.addAndExpand(buttonCocktail);

		HorizontalLayout images = imageBanner();
		add(images, menu);
		setAlignItems(Alignment.CENTER);
	}

	/**
	 * Banner with all images
	 * 
	 * @return a horizontal layout
	 */
	public HorizontalLayout imageBanner() {
		HorizontalLayout images = new HorizontalLayout();
		Image univLogo = new Image(
				"https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/Universit%C3%A9_de_Lille_logo.svg/1200px-Universit%C3%A9_de_Lille_logo.svg.png",
				"Université de Lille");
		univLogo.setWidth("300px");
		Image vaadinLogo = new Image("https://cdn2.hubspot.net/hubfs/1840687/Pages/trademark/vaadin-logo-full.svg",
				"Vaadin");
		vaadinLogo.setWidth("300px");
		images.add(univLogo, vaadinLogo);
		return images;
	}

	/**
	 * Dialog to start quizz. The user fill in the wanted number of question
	 * 
	 * @return a dialog
	 */
	public Dialog startQuizz() {
		VerticalLayout layout = new VerticalLayout();
		Text text = new Text("How many questions do you want?");
		NumberField questionsNumber = new NumberField();
		questionsNumber.setHasControls(true);
		questionsNumber.setStep(1);
		questionsNumber.setMin(1);
		Dialog dialog = new Dialog();
		Button button = new Button("Submit");
		button.addClickListener(event -> {
			if (questionsNumber.getValue() == null || questionsNumber.getValue() <= 0) {
				Notification notification = new Notification("You have to choose a number of questions", 3000, Notification.Position.TOP_CENTER);
				notification.open();
			} else {
				this.questions = this.questionService.getQuestion((int)Math.round(questionsNumber.getValue())).getResults();
				button.getUI().ifPresent(ui -> ui.navigate("quizz"));
				dialog.close();
			}
		});
		layout.add(text, questionsNumber, button);
		layout.setAlignItems(Alignment.CENTER);
		dialog.add(layout);
		return dialog;
	}

}
