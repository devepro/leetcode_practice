class Solution {
    
    /** 
        Logic : 
        1. Find prefix with help of exp int
        2. Based on the prefix use array and exp to determine the Roman numeral
        3. Substract as we are doing a top down approach
        
        // other method -- we can also go bottom to top by using % function.
        Main Logic is below:
        No dependence or use of a lot of if else conditions
        Tricky at line no 45.. Use of exp .. Math.pow needs int conversion
        
        if prefix < 4 -- i wala * prefix
        prefix == 4 -- "i" and i+1
        prefix ==5 -- "i+1"
        prefix > 6 and < 9-- "i+1" and "i"*prefix
        prefix ==9 -- i and "i+2" 
    **/
    public String intToRoman(int num) {
        String s = "";
        int exp = 3;    
        while(exp>=0){
            int prefix = num/ ((int)Math.pow(10,exp));
            if(prefix>0){    
                s = s.concat(getRoman(prefix,exp));
                num = num - prefix*((int)Math.pow(10,exp));
            }
               
            exp--;
        }
            
        return s;
    }
    
    public String getRoman(int prefix, int exp){
        String[] set = {"I","V","X","L","C","D","M"};
        int rIndex = exp * 2;
        String s = "";
        if(prefix < 4 ){
            while(prefix>0){ 
               s = s.concat(set[rIndex]);
               prefix--;
            }
        }else if(prefix == 4){
             s = s.concat(set[rIndex]);
             s = s.concat(set[rIndex+1]);
        }else if(prefix == 5){
            s = s.concat(set[rIndex+1]);
        }else if(prefix < 9){
            s = s.concat(set[rIndex+1]);
            while(prefix>5){ 
               s = s.concat(set[rIndex]);
               prefix--;
            }
        }else if(prefix == 9){
            s = s.concat(set[rIndex]);
            s = s.concat(set[rIndex+2]);
        }
        return s;
    }

}


/**
 * 
 * Perfect solution :----
 * 
 * class Solution {
    // use the restrictions carefully and implement.
    // time and space complexity ????
    
    public String intToRoman(int num) {
        int arabs[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arabs.length; i++) {
            while (num >= arabs[i]) {
                sb.append(romans[i]);
                num -= arabs[i];
            }
        }
        
        return sb.toString();
    }
}
 * 
 * 
 * 
 * 
 */