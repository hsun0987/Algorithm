# 계산의 최소값 구하기
# -가 있을 때 -를 기준으로 나눠서 계산

import sys
input = sys.stdin.readline

n = input().strip()

temp = n.split('-')

answer = 0
answer += sum(map(int, temp[0].split('+')))

# -가 있을 경우
if len(temp) > 1: 
    for i in range(1, len(temp)):
        answer -= sum(map(int, temp[i].split('+')))

print(answer)