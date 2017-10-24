const range = (size) => [...new Array(size).keys()]

class BerlinClock {
    singleMinutes(date) {
        const minute = date.getMinutes()
        const nbLightOn = minute % 5

        return range(4)
            .map(lightNumber => lightNumber < nbLightOn ? 'Y' : 'O')
            .join('')
    }

    fiveMinutes(date) {
        const minute = date.getMinutes()
        const nbLightOn = ~~(minute / 5)

        return range(11)
            .map((lightNumber, index) => {
                if (lightNumber < nbLightOn) {
                    if ((index + 1) % 3 === 0) {
                        return 'R'
                    }
                    return 'Y'
                }
                return 'O'
            })
            .join('')
    }

    singleHours(date) {
        const minute = date.getHours()
        const nbLightOn = minute % 5

        return range(4)
            .map(lightNumber => lightNumber < nbLightOn ? 'R' : 'O')
            .join('')
    }

    fiveHours(date) {
        const minute = date.getHours()
        const nbLightOn = ~~(minute / 5)

        return range(4)
            .map(lightNumber => lightNumber < nbLightOn ? 'R' : 'O')
            .join('')
    }

    seconds(date) {
        const minute = date.getSeconds()
        const nbLightOn = ~~(minute % 2)

        return range(1)
            .map(lightNumber => lightNumber < nbLightOn ? 'O' : 'Y')
            .join('')
    }

    format(date) {
        return this.seconds(date)
            + this.fiveHours(date)
            + this.singleHours(date)
            + this.fiveMinutes(date)
            + this.singleMinutes(date)
    }
}

const berlinclock = new BerlinClock()

module.exports = berlinclock
