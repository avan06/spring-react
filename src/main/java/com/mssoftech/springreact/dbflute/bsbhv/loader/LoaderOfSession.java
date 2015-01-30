package com.mssoftech.springreact.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.mssoftech.springreact.dbflute.exbhv.*;
import com.mssoftech.springreact.dbflute.exentity.*;

/**
 * The referrer loader of session as TABLE. <br>
 * <pre>
 * [primary key]
 *     id
 *
 * [column]
 *     id, uuid, login_id, role, data, version_no, del_flag, register_datetime, register_user, register_process, update_datetime, update_user, update_process
 *
 * [sequence]
 *     session_id_seq
 *
 * [identity]
 *     
 *
 * [version-no]
 *     version_no
 *
 * [foreign table]
 *     login
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     login
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfSession {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Session> _selectedList;
    protected BehaviorSelector _selector;
    protected SessionBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfSession ready(List<Session> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected SessionBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(SessionBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfLogin _foreignLoginLoader;
    public LoaderOfLogin pulloutLogin() {
        if (_foreignLoginLoader == null)
        { _foreignLoginLoader = new LoaderOfLogin().ready(myBhv().pulloutLogin(_selectedList), _selector); }
        return _foreignLoginLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Session> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
