import sys

input = sys.stdin.readline
n, m = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

for i in b:
   a.append(i)
   
a.sort()
print(*a)