var twoSum = function(nums, target) {
    var saved={};
    var result=[];
    for(i=0; i< nums.length; i++) {
        var val = nums[i];
        if(saved.hasOwnProperty(val)) {
            result[0] = saved[val];
            result[1] = i;
            return result;
        }
        saved[target - val] = i;
    }
    return null;
};

module.exports = twoSum;
