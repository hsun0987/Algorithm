# 2579. 계단 오르기 유사
import sys

input = sys.stdin.readline
n = int(input())

wine = [0] * (n+1)
for i in range(1, n+1):
    wine[i] = int(input())

dp = [0] * (n+1)

if n < 3:
    if n == 1:
        dp[1] = wine[1]
    else:
        dp[2] = wine[1] + wine[2]
    
else:
    # 초기값 설정
    dp[1] = wine[1]
    dp[2] = wine[1] + wine[2]
    dp[3] = max(wine[1] + wine[3], wine[2] + wine[3])

    # 점화식
    # 3칸 연속x => 2칸 -> 1칸, 1칸 -> 2칸  중 큰 값 저장
    # dp[i] = max(dp[i-2] + a[i], dp[i-3] + a[i-1] + a[i])

    for i in range(4, n+1):
        dp[i] = max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i])
        if i > 4: # 반례: 1 1 0 0 1 1 -> 4(3x)
            dp[i] = max(dp[i], dp[i-4] + wine[i-1] + wine[i])
print(max(dp))