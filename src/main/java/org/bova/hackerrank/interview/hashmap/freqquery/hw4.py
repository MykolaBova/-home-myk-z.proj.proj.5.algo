
// https://www.jianshu.com/p/00748d283521
def freqQuery(queries):
    count_dic = {}
    freq_dic = {}
    for case, data in queries:
        if case == 1:
            count = count_dic.setdefault(data, 0)
            freq = freq_dic.setdefault(count, 1)
            count_dic[data] += 1
            freq_dic.setdefault(count+1, 0)
            freq_dic[count+1] += 1
            freq_dic[count] -= 1
        elif case == 2:
            count = count_dic.setdefault(data, 0)
            freq = freq_dic.setdefault(count, 1)
            if count > 0:
                count_dic[data] -= 1
                freq_dic.setdefault(count-1, 0)
                freq_dic[count-1] += 1
                freq_dic[count] -= 1
        else:
            yield 1 if freq_dic.get(data, 0) > 0 else 0
