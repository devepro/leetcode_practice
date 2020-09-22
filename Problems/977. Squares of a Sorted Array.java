class Solution {
    public int[] sortedSquares(int[] A) {
        int[] c = new int[A.length];
        int[] b = new int[A.length];
        int i = 0;
        int j = -1;
        for(int a : A){
            if(a<0){
               j++; 
               c[j] = (a*a); 
            }else{
                while(j>=0 && c[j] < a*a){
                    b[i++] = c[j];
                    j--;
                }
                b[i] = a*a;
                i++;
            }
        }
        
        while(j>=0){
           b[i++] = c[j];
           j--; 
        }
        return b;
    }
}

