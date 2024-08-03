import sys

input = sys.stdin.readline
n, m = map(int, input().split())
arr = []
for i in range(n):
    arr.append(list(input().strip()))

# 초기값 설정
dp = [[0] * (1001) for _ in range(1001)]

# 점화식
# dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1

answer = 0
for i in range(n):
    for j in range(m):
        # 인덱스 범위 넘어감 방지, 현위치가 0이면 0
        if i == 0 or j == 0 or arr[i][j] == "0":
            dp[i][j] = int(arr[i][j])  
        else:
            # 현재 위치 기준 (왼, 위, 왼+위) 중 최솟값 + 1
            dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1
        # 최댓값 갱신
        answer = max(dp[i][j], answer)
print(answer ** 2)