package JavaProblems.Soal3;

import java.util.Arrays;
import java.util.Collections;

public class ProblemThree {
    public static void main(String[] args) {
        int arr[] = {12,4,3,1,9,657};
        int n = 3;

        int ans = Arrays.stream(arr)
        .boxed()
        .sorted(Collections.reverseOrder())
        .skip(n-1)
        .findFirst()
        .orElse(0);

        System.out.println("Elemen terbesar ke-3 adalah: " + ans);      
    }
}
