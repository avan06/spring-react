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
 * The base condition-query of sys_table.
 * @author DBFlute(AutoGenerator)
 */
public class BsSysTableCQ extends AbstractBsSysTableCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected SysTableCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsSysTableCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from sys_table) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public SysTableCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected SysTableCIQ xcreateCIQ() {
        SysTableCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected SysTableCIQ xnewCIQ() {
        return new SysTableCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join sys_table on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public SysTableCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        SysTableCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
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
    public BsSysTableCQ addOrderBy_Id_Asc() { regOBA("id"); return this; }

    /**
     * Add order-by as descend. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_Id_Desc() { regOBD("id"); return this; }

    protected ConditionValue _tableName;
    public ConditionValue xdfgetTableName()
    { if (_tableName == null) { _tableName = nCV(); }
      return _tableName; }
    protected ConditionValue xgetCValueTableName() { return xdfgetTableName(); }

    /** 
     * Add order-by as ascend. <br>
     * table_name: {UQ+, NotNull, varchar(40)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_TableName_Asc() { regOBA("table_name"); return this; }

    /**
     * Add order-by as descend. <br>
     * table_name: {UQ+, NotNull, varchar(40)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_TableName_Desc() { regOBD("table_name"); return this; }

    protected ConditionValue _key1;
    public ConditionValue xdfgetKey1()
    { if (_key1 == null) { _key1 = nCV(); }
      return _key1; }
    protected ConditionValue xgetCValueKey1() { return xdfgetKey1(); }

    /** 
     * Add order-by as ascend. <br>
     * key_1: {+UQ, NotNull, varchar(40)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_Key1_Asc() { regOBA("key_1"); return this; }

    /**
     * Add order-by as descend. <br>
     * key_1: {+UQ, NotNull, varchar(40)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_Key1_Desc() { regOBD("key_1"); return this; }

    protected ConditionValue _key2;
    public ConditionValue xdfgetKey2()
    { if (_key2 == null) { _key2 = nCV(); }
      return _key2; }
    protected ConditionValue xgetCValueKey2() { return xdfgetKey2(); }

    /** 
     * Add order-by as ascend. <br>
     * key_2: {+UQ, NotNull, varchar(100)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_Key2_Asc() { regOBA("key_2"); return this; }

    /**
     * Add order-by as descend. <br>
     * key_2: {+UQ, NotNull, varchar(100)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_Key2_Desc() { regOBD("key_2"); return this; }

    protected ConditionValue _s1Data;
    public ConditionValue xdfgetS1Data()
    { if (_s1Data == null) { _s1Data = nCV(); }
      return _s1Data; }
    protected ConditionValue xgetCValueS1Data() { return xdfgetS1Data(); }

    /** 
     * Add order-by as ascend. <br>
     * s1_data: {text(2147483647)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_S1Data_Asc() { regOBA("s1_data"); return this; }

    /**
     * Add order-by as descend. <br>
     * s1_data: {text(2147483647)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_S1Data_Desc() { regOBD("s1_data"); return this; }

    protected ConditionValue _s2Data;
    public ConditionValue xdfgetS2Data()
    { if (_s2Data == null) { _s2Data = nCV(); }
      return _s2Data; }
    protected ConditionValue xgetCValueS2Data() { return xdfgetS2Data(); }

    /** 
     * Add order-by as ascend. <br>
     * s2_data: {varchar(100)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_S2Data_Asc() { regOBA("s2_data"); return this; }

    /**
     * Add order-by as descend. <br>
     * s2_data: {varchar(100)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_S2Data_Desc() { regOBD("s2_data"); return this; }

    protected ConditionValue _s3Data;
    public ConditionValue xdfgetS3Data()
    { if (_s3Data == null) { _s3Data = nCV(); }
      return _s3Data; }
    protected ConditionValue xgetCValueS3Data() { return xdfgetS3Data(); }

    /** 
     * Add order-by as ascend. <br>
     * s3_data: {varchar(100)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_S3Data_Asc() { regOBA("s3_data"); return this; }

    /**
     * Add order-by as descend. <br>
     * s3_data: {varchar(100)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_S3Data_Desc() { regOBD("s3_data"); return this; }

    protected ConditionValue _n1Data;
    public ConditionValue xdfgetN1Data()
    { if (_n1Data == null) { _n1Data = nCV(); }
      return _n1Data; }
    protected ConditionValue xgetCValueN1Data() { return xdfgetN1Data(); }

    /** 
     * Add order-by as ascend. <br>
     * n1_data: {numeric(20, 2)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_N1Data_Asc() { regOBA("n1_data"); return this; }

    /**
     * Add order-by as descend. <br>
     * n1_data: {numeric(20, 2)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_N1Data_Desc() { regOBD("n1_data"); return this; }

    protected ConditionValue _n2Data;
    public ConditionValue xdfgetN2Data()
    { if (_n2Data == null) { _n2Data = nCV(); }
      return _n2Data; }
    protected ConditionValue xgetCValueN2Data() { return xdfgetN2Data(); }

    /** 
     * Add order-by as ascend. <br>
     * n2_data: {numeric(20, 2)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_N2Data_Asc() { regOBA("n2_data"); return this; }

    /**
     * Add order-by as descend. <br>
     * n2_data: {numeric(20, 2)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_N2Data_Desc() { regOBD("n2_data"); return this; }

    protected ConditionValue _n3Data;
    public ConditionValue xdfgetN3Data()
    { if (_n3Data == null) { _n3Data = nCV(); }
      return _n3Data; }
    protected ConditionValue xgetCValueN3Data() { return xdfgetN3Data(); }

    /** 
     * Add order-by as ascend. <br>
     * n3_data: {numeric(20, 2)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_N3Data_Asc() { regOBA("n3_data"); return this; }

    /**
     * Add order-by as descend. <br>
     * n3_data: {numeric(20, 2)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_N3Data_Desc() { regOBD("n3_data"); return this; }

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
    public BsSysTableCQ addOrderBy_VersionNo_Asc() { regOBA("version_no"); return this; }

    /**
     * Add order-by as descend. <br>
     * version_no: {NotNull, int4(10)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_VersionNo_Desc() { regOBD("version_no"); return this; }

    protected ConditionValue _delFlag;
    public ConditionValue xdfgetDelFlag()
    { if (_delFlag == null) { _delFlag = nCV(); }
      return _delFlag; }
    protected ConditionValue xgetCValueDelFlag() { return xdfgetDelFlag(); }

    /** 
     * Add order-by as ascend. <br>
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_DelFlag_Asc() { regOBA("del_flag"); return this; }

    /**
     * Add order-by as descend. <br>
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_DelFlag_Desc() { regOBD("del_flag"); return this; }

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
    public BsSysTableCQ addOrderBy_RegisterDatetime_Asc() { regOBA("register_datetime"); return this; }

    /**
     * Add order-by as descend. <br>
     * register_datetime: {NotNull, timestamp(29, 6)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_RegisterDatetime_Desc() { regOBD("register_datetime"); return this; }

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
    public BsSysTableCQ addOrderBy_RegisterUser_Asc() { regOBA("register_user"); return this; }

    /**
     * Add order-by as descend. <br>
     * register_user: {NotNull, varchar(30)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_RegisterUser_Desc() { regOBD("register_user"); return this; }

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
    public BsSysTableCQ addOrderBy_RegisterProcess_Asc() { regOBA("register_process"); return this; }

    /**
     * Add order-by as descend. <br>
     * register_process: {NotNull, varchar(30)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_RegisterProcess_Desc() { regOBD("register_process"); return this; }

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
    public BsSysTableCQ addOrderBy_UpdateDatetime_Asc() { regOBA("update_datetime"); return this; }

    /**
     * Add order-by as descend. <br>
     * update_datetime: {NotNull, timestamp(29, 6)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_UpdateDatetime_Desc() { regOBD("update_datetime"); return this; }

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
    public BsSysTableCQ addOrderBy_UpdateUser_Asc() { regOBA("update_user"); return this; }

    /**
     * Add order-by as descend. <br>
     * update_user: {NotNull, varchar(30)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_UpdateUser_Desc() { regOBD("update_user"); return this; }

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
    public BsSysTableCQ addOrderBy_UpdateProcess_Asc() { regOBA("update_process"); return this; }

    /**
     * Add order-by as descend. <br>
     * update_process: {NotNull, varchar(30)}
     * @return this. (NotNull)
     */
    public BsSysTableCQ addOrderBy_UpdateProcess_Desc() { regOBD("update_process"); return this; }

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
    public BsSysTableCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsSysTableCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, SysTableCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(SysTableCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, SysTableCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(SysTableCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, SysTableCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(SysTableCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, SysTableCQ> _myselfExistsMap;
    public Map<String, SysTableCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(SysTableCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, SysTableCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(SysTableCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return SysTableCB.class.getName(); }
    protected String xCQ() { return SysTableCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
