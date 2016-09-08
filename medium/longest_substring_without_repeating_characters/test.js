var expect = require('expect'),
    longest = require('./longest');

expect(
    longest('abcabcbb')
).toEqual(3);

expect(
    longest('bbbbb')
).toEqual(1);

expect(
    longest('pwwkew')
).toEqual(3);

console.info('tests passed');
