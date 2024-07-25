import sys

input = sys.stdin.readline
n, r = map(int, input().split())

# 초기값 설정
dp = [[0] * 101 for _ in range(101)]

# 점화식
# nCr = n-1Cr-1 + n-1Cr
# dp[r][n] = dp[r-1][n-1] +dp[r][n-1]
for i in range(r+1):
   for j in range(n+1):
      if i == 1:
         dp[i][j] = j
      elif i == j:
         dp[i][j] = 1
      elif i < j:
         dp[i][j] = dp[i-1][j-1] +dp[i][j-1]

print(dp[r][n])