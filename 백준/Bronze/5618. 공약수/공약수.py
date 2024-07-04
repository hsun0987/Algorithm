# 공약수: a로도 나눠지고 b로도 나눠지는 수
# 최대공약수의 약수를 구한다

import math
import sys
input = sys.stdin.readline

# 입력
n = int(input())

if n == 2:
    p, q = map(int, input().split())
    a = math.gcd(p, q)
else:
    p, q, r = map(int, input().split())
    a = math.gcd(p, q, r)

answer = []
for i in range(1, int(math.sqrt(a))+1):
    if a % i == 0:
        answer.append(i)
        if i**2 != a:
            answer.append(a // i)

answer.sort()

# 출력
for i in answer:    
    print(i)