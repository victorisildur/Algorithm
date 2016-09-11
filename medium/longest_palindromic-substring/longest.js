/* extend palindrome, start at i,j
 */
var extendPalindrome = function(s, i, j) {
    while (i >= 0 && j < s.length &&
	   s[i] === s[j]
	  ) {
	i--;
	j++;
    }
    return {
	start: i+1,
	end: j-1,
	len: Math.max(j-i-1, 0)
    };
}

/**
 * @param {string} s
 * @return {string}
 * palindrome has no dynamic property!
 * can only be extended from center to both sides..
 */
var longestPalindrome = function(s) {
    var l = s.length,
	max = {start: 0, end: 0, len: 0};
    if (l < 2) 
	return s;
    for (var i = 0; i<l; i++) {
	var ext1 = extendPalindrome(s, i, i);
	var ext2 = extendPalindrome(s, i, i+1);
	var ext = ext1.len > ext2.len ? ext1 : ext2;
	if (ext.len > max.len) {
	    max = ext;
	}
    }
    return s.slice(max.start, max.end+1);
};

module.exports = longestPalindrome;
