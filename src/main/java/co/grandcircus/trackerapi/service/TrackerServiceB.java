package co.grandcircus.trackerapi.service;

import org.springframework.stereotype.Service;

@Service
public class TrackerServiceB implements TrackerService {
	@Override
	public void add(String token) {
/* 
		for (CountPair tokeen : tokens) {
			if (tokeen.getToken().equals(token)) {
				tokeen.setCount(tokeen.getCount() + 1);
				return;
			}
		}
		CountPair newToken = new CountPair(token, 1);
		tokens.add(newToken);
*/
	}
}
