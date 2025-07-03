package A5dp;

public class A02동전관련 {

    public static void main(String[] args) {
        // 1, 4, 5d의 숫자가 없을 때, 조합하여 13을 만들 수 있는 조합 중 가장 짧은 조합의 길이
        Integer[] arr = {1, 4, 5};
        // greedy => 5*2+1*3 -> 5개 동전
        // dfs, bfs -> 시간 초과 & 메모리 초과
        // dp로 문제를 풀 경우 : 4*2 + 5*1 -> 3개 동전
        // f(n) = (Min(f(n -ni), f(n - n2))) + 1

        /*int n = 13;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i - 1]; j++) {
                if (i - j >= 0 && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }*/

        // 동전 2(2294) : 백준

    }


}
