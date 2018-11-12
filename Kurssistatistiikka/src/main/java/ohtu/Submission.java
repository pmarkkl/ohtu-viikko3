package ohtu;

import java.util.List;

public class Submission {
    private int week, hours;
    private String course;
    private List<Integer> exercises;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }
    
    public void setHours(int hours) {
        this.hours = hours;
    }
    
    public int getHours() {
        return hours;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public String getCourse() {
        return course;
    }
    
    public void setExercises(List exercises) {
        this.exercises = exercises;
    }
    
    public List<Integer> getExercises() {
        return exercises;
    }
    
    public int getNumberOfExercises() {
        return exercises.size();
    }

    @Override
    public String toString() {
        return "  " + course + ", viikko " + week + " tehtyjä tehtäviä yhteensä " + exercises.size() + 
                " aikaa kului " + hours + " tehdyt tehtävät: " + exercises.toString();
    }
    
}