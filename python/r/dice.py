import random # 내장 랜덤 모듈 불러오기

def dice(n):
    return random.randint(1, n)

def dice_str(n):
    return str(random.randint(1, n))    #파이썬은 1+"고양이" 안됨. str(숫자) 해서 숫자를 형변환해야됨.