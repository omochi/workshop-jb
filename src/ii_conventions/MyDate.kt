package ii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (year != other.year) {
            return year - other.year;
        }
        if (month != other.month) {
            return month - other.month;
        }
        if (dayOfMonth != other.dayOfMonth) {
            return dayOfMonth - other.dayOfMonth;
        }
        return 0;
    }
}

fun MyDate.rangeTo(end: MyDate) : DateRange {
    return DateRange(this, end)
}

fun MyDate.plus(interval: TimeInterval) : MyDate {
    return addTimeIntervals(interval, 1)
}
fun MyDate.plus(interval: RepeatedTimeInterval) : MyDate {
    return addTimeIntervals(interval.unit, interval.times)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

fun TimeInterval.times(times: Int) : RepeatedTimeInterval {
    return RepeatedTimeInterval(this, times)
}

class RepeatedTimeInterval(val unit: TimeInterval, val times: Int)

fun RepeatedTimeInterval.times(times: Int) : RepeatedTimeInterval {
    return RepeatedTimeInterval(unit, this.times * times)
}

class DateRange(public val start: MyDate, public val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            private var day = start

            override fun next(): MyDate {
                val ret = day
                day = day.nextDay()
                return ret
            }

            override fun hasNext(): Boolean {
                return day <= end
            }

        };
    }
}

fun DateRange.contains(date: MyDate): Boolean {
    return start <= date && date <= end
}