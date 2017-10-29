import java.util.Scanner;
import org.apache.commons.cli.*;

public class Main implements Comparable{
    public static void main(String[] args) {
        Main main = new Main();
        int returnValue = -1;
        Options options = new Options();
        Option typeOption = Option.builder("t").longOpt("type").hasArg().numberOfArgs(1).required(true).build();
        options.addOption(typeOption);
        Option keyOption = Option.builder("k").longOpt("key").hasArg().numberOfArgs(1).required(true).build();
        options.addOption(keyOption);
        Option listOption = Option.builder("l").longOpt("list").hasArg().numberOfArgs(Option.UNLIMITED_VALUES).valueSeparator(' ').required(true).build();
        options.addOption(listOption);
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(0);
            return;
        }

        String type = cmd.getOptionValue("type");
        String[] stringList = cmd.getOptionValues("list");
        if (type.equals("i")){
            Integer[] alist = new Integer[stringList.length];
            int intkey = Integer.parseInt(cmd.getOptionValue("key"));
            for(int i=0; i< stringList.length; i++){
                int value = Integer.parseInt(stringList[i]);
                alist[i] = value;
            }
             returnValue = main.binSearch(alist, intkey);

        }
        else if (type.equals("s")){
            String stringkey =cmd.getOptionValue("key");
            returnValue = main.binSearch(stringList, stringkey);
        }
        else {
            System.out.println("argument not supported");
            System.exit(1);

        }




        /*if(args.length == 0){
            System.out.println("Error!!!! List can't be empty!!");
            System.exit(0);
        }
        Scanner readInput = new Scanner(System.in);
        int[] aList = new int[args.length];
        for(int i=0; i< args.length; i++){
            int value = Integer.parseInt(args[i]);
            aList[i] = value;
        }
        //int[] aList = numberList.stream().mapToInt(i -> i).toArray();
        int key = readInput.nextInt();
        int returnValue = binSearch(aList, key);
        */

        System.out.println(returnValue);
    }

    protected int binSearch(Comparable[] aList, Comparable key){
        int min = 0;
        int max = aList.length - 1;
        while(max >= min){
            int avg = (min + max)/2;
            if(aList[avg].compareTo(key) == 0){
                return 1;
            }
            else if(aList[avg].compareTo(key) < 0){
                min = avg + 1;
            }
            else if(aList[avg].compareTo(key) > 0){
                max = avg - 1;
            }
        }
        return 0;
    }

    public int compareTo(Object o) {
        return 0;
    }
}
