import requests
import re
url='https://kin.naver.com/qna/detail.nhn?d1id=1&dirId=1040201&docId=337940675'
text = requests.get(url).text
print(text)

