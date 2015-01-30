package com.mssoftech.springreact.dbflute.cbean.cq.bs;

import java.util.Map;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.exception.IllegalConditionBeanOperationException;
import com.mssoftech.springreact.dbflute.cbean.cq.ciq.*;
import com.mssoftech.springreact.dbflute.cbean.*;
import com.mssoftech.springreact.dbflute.cbean.cq.*;

/**
 * The base condition-query of session.
 * @author DBFlute(AutoGenerator)
 */
public class BsSessionCQ extends AbstractBsSessionCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected SessionCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsSessionCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from session) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public SessionCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected SessionCIQ xcreateCIQ() {
        SessionCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected SessionCIQ xnewCIQ() {
        return new SessionCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join session on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public SessionCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        SessionCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _id;
    public ConditionValue xdfgetId()
    { if (_id == null) { _id = nCV(); }
      return _id; }
    protected ConditionValue xgetCValueId() { return xdfgetId(); }

    /** 
     * Add order-by as ascend. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_Id_Asc() { regOBA("id"); return this; }

    /**
     * Add order-by as descend. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_Id_Desc() { regOBD("id"); return this; }

    protected ConditionValue _uuid;
    public ConditionValue xdfgetUuid()
    { if (_uuid == null) { _uuid = nCV(); }
      return _uuid; }
    protected ConditionValue xgetCValueUuid() { return xdfgetUuid(); }

    /** 
     * Add order-by as ascend. <br>
     * uuid: {UQ, NotNull, varchar(50)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_Uuid_Asc() { regOBA("uuid"); return this; }

    /**
     * Add order-by as descend. <br>
     * uuid: {UQ, NotNull, varchar(50)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_Uuid_Desc() { regOBD("uuid"); return this; }

    protected ConditionValue _loginId;
    public ConditionValue xdfgetLoginId()
    { if (_loginId == null) { _loginId = nCV(); }
      return _loginId; }
    protected ConditionValue xgetCValueLoginId() { return xdfgetLoginId(); }

    /** 
     * Add order-by as ascend. <br>
     * login_id: {int4(10), FK to login}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_LoginId_Asc() { regOBA("login_id"); return this; }

    /**
     * Add order-by as descend. <br>
     * login_id: {int4(10), FK to login}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_LoginId_Desc() { regOBD("login_id"); return this; }

    protected ConditionValue _role;
    public ConditionValue xdfgetRole()
    { if (_role == null) { _role = nCV(); }
      return _role; }
    protected ConditionValue xgetCValueRole() { return xdfgetRole(); }

    /** 
     * Add order-by as ascend. <br>
     * role: {varchar(5)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_Role_Asc() { regOBA("role"); return this; }

    /**
     * Add order-by as descend. <br>
     * role: {varchar(5)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_Role_Desc() { regOBD("role"); return this; }

    protected ConditionValue _data;
    public ConditionValue xdfgetData()
    { if (_data == null) { _data = nCV(); }
      return _data; }
    protected ConditionValue xgetCValueData() { return xdfgetData(); }

    /** 
     * Add order-by as ascend. <br>
     * data: {varchar(255)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_Data_Asc() { regOBA("data"); return this; }

    /**
     * Add order-by as descend. <br>
     * data: {varchar(255)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_Data_Desc() { regOBD("data"); return this; }

    protected ConditionValue _versionNo;
    public ConditionValue xdfgetVersionNo()
    { if (_versionNo == null) { _versionNo = nCV(); }
      return _versionNo; }
    protected ConditionValue xgetCValueVersionNo() { return xdfgetVersionNo(); }

    /** 
     * Add order-by as ascend. <br>
     * version_no: {NotNull, int4(10)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_VersionNo_Asc() { regOBA("version_no"); return this; }

    /**
     * Add order-by as descend. <br>
     * version_no: {NotNull, int4(10)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_VersionNo_Desc() { regOBD("version_no"); return this; }

    protected ConditionValue _delFlag;
    public ConditionValue xdfgetDelFlag()
    { if (_delFlag == null) { _delFlag = nCV(); }
      return _delFlag; }
    protected ConditionValue xgetCValueDelFlag() { return xdfgetDelFlag(); }

    /** 
     * Add order-by as ascend. <br>
     * del_flag: {NotNull, int4(10), default=[0]}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_DelFlag_Asc() { regOBA("del_flag"); return this; }

    /**
     * Add order-by as descend. <br>
     * del_flag: {NotNull, int4(10), default=[0]}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_DelFlag_Desc() { regOBD("del_flag"); return this; }

    protected ConditionValue _registerDatetime;
    public ConditionValue xdfgetRegisterDatetime()
    { if (_registerDatetime == null) { _registerDatetime = nCV(); }
      return _registerDatetime; }
    protected ConditionValue xgetCValueRegisterDatetime() { return xdfgetRegisterDatetime(); }

    /** 
     * Add order-by as ascend. <br>
     * register_datetime: {NotNull, timestamp(29, 6)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_RegisterDatetime_Asc() { regOBA("register_datetime"); return this; }

    /**
     * Add order-by as descend. <br>
     * register_datetime: {NotNull, timestamp(29, 6)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_RegisterDatetime_Desc() { regOBD("register_datetime"); return this; }

    protected ConditionValue _registerUser;
    public ConditionValue xdfgetRegisterUser()
    { if (_registerUser == null) { _registerUser = nCV(); }
      return _registerUser; }
    protected ConditionValue xgetCValueRegisterUser() { return xdfgetRegisterUser(); }

    /** 
     * Add order-by as ascend. <br>
     * register_user: {NotNull, varchar(30)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_RegisterUser_Asc() { regOBA("register_user"); return this; }

    /**
     * Add order-by as descend. <br>
     * register_user: {NotNull, varchar(30)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_RegisterUser_Desc() { regOBD("register_user"); return this; }

    protected ConditionValue _registerProcess;
    public ConditionValue xdfgetRegisterProcess()
    { if (_registerProcess == null) { _registerProcess = nCV(); }
      return _registerProcess; }
    protected ConditionValue xgetCValueRegisterProcess() { return xdfgetRegisterProcess(); }

    /** 
     * Add order-by as ascend. <br>
     * register_process: {NotNull, varchar(30)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_RegisterProcess_Asc() { regOBA("register_process"); return this; }

    /**
     * Add order-by as descend. <br>
     * register_process: {NotNull, varchar(30)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_RegisterProcess_Desc() { regOBD("register_process"); return this; }

    protected ConditionValue _updateDatetime;
    public ConditionValue xdfgetUpdateDatetime()
    { if (_updateDatetime == null) { _updateDatetime = nCV(); }
      return _updateDatetime; }
    protected ConditionValue xgetCValueUpdateDatetime() { return xdfgetUpdateDatetime(); }

    /** 
     * Add order-by as ascend. <br>
     * update_datetime: {NotNull, timestamp(29, 6)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_UpdateDatetime_Asc() { regOBA("update_datetime"); return this; }

    /**
     * Add order-by as descend. <br>
     * update_datetime: {NotNull, timestamp(29, 6)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_UpdateDatetime_Desc() { regOBD("update_datetime"); return this; }

    protected ConditionValue _updateUser;
    public ConditionValue xdfgetUpdateUser()
    { if (_updateUser == null) { _updateUser = nCV(); }
      return _updateUser; }
    protected ConditionValue xgetCValueUpdateUser() { return xdfgetUpdateUser(); }

    /** 
     * Add order-by as ascend. <br>
     * update_user: {NotNull, varchar(30)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_UpdateUser_Asc() { regOBA("update_user"); return this; }

    /**
     * Add order-by as descend. <br>
     * update_user: {NotNull, varchar(30)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_UpdateUser_Desc() { regOBD("update_user"); return this; }

    protected ConditionValue _updateProcess;
    public ConditionValue xdfgetUpdateProcess()
    { if (_updateProcess == null) { _updateProcess = nCV(); }
      return _updateProcess; }
    protected ConditionValue xgetCValueUpdateProcess() { return xdfgetUpdateProcess(); }

    /** 
     * Add order-by as ascend. <br>
     * update_process: {NotNull, varchar(30)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_UpdateProcess_Asc() { regOBA("update_process"); return this; }

    /**
     * Add order-by as descend. <br>
     * update_process: {NotNull, varchar(30)}
     * @return this. (NotNull)
     */
    public BsSessionCQ addOrderBy_UpdateProcess_Desc() { regOBD("update_process"); return this; }

    // ===================================================================================
    //                                                             SpecifiedDerivedOrderBy
    //                                                             =======================
    /**
     * Add order-by for specified derived column as ascend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsSessionCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsSessionCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        SessionCQ bq = (SessionCQ)bqs;
        SessionCQ uq = (SessionCQ)uqs;
        if (bq.hasConditionQueryLogin()) {
            uq.queryLogin().reflectRelationOnUnionQuery(bq.queryLogin(), uq.queryLogin());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * login by my login_id, named 'login'.
     * @return The instance of condition-query. (NotNull)
     */
    public LoginCQ queryLogin() {
        return xdfgetConditionQueryLogin();
    }
    public LoginCQ xdfgetConditionQueryLogin() {
        String prop = "login";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryLogin()); xsetupOuterJoinLogin(); }
        return xgetQueRlMap(prop);
    }
    protected LoginCQ xcreateQueryLogin() {
        String nrp = xresolveNRP("session", "login"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new LoginCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "login", nrp);
    }
    protected void xsetupOuterJoinLogin() { xregOutJo("login"); }
    public boolean hasConditionQueryLogin() { return xhasQueRlMap("login"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, SessionCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(SessionCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, SessionCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(SessionCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, SessionCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(SessionCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, SessionCQ> _myselfExistsMap;
    public Map<String, SessionCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(SessionCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, SessionCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(SessionCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return SessionCB.class.getName(); }
    protected String xCQ() { return SessionCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
