r = r[0].strip()
#
f = open('../Data/todayMenu.txt','w',encoding='utf-8')
f.write(r)
f.close()

print('오늘의 메뉴를 수집완료')