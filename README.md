# meta-calendar

 [![Build Status](https://travis-ci.com/eparovyshnaya/meta-calendar.svg?branch=master)](https://travis-ci.com/eparovyshnaya/meta-calendar)
 [![Codacy Badge](https://api.codacy.com/project/badge/Grade/6d05c5201f9e4b0a90359399c570f13a)](https://www.codacy.com/manual/elena.parovyshnaya/meta-calendar?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=eparovyshnaya/meta-calendar&amp;utm_campaign=Badge_Grade)
 [![codecov](https://codecov.io/gh/eparovyshnaya/meta-calendar/branch/master/graph/badge.svg)](https://codecov.io/gh/eparovyshnaya/meta-calendar)
 [![Hits-of-Code](https://hitsofcode.com/github/eparovyshnaya/meta-calendar)](https://hitsofcode.com/view/github/eparovyshnaya/meta-calendar)

[![License](https://img.shields.io/badge/License-MIT-green.svg)](https://github.com/eparovyshnaya/meta-calendar/blob/master/LICENSE)

[![Release](https://img.shields.io/badge/Release-Latest%202.0.0-pink.svg)](https://github.com/eparovyshnaya/meta-calendar/releases/latest)

## what is it all about
_Meta-calendar_ is sort of a data structure with a plain API to handle time *period*s.
*Period*s are not nailed down to particular dates, 
so you cannot settle an alarm clock to avoid missing start of such a *period*.
Instead, they are expressed freely like
 - autumn school holidays: from the last saturday of October till the first saturday of November
 - Judith's birthday: 21-st of August
 - Jol in Iceland: from 12-th of December till 25-th of December
 - time to let your hair down: the last day of December
 - you name it
 
 Here we provide a way to 
  - describe such a calendar, 
  - map it to a particular timeline slot and 
  - exploit actual dates.
 
## what's the use 
Not much of it, actually. You can
 - **construct** these periods out of natural language phrases like the ones listed above, or by formal API
>by dsl (have a look at [DslTest](src/test/kotlin/ru/cleverclover/metacalendar/compose/DslTest.kt))
 ```kotlin
    calendar {
            period(
                    from = "третья среда ноября",
                    till = "17 января",
                    note = "dark time"
            )
            period(
                range = "с конца августа по третью пятницу сентября",
                note = "school settling"
            )
    }
```
>by natural language API (see [PeriodParseTest](src/test/kotlin/ru/cleverclover/metacalendar/parse/PeriodParseTest.kt) 
>and [ModelApiTest](src/test/kotlin/ru/cleverclover/metacalendar/api/ModelApiTest.kt))
 ```kotlin
    MetaCalendar(
        PeriodFromRangeDefinition("с 1 января по 8 февраля").bounds().period(),
        PeriodFromBoundDefinitions("1 января", "8 июля").bounds().period()
    )
```
>by regular API
```kotlin
MetaCalendar(Period(DayOfMonth(Month.JANUARY, 1),  LastDayOfMonth(Month.FEBRUARY)))
```
 - **resolve** any of'em (or every, in one fell swoop) to *real date periods*,
  having a precise *year* and *time zone* to get pairs of *java.time.ZonedDateTime* objects. 
  The ones you actually can set an alarm clock for.
  (see [CalendarResolutionTest](src/test/kotlin/ru/cleverclover/metacalendar/resolve/CalendarResolutionTest.kt))
```kotlin
MetaCalendar(Period(DayOfMonth(Month.APRIL, 12), LastDayOfMonth(Month.APRIL)))
    .resolve(2019)
```

## how to plug

 - the library distributive resides under [jcenter](https://mvnrepository.com/repos/jcenter) maven repository.
 To add a repository to your, say, gradle build, use the dedicated gradle dsl function
```groovy
repositories {
    jcenter()
}    
```
or configure it directly 
```kotlin
repositories {
    maven(url = "https://jcenter.bintray.com")
}
```

 - latest released artifact version can be found, let alone this place, 
 at [bintray](https://bintray.com/eparovyshnaya/clever-clover/meta-calendar) presence page.
 Include the library in your, say, gradle build as follows (groovy dsl sample)
```groovy 
    compile 'ru.clever-clover.meta-calendar:meta-calendar:1.0.1'
``` 

## yet to be done
 - i18n is going to happen, currently ru-l10n is embedded [#6](https://github.com/eparovyshnaya/meta-calendar/issues/6)
