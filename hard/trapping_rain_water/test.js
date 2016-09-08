var expect = require('expect');
var trap = require('./trap');

expect(
    trap([0,1,0,2,1,0,1,3,2,1,2,1])
).toEqual(6);

console.info('tests passed!');
