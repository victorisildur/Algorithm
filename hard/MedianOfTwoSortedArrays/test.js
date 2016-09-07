var expect = require('expect'),
    find = require('./find_median');

expect(
    find([1, 3], [2])
).toEqual(2.0);

expect(
    find([1, 2], [3, 4])
).toEqual(2.5);

expect(
    find([1], [1])
).toEqual(1.0);

expect(
    find([1,2,3,4,5], [2,3,4,5,6])
).toEqual(3.0);

console.info('pass tests');
