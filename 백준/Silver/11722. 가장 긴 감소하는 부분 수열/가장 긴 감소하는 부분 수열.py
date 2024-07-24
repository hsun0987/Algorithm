# 연결된 숫자 중 가장 긴 부분 수열
import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))

# 초기값 설정
dp = [1] * (1001)

# 점화식
# dp[n] = max(dp[n], dp[k] + 1) >> k: n보다 큰 값

for i in range(1, n):
   for j in range(i):
      if arr[i] < arr[j]:
         dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))