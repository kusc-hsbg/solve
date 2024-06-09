from collections import deque
import sys

input = sys.stdin.read

def ac_program(p, n, arr):
    deq = deque(arr)
    reverse = False

    try:
        for cmd in p:
            if cmd == 'R':
                reverse = not reverse
            elif cmd == 'D':
                if not deq:
                    return "error"
                if reverse:
                    deq.pop()
                else:
                    deq.popleft()
    except IndexError:
        return "error"

    if reverse:
        deq.reverse()

    return '[' + ','.join(map(str, deq)) + ']'


def main():
    data = input().strip().split()
    index = 0
    t = int(data[index])
    index += 1
    results = []

    for _ in range(t):
        p = data[index]
        index += 1
        n = int(data[index])
        index += 1
        if n == 0:
            arr = []
            index += 1
        else:
            arr = list(map(int, data[index][1:-1].split(',')))
            index += 1
        results.append(ac_program(p, n, arr))

    for result in results:
        print(result)


if __name__ == "__main__":
    main()
