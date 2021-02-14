# returns True if string is balanced
def isBalanced(s):
    for i in range(len(s)):
        if s[i].islower() and s[i].upper() not in s:
            return False
        if s[i].isupper() and s[i].lower() not in s:
            return False
    return True


# returns minimum
def solution(s):
    minimum = len(s)
    isFoundMin = False
    for i in range(len(s)+1):
        for j in range(i+1, len(s)+1):
            if isBalanced(s[i:j]) and minimum >= j-i:
                minimum = j-i
                isFoundMin = True
    if isFoundMin:
        return minimum
    return -1


print(solution('azABaabza'))
print(solution('TocoCat'))
print(solution('AcZCbaBz'))
print(solution('abcdefghijklmnopqrstuvwxyz'))
