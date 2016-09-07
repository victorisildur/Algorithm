/* @param {string} p -> pattern
 * @return {{char, finite}[]} -> states
 */
var makeStates = function(p) {
    var states = [];
    for (var i = 0, l = p.length; i<l; i++) {
        var char = p[i];
        if (char !== '*') {
            states.push({char: char, infinite: false});
        } else {
            states[states.length - 1].infinite = true;
        }
    }
    return states;
};

/* @func: transfer state
 * @return: if nowhere to go, return -1. 
 *          if remain current input, goto next state, return -2.
 *          else return next state
 */
var nextState = function(states, currStateIdx, nextStateIdx, char) {
    var currState = states[currStateIdx],
        nextState = states[nextStateIdx];
    console.info('  calling nextState().. currState:' + JSON.stringify(currState) +
                 ',nextState:' + JSON.stringify(nextState) +
                 ',char:' + char);
    if (!currState)
        return -1;
    if (nextState && nextState.char === char) {
        return nextStateIdx;
    }
    if (currState.char === '.' ||
        currState.char === char
       ) {
        if (currState.infinite === true) {
            return currStateIdx;
        } else {
            return nextStateIdx;
        }
    } 

    if (currState.infinite === true) {
        return -2;
    } else {
        return -1;
    }
};

/* @param {string} s -> string
 *        {string} p -> pattern
 * @return {boolean}
 */
var isMatch = function(s, p) {
    var states = makeStates(p),
        currStateIdx = 0,
        nextStateIdx = null;
    console.info('-----------------');
    console.info('states:' + JSON.stringify(states) +
                 ',p:' + p);
    for (var i=0, l=s.length; i<l; ) {
        var char = s[i];
        nextStateIdx = nextState(states, currStateIdx, currStateIdx+1, char);
        console.info('  i:' + i +
                     ',char:' + char +
                     ',curr Idx:' + currStateIdx +
                     ',next Idx:' + nextStateIdx +
                     ',currState:' + JSON.stringify(states[currStateIdx]) +
                     ',nextState:' + JSON.stringify(states[nextStateIdx]));
        if (nextStateIdx === -1) {
            return false;
        } else if (nextStateIdx == -2) {
            currStateIdx++;
        } else {
            currStateIdx = nextStateIdx;
            i ++;
        }
    }
    if ((currStateIdx > states.length - 1) ||
        (currStateIdx === states.length - 1 && states[currStateIdx].infinite === true)
       )
        return true;
    else
        return false;
};

module.exports = isMatch;
