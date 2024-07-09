# 사람 수의 합이 총 사람 수의 절반 이상일 때 = 우체국
# 누적 마을의 사람 수 >= 총 사람 수 / 2
import sys

def solution(n, xa, people):
   answer = 0
   
   p = 0
   for x, a in xa:
      p += a
      if p >= (people / 2):
         answer = x
         break
   return answer

#입력
input = sys.stdin.readline

n = int(input())
xa = []
people = 0
for _ in range(n):
   x, a = map(int, input().split())
   xa.append([x, a])
   people += a
    
#정렬
xa.sort(key=lambda x:(x[0]))

#출력       
print(solution(n, xa, people))