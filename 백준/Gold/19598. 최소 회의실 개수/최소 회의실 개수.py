# 다음 회의 시작시간 < 전 회의 끝시간
# 맞을 경우 같은 회의실 사용 불가 cnt ++
# 아닐 경우 같은 회의실 사용 -> heap 에서 제거

import heapq
import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

# 시작시간 기준 오름차순 -> 반례 대응
arr.sort(key=lambda x:(x[0], x[1]))

heap = []
heapq.heappush(heap, arr[0][1]) # 맨 처음 값의 끝 시간(end)

cnt = 1   
for i in range(1, n):
    start, end = arr[i]
    if start < heap[0]:
        cnt += 1
    else:
        heapq.heappop(heap) # 회의 완. 힙에서 제거
    heapq.heappush(heap, end) # 다음 끝시간 힙에 저장

print(cnt)