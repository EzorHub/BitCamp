import requests
import re

url='https://kin.naver.com/qna/list.nhn'
text = requests.get(url).text

# print(text)
arr = re.findall('<a href="/qna/detail.nhn.+?>(.+?)</a>', text, re.DOTALL)
#print(arr)

# <a href="/qna/detail.nhn.+?>(.+?)</a>
#
# <a href="/qna/detail.nhn?d1id=10&dirId=100106&docId=337947081" rel="KIN" target="_blank" class="_nclicks:kls_new.list,r:1,i:100106_337947081">골프백수선점...</a>

f = open('../Data/qna.txt','w',encoding='utf-8')
for str in arr:
    f.write(str)
    f.write('\n')
f.close()
print('수집완료')

