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
            } else if (i===j+1) {
                P[i][j] = true;
            } else if (i===j-1) {
                P[i][j] = s[i] === '(' && s[j] === ')';
                if (P[i][i+1]) max = 2;
            } else {
                P[i][j] = false;
            }
        }
    }
    if (l < 4) return max;

    /*
     * iff P(s) and P(t) then P(st) = T
     * iff P(s) xor P(t) then P(st) = F
     * iff !P(s) and !P(t) 
     *     then P(st) = P(s[1...]) and P(t[0...-1]) 
     *            and s[0] = '(' and t[-1] = ')'
     */
    for (var d=3; d<l; d = d + 2) {
        for (var i=0, j=i+d; i+d<l; i++) {
            j = i+d;
            var m1 = Math.floor((i+j)/2),
                m2 = Math.ceil((i+j)/2),
                lowerHalf = P[i][m1],
                higherHalf = P[m2][j];
            /* P(s[i..j]) -> P(s[i...m1]), P(s[m2...j])
             * Error: (())()
             */
            console.info(' i:' + i + ',j:' + j +
                         ',d:' + d +
                         ',m1:' + m1 + ',m2:' + m2 +
                         ',lowerHalf:' + lowerHalf +
                         ',higherHalf:' + higherHalf);
            if (lowerHalf & higherHalf) {
                // both good
                P[i][j] = true;
                max = Math.max(max, j-i+1);
            } else if (lowerHalf ^ higherHalf) {
                // one good, another bad
                P[i][j] = false;
            } else {
                // both bad
                if (j-i === 1) {
                    if (P[i][j])
                        max = Math.max(max, j-i+1);
                } else if (P[i+1][j-1] &&
                    s[i] === '(' && s[j] === ')') {
                    P[i][j] = true;
                    max = Math.max(max, j-i+1);
                } else {
                    P[i][j] = false;
                }
            }
            console.info(' P['+i+']['+j+']:' + P[i][j]);
        }
    }
    console.info('whole P:');
    P.forEach(function(arr, i) {
        console.info('P['+i+']:' + arr.map(function(item) {
            if (typeof item === 'undefined' || (null === item))
                return 'null';
            else
                return item;
        }).join('\t'));
    });
    return max;
};

module.exports = longestValidParentheses;
