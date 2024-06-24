import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

arr.sort(reverse=True)
answer = arr[0]
for i in range(n-1):
    answer += (float)(arr[i+1]) / 2

output_a = "{:g}".format(answer)
print (output_a)