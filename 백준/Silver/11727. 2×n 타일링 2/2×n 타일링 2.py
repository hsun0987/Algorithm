import sys

input = sys.stdin.readline
n = int(input())

# 초기값 설정
dp = [0] * 1001
dp[1] = 1
dp[2] = 3

# 점화식
# dp[n] = dp[n-2] * 2 + dp[n-1]

for i in range(3, n + 1):
   dp[i] = (dp[i-2] * 2) % 10007 + dp[i-1] % 10007
   dp[i] %= 10007

print(dp[n])