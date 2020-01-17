import re
import requests


# <img onerror="this.src='https://static-comic.pstatic.net/staticImages/COMICWEB/NAVER/img/common/blank.gif'" src="https://shared-comic.pstatic.net/thumb/webtoon/183559/thumbnail/thumbnail_IMAG10_5e13c29c-f451-4430-a84a-a46495fb8cc3.jpg" width="83" height="90" title="신의 탑" alt="신의 탑">

# https://shared-comic.pstatic.net/thumb/webtoon/651673/thumbnail/thumbnail_IMAG10_659b9446-0940-494a-bb5f-5893290a84d0.jpg



url = 'https://comic.naver.com/webtoon/weekday.nhn'
text = requests.get(url).text
print(text)

title = re.findall('<div class="thumb">.+?title="(.+?)".+?</div>',text,re.DOTALL)
# print(title)
# img = re.findall('<img onerror=.+?src="(.+?)".+?>',text,re.DOTALL)
arr = re.findall('<img onerror=.+?src="(.+?)".+?>',text,re.DOTALL)
# print(img)
#
for i in range(len(arr)):
   f = open('../Data/wt'+str(i)+'.jpg', 'wb')
    f.write(requests.get(arr[i]).content)
    f.close()

print(str(i)+'이미지다운 완료')

