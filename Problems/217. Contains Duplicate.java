/**
 * 
 * Time complexity : O(n). We do search() and insert() for nn times and each operation takes constant time.
 * Space complexity : O(n). The space used by a hash table is linear with the number of elements in it.
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers =new HashSet<>();
        for (int num : nums){
            if (numbers.contains(num)){
                return true;
            }
            numbers.add(num);
        }
        return false;
    }
}