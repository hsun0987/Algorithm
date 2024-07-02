# K개 작은 숫자를 차례대로 삭제
# 스택에 숫자를 하나씩 push
# top 보다 큰 값이 들어오면 작은 값 삭제
# K개 삭제

import sys
input = sys.stdin.readline

def solution(n, k, arr):
    stack = []
    cnt = 0 # k개 셀 변수
    
    stack.append(arr[0])
    for i in range(1, n):        
        while stack and cnt < k and stack[-1] < arr[i]:
            stack.pop()
            cnt += 1
        stack.append(arr[i])

    if cnt < k:
        for i in range(k-cnt):
            stack.pop()
            
    return ''.join(stack)

# 입력
n, k = map(int, input().split())
arr = input().strip()

# 출력
print(solution(n, k, arr))