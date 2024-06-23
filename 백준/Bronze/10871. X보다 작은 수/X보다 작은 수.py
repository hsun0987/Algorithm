n, x = map(int, input().split())
a = list(map(int, input().split()))

answer = ""
for i in range(n):
    if x > a[i]:
        answer += str(a[i]) + " "
        
print(answer)