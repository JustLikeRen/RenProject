##가위바위보
from r.dice import dice

#컴이 가위바위보 내기
r_p = dice(3)
if r_p == 1:
    r_p = "가위"
if r_p == 2:
    r_p = "바위"
if r_p == 3:
    r_p = "보"

#유저가 가위바위보 내기
r_u = input("가위바위보 중 하나를 내주세용: ")

#낸거 출력
print("컴: "+r_p+" vs "+"나: "+r_u)

#판정
r = ""
if r_p == "가위":
    if r_u == "가위":
        r="비김"
    if r_u == "바위":
        r="이겼다"
    if r_u == "보":
        r="졌다"
if r_p == "바위":
    if r_u == "가위":
        r="졌다"
    if r_u == "바위":
        r="비김"
    if r_u == "보":
        r="이겼다"
if r_p == "보":
    if r_u == "가위":
        r="이겼다"
    if r_u == "바위":
        r="졌다"
    if r_u == "보":
        r="비김"

#판정 결과
print(r)