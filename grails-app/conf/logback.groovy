import grails.util.BuildSettings
import grails.util.Environment
import org.springframework.boot.logging.logback.ColorConverter
import org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

import java.nio.charset.Charset

conversionRule 'clr', ColorConverter
conversionRule 'wex', WhitespaceThrowableProxyConverter

String defaultPattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} | %-5level | %logger{50}.%M\\(\\):%L - %msg%n"
String logFileLocation = "syslog/bootvue.log"

/****************************************************
 * Log file CONSOLE Appender
 ****************************************************
 */
appender('CONSOLE', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = defaultPattern
    }
}

/****************************************************
 * Log file FILE Appender
 ****************************************************
 */
appender("FILE", RollingFileAppender) {
    file = "${logFileLocation}"
    encoder(PatternLayoutEncoder) {
        pattern = defaultPattern
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${logFileLocation}.%d{yyyy-MM-dd}"
    }
}


/****************************************************
 * Environment specific log level
 ****************************************************
 */
if(Environment.current == Environment.DEVELOPMENT) {
    logger("StackTrace", ERROR, ['CONSOLE'], false)
    logger("com.bootvue", DEBUG, ['CONSOLE'], false)
    logger("org.grails", ERROR, ['CONSOLE'], false)
    logger("org.hibernate", ERROR, ['CONSOLE'], false)
    root(ERROR, ['CONSOLE'])
} else if (Environment.current == Environment.TEST || Environment.current == Environment.PRODUCTION) {
    logger("StackTrace", ERROR, ['CONSOLE', 'FILE'], false)
    root(ERROR, ['CONSOLE', 'FILE'])
}
