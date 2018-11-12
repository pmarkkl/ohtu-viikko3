
package ohtu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private Map<String, List<Submission>> courses;
    
    public Student() {
        courses = new LinkedHashMap<>();
    }
    
    public void addSubmission(Submission submission) {
        List<Submission> subs = courses.get(submission.getCourse());
         if (subs == null) {
            subs = new ArrayList<Submission>();
            courses.put(submission.getCourse(), subs);
         }
         subs.add(submission);
    }
    
    public Map<String, List<Submission>> getSubmissions() {
        return courses;
    }
}
