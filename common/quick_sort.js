var swap = function(arr, i, j) {
    var tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
};

/* @func: quick sort
 * @param {number[]} arr
 * @return {number[]}
 */
var quickSort = function(array) {
    if (array.length <= 1) {
        return array;
    }
    if (array.length === 2) {
        return array[0] > array[1] ? [array[1], array[0]] : array;
    }
    var arr = array.map(function(item) {return item;});
    // arr.length >= 3
    var val = arr[0];
    for (var i = 1, j = arr.length - 1; i <= j;) {
        if (arr[i] < val) {
            // search a bigger val
            i ++;
            continue;
        } else {
            // reversely search a smaller val
            if (arr[j] > val) {
                j--;
                continue;
            } else {
                swap(arr, i++, j--);
            }
        }
    }
    // arr[1...i-1] < val, arr[j+1 ... len-1] > val
    var beginHalf = quickSort(arr.slice(1, i)),
        endHalf = quickSort(arr.slice(j+1, arr.length));
    return beginHalf.concat(val).concat(endHalf);
};

module.exports = quickSort;
