# 시작시간과 종료시간이 겹치지 않는 배열의 갯수

import sys
input = sys.stdin.readline

n = int(input())
arr = []
# 회의 시작시간, 종료시간 2차원 배열
for i in range(n):
    arr.append(list(map(int, input().split())))

# 끝시간을 기준으로 정렬, 동일값일 경우 시작시간으로 정렬
arr.sort(key=lambda x:(x[1], x[0]))

cnt = 1
before = 0
for i in range(1, n):
     # 전 회의 끝시간 <= 다음 회의 시작시간
    if arr[before][1] <= arr[i][0]:
        cnt += 1
        before = i
       
print(cnt)