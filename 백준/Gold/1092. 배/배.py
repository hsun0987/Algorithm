import sys

def solution(n, crane, m, box):
   cnt = 0
   
   # 최대 박스 무게 > 최대 크레인 무게 = -1
   if crane[0] < box[0]:
      return -1
   
   while box:
      cnt += 1
      j = 0
      for i in range(n):
         # 박스 > 크레인 => 옮길수 없음 j +=1
         while j < len(box) and box[j] > crane[i]:
               j += 1
         # box 내에 인덱스가 존재하면 pop
         if j < len(box):
               box.pop(j)
   
   return cnt

#입력
input = sys.stdin.readline

n = int(input())
crane = list(map(int, input().split()))
m = int(input())
box = list(map(int, input().split()))

#정렬
crane.sort(reverse=True)
box.sort(reverse=True)

#출력       
print(solution(n, crane, m, box)) 