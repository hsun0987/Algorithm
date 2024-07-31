import sys

input = sys.stdin.readline
n, k = map(int, input().split())
bag = []
for i in range(n):
   bag.append(list(map(int, input().split())))

# 초기값 설정
dp = [0] * (k+1)
   
# 점화식
#1106. 호텔 문제 유사
#dp[n] = max(dp[n-w] + v, dp[n])

for w, v in bag:
   # 호텔과 다른점: 물건 개수 한정 -> i를 앞에서부터 돌면 누적값이 계속 커지는 문제
   # => i를 k부터 아래로 반복 
   for i in range(k, w-1, -1):
      dp[i] = max(dp[i-w] + v, dp[i])

print(dp[k])