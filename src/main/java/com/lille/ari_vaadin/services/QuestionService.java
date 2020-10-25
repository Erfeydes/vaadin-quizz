package com.lille.ari_vaadin.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import com.lille.ari_vaadin.ressource.QuestionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lille.ari_vaadin.models.ResponseAPI;

@Service
public class QuestionService implements Serializable {

	QuestionResource questionResource;

	public QuestionService(QuestionResource questionResource) {
		this.questionResource = questionResource;
	}

	public ResponseAPI getQuestion(int quantity){
		return questionResource.getQuestion(quantity);
	}

}
