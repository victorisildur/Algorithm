/*
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    var l = s.length,
        P = new Array(l),
        max = 0;
    for (var i=0; i<l; i++) {
        P[i] = new Array(l);
    }
    console.log('-------------');
    console.log('  s:' + s + ' ,l:' + l);
    /* P[i][j]:   s[i...j] is good parenthesis, 0<=i<j<l
     * P[k][k]:   s[k] -> false
     * P[k+1][k]: empty char -> true
     * P[k][k+1]: s[k] === '(' && s[k] === ')'
     */
    for (var i=0; i<l; i++) {
        for (var j=0; j<l; j++) {
            if (i===j) {
                P[i][j] = false;
            } else if (i===j-1) {
                P[i][j] = s[i] === '(' && s[j] === ')';
                if (P[i][i+1]) max = 2;
            } else {
                P[i][j] = false;
            }
        }
    }
    if (l < 4) return max;

    /* So far we got P[i][j] where j-i = d = {0,1}
     * Next we will calc P[i][j] where d = {3, 5, 7...}
     *
     * iff P(s) and P(t) then P(st) = T
     * iff P(s) xor P(t) then P(st) = F
     * iff !P(s) and !P(t) can't tell
     */
    for (var d = 3; d < l; d = d + 2) {
        for (var i = 0; i + d < l; i++) {
            var j = i + d;
	    /* we only need to decrease the d by 2
	     * there are 3 possible ways:
	     * 1. ( ... )
	     * 2. () ...
	     * 3. ... ()
	     */
	    if ((s[i] === '(' && s[j] === ')' && P[i+1][j-1]) ||
		(P[i][i+1] && P[i+2][j]) ||
		(P[i][j-2] && P[j-1][j])
	       ) {
		P[i][j] = true;
		max = Math.max(max, j-i+1);
	    }
        }
    }
    console.info('whole P:');
    P.forEach(function(arr, i) {
        console.info('P['+i+']:\t' + arr.map(function(item) {
            return item ? 'T': 'F';
        }).join(' '));
    });
    return max;
};

module.exports = longestValidParentheses;
