const range = size => [...new Array(size).keys()]

const euclideanDivisionBy5 = minute => {
    return ~~(minute / 5)
}

const formatLight = lightColor => nbLightOn => (lightNumber, index) =>
    lightNumber < nbLightOn ? lightColor(index) : 'O'

const allYellowLight = formatLight(_ => 'Y')
const allRedLights = formatLight(_ => 'R')
const oneLightOverThreeIsRed = formatLight(index => {
    if ((index + 1) % 3 === 0) {
        return 'R'
    }
    return 'Y'
})

const displayLights = nbLightTotal => formatLight => {
    return range(nbLightTotal)
        .map(formatLight)
        .join('');
}

const oneLight = displayLights(1)
const fourLight = displayLights(4)
const elevenLight = displayLights(11)


class BerlinClock {
    singleMinutes(date) {
        const minute = date.getMinutes()
        const nbLightOn = minute % 5

        return fourLight(allYellowLight(nbLightOn))
    }

    fiveMinutes(date) {
        const minute = date.getMinutes()
        const nbLightOn = euclideanDivisionBy5(minute)

        return elevenLight(oneLightOverThreeIsRed(nbLightOn))
    }

    singleHours(date) {
        const minute = date.getHours()
        const nbLightOn = minute % 5

        return fourLight(allRedLights(nbLightOn))
    }

    fiveHours(date) {
        const minute = date.getHours()
        const nbLightOn = euclideanDivisionBy5(minute)

        return fourLight(allRedLights(nbLightOn))
    }

    seconds(date) {
        const minute = date.getSeconds()
        const nbLightOn = (minute + 1) % 2

        return oneLight(allYellowLight(nbLightOn))
    }

    format(date) {
        return [this.seconds, this.fiveHours, this.singleHours, this.fiveMinutes, this.singleMinutes]
            .map(fn => fn(date))
            .join('');
    }
}

module.exports = new BerlinClock()
