package com.mssoftech.springreact.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import com.mssoftech.springreact.dbflute.allcommon.EntityDefinedCommonColumn;
import com.mssoftech.springreact.dbflute.allcommon.DBMetaInstanceHandler;
import com.mssoftech.springreact.dbflute.exentity.*;

/**
 * The entity of user_table as TABLE. <br>
 * <pre>
 * [primary-key]
 *     id
 * 
 * [column]
 *     id, table_name, key_1, key_2, s1_data, s2_data, s3_data, n1_data, n2_data, n3_data, version_no, del_flag, register_datetime, register_user, register_process, update_datetime, update_user, update_process
 * 
 * [sequence]
 *     user_table_id_seq
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
 *     
 * 
 * [foreign property]
 *     
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer id = entity.getId();
 * String tableName = entity.getTableName();
 * String key1 = entity.getKey1();
 * String key2 = entity.getKey2();
 * String s1Data = entity.getS1Data();
 * String s2Data = entity.getS2Data();
 * String s3Data = entity.getS3Data();
 * java.math.BigDecimal n1Data = entity.getN1Data();
 * java.math.BigDecimal n2Data = entity.getN2Data();
 * java.math.BigDecimal n3Data = entity.getN3Data();
 * Integer versionNo = entity.getVersionNo();
 * Integer delFlag = entity.getDelFlag();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * String registerProcess = entity.getRegisterProcess();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * String updateProcess = entity.getUpdateProcess();
 * entity.setId(id);
 * entity.setTableName(tableName);
 * entity.setKey1(key1);
 * entity.setKey2(key2);
 * entity.setS1Data(s1Data);
 * entity.setS2Data(s2Data);
 * entity.setS3Data(s3Data);
 * entity.setN1Data(n1Data);
 * entity.setN2Data(n2Data);
 * entity.setN3Data(n3Data);
 * entity.setVersionNo(versionNo);
 * entity.setDelFlag(delFlag);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterUser(registerUser);
 * entity.setRegisterProcess(registerProcess);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateUser(updateUser);
 * entity.setUpdateProcess(updateProcess);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsUserTable extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** id: {PK, ID, NotNull, serial(10)} */
    protected Integer _id;

    /** table_name: {UQ+, NotNull, varchar(40)} */
    protected String _tableName;

    /** key_1: {+UQ, NotNull, varchar(40)} */
    protected String _key1;

    /** key_2: {+UQ, NotNull, varchar(100)} */
    protected String _key2;

    /** s1_data: {text(2147483647)} */
    protected String _s1Data;

    /** s2_data: {varchar(100)} */
    protected String _s2Data;

    /** s3_data: {varchar(100)} */
    protected String _s3Data;

    /** n1_data: {numeric(20, 2)} */
    protected java.math.BigDecimal _n1Data;

    /** n2_data: {numeric(20, 2)} */
    protected java.math.BigDecimal _n2Data;

    /** n3_data: {numeric(20, 2)} */
    protected java.math.BigDecimal _n3Data;

    /** version_no: {NotNull, int4(10)} */
    protected Integer _versionNo;

    /** del_flag: {+UQ, NotNull, int4(10), default=[0]} */
    protected Integer _delFlag;

    /** register_datetime: {NotNull, timestamp(29, 6)} */
    protected java.time.LocalDateTime _registerDatetime;

    /** register_user: {NotNull, varchar(30)} */
    protected String _registerUser;

    /** register_process: {NotNull, varchar(30)} */
    protected String _registerProcess;

    /** update_datetime: {NotNull, timestamp(29, 6)} */
    protected java.time.LocalDateTime _updateDatetime;

    /** update_user: {NotNull, varchar(30)} */
    protected String _updateUser;

    /** update_process: {NotNull, varchar(30)} */
    protected String _updateProcess;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "user_table";
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_id == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br>
     * You can update the entity by the key when entity update (NOT batch update).
     * @param tableName : UQ+, NotNull, varchar(40). (NotNull)
     * @param key1 : +UQ, NotNull, varchar(40). (NotNull)
     * @param key2 : +UQ, NotNull, varchar(100). (NotNull)
     * @param delFlag : +UQ, NotNull, int4(10), default=[0]. (NotNull)
     */
    public void uniqueBy(String tableName, String key1, String key2, Integer delFlag) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("tableName");
        __uniqueDrivenProperties.addPropertyName("key1");
        __uniqueDrivenProperties.addPropertyName("key2");
        __uniqueDrivenProperties.addPropertyName("delFlag");
        setTableName(tableName);setKey1(key1);setKey2(key2);setDelFlag(delFlag);
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsUserTable) {
            BsUserTable other = (BsUserTable)obj;
            if (!xSV(_id, other._id)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _id);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_id));
        sb.append(dm).append(xfND(_tableName));
        sb.append(dm).append(xfND(_key1));
        sb.append(dm).append(xfND(_key2));
        sb.append(dm).append(xfND(_s1Data));
        sb.append(dm).append(xfND(_s2Data));
        sb.append(dm).append(xfND(_s3Data));
        sb.append(dm).append(xfND(_n1Data));
        sb.append(dm).append(xfND(_n2Data));
        sb.append(dm).append(xfND(_n3Data));
        sb.append(dm).append(xfND(_versionNo));
        sb.append(dm).append(xfND(_delFlag));
        sb.append(dm).append(xfND(_registerDatetime));
        sb.append(dm).append(xfND(_registerUser));
        sb.append(dm).append(xfND(_registerProcess));
        sb.append(dm).append(xfND(_updateDatetime));
        sb.append(dm).append(xfND(_updateUser));
        sb.append(dm).append(xfND(_updateProcess));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        return "";
    }

    @Override
    public UserTable clone() {
        return (UserTable)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] id: {PK, ID, NotNull, serial(10)} <br>
     * @return The value of the column 'id'. (basically NotNull if selected: for the constraint)
     */
    public Integer getId() {
        checkSpecifiedProperty("id");
        return _id;
    }

    /**
     * [set] id: {PK, ID, NotNull, serial(10)} <br>
     * @param id The value of the column 'id'. (basically NotNull if update: for the constraint)
     */
    public void setId(Integer id) {
        registerModifiedProperty("id");
        _id = id;
    }

    /**
     * [get] table_name: {UQ+, NotNull, varchar(40)} <br>
     * @return The value of the column 'table_name'. (basically NotNull if selected: for the constraint)
     */
    public String getTableName() {
        checkSpecifiedProperty("tableName");
        return _tableName;
    }

    /**
     * [set] table_name: {UQ+, NotNull, varchar(40)} <br>
     * @param tableName The value of the column 'table_name'. (basically NotNull if update: for the constraint)
     */
    public void setTableName(String tableName) {
        registerModifiedProperty("tableName");
        _tableName = tableName;
    }

    /**
     * [get] key_1: {+UQ, NotNull, varchar(40)} <br>
     * @return The value of the column 'key_1'. (basically NotNull if selected: for the constraint)
     */
    public String getKey1() {
        checkSpecifiedProperty("key1");
        return _key1;
    }

    /**
     * [set] key_1: {+UQ, NotNull, varchar(40)} <br>
     * @param key1 The value of the column 'key_1'. (basically NotNull if update: for the constraint)
     */
    public void setKey1(String key1) {
        registerModifiedProperty("key1");
        _key1 = key1;
    }

    /**
     * [get] key_2: {+UQ, NotNull, varchar(100)} <br>
     * @return The value of the column 'key_2'. (basically NotNull if selected: for the constraint)
     */
    public String getKey2() {
        checkSpecifiedProperty("key2");
        return _key2;
    }

    /**
     * [set] key_2: {+UQ, NotNull, varchar(100)} <br>
     * @param key2 The value of the column 'key_2'. (basically NotNull if update: for the constraint)
     */
    public void setKey2(String key2) {
        registerModifiedProperty("key2");
        _key2 = key2;
    }

    /**
     * [get] s1_data: {text(2147483647)} <br>
     * @return The value of the column 's1_data'. (NullAllowed even if selected: for no constraint)
     */
    public String getS1Data() {
        checkSpecifiedProperty("s1Data");
        return _s1Data;
    }

    /**
     * [set] s1_data: {text(2147483647)} <br>
     * @param s1Data The value of the column 's1_data'. (NullAllowed: null update allowed for no constraint)
     */
    public void setS1Data(String s1Data) {
        registerModifiedProperty("s1Data");
        _s1Data = s1Data;
    }

    /**
     * [get] s2_data: {varchar(100)} <br>
     * @return The value of the column 's2_data'. (NullAllowed even if selected: for no constraint)
     */
    public String getS2Data() {
        checkSpecifiedProperty("s2Data");
        return _s2Data;
    }

    /**
     * [set] s2_data: {varchar(100)} <br>
     * @param s2Data The value of the column 's2_data'. (NullAllowed: null update allowed for no constraint)
     */
    public void setS2Data(String s2Data) {
        registerModifiedProperty("s2Data");
        _s2Data = s2Data;
    }

    /**
     * [get] s3_data: {varchar(100)} <br>
     * @return The value of the column 's3_data'. (NullAllowed even if selected: for no constraint)
     */
    public String getS3Data() {
        checkSpecifiedProperty("s3Data");
        return _s3Data;
    }

    /**
     * [set] s3_data: {varchar(100)} <br>
     * @param s3Data The value of the column 's3_data'. (NullAllowed: null update allowed for no constraint)
     */
    public void setS3Data(String s3Data) {
        registerModifiedProperty("s3Data");
        _s3Data = s3Data;
    }

    /**
     * [get] n1_data: {numeric(20, 2)} <br>
     * @return The value of the column 'n1_data'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getN1Data() {
        checkSpecifiedProperty("n1Data");
        return _n1Data;
    }

    /**
     * [set] n1_data: {numeric(20, 2)} <br>
     * @param n1Data The value of the column 'n1_data'. (NullAllowed: null update allowed for no constraint)
     */
    public void setN1Data(java.math.BigDecimal n1Data) {
        registerModifiedProperty("n1Data");
        _n1Data = n1Data;
    }

    /**
     * [get] n2_data: {numeric(20, 2)} <br>
     * @return The value of the column 'n2_data'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getN2Data() {
        checkSpecifiedProperty("n2Data");
        return _n2Data;
    }

    /**
     * [set] n2_data: {numeric(20, 2)} <br>
     * @param n2Data The value of the column 'n2_data'. (NullAllowed: null update allowed for no constraint)
     */
    public void setN2Data(java.math.BigDecimal n2Data) {
        registerModifiedProperty("n2Data");
        _n2Data = n2Data;
    }

    /**
     * [get] n3_data: {numeric(20, 2)} <br>
     * @return The value of the column 'n3_data'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getN3Data() {
        checkSpecifiedProperty("n3Data");
        return _n3Data;
    }

    /**
     * [set] n3_data: {numeric(20, 2)} <br>
     * @param n3Data The value of the column 'n3_data'. (NullAllowed: null update allowed for no constraint)
     */
    public void setN3Data(java.math.BigDecimal n3Data) {
        registerModifiedProperty("n3Data");
        _n3Data = n3Data;
    }

    /**
     * [get] version_no: {NotNull, int4(10)} <br>
     * @return The value of the column 'version_no'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVersionNo() {
        checkSpecifiedProperty("versionNo");
        return _versionNo;
    }

    /**
     * [set] version_no: {NotNull, int4(10)} <br>
     * @param versionNo The value of the column 'version_no'. (basically NotNull if update: for the constraint)
     */
    public void setVersionNo(Integer versionNo) {
        registerModifiedProperty("versionNo");
        _versionNo = versionNo;
    }

    /**
     * [get] del_flag: {+UQ, NotNull, int4(10), default=[0]} <br>
     * @return The value of the column 'del_flag'. (basically NotNull if selected: for the constraint)
     */
    public Integer getDelFlag() {
        checkSpecifiedProperty("delFlag");
        return _delFlag;
    }

    /**
     * [set] del_flag: {+UQ, NotNull, int4(10), default=[0]} <br>
     * @param delFlag The value of the column 'del_flag'. (basically NotNull if update: for the constraint)
     */
    public void setDelFlag(Integer delFlag) {
        registerModifiedProperty("delFlag");
        _delFlag = delFlag;
    }

    /**
     * [get] register_datetime: {NotNull, timestamp(29, 6)} <br>
     * @return The value of the column 'register_datetime'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getRegisterDatetime() {
        checkSpecifiedProperty("registerDatetime");
        return _registerDatetime;
    }

    /**
     * [set] register_datetime: {NotNull, timestamp(29, 6)} <br>
     * @param registerDatetime The value of the column 'register_datetime'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterDatetime(java.time.LocalDateTime registerDatetime) {
        registerModifiedProperty("registerDatetime");
        _registerDatetime = registerDatetime;
    }

    /**
     * [get] register_user: {NotNull, varchar(30)} <br>
     * @return The value of the column 'register_user'. (basically NotNull if selected: for the constraint)
     */
    public String getRegisterUser() {
        checkSpecifiedProperty("registerUser");
        return _registerUser;
    }

    /**
     * [set] register_user: {NotNull, varchar(30)} <br>
     * @param registerUser The value of the column 'register_user'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterUser(String registerUser) {
        registerModifiedProperty("registerUser");
        _registerUser = registerUser;
    }

    /**
     * [get] register_process: {NotNull, varchar(30)} <br>
     * @return The value of the column 'register_process'. (basically NotNull if selected: for the constraint)
     */
    public String getRegisterProcess() {
        checkSpecifiedProperty("registerProcess");
        return _registerProcess;
    }

    /**
     * [set] register_process: {NotNull, varchar(30)} <br>
     * @param registerProcess The value of the column 'register_process'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterProcess(String registerProcess) {
        registerModifiedProperty("registerProcess");
        _registerProcess = registerProcess;
    }

    /**
     * [get] update_datetime: {NotNull, timestamp(29, 6)} <br>
     * @return The value of the column 'update_datetime'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getUpdateDatetime() {
        checkSpecifiedProperty("updateDatetime");
        return _updateDatetime;
    }

    /**
     * [set] update_datetime: {NotNull, timestamp(29, 6)} <br>
     * @param updateDatetime The value of the column 'update_datetime'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateDatetime(java.time.LocalDateTime updateDatetime) {
        registerModifiedProperty("updateDatetime");
        _updateDatetime = updateDatetime;
    }

    /**
     * [get] update_user: {NotNull, varchar(30)} <br>
     * @return The value of the column 'update_user'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdateUser() {
        checkSpecifiedProperty("updateUser");
        return _updateUser;
    }

    /**
     * [set] update_user: {NotNull, varchar(30)} <br>
     * @param updateUser The value of the column 'update_user'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateUser(String updateUser) {
        registerModifiedProperty("updateUser");
        _updateUser = updateUser;
    }

    /**
     * [get] update_process: {NotNull, varchar(30)} <br>
     * @return The value of the column 'update_process'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdateProcess() {
        checkSpecifiedProperty("updateProcess");
        return _updateProcess;
    }

    /**
     * [set] update_process: {NotNull, varchar(30)} <br>
     * @param updateProcess The value of the column 'update_process'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateProcess(String updateProcess) {
        registerModifiedProperty("updateProcess");
        _updateProcess = updateProcess;
    }
}
