import java.util.Scanner;

public class MyList {
    public static void main(String[] args) {
        if(args.length == 0){
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
        System.out.println(returnValue);
    }

    public static int binSearch(int[] aList, int key){
        int min = 0;
        int max = aList.length - 1;
        while(max >= min){
            int avg = (min + max)/2;
            if(key == aList[avg]){
                return 1;
            }
            else if(key > aList[avg]){
                min = avg + 1;
            }
            else if(key < aList[avg]){
                max = avg - 1;
            }
        }
        return 0;
    }
}
