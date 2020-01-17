f = open('../Data/song.txt','r',encoding='utf-8')

lines = f.readlines()
print(lines)
for line in lines:
    print(line.strip())