class Solution {
    public int romanToInt(String s) {
        /**
        *   MCMXCIV
        *   M +1000
            C  100
            M  1000
            X  10
            C  100
            I  1
            V  5
            
            Approach : 1.go on adding the values on the basis of detected char
            2.only reduce prev added value if prev> current
            Time complexity = O(n)
            space complexity = 1
            

            Other approaches include: use of if statements to add and then contains to substact twice 
            example if s.contains(IX) then ans = ans - 2;
        */
        
        int ans = 0;
        for ( int i = 0 ; i< s.length() ; i++){
            if (i > 0 && c2n(s.charAt(i)) > c2n(s.charAt(i - 1))) {
                ans = ans + (c2n(s.charAt(i))- (2*c2n(s.charAt(i-1))));
            }else{
                ans = ans + c2n(s.charAt(i));
            }           
        }
        return ans;
    }
    
    public int c2n(char c) {  
            switch(c) {  
                case 'I': return 1;  
                case 'V': return 5;  
                case 'X': return 10;  
                case 'L': return 50;  
                case 'C': return 100;  
                case 'D': return 500;  
                case 'M': return 1000;  
                default: return 0;  
            }
        } 
}