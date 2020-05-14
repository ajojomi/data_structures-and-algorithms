class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) { //escape duplicates
                int j = i + 1, k = len - 1, sum = nums[i] * -1;
                while(j < k) {
                    if(nums[j] + nums[k] == sum) {
                        res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                        //escape duplicates
                        while(j < k && nums[j] == nums[j - 1]) j++;
                        while(j < k && nums[k] == nums[k + 1]) k--;
                    } 
                    else if (nums[j] + nums[k] < sum) j++;
                    else k--;
                }
            }
        }
        return res;
    }
}