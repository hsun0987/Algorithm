#  사람의 수가 총 사람 수의 절반 이상이 되는 위치
#  우체국 설치

import sys

def solution(n, city, total):
   answer = 0
   
   people = 0
   for x, a in city:
      people += a
      if people >= total / 2:
         answer = x
         break
   
   return answer

#입력
input = sys.stdin.readline
n = int(input())
city = []
total = 0
for _ in range(n):
   x, a = map(int, input().split())
   city.append([x, a])
   total += a

# 정렬
city.sort(key = lambda x: x[0])
   
#출력    
print(solution(n, city, total))