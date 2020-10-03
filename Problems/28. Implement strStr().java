class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        for(int i = 0; i< haystack.length() ; i++){
            int nstart = 0;
            int hstart = i;
            while(nstart < needle.length() && hstart < haystack.length() && haystack.charAt(hstart)==needle.charAt(nstart)  )             {
                nstart++;
                hstart++;
            }
            if(nstart==needle.length()){
                return i;
            }
        }
        return -1;
    }
}