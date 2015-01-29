package com.mssoftech.springreact.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.optional.OptionalEntity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.mssoftech.springreact.dbflute.allcommon.*;
import com.mssoftech.springreact.dbflute.exentity.*;

/**
 * The DB meta of session. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class SessionDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final SessionDbm _instance = new SessionDbm();
    private SessionDbm() {}
    public static SessionDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((Session)et).getId(), (et, vl) -> ((Session)et).setId(cti(vl)), "id");
        setupEpg(_epgMap, et -> ((Session)et).getUuid(), (et, vl) -> ((Session)et).setUuid((String)vl), "uuid");
        setupEpg(_epgMap, et -> ((Session)et).getLoginId(), (et, vl) -> ((Session)et).setLoginId(cti(vl)), "loginId");
        setupEpg(_epgMap, et -> ((Session)et).getCompId(), (et, vl) -> ((Session)et).setCompId(cti(vl)), "compId");
        setupEpg(_epgMap, et -> ((Session)et).getFy(), (et, vl) -> ((Session)et).setFy((String)vl), "fy");
        setupEpg(_epgMap, et -> ((Session)et).getGrp(), (et, vl) -> ((Session)et).setGrp((String)vl), "grp");
        setupEpg(_epgMap, et -> ((Session)et).getData(), (et, vl) -> ((Session)et).setData((String)vl), "data");
        setupEpg(_epgMap, et -> ((Session)et).getVersionNo(), (et, vl) -> ((Session)et).setVersionNo(cti(vl)), "versionNo");
        setupEpg(_epgMap, et -> ((Session)et).getDelFlag(), (et, vl) -> ((Session)et).setDelFlag(cti(vl)), "delFlag");
        setupEpg(_epgMap, et -> ((Session)et).getRegisterDatetime(), (et, vl) -> ((Session)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((Session)et).getRegisterUser(), (et, vl) -> ((Session)et).setRegisterUser((String)vl), "registerUser");
        setupEpg(_epgMap, et -> ((Session)et).getRegisterProcess(), (et, vl) -> ((Session)et).setRegisterProcess((String)vl), "registerProcess");
        setupEpg(_epgMap, et -> ((Session)et).getUpdateDatetime(), (et, vl) -> ((Session)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((Session)et).getUpdateUser(), (et, vl) -> ((Session)et).setUpdateUser((String)vl), "updateUser");
        setupEpg(_epgMap, et -> ((Session)et).getUpdateProcess(), (et, vl) -> ((Session)et).setUpdateProcess((String)vl), "updateProcess");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    { xsetupEfpg(); }
    @SuppressWarnings("unchecked")
    protected void xsetupEfpg() {
        setupEfpg(_efpgMap, et -> ((Session)et).getLogin(), (et, vl) -> ((Session)et).setLogin((OptionalEntity<Login>)vl), "login");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "session";
    protected final String _tablePropertyName = "session";
    protected final TableSqlName _tableSqlName = new TableSqlName("session", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnId = cci("id", "id", null, null, Integer.class, "id", null, true, true, true, "serial", 10, 0, "nextval('session_id_seq'::regclass)", false, null, null, null, null, null, false);
    protected final ColumnInfo _columnUuid = cci("uuid", "uuid", null, null, String.class, "uuid", null, false, false, true, "varchar", 50, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnLoginId = cci("login_id", "login_id", null, null, Integer.class, "loginId", null, false, false, false, "int4", 10, 0, null, false, null, null, "login", null, null, false);
    protected final ColumnInfo _columnCompId = cci("comp_id", "comp_id", null, null, Integer.class, "compId", null, false, false, false, "int4", 10, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnFy = cci("fy", "fy", null, null, String.class, "fy", null, false, false, false, "bpchar", 4, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnGrp = cci("grp", "grp", null, null, String.class, "grp", null, false, false, false, "varchar", 5, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnData = cci("data", "data", null, null, String.class, "data", null, false, false, false, "varchar", 255, 0, null, false, null, null, null, null, null, false);
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
     * uuid: {UQ, NotNull, varchar(50)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUuid() { return _columnUuid; }
    /**
     * login_id: {int4(10), FK to login}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnLoginId() { return _columnLoginId; }
    /**
     * comp_id: {int4(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCompId() { return _columnCompId; }
    /**
     * fy: {bpchar(4)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnFy() { return _columnFy; }
    /**
     * grp: {varchar(5)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnGrp() { return _columnGrp; }
    /**
     * data: {varchar(255)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnData() { return _columnData; }
    /**
     * version_no: {NotNull, int4(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVersionNo() { return _columnVersionNo; }
    /**
     * del_flag: {NotNull, int4(10), default=[0]}
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
        ls.add(columnUuid());
        ls.add(columnLoginId());
        ls.add(columnCompId());
        ls.add(columnFy());
        ls.add(columnGrp());
        ls.add(columnData());
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
    public UniqueInfo uniqueOf() { return hpcui(columnUuid()); }

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
    /**
     * login by my login_id, named 'login'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignLogin() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnLoginId(), LoginDbm.getInstance().columnId());
        return cfi("session_login_fkey", "login", this, LoginDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "sessionList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasSequence() { return true; }
    public String getSequenceName() { return "session_id_seq"; }
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
    public String getEntityTypeName() { return "com.mssoftech.springreact.dbflute.exentity.Session"; }
    public String getConditionBeanTypeName() { return "com.mssoftech.springreact.dbflute.cbean.SessionCB"; }
    public String getBehaviorTypeName() { return "com.mssoftech.springreact.dbflute.exbhv.SessionBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Session> getEntityType() { return Session.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Session newEntity() { return new Session(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Session)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Session)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
