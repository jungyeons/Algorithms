import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main1302 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr[] = new String[n];


        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }

        });
        String bestSeller = arr[0];
        int maxCount = 1;
        int currentCount = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i].equals(arr[i-1])){
                currentCount++;
            }else {
                currentCount = 1;
            }if(currentCount> maxCount){
                maxCount = currentCount;
                bestSeller = arr[i];
            }
        }
   System.out.println(bestSeller);
}}
