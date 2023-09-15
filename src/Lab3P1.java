
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.net.HttpURLConnection;


public class Lab3P1 {

    public static void main (String [] args){
        System.out.println("Please enter a Website address and the keyword to search.");
        ArrayList<String> traversed = new ArrayList<String>();
        ArrayList<String> pending = new ArrayList<String>();


        Scanner input = new Scanner(System.in);
        String website = input.next();
        String keyword = input.next();

        System.out.println("Website addr you have entered: " +  website);
        System.out.println("Keyword you entered: " + keyword);

        String contentx = " ";

        // Traversing a site.
        try {
            contentx = fetchWebPage(website);
            //System.out.println("Content from " + website + ":\n");
            //System.out.println(contentx);

            // If the site contains the keyword, find the URLs
            boolean isFound = contentx.contains(keyword);
            int siteIndex = contentx.indexOf("http"); // Getting the Index.

            // Looking for the indexOf the first quotation mark after the http
            int quotationMarkIndex = contentx.indexOf('\"', siteIndex);

            // Getting the substring.
            String site = contentx.substring(siteIndex, quotationMarkIndex);

            //String siteContent = Arrays.toString(site.trim().split("\"", 3));
            System.out.println("\r\n siteContent:" + site);

            // Adding it to the pending ArrayList
            pending.add(site);

            System.out.println("\r\n Keyword found: " + isFound + "\r\n site: " + pending.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> visitedUrls = new ArrayList<>();
        int urlCount = 0;
        boolean visited = false;

        // Check for URLs.
        for (urlCount= 0 ; urlCount > 100 ; urlCount ++){
            boolean isUrl = contentx.contains("http");
            System.out.println("100 links visited. ");

            // Use substring to extract URLs.

        // Read each URL in ArrayList
            // Check if it exists in traversed ArrayList
            // if not in list, add in pending ArrayList
            // Once done, check if traversed list count is 100
            // if not, remove URL from the 0th index of pending list and add to traversed list
            // pass this URL to search term to the subURLGenerate function
            // if found, print that it was found on this URL
            // else, return the ArrayList with the subURL lists
                // repeat
        }
    }

    public static String fetchWebPage(String url) throws IOException {
        StringBuilder content = new StringBuilder();

        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setRequestMethod("GET");

        try (Scanner scanner = new Scanner(connection.getInputStream())) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
            //scanner.close();
        }
        connection.disconnect();

        return content.toString();
    }
//    public static String fetchWebPage(String url) throws IOException {
//        StringBuilder content = new StringBuilder();
//
//        URL urlObj = new URL(url);
//        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
//        connection.setRequestMethod("GET");
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//        String line;
//        while ((line = reader.readLine()) != null) {
//            content.append(line).append("\n");
//        }
//
//        reader.close();
//        connection.disconnect();
//
//        return content.toString();
//    }

    public ArrayList<String> subURLGenerate(String keyword, String url) {
        ArrayList<String> traversed = new ArrayList<String>();
        boolean isFound = false;

        //Scan each line on the webpage
        // Search for the string

        // if not found
        if (!isFound) {
            // search for the URL in that line
            // save the URL to the ArrayList
            // Scan the next line
            // repeat until finished traversing the website
            // return to main
        }
        else {
            // print the line with the keyword
        }

        return traversed;
    }

}
