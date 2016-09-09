var expect = require('expect'),
    most = require('./most');

expect(
    most('9fil3dj11P0jAsf11j')
).toEqual(22);

expect(
    most('9fi9l3dj11P0jAsf11j')
).toEqual(22);

console.info('tests passed!');
