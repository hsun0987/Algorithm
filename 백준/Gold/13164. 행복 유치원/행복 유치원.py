# 비용 = 가장 큰 키 - 작은 키
# 각 인접한 키차이 저장, 정렬
# k-1개 제외 -> 가장 큰 값은 혼자

import sys
input = sys.stdin.readline

n, k = map(int, input().split())
std = list(map(int, input().split()))

h = []
for i in range(n-1):
    h.append(std[i+1] - std[i])

h.sort()

for _ in range(k-1):
    h.pop()
    
answer = sum(h)

print(answer)