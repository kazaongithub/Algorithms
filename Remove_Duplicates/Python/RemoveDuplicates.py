import sys

def remove_duplicates_adhoc(ele_list):
    for i in range(len(ele_list)):
        for j in range(i + 1, len(ele_list)):
            if ele_list[i] == ele_list[j]:
                ele_list[j] = sys.maxsize

    dist_list = []
    for i in range(len(ele_list)):
        if ele_list[i] != sys.maxsize:
            dist_list.append(ele_list[i])

    print(*ele_list)
    print(*dist_list)

remove_duplicates_adhoc([10, 10, 20, 20, 20, 30, 40, 50])
