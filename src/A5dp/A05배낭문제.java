package A5dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주어진 데이터를 중복해서 사용할 수 있는지 구분 필요 (동전과 유사)
public class A05배낭문제 {
    // 평범한 배낭 : 백준
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 물품 수
        int k = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[] w = new int[n]; // 무게
        int[] v = new int[n]; // 가치
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = k; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }

        sb.append(dp[k]);
        System.out.println(sb);
    }*/

    // 호텔 : 백준
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); // 목표 고객 수
        int n = Integer.parseInt(st.nextToken()); // 홀보할 수 있는 도시 개수
        int[] costs = new int[n]; // 홍보 비용
        int[] values = new int[n]; // 홍보로 얻을 수 있는 고객 수

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        int max = c + 100 * 100;
        int[] dp = new int[max + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = values[i]; j <= max; j++) {
                if (dp[j - values[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - values[i]] + costs[i]);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = c; i < max; i++) {
            if (dp[i] < result)
                result = dp[i];
        }

        sb.append(result);
        System.out.println(sb);

        br.close();
    }
}
