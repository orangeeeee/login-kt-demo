package strings

import com.kt.loginktdemo.business.impl.SampleBusinessAPIImpl.SiteVisit

fun String.lastChar(): Char = this.get(length - 1)


inline fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()