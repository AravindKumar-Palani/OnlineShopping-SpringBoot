package com.eshop.util;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CommonLoggers {

    /*
    error log -> file x
    info log -> file y
    user info, session data => log
     */
    public void  addErrorLogs(Logger logger, Exception exception) {
        logger.info("Transaction failed " + exception.getMessage());
        logger.error("Error Logs "+exception.getStackTrace());
    }
}
