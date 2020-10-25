package com.lille.ari_vaadin.models;

import java.util.List;

public class ResponseAPI {

	private int response_code;
	private List<Question> results;

	/**
	 * @return the response_code
	 */
	public int getResponse_code() {
		return response_code;
	}

	/**
	 * @param response_code the response_code to set
	 */
	public void setResponse_code(int response_code) {
		this.response_code = response_code;
	}

	/**
	 * @return the results
	 */
	public List<Question> getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(List<Question> results) {
		this.results = results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + response_code;
		result = prime * result + ((results == null) ? 0 : results.hashCode());
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
		ResponseAPI other = (ResponseAPI) obj;
		if (response_code != other.response_code)
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		return true;
	}

}
