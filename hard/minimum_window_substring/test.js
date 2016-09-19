var expect = require('expect'),
    min = require('./min');

expect(
    min('ADOBEFCODEBANC', 'ABC')
).toEqual('BANC');

expect(
    min('ADOBEFCODEBAN', 'ABCD')
).toEqual('CODEBA');

expect(
    min('ABCDEFG', 'A')
).toEqual('A');

expect(
    min('ABCD', '')
).toEqual('');

expect(
    min('ABCD', 'EFG')
).toEqual('');

expect(
    min('AAAAAAAAA', 'A')
).toEqual('A');

console.log('tests passed');
