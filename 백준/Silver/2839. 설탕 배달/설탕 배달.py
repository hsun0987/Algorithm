import sys

def solution(n):
   answer = 0
   if n == 4:
      return -1
   
   while n > 0:
      if n % 5 == 0:
         answer += n // 5
         break
      n -= 3
      answer += 1
      
   if n < 0:
      return -1
   
   return answer

#입력
input = sys.stdin.readline
n = int(input())
   
#출력    
print(solution(n))