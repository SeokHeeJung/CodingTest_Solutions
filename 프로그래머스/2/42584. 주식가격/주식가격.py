def solution(prices):
    answer = []
    for i in range(0, len(prices) -1) :
        sec = 0
        for j in range (i + 1, len(prices)) :
            sec += 1
            if (prices[i] <= prices[j]) :
                continue
            else :
                break
        answer.append(sec)
    answer.append(0)
    return answer