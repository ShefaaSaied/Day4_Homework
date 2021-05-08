import java.util.List;

public class TestWuzzufJobs {

      public static void test(){

        ReadCSV jobs_read = new ReadCSV();
        List<JobDetails> jobs = jobs_read.readJobsFromCSV("Wuzzuf_Jobs.csv");
        JobsDataService jobs_services = new JobsDataService();

        System.out.println("Job list:");
        for(int i=0; i<jobs.size();i++)
        {
            System.out.println(jobs.get(i));
        }
        System.out.println("");
        System.out.println("Job titles and Popularity:");
        System.out.println(jobs_services.FilterJobsByTitle(jobs));
        System.out.println("");

        System.out.println("Countries and Job demand:");
        System.out.println(jobs_services.FilterJobsByCountry(jobs));
        System.out.println("");

        System.out.println("Job levels and its popularity:");
        System.out.println(jobs_services.FilterJobsByLevel(jobs));
        System.out.println("");

        System.out.println("Sorted years of exp and its popularity:");
        System.out.println(jobs_services.FilterJobsByExp(jobs));

    }

    public static void main(String[] args) {
          // Invoking tet test() method
          test();
    }
}