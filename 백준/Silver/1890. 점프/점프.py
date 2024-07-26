import sys

input = sys.stdin.readline
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

# 초기값 설정
dp = [[0] * 101 for _ in range(101)]
dp[0][0] = 1


# 점화식
# x = arr[i][j]
# dp[i+x][j] += dp[i][j] 
# dp[i][j+x] += dp[i][j]

for i in range(n):
   for j in range(n):
      x = arr[i][j]
      
      # dp[i][j] != 0 >> 앞서 방문한 곳만 이어서 방문
      if x == 0 or dp[i][j] == 0:
         continue
      
      ni = i + x
      nj = j + x
      
      if ni < n:
         dp[ni][j] += max(dp[i][j], 1)
      if nj < n:
         dp[i][nj] += max(dp[i][j], 1)
         
print(dp[n-1][n-1])