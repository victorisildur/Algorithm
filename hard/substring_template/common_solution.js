var substr = function(s) {
    var map = {}, //hash map
        i = 0, j = 0, // two pointer
        counter = 0,  // valid condition
        d = 0;        // substring length

    for (var c in s) {
        // init map
    }
    while (j < s.length) {
        // increase j
        judge(s[j++]);
        update(map);
        while (counter === 0) {
            // update d
            d = Math.max(d, j-i+1);
            // increase i
            judge(s[i++]);
            update(map);
            // util counter is broken
            if (something) {
                counter ++;
            }
        }
    }
    return d;
};
