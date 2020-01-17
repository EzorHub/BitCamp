#-*- coding:utf-8 -*-

import re
import requests
import sys








#
# # url = "http://www.bcl.go.kr/site/program/libraryuse/readingroom?menuid=019006010&libraryset=4"
# url = "http://112.216.58.58:8800/seatmate/SeatMate.php"
# text = requests.get(url).text
# # a = text.decode('cp949').encode('utf-8')
# print(text)
#
#
# #빈자리만 출력
# # empty = text.match('rgb(185,185,185)')
# empty= re.findall('<div style="(background-color:rgb(185,185,185))"></div>)',text)
# print('empty: ',empty)
#

url = "http://210.104.108.108/libseat/Seat_Info/1_readingroom.asp"
text = requests.get(url).text
#print(text)
# 정규식 표현만들기
# 
# <span.+?#FFFE91;.+?<font size ="2">(.+?)</td>
# <span.+?#FFFE91;.+?<font size ="2">(.+?)</td></tr></table></span> 
# 
# <span id="Layer110" style="position:absolute; left:130px; top:156; width:30px; height:25px; z-index:1; background-color: #FFFE91; border: 1px solid #000000;"><table height="100%" align="center" valign="middle"  cellpadding="0" cellspacing="0" style="margin:0px"><tr><td><font size ="2">2</td></tr></table></span> 
# 

arr= re.findall('<span.+?#FFFE91;.+?<font size ="2">(.+?)</td>', text)
print(len(arr))
print('arr: ',arr)


# print('----------------------------')
# print('수색초등학교 급식메뉴')
#
# url='http://susaek.sen.es.kr/dggb/module/mlsv/selectMlsvDetailPopup.do?mlsvId=1222957'
# #url='http://sangin.es.kr/lunch.list'
# text = requests.get(url).text
# print(text)
# # <tr>
# # 					<th scope="row">식단</th>
# # 					<td class="ta_l">
# # 						영양닭죽 13.15.
# # 깻잎김치 5.6.13.
# # 나박김치 9.13
# # 모닝빵샌드위치.6.10.12.13.
# # 배
# # 					</td>
# # 				</tr>
# arr = re.findall('<th scope="row">식단</th>.+?<td class="ta_l">(.+?)</td>', text,re.DOTALL)
# r= arr[0].strip()
# print(r)

print('----------------------------')
print('상인초등학교 급식메뉴')
url = 'http://sangin.es.kr/lunch.view?date=20191001'
text = requests.get(url).text
# <a href="/hosts/sangin-es/files/lunch/20191001_2.gif" rel="lightbox1"><img src="/hosts/sangin-es/files/lunch/20191001_2.gif_120" alt="중식 사진 이미지 입니다." width="120px" height="80px" /></a><span>조각콩밥 5.<br />
# 감자미역국 5.6.<br />
# 고등어무조림 5.6.7.<br />
# 시금치무침 <br />
# ㆍ배추김치 9.<br />
# 초코롤케&amp;#51084; 1.2.5.6.13.<br />
#  </span>
print(text)