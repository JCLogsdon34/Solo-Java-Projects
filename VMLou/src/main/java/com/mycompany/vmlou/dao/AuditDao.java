package com.mycompany.vmlou.dao;

/**
 *
 * @author JCLog
 */
public interface AuditDao {

    public void writeAuditEntry(String entry)
            throws VMLouPersistenceException;

}
