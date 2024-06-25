# 근손실 정도 = 두 운동기구의 근손실 합
# 두개의 합의 최댓값들 중 최솟값 구하기

import sys
input = sys.stdin.readline

n = int(input())
t = list(map(int, input().split()))

t.sort()

# 홀수일 경우 마지막 값이 최소
if n % 2 != 0:
    m = t.pop()    
else:
    m = 0

# 맨 앞 + 맨 뒤 값의 최대값 저장  
for i in range(n//2):
    m = max(m, t[i] + t[-(i+1)])

print(m)