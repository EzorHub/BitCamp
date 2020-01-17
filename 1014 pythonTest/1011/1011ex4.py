# a,b = 10,20
# print(a)
# print(b)

# a = 10,20
# print( type(a) )
# print(a)

#  큰수와 작은수를 한꺼번에 찾을 수 있음!


# n까지의 합과 팩토리얼구하기
def getSumFac(n):
    sum,r = 0,1
    for i in range(1,n+1):
        sum += i
        r *= i
    return sum, r

a,b = getSumFac(5)
#a = getSumFac(5) 몇개를 반환하는지 모를때!
print(a)
print(b)


# list를 매개변수로 전달받아
# 그중에 가장 큰 수, 가장 작은 수 , 총합, 평균을 구해
# 반환하는 함수를 만들고 호출해봅니다.

# 내 풀이
# def getCal(list):
#     for i in list:
#         if list[i] > list[i+1]:
#             max = list[i]
#         elif list[i] < list[i+1]:
#             min = list[i]
#     sum = sum(list)
#     avg = sum/len(list)
#     return max, min, sum, avg
#
#
# num = [1,3,5,7,9]
# re = getCal(num)
# print(re)
#

#선생님 풀이

def getInfo(arr):
    max, min, sum, avg = arr[0],arr[0],0,0
    for i in range(len(arr)): #arr의 길이까지 루프를 돌면서
        #in list 가 안먹힘....ㅠㅠ
        sum += arr[i]
        if arr[i] > max:
            max = arr[i]
        if arr[i] < min:
            min = arr[i]
    avg = sum / len(arr)
    return max, min, sum, avg

data = [6,2,3,9,8]
# max,min,sum,avg = getInfo(data)
# print(max,min,sum,avg)

r = getInfo(data)
print(r)
