package com.mssoftech.springreact.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import com.mssoftech.springreact.dbflute.allcommon.EntityDefinedCommonColumn;
import com.mssoftech.springreact.dbflute.allcommon.DBMetaInstanceHandler;
import com.mssoftech.springreact.dbflute.exentity.*;

/**
 * The entity of session as TABLE. <br>
 * <pre>
 * [primary-key]
 *     id
 * 
 * [column]
 *     id, uuid, login_id, comp_id, fy, grp, data, version_no, del_flag, register_datetime, register_user, register_process, update_datetime, update_user, update_process
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
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer id = entity.getId();
 * String uuid = entity.getUuid();
 * Integer loginId = entity.getLoginId();
 * Integer compId = entity.getCompId();
 * String fy = entity.getFy();
 * String grp = entity.getGrp();
 * String data = entity.getData();
 * Integer versionNo = entity.getVersionNo();
 * Integer delFlag = entity.getDelFlag();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * String registerProcess = entity.getRegisterProcess();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * String updateProcess = entity.getUpdateProcess();
 * entity.setId(id);
 * entity.setUuid(uuid);
 * entity.setLoginId(loginId);
 * entity.setCompId(compId);
 * entity.setFy(fy);
 * entity.setGrp(grp);
 * entity.setData(data);
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
public abstract class BsSession extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

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

    /** uuid: {UQ, NotNull, varchar(50)} */
    protected String _uuid;

    /** login_id: {int4(10), FK to login} */
    protected Integer _loginId;

    /** comp_id: {int4(10)} */
    protected Integer _compId;

    /** fy: {bpchar(4)} */
    protected String _fy;

    /** grp: {varchar(5)} */
    protected String _grp;

    /** data: {varchar(255)} */
    protected String _data;

    /** version_no: {NotNull, int4(10)} */
    protected Integer _versionNo;

    /** del_flag: {NotNull, int4(10), default=[0]} */
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
        return "session";
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
     * @param uuid : UQ, NotNull, varchar(50). (NotNull)
     */
    public void uniqueBy(String uuid) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("uuid");
        setUuid(uuid);
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** login by my login_id, named 'login'. */
    protected OptionalEntity<Login> _login;

    /**
     * [get] login by my login_id, named 'login'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'login'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Login> getLogin() {
        if (_login == null) { _login = OptionalEntity.relationEmpty(this, "login"); }
        return _login;
    }

    /**
     * [set] login by my login_id, named 'login'.
     * @param login The entity of foreign property 'login'. (NullAllowed)
     */
    public void setLogin(OptionalEntity<Login> login) {
        _login = login;
    }

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
        if (obj instanceof BsSession) {
            BsSession other = (BsSession)obj;
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
        StringBuilder sb = new StringBuilder();
        if (_login != null && _login.isPresent())
        { sb.append(li).append(xbRDS(_login, "login")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_id));
        sb.append(dm).append(xfND(_uuid));
        sb.append(dm).append(xfND(_loginId));
        sb.append(dm).append(xfND(_compId));
        sb.append(dm).append(xfND(_fy));
        sb.append(dm).append(xfND(_grp));
        sb.append(dm).append(xfND(_data));
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
        StringBuilder sb = new StringBuilder();
        if (_login != null && _login.isPresent())
        { sb.append(dm).append("login"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Session clone() {
        return (Session)super.clone();
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
     * [get] uuid: {UQ, NotNull, varchar(50)} <br>
     * @return The value of the column 'uuid'. (basically NotNull if selected: for the constraint)
     */
    public String getUuid() {
        checkSpecifiedProperty("uuid");
        return _uuid;
    }

    /**
     * [set] uuid: {UQ, NotNull, varchar(50)} <br>
     * @param uuid The value of the column 'uuid'. (basically NotNull if update: for the constraint)
     */
    public void setUuid(String uuid) {
        registerModifiedProperty("uuid");
        _uuid = uuid;
    }

    /**
     * [get] login_id: {int4(10), FK to login} <br>
     * @return The value of the column 'login_id'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getLoginId() {
        checkSpecifiedProperty("loginId");
        return _loginId;
    }

    /**
     * [set] login_id: {int4(10), FK to login} <br>
     * @param loginId The value of the column 'login_id'. (NullAllowed: null update allowed for no constraint)
     */
    public void setLoginId(Integer loginId) {
        registerModifiedProperty("loginId");
        _loginId = loginId;
    }

    /**
     * [get] comp_id: {int4(10)} <br>
     * @return The value of the column 'comp_id'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getCompId() {
        checkSpecifiedProperty("compId");
        return _compId;
    }

    /**
     * [set] comp_id: {int4(10)} <br>
     * @param compId The value of the column 'comp_id'. (NullAllowed: null update allowed for no constraint)
     */
    public void setCompId(Integer compId) {
        registerModifiedProperty("compId");
        _compId = compId;
    }

    /**
     * [get] fy: {bpchar(4)} <br>
     * @return The value of the column 'fy'. (NullAllowed even if selected: for no constraint)
     */
    public String getFy() {
        checkSpecifiedProperty("fy");
        return _fy;
    }

    /**
     * [set] fy: {bpchar(4)} <br>
     * @param fy The value of the column 'fy'. (NullAllowed: null update allowed for no constraint)
     */
    public void setFy(String fy) {
        registerModifiedProperty("fy");
        _fy = fy;
    }

    /**
     * [get] grp: {varchar(5)} <br>
     * @return The value of the column 'grp'. (NullAllowed even if selected: for no constraint)
     */
    public String getGrp() {
        checkSpecifiedProperty("grp");
        return _grp;
    }

    /**
     * [set] grp: {varchar(5)} <br>
     * @param grp The value of the column 'grp'. (NullAllowed: null update allowed for no constraint)
     */
    public void setGrp(String grp) {
        registerModifiedProperty("grp");
        _grp = grp;
    }

    /**
     * [get] data: {varchar(255)} <br>
     * @return The value of the column 'data'. (NullAllowed even if selected: for no constraint)
     */
    public String getData() {
        checkSpecifiedProperty("data");
        return _data;
    }

    /**
     * [set] data: {varchar(255)} <br>
     * @param data The value of the column 'data'. (NullAllowed: null update allowed for no constraint)
     */
    public void setData(String data) {
        registerModifiedProperty("data");
        _data = data;
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
     * [get] del_flag: {NotNull, int4(10), default=[0]} <br>
     * @return The value of the column 'del_flag'. (basically NotNull if selected: for the constraint)
     */
    public Integer getDelFlag() {
        checkSpecifiedProperty("delFlag");
        return _delFlag;
    }

    /**
     * [set] del_flag: {NotNull, int4(10), default=[0]} <br>
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
