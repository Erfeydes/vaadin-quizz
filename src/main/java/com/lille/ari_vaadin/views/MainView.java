package com.lille.ari_vaadin.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.lille.ari_vaadin.models.Question;
import com.lille.ari_vaadin.services.QuestionService;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Collections;
import java.util.List;

/**
 * Quizz page
 */
@Route(value = "quizz")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {
	private int index = 0;
	private int correct = 0;
	private boolean end = false;
	private VerticalLayout layout;

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
		Button button = new Button("Go back to Homepage");
		button.addClickListener(e -> button.getUI().ifPresent(ui -> ui.navigate("")));
		add(button);
		setAlignItems(Alignment.CENTER);
	}

	/**
	 * Construct a view if the questions are been generated
	 */
	public void loadPage() {
		if (index == HomeView.questions.size()) {
			displayScore();
		} else {
			layout = new VerticalLayout();
			Span question = new Span(StringEscapeUtils.unescapeHtml4(HomeView.questions.get(index).getQuestion()));
			question.addClassName("question");
			Span difficulty = new Span("Difficulty: " + HomeView.questions.get(index).getDifficulty());
			difficulty.addClassName("difficulty");
			layout.add(question, difficulty, responses(HomeView.questions.get(index)));
			layout.setAlignItems(Alignment.CENTER);
			setSizeFull();
			addClassName("centered-content");
			add(layout);
		}
	}

	/**
	 * Generate vertical layout with answer buttons
	 * 
	 * @param question the current question
	 * @return vertical layout contains only buttons
	 */
	public VerticalLayout responses(Question question) {
		VerticalLayout answers = new VerticalLayout();

		if (question.getType().equals("boolean")) { //two questions
			HorizontalLayout horizontal = new HorizontalLayout();
			Button trueBtn = new Button("True", new Icon(VaadinIcon.CHECK), event -> answer("True", question));
			Button falseBtn = new Button("False", new Icon(VaadinIcon.CLOSE), event -> answer("False", question));

			//add colooor
			trueBtn.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
			trueBtn.addThemeVariants(ButtonVariant.LUMO_LARGE);
			trueBtn.setClassName("buttonResponse");
			falseBtn.addThemeVariants(ButtonVariant.LUMO_ERROR);
			falseBtn.addThemeVariants(ButtonVariant.LUMO_LARGE);
			falseBtn.setClassName("buttonResponse");

			horizontal.add(trueBtn, falseBtn);
			answers.add(horizontal);
		} else { //four questions
			List<String> propositions = question.getIncorrect_answers();
			propositions.add(question.getCorrect_answer());

			Collections.shuffle(propositions); //the correct answer won't be the last one every time

			Button first = new Button(StringEscapeUtils.unescapeHtml4(propositions.get(0)), new Icon(VaadinIcon.QUESTION_CIRCLE_O), event -> answer(propositions.get(0), question));
			first.setClassName("buttonResponse");
			first.addThemeVariants(ButtonVariant.LUMO_LARGE);
			first.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
			Button second = new Button(StringEscapeUtils.unescapeHtml4(propositions.get(1)), new Icon(VaadinIcon.QUESTION_CIRCLE_O), event -> answer(propositions.get(1), question));
			second.setClassName("buttonResponse");
			second.addThemeVariants(ButtonVariant.LUMO_LARGE);
			second.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
			Button third = new Button(StringEscapeUtils.unescapeHtml4(propositions.get(2)), new Icon(VaadinIcon.QUESTION_CIRCLE_O), event -> answer(propositions.get(2), question));
			third.setClassName("buttonResponse");
			third.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
			third.addThemeVariants(ButtonVariant.LUMO_LARGE);
			Button fourth = new Button(StringEscapeUtils.unescapeHtml4(propositions.get(3)), new Icon(VaadinIcon.QUESTION_CIRCLE_O), event -> answer(propositions.get(3), question));
			fourth.setClassName("buttonResponse");
			fourth.addThemeVariants(ButtonVariant.LUMO_LARGE);
			fourth.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

			HorizontalLayout firstBtn = new HorizontalLayout();
			firstBtn.add(first, second);
			HorizontalLayout secondBtn = new HorizontalLayout();
			secondBtn.add(third, fourth);
			answers.add(firstBtn, secondBtn);
		}

		answers.setAlignItems(Alignment.CENTER);
		return answers;
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
		if (end) return;
		boolean isCorrect = answer.equals(currentQuestion.getCorrect_answer());
		if (isCorrect) {
			addClassName("goodAnswer");
			this.correct++;
		} else {
			addClassName("badAnswer");
			Notification notification = new Notification("The correct answer is " + StringEscapeUtils.unescapeHtml4(currentQuestion.getCorrect_answer()), 2000, Notification.Position.TOP_CENTER);
			notification.open();
		}
		nextQuestion();
		end = true;
	}

	/**
	 * Add a button to pass to the next question. The button handle the pass to the
	 * next question
	 */
	public void nextQuestion() {
		Button button = new Button("Next", new Icon(VaadinIcon.ARROW_RIGHT), event -> {
			removeClassNames("goodAnswer", "badAnswer");
			this.index++;
			end = false;
			removeAll();
			loadPage();
		});
		button.setIconAfterText(true);
		button.addThemeVariants(ButtonVariant.LUMO_LARGE);
		button.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
		layout.add(button);
		add(layout);
	}

	/**
	 * Display the score
	 */
	public void displayScore() {
		Span score = new Span("Your score: " + correct + "/" + HomeView.questions.size());
		Button button = new Button("Go back to Homepage");
		button.addClickListener(e -> button.getUI().ifPresent(ui -> ui.navigate("")));
		button.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
		add(score, button);
		setAlignItems(Alignment.CENTER);
	}

}
