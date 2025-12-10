class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1_000_000_000;
        int len = info.length;

        // dp[i][a] = i번째 물건까지 고려했을 때 A의 흔적이 a일 때 B의 최소 흔적
        int[][] dp = new int[len][n];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = INF;
            }
        }

        // 초기값: 첫 번째 물건을 A가 훔친 경우
        if (info[0][0] < n) {
            dp[0][info[0][0]] = 0;
        }
        // 초기값: 첫 번째 물건을 B가 훔친 경우
        if (info[0][1] < m) {
            dp[0][0] = info[0][1];
        }

        // DP 진행
        for (int i = 1; i < len; i++) {
            for (int a = 0; a < n; a++) {
                if (dp[i - 1][a] == INF) continue;
                int b = dp[i - 1][a];

                // A가 훔치는 경우
                int newA = a + info[i][0];
                if (newA < n && b < m) {
                    dp[i][newA] = Math.min(dp[i][newA], b);
                }

                // B가 훔치는 경우
                int newB = b + info[i][1];
                if (a < n && newB < m) {
                    dp[i][a] = Math.min(dp[i][a], newB);
                }
            }
        }

        // 결과 찾기
        int answer = INF;
        for (int a = 0; a < n; a++) {
            if (dp[len - 1][a] < m) {
                answer = Math.min(answer, a);
            }
        }
        return answer == INF ? -1 : answer;
    }
}
