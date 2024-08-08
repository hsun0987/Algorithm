import sys

input = sys.stdin.readline
t = int(input())
k = int(input())
coin = [list(map(int, input().split())) for _ in range(k)]

# 초기값 설정
dp = [0] * (t+1)
dp[0] = 1
   
# 점화식
# money: 만들고자하는 돈, p: 동전 종류, i: 개수(n)
# dp[20] = dp[20-10*1] + dp[20-10*2] 를 의미
# dp[money] += dp[money - p * i]

for p, n in coin:
   for money in range(t, 0, -1): # T원부터 1원까지 내려가며 진행 => 1부터 시작하면 계속 누적됨
      for i in range(1, n+1): # 현재 동전 coin의 개수만큼 for문 진행 
         if money - p * i >= 0: # 0원 이상인 경우
            dp[money] += dp[money - p * i]

print(dp[t])