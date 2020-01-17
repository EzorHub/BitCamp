from flask import Flask, jsonify
import re
import requests


app = Flask(__name__)
# 요청 - spring의 requestMapping

@app.route('/down_webtoon.do')
def down_webtoon():
    url = 'https://comic.naver.com/webtoon/weekday.nhn'
    text = requests.get(url).text
    # print(text)

    title = re.findall('<div class="thumb">.+?title="(.+?)".+?</div>', text, re.DOTALL)
    img = re.findall('<img onerror=.+?src="(.+?)".+?>', text, re.DOTALL)
    # print(len(title))

    for i in range(1, 323):
        title[i] = title[i].replace(',', "_")
        title[i] = title[i].replace('?', "_")
        f = open('../Data/' + title[i] + '.jpg', 'wb')
        f.write(requests.get(img[i]).content)
        f.close()
        print(title[i] + '이미지다운 완료')
    return '완료'

@app.route('/hello.do')
def hello_world():
    return 'hello world'

@app.route('/listMember.do')
def list_member():
    arr = [{'name':'lion', 'age':20},
           {'name':'tiger', 'age':40}
           ]
    return jsonify(arr)

if __name__ =='__main__':
    # app.run(port=8088,host='203.236.209.118')
    app.run(host='203.236.209.118')
