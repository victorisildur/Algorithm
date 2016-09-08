/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    if (!s || s.length === 0)
	return 0;
    /* find longest substring starting at each i
     */
    var i = 0,
	j = 1,
	len = s.length,
	max = 1,
	set = {};
    set[s[i]] = true;
    while (i < len && j < len) {
	if (!set[s[j]]) {
	    max = Math.max(max, j-i+1);
	    set[s[j]] = true;
	    j++;
	} else {
	    set[s[i]] = false;
	    i++;
	}
    }
    return max;
};

module.exports = lengthOfLongestSubstring;
