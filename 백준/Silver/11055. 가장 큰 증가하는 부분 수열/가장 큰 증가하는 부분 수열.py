# 연결된 숫자 중 가장 합이 큰 부분 수열
import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))

# 초기값 설정
dp = [0] * (n)
dp[0] = arr[0]

# 점화식
# dp[n] = max(dp[n], dp[k] + arr[n]) >> k: n보다 작은 값

for i in range(1, n):
   for j in range(i):
      if arr[i] > arr[j]:
         dp[i] = max(dp[i], dp[j] + arr[i])
      if dp[i] == 0:
         dp[i] = arr[i]

print(max(dp))