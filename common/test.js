var sort = require('./quick_sort');
var expect = require('expect');

expect(
    sort([])
).toEqual([]);

expect(
    sort([1])
).toEqual([1]);

expect(
    sort([2, 1])
).toEqual([1, 2]);

expect(
    sort([34, -111, 1])
).toEqual([-111, 1, 34]);

expect(
    sort([5,4,3,6,1,2,7,8,9,0,-1,-2])
).toEqual([-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]);

expect(
    sort([3, 2, 4])
).toEqual([2, 3, 4]);

expect(
    sort([0, 3, 2, 0])
).toEqual([0, 0, 2, 3]);

console.info('quick sort tests passed!');
