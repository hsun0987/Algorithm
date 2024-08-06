import sys

input = sys.stdin.readline
n = int(input())
children = [int(input()) for _ in range(n)]

# 초기값 설정
dp = [0] * (n+1)
dp[0] = 1
   
# 점화식
# dp[n] = max(dp[i] + 1, dp[n]) # i: 자기보다 작은 n

for i in range(1, n):
   for j in range(i):
      if children[i] > children[j]:
         dp[i] = max(dp[j] + 1, dp[i])
      else: # 반례: 4 1 2 3 5 / 답: 1, 오답: 2
         dp[i] = max(1, dp[i])
         
# 최소 이동 = 총 아이들 수 - LIS 수(최장증가부분수열)
answer = n - max(dp)
print(answer)