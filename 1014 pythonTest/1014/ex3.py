import re
import requests

url ='https://shared-comic.pstatic.net/thumb/webtoon/708452/thumbnail/thumbnail_IMAG04_e5269772-9eeb-4cab-bafc-d7dd0ea740d9.jpg'
f = open('../Data/webtoon.jpg','wb') #이미지모듈로 저장 - wb
f.write(requests.get(url).content)
f.close()
print('이미지를 다운받았습니다.')


