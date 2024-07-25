import sys

input = sys.stdin.readline
n = int(input())

# 초기값 설정
dp = [0] * 50001
dp[1] = 1

# 점화식
# dp[i] = dp[i-j**2] + 1
# j는 i보다 작은 최대 제곱수
# ex) i = 11 = 3**2 + 1**2 + 1**2
# j = 3, dp[11 - 3**2] = dp[2] = 1**2 + 1**2

for i in range(2, n+1):
   min_sqrt = 4
   j = 1
   # 자신보다 작은 제곱수 일 때
   while (j**2) <= i:
      # 제곱수의 합 개수의 최솟값
      min_sqrt = min(min_sqrt, dp[i-j**2])
      j += 1
   dp[i] = min_sqrt + 1

print(dp[n])