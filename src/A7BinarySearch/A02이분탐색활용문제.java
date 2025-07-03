package A7BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A02이분탐색활용문제 {

    // 예산 : 백준
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0, end = arr.length - 1;
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            long total = 0;
            for (int i = start; i <= mid; i++) {
                if (arr[i] > mid)
                    total += mid;
                else
                    total += arr[i];
            }
            if (total <= n) {
                answer = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }

        System.out.println(sb.append(answer));
    }

    //  과자 나눠주기 - 백궂ㄴ
    // answer 찾은 후에도 계속 탐색

    // 입국 심사 : 백준, 프로그래머스
}
