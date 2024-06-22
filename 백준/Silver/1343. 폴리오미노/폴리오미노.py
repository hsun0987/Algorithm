# .을 만날 때까지 cnt 세기
# cnt가 홀수면 -1 break
# 짝수면 A나 B를 적어줌
# if .이 없을 경우 -> cnt != 0 인 경우, cnt가 홀수인 경우 처리

x = input()
answer = ""
cnt = 0

for i in range(len(x)):
    if x[i] == "X":
        cnt += 1
    elif x[i] == ".":
        if cnt % 2 != 0:
            answer = "-1"
            break
        elif cnt == 0:
            answer += "."
        else:
            answer += "A" * (cnt//4 * 4) + "B" * (cnt%4)
            answer += "."
            cnt = 0
                    
if cnt % 2 != 0 or answer == "-1":
    print(-1)
else:
    if cnt != 0:
        answer += "A" * (cnt//4 * 4) + "B" * (cnt%4)
    print(answer)