package com.report.global;

import java.io.Reader;

import com.css.base.BaseException;
import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;

public class DaoConfig {
    private static final String resource = "com/report/global/dao-config.xml";

    private static DaoManager daoManager;

    private DaoConfig() {
    }

    public static DaoManager getDaoManager() throws BaseException {
        try {
            if (daoManager == null) {
                Reader reader = Resources.getResourceAsReader(resource);
                daoManager = DaoManagerBuilder.buildDaoManager(reader);
            }
            return daoManager;
        }
        catch (Exception e) {
            // throw new BaseException("errors.not.connect.db", e);
            throw new RuntimeException(
                    "Could not initialize DaoFactory.  Cause: " + e, e);
        }
    }
}