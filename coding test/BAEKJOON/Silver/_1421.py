def max_profit(N, C, W, lengths):
    max_length = max(lengths)
    max_profit = 0
    
    for L in range(1, max_length + 1):
        total_profit = 0
        
        for length in lengths:
            num_pieces = length // L
            num_cuts = num_pieces - 1 if num_pieces > 0 else 0
            
            if num_pieces > 0 and length % L != 0:
                num_cuts += 1
            
            profit = num_pieces * L * W
            cost = num_cuts * C
            
            if profit > cost:
                total_profit += (profit - cost)
        
        max_profit = max(max_profit, total_profit)
    
    return max_profit

N, C, W = map(int, input().split())
lengths = [int(input()) for _ in range(N)]

result = max_profit(N, C, W, lengths)
print(result)
