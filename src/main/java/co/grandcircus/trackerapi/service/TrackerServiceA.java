package co.grandcircus.trackerapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.grandcircus.trackerapi.model.CountPair;

@Service
public class TrackerServiceA implements TrackerService{

	@Override
	public void add(String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getTokenExists(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTokenCount(String token) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLatest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountPair getTop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getLatest5() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountPair> getTop5() {
		// TODO Auto-generated method stub
		return null;
	}

}
