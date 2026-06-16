# PROCESS STRING WITH SPECIAL OPERATIONS->https://leetcode.com/problems/process-string-with-special-operations-i/description/?envType=daily-question&envId=2026-06-16

# COMPLEXITY=O(n)  FOR WORST CASE=O(n^2)

class Solution:
    def processStr(self, s: str) -> str:
        

        container=list(s)
        res=""
        

        for i in range(len(container)):
            n=len(res)
            if container[i]=='#':
                res+=res

            elif container[i]=='%':
                res=res[::-1]

            elif container[i]=='*':
                if(len(res)!=0):
                    res = res[:n-1]
                 
            else:
                res+=container[i]

        return res


