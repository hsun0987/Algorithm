import sys
import heapq

def solution(n, card):
   answer = 0
   heapq.heapify(card)
   
   for i in range(n-1):
      a = heapq.heappop(card)
      b = heapq.heappop(card)
      sum = a + b
      answer += sum
      heapq.heappush(card, sum)
      
   return answer

#입력
input = sys.stdin.readline
n = int(input())
card = [int(input()) for i in range(n)]
   
#출력    
print(solution(n, card))