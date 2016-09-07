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
    console.log('  s:' + s + ',l:' + l);
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
	    if (s[i] === '(' &&
		s[j] === ')' &&
		P[i+1][j-1]
	       ) {
		P[i][j] = true;
		max = Math.max(max, j-i+1);
	    }
	    /* d = 2^k - 1, k = 2,3,...logL
	     * d + 1 = 2        2^k - 2
	     *         4        2^k - 4
	     *         6        2^k - 6
	     *         ...
	     *         2^k - 2  2
	     * in total 2^(k-1)-1 = (d-1)/2 combination
	     * we can enumerate them to see if there is P(t) and P(s) comb
	     * or P(t) xor P(s) comb
	     */
	    for (var m = 1; m <= (d-1) / 2; m++) {
		var mid = i + m*2 - 1,
		    Ps = P[i][mid],
		    Pt = P[mid+1][j];
		if (Ps && Pt) {
		    P[i][j] = true;
		    max = Math.max(max, j-i+1);
		    break;
		} else if (Ps !== Pt) {
		    P[i][j] = false;
		    break;
		} else {
		    continue;
		}
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
