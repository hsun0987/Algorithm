import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
arr.sort()

start, end = 0, n-1
res = sys.maxsize
answer = []

while start < end:
   arr_sum = arr[end] + arr[start]
   if abs(arr_sum) < res: # 합의 최솟값 저장
     res = abs(arr_sum)
     answer = [arr[start], arr[end]]
   if arr_sum < 0: # 음수면 더 작은 값 더할 필요X 가장 작은 값 제외
      start += 1
   elif arr_sum > 0: # 가장 큰 값 제외
      end -= 1
   else:
      break
   
print(*answer)