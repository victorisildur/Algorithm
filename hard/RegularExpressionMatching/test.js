var expect = require('expect'),
    match = require('./match');

expect(
    match('aa', 'a')
).toEqual(false);

expect(
    match('aa', 'aa')
).toEqual(true);

expect(
    match('aaa', 'aa')
).toEqual(false);

expect(
    match('aa', 'a*')
).toEqual(true);

expect(
    match('aa', '.*')
).toEqual(true);

expect(
    match('ab', '.*')
).toEqual(true);

expect(
    match('aab', '.*')
).toEqual(true);

expect(
    match('aab', 'c*a*b*')
).toEqual(true);

expect(
    match('ab', '.*c')
).toEqual(false);

expect(
    match('aaa', 'aaaa')
).toEqual(false);

expect(
    match('aaa', 'a.a')
).toEqual(true);

expect(
    match('aaa', 'a*a')
).toEqual(true);

console.info('pass tests!');
