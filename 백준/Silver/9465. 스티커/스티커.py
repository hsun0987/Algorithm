import sys

input = sys.stdin.readline
t = int(input())

for _ in range(t):
   n = int(input())
   arr = [[0] * n for _ in range(2)]
   arr[0] = list(map(int, input().split()))
   arr[1] = list(map(int, input().split()))
   
   if n == 1:  # 반례(인덱스 에러)
      print(max(arr[0][0], arr[1][0]))
   
   else:
      # 초기값 설정
      dp = [[0] * 100001 for _ in range(2)]
      dp[0][0] = arr[0][0]
      dp[1][0] = arr[1][0]
      dp[0][1] = arr[1][0] + arr[0][1]
      dp[1][1] = arr[0][0] + arr[1][1]

      # 점화식
      # dp[0][i] = max(dp[0][i-2], dp[1][i-2], dp[1][i-1]) + arr[0][i] 
      # dp[1][i] = max(dp[1][i-2], dp[0][i-2], dp[0][i-1]) + arr[1][i]

      for i in range(2, n):
         dp[0][i] = max(dp[0][i-2], dp[1][i-2], dp[1][i-1]) + arr[0][i] 
         dp[1][i] = max(dp[1][i-2], dp[0][i-2], dp[0][i-1]) + arr[1][i]

      print(max(dp[0][n-1], dp[1][n-1]))