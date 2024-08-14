import sys

input = sys.stdin.readline
n, k = map(int, input().split())
arr = list(map(int, input().split()))

# 각 숫자의 개수를 담는 배열
cnt = [0] * (max(arr) + 1)
left, right = 0, 0
answer = 0

while right < n:
   if cnt[arr[right]] < k:
      # cnt++ 후 오른쪽으로 전진
      cnt[arr[right]] += 1
      right += 1
   else:
      # 맨 왼쪽에서 한칸 오른쪽으로
      cnt[arr[left]] -= 1
      left += 1
   answer = max(answer, right - left)
   
print(answer)