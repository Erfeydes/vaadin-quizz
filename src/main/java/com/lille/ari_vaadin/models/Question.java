package com.lille.ari_vaadin.models;

import java.util.List;

public class Question {
	
	private String category;
	private String type;
	private String difficulty;
	private String question;
	private String correct_answer;
	private List<String> incorrect_answers;
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the difficulty
	 */
	public String getDifficulty() {
		return difficulty;
	}
	/**
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the correct_answer
	 */
	public String getCorrect_answer() {
		return correct_answer;
	}
	/**
	 * @param correct_answer the correct_answer to set
	 */
	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}
	/**
	 * @return the incorrect_answers
	 */
	public List<String> getIncorrect_answers() {
		return incorrect_answers;
	}
	/**
	 * @param incorrect_answers the incorrect_answers to set
	 */
	public void setIncorrect_answers(List<String> incorrect_answers) {
		this.incorrect_answers = incorrect_answers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((correct_answer == null) ? 0 : correct_answer.hashCode());
		result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
		result = prime * result + ((incorrect_answers == null) ? 0 : incorrect_answers.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (correct_answer == null) {
			if (other.correct_answer != null)
				return false;
		} else if (!correct_answer.equals(other.correct_answer))
			return false;
		if (difficulty == null) {
			if (other.difficulty != null)
				return false;
		} else if (!difficulty.equals(other.difficulty))
			return false;
		if (incorrect_answers == null) {
			if (other.incorrect_answers != null)
				return false;
		} else if (!incorrect_answers.equals(other.incorrect_answers))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	

}
