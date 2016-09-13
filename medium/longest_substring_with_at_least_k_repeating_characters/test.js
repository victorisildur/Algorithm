var expect = require('expect'),
    longest = require('./longest');

expect(
    longest('aaabb', 2)
).toEqual(5);

expect(
    longest('aaabb', 3)
).toEqual(3);

expect(
    longest('abbcdd', 2)
).toEqual(2);

expect(
    longest('abbadd', 2)
).toEqual(6);

expect(
    longest('abbadc', 2)
).toEqual(4);

expect(
    longest('abcdefgh', 1)
).toEqual(8);


console.info('tests passed');
