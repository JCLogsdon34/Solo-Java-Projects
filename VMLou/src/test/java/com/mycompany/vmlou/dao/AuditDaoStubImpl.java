package com.mycompany.vmlou.dao;

import com.mycompany.vmlou.dao.AuditDao;
import com.mycompany.vmlou.dao.VMLouPersistenceException;

/**
 *
 * @author JCLog
 */
public class AuditDaoStubImpl implements AuditDao {

    @Override
    public void writeAuditEntry(String entry) throws VMLouPersistenceException {
        // Nihil
    }
}