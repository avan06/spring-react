package com.mssoftech.springreact.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.mssoftech.springreact.dbflute.allcommon.*;
import com.mssoftech.springreact.dbflute.exentity.*;

/**
 * The DB meta of login. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class LoginDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final LoginDbm _instance = new LoginDbm();
    private LoginDbm() {}
    public static LoginDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((Login)et).getId(), (et, vl) -> ((Login)et).setId(cti(vl)), "id");
        setupEpg(_epgMap, et -> ((Login)et).getLoginId(), (et, vl) -> ((Login)et).setLoginId((String)vl), "loginId");
        setupEpg(_epgMap, et -> ((Login)et).getName(), (et, vl) -> ((Login)et).setName((String)vl), "name");
        setupEpg(_epgMap, et -> ((Login)et).getPassword(), (et, vl) -> ((Login)et).setPassword((String)vl), "password");
        setupEpg(_epgMap, et -> ((Login)et).getVersionNo(), (et, vl) -> ((Login)et).setVersionNo(cti(vl)), "versionNo");
        setupEpg(_epgMap, et -> ((Login)et).getDelFlag(), (et, vl) -> ((Login)et).setDelFlag(cti(vl)), "delFlag");
        setupEpg(_epgMap, et -> ((Login)et).getRegisterDatetime(), (et, vl) -> ((Login)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((Login)et).getRegisterUser(), (et, vl) -> ((Login)et).setRegisterUser((String)vl), "registerUser");
        setupEpg(_epgMap, et -> ((Login)et).getRegisterProcess(), (et, vl) -> ((Login)et).setRegisterProcess((String)vl), "registerProcess");
        setupEpg(_epgMap, et -> ((Login)et).getUpdateDatetime(), (et, vl) -> ((Login)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((Login)et).getUpdateUser(), (et, vl) -> ((Login)et).setUpdateUser((String)vl), "updateUser");
        setupEpg(_epgMap, et -> ((Login)et).getUpdateProcess(), (et, vl) -> ((Login)et).setUpdateProcess((String)vl), "updateProcess");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "login";
    protected final String _tablePropertyName = "login";
    protected final TableSqlName _tableSqlName = new TableSqlName("login", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnId = cci("id", "id", null, null, Integer.class, "id", null, true, true, true, "serial", 10, 0, "nextval('login_id_seq'::regclass)", false, null, null, null, "sessionList", null, false);
    protected final ColumnInfo _columnLoginId = cci("login_id", "login_id", null, null, String.class, "loginId", null, false, false, true, "varchar", 40, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnName = cci("name", "name", null, null, String.class, "name", null, false, false, true, "varchar", 40, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnPassword = cci("password", "password", null, null, String.class, "password", null, false, false, true, "varchar", 40, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnVersionNo = cci("version_no", "version_no", null, null, Integer.class, "versionNo", null, false, false, true, "int4", 10, 0, null, false, OptimisticLockType.VERSION_NO, null, null, null, null, false);
    protected final ColumnInfo _columnDelFlag = cci("del_flag", "del_flag", null, null, Integer.class, "delFlag", null, false, false, true, "int4", 10, 0, "0", false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("register_datetime", "register_datetime", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "timestamp", 29, 6, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterUser = cci("register_user", "register_user", null, null, String.class, "registerUser", null, false, false, true, "varchar", 30, 0, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterProcess = cci("register_process", "register_process", null, null, String.class, "registerProcess", null, false, false, true, "varchar", 30, 0, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("update_datetime", "update_datetime", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "timestamp", 29, 6, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateUser = cci("update_user", "update_user", null, null, String.class, "updateUser", null, false, false, true, "varchar", 30, 0, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateProcess = cci("update_process", "update_process", null, null, String.class, "updateProcess", null, false, false, true, "varchar", 30, 0, null, true, null, null, null, null, null, false);

    /**
     * id: {PK, ID, NotNull, serial(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnId() { return _columnId; }
    /**
     * login_id: {UQ+, NotNull, varchar(40)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnLoginId() { return _columnLoginId; }
    /**
     * name: {NotNull, varchar(40)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnName() { return _columnName; }
    /**
     * password: {NotNull, varchar(40)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPassword() { return _columnPassword; }
    /**
     * version_no: {NotNull, int4(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVersionNo() { return _columnVersionNo; }
    /**
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDelFlag() { return _columnDelFlag; }
    /**
     * register_datetime: {NotNull, timestamp(29, 6)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterDatetime() { return _columnRegisterDatetime; }
    /**
     * register_user: {NotNull, varchar(30)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterUser() { return _columnRegisterUser; }
    /**
     * register_process: {NotNull, varchar(30)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterProcess() { return _columnRegisterProcess; }
    /**
     * update_datetime: {NotNull, timestamp(29, 6)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateDatetime() { return _columnUpdateDatetime; }
    /**
     * update_user: {NotNull, varchar(30)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateUser() { return _columnUpdateUser; }
    /**
     * update_process: {NotNull, varchar(30)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateProcess() { return _columnUpdateProcess; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnId());
        ls.add(columnLoginId());
        ls.add(columnName());
        ls.add(columnPassword());
        ls.add(columnVersionNo());
        ls.add(columnDelFlag());
        ls.add(columnRegisterDatetime());
        ls.add(columnRegisterUser());
        ls.add(columnRegisterProcess());
        ls.add(columnUpdateDatetime());
        ls.add(columnUpdateUser());
        ls.add(columnUpdateProcess());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // -----------------------------------------------------
    //                                        Unique Element
    //                                        --------------
    private volatile List<UniqueInfo> _uniqueInfoList;
    public List<UniqueInfo> getUniqueInfoList() {
        if (_uniqueInfoList != null) {
            return _uniqueInfoList;
        }
        synchronized (this) {
            if (_uniqueInfoList != null) {
                return _uniqueInfoList;
            }
            final java.lang.reflect.Method[] methods = this.getClass().getMethods();
            _uniqueInfoList = newArrayListSized(4);
            final String prefix = "uniqueOf";
            final Class<UniqueInfo> returnType = UniqueInfo.class;
            for (java.lang.reflect.Method method : methods) {
                if (method.getName().startsWith(prefix) && returnType.equals(method.getReturnType())) {
                    _uniqueInfoList.add((UniqueInfo) org.dbflute.util.DfReflectionUtil.invoke(method, this, null));
                }
            }
            return _uniqueInfoList;
        }
    }
    public UniqueInfo uniqueOf() {
        List<ColumnInfo> ls = newArrayListSized(4);
        ls.add(columnLoginId());
        ls.add(columnDelFlag());
        return hpcui(ls);
    }

    protected UniqueInfo hpcui(ColumnInfo uniqueColumnInfo) { // helpCreateUniqueInfo()
        return hpcui(java.util.Arrays.asList(uniqueColumnInfo));
    }

    protected UniqueInfo hpcui(java.util.List<ColumnInfo> uniqueColumnInfoList) { // helpCreateUniqueInfo()
        return new UniqueInfo(this, uniqueColumnInfoList, false);
    }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * session by login_id, named 'sessionList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerSessionList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnId(), SessionDbm.getInstance().columnLoginId());
        return cri("session_login_fkey", "sessionList", this, SessionDbm.getInstance(), mp, false, "login");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasSequence() { return true; }
    public String getSequenceName() { return "login_id_seq"; }
    public Integer getSequenceIncrementSize() { return 1; }
    public Integer getSequenceCacheSize() { return null; }
    public boolean hasVersionNo() { return true; }
    public ColumnInfo getVersionNoColumnInfo() { return _columnVersionNo; }
    public boolean hasCommonColumn() { return true; }
    public List<ColumnInfo> getCommonColumnInfoList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterUser(), columnRegisterProcess(), columnUpdateDatetime(), columnUpdateUser(), columnUpdateProcess()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeInsertList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterUser(), columnRegisterProcess(), columnUpdateDatetime(), columnUpdateUser(), columnUpdateProcess()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeUpdateList()
    { return newArrayList(columnUpdateDatetime(), columnUpdateUser(), columnUpdateProcess()); }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.mssoftech.springreact.dbflute.exentity.Login"; }
    public String getConditionBeanTypeName() { return "com.mssoftech.springreact.dbflute.cbean.LoginCB"; }
    public String getBehaviorTypeName() { return "com.mssoftech.springreact.dbflute.exbhv.LoginBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Login> getEntityType() { return Login.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Login newEntity() { return new Login(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Login)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Login)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
