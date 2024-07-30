import sys

input = sys.stdin.readline
n, k = map(int, input().split())
coin = [int(input()) for _ in range(n)]
coin.sort()

# 초기값 설정
dp = [999999] * (k+1)
dp[0] = 0

# 점화식
# dp[n] = min(dp[n-c] + 1, dp[n])

for c in coin:
   for i in range(c, k+1):
      dp[i] = min(dp[i-c] + 1, dp[i])

# 마지막 값이 초기값과 같으면 불가능한 경우로 판단
if dp[k] >= 999999:
   dp[k] = -1
   
print(dp[k])