# 한 색으로 색칠 + 다른 색 칠한 수 
# 반례: RRBBB -> 연속된 색깔일 때
# RRBBRRBBRR

import sys
input = sys.stdin.readline

n = int(input())
arr = input()

# 앞에서부터 색을 칠하는 경우
cnt1 = 1
for i in range(1, n):
    if arr[i] != arr[i-1]:
        cnt1 += 1

# B로 다 칠한 경우
cnt2 = 1
if arr[0] == "R":
    cnt2 += 1
for i in range(1, n):
    a = arr[i]
    if arr[i] == "R" and arr[i] != arr[i-1]:
        cnt2 += 1  

# R로 다 칠한 경우 
cnt3 = 1
if arr[0] == "B":
    cnt3 += 1
for i in range(1, n):
    a = arr[i]
    if arr[i] == "B" and arr[i] != arr[i-1]:
        cnt3 += 1         

answer = min(cnt1, cnt2, cnt3)

print(answer)