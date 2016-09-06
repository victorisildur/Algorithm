var expect = require('expect'),
    twoSum = require('./solution');

expect(
    twoSum([1, 2, 3], 4)
).toEqual([0, 2]);

expect(
    twoSum([2, 5, 3], 8)
).toEqual([1, 2]);

expect(
    twoSum([3, 2, 4], 6)
).toEqual([1, 2]);

expect(
    twoSum([0, 3, 2, 0], 0)
).toEqual([0, 3]);

console.info('two sum tests passed!');
