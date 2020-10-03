class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];
        return isMatchSubtring(s,p,0,0);
    }
    
    public boolean isMatchSubtring(String s, String p,int sStart, int pStart){
        if(sStart == s.length() && pStart == p.length()){
            return true;
        }else if(sStart == s.length() && pStart < p.length()){
            while(pStart<p.length()-1){
                if(p.charAt(pStart+1)=='*'){
                    pStart=pStart+2;
                }else{
                    break;
                }
            }
            if(pStart == p.length()){
                return true;
            }else{
                return false;
            }
        }else if(pStart == p.length() && sStart < s.length()){
            return false;
        }
        
        if(dp[sStart][pStart]!=null){
            return dp[sStart][pStart];
        }
        
        int i=sStart;
        if(pStart < p.length()-1 && '*'==p.charAt(pStart+1)){
            if(s.charAt(i)!=p.charAt(pStart)){
                if('.' == p.charAt(pStart)){
                    if(!isMatchSubtring(s , p ,i , pStart+2)){
                        if(pStart+2 < p.length()){
                            int l = i;
                            while(l< s.length()){
                                boolean found = isMatchSubtring(s , p , l+1 , pStart+2);
                                if(!found){
                                    l++;
                                }else{
                                    dp[l+1][pStart+2] = true;
                                    return true;
                                }
                            } 
                        }else{
                            return true;
                        }  
                    }else{
                        dp[i][pStart+2]= true;
                        return true;
                    }
                }else{
                    boolean b1 = isMatchSubtring(s , p , i , pStart+2);
                    dp[i][pStart+2]= b1;
                    return b1;
                }
            }else{
                    if(!isMatchSubtring(s , p ,i , pStart+2)){
                        int j = i;
                        while(j < s.length() && ( s.charAt(j)==p.charAt(pStart) || '.'==p.charAt(pStart))){
                            j++;
                        }
                        boolean match = isMatchSubtring(s , p ,j , pStart+2);
                        if(!match){
                            pStart= pStart+2;
                            boolean b2 = isMatchSubtring(s , p ,j-1 ,pStart);
                            dp[j-1][pStart] = b2;
                            return b2;
                        }else{
                            dp[j][pStart+2] = true;
                            return true; 
                        }    
                    }else{
                        dp[i][pStart+2] = true;
                        return true;
                    }
            }
        }else if(s.charAt(i)==p.charAt(pStart) || '.'==p.charAt(pStart)){
            boolean match = isMatchSubtring(s , p , i+1 , pStart+1);
            dp[i+1][pStart+1] = match;
            return match;
        }
        return false;
    }
}