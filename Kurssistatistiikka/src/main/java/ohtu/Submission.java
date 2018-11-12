package ohtu;

import java.util.List;

public class Submission {
    private int week, hours, numberOfExercises;
    private String course, fullName;
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
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setNumberOfExercises(int numberOfExercises) {
        this.numberOfExercises = numberOfExercises;
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
    
    private int getNumberOfExercisesAvailable() {
        return numberOfExercises;
    }

    @Override
    public String toString() {
        return "viikko " + week + ":\n  tehtyjä tehtäviä " + exercises.size() + "/" + getNumberOfExercisesAvailable() +
                " aikaa kului " + hours + " tehdyt tehtävät: " + exercises.toString() + "\n";
    }
    
}