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
 * The abstract condition-query of user_table.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsUserTableCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsUserTableCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "user_table";
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
     * table_name: {UQ+, NotNull, varchar(40)}
     * @param tableName The value of tableName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setTableName_Equal(String tableName) {
        doSetTableName_Equal(fRES(tableName));
    }

    protected void doSetTableName_Equal(String tableName) {
        regTableName(CK_EQ, tableName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * table_name: {UQ+, NotNull, varchar(40)}
     * @param tableName The value of tableName as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setTableName_NotEqual(String tableName) {
        doSetTableName_NotEqual(fRES(tableName));
    }

    protected void doSetTableName_NotEqual(String tableName) {
        regTableName(CK_NES, tableName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * table_name: {UQ+, NotNull, varchar(40)}
     * @param tableName The value of tableName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setTableName_GreaterThan(String tableName) {
        regTableName(CK_GT, fRES(tableName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * table_name: {UQ+, NotNull, varchar(40)}
     * @param tableName The value of tableName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setTableName_LessThan(String tableName) {
        regTableName(CK_LT, fRES(tableName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * table_name: {UQ+, NotNull, varchar(40)}
     * @param tableName The value of tableName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setTableName_GreaterEqual(String tableName) {
        regTableName(CK_GE, fRES(tableName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * table_name: {UQ+, NotNull, varchar(40)}
     * @param tableName The value of tableName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setTableName_LessEqual(String tableName) {
        regTableName(CK_LE, fRES(tableName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * table_name: {UQ+, NotNull, varchar(40)}
     * @param tableNameList The collection of tableName as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTableName_InScope(Collection<String> tableNameList) {
        doSetTableName_InScope(tableNameList);
    }

    protected void doSetTableName_InScope(Collection<String> tableNameList) {
        regINS(CK_INS, cTL(tableNameList), xgetCValueTableName(), "table_name");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * table_name: {UQ+, NotNull, varchar(40)}
     * @param tableNameList The collection of tableName as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTableName_NotInScope(Collection<String> tableNameList) {
        doSetTableName_NotInScope(tableNameList);
    }

    protected void doSetTableName_NotInScope(Collection<String> tableNameList) {
        regINS(CK_NINS, cTL(tableNameList), xgetCValueTableName(), "table_name");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * table_name: {UQ+, NotNull, varchar(40)} <br>
     * <pre>e.g. setTableName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param tableName The value of tableName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setTableName_LikeSearch(String tableName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setTableName_LikeSearch(tableName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * table_name: {UQ+, NotNull, varchar(40)} <br>
     * <pre>e.g. setTableName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param tableName The value of tableName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setTableName_LikeSearch(String tableName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(tableName), xgetCValueTableName(), "table_name", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * table_name: {UQ+, NotNull, varchar(40)}
     * @param tableName The value of tableName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setTableName_NotLikeSearch(String tableName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setTableName_NotLikeSearch(tableName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * table_name: {UQ+, NotNull, varchar(40)}
     * @param tableName The value of tableName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setTableName_NotLikeSearch(String tableName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(tableName), xgetCValueTableName(), "table_name", likeSearchOption);
    }

    protected void regTableName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueTableName(), "table_name"); }
    protected abstract ConditionValue xgetCValueTableName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * key_1: {+UQ, NotNull, varchar(40)}
     * @param key1 The value of key1 as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey1_Equal(String key1) {
        doSetKey1_Equal(fRES(key1));
    }

    protected void doSetKey1_Equal(String key1) {
        regKey1(CK_EQ, key1);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * key_1: {+UQ, NotNull, varchar(40)}
     * @param key1 The value of key1 as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey1_NotEqual(String key1) {
        doSetKey1_NotEqual(fRES(key1));
    }

    protected void doSetKey1_NotEqual(String key1) {
        regKey1(CK_NES, key1);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * key_1: {+UQ, NotNull, varchar(40)}
     * @param key1 The value of key1 as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey1_GreaterThan(String key1) {
        regKey1(CK_GT, fRES(key1));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * key_1: {+UQ, NotNull, varchar(40)}
     * @param key1 The value of key1 as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey1_LessThan(String key1) {
        regKey1(CK_LT, fRES(key1));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * key_1: {+UQ, NotNull, varchar(40)}
     * @param key1 The value of key1 as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey1_GreaterEqual(String key1) {
        regKey1(CK_GE, fRES(key1));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * key_1: {+UQ, NotNull, varchar(40)}
     * @param key1 The value of key1 as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey1_LessEqual(String key1) {
        regKey1(CK_LE, fRES(key1));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * key_1: {+UQ, NotNull, varchar(40)}
     * @param key1List The collection of key1 as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey1_InScope(Collection<String> key1List) {
        doSetKey1_InScope(key1List);
    }

    protected void doSetKey1_InScope(Collection<String> key1List) {
        regINS(CK_INS, cTL(key1List), xgetCValueKey1(), "key_1");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * key_1: {+UQ, NotNull, varchar(40)}
     * @param key1List The collection of key1 as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey1_NotInScope(Collection<String> key1List) {
        doSetKey1_NotInScope(key1List);
    }

    protected void doSetKey1_NotInScope(Collection<String> key1List) {
        regINS(CK_NINS, cTL(key1List), xgetCValueKey1(), "key_1");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * key_1: {+UQ, NotNull, varchar(40)} <br>
     * <pre>e.g. setKey1_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param key1 The value of key1 as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setKey1_LikeSearch(String key1, ConditionOptionCall<LikeSearchOption> opLambda) {
        setKey1_LikeSearch(key1, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * key_1: {+UQ, NotNull, varchar(40)} <br>
     * <pre>e.g. setKey1_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param key1 The value of key1 as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setKey1_LikeSearch(String key1, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(key1), xgetCValueKey1(), "key_1", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * key_1: {+UQ, NotNull, varchar(40)}
     * @param key1 The value of key1 as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setKey1_NotLikeSearch(String key1, ConditionOptionCall<LikeSearchOption> opLambda) {
        setKey1_NotLikeSearch(key1, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * key_1: {+UQ, NotNull, varchar(40)}
     * @param key1 The value of key1 as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setKey1_NotLikeSearch(String key1, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(key1), xgetCValueKey1(), "key_1", likeSearchOption);
    }

    protected void regKey1(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueKey1(), "key_1"); }
    protected abstract ConditionValue xgetCValueKey1();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * key_2: {+UQ, NotNull, varchar(100)}
     * @param key2 The value of key2 as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey2_Equal(String key2) {
        doSetKey2_Equal(fRES(key2));
    }

    protected void doSetKey2_Equal(String key2) {
        regKey2(CK_EQ, key2);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * key_2: {+UQ, NotNull, varchar(100)}
     * @param key2 The value of key2 as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey2_NotEqual(String key2) {
        doSetKey2_NotEqual(fRES(key2));
    }

    protected void doSetKey2_NotEqual(String key2) {
        regKey2(CK_NES, key2);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * key_2: {+UQ, NotNull, varchar(100)}
     * @param key2 The value of key2 as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey2_GreaterThan(String key2) {
        regKey2(CK_GT, fRES(key2));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * key_2: {+UQ, NotNull, varchar(100)}
     * @param key2 The value of key2 as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey2_LessThan(String key2) {
        regKey2(CK_LT, fRES(key2));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * key_2: {+UQ, NotNull, varchar(100)}
     * @param key2 The value of key2 as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey2_GreaterEqual(String key2) {
        regKey2(CK_GE, fRES(key2));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * key_2: {+UQ, NotNull, varchar(100)}
     * @param key2 The value of key2 as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey2_LessEqual(String key2) {
        regKey2(CK_LE, fRES(key2));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * key_2: {+UQ, NotNull, varchar(100)}
     * @param key2List The collection of key2 as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey2_InScope(Collection<String> key2List) {
        doSetKey2_InScope(key2List);
    }

    protected void doSetKey2_InScope(Collection<String> key2List) {
        regINS(CK_INS, cTL(key2List), xgetCValueKey2(), "key_2");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * key_2: {+UQ, NotNull, varchar(100)}
     * @param key2List The collection of key2 as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setKey2_NotInScope(Collection<String> key2List) {
        doSetKey2_NotInScope(key2List);
    }

    protected void doSetKey2_NotInScope(Collection<String> key2List) {
        regINS(CK_NINS, cTL(key2List), xgetCValueKey2(), "key_2");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * key_2: {+UQ, NotNull, varchar(100)} <br>
     * <pre>e.g. setKey2_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param key2 The value of key2 as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setKey2_LikeSearch(String key2, ConditionOptionCall<LikeSearchOption> opLambda) {
        setKey2_LikeSearch(key2, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * key_2: {+UQ, NotNull, varchar(100)} <br>
     * <pre>e.g. setKey2_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param key2 The value of key2 as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setKey2_LikeSearch(String key2, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(key2), xgetCValueKey2(), "key_2", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * key_2: {+UQ, NotNull, varchar(100)}
     * @param key2 The value of key2 as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setKey2_NotLikeSearch(String key2, ConditionOptionCall<LikeSearchOption> opLambda) {
        setKey2_NotLikeSearch(key2, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * key_2: {+UQ, NotNull, varchar(100)}
     * @param key2 The value of key2 as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setKey2_NotLikeSearch(String key2, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(key2), xgetCValueKey2(), "key_2", likeSearchOption);
    }

    protected void regKey2(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueKey2(), "key_2"); }
    protected abstract ConditionValue xgetCValueKey2();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s1_data: {text(2147483647)}
     * @param s1Data The value of s1Data as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setS1Data_Equal(String s1Data) {
        doSetS1Data_Equal(fRES(s1Data));
    }

    protected void doSetS1Data_Equal(String s1Data) {
        regS1Data(CK_EQ, s1Data);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s1_data: {text(2147483647)}
     * @param s1Data The value of s1Data as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setS1Data_NotEqual(String s1Data) {
        doSetS1Data_NotEqual(fRES(s1Data));
    }

    protected void doSetS1Data_NotEqual(String s1Data) {
        regS1Data(CK_NES, s1Data);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s1_data: {text(2147483647)}
     * @param s1Data The value of s1Data as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setS1Data_GreaterThan(String s1Data) {
        regS1Data(CK_GT, fRES(s1Data));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s1_data: {text(2147483647)}
     * @param s1Data The value of s1Data as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setS1Data_LessThan(String s1Data) {
        regS1Data(CK_LT, fRES(s1Data));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s1_data: {text(2147483647)}
     * @param s1Data The value of s1Data as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setS1Data_GreaterEqual(String s1Data) {
        regS1Data(CK_GE, fRES(s1Data));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s1_data: {text(2147483647)}
     * @param s1Data The value of s1Data as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setS1Data_LessEqual(String s1Data) {
        regS1Data(CK_LE, fRES(s1Data));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * s1_data: {text(2147483647)}
     * @param s1DataList The collection of s1Data as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setS1Data_InScope(Collection<String> s1DataList) {
        doSetS1Data_InScope(s1DataList);
    }

    protected void doSetS1Data_InScope(Collection<String> s1DataList) {
        regINS(CK_INS, cTL(s1DataList), xgetCValueS1Data(), "s1_data");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * s1_data: {text(2147483647)}
     * @param s1DataList The collection of s1Data as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setS1Data_NotInScope(Collection<String> s1DataList) {
        doSetS1Data_NotInScope(s1DataList);
    }

    protected void doSetS1Data_NotInScope(Collection<String> s1DataList) {
        regINS(CK_NINS, cTL(s1DataList), xgetCValueS1Data(), "s1_data");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * s1_data: {text(2147483647)} <br>
     * <pre>e.g. setS1Data_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param s1Data The value of s1Data as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setS1Data_LikeSearch(String s1Data, ConditionOptionCall<LikeSearchOption> opLambda) {
        setS1Data_LikeSearch(s1Data, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * s1_data: {text(2147483647)} <br>
     * <pre>e.g. setS1Data_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param s1Data The value of s1Data as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setS1Data_LikeSearch(String s1Data, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(s1Data), xgetCValueS1Data(), "s1_data", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * s1_data: {text(2147483647)}
     * @param s1Data The value of s1Data as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setS1Data_NotLikeSearch(String s1Data, ConditionOptionCall<LikeSearchOption> opLambda) {
        setS1Data_NotLikeSearch(s1Data, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * s1_data: {text(2147483647)}
     * @param s1Data The value of s1Data as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setS1Data_NotLikeSearch(String s1Data, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(s1Data), xgetCValueS1Data(), "s1_data", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * s1_data: {text(2147483647)}
     */
    public void setS1Data_IsNull() { regS1Data(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * s1_data: {text(2147483647)}
     */
    public void setS1Data_IsNullOrEmpty() { regS1Data(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * s1_data: {text(2147483647)}
     */
    public void setS1Data_IsNotNull() { regS1Data(CK_ISNN, DOBJ); }

    protected void regS1Data(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueS1Data(), "s1_data"); }
    protected abstract ConditionValue xgetCValueS1Data();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s2_data: {varchar(100)}
     * @param s2Data The value of s2Data as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setS2Data_Equal(String s2Data) {
        doSetS2Data_Equal(fRES(s2Data));
    }

    protected void doSetS2Data_Equal(String s2Data) {
        regS2Data(CK_EQ, s2Data);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s2_data: {varchar(100)}
     * @param s2Data The value of s2Data as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setS2Data_NotEqual(String s2Data) {
        doSetS2Data_NotEqual(fRES(s2Data));
    }

    protected void doSetS2Data_NotEqual(String s2Data) {
        regS2Data(CK_NES, s2Data);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s2_data: {varchar(100)}
     * @param s2Data The value of s2Data as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setS2Data_GreaterThan(String s2Data) {
        regS2Data(CK_GT, fRES(s2Data));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s2_data: {varchar(100)}
     * @param s2Data The value of s2Data as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setS2Data_LessThan(String s2Data) {
        regS2Data(CK_LT, fRES(s2Data));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s2_data: {varchar(100)}
     * @param s2Data The value of s2Data as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setS2Data_GreaterEqual(String s2Data) {
        regS2Data(CK_GE, fRES(s2Data));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s2_data: {varchar(100)}
     * @param s2Data The value of s2Data as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setS2Data_LessEqual(String s2Data) {
        regS2Data(CK_LE, fRES(s2Data));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * s2_data: {varchar(100)}
     * @param s2DataList The collection of s2Data as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setS2Data_InScope(Collection<String> s2DataList) {
        doSetS2Data_InScope(s2DataList);
    }

    protected void doSetS2Data_InScope(Collection<String> s2DataList) {
        regINS(CK_INS, cTL(s2DataList), xgetCValueS2Data(), "s2_data");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * s2_data: {varchar(100)}
     * @param s2DataList The collection of s2Data as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setS2Data_NotInScope(Collection<String> s2DataList) {
        doSetS2Data_NotInScope(s2DataList);
    }

    protected void doSetS2Data_NotInScope(Collection<String> s2DataList) {
        regINS(CK_NINS, cTL(s2DataList), xgetCValueS2Data(), "s2_data");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * s2_data: {varchar(100)} <br>
     * <pre>e.g. setS2Data_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param s2Data The value of s2Data as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setS2Data_LikeSearch(String s2Data, ConditionOptionCall<LikeSearchOption> opLambda) {
        setS2Data_LikeSearch(s2Data, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * s2_data: {varchar(100)} <br>
     * <pre>e.g. setS2Data_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param s2Data The value of s2Data as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setS2Data_LikeSearch(String s2Data, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(s2Data), xgetCValueS2Data(), "s2_data", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * s2_data: {varchar(100)}
     * @param s2Data The value of s2Data as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setS2Data_NotLikeSearch(String s2Data, ConditionOptionCall<LikeSearchOption> opLambda) {
        setS2Data_NotLikeSearch(s2Data, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * s2_data: {varchar(100)}
     * @param s2Data The value of s2Data as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setS2Data_NotLikeSearch(String s2Data, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(s2Data), xgetCValueS2Data(), "s2_data", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * s2_data: {varchar(100)}
     */
    public void setS2Data_IsNull() { regS2Data(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * s2_data: {varchar(100)}
     */
    public void setS2Data_IsNullOrEmpty() { regS2Data(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * s2_data: {varchar(100)}
     */
    public void setS2Data_IsNotNull() { regS2Data(CK_ISNN, DOBJ); }

    protected void regS2Data(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueS2Data(), "s2_data"); }
    protected abstract ConditionValue xgetCValueS2Data();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s3_data: {varchar(100)}
     * @param s3Data The value of s3Data as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setS3Data_Equal(String s3Data) {
        doSetS3Data_Equal(fRES(s3Data));
    }

    protected void doSetS3Data_Equal(String s3Data) {
        regS3Data(CK_EQ, s3Data);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s3_data: {varchar(100)}
     * @param s3Data The value of s3Data as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setS3Data_NotEqual(String s3Data) {
        doSetS3Data_NotEqual(fRES(s3Data));
    }

    protected void doSetS3Data_NotEqual(String s3Data) {
        regS3Data(CK_NES, s3Data);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s3_data: {varchar(100)}
     * @param s3Data The value of s3Data as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setS3Data_GreaterThan(String s3Data) {
        regS3Data(CK_GT, fRES(s3Data));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s3_data: {varchar(100)}
     * @param s3Data The value of s3Data as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setS3Data_LessThan(String s3Data) {
        regS3Data(CK_LT, fRES(s3Data));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s3_data: {varchar(100)}
     * @param s3Data The value of s3Data as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setS3Data_GreaterEqual(String s3Data) {
        regS3Data(CK_GE, fRES(s3Data));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * s3_data: {varchar(100)}
     * @param s3Data The value of s3Data as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setS3Data_LessEqual(String s3Data) {
        regS3Data(CK_LE, fRES(s3Data));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * s3_data: {varchar(100)}
     * @param s3DataList The collection of s3Data as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setS3Data_InScope(Collection<String> s3DataList) {
        doSetS3Data_InScope(s3DataList);
    }

    protected void doSetS3Data_InScope(Collection<String> s3DataList) {
        regINS(CK_INS, cTL(s3DataList), xgetCValueS3Data(), "s3_data");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * s3_data: {varchar(100)}
     * @param s3DataList The collection of s3Data as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setS3Data_NotInScope(Collection<String> s3DataList) {
        doSetS3Data_NotInScope(s3DataList);
    }

    protected void doSetS3Data_NotInScope(Collection<String> s3DataList) {
        regINS(CK_NINS, cTL(s3DataList), xgetCValueS3Data(), "s3_data");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * s3_data: {varchar(100)} <br>
     * <pre>e.g. setS3Data_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param s3Data The value of s3Data as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setS3Data_LikeSearch(String s3Data, ConditionOptionCall<LikeSearchOption> opLambda) {
        setS3Data_LikeSearch(s3Data, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * s3_data: {varchar(100)} <br>
     * <pre>e.g. setS3Data_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param s3Data The value of s3Data as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setS3Data_LikeSearch(String s3Data, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(s3Data), xgetCValueS3Data(), "s3_data", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * s3_data: {varchar(100)}
     * @param s3Data The value of s3Data as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setS3Data_NotLikeSearch(String s3Data, ConditionOptionCall<LikeSearchOption> opLambda) {
        setS3Data_NotLikeSearch(s3Data, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * s3_data: {varchar(100)}
     * @param s3Data The value of s3Data as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setS3Data_NotLikeSearch(String s3Data, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(s3Data), xgetCValueS3Data(), "s3_data", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * s3_data: {varchar(100)}
     */
    public void setS3Data_IsNull() { regS3Data(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * s3_data: {varchar(100)}
     */
    public void setS3Data_IsNullOrEmpty() { regS3Data(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * s3_data: {varchar(100)}
     */
    public void setS3Data_IsNotNull() { regS3Data(CK_ISNN, DOBJ); }

    protected void regS3Data(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueS3Data(), "s3_data"); }
    protected abstract ConditionValue xgetCValueS3Data();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * n1_data: {numeric(20, 2)}
     * @param n1Data The value of n1Data as equal. (NullAllowed: if null, no condition)
     */
    public void setN1Data_Equal(java.math.BigDecimal n1Data) {
        doSetN1Data_Equal(n1Data);
    }

    protected void doSetN1Data_Equal(java.math.BigDecimal n1Data) {
        regN1Data(CK_EQ, n1Data);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * n1_data: {numeric(20, 2)}
     * @param n1Data The value of n1Data as notEqual. (NullAllowed: if null, no condition)
     */
    public void setN1Data_NotEqual(java.math.BigDecimal n1Data) {
        doSetN1Data_NotEqual(n1Data);
    }

    protected void doSetN1Data_NotEqual(java.math.BigDecimal n1Data) {
        regN1Data(CK_NES, n1Data);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * n1_data: {numeric(20, 2)}
     * @param n1Data The value of n1Data as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setN1Data_GreaterThan(java.math.BigDecimal n1Data) {
        regN1Data(CK_GT, n1Data);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * n1_data: {numeric(20, 2)}
     * @param n1Data The value of n1Data as lessThan. (NullAllowed: if null, no condition)
     */
    public void setN1Data_LessThan(java.math.BigDecimal n1Data) {
        regN1Data(CK_LT, n1Data);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * n1_data: {numeric(20, 2)}
     * @param n1Data The value of n1Data as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setN1Data_GreaterEqual(java.math.BigDecimal n1Data) {
        regN1Data(CK_GE, n1Data);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * n1_data: {numeric(20, 2)}
     * @param n1Data The value of n1Data as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setN1Data_LessEqual(java.math.BigDecimal n1Data) {
        regN1Data(CK_LE, n1Data);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * n1_data: {numeric(20, 2)}
     * @param minNumber The min number of n1Data. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of n1Data. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setN1Data_RangeOf(java.math.BigDecimal minNumber, java.math.BigDecimal maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setN1Data_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * n1_data: {numeric(20, 2)}
     * @param minNumber The min number of n1Data. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of n1Data. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setN1Data_RangeOf(java.math.BigDecimal minNumber, java.math.BigDecimal maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueN1Data(), "n1_data", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * n1_data: {numeric(20, 2)}
     * @param n1DataList The collection of n1Data as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setN1Data_InScope(Collection<java.math.BigDecimal> n1DataList) {
        doSetN1Data_InScope(n1DataList);
    }

    protected void doSetN1Data_InScope(Collection<java.math.BigDecimal> n1DataList) {
        regINS(CK_INS, cTL(n1DataList), xgetCValueN1Data(), "n1_data");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * n1_data: {numeric(20, 2)}
     * @param n1DataList The collection of n1Data as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setN1Data_NotInScope(Collection<java.math.BigDecimal> n1DataList) {
        doSetN1Data_NotInScope(n1DataList);
    }

    protected void doSetN1Data_NotInScope(Collection<java.math.BigDecimal> n1DataList) {
        regINS(CK_NINS, cTL(n1DataList), xgetCValueN1Data(), "n1_data");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * n1_data: {numeric(20, 2)}
     */
    public void setN1Data_IsNull() { regN1Data(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * n1_data: {numeric(20, 2)}
     */
    public void setN1Data_IsNotNull() { regN1Data(CK_ISNN, DOBJ); }

    protected void regN1Data(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueN1Data(), "n1_data"); }
    protected abstract ConditionValue xgetCValueN1Data();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * n2_data: {numeric(20, 2)}
     * @param n2Data The value of n2Data as equal. (NullAllowed: if null, no condition)
     */
    public void setN2Data_Equal(java.math.BigDecimal n2Data) {
        doSetN2Data_Equal(n2Data);
    }

    protected void doSetN2Data_Equal(java.math.BigDecimal n2Data) {
        regN2Data(CK_EQ, n2Data);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * n2_data: {numeric(20, 2)}
     * @param n2Data The value of n2Data as notEqual. (NullAllowed: if null, no condition)
     */
    public void setN2Data_NotEqual(java.math.BigDecimal n2Data) {
        doSetN2Data_NotEqual(n2Data);
    }

    protected void doSetN2Data_NotEqual(java.math.BigDecimal n2Data) {
        regN2Data(CK_NES, n2Data);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * n2_data: {numeric(20, 2)}
     * @param n2Data The value of n2Data as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setN2Data_GreaterThan(java.math.BigDecimal n2Data) {
        regN2Data(CK_GT, n2Data);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * n2_data: {numeric(20, 2)}
     * @param n2Data The value of n2Data as lessThan. (NullAllowed: if null, no condition)
     */
    public void setN2Data_LessThan(java.math.BigDecimal n2Data) {
        regN2Data(CK_LT, n2Data);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * n2_data: {numeric(20, 2)}
     * @param n2Data The value of n2Data as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setN2Data_GreaterEqual(java.math.BigDecimal n2Data) {
        regN2Data(CK_GE, n2Data);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * n2_data: {numeric(20, 2)}
     * @param n2Data The value of n2Data as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setN2Data_LessEqual(java.math.BigDecimal n2Data) {
        regN2Data(CK_LE, n2Data);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * n2_data: {numeric(20, 2)}
     * @param minNumber The min number of n2Data. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of n2Data. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setN2Data_RangeOf(java.math.BigDecimal minNumber, java.math.BigDecimal maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setN2Data_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * n2_data: {numeric(20, 2)}
     * @param minNumber The min number of n2Data. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of n2Data. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setN2Data_RangeOf(java.math.BigDecimal minNumber, java.math.BigDecimal maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueN2Data(), "n2_data", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * n2_data: {numeric(20, 2)}
     * @param n2DataList The collection of n2Data as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setN2Data_InScope(Collection<java.math.BigDecimal> n2DataList) {
        doSetN2Data_InScope(n2DataList);
    }

    protected void doSetN2Data_InScope(Collection<java.math.BigDecimal> n2DataList) {
        regINS(CK_INS, cTL(n2DataList), xgetCValueN2Data(), "n2_data");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * n2_data: {numeric(20, 2)}
     * @param n2DataList The collection of n2Data as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setN2Data_NotInScope(Collection<java.math.BigDecimal> n2DataList) {
        doSetN2Data_NotInScope(n2DataList);
    }

    protected void doSetN2Data_NotInScope(Collection<java.math.BigDecimal> n2DataList) {
        regINS(CK_NINS, cTL(n2DataList), xgetCValueN2Data(), "n2_data");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * n2_data: {numeric(20, 2)}
     */
    public void setN2Data_IsNull() { regN2Data(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * n2_data: {numeric(20, 2)}
     */
    public void setN2Data_IsNotNull() { regN2Data(CK_ISNN, DOBJ); }

    protected void regN2Data(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueN2Data(), "n2_data"); }
    protected abstract ConditionValue xgetCValueN2Data();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * n3_data: {numeric(20, 2)}
     * @param n3Data The value of n3Data as equal. (NullAllowed: if null, no condition)
     */
    public void setN3Data_Equal(java.math.BigDecimal n3Data) {
        doSetN3Data_Equal(n3Data);
    }

    protected void doSetN3Data_Equal(java.math.BigDecimal n3Data) {
        regN3Data(CK_EQ, n3Data);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * n3_data: {numeric(20, 2)}
     * @param n3Data The value of n3Data as notEqual. (NullAllowed: if null, no condition)
     */
    public void setN3Data_NotEqual(java.math.BigDecimal n3Data) {
        doSetN3Data_NotEqual(n3Data);
    }

    protected void doSetN3Data_NotEqual(java.math.BigDecimal n3Data) {
        regN3Data(CK_NES, n3Data);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * n3_data: {numeric(20, 2)}
     * @param n3Data The value of n3Data as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setN3Data_GreaterThan(java.math.BigDecimal n3Data) {
        regN3Data(CK_GT, n3Data);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * n3_data: {numeric(20, 2)}
     * @param n3Data The value of n3Data as lessThan. (NullAllowed: if null, no condition)
     */
    public void setN3Data_LessThan(java.math.BigDecimal n3Data) {
        regN3Data(CK_LT, n3Data);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * n3_data: {numeric(20, 2)}
     * @param n3Data The value of n3Data as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setN3Data_GreaterEqual(java.math.BigDecimal n3Data) {
        regN3Data(CK_GE, n3Data);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * n3_data: {numeric(20, 2)}
     * @param n3Data The value of n3Data as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setN3Data_LessEqual(java.math.BigDecimal n3Data) {
        regN3Data(CK_LE, n3Data);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * n3_data: {numeric(20, 2)}
     * @param minNumber The min number of n3Data. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of n3Data. (NullAllowed: if null, no to-condition)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setN3Data_RangeOf(java.math.BigDecimal minNumber, java.math.BigDecimal maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setN3Data_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * n3_data: {numeric(20, 2)}
     * @param minNumber The min number of n3Data. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of n3Data. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setN3Data_RangeOf(java.math.BigDecimal minNumber, java.math.BigDecimal maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueN3Data(), "n3_data", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * n3_data: {numeric(20, 2)}
     * @param n3DataList The collection of n3Data as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setN3Data_InScope(Collection<java.math.BigDecimal> n3DataList) {
        doSetN3Data_InScope(n3DataList);
    }

    protected void doSetN3Data_InScope(Collection<java.math.BigDecimal> n3DataList) {
        regINS(CK_INS, cTL(n3DataList), xgetCValueN3Data(), "n3_data");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * n3_data: {numeric(20, 2)}
     * @param n3DataList The collection of n3Data as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setN3Data_NotInScope(Collection<java.math.BigDecimal> n3DataList) {
        doSetN3Data_NotInScope(n3DataList);
    }

    protected void doSetN3Data_NotInScope(Collection<java.math.BigDecimal> n3DataList) {
        regINS(CK_NINS, cTL(n3DataList), xgetCValueN3Data(), "n3_data");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * n3_data: {numeric(20, 2)}
     */
    public void setN3Data_IsNull() { regN3Data(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * n3_data: {numeric(20, 2)}
     */
    public void setN3Data_IsNotNull() { regN3Data(CK_ISNN, DOBJ); }

    protected void regN3Data(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueN3Data(), "n3_data"); }
    protected abstract ConditionValue xgetCValueN3Data();

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
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
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
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
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
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
     * @param delFlag The value of delFlag as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setDelFlag_GreaterThan(Integer delFlag) {
        regDelFlag(CK_GT, delFlag);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
     * @param delFlag The value of delFlag as lessThan. (NullAllowed: if null, no condition)
     */
    public void setDelFlag_LessThan(Integer delFlag) {
        regDelFlag(CK_LT, delFlag);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
     * @param delFlag The value of delFlag as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setDelFlag_GreaterEqual(Integer delFlag) {
        regDelFlag(CK_GE, delFlag);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
     * @param delFlag The value of delFlag as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setDelFlag_LessEqual(Integer delFlag) {
        regDelFlag(CK_LE, delFlag);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
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
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
     * @param minNumber The min number of delFlag. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of delFlag. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDelFlag_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDelFlag(), "del_flag", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
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
     * del_flag: {+UQ, NotNull, int4(10), default=[0]}
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
     * cb.query().<span style="color: #CC4747">scalar_Equal()</span>.max(new SubQuery&lt;UserTableCB&gt;() {
     *     public void query(UserTableCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<UserTableCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ, UserTableCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_NotEqual()</span>.max(new SubQuery&lt;UserTableCB&gt;() {
     *     public void query(UserTableCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<UserTableCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES, UserTableCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br>
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;UserTableCB&gt;() {
     *     public void query(UserTableCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<UserTableCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT, UserTableCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br>
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessThan()</span>.max(new SubQuery&lt;UserTableCB&gt;() {
     *     public void query(UserTableCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<UserTableCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT, UserTableCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br>
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;UserTableCB&gt;() {
     *     public void query(UserTableCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<UserTableCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE, UserTableCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;UserTableCB&gt;() {
     *     public void query(UserTableCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<UserTableCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE, UserTableCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        UserTableCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(UserTableCQ sq);

    protected UserTableCB xcreateScalarConditionCB() {
        UserTableCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected UserTableCB xcreateScalarConditionPartitionByCB() {
        UserTableCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<UserTableCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        UserTableCB cb = new UserTableCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "id";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(UserTableCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<UserTableCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(UserTableCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        UserTableCB cb = new UserTableCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "id";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(UserTableCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<UserTableCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        UserTableCB cb = new UserTableCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(UserTableCQ sq);

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
    protected UserTableCB newMyCB() {
        return new UserTableCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return UserTableCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
