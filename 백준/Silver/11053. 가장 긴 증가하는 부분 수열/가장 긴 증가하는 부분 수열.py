# dp[n] = 현재 n보다 작은 값 중 최댓값 n + 1
import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))

# 초기값 설정
dp = [1] * 1001

# 점화식
# dp[n] = max(dp[n], dp[i] + 1) >> i: n보다 작은 값

for i in range(n):      # 기준값(현재 n)
   for j in range(i):   # 비교 대상(앞에 값 중 작은 값 찾기)
      if arr[i] > arr[j]:
         dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))