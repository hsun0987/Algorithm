# 2+1 가장 싼 것 무료 3으로 나눠떨어질 때 합X
import sys
input = sys.stdin.readline

n = int(input())
arr = [int(input()) for i in range(n)]

arr.sort(reverse=True)
answer = 0
for i in range(n):
    if (i+1) % 3 != 0:
        answer += arr[i]

print(answer)