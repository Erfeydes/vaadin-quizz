package com.lille.ari_vaadin.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.lille.ari_vaadin.models.Question;
import com.lille.ari_vaadin.services.QuestionService;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Quizz page
 */
@Route(value = "quizz")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

	/**
	 * Choose a Vaadin view if the questions are been generated or no Build the
	 * initial UI state for the user accessing the application.
	 *
	 * @param service The message service. Automatically injected Spring managed
	 *                bean.
	 */
	public MainView(@Autowired QuestionService service) {
		if (HomeView.questions == null) {
			goToHomePage();
		} else {
			loadPage();
		}
	}

	/**
	 * Construct a view if the questions are'nt been generated
	 */
	public void goToHomePage() {
		// TODO
		// Return to the home page
	}

	/**
	 * Construct a view if the questions are been generated
	 */
	public void loadPage() {
		// TODO
		// display score if all question are been answered
		// display question and potential answer if questions are not answered yet
	}

	/**
	 * Generate vertical layout with answer buttons
	 * 
	 * @param question the current question
	 * @return vertical layout contains only buttons
	 */
	public VerticalLayout responses(Question question) {
		// TODO
		// 2 types of questions : true/false or MCQ (QCM)
		// 2 buttons for true and false or 4 buttons for MCQ
		// You are free to display the buttons are you want
		return null;
	}

	/**
	 * Behavior when you click on answer button : If the question is already
	 * answered : do nothing / Set class name for general view : if good answer the
	 * class name is "goodAnswer", "badAnswer" otherwise / Increment the total of
	 * good answers / Make a notification with the good answer if the answer is
	 * incorrect / Call nextQuestion()
	 * 
	 * @param answer          the answer chosen by the user
	 * @param currentQuestion the current question
	 */
	public void answer(String answer, Question currentQuestion) {
		// TODO
		// Handle the user answer
	}

	/**
	 * Add a button to pass to the next question. The button handle the pass to the
	 * next question
	 */
	public void nextQuestion() {
		// TODO
		// Handle the next question
	}

	/**
	 * Display the score
	 */
	public void displayScore() {
		// TODO
		// Display score
	}

}
