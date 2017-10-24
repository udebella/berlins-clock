const chai = require('chai')
const berlinClock = require('./berlinclock')

const createTime = (hour = 0, minute = 0, seconds = 0) => new Date(1970, 1, 1, hour, minute, seconds)

describe('Berlin clock', () => {
    describe('Single minutes row', () => {
        it('all lights should be off at midnight', () => {
            const time = createTime()

            chai.expect(berlinClock.singleMinutes(time)).to.equal('OOOO')
        })

        it('all lights should be on at 1 sec to midnight', () => {
            const time = createTime(23, 59, 59)

            chai.expect(berlinClock.singleMinutes(time)).to.equal('YYYY')
        })

        it('half of the lights should be on at 12:32', () => {
            const time = createTime(12, 32, 0)

            chai.expect(berlinClock.singleMinutes(time)).to.equal('YYOO')
        })

        it('all lights should be on at 12:34', () => {
            const time = createTime(12, 34, 0)

            chai.expect(berlinClock.singleMinutes(time)).to.equal('YYYY')
        })

        it('all lights should be off at 12:35', () => {
            const time = createTime(12, 35, 0)

            chai.expect(berlinClock.singleMinutes(time)).to.equal('OOOO')
        })
    })

    describe('Five minutes row', () => {
        it('all lights should be off at midnight', () => {
            const time = createTime()

            chai.expect(berlinClock.fiveMinutes(time)).to.equal('OOOOOOOOOOO')
        })

        it('all lights should be on at 1 sec to midnight', () => {
            const time = createTime(23, 59, 59)

            chai.expect(berlinClock.fiveMinutes(time)).to.equal('YYRYYRYYRYY')
        })

        it('all lights should be off at 12:04', () => {
            const time = createTime(12, 4, 0)

            chai.expect(berlinClock.fiveMinutes(time)).to.equal('OOOOOOOOOOO')
        })

        it('some lights should be on at 12:23', () => {
            const time = createTime(12, 23, 0)

            chai.expect(berlinClock.fiveMinutes(time)).to.equal('YYRYOOOOOOO')
        })

        it('some lights should be off at 12:35', () => {
            const time = createTime(12, 35, 0)

            chai.expect(berlinClock.fiveMinutes(time)).to.equal('YYRYYRYOOOO')
        })
    })

    describe('Single hours row', () => {
        it('all lights should be off at midnight', () => {
            const time = createTime()

            chai.expect(berlinClock.singleHours(time)).to.equal('OOOO')
        })

        it('all lights should be on at 1 sec to midnight', () => {
            const time = createTime(23, 59, 59)

            chai.expect(berlinClock.singleHours(time)).to.equal('RRRO')
        })

        it('half the lights should be off at 02:04', () => {
            const time = createTime(2, 4, 0)

            chai.expect(berlinClock.singleHours(time)).to.equal('RROO')
        })

        it('some lights should be on at 8:23', () => {
            const time = createTime(8, 23, 0)

            chai.expect(berlinClock.singleHours(time)).to.equal('RRRO')
        })

        it('all lights should be off at 14:35', () => {
            const time = createTime(14, 35, 0)

            chai.expect(berlinClock.singleHours(time)).to.equal('RRRR')
        })
    })

    describe('Five hours row', () => {
        it('all lights should be off at midnight', () => {
            const time = createTime()

            chai.expect(berlinClock.fiveHours(time)).to.equal('OOOO')
        })

        it('all lights should be on at 1 sec to midnight', () => {
            const time = createTime(23, 59, 59)

            chai.expect(berlinClock.fiveHours(time)).to.equal('RRRR')
        })

        it('half the lights should be off at 02:04', () => {
            const time = createTime(2, 4, 0)

            chai.expect(berlinClock.fiveHours(time)).to.equal('OOOO')
        })

        it('some lights should be on at 8:23', () => {
            const time = createTime(8, 23, 0)

            chai.expect(berlinClock.fiveHours(time)).to.equal('ROOO')
        })

        it('all lights should be off at 16:35', () => {
            const time = createTime(16, 35, 0)

            chai.expect(berlinClock.fiveHours(time)).to.equal('RRRO')
        })
    })

    describe('Seconds lamp', () => {
        it('seconds light should be on at midnight', () => {
            const time = createTime()

            chai.expect(berlinClock.seconds(time)).to.equal('Y')
        })

        it('seconds light should be off at 1 sec to midnight', () => {
            const time = createTime(23, 59, 59)

            chai.expect(berlinClock.seconds(time)).to.equal('O')
        })
    })

    describe('The whole clock', () => {
        it('should return right chain for midnight', () => {
            const time = createTime()

            chai.expect(berlinClock.format(time)).to.equal('YOOOOOOOOOOOOOOOOOOOOOOO')
        })

        it('should return right chain for 1 sec to midnight', () => {
            const time = createTime(23, 59, 59)

            chai.expect(berlinClock.format(time)).to.equal('ORRRRRRROYYRYYRYYRYYYYYY')
        })

        it('should return right chain for 16:50:06', () => {
            const time = createTime(16, 50, 6)

            chai.expect(berlinClock.format(time)).to.equal('YRRROROOOYYRYYRYYRYOOOOO')
        })

        it('should return right chain for 11:37:01', () => {
            const time = createTime(11, 37, 1)

            chai.expect(berlinClock.format(time)).to.equal('ORROOROOOYYRYYRYOOOOYYOO')
        })
    })
})