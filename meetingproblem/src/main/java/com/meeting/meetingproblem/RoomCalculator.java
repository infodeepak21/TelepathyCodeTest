package com.meeting.meetingproblem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RoomCalculator {

	public List<Room> getRooms(List<Meeting> meetings) {
		sortMeetings(meetings);
		List<Room> rooms = new CopyOnWriteArrayList<>();
		for (Meeting meeting : meetings) {
			if (rooms.isEmpty()) {
				rooms.add(createRoom(meeting));
				continue;
			}

			checkRoomAvailableAndAssign(rooms, meeting);
		}

		return rooms;
	}

	public void sortMeetings(List<Meeting> meetings) {
		Comparator<Meeting> meetingComparator = (m1, m2) -> {
			float compare = Float.compare(m1.getStartTime(), m2.getStartTime());
			if (compare == 0.0) {
				compare = Float.compare(m1.getEndTime(), m2.getEndTime());
			}
			return (int) compare * 10;
		};
		Collections.sort(meetings, meetingComparator);
	}

	public void checkRoomAvailableAndAssign(List<Room> rooms, Meeting meeting) {
		boolean isRoomAvailable = false;
		for (Room room : rooms) {
			boolean isMeetingConflicts = false;
			for (Meeting roomMeeting : room.getMeeting()) {
				
				if (meeting.getStartTime() >= roomMeeting.getStartTime()
						&& meeting.getStartTime() < roomMeeting.getEndTime()) {
//					System.out.println("Room is Accoupied");
					isMeetingConflicts = true;
				}
			}
			if(!isMeetingConflicts) {
				room.getMeeting().add(meeting);
				isRoomAvailable = true;
			}
			if (isRoomAvailable)
				break;
		}
		if (!isRoomAvailable) {
			rooms.add(createRoom(meeting));
		}
	}

	public Room createRoom(Meeting meeting) {
		Room room = new Room();
		List<Meeting> roomMeetings = new CopyOnWriteArrayList<>();
		roomMeetings.add(meeting);
		room.setMeeting(roomMeetings);
		return room;
	}

}
