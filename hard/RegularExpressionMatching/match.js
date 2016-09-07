/* @param {string} s -> string
 *        {string} p -> pattern
 * @return {boolean}
 */
var isMatch = function(s, p) {
    /* M[i][j]: s[0...i-1] is match p[0...j-1]
     * M[0][0]: '' is match '' -> true
     * M[0][j]: '' is match p[0...j-1]
     */
    var sL = s.length,
        pL = p.length,
        M = [];
    for (var i = 0; i <= sL; i++) {
        M.push(new Array(pL + 1));
    }
    M[0][0] = true;
    /* M[0][j]: '' is match p[0...j-1]
     * M[0][j] = p[j-1] == '*' and M[0][j-2]
     */
    for (var j = 1; j <= pL; j++) {
        M[0][j] = false;
        if (p[j-1] === '*' &&
            (j>1 && M[0][j-2]))
                M[0][j] = true;
    }
    /* M[i][0]: s[0...i-1] is match ''
     * M[i][0] = false
     */
    for (var i=1; i<=sL; i++) {
        M[i][0] = false;
    }
    /* if p[j-1] == s[i-1] then M[i][j] = M[i-1][j-1]
     * if p[j-1] == '.'  then M[i][j] = M[i-1][j-1]
     * if p[j-1] == '*'  then
     *     if p[j-2] != s[i-1] and p[j-2] != '.'  // empty
     *         then M[i][j] = M[i][j-2]
     *     if p[j-2] == s[i-1] or  p[j-2] == '.'  // empty, single, multiple
     *         then M[i][j] = M[i][j-2] || M[i][j-1] || M[i-1][j]
     */
    for (var i=1; i<=sL; i++) {
        for (var j=1; j<=pL; j++) {
            if (p[j-1] === s[i-1] || p[j-1] === '.') {
                M[i][j] = M[i-1][j-1];
            } else if (p[j-1] === '*') {
                if (p[j-2] !== s[i-1] && p[j-2] !== '.') {
                    M[i][j] = M[i][j-2];
                } else {
                    M[i][j] = M[i][j-2] || M[i][j-1] || M[i-1][j];
                }
            } else {
                M[i][j] = false;
            }
        }
    }
    console.info('-------------------');
    console.info('  s:' + s + ',p:' + p);
    console.info('  M[][]:' + JSON.stringify(M));
    return M[sL][pL];
};

module.exports = isMatch;
