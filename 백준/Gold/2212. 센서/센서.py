# 수신거리 = 최대거리 - 최소거리 = 최솟값(13164.행복유치원)
# 0. 입력 받은 거리 정렬(거리의 최소를 구하기 위해)
# 1. 각 거리 차이 저장
# 2. 오름차순 정렬
# 3. k-1 개 제거 (연결의 수)

import sys
input = sys.stdin.readline

def solution(n, k, arr):
    answer = 0
   
    len = []
    for i in range(n-1):
       len.append(arr[i+1] - arr[i])
    
    len.sort()
    
    for _ in range(k-1):
        len.pop()
   
    answer = sum(len)
    return answer

# 입력
n = int(input())
k = int(input())
arr = list(map(int, input().split()))
arr.sort()

# 출력
if n < k:
    print(0)
else:
    print(solution(n, k, arr))