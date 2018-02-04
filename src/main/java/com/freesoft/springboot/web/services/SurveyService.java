package com.freesoft.springboot.web.services;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.freesoft.springboot.web.beans.Question;
import com.freesoft.springboot.web.beans.Survey;

@Service
public class SurveyService {

	private static List<Survey> surveys = new ArrayList<>();

	static {
		Question q1 = new Question("Question1", "Largest Country in the World", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));
		Question q2 = new Question("Question2", "Most Populus Country in the World", "China",
				Arrays.asList("India", "Russia", "United States", "China"));
		Question q3 = new Question("Question3", "Highest GDP in the World", "United States",
				Arrays.asList("India", "Russia", "United States", "China"));
		Question q4 = new Question("Question4", "Second largest english speaking country", "India",
				Arrays.asList("India", "Russia", "United States", "China"));
		List<Question> questions = new ArrayList<>(Arrays.asList(q1, q2, q3, q4));
		Survey survey = new Survey("Survey1", "My Favorite Survey", "Description of the Survey", questions);
		surveys.add(survey);
	}

	public List<Survey> retriveAllSurveys() {
		return surveys;
	}

	public Survey retriveSurvey(String surveyId) {
		return surveys.stream().filter(s -> s.getId().equals(surveyId)).findAny().get();
	}

	public List<Question> retrieveQuestions(String surveyId) {
		return retriveSurvey(surveyId) == null ? null : retriveSurvey(surveyId).getQuestions();
	}

	public Question retrieveQuestion(String surveyId, String questionId) {
		return retriveSurvey(surveyId) == null ? null
				: retriveSurvey(surveyId).getQuestions().stream().filter(q -> q.getId().equals(questionId)).findAny()
						.get();
	}

	private SecureRandom random = new SecureRandom();

	public Question addQuestion(String surveyId, Question question) {
		Survey survey = retriveSurvey(surveyId);
		if (survey == null) {
			return null;
		}
		String randomId = new BigInteger(130, random).toString(32);
		question.setId(randomId);
		survey.getQuestions().add(question);
		return question;
	}
}
