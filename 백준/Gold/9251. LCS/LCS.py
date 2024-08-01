import sys

input = sys.stdin.readline
s1 = input()
s2 = input()

# 초기값 설정
dp = [[0] * (1001) for _ in range(1001)]

    
# 점화식
# 같은 문자일 때: dp[i-1][j-1] + 1
# 다른 문자일 때: max(dp[i][j-1], dp[i-1][j])

for i in range(len(s2)-1):
    for j in range(len(s1)-1):
        if s2[i] == s1[j]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i][j-1], dp[i-1][j])

print(max(map(max, dp)))