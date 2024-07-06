# 최소공배수 
# lcm{N1,N2}=gcd{N1,N2} * n1 * n2

import sys
import math

input = sys.stdin.readline
t = int(input())

for _ in range(t):
   arr = list(map(int, input().split()))
   
   g = math.gcd(arr[0], arr[1])
   answer = g * (arr[0]/g) * (arr[1]/g)

   print(int(answer)) 