package com.mssoftech.springreact.dbflute.cbean.cq.bs;

import java.util.*;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.ckey.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.ordering.*;
import org.dbflute.cbean.scoping.*;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.dbmeta.DBMetaProvider;
import com.mssoftech.springreact.dbflute.allcommon.*;
import com.mssoftech.springreact.dbflute.cbean.*;
import com.mssoftech.springreact.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of session.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsSessionCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsSessionCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    public String asTableDbName() {
        return "session";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @param id The value of id as equal. (NullAllowed: if null, no condition)
     */
    public void setId_Equal(Integer id) {
        doSetId_Equal(id);
    }

    protected void doSetId_Equal(Integer id) {
        regId(CK_EQ, id);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @param id The value of id as notEqual. (NullAllowed: if null, no condition)
     */
    public void setId_NotEqual(Integer id) {
        doSetId_NotEqual(id);
    }

    protected void doSetId_NotEqual(Integer id) {
        regId(CK_NES, id);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @param id The value of id as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setId_GreaterThan(Integer id) {
        regId(CK_GT, id);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @param id The value of id as lessThan. (NullAllowed: if null, no condition)
     */
    public void setId_LessThan(Integer id) {
        regId(CK_LT, id);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @param id The value of id as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setId_GreaterEqual(Integer id) {
        regId(CK_GE, id);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @param id The value of id as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setId_LessEqual(Integer id) {
        regId(CK_LE, id);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @param minNumber The min number of id. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of id. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @param minNumber The min number of id. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of id. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueId(), "id", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @param idList The collection of id as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setId_InScope(Collection<Integer> idList) {
        doSetId_InScope(idList);
    }

    protected void doSetId_InScope(Collection<Integer> idList) {
        regINS(CK_INS, cTL(idList), xgetCValueId(), "id");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * id: {PK, ID, NotNull, serial(10)}
     * @param idList The collection of id as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setId_NotInScope(Collection<Integer> idList) {
        doSetId_NotInScope(idList);
    }

    protected void doSetId_NotInScope(Collection<Integer> idList) {
        regINS(CK_NINS, cTL(idList), xgetCValueId(), "id");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * id: {PK, ID, NotNull, serial(10)}
     */
    public void setId_IsNull() { regId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * id: {PK, ID, NotNull, serial(10)}
     */
    public void setId_IsNotNull() { regId(CK_ISNN, DOBJ); }

    protected void regId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueId(), "id"); }
    protected abstract ConditionValue xgetCValueId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * uuid: {UQ, NotNull, varchar(50)}
     * @param uuid The value of uuid as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setUuid_Equal(String uuid) {
        doSetUuid_Equal(fRES(uuid));
    }

    protected void doSetUuid_Equal(String uuid) {
        regUuid(CK_EQ, uuid);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * uuid: {UQ, NotNull, varchar(50)}
     * @param uuid The value of uuid as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUuid_NotEqual(String uuid) {
        doSetUuid_NotEqual(fRES(uuid));
    }

    protected void doSetUuid_NotEqual(String uuid) {
        regUuid(CK_NES, uuid);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * uuid: {UQ, NotNull, varchar(50)}
     * @param uuid The value of uuid as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUuid_GreaterThan(String uuid) {
        regUuid(CK_GT, fRES(uuid));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * uuid: {UQ, NotNull, varchar(50)}
     * @param uuid The value of uuid as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUuid_LessThan(String uuid) {
        regUuid(CK_LT, fRES(uuid));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * uuid: {UQ, NotNull, varchar(50)}
     * @param uuid The value of uuid as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUuid_GreaterEqual(String uuid) {
        regUuid(CK_GE, fRES(uuid));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * uuid: {UQ, NotNull, varchar(50)}
     * @param uuid The value of uuid as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUuid_LessEqual(String uuid) {
        regUuid(CK_LE, fRES(uuid));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * uuid: {UQ, NotNull, varchar(50)}
     * @param uuidList The collection of uuid as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUuid_InScope(Collection<String> uuidList) {
        doSetUuid_InScope(uuidList);
    }

    protected void doSetUuid_InScope(Collection<String> uuidList) {
        regINS(CK_INS, cTL(uuidList), xgetCValueUuid(), "uuid");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * uuid: {UQ, NotNull, varchar(50)}
     * @param uuidList The collection of uuid as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUuid_NotInScope(Collection<String> uuidList) {
        doSetUuid_NotInScope(uuidList);
    }

    protected void doSetUuid_NotInScope(Collection<String> uuidList) {
        regINS(CK_NINS, cTL(uuidList), xgetCValueUuid(), "uuid");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * uuid: {UQ, NotNull, varchar(50)} <br>
     * <pre>e.g. setUuid_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param uuid The value of uuid as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUuid_LikeSearch(String uuid, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUuid_LikeSearch(uuid, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * uuid: {UQ, NotNull, varchar(50)} <br>
     * <pre>e.g. setUuid_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param uuid The value of uuid as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setUuid_LikeSearch(String uuid, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(uuid), xgetCValueUuid(), "uuid", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * uuid: {UQ, NotNull, varchar(50)}
     * @param uuid The value of uuid as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUuid_NotLikeSearch(String uuid, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUuid_NotLikeSearch(uuid, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * uuid: {UQ, NotNull, varchar(50)}
     * @param uuid The value of uuid as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setUuid_NotLikeSearch(String uuid, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(uuid), xgetCValueUuid(), "uuid", likeSearchOption);
    }

    protected void regUuid(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUuid(), "uuid"); }
    protected abstract ConditionValue xgetCValueUuid();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * login_id: {int4(10), FK to login}
     * @param loginId The value of loginId as equal. (NullAllowed: if null, no condition)
     */
    public void setLoginId_Equal(Integer loginId) {
        doSetLoginId_Equal(loginId);
    }

    protected void doSetLoginId_Equal(Integer loginId) {
        regLoginId(CK_EQ, loginId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * login_id: {int4(10), FK to login}
     * @param loginId The value of loginId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setLoginId_NotEqual(Integer loginId) {
        doSetLoginId_NotEqual(loginId);
    }

    protected void doSetLoginId_NotEqual(Integer loginId) {
        regLoginId(CK_NES, loginId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * login_id: {int4(10), FK to login}
     * @param loginId The value of loginId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setLoginId_GreaterThan(Integer loginId) {
        regLoginId(CK_GT, loginId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * login_id: {int4(10), FK to login}
     * @param loginId The value of loginId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setLoginId_LessThan(Integer loginId) {
        regLoginId(CK_LT, loginId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * login_id: {int4(10), FK to login}
     * @param loginId The value of loginId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setLoginId_GreaterEqual(Integer loginId) {
        regLoginId(CK_GE, loginId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * login_id: {int4(10), FK to login}
     * @param loginId The value of loginId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setLoginId_LessEqual(Integer loginId) {
        regLoginId(CK_LE, loginId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * login_id: {int4(10), FK to login}
     * @param minNumber The min number of loginId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of loginId. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setLoginId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setLoginId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * login_id: {int4(10), FK to login}
     * @param minNumber The min number of loginId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of loginId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setLoginId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueLoginId(), "login_id", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * login_id: {int4(10), FK to login}
     * @param loginIdList The collection of loginId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setLoginId_InScope(Collection<Integer> loginIdList) {
        doSetLoginId_InScope(loginIdList);
    }

    protected void doSetLoginId_InScope(Collection<Integer> loginIdList) {
        regINS(CK_INS, cTL(loginIdList), xgetCValueLoginId(), "login_id");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * login_id: {int4(10), FK to login}
     * @param loginIdList The collection of loginId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setLoginId_NotInScope(Collection<Integer> loginIdList) {
        doSetLoginId_NotInScope(loginIdList);
    }

    protected void doSetLoginId_NotInScope(Collection<Integer> loginIdList) {
        regINS(CK_NINS, cTL(loginIdList), xgetCValueLoginId(), "login_id");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * login_id: {int4(10), FK to login}
     */
    public void setLoginId_IsNull() { regLoginId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * login_id: {int4(10), FK to login}
     */
    public void setLoginId_IsNotNull() { regLoginId(CK_ISNN, DOBJ); }

    protected void regLoginId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueLoginId(), "login_id"); }
    protected abstract ConditionValue xgetCValueLoginId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * role: {varchar(5)}
     * @param role The value of role as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setRole_Equal(String role) {
        doSetRole_Equal(fRES(role));
    }

    protected void doSetRole_Equal(String role) {
        regRole(CK_EQ, role);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * role: {varchar(5)}
     * @param role The value of role as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRole_NotEqual(String role) {
        doSetRole_NotEqual(fRES(role));
    }

    protected void doSetRole_NotEqual(String role) {
        regRole(CK_NES, role);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * role: {varchar(5)}
     * @param role The value of role as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setRole_GreaterThan(String role) {
        regRole(CK_GT, fRES(role));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * role: {varchar(5)}
     * @param role The value of role as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setRole_LessThan(String role) {
        regRole(CK_LT, fRES(role));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * role: {varchar(5)}
     * @param role The value of role as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRole_GreaterEqual(String role) {
        regRole(CK_GE, fRES(role));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * role: {varchar(5)}
     * @param role The value of role as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRole_LessEqual(String role) {
        regRole(CK_LE, fRES(role));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * role: {varchar(5)}
     * @param roleList The collection of role as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setRole_InScope(Collection<String> roleList) {
        doSetRole_InScope(roleList);
    }

    protected void doSetRole_InScope(Collection<String> roleList) {
        regINS(CK_INS, cTL(roleList), xgetCValueRole(), "role");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * role: {varchar(5)}
     * @param roleList The collection of role as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setRole_NotInScope(Collection<String> roleList) {
        doSetRole_NotInScope(roleList);
    }

    protected void doSetRole_NotInScope(Collection<String> roleList) {
        regINS(CK_NINS, cTL(roleList), xgetCValueRole(), "role");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * role: {varchar(5)} <br>
     * <pre>e.g. setRole_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param role The value of role as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRole_LikeSearch(String role, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRole_LikeSearch(role, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * role: {varchar(5)} <br>
     * <pre>e.g. setRole_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param role The value of role as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setRole_LikeSearch(String role, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(role), xgetCValueRole(), "role", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * role: {varchar(5)}
     * @param role The value of role as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRole_NotLikeSearch(String role, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRole_NotLikeSearch(role, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * role: {varchar(5)}
     * @param role The value of role as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setRole_NotLikeSearch(String role, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(role), xgetCValueRole(), "role", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * role: {varchar(5)}
     */
    public void setRole_IsNull() { regRole(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * role: {varchar(5)}
     */
    public void setRole_IsNullOrEmpty() { regRole(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * role: {varchar(5)}
     */
    public void setRole_IsNotNull() { regRole(CK_ISNN, DOBJ); }

    protected void regRole(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRole(), "role"); }
    protected abstract ConditionValue xgetCValueRole();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * data: {varchar(255)}
     * @param data The value of data as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setData_Equal(String data) {
        doSetData_Equal(fRES(data));
    }

    protected void doSetData_Equal(String data) {
        regData(CK_EQ, data);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * data: {varchar(255)}
     * @param data The value of data as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setData_NotEqual(String data) {
        doSetData_NotEqual(fRES(data));
    }

    protected void doSetData_NotEqual(String data) {
        regData(CK_NES, data);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * data: {varchar(255)}
     * @param data The value of data as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setData_GreaterThan(String data) {
        regData(CK_GT, fRES(data));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * data: {varchar(255)}
     * @param data The value of data as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setData_LessThan(String data) {
        regData(CK_LT, fRES(data));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * data: {varchar(255)}
     * @param data The value of data as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setData_GreaterEqual(String data) {
        regData(CK_GE, fRES(data));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * data: {varchar(255)}
     * @param data The value of data as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setData_LessEqual(String data) {
        regData(CK_LE, fRES(data));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * data: {varchar(255)}
     * @param dataList The collection of data as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setData_InScope(Collection<String> dataList) {
        doSetData_InScope(dataList);
    }

    protected void doSetData_InScope(Collection<String> dataList) {
        regINS(CK_INS, cTL(dataList), xgetCValueData(), "data");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * data: {varchar(255)}
     * @param dataList The collection of data as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setData_NotInScope(Collection<String> dataList) {
        doSetData_NotInScope(dataList);
    }

    protected void doSetData_NotInScope(Collection<String> dataList) {
        regINS(CK_NINS, cTL(dataList), xgetCValueData(), "data");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * data: {varchar(255)} <br>
     * <pre>e.g. setData_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param data The value of data as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setData_LikeSearch(String data, ConditionOptionCall<LikeSearchOption> opLambda) {
        setData_LikeSearch(data, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * data: {varchar(255)} <br>
     * <pre>e.g. setData_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param data The value of data as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setData_LikeSearch(String data, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(data), xgetCValueData(), "data", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * data: {varchar(255)}
     * @param data The value of data as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setData_NotLikeSearch(String data, ConditionOptionCall<LikeSearchOption> opLambda) {
        setData_NotLikeSearch(data, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * data: {varchar(255)}
     * @param data The value of data as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setData_NotLikeSearch(String data, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(data), xgetCValueData(), "data", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * data: {varchar(255)}
     */
    public void setData_IsNull() { regData(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * data: {varchar(255)}
     */
    public void setData_IsNullOrEmpty() { regData(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * data: {varchar(255)}
     */
    public void setData_IsNotNull() { regData(CK_ISNN, DOBJ); }

    protected void regData(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueData(), "data"); }
    protected abstract ConditionValue xgetCValueData();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * version_no: {NotNull, int4(10)}
     * @param versionNo The value of versionNo as equal. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_Equal(Integer versionNo) {
        doSetVersionNo_Equal(versionNo);
    }

    protected void doSetVersionNo_Equal(Integer versionNo) {
        regVersionNo(CK_EQ, versionNo);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * version_no: {NotNull, int4(10)}
     * @param versionNo The value of versionNo as notEqual. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_NotEqual(Integer versionNo) {
        doSetVersionNo_NotEqual(versionNo);
    }

    protected void doSetVersionNo_NotEqual(Integer versionNo) {
        regVersionNo(CK_NES, versionNo);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * version_no: {NotNull, int4(10)}
     * @param versionNo The value of versionNo as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_GreaterThan(Integer versionNo) {
        regVersionNo(CK_GT, versionNo);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * version_no: {NotNull, int4(10)}
     * @param versionNo The value of versionNo as lessThan. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_LessThan(Integer versionNo) {
        regVersionNo(CK_LT, versionNo);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * version_no: {NotNull, int4(10)}
     * @param versionNo The value of versionNo as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_GreaterEqual(Integer versionNo) {
        regVersionNo(CK_GE, versionNo);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * version_no: {NotNull, int4(10)}
     * @param versionNo The value of versionNo as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_LessEqual(Integer versionNo) {
        regVersionNo(CK_LE, versionNo);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * version_no: {NotNull, int4(10)}
     * @param minNumber The min number of versionNo. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of versionNo. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setVersionNo_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setVersionNo_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * version_no: {NotNull, int4(10)}
     * @param minNumber The min number of versionNo. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of versionNo. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setVersionNo_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueVersionNo(), "version_no", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * version_no: {NotNull, int4(10)}
     * @param versionNoList The collection of versionNo as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setVersionNo_InScope(Collection<Integer> versionNoList) {
        doSetVersionNo_InScope(versionNoList);
    }

    protected void doSetVersionNo_InScope(Collection<Integer> versionNoList) {
        regINS(CK_INS, cTL(versionNoList), xgetCValueVersionNo(), "version_no");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * version_no: {NotNull, int4(10)}
     * @param versionNoList The collection of versionNo as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setVersionNo_NotInScope(Collection<Integer> versionNoList) {
        doSetVersionNo_NotInScope(versionNoList);
    }

    protected void doSetVersionNo_NotInScope(Collection<Integer> versionNoList) {
        regINS(CK_NINS, cTL(versionNoList), xgetCValueVersionNo(), "version_no");
    }

    protected void regVersionNo(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVersionNo(), "version_no"); }
    protected abstract ConditionValue xgetCValueVersionNo();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * del_flag: {NotNull, int4(10), default=[0]}
     * @param delFlag The value of delFlag as equal. (NullAllowed: if null, no condition)
     */
    public void setDelFlag_Equal(Integer delFlag) {
        doSetDelFlag_Equal(delFlag);
    }

    protected void doSetDelFlag_Equal(Integer delFlag) {
        regDelFlag(CK_EQ, delFlag);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * del_flag: {NotNull, int4(10), default=[0]}
     * @param delFlag The value of delFlag as notEqual. (NullAllowed: if null, no condition)
     */
    public void setDelFlag_NotEqual(Integer delFlag) {
        doSetDelFlag_NotEqual(delFlag);
    }

    protected void doSetDelFlag_NotEqual(Integer delFlag) {
        regDelFlag(CK_NES, delFlag);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * del_flag: {NotNull, int4(10), default=[0]}
     * @param delFlag The value of delFlag as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setDelFlag_GreaterThan(Integer delFlag) {
        regDelFlag(CK_GT, delFlag);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * del_flag: {NotNull, int4(10), default=[0]}
     * @param delFlag The value of delFlag as lessThan. (NullAllowed: if null, no condition)
     */
    public void setDelFlag_LessThan(Integer delFlag) {
        regDelFlag(CK_LT, delFlag);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * del_flag: {NotNull, int4(10), default=[0]}
     * @param delFlag The value of delFlag as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setDelFlag_GreaterEqual(Integer delFlag) {
        regDelFlag(CK_GE, delFlag);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * del_flag: {NotNull, int4(10), default=[0]}
     * @param delFlag The value of delFlag as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setDelFlag_LessEqual(Integer delFlag) {
        regDelFlag(CK_LE, delFlag);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * del_flag: {NotNull, int4(10), default=[0]}
     * @param minNumber The min number of delFlag. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of delFlag. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDelFlag_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDelFlag_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * del_flag: {NotNull, int4(10), default=[0]}
     * @param minNumber The min number of delFlag. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of delFlag. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDelFlag_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDelFlag(), "del_flag", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * del_flag: {NotNull, int4(10), default=[0]}
     * @param delFlagList The collection of delFlag as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setDelFlag_InScope(Collection<Integer> delFlagList) {
        doSetDelFlag_InScope(delFlagList);
    }

    protected void doSetDelFlag_InScope(Collection<Integer> delFlagList) {
        regINS(CK_INS, cTL(delFlagList), xgetCValueDelFlag(), "del_flag");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * del_flag: {NotNull, int4(10), default=[0]}
     * @param delFlagList The collection of delFlag as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setDelFlag_NotInScope(Collection<Integer> delFlagList) {
        doSetDelFlag_NotInScope(delFlagList);
    }

    protected void doSetDelFlag_NotInScope(Collection<Integer> delFlagList) {
        regINS(CK_NINS, cTL(delFlagList), xgetCValueDelFlag(), "del_flag");
    }

    protected void regDelFlag(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDelFlag(), "del_flag"); }
    protected abstract ConditionValue xgetCValueDelFlag();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * register_datetime: {NotNull, timestamp(29, 6)}
     * @param registerDatetime The value of registerDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setRegisterDatetime_Equal(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_EQ,  registerDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * register_datetime: {NotNull, timestamp(29, 6)}
     * @param registerDatetime The value of registerDatetime as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setRegisterDatetime_GreaterThan(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_GT,  registerDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * register_datetime: {NotNull, timestamp(29, 6)}
     * @param registerDatetime The value of registerDatetime as lessThan. (NullAllowed: if null, no condition)
     */
    public void setRegisterDatetime_LessThan(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_LT,  registerDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * register_datetime: {NotNull, timestamp(29, 6)}
     * @param registerDatetime The value of registerDatetime as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setRegisterDatetime_GreaterEqual(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_GE,  registerDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * register_datetime: {NotNull, timestamp(29, 6)}
     * @param registerDatetime The value of registerDatetime as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setRegisterDatetime_LessEqual(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_LE, registerDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * register_datetime: {NotNull, timestamp(29, 6)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setRegisterDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setRegisterDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * register_datetime: {NotNull, timestamp(29, 6)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setRegisterDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "register_datetime"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueRegisterDatetime(), nm, op);
    }

    protected void regRegisterDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterDatetime(), "register_datetime"); }
    protected abstract ConditionValue xgetCValueRegisterDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * register_user: {NotNull, varchar(30)}
     * @param registerUser The value of registerUser as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_Equal(String registerUser) {
        doSetRegisterUser_Equal(fRES(registerUser));
    }

    protected void doSetRegisterUser_Equal(String registerUser) {
        regRegisterUser(CK_EQ, registerUser);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * register_user: {NotNull, varchar(30)}
     * @param registerUser The value of registerUser as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_NotEqual(String registerUser) {
        doSetRegisterUser_NotEqual(fRES(registerUser));
    }

    protected void doSetRegisterUser_NotEqual(String registerUser) {
        regRegisterUser(CK_NES, registerUser);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * register_user: {NotNull, varchar(30)}
     * @param registerUser The value of registerUser as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_GreaterThan(String registerUser) {
        regRegisterUser(CK_GT, fRES(registerUser));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * register_user: {NotNull, varchar(30)}
     * @param registerUser The value of registerUser as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_LessThan(String registerUser) {
        regRegisterUser(CK_LT, fRES(registerUser));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * register_user: {NotNull, varchar(30)}
     * @param registerUser The value of registerUser as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_GreaterEqual(String registerUser) {
        regRegisterUser(CK_GE, fRES(registerUser));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * register_user: {NotNull, varchar(30)}
     * @param registerUser The value of registerUser as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_LessEqual(String registerUser) {
        regRegisterUser(CK_LE, fRES(registerUser));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * register_user: {NotNull, varchar(30)}
     * @param registerUserList The collection of registerUser as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_InScope(Collection<String> registerUserList) {
        doSetRegisterUser_InScope(registerUserList);
    }

    protected void doSetRegisterUser_InScope(Collection<String> registerUserList) {
        regINS(CK_INS, cTL(registerUserList), xgetCValueRegisterUser(), "register_user");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * register_user: {NotNull, varchar(30)}
     * @param registerUserList The collection of registerUser as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_NotInScope(Collection<String> registerUserList) {
        doSetRegisterUser_NotInScope(registerUserList);
    }

    protected void doSetRegisterUser_NotInScope(Collection<String> registerUserList) {
        regINS(CK_NINS, cTL(registerUserList), xgetCValueRegisterUser(), "register_user");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * register_user: {NotNull, varchar(30)} <br>
     * <pre>e.g. setRegisterUser_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param registerUser The value of registerUser as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterUser_LikeSearch(String registerUser, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterUser_LikeSearch(registerUser, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * register_user: {NotNull, varchar(30)} <br>
     * <pre>e.g. setRegisterUser_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param registerUser The value of registerUser as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setRegisterUser_LikeSearch(String registerUser, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(registerUser), xgetCValueRegisterUser(), "register_user", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * register_user: {NotNull, varchar(30)}
     * @param registerUser The value of registerUser as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterUser_NotLikeSearch(String registerUser, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterUser_NotLikeSearch(registerUser, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * register_user: {NotNull, varchar(30)}
     * @param registerUser The value of registerUser as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setRegisterUser_NotLikeSearch(String registerUser, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(registerUser), xgetCValueRegisterUser(), "register_user", likeSearchOption);
    }

    protected void regRegisterUser(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterUser(), "register_user"); }
    protected abstract ConditionValue xgetCValueRegisterUser();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * register_process: {NotNull, varchar(30)}
     * @param registerProcess The value of registerProcess as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_Equal(String registerProcess) {
        doSetRegisterProcess_Equal(fRES(registerProcess));
    }

    protected void doSetRegisterProcess_Equal(String registerProcess) {
        regRegisterProcess(CK_EQ, registerProcess);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * register_process: {NotNull, varchar(30)}
     * @param registerProcess The value of registerProcess as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_NotEqual(String registerProcess) {
        doSetRegisterProcess_NotEqual(fRES(registerProcess));
    }

    protected void doSetRegisterProcess_NotEqual(String registerProcess) {
        regRegisterProcess(CK_NES, registerProcess);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * register_process: {NotNull, varchar(30)}
     * @param registerProcess The value of registerProcess as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_GreaterThan(String registerProcess) {
        regRegisterProcess(CK_GT, fRES(registerProcess));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * register_process: {NotNull, varchar(30)}
     * @param registerProcess The value of registerProcess as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_LessThan(String registerProcess) {
        regRegisterProcess(CK_LT, fRES(registerProcess));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * register_process: {NotNull, varchar(30)}
     * @param registerProcess The value of registerProcess as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_GreaterEqual(String registerProcess) {
        regRegisterProcess(CK_GE, fRES(registerProcess));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * register_process: {NotNull, varchar(30)}
     * @param registerProcess The value of registerProcess as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_LessEqual(String registerProcess) {
        regRegisterProcess(CK_LE, fRES(registerProcess));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * register_process: {NotNull, varchar(30)}
     * @param registerProcessList The collection of registerProcess as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_InScope(Collection<String> registerProcessList) {
        doSetRegisterProcess_InScope(registerProcessList);
    }

    protected void doSetRegisterProcess_InScope(Collection<String> registerProcessList) {
        regINS(CK_INS, cTL(registerProcessList), xgetCValueRegisterProcess(), "register_process");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * register_process: {NotNull, varchar(30)}
     * @param registerProcessList The collection of registerProcess as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterProcess_NotInScope(Collection<String> registerProcessList) {
        doSetRegisterProcess_NotInScope(registerProcessList);
    }

    protected void doSetRegisterProcess_NotInScope(Collection<String> registerProcessList) {
        regINS(CK_NINS, cTL(registerProcessList), xgetCValueRegisterProcess(), "register_process");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * register_process: {NotNull, varchar(30)} <br>
     * <pre>e.g. setRegisterProcess_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param registerProcess The value of registerProcess as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterProcess_LikeSearch(String registerProcess, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterProcess_LikeSearch(registerProcess, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * register_process: {NotNull, varchar(30)} <br>
     * <pre>e.g. setRegisterProcess_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param registerProcess The value of registerProcess as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setRegisterProcess_LikeSearch(String registerProcess, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(registerProcess), xgetCValueRegisterProcess(), "register_process", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * register_process: {NotNull, varchar(30)}
     * @param registerProcess The value of registerProcess as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterProcess_NotLikeSearch(String registerProcess, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterProcess_NotLikeSearch(registerProcess, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * register_process: {NotNull, varchar(30)}
     * @param registerProcess The value of registerProcess as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setRegisterProcess_NotLikeSearch(String registerProcess, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(registerProcess), xgetCValueRegisterProcess(), "register_process", likeSearchOption);
    }

    protected void regRegisterProcess(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterProcess(), "register_process"); }
    protected abstract ConditionValue xgetCValueRegisterProcess();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * update_datetime: {NotNull, timestamp(29, 6)}
     * @param updateDatetime The value of updateDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setUpdateDatetime_Equal(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_EQ,  updateDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * update_datetime: {NotNull, timestamp(29, 6)}
     * @param updateDatetime The value of updateDatetime as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setUpdateDatetime_GreaterThan(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_GT,  updateDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * update_datetime: {NotNull, timestamp(29, 6)}
     * @param updateDatetime The value of updateDatetime as lessThan. (NullAllowed: if null, no condition)
     */
    public void setUpdateDatetime_LessThan(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_LT,  updateDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * update_datetime: {NotNull, timestamp(29, 6)}
     * @param updateDatetime The value of updateDatetime as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setUpdateDatetime_GreaterEqual(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_GE,  updateDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * update_datetime: {NotNull, timestamp(29, 6)}
     * @param updateDatetime The value of updateDatetime as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setUpdateDatetime_LessEqual(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_LE, updateDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * update_datetime: {NotNull, timestamp(29, 6)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setUpdateDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setUpdateDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * update_datetime: {NotNull, timestamp(29, 6)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setUpdateDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "update_datetime"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueUpdateDatetime(), nm, op);
    }

    protected void regUpdateDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateDatetime(), "update_datetime"); }
    protected abstract ConditionValue xgetCValueUpdateDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * update_user: {NotNull, varchar(30)}
     * @param updateUser The value of updateUser as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_Equal(String updateUser) {
        doSetUpdateUser_Equal(fRES(updateUser));
    }

    protected void doSetUpdateUser_Equal(String updateUser) {
        regUpdateUser(CK_EQ, updateUser);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * update_user: {NotNull, varchar(30)}
     * @param updateUser The value of updateUser as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_NotEqual(String updateUser) {
        doSetUpdateUser_NotEqual(fRES(updateUser));
    }

    protected void doSetUpdateUser_NotEqual(String updateUser) {
        regUpdateUser(CK_NES, updateUser);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * update_user: {NotNull, varchar(30)}
     * @param updateUser The value of updateUser as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_GreaterThan(String updateUser) {
        regUpdateUser(CK_GT, fRES(updateUser));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * update_user: {NotNull, varchar(30)}
     * @param updateUser The value of updateUser as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_LessThan(String updateUser) {
        regUpdateUser(CK_LT, fRES(updateUser));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * update_user: {NotNull, varchar(30)}
     * @param updateUser The value of updateUser as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_GreaterEqual(String updateUser) {
        regUpdateUser(CK_GE, fRES(updateUser));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * update_user: {NotNull, varchar(30)}
     * @param updateUser The value of updateUser as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_LessEqual(String updateUser) {
        regUpdateUser(CK_LE, fRES(updateUser));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * update_user: {NotNull, varchar(30)}
     * @param updateUserList The collection of updateUser as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_InScope(Collection<String> updateUserList) {
        doSetUpdateUser_InScope(updateUserList);
    }

    protected void doSetUpdateUser_InScope(Collection<String> updateUserList) {
        regINS(CK_INS, cTL(updateUserList), xgetCValueUpdateUser(), "update_user");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * update_user: {NotNull, varchar(30)}
     * @param updateUserList The collection of updateUser as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_NotInScope(Collection<String> updateUserList) {
        doSetUpdateUser_NotInScope(updateUserList);
    }

    protected void doSetUpdateUser_NotInScope(Collection<String> updateUserList) {
        regINS(CK_NINS, cTL(updateUserList), xgetCValueUpdateUser(), "update_user");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * update_user: {NotNull, varchar(30)} <br>
     * <pre>e.g. setUpdateUser_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param updateUser The value of updateUser as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateUser_LikeSearch(String updateUser, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateUser_LikeSearch(updateUser, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * update_user: {NotNull, varchar(30)} <br>
     * <pre>e.g. setUpdateUser_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param updateUser The value of updateUser as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setUpdateUser_LikeSearch(String updateUser, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(updateUser), xgetCValueUpdateUser(), "update_user", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * update_user: {NotNull, varchar(30)}
     * @param updateUser The value of updateUser as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateUser_NotLikeSearch(String updateUser, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateUser_NotLikeSearch(updateUser, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * update_user: {NotNull, varchar(30)}
     * @param updateUser The value of updateUser as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setUpdateUser_NotLikeSearch(String updateUser, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(updateUser), xgetCValueUpdateUser(), "update_user", likeSearchOption);
    }

    protected void regUpdateUser(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateUser(), "update_user"); }
    protected abstract ConditionValue xgetCValueUpdateUser();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * update_process: {NotNull, varchar(30)}
     * @param updateProcess The value of updateProcess as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_Equal(String updateProcess) {
        doSetUpdateProcess_Equal(fRES(updateProcess));
    }

    protected void doSetUpdateProcess_Equal(String updateProcess) {
        regUpdateProcess(CK_EQ, updateProcess);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * update_process: {NotNull, varchar(30)}
     * @param updateProcess The value of updateProcess as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_NotEqual(String updateProcess) {
        doSetUpdateProcess_NotEqual(fRES(updateProcess));
    }

    protected void doSetUpdateProcess_NotEqual(String updateProcess) {
        regUpdateProcess(CK_NES, updateProcess);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * update_process: {NotNull, varchar(30)}
     * @param updateProcess The value of updateProcess as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_GreaterThan(String updateProcess) {
        regUpdateProcess(CK_GT, fRES(updateProcess));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * update_process: {NotNull, varchar(30)}
     * @param updateProcess The value of updateProcess as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_LessThan(String updateProcess) {
        regUpdateProcess(CK_LT, fRES(updateProcess));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * update_process: {NotNull, varchar(30)}
     * @param updateProcess The value of updateProcess as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_GreaterEqual(String updateProcess) {
        regUpdateProcess(CK_GE, fRES(updateProcess));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * update_process: {NotNull, varchar(30)}
     * @param updateProcess The value of updateProcess as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_LessEqual(String updateProcess) {
        regUpdateProcess(CK_LE, fRES(updateProcess));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * update_process: {NotNull, varchar(30)}
     * @param updateProcessList The collection of updateProcess as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_InScope(Collection<String> updateProcessList) {
        doSetUpdateProcess_InScope(updateProcessList);
    }

    protected void doSetUpdateProcess_InScope(Collection<String> updateProcessList) {
        regINS(CK_INS, cTL(updateProcessList), xgetCValueUpdateProcess(), "update_process");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * update_process: {NotNull, varchar(30)}
     * @param updateProcessList The collection of updateProcess as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateProcess_NotInScope(Collection<String> updateProcessList) {
        doSetUpdateProcess_NotInScope(updateProcessList);
    }

    protected void doSetUpdateProcess_NotInScope(Collection<String> updateProcessList) {
        regINS(CK_NINS, cTL(updateProcessList), xgetCValueUpdateProcess(), "update_process");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * update_process: {NotNull, varchar(30)} <br>
     * <pre>e.g. setUpdateProcess_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param updateProcess The value of updateProcess as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateProcess_LikeSearch(String updateProcess, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateProcess_LikeSearch(updateProcess, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * update_process: {NotNull, varchar(30)} <br>
     * <pre>e.g. setUpdateProcess_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param updateProcess The value of updateProcess as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setUpdateProcess_LikeSearch(String updateProcess, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(updateProcess), xgetCValueUpdateProcess(), "update_process", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * update_process: {NotNull, varchar(30)}
     * @param updateProcess The value of updateProcess as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateProcess_NotLikeSearch(String updateProcess, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateProcess_NotLikeSearch(updateProcess, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * update_process: {NotNull, varchar(30)}
     * @param updateProcess The value of updateProcess as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setUpdateProcess_NotLikeSearch(String updateProcess, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(updateProcess), xgetCValueUpdateProcess(), "update_process", likeSearchOption);
    }

    protected void regUpdateProcess(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateProcess(), "update_process"); }
    protected abstract ConditionValue xgetCValueUpdateProcess();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_Equal()</span>.max(new SubQuery&lt;SessionCB&gt;() {
     *     public void query(SessionCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<SessionCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ, SessionCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_NotEqual()</span>.max(new SubQuery&lt;SessionCB&gt;() {
     *     public void query(SessionCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<SessionCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES, SessionCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br>
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;SessionCB&gt;() {
     *     public void query(SessionCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<SessionCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT, SessionCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br>
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessThan()</span>.max(new SubQuery&lt;SessionCB&gt;() {
     *     public void query(SessionCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<SessionCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT, SessionCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br>
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;SessionCB&gt;() {
     *     public void query(SessionCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<SessionCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE, SessionCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;SessionCB&gt;() {
     *     public void query(SessionCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<SessionCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE, SessionCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        SessionCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(SessionCQ sq);

    protected SessionCB xcreateScalarConditionCB() {
        SessionCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected SessionCB xcreateScalarConditionPartitionByCB() {
        SessionCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<SessionCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        SessionCB cb = new SessionCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "id";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(SessionCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<SessionCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(SessionCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        SessionCB cb = new SessionCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "id";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(SessionCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<SessionCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        SessionCB cb = new SessionCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(SessionCQ sq);

    // ===================================================================================
    //                                                                        Manual Order
    //                                                                        ============
    /**
     * Order along manual ordering information.
     * <pre>
     * cb.query().addOrderBy_Birthdate_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when BIRTHDATE &gt;= '2000/01/01' then 0</span>
     * <span style="color: #3F7E5E">//     else 1</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     *
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Withdrawal);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Formalized);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Provisional);
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * <p>This function with Union is unsupported!</p>
     * <p>The order values are bound (treated as bind parameter).</p>
     * @param opLambda The callback for option of manual-order containing order values. (NotNull)
     */
    public void withManualOrder(ManualOrderOptionCall opLambda) { // is user public!
        xdoWithManualOrder(cMOO(opLambda));
    }

    // ===================================================================================
    //                                                                    Small Adjustment
    //                                                                    ================
    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected SessionCB newMyCB() {
        return new SessionCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return SessionCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
