package com.mssoftech.springreact.dbflute.cbean.nss;

import com.mssoftech.springreact.dbflute.cbean.cq.SessionCQ;

/**
 * The nest select set-upper of session.
 * @author DBFlute(AutoGenerator)
 */
public class SessionNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final SessionCQ _query;
    public SessionNss(SessionCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * login by my login_id, named 'login'.
     */
    public void withLogin() {
        _query.xdoNss(() -> _query.queryLogin());
    }
}
