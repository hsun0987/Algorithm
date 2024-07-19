# 돌의 개수 홀수 -> 상근
# 짝수 -> 창영

import sys

input = sys.stdin.readline
n = int(input())

if n % 2 != 0:
   print("SK")
else:
   print("CY")