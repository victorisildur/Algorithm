/*
 * 出现次数最多的数字之和
 */
function most (str) {
    if (!str || str.length === 0) {
        return 0;
    }
    var num = '',
        nums = {},  // {num: numShowTimes}
        maxTime = 0;
    // 有可能有多个num都出现了maxTime次，故不保存maxNum
    for (var i = 0; i<str.length; i++) {
        var char = str[i];
        if (/\d/.test(char)) {
            num += char;
        } else {
            if (num.length > 0) {
                console.info(' got num:' + num);
                if (nums[num]) {
                    nums[num] = nums[num] + 1;
                } else {
                    nums[num] = 1;
                }
                maxTime = Math.max(maxTime, nums[num]);
            }
            num = '';
        }
    }
    var maxNum = 0;
    for (var val in nums) {
        if (nums[val] === maxTime) {
            maxNum = Math.max(maxNum, val);
        }
    }
    console.info('nums:' + JSON.stringify(nums));
    console.info('maxNum:' + maxNum + ',maxTime:' + maxTime);
    return maxTime * maxNum;
};

module.exports = most;
