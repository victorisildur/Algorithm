var expect = require('expect'),
    longest = require('./longest');

expect(
    longest('12asasasabb')
).toEqual('asasasa');

expect(
    longest('12bb')
).toEqual('bb');

expect(
    longest('b')
).toEqual('b');

expect(
    longest('')
).toEqual('');

expect(
    longest('12asabbsasabb')
).toEqual('asa');

console.info('tests passed');
