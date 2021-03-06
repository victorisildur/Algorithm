var expect = require('expect'),
    longest = require('./longest2');

expect(
    longest('()()')
).toEqual(4);

expect(
    longest(')()()')
).toEqual(4);

expect(
    longest('()()(')
).toEqual(4);

expect(
    longest('()(()')
).toEqual(2);

expect(
    longest('(()()')
).toEqual(4);

expect(
    longest('(')
).toEqual(0);

expect(
    longest('')
).toEqual(0);

expect(
    longest('(()())')
).toEqual(6);

expect(
    longest('(())()')
).toEqual(6);

expect(
    longest('"((()))())"')
).toEqual(8);

console.info('pass tests');
