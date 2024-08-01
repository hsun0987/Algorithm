import sys

input = sys.stdin.readline
n, k = map(int, input().split())

# 초기값 설정
dp = [[1] * (201) for _ in range(201)]

# 점화식
# dp[k][n] = dp[k-1][n] + dp[k][n-1]

for i in range(2, k+1):
    for j in range(1, n+1):
        dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000
        
print(dp[k][n])