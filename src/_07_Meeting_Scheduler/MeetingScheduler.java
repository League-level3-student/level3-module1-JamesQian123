package _07_Meeting_Scheduler;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class MeetingScheduler {
    /*
     * Your task is to code a method to find a meeting time for two people
     * given their schedules.
     * 
     * Code the method below so that it returns a Schedule object that contains
     * all the times during the week that are in BOTH people's schedules. The
     * Schedule class is included in this package.
     * 
     * Example:
     * person1 availability - Monday at 9, Tuesday at 14, and Friday 10
     * person2 availability - Tuesday at 14, Friday 8, and Monday at 9
     * The returned HashMap should contain: Tuesday 14 and Monday 9
     * 
     * The returned Schedule object represents the times both people are
     * available for a meeting.
     * 
     * Time availability is always at the top of the hour, so 9:30 is not valid
     * Time availability always represents 1 hour
     * Assume both schedules are in the same time zones
     */
    public static Schedule getMutualAvailability(Schedule person1, Schedule person2) {
    	int time = 0;
        Schedule available = new Schedule();
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        HashMap<String, ArrayList<Integer>> person1schedule = person1.getSchedule();
        HashMap<String, ArrayList<Integer>> person2schedule = person2.getSchedule();
;        for(int i = 0; i < days.size(); i++) {
        	ArrayList<Integer> times = person1schedule.get(days.get(i));
        	ArrayList<Integer> tmes = person2schedule.get(days.get(i));
        	for(int j = 0; j<times.size(); j++) {
        		if(tmes.contains(times.get(j))) {
        			available.addAvailability(days.get(i), times.get(j));
        		}
        	}
//        		if(person1schedule.get(days.get(i)) == person2schedule.get(days.get(i))) {
//        			time = person1schedule.get(days.get(i));
//        			available.addAvailability(days.get(i),);
//        		}
        		
        	}
        
        
    
		return available;
    }
}
