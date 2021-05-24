#### Logging 

In java logging is an API that provides the ability to tract out the errors of the application , when an application generates the logging call , the Logger 
records the event in the Log Record, after that , it send to the corresponding handlers or appenders. before sending it to the console or file , appenders format that log 
record by using formatter.

# Need for logging 
  
  It Provides the complete tracing information of the applicaiton 
  record the critical failure if any occur in an application 
  
  
# components of logging 

1. Logger 
2. Logging Handler or Appender 
3. Logging Formatter

Logger: 
  The code used by the client sends the log request to the Logger objects. these logger objects keep the track of a log leve that is interested in , also rejects the 
  log request that are below the specified log level
  
  Loggers are responsible for capturing log records, after that it passes the records to the corresponding appender 
  
 Appender/Handler 
  Logging API allows us to use Multiple handlers in a java logger and handlers process the logs accordingly 
  
  There are 5 types of logging handlers 
  
  1. Stream handler - it writes the formatted log message to an Output Stream 
  2. Console handler - writes all the formatted logs messages to a console 
  3. File handler - writes the log message either to a single file or a group of rotating log file in the XML format 
  4. socket handler - writes the log message to the remote TCP ports 
  5. Memory handler - handles the buffer log records resides in the memory 
 
 Industry prominently uses Console handler and File handler 
 
 Level in Java 1.4 are
 1. severe - critical error 
 2. fine - info
 3. Warning
 
 Pitfalls : complex configuration option , slow performance etc 
 
 
 Log4j:
 
 Log4j is used to configure loggers by using appenders such as File, consolde, SMTP,JDBC , Rolling .
 private static Logger logger = Logger.getLogger(LoggerImpl.class);
 
 Commons :
 Logging log = LogFactory.getLog(classname.class);
 
 SLF4j & LogBack - facade pattern with api such as Log4j, commons,logback 
 
 Log4j2 - latest 
 
 
 
