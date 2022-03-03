package com.eugene.spring.boot.EgWeb.impl.aop.restapi;

import com.eugene.spring.boot.EgWeb.impl.basecontrol.EgBaseDataImpl;

public interface EgRestApiDataImpl extends EgBaseDataImpl {

    /**
     * Target columns are actual columns which exists on Database,
     * especially, table or collections which are identify the data.
     * For example, select `COL1`, `COL2`, ...
     * For example, insert into table (`COL1`, `COL2`, ...)
     * @return Target Column Names
     */
    String getTargetColumns();
}
