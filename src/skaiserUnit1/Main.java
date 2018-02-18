package skaiserUnit1;
/**
 * @author Sam Kaiser
 *
 * Directions:
 * Create a program that reads the files: places.csv and stuff.csv.
 * The places file is the driver and the stuff file is the
 * transaction file. There are numerous ways to solve the
 * following problem.
 *
 * The program must include JavaDoc, Junit and be uploaded to GitHub.
 * Create a report that prints out each country and the number
 * of cities listed in the places file and the number
 * of stuff listed in the stuff file.
 *
 * Upload compressed file with JavaDoc output.
 *
 ***************************************************************************
 *
 * Here I go.
 */
public class Main {

    /**
     * First I have to grab the files by
     * creating two new instantiations of
     * the FileInput class.
     *
     */
    private final static FileInput placesFile = new FileInput("placesSorted.csv");
    private final static FileInput stuffFile = new FileInput("stuff.csv");

    public static void main(String[] args) {


        /**
         * Defining a few base variables for
         * each line of data, an array to hold
         * each string of data, and an array to
         * hold the count of places and "stuff"
         */

        String line;
        String[] fields;
        int[] counter = new int[2];

        /**
         * Creating header for report.
         */

        System.out.format("%-22s %-7s %-6s\n", "Country", "Cities", "Stuff");
        System.out.format("%-22s %-7s %-6s\n", "=======", "======", "=====");

        /**
         * Spitting out the data.
         */

       while((line = placesFile.fileReadLine()) != null){

            fields = line.split(",");
            countCities(fields[0], counter);
            findStuff(fields[0], counter);
            System.out.format("%-22s %-7s %-6s\n", fields[0], counter[0], counter[1]);
        }
        //placesFile.fileRead();
    }

    public static void findCities(String country, int[] counter){
        counter[0] = 0;
        String line;
        String[] fields;
        boolean done = false;

        while(((line = placesFile.fileReadLine()) != null) && !(done)){
            fields = line.split(",");

            /**
             *
             * The following conditional tests to see if the string length of the next
             * country has changed.  It checks to see whether or not the new Country is
             * longer or shorter than the previous run Country.
             *
             * This has allowed me to only print the name of each country one time.
             *
             */
            if((fields[0].compareTo(country) > 0)) {
                done = true;
            }else if((fields[0].compareTo(country) < 0)){
                done = true;}
            else{
                counter[0]++;
            }

            }

        }

    public static void findStuff(String country, int[] counter) {

        String line;
        String[] fields;
        boolean done = false;
        counter[1] = 0;



        while(((line = stuffFile.fileReadLine()) != null) && !(done)){
            fields = line.split(",");

            /*if((fields[0].compareTo(country) > 0) || (fields[0].compareTo(country) < 0)) {
                done = true;
            }else{
                counter[1]++;
            }
*/
        }

        }


    public static void counter(String country, int[] counter){
        String line="";
        String[] fields;
        counter[0] = 0;
        counter[1] = 0;

        boolean done = false;

        while(((line = stuffFile.fileReadLine()) != null) && !(done)){
            fields = country.split(",");

            if((fields[0].compareTo(country) > 0) || (fields[0].compareTo(country) < 0)) {
                done = true;
            }else{
                counter[1]++;
            }
            //while()
        }
    }


    public static void countCities(String country, int[] counter) {
        counter[0] = 0;
        counter[1] = 0;
        String line;
        String[] fields;
        boolean done = false;

        while (((line = placesFile.fileReadLine()) != null) && !(done)) {
            fields = line.split(",");
            if (fields[0].compareTo(country) > 0) {
                done = true;
            }
            else if (fields[0].equals(country)) {
                counter[0]++;
                //counter[1] += Integer.parseInt(fields[2]);
            }

        }
    }}