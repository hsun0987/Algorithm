import sys
import heapq

def solution(n, arr):
   answer = 0
   heapq.heapify(arr)
   
   for _ in range(n-1):
      a = heapq.heappop(arr)
      b = heapq.heappop(arr)
      ab = a + b
      heapq.heappush(arr, ab)
      answer += ab

   return answer

#입력
input = sys.stdin.readline
t = int(input())

for _ in range(t):
   n = int(input())
   arr = list(map(int, input().split()))
   
   #출력    
   print(solution(n, arr))