# 숫자가 커지면 시간초과 -> 재사용 => DP
# nCr = n-1Cr-1 + n-1Cr
# dp[n][r] = dp[n-1][r-1] + dp[n-1][r]

import sys

#입력
input = sys.stdin.readline
T = int(input())
dp = [[0] * 30 for _ in range(30)]
for i in range(30):
   for j in range(30):
      if i == 1:
         dp[i][j] = j
      else:
         if i == j:
            dp[i][j] = 1
         elif i < j:
            dp[i][j] = dp[i-1][j-1] + dp[i][j-1]

for _ in range(T):
    N, M = list(map(int, input().split()))
    print (dp[N][M])