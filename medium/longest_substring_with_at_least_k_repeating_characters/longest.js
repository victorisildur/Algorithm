var longest = function(s, k) {
    console.info(' enter s:' + s);
    var len = s.length;
    if (len < k) {
        return 0;
    }
    var set = {};
    for (var i=0; i<len; i++) {
        var char = s[i];
        !set[char] ? set[char] = 1 : set[char] ++;
    }

    // search a too few char, divide by removing it
    for (var i=0; i<len; i++) {
        var char = s[i];
        if (set[char] < k) {
            var left = longest(s.slice(0, i), k),
                right = longest(s.slice(i+1, len), k);
            return Math.max(left, right);
        }
    }
    return len;
};

/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var longestSubstring = function(s, k) {
    console.info('------------');
    var len  = s.length;
    if (k < 2) 
        return len;
    if (len < k)
        return 0;
    return longest(s, k);
};

module.exports = longestSubstring;
