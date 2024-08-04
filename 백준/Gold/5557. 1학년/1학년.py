import sys

input = sys.stdin.readline
n = int(input())
nums = list(map(int, input().split()))

# 초기값 설정
dp = [[0] * 21 for _ in range(n-1)]
dp[0][nums[0]] = 1
   
# 점화식
# i : 수식의 수, j : 계산 후 만들어지는 경우의 수
# j-nums[i] = 계산 결과, dp[i-1][j] = 이전 피연산자의 경우의 수 누적
# 차: dp[i][j-nums[i]] += dp[i-1][j]
# 합: dp[i][j+nums[i]] += dp[i-1][j]

for i in range(1, n-1):
   for j in range(21):
      if j-nums[i] >= 0: 
         dp[i][j-nums[i]] += dp[i-1][j]
      if j+nums[i] <= 20: 
         dp[i][j+nums[i]] += dp[i-1][j]

print(dp[-1][nums[-1]])