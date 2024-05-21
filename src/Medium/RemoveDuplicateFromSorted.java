package Medium;

public class RemoveDuplicateFromSorted {
    public int removeDuplicates(int[] nums) {
        int countKey = 1, key = nums[0], j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == key && countKey == 1){
                nums[j++] = key; countKey++;
            } else if (nums[i] != key) {
                nums[j++] = nums[i]; key = nums[i]; countKey = 1;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        new RemoveDuplicateFromSorted().removeDuplicates(new int []{0,0,1,1,1,1,2,3,3});
    }
}
