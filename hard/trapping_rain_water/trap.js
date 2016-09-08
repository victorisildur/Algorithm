/* @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    var h = height,
        leftMax = 0,
        rightMax = 0,
        i = 0,
        j = h.length - 1,
        water = 0;
    while(i<j) {
        leftMax = Math.max(leftMax, h[i]);
        rightMax = Math.max(rightMax, h[j]);
        if (leftMax < rightMax) {
            water += leftMax - h[i];
            i++;
        } else {
            water += rightMax - h[j];
            j--;
        }
    }
    return water;
};

module.exports = trap;
