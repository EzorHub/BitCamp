import re
import requests

# maximum = 0
# page = 1
#
# url = 'https://kin.naver.com/qna/list.nhn?queryTime=2019-10-14%2009%3A44%3A58&page=2'
# content = requests.get(url).text
# print(content)

for i in range(1,100):
    url = 'https://kin.naver.com/qna/list.nhn?queryTime=2019-10-14%2009%3A44%3A58&page='+str(i)
    text = requests.get(url).text
    # print(text)
    arr = re.findall('<a href="/qna/detail.nhn.+?">(.+?)</a>',text,re.DOTALL)
    print(arr)
    fname = '../Data/qna'+str(i)+'.txt'
    f = open(fname,'w',encoding='utf-8')
    for line in arr:
         f.write(line)
         f.write('\n')
    f.close()

    print(str(i)+'페이지 수집을 완료')




