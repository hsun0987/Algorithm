# 계단 1, 2칸씩 이동 
# 값이 더 큰 경우를 더해줌

import sys

input = sys.stdin.readline
n = int(input())

# 1층을 1번 인덱스로
stairs = [0] * 301
for i in range(1, n + 1):
   stairs[i] = int(input())

# 초기값 설정
dp = [0] * 301
dp[1] = stairs[1]
dp[2] = stairs[1] + stairs[2]
dp[3] = max(stairs[1] + stairs[3], stairs[2] + stairs[3])

# 점화식
# 1칸 dp[i] = dp[i-2] + s[i]
# 2칸 dp[i] = dp[i-3] + s[i-1] + s[i]

for i in range(4, n + 1):
   dp[i] = max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i])

print(dp[n])