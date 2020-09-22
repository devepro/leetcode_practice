class Solution {
    public int reverse(int x) {
        int num = x;
        int ans=0;
        while(num!=0){
            int pop = (num%10);
            num = num/10;
             if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            ans = ans*10+ pop;
        }
        return ans;
    }
}