import sys

input = sys.stdin.readline
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

 # 초기값 설정
 # 전체 누적합 저장
dp = [[0]*(m+1) for _ in range(n+1)]
for i in range(1, n+1):
   for j in range(1, m+1):
      dp[i][j] = arr[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]

k = int(input())

for _ in range(k):
   # 점화식
   # 총 누적값 - 해당하지 않는 범위의 누적값
   # dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]
   
   x1, y1, x2, y2 = list(map(int, input().split()))
   answer = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]   
   print(answer)