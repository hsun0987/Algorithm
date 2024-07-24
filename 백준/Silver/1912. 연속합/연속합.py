# 연속된 값 중 합이 가장 큰 값
import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))

# 초기값 설정
dp = [0] * (n)
dp[0] = arr[0]
if n > 1:
   dp[1] = max(arr[0] + arr[1], arr[1])

# 점화식
# dp[n] = max(dp[n-1] + arr[n], arr[n-1] + arr[n], arr[n])
 
for i in  range(2, n):
   dp[i] = max(dp[i-1] + arr[i], arr[i-1] + arr[i], arr[i])

print(max(dp))