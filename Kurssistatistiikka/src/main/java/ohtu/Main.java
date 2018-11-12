package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        int exercises = 0;
        int hours = 0;
        System.out.println("opiskelijanumero " + studentNr + "\n");
        for (Submission submission : subs) {
            hours += submission.getHours();
            exercises += submission.getNumberOfExercises();
            System.out.println(submission);
        }
        System.out.println("\nyhteensä: " + exercises + " tehtävää " + hours + " tuntia");
    }
}