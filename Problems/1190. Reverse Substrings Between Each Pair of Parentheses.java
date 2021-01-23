/**
 * 
 * Time complexity O(n)
 * Space complexity O(paranthesis)
 */
class Solution {
    public String reverseParentheses(String s) {
        Map<Integer, Integer> map = new HashMap();
        
        Stack<Integer> stack = new Stack();
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length ; i++){
            if(ch[i]=='('){
                stack.push(i);
            }else if(ch[i]==')'){
                int pos = stack.pop();   
                map.put(pos, i);
                map.put(i, pos);
            }
        }
        
        int dir = 0;
        int ptr = 0;
        String res = "";
        while(ptr<ch.length){
            if(ch[ptr]=='(' && dir == 0){
                ptr = map.get(ptr)-1;
                dir = 1;
            }else if(ch[ptr]==')' && dir == 0){
                ptr = map.get(ptr)-1;
                dir = 1;
            }else if(ch[ptr]=='(' && dir == 1){
                ptr = map.get(ptr)+1;
                dir = 0;
            }else if(ch[ptr]==')' && dir == 1){
                ptr = map.get(ptr)+1;
                dir = 0;
            }else{
                res = res + ch[ptr];
                ptr = dir==0? ptr+1: ptr-1;
            }
        }
        
        return res;
    }
}