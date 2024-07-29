import sys

input = sys.stdin.readline
n, k = map(int, input().split())

coin = [int(input()) for _ in range(n)]
coin.sort()

# 초기값 설정
dp = [0] * (k+1)
dp[0] = 1
    
# 점화식
# c = 1 부터 DP 채우기(c = 2, 5 ... dp 갱신)
# dp[i]에 c 전에 있는 값에 c를 추가한 경우 더해줌
# ex. c = 2 -> dp[4]는 dp[2]일 경우에 2를 추가해준 경우의 수임
# (1 1 / 2) -> (1 1 2 / 2 2) + (1 1 1 1)
# dp[i] += dp[i-c]

for c in coin:
    for i in range(c, k + 1):
        dp[i] += dp[i - c]

print(dp[k])