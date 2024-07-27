import sys

input = sys.stdin.readline
n = int(input())

t, p = [0 for _ in range(n + 1)], [0 for _ in range(n + 1)]
for i in range(1, n + 1):
    t[i], p[i] = map(int, input().split())

# 초기값 설정
dp = [0] * 1500001
    
# 점화식
# dp[i+t(i)-1] = max(dp[i-1] + p[i], dp[i+t(i)-1])

for i in range(1, n + 1): 
    # 이전까지의 최댓값
    dp[i] = max(dp[i], dp[i-1]) 
    
    # 당일 포함
    fin = i + t[i] - 1
      
    if fin <= n: # 최종일 안에 일이 끝날 경우
        # max(원래 값, 이전값 + p[i])
        dp[fin] = max(dp[fin], dp[i - 1] + p[i])
         
print(max(dp))