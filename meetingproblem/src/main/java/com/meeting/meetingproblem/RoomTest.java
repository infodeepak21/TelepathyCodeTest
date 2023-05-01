package com.meeting.meetingproblem;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 *java -cp target\meetingproblem-0.0.1-SNAPSHOT.jar com.meeting.meetingproblem.RoomTest "Fully Qualified path for example-meeting.txt"
 *
 */
public class RoomTest {
	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader(new File(args[0]));
		try (Scanner scanner = new Scanner(fileReader)) {
			List<Meeting> meetings = new ArrayList<>();
			List<Room> rooms = null;
			while (scanner.hasNextLine()) {
				meetings.add(getMeeting(scanner.nextLine()));
			}
			RoomCalculator calculator = new RoomCalculator();
			rooms = calculator.getRooms(meetings);
			System.out.println("Total Meeting room required: "+ rooms.size());
		}
	}

	public static Meeting getMeeting(String line) {
		Meeting meeting = new Meeting();
		String[] times = line.split("-");
		String[] startTime = times[0].split(":");
		String[] endTime = times[1].split(":");

		meeting.setStartTime(
				Float.parseFloat("" + Integer.parseInt(startTime[0]) + "." + Integer.parseInt(startTime[1])));
		meeting.setEndTime(Float.parseFloat("" + Integer.parseInt(endTime[0]) + "." + Integer.parseInt(endTime[1])));
		return meeting;
	}
}
