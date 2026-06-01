# LARGEST ODD NUMBER IN STRING->https://leetcode.com/problems/largest-odd-number-in-string/description/
# COMPLEXITY->O(n)

class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";        
    }
}


# REMOVE OUTERMOST PARENTHESIS->https://leetcode.com/problems/remove-outermost-parentheses/description/
# TIME COMPLEXITY=O(n) AND SPACE COMPLEXITY=

class Solution {
    public String removeOuterParentheses(String s) {
        
      int n = s.length();
      if(n<=2){
        return "";
      }

      StringBuilder result = new StringBuilder();
      int open = 0;

      for(char c :s.toCharArray()){
         if(c=='('){
            open++;
            if(open>1){
                result.append('(');
            }
         }

         else{
            if(open>1){
                result.append(')');
            }
            open--;
         }
      }

      return result.toString();
    }
}

# REVERSE THE STRING ->https://leetcode.com/problems/reverse-words-in-a-string/

# BETTER APPRAOCH
# COMPEXITY =O(n) , SPACE COMPEXITY=O(n)

class Solution {
    public String reverseWords(String s) {
        
         
        String [] sr = s.trim().split("\\s+");
        int n = sr.length;
        StringBuilder result = new StringBuilder();

        for(int i=n-1;i>=0;i--){
            
           result.append(sr[i]);
           if(i==0){
            continue;
           }
           result.append(" ");
           
        }

        return result.toString();
    }
}

# OPTIMAL APPRAOCH
# COMPEXITY =O(n)

class Solution:
    def reverseWords(self, s: str) -> str:

        sr=s.split()
        n=len(sr)

        result=[]

        for i in range(n-1,-1,-1):
            result.append(sr[i])
            if i==0:
                continue
            result.append(" ")


        return "".join(result)
        

# LONGEST COMMON PREFIX->https://leetcode.com/problems/longest-common-prefix/description/
# COMPLEXITY=O(n^2)


class Solution {
    public String longestCommonPrefix(String[] strs) {
        
     String s=strs[0];
     int n = s.length();

     for(int i=1;i<strs.length;i++){
        String sub=strs[i];

        while(n>0 && !sub.startsWith(s.substring(0,n))){
            n--;
        }

        if(n==0){
            return "";
        }
     }

     return s.substring(0,n);

    }
}
