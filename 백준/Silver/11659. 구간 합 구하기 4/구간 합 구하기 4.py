import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
step = [list(map(int, input().split())) for _ in range(m)]

dp = [0] * (n+1)
for i in range(1, n+1):
   dp[i] += dp[i-1] + arr[i-1]

for i, j in step:
   print(dp[j] - dp[i-1])