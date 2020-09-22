class Solution {
    public int myAtoi(String str) {
        int n = str.length();
        int i = 0;
        int sign = 1;
        int num = 0;
        if(n==0){ return 0;}
        while(i< str.length() && str.charAt(i)==' '){
            i++;
        }
       
        if(i < str.length() && (str.charAt(i)=='+' || str.charAt(i)=='-')){
            sign = str.charAt(i)=='-'?-1:1;
            i++;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
          
                 if (num > Integer.MAX_VALUE / 10 ||
                    (num == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                num = num*10 + str.charAt(i) - '0';
                i++;
        }
        
        return num*sign;
    }
}