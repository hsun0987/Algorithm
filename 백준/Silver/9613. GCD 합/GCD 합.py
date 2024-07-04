import sys
import math
from itertools import combinations

input = sys.stdin.readline
t = int(input())

for _ in range(t):
    arr = list(map(int, input().split()))
    n = arr.pop(0)
    
    combi = list(combinations(arr, 2))
    gcds = []
    for i in combi:
       gcds.append(math.gcd(i[0], i[1]))
       
    print(sum(gcds)) 