
package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Course {
    
    private int year;
    private String name, term, fullName;
    private List<Integer> exercises;
    private List<Submission> submissions;
    
    public int getYear() {
        return year;
    }
    
    public String getTerm() {
        return term;
    }
    
    public String getName() {
        return name;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public List<Integer> getExercises() {
        return exercises;
    }
    
    public int getNumberOfExercises() {
        return exercises.size();
    }
    
    public int getNumberOfSubmissions() {
        if (submissions == null) return 0;
        return submissions.size();
    }
    
    public void addSubmission(Submission submission) {
        if (submissions == null) {
            submissions = new ArrayList<>();
        }
        submissions.add(submission);
    }
    
    public List<Submission> getSubmissions() {
        return submissions;
    }
    
    private int getHours() {
        int hours = 0;
        hours = submissions.stream().map((submission) -> submission.getHours()).reduce(hours, Integer::sum);
        return hours;
    }
    
    
    private int getExercisesDone() {
        int execs = 0;
        execs = submissions.stream().map((submission) -> submission.getNumberOfExercises()).reduce(execs, Integer::sum);
        return execs;
    }
    
    private String stringBuilder(List<Submission> submissions) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < submissions.size(); i++) {
            stringBuilder.append(submissions.get(i));
        }
        return stringBuilder.toString();
    }
    
    @Override
    public String toString() {
        return fullName + " " + term + " " + year + " \n\n" + stringBuilder(submissions) + "\nyhteensä " + getExercisesDone() + "/" + exercises.stream().mapToInt(Integer::intValue).sum() + 
                " tehtävää " + getHours() + " tuntia\n";
    }
}
