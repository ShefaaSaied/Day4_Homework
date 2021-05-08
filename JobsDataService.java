import java.security.KeyStore;
import java.util.*;

public class JobsDataService {
    // FilterJobsByTitle method
    public List<JobDetails> FilterJobsByTitle(List<JobDetails> jobsFile) {
        List<String> List_of_titles = new ArrayList<>();

        for (int i = 0; i < jobsFile.size(); i++) {
            List_of_titles.add((jobsFile.get(i).getTitle()));
        }
        //Calling frequency method to get the popularity of each job title
        List<String> titleFreq= frequency(List_of_titles);
        //Displays the frequency of each job title
        for (int q = 0; q < titleFreq.size(); q++) {
            System.out.println(List_of_titles.get(q) + " --> " + titleFreq.get(q));
        }
        return null;
    }

    // FilterJobsByCountry method
    public List<JobDetails> FilterJobsByCountry(List<JobDetails> jobsFile) {
        List<String> List_of_countries = new ArrayList<>();
        //Map<String, List<String>> map = new TreeMap<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < jobsFile.size(); i++) {
            List_of_countries.add((jobsFile.get(i).getCountry()));
        }
        //Calling frequency method to get the job demand in each country
        List<String> jobDemand = frequency(List_of_countries);

        for (int q = 0; q < List_of_countries.size(); q++) {
            boolean isKeyExist = map.containsKey(List_of_countries.get(q));
            // Checking if the key already exists in the Map
            if (isKeyExist == true) {
                map.get(List_of_countries.get(q)).add(jobDemand.get(q));
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(jobDemand.get(q));
                map.put(List_of_countries.get(q), newList);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = Collections.singletonList(entry.getValue().get(0));
            for (String val:value){
                System.out.println(key + " : " + val);
            }
        }
        return null;
    }

    // FilterJobsByLevel method
    public List<JobDetails> FilterJobsByLevel(List<JobDetails> jobsFile) {
        List<String> List_of_levels = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        //Map<String, List<String>> map = new TreeMap<>();

        for (int i = 0; i < jobsFile.size(); i++) {
            List_of_levels.add((jobsFile.get(i).getLevel()));
        }
        //Calling frequency method to get the job demand in each country
        List<String> jobDemand = frequency(List_of_levels);

        for (int q = 0; q < List_of_levels.size(); q++) {
            boolean isKeyExist = map.containsKey(List_of_levels.get(q));
            // Checking if the key already exists in the Map
            if (isKeyExist == true) {
                map.get(List_of_levels.get(q)).add(jobDemand.get(q));
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(jobDemand.get(q));
                map.put(List_of_levels.get(q), newList);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = Collections.singletonList(entry.getValue().get(0));
            for (String val:value){
                System.out.println(key + " : " + val);
            }
        }
        return null;
    }

    // FilterJobsByExp method
    public List<JobDetails> FilterJobsByExp(List<JobDetails> jobsFile) {
        List<String> years_of_exp = new ArrayList<>();
        //HashMap<String, List<String>> hashmap = new HashMap<>();
        Map<String, List<String>> map = new TreeMap<>();

        for (int i = 0; i < jobsFile.size(); i++) {
            years_of_exp.add((jobsFile.get(i).getExp()));
        }
        //Calling frequency method to get the job demand in each country
        List<String> jobDemand = frequency(years_of_exp );

        for (int q = 0; q < years_of_exp.size(); q++) {
            boolean isKeyExist = map.containsKey(years_of_exp.get(q));
            // Checking if the key already exists in the Map
            if (isKeyExist == true) {
                map.get(years_of_exp.get(q)).add(jobDemand.get(q));
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(jobDemand.get(q));
                map.put(years_of_exp.get(q), newList);
            }
        }

        // Calling sortedmap fn
        LinkedHashMap<String, List<String>> sorted_map= sortMap(map);

        for (Map.Entry<String, List<String>> entry : sorted_map.entrySet()) {
            String key = entry.getKey();
            List<String> value = Collections.singletonList(entry.getValue().get(0));
            for (String val:value){
                System.out.println(key + " : " + val);
            }
        }
        return null;
    }

    // Sorted map fn
    public LinkedHashMap<String, List<String>> sortMap(Map<String, List<String>> map) {
        LinkedHashMap<String, List<String>> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    // Get frequency of other methods
    public List<String> frequency(List<String> list) {
        List<String> freq = new ArrayList<>();
        boolean visited[] = new boolean[list.size()];
        Arrays.fill(visited, false);

        for (int j = 0; j < list.size(); j++) {
            // Skip this element if already processed
            if (visited[j] == true) {
                continue;
            }

            int count = 1;
            for (int z = j + 1; z < list.size(); z++) {
                if (list.get(j).equals(list.get(z))) {
                    count++;
                }
            }
            freq.add(Integer.toString(count));
        }
        return freq;
    }
}