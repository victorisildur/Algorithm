/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var longestSubstring = function(s, k) {
    var len  = s.length;
    if (k < 2) 
        return len;
    var max = 0;
    for (var i=0; i<len; i++) {
        // brutal, search through s[i...]
        var set = {};
        for (var j=i; j<len; j++) {
            var char = s[j];
            if (!set[char]) {
                set[char] = 1;
            } else {
                set[char] ++;
            }
            var validSubstr = true;
            for (var key in set) {
                if (set[key] < k) {
                    validSubstr = false;
                    break;
                }
            }
            if (validSubstr)
                max = Math.max(max, j-i+1);
        }
    }
    return max;
};

module.exports = longestSubstring;
