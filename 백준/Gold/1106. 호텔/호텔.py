import sys

input = sys.stdin.readline
c, n = map(int, input().split())
cost_list = [list(map(int, input().split())) for _ in range(n)]

# 초기값 설정
dp = [1e7] * (c + 100) # cost <= 100
dp[0] = 0

# 점화식
# dp[n] = min(dp[n], dp[n-people] + cost)

for cost, people in cost_list:
   for i in range(people, c+100):   # c명보다 많은 고객 수 일 때 최소 비용이 나올 경우 생각
      dp[i] = min(dp[i], dp[i-people] + cost)

# c명 이상의 범위 내에서 최소비용 (정렬 필요 없음)
print(min(dp[c:]))