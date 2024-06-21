# 팁 - (받은 등수 - 1)
# 최댓값 -> 팁이 큰 순서대로 커피를 줌(내림차순)

n = int(input())

arr = [int(input()) for _ in range(n)]

arr.sort(reverse=True)

answer = 0
for i in range(0, n):
    tip = arr[i] - i
    if tip > 0:
        answer += tip
    else:
        break
    
print(answer)
