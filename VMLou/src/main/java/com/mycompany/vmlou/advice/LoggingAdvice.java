package com.mycompany.vmlou.advice;

import com.mycompany.vmlou.dao.AuditDao;
import com.mycompany.vmlou.dao.VMLouPersistenceException;
import java.time.LocalDateTime;
import org.aspectj.lang.JoinPoint;
/**
 *
 * @author JCLog
 */
public class LoggingAdvice {

    AuditDao auditDao;

    public LoggingAdvice(AuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": " + LocalDateTime.now().toString();
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VMLouPersistenceException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    public void logExceptions(JoinPoint methodInfo, Throwable e) {
        try {
            String nameOfMethodThatExecuted = methodInfo.getSignature().getName();
            auditDao.writeAuditEntry(nameOfMethodThatExecuted + " just threw an exception (" + e.getClass().getSimpleName() + ")");
            auditDao.writeAuditEntry("And these were it's arguments: ");

            Object[] params = methodInfo.getArgs();
            int count = 1;
            for (Object param : params) {
                auditDao.writeAuditEntry(count + ") " + param.getClass().getSimpleName() + ": " + param.toString() + LocalDateTime.now().toString());
                count++;
            }
        } catch (Throwable t) {
            System.out.println("Something went wrong logging that exception.");
        }
    }
}
