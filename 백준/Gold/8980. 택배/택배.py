# 도착 마을 순으로 정렬
# 출발~도착 마을까지 돌면서 박스 배달
# 도착까지 보내는 박스의 개수 누적(트럭 용량 초과시 처리)

import sys

def solution(n, c, boxes):
   answer = 0
   truck = [0] * n # n번째 마을까지 실린 박스 수
   
   for start, end, cnt in boxes:
      cur = cnt # 현재 마을에서 보내는 박스 수
      
      for i in range(start, end):
         if cur + truck[i] >= c: # 용량 초과
            cur = c - truck[i] # 트럭의 용량에서 이미 실린 박스만큼 빼기(추가로 더 실을 수 있는 박스 수)
         truck[i] += cur # 트럭에 현재 박스 개수 추가
      answer += cur # 보내는 마을에 도착했을 때 트럭에 있는 박스 내리기
   
   return answer

#입력
input = sys.stdin.readline
n, c = map(int, input().split())
m = int(input())

boxes = []
for _ in range(m):
   s, r, b = map(int, input().split())
   boxes.append([s, r, b])

# 받는 마을, 보내는 마을 순으로 정렬
boxes.sort(key = lambda x: (x[1], x[0]))
   
#출력    
print(solution(n, c, boxes))