from pymongo import MongoClient

# MongoDB 서버에 연결
# MongoDB 서버 주소와 포트
client = MongoClient("mongodb://localhost:27017/")

# 데이터베이스와 컬렉션 선택
db = client["db_cat"]  #db명 넣기
collection = db["col_member"]   #콜렉션 명 넣기

######## MQL을 사용하여 데이터 조회
#### 유저이름이 고양이인 데이터 도큐먼트 검색하기
## 쿼리변수에 딕셔너리 형태로 찾으려는 (키:값) 쌍을 넣기
query = {"user_name": "고양이"}
## collection 객체의 find 함수에 위 딕셔너리 전달하기
## (검색 조건에 맞는 도큐먼트 객체가 result로 넘어옴)
results = collection.find(query)


# 검색 리스트에서 하나씩 향상된 for문으로 꺼내서 하나씩
# 결과 도큐 객체를 출력하기
# ex. 아래 형태로 출력됨.
# {'_id': ObjectId('6517effcb75c0c189e08d296'),
# 'user_id': 'bbbb', 'age': '5',
# 'user_name': '고양이', 'user_pw': '2222'}
#
#
for result in results:print(result)
