import re
import requests
db='''
3412    Bob 123
3834  Jonny 333
1248   Kate 634
1423   Tony 567
2567  Peter 435
3567  Alice 535
1548  Kerry 534
'''
print('db내용',db)

# temp=re.findall('Alice', db)
temp = re.findall('[0-9]', db)
print(temp)

url = 'http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108'
text = requests.get(url).text
print(text)

# 서울의 다음주 날씨를 출력해주세요.
# 날짜, 최고온도, 최저온도
seoul = re.findall('<city>서울</city>(.+?</location>)',text,re.DOTALL)
print(seoul)

arr = re.findall('<tmEf>(.+?)</tmEf>.+?<tmn>(.+?)</tmn>.+?<tmx>(.+?)</tmx>', seoul[0],re.DOTALL)
print(arr[0])
print(type(arr[0]))