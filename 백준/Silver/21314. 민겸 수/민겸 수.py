# 최댓값 = k 기준 최소로 나눈 것(k는 1개씩만 연속 없음)
# 최솟값 = k 기준 다 자름
# K가 한개면 무조건 나눠야함

import sys
input = sys.stdin.readline

mk = input().strip()

max = ''
min = ''
m = 0

for i in mk:
    if i == 'M':
        m += 1
    elif i == 'K':
        if m > 0:
            max += str(5 * (10 ** m))
            min += str(10 ** (m-1))
            min += '5'
        else:
            max += '5'
            min += '5'
        m = 0

if m > 0:
    min += str(10 ** (m-1))
    # max는 나머지가 다 1일 경우
    for i in range(m):
        max += '1'
              
print(max)
print(min)