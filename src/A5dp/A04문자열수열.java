package A5dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A04문자열수열 {
    // 가장 긴 증가하는 부분 수열 (11053) - 백준
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, dp[i]);
        sb.append(max);
        System.out.println(sb);

        br.close();
    }*/

    // 가장 긴 증가하는 부분 수열 4 (14002) - 백준
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] prev = new int[n]; // 수열 복원용 (현재 위치 앞에 있는 수열 인덱스 저장)

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            prev[i] = -1;
        }

        // DP
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j; // 가장 최근 연결된 수열 인덱스 저장
                }
            }
        }

        int max = 0, idx = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }
        sb.append(max + "\n");

        // 실제 원소 복원
        Deque<Integer> stack = new ArrayDeque<>();
        while (idx != -1) {
            stack.push(arr[idx]);
            idx = prev[idx];
        }
        while (!stack.isEmpty())
            sb.append(stack.pop() + " ");

        // 수열 : 10 -> 20 -> 30 -> 50
        // dp : 1, 2, 1, 3, 2, 4
        // prev : -1, 0, -1, 1, 0, 3
        System.out.println(sb);

        br.close();
    }
}
