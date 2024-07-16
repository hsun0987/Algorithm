# 기름값이 비싼 곳에서는 최소 비용만 구매
# 앞 도시보다 기름값이 싼 도시가 있으면 그 가격으로 구매

import sys

def solution(n, dis, oil):
   answer = 0
   
   min_oil = oil[0]
   for i in range(n-1):
      if min_oil > oil[i]:
         min_oil = oil[i]
      answer += dis[i] * min_oil
   
   return answer

#입력
input = sys.stdin.readline
n = int(input())
dis = list(map(int, input().split()))
oil = list(map(int, input().split()))
oil.pop() # 마지막 도시는 신경X
   
#출력    
print(solution(n, dis, oil))