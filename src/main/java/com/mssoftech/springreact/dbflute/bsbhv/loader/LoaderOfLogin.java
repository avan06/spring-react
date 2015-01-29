package com.mssoftech.springreact.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.mssoftech.springreact.dbflute.exbhv.*;
import com.mssoftech.springreact.dbflute.exentity.*;
import com.mssoftech.springreact.dbflute.cbean.*;

/**
 * The referrer loader of login as TABLE. <br>
 * <pre>
 * [primary key]
 *     id
 *
 * [column]
 *     id, login_id, name, password, version_no, del_flag, register_datetime, register_user, register_process, update_datetime, update_user, update_process
 *
 * [sequence]
 *     login_id_seq
 *
 * [identity]
 *     
 *
 * [version-no]
 *     version_no
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     session
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     sessionList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfLogin {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Login> _selectedList;
    protected BehaviorSelector _selector;
    protected LoginBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfLogin ready(List<Login> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected LoginBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(LoginBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Session> _referrerSession;

    /**
     * Load referrer of sessionList by the set-upper of referrer. <br>
     * session by login_id, named 'sessionList'.
     * <pre>
     * <span style="color: #0000C0">loginBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">loginList</span>, <span style="color: #553000">loginLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">loginLoader</span>.<span style="color: #CC4747">loadSession</span>(<span style="color: #553000">sessionCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">sessionCB</span>.setupSelect...
     *         <span style="color: #553000">sessionCB</span>.query().set...
     *         <span style="color: #553000">sessionCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">sessionLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    sessionLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Login login : <span style="color: #553000">loginList</span>) {
     *     ... = login.<span style="color: #CC4747">getSessionList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setLoginId_InScope(pkList);
     * cb.query().addOrderBy_LoginId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfSession> loadSession(ReferrerConditionSetupper<SessionCB> refCBLambda) {
        myBhv().loadSession(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerSession = refLs);
        return hd -> hd.handle(new LoaderOfSession().ready(_referrerSession, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Login> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
