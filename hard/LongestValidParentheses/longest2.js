/*
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    var l = s.length,
        P = new Array(l),
	badP = [];
    /* instead of using P[i][j] to represent if s[i...j] is a good paren or not
     * we can use P[i] to represent if s[i] is inside a good paren
     * like:
     * s: ()()((
     * P: 111100
     */
    for (var i=0; i<l; ) {
	if (i<l-1 && s[i] === '(' && s[i+1] === ')') {
	    // ... ()
	    P[i] = P[i+1] = true;
	    i = i + 2;
	} else if (s[i] === ')' &&
		   badP.length > 0 &&
		   s[badP[badP.length-1]] === '('
		  ) {
	    // ( ... )
	    P[i] = P[badP[badP.length-1]] = true;
	    badP.splice(-1, 1); //remove last bad P
	    i = i + 1;
	} else {
	    P[i] = false;
	    badP.push(i);
	    i = i + 1;
	}
    }
    var cnt = 0,
	max = 0;
    for (var i=0; i<l; i++) {
	if (P[i]) {
	    cnt++;
	    max = Math.max(max, cnt);
	} else {
	    cnt = 0;
	}
    }
    return max;
}

module.exports = longestValidParentheses;
