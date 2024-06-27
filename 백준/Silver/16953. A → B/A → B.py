# B -> A
# 1. B 뒷자리가 1인 경우
# 뒷자리 1을 없앰
# 2. B가 2로 나눠질 경우
# 계속 계산
# 3. B = A 경우 종료 -> 만약에 더 작아지면 -1

import sys
input = sys.stdin.readline

a, b = map(int, input().split())

answer = 0
while True:
    if b == a:
        answer += 1 
        break
    if b < a:
        answer = -1
        break
    if b % 10 == 1:
        b = int(b / 10)
        answer += 1
    else:
        b = b / 2
        answer += 1  

print(answer)