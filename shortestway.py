#Time: O(mn) where m is len of S and N is len of T
#Space:O(1)
# Locked on leetcode

def shortestway(S, T):
    Slen = len(S)
    Tlen = len(T)

    SP = 0 # pointer for S
    TP = 0 # pointer for T
    result = 0


    while(TP< Tlen):
        SP=0
        result+=1
        curr = TP
        while(SP< Slen and TP< Tlen):
            if S[SP] == T[TP]: # if both character matches then we move both the pointers ahed
                SP+=1
                TP+=1
               
            else: # if no match we move the SP pointer ahead
                SP+=1
        if curr == TP: # if the character is not present in source then return -1
            return -1
    return result

output = shortestway(S= 'abc', T = 'abdbc')
print(output)

