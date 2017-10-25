const compose = (...functions) => param => functions.reduce((acc, fn) => fn(acc), param)
const range = size => [...new Array(size).keys()]

const modulo = modulo => number => number % modulo
const euclideanDivisionBy5 = minute => ~~(minute / 5)
const modulo5 = modulo(5)
const add1 = number => number + 1
const isOdd = compose(add1, modulo(2))
const oneOverThree = compose(add1, modulo(3))

const isLightOn = lightColor => nbLightOn => (lightNumber, index) =>
    lightNumber < nbLightOn ? lightColor(index) : 'O'
const allYellowLightsOn = isLightOn(_ => 'Y')
const allRedLightsOn = isLightOn(_ => 'R')
const oneLightOverThreeIsRed = isLightOn(index => {
    return oneOverThree(index) ? 'Y' : 'R';
})

const displayLights = nbLightTotal => formatLight => {
    return range(nbLightTotal)
        .map(formatLight)
        .join('');
}
const oneLight = displayLights(1)
const fourLight = displayLights(4)
const elevenLight = displayLights(11)

const retrieveHours = date => date.getHours()
const retrieveMinutes = date => date.getMinutes()
const retrieveSeconds = date => date.getSeconds()

const singleMinutes = compose(retrieveMinutes, modulo5, allYellowLightsOn, fourLight)
const fiveMinutes = compose(retrieveMinutes, euclideanDivisionBy5, oneLightOverThreeIsRed, elevenLight)
const singleHours = compose(retrieveHours, modulo5, allRedLightsOn, fourLight)
const fiveHours = compose(retrieveHours, euclideanDivisionBy5, allRedLightsOn, fourLight)
const seconds = compose(retrieveSeconds, isOdd, allYellowLightsOn, oneLight)
const format = date => [seconds, fiveHours, singleHours, fiveMinutes, singleMinutes].map(fn => fn(date)).join('')

module.exports = {
    singleMinutes,
    fiveMinutes,
    singleHours,
    fiveHours,
    seconds,
    format
}
