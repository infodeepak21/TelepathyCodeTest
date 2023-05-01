package com.meeting.meetingproblem;

import java.util.List;

public class Room {
	List<Meeting> meeting;

	public List<Meeting> getMeeting() {
		return meeting;
	}

	public void setMeeting(List<Meeting> meeting) {
		this.meeting = meeting;
	}

	@Override
	public String toString() {
		return "Room [meeting=" + meeting + "]";
	}
	
}
