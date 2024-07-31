import sys

input = sys.stdin.readline
t = int(input())

for _ in range(t):
   n = int(input())
   coin = list(map(int, input().split()))
   m = int(input())

   # 초기값 설정
   dp = [0] * (m+1)
   dp[0] = 1
      
   # 점화식
   #dp[n] += dp[n-c]

   for c in coin:
      for i in range(c, m+1):
         dp[i] += dp[i-c]
   
   print(dp[m])