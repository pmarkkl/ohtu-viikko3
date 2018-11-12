package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String studentUrl = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";
        String coursesUrl = "https://studies.cs.helsinki.fi/courses/courseinfo";

        String bodyText = Request.Get(studentUrl).execute().returnContent().asString();
        String coursesText = Request.Get(coursesUrl).execute().returnContent().asString();
        
        Gson studentMapper = new Gson();
        Submission[] subs = studentMapper.fromJson(bodyText, Submission[].class);
        
        Gson coursesMapper = new Gson();
        Course[] courses = coursesMapper.fromJson(coursesText, Course[].class);
        
        for (Course course : courses) {
            List<Integer> numberOf = course.getExercises();
            for (Submission submission : subs) {
                if (course.getName().equals(submission.getCourse())) {
                    course.addSubmission(submission);
                    submission.setNumberOfExercises(numberOf.get(submission.getWeek()));
                }
            }
        }
        
        // stats
        
        JsonParser parser = new JsonParser();
        for (Course course : courses) {
            if (course.getNumberOfSubmissions() > 0) {
                int totalHours = 0;
                int totalExercises = 0;
                int totalStudents = 0;
                String courseShortName = course.getName();
                String statsResponse = Request.Get("https://studies.cs.helsinki.fi/courses/"+courseShortName+"/stats").execute().returnContent().asString();
                JsonObject parsittuData = parser.parse(statsResponse).getAsJsonObject();
                for (int i = 1; i <= parsittuData.size(); i++) {
                    totalHours += parsittuData.get(Integer.toString(i)).getAsJsonObject().get("hour_total").getAsInt();
                    totalExercises += parsittuData.get(Integer.toString(i)).getAsJsonObject().get("exercise_total").getAsInt();
                    totalStudents += parsittuData.get(Integer.toString(i)).getAsJsonObject().get("students").getAsInt();
                }
                course.setHoursTotal(totalHours);
                course.setExerciseTotal(totalExercises);
                course.setStudentsTotal(totalStudents);
            }
        }
        
        System.out.println("opiskelijanumero " + studentNr + "\n");
        
        for (Course course : courses) {
            if (course.getNumberOfSubmissions() > 0) {
                System.out.println(course);
            }
        }
                
    }
}