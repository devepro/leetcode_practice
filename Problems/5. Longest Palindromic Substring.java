class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans= n>0?s.substring(0,1):"";
        int i = 0;
        for(i = 0 ; i < n ; i++){
            int k = i;
            int j = i+1;
            String subs="";
            if(j<n && s.charAt(k)==s.charAt(j)){
                while(k>=0 && j<n){
                   if(s.charAt(k)==s.charAt(j)){
                       subs = s.substring(k,j+1);
                       k--;
                       j++;
                   }else{ 
                        break;
                   }
                }
                if(ans.length()<subs.length()){
                           ans = subs;
                }
            }
            k = i-1;
            j = i+1;
            subs = "";
            if( (k)>=0 && j<n && (s.charAt(k)==s.charAt(j))){
                while(k>=0 && j<n){
                   if(s.charAt(k)==s.charAt(j)){
                       subs = s.substring(k,j+1);
                       k--;
                       j++;
                   }else{ 
                        break;
                   }
                }
                if(ans.length()<subs.length()){
                           ans = subs;
                }
            }
            
        }
        return ans;
    }
}