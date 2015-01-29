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
 * The DB meta of sys_table. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class SysTableDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final SysTableDbm _instance = new SysTableDbm();
    private SysTableDbm() {}
    public static SysTableDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((SysTable)et).getId(), (et, vl) -> ((SysTable)et).setId(cti(vl)), "id");
        setupEpg(_epgMap, et -> ((SysTable)et).getTableName(), (et, vl) -> ((SysTable)et).setTableName((String)vl), "tableName");
        setupEpg(_epgMap, et -> ((SysTable)et).getKey1(), (et, vl) -> ((SysTable)et).setKey1((String)vl), "key1");
        setupEpg(_epgMap, et -> ((SysTable)et).getKey2(), (et, vl) -> ((SysTable)et).setKey2((String)vl), "key2");
        setupEpg(_epgMap, et -> ((SysTable)et).getS1Data(), (et, vl) -> ((SysTable)et).setS1Data((String)vl), "s1Data");
        setupEpg(_epgMap, et -> ((SysTable)et).getS2Data(), (et, vl) -> ((SysTable)et).setS2Data((String)vl), "s2Data");
        setupEpg(_epgMap, et -> ((SysTable)et).getS3Data(), (et, vl) -> ((SysTable)et).setS3Data((String)vl), "s3Data");
        setupEpg(_epgMap, et -> ((SysTable)et).getN1Data(), (et, vl) -> ((SysTable)et).setN1Data(ctb(vl)), "n1Data");
        setupEpg(_epgMap, et -> ((SysTable)et).getN2Data(), (et, vl) -> ((SysTable)et).setN2Data(ctb(vl)), "n2Data");
        setupEpg(_epgMap, et -> ((SysTable)et).getN3Data(), (et, vl) -> ((SysTable)et).setN3Data(ctb(vl)), "n3Data");
        setupEpg(_epgMap, et -> ((SysTable)et).getVersionNo(), (et, vl) -> ((SysTable)et).setVersionNo(cti(vl)), "versionNo");
        setupEpg(_epgMap, et -> ((SysTable)et).getDelFlag(), (et, vl) -> ((SysTable)et).setDelFlag(cti(vl)), "delFlag");
        setupEpg(_epgMap, et -> ((SysTable)et).getRegisterDatetime(), (et, vl) -> ((SysTable)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((SysTable)et).getRegisterUser(), (et, vl) -> ((SysTable)et).setRegisterUser((String)vl), "registerUser");
        setupEpg(_epgMap, et -> ((SysTable)et).getRegisterProcess(), (et, vl) -> ((SysTable)et).setRegisterProcess((String)vl), "registerProcess");
        setupEpg(_epgMap, et -> ((SysTable)et).getUpdateDatetime(), (et, vl) -> ((SysTable)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((SysTable)et).getUpdateUser(), (et, vl) -> ((SysTable)et).setUpdateUser((String)vl), "updateUser");
        setupEpg(_epgMap, et -> ((SysTable)et).getUpdateProcess(), (et, vl) -> ((SysTable)et).setUpdateProcess((String)vl), "updateProcess");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "sys_table";
    protected final String _tablePropertyName = "sysTable";
    protected final TableSqlName _tableSqlName = new TableSqlName("sys_table", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnId = cci("id", "id", null, null, Integer.class, "id", null, true, true, true, "serial", 10, 0, "nextval('sys_table_id_seq'::regclass)", false, null, null, null, null, null, false);
    protected final ColumnInfo _columnTableName = cci("table_name", "table_name", null, null, String.class, "tableName", null, false, false, true, "varchar", 40, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnKey1 = cci("key_1", "key_1", null, null, String.class, "key1", null, false, false, true, "varchar", 40, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnKey2 = cci("key_2", "key_2", null, null, String.class, "key2", null, false, false, true, "varchar", 100, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnS1Data = cci("s1_data", "s1_data", null, null, String.class, "s1Data", null, false, false, false, "text", 2147483647, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnS2Data = cci("s2_data", "s2_data", null, null, String.class, "s2Data", null, false, false, false, "varchar", 100, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnS3Data = cci("s3_data", "s3_data", null, null, String.class, "s3Data", null, false, false, false, "varchar", 100, 0, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnN1Data = cci("n1_data", "n1_data", null, null, java.math.BigDecimal.class, "n1Data", null, false, false, false, "numeric", 20, 2, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnN2Data = cci("n2_data", "n2_data", null, null, java.math.BigDecimal.class, "n2Data", null, false, false, false, "numeric", 20, 2, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnN3Data = cci("n3_data", "n3_data", null, null, java.math.BigDecimal.class, "n3Data", null, false, false, false, "numeric", 20, 2, null, false, null, null, null, null, null, false);
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
     * table_name: {UQ+, NotNull, varchar(40)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnTableName() { return _columnTableName; }
    /**
     * key_1: {+UQ, NotNull, varchar(40)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnKey1() { return _columnKey1; }
    /**
     * key_2: {+UQ, NotNull, varchar(100)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnKey2() { return _columnKey2; }
    /**
     * s1_data: {text(2147483647)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnS1Data() { return _columnS1Data; }
    /**
     * s2_data: {varchar(100)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnS2Data() { return _columnS2Data; }
    /**
     * s3_data: {varchar(100)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnS3Data() { return _columnS3Data; }
    /**
     * n1_data: {numeric(20, 2)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnN1Data() { return _columnN1Data; }
    /**
     * n2_data: {numeric(20, 2)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnN2Data() { return _columnN2Data; }
    /**
     * n3_data: {numeric(20, 2)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnN3Data() { return _columnN3Data; }
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
        ls.add(columnTableName());
        ls.add(columnKey1());
        ls.add(columnKey2());
        ls.add(columnS1Data());
        ls.add(columnS2Data());
        ls.add(columnS3Data());
        ls.add(columnN1Data());
        ls.add(columnN2Data());
        ls.add(columnN3Data());
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
        ls.add(columnTableName());
        ls.add(columnKey1());
        ls.add(columnKey2());
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

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasSequence() { return true; }
    public String getSequenceName() { return "sys_table_id_seq"; }
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
    public String getEntityTypeName() { return "com.mssoftech.springreact.dbflute.exentity.SysTable"; }
    public String getConditionBeanTypeName() { return "com.mssoftech.springreact.dbflute.cbean.SysTableCB"; }
    public String getBehaviorTypeName() { return "com.mssoftech.springreact.dbflute.exbhv.SysTableBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<SysTable> getEntityType() { return SysTable.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public SysTable newEntity() { return new SysTable(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((SysTable)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((SysTable)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
