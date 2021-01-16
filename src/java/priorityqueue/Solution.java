package java.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */


class Student implements Comparable<Student>{

    Integer id;
    String name;
    Double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student o) {

        if (o == null) return 1;

        if (!this.getCgpa().equals(o.getCgpa())) {
            return o.getCgpa().compareTo(this.getCgpa());
        } else if (!this.getName().equals(o.getName())) {
            return this.getName().compareTo(o.getName());
        } else {
            return  o.getId().compareTo(this.getId());
        }
    }
}

class Priorities {

    PriorityQueue<Student> priorityQueue = new PriorityQueue<>();

    List<Student> getStudents(List<String> events) {

        for (String event : events) {
            String[] eventParts = event.split(" ");
            if("ENTER".equals( eventParts[0])) {
                priorityQueue.add(new Student(Integer.parseInt(eventParts[3]),
                        eventParts[1],
                        Double.parseDouble(eventParts[2])));
            } else if (("SERVED").equals( eventParts[0])) {
                priorityQueue.poll();
            }
        }

        List<Student> remainingStudents = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            remainingStudents.add(priorityQueue.poll());
        }
        return remainingStudents;
    }

}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}