import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.net.HttpURLConnection;

public class Lab3P1 {

    public static void main (String [] args) throws IOException {
        System.out.println("Please enter a Website address and the keyword to search.");
        ArrayList<String> readURLs = new ArrayList<String>();
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
            readURLs = subURLGenerate(keyword, website);
            //System.out.println("Content from " + website + ":\n");
            //System.out.println(contentx);

            // If the site contains the keyword, find the URLs
            //boolean isFound = contentx.contains(keyword);
            //int siteIndex = contentx.indexOf("http"); // Getting the Index.

            // Looking for the indexOf the first quotation mark after the http
            //int quotationMarkIndex = contentx.indexOf('\"', siteIndex);

            // Getting the substring.
            // site = contentx.substring(siteIndex, quotationMarkIndex);

            //String siteContent = Arrays.toString(site.trim().split("\"", 3));
            //System.out.println("\r\n siteContent:" + site);

            // Adding it to the pending ArrayList
            //pending.add(site);

            //System.out.println("\r\n Keyword found: " + isFound + "\r\n site: " + pending.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("\n Pending ArrayList: " + pending.toString());
        ArrayList<String> visitedUrls = new ArrayList<>();
        int urlCount = 0;
        boolean visited = false;

            //String read = " ";
        // Read each URL in ArrayList
            for (String read : readURLs ) {

                // Check if it exists in traversed ArrayList
                if (!traversed.contains(read)) {
                    // if not in list, add in pending ArrayList
                    pending.add(read);
                }

                int traversedSize = traversed.size();
                // Once done, check if traversed list count is 100
                System.out.println("Traversed list size: " + traversedSize);
                if (traversedSize >= 100) {
                    // else, return the ArrayList with the subURL lists
                }
                else {
                    // if not, remove URL from the 0th index of pending list and add to traversed list
                    // pass this URL to search term to the subURLGenerate function
                    String urlString = pending.remove(0);
                    traversed.add(urlString);
                    subURLGenerate(urlString, read);

                    // if found, print that it was found on this URL
                }
                // repeat
            }

    }

    public static ArrayList<String> subURLGenerate(String keyword, String url) throws IOException {
        //StringBuilder content = new StringBuilder();
        ArrayList<String> traversed = new ArrayList<String>();
        ArrayList<String> pending = new ArrayList<String>();
        //String content = " ";
        boolean isFound = false;

        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setRequestMethod("GET");

        try (Scanner scanner = new Scanner(connection.getInputStream())) {
            // Scan each line on the webpage
            while (scanner.hasNextLine()) {
                String content = scanner.nextLine();
                String site = " ";

                //System.out.println("\n Scanner line: " + content);

                // Search for the string
                isFound = content.contains(keyword);

                // If found, print that line
                if (isFound) {
                    System.out.println(keyword + "found on " + url + "\n line: " + content + "\r\n");
                }
                else {
                    System.out.println(keyword + " not found!");

                    int siteIndex = 0;
                    int unsecureSiteIndex = 0;
                    int secureSiteIndex = 0;
                    // search for the URL in that line
                    unsecureSiteIndex = content.indexOf("http://");

                    // search for the URL in that line
                    secureSiteIndex = content.indexOf("https://");

                    if (unsecureSiteIndex == secureSiteIndex) {

                        siteIndex = secureSiteIndex;
                        System.out.println("\n Test1");
                        if (siteIndex == 0) continue;
                        // Looking for the indexOf the first quotation mark after the http
                        int whiteSpaceIndex = content.indexOf("\\s+", siteIndex);

                        System.out.println("\n" + site);
                        if (whiteSpaceIndex == 0) continue;

                        // Getting the substring
                        site = content.substring(siteIndex, whiteSpaceIndex);
                    }
                    else if (unsecureSiteIndex < secureSiteIndex) {
                        siteIndex = secureSiteIndex;
                        System.out.println("\n Test2");
                        if (siteIndex == 0) continue;

                        // Looking for the indexOf the first quotation mark after the http
                        int quotationMarkIndex = content.indexOf('\"', siteIndex);

                        // Getting the substring
                        site = content.substring(siteIndex, quotationMarkIndex);
                    }
                    else {
                        siteIndex = unsecureSiteIndex;
                        System.out.println("\n Test3");
                        if (siteIndex == 0) continue;
                        // Looking for the indexOf the first quotation mark after the http
                        int quotationMarkIndex = content.indexOf('\"', siteIndex);

                        // Getting the substring
                        site = content.substring(siteIndex, quotationMarkIndex);
                    }

                    // Adding it to the pending ArrayList
                    pending.add(site);
                    break;

                    //System.out.println("\r\n Keyword found: " + isFound + "\r\n site: " + pending.get(0));

                    // save the URL to the ArrayList
                    // Scan the next line
                    // repeat until finished traversing the website
                    // return to main
                }
            }
            // Continuing to look for sites to add to ArrayList pending when no more keywords are left on webpage
            while (scanner.hasNextLine()) {
                String content = scanner.nextLine();
                String site = " ";
                //System.out.println("\n Scanner line: " + content);

                // search for the URL in that line
                int siteIndex = content.indexOf("http");

                if (siteIndex < 0)  continue;

                // Looking for the indexOf the first quotation mark after the http
                int quotationMarkIndex = content.indexOf('\"', siteIndex);

                if (quotationMarkIndex < 0) {
                    site = content.substring(siteIndex);
                }
                else {
                    // Getting the substring
                    site = content.substring(siteIndex, quotationMarkIndex);
                }
                //String siteContent = Arrays.toString(site.trim().split("\"", 3));
                //++++++++++++System.out.println("\r\n siteContent:" + site);

                // Adding it to the pending ArrayList
                pending.add(site);
            }

            scanner.close();
        }

        connection.disconnect();

        return pending;
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

//    public ArrayList<String> subURLGenerate(String keyword, String url) {
//        ArrayList<String> traversed = new ArrayList<String>();
//
//        return traversed;
//    }

}
