n, x = map(int, input().split())
a = list(map(int, input().split()))

answer = []
for i in a:
    if x > i:
        answer.append(str(i))

print(' '.join(answer))