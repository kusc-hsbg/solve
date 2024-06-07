S = input().strip()
positions = [-1] * 26
for index, char in enumerate(S):
    pos = ord(char) - ord('a')
    if positions[pos] == -1: 
        positions[pos] = index
print(' '.join(map(str, positions)))
