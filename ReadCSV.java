import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    public ReadCSV() { }

    public List<JobDetails> readJobsFromCSV(String fileName) {
        List<JobDetails> Jobs = new ArrayList<>();
        // create an instance of BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // read the first line from the text file which will be head column
            String line = br.readLine();
            // read first line
            if (line != null) {
                line = br.readLine(); // the first real data
            }
            while (line != null) {
                String[] attributes = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // to handle columns that have commas

                JobDetails job=createJob(attributes);

                // adding the job into ArrayList
                Jobs.add(job);
                // read next line before looping
                line = br.readLine();
                // if end of file reached, line would be null
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return Jobs;
    }

    public JobDetails createJob(String[] metadata) {
        String title = metadata[0];
        String company = metadata[1];
        String location = metadata[2];
        String type = metadata[3];
        String level = metadata[4];
        String exp = metadata[5];
        String country = metadata[6];
        String skills = metadata[7];

        return new JobDetails(title, company, location, type, level,exp,country,skills);
    }
}
