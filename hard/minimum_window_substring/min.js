/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    var sL = s.length,
        tL = t.length,
        map = {};
    if (sL < tL)
        return '';
    if (tL === 0 || sL === 0)
        return '';
    // char number map for t
    for (var i=0; i<tL; i++) {
        if (!map[t[i]]) {
            map[t[i]] = 1;
        } else {
            map[t[i]]++;
        }
    }
    // map[c]: c in t - c in s
    var i = 0,
        j = 0,
        counter = tL, // substr cond
        head = 0,     // substr head
        d = Number.MAX_SAFE_INTEGER; // substr length
    while (j<sL) {
        // expand right
        if (map.hasOwnProperty(s[j]) && map[s[j]]-- > 0) {
            // s[j] in t
            counter --;
        }
        j ++;
        // console.log('a. (i,j): (' + i + ',' + j + '), counter:' + counter + ',map:' + JSON.stringify(map));
        // shrink left
        while(counter === 0 && i < j) {  // valid
            if (j-i < d) {
                d = j-i;
                head = i;
            }
            if (map.hasOwnProperty(s[i]) && map[s[i]]++ === 0) {
                counter ++;  // invalid
            }
            i ++;
            // console.log('b. (i,j): (' + i + ',' + j + '), counter:' + counter + ',map:' + JSON.stringify(map));
        }
    }
    return d === Number.MAX_SAFE_INTEGER ? '' : s.slice(head, head + d);
};

module.exports = minWindow;
