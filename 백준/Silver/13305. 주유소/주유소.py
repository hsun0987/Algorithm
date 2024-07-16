# 기름값이 비싼 곳에서는 최소 비용만 구매
# 기름값이 가장 싼 곳에서 남은 거리만큼 구매

import sys

def solution(n, oil, city, x):
   answer = 0
   
   for i in range(n):
      if city[i] == x:
         len = sum(oil[i:])
         answer += len * x
         break
      answer += city[i] * oil[i]
   
   return answer

#입력
input = sys.stdin.readline
n = int(input())
oil = list(map(int, input().split()))
city = list(map(int, input().split()))
city.pop() # 마지막 도시는 신경X

x = min(city)
   
#출력    
print(solution(n, oil, city, x))