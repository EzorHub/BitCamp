# collection:
#   set, list, map - 자바의 collection
#   list(script배열, 자바list), tuple(list의 상수버전), set, dictionary(==java의 map)
#   []                           ()                  {}      {}

a = [1,3,5,7,3]
print(a)
print( type(a) ) #값 변경d

b = (1,3,5,7,3)
print(b)
print( type(b) ) #값 변경x


print(a[0])
print(b[0])

a[0] = 100
b[0] = 100
print(a[0])
print(b[0])


c = {1,3,5,7,3}
print(c)
print( type(c) ) #중복허용x
