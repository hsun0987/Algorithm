# 시간이 오래걸리는 사람 순서대로 처리(내림차순 정렬)
# 누적합

n = int(input())
p = list(map(int, input().split()))

p.sort(reverse=True)
answer = 0
for i in range(n):
    sum = 0
    for j in range(i+1):
        sum += p[i]
    answer += sum
    
print(answer)