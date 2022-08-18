package co.grandcircus.trackerapi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import co.grandcircus.trackerapi.model.CountPair;

@Service
public class TrackerServiceA implements TrackerService {

	private List<CountPair> tokens;

	@Override
	public void add(String token) {

		for (CountPair tokeen : tokens) {
			if (tokeen.getToken().equals(token)) {
				tokeen.setCount(tokeen.getCount() + 1);
				return;
			}
		}
		CountPair newToken = new CountPair(token, 1);
		tokens.add(newToken);

	}

	@Override
	public void reset() {

		tokens.removeAll(tokens);

	}

	@Override
	public int getTotalCount() {
		int totalCounts = 0;
		for (CountPair token : tokens) {
			totalCounts += token.getCount();
		}
		return totalCounts;
	}

	@Override
	public boolean getTokenExists(String token) {
		for (CountPair tokeen : tokens) {
			if (tokeen.getToken().equals(token)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getTokenCount(String token) {
		for (CountPair tokeen : tokens) {
			if (tokeen.getToken().equals(token)) {
				return tokeen.getCount();
			}
		}
		return 0;
	}

	@Override
	public String getLatest() {

		String latestToken = tokens.get(tokens.size() - 1).getToken();
		return latestToken;
	}

	@Override
	public CountPair getTop() {
		if (tokens.size() == 0) {
			return new CountPair("", 0);
		}
		CountPair topToken = tokens.get(0);
		for (CountPair tokeen : tokens) {
			if (tokeen.getCount() > topToken.getCount()) {
				topToken = tokeen;
			}
		}

		return topToken;
	}

	@Override
	public List<String> getLatest5() {
		List<String> latestFiveTokens = new ArrayList<>();
		String token;
		if (tokens.size() > 5) {
			for (int i = tokens.size() - 1; i >= tokens.size() - 5; i--) {
				token = tokens.get(i).getToken();
				latestFiveTokens.add(token);
			}
		} else {
			for (int i = tokens.size() - 1; i >= 0; i--) {
				token = tokens.get(i).getToken();
				latestFiveTokens.add(token);
			}
		}

		return latestFiveTokens;
	}

	public static Comparator<CountPair> topFiveSorted = new Comparator<CountPair>() {
		public int compare(CountPair a, CountPair b) {
			int countA = a.getCount();
			int countB = b.getCount();
			return countB-countA;
		}
	};
	
	@Override
	public List<CountPair> getTop5() {
		
		List<CountPair> topFiveTokens = new ArrayList<>();
		Collections.sort(tokens, topFiveSorted);
		if (tokens.size() > 5) {
			for (int i = 0; i < 5; i++) {
				CountPair token = tokens.get(i);
				topFiveTokens.add(token);
			}
		} else {
			for (int i = 0; i < tokens.size(); i++) {
				CountPair token = tokens.get(i);
				topFiveTokens.add(token);
			}
		}
		return topFiveTokens;
	}

}
