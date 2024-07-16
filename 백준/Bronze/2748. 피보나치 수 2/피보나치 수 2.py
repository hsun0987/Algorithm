import sys

def solution(n):
   answer = 0
   
   dp = [0] * (n+1)
   
   if n >= 1:
      dp[1] = 1 # f(1)
   
   for i in range(2, n+1):
      # f(n) = f(n-1) + f(n-2)
      dp[i] = dp[i-1] + dp[i-2]
   
   answer = dp[n]
   return answer

#입력
input = sys.stdin.readline
n = int(input())
   
#출력    
print(solution(n))