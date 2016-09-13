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

// TLE
expect(
    longest('aaaaaaaaaaaaaaaaaaaa', 20)
).toEqual(20);

// TLE
expect(
    longest('abcdefghijklmnopqrstuvwxyz', 2)
).toEqual(0);


// TLE
expect(
    longest('aaabbbcdefcdefgggggggggggggggcde', 3)
).toEqual(15);

// wrong answer
expect(
    longest('ababacb', 3)
).toEqual(0);


console.info('tests passed');
