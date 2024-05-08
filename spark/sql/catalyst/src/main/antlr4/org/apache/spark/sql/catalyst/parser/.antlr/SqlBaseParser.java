// Generated from d:\project\DIMS\spark\sql\catalyst\src\main\antlr4\org\apache\spark\sql\catalyst\parser\SqlBase.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlBaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		SELECT=10, FROM=11, ADD=12, AS=13, ALL=14, DISTINCT=15, WHERE=16, GROUP=17, 
		BY=18, GROUPING=19, SETS=20, CUBE=21, ROLLUP=22, ORDER=23, HAVING=24, 
		LIMIT=25, AT=26, OR=27, AND=28, IN=29, NOT=30, NO=31, EXISTS=32, BETWEEN=33, 
		LIKE=34, RLIKE=35, IS=36, NULL=37, TRUE=38, FALSE=39, NULLS=40, ASC=41, 
		DESC=42, FOR=43, INTERVAL=44, CASE=45, WHEN=46, THEN=47, ELSE=48, END=49, 
		JOIN=50, CROSS=51, OUTER=52, INNER=53, LEFT=54, SEMI=55, RIGHT=56, FULL=57, 
		NATURAL=58, ON=59, LATERAL=60, WINDOW=61, OVER=62, PARTITION=63, RANGE=64, 
		ROWS=65, UNBOUNDED=66, PRECEDING=67, FOLLOWING=68, CURRENT=69, FIRST=70, 
		AFTER=71, LAST=72, ROW=73, WITH=74, VALUES=75, CREATE=76, TABLE=77, VIEW=78, 
		REPLACE=79, INSERT=80, DELETE=81, INTO=82, DESCRIBE=83, EXPLAIN=84, FORMAT=85, 
		LOGICAL=86, CODEGEN=87, COST=88, CAST=89, SHOW=90, TABLES=91, COLUMNS=92, 
		COLUMN=93, USE=94, PARTITIONS=95, FUNCTIONS=96, DROP=97, UNION=98, EXCEPT=99, 
		SETMINUS=100, INTERSECT=101, TO=102, TABLESAMPLE=103, STRATIFY=104, ALTER=105, 
		RENAME=106, ARRAY=107, MAP=108, STRUCT=109, COMMENT=110, SET=111, RESET=112, 
		DATA=113, START=114, TRANSACTION=115, COMMIT=116, ROLLBACK=117, MACRO=118, 
		IGNORE=119, IF=120, EQ=121, NSEQ=122, NEQ=123, NEQJ=124, LT=125, LTE=126, 
		GT=127, GTE=128, PLUS=129, MINUS=130, ASTERISK=131, SLASH=132, PERCENT=133, 
		DIV=134, TILDE=135, AMPERSAND=136, PIPE=137, HAT=138, PERCENTLIT=139, 
		BUCKET=140, OUT=141, OF=142, SORT=143, CLUSTER=144, DISTRIBUTE=145, OVERWRITE=146, 
		TRANSFORM=147, REDUCE=148, USING=149, SERDE=150, SERDEPROPERTIES=151, 
		RECORDREADER=152, RECORDWRITER=153, DELIMITED=154, FIELDS=155, TERMINATED=156, 
		COLLECTION=157, ITEMS=158, KEYS=159, ESCAPED=160, LINES=161, SEPARATED=162, 
		FUNCTION=163, EXTENDED=164, REFRESH=165, CLEAR=166, CACHE=167, UNCACHE=168, 
		LAZY=169, FORMATTED=170, GLOBAL=171, TEMPORARY=172, OPTIONS=173, UNSET=174, 
		TBLPROPERTIES=175, DBPROPERTIES=176, BUCKETS=177, SKEWED=178, STORED=179, 
		DIRECTORIES=180, LOCATION=181, EXCHANGE=182, ARCHIVE=183, UNARCHIVE=184, 
		FILEFORMAT=185, TOUCH=186, COMPACT=187, CONCATENATE=188, CHANGE=189, CASCADE=190, 
		RESTRICT=191, CLUSTERED=192, SORTED=193, PURGE=194, INPUTFORMAT=195, OUTPUTFORMAT=196, 
		DATABASE=197, DATABASES=198, DFS=199, TRUNCATE=200, ANALYZE=201, COMPUTE=202, 
		LIST=203, STATISTICS=204, PARTITIONED=205, EXTERNAL=206, DEFINED=207, 
		REVOKE=208, GRANT=209, LOCK=210, UNLOCK=211, MSCK=212, REPAIR=213, RECOVER=214, 
		EXPORT=215, IMPORT=216, LOAD=217, ROLE=218, ROLES=219, COMPACTIONS=220, 
		PRINCIPALS=221, TRANSACTIONS=222, INDEX=223, INDEXES=224, LOCKS=225, OPTION=226, 
		ANTI=227, LOCAL=228, INPATH=229, CURRENT_DATE=230, CURRENT_TIMESTAMP=231, 
		MCHORD=232, EUCLID=233, METRICPOINT=234, DTW=235, FRECHET=236, EDR=237, 
		LCSS=238, TRIE=239, KNN=240, TRAJECTORY=241, POINT=242, MBRRANGE=243, 
		CIRCLERANGE=244, STRING=245, BIGINT_LITERAL=246, SMALLINT_LITERAL=247, 
		TINYINT_LITERAL=248, BYTELENGTH_LITERAL=249, INTEGER_VALUE=250, DECIMAL_VALUE=251, 
		DOUBLE_LITERAL=252, BIGDECIMAL_LITERAL=253, IDENTIFIER=254, BACKQUOTED_IDENTIFIER=255, 
		SIMPLE_COMMENT=256, BRACKETED_EMPTY_COMMENT=257, BRACKETED_COMMENT=258, 
		WS=259, UNRECOGNIZED=260, DELIMITER=261, METRIC=262;
	public static final int
		RULE_singleStatement = 0, RULE_singleExpression = 1, RULE_singleTableIdentifier = 2, 
		RULE_singleFunctionIdentifier = 3, RULE_singleDataType = 4, RULE_statement = 5, 
		RULE_unsupportedHiveNativeCommands = 6, RULE_createTableHeader = 7, RULE_bucketSpec = 8, 
		RULE_skewSpec = 9, RULE_locationSpec = 10, RULE_query = 11, RULE_insertInto = 12, 
		RULE_partitionSpecLocation = 13, RULE_partitionSpec = 14, RULE_partitionVal = 15, 
		RULE_describeFuncName = 16, RULE_describeColName = 17, RULE_ctes = 18, 
		RULE_namedQuery = 19, RULE_tableProvider = 20, RULE_tablePropertyList = 21, 
		RULE_tableProperty = 22, RULE_tablePropertyKey = 23, RULE_tablePropertyValue = 24, 
		RULE_constantList = 25, RULE_nestedConstantList = 26, RULE_createFileFormat = 27, 
		RULE_fileFormat = 28, RULE_storageHandler = 29, RULE_resource = 30, RULE_queryNoWith = 31, 
		RULE_queryOrganization = 32, RULE_multiInsertQueryBody = 33, RULE_queryTerm = 34, 
		RULE_queryPrimary = 35, RULE_sortItem = 36, RULE_querySpecification = 37, 
		RULE_hint = 38, RULE_hintStatement = 39, RULE_fromClause = 40, RULE_aggregation = 41, 
		RULE_groupingSet = 42, RULE_lateralView = 43, RULE_setQuantifier = 44, 
		RULE_relation = 45, RULE_joinRelation = 46, RULE_joinType = 47, RULE_joinCriteria = 48, 
		RULE_sample = 49, RULE_identifierList = 50, RULE_identifierSeq = 51, RULE_orderedIdentifierList = 52, 
		RULE_orderedIdentifier = 53, RULE_identifierCommentList = 54, RULE_identifierComment = 55, 
		RULE_relationPrimary = 56, RULE_inlineTable = 57, RULE_rowFormat = 58, 
		RULE_tableIdentifier = 59, RULE_functionIdentifier = 60, RULE_namedExpression = 61, 
		RULE_namedExpressionSeq = 62, RULE_expression = 63, RULE_booleanExpression = 64, 
		RULE_predicated = 65, RULE_predicate = 66, RULE_metricSimilarityFunction = 67, 
		RULE_trajectorySimilarityFunction = 68, RULE_valueExpression = 69, RULE_primaryExpression = 70, 
		RULE_trajectorySimilarityExpression = 71, RULE_pointExpression = 72, RULE_trajectoryExpression = 73, 
		RULE_metricSimilarityExpression = 74, RULE_metricPointExpression = 75, 
		RULE_metricExpression = 76, RULE_constant = 77, RULE_comparisonOperator = 78, 
		RULE_arithmeticOperator = 79, RULE_predicateOperator = 80, RULE_booleanValue = 81, 
		RULE_interval = 82, RULE_intervalField = 83, RULE_intervalValue = 84, 
		RULE_colPosition = 85, RULE_dataType = 86, RULE_colTypeList = 87, RULE_colType = 88, 
		RULE_complexColTypeList = 89, RULE_complexColType = 90, RULE_whenClause = 91, 
		RULE_windows = 92, RULE_namedWindow = 93, RULE_windowSpec = 94, RULE_windowFrame = 95, 
		RULE_frameBound = 96, RULE_qualifiedName = 97, RULE_identifier = 98, RULE_strictIdentifier = 99, 
		RULE_quotedIdentifier = 100, RULE_number = 101, RULE_nonReserved = 102;
	private static String[] makeRuleNames() {
		return new String[] {
			"singleStatement", "singleExpression", "singleTableIdentifier", "singleFunctionIdentifier", 
			"singleDataType", "statement", "unsupportedHiveNativeCommands", "createTableHeader", 
			"bucketSpec", "skewSpec", "locationSpec", "query", "insertInto", "partitionSpecLocation", 
			"partitionSpec", "partitionVal", "describeFuncName", "describeColName", 
			"ctes", "namedQuery", "tableProvider", "tablePropertyList", "tableProperty", 
			"tablePropertyKey", "tablePropertyValue", "constantList", "nestedConstantList", 
			"createFileFormat", "fileFormat", "storageHandler", "resource", "queryNoWith", 
			"queryOrganization", "multiInsertQueryBody", "queryTerm", "queryPrimary", 
			"sortItem", "querySpecification", "hint", "hintStatement", "fromClause", 
			"aggregation", "groupingSet", "lateralView", "setQuantifier", "relation", 
			"joinRelation", "joinType", "joinCriteria", "sample", "identifierList", 
			"identifierSeq", "orderedIdentifierList", "orderedIdentifier", "identifierCommentList", 
			"identifierComment", "relationPrimary", "inlineTable", "rowFormat", "tableIdentifier", 
			"functionIdentifier", "namedExpression", "namedExpressionSeq", "expression", 
			"booleanExpression", "predicated", "predicate", "metricSimilarityFunction", 
			"trajectorySimilarityFunction", "valueExpression", "primaryExpression", 
			"trajectorySimilarityExpression", "pointExpression", "trajectoryExpression", 
			"metricSimilarityExpression", "metricPointExpression", "metricExpression", 
			"constant", "comparisonOperator", "arithmeticOperator", "predicateOperator", 
			"booleanValue", "interval", "intervalField", "intervalValue", "colPosition", 
			"dataType", "colTypeList", "colType", "complexColTypeList", "complexColType", 
			"whenClause", "windows", "namedWindow", "windowSpec", "windowFrame", 
			"frameBound", "qualifiedName", "identifier", "strictIdentifier", "quotedIdentifier", 
			"number", "nonReserved"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'.'", "'/*+'", "'*/'", "'['", "']'", "':'", 
			"'SELECT'", "'FROM'", "'ADD'", "'AS'", "'ALL'", "'DISTINCT'", "'WHERE'", 
			"'GROUP'", "'BY'", "'GROUPING'", "'SETS'", "'CUBE'", "'ROLLUP'", "'ORDER'", 
			"'HAVING'", "'LIMIT'", "'AT'", "'OR'", "'AND'", "'IN'", null, "'NO'", 
			"'EXISTS'", "'BETWEEN'", "'LIKE'", null, "'IS'", "'NULL'", "'TRUE'", 
			"'FALSE'", "'NULLS'", "'ASC'", "'DESC'", "'FOR'", "'INTERVAL'", "'CASE'", 
			"'WHEN'", "'THEN'", "'ELSE'", "'END'", "'JOIN'", "'CROSS'", "'OUTER'", 
			"'INNER'", "'LEFT'", "'SEMI'", "'RIGHT'", "'FULL'", "'NATURAL'", "'ON'", 
			"'LATERAL'", "'WINDOW'", "'OVER'", "'PARTITION'", "'RANGE'", "'ROWS'", 
			"'UNBOUNDED'", "'PRECEDING'", "'FOLLOWING'", "'CURRENT'", "'FIRST'", 
			"'AFTER'", "'LAST'", "'ROW'", "'WITH'", "'VALUES'", "'CREATE'", "'TABLE'", 
			"'VIEW'", "'REPLACE'", "'INSERT'", "'DELETE'", "'INTO'", "'DESCRIBE'", 
			"'EXPLAIN'", "'FORMAT'", "'LOGICAL'", "'CODEGEN'", "'COST'", "'CAST'", 
			"'SHOW'", "'TABLES'", "'COLUMNS'", "'COLUMN'", "'USE'", "'PARTITIONS'", 
			"'FUNCTIONS'", "'DROP'", "'UNION'", "'EXCEPT'", "'MINUS'", "'INTERSECT'", 
			"'TO'", "'TABLESAMPLE'", "'STRATIFY'", "'ALTER'", "'RENAME'", "'ARRAY'", 
			"'MAP'", "'STRUCT'", "'COMMENT'", "'SET'", "'RESET'", "'DATA'", "'START'", 
			"'TRANSACTION'", "'COMMIT'", "'ROLLBACK'", "'MACRO'", "'IGNORE'", "'IF'", 
			null, "'<=>'", "'<>'", "'!='", "'<'", null, "'>'", null, "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'DIV'", "'~'", "'&'", "'|'", "'^'", "'PERCENT'", 
			"'BUCKET'", "'OUT'", "'OF'", "'SORT'", "'CLUSTER'", "'DISTRIBUTE'", "'OVERWRITE'", 
			"'TRANSFORM'", "'REDUCE'", "'USING'", "'SERDE'", "'SERDEPROPERTIES'", 
			"'RECORDREADER'", "'RECORDWRITER'", "'DELIMITED'", "'FIELDS'", "'TERMINATED'", 
			"'COLLECTION'", "'ITEMS'", "'KEYS'", "'ESCAPED'", "'LINES'", "'SEPARATED'", 
			"'FUNCTION'", "'EXTENDED'", "'REFRESH'", "'CLEAR'", "'CACHE'", "'UNCACHE'", 
			"'LAZY'", "'FORMATTED'", "'GLOBAL'", null, "'OPTIONS'", "'UNSET'", "'TBLPROPERTIES'", 
			"'DBPROPERTIES'", "'BUCKETS'", "'SKEWED'", "'STORED'", "'DIRECTORIES'", 
			"'LOCATION'", "'EXCHANGE'", "'ARCHIVE'", "'UNARCHIVE'", "'FILEFORMAT'", 
			"'TOUCH'", "'COMPACT'", "'CONCATENATE'", "'CHANGE'", "'CASCADE'", "'RESTRICT'", 
			"'CLUSTERED'", "'SORTED'", "'PURGE'", "'INPUTFORMAT'", "'OUTPUTFORMAT'", 
			null, null, "'DFS'", "'TRUNCATE'", "'ANALYZE'", "'COMPUTE'", "'LIST'", 
			"'STATISTICS'", "'PARTITIONED'", "'EXTERNAL'", "'DEFINED'", "'REVOKE'", 
			"'GRANT'", "'LOCK'", "'UNLOCK'", "'MSCK'", "'REPAIR'", "'RECOVER'", "'EXPORT'", 
			"'IMPORT'", "'LOAD'", "'ROLE'", "'ROLES'", "'COMPACTIONS'", "'PRINCIPALS'", 
			"'TRANSACTIONS'", "'INDEX'", "'INDEXES'", "'LOCKS'", "'OPTION'", "'ANTI'", 
			"'LOCAL'", "'INPATH'", "'CURRENT_DATE'", "'CURRENT_TIMESTAMP'", "'MCHORD'", 
			"'EUCLID'", "'METRICPOINT'", "'DTW'", "'FRECHET'", "'EDR'", "'LCSS'", 
			"'TRIE'", "'KNN'", "'TRAJECTORY'", "'POINT'", "'MBRRANGE'", "'CIRCLERANGE'", 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'/**/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "SELECT", 
			"FROM", "ADD", "AS", "ALL", "DISTINCT", "WHERE", "GROUP", "BY", "GROUPING", 
			"SETS", "CUBE", "ROLLUP", "ORDER", "HAVING", "LIMIT", "AT", "OR", "AND", 
			"IN", "NOT", "NO", "EXISTS", "BETWEEN", "LIKE", "RLIKE", "IS", "NULL", 
			"TRUE", "FALSE", "NULLS", "ASC", "DESC", "FOR", "INTERVAL", "CASE", "WHEN", 
			"THEN", "ELSE", "END", "JOIN", "CROSS", "OUTER", "INNER", "LEFT", "SEMI", 
			"RIGHT", "FULL", "NATURAL", "ON", "LATERAL", "WINDOW", "OVER", "PARTITION", 
			"RANGE", "ROWS", "UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "FIRST", 
			"AFTER", "LAST", "ROW", "WITH", "VALUES", "CREATE", "TABLE", "VIEW", 
			"REPLACE", "INSERT", "DELETE", "INTO", "DESCRIBE", "EXPLAIN", "FORMAT", 
			"LOGICAL", "CODEGEN", "COST", "CAST", "SHOW", "TABLES", "COLUMNS", "COLUMN", 
			"USE", "PARTITIONS", "FUNCTIONS", "DROP", "UNION", "EXCEPT", "SETMINUS", 
			"INTERSECT", "TO", "TABLESAMPLE", "STRATIFY", "ALTER", "RENAME", "ARRAY", 
			"MAP", "STRUCT", "COMMENT", "SET", "RESET", "DATA", "START", "TRANSACTION", 
			"COMMIT", "ROLLBACK", "MACRO", "IGNORE", "IF", "EQ", "NSEQ", "NEQ", "NEQJ", 
			"LT", "LTE", "GT", "GTE", "PLUS", "MINUS", "ASTERISK", "SLASH", "PERCENT", 
			"DIV", "TILDE", "AMPERSAND", "PIPE", "HAT", "PERCENTLIT", "BUCKET", "OUT", 
			"OF", "SORT", "CLUSTER", "DISTRIBUTE", "OVERWRITE", "TRANSFORM", "REDUCE", 
			"USING", "SERDE", "SERDEPROPERTIES", "RECORDREADER", "RECORDWRITER", 
			"DELIMITED", "FIELDS", "TERMINATED", "COLLECTION", "ITEMS", "KEYS", "ESCAPED", 
			"LINES", "SEPARATED", "FUNCTION", "EXTENDED", "REFRESH", "CLEAR", "CACHE", 
			"UNCACHE", "LAZY", "FORMATTED", "GLOBAL", "TEMPORARY", "OPTIONS", "UNSET", 
			"TBLPROPERTIES", "DBPROPERTIES", "BUCKETS", "SKEWED", "STORED", "DIRECTORIES", 
			"LOCATION", "EXCHANGE", "ARCHIVE", "UNARCHIVE", "FILEFORMAT", "TOUCH", 
			"COMPACT", "CONCATENATE", "CHANGE", "CASCADE", "RESTRICT", "CLUSTERED", 
			"SORTED", "PURGE", "INPUTFORMAT", "OUTPUTFORMAT", "DATABASE", "DATABASES", 
			"DFS", "TRUNCATE", "ANALYZE", "COMPUTE", "LIST", "STATISTICS", "PARTITIONED", 
			"EXTERNAL", "DEFINED", "REVOKE", "GRANT", "LOCK", "UNLOCK", "MSCK", "REPAIR", 
			"RECOVER", "EXPORT", "IMPORT", "LOAD", "ROLE", "ROLES", "COMPACTIONS", 
			"PRINCIPALS", "TRANSACTIONS", "INDEX", "INDEXES", "LOCKS", "OPTION", 
			"ANTI", "LOCAL", "INPATH", "CURRENT_DATE", "CURRENT_TIMESTAMP", "MCHORD", 
			"EUCLID", "METRICPOINT", "DTW", "FRECHET", "EDR", "LCSS", "TRIE", "KNN", 
			"TRAJECTORY", "POINT", "MBRRANGE", "CIRCLERANGE", "STRING", "BIGINT_LITERAL", 
			"SMALLINT_LITERAL", "TINYINT_LITERAL", "BYTELENGTH_LITERAL", "INTEGER_VALUE", 
			"DECIMAL_VALUE", "DOUBLE_LITERAL", "BIGDECIMAL_LITERAL", "IDENTIFIER", 
			"BACKQUOTED_IDENTIFIER", "SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", 
			"BRACKETED_COMMENT", "WS", "UNRECOGNIZED", "DELIMITER", "METRIC"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SqlBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  /**
	   * Verify whether current token is a valid decimal token (which contains dot).
	   * Returns true if the character that follows the token is not a digit or letter or underscore.
	   *
	   * For example:
	   * For char stream "2.3", "2." is not a valid decimal token, because it is followed by digit '3'.
	   * For char stream "2.3_", "2.3" is not a valid decimal token, because it is followed by '_'.
	   * For char stream "2.3W", "2.3" is not a valid decimal token, because it is followed by 'W'.
	   * For char stream "12.0D 34.E2+0.12 "  12.0D is a valid decimal token because it is folllowed
	   * by a space. 34.E2 is a valid decimal token because it is followed by symbol '+'
	   * which is not a digit or letter or underscore.
	   */
	  public boolean isValidDecimal() {
	    int nextChar = _input.LA(1);
	    if (nextChar >= 'A' && nextChar <= 'Z' || nextChar >= '0' && nextChar <= '9' ||
	      nextChar == '_') {
	      return false;
	    } else {
	      return true;
	    }
	  }

	public SqlBaseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SingleStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_singleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			statement();
			setState(207);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleExpressionContext extends ParserRuleContext {
		public NamedExpressionContext namedExpression() {
			return getRuleContext(NamedExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public SingleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleExpression; }
	}

	public final SingleExpressionContext singleExpression() throws RecognitionException {
		SingleExpressionContext _localctx = new SingleExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_singleExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			namedExpression();
			setState(210);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleTableIdentifierContext extends ParserRuleContext {
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public SingleTableIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleTableIdentifier; }
	}

	public final SingleTableIdentifierContext singleTableIdentifier() throws RecognitionException {
		SingleTableIdentifierContext _localctx = new SingleTableIdentifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_singleTableIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			tableIdentifier();
			setState(213);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleFunctionIdentifierContext extends ParserRuleContext {
		public FunctionIdentifierContext functionIdentifier() {
			return getRuleContext(FunctionIdentifierContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public SingleFunctionIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleFunctionIdentifier; }
	}

	public final SingleFunctionIdentifierContext singleFunctionIdentifier() throws RecognitionException {
		SingleFunctionIdentifierContext _localctx = new SingleFunctionIdentifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_singleFunctionIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			functionIdentifier();
			setState(216);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleDataTypeContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public SingleDataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleDataType; }
	}

	public final SingleDataTypeContext singleDataType() throws RecognitionException {
		SingleDataTypeContext _localctx = new SingleDataTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_singleDataType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			dataType();
			setState(219);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExplainContext extends StatementContext {
		public TerminalNode EXPLAIN() { return getToken(SqlBaseParser.EXPLAIN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode LOGICAL() { return getToken(SqlBaseParser.LOGICAL, 0); }
		public TerminalNode FORMATTED() { return getToken(SqlBaseParser.FORMATTED, 0); }
		public TerminalNode EXTENDED() { return getToken(SqlBaseParser.EXTENDED, 0); }
		public TerminalNode CODEGEN() { return getToken(SqlBaseParser.CODEGEN, 0); }
		public TerminalNode COST() { return getToken(SqlBaseParser.COST, 0); }
		public ExplainContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class DropDatabaseContext extends StatementContext {
		public TerminalNode DROP() { return getToken(SqlBaseParser.DROP, 0); }
		public TerminalNode DATABASE() { return getToken(SqlBaseParser.DATABASE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public TerminalNode RESTRICT() { return getToken(SqlBaseParser.RESTRICT, 0); }
		public TerminalNode CASCADE() { return getToken(SqlBaseParser.CASCADE, 0); }
		public DropDatabaseContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ResetConfigurationContext extends StatementContext {
		public TerminalNode RESET() { return getToken(SqlBaseParser.RESET, 0); }
		public ResetConfigurationContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class DescribeDatabaseContext extends StatementContext {
		public TerminalNode DATABASE() { return getToken(SqlBaseParser.DATABASE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DESC() { return getToken(SqlBaseParser.DESC, 0); }
		public TerminalNode DESCRIBE() { return getToken(SqlBaseParser.DESCRIBE, 0); }
		public TerminalNode EXTENDED() { return getToken(SqlBaseParser.EXTENDED, 0); }
		public DescribeDatabaseContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class AlterViewQueryContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public AlterViewQueryContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class UseContext extends StatementContext {
		public IdentifierContext db;
		public TerminalNode USE() { return getToken(SqlBaseParser.USE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public UseContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CreateTempViewUsingContext extends StatementContext {
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode TEMPORARY() { return getToken(SqlBaseParser.TEMPORARY, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TableProviderContext tableProvider() {
			return getRuleContext(TableProviderContext.class,0);
		}
		public TerminalNode OR() { return getToken(SqlBaseParser.OR, 0); }
		public TerminalNode REPLACE() { return getToken(SqlBaseParser.REPLACE, 0); }
		public TerminalNode GLOBAL() { return getToken(SqlBaseParser.GLOBAL, 0); }
		public ColTypeListContext colTypeList() {
			return getRuleContext(ColTypeListContext.class,0);
		}
		public TerminalNode OPTIONS() { return getToken(SqlBaseParser.OPTIONS, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public CreateTempViewUsingContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RenameTableContext extends StatementContext {
		public TableIdentifierContext from;
		public TableIdentifierContext to;
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode RENAME() { return getToken(SqlBaseParser.RENAME, 0); }
		public TerminalNode TO() { return getToken(SqlBaseParser.TO, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public List<TableIdentifierContext> tableIdentifier() {
			return getRuleContexts(TableIdentifierContext.class);
		}
		public TableIdentifierContext tableIdentifier(int i) {
			return getRuleContext(TableIdentifierContext.class,i);
		}
		public RenameTableContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class FailNativeCommandContext extends StatementContext {
		public TerminalNode SET() { return getToken(SqlBaseParser.SET, 0); }
		public TerminalNode ROLE() { return getToken(SqlBaseParser.ROLE, 0); }
		public UnsupportedHiveNativeCommandsContext unsupportedHiveNativeCommands() {
			return getRuleContext(UnsupportedHiveNativeCommandsContext.class,0);
		}
		public FailNativeCommandContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ClearCacheContext extends StatementContext {
		public TerminalNode CLEAR() { return getToken(SqlBaseParser.CLEAR, 0); }
		public TerminalNode CACHE() { return getToken(SqlBaseParser.CACHE, 0); }
		public ClearCacheContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ShowTrieIndexesContext extends StatementContext {
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode TRIE() { return getToken(SqlBaseParser.TRIE, 0); }
		public TerminalNode INDEXES() { return getToken(SqlBaseParser.INDEXES, 0); }
		public ShowTrieIndexesContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ShowTablesContext extends StatementContext {
		public IdentifierContext db;
		public Token pattern;
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode TABLES() { return getToken(SqlBaseParser.TABLES, 0); }
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TerminalNode LIKE() { return getToken(SqlBaseParser.LIKE, 0); }
		public ShowTablesContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RecoverPartitionsContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode RECOVER() { return getToken(SqlBaseParser.RECOVER, 0); }
		public TerminalNode PARTITIONS() { return getToken(SqlBaseParser.PARTITIONS, 0); }
		public RecoverPartitionsContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class DropMchordIndexContext extends StatementContext {
		public IdentifierContext indexIdentifier;
		public TerminalNode DROP() { return getToken(SqlBaseParser.DROP, 0); }
		public TerminalNode MCHORD() { return getToken(SqlBaseParser.MCHORD, 0); }
		public TerminalNode INDEX() { return getToken(SqlBaseParser.INDEX, 0); }
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DropMchordIndexContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RenameTablePartitionContext extends StatementContext {
		public PartitionSpecContext from;
		public PartitionSpecContext to;
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode RENAME() { return getToken(SqlBaseParser.RENAME, 0); }
		public TerminalNode TO() { return getToken(SqlBaseParser.TO, 0); }
		public List<PartitionSpecContext> partitionSpec() {
			return getRuleContexts(PartitionSpecContext.class);
		}
		public PartitionSpecContext partitionSpec(int i) {
			return getRuleContext(PartitionSpecContext.class,i);
		}
		public RenameTablePartitionContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RepairTableContext extends StatementContext {
		public TerminalNode MSCK() { return getToken(SqlBaseParser.MSCK, 0); }
		public TerminalNode REPAIR() { return getToken(SqlBaseParser.REPAIR, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public RepairTableContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RefreshResourceContext extends StatementContext {
		public TerminalNode REFRESH() { return getToken(SqlBaseParser.REFRESH, 0); }
		public RefreshResourceContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ShowCreateTableContext extends StatementContext {
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public ShowCreateTableContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ShowColumnsContext extends StatementContext {
		public IdentifierContext db;
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlBaseParser.COLUMNS, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public List<TerminalNode> FROM() { return getTokens(SqlBaseParser.FROM); }
		public TerminalNode FROM(int i) {
			return getToken(SqlBaseParser.FROM, i);
		}
		public List<TerminalNode> IN() { return getTokens(SqlBaseParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(SqlBaseParser.IN, i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ShowColumnsContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class AddTablePartitionContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode ADD() { return getToken(SqlBaseParser.ADD, 0); }
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public List<PartitionSpecLocationContext> partitionSpecLocation() {
			return getRuleContexts(PartitionSpecLocationContext.class);
		}
		public PartitionSpecLocationContext partitionSpecLocation(int i) {
			return getRuleContext(PartitionSpecLocationContext.class,i);
		}
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public List<PartitionSpecContext> partitionSpec() {
			return getRuleContexts(PartitionSpecContext.class);
		}
		public PartitionSpecContext partitionSpec(int i) {
			return getRuleContext(PartitionSpecContext.class,i);
		}
		public AddTablePartitionContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RefreshTableContext extends StatementContext {
		public TerminalNode REFRESH() { return getToken(SqlBaseParser.REFRESH, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public RefreshTableContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ManageResourceContext extends StatementContext {
		public Token op;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ADD() { return getToken(SqlBaseParser.ADD, 0); }
		public TerminalNode LIST() { return getToken(SqlBaseParser.LIST, 0); }
		public ManageResourceContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CreateDatabaseContext extends StatementContext {
		public Token comment;
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode DATABASE() { return getToken(SqlBaseParser.DATABASE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public TerminalNode COMMENT() { return getToken(SqlBaseParser.COMMENT, 0); }
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public TerminalNode DBPROPERTIES() { return getToken(SqlBaseParser.DBPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public CreateDatabaseContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class AnalyzeContext extends StatementContext {
		public TerminalNode ANALYZE() { return getToken(SqlBaseParser.ANALYZE, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode COMPUTE() { return getToken(SqlBaseParser.COMPUTE, 0); }
		public TerminalNode STATISTICS() { return getToken(SqlBaseParser.STATISTICS, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode FOR() { return getToken(SqlBaseParser.FOR, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlBaseParser.COLUMNS, 0); }
		public IdentifierSeqContext identifierSeq() {
			return getRuleContext(IdentifierSeqContext.class,0);
		}
		public AnalyzeContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CreateHiveTableContext extends StatementContext {
		public ColTypeListContext columns;
		public Token comment;
		public ColTypeListContext partitionColumns;
		public CreateTableHeaderContext createTableHeader() {
			return getRuleContext(CreateTableHeaderContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlBaseParser.COMMENT, 0); }
		public TerminalNode PARTITIONED() { return getToken(SqlBaseParser.PARTITIONED, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public BucketSpecContext bucketSpec() {
			return getRuleContext(BucketSpecContext.class,0);
		}
		public SkewSpecContext skewSpec() {
			return getRuleContext(SkewSpecContext.class,0);
		}
		public RowFormatContext rowFormat() {
			return getRuleContext(RowFormatContext.class,0);
		}
		public CreateFileFormatContext createFileFormat() {
			return getRuleContext(CreateFileFormatContext.class,0);
		}
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public TerminalNode TBLPROPERTIES() { return getToken(SqlBaseParser.TBLPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public List<ColTypeListContext> colTypeList() {
			return getRuleContexts(ColTypeListContext.class);
		}
		public ColTypeListContext colTypeList(int i) {
			return getRuleContext(ColTypeListContext.class,i);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public CreateHiveTableContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CreateFunctionContext extends StatementContext {
		public Token className;
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode FUNCTION() { return getToken(SqlBaseParser.FUNCTION, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TerminalNode TEMPORARY() { return getToken(SqlBaseParser.TEMPORARY, 0); }
		public TerminalNode USING() { return getToken(SqlBaseParser.USING, 0); }
		public List<ResourceContext> resource() {
			return getRuleContexts(ResourceContext.class);
		}
		public ResourceContext resource(int i) {
			return getRuleContext(ResourceContext.class,i);
		}
		public CreateFunctionContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ShowTableContext extends StatementContext {
		public IdentifierContext db;
		public Token pattern;
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TerminalNode EXTENDED() { return getToken(SqlBaseParser.EXTENDED, 0); }
		public TerminalNode LIKE() { return getToken(SqlBaseParser.LIKE, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ShowTableContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class SetDatabasePropertiesContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode DATABASE() { return getToken(SqlBaseParser.DATABASE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SET() { return getToken(SqlBaseParser.SET, 0); }
		public TerminalNode DBPROPERTIES() { return getToken(SqlBaseParser.DBPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public SetDatabasePropertiesContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CreateTableContext extends StatementContext {
		public TablePropertyListContext options;
		public IdentifierListContext partitionColumnNames;
		public Token comment;
		public CreateTableHeaderContext createTableHeader() {
			return getRuleContext(CreateTableHeaderContext.class,0);
		}
		public TableProviderContext tableProvider() {
			return getRuleContext(TableProviderContext.class,0);
		}
		public ColTypeListContext colTypeList() {
			return getRuleContext(ColTypeListContext.class,0);
		}
		public TerminalNode OPTIONS() { return getToken(SqlBaseParser.OPTIONS, 0); }
		public TerminalNode PARTITIONED() { return getToken(SqlBaseParser.PARTITIONED, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public BucketSpecContext bucketSpec() {
			return getRuleContext(BucketSpecContext.class,0);
		}
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlBaseParser.COMMENT, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public CreateTableContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class DescribeTableContext extends StatementContext {
		public Token option;
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode DESC() { return getToken(SqlBaseParser.DESC, 0); }
		public TerminalNode DESCRIBE() { return getToken(SqlBaseParser.DESCRIBE, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public DescribeColNameContext describeColName() {
			return getRuleContext(DescribeColNameContext.class,0);
		}
		public TerminalNode EXTENDED() { return getToken(SqlBaseParser.EXTENDED, 0); }
		public TerminalNode FORMATTED() { return getToken(SqlBaseParser.FORMATTED, 0); }
		public DescribeTableContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CreateTableLikeContext extends StatementContext {
		public TableIdentifierContext target;
		public TableIdentifierContext source;
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TerminalNode LIKE() { return getToken(SqlBaseParser.LIKE, 0); }
		public List<TableIdentifierContext> tableIdentifier() {
			return getRuleContexts(TableIdentifierContext.class);
		}
		public TableIdentifierContext tableIdentifier(int i) {
			return getRuleContext(TableIdentifierContext.class,i);
		}
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public CreateTableLikeContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class UncacheTableContext extends StatementContext {
		public TerminalNode UNCACHE() { return getToken(SqlBaseParser.UNCACHE, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public UncacheTableContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CreateTrieIndexContext extends StatementContext {
		public IdentifierContext indexIdentifier;
		public IdentifierContext column;
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode TRIE() { return getToken(SqlBaseParser.TRIE, 0); }
		public TerminalNode INDEX() { return getToken(SqlBaseParser.INDEX, 0); }
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public CreateTrieIndexContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class DropFunctionContext extends StatementContext {
		public TerminalNode DROP() { return getToken(SqlBaseParser.DROP, 0); }
		public TerminalNode FUNCTION() { return getToken(SqlBaseParser.FUNCTION, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode TEMPORARY() { return getToken(SqlBaseParser.TEMPORARY, 0); }
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public DropFunctionContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class LoadDataContext extends StatementContext {
		public Token path;
		public TerminalNode LOAD() { return getToken(SqlBaseParser.LOAD, 0); }
		public TerminalNode DATA() { return getToken(SqlBaseParser.DATA, 0); }
		public TerminalNode INPATH() { return getToken(SqlBaseParser.INPATH, 0); }
		public TerminalNode INTO() { return getToken(SqlBaseParser.INTO, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TerminalNode LOCAL() { return getToken(SqlBaseParser.LOCAL, 0); }
		public TerminalNode OVERWRITE() { return getToken(SqlBaseParser.OVERWRITE, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public LoadDataContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ShowPartitionsContext extends StatementContext {
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode PARTITIONS() { return getToken(SqlBaseParser.PARTITIONS, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public ShowPartitionsContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class DescribeFunctionContext extends StatementContext {
		public TerminalNode FUNCTION() { return getToken(SqlBaseParser.FUNCTION, 0); }
		public DescribeFuncNameContext describeFuncName() {
			return getRuleContext(DescribeFuncNameContext.class,0);
		}
		public TerminalNode DESC() { return getToken(SqlBaseParser.DESC, 0); }
		public TerminalNode DESCRIBE() { return getToken(SqlBaseParser.DESCRIBE, 0); }
		public TerminalNode EXTENDED() { return getToken(SqlBaseParser.EXTENDED, 0); }
		public DescribeFunctionContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ChangeColumnContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode CHANGE() { return getToken(SqlBaseParser.CHANGE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColTypeContext colType() {
			return getRuleContext(ColTypeContext.class,0);
		}
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode COLUMN() { return getToken(SqlBaseParser.COLUMN, 0); }
		public ColPositionContext colPosition() {
			return getRuleContext(ColPositionContext.class,0);
		}
		public ChangeColumnContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ShowMchordIndexesContext extends StatementContext {
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode MCHORD() { return getToken(SqlBaseParser.MCHORD, 0); }
		public TerminalNode INDEXES() { return getToken(SqlBaseParser.INDEXES, 0); }
		public ShowMchordIndexesContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatementDefaultContext extends StatementContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public StatementDefaultContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class TruncateTableContext extends StatementContext {
		public TerminalNode TRUNCATE() { return getToken(SqlBaseParser.TRUNCATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TruncateTableContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class SetTableSerDeContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode SET() { return getToken(SqlBaseParser.SET, 0); }
		public TerminalNode SERDE() { return getToken(SqlBaseParser.SERDE, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(SqlBaseParser.SERDEPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public SetTableSerDeContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CreateViewContext extends StatementContext {
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode OR() { return getToken(SqlBaseParser.OR, 0); }
		public TerminalNode REPLACE() { return getToken(SqlBaseParser.REPLACE, 0); }
		public TerminalNode TEMPORARY() { return getToken(SqlBaseParser.TEMPORARY, 0); }
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public IdentifierCommentListContext identifierCommentList() {
			return getRuleContext(IdentifierCommentListContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlBaseParser.COMMENT, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TerminalNode PARTITIONED() { return getToken(SqlBaseParser.PARTITIONED, 0); }
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode TBLPROPERTIES() { return getToken(SqlBaseParser.TBLPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public TerminalNode GLOBAL() { return getToken(SqlBaseParser.GLOBAL, 0); }
		public CreateViewContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class DropTablePartitionsContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode DROP() { return getToken(SqlBaseParser.DROP, 0); }
		public List<PartitionSpecContext> partitionSpec() {
			return getRuleContexts(PartitionSpecContext.class);
		}
		public PartitionSpecContext partitionSpec(int i) {
			return getRuleContext(PartitionSpecContext.class,i);
		}
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public TerminalNode PURGE() { return getToken(SqlBaseParser.PURGE, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public DropTablePartitionsContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class SetConfigurationContext extends StatementContext {
		public TerminalNode SET() { return getToken(SqlBaseParser.SET, 0); }
		public SetConfigurationContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class DropTableContext extends StatementContext {
		public TerminalNode DROP() { return getToken(SqlBaseParser.DROP, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public TerminalNode PURGE() { return getToken(SqlBaseParser.PURGE, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public DropTableContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CreateMchordIndexContext extends StatementContext {
		public IdentifierContext indexIdentifier;
		public IdentifierContext column;
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode MCHORD() { return getToken(SqlBaseParser.MCHORD, 0); }
		public TerminalNode INDEX() { return getToken(SqlBaseParser.INDEX, 0); }
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public CreateMchordIndexContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ShowDatabasesContext extends StatementContext {
		public Token pattern;
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode DATABASES() { return getToken(SqlBaseParser.DATABASES, 0); }
		public TerminalNode LIKE() { return getToken(SqlBaseParser.LIKE, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public ShowDatabasesContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class DropTrieIndexContext extends StatementContext {
		public IdentifierContext indexIdentifier;
		public TerminalNode DROP() { return getToken(SqlBaseParser.DROP, 0); }
		public TerminalNode TRIE() { return getToken(SqlBaseParser.TRIE, 0); }
		public TerminalNode INDEX() { return getToken(SqlBaseParser.INDEX, 0); }
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DropTrieIndexContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ShowTblPropertiesContext extends StatementContext {
		public TableIdentifierContext table;
		public TablePropertyKeyContext key;
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode TBLPROPERTIES() { return getToken(SqlBaseParser.TBLPROPERTIES, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TablePropertyKeyContext tablePropertyKey() {
			return getRuleContext(TablePropertyKeyContext.class,0);
		}
		public ShowTblPropertiesContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class UnsetTablePropertiesContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode UNSET() { return getToken(SqlBaseParser.UNSET, 0); }
		public TerminalNode TBLPROPERTIES() { return getToken(SqlBaseParser.TBLPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public UnsetTablePropertiesContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class SetTableLocationContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode SET() { return getToken(SqlBaseParser.SET, 0); }
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public SetTableLocationContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ShowFunctionsContext extends StatementContext {
		public Token pattern;
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode FUNCTIONS() { return getToken(SqlBaseParser.FUNCTIONS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(SqlBaseParser.LIKE, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public ShowFunctionsContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CacheTableContext extends StatementContext {
		public TerminalNode CACHE() { return getToken(SqlBaseParser.CACHE, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode LAZY() { return getToken(SqlBaseParser.LAZY, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public CacheTableContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class AddTableColumnsContext extends StatementContext {
		public ColTypeListContext columns;
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode ADD() { return getToken(SqlBaseParser.ADD, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlBaseParser.COLUMNS, 0); }
		public ColTypeListContext colTypeList() {
			return getRuleContext(ColTypeListContext.class,0);
		}
		public AddTableColumnsContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class SetTablePropertiesContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode SET() { return getToken(SqlBaseParser.SET, 0); }
		public TerminalNode TBLPROPERTIES() { return getToken(SqlBaseParser.TBLPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public SetTablePropertiesContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(867);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				_localctx = new StatementDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				query();
				}
				break;
			case 2:
				_localctx = new UseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(USE);
				setState(223);
				((UseContext)_localctx).db = identifier();
				}
				break;
			case 3:
				_localctx = new CreateDatabaseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				match(CREATE);
				setState(225);
				match(DATABASE);
				setState(229);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(226);
					match(IF);
					setState(227);
					match(NOT);
					setState(228);
					match(EXISTS);
					}
					break;
				}
				setState(231);
				identifier();
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(232);
					match(COMMENT);
					setState(233);
					((CreateDatabaseContext)_localctx).comment = match(STRING);
					}
				}

				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCATION) {
					{
					setState(236);
					locationSpec();
					}
				}

				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(239);
					match(WITH);
					setState(240);
					match(DBPROPERTIES);
					setState(241);
					tablePropertyList();
					}
				}

				}
				break;
			case 4:
				_localctx = new SetDatabasePropertiesContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(244);
				match(ALTER);
				setState(245);
				match(DATABASE);
				setState(246);
				identifier();
				setState(247);
				match(SET);
				setState(248);
				match(DBPROPERTIES);
				setState(249);
				tablePropertyList();
				}
				break;
			case 5:
				_localctx = new DropDatabaseContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(251);
				match(DROP);
				setState(252);
				match(DATABASE);
				setState(255);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(253);
					match(IF);
					setState(254);
					match(EXISTS);
					}
					break;
				}
				setState(257);
				identifier();
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(258);
					_la = _input.LA(1);
					if ( !(_la==CASCADE || _la==RESTRICT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			case 6:
				_localctx = new CreateTableContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(261);
				createTableHeader();
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(262);
					match(T__0);
					setState(263);
					colTypeList();
					setState(264);
					match(T__1);
					}
				}

				setState(268);
				tableProvider();
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS) {
					{
					setState(269);
					match(OPTIONS);
					setState(270);
					((CreateTableContext)_localctx).options = tablePropertyList();
					}
				}

				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONED) {
					{
					setState(273);
					match(PARTITIONED);
					setState(274);
					match(BY);
					setState(275);
					((CreateTableContext)_localctx).partitionColumnNames = identifierList();
					}
				}

				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CLUSTERED) {
					{
					setState(278);
					bucketSpec();
					}
				}

				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCATION) {
					{
					setState(281);
					locationSpec();
					}
				}

				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(284);
					match(COMMENT);
					setState(285);
					((CreateTableContext)_localctx).comment = match(STRING);
					}
				}

				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SELECT) | (1L << FROM) | (1L << AS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (WITH - 74)) | (1L << (VALUES - 74)) | (1L << (TABLE - 74)) | (1L << (INSERT - 74)) | (1L << (MAP - 74)))) != 0) || _la==REDUCE) {
					{
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(288);
						match(AS);
						}
					}

					setState(291);
					query();
					}
				}

				}
				break;
			case 7:
				_localctx = new CreateHiveTableContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(294);
				createTableHeader();
				setState(299);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(295);
					match(T__0);
					setState(296);
					((CreateHiveTableContext)_localctx).columns = colTypeList();
					setState(297);
					match(T__1);
					}
					break;
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(301);
					match(COMMENT);
					setState(302);
					((CreateHiveTableContext)_localctx).comment = match(STRING);
					}
				}

				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONED) {
					{
					setState(305);
					match(PARTITIONED);
					setState(306);
					match(BY);
					setState(307);
					match(T__0);
					setState(308);
					((CreateHiveTableContext)_localctx).partitionColumns = colTypeList();
					setState(309);
					match(T__1);
					}
				}

				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CLUSTERED) {
					{
					setState(313);
					bucketSpec();
					}
				}

				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SKEWED) {
					{
					setState(316);
					skewSpec();
					}
				}

				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROW) {
					{
					setState(319);
					rowFormat();
					}
				}

				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STORED) {
					{
					setState(322);
					createFileFormat();
					}
				}

				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCATION) {
					{
					setState(325);
					locationSpec();
					}
				}

				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TBLPROPERTIES) {
					{
					setState(328);
					match(TBLPROPERTIES);
					setState(329);
					tablePropertyList();
					}
				}

				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SELECT) | (1L << FROM) | (1L << AS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (WITH - 74)) | (1L << (VALUES - 74)) | (1L << (TABLE - 74)) | (1L << (INSERT - 74)) | (1L << (MAP - 74)))) != 0) || _la==REDUCE) {
					{
					setState(333);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(332);
						match(AS);
						}
					}

					setState(335);
					query();
					}
				}

				}
				break;
			case 8:
				_localctx = new CreateTableLikeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(338);
				match(CREATE);
				setState(339);
				match(TABLE);
				setState(343);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(340);
					match(IF);
					setState(341);
					match(NOT);
					setState(342);
					match(EXISTS);
					}
					break;
				}
				setState(345);
				((CreateTableLikeContext)_localctx).target = tableIdentifier();
				setState(346);
				match(LIKE);
				setState(347);
				((CreateTableLikeContext)_localctx).source = tableIdentifier();
				setState(349);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCATION) {
					{
					setState(348);
					locationSpec();
					}
				}

				}
				break;
			case 9:
				_localctx = new AnalyzeContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(351);
				match(ANALYZE);
				setState(352);
				match(TABLE);
				setState(353);
				tableIdentifier();
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(354);
					partitionSpec();
					}
				}

				setState(357);
				match(COMPUTE);
				setState(358);
				match(STATISTICS);
				setState(363);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(359);
					identifier();
					}
					break;
				case 2:
					{
					setState(360);
					match(FOR);
					setState(361);
					match(COLUMNS);
					setState(362);
					identifierSeq();
					}
					break;
				}
				}
				break;
			case 10:
				_localctx = new AddTableColumnsContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(365);
				match(ALTER);
				setState(366);
				match(TABLE);
				setState(367);
				tableIdentifier();
				setState(368);
				match(ADD);
				setState(369);
				match(COLUMNS);
				setState(370);
				match(T__0);
				setState(371);
				((AddTableColumnsContext)_localctx).columns = colTypeList();
				setState(372);
				match(T__1);
				}
				break;
			case 11:
				_localctx = new RenameTableContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(374);
				match(ALTER);
				setState(375);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==VIEW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(376);
				((RenameTableContext)_localctx).from = tableIdentifier();
				setState(377);
				match(RENAME);
				setState(378);
				match(TO);
				setState(379);
				((RenameTableContext)_localctx).to = tableIdentifier();
				}
				break;
			case 12:
				_localctx = new SetTablePropertiesContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(381);
				match(ALTER);
				setState(382);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==VIEW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(383);
				tableIdentifier();
				setState(384);
				match(SET);
				setState(385);
				match(TBLPROPERTIES);
				setState(386);
				tablePropertyList();
				}
				break;
			case 13:
				_localctx = new UnsetTablePropertiesContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(388);
				match(ALTER);
				setState(389);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==VIEW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(390);
				tableIdentifier();
				setState(391);
				match(UNSET);
				setState(392);
				match(TBLPROPERTIES);
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(393);
					match(IF);
					setState(394);
					match(EXISTS);
					}
				}

				setState(397);
				tablePropertyList();
				}
				break;
			case 14:
				_localctx = new ChangeColumnContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(399);
				match(ALTER);
				setState(400);
				match(TABLE);
				setState(401);
				tableIdentifier();
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(402);
					partitionSpec();
					}
				}

				setState(405);
				match(CHANGE);
				setState(407);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(406);
					match(COLUMN);
					}
					break;
				}
				setState(409);
				identifier();
				setState(410);
				colType();
				setState(412);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FIRST || _la==AFTER) {
					{
					setState(411);
					colPosition();
					}
				}

				}
				break;
			case 15:
				_localctx = new SetTableSerDeContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(414);
				match(ALTER);
				setState(415);
				match(TABLE);
				setState(416);
				tableIdentifier();
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(417);
					partitionSpec();
					}
				}

				setState(420);
				match(SET);
				setState(421);
				match(SERDE);
				setState(422);
				match(STRING);
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(423);
					match(WITH);
					setState(424);
					match(SERDEPROPERTIES);
					setState(425);
					tablePropertyList();
					}
				}

				}
				break;
			case 16:
				_localctx = new SetTableSerDeContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(428);
				match(ALTER);
				setState(429);
				match(TABLE);
				setState(430);
				tableIdentifier();
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(431);
					partitionSpec();
					}
				}

				setState(434);
				match(SET);
				setState(435);
				match(SERDEPROPERTIES);
				setState(436);
				tablePropertyList();
				}
				break;
			case 17:
				_localctx = new AddTablePartitionContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(438);
				match(ALTER);
				setState(439);
				match(TABLE);
				setState(440);
				tableIdentifier();
				setState(441);
				match(ADD);
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(442);
					match(IF);
					setState(443);
					match(NOT);
					setState(444);
					match(EXISTS);
					}
				}

				setState(448); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(447);
					partitionSpecLocation();
					}
					}
					setState(450); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PARTITION );
				}
				break;
			case 18:
				_localctx = new AddTablePartitionContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(452);
				match(ALTER);
				setState(453);
				match(VIEW);
				setState(454);
				tableIdentifier();
				setState(455);
				match(ADD);
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(456);
					match(IF);
					setState(457);
					match(NOT);
					setState(458);
					match(EXISTS);
					}
				}

				setState(462); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(461);
					partitionSpec();
					}
					}
					setState(464); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PARTITION );
				}
				break;
			case 19:
				_localctx = new RenameTablePartitionContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(466);
				match(ALTER);
				setState(467);
				match(TABLE);
				setState(468);
				tableIdentifier();
				setState(469);
				((RenameTablePartitionContext)_localctx).from = partitionSpec();
				setState(470);
				match(RENAME);
				setState(471);
				match(TO);
				setState(472);
				((RenameTablePartitionContext)_localctx).to = partitionSpec();
				}
				break;
			case 20:
				_localctx = new DropTablePartitionsContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(474);
				match(ALTER);
				setState(475);
				match(TABLE);
				setState(476);
				tableIdentifier();
				setState(477);
				match(DROP);
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(478);
					match(IF);
					setState(479);
					match(EXISTS);
					}
				}

				setState(482);
				partitionSpec();
				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(483);
					match(T__2);
					setState(484);
					partitionSpec();
					}
					}
					setState(489);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(491);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PURGE) {
					{
					setState(490);
					match(PURGE);
					}
				}

				}
				break;
			case 21:
				_localctx = new DropTablePartitionsContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(493);
				match(ALTER);
				setState(494);
				match(VIEW);
				setState(495);
				tableIdentifier();
				setState(496);
				match(DROP);
				setState(499);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(497);
					match(IF);
					setState(498);
					match(EXISTS);
					}
				}

				setState(501);
				partitionSpec();
				setState(506);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(502);
					match(T__2);
					setState(503);
					partitionSpec();
					}
					}
					setState(508);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 22:
				_localctx = new SetTableLocationContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(509);
				match(ALTER);
				setState(510);
				match(TABLE);
				setState(511);
				tableIdentifier();
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(512);
					partitionSpec();
					}
				}

				setState(515);
				match(SET);
				setState(516);
				locationSpec();
				}
				break;
			case 23:
				_localctx = new RecoverPartitionsContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(518);
				match(ALTER);
				setState(519);
				match(TABLE);
				setState(520);
				tableIdentifier();
				setState(521);
				match(RECOVER);
				setState(522);
				match(PARTITIONS);
				}
				break;
			case 24:
				_localctx = new DropTableContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(524);
				match(DROP);
				setState(525);
				match(TABLE);
				setState(528);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(526);
					match(IF);
					setState(527);
					match(EXISTS);
					}
					break;
				}
				setState(530);
				tableIdentifier();
				setState(532);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PURGE) {
					{
					setState(531);
					match(PURGE);
					}
				}

				}
				break;
			case 25:
				_localctx = new DropTableContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(534);
				match(DROP);
				setState(535);
				match(VIEW);
				setState(538);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(536);
					match(IF);
					setState(537);
					match(EXISTS);
					}
					break;
				}
				setState(540);
				tableIdentifier();
				}
				break;
			case 26:
				_localctx = new CreateViewContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(541);
				match(CREATE);
				setState(544);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(542);
					match(OR);
					setState(543);
					match(REPLACE);
					}
				}

				setState(550);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GLOBAL || _la==TEMPORARY) {
					{
					setState(547);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==GLOBAL) {
						{
						setState(546);
						match(GLOBAL);
						}
					}

					setState(549);
					match(TEMPORARY);
					}
				}

				setState(552);
				match(VIEW);
				setState(556);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
				case 1:
					{
					setState(553);
					match(IF);
					setState(554);
					match(NOT);
					setState(555);
					match(EXISTS);
					}
					break;
				}
				setState(558);
				tableIdentifier();
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(559);
					identifierCommentList();
					}
				}

				setState(564);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(562);
					match(COMMENT);
					setState(563);
					match(STRING);
					}
				}

				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONED) {
					{
					setState(566);
					match(PARTITIONED);
					setState(567);
					match(ON);
					setState(568);
					identifierList();
					}
				}

				setState(573);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TBLPROPERTIES) {
					{
					setState(571);
					match(TBLPROPERTIES);
					setState(572);
					tablePropertyList();
					}
				}

				setState(575);
				match(AS);
				setState(576);
				query();
				}
				break;
			case 27:
				_localctx = new CreateTempViewUsingContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(578);
				match(CREATE);
				setState(581);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(579);
					match(OR);
					setState(580);
					match(REPLACE);
					}
				}

				setState(584);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GLOBAL) {
					{
					setState(583);
					match(GLOBAL);
					}
				}

				setState(586);
				match(TEMPORARY);
				setState(587);
				match(VIEW);
				setState(588);
				tableIdentifier();
				setState(593);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(589);
					match(T__0);
					setState(590);
					colTypeList();
					setState(591);
					match(T__1);
					}
				}

				setState(595);
				tableProvider();
				setState(598);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS) {
					{
					setState(596);
					match(OPTIONS);
					setState(597);
					tablePropertyList();
					}
				}

				}
				break;
			case 28:
				_localctx = new AlterViewQueryContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(600);
				match(ALTER);
				setState(601);
				match(VIEW);
				setState(602);
				tableIdentifier();
				setState(604);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(603);
					match(AS);
					}
				}

				setState(606);
				query();
				}
				break;
			case 29:
				_localctx = new CreateFunctionContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(608);
				match(CREATE);
				setState(610);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TEMPORARY) {
					{
					setState(609);
					match(TEMPORARY);
					}
				}

				setState(612);
				match(FUNCTION);
				setState(613);
				qualifiedName();
				setState(614);
				match(AS);
				setState(615);
				((CreateFunctionContext)_localctx).className = match(STRING);
				setState(625);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(616);
					match(USING);
					setState(617);
					resource();
					setState(622);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(618);
						match(T__2);
						setState(619);
						resource();
						}
						}
						setState(624);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			case 30:
				_localctx = new DropFunctionContext(_localctx);
				enterOuterAlt(_localctx, 30);
				{
				setState(627);
				match(DROP);
				setState(629);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TEMPORARY) {
					{
					setState(628);
					match(TEMPORARY);
					}
				}

				setState(631);
				match(FUNCTION);
				setState(634);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(632);
					match(IF);
					setState(633);
					match(EXISTS);
					}
					break;
				}
				setState(636);
				qualifiedName();
				}
				break;
			case 31:
				_localctx = new ExplainContext(_localctx);
				enterOuterAlt(_localctx, 31);
				{
				setState(637);
				match(EXPLAIN);
				setState(639);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (LOGICAL - 86)) | (1L << (CODEGEN - 86)) | (1L << (COST - 86)))) != 0) || _la==EXTENDED || _la==FORMATTED) {
					{
					setState(638);
					_la = _input.LA(1);
					if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (LOGICAL - 86)) | (1L << (CODEGEN - 86)) | (1L << (COST - 86)))) != 0) || _la==EXTENDED || _la==FORMATTED) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(641);
				statement();
				}
				break;
			case 32:
				_localctx = new ShowTablesContext(_localctx);
				enterOuterAlt(_localctx, 32);
				{
				setState(642);
				match(SHOW);
				setState(643);
				match(TABLES);
				setState(646);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM || _la==IN) {
					{
					setState(644);
					_la = _input.LA(1);
					if ( !(_la==FROM || _la==IN) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(645);
					((ShowTablesContext)_localctx).db = identifier();
					}
				}

				setState(652);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LIKE || _la==STRING) {
					{
					setState(649);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LIKE) {
						{
						setState(648);
						match(LIKE);
						}
					}

					setState(651);
					((ShowTablesContext)_localctx).pattern = match(STRING);
					}
				}

				}
				break;
			case 33:
				_localctx = new ShowTableContext(_localctx);
				enterOuterAlt(_localctx, 33);
				{
				setState(654);
				match(SHOW);
				setState(655);
				match(TABLE);
				setState(656);
				match(EXTENDED);
				setState(659);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM || _la==IN) {
					{
					setState(657);
					_la = _input.LA(1);
					if ( !(_la==FROM || _la==IN) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(658);
					((ShowTableContext)_localctx).db = identifier();
					}
				}

				setState(661);
				match(LIKE);
				setState(662);
				((ShowTableContext)_localctx).pattern = match(STRING);
				setState(664);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(663);
					partitionSpec();
					}
				}

				}
				break;
			case 34:
				_localctx = new ShowDatabasesContext(_localctx);
				enterOuterAlt(_localctx, 34);
				{
				setState(666);
				match(SHOW);
				setState(667);
				match(DATABASES);
				setState(670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LIKE) {
					{
					setState(668);
					match(LIKE);
					setState(669);
					((ShowDatabasesContext)_localctx).pattern = match(STRING);
					}
				}

				}
				break;
			case 35:
				_localctx = new ShowTblPropertiesContext(_localctx);
				enterOuterAlt(_localctx, 35);
				{
				setState(672);
				match(SHOW);
				setState(673);
				match(TBLPROPERTIES);
				setState(674);
				((ShowTblPropertiesContext)_localctx).table = tableIdentifier();
				setState(679);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(675);
					match(T__0);
					setState(676);
					((ShowTblPropertiesContext)_localctx).key = tablePropertyKey();
					setState(677);
					match(T__1);
					}
				}

				}
				break;
			case 36:
				_localctx = new ShowColumnsContext(_localctx);
				enterOuterAlt(_localctx, 36);
				{
				setState(681);
				match(SHOW);
				setState(682);
				match(COLUMNS);
				setState(683);
				_la = _input.LA(1);
				if ( !(_la==FROM || _la==IN) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(684);
				tableIdentifier();
				setState(687);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM || _la==IN) {
					{
					setState(685);
					_la = _input.LA(1);
					if ( !(_la==FROM || _la==IN) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(686);
					((ShowColumnsContext)_localctx).db = identifier();
					}
				}

				}
				break;
			case 37:
				_localctx = new ShowPartitionsContext(_localctx);
				enterOuterAlt(_localctx, 37);
				{
				setState(689);
				match(SHOW);
				setState(690);
				match(PARTITIONS);
				setState(691);
				tableIdentifier();
				setState(693);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(692);
					partitionSpec();
					}
				}

				}
				break;
			case 38:
				_localctx = new ShowFunctionsContext(_localctx);
				enterOuterAlt(_localctx, 38);
				{
				setState(695);
				match(SHOW);
				setState(697);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(696);
					identifier();
					}
					break;
				}
				setState(699);
				match(FUNCTIONS);
				setState(707);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL) | (1L << ON) | (1L << LATERAL) | (1L << WINDOW) | (1L << OVER) | (1L << PARTITION))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (DIV - 134)) | (1L << (PERCENTLIT - 134)) | (1L << (BUCKET - 134)) | (1L << (OUT - 134)) | (1L << (OF - 134)) | (1L << (SORT - 134)) | (1L << (CLUSTER - 134)) | (1L << (DISTRIBUTE - 134)) | (1L << (OVERWRITE - 134)) | (1L << (TRANSFORM - 134)) | (1L << (REDUCE - 134)) | (1L << (USING - 134)) | (1L << (SERDE - 134)) | (1L << (SERDEPROPERTIES - 134)) | (1L << (RECORDREADER - 134)) | (1L << (RECORDWRITER - 134)) | (1L << (DELIMITED - 134)) | (1L << (FIELDS - 134)) | (1L << (TERMINATED - 134)) | (1L << (COLLECTION - 134)) | (1L << (ITEMS - 134)) | (1L << (KEYS - 134)) | (1L << (ESCAPED - 134)) | (1L << (LINES - 134)) | (1L << (SEPARATED - 134)) | (1L << (FUNCTION - 134)) | (1L << (EXTENDED - 134)) | (1L << (REFRESH - 134)) | (1L << (CLEAR - 134)) | (1L << (CACHE - 134)) | (1L << (UNCACHE - 134)) | (1L << (LAZY - 134)) | (1L << (FORMATTED - 134)) | (1L << (GLOBAL - 134)) | (1L << (TEMPORARY - 134)) | (1L << (OPTIONS - 134)) | (1L << (UNSET - 134)) | (1L << (TBLPROPERTIES - 134)) | (1L << (DBPROPERTIES - 134)) | (1L << (BUCKETS - 134)) | (1L << (SKEWED - 134)) | (1L << (STORED - 134)) | (1L << (DIRECTORIES - 134)) | (1L << (LOCATION - 134)) | (1L << (EXCHANGE - 134)) | (1L << (ARCHIVE - 134)) | (1L << (UNARCHIVE - 134)) | (1L << (FILEFORMAT - 134)) | (1L << (TOUCH - 134)) | (1L << (COMPACT - 134)) | (1L << (CONCATENATE - 134)) | (1L << (CHANGE - 134)) | (1L << (CASCADE - 134)) | (1L << (RESTRICT - 134)) | (1L << (CLUSTERED - 134)) | (1L << (SORTED - 134)) | (1L << (PURGE - 134)) | (1L << (INPUTFORMAT - 134)) | (1L << (OUTPUTFORMAT - 134)) | (1L << (DATABASE - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (DATABASES - 198)) | (1L << (DFS - 198)) | (1L << (TRUNCATE - 198)) | (1L << (ANALYZE - 198)) | (1L << (COMPUTE - 198)) | (1L << (LIST - 198)) | (1L << (STATISTICS - 198)) | (1L << (PARTITIONED - 198)) | (1L << (EXTERNAL - 198)) | (1L << (DEFINED - 198)) | (1L << (REVOKE - 198)) | (1L << (GRANT - 198)) | (1L << (LOCK - 198)) | (1L << (UNLOCK - 198)) | (1L << (MSCK - 198)) | (1L << (REPAIR - 198)) | (1L << (RECOVER - 198)) | (1L << (EXPORT - 198)) | (1L << (IMPORT - 198)) | (1L << (LOAD - 198)) | (1L << (ROLE - 198)) | (1L << (ROLES - 198)) | (1L << (COMPACTIONS - 198)) | (1L << (PRINCIPALS - 198)) | (1L << (TRANSACTIONS - 198)) | (1L << (INDEX - 198)) | (1L << (INDEXES - 198)) | (1L << (LOCKS - 198)) | (1L << (OPTION - 198)) | (1L << (ANTI - 198)) | (1L << (LOCAL - 198)) | (1L << (INPATH - 198)) | (1L << (CURRENT_DATE - 198)) | (1L << (CURRENT_TIMESTAMP - 198)) | (1L << (STRING - 198)) | (1L << (IDENTIFIER - 198)) | (1L << (BACKQUOTED_IDENTIFIER - 198)))) != 0)) {
					{
					setState(701);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
					case 1:
						{
						setState(700);
						match(LIKE);
						}
						break;
					}
					setState(705);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SELECT:
					case FROM:
					case ADD:
					case AS:
					case ALL:
					case DISTINCT:
					case WHERE:
					case GROUP:
					case BY:
					case GROUPING:
					case SETS:
					case CUBE:
					case ROLLUP:
					case ORDER:
					case HAVING:
					case LIMIT:
					case AT:
					case OR:
					case AND:
					case IN:
					case NOT:
					case NO:
					case EXISTS:
					case BETWEEN:
					case LIKE:
					case RLIKE:
					case IS:
					case NULL:
					case TRUE:
					case FALSE:
					case NULLS:
					case ASC:
					case DESC:
					case FOR:
					case INTERVAL:
					case CASE:
					case WHEN:
					case THEN:
					case ELSE:
					case END:
					case JOIN:
					case CROSS:
					case OUTER:
					case INNER:
					case LEFT:
					case SEMI:
					case RIGHT:
					case FULL:
					case NATURAL:
					case ON:
					case LATERAL:
					case WINDOW:
					case OVER:
					case PARTITION:
					case RANGE:
					case ROWS:
					case UNBOUNDED:
					case PRECEDING:
					case FOLLOWING:
					case CURRENT:
					case FIRST:
					case AFTER:
					case LAST:
					case ROW:
					case WITH:
					case VALUES:
					case CREATE:
					case TABLE:
					case VIEW:
					case REPLACE:
					case INSERT:
					case DELETE:
					case INTO:
					case DESCRIBE:
					case EXPLAIN:
					case FORMAT:
					case LOGICAL:
					case CODEGEN:
					case COST:
					case CAST:
					case SHOW:
					case TABLES:
					case COLUMNS:
					case COLUMN:
					case USE:
					case PARTITIONS:
					case FUNCTIONS:
					case DROP:
					case UNION:
					case EXCEPT:
					case SETMINUS:
					case INTERSECT:
					case TO:
					case TABLESAMPLE:
					case STRATIFY:
					case ALTER:
					case RENAME:
					case ARRAY:
					case MAP:
					case STRUCT:
					case COMMENT:
					case SET:
					case RESET:
					case DATA:
					case START:
					case TRANSACTION:
					case COMMIT:
					case ROLLBACK:
					case MACRO:
					case IGNORE:
					case IF:
					case DIV:
					case PERCENTLIT:
					case BUCKET:
					case OUT:
					case OF:
					case SORT:
					case CLUSTER:
					case DISTRIBUTE:
					case OVERWRITE:
					case TRANSFORM:
					case REDUCE:
					case USING:
					case SERDE:
					case SERDEPROPERTIES:
					case RECORDREADER:
					case RECORDWRITER:
					case DELIMITED:
					case FIELDS:
					case TERMINATED:
					case COLLECTION:
					case ITEMS:
					case KEYS:
					case ESCAPED:
					case LINES:
					case SEPARATED:
					case FUNCTION:
					case EXTENDED:
					case REFRESH:
					case CLEAR:
					case CACHE:
					case UNCACHE:
					case LAZY:
					case FORMATTED:
					case GLOBAL:
					case TEMPORARY:
					case OPTIONS:
					case UNSET:
					case TBLPROPERTIES:
					case DBPROPERTIES:
					case BUCKETS:
					case SKEWED:
					case STORED:
					case DIRECTORIES:
					case LOCATION:
					case EXCHANGE:
					case ARCHIVE:
					case UNARCHIVE:
					case FILEFORMAT:
					case TOUCH:
					case COMPACT:
					case CONCATENATE:
					case CHANGE:
					case CASCADE:
					case RESTRICT:
					case CLUSTERED:
					case SORTED:
					case PURGE:
					case INPUTFORMAT:
					case OUTPUTFORMAT:
					case DATABASE:
					case DATABASES:
					case DFS:
					case TRUNCATE:
					case ANALYZE:
					case COMPUTE:
					case LIST:
					case STATISTICS:
					case PARTITIONED:
					case EXTERNAL:
					case DEFINED:
					case REVOKE:
					case GRANT:
					case LOCK:
					case UNLOCK:
					case MSCK:
					case REPAIR:
					case RECOVER:
					case EXPORT:
					case IMPORT:
					case LOAD:
					case ROLE:
					case ROLES:
					case COMPACTIONS:
					case PRINCIPALS:
					case TRANSACTIONS:
					case INDEX:
					case INDEXES:
					case LOCKS:
					case OPTION:
					case ANTI:
					case LOCAL:
					case INPATH:
					case CURRENT_DATE:
					case CURRENT_TIMESTAMP:
					case IDENTIFIER:
					case BACKQUOTED_IDENTIFIER:
						{
						setState(703);
						qualifiedName();
						}
						break;
					case STRING:
						{
						setState(704);
						((ShowFunctionsContext)_localctx).pattern = match(STRING);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}

				}
				break;
			case 39:
				_localctx = new ShowCreateTableContext(_localctx);
				enterOuterAlt(_localctx, 39);
				{
				setState(709);
				match(SHOW);
				setState(710);
				match(CREATE);
				setState(711);
				match(TABLE);
				setState(712);
				tableIdentifier();
				}
				break;
			case 40:
				_localctx = new DescribeFunctionContext(_localctx);
				enterOuterAlt(_localctx, 40);
				{
				setState(713);
				_la = _input.LA(1);
				if ( !(_la==DESC || _la==DESCRIBE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(714);
				match(FUNCTION);
				setState(716);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
				case 1:
					{
					setState(715);
					match(EXTENDED);
					}
					break;
				}
				setState(718);
				describeFuncName();
				}
				break;
			case 41:
				_localctx = new DescribeDatabaseContext(_localctx);
				enterOuterAlt(_localctx, 41);
				{
				setState(719);
				_la = _input.LA(1);
				if ( !(_la==DESC || _la==DESCRIBE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(720);
				match(DATABASE);
				setState(722);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
				case 1:
					{
					setState(721);
					match(EXTENDED);
					}
					break;
				}
				setState(724);
				identifier();
				}
				break;
			case 42:
				_localctx = new DescribeTableContext(_localctx);
				enterOuterAlt(_localctx, 42);
				{
				setState(725);
				_la = _input.LA(1);
				if ( !(_la==DESC || _la==DESCRIBE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(727);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					setState(726);
					match(TABLE);
					}
					break;
				}
				setState(730);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
				case 1:
					{
					setState(729);
					((DescribeTableContext)_localctx).option = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==EXTENDED || _la==FORMATTED) ) {
						((DescribeTableContext)_localctx).option = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(732);
				tableIdentifier();
				setState(734);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
				case 1:
					{
					setState(733);
					partitionSpec();
					}
					break;
				}
				setState(737);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL) | (1L << ON) | (1L << LATERAL) | (1L << WINDOW) | (1L << OVER) | (1L << PARTITION))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (DIV - 134)) | (1L << (PERCENTLIT - 134)) | (1L << (BUCKET - 134)) | (1L << (OUT - 134)) | (1L << (OF - 134)) | (1L << (SORT - 134)) | (1L << (CLUSTER - 134)) | (1L << (DISTRIBUTE - 134)) | (1L << (OVERWRITE - 134)) | (1L << (TRANSFORM - 134)) | (1L << (REDUCE - 134)) | (1L << (USING - 134)) | (1L << (SERDE - 134)) | (1L << (SERDEPROPERTIES - 134)) | (1L << (RECORDREADER - 134)) | (1L << (RECORDWRITER - 134)) | (1L << (DELIMITED - 134)) | (1L << (FIELDS - 134)) | (1L << (TERMINATED - 134)) | (1L << (COLLECTION - 134)) | (1L << (ITEMS - 134)) | (1L << (KEYS - 134)) | (1L << (ESCAPED - 134)) | (1L << (LINES - 134)) | (1L << (SEPARATED - 134)) | (1L << (FUNCTION - 134)) | (1L << (EXTENDED - 134)) | (1L << (REFRESH - 134)) | (1L << (CLEAR - 134)) | (1L << (CACHE - 134)) | (1L << (UNCACHE - 134)) | (1L << (LAZY - 134)) | (1L << (FORMATTED - 134)) | (1L << (GLOBAL - 134)) | (1L << (TEMPORARY - 134)) | (1L << (OPTIONS - 134)) | (1L << (UNSET - 134)) | (1L << (TBLPROPERTIES - 134)) | (1L << (DBPROPERTIES - 134)) | (1L << (BUCKETS - 134)) | (1L << (SKEWED - 134)) | (1L << (STORED - 134)) | (1L << (DIRECTORIES - 134)) | (1L << (LOCATION - 134)) | (1L << (EXCHANGE - 134)) | (1L << (ARCHIVE - 134)) | (1L << (UNARCHIVE - 134)) | (1L << (FILEFORMAT - 134)) | (1L << (TOUCH - 134)) | (1L << (COMPACT - 134)) | (1L << (CONCATENATE - 134)) | (1L << (CHANGE - 134)) | (1L << (CASCADE - 134)) | (1L << (RESTRICT - 134)) | (1L << (CLUSTERED - 134)) | (1L << (SORTED - 134)) | (1L << (PURGE - 134)) | (1L << (INPUTFORMAT - 134)) | (1L << (OUTPUTFORMAT - 134)) | (1L << (DATABASE - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (DATABASES - 198)) | (1L << (DFS - 198)) | (1L << (TRUNCATE - 198)) | (1L << (ANALYZE - 198)) | (1L << (COMPUTE - 198)) | (1L << (LIST - 198)) | (1L << (STATISTICS - 198)) | (1L << (PARTITIONED - 198)) | (1L << (EXTERNAL - 198)) | (1L << (DEFINED - 198)) | (1L << (REVOKE - 198)) | (1L << (GRANT - 198)) | (1L << (LOCK - 198)) | (1L << (UNLOCK - 198)) | (1L << (MSCK - 198)) | (1L << (REPAIR - 198)) | (1L << (RECOVER - 198)) | (1L << (EXPORT - 198)) | (1L << (IMPORT - 198)) | (1L << (LOAD - 198)) | (1L << (ROLE - 198)) | (1L << (ROLES - 198)) | (1L << (COMPACTIONS - 198)) | (1L << (PRINCIPALS - 198)) | (1L << (TRANSACTIONS - 198)) | (1L << (INDEX - 198)) | (1L << (INDEXES - 198)) | (1L << (LOCKS - 198)) | (1L << (OPTION - 198)) | (1L << (ANTI - 198)) | (1L << (LOCAL - 198)) | (1L << (INPATH - 198)) | (1L << (CURRENT_DATE - 198)) | (1L << (CURRENT_TIMESTAMP - 198)) | (1L << (IDENTIFIER - 198)) | (1L << (BACKQUOTED_IDENTIFIER - 198)))) != 0)) {
					{
					setState(736);
					describeColName();
					}
				}

				}
				break;
			case 43:
				_localctx = new RefreshTableContext(_localctx);
				enterOuterAlt(_localctx, 43);
				{
				setState(739);
				match(REFRESH);
				setState(740);
				match(TABLE);
				setState(741);
				tableIdentifier();
				}
				break;
			case 44:
				_localctx = new RefreshResourceContext(_localctx);
				enterOuterAlt(_localctx, 44);
				{
				setState(742);
				match(REFRESH);
				setState(746);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(743);
						matchWildcard();
						}
						} 
					}
					setState(748);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
				}
				}
				break;
			case 45:
				_localctx = new CacheTableContext(_localctx);
				enterOuterAlt(_localctx, 45);
				{
				setState(749);
				match(CACHE);
				setState(751);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LAZY) {
					{
					setState(750);
					match(LAZY);
					}
				}

				setState(753);
				match(TABLE);
				setState(754);
				tableIdentifier();
				setState(759);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SELECT) | (1L << FROM) | (1L << AS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (WITH - 74)) | (1L << (VALUES - 74)) | (1L << (TABLE - 74)) | (1L << (INSERT - 74)) | (1L << (MAP - 74)))) != 0) || _la==REDUCE) {
					{
					setState(756);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(755);
						match(AS);
						}
					}

					setState(758);
					query();
					}
				}

				}
				break;
			case 46:
				_localctx = new UncacheTableContext(_localctx);
				enterOuterAlt(_localctx, 46);
				{
				setState(761);
				match(UNCACHE);
				setState(762);
				match(TABLE);
				setState(765);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
				case 1:
					{
					setState(763);
					match(IF);
					setState(764);
					match(EXISTS);
					}
					break;
				}
				setState(767);
				tableIdentifier();
				}
				break;
			case 47:
				_localctx = new ClearCacheContext(_localctx);
				enterOuterAlt(_localctx, 47);
				{
				setState(768);
				match(CLEAR);
				setState(769);
				match(CACHE);
				}
				break;
			case 48:
				_localctx = new LoadDataContext(_localctx);
				enterOuterAlt(_localctx, 48);
				{
				setState(770);
				match(LOAD);
				setState(771);
				match(DATA);
				setState(773);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCAL) {
					{
					setState(772);
					match(LOCAL);
					}
				}

				setState(775);
				match(INPATH);
				setState(776);
				((LoadDataContext)_localctx).path = match(STRING);
				setState(778);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(777);
					match(OVERWRITE);
					}
				}

				setState(780);
				match(INTO);
				setState(781);
				match(TABLE);
				setState(782);
				tableIdentifier();
				setState(784);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(783);
					partitionSpec();
					}
				}

				}
				break;
			case 49:
				_localctx = new TruncateTableContext(_localctx);
				enterOuterAlt(_localctx, 49);
				{
				setState(786);
				match(TRUNCATE);
				setState(787);
				match(TABLE);
				setState(788);
				tableIdentifier();
				setState(790);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(789);
					partitionSpec();
					}
				}

				}
				break;
			case 50:
				_localctx = new RepairTableContext(_localctx);
				enterOuterAlt(_localctx, 50);
				{
				setState(792);
				match(MSCK);
				setState(793);
				match(REPAIR);
				setState(794);
				match(TABLE);
				setState(795);
				tableIdentifier();
				}
				break;
			case 51:
				_localctx = new ManageResourceContext(_localctx);
				enterOuterAlt(_localctx, 51);
				{
				setState(796);
				((ManageResourceContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==LIST) ) {
					((ManageResourceContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(797);
				identifier();
				setState(801);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(798);
						matchWildcard();
						}
						} 
					}
					setState(803);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
				}
				}
				break;
			case 52:
				_localctx = new FailNativeCommandContext(_localctx);
				enterOuterAlt(_localctx, 52);
				{
				setState(804);
				match(SET);
				setState(805);
				match(ROLE);
				setState(809);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(806);
						matchWildcard();
						}
						} 
					}
					setState(811);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				}
				}
				break;
			case 53:
				_localctx = new SetConfigurationContext(_localctx);
				enterOuterAlt(_localctx, 53);
				{
				setState(812);
				match(SET);
				setState(816);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(813);
						matchWildcard();
						}
						} 
					}
					setState(818);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
				}
				}
				break;
			case 54:
				_localctx = new ResetConfigurationContext(_localctx);
				enterOuterAlt(_localctx, 54);
				{
				setState(819);
				match(RESET);
				}
				break;
			case 55:
				_localctx = new CreateTrieIndexContext(_localctx);
				enterOuterAlt(_localctx, 55);
				{
				setState(820);
				match(CREATE);
				setState(821);
				match(TRIE);
				setState(822);
				match(INDEX);
				setState(823);
				((CreateTrieIndexContext)_localctx).indexIdentifier = identifier();
				setState(824);
				match(ON);
				setState(825);
				tableIdentifier();
				setState(826);
				match(T__0);
				setState(827);
				((CreateTrieIndexContext)_localctx).column = identifier();
				setState(828);
				match(T__1);
				}
				break;
			case 56:
				_localctx = new DropTrieIndexContext(_localctx);
				enterOuterAlt(_localctx, 56);
				{
				setState(830);
				match(DROP);
				setState(831);
				match(TRIE);
				setState(832);
				match(INDEX);
				setState(833);
				((DropTrieIndexContext)_localctx).indexIdentifier = identifier();
				setState(834);
				match(ON);
				setState(835);
				tableIdentifier();
				}
				break;
			case 57:
				_localctx = new ShowTrieIndexesContext(_localctx);
				enterOuterAlt(_localctx, 57);
				{
				setState(837);
				match(SHOW);
				setState(838);
				match(TRIE);
				setState(839);
				match(INDEXES);
				}
				break;
			case 58:
				_localctx = new CreateMchordIndexContext(_localctx);
				enterOuterAlt(_localctx, 58);
				{
				setState(840);
				match(CREATE);
				setState(841);
				match(MCHORD);
				setState(842);
				match(INDEX);
				setState(843);
				((CreateMchordIndexContext)_localctx).indexIdentifier = identifier();
				setState(844);
				match(ON);
				setState(845);
				tableIdentifier();
				setState(846);
				match(T__0);
				setState(847);
				((CreateMchordIndexContext)_localctx).column = identifier();
				setState(848);
				match(T__1);
				}
				break;
			case 59:
				_localctx = new DropMchordIndexContext(_localctx);
				enterOuterAlt(_localctx, 59);
				{
				setState(850);
				match(DROP);
				setState(851);
				match(MCHORD);
				setState(852);
				match(INDEX);
				setState(853);
				((DropMchordIndexContext)_localctx).indexIdentifier = identifier();
				setState(854);
				match(ON);
				setState(855);
				tableIdentifier();
				}
				break;
			case 60:
				_localctx = new ShowMchordIndexesContext(_localctx);
				enterOuterAlt(_localctx, 60);
				{
				setState(857);
				match(SHOW);
				setState(858);
				match(MCHORD);
				setState(859);
				match(INDEXES);
				}
				break;
			case 61:
				_localctx = new FailNativeCommandContext(_localctx);
				enterOuterAlt(_localctx, 61);
				{
				setState(860);
				unsupportedHiveNativeCommands();
				setState(864);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(861);
						matchWildcard();
						}
						} 
					}
					setState(866);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsupportedHiveNativeCommandsContext extends ParserRuleContext {
		public Token kw1;
		public Token kw2;
		public Token kw3;
		public Token kw4;
		public Token kw5;
		public Token kw6;
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode ROLE() { return getToken(SqlBaseParser.ROLE, 0); }
		public TerminalNode DROP() { return getToken(SqlBaseParser.DROP, 0); }
		public TerminalNode GRANT() { return getToken(SqlBaseParser.GRANT, 0); }
		public TerminalNode REVOKE() { return getToken(SqlBaseParser.REVOKE, 0); }
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode PRINCIPALS() { return getToken(SqlBaseParser.PRINCIPALS, 0); }
		public TerminalNode ROLES() { return getToken(SqlBaseParser.ROLES, 0); }
		public TerminalNode CURRENT() { return getToken(SqlBaseParser.CURRENT, 0); }
		public TerminalNode EXPORT() { return getToken(SqlBaseParser.EXPORT, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TerminalNode IMPORT() { return getToken(SqlBaseParser.IMPORT, 0); }
		public TerminalNode COMPACTIONS() { return getToken(SqlBaseParser.COMPACTIONS, 0); }
		public TerminalNode TRANSACTIONS() { return getToken(SqlBaseParser.TRANSACTIONS, 0); }
		public TerminalNode INDEXES() { return getToken(SqlBaseParser.INDEXES, 0); }
		public TerminalNode LOCKS() { return getToken(SqlBaseParser.LOCKS, 0); }
		public TerminalNode INDEX() { return getToken(SqlBaseParser.INDEX, 0); }
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode LOCK() { return getToken(SqlBaseParser.LOCK, 0); }
		public TerminalNode DATABASE() { return getToken(SqlBaseParser.DATABASE, 0); }
		public TerminalNode UNLOCK() { return getToken(SqlBaseParser.UNLOCK, 0); }
		public TerminalNode TEMPORARY() { return getToken(SqlBaseParser.TEMPORARY, 0); }
		public TerminalNode MACRO() { return getToken(SqlBaseParser.MACRO, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public TerminalNode CLUSTERED() { return getToken(SqlBaseParser.CLUSTERED, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public TerminalNode SORTED() { return getToken(SqlBaseParser.SORTED, 0); }
		public TerminalNode SKEWED() { return getToken(SqlBaseParser.SKEWED, 0); }
		public TerminalNode STORED() { return getToken(SqlBaseParser.STORED, 0); }
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public TerminalNode DIRECTORIES() { return getToken(SqlBaseParser.DIRECTORIES, 0); }
		public TerminalNode SET() { return getToken(SqlBaseParser.SET, 0); }
		public TerminalNode LOCATION() { return getToken(SqlBaseParser.LOCATION, 0); }
		public TerminalNode EXCHANGE() { return getToken(SqlBaseParser.EXCHANGE, 0); }
		public TerminalNode PARTITION() { return getToken(SqlBaseParser.PARTITION, 0); }
		public TerminalNode ARCHIVE() { return getToken(SqlBaseParser.ARCHIVE, 0); }
		public TerminalNode UNARCHIVE() { return getToken(SqlBaseParser.UNARCHIVE, 0); }
		public TerminalNode TOUCH() { return getToken(SqlBaseParser.TOUCH, 0); }
		public TerminalNode COMPACT() { return getToken(SqlBaseParser.COMPACT, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode CONCATENATE() { return getToken(SqlBaseParser.CONCATENATE, 0); }
		public TerminalNode FILEFORMAT() { return getToken(SqlBaseParser.FILEFORMAT, 0); }
		public TerminalNode REPLACE() { return getToken(SqlBaseParser.REPLACE, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlBaseParser.COLUMNS, 0); }
		public TerminalNode START() { return getToken(SqlBaseParser.START, 0); }
		public TerminalNode TRANSACTION() { return getToken(SqlBaseParser.TRANSACTION, 0); }
		public TerminalNode COMMIT() { return getToken(SqlBaseParser.COMMIT, 0); }
		public TerminalNode ROLLBACK() { return getToken(SqlBaseParser.ROLLBACK, 0); }
		public TerminalNode DFS() { return getToken(SqlBaseParser.DFS, 0); }
		public TerminalNode DELETE() { return getToken(SqlBaseParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public UnsupportedHiveNativeCommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsupportedHiveNativeCommands; }
	}

	public final UnsupportedHiveNativeCommandsContext unsupportedHiveNativeCommands() throws RecognitionException {
		UnsupportedHiveNativeCommandsContext _localctx = new UnsupportedHiveNativeCommandsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_unsupportedHiveNativeCommands);
		int _la;
		try {
			setState(1039);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(869);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(CREATE);
				setState(870);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(871);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DROP);
				setState(872);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(873);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(GRANT);
				setState(875);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(874);
					((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(877);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(REVOKE);
				setState(879);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(878);
					((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(881);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(882);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(GRANT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(883);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(884);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
				setState(886);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
				case 1:
					{
					setState(885);
					((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(GRANT);
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(888);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(889);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(PRINCIPALS);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(890);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(891);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLES);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(892);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(893);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(CURRENT);
				setState(894);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(ROLES);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(895);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(EXPORT);
				setState(896);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(897);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(IMPORT);
				setState(898);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(899);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(900);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(COMPACTIONS);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(901);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(902);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(CREATE);
				setState(903);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(TABLE);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(904);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(905);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TRANSACTIONS);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(906);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(907);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(INDEXES);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(908);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(909);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(LOCKS);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(910);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(CREATE);
				setState(911);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(INDEX);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(912);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DROP);
				setState(913);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(INDEX);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(914);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(915);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(INDEX);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(916);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(LOCK);
				setState(917);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(918);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(LOCK);
				setState(919);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(DATABASE);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(920);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(UNLOCK);
				setState(921);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(922);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(UNLOCK);
				setState(923);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(DATABASE);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(924);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(CREATE);
				setState(925);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TEMPORARY);
				setState(926);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(MACRO);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(927);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DROP);
				setState(928);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TEMPORARY);
				setState(929);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(MACRO);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(930);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(931);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(932);
				tableIdentifier();
				setState(933);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(NOT);
				setState(934);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(CLUSTERED);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(936);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(937);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(938);
				tableIdentifier();
				setState(939);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(CLUSTERED);
				setState(940);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(BY);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(942);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(943);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(944);
				tableIdentifier();
				setState(945);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(NOT);
				setState(946);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(SORTED);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(948);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(949);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(950);
				tableIdentifier();
				setState(951);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(SKEWED);
				setState(952);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(BY);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(954);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(955);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(956);
				tableIdentifier();
				setState(957);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(NOT);
				setState(958);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(SKEWED);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(960);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(961);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(962);
				tableIdentifier();
				setState(963);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(NOT);
				setState(964);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(STORED);
				setState(965);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw5 = match(AS);
				setState(966);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw6 = match(DIRECTORIES);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(968);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(969);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(970);
				tableIdentifier();
				setState(971);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(SET);
				setState(972);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(SKEWED);
				setState(973);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw5 = match(LOCATION);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(975);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(976);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(977);
				tableIdentifier();
				setState(978);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(EXCHANGE);
				setState(979);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(PARTITION);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(981);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(982);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(983);
				tableIdentifier();
				setState(984);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(ARCHIVE);
				setState(985);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(PARTITION);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(987);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(988);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(989);
				tableIdentifier();
				setState(990);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(UNARCHIVE);
				setState(991);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(PARTITION);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(993);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(994);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(995);
				tableIdentifier();
				setState(996);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(TOUCH);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(998);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(999);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1000);
				tableIdentifier();
				setState(1002);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1001);
					partitionSpec();
					}
				}

				setState(1004);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(COMPACT);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(1006);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1007);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1008);
				tableIdentifier();
				setState(1010);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1009);
					partitionSpec();
					}
				}

				setState(1012);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(CONCATENATE);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(1014);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1015);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1016);
				tableIdentifier();
				setState(1018);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1017);
					partitionSpec();
					}
				}

				setState(1020);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(SET);
				setState(1021);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(FILEFORMAT);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				setState(1023);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1024);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1025);
				tableIdentifier();
				setState(1027);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1026);
					partitionSpec();
					}
				}

				setState(1029);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(REPLACE);
				setState(1030);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(COLUMNS);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(1032);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(START);
				setState(1033);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TRANSACTION);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(1034);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(COMMIT);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 43);
				{
				setState(1035);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ROLLBACK);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 44);
				{
				setState(1036);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DFS);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 45);
				{
				setState(1037);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DELETE);
				setState(1038);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(FROM);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateTableHeaderContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode TEMPORARY() { return getToken(SqlBaseParser.TEMPORARY, 0); }
		public TerminalNode EXTERNAL() { return getToken(SqlBaseParser.EXTERNAL, 0); }
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public CreateTableHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTableHeader; }
	}

	public final CreateTableHeaderContext createTableHeader() throws RecognitionException {
		CreateTableHeaderContext _localctx = new CreateTableHeaderContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_createTableHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1041);
			match(CREATE);
			setState(1043);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMPORARY) {
				{
				setState(1042);
				match(TEMPORARY);
				}
			}

			setState(1046);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTERNAL) {
				{
				setState(1045);
				match(EXTERNAL);
				}
			}

			setState(1048);
			match(TABLE);
			setState(1052);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				{
				setState(1049);
				match(IF);
				setState(1050);
				match(NOT);
				setState(1051);
				match(EXISTS);
				}
				break;
			}
			setState(1054);
			tableIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BucketSpecContext extends ParserRuleContext {
		public TerminalNode CLUSTERED() { return getToken(SqlBaseParser.CLUSTERED, 0); }
		public List<TerminalNode> BY() { return getTokens(SqlBaseParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SqlBaseParser.BY, i);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode INTO() { return getToken(SqlBaseParser.INTO, 0); }
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode BUCKETS() { return getToken(SqlBaseParser.BUCKETS, 0); }
		public TerminalNode SORTED() { return getToken(SqlBaseParser.SORTED, 0); }
		public OrderedIdentifierListContext orderedIdentifierList() {
			return getRuleContext(OrderedIdentifierListContext.class,0);
		}
		public BucketSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bucketSpec; }
	}

	public final BucketSpecContext bucketSpec() throws RecognitionException {
		BucketSpecContext _localctx = new BucketSpecContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bucketSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1056);
			match(CLUSTERED);
			setState(1057);
			match(BY);
			setState(1058);
			identifierList();
			setState(1062);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SORTED) {
				{
				setState(1059);
				match(SORTED);
				setState(1060);
				match(BY);
				setState(1061);
				orderedIdentifierList();
				}
			}

			setState(1064);
			match(INTO);
			setState(1065);
			match(INTEGER_VALUE);
			setState(1066);
			match(BUCKETS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkewSpecContext extends ParserRuleContext {
		public TerminalNode SKEWED() { return getToken(SqlBaseParser.SKEWED, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public ConstantListContext constantList() {
			return getRuleContext(ConstantListContext.class,0);
		}
		public NestedConstantListContext nestedConstantList() {
			return getRuleContext(NestedConstantListContext.class,0);
		}
		public TerminalNode STORED() { return getToken(SqlBaseParser.STORED, 0); }
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public TerminalNode DIRECTORIES() { return getToken(SqlBaseParser.DIRECTORIES, 0); }
		public SkewSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skewSpec; }
	}

	public final SkewSpecContext skewSpec() throws RecognitionException {
		SkewSpecContext _localctx = new SkewSpecContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_skewSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1068);
			match(SKEWED);
			setState(1069);
			match(BY);
			setState(1070);
			identifierList();
			setState(1071);
			match(ON);
			setState(1074);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				{
				setState(1072);
				constantList();
				}
				break;
			case 2:
				{
				setState(1073);
				nestedConstantList();
				}
				break;
			}
			setState(1079);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(1076);
				match(STORED);
				setState(1077);
				match(AS);
				setState(1078);
				match(DIRECTORIES);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocationSpecContext extends ParserRuleContext {
		public TerminalNode LOCATION() { return getToken(SqlBaseParser.LOCATION, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public LocationSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_locationSpec; }
	}

	public final LocationSpecContext locationSpec() throws RecognitionException {
		LocationSpecContext _localctx = new LocationSpecContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_locationSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1081);
			match(LOCATION);
			setState(1082);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public CtesContext ctes() {
			return getRuleContext(CtesContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1085);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1084);
				ctes();
				}
			}

			setState(1087);
			queryNoWith();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertIntoContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(SqlBaseParser.INSERT, 0); }
		public TerminalNode OVERWRITE() { return getToken(SqlBaseParser.OVERWRITE, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public TerminalNode INTO() { return getToken(SqlBaseParser.INTO, 0); }
		public InsertIntoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertInto; }
	}

	public final InsertIntoContext insertInto() throws RecognitionException {
		InsertIntoContext _localctx = new InsertIntoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_insertInto);
		int _la;
		try {
			setState(1110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1089);
				match(INSERT);
				setState(1090);
				match(OVERWRITE);
				setState(1091);
				match(TABLE);
				setState(1092);
				tableIdentifier();
				setState(1099);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1093);
					partitionSpec();
					setState(1097);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IF) {
						{
						setState(1094);
						match(IF);
						setState(1095);
						match(NOT);
						setState(1096);
						match(EXISTS);
						}
					}

					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1101);
				match(INSERT);
				setState(1102);
				match(INTO);
				setState(1104);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
				case 1:
					{
					setState(1103);
					match(TABLE);
					}
					break;
				}
				setState(1106);
				tableIdentifier();
				setState(1108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1107);
					partitionSpec();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionSpecLocationContext extends ParserRuleContext {
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public PartitionSpecLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionSpecLocation; }
	}

	public final PartitionSpecLocationContext partitionSpecLocation() throws RecognitionException {
		PartitionSpecLocationContext _localctx = new PartitionSpecLocationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_partitionSpecLocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1112);
			partitionSpec();
			setState(1114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCATION) {
				{
				setState(1113);
				locationSpec();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionSpecContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SqlBaseParser.PARTITION, 0); }
		public List<PartitionValContext> partitionVal() {
			return getRuleContexts(PartitionValContext.class);
		}
		public PartitionValContext partitionVal(int i) {
			return getRuleContext(PartitionValContext.class,i);
		}
		public PartitionSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionSpec; }
	}

	public final PartitionSpecContext partitionSpec() throws RecognitionException {
		PartitionSpecContext _localctx = new PartitionSpecContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_partitionSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1116);
			match(PARTITION);
			setState(1117);
			match(T__0);
			setState(1118);
			partitionVal();
			setState(1123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1119);
				match(T__2);
				setState(1120);
				partitionVal();
				}
				}
				setState(1125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1126);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionValContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SqlBaseParser.EQ, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public PartitionValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionVal; }
	}

	public final PartitionValContext partitionVal() throws RecognitionException {
		PartitionValContext _localctx = new PartitionValContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_partitionVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1128);
			identifier();
			setState(1131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(1129);
				match(EQ);
				setState(1130);
				constant();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescribeFuncNameContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ArithmeticOperatorContext arithmeticOperator() {
			return getRuleContext(ArithmeticOperatorContext.class,0);
		}
		public PredicateOperatorContext predicateOperator() {
			return getRuleContext(PredicateOperatorContext.class,0);
		}
		public DescribeFuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_describeFuncName; }
	}

	public final DescribeFuncNameContext describeFuncName() throws RecognitionException {
		DescribeFuncNameContext _localctx = new DescribeFuncNameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_describeFuncName);
		try {
			setState(1138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1133);
				qualifiedName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1134);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1135);
				comparisonOperator();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1136);
				arithmeticOperator();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1137);
				predicateOperator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescribeColNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> STRING() { return getTokens(SqlBaseParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SqlBaseParser.STRING, i);
		}
		public DescribeColNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_describeColName; }
	}

	public final DescribeColNameContext describeColName() throws RecognitionException {
		DescribeColNameContext _localctx = new DescribeColNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_describeColName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1140);
			identifier();
			setState(1148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(1141);
				match(T__3);
				setState(1144);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT:
				case FROM:
				case ADD:
				case AS:
				case ALL:
				case DISTINCT:
				case WHERE:
				case GROUP:
				case BY:
				case GROUPING:
				case SETS:
				case CUBE:
				case ROLLUP:
				case ORDER:
				case HAVING:
				case LIMIT:
				case AT:
				case OR:
				case AND:
				case IN:
				case NOT:
				case NO:
				case EXISTS:
				case BETWEEN:
				case LIKE:
				case RLIKE:
				case IS:
				case NULL:
				case TRUE:
				case FALSE:
				case NULLS:
				case ASC:
				case DESC:
				case FOR:
				case INTERVAL:
				case CASE:
				case WHEN:
				case THEN:
				case ELSE:
				case END:
				case JOIN:
				case CROSS:
				case OUTER:
				case INNER:
				case LEFT:
				case SEMI:
				case RIGHT:
				case FULL:
				case NATURAL:
				case ON:
				case LATERAL:
				case WINDOW:
				case OVER:
				case PARTITION:
				case RANGE:
				case ROWS:
				case UNBOUNDED:
				case PRECEDING:
				case FOLLOWING:
				case CURRENT:
				case FIRST:
				case AFTER:
				case LAST:
				case ROW:
				case WITH:
				case VALUES:
				case CREATE:
				case TABLE:
				case VIEW:
				case REPLACE:
				case INSERT:
				case DELETE:
				case INTO:
				case DESCRIBE:
				case EXPLAIN:
				case FORMAT:
				case LOGICAL:
				case CODEGEN:
				case COST:
				case CAST:
				case SHOW:
				case TABLES:
				case COLUMNS:
				case COLUMN:
				case USE:
				case PARTITIONS:
				case FUNCTIONS:
				case DROP:
				case UNION:
				case EXCEPT:
				case SETMINUS:
				case INTERSECT:
				case TO:
				case TABLESAMPLE:
				case STRATIFY:
				case ALTER:
				case RENAME:
				case ARRAY:
				case MAP:
				case STRUCT:
				case COMMENT:
				case SET:
				case RESET:
				case DATA:
				case START:
				case TRANSACTION:
				case COMMIT:
				case ROLLBACK:
				case MACRO:
				case IGNORE:
				case IF:
				case DIV:
				case PERCENTLIT:
				case BUCKET:
				case OUT:
				case OF:
				case SORT:
				case CLUSTER:
				case DISTRIBUTE:
				case OVERWRITE:
				case TRANSFORM:
				case REDUCE:
				case USING:
				case SERDE:
				case SERDEPROPERTIES:
				case RECORDREADER:
				case RECORDWRITER:
				case DELIMITED:
				case FIELDS:
				case TERMINATED:
				case COLLECTION:
				case ITEMS:
				case KEYS:
				case ESCAPED:
				case LINES:
				case SEPARATED:
				case FUNCTION:
				case EXTENDED:
				case REFRESH:
				case CLEAR:
				case CACHE:
				case UNCACHE:
				case LAZY:
				case FORMATTED:
				case GLOBAL:
				case TEMPORARY:
				case OPTIONS:
				case UNSET:
				case TBLPROPERTIES:
				case DBPROPERTIES:
				case BUCKETS:
				case SKEWED:
				case STORED:
				case DIRECTORIES:
				case LOCATION:
				case EXCHANGE:
				case ARCHIVE:
				case UNARCHIVE:
				case FILEFORMAT:
				case TOUCH:
				case COMPACT:
				case CONCATENATE:
				case CHANGE:
				case CASCADE:
				case RESTRICT:
				case CLUSTERED:
				case SORTED:
				case PURGE:
				case INPUTFORMAT:
				case OUTPUTFORMAT:
				case DATABASE:
				case DATABASES:
				case DFS:
				case TRUNCATE:
				case ANALYZE:
				case COMPUTE:
				case LIST:
				case STATISTICS:
				case PARTITIONED:
				case EXTERNAL:
				case DEFINED:
				case REVOKE:
				case GRANT:
				case LOCK:
				case UNLOCK:
				case MSCK:
				case REPAIR:
				case RECOVER:
				case EXPORT:
				case IMPORT:
				case LOAD:
				case ROLE:
				case ROLES:
				case COMPACTIONS:
				case PRINCIPALS:
				case TRANSACTIONS:
				case INDEX:
				case INDEXES:
				case LOCKS:
				case OPTION:
				case ANTI:
				case LOCAL:
				case INPATH:
				case CURRENT_DATE:
				case CURRENT_TIMESTAMP:
				case IDENTIFIER:
				case BACKQUOTED_IDENTIFIER:
					{
					setState(1142);
					identifier();
					}
					break;
				case STRING:
					{
					setState(1143);
					match(STRING);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(1150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtesContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public List<NamedQueryContext> namedQuery() {
			return getRuleContexts(NamedQueryContext.class);
		}
		public NamedQueryContext namedQuery(int i) {
			return getRuleContext(NamedQueryContext.class,i);
		}
		public CtesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctes; }
	}

	public final CtesContext ctes() throws RecognitionException {
		CtesContext _localctx = new CtesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ctes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1151);
			match(WITH);
			setState(1152);
			namedQuery();
			setState(1157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1153);
				match(T__2);
				setState(1154);
				namedQuery();
				}
				}
				setState(1159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedQueryContext extends ParserRuleContext {
		public IdentifierContext name;
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public NamedQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedQuery; }
	}

	public final NamedQueryContext namedQuery() throws RecognitionException {
		NamedQueryContext _localctx = new NamedQueryContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_namedQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1160);
			((NamedQueryContext)_localctx).name = identifier();
			setState(1162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(1161);
				match(AS);
				}
			}

			setState(1164);
			match(T__0);
			setState(1165);
			query();
			setState(1166);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableProviderContext extends ParserRuleContext {
		public TerminalNode USING() { return getToken(SqlBaseParser.USING, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TableProviderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableProvider; }
	}

	public final TableProviderContext tableProvider() throws RecognitionException {
		TableProviderContext _localctx = new TableProviderContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_tableProvider);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1168);
			match(USING);
			setState(1169);
			qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyListContext extends ParserRuleContext {
		public List<TablePropertyContext> tableProperty() {
			return getRuleContexts(TablePropertyContext.class);
		}
		public TablePropertyContext tableProperty(int i) {
			return getRuleContext(TablePropertyContext.class,i);
		}
		public TablePropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePropertyList; }
	}

	public final TablePropertyListContext tablePropertyList() throws RecognitionException {
		TablePropertyListContext _localctx = new TablePropertyListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_tablePropertyList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1171);
			match(T__0);
			setState(1172);
			tableProperty();
			setState(1177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1173);
				match(T__2);
				setState(1174);
				tableProperty();
				}
				}
				setState(1179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1180);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyContext extends ParserRuleContext {
		public TablePropertyKeyContext key;
		public TablePropertyValueContext value;
		public TablePropertyKeyContext tablePropertyKey() {
			return getRuleContext(TablePropertyKeyContext.class,0);
		}
		public TablePropertyValueContext tablePropertyValue() {
			return getRuleContext(TablePropertyValueContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SqlBaseParser.EQ, 0); }
		public TablePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableProperty; }
	}

	public final TablePropertyContext tableProperty() throws RecognitionException {
		TablePropertyContext _localctx = new TablePropertyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_tableProperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1182);
			((TablePropertyContext)_localctx).key = tablePropertyKey();
			setState(1187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || _la==EQ || ((((_la - 245)) & ~0x3f) == 0 && ((1L << (_la - 245)) & ((1L << (STRING - 245)) | (1L << (INTEGER_VALUE - 245)) | (1L << (DECIMAL_VALUE - 245)))) != 0)) {
				{
				setState(1184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQ) {
					{
					setState(1183);
					match(EQ);
					}
				}

				setState(1186);
				((TablePropertyContext)_localctx).value = tablePropertyValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyKeyContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TablePropertyKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePropertyKey; }
	}

	public final TablePropertyKeyContext tablePropertyKey() throws RecognitionException {
		TablePropertyKeyContext _localctx = new TablePropertyKeyContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_tablePropertyKey);
		int _la;
		try {
			setState(1198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
			case FROM:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case JOIN:
			case CROSS:
			case OUTER:
			case INNER:
			case LEFT:
			case SEMI:
			case RIGHT:
			case FULL:
			case NATURAL:
			case ON:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case UNION:
			case EXCEPT:
			case SETMINUS:
			case INTERSECT:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case IF:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case USING:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case ANTI:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
			case IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1189);
				identifier();
				setState(1194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(1190);
					match(T__3);
					setState(1191);
					identifier();
					}
					}
					setState(1196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1197);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyValueContext extends ParserRuleContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlBaseParser.DECIMAL_VALUE, 0); }
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TablePropertyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePropertyValue; }
	}

	public final TablePropertyValueContext tablePropertyValue() throws RecognitionException {
		TablePropertyValueContext _localctx = new TablePropertyValueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_tablePropertyValue);
		try {
			setState(1204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1200);
				match(INTEGER_VALUE);
				}
				break;
			case DECIMAL_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1201);
				match(DECIMAL_VALUE);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1202);
				booleanValue();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(1203);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantListContext extends ParserRuleContext {
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public ConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantList; }
	}

	public final ConstantListContext constantList() throws RecognitionException {
		ConstantListContext _localctx = new ConstantListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_constantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1206);
			match(T__0);
			setState(1207);
			constant();
			setState(1212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1208);
				match(T__2);
				setState(1209);
				constant();
				}
				}
				setState(1214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1215);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NestedConstantListContext extends ParserRuleContext {
		public List<ConstantListContext> constantList() {
			return getRuleContexts(ConstantListContext.class);
		}
		public ConstantListContext constantList(int i) {
			return getRuleContext(ConstantListContext.class,i);
		}
		public NestedConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedConstantList; }
	}

	public final NestedConstantListContext nestedConstantList() throws RecognitionException {
		NestedConstantListContext _localctx = new NestedConstantListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_nestedConstantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1217);
			match(T__0);
			setState(1218);
			constantList();
			setState(1223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1219);
				match(T__2);
				setState(1220);
				constantList();
				}
				}
				setState(1225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1226);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateFileFormatContext extends ParserRuleContext {
		public TerminalNode STORED() { return getToken(SqlBaseParser.STORED, 0); }
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public FileFormatContext fileFormat() {
			return getRuleContext(FileFormatContext.class,0);
		}
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public StorageHandlerContext storageHandler() {
			return getRuleContext(StorageHandlerContext.class,0);
		}
		public CreateFileFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createFileFormat; }
	}

	public final CreateFileFormatContext createFileFormat() throws RecognitionException {
		CreateFileFormatContext _localctx = new CreateFileFormatContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_createFileFormat);
		try {
			setState(1234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1228);
				match(STORED);
				setState(1229);
				match(AS);
				setState(1230);
				fileFormat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1231);
				match(STORED);
				setState(1232);
				match(BY);
				setState(1233);
				storageHandler();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FileFormatContext extends ParserRuleContext {
		public FileFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileFormat; }
	 
		public FileFormatContext() { }
		public void copyFrom(FileFormatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TableFileFormatContext extends FileFormatContext {
		public Token inFmt;
		public Token outFmt;
		public TerminalNode INPUTFORMAT() { return getToken(SqlBaseParser.INPUTFORMAT, 0); }
		public TerminalNode OUTPUTFORMAT() { return getToken(SqlBaseParser.OUTPUTFORMAT, 0); }
		public List<TerminalNode> STRING() { return getTokens(SqlBaseParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SqlBaseParser.STRING, i);
		}
		public TableFileFormatContext(FileFormatContext ctx) { copyFrom(ctx); }
	}
	public static class GenericFileFormatContext extends FileFormatContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public GenericFileFormatContext(FileFormatContext ctx) { copyFrom(ctx); }
	}

	public final FileFormatContext fileFormat() throws RecognitionException {
		FileFormatContext _localctx = new FileFormatContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_fileFormat);
		try {
			setState(1241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				_localctx = new TableFileFormatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1236);
				match(INPUTFORMAT);
				setState(1237);
				((TableFileFormatContext)_localctx).inFmt = match(STRING);
				setState(1238);
				match(OUTPUTFORMAT);
				setState(1239);
				((TableFileFormatContext)_localctx).outFmt = match(STRING);
				}
				break;
			case 2:
				_localctx = new GenericFileFormatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1240);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StorageHandlerContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(SqlBaseParser.SERDEPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public StorageHandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageHandler; }
	}

	public final StorageHandlerContext storageHandler() throws RecognitionException {
		StorageHandlerContext _localctx = new StorageHandlerContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_storageHandler);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1243);
			match(STRING);
			setState(1247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				{
				setState(1244);
				match(WITH);
				setState(1245);
				match(SERDEPROPERTIES);
				setState(1246);
				tablePropertyList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_resource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1249);
			identifier();
			setState(1250);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryNoWithContext extends ParserRuleContext {
		public QueryNoWithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryNoWith; }
	 
		public QueryNoWithContext() { }
		public void copyFrom(QueryNoWithContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleInsertQueryContext extends QueryNoWithContext {
		public QueryTermContext queryTerm() {
			return getRuleContext(QueryTermContext.class,0);
		}
		public QueryOrganizationContext queryOrganization() {
			return getRuleContext(QueryOrganizationContext.class,0);
		}
		public InsertIntoContext insertInto() {
			return getRuleContext(InsertIntoContext.class,0);
		}
		public SingleInsertQueryContext(QueryNoWithContext ctx) { copyFrom(ctx); }
	}
	public static class MultiInsertQueryContext extends QueryNoWithContext {
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public List<MultiInsertQueryBodyContext> multiInsertQueryBody() {
			return getRuleContexts(MultiInsertQueryBodyContext.class);
		}
		public MultiInsertQueryBodyContext multiInsertQueryBody(int i) {
			return getRuleContext(MultiInsertQueryBodyContext.class,i);
		}
		public MultiInsertQueryContext(QueryNoWithContext ctx) { copyFrom(ctx); }
	}

	public final QueryNoWithContext queryNoWith() throws RecognitionException {
		QueryNoWithContext _localctx = new QueryNoWithContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_queryNoWith);
		int _la;
		try {
			setState(1264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
			case 1:
				_localctx = new SingleInsertQueryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INSERT) {
					{
					setState(1252);
					insertInto();
					}
				}

				setState(1255);
				queryTerm(0);
				setState(1256);
				queryOrganization();
				}
				break;
			case 2:
				_localctx = new MultiInsertQueryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1258);
				fromClause();
				setState(1260); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1259);
					multiInsertQueryBody();
					}
					}
					setState(1262); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SELECT || _la==FROM || _la==INSERT || _la==MAP || _la==REDUCE );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryOrganizationContext extends ParserRuleContext {
		public SortItemContext sortItem;
		public List<SortItemContext> order = new ArrayList<SortItemContext>();
		public ExpressionContext expression;
		public List<ExpressionContext> clusterBy = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> distributeBy = new ArrayList<ExpressionContext>();
		public List<SortItemContext> sort = new ArrayList<SortItemContext>();
		public ExpressionContext limit;
		public TerminalNode ORDER() { return getToken(SqlBaseParser.ORDER, 0); }
		public List<TerminalNode> BY() { return getTokens(SqlBaseParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SqlBaseParser.BY, i);
		}
		public TerminalNode CLUSTER() { return getToken(SqlBaseParser.CLUSTER, 0); }
		public TerminalNode DISTRIBUTE() { return getToken(SqlBaseParser.DISTRIBUTE, 0); }
		public TerminalNode SORT() { return getToken(SqlBaseParser.SORT, 0); }
		public WindowsContext windows() {
			return getRuleContext(WindowsContext.class,0);
		}
		public TerminalNode LIMIT() { return getToken(SqlBaseParser.LIMIT, 0); }
		public List<SortItemContext> sortItem() {
			return getRuleContexts(SortItemContext.class);
		}
		public SortItemContext sortItem(int i) {
			return getRuleContext(SortItemContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public QueryOrganizationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryOrganization; }
	}

	public final QueryOrganizationContext queryOrganization() throws RecognitionException {
		QueryOrganizationContext _localctx = new QueryOrganizationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_queryOrganization);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(1266);
				match(ORDER);
				setState(1267);
				match(BY);
				setState(1268);
				((QueryOrganizationContext)_localctx).sortItem = sortItem();
				((QueryOrganizationContext)_localctx).order.add(((QueryOrganizationContext)_localctx).sortItem);
				setState(1273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1269);
					match(T__2);
					setState(1270);
					((QueryOrganizationContext)_localctx).sortItem = sortItem();
					((QueryOrganizationContext)_localctx).order.add(((QueryOrganizationContext)_localctx).sortItem);
					}
					}
					setState(1275);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLUSTER) {
				{
				setState(1278);
				match(CLUSTER);
				setState(1279);
				match(BY);
				setState(1280);
				((QueryOrganizationContext)_localctx).expression = expression();
				((QueryOrganizationContext)_localctx).clusterBy.add(((QueryOrganizationContext)_localctx).expression);
				setState(1285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1281);
					match(T__2);
					setState(1282);
					((QueryOrganizationContext)_localctx).expression = expression();
					((QueryOrganizationContext)_localctx).clusterBy.add(((QueryOrganizationContext)_localctx).expression);
					}
					}
					setState(1287);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DISTRIBUTE) {
				{
				setState(1290);
				match(DISTRIBUTE);
				setState(1291);
				match(BY);
				setState(1292);
				((QueryOrganizationContext)_localctx).expression = expression();
				((QueryOrganizationContext)_localctx).distributeBy.add(((QueryOrganizationContext)_localctx).expression);
				setState(1297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1293);
					match(T__2);
					setState(1294);
					((QueryOrganizationContext)_localctx).expression = expression();
					((QueryOrganizationContext)_localctx).distributeBy.add(((QueryOrganizationContext)_localctx).expression);
					}
					}
					setState(1299);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SORT) {
				{
				setState(1302);
				match(SORT);
				setState(1303);
				match(BY);
				setState(1304);
				((QueryOrganizationContext)_localctx).sortItem = sortItem();
				((QueryOrganizationContext)_localctx).sort.add(((QueryOrganizationContext)_localctx).sortItem);
				setState(1309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1305);
					match(T__2);
					setState(1306);
					((QueryOrganizationContext)_localctx).sortItem = sortItem();
					((QueryOrganizationContext)_localctx).sort.add(((QueryOrganizationContext)_localctx).sortItem);
					}
					}
					setState(1311);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WINDOW) {
				{
				setState(1314);
				windows();
				}
			}

			setState(1319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(1317);
				match(LIMIT);
				setState(1318);
				((QueryOrganizationContext)_localctx).limit = expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiInsertQueryBodyContext extends ParserRuleContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public QueryOrganizationContext queryOrganization() {
			return getRuleContext(QueryOrganizationContext.class,0);
		}
		public InsertIntoContext insertInto() {
			return getRuleContext(InsertIntoContext.class,0);
		}
		public MultiInsertQueryBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiInsertQueryBody; }
	}

	public final MultiInsertQueryBodyContext multiInsertQueryBody() throws RecognitionException {
		MultiInsertQueryBodyContext _localctx = new MultiInsertQueryBodyContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_multiInsertQueryBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INSERT) {
				{
				setState(1321);
				insertInto();
				}
			}

			setState(1324);
			querySpecification();
			setState(1325);
			queryOrganization();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryTermContext extends ParserRuleContext {
		public QueryTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryTerm; }
	 
		public QueryTermContext() { }
		public void copyFrom(QueryTermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QueryTermDefaultContext extends QueryTermContext {
		public QueryPrimaryContext queryPrimary() {
			return getRuleContext(QueryPrimaryContext.class,0);
		}
		public QueryTermDefaultContext(QueryTermContext ctx) { copyFrom(ctx); }
	}
	public static class SetOperationContext extends QueryTermContext {
		public QueryTermContext left;
		public Token operator;
		public QueryTermContext right;
		public List<QueryTermContext> queryTerm() {
			return getRuleContexts(QueryTermContext.class);
		}
		public QueryTermContext queryTerm(int i) {
			return getRuleContext(QueryTermContext.class,i);
		}
		public TerminalNode INTERSECT() { return getToken(SqlBaseParser.INTERSECT, 0); }
		public TerminalNode UNION() { return getToken(SqlBaseParser.UNION, 0); }
		public TerminalNode EXCEPT() { return getToken(SqlBaseParser.EXCEPT, 0); }
		public TerminalNode SETMINUS() { return getToken(SqlBaseParser.SETMINUS, 0); }
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public SetOperationContext(QueryTermContext ctx) { copyFrom(ctx); }
	}

	public final QueryTermContext queryTerm() throws RecognitionException {
		return queryTerm(0);
	}

	private QueryTermContext queryTerm(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		QueryTermContext _localctx = new QueryTermContext(_ctx, _parentState);
		QueryTermContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_queryTerm, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new QueryTermDefaultContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(1328);
			queryPrimary();
			}
			_ctx.stop = _input.LT(-1);
			setState(1338);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,155,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SetOperationContext(new QueryTermContext(_parentctx, _parentState));
					((SetOperationContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_queryTerm);
					setState(1330);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1331);
					((SetOperationContext)_localctx).operator = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (UNION - 98)) | (1L << (EXCEPT - 98)) | (1L << (SETMINUS - 98)) | (1L << (INTERSECT - 98)))) != 0)) ) {
						((SetOperationContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1333);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL || _la==DISTINCT) {
						{
						setState(1332);
						setQuantifier();
						}
					}

					setState(1335);
					((SetOperationContext)_localctx).right = queryTerm(2);
					}
					} 
				}
				setState(1340);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,155,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class QueryPrimaryContext extends ParserRuleContext {
		public QueryPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryPrimary; }
	 
		public QueryPrimaryContext() { }
		public void copyFrom(QueryPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubqueryContext extends QueryPrimaryContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public SubqueryContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
	}
	public static class QueryPrimaryDefaultContext extends QueryPrimaryContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public QueryPrimaryDefaultContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
	}
	public static class InlineTableDefault1Context extends QueryPrimaryContext {
		public InlineTableContext inlineTable() {
			return getRuleContext(InlineTableContext.class,0);
		}
		public InlineTableDefault1Context(QueryPrimaryContext ctx) { copyFrom(ctx); }
	}
	public static class TableContext extends QueryPrimaryContext {
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TableContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
	}

	public final QueryPrimaryContext queryPrimary() throws RecognitionException {
		QueryPrimaryContext _localctx = new QueryPrimaryContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_queryPrimary);
		try {
			setState(1349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
			case FROM:
			case MAP:
			case REDUCE:
				_localctx = new QueryPrimaryDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1341);
				querySpecification();
				}
				break;
			case TABLE:
				_localctx = new TableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1342);
				match(TABLE);
				setState(1343);
				tableIdentifier();
				}
				break;
			case VALUES:
				_localctx = new InlineTableDefault1Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1344);
				inlineTable();
				}
				break;
			case T__0:
				_localctx = new SubqueryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1345);
				match(T__0);
				setState(1346);
				queryNoWith();
				setState(1347);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SortItemContext extends ParserRuleContext {
		public Token ordering;
		public Token nullOrder;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NULLS() { return getToken(SqlBaseParser.NULLS, 0); }
		public TerminalNode ASC() { return getToken(SqlBaseParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SqlBaseParser.DESC, 0); }
		public TerminalNode LAST() { return getToken(SqlBaseParser.LAST, 0); }
		public TerminalNode FIRST() { return getToken(SqlBaseParser.FIRST, 0); }
		public SortItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortItem; }
	}

	public final SortItemContext sortItem() throws RecognitionException {
		SortItemContext _localctx = new SortItemContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_sortItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1351);
			expression();
			setState(1353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(1352);
				((SortItemContext)_localctx).ordering = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((SortItemContext)_localctx).ordering = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(1357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULLS) {
				{
				setState(1355);
				match(NULLS);
				setState(1356);
				((SortItemContext)_localctx).nullOrder = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==FIRST || _la==LAST) ) {
					((SortItemContext)_localctx).nullOrder = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuerySpecificationContext extends ParserRuleContext {
		public Token kind;
		public RowFormatContext inRowFormat;
		public Token recordWriter;
		public Token script;
		public RowFormatContext outRowFormat;
		public Token recordReader;
		public BooleanExpressionContext where;
		public HintContext hint;
		public List<HintContext> hints = new ArrayList<HintContext>();
		public BooleanExpressionContext having;
		public TerminalNode USING() { return getToken(SqlBaseParser.USING, 0); }
		public List<TerminalNode> STRING() { return getTokens(SqlBaseParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SqlBaseParser.STRING, i);
		}
		public TerminalNode RECORDWRITER() { return getToken(SqlBaseParser.RECORDWRITER, 0); }
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public TerminalNode RECORDREADER() { return getToken(SqlBaseParser.RECORDREADER, 0); }
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SqlBaseParser.WHERE, 0); }
		public TerminalNode SELECT() { return getToken(SqlBaseParser.SELECT, 0); }
		public NamedExpressionSeqContext namedExpressionSeq() {
			return getRuleContext(NamedExpressionSeqContext.class,0);
		}
		public List<RowFormatContext> rowFormat() {
			return getRuleContexts(RowFormatContext.class);
		}
		public RowFormatContext rowFormat(int i) {
			return getRuleContext(RowFormatContext.class,i);
		}
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public TerminalNode TRANSFORM() { return getToken(SqlBaseParser.TRANSFORM, 0); }
		public TerminalNode MAP() { return getToken(SqlBaseParser.MAP, 0); }
		public TerminalNode REDUCE() { return getToken(SqlBaseParser.REDUCE, 0); }
		public IdentifierSeqContext identifierSeq() {
			return getRuleContext(IdentifierSeqContext.class,0);
		}
		public ColTypeListContext colTypeList() {
			return getRuleContext(ColTypeListContext.class,0);
		}
		public List<LateralViewContext> lateralView() {
			return getRuleContexts(LateralViewContext.class);
		}
		public LateralViewContext lateralView(int i) {
			return getRuleContext(LateralViewContext.class,i);
		}
		public AggregationContext aggregation() {
			return getRuleContext(AggregationContext.class,0);
		}
		public TerminalNode HAVING() { return getToken(SqlBaseParser.HAVING, 0); }
		public WindowsContext windows() {
			return getRuleContext(WindowsContext.class,0);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public List<HintContext> hint() {
			return getRuleContexts(HintContext.class);
		}
		public HintContext hint(int i) {
			return getRuleContext(HintContext.class,i);
		}
		public QuerySpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecification; }
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_querySpecification);
		int _la;
		try {
			int _alt;
			setState(1452);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				{
				setState(1369);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT:
					{
					setState(1359);
					match(SELECT);
					setState(1360);
					((QuerySpecificationContext)_localctx).kind = match(TRANSFORM);
					setState(1361);
					match(T__0);
					setState(1362);
					namedExpressionSeq();
					setState(1363);
					match(T__1);
					}
					break;
				case MAP:
					{
					setState(1365);
					((QuerySpecificationContext)_localctx).kind = match(MAP);
					setState(1366);
					namedExpressionSeq();
					}
					break;
				case REDUCE:
					{
					setState(1367);
					((QuerySpecificationContext)_localctx).kind = match(REDUCE);
					setState(1368);
					namedExpressionSeq();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1372);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROW) {
					{
					setState(1371);
					((QuerySpecificationContext)_localctx).inRowFormat = rowFormat();
					}
				}

				setState(1376);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RECORDWRITER) {
					{
					setState(1374);
					match(RECORDWRITER);
					setState(1375);
					((QuerySpecificationContext)_localctx).recordWriter = match(STRING);
					}
				}

				setState(1378);
				match(USING);
				setState(1379);
				((QuerySpecificationContext)_localctx).script = match(STRING);
				setState(1392);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
				case 1:
					{
					setState(1380);
					match(AS);
					setState(1390);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,163,_ctx) ) {
					case 1:
						{
						setState(1381);
						identifierSeq();
						}
						break;
					case 2:
						{
						setState(1382);
						colTypeList();
						}
						break;
					case 3:
						{
						{
						setState(1383);
						match(T__0);
						setState(1386);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
						case 1:
							{
							setState(1384);
							identifierSeq();
							}
							break;
						case 2:
							{
							setState(1385);
							colTypeList();
							}
							break;
						}
						setState(1388);
						match(T__1);
						}
						}
						break;
					}
					}
					break;
				}
				setState(1395);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
				case 1:
					{
					setState(1394);
					((QuerySpecificationContext)_localctx).outRowFormat = rowFormat();
					}
					break;
				}
				setState(1399);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
				case 1:
					{
					setState(1397);
					match(RECORDREADER);
					setState(1398);
					((QuerySpecificationContext)_localctx).recordReader = match(STRING);
					}
					break;
				}
				setState(1402);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
				case 1:
					{
					setState(1401);
					fromClause();
					}
					break;
				}
				setState(1406);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
				case 1:
					{
					setState(1404);
					match(WHERE);
					setState(1405);
					((QuerySpecificationContext)_localctx).where = booleanExpression(0);
					}
					break;
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1430);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT:
					{
					setState(1408);
					((QuerySpecificationContext)_localctx).kind = match(SELECT);
					setState(1412);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(1409);
						((QuerySpecificationContext)_localctx).hint = hint();
						((QuerySpecificationContext)_localctx).hints.add(((QuerySpecificationContext)_localctx).hint);
						}
						}
						setState(1414);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1416);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
					case 1:
						{
						setState(1415);
						setQuantifier();
						}
						break;
					}
					setState(1418);
					namedExpressionSeq();
					setState(1420);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
					case 1:
						{
						setState(1419);
						fromClause();
						}
						break;
					}
					}
					break;
				case FROM:
					{
					setState(1422);
					fromClause();
					setState(1428);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
					case 1:
						{
						setState(1423);
						((QuerySpecificationContext)_localctx).kind = match(SELECT);
						setState(1425);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
						case 1:
							{
							setState(1424);
							setQuantifier();
							}
							break;
						}
						setState(1427);
						namedExpressionSeq();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1435);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1432);
						lateralView();
						}
						} 
					}
					setState(1437);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
				}
				setState(1440);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,176,_ctx) ) {
				case 1:
					{
					setState(1438);
					match(WHERE);
					setState(1439);
					((QuerySpecificationContext)_localctx).where = booleanExpression(0);
					}
					break;
				}
				setState(1443);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
				case 1:
					{
					setState(1442);
					aggregation();
					}
					break;
				}
				setState(1447);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
				case 1:
					{
					setState(1445);
					match(HAVING);
					setState(1446);
					((QuerySpecificationContext)_localctx).having = booleanExpression(0);
					}
					break;
				}
				setState(1450);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
				case 1:
					{
					setState(1449);
					windows();
					}
					break;
				}
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HintContext extends ParserRuleContext {
		public HintStatementContext hintStatement;
		public List<HintStatementContext> hintStatements = new ArrayList<HintStatementContext>();
		public List<HintStatementContext> hintStatement() {
			return getRuleContexts(HintStatementContext.class);
		}
		public HintStatementContext hintStatement(int i) {
			return getRuleContext(HintStatementContext.class,i);
		}
		public HintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hint; }
	}

	public final HintContext hint() throws RecognitionException {
		HintContext _localctx = new HintContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_hint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1454);
			match(T__4);
			setState(1455);
			((HintContext)_localctx).hintStatement = hintStatement();
			((HintContext)_localctx).hintStatements.add(((HintContext)_localctx).hintStatement);
			setState(1462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL) | (1L << ON) | (1L << LATERAL) | (1L << WINDOW) | (1L << OVER) | (1L << PARTITION))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (DIV - 134)) | (1L << (PERCENTLIT - 134)) | (1L << (BUCKET - 134)) | (1L << (OUT - 134)) | (1L << (OF - 134)) | (1L << (SORT - 134)) | (1L << (CLUSTER - 134)) | (1L << (DISTRIBUTE - 134)) | (1L << (OVERWRITE - 134)) | (1L << (TRANSFORM - 134)) | (1L << (REDUCE - 134)) | (1L << (USING - 134)) | (1L << (SERDE - 134)) | (1L << (SERDEPROPERTIES - 134)) | (1L << (RECORDREADER - 134)) | (1L << (RECORDWRITER - 134)) | (1L << (DELIMITED - 134)) | (1L << (FIELDS - 134)) | (1L << (TERMINATED - 134)) | (1L << (COLLECTION - 134)) | (1L << (ITEMS - 134)) | (1L << (KEYS - 134)) | (1L << (ESCAPED - 134)) | (1L << (LINES - 134)) | (1L << (SEPARATED - 134)) | (1L << (FUNCTION - 134)) | (1L << (EXTENDED - 134)) | (1L << (REFRESH - 134)) | (1L << (CLEAR - 134)) | (1L << (CACHE - 134)) | (1L << (UNCACHE - 134)) | (1L << (LAZY - 134)) | (1L << (FORMATTED - 134)) | (1L << (GLOBAL - 134)) | (1L << (TEMPORARY - 134)) | (1L << (OPTIONS - 134)) | (1L << (UNSET - 134)) | (1L << (TBLPROPERTIES - 134)) | (1L << (DBPROPERTIES - 134)) | (1L << (BUCKETS - 134)) | (1L << (SKEWED - 134)) | (1L << (STORED - 134)) | (1L << (DIRECTORIES - 134)) | (1L << (LOCATION - 134)) | (1L << (EXCHANGE - 134)) | (1L << (ARCHIVE - 134)) | (1L << (UNARCHIVE - 134)) | (1L << (FILEFORMAT - 134)) | (1L << (TOUCH - 134)) | (1L << (COMPACT - 134)) | (1L << (CONCATENATE - 134)) | (1L << (CHANGE - 134)) | (1L << (CASCADE - 134)) | (1L << (RESTRICT - 134)) | (1L << (CLUSTERED - 134)) | (1L << (SORTED - 134)) | (1L << (PURGE - 134)) | (1L << (INPUTFORMAT - 134)) | (1L << (OUTPUTFORMAT - 134)) | (1L << (DATABASE - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (DATABASES - 198)) | (1L << (DFS - 198)) | (1L << (TRUNCATE - 198)) | (1L << (ANALYZE - 198)) | (1L << (COMPUTE - 198)) | (1L << (LIST - 198)) | (1L << (STATISTICS - 198)) | (1L << (PARTITIONED - 198)) | (1L << (EXTERNAL - 198)) | (1L << (DEFINED - 198)) | (1L << (REVOKE - 198)) | (1L << (GRANT - 198)) | (1L << (LOCK - 198)) | (1L << (UNLOCK - 198)) | (1L << (MSCK - 198)) | (1L << (REPAIR - 198)) | (1L << (RECOVER - 198)) | (1L << (EXPORT - 198)) | (1L << (IMPORT - 198)) | (1L << (LOAD - 198)) | (1L << (ROLE - 198)) | (1L << (ROLES - 198)) | (1L << (COMPACTIONS - 198)) | (1L << (PRINCIPALS - 198)) | (1L << (TRANSACTIONS - 198)) | (1L << (INDEX - 198)) | (1L << (INDEXES - 198)) | (1L << (LOCKS - 198)) | (1L << (OPTION - 198)) | (1L << (ANTI - 198)) | (1L << (LOCAL - 198)) | (1L << (INPATH - 198)) | (1L << (CURRENT_DATE - 198)) | (1L << (CURRENT_TIMESTAMP - 198)) | (1L << (IDENTIFIER - 198)) | (1L << (BACKQUOTED_IDENTIFIER - 198)))) != 0)) {
				{
				{
				setState(1457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(1456);
					match(T__2);
					}
				}

				setState(1459);
				((HintContext)_localctx).hintStatement = hintStatement();
				((HintContext)_localctx).hintStatements.add(((HintContext)_localctx).hintStatement);
				}
				}
				setState(1464);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1465);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HintStatementContext extends ParserRuleContext {
		public IdentifierContext hintName;
		public PrimaryExpressionContext primaryExpression;
		public List<PrimaryExpressionContext> parameters = new ArrayList<PrimaryExpressionContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public HintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hintStatement; }
	}

	public final HintStatementContext hintStatement() throws RecognitionException {
		HintStatementContext _localctx = new HintStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_hintStatement);
		int _la;
		try {
			setState(1480);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1467);
				((HintStatementContext)_localctx).hintName = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1468);
				((HintStatementContext)_localctx).hintName = identifier();
				setState(1469);
				match(T__0);
				setState(1470);
				((HintStatementContext)_localctx).primaryExpression = primaryExpression(0);
				((HintStatementContext)_localctx).parameters.add(((HintStatementContext)_localctx).primaryExpression);
				setState(1475);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1471);
					match(T__2);
					setState(1472);
					((HintStatementContext)_localctx).primaryExpression = primaryExpression(0);
					((HintStatementContext)_localctx).parameters.add(((HintStatementContext)_localctx).primaryExpression);
					}
					}
					setState(1477);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1478);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromClauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public List<LateralViewContext> lateralView() {
			return getRuleContexts(LateralViewContext.class);
		}
		public LateralViewContext lateralView(int i) {
			return getRuleContext(LateralViewContext.class,i);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_fromClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1482);
			match(FROM);
			setState(1483);
			relation();
			setState(1488);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1484);
					match(T__2);
					setState(1485);
					relation();
					}
					} 
				}
				setState(1490);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
			}
			setState(1494);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1491);
					lateralView();
					}
					} 
				}
				setState(1496);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregationContext extends ParserRuleContext {
		public ExpressionContext expression;
		public List<ExpressionContext> groupingExpressions = new ArrayList<ExpressionContext>();
		public Token kind;
		public TerminalNode GROUP() { return getToken(SqlBaseParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public TerminalNode SETS() { return getToken(SqlBaseParser.SETS, 0); }
		public List<GroupingSetContext> groupingSet() {
			return getRuleContexts(GroupingSetContext.class);
		}
		public GroupingSetContext groupingSet(int i) {
			return getRuleContext(GroupingSetContext.class,i);
		}
		public TerminalNode ROLLUP() { return getToken(SqlBaseParser.ROLLUP, 0); }
		public TerminalNode CUBE() { return getToken(SqlBaseParser.CUBE, 0); }
		public TerminalNode GROUPING() { return getToken(SqlBaseParser.GROUPING, 0); }
		public AggregationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregation; }
	}

	public final AggregationContext aggregation() throws RecognitionException {
		AggregationContext _localctx = new AggregationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_aggregation);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1497);
			match(GROUP);
			setState(1498);
			match(BY);
			setState(1499);
			((AggregationContext)_localctx).expression = expression();
			((AggregationContext)_localctx).groupingExpressions.add(((AggregationContext)_localctx).expression);
			setState(1504);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1500);
					match(T__2);
					setState(1501);
					((AggregationContext)_localctx).expression = expression();
					((AggregationContext)_localctx).groupingExpressions.add(((AggregationContext)_localctx).expression);
					}
					} 
				}
				setState(1506);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
			}
			setState(1524);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				{
				setState(1507);
				match(WITH);
				setState(1508);
				((AggregationContext)_localctx).kind = match(ROLLUP);
				}
				break;
			case 2:
				{
				setState(1509);
				match(WITH);
				setState(1510);
				((AggregationContext)_localctx).kind = match(CUBE);
				}
				break;
			case 3:
				{
				setState(1511);
				((AggregationContext)_localctx).kind = match(GROUPING);
				setState(1512);
				match(SETS);
				setState(1513);
				match(T__0);
				setState(1514);
				groupingSet();
				setState(1519);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1515);
					match(T__2);
					setState(1516);
					groupingSet();
					}
					}
					setState(1521);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1522);
				match(T__1);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupingSetContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GroupingSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingSet; }
	}

	public final GroupingSetContext groupingSet() throws RecognitionException {
		GroupingSetContext _localctx = new GroupingSetContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_groupingSet);
		int _la;
		try {
			setState(1539);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1526);
				match(T__0);
				setState(1535);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL) | (1L << ON) | (1L << LATERAL) | (1L << WINDOW) | (1L << OVER) | (1L << PARTITION))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (PLUS - 129)) | (1L << (MINUS - 129)) | (1L << (ASTERISK - 129)) | (1L << (DIV - 129)) | (1L << (TILDE - 129)) | (1L << (PERCENTLIT - 129)) | (1L << (BUCKET - 129)) | (1L << (OUT - 129)) | (1L << (OF - 129)) | (1L << (SORT - 129)) | (1L << (CLUSTER - 129)) | (1L << (DISTRIBUTE - 129)) | (1L << (OVERWRITE - 129)) | (1L << (TRANSFORM - 129)) | (1L << (REDUCE - 129)) | (1L << (USING - 129)) | (1L << (SERDE - 129)) | (1L << (SERDEPROPERTIES - 129)) | (1L << (RECORDREADER - 129)) | (1L << (RECORDWRITER - 129)) | (1L << (DELIMITED - 129)) | (1L << (FIELDS - 129)) | (1L << (TERMINATED - 129)) | (1L << (COLLECTION - 129)) | (1L << (ITEMS - 129)) | (1L << (KEYS - 129)) | (1L << (ESCAPED - 129)) | (1L << (LINES - 129)) | (1L << (SEPARATED - 129)) | (1L << (FUNCTION - 129)) | (1L << (EXTENDED - 129)) | (1L << (REFRESH - 129)) | (1L << (CLEAR - 129)) | (1L << (CACHE - 129)) | (1L << (UNCACHE - 129)) | (1L << (LAZY - 129)) | (1L << (FORMATTED - 129)) | (1L << (GLOBAL - 129)) | (1L << (TEMPORARY - 129)) | (1L << (OPTIONS - 129)) | (1L << (UNSET - 129)) | (1L << (TBLPROPERTIES - 129)) | (1L << (DBPROPERTIES - 129)) | (1L << (BUCKETS - 129)) | (1L << (SKEWED - 129)) | (1L << (STORED - 129)) | (1L << (DIRECTORIES - 129)) | (1L << (LOCATION - 129)) | (1L << (EXCHANGE - 129)) | (1L << (ARCHIVE - 129)) | (1L << (UNARCHIVE - 129)) | (1L << (FILEFORMAT - 129)) | (1L << (TOUCH - 129)) | (1L << (COMPACT - 129)) | (1L << (CONCATENATE - 129)) | (1L << (CHANGE - 129)) | (1L << (CASCADE - 129)) | (1L << (RESTRICT - 129)) | (1L << (CLUSTERED - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (SORTED - 193)) | (1L << (PURGE - 193)) | (1L << (INPUTFORMAT - 193)) | (1L << (OUTPUTFORMAT - 193)) | (1L << (DATABASE - 193)) | (1L << (DATABASES - 193)) | (1L << (DFS - 193)) | (1L << (TRUNCATE - 193)) | (1L << (ANALYZE - 193)) | (1L << (COMPUTE - 193)) | (1L << (LIST - 193)) | (1L << (STATISTICS - 193)) | (1L << (PARTITIONED - 193)) | (1L << (EXTERNAL - 193)) | (1L << (DEFINED - 193)) | (1L << (REVOKE - 193)) | (1L << (GRANT - 193)) | (1L << (LOCK - 193)) | (1L << (UNLOCK - 193)) | (1L << (MSCK - 193)) | (1L << (REPAIR - 193)) | (1L << (RECOVER - 193)) | (1L << (EXPORT - 193)) | (1L << (IMPORT - 193)) | (1L << (LOAD - 193)) | (1L << (ROLE - 193)) | (1L << (ROLES - 193)) | (1L << (COMPACTIONS - 193)) | (1L << (PRINCIPALS - 193)) | (1L << (TRANSACTIONS - 193)) | (1L << (INDEX - 193)) | (1L << (INDEXES - 193)) | (1L << (LOCKS - 193)) | (1L << (OPTION - 193)) | (1L << (ANTI - 193)) | (1L << (LOCAL - 193)) | (1L << (INPATH - 193)) | (1L << (CURRENT_DATE - 193)) | (1L << (CURRENT_TIMESTAMP - 193)) | (1L << (EUCLID - 193)) | (1L << (DTW - 193)) | (1L << (FRECHET - 193)) | (1L << (EDR - 193)) | (1L << (LCSS - 193)) | (1L << (STRING - 193)) | (1L << (BIGINT_LITERAL - 193)) | (1L << (SMALLINT_LITERAL - 193)) | (1L << (TINYINT_LITERAL - 193)) | (1L << (INTEGER_VALUE - 193)) | (1L << (DECIMAL_VALUE - 193)) | (1L << (DOUBLE_LITERAL - 193)) | (1L << (BIGDECIMAL_LITERAL - 193)) | (1L << (IDENTIFIER - 193)) | (1L << (BACKQUOTED_IDENTIFIER - 193)))) != 0)) {
					{
					setState(1527);
					expression();
					setState(1532);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(1528);
						match(T__2);
						setState(1529);
						expression();
						}
						}
						setState(1534);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1537);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1538);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LateralViewContext extends ParserRuleContext {
		public IdentifierContext tblName;
		public IdentifierContext identifier;
		public List<IdentifierContext> colName = new ArrayList<IdentifierContext>();
		public TerminalNode LATERAL() { return getToken(SqlBaseParser.LATERAL, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OUTER() { return getToken(SqlBaseParser.OUTER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public LateralViewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lateralView; }
	}

	public final LateralViewContext lateralView() throws RecognitionException {
		LateralViewContext _localctx = new LateralViewContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_lateralView);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1541);
			match(LATERAL);
			setState(1542);
			match(VIEW);
			setState(1544);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
			case 1:
				{
				setState(1543);
				match(OUTER);
				}
				break;
			}
			setState(1546);
			qualifiedName();
			setState(1547);
			match(T__0);
			setState(1556);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL) | (1L << ON) | (1L << LATERAL) | (1L << WINDOW) | (1L << OVER) | (1L << PARTITION))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (PLUS - 129)) | (1L << (MINUS - 129)) | (1L << (ASTERISK - 129)) | (1L << (DIV - 129)) | (1L << (TILDE - 129)) | (1L << (PERCENTLIT - 129)) | (1L << (BUCKET - 129)) | (1L << (OUT - 129)) | (1L << (OF - 129)) | (1L << (SORT - 129)) | (1L << (CLUSTER - 129)) | (1L << (DISTRIBUTE - 129)) | (1L << (OVERWRITE - 129)) | (1L << (TRANSFORM - 129)) | (1L << (REDUCE - 129)) | (1L << (USING - 129)) | (1L << (SERDE - 129)) | (1L << (SERDEPROPERTIES - 129)) | (1L << (RECORDREADER - 129)) | (1L << (RECORDWRITER - 129)) | (1L << (DELIMITED - 129)) | (1L << (FIELDS - 129)) | (1L << (TERMINATED - 129)) | (1L << (COLLECTION - 129)) | (1L << (ITEMS - 129)) | (1L << (KEYS - 129)) | (1L << (ESCAPED - 129)) | (1L << (LINES - 129)) | (1L << (SEPARATED - 129)) | (1L << (FUNCTION - 129)) | (1L << (EXTENDED - 129)) | (1L << (REFRESH - 129)) | (1L << (CLEAR - 129)) | (1L << (CACHE - 129)) | (1L << (UNCACHE - 129)) | (1L << (LAZY - 129)) | (1L << (FORMATTED - 129)) | (1L << (GLOBAL - 129)) | (1L << (TEMPORARY - 129)) | (1L << (OPTIONS - 129)) | (1L << (UNSET - 129)) | (1L << (TBLPROPERTIES - 129)) | (1L << (DBPROPERTIES - 129)) | (1L << (BUCKETS - 129)) | (1L << (SKEWED - 129)) | (1L << (STORED - 129)) | (1L << (DIRECTORIES - 129)) | (1L << (LOCATION - 129)) | (1L << (EXCHANGE - 129)) | (1L << (ARCHIVE - 129)) | (1L << (UNARCHIVE - 129)) | (1L << (FILEFORMAT - 129)) | (1L << (TOUCH - 129)) | (1L << (COMPACT - 129)) | (1L << (CONCATENATE - 129)) | (1L << (CHANGE - 129)) | (1L << (CASCADE - 129)) | (1L << (RESTRICT - 129)) | (1L << (CLUSTERED - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (SORTED - 193)) | (1L << (PURGE - 193)) | (1L << (INPUTFORMAT - 193)) | (1L << (OUTPUTFORMAT - 193)) | (1L << (DATABASE - 193)) | (1L << (DATABASES - 193)) | (1L << (DFS - 193)) | (1L << (TRUNCATE - 193)) | (1L << (ANALYZE - 193)) | (1L << (COMPUTE - 193)) | (1L << (LIST - 193)) | (1L << (STATISTICS - 193)) | (1L << (PARTITIONED - 193)) | (1L << (EXTERNAL - 193)) | (1L << (DEFINED - 193)) | (1L << (REVOKE - 193)) | (1L << (GRANT - 193)) | (1L << (LOCK - 193)) | (1L << (UNLOCK - 193)) | (1L << (MSCK - 193)) | (1L << (REPAIR - 193)) | (1L << (RECOVER - 193)) | (1L << (EXPORT - 193)) | (1L << (IMPORT - 193)) | (1L << (LOAD - 193)) | (1L << (ROLE - 193)) | (1L << (ROLES - 193)) | (1L << (COMPACTIONS - 193)) | (1L << (PRINCIPALS - 193)) | (1L << (TRANSACTIONS - 193)) | (1L << (INDEX - 193)) | (1L << (INDEXES - 193)) | (1L << (LOCKS - 193)) | (1L << (OPTION - 193)) | (1L << (ANTI - 193)) | (1L << (LOCAL - 193)) | (1L << (INPATH - 193)) | (1L << (CURRENT_DATE - 193)) | (1L << (CURRENT_TIMESTAMP - 193)) | (1L << (EUCLID - 193)) | (1L << (DTW - 193)) | (1L << (FRECHET - 193)) | (1L << (EDR - 193)) | (1L << (LCSS - 193)) | (1L << (STRING - 193)) | (1L << (BIGINT_LITERAL - 193)) | (1L << (SMALLINT_LITERAL - 193)) | (1L << (TINYINT_LITERAL - 193)) | (1L << (INTEGER_VALUE - 193)) | (1L << (DECIMAL_VALUE - 193)) | (1L << (DOUBLE_LITERAL - 193)) | (1L << (BIGDECIMAL_LITERAL - 193)) | (1L << (IDENTIFIER - 193)) | (1L << (BACKQUOTED_IDENTIFIER - 193)))) != 0)) {
				{
				setState(1548);
				expression();
				setState(1553);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1549);
					match(T__2);
					setState(1550);
					expression();
					}
					}
					setState(1555);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1558);
			match(T__1);
			setState(1559);
			((LateralViewContext)_localctx).tblName = identifier();
			setState(1571);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
			case 1:
				{
				setState(1561);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
				case 1:
					{
					setState(1560);
					match(AS);
					}
					break;
				}
				setState(1563);
				((LateralViewContext)_localctx).identifier = identifier();
				((LateralViewContext)_localctx).colName.add(((LateralViewContext)_localctx).identifier);
				setState(1568);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1564);
						match(T__2);
						setState(1565);
						((LateralViewContext)_localctx).identifier = identifier();
						((LateralViewContext)_localctx).colName.add(((LateralViewContext)_localctx).identifier);
						}
						} 
					}
					setState(1570);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetQuantifierContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(SqlBaseParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(SqlBaseParser.ALL, 0); }
		public SetQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setQuantifier; }
	}

	public final SetQuantifierContext setQuantifier() throws RecognitionException {
		SetQuantifierContext _localctx = new SetQuantifierContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_setQuantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1573);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public RelationPrimaryContext relationPrimary() {
			return getRuleContext(RelationPrimaryContext.class,0);
		}
		public List<JoinRelationContext> joinRelation() {
			return getRuleContexts(JoinRelationContext.class);
		}
		public JoinRelationContext joinRelation(int i) {
			return getRuleContext(JoinRelationContext.class,i);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_relation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1575);
			relationPrimary();
			setState(1579);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,199,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1576);
					joinRelation();
					}
					} 
				}
				setState(1581);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,199,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinRelationContext extends ParserRuleContext {
		public RelationPrimaryContext right;
		public TerminalNode JOIN() { return getToken(SqlBaseParser.JOIN, 0); }
		public RelationPrimaryContext relationPrimary() {
			return getRuleContext(RelationPrimaryContext.class,0);
		}
		public JoinTypeContext joinType() {
			return getRuleContext(JoinTypeContext.class,0);
		}
		public JoinCriteriaContext joinCriteria() {
			return getRuleContext(JoinCriteriaContext.class,0);
		}
		public TerminalNode NATURAL() { return getToken(SqlBaseParser.NATURAL, 0); }
		public JoinRelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinRelation; }
	}

	public final JoinRelationContext joinRelation() throws RecognitionException {
		JoinRelationContext _localctx = new JoinRelationContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_joinRelation);
		try {
			setState(1593);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JOIN:
			case CROSS:
			case INNER:
			case LEFT:
			case RIGHT:
			case FULL:
			case ANTI:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1582);
				joinType();
				}
				setState(1583);
				match(JOIN);
				setState(1584);
				((JoinRelationContext)_localctx).right = relationPrimary();
				setState(1586);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
				case 1:
					{
					setState(1585);
					joinCriteria();
					}
					break;
				}
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1588);
				match(NATURAL);
				setState(1589);
				joinType();
				setState(1590);
				match(JOIN);
				setState(1591);
				((JoinRelationContext)_localctx).right = relationPrimary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinTypeContext extends ParserRuleContext {
		public TerminalNode INNER() { return getToken(SqlBaseParser.INNER, 0); }
		public TerminalNode CROSS() { return getToken(SqlBaseParser.CROSS, 0); }
		public TerminalNode LEFT() { return getToken(SqlBaseParser.LEFT, 0); }
		public TerminalNode OUTER() { return getToken(SqlBaseParser.OUTER, 0); }
		public TerminalNode SEMI() { return getToken(SqlBaseParser.SEMI, 0); }
		public TerminalNode RIGHT() { return getToken(SqlBaseParser.RIGHT, 0); }
		public TerminalNode FULL() { return getToken(SqlBaseParser.FULL, 0); }
		public TerminalNode ANTI() { return getToken(SqlBaseParser.ANTI, 0); }
		public JoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinType; }
	}

	public final JoinTypeContext joinType() throws RecognitionException {
		JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_joinType);
		int _la;
		try {
			setState(1617);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1596);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INNER) {
					{
					setState(1595);
					match(INNER);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1598);
				match(CROSS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1599);
				match(LEFT);
				setState(1601);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(1600);
					match(OUTER);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1603);
				match(LEFT);
				setState(1604);
				match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1605);
				match(RIGHT);
				setState(1607);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(1606);
					match(OUTER);
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1609);
				match(FULL);
				setState(1611);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(1610);
					match(OUTER);
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1614);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT) {
					{
					setState(1613);
					match(LEFT);
					}
				}

				setState(1616);
				match(ANTI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinCriteriaContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode USING() { return getToken(SqlBaseParser.USING, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public JoinCriteriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinCriteria; }
	}

	public final JoinCriteriaContext joinCriteria() throws RecognitionException {
		JoinCriteriaContext _localctx = new JoinCriteriaContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_joinCriteria);
		int _la;
		try {
			setState(1633);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(1619);
				match(ON);
				setState(1620);
				booleanExpression(0);
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1621);
				match(USING);
				setState(1622);
				match(T__0);
				setState(1623);
				identifier();
				setState(1628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1624);
					match(T__2);
					setState(1625);
					identifier();
					}
					}
					setState(1630);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1631);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SampleContext extends ParserRuleContext {
		public Token percentage;
		public Token sampleType;
		public Token numerator;
		public Token denominator;
		public TerminalNode TABLESAMPLE() { return getToken(SqlBaseParser.TABLESAMPLE, 0); }
		public TerminalNode BYTELENGTH_LITERAL() { return getToken(SqlBaseParser.BYTELENGTH_LITERAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OUT() { return getToken(SqlBaseParser.OUT, 0); }
		public TerminalNode OF() { return getToken(SqlBaseParser.OF, 0); }
		public TerminalNode PERCENTLIT() { return getToken(SqlBaseParser.PERCENTLIT, 0); }
		public TerminalNode ROWS() { return getToken(SqlBaseParser.ROWS, 0); }
		public TerminalNode BUCKET() { return getToken(SqlBaseParser.BUCKET, 0); }
		public List<TerminalNode> INTEGER_VALUE() { return getTokens(SqlBaseParser.INTEGER_VALUE); }
		public TerminalNode INTEGER_VALUE(int i) {
			return getToken(SqlBaseParser.INTEGER_VALUE, i);
		}
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlBaseParser.DECIMAL_VALUE, 0); }
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public SampleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sample; }
	}

	public final SampleContext sample() throws RecognitionException {
		SampleContext _localctx = new SampleContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_sample);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1635);
			match(TABLESAMPLE);
			setState(1636);
			match(T__0);
			setState(1658);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,212,_ctx) ) {
			case 1:
				{
				{
				setState(1637);
				((SampleContext)_localctx).percentage = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INTEGER_VALUE || _la==DECIMAL_VALUE) ) {
					((SampleContext)_localctx).percentage = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1638);
				((SampleContext)_localctx).sampleType = match(PERCENTLIT);
				}
				}
				break;
			case 2:
				{
				{
				setState(1639);
				expression();
				setState(1640);
				((SampleContext)_localctx).sampleType = match(ROWS);
				}
				}
				break;
			case 3:
				{
				setState(1642);
				((SampleContext)_localctx).sampleType = match(BYTELENGTH_LITERAL);
				}
				break;
			case 4:
				{
				{
				setState(1643);
				((SampleContext)_localctx).sampleType = match(BUCKET);
				setState(1644);
				((SampleContext)_localctx).numerator = match(INTEGER_VALUE);
				setState(1645);
				match(OUT);
				setState(1646);
				match(OF);
				setState(1647);
				((SampleContext)_localctx).denominator = match(INTEGER_VALUE);
				setState(1656);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(1648);
					match(ON);
					setState(1654);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
					case 1:
						{
						setState(1649);
						identifier();
						}
						break;
					case 2:
						{
						setState(1650);
						qualifiedName();
						setState(1651);
						match(T__0);
						setState(1652);
						match(T__1);
						}
						break;
					}
					}
				}

				}
				}
				break;
			}
			setState(1660);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierListContext extends ParserRuleContext {
		public IdentifierSeqContext identifierSeq() {
			return getRuleContext(IdentifierSeqContext.class,0);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_identifierList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1662);
			match(T__0);
			setState(1663);
			identifierSeq();
			setState(1664);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierSeqContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public IdentifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierSeq; }
	}

	public final IdentifierSeqContext identifierSeq() throws RecognitionException {
		IdentifierSeqContext _localctx = new IdentifierSeqContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_identifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1666);
			identifier();
			setState(1671);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,213,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1667);
					match(T__2);
					setState(1668);
					identifier();
					}
					} 
				}
				setState(1673);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,213,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderedIdentifierListContext extends ParserRuleContext {
		public List<OrderedIdentifierContext> orderedIdentifier() {
			return getRuleContexts(OrderedIdentifierContext.class);
		}
		public OrderedIdentifierContext orderedIdentifier(int i) {
			return getRuleContext(OrderedIdentifierContext.class,i);
		}
		public OrderedIdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderedIdentifierList; }
	}

	public final OrderedIdentifierListContext orderedIdentifierList() throws RecognitionException {
		OrderedIdentifierListContext _localctx = new OrderedIdentifierListContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_orderedIdentifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1674);
			match(T__0);
			setState(1675);
			orderedIdentifier();
			setState(1680);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1676);
				match(T__2);
				setState(1677);
				orderedIdentifier();
				}
				}
				setState(1682);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1683);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderedIdentifierContext extends ParserRuleContext {
		public Token ordering;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASC() { return getToken(SqlBaseParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SqlBaseParser.DESC, 0); }
		public OrderedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderedIdentifier; }
	}

	public final OrderedIdentifierContext orderedIdentifier() throws RecognitionException {
		OrderedIdentifierContext _localctx = new OrderedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_orderedIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1685);
			identifier();
			setState(1687);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(1686);
				((OrderedIdentifierContext)_localctx).ordering = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((OrderedIdentifierContext)_localctx).ordering = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierCommentListContext extends ParserRuleContext {
		public List<IdentifierCommentContext> identifierComment() {
			return getRuleContexts(IdentifierCommentContext.class);
		}
		public IdentifierCommentContext identifierComment(int i) {
			return getRuleContext(IdentifierCommentContext.class,i);
		}
		public IdentifierCommentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierCommentList; }
	}

	public final IdentifierCommentListContext identifierCommentList() throws RecognitionException {
		IdentifierCommentListContext _localctx = new IdentifierCommentListContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_identifierCommentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1689);
			match(T__0);
			setState(1690);
			identifierComment();
			setState(1695);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1691);
				match(T__2);
				setState(1692);
				identifierComment();
				}
				}
				setState(1697);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1698);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierCommentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlBaseParser.COMMENT, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public IdentifierCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierComment; }
	}

	public final IdentifierCommentContext identifierComment() throws RecognitionException {
		IdentifierCommentContext _localctx = new IdentifierCommentContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_identifierComment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1700);
			identifier();
			setState(1703);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(1701);
				match(COMMENT);
				setState(1702);
				match(STRING);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationPrimaryContext extends ParserRuleContext {
		public RelationPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationPrimary; }
	 
		public RelationPrimaryContext() { }
		public void copyFrom(RelationPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TableValuedFunctionContext extends RelationPrimaryContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TableValuedFunctionContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
	}
	public static class InlineTableDefault2Context extends RelationPrimaryContext {
		public InlineTableContext inlineTable() {
			return getRuleContext(InlineTableContext.class,0);
		}
		public InlineTableDefault2Context(RelationPrimaryContext ctx) { copyFrom(ctx); }
	}
	public static class AliasedRelationContext extends RelationPrimaryContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public SampleContext sample() {
			return getRuleContext(SampleContext.class,0);
		}
		public StrictIdentifierContext strictIdentifier() {
			return getRuleContext(StrictIdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public AliasedRelationContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
	}
	public static class AliasedQueryContext extends RelationPrimaryContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public SampleContext sample() {
			return getRuleContext(SampleContext.class,0);
		}
		public StrictIdentifierContext strictIdentifier() {
			return getRuleContext(StrictIdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public AliasedQueryContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
	}
	public static class TableNameContext extends RelationPrimaryContext {
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public SampleContext sample() {
			return getRuleContext(SampleContext.class,0);
		}
		public StrictIdentifierContext strictIdentifier() {
			return getRuleContext(StrictIdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public TableNameContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
	}

	public final RelationPrimaryContext relationPrimary() throws RecognitionException {
		RelationPrimaryContext _localctx = new RelationPrimaryContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_relationPrimary);
		int _la;
		try {
			setState(1754);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,229,_ctx) ) {
			case 1:
				_localctx = new TableNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1705);
				tableIdentifier();
				setState(1707);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,218,_ctx) ) {
				case 1:
					{
					setState(1706);
					sample();
					}
					break;
				}
				setState(1713);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,220,_ctx) ) {
				case 1:
					{
					setState(1710);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
					case 1:
						{
						setState(1709);
						match(AS);
						}
						break;
					}
					setState(1712);
					strictIdentifier();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new AliasedQueryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1715);
				match(T__0);
				setState(1716);
				queryNoWith();
				setState(1717);
				match(T__1);
				setState(1719);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
				case 1:
					{
					setState(1718);
					sample();
					}
					break;
				}
				setState(1725);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
				case 1:
					{
					setState(1722);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,222,_ctx) ) {
					case 1:
						{
						setState(1721);
						match(AS);
						}
						break;
					}
					setState(1724);
					strictIdentifier();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new AliasedRelationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1727);
				match(T__0);
				setState(1728);
				relation();
				setState(1729);
				match(T__1);
				setState(1731);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,224,_ctx) ) {
				case 1:
					{
					setState(1730);
					sample();
					}
					break;
				}
				setState(1737);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,226,_ctx) ) {
				case 1:
					{
					setState(1734);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
					case 1:
						{
						setState(1733);
						match(AS);
						}
						break;
					}
					setState(1736);
					strictIdentifier();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new InlineTableDefault2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1739);
				inlineTable();
				}
				break;
			case 5:
				_localctx = new TableValuedFunctionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1740);
				identifier();
				setState(1741);
				match(T__0);
				setState(1750);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL) | (1L << ON) | (1L << LATERAL) | (1L << WINDOW) | (1L << OVER) | (1L << PARTITION))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (PLUS - 129)) | (1L << (MINUS - 129)) | (1L << (ASTERISK - 129)) | (1L << (DIV - 129)) | (1L << (TILDE - 129)) | (1L << (PERCENTLIT - 129)) | (1L << (BUCKET - 129)) | (1L << (OUT - 129)) | (1L << (OF - 129)) | (1L << (SORT - 129)) | (1L << (CLUSTER - 129)) | (1L << (DISTRIBUTE - 129)) | (1L << (OVERWRITE - 129)) | (1L << (TRANSFORM - 129)) | (1L << (REDUCE - 129)) | (1L << (USING - 129)) | (1L << (SERDE - 129)) | (1L << (SERDEPROPERTIES - 129)) | (1L << (RECORDREADER - 129)) | (1L << (RECORDWRITER - 129)) | (1L << (DELIMITED - 129)) | (1L << (FIELDS - 129)) | (1L << (TERMINATED - 129)) | (1L << (COLLECTION - 129)) | (1L << (ITEMS - 129)) | (1L << (KEYS - 129)) | (1L << (ESCAPED - 129)) | (1L << (LINES - 129)) | (1L << (SEPARATED - 129)) | (1L << (FUNCTION - 129)) | (1L << (EXTENDED - 129)) | (1L << (REFRESH - 129)) | (1L << (CLEAR - 129)) | (1L << (CACHE - 129)) | (1L << (UNCACHE - 129)) | (1L << (LAZY - 129)) | (1L << (FORMATTED - 129)) | (1L << (GLOBAL - 129)) | (1L << (TEMPORARY - 129)) | (1L << (OPTIONS - 129)) | (1L << (UNSET - 129)) | (1L << (TBLPROPERTIES - 129)) | (1L << (DBPROPERTIES - 129)) | (1L << (BUCKETS - 129)) | (1L << (SKEWED - 129)) | (1L << (STORED - 129)) | (1L << (DIRECTORIES - 129)) | (1L << (LOCATION - 129)) | (1L << (EXCHANGE - 129)) | (1L << (ARCHIVE - 129)) | (1L << (UNARCHIVE - 129)) | (1L << (FILEFORMAT - 129)) | (1L << (TOUCH - 129)) | (1L << (COMPACT - 129)) | (1L << (CONCATENATE - 129)) | (1L << (CHANGE - 129)) | (1L << (CASCADE - 129)) | (1L << (RESTRICT - 129)) | (1L << (CLUSTERED - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (SORTED - 193)) | (1L << (PURGE - 193)) | (1L << (INPUTFORMAT - 193)) | (1L << (OUTPUTFORMAT - 193)) | (1L << (DATABASE - 193)) | (1L << (DATABASES - 193)) | (1L << (DFS - 193)) | (1L << (TRUNCATE - 193)) | (1L << (ANALYZE - 193)) | (1L << (COMPUTE - 193)) | (1L << (LIST - 193)) | (1L << (STATISTICS - 193)) | (1L << (PARTITIONED - 193)) | (1L << (EXTERNAL - 193)) | (1L << (DEFINED - 193)) | (1L << (REVOKE - 193)) | (1L << (GRANT - 193)) | (1L << (LOCK - 193)) | (1L << (UNLOCK - 193)) | (1L << (MSCK - 193)) | (1L << (REPAIR - 193)) | (1L << (RECOVER - 193)) | (1L << (EXPORT - 193)) | (1L << (IMPORT - 193)) | (1L << (LOAD - 193)) | (1L << (ROLE - 193)) | (1L << (ROLES - 193)) | (1L << (COMPACTIONS - 193)) | (1L << (PRINCIPALS - 193)) | (1L << (TRANSACTIONS - 193)) | (1L << (INDEX - 193)) | (1L << (INDEXES - 193)) | (1L << (LOCKS - 193)) | (1L << (OPTION - 193)) | (1L << (ANTI - 193)) | (1L << (LOCAL - 193)) | (1L << (INPATH - 193)) | (1L << (CURRENT_DATE - 193)) | (1L << (CURRENT_TIMESTAMP - 193)) | (1L << (EUCLID - 193)) | (1L << (DTW - 193)) | (1L << (FRECHET - 193)) | (1L << (EDR - 193)) | (1L << (LCSS - 193)) | (1L << (STRING - 193)) | (1L << (BIGINT_LITERAL - 193)) | (1L << (SMALLINT_LITERAL - 193)) | (1L << (TINYINT_LITERAL - 193)) | (1L << (INTEGER_VALUE - 193)) | (1L << (DECIMAL_VALUE - 193)) | (1L << (DOUBLE_LITERAL - 193)) | (1L << (BIGDECIMAL_LITERAL - 193)) | (1L << (IDENTIFIER - 193)) | (1L << (BACKQUOTED_IDENTIFIER - 193)))) != 0)) {
					{
					setState(1742);
					expression();
					setState(1747);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(1743);
						match(T__2);
						setState(1744);
						expression();
						}
						}
						setState(1749);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1752);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineTableContext extends ParserRuleContext {
		public TerminalNode VALUES() { return getToken(SqlBaseParser.VALUES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public InlineTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTable; }
	}

	public final InlineTableContext inlineTable() throws RecognitionException {
		InlineTableContext _localctx = new InlineTableContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_inlineTable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1756);
			match(VALUES);
			setState(1757);
			expression();
			setState(1762);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,230,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1758);
					match(T__2);
					setState(1759);
					expression();
					}
					} 
				}
				setState(1764);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,230,_ctx);
			}
			setState(1772);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,233,_ctx) ) {
			case 1:
				{
				setState(1766);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,231,_ctx) ) {
				case 1:
					{
					setState(1765);
					match(AS);
					}
					break;
				}
				setState(1768);
				identifier();
				setState(1770);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
				case 1:
					{
					setState(1769);
					identifierList();
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RowFormatContext extends ParserRuleContext {
		public RowFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowFormat; }
	 
		public RowFormatContext() { }
		public void copyFrom(RowFormatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RowFormatSerdeContext extends RowFormatContext {
		public Token name;
		public TablePropertyListContext props;
		public TerminalNode ROW() { return getToken(SqlBaseParser.ROW, 0); }
		public TerminalNode FORMAT() { return getToken(SqlBaseParser.FORMAT, 0); }
		public TerminalNode SERDE() { return getToken(SqlBaseParser.SERDE, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(SqlBaseParser.SERDEPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public RowFormatSerdeContext(RowFormatContext ctx) { copyFrom(ctx); }
	}
	public static class RowFormatDelimitedContext extends RowFormatContext {
		public Token fieldsTerminatedBy;
		public Token escapedBy;
		public Token collectionItemsTerminatedBy;
		public Token keysTerminatedBy;
		public Token linesSeparatedBy;
		public Token nullDefinedAs;
		public TerminalNode ROW() { return getToken(SqlBaseParser.ROW, 0); }
		public TerminalNode FORMAT() { return getToken(SqlBaseParser.FORMAT, 0); }
		public TerminalNode DELIMITED() { return getToken(SqlBaseParser.DELIMITED, 0); }
		public TerminalNode FIELDS() { return getToken(SqlBaseParser.FIELDS, 0); }
		public List<TerminalNode> TERMINATED() { return getTokens(SqlBaseParser.TERMINATED); }
		public TerminalNode TERMINATED(int i) {
			return getToken(SqlBaseParser.TERMINATED, i);
		}
		public List<TerminalNode> BY() { return getTokens(SqlBaseParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SqlBaseParser.BY, i);
		}
		public TerminalNode COLLECTION() { return getToken(SqlBaseParser.COLLECTION, 0); }
		public TerminalNode ITEMS() { return getToken(SqlBaseParser.ITEMS, 0); }
		public TerminalNode MAP() { return getToken(SqlBaseParser.MAP, 0); }
		public TerminalNode KEYS() { return getToken(SqlBaseParser.KEYS, 0); }
		public TerminalNode LINES() { return getToken(SqlBaseParser.LINES, 0); }
		public TerminalNode NULL() { return getToken(SqlBaseParser.NULL, 0); }
		public TerminalNode DEFINED() { return getToken(SqlBaseParser.DEFINED, 0); }
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public List<TerminalNode> STRING() { return getTokens(SqlBaseParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SqlBaseParser.STRING, i);
		}
		public TerminalNode ESCAPED() { return getToken(SqlBaseParser.ESCAPED, 0); }
		public RowFormatDelimitedContext(RowFormatContext ctx) { copyFrom(ctx); }
	}

	public final RowFormatContext rowFormat() throws RecognitionException {
		RowFormatContext _localctx = new RowFormatContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_rowFormat);
		try {
			setState(1823);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,241,_ctx) ) {
			case 1:
				_localctx = new RowFormatSerdeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1774);
				match(ROW);
				setState(1775);
				match(FORMAT);
				setState(1776);
				match(SERDE);
				setState(1777);
				((RowFormatSerdeContext)_localctx).name = match(STRING);
				setState(1781);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
				case 1:
					{
					setState(1778);
					match(WITH);
					setState(1779);
					match(SERDEPROPERTIES);
					setState(1780);
					((RowFormatSerdeContext)_localctx).props = tablePropertyList();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new RowFormatDelimitedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1783);
				match(ROW);
				setState(1784);
				match(FORMAT);
				setState(1785);
				match(DELIMITED);
				setState(1795);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
				case 1:
					{
					setState(1786);
					match(FIELDS);
					setState(1787);
					match(TERMINATED);
					setState(1788);
					match(BY);
					setState(1789);
					((RowFormatDelimitedContext)_localctx).fieldsTerminatedBy = match(STRING);
					setState(1793);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
					case 1:
						{
						setState(1790);
						match(ESCAPED);
						setState(1791);
						match(BY);
						setState(1792);
						((RowFormatDelimitedContext)_localctx).escapedBy = match(STRING);
						}
						break;
					}
					}
					break;
				}
				setState(1802);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,237,_ctx) ) {
				case 1:
					{
					setState(1797);
					match(COLLECTION);
					setState(1798);
					match(ITEMS);
					setState(1799);
					match(TERMINATED);
					setState(1800);
					match(BY);
					setState(1801);
					((RowFormatDelimitedContext)_localctx).collectionItemsTerminatedBy = match(STRING);
					}
					break;
				}
				setState(1809);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,238,_ctx) ) {
				case 1:
					{
					setState(1804);
					match(MAP);
					setState(1805);
					match(KEYS);
					setState(1806);
					match(TERMINATED);
					setState(1807);
					match(BY);
					setState(1808);
					((RowFormatDelimitedContext)_localctx).keysTerminatedBy = match(STRING);
					}
					break;
				}
				setState(1815);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,239,_ctx) ) {
				case 1:
					{
					setState(1811);
					match(LINES);
					setState(1812);
					match(TERMINATED);
					setState(1813);
					match(BY);
					setState(1814);
					((RowFormatDelimitedContext)_localctx).linesSeparatedBy = match(STRING);
					}
					break;
				}
				setState(1821);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,240,_ctx) ) {
				case 1:
					{
					setState(1817);
					match(NULL);
					setState(1818);
					match(DEFINED);
					setState(1819);
					match(AS);
					setState(1820);
					((RowFormatDelimitedContext)_localctx).nullDefinedAs = match(STRING);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableIdentifierContext extends ParserRuleContext {
		public IdentifierContext db;
		public IdentifierContext table;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TableIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableIdentifier; }
	}

	public final TableIdentifierContext tableIdentifier() throws RecognitionException {
		TableIdentifierContext _localctx = new TableIdentifierContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_tableIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1828);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
			case 1:
				{
				setState(1825);
				((TableIdentifierContext)_localctx).db = identifier();
				setState(1826);
				match(T__3);
				}
				break;
			}
			setState(1830);
			((TableIdentifierContext)_localctx).table = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionIdentifierContext extends ParserRuleContext {
		public IdentifierContext db;
		public IdentifierContext function;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public FunctionIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionIdentifier; }
	}

	public final FunctionIdentifierContext functionIdentifier() throws RecognitionException {
		FunctionIdentifierContext _localctx = new FunctionIdentifierContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_functionIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1835);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,243,_ctx) ) {
			case 1:
				{
				setState(1832);
				((FunctionIdentifierContext)_localctx).db = identifier();
				setState(1833);
				match(T__3);
				}
				break;
			}
			setState(1837);
			((FunctionIdentifierContext)_localctx).function = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public NamedExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedExpression; }
	}

	public final NamedExpressionContext namedExpression() throws RecognitionException {
		NamedExpressionContext _localctx = new NamedExpressionContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_namedExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1839);
			expression();
			setState(1847);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,246,_ctx) ) {
			case 1:
				{
				setState(1841);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,244,_ctx) ) {
				case 1:
					{
					setState(1840);
					match(AS);
					}
					break;
				}
				setState(1845);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT:
				case FROM:
				case ADD:
				case AS:
				case ALL:
				case DISTINCT:
				case WHERE:
				case GROUP:
				case BY:
				case GROUPING:
				case SETS:
				case CUBE:
				case ROLLUP:
				case ORDER:
				case HAVING:
				case LIMIT:
				case AT:
				case OR:
				case AND:
				case IN:
				case NOT:
				case NO:
				case EXISTS:
				case BETWEEN:
				case LIKE:
				case RLIKE:
				case IS:
				case NULL:
				case TRUE:
				case FALSE:
				case NULLS:
				case ASC:
				case DESC:
				case FOR:
				case INTERVAL:
				case CASE:
				case WHEN:
				case THEN:
				case ELSE:
				case END:
				case JOIN:
				case CROSS:
				case OUTER:
				case INNER:
				case LEFT:
				case SEMI:
				case RIGHT:
				case FULL:
				case NATURAL:
				case ON:
				case LATERAL:
				case WINDOW:
				case OVER:
				case PARTITION:
				case RANGE:
				case ROWS:
				case UNBOUNDED:
				case PRECEDING:
				case FOLLOWING:
				case CURRENT:
				case FIRST:
				case AFTER:
				case LAST:
				case ROW:
				case WITH:
				case VALUES:
				case CREATE:
				case TABLE:
				case VIEW:
				case REPLACE:
				case INSERT:
				case DELETE:
				case INTO:
				case DESCRIBE:
				case EXPLAIN:
				case FORMAT:
				case LOGICAL:
				case CODEGEN:
				case COST:
				case CAST:
				case SHOW:
				case TABLES:
				case COLUMNS:
				case COLUMN:
				case USE:
				case PARTITIONS:
				case FUNCTIONS:
				case DROP:
				case UNION:
				case EXCEPT:
				case SETMINUS:
				case INTERSECT:
				case TO:
				case TABLESAMPLE:
				case STRATIFY:
				case ALTER:
				case RENAME:
				case ARRAY:
				case MAP:
				case STRUCT:
				case COMMENT:
				case SET:
				case RESET:
				case DATA:
				case START:
				case TRANSACTION:
				case COMMIT:
				case ROLLBACK:
				case MACRO:
				case IGNORE:
				case IF:
				case DIV:
				case PERCENTLIT:
				case BUCKET:
				case OUT:
				case OF:
				case SORT:
				case CLUSTER:
				case DISTRIBUTE:
				case OVERWRITE:
				case TRANSFORM:
				case REDUCE:
				case USING:
				case SERDE:
				case SERDEPROPERTIES:
				case RECORDREADER:
				case RECORDWRITER:
				case DELIMITED:
				case FIELDS:
				case TERMINATED:
				case COLLECTION:
				case ITEMS:
				case KEYS:
				case ESCAPED:
				case LINES:
				case SEPARATED:
				case FUNCTION:
				case EXTENDED:
				case REFRESH:
				case CLEAR:
				case CACHE:
				case UNCACHE:
				case LAZY:
				case FORMATTED:
				case GLOBAL:
				case TEMPORARY:
				case OPTIONS:
				case UNSET:
				case TBLPROPERTIES:
				case DBPROPERTIES:
				case BUCKETS:
				case SKEWED:
				case STORED:
				case DIRECTORIES:
				case LOCATION:
				case EXCHANGE:
				case ARCHIVE:
				case UNARCHIVE:
				case FILEFORMAT:
				case TOUCH:
				case COMPACT:
				case CONCATENATE:
				case CHANGE:
				case CASCADE:
				case RESTRICT:
				case CLUSTERED:
				case SORTED:
				case PURGE:
				case INPUTFORMAT:
				case OUTPUTFORMAT:
				case DATABASE:
				case DATABASES:
				case DFS:
				case TRUNCATE:
				case ANALYZE:
				case COMPUTE:
				case LIST:
				case STATISTICS:
				case PARTITIONED:
				case EXTERNAL:
				case DEFINED:
				case REVOKE:
				case GRANT:
				case LOCK:
				case UNLOCK:
				case MSCK:
				case REPAIR:
				case RECOVER:
				case EXPORT:
				case IMPORT:
				case LOAD:
				case ROLE:
				case ROLES:
				case COMPACTIONS:
				case PRINCIPALS:
				case TRANSACTIONS:
				case INDEX:
				case INDEXES:
				case LOCKS:
				case OPTION:
				case ANTI:
				case LOCAL:
				case INPATH:
				case CURRENT_DATE:
				case CURRENT_TIMESTAMP:
				case IDENTIFIER:
				case BACKQUOTED_IDENTIFIER:
					{
					setState(1843);
					identifier();
					}
					break;
				case T__0:
					{
					setState(1844);
					identifierList();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedExpressionSeqContext extends ParserRuleContext {
		public List<NamedExpressionContext> namedExpression() {
			return getRuleContexts(NamedExpressionContext.class);
		}
		public NamedExpressionContext namedExpression(int i) {
			return getRuleContext(NamedExpressionContext.class,i);
		}
		public NamedExpressionSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedExpressionSeq; }
	}

	public final NamedExpressionSeqContext namedExpressionSeq() throws RecognitionException {
		NamedExpressionSeqContext _localctx = new NamedExpressionSeqContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_namedExpressionSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1849);
			namedExpression();
			setState(1854);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,247,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1850);
					match(T__2);
					setState(1851);
					namedExpression();
					}
					} 
				}
				setState(1856);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,247,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1857);
			booleanExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
	 
		public BooleanExpressionContext() { }
		public void copyFrom(BooleanExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalNotContext extends BooleanExpressionContext {
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public LogicalNotContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanDefaultContext extends BooleanExpressionContext {
		public PredicatedContext predicated() {
			return getRuleContext(PredicatedContext.class,0);
		}
		public BooleanDefaultContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ExistsContext extends BooleanExpressionContext {
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ExistsContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class LogicalBinaryContext extends BooleanExpressionContext {
		public BooleanExpressionContext left;
		public Token operator;
		public BooleanExpressionContext right;
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(SqlBaseParser.AND, 0); }
		public TerminalNode OR() { return getToken(SqlBaseParser.OR, 0); }
		public LogicalBinaryContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		return booleanExpression(0);
	}

	private BooleanExpressionContext booleanExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, _parentState);
		BooleanExpressionContext _prevctx = _localctx;
		int _startState = 128;
		enterRecursionRule(_localctx, 128, RULE_booleanExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1868);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,248,_ctx) ) {
			case 1:
				{
				_localctx = new LogicalNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1860);
				match(NOT);
				setState(1861);
				booleanExpression(5);
				}
				break;
			case 2:
				{
				_localctx = new ExistsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1862);
				match(EXISTS);
				setState(1863);
				match(T__0);
				setState(1864);
				query();
				setState(1865);
				match(T__1);
				}
				break;
			case 3:
				{
				_localctx = new BooleanDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1867);
				predicated();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1878);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,250,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1876);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,249,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
						((LogicalBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(1870);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1871);
						((LogicalBinaryContext)_localctx).operator = match(AND);
						setState(1872);
						((LogicalBinaryContext)_localctx).right = booleanExpression(3);
						}
						break;
					case 2:
						{
						_localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
						((LogicalBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(1873);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1874);
						((LogicalBinaryContext)_localctx).operator = match(OR);
						setState(1875);
						((LogicalBinaryContext)_localctx).right = booleanExpression(2);
						}
						break;
					}
					} 
				}
				setState(1880);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,250,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PredicatedContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicatedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicated; }
	}

	public final PredicatedContext predicated() throws RecognitionException {
		PredicatedContext _localctx = new PredicatedContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_predicated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1881);
			valueExpression(0);
			setState(1883);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,251,_ctx) ) {
			case 1:
				{
				setState(1882);
				predicate();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public Token kind;
		public ValueExpressionContext lower;
		public ValueExpressionContext upper;
		public ValueExpressionContext pattern;
		public TerminalNode AND() { return getToken(SqlBaseParser.AND, 0); }
		public TerminalNode BETWEEN() { return getToken(SqlBaseParser.BETWEEN, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode RLIKE() { return getToken(SqlBaseParser.RLIKE, 0); }
		public TerminalNode LIKE() { return getToken(SqlBaseParser.LIKE, 0); }
		public TerminalNode IS() { return getToken(SqlBaseParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SqlBaseParser.NULL, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_predicate);
		int _la;
		try {
			setState(1926);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1886);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1885);
					match(NOT);
					}
				}

				setState(1888);
				((PredicateContext)_localctx).kind = match(BETWEEN);
				setState(1889);
				((PredicateContext)_localctx).lower = valueExpression(0);
				setState(1890);
				match(AND);
				setState(1891);
				((PredicateContext)_localctx).upper = valueExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1894);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1893);
					match(NOT);
					}
				}

				setState(1896);
				((PredicateContext)_localctx).kind = match(IN);
				setState(1897);
				match(T__0);
				setState(1898);
				expression();
				setState(1903);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1899);
					match(T__2);
					setState(1900);
					expression();
					}
					}
					setState(1905);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1906);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1909);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1908);
					match(NOT);
					}
				}

				setState(1911);
				((PredicateContext)_localctx).kind = match(IN);
				setState(1912);
				match(T__0);
				setState(1913);
				query();
				setState(1914);
				match(T__1);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1917);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1916);
					match(NOT);
					}
				}

				setState(1919);
				((PredicateContext)_localctx).kind = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==LIKE || _la==RLIKE) ) {
					((PredicateContext)_localctx).kind = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1920);
				((PredicateContext)_localctx).pattern = valueExpression(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1921);
				match(IS);
				setState(1923);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1922);
					match(NOT);
					}
				}

				setState(1925);
				((PredicateContext)_localctx).kind = match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetricSimilarityFunctionContext extends ParserRuleContext {
		public TerminalNode EUCLID() { return getToken(SqlBaseParser.EUCLID, 0); }
		public MetricSimilarityFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metricSimilarityFunction; }
	}

	public final MetricSimilarityFunctionContext metricSimilarityFunction() throws RecognitionException {
		MetricSimilarityFunctionContext _localctx = new MetricSimilarityFunctionContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_metricSimilarityFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1928);
			match(EUCLID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TrajectorySimilarityFunctionContext extends ParserRuleContext {
		public TerminalNode DTW() { return getToken(SqlBaseParser.DTW, 0); }
		public TerminalNode FRECHET() { return getToken(SqlBaseParser.FRECHET, 0); }
		public TerminalNode EDR() { return getToken(SqlBaseParser.EDR, 0); }
		public TerminalNode LCSS() { return getToken(SqlBaseParser.LCSS, 0); }
		public TrajectorySimilarityFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trajectorySimilarityFunction; }
	}

	public final TrajectorySimilarityFunctionContext trajectorySimilarityFunction() throws RecognitionException {
		TrajectorySimilarityFunctionContext _localctx = new TrajectorySimilarityFunctionContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_trajectorySimilarityFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1930);
			_la = _input.LA(1);
			if ( !(((((_la - 235)) & ~0x3f) == 0 && ((1L << (_la - 235)) & ((1L << (DTW - 235)) | (1L << (FRECHET - 235)) | (1L << (EDR - 235)) | (1L << (LCSS - 235)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueExpressionContext extends ParserRuleContext {
		public ValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueExpression; }
	 
		public ValueExpressionContext() { }
		public void copyFrom(ValueExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TrajectoryMBRRangeContext extends ValueExpressionContext {
		public PrimaryExpressionContext leftTable;
		public PointExpressionContext lowPoint;
		public PointExpressionContext highPoint;
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public TerminalNode MBRRANGE() { return getToken(SqlBaseParser.MBRRANGE, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public List<PointExpressionContext> pointExpression() {
			return getRuleContexts(PointExpressionContext.class);
		}
		public PointExpressionContext pointExpression(int i) {
			return getRuleContext(PointExpressionContext.class,i);
		}
		public TrajectoryMBRRangeContext(ValueExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ValueExpressionDefaultContext extends ValueExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ValueExpressionDefaultContext(ValueExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ComparisonContext extends ValueExpressionContext {
		public ValueExpressionContext left;
		public ValueExpressionContext right;
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public ComparisonContext(ValueExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class MetricSimilarityWithKNNContext extends ValueExpressionContext {
		public NumberContext count;
		public MetricSimilarityExpressionContext metricSimilarityExpression() {
			return getRuleContext(MetricSimilarityExpressionContext.class,0);
		}
		public TerminalNode KNN() { return getToken(SqlBaseParser.KNN, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public MetricSimilarityWithKNNContext(ValueExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class TrajectorySimilarityWithKNNContext extends ValueExpressionContext {
		public NumberContext count;
		public TrajectorySimilarityExpressionContext trajectorySimilarityExpression() {
			return getRuleContext(TrajectorySimilarityExpressionContext.class,0);
		}
		public TerminalNode KNN() { return getToken(SqlBaseParser.KNN, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TrajectorySimilarityWithKNNContext(ValueExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class TrajectoryCircleRangeContext extends ValueExpressionContext {
		public PrimaryExpressionContext leftTable;
		public PointExpressionContext center;
		public NumberContext radius;
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public TerminalNode CIRCLERANGE() { return getToken(SqlBaseParser.CIRCLERANGE, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public PointExpressionContext pointExpression() {
			return getRuleContext(PointExpressionContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TrajectoryCircleRangeContext(ValueExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class TrajectorySimilarityWithThresholdContext extends ValueExpressionContext {
		public NumberContext threshold;
		public TrajectorySimilarityExpressionContext trajectorySimilarityExpression() {
			return getRuleContext(TrajectorySimilarityExpressionContext.class,0);
		}
		public TerminalNode LTE() { return getToken(SqlBaseParser.LTE, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TrajectorySimilarityWithThresholdContext(ValueExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ArithmeticBinaryContext extends ValueExpressionContext {
		public ValueExpressionContext left;
		public Token operator;
		public ValueExpressionContext right;
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode ASTERISK() { return getToken(SqlBaseParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(SqlBaseParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(SqlBaseParser.PERCENT, 0); }
		public TerminalNode DIV() { return getToken(SqlBaseParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(SqlBaseParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public TerminalNode AMPERSAND() { return getToken(SqlBaseParser.AMPERSAND, 0); }
		public TerminalNode HAT() { return getToken(SqlBaseParser.HAT, 0); }
		public TerminalNode PIPE() { return getToken(SqlBaseParser.PIPE, 0); }
		public ArithmeticBinaryContext(ValueExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ArithmeticUnaryContext extends ValueExpressionContext {
		public Token operator;
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SqlBaseParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(SqlBaseParser.TILDE, 0); }
		public ArithmeticUnaryContext(ValueExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ValueExpressionContext valueExpression() throws RecognitionException {
		return valueExpression(0);
	}

	private ValueExpressionContext valueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueExpressionContext _localctx = new ValueExpressionContext(_ctx, _parentState);
		ValueExpressionContext _prevctx = _localctx;
		int _startState = 138;
		enterRecursionRule(_localctx, 138, RULE_valueExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1966);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,259,_ctx) ) {
			case 1:
				{
				_localctx = new TrajectorySimilarityWithThresholdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1933);
				trajectorySimilarityExpression();
				setState(1934);
				match(LTE);
				setState(1935);
				((TrajectorySimilarityWithThresholdContext)_localctx).threshold = number();
				}
				break;
			case 2:
				{
				_localctx = new TrajectorySimilarityWithKNNContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1937);
				trajectorySimilarityExpression();
				setState(1938);
				match(KNN);
				setState(1939);
				((TrajectorySimilarityWithKNNContext)_localctx).count = number();
				}
				break;
			case 3:
				{
				_localctx = new MetricSimilarityWithKNNContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1941);
				metricSimilarityExpression();
				setState(1942);
				match(KNN);
				setState(1943);
				((MetricSimilarityWithKNNContext)_localctx).count = number();
				}
				break;
			case 4:
				{
				_localctx = new TrajectoryMBRRangeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1945);
				((TrajectoryMBRRangeContext)_localctx).leftTable = primaryExpression(0);
				setState(1946);
				match(IN);
				setState(1947);
				match(MBRRANGE);
				setState(1948);
				match(T__0);
				setState(1949);
				((TrajectoryMBRRangeContext)_localctx).lowPoint = pointExpression();
				setState(1950);
				match(T__2);
				setState(1951);
				((TrajectoryMBRRangeContext)_localctx).highPoint = pointExpression();
				setState(1952);
				match(T__1);
				}
				break;
			case 5:
				{
				_localctx = new TrajectoryCircleRangeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1954);
				((TrajectoryCircleRangeContext)_localctx).leftTable = primaryExpression(0);
				setState(1955);
				match(IN);
				setState(1956);
				match(CIRCLERANGE);
				setState(1957);
				match(T__0);
				setState(1958);
				((TrajectoryCircleRangeContext)_localctx).center = pointExpression();
				setState(1959);
				match(T__2);
				setState(1960);
				((TrajectoryCircleRangeContext)_localctx).radius = number();
				setState(1961);
				match(T__1);
				}
				break;
			case 6:
				{
				_localctx = new ValueExpressionDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1963);
				primaryExpression(0);
				}
				break;
			case 7:
				{
				_localctx = new ArithmeticUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1964);
				((ArithmeticUnaryContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (PLUS - 129)) | (1L << (MINUS - 129)) | (1L << (TILDE - 129)))) != 0)) ) {
					((ArithmeticUnaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1965);
				valueExpression(7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1989);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,261,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1987);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,260,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(1968);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1969);
						((ArithmeticBinaryContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (ASTERISK - 131)) | (1L << (SLASH - 131)) | (1L << (PERCENT - 131)) | (1L << (DIV - 131)))) != 0)) ) {
							((ArithmeticBinaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1970);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(7);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(1971);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1972);
						((ArithmeticBinaryContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ArithmeticBinaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1973);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(6);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(1974);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1975);
						((ArithmeticBinaryContext)_localctx).operator = match(AMPERSAND);
						setState(1976);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(5);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(1977);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1978);
						((ArithmeticBinaryContext)_localctx).operator = match(HAT);
						setState(1979);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(4);
						}
						break;
					case 5:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(1980);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1981);
						((ArithmeticBinaryContext)_localctx).operator = match(PIPE);
						setState(1982);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(3);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonContext(new ValueExpressionContext(_parentctx, _parentState));
						((ComparisonContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(1983);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1984);
						comparisonOperator();
						setState(1985);
						((ComparisonContext)_localctx).right = valueExpression(2);
						}
						break;
					}
					} 
				}
				setState(1991);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,261,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	 
		public PrimaryExpressionContext() { }
		public void copyFrom(PrimaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StructContext extends PrimaryExpressionContext {
		public NamedExpressionContext namedExpression;
		public List<NamedExpressionContext> argument = new ArrayList<NamedExpressionContext>();
		public TerminalNode STRUCT() { return getToken(SqlBaseParser.STRUCT, 0); }
		public List<NamedExpressionContext> namedExpression() {
			return getRuleContexts(NamedExpressionContext.class);
		}
		public NamedExpressionContext namedExpression(int i) {
			return getRuleContext(NamedExpressionContext.class,i);
		}
		public StructContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class DereferenceContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext base;
		public IdentifierContext fieldName;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DereferenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class SimpleCaseContext extends PrimaryExpressionContext {
		public ExpressionContext value;
		public ExpressionContext elseExpression;
		public TerminalNode CASE() { return getToken(SqlBaseParser.CASE, 0); }
		public TerminalNode END() { return getToken(SqlBaseParser.END, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<WhenClauseContext> whenClause() {
			return getRuleContexts(WhenClauseContext.class);
		}
		public WhenClauseContext whenClause(int i) {
			return getRuleContext(WhenClauseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SqlBaseParser.ELSE, 0); }
		public SimpleCaseContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ColumnReferenceContext extends PrimaryExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColumnReferenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class RowConstructorContext extends PrimaryExpressionContext {
		public List<NamedExpressionContext> namedExpression() {
			return getRuleContexts(NamedExpressionContext.class);
		}
		public NamedExpressionContext namedExpression(int i) {
			return getRuleContext(NamedExpressionContext.class,i);
		}
		public RowConstructorContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class LastContext extends PrimaryExpressionContext {
		public TerminalNode LAST() { return getToken(SqlBaseParser.LAST, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IGNORE() { return getToken(SqlBaseParser.IGNORE, 0); }
		public TerminalNode NULLS() { return getToken(SqlBaseParser.NULLS, 0); }
		public LastContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class StarContext extends PrimaryExpressionContext {
		public TerminalNode ASTERISK() { return getToken(SqlBaseParser.ASTERISK, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public StarContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class SubscriptContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext value;
		public ValueExpressionContext index;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public SubscriptContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class TimeFunctionCallContext extends PrimaryExpressionContext {
		public Token name;
		public TerminalNode CURRENT_DATE() { return getToken(SqlBaseParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SqlBaseParser.CURRENT_TIMESTAMP, 0); }
		public TimeFunctionCallContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class SubqueryExpressionContext extends PrimaryExpressionContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public SubqueryExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class CastContext extends PrimaryExpressionContext {
		public TerminalNode CAST() { return getToken(SqlBaseParser.CAST, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public CastContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ConstantDefaultContext extends PrimaryExpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantDefaultContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ParenthesizedExpressionContext extends PrimaryExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesizedExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionCallContext extends PrimaryExpressionContext {
		public ExpressionContext expression;
		public List<ExpressionContext> argument = new ArrayList<ExpressionContext>();
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode OVER() { return getToken(SqlBaseParser.OVER, 0); }
		public WindowSpecContext windowSpec() {
			return getRuleContext(WindowSpecContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public FunctionCallContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class SearchedCaseContext extends PrimaryExpressionContext {
		public ExpressionContext elseExpression;
		public TerminalNode CASE() { return getToken(SqlBaseParser.CASE, 0); }
		public TerminalNode END() { return getToken(SqlBaseParser.END, 0); }
		public List<WhenClauseContext> whenClause() {
			return getRuleContexts(WhenClauseContext.class);
		}
		public WhenClauseContext whenClause(int i) {
			return getRuleContext(WhenClauseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SqlBaseParser.ELSE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SearchedCaseContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class FirstContext extends PrimaryExpressionContext {
		public TerminalNode FIRST() { return getToken(SqlBaseParser.FIRST, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IGNORE() { return getToken(SqlBaseParser.IGNORE, 0); }
		public TerminalNode NULLS() { return getToken(SqlBaseParser.NULLS, 0); }
		public FirstContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		return primaryExpression(0);
	}

	private PrimaryExpressionContext primaryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, _parentState);
		PrimaryExpressionContext _prevctx = _localctx;
		int _startState = 140;
		enterRecursionRule(_localctx, 140, RULE_primaryExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
			case 1:
				{
				_localctx = new TimeFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1993);
				((TimeFunctionCallContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==CURRENT_DATE || _la==CURRENT_TIMESTAMP) ) {
					((TimeFunctionCallContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				{
				_localctx = new SearchedCaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1994);
				match(CASE);
				setState(1996); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1995);
					whenClause();
					}
					}
					setState(1998); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(2002);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(2000);
					match(ELSE);
					setState(2001);
					((SearchedCaseContext)_localctx).elseExpression = expression();
					}
				}

				setState(2004);
				match(END);
				}
				break;
			case 3:
				{
				_localctx = new SimpleCaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2006);
				match(CASE);
				setState(2007);
				((SimpleCaseContext)_localctx).value = expression();
				setState(2009); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2008);
					whenClause();
					}
					}
					setState(2011); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(2015);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(2013);
					match(ELSE);
					setState(2014);
					((SimpleCaseContext)_localctx).elseExpression = expression();
					}
				}

				setState(2017);
				match(END);
				}
				break;
			case 4:
				{
				_localctx = new CastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2019);
				match(CAST);
				setState(2020);
				match(T__0);
				setState(2021);
				expression();
				setState(2022);
				match(AS);
				setState(2023);
				dataType();
				setState(2024);
				match(T__1);
				}
				break;
			case 5:
				{
				_localctx = new StructContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2026);
				match(STRUCT);
				setState(2027);
				match(T__0);
				setState(2036);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL) | (1L << ON) | (1L << LATERAL) | (1L << WINDOW) | (1L << OVER) | (1L << PARTITION))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (PLUS - 129)) | (1L << (MINUS - 129)) | (1L << (ASTERISK - 129)) | (1L << (DIV - 129)) | (1L << (TILDE - 129)) | (1L << (PERCENTLIT - 129)) | (1L << (BUCKET - 129)) | (1L << (OUT - 129)) | (1L << (OF - 129)) | (1L << (SORT - 129)) | (1L << (CLUSTER - 129)) | (1L << (DISTRIBUTE - 129)) | (1L << (OVERWRITE - 129)) | (1L << (TRANSFORM - 129)) | (1L << (REDUCE - 129)) | (1L << (USING - 129)) | (1L << (SERDE - 129)) | (1L << (SERDEPROPERTIES - 129)) | (1L << (RECORDREADER - 129)) | (1L << (RECORDWRITER - 129)) | (1L << (DELIMITED - 129)) | (1L << (FIELDS - 129)) | (1L << (TERMINATED - 129)) | (1L << (COLLECTION - 129)) | (1L << (ITEMS - 129)) | (1L << (KEYS - 129)) | (1L << (ESCAPED - 129)) | (1L << (LINES - 129)) | (1L << (SEPARATED - 129)) | (1L << (FUNCTION - 129)) | (1L << (EXTENDED - 129)) | (1L << (REFRESH - 129)) | (1L << (CLEAR - 129)) | (1L << (CACHE - 129)) | (1L << (UNCACHE - 129)) | (1L << (LAZY - 129)) | (1L << (FORMATTED - 129)) | (1L << (GLOBAL - 129)) | (1L << (TEMPORARY - 129)) | (1L << (OPTIONS - 129)) | (1L << (UNSET - 129)) | (1L << (TBLPROPERTIES - 129)) | (1L << (DBPROPERTIES - 129)) | (1L << (BUCKETS - 129)) | (1L << (SKEWED - 129)) | (1L << (STORED - 129)) | (1L << (DIRECTORIES - 129)) | (1L << (LOCATION - 129)) | (1L << (EXCHANGE - 129)) | (1L << (ARCHIVE - 129)) | (1L << (UNARCHIVE - 129)) | (1L << (FILEFORMAT - 129)) | (1L << (TOUCH - 129)) | (1L << (COMPACT - 129)) | (1L << (CONCATENATE - 129)) | (1L << (CHANGE - 129)) | (1L << (CASCADE - 129)) | (1L << (RESTRICT - 129)) | (1L << (CLUSTERED - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (SORTED - 193)) | (1L << (PURGE - 193)) | (1L << (INPUTFORMAT - 193)) | (1L << (OUTPUTFORMAT - 193)) | (1L << (DATABASE - 193)) | (1L << (DATABASES - 193)) | (1L << (DFS - 193)) | (1L << (TRUNCATE - 193)) | (1L << (ANALYZE - 193)) | (1L << (COMPUTE - 193)) | (1L << (LIST - 193)) | (1L << (STATISTICS - 193)) | (1L << (PARTITIONED - 193)) | (1L << (EXTERNAL - 193)) | (1L << (DEFINED - 193)) | (1L << (REVOKE - 193)) | (1L << (GRANT - 193)) | (1L << (LOCK - 193)) | (1L << (UNLOCK - 193)) | (1L << (MSCK - 193)) | (1L << (REPAIR - 193)) | (1L << (RECOVER - 193)) | (1L << (EXPORT - 193)) | (1L << (IMPORT - 193)) | (1L << (LOAD - 193)) | (1L << (ROLE - 193)) | (1L << (ROLES - 193)) | (1L << (COMPACTIONS - 193)) | (1L << (PRINCIPALS - 193)) | (1L << (TRANSACTIONS - 193)) | (1L << (INDEX - 193)) | (1L << (INDEXES - 193)) | (1L << (LOCKS - 193)) | (1L << (OPTION - 193)) | (1L << (ANTI - 193)) | (1L << (LOCAL - 193)) | (1L << (INPATH - 193)) | (1L << (CURRENT_DATE - 193)) | (1L << (CURRENT_TIMESTAMP - 193)) | (1L << (EUCLID - 193)) | (1L << (DTW - 193)) | (1L << (FRECHET - 193)) | (1L << (EDR - 193)) | (1L << (LCSS - 193)) | (1L << (STRING - 193)) | (1L << (BIGINT_LITERAL - 193)) | (1L << (SMALLINT_LITERAL - 193)) | (1L << (TINYINT_LITERAL - 193)) | (1L << (INTEGER_VALUE - 193)) | (1L << (DECIMAL_VALUE - 193)) | (1L << (DOUBLE_LITERAL - 193)) | (1L << (BIGDECIMAL_LITERAL - 193)) | (1L << (IDENTIFIER - 193)) | (1L << (BACKQUOTED_IDENTIFIER - 193)))) != 0)) {
					{
					setState(2028);
					((StructContext)_localctx).namedExpression = namedExpression();
					((StructContext)_localctx).argument.add(((StructContext)_localctx).namedExpression);
					setState(2033);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(2029);
						match(T__2);
						setState(2030);
						((StructContext)_localctx).namedExpression = namedExpression();
						((StructContext)_localctx).argument.add(((StructContext)_localctx).namedExpression);
						}
						}
						setState(2035);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(2038);
				match(T__1);
				}
				break;
			case 6:
				{
				_localctx = new FirstContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2039);
				match(FIRST);
				setState(2040);
				match(T__0);
				setState(2041);
				expression();
				setState(2044);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGNORE) {
					{
					setState(2042);
					match(IGNORE);
					setState(2043);
					match(NULLS);
					}
				}

				setState(2046);
				match(T__1);
				}
				break;
			case 7:
				{
				_localctx = new LastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2048);
				match(LAST);
				setState(2049);
				match(T__0);
				setState(2050);
				expression();
				setState(2053);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGNORE) {
					{
					setState(2051);
					match(IGNORE);
					setState(2052);
					match(NULLS);
					}
				}

				setState(2055);
				match(T__1);
				}
				break;
			case 8:
				{
				_localctx = new ConstantDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2057);
				constant();
				}
				break;
			case 9:
				{
				_localctx = new StarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2058);
				match(ASTERISK);
				}
				break;
			case 10:
				{
				_localctx = new StarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2059);
				qualifiedName();
				setState(2060);
				match(T__3);
				setState(2061);
				match(ASTERISK);
				}
				break;
			case 11:
				{
				_localctx = new RowConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2063);
				match(T__0);
				setState(2064);
				namedExpression();
				setState(2067); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2065);
					match(T__2);
					setState(2066);
					namedExpression();
					}
					}
					setState(2069); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__2 );
				setState(2071);
				match(T__1);
				}
				break;
			case 12:
				{
				_localctx = new SubqueryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2073);
				match(T__0);
				setState(2074);
				query();
				setState(2075);
				match(T__1);
				}
				break;
			case 13:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2077);
				qualifiedName();
				setState(2078);
				match(T__0);
				setState(2090);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL) | (1L << ON) | (1L << LATERAL) | (1L << WINDOW) | (1L << OVER) | (1L << PARTITION))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (PLUS - 129)) | (1L << (MINUS - 129)) | (1L << (ASTERISK - 129)) | (1L << (DIV - 129)) | (1L << (TILDE - 129)) | (1L << (PERCENTLIT - 129)) | (1L << (BUCKET - 129)) | (1L << (OUT - 129)) | (1L << (OF - 129)) | (1L << (SORT - 129)) | (1L << (CLUSTER - 129)) | (1L << (DISTRIBUTE - 129)) | (1L << (OVERWRITE - 129)) | (1L << (TRANSFORM - 129)) | (1L << (REDUCE - 129)) | (1L << (USING - 129)) | (1L << (SERDE - 129)) | (1L << (SERDEPROPERTIES - 129)) | (1L << (RECORDREADER - 129)) | (1L << (RECORDWRITER - 129)) | (1L << (DELIMITED - 129)) | (1L << (FIELDS - 129)) | (1L << (TERMINATED - 129)) | (1L << (COLLECTION - 129)) | (1L << (ITEMS - 129)) | (1L << (KEYS - 129)) | (1L << (ESCAPED - 129)) | (1L << (LINES - 129)) | (1L << (SEPARATED - 129)) | (1L << (FUNCTION - 129)) | (1L << (EXTENDED - 129)) | (1L << (REFRESH - 129)) | (1L << (CLEAR - 129)) | (1L << (CACHE - 129)) | (1L << (UNCACHE - 129)) | (1L << (LAZY - 129)) | (1L << (FORMATTED - 129)) | (1L << (GLOBAL - 129)) | (1L << (TEMPORARY - 129)) | (1L << (OPTIONS - 129)) | (1L << (UNSET - 129)) | (1L << (TBLPROPERTIES - 129)) | (1L << (DBPROPERTIES - 129)) | (1L << (BUCKETS - 129)) | (1L << (SKEWED - 129)) | (1L << (STORED - 129)) | (1L << (DIRECTORIES - 129)) | (1L << (LOCATION - 129)) | (1L << (EXCHANGE - 129)) | (1L << (ARCHIVE - 129)) | (1L << (UNARCHIVE - 129)) | (1L << (FILEFORMAT - 129)) | (1L << (TOUCH - 129)) | (1L << (COMPACT - 129)) | (1L << (CONCATENATE - 129)) | (1L << (CHANGE - 129)) | (1L << (CASCADE - 129)) | (1L << (RESTRICT - 129)) | (1L << (CLUSTERED - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (SORTED - 193)) | (1L << (PURGE - 193)) | (1L << (INPUTFORMAT - 193)) | (1L << (OUTPUTFORMAT - 193)) | (1L << (DATABASE - 193)) | (1L << (DATABASES - 193)) | (1L << (DFS - 193)) | (1L << (TRUNCATE - 193)) | (1L << (ANALYZE - 193)) | (1L << (COMPUTE - 193)) | (1L << (LIST - 193)) | (1L << (STATISTICS - 193)) | (1L << (PARTITIONED - 193)) | (1L << (EXTERNAL - 193)) | (1L << (DEFINED - 193)) | (1L << (REVOKE - 193)) | (1L << (GRANT - 193)) | (1L << (LOCK - 193)) | (1L << (UNLOCK - 193)) | (1L << (MSCK - 193)) | (1L << (REPAIR - 193)) | (1L << (RECOVER - 193)) | (1L << (EXPORT - 193)) | (1L << (IMPORT - 193)) | (1L << (LOAD - 193)) | (1L << (ROLE - 193)) | (1L << (ROLES - 193)) | (1L << (COMPACTIONS - 193)) | (1L << (PRINCIPALS - 193)) | (1L << (TRANSACTIONS - 193)) | (1L << (INDEX - 193)) | (1L << (INDEXES - 193)) | (1L << (LOCKS - 193)) | (1L << (OPTION - 193)) | (1L << (ANTI - 193)) | (1L << (LOCAL - 193)) | (1L << (INPATH - 193)) | (1L << (CURRENT_DATE - 193)) | (1L << (CURRENT_TIMESTAMP - 193)) | (1L << (EUCLID - 193)) | (1L << (DTW - 193)) | (1L << (FRECHET - 193)) | (1L << (EDR - 193)) | (1L << (LCSS - 193)) | (1L << (STRING - 193)) | (1L << (BIGINT_LITERAL - 193)) | (1L << (SMALLINT_LITERAL - 193)) | (1L << (TINYINT_LITERAL - 193)) | (1L << (INTEGER_VALUE - 193)) | (1L << (DECIMAL_VALUE - 193)) | (1L << (DOUBLE_LITERAL - 193)) | (1L << (BIGDECIMAL_LITERAL - 193)) | (1L << (IDENTIFIER - 193)) | (1L << (BACKQUOTED_IDENTIFIER - 193)))) != 0)) {
					{
					setState(2080);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,271,_ctx) ) {
					case 1:
						{
						setState(2079);
						setQuantifier();
						}
						break;
					}
					setState(2082);
					((FunctionCallContext)_localctx).expression = expression();
					((FunctionCallContext)_localctx).argument.add(((FunctionCallContext)_localctx).expression);
					setState(2087);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(2083);
						match(T__2);
						setState(2084);
						((FunctionCallContext)_localctx).expression = expression();
						((FunctionCallContext)_localctx).argument.add(((FunctionCallContext)_localctx).expression);
						}
						}
						setState(2089);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(2092);
				match(T__1);
				setState(2095);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
				case 1:
					{
					setState(2093);
					match(OVER);
					setState(2094);
					windowSpec();
					}
					break;
				}
				}
				break;
			case 14:
				{
				_localctx = new ColumnReferenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2097);
				identifier();
				}
				break;
			case 15:
				{
				_localctx = new ParenthesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2098);
				match(T__0);
				setState(2099);
				expression();
				setState(2100);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(2114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,277,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2112);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,276,_ctx) ) {
					case 1:
						{
						_localctx = new SubscriptContext(new PrimaryExpressionContext(_parentctx, _parentState));
						((SubscriptContext)_localctx).value = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(2104);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(2105);
						match(T__6);
						setState(2106);
						((SubscriptContext)_localctx).index = valueExpression(0);
						setState(2107);
						match(T__7);
						}
						break;
					case 2:
						{
						_localctx = new DereferenceContext(new PrimaryExpressionContext(_parentctx, _parentState));
						((DereferenceContext)_localctx).base = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(2109);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2110);
						match(T__3);
						setState(2111);
						((DereferenceContext)_localctx).fieldName = identifier();
						}
						break;
					}
					} 
				}
				setState(2116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,277,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TrajectorySimilarityExpressionContext extends ParserRuleContext {
		public TrajectorySimilarityFunctionContext function;
		public PrimaryExpressionContext leftTable;
		public PrimaryExpressionContext rightTable;
		public TrajectoryExpressionContext leftTrajectory;
		public TrajectoryExpressionContext rightTrajectory;
		public TrajectorySimilarityFunctionContext trajectorySimilarityFunction() {
			return getRuleContext(TrajectorySimilarityFunctionContext.class,0);
		}
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public TrajectoryExpressionContext trajectoryExpression() {
			return getRuleContext(TrajectoryExpressionContext.class,0);
		}
		public TrajectorySimilarityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trajectorySimilarityExpression; }
	}

	public final TrajectorySimilarityExpressionContext trajectorySimilarityExpression() throws RecognitionException {
		TrajectorySimilarityExpressionContext _localctx = new TrajectorySimilarityExpressionContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_trajectorySimilarityExpression);
		try {
			setState(2138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,278,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2117);
				((TrajectorySimilarityExpressionContext)_localctx).function = trajectorySimilarityFunction();
				setState(2118);
				match(T__0);
				setState(2119);
				((TrajectorySimilarityExpressionContext)_localctx).leftTable = primaryExpression(0);
				setState(2120);
				match(T__2);
				setState(2121);
				((TrajectorySimilarityExpressionContext)_localctx).rightTable = primaryExpression(0);
				setState(2122);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2124);
				((TrajectorySimilarityExpressionContext)_localctx).function = trajectorySimilarityFunction();
				setState(2125);
				match(T__0);
				setState(2126);
				((TrajectorySimilarityExpressionContext)_localctx).leftTrajectory = trajectoryExpression();
				setState(2127);
				match(T__2);
				setState(2128);
				((TrajectorySimilarityExpressionContext)_localctx).rightTable = primaryExpression(0);
				setState(2129);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2131);
				((TrajectorySimilarityExpressionContext)_localctx).function = trajectorySimilarityFunction();
				setState(2132);
				match(T__0);
				setState(2133);
				((TrajectorySimilarityExpressionContext)_localctx).leftTable = primaryExpression(0);
				setState(2134);
				match(T__2);
				setState(2135);
				((TrajectorySimilarityExpressionContext)_localctx).rightTrajectory = trajectoryExpression();
				setState(2136);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointExpressionContext extends ParserRuleContext {
		public NumberContext number;
		public List<NumberContext> coords = new ArrayList<NumberContext>();
		public TerminalNode POINT() { return getToken(SqlBaseParser.POINT, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public PointExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointExpression; }
	}

	public final PointExpressionContext pointExpression() throws RecognitionException {
		PointExpressionContext _localctx = new PointExpressionContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_pointExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2140);
			match(POINT);
			setState(2141);
			match(T__0);
			setState(2142);
			((PointExpressionContext)_localctx).number = number();
			((PointExpressionContext)_localctx).coords.add(((PointExpressionContext)_localctx).number);
			setState(2147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(2143);
				match(T__2);
				setState(2144);
				((PointExpressionContext)_localctx).number = number();
				((PointExpressionContext)_localctx).coords.add(((PointExpressionContext)_localctx).number);
				}
				}
				setState(2149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2150);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TrajectoryExpressionContext extends ParserRuleContext {
		public PointExpressionContext pointExpression;
		public List<PointExpressionContext> points = new ArrayList<PointExpressionContext>();
		public TerminalNode TRAJECTORY() { return getToken(SqlBaseParser.TRAJECTORY, 0); }
		public List<PointExpressionContext> pointExpression() {
			return getRuleContexts(PointExpressionContext.class);
		}
		public PointExpressionContext pointExpression(int i) {
			return getRuleContext(PointExpressionContext.class,i);
		}
		public TrajectoryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trajectoryExpression; }
	}

	public final TrajectoryExpressionContext trajectoryExpression() throws RecognitionException {
		TrajectoryExpressionContext _localctx = new TrajectoryExpressionContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_trajectoryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2152);
			match(TRAJECTORY);
			setState(2153);
			match(T__0);
			setState(2154);
			((TrajectoryExpressionContext)_localctx).pointExpression = pointExpression();
			((TrajectoryExpressionContext)_localctx).points.add(((TrajectoryExpressionContext)_localctx).pointExpression);
			setState(2159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(2155);
				match(T__2);
				setState(2156);
				((TrajectoryExpressionContext)_localctx).pointExpression = pointExpression();
				((TrajectoryExpressionContext)_localctx).points.add(((TrajectoryExpressionContext)_localctx).pointExpression);
				}
				}
				setState(2161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2162);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetricSimilarityExpressionContext extends ParserRuleContext {
		public MetricSimilarityFunctionContext function;
		public PrimaryExpressionContext leftTable;
		public PrimaryExpressionContext rightTable;
		public MetricExpressionContext leftTrajectory;
		public MetricExpressionContext rightTrajectory;
		public MetricSimilarityFunctionContext metricSimilarityFunction() {
			return getRuleContext(MetricSimilarityFunctionContext.class,0);
		}
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public MetricExpressionContext metricExpression() {
			return getRuleContext(MetricExpressionContext.class,0);
		}
		public MetricSimilarityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metricSimilarityExpression; }
	}

	public final MetricSimilarityExpressionContext metricSimilarityExpression() throws RecognitionException {
		MetricSimilarityExpressionContext _localctx = new MetricSimilarityExpressionContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_metricSimilarityExpression);
		try {
			setState(2185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,281,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2164);
				((MetricSimilarityExpressionContext)_localctx).function = metricSimilarityFunction();
				setState(2165);
				match(T__0);
				setState(2166);
				((MetricSimilarityExpressionContext)_localctx).leftTable = primaryExpression(0);
				setState(2167);
				match(T__2);
				setState(2168);
				((MetricSimilarityExpressionContext)_localctx).rightTable = primaryExpression(0);
				setState(2169);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2171);
				((MetricSimilarityExpressionContext)_localctx).function = metricSimilarityFunction();
				setState(2172);
				match(T__0);
				setState(2173);
				((MetricSimilarityExpressionContext)_localctx).leftTrajectory = metricExpression();
				setState(2174);
				match(T__2);
				setState(2175);
				((MetricSimilarityExpressionContext)_localctx).rightTable = primaryExpression(0);
				setState(2176);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2178);
				((MetricSimilarityExpressionContext)_localctx).function = metricSimilarityFunction();
				setState(2179);
				match(T__0);
				setState(2180);
				((MetricSimilarityExpressionContext)_localctx).leftTable = primaryExpression(0);
				setState(2181);
				match(T__2);
				setState(2182);
				((MetricSimilarityExpressionContext)_localctx).rightTrajectory = metricExpression();
				setState(2183);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetricPointExpressionContext extends ParserRuleContext {
		public NumberContext number;
		public List<NumberContext> coords = new ArrayList<NumberContext>();
		public TerminalNode METRICPOINT() { return getToken(SqlBaseParser.METRICPOINT, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public MetricPointExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metricPointExpression; }
	}

	public final MetricPointExpressionContext metricPointExpression() throws RecognitionException {
		MetricPointExpressionContext _localctx = new MetricPointExpressionContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_metricPointExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2187);
			match(METRICPOINT);
			setState(2188);
			match(T__0);
			setState(2189);
			((MetricPointExpressionContext)_localctx).number = number();
			((MetricPointExpressionContext)_localctx).coords.add(((MetricPointExpressionContext)_localctx).number);
			setState(2194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(2190);
				match(T__2);
				setState(2191);
				((MetricPointExpressionContext)_localctx).number = number();
				((MetricPointExpressionContext)_localctx).coords.add(((MetricPointExpressionContext)_localctx).number);
				}
				}
				setState(2196);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2197);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetricExpressionContext extends ParserRuleContext {
		public MetricPointExpressionContext metricPointExpression;
		public List<MetricPointExpressionContext> points = new ArrayList<MetricPointExpressionContext>();
		public TerminalNode METRIC() { return getToken(SqlBaseParser.METRIC, 0); }
		public List<MetricPointExpressionContext> metricPointExpression() {
			return getRuleContexts(MetricPointExpressionContext.class);
		}
		public MetricPointExpressionContext metricPointExpression(int i) {
			return getRuleContext(MetricPointExpressionContext.class,i);
		}
		public MetricExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metricExpression; }
	}

	public final MetricExpressionContext metricExpression() throws RecognitionException {
		MetricExpressionContext _localctx = new MetricExpressionContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_metricExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2199);
			match(METRIC);
			setState(2200);
			match(T__0);
			setState(2201);
			((MetricExpressionContext)_localctx).metricPointExpression = metricPointExpression();
			((MetricExpressionContext)_localctx).points.add(((MetricExpressionContext)_localctx).metricPointExpression);
			setState(2206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(2202);
				match(T__2);
				setState(2203);
				((MetricExpressionContext)_localctx).metricPointExpression = metricPointExpression();
				((MetricExpressionContext)_localctx).points.add(((MetricExpressionContext)_localctx).metricPointExpression);
				}
				}
				setState(2208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2209);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	 
		public ConstantContext() { }
		public void copyFrom(ConstantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NullLiteralContext extends ConstantContext {
		public TerminalNode NULL() { return getToken(SqlBaseParser.NULL, 0); }
		public NullLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
	}
	public static class StringLiteralContext extends ConstantContext {
		public List<TerminalNode> STRING() { return getTokens(SqlBaseParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SqlBaseParser.STRING, i);
		}
		public StringLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
	}
	public static class TypeConstructorContext extends ConstantContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TypeConstructorContext(ConstantContext ctx) { copyFrom(ctx); }
	}
	public static class IntervalLiteralContext extends ConstantContext {
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public IntervalLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
	}
	public static class NumericLiteralContext extends ConstantContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumericLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanLiteralContext extends ConstantContext {
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public BooleanLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_constant);
		try {
			int _alt;
			setState(2223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
			case 1:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2211);
				match(NULL);
				}
				break;
			case 2:
				_localctx = new IntervalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2212);
				interval();
				}
				break;
			case 3:
				_localctx = new TypeConstructorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(2213);
				identifier();
				setState(2214);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new NumericLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(2216);
				number();
				}
				break;
			case 5:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(2217);
				booleanValue();
				}
				break;
			case 6:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(2219); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2218);
						match(STRING);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2221); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,284,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SqlBaseParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(SqlBaseParser.NEQ, 0); }
		public TerminalNode NEQJ() { return getToken(SqlBaseParser.NEQJ, 0); }
		public TerminalNode LT() { return getToken(SqlBaseParser.LT, 0); }
		public TerminalNode LTE() { return getToken(SqlBaseParser.LTE, 0); }
		public TerminalNode GT() { return getToken(SqlBaseParser.GT, 0); }
		public TerminalNode GTE() { return getToken(SqlBaseParser.GTE, 0); }
		public TerminalNode NSEQ() { return getToken(SqlBaseParser.NSEQ, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2225);
			_la = _input.LA(1);
			if ( !(((((_la - 121)) & ~0x3f) == 0 && ((1L << (_la - 121)) & ((1L << (EQ - 121)) | (1L << (NSEQ - 121)) | (1L << (NEQ - 121)) | (1L << (NEQJ - 121)) | (1L << (LT - 121)) | (1L << (LTE - 121)) | (1L << (GT - 121)) | (1L << (GTE - 121)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(SqlBaseParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public TerminalNode ASTERISK() { return getToken(SqlBaseParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(SqlBaseParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(SqlBaseParser.PERCENT, 0); }
		public TerminalNode DIV() { return getToken(SqlBaseParser.DIV, 0); }
		public TerminalNode TILDE() { return getToken(SqlBaseParser.TILDE, 0); }
		public TerminalNode AMPERSAND() { return getToken(SqlBaseParser.AMPERSAND, 0); }
		public TerminalNode PIPE() { return getToken(SqlBaseParser.PIPE, 0); }
		public TerminalNode HAT() { return getToken(SqlBaseParser.HAT, 0); }
		public ArithmeticOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticOperator; }
	}

	public final ArithmeticOperatorContext arithmeticOperator() throws RecognitionException {
		ArithmeticOperatorContext _localctx = new ArithmeticOperatorContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_arithmeticOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2227);
			_la = _input.LA(1);
			if ( !(((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (PLUS - 129)) | (1L << (MINUS - 129)) | (1L << (ASTERISK - 129)) | (1L << (SLASH - 129)) | (1L << (PERCENT - 129)) | (1L << (DIV - 129)) | (1L << (TILDE - 129)) | (1L << (AMPERSAND - 129)) | (1L << (PIPE - 129)) | (1L << (HAT - 129)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateOperatorContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(SqlBaseParser.OR, 0); }
		public TerminalNode AND() { return getToken(SqlBaseParser.AND, 0); }
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public PredicateOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateOperator; }
	}

	public final PredicateOperatorContext predicateOperator() throws RecognitionException {
		PredicateOperatorContext _localctx = new PredicateOperatorContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_predicateOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2229);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanValueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SqlBaseParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SqlBaseParser.FALSE, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_booleanValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2231);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalContext extends ParserRuleContext {
		public TerminalNode INTERVAL() { return getToken(SqlBaseParser.INTERVAL, 0); }
		public List<IntervalFieldContext> intervalField() {
			return getRuleContexts(IntervalFieldContext.class);
		}
		public IntervalFieldContext intervalField(int i) {
			return getRuleContext(IntervalFieldContext.class,i);
		}
		public IntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interval; }
	}

	public final IntervalContext interval() throws RecognitionException {
		IntervalContext _localctx = new IntervalContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_interval);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2233);
			match(INTERVAL);
			setState(2237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,286,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2234);
					intervalField();
					}
					} 
				}
				setState(2239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,286,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalFieldContext extends ParserRuleContext {
		public IntervalValueContext value;
		public IdentifierContext unit;
		public IdentifierContext to;
		public IntervalValueContext intervalValue() {
			return getRuleContext(IntervalValueContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode TO() { return getToken(SqlBaseParser.TO, 0); }
		public IntervalFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalField; }
	}

	public final IntervalFieldContext intervalField() throws RecognitionException {
		IntervalFieldContext _localctx = new IntervalFieldContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_intervalField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2240);
			((IntervalFieldContext)_localctx).value = intervalValue();
			setState(2241);
			((IntervalFieldContext)_localctx).unit = identifier();
			setState(2244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,287,_ctx) ) {
			case 1:
				{
				setState(2242);
				match(TO);
				setState(2243);
				((IntervalFieldContext)_localctx).to = identifier();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalValueContext extends ParserRuleContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlBaseParser.DECIMAL_VALUE, 0); }
		public TerminalNode PLUS() { return getToken(SqlBaseParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public IntervalValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalValue; }
	}

	public final IntervalValueContext intervalValue() throws RecognitionException {
		IntervalValueContext _localctx = new IntervalValueContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_intervalValue);
		int _la;
		try {
			setState(2251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case INTEGER_VALUE:
			case DECIMAL_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(2246);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(2249);
				_la = _input.LA(1);
				if ( !(_la==INTEGER_VALUE || _la==DECIMAL_VALUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(2250);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColPositionContext extends ParserRuleContext {
		public TerminalNode FIRST() { return getToken(SqlBaseParser.FIRST, 0); }
		public TerminalNode AFTER() { return getToken(SqlBaseParser.AFTER, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColPositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colPosition; }
	}

	public final ColPositionContext colPosition() throws RecognitionException {
		ColPositionContext _localctx = new ColPositionContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_colPosition);
		try {
			setState(2256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FIRST:
				enterOuterAlt(_localctx, 1);
				{
				setState(2253);
				match(FIRST);
				}
				break;
			case AFTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(2254);
				match(AFTER);
				setState(2255);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	 
		public DataTypeContext() { }
		public void copyFrom(DataTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComplexDataTypeContext extends DataTypeContext {
		public Token complex;
		public TerminalNode LT() { return getToken(SqlBaseParser.LT, 0); }
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public TerminalNode GT() { return getToken(SqlBaseParser.GT, 0); }
		public TerminalNode ARRAY() { return getToken(SqlBaseParser.ARRAY, 0); }
		public TerminalNode MAP() { return getToken(SqlBaseParser.MAP, 0); }
		public TerminalNode STRUCT() { return getToken(SqlBaseParser.STRUCT, 0); }
		public TerminalNode NEQ() { return getToken(SqlBaseParser.NEQ, 0); }
		public ComplexColTypeListContext complexColTypeList() {
			return getRuleContext(ComplexColTypeListContext.class,0);
		}
		public ComplexDataTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
	}
	public static class PrimitiveDataTypeContext extends DataTypeContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> INTEGER_VALUE() { return getTokens(SqlBaseParser.INTEGER_VALUE); }
		public TerminalNode INTEGER_VALUE(int i) {
			return getToken(SqlBaseParser.INTEGER_VALUE, i);
		}
		public PrimitiveDataTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_dataType);
		int _la;
		try {
			setState(2292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,295,_ctx) ) {
			case 1:
				_localctx = new ComplexDataTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2258);
				((ComplexDataTypeContext)_localctx).complex = match(ARRAY);
				setState(2259);
				match(LT);
				setState(2260);
				dataType();
				setState(2261);
				match(GT);
				}
				break;
			case 2:
				_localctx = new ComplexDataTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2263);
				((ComplexDataTypeContext)_localctx).complex = match(MAP);
				setState(2264);
				match(LT);
				setState(2265);
				dataType();
				setState(2266);
				match(T__2);
				setState(2267);
				dataType();
				setState(2268);
				match(GT);
				}
				break;
			case 3:
				_localctx = new ComplexDataTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(2270);
				((ComplexDataTypeContext)_localctx).complex = match(STRUCT);
				setState(2277);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LT:
					{
					setState(2271);
					match(LT);
					setState(2273);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL) | (1L << ON) | (1L << LATERAL) | (1L << WINDOW) | (1L << OVER) | (1L << PARTITION))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (DIV - 134)) | (1L << (PERCENTLIT - 134)) | (1L << (BUCKET - 134)) | (1L << (OUT - 134)) | (1L << (OF - 134)) | (1L << (SORT - 134)) | (1L << (CLUSTER - 134)) | (1L << (DISTRIBUTE - 134)) | (1L << (OVERWRITE - 134)) | (1L << (TRANSFORM - 134)) | (1L << (REDUCE - 134)) | (1L << (USING - 134)) | (1L << (SERDE - 134)) | (1L << (SERDEPROPERTIES - 134)) | (1L << (RECORDREADER - 134)) | (1L << (RECORDWRITER - 134)) | (1L << (DELIMITED - 134)) | (1L << (FIELDS - 134)) | (1L << (TERMINATED - 134)) | (1L << (COLLECTION - 134)) | (1L << (ITEMS - 134)) | (1L << (KEYS - 134)) | (1L << (ESCAPED - 134)) | (1L << (LINES - 134)) | (1L << (SEPARATED - 134)) | (1L << (FUNCTION - 134)) | (1L << (EXTENDED - 134)) | (1L << (REFRESH - 134)) | (1L << (CLEAR - 134)) | (1L << (CACHE - 134)) | (1L << (UNCACHE - 134)) | (1L << (LAZY - 134)) | (1L << (FORMATTED - 134)) | (1L << (GLOBAL - 134)) | (1L << (TEMPORARY - 134)) | (1L << (OPTIONS - 134)) | (1L << (UNSET - 134)) | (1L << (TBLPROPERTIES - 134)) | (1L << (DBPROPERTIES - 134)) | (1L << (BUCKETS - 134)) | (1L << (SKEWED - 134)) | (1L << (STORED - 134)) | (1L << (DIRECTORIES - 134)) | (1L << (LOCATION - 134)) | (1L << (EXCHANGE - 134)) | (1L << (ARCHIVE - 134)) | (1L << (UNARCHIVE - 134)) | (1L << (FILEFORMAT - 134)) | (1L << (TOUCH - 134)) | (1L << (COMPACT - 134)) | (1L << (CONCATENATE - 134)) | (1L << (CHANGE - 134)) | (1L << (CASCADE - 134)) | (1L << (RESTRICT - 134)) | (1L << (CLUSTERED - 134)) | (1L << (SORTED - 134)) | (1L << (PURGE - 134)) | (1L << (INPUTFORMAT - 134)) | (1L << (OUTPUTFORMAT - 134)) | (1L << (DATABASE - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (DATABASES - 198)) | (1L << (DFS - 198)) | (1L << (TRUNCATE - 198)) | (1L << (ANALYZE - 198)) | (1L << (COMPUTE - 198)) | (1L << (LIST - 198)) | (1L << (STATISTICS - 198)) | (1L << (PARTITIONED - 198)) | (1L << (EXTERNAL - 198)) | (1L << (DEFINED - 198)) | (1L << (REVOKE - 198)) | (1L << (GRANT - 198)) | (1L << (LOCK - 198)) | (1L << (UNLOCK - 198)) | (1L << (MSCK - 198)) | (1L << (REPAIR - 198)) | (1L << (RECOVER - 198)) | (1L << (EXPORT - 198)) | (1L << (IMPORT - 198)) | (1L << (LOAD - 198)) | (1L << (ROLE - 198)) | (1L << (ROLES - 198)) | (1L << (COMPACTIONS - 198)) | (1L << (PRINCIPALS - 198)) | (1L << (TRANSACTIONS - 198)) | (1L << (INDEX - 198)) | (1L << (INDEXES - 198)) | (1L << (LOCKS - 198)) | (1L << (OPTION - 198)) | (1L << (ANTI - 198)) | (1L << (LOCAL - 198)) | (1L << (INPATH - 198)) | (1L << (CURRENT_DATE - 198)) | (1L << (CURRENT_TIMESTAMP - 198)) | (1L << (IDENTIFIER - 198)) | (1L << (BACKQUOTED_IDENTIFIER - 198)))) != 0)) {
						{
						setState(2272);
						complexColTypeList();
						}
					}

					setState(2275);
					match(GT);
					}
					break;
				case NEQ:
					{
					setState(2276);
					match(NEQ);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				_localctx = new PrimitiveDataTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(2279);
				identifier();
				setState(2290);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,294,_ctx) ) {
				case 1:
					{
					setState(2280);
					match(T__0);
					setState(2281);
					match(INTEGER_VALUE);
					setState(2286);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(2282);
						match(T__2);
						setState(2283);
						match(INTEGER_VALUE);
						}
						}
						setState(2288);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2289);
					match(T__1);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColTypeListContext extends ParserRuleContext {
		public List<ColTypeContext> colType() {
			return getRuleContexts(ColTypeContext.class);
		}
		public ColTypeContext colType(int i) {
			return getRuleContext(ColTypeContext.class,i);
		}
		public ColTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colTypeList; }
	}

	public final ColTypeListContext colTypeList() throws RecognitionException {
		ColTypeListContext _localctx = new ColTypeListContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_colTypeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2294);
			colType();
			setState(2299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,296,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2295);
					match(T__2);
					setState(2296);
					colType();
					}
					} 
				}
				setState(2301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,296,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlBaseParser.COMMENT, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public ColTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colType; }
	}

	public final ColTypeContext colType() throws RecognitionException {
		ColTypeContext _localctx = new ColTypeContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_colType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2302);
			identifier();
			setState(2303);
			dataType();
			setState(2306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,297,_ctx) ) {
			case 1:
				{
				setState(2304);
				match(COMMENT);
				setState(2305);
				match(STRING);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComplexColTypeListContext extends ParserRuleContext {
		public List<ComplexColTypeContext> complexColType() {
			return getRuleContexts(ComplexColTypeContext.class);
		}
		public ComplexColTypeContext complexColType(int i) {
			return getRuleContext(ComplexColTypeContext.class,i);
		}
		public ComplexColTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexColTypeList; }
	}

	public final ComplexColTypeListContext complexColTypeList() throws RecognitionException {
		ComplexColTypeListContext _localctx = new ComplexColTypeListContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_complexColTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2308);
			complexColType();
			setState(2313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(2309);
				match(T__2);
				setState(2310);
				complexColType();
				}
				}
				setState(2315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComplexColTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlBaseParser.COMMENT, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public ComplexColTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexColType; }
	}

	public final ComplexColTypeContext complexColType() throws RecognitionException {
		ComplexColTypeContext _localctx = new ComplexColTypeContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_complexColType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2316);
			identifier();
			setState(2317);
			match(T__8);
			setState(2318);
			dataType();
			setState(2321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(2319);
				match(COMMENT);
				setState(2320);
				match(STRING);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenClauseContext extends ParserRuleContext {
		public ExpressionContext condition;
		public ExpressionContext result;
		public TerminalNode WHEN() { return getToken(SqlBaseParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(SqlBaseParser.THEN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public WhenClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenClause; }
	}

	public final WhenClauseContext whenClause() throws RecognitionException {
		WhenClauseContext _localctx = new WhenClauseContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_whenClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2323);
			match(WHEN);
			setState(2324);
			((WhenClauseContext)_localctx).condition = expression();
			setState(2325);
			match(THEN);
			setState(2326);
			((WhenClauseContext)_localctx).result = expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowsContext extends ParserRuleContext {
		public TerminalNode WINDOW() { return getToken(SqlBaseParser.WINDOW, 0); }
		public List<NamedWindowContext> namedWindow() {
			return getRuleContexts(NamedWindowContext.class);
		}
		public NamedWindowContext namedWindow(int i) {
			return getRuleContext(NamedWindowContext.class,i);
		}
		public WindowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windows; }
	}

	public final WindowsContext windows() throws RecognitionException {
		WindowsContext _localctx = new WindowsContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_windows);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2328);
			match(WINDOW);
			setState(2329);
			namedWindow();
			setState(2334);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,300,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2330);
					match(T__2);
					setState(2331);
					namedWindow();
					}
					} 
				}
				setState(2336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,300,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedWindowContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public WindowSpecContext windowSpec() {
			return getRuleContext(WindowSpecContext.class,0);
		}
		public NamedWindowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedWindow; }
	}

	public final NamedWindowContext namedWindow() throws RecognitionException {
		NamedWindowContext _localctx = new NamedWindowContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_namedWindow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2337);
			identifier();
			setState(2338);
			match(AS);
			setState(2339);
			windowSpec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowSpecContext extends ParserRuleContext {
		public WindowSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowSpec; }
	 
		public WindowSpecContext() { }
		public void copyFrom(WindowSpecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WindowRefContext extends WindowSpecContext {
		public IdentifierContext name;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public WindowRefContext(WindowSpecContext ctx) { copyFrom(ctx); }
	}
	public static class WindowDefContext extends WindowSpecContext {
		public ExpressionContext expression;
		public List<ExpressionContext> partition = new ArrayList<ExpressionContext>();
		public TerminalNode CLUSTER() { return getToken(SqlBaseParser.CLUSTER, 0); }
		public List<TerminalNode> BY() { return getTokens(SqlBaseParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SqlBaseParser.BY, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public WindowFrameContext windowFrame() {
			return getRuleContext(WindowFrameContext.class,0);
		}
		public List<SortItemContext> sortItem() {
			return getRuleContexts(SortItemContext.class);
		}
		public SortItemContext sortItem(int i) {
			return getRuleContext(SortItemContext.class,i);
		}
		public TerminalNode PARTITION() { return getToken(SqlBaseParser.PARTITION, 0); }
		public TerminalNode DISTRIBUTE() { return getToken(SqlBaseParser.DISTRIBUTE, 0); }
		public TerminalNode ORDER() { return getToken(SqlBaseParser.ORDER, 0); }
		public TerminalNode SORT() { return getToken(SqlBaseParser.SORT, 0); }
		public WindowDefContext(WindowSpecContext ctx) { copyFrom(ctx); }
	}

	public final WindowSpecContext windowSpec() throws RecognitionException {
		WindowSpecContext _localctx = new WindowSpecContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_windowSpec);
		int _la;
		try {
			setState(2383);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
			case FROM:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case JOIN:
			case CROSS:
			case OUTER:
			case INNER:
			case LEFT:
			case SEMI:
			case RIGHT:
			case FULL:
			case NATURAL:
			case ON:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case UNION:
			case EXCEPT:
			case SETMINUS:
			case INTERSECT:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case IF:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case USING:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case ANTI:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
			case IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				_localctx = new WindowRefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2341);
				((WindowRefContext)_localctx).name = identifier();
				}
				break;
			case T__0:
				_localctx = new WindowDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2342);
				match(T__0);
				setState(2377);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CLUSTER:
					{
					setState(2343);
					match(CLUSTER);
					setState(2344);
					match(BY);
					setState(2345);
					((WindowDefContext)_localctx).expression = expression();
					((WindowDefContext)_localctx).partition.add(((WindowDefContext)_localctx).expression);
					setState(2350);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(2346);
						match(T__2);
						setState(2347);
						((WindowDefContext)_localctx).expression = expression();
						((WindowDefContext)_localctx).partition.add(((WindowDefContext)_localctx).expression);
						}
						}
						setState(2352);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case T__1:
				case ORDER:
				case PARTITION:
				case RANGE:
				case ROWS:
				case SORT:
				case DISTRIBUTE:
					{
					setState(2363);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PARTITION || _la==DISTRIBUTE) {
						{
						setState(2353);
						_la = _input.LA(1);
						if ( !(_la==PARTITION || _la==DISTRIBUTE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(2354);
						match(BY);
						setState(2355);
						((WindowDefContext)_localctx).expression = expression();
						((WindowDefContext)_localctx).partition.add(((WindowDefContext)_localctx).expression);
						setState(2360);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(2356);
							match(T__2);
							setState(2357);
							((WindowDefContext)_localctx).expression = expression();
							((WindowDefContext)_localctx).partition.add(((WindowDefContext)_localctx).expression);
							}
							}
							setState(2362);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(2375);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ORDER || _la==SORT) {
						{
						setState(2365);
						_la = _input.LA(1);
						if ( !(_la==ORDER || _la==SORT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(2366);
						match(BY);
						setState(2367);
						sortItem();
						setState(2372);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(2368);
							match(T__2);
							setState(2369);
							sortItem();
							}
							}
							setState(2374);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2380);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RANGE || _la==ROWS) {
					{
					setState(2379);
					windowFrame();
					}
				}

				setState(2382);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameContext extends ParserRuleContext {
		public Token frameType;
		public FrameBoundContext start;
		public FrameBoundContext end;
		public TerminalNode RANGE() { return getToken(SqlBaseParser.RANGE, 0); }
		public List<FrameBoundContext> frameBound() {
			return getRuleContexts(FrameBoundContext.class);
		}
		public FrameBoundContext frameBound(int i) {
			return getRuleContext(FrameBoundContext.class,i);
		}
		public TerminalNode ROWS() { return getToken(SqlBaseParser.ROWS, 0); }
		public TerminalNode BETWEEN() { return getToken(SqlBaseParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(SqlBaseParser.AND, 0); }
		public WindowFrameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrame; }
	}

	public final WindowFrameContext windowFrame() throws RecognitionException {
		WindowFrameContext _localctx = new WindowFrameContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_windowFrame);
		try {
			setState(2401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,309,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2385);
				((WindowFrameContext)_localctx).frameType = match(RANGE);
				setState(2386);
				((WindowFrameContext)_localctx).start = frameBound();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2387);
				((WindowFrameContext)_localctx).frameType = match(ROWS);
				setState(2388);
				((WindowFrameContext)_localctx).start = frameBound();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2389);
				((WindowFrameContext)_localctx).frameType = match(RANGE);
				setState(2390);
				match(BETWEEN);
				setState(2391);
				((WindowFrameContext)_localctx).start = frameBound();
				setState(2392);
				match(AND);
				setState(2393);
				((WindowFrameContext)_localctx).end = frameBound();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2395);
				((WindowFrameContext)_localctx).frameType = match(ROWS);
				setState(2396);
				match(BETWEEN);
				setState(2397);
				((WindowFrameContext)_localctx).start = frameBound();
				setState(2398);
				match(AND);
				setState(2399);
				((WindowFrameContext)_localctx).end = frameBound();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FrameBoundContext extends ParserRuleContext {
		public Token boundType;
		public TerminalNode UNBOUNDED() { return getToken(SqlBaseParser.UNBOUNDED, 0); }
		public TerminalNode PRECEDING() { return getToken(SqlBaseParser.PRECEDING, 0); }
		public TerminalNode FOLLOWING() { return getToken(SqlBaseParser.FOLLOWING, 0); }
		public TerminalNode ROW() { return getToken(SqlBaseParser.ROW, 0); }
		public TerminalNode CURRENT() { return getToken(SqlBaseParser.CURRENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FrameBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frameBound; }
	}

	public final FrameBoundContext frameBound() throws RecognitionException {
		FrameBoundContext _localctx = new FrameBoundContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_frameBound);
		int _la;
		try {
			setState(2410);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,310,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2403);
				match(UNBOUNDED);
				setState(2404);
				((FrameBoundContext)_localctx).boundType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PRECEDING || _la==FOLLOWING) ) {
					((FrameBoundContext)_localctx).boundType = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2405);
				((FrameBoundContext)_localctx).boundType = match(CURRENT);
				setState(2406);
				match(ROW);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2407);
				expression();
				setState(2408);
				((FrameBoundContext)_localctx).boundType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PRECEDING || _la==FOLLOWING) ) {
					((FrameBoundContext)_localctx).boundType = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2412);
			identifier();
			setState(2417);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,311,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2413);
					match(T__3);
					setState(2414);
					identifier();
					}
					} 
				}
				setState(2419);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,311,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public StrictIdentifierContext strictIdentifier() {
			return getRuleContext(StrictIdentifierContext.class,0);
		}
		public TerminalNode ANTI() { return getToken(SqlBaseParser.ANTI, 0); }
		public TerminalNode FULL() { return getToken(SqlBaseParser.FULL, 0); }
		public TerminalNode INNER() { return getToken(SqlBaseParser.INNER, 0); }
		public TerminalNode LEFT() { return getToken(SqlBaseParser.LEFT, 0); }
		public TerminalNode SEMI() { return getToken(SqlBaseParser.SEMI, 0); }
		public TerminalNode RIGHT() { return getToken(SqlBaseParser.RIGHT, 0); }
		public TerminalNode NATURAL() { return getToken(SqlBaseParser.NATURAL, 0); }
		public TerminalNode JOIN() { return getToken(SqlBaseParser.JOIN, 0); }
		public TerminalNode CROSS() { return getToken(SqlBaseParser.CROSS, 0); }
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public TerminalNode UNION() { return getToken(SqlBaseParser.UNION, 0); }
		public TerminalNode INTERSECT() { return getToken(SqlBaseParser.INTERSECT, 0); }
		public TerminalNode EXCEPT() { return getToken(SqlBaseParser.EXCEPT, 0); }
		public TerminalNode SETMINUS() { return getToken(SqlBaseParser.SETMINUS, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_identifier);
		try {
			setState(2435);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
			case FROM:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case OUTER:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case IF:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case USING:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
			case IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2420);
				strictIdentifier();
				}
				break;
			case ANTI:
				enterOuterAlt(_localctx, 2);
				{
				setState(2421);
				match(ANTI);
				}
				break;
			case FULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2422);
				match(FULL);
				}
				break;
			case INNER:
				enterOuterAlt(_localctx, 4);
				{
				setState(2423);
				match(INNER);
				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2424);
				match(LEFT);
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 6);
				{
				setState(2425);
				match(SEMI);
				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2426);
				match(RIGHT);
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 8);
				{
				setState(2427);
				match(NATURAL);
				}
				break;
			case JOIN:
				enterOuterAlt(_localctx, 9);
				{
				setState(2428);
				match(JOIN);
				}
				break;
			case CROSS:
				enterOuterAlt(_localctx, 10);
				{
				setState(2429);
				match(CROSS);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 11);
				{
				setState(2430);
				match(ON);
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 12);
				{
				setState(2431);
				match(UNION);
				}
				break;
			case INTERSECT:
				enterOuterAlt(_localctx, 13);
				{
				setState(2432);
				match(INTERSECT);
				}
				break;
			case EXCEPT:
				enterOuterAlt(_localctx, 14);
				{
				setState(2433);
				match(EXCEPT);
				}
				break;
			case SETMINUS:
				enterOuterAlt(_localctx, 15);
				{
				setState(2434);
				match(SETMINUS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrictIdentifierContext extends ParserRuleContext {
		public StrictIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strictIdentifier; }
	 
		public StrictIdentifierContext() { }
		public void copyFrom(StrictIdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QuotedIdentifierAlternativeContext extends StrictIdentifierContext {
		public QuotedIdentifierContext quotedIdentifier() {
			return getRuleContext(QuotedIdentifierContext.class,0);
		}
		public QuotedIdentifierAlternativeContext(StrictIdentifierContext ctx) { copyFrom(ctx); }
	}
	public static class UnquotedIdentifierContext extends StrictIdentifierContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlBaseParser.IDENTIFIER, 0); }
		public NonReservedContext nonReserved() {
			return getRuleContext(NonReservedContext.class,0);
		}
		public UnquotedIdentifierContext(StrictIdentifierContext ctx) { copyFrom(ctx); }
	}

	public final StrictIdentifierContext strictIdentifier() throws RecognitionException {
		StrictIdentifierContext _localctx = new StrictIdentifierContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_strictIdentifier);
		try {
			setState(2440);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2437);
				match(IDENTIFIER);
				}
				break;
			case BACKQUOTED_IDENTIFIER:
				_localctx = new QuotedIdentifierAlternativeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2438);
				quotedIdentifier();
				}
				break;
			case SELECT:
			case FROM:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case OUTER:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case IF:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case USING:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(2439);
				nonReserved();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuotedIdentifierContext extends ParserRuleContext {
		public TerminalNode BACKQUOTED_IDENTIFIER() { return getToken(SqlBaseParser.BACKQUOTED_IDENTIFIER, 0); }
		public QuotedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedIdentifier; }
	}

	public final QuotedIdentifierContext quotedIdentifier() throws RecognitionException {
		QuotedIdentifierContext _localctx = new QuotedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_quotedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2442);
			match(BACKQUOTED_IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecimalLiteralContext extends NumberContext {
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlBaseParser.DECIMAL_VALUE, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public DecimalLiteralContext(NumberContext ctx) { copyFrom(ctx); }
	}
	public static class BigIntLiteralContext extends NumberContext {
		public TerminalNode BIGINT_LITERAL() { return getToken(SqlBaseParser.BIGINT_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public BigIntLiteralContext(NumberContext ctx) { copyFrom(ctx); }
	}
	public static class TinyIntLiteralContext extends NumberContext {
		public TerminalNode TINYINT_LITERAL() { return getToken(SqlBaseParser.TINYINT_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public TinyIntLiteralContext(NumberContext ctx) { copyFrom(ctx); }
	}
	public static class BigDecimalLiteralContext extends NumberContext {
		public TerminalNode BIGDECIMAL_LITERAL() { return getToken(SqlBaseParser.BIGDECIMAL_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public BigDecimalLiteralContext(NumberContext ctx) { copyFrom(ctx); }
	}
	public static class DoubleLiteralContext extends NumberContext {
		public TerminalNode DOUBLE_LITERAL() { return getToken(SqlBaseParser.DOUBLE_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public DoubleLiteralContext(NumberContext ctx) { copyFrom(ctx); }
	}
	public static class IntegerLiteralContext extends NumberContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public IntegerLiteralContext(NumberContext ctx) { copyFrom(ctx); }
	}
	public static class SmallIntLiteralContext extends NumberContext {
		public TerminalNode SMALLINT_LITERAL() { return getToken(SqlBaseParser.SMALLINT_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public SmallIntLiteralContext(NumberContext ctx) { copyFrom(ctx); }
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_number);
		int _la;
		try {
			setState(2472);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,321,_ctx) ) {
			case 1:
				_localctx = new DecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2444);
					match(MINUS);
					}
				}

				setState(2447);
				match(DECIMAL_VALUE);
				}
				break;
			case 2:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2448);
					match(MINUS);
					}
				}

				setState(2451);
				match(INTEGER_VALUE);
				}
				break;
			case 3:
				_localctx = new BigIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(2453);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2452);
					match(MINUS);
					}
				}

				setState(2455);
				match(BIGINT_LITERAL);
				}
				break;
			case 4:
				_localctx = new SmallIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(2457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2456);
					match(MINUS);
					}
				}

				setState(2459);
				match(SMALLINT_LITERAL);
				}
				break;
			case 5:
				_localctx = new TinyIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(2461);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2460);
					match(MINUS);
					}
				}

				setState(2463);
				match(TINYINT_LITERAL);
				}
				break;
			case 6:
				_localctx = new DoubleLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(2465);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2464);
					match(MINUS);
					}
				}

				setState(2467);
				match(DOUBLE_LITERAL);
				}
				break;
			case 7:
				_localctx = new BigDecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(2469);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2468);
					match(MINUS);
					}
				}

				setState(2471);
				match(BIGDECIMAL_LITERAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonReservedContext extends ParserRuleContext {
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode TABLES() { return getToken(SqlBaseParser.TABLES, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlBaseParser.COLUMNS, 0); }
		public TerminalNode COLUMN() { return getToken(SqlBaseParser.COLUMN, 0); }
		public TerminalNode PARTITIONS() { return getToken(SqlBaseParser.PARTITIONS, 0); }
		public TerminalNode FUNCTIONS() { return getToken(SqlBaseParser.FUNCTIONS, 0); }
		public TerminalNode DATABASES() { return getToken(SqlBaseParser.DATABASES, 0); }
		public TerminalNode ADD() { return getToken(SqlBaseParser.ADD, 0); }
		public TerminalNode OVER() { return getToken(SqlBaseParser.OVER, 0); }
		public TerminalNode PARTITION() { return getToken(SqlBaseParser.PARTITION, 0); }
		public TerminalNode RANGE() { return getToken(SqlBaseParser.RANGE, 0); }
		public TerminalNode ROWS() { return getToken(SqlBaseParser.ROWS, 0); }
		public TerminalNode PRECEDING() { return getToken(SqlBaseParser.PRECEDING, 0); }
		public TerminalNode FOLLOWING() { return getToken(SqlBaseParser.FOLLOWING, 0); }
		public TerminalNode CURRENT() { return getToken(SqlBaseParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SqlBaseParser.ROW, 0); }
		public TerminalNode LAST() { return getToken(SqlBaseParser.LAST, 0); }
		public TerminalNode FIRST() { return getToken(SqlBaseParser.FIRST, 0); }
		public TerminalNode AFTER() { return getToken(SqlBaseParser.AFTER, 0); }
		public TerminalNode MAP() { return getToken(SqlBaseParser.MAP, 0); }
		public TerminalNode ARRAY() { return getToken(SqlBaseParser.ARRAY, 0); }
		public TerminalNode STRUCT() { return getToken(SqlBaseParser.STRUCT, 0); }
		public TerminalNode LATERAL() { return getToken(SqlBaseParser.LATERAL, 0); }
		public TerminalNode WINDOW() { return getToken(SqlBaseParser.WINDOW, 0); }
		public TerminalNode REDUCE() { return getToken(SqlBaseParser.REDUCE, 0); }
		public TerminalNode TRANSFORM() { return getToken(SqlBaseParser.TRANSFORM, 0); }
		public TerminalNode USING() { return getToken(SqlBaseParser.USING, 0); }
		public TerminalNode SERDE() { return getToken(SqlBaseParser.SERDE, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(SqlBaseParser.SERDEPROPERTIES, 0); }
		public TerminalNode RECORDREADER() { return getToken(SqlBaseParser.RECORDREADER, 0); }
		public TerminalNode DELIMITED() { return getToken(SqlBaseParser.DELIMITED, 0); }
		public TerminalNode FIELDS() { return getToken(SqlBaseParser.FIELDS, 0); }
		public TerminalNode TERMINATED() { return getToken(SqlBaseParser.TERMINATED, 0); }
		public TerminalNode COLLECTION() { return getToken(SqlBaseParser.COLLECTION, 0); }
		public TerminalNode ITEMS() { return getToken(SqlBaseParser.ITEMS, 0); }
		public TerminalNode KEYS() { return getToken(SqlBaseParser.KEYS, 0); }
		public TerminalNode ESCAPED() { return getToken(SqlBaseParser.ESCAPED, 0); }
		public TerminalNode LINES() { return getToken(SqlBaseParser.LINES, 0); }
		public TerminalNode SEPARATED() { return getToken(SqlBaseParser.SEPARATED, 0); }
		public TerminalNode EXTENDED() { return getToken(SqlBaseParser.EXTENDED, 0); }
		public TerminalNode REFRESH() { return getToken(SqlBaseParser.REFRESH, 0); }
		public TerminalNode CLEAR() { return getToken(SqlBaseParser.CLEAR, 0); }
		public TerminalNode CACHE() { return getToken(SqlBaseParser.CACHE, 0); }
		public TerminalNode UNCACHE() { return getToken(SqlBaseParser.UNCACHE, 0); }
		public TerminalNode LAZY() { return getToken(SqlBaseParser.LAZY, 0); }
		public TerminalNode GLOBAL() { return getToken(SqlBaseParser.GLOBAL, 0); }
		public TerminalNode TEMPORARY() { return getToken(SqlBaseParser.TEMPORARY, 0); }
		public TerminalNode OPTIONS() { return getToken(SqlBaseParser.OPTIONS, 0); }
		public TerminalNode GROUPING() { return getToken(SqlBaseParser.GROUPING, 0); }
		public TerminalNode CUBE() { return getToken(SqlBaseParser.CUBE, 0); }
		public TerminalNode ROLLUP() { return getToken(SqlBaseParser.ROLLUP, 0); }
		public TerminalNode EXPLAIN() { return getToken(SqlBaseParser.EXPLAIN, 0); }
		public TerminalNode FORMAT() { return getToken(SqlBaseParser.FORMAT, 0); }
		public TerminalNode LOGICAL() { return getToken(SqlBaseParser.LOGICAL, 0); }
		public TerminalNode FORMATTED() { return getToken(SqlBaseParser.FORMATTED, 0); }
		public TerminalNode CODEGEN() { return getToken(SqlBaseParser.CODEGEN, 0); }
		public TerminalNode COST() { return getToken(SqlBaseParser.COST, 0); }
		public TerminalNode TABLESAMPLE() { return getToken(SqlBaseParser.TABLESAMPLE, 0); }
		public TerminalNode USE() { return getToken(SqlBaseParser.USE, 0); }
		public TerminalNode TO() { return getToken(SqlBaseParser.TO, 0); }
		public TerminalNode BUCKET() { return getToken(SqlBaseParser.BUCKET, 0); }
		public TerminalNode PERCENTLIT() { return getToken(SqlBaseParser.PERCENTLIT, 0); }
		public TerminalNode OUT() { return getToken(SqlBaseParser.OUT, 0); }
		public TerminalNode OF() { return getToken(SqlBaseParser.OF, 0); }
		public TerminalNode SET() { return getToken(SqlBaseParser.SET, 0); }
		public TerminalNode RESET() { return getToken(SqlBaseParser.RESET, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public TerminalNode REPLACE() { return getToken(SqlBaseParser.REPLACE, 0); }
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode NO() { return getToken(SqlBaseParser.NO, 0); }
		public TerminalNode DATA() { return getToken(SqlBaseParser.DATA, 0); }
		public TerminalNode START() { return getToken(SqlBaseParser.START, 0); }
		public TerminalNode TRANSACTION() { return getToken(SqlBaseParser.TRANSACTION, 0); }
		public TerminalNode COMMIT() { return getToken(SqlBaseParser.COMMIT, 0); }
		public TerminalNode ROLLBACK() { return getToken(SqlBaseParser.ROLLBACK, 0); }
		public TerminalNode IGNORE() { return getToken(SqlBaseParser.IGNORE, 0); }
		public TerminalNode SORT() { return getToken(SqlBaseParser.SORT, 0); }
		public TerminalNode CLUSTER() { return getToken(SqlBaseParser.CLUSTER, 0); }
		public TerminalNode DISTRIBUTE() { return getToken(SqlBaseParser.DISTRIBUTE, 0); }
		public TerminalNode UNSET() { return getToken(SqlBaseParser.UNSET, 0); }
		public TerminalNode TBLPROPERTIES() { return getToken(SqlBaseParser.TBLPROPERTIES, 0); }
		public TerminalNode SKEWED() { return getToken(SqlBaseParser.SKEWED, 0); }
		public TerminalNode STORED() { return getToken(SqlBaseParser.STORED, 0); }
		public TerminalNode DIRECTORIES() { return getToken(SqlBaseParser.DIRECTORIES, 0); }
		public TerminalNode LOCATION() { return getToken(SqlBaseParser.LOCATION, 0); }
		public TerminalNode EXCHANGE() { return getToken(SqlBaseParser.EXCHANGE, 0); }
		public TerminalNode ARCHIVE() { return getToken(SqlBaseParser.ARCHIVE, 0); }
		public TerminalNode UNARCHIVE() { return getToken(SqlBaseParser.UNARCHIVE, 0); }
		public TerminalNode FILEFORMAT() { return getToken(SqlBaseParser.FILEFORMAT, 0); }
		public TerminalNode TOUCH() { return getToken(SqlBaseParser.TOUCH, 0); }
		public TerminalNode COMPACT() { return getToken(SqlBaseParser.COMPACT, 0); }
		public TerminalNode CONCATENATE() { return getToken(SqlBaseParser.CONCATENATE, 0); }
		public TerminalNode CHANGE() { return getToken(SqlBaseParser.CHANGE, 0); }
		public TerminalNode CASCADE() { return getToken(SqlBaseParser.CASCADE, 0); }
		public TerminalNode RESTRICT() { return getToken(SqlBaseParser.RESTRICT, 0); }
		public TerminalNode BUCKETS() { return getToken(SqlBaseParser.BUCKETS, 0); }
		public TerminalNode CLUSTERED() { return getToken(SqlBaseParser.CLUSTERED, 0); }
		public TerminalNode SORTED() { return getToken(SqlBaseParser.SORTED, 0); }
		public TerminalNode PURGE() { return getToken(SqlBaseParser.PURGE, 0); }
		public TerminalNode INPUTFORMAT() { return getToken(SqlBaseParser.INPUTFORMAT, 0); }
		public TerminalNode OUTPUTFORMAT() { return getToken(SqlBaseParser.OUTPUTFORMAT, 0); }
		public TerminalNode DBPROPERTIES() { return getToken(SqlBaseParser.DBPROPERTIES, 0); }
		public TerminalNode DFS() { return getToken(SqlBaseParser.DFS, 0); }
		public TerminalNode TRUNCATE() { return getToken(SqlBaseParser.TRUNCATE, 0); }
		public TerminalNode COMPUTE() { return getToken(SqlBaseParser.COMPUTE, 0); }
		public TerminalNode LIST() { return getToken(SqlBaseParser.LIST, 0); }
		public TerminalNode STATISTICS() { return getToken(SqlBaseParser.STATISTICS, 0); }
		public TerminalNode ANALYZE() { return getToken(SqlBaseParser.ANALYZE, 0); }
		public TerminalNode PARTITIONED() { return getToken(SqlBaseParser.PARTITIONED, 0); }
		public TerminalNode EXTERNAL() { return getToken(SqlBaseParser.EXTERNAL, 0); }
		public TerminalNode DEFINED() { return getToken(SqlBaseParser.DEFINED, 0); }
		public TerminalNode RECORDWRITER() { return getToken(SqlBaseParser.RECORDWRITER, 0); }
		public TerminalNode REVOKE() { return getToken(SqlBaseParser.REVOKE, 0); }
		public TerminalNode GRANT() { return getToken(SqlBaseParser.GRANT, 0); }
		public TerminalNode LOCK() { return getToken(SqlBaseParser.LOCK, 0); }
		public TerminalNode UNLOCK() { return getToken(SqlBaseParser.UNLOCK, 0); }
		public TerminalNode MSCK() { return getToken(SqlBaseParser.MSCK, 0); }
		public TerminalNode REPAIR() { return getToken(SqlBaseParser.REPAIR, 0); }
		public TerminalNode RECOVER() { return getToken(SqlBaseParser.RECOVER, 0); }
		public TerminalNode EXPORT() { return getToken(SqlBaseParser.EXPORT, 0); }
		public TerminalNode IMPORT() { return getToken(SqlBaseParser.IMPORT, 0); }
		public TerminalNode LOAD() { return getToken(SqlBaseParser.LOAD, 0); }
		public TerminalNode VALUES() { return getToken(SqlBaseParser.VALUES, 0); }
		public TerminalNode COMMENT() { return getToken(SqlBaseParser.COMMENT, 0); }
		public TerminalNode ROLE() { return getToken(SqlBaseParser.ROLE, 0); }
		public TerminalNode ROLES() { return getToken(SqlBaseParser.ROLES, 0); }
		public TerminalNode COMPACTIONS() { return getToken(SqlBaseParser.COMPACTIONS, 0); }
		public TerminalNode PRINCIPALS() { return getToken(SqlBaseParser.PRINCIPALS, 0); }
		public TerminalNode TRANSACTIONS() { return getToken(SqlBaseParser.TRANSACTIONS, 0); }
		public TerminalNode INDEX() { return getToken(SqlBaseParser.INDEX, 0); }
		public TerminalNode INDEXES() { return getToken(SqlBaseParser.INDEXES, 0); }
		public TerminalNode LOCKS() { return getToken(SqlBaseParser.LOCKS, 0); }
		public TerminalNode OPTION() { return getToken(SqlBaseParser.OPTION, 0); }
		public TerminalNode LOCAL() { return getToken(SqlBaseParser.LOCAL, 0); }
		public TerminalNode INPATH() { return getToken(SqlBaseParser.INPATH, 0); }
		public TerminalNode ASC() { return getToken(SqlBaseParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SqlBaseParser.DESC, 0); }
		public TerminalNode LIMIT() { return getToken(SqlBaseParser.LIMIT, 0); }
		public TerminalNode RENAME() { return getToken(SqlBaseParser.RENAME, 0); }
		public TerminalNode SETS() { return getToken(SqlBaseParser.SETS, 0); }
		public TerminalNode AT() { return getToken(SqlBaseParser.AT, 0); }
		public TerminalNode NULLS() { return getToken(SqlBaseParser.NULLS, 0); }
		public TerminalNode OVERWRITE() { return getToken(SqlBaseParser.OVERWRITE, 0); }
		public TerminalNode ALL() { return getToken(SqlBaseParser.ALL, 0); }
		public TerminalNode ALTER() { return getToken(SqlBaseParser.ALTER, 0); }
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public TerminalNode BETWEEN() { return getToken(SqlBaseParser.BETWEEN, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public TerminalNode CREATE() { return getToken(SqlBaseParser.CREATE, 0); }
		public TerminalNode DELETE() { return getToken(SqlBaseParser.DELETE, 0); }
		public TerminalNode DESCRIBE() { return getToken(SqlBaseParser.DESCRIBE, 0); }
		public TerminalNode DROP() { return getToken(SqlBaseParser.DROP, 0); }
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public TerminalNode FALSE() { return getToken(SqlBaseParser.FALSE, 0); }
		public TerminalNode FOR() { return getToken(SqlBaseParser.FOR, 0); }
		public TerminalNode GROUP() { return getToken(SqlBaseParser.GROUP, 0); }
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public TerminalNode INSERT() { return getToken(SqlBaseParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(SqlBaseParser.INTO, 0); }
		public TerminalNode IS() { return getToken(SqlBaseParser.IS, 0); }
		public TerminalNode LIKE() { return getToken(SqlBaseParser.LIKE, 0); }
		public TerminalNode NULL() { return getToken(SqlBaseParser.NULL, 0); }
		public TerminalNode ORDER() { return getToken(SqlBaseParser.ORDER, 0); }
		public TerminalNode OUTER() { return getToken(SqlBaseParser.OUTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public TerminalNode TRUE() { return getToken(SqlBaseParser.TRUE, 0); }
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public TerminalNode RLIKE() { return getToken(SqlBaseParser.RLIKE, 0); }
		public TerminalNode AND() { return getToken(SqlBaseParser.AND, 0); }
		public TerminalNode CASE() { return getToken(SqlBaseParser.CASE, 0); }
		public TerminalNode CAST() { return getToken(SqlBaseParser.CAST, 0); }
		public TerminalNode DISTINCT() { return getToken(SqlBaseParser.DISTINCT, 0); }
		public TerminalNode DIV() { return getToken(SqlBaseParser.DIV, 0); }
		public TerminalNode ELSE() { return getToken(SqlBaseParser.ELSE, 0); }
		public TerminalNode END() { return getToken(SqlBaseParser.END, 0); }
		public TerminalNode FUNCTION() { return getToken(SqlBaseParser.FUNCTION, 0); }
		public TerminalNode INTERVAL() { return getToken(SqlBaseParser.INTERVAL, 0); }
		public TerminalNode MACRO() { return getToken(SqlBaseParser.MACRO, 0); }
		public TerminalNode OR() { return getToken(SqlBaseParser.OR, 0); }
		public TerminalNode STRATIFY() { return getToken(SqlBaseParser.STRATIFY, 0); }
		public TerminalNode THEN() { return getToken(SqlBaseParser.THEN, 0); }
		public TerminalNode UNBOUNDED() { return getToken(SqlBaseParser.UNBOUNDED, 0); }
		public TerminalNode WHEN() { return getToken(SqlBaseParser.WHEN, 0); }
		public TerminalNode DATABASE() { return getToken(SqlBaseParser.DATABASE, 0); }
		public TerminalNode SELECT() { return getToken(SqlBaseParser.SELECT, 0); }
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public TerminalNode WHERE() { return getToken(SqlBaseParser.WHERE, 0); }
		public TerminalNode HAVING() { return getToken(SqlBaseParser.HAVING, 0); }
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public TerminalNode CURRENT_DATE() { return getToken(SqlBaseParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SqlBaseParser.CURRENT_TIMESTAMP, 0); }
		public NonReservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonReserved; }
	}

	public final NonReservedContext nonReserved() throws RecognitionException {
		NonReservedContext _localctx = new NonReservedContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_nonReserved);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2474);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << OUTER) | (1L << LATERAL) | (1L << WINDOW) | (1L << OVER) | (1L << PARTITION))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (DIV - 134)) | (1L << (PERCENTLIT - 134)) | (1L << (BUCKET - 134)) | (1L << (OUT - 134)) | (1L << (OF - 134)) | (1L << (SORT - 134)) | (1L << (CLUSTER - 134)) | (1L << (DISTRIBUTE - 134)) | (1L << (OVERWRITE - 134)) | (1L << (TRANSFORM - 134)) | (1L << (REDUCE - 134)) | (1L << (USING - 134)) | (1L << (SERDE - 134)) | (1L << (SERDEPROPERTIES - 134)) | (1L << (RECORDREADER - 134)) | (1L << (RECORDWRITER - 134)) | (1L << (DELIMITED - 134)) | (1L << (FIELDS - 134)) | (1L << (TERMINATED - 134)) | (1L << (COLLECTION - 134)) | (1L << (ITEMS - 134)) | (1L << (KEYS - 134)) | (1L << (ESCAPED - 134)) | (1L << (LINES - 134)) | (1L << (SEPARATED - 134)) | (1L << (FUNCTION - 134)) | (1L << (EXTENDED - 134)) | (1L << (REFRESH - 134)) | (1L << (CLEAR - 134)) | (1L << (CACHE - 134)) | (1L << (UNCACHE - 134)) | (1L << (LAZY - 134)) | (1L << (FORMATTED - 134)) | (1L << (GLOBAL - 134)) | (1L << (TEMPORARY - 134)) | (1L << (OPTIONS - 134)) | (1L << (UNSET - 134)) | (1L << (TBLPROPERTIES - 134)) | (1L << (DBPROPERTIES - 134)) | (1L << (BUCKETS - 134)) | (1L << (SKEWED - 134)) | (1L << (STORED - 134)) | (1L << (DIRECTORIES - 134)) | (1L << (LOCATION - 134)) | (1L << (EXCHANGE - 134)) | (1L << (ARCHIVE - 134)) | (1L << (UNARCHIVE - 134)) | (1L << (FILEFORMAT - 134)) | (1L << (TOUCH - 134)) | (1L << (COMPACT - 134)) | (1L << (CONCATENATE - 134)) | (1L << (CHANGE - 134)) | (1L << (CASCADE - 134)) | (1L << (RESTRICT - 134)) | (1L << (CLUSTERED - 134)) | (1L << (SORTED - 134)) | (1L << (PURGE - 134)) | (1L << (INPUTFORMAT - 134)) | (1L << (OUTPUTFORMAT - 134)) | (1L << (DATABASE - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (DATABASES - 198)) | (1L << (DFS - 198)) | (1L << (TRUNCATE - 198)) | (1L << (ANALYZE - 198)) | (1L << (COMPUTE - 198)) | (1L << (LIST - 198)) | (1L << (STATISTICS - 198)) | (1L << (PARTITIONED - 198)) | (1L << (EXTERNAL - 198)) | (1L << (DEFINED - 198)) | (1L << (REVOKE - 198)) | (1L << (GRANT - 198)) | (1L << (LOCK - 198)) | (1L << (UNLOCK - 198)) | (1L << (MSCK - 198)) | (1L << (REPAIR - 198)) | (1L << (RECOVER - 198)) | (1L << (EXPORT - 198)) | (1L << (IMPORT - 198)) | (1L << (LOAD - 198)) | (1L << (ROLE - 198)) | (1L << (ROLES - 198)) | (1L << (COMPACTIONS - 198)) | (1L << (PRINCIPALS - 198)) | (1L << (TRANSACTIONS - 198)) | (1L << (INDEX - 198)) | (1L << (INDEXES - 198)) | (1L << (LOCKS - 198)) | (1L << (OPTION - 198)) | (1L << (LOCAL - 198)) | (1L << (INPATH - 198)) | (1L << (CURRENT_DATE - 198)) | (1L << (CURRENT_TIMESTAMP - 198)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 34:
			return queryTerm_sempred((QueryTermContext)_localctx, predIndex);
		case 64:
			return booleanExpression_sempred((BooleanExpressionContext)_localctx, predIndex);
		case 69:
			return valueExpression_sempred((ValueExpressionContext)_localctx, predIndex);
		case 70:
			return primaryExpression_sempred((PrimaryExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean queryTerm_sempred(QueryTermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean booleanExpression_sempred(BooleanExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean valueExpression_sempred(ValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean primaryExpression_sempred(PrimaryExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	private static final int _serializedATNSegments = 2;
	private static final String _serializedATNSegment0 =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0108\u09af\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7\u00e8\n\7\3\7\3\7\3\7\5\7\u00ed\n\7\3\7\5\7\u00f0\n\7\3\7\3\7"+
		"\3\7\5\7\u00f5\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0102"+
		"\n\7\3\7\3\7\5\7\u0106\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u010d\n\7\3\7\3\7\3"+
		"\7\5\7\u0112\n\7\3\7\3\7\3\7\5\7\u0117\n\7\3\7\5\7\u011a\n\7\3\7\5\7\u011d"+
		"\n\7\3\7\3\7\5\7\u0121\n\7\3\7\5\7\u0124\n\7\3\7\5\7\u0127\n\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u012e\n\7\3\7\3\7\5\7\u0132\n\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\5\7\u013a\n\7\3\7\5\7\u013d\n\7\3\7\5\7\u0140\n\7\3\7\5\7\u0143\n\7"+
		"\3\7\5\7\u0146\n\7\3\7\5\7\u0149\n\7\3\7\3\7\5\7\u014d\n\7\3\7\5\7\u0150"+
		"\n\7\3\7\5\7\u0153\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u015a\n\7\3\7\3\7\3\7\3"+
		"\7\5\7\u0160\n\7\3\7\3\7\3\7\3\7\5\7\u0166\n\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7\u016e\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u018e"+
		"\n\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0196\n\7\3\7\3\7\5\7\u019a\n\7\3\7\3"+
		"\7\3\7\5\7\u019f\n\7\3\7\3\7\3\7\3\7\5\7\u01a5\n\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7\u01ad\n\7\3\7\3\7\3\7\3\7\5\7\u01b3\n\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7\u01c0\n\7\3\7\6\7\u01c3\n\7\r\7\16\7\u01c4"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u01ce\n\7\3\7\6\7\u01d1\n\7\r\7\16\7"+
		"\u01d2\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u01e3"+
		"\n\7\3\7\3\7\3\7\7\7\u01e8\n\7\f\7\16\7\u01eb\13\7\3\7\5\7\u01ee\n\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7\u01f6\n\7\3\7\3\7\3\7\7\7\u01fb\n\7\f\7\16"+
		"\7\u01fe\13\7\3\7\3\7\3\7\3\7\5\7\u0204\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0213\n\7\3\7\3\7\5\7\u0217\n\7\3\7\3\7"+
		"\3\7\3\7\5\7\u021d\n\7\3\7\3\7\3\7\3\7\5\7\u0223\n\7\3\7\5\7\u0226\n\7"+
		"\3\7\5\7\u0229\n\7\3\7\3\7\3\7\3\7\5\7\u022f\n\7\3\7\3\7\5\7\u0233\n\7"+
		"\3\7\3\7\5\7\u0237\n\7\3\7\3\7\3\7\5\7\u023c\n\7\3\7\3\7\5\7\u0240\n\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0248\n\7\3\7\5\7\u024b\n\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7\u0254\n\7\3\7\3\7\3\7\5\7\u0259\n\7\3\7\3\7\3\7\3\7"+
		"\5\7\u025f\n\7\3\7\3\7\3\7\3\7\5\7\u0265\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\7\7\u026f\n\7\f\7\16\7\u0272\13\7\5\7\u0274\n\7\3\7\3\7\5\7\u0278"+
		"\n\7\3\7\3\7\3\7\5\7\u027d\n\7\3\7\3\7\3\7\5\7\u0282\n\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u0289\n\7\3\7\5\7\u028c\n\7\3\7\5\7\u028f\n\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u0296\n\7\3\7\3\7\3\7\5\7\u029b\n\7\3\7\3\7\3\7\3\7\5\7\u02a1"+
		"\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u02aa\n\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7\u02b2\n\7\3\7\3\7\3\7\3\7\5\7\u02b8\n\7\3\7\3\7\5\7\u02bc\n\7\3\7"+
		"\3\7\5\7\u02c0\n\7\3\7\3\7\5\7\u02c4\n\7\5\7\u02c6\n\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u02cf\n\7\3\7\3\7\3\7\3\7\5\7\u02d5\n\7\3\7\3\7\3\7\5"+
		"\7\u02da\n\7\3\7\5\7\u02dd\n\7\3\7\3\7\5\7\u02e1\n\7\3\7\5\7\u02e4\n\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7\u02eb\n\7\f\7\16\7\u02ee\13\7\3\7\3\7\5\7\u02f2"+
		"\n\7\3\7\3\7\3\7\5\7\u02f7\n\7\3\7\5\7\u02fa\n\7\3\7\3\7\3\7\3\7\5\7\u0300"+
		"\n\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0308\n\7\3\7\3\7\3\7\5\7\u030d\n\7\3"+
		"\7\3\7\3\7\3\7\5\7\u0313\n\7\3\7\3\7\3\7\3\7\5\7\u0319\n\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\7\7\u0322\n\7\f\7\16\7\u0325\13\7\3\7\3\7\3\7\7\7\u032a"+
		"\n\7\f\7\16\7\u032d\13\7\3\7\3\7\7\7\u0331\n\7\f\7\16\7\u0334\13\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0361\n\7\f\7\16\7\u0364\13\7\5\7\u0366"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u036e\n\b\3\b\3\b\5\b\u0372\n\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u0379\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u03ed"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u03f5\n\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"\u03fd\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0406\n\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b\u0412\n\b\3\t\3\t\5\t\u0416\n\t\3\t\5\t\u0419"+
		"\n\t\3\t\3\t\3\t\3\t\5\t\u041f\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u0429\n\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0435\n"+
		"\13\3\13\3\13\3\13\5\13\u043a\n\13\3\f\3\f\3\f\3\r\5\r\u0440\n\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u044c\n\16\5\16\u044e"+
		"\n\16\3\16\3\16\3\16\5\16\u0453\n\16\3\16\3\16\5\16\u0457\n\16\5\16\u0459"+
		"\n\16\3\17\3\17\5\17\u045d\n\17\3\20\3\20\3\20\3\20\3\20\7\20\u0464\n"+
		"\20\f\20\16\20\u0467\13\20\3\20\3\20\3\21\3\21\3\21\5\21\u046e\n\21\3"+
		"\22\3\22\3\22\3\22\3\22\5\22\u0475\n\22\3\23\3\23\3\23\3\23\5\23\u047b"+
		"\n\23\7\23\u047d\n\23\f\23\16\23\u0480\13\23\3\24\3\24\3\24\3\24\7\24"+
		"\u0486\n\24\f\24\16\24\u0489\13\24\3\25\3\25\5\25\u048d\n\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u049a\n\27\f\27\16"+
		"\27\u049d\13\27\3\27\3\27\3\30\3\30\5\30\u04a3\n\30\3\30\5\30\u04a6\n"+
		"\30\3\31\3\31\3\31\7\31\u04ab\n\31\f\31\16\31\u04ae\13\31\3\31\5\31\u04b1"+
		"\n\31\3\32\3\32\3\32\3\32\5\32\u04b7\n\32\3\33\3\33\3\33\3\33\7\33\u04bd"+
		"\n\33\f\33\16\33\u04c0\13\33\3\33\3\33\3\34\3\34\3\34\3\34\7\34\u04c8"+
		"\n\34\f\34\16\34\u04cb\13\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\5"+
		"\35\u04d5\n\35\3\36\3\36\3\36\3\36\3\36\5\36\u04dc\n\36\3\37\3\37\3\37"+
		"\3\37\5\37\u04e2\n\37\3 \3 \3 \3!\5!\u04e8\n!\3!\3!\3!\3!\3!\6!\u04ef"+
		"\n!\r!\16!\u04f0\5!\u04f3\n!\3\"\3\"\3\"\3\"\3\"\7\"\u04fa\n\"\f\"\16"+
		"\"\u04fd\13\"\5\"\u04ff\n\"\3\"\3\"\3\"\3\"\3\"\7\"\u0506\n\"\f\"\16\""+
		"\u0509\13\"\5\"\u050b\n\"\3\"\3\"\3\"\3\"\3\"\7\"\u0512\n\"\f\"\16\"\u0515"+
		"\13\"\5\"\u0517\n\"\3\"\3\"\3\"\3\"\3\"\7\"\u051e\n\"\f\"\16\"\u0521\13"+
		"\"\5\"\u0523\n\"\3\"\5\"\u0526\n\"\3\"\3\"\5\"\u052a\n\"\3#\5#\u052d\n"+
		"#\3#\3#\3#\3$\3$\3$\3$\3$\3$\5$\u0538\n$\3$\7$\u053b\n$\f$\16$\u053e\13"+
		"$\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0548\n%\3&\3&\5&\u054c\n&\3&\3&\5&\u0550"+
		"\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u055c\n\'\3\'\5\'\u055f"+
		"\n\'\3\'\3\'\5\'\u0563\n\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u056d\n"+
		"\'\3\'\3\'\5\'\u0571\n\'\5\'\u0573\n\'\3\'\5\'\u0576\n\'\3\'\3\'\5\'\u057a"+
		"\n\'\3\'\5\'\u057d\n\'\3\'\3\'\5\'\u0581\n\'\3\'\3\'\7\'\u0585\n\'\f\'"+
		"\16\'\u0588\13\'\3\'\5\'\u058b\n\'\3\'\3\'\5\'\u058f\n\'\3\'\3\'\3\'\5"+
		"\'\u0594\n\'\3\'\5\'\u0597\n\'\5\'\u0599\n\'\3\'\7\'\u059c\n\'\f\'\16"+
		"\'\u059f\13\'\3\'\3\'\5\'\u05a3\n\'\3\'\5\'\u05a6\n\'\3\'\3\'\5\'\u05aa"+
		"\n\'\3\'\5\'\u05ad\n\'\5\'\u05af\n\'\3(\3(\3(\5(\u05b4\n(\3(\7(\u05b7"+
		"\n(\f(\16(\u05ba\13(\3(\3(\3)\3)\3)\3)\3)\3)\7)\u05c4\n)\f)\16)\u05c7"+
		"\13)\3)\3)\5)\u05cb\n)\3*\3*\3*\3*\7*\u05d1\n*\f*\16*\u05d4\13*\3*\7*"+
		"\u05d7\n*\f*\16*\u05da\13*\3+\3+\3+\3+\3+\7+\u05e1\n+\f+\16+\u05e4\13"+
		"+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\7+\u05f0\n+\f+\16+\u05f3\13+\3+\3+\5+"+
		"\u05f7\n+\3,\3,\3,\3,\7,\u05fd\n,\f,\16,\u0600\13,\5,\u0602\n,\3,\3,\5"+
		",\u0606\n,\3-\3-\3-\5-\u060b\n-\3-\3-\3-\3-\3-\7-\u0612\n-\f-\16-\u0615"+
		"\13-\5-\u0617\n-\3-\3-\3-\5-\u061c\n-\3-\3-\3-\7-\u0621\n-\f-\16-\u0624"+
		"\13-\5-\u0626\n-\3.\3.\3/\3/\7/\u062c\n/\f/\16/\u062f\13/\3\60\3\60\3"+
		"\60\3\60\5\60\u0635\n\60\3\60\3\60\3\60\3\60\3\60\5\60\u063c\n\60\3\61"+
		"\5\61\u063f\n\61\3\61\3\61\3\61\5\61\u0644\n\61\3\61\3\61\3\61\3\61\5"+
		"\61\u064a\n\61\3\61\3\61\5\61\u064e\n\61\3\61\5\61\u0651\n\61\3\61\5\61"+
		"\u0654\n\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u065d\n\62\f\62\16"+
		"\62\u0660\13\62\3\62\3\62\5\62\u0664\n\62\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63"+
		"\u0679\n\63\5\63\u067b\n\63\5\63\u067d\n\63\3\63\3\63\3\64\3\64\3\64\3"+
		"\64\3\65\3\65\3\65\7\65\u0688\n\65\f\65\16\65\u068b\13\65\3\66\3\66\3"+
		"\66\3\66\7\66\u0691\n\66\f\66\16\66\u0694\13\66\3\66\3\66\3\67\3\67\5"+
		"\67\u069a\n\67\38\38\38\38\78\u06a0\n8\f8\168\u06a3\138\38\38\39\39\3"+
		"9\59\u06aa\n9\3:\3:\5:\u06ae\n:\3:\5:\u06b1\n:\3:\5:\u06b4\n:\3:\3:\3"+
		":\3:\5:\u06ba\n:\3:\5:\u06bd\n:\3:\5:\u06c0\n:\3:\3:\3:\3:\5:\u06c6\n"+
		":\3:\5:\u06c9\n:\3:\5:\u06cc\n:\3:\3:\3:\3:\3:\3:\7:\u06d4\n:\f:\16:\u06d7"+
		"\13:\5:\u06d9\n:\3:\3:\5:\u06dd\n:\3;\3;\3;\3;\7;\u06e3\n;\f;\16;\u06e6"+
		"\13;\3;\5;\u06e9\n;\3;\3;\5;\u06ed\n;\5;\u06ef\n;\3<\3<\3<\3<\3<\3<\3"+
		"<\5<\u06f8\n<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\5<\u0704\n<\5<\u0706\n<\3"+
		"<\3<\3<\3<\3<\5<\u070d\n<\3<\3<\3<\3<\3<\5<\u0714\n<\3<\3<\3<\3<\5<\u071a"+
		"\n<\3<\3<\3<\3<\5<\u0720\n<\5<\u0722\n<\3=\3=\3=\5=\u0727\n=\3=\3=\3>"+
		"\3>\3>\5>\u072e\n>\3>\3>\3?\3?\5?\u0734\n?\3?\3?\5?\u0738\n?\5?\u073a"+
		"\n?\3@\3@\3@\7@\u073f\n@\f@\16@\u0742\13@\3A\3A\3B\3B\3B\3B\3B\3B\3B\3"+
		"B\3B\5B\u074f\nB\3B\3B\3B\3B\3B\3B\7B\u0757\nB\fB\16B\u075a\13B\3C\3C"+
		"\5C\u075e\nC\3D\5D\u0761\nD\3D\3D\3D\3D\3D\3D\5D\u0769\nD\3D\3D\3D\3D"+
		"\3D\7D\u0770\nD\fD\16D\u0773\13D\3D\3D\3D\5D\u0778\nD\3D\3D\3D\3D\3D\3"+
		"D\5D\u0780\nD\3D\3D\3D\3D\5D\u0786\nD\3D\5D\u0789\nD\3E\3E\3F\3F\3G\3"+
		"G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3"+
		"G\3G\3G\3G\3G\3G\3G\3G\3G\3G\5G\u07b1\nG\3G\3G\3G\3G\3G\3G\3G\3G\3G\3"+
		"G\3G\3G\3G\3G\3G\3G\3G\3G\3G\7G\u07c6\nG\fG\16G\u07c9\13G\3H\3H\3H\3H"+
		"\6H\u07cf\nH\rH\16H\u07d0\3H\3H\5H\u07d5\nH\3H\3H\3H\3H\3H\6H\u07dc\n"+
		"H\rH\16H\u07dd\3H\3H\5H\u07e2\nH\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3"+
		"H\3H\7H\u07f2\nH\fH\16H\u07f5\13H\5H\u07f7\nH\3H\3H\3H\3H\3H\3H\5H\u07ff"+
		"\nH\3H\3H\3H\3H\3H\3H\3H\5H\u0808\nH\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\6H\u0816\nH\rH\16H\u0817\3H\3H\3H\3H\3H\3H\3H\3H\3H\5H\u0823\nH\3"+
		"H\3H\3H\7H\u0828\nH\fH\16H\u082b\13H\5H\u082d\nH\3H\3H\3H\5H\u0832\nH"+
		"\3H\3H\3H\3H\3H\5H\u0839\nH\3H\3H\3H\3H\3H\3H\3H\3H\7H\u0843\nH\fH\16"+
		"H\u0846\13H\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3"+
		"I\3I\5I\u085d\nI\3J\3J\3J\3J\3J\7J\u0864\nJ\fJ\16J\u0867\13J\3J\3J\3K"+
		"\3K\3K\3K\3K\7K\u0870\nK\fK\16K\u0873\13K\3K\3K\3L\3L\3L\3L\3L\3L\3L\3"+
		"L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\5L\u088c\nL\3M\3M\3M\3M\3M\7"+
		"M\u0893\nM\fM\16M\u0896\13M\3M\3M\3N\3N\3N\3N\3N\7N\u089f\nN\fN\16N\u08a2"+
		"\13N\3N\3N\3O\3O\3O\3O\3O\3O\3O\3O\6O\u08ae\nO\rO\16O\u08af\5O\u08b2\n"+
		"O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\7T\u08be\nT\fT\16T\u08c1\13T\3U\3U\3U"+
		"\3U\5U\u08c7\nU\3V\5V\u08ca\nV\3V\3V\5V\u08ce\nV\3W\3W\3W\5W\u08d3\nW"+
		"\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\5X\u08e4\nX\3X\3X\5X\u08e8"+
		"\nX\3X\3X\3X\3X\3X\7X\u08ef\nX\fX\16X\u08f2\13X\3X\5X\u08f5\nX\5X\u08f7"+
		"\nX\3Y\3Y\3Y\7Y\u08fc\nY\fY\16Y\u08ff\13Y\3Z\3Z\3Z\3Z\5Z\u0905\nZ\3[\3"+
		"[\3[\7[\u090a\n[\f[\16[\u090d\13[\3\\\3\\\3\\\3\\\3\\\5\\\u0914\n\\\3"+
		"]\3]\3]\3]\3]\3^\3^\3^\3^\7^\u091f\n^\f^\16^\u0922\13^\3_\3_\3_\3_\3`"+
		"\3`\3`\3`\3`\3`\3`\7`\u092f\n`\f`\16`\u0932\13`\3`\3`\3`\3`\3`\7`\u0939"+
		"\n`\f`\16`\u093c\13`\5`\u093e\n`\3`\3`\3`\3`\3`\7`\u0945\n`\f`\16`\u0948"+
		"\13`\5`\u094a\n`\5`\u094c\n`\3`\5`\u094f\n`\3`\5`\u0952\n`\3a\3a\3a\3"+
		"a\3a\3a\3a\3a\3a\3a\3a\3a\3a\3a\3a\3a\5a\u0964\na\3b\3b\3b\3b\3b\3b\3"+
		"b\5b\u096d\nb\3c\3c\3c\7c\u0972\nc\fc\16c\u0975\13c\3d\3d\3d\3d\3d\3d"+
		"\3d\3d\3d\3d\3d\3d\3d\3d\3d\5d\u0986\nd\3e\3e\3e\5e\u098b\ne\3f\3f\3g"+
		"\5g\u0990\ng\3g\3g\5g\u0994\ng\3g\3g\5g\u0998\ng\3g\3g\5g\u099c\ng\3g"+
		"\3g\5g\u09a0\ng\3g\3g\5g\u09a4\ng\3g\3g\5g\u09a8\ng\3g\5g\u09ab\ng\3h"+
		"\3h\3h\7\u02ec\u0323\u032b\u0332\u0362\6F\u0082\u008c\u008ei\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\"+
		"^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090"+
		"\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8"+
		"\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0"+
		"\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\2\34\3\2\u00c0\u00c1\3\2OP"+
		"\5\2XZ\u00a6\u00a6\u00ac\u00ac\4\2\r\r\37\37\4\2,,UU\4\2\u00a6\u00a6\u00ac"+
		"\u00ac\4\2\16\16\u00cd\u00cd\3\2dg\3\2+,\4\2HHJJ\3\2\20\21\3\2\u00fc\u00fd"+
		"\3\2$%\3\2\u00ed\u00f0\4\2\u0083\u0084\u0089\u0089\3\2\u0085\u0088\3\2"+
		"\u0083\u0084\3\2\u00e8\u00e9\3\2{\u0082\3\2\u0083\u008c\3\2\35 \3\2()"+
		"\4\2AA\u0093\u0093\4\2\31\31\u0091\u0091\3\2EF\t\2\f\63\66\66>chz\u0088"+
		"\u0088\u008d\u00e4\u00e6\u00e9\2\u0b3d\2\u00d0\3\2\2\2\4\u00d3\3\2\2\2"+
		"\6\u00d6\3\2\2\2\b\u00d9\3\2\2\2\n\u00dc\3\2\2\2\f\u0365\3\2\2\2\16\u0411"+
		"\3\2\2\2\20\u0413\3\2\2\2\22\u0422\3\2\2\2\24\u042e\3\2\2\2\26\u043b\3"+
		"\2\2\2\30\u043f\3\2\2\2\32\u0458\3\2\2\2\34\u045a\3\2\2\2\36\u045e\3\2"+
		"\2\2 \u046a\3\2\2\2\"\u0474\3\2\2\2$\u0476\3\2\2\2&\u0481\3\2\2\2(\u048a"+
		"\3\2\2\2*\u0492\3\2\2\2,\u0495\3\2\2\2.\u04a0\3\2\2\2\60\u04b0\3\2\2\2"+
		"\62\u04b6\3\2\2\2\64\u04b8\3\2\2\2\66\u04c3\3\2\2\28\u04d4\3\2\2\2:\u04db"+
		"\3\2\2\2<\u04dd\3\2\2\2>\u04e3\3\2\2\2@\u04f2\3\2\2\2B\u04fe\3\2\2\2D"+
		"\u052c\3\2\2\2F\u0531\3\2\2\2H\u0547\3\2\2\2J\u0549\3\2\2\2L\u05ae\3\2"+
		"\2\2N\u05b0\3\2\2\2P\u05ca\3\2\2\2R\u05cc\3\2\2\2T\u05db\3\2\2\2V\u0605"+
		"\3\2\2\2X\u0607\3\2\2\2Z\u0627\3\2\2\2\\\u0629\3\2\2\2^\u063b\3\2\2\2"+
		"`\u0653\3\2\2\2b\u0663\3\2\2\2d\u0665\3\2\2\2f\u0680\3\2\2\2h\u0684\3"+
		"\2\2\2j\u068c\3\2\2\2l\u0697\3\2\2\2n\u069b\3\2\2\2p\u06a6\3\2\2\2r\u06dc"+
		"\3\2\2\2t\u06de\3\2\2\2v\u0721\3\2\2\2x\u0726\3\2\2\2z\u072d\3\2\2\2|"+
		"\u0731\3\2\2\2~\u073b\3\2\2\2\u0080\u0743\3\2\2\2\u0082\u074e\3\2\2\2"+
		"\u0084\u075b\3\2\2\2\u0086\u0788\3\2\2\2\u0088\u078a\3\2\2\2\u008a\u078c"+
		"\3\2\2\2\u008c\u07b0\3\2\2\2\u008e\u0838\3\2\2\2\u0090\u085c\3\2\2\2\u0092"+
		"\u085e\3\2\2\2\u0094\u086a\3\2\2\2\u0096\u088b\3\2\2\2\u0098\u088d\3\2"+
		"\2\2\u009a\u0899\3\2\2\2\u009c\u08b1\3\2\2\2\u009e\u08b3\3\2\2\2\u00a0"+
		"\u08b5\3\2\2\2\u00a2\u08b7\3\2\2\2\u00a4\u08b9\3\2\2\2\u00a6\u08bb\3\2"+
		"\2\2\u00a8\u08c2\3\2\2\2\u00aa\u08cd\3\2\2\2\u00ac\u08d2\3\2\2\2\u00ae"+
		"\u08f6\3\2\2\2\u00b0\u08f8\3\2\2\2\u00b2\u0900\3\2\2\2\u00b4\u0906\3\2"+
		"\2\2\u00b6\u090e\3\2\2\2\u00b8\u0915\3\2\2\2\u00ba\u091a\3\2\2\2\u00bc"+
		"\u0923\3\2\2\2\u00be\u0951\3\2\2\2\u00c0\u0963\3\2\2\2\u00c2\u096c\3\2"+
		"\2\2\u00c4\u096e\3\2\2\2\u00c6\u0985\3\2\2\2\u00c8\u098a\3\2\2\2\u00ca"+
		"\u098c\3\2\2\2\u00cc\u09aa\3\2\2\2\u00ce\u09ac\3\2\2\2\u00d0\u00d1\5\f"+
		"\7\2\u00d1\u00d2\7\2\2\3\u00d2\3\3\2\2\2\u00d3\u00d4\5|?\2\u00d4\u00d5"+
		"\7\2\2\3\u00d5\5\3\2\2\2\u00d6\u00d7\5x=\2\u00d7\u00d8\7\2\2\3\u00d8\7"+
		"\3\2\2\2\u00d9\u00da\5z>\2\u00da\u00db\7\2\2\3\u00db\t\3\2\2\2\u00dc\u00dd"+
		"\5\u00aeX\2\u00dd\u00de\7\2\2\3\u00de\13\3\2\2\2\u00df\u0366\5\30\r\2"+
		"\u00e0\u00e1\7`\2\2\u00e1\u0366\5\u00c6d\2\u00e2\u00e3\7N\2\2\u00e3\u00e7"+
		"\7\u00c7\2\2\u00e4\u00e5\7z\2\2\u00e5\u00e6\7 \2\2\u00e6\u00e8\7\"\2\2"+
		"\u00e7\u00e4\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ec"+
		"\5\u00c6d\2\u00ea\u00eb\7p\2\2\u00eb\u00ed\7\u00f7\2\2\u00ec\u00ea\3\2"+
		"\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00f0\5\26\f\2\u00ef"+
		"\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f4\3\2\2\2\u00f1\u00f2\7L"+
		"\2\2\u00f2\u00f3\7\u00b2\2\2\u00f3\u00f5\5,\27\2\u00f4\u00f1\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u0366\3\2\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7\u00c7"+
		"\2\2\u00f8\u00f9\5\u00c6d\2\u00f9\u00fa\7q\2\2\u00fa\u00fb\7\u00b2\2\2"+
		"\u00fb\u00fc\5,\27\2\u00fc\u0366\3\2\2\2\u00fd\u00fe\7c\2\2\u00fe\u0101"+
		"\7\u00c7\2\2\u00ff\u0100\7z\2\2\u0100\u0102\7\"\2\2\u0101\u00ff\3\2\2"+
		"\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\5\u00c6d\2\u0104"+
		"\u0106\t\2\2\2\u0105\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0366\3\2"+
		"\2\2\u0107\u010c\5\20\t\2\u0108\u0109\7\3\2\2\u0109\u010a\5\u00b0Y\2\u010a"+
		"\u010b\7\4\2\2\u010b\u010d\3\2\2\2\u010c\u0108\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010d\u010e\3\2\2\2\u010e\u0111\5*\26\2\u010f\u0110\7\u00af\2\2\u0110"+
		"\u0112\5,\27\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0116\3\2"+
		"\2\2\u0113\u0114\7\u00cf\2\2\u0114\u0115\7\24\2\2\u0115\u0117\5f\64\2"+
		"\u0116\u0113\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u011a"+
		"\5\22\n\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2\2\2"+
		"\u011b\u011d\5\26\f\2\u011c\u011b\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0120"+
		"\3\2\2\2\u011e\u011f\7p\2\2\u011f\u0121\7\u00f7\2\2\u0120\u011e\3\2\2"+
		"\2\u0120\u0121\3\2\2\2\u0121\u0126\3\2\2\2\u0122\u0124\7\17\2\2\u0123"+
		"\u0122\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\5\30"+
		"\r\2\u0126\u0123\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0366\3\2\2\2\u0128"+
		"\u012d\5\20\t\2\u0129\u012a\7\3\2\2\u012a\u012b\5\u00b0Y\2\u012b\u012c"+
		"\7\4\2\2\u012c\u012e\3\2\2\2\u012d\u0129\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u0131\3\2\2\2\u012f\u0130\7p\2\2\u0130\u0132\7\u00f7\2\2\u0131\u012f"+
		"\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0139\3\2\2\2\u0133\u0134\7\u00cf\2"+
		"\2\u0134\u0135\7\24\2\2\u0135\u0136\7\3\2\2\u0136\u0137\5\u00b0Y\2\u0137"+
		"\u0138\7\4\2\2\u0138\u013a\3\2\2\2\u0139\u0133\3\2\2\2\u0139\u013a\3\2"+
		"\2\2\u013a\u013c\3\2\2\2\u013b\u013d\5\22\n\2\u013c\u013b\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u0140\5\24\13\2\u013f\u013e\3"+
		"\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142\3\2\2\2\u0141\u0143\5v<\2\u0142"+
		"\u0141\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u0146\58"+
		"\35\2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0148\3\2\2\2\u0147"+
		"\u0149\5\26\f\2\u0148\u0147\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014c\3"+
		"\2\2\2\u014a\u014b\7\u00b1\2\2\u014b\u014d\5,\27\2\u014c\u014a\3\2\2\2"+
		"\u014c\u014d\3\2\2\2\u014d\u0152\3\2\2\2\u014e\u0150\7\17\2\2\u014f\u014e"+
		"\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0153\5\30\r\2"+
		"\u0152\u014f\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0366\3\2\2\2\u0154\u0155"+
		"\7N\2\2\u0155\u0159\7O\2\2\u0156\u0157\7z\2\2\u0157\u0158\7 \2\2\u0158"+
		"\u015a\7\"\2\2\u0159\u0156\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\3\2"+
		"\2\2\u015b\u015c\5x=\2\u015c\u015d\7$\2\2\u015d\u015f\5x=\2\u015e\u0160"+
		"\5\26\f\2\u015f\u015e\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0366\3\2\2\2"+
		"\u0161\u0162\7\u00cb\2\2\u0162\u0163\7O\2\2\u0163\u0165\5x=\2\u0164\u0166"+
		"\5\36\20\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167\3\2\2\2"+
		"\u0167\u0168\7\u00cc\2\2\u0168\u016d\7\u00ce\2\2\u0169\u016e\5\u00c6d"+
		"\2\u016a\u016b\7-\2\2\u016b\u016c\7^\2\2\u016c\u016e\5h\65\2\u016d\u0169"+
		"\3\2\2\2\u016d\u016a\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0366\3\2\2\2\u016f"+
		"\u0170\7k\2\2\u0170\u0171\7O\2\2\u0171\u0172\5x=\2\u0172\u0173\7\16\2"+
		"\2\u0173\u0174\7^\2\2\u0174\u0175\7\3\2\2\u0175\u0176\5\u00b0Y\2\u0176"+
		"\u0177\7\4\2\2\u0177\u0366\3\2\2\2\u0178\u0179\7k\2\2\u0179\u017a\t\3"+
		"\2\2\u017a\u017b\5x=\2\u017b\u017c\7l\2\2\u017c\u017d\7h\2\2\u017d\u017e"+
		"\5x=\2\u017e\u0366\3\2\2\2\u017f\u0180\7k\2\2\u0180\u0181\t\3\2\2\u0181"+
		"\u0182\5x=\2\u0182\u0183\7q\2\2\u0183\u0184\7\u00b1\2\2\u0184\u0185\5"+
		",\27\2\u0185\u0366\3\2\2\2\u0186\u0187\7k\2\2\u0187\u0188\t\3\2\2\u0188"+
		"\u0189\5x=\2\u0189\u018a\7\u00b0\2\2\u018a\u018d\7\u00b1\2\2\u018b\u018c"+
		"\7z\2\2\u018c\u018e\7\"\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f\u0190\5,\27\2\u0190\u0366\3\2\2\2\u0191\u0192\7k"+
		"\2\2\u0192\u0193\7O\2\2\u0193\u0195\5x=\2\u0194\u0196\5\36\20\2\u0195"+
		"\u0194\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0199\7\u00bf"+
		"\2\2\u0198\u019a\7_\2\2\u0199\u0198\3\2\2\2\u0199\u019a\3\2\2\2\u019a"+
		"\u019b\3\2\2\2\u019b\u019c\5\u00c6d\2\u019c\u019e\5\u00b2Z\2\u019d\u019f"+
		"\5\u00acW\2\u019e\u019d\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u0366\3\2\2"+
		"\2\u01a0\u01a1\7k\2\2\u01a1\u01a2\7O\2\2\u01a2\u01a4\5x=\2\u01a3\u01a5"+
		"\5\36\20\2\u01a4\u01a3\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2"+
		"\u01a6\u01a7\7q\2\2\u01a7\u01a8\7\u0098\2\2\u01a8\u01ac\7\u00f7\2\2\u01a9"+
		"\u01aa\7L\2\2\u01aa\u01ab\7\u0099\2\2\u01ab\u01ad\5,\27\2\u01ac\u01a9"+
		"\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u0366\3\2\2\2\u01ae\u01af\7k\2\2\u01af"+
		"\u01b0\7O\2\2\u01b0\u01b2\5x=\2\u01b1\u01b3\5\36\20\2\u01b2\u01b1\3\2"+
		"\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\7q\2\2\u01b5"+
		"\u01b6\7\u0099\2\2\u01b6\u01b7\5,\27\2\u01b7\u0366\3\2\2\2\u01b8\u01b9"+
		"\7k\2\2\u01b9\u01ba\7O\2\2\u01ba\u01bb\5x=\2\u01bb\u01bf\7\16\2\2\u01bc"+
		"\u01bd\7z\2\2\u01bd\u01be\7 \2\2\u01be\u01c0\7\"\2\2\u01bf\u01bc\3\2\2"+
		"\2\u01bf\u01c0\3\2\2\2\u01c0\u01c2\3\2\2\2\u01c1\u01c3\5\34\17\2\u01c2"+
		"\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2"+
		"\2\2\u01c5\u0366\3\2\2\2\u01c6\u01c7\7k\2\2\u01c7\u01c8\7P\2\2\u01c8\u01c9"+
		"\5x=\2\u01c9\u01cd\7\16\2\2\u01ca\u01cb\7z\2\2\u01cb\u01cc\7 \2\2\u01cc"+
		"\u01ce\7\"\2\2\u01cd\u01ca\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d0\3\2"+
		"\2\2\u01cf\u01d1\5\36\20\2\u01d0\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2"+
		"\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u0366\3\2\2\2\u01d4\u01d5\7k"+
		"\2\2\u01d5\u01d6\7O\2\2\u01d6\u01d7\5x=\2\u01d7\u01d8\5\36\20\2\u01d8"+
		"\u01d9\7l\2\2\u01d9\u01da\7h\2\2\u01da\u01db\5\36\20\2\u01db\u0366\3\2"+
		"\2\2\u01dc\u01dd\7k\2\2\u01dd\u01de\7O\2\2\u01de\u01df\5x=\2\u01df\u01e2"+
		"\7c\2\2\u01e0\u01e1\7z\2\2\u01e1\u01e3\7\"\2\2\u01e2\u01e0\3\2\2\2\u01e2"+
		"\u01e3\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e9\5\36\20\2\u01e5\u01e6\7"+
		"\5\2\2\u01e6\u01e8\5\36\20\2\u01e7\u01e5\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9"+
		"\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2"+
		"\2\2\u01ec\u01ee\7\u00c4\2\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee"+
		"\u0366\3\2\2\2\u01ef\u01f0\7k\2\2\u01f0\u01f1\7P\2\2\u01f1\u01f2\5x=\2"+
		"\u01f2\u01f5\7c\2\2\u01f3\u01f4\7z\2\2\u01f4\u01f6\7\"\2\2\u01f5\u01f3"+
		"\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01fc\5\36\20\2"+
		"\u01f8\u01f9\7\5\2\2\u01f9\u01fb\5\36\20\2\u01fa\u01f8\3\2\2\2\u01fb\u01fe"+
		"\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u0366\3\2\2\2\u01fe"+
		"\u01fc\3\2\2\2\u01ff\u0200\7k\2\2\u0200\u0201\7O\2\2\u0201\u0203\5x=\2"+
		"\u0202\u0204\5\36\20\2\u0203\u0202\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205"+
		"\3\2\2\2\u0205\u0206\7q\2\2\u0206\u0207\5\26\f\2\u0207\u0366\3\2\2\2\u0208"+
		"\u0209\7k\2\2\u0209\u020a\7O\2\2\u020a\u020b\5x=\2\u020b\u020c\7\u00d8"+
		"\2\2\u020c\u020d\7a\2\2\u020d\u0366\3\2\2\2\u020e\u020f\7c\2\2\u020f\u0212"+
		"\7O\2\2\u0210\u0211\7z\2\2\u0211\u0213\7\"\2\2\u0212\u0210\3\2\2\2\u0212"+
		"\u0213\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0216\5x=\2\u0215\u0217\7\u00c4"+
		"\2\2\u0216\u0215\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0366\3\2\2\2\u0218"+
		"\u0219\7c\2\2\u0219\u021c\7P\2\2\u021a\u021b\7z\2\2\u021b\u021d\7\"\2"+
		"\2\u021c\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0366"+
		"\5x=\2\u021f\u0222\7N\2\2\u0220\u0221\7\35\2\2\u0221\u0223\7Q\2\2\u0222"+
		"\u0220\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0228\3\2\2\2\u0224\u0226\7\u00ad"+
		"\2\2\u0225\u0224\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\3\2\2\2\u0227"+
		"\u0229\7\u00ae\2\2\u0228\u0225\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022a"+
		"\3\2\2\2\u022a\u022e\7P\2\2\u022b\u022c\7z\2\2\u022c\u022d\7 \2\2\u022d"+
		"\u022f\7\"\2\2\u022e\u022b\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0230\3\2"+
		"\2\2\u0230\u0232\5x=\2\u0231\u0233\5n8\2\u0232\u0231\3\2\2\2\u0232\u0233"+
		"\3\2\2\2\u0233\u0236\3\2\2\2\u0234\u0235\7p\2\2\u0235\u0237\7\u00f7\2"+
		"\2\u0236\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u023b\3\2\2\2\u0238\u0239"+
		"\7\u00cf\2\2\u0239\u023a\7=\2\2\u023a\u023c\5f\64\2\u023b\u0238\3\2\2"+
		"\2\u023b\u023c\3\2\2\2\u023c\u023f\3\2\2\2\u023d\u023e\7\u00b1\2\2\u023e"+
		"\u0240\5,\27\2\u023f\u023d\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0241\3\2"+
		"\2\2\u0241\u0242\7\17\2\2\u0242\u0243\5\30\r\2\u0243\u0366\3\2\2\2\u0244"+
		"\u0247\7N\2\2\u0245\u0246\7\35\2\2\u0246\u0248\7Q\2\2\u0247\u0245\3\2"+
		"\2\2\u0247\u0248\3\2\2\2\u0248\u024a\3\2\2\2\u0249\u024b\7\u00ad\2\2\u024a"+
		"\u0249\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024c\3\2\2\2\u024c\u024d\7\u00ae"+
		"\2\2\u024d\u024e\7P\2\2\u024e\u0253\5x=\2\u024f\u0250\7\3\2\2\u0250\u0251"+
		"\5\u00b0Y\2\u0251\u0252\7\4\2\2\u0252\u0254\3\2\2\2\u0253\u024f\3\2\2"+
		"\2\u0253\u0254\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0258\5*\26\2\u0256\u0257"+
		"\7\u00af\2\2\u0257\u0259\5,\27\2\u0258\u0256\3\2\2\2\u0258\u0259\3\2\2"+
		"\2\u0259\u0366\3\2\2\2\u025a\u025b\7k\2\2\u025b\u025c\7P\2\2\u025c\u025e"+
		"\5x=\2\u025d\u025f\7\17\2\2\u025e\u025d\3\2\2\2\u025e\u025f\3\2\2\2\u025f"+
		"\u0260\3\2\2\2\u0260\u0261\5\30\r\2\u0261\u0366\3\2\2\2\u0262\u0264\7"+
		"N\2\2\u0263\u0265\7\u00ae\2\2\u0264\u0263\3\2\2\2\u0264\u0265\3\2\2\2"+
		"\u0265\u0266\3\2\2\2\u0266\u0267\7\u00a5\2\2\u0267\u0268\5\u00c4c\2\u0268"+
		"\u0269\7\17\2\2\u0269\u0273\7\u00f7\2\2\u026a\u026b\7\u0097\2\2\u026b"+
		"\u0270\5> \2\u026c\u026d\7\5\2\2\u026d\u026f\5> \2\u026e\u026c\3\2\2\2"+
		"\u026f\u0272\3\2\2\2\u0270\u026e\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0274"+
		"\3\2\2\2\u0272\u0270\3\2\2\2\u0273\u026a\3\2\2\2\u0273\u0274\3\2\2\2\u0274"+
		"\u0366\3\2\2\2\u0275\u0277\7c\2\2\u0276\u0278\7\u00ae\2\2\u0277\u0276"+
		"\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027c\7\u00a5\2"+
		"\2\u027a\u027b\7z\2\2\u027b\u027d\7\"\2\2\u027c\u027a\3\2\2\2\u027c\u027d"+
		"\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u0366\5\u00c4c\2\u027f\u0281\7V\2\2"+
		"\u0280\u0282\t\4\2\2\u0281\u0280\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0283"+
		"\3\2\2\2\u0283\u0366\5\f\7\2\u0284\u0285\7\\\2\2\u0285\u0288\7]\2\2\u0286"+
		"\u0287\t\5\2\2\u0287\u0289\5\u00c6d\2\u0288\u0286\3\2\2\2\u0288\u0289"+
		"\3\2\2\2\u0289\u028e\3\2\2\2\u028a\u028c\7$\2\2\u028b\u028a\3\2\2\2\u028b"+
		"\u028c\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u028f\7\u00f7\2\2\u028e\u028b"+
		"\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u0366\3\2\2\2\u0290\u0291\7\\\2\2\u0291"+
		"\u0292\7O\2\2\u0292\u0295\7\u00a6\2\2\u0293\u0294\t\5\2\2\u0294\u0296"+
		"\5\u00c6d\2\u0295\u0293\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u0297\3\2\2"+
		"\2\u0297\u0298\7$\2\2\u0298\u029a\7\u00f7\2\2\u0299\u029b\5\36\20\2\u029a"+
		"\u0299\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u0366\3\2\2\2\u029c\u029d\7\\"+
		"\2\2\u029d\u02a0\7\u00c8\2\2\u029e\u029f\7$\2\2\u029f\u02a1\7\u00f7\2"+
		"\2\u02a0\u029e\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u0366\3\2\2\2\u02a2\u02a3"+
		"\7\\\2\2\u02a3\u02a4\7\u00b1\2\2\u02a4\u02a9\5x=\2\u02a5\u02a6\7\3\2\2"+
		"\u02a6\u02a7\5\60\31\2\u02a7\u02a8\7\4\2\2\u02a8\u02aa\3\2\2\2\u02a9\u02a5"+
		"\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u0366\3\2\2\2\u02ab\u02ac\7\\\2\2\u02ac"+
		"\u02ad\7^\2\2\u02ad\u02ae\t\5\2\2\u02ae\u02b1\5x=\2\u02af\u02b0\t\5\2"+
		"\2\u02b0\u02b2\5\u00c6d\2\u02b1\u02af\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2"+
		"\u0366\3\2\2\2\u02b3\u02b4\7\\\2\2\u02b4\u02b5\7a\2\2\u02b5\u02b7\5x="+
		"\2\u02b6\u02b8\5\36\20\2\u02b7\u02b6\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8"+
		"\u0366\3\2\2\2\u02b9\u02bb\7\\\2\2\u02ba\u02bc\5\u00c6d\2\u02bb\u02ba"+
		"\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02c5\7b\2\2\u02be"+
		"\u02c0\7$\2\2\u02bf\u02be\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c3\3\2"+
		"\2\2\u02c1\u02c4\5\u00c4c\2\u02c2\u02c4\7\u00f7\2\2\u02c3\u02c1\3\2\2"+
		"\2\u02c3\u02c2\3\2\2\2\u02c4\u02c6\3\2\2\2\u02c5\u02bf\3\2\2\2\u02c5\u02c6"+
		"\3\2\2\2\u02c6\u0366\3\2\2\2\u02c7\u02c8\7\\\2\2\u02c8\u02c9\7N\2\2\u02c9"+
		"\u02ca\7O\2\2\u02ca\u0366\5x=\2\u02cb\u02cc\t\6\2\2\u02cc\u02ce\7\u00a5"+
		"\2\2\u02cd\u02cf\7\u00a6\2\2\u02ce\u02cd\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf"+
		"\u02d0\3\2\2\2\u02d0\u0366\5\"\22\2\u02d1\u02d2\t\6\2\2\u02d2\u02d4\7"+
		"\u00c7\2\2\u02d3\u02d5\7\u00a6\2\2\u02d4\u02d3\3\2\2\2\u02d4\u02d5\3\2"+
		"\2\2\u02d5\u02d6\3\2\2\2\u02d6\u0366\5\u00c6d\2\u02d7\u02d9\t\6\2\2\u02d8"+
		"\u02da\7O\2\2\u02d9\u02d8\3\2\2\2\u02d9\u02da\3\2\2\2\u02da\u02dc\3\2"+
		"\2\2\u02db\u02dd\t\7\2\2\u02dc\u02db\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd"+
		"\u02de\3\2\2\2\u02de\u02e0\5x=\2\u02df\u02e1\5\36\20\2\u02e0\u02df\3\2"+
		"\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02e3\3\2\2\2\u02e2\u02e4\5$\23\2\u02e3"+
		"\u02e2\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u0366\3\2\2\2\u02e5\u02e6\7\u00a7"+
		"\2\2\u02e6\u02e7\7O\2\2\u02e7\u0366\5x=\2\u02e8\u02ec\7\u00a7\2\2\u02e9"+
		"\u02eb\13\2\2\2\u02ea\u02e9\3\2\2\2\u02eb\u02ee\3\2\2\2\u02ec\u02ed\3"+
		"\2\2\2\u02ec\u02ea\3\2\2\2\u02ed\u0366\3\2\2\2\u02ee\u02ec\3\2\2\2\u02ef"+
		"\u02f1\7\u00a9\2\2\u02f0\u02f2\7\u00ab\2\2\u02f1\u02f0\3\2\2\2\u02f1\u02f2"+
		"\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f4\7O\2\2\u02f4\u02f9\5x=\2\u02f5"+
		"\u02f7\7\17\2\2\u02f6\u02f5\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f8\3"+
		"\2\2\2\u02f8\u02fa\5\30\r\2\u02f9\u02f6\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa"+
		"\u0366\3\2\2\2\u02fb\u02fc\7\u00aa\2\2\u02fc\u02ff\7O\2\2\u02fd\u02fe"+
		"\7z\2\2\u02fe\u0300\7\"\2\2\u02ff\u02fd\3\2\2\2\u02ff\u0300\3\2\2\2\u0300"+
		"\u0301\3\2\2\2\u0301\u0366\5x=\2\u0302\u0303\7\u00a8\2\2\u0303\u0366\7"+
		"\u00a9\2\2\u0304\u0305\7\u00db\2\2\u0305\u0307\7s\2\2\u0306\u0308\7\u00e6"+
		"\2\2\u0307\u0306\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u0309\3\2\2\2\u0309"+
		"\u030a\7\u00e7\2\2\u030a\u030c\7\u00f7\2\2\u030b\u030d\7\u0094\2\2\u030c"+
		"\u030b\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u030f\7T"+
		"\2\2\u030f\u0310\7O\2\2\u0310\u0312\5x=\2\u0311\u0313\5\36\20\2\u0312"+
		"\u0311\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0366\3\2\2\2\u0314\u0315\7\u00ca"+
		"\2\2\u0315\u0316\7O\2\2\u0316\u0318\5x=\2\u0317\u0319\5\36\20\2\u0318"+
		"\u0317\3\2\2\2\u0318\u0319\3\2\2\2\u0319\u0366\3\2\2\2\u031a\u031b\7\u00d6"+
		"\2\2\u031b\u031c\7\u00d7\2\2\u031c\u031d\7O\2\2\u031d\u0366\5x=\2\u031e"+
		"\u031f\t\b\2\2\u031f\u0323\5\u00c6d\2\u0320\u0322\13\2\2\2\u0321\u0320"+
		"\3\2\2\2\u0322\u0325\3\2\2\2\u0323\u0324\3\2\2\2\u0323\u0321\3\2\2\2\u0324"+
		"\u0366\3\2\2\2\u0325\u0323\3\2\2\2\u0326\u0327\7q\2\2\u0327\u032b\7\u00dc"+
		"\2\2\u0328\u032a\13\2\2\2\u0329\u0328\3\2\2\2\u032a\u032d\3\2\2\2\u032b"+
		"\u032c\3\2\2\2\u032b\u0329\3\2\2\2\u032c\u0366\3\2\2\2\u032d\u032b\3\2"+
		"\2\2\u032e\u0332\7q\2\2\u032f\u0331\13\2\2\2\u0330\u032f\3\2\2\2\u0331"+
		"\u0334\3\2\2\2\u0332\u0333\3\2\2\2\u0332\u0330\3\2\2\2\u0333\u0366\3\2"+
		"\2\2\u0334\u0332\3\2\2\2\u0335\u0366\7r\2\2\u0336\u0337\7N\2\2\u0337\u0338"+
		"\7\u00f1\2\2\u0338\u0339\7\u00e1\2\2\u0339\u033a\5\u00c6d\2\u033a\u033b"+
		"\7=\2\2\u033b\u033c\5x=\2\u033c\u033d\7\3\2\2\u033d\u033e\5\u00c6d\2\u033e"+
		"\u033f\7\4\2\2\u033f\u0366\3\2\2\2\u0340\u0341\7c\2\2\u0341\u0342\7\u00f1"+
		"\2\2\u0342\u0343\7\u00e1\2\2\u0343\u0344\5\u00c6d\2\u0344\u0345\7=\2\2"+
		"\u0345\u0346\5x=\2\u0346\u0366\3\2\2\2\u0347\u0348\7\\\2\2\u0348\u0349"+
		"\7\u00f1\2\2\u0349\u0366\7\u00e2\2\2\u034a\u034b\7N\2\2\u034b\u034c\7"+
		"\u00ea\2\2\u034c\u034d\7\u00e1\2\2\u034d\u034e\5\u00c6d\2\u034e\u034f"+
		"\7=\2\2\u034f\u0350\5x=\2\u0350\u0351\7\3\2\2\u0351\u0352\5\u00c6d\2\u0352"+
		"\u0353\7\4\2\2\u0353\u0366\3\2\2\2\u0354\u0355\7c\2\2\u0355\u0356\7\u00ea"+
		"\2\2\u0356\u0357\7\u00e1\2\2\u0357\u0358\5\u00c6d\2\u0358\u0359\7=\2\2"+
		"\u0359\u035a\5x=\2\u035a\u0366\3\2\2\2\u035b\u035c\7\\\2\2\u035c\u035d"+
		"\7\u00ea\2\2\u035d\u0366\7\u00e2\2\2\u035e\u0362\5\16\b\2\u035f\u0361"+
		"\13\2\2\2\u0360\u035f\3\2\2\2\u0361\u0364\3\2\2\2\u0362\u0363\3\2\2\2"+
		"\u0362\u0360\3\2\2\2\u0363\u0366\3\2\2\2\u0364\u0362\3\2\2\2\u0365\u00df"+
		"\3\2\2\2\u0365\u00e0\3\2\2\2\u0365\u00e2\3\2\2\2\u0365\u00f6\3\2\2\2\u0365"+
		"\u00fd\3\2\2\2\u0365\u0107\3\2\2\2\u0365\u0128\3\2\2\2\u0365\u0154\3\2"+
		"\2\2\u0365\u0161\3\2\2\2\u0365\u016f\3\2\2\2\u0365\u0178\3\2\2\2\u0365"+
		"\u017f\3\2\2\2\u0365\u0186\3\2\2\2\u0365\u0191\3\2\2\2\u0365\u01a0\3\2"+
		"\2\2\u0365\u01ae\3\2\2\2\u0365\u01b8\3\2\2\2\u0365\u01c6\3\2\2\2\u0365"+
		"\u01d4\3\2\2\2\u0365\u01dc\3\2\2\2\u0365\u01ef\3\2\2\2\u0365\u01ff\3\2"+
		"\2\2\u0365\u0208\3\2\2\2\u0365\u020e\3\2\2\2\u0365\u0218\3\2\2\2\u0365"+
		"\u021f\3\2\2\2\u0365\u0244\3\2\2\2\u0365\u025a\3\2\2\2\u0365\u0262\3\2"+
		"\2\2\u0365\u0275\3\2\2\2\u0365\u027f\3\2\2\2\u0365\u0284\3\2\2\2\u0365"+
		"\u0290\3\2\2\2\u0365\u029c\3\2\2\2\u0365\u02a2\3\2\2\2\u0365\u02ab\3\2"+
		"\2\2\u0365\u02b3\3\2\2\2\u0365\u02b9\3\2\2\2\u0365\u02c7\3\2\2\2\u0365"+
		"\u02cb\3\2\2\2\u0365\u02d1\3\2\2\2\u0365\u02d7\3\2\2\2\u0365\u02e5\3\2"+
		"\2\2\u0365\u02e8\3\2\2\2\u0365\u02ef\3\2\2\2\u0365\u02fb\3\2\2\2\u0365"+
		"\u0302\3\2\2\2\u0365\u0304\3\2\2\2\u0365\u0314\3\2\2\2\u0365\u031a\3\2"+
		"\2\2\u0365\u031e\3\2\2\2\u0365\u0326\3\2\2\2\u0365\u032e\3\2\2\2\u0365"+
		"\u0335\3\2\2\2\u0365\u0336\3\2\2\2\u0365\u0340\3\2\2\2\u0365\u0347\3\2"+
		"\2\2\u0365\u034a\3\2\2\2\u0365\u0354\3\2\2\2\u0365\u035b\3\2\2\2\u0365"+
		"\u035e\3\2\2\2\u0366\r\3\2\2\2\u0367\u0368\7N\2\2\u0368\u0412\7\u00dc"+
		"\2\2\u0369\u036a\7c\2\2\u036a\u0412\7\u00dc\2\2\u036b\u036d\7\u00d3\2"+
		"\2\u036c\u036e\7\u00dc\2\2\u036d\u036c\3\2\2\2\u036d\u036e\3\2\2\2\u036e"+
		"\u0412\3\2\2\2\u036f\u0371\7\u00d2\2\2\u0370\u0372\7\u00dc\2\2\u0371\u0370"+
		"\3\2\2\2\u0371\u0372\3\2\2\2\u0372\u0412\3\2\2\2\u0373\u0374\7\\\2\2\u0374"+
		"\u0412\7\u00d3\2\2\u0375\u0376\7\\\2\2\u0376\u0378\7\u00dc\2\2\u0377\u0379"+
		"\7\u00d3\2\2\u0378\u0377\3\2\2\2\u0378\u0379\3\2\2\2\u0379\u0412\3\2\2"+
		"\2\u037a\u037b\7\\\2\2\u037b\u0412\7\u00df\2\2\u037c\u037d\7\\\2\2\u037d"+
		"\u0412\7\u00dd\2\2\u037e\u037f\7\\\2\2\u037f\u0380\7G\2\2\u0380\u0412"+
		"\7\u00dd\2\2\u0381\u0382\7\u00d9\2\2\u0382\u0412\7O\2\2\u0383\u0384\7"+
		"\u00da\2\2\u0384\u0412\7O\2\2\u0385\u0386\7\\\2\2\u0386\u0412\7\u00de"+
		"\2\2\u0387\u0388\7\\\2\2\u0388\u0389\7N\2\2\u0389\u0412\7O\2\2\u038a\u038b"+
		"\7\\\2\2\u038b\u0412\7\u00e0\2\2\u038c\u038d\7\\\2\2\u038d\u0412\7\u00e2"+
		"\2\2\u038e\u038f\7\\\2\2\u038f\u0412\7\u00e3\2\2\u0390\u0391\7N\2\2\u0391"+
		"\u0412\7\u00e1\2\2\u0392\u0393\7c\2\2\u0393\u0412\7\u00e1\2\2\u0394\u0395"+
		"\7k\2\2\u0395\u0412\7\u00e1\2\2\u0396\u0397\7\u00d4\2\2\u0397\u0412\7"+
		"O\2\2\u0398\u0399\7\u00d4\2\2\u0399\u0412\7\u00c7\2\2\u039a\u039b\7\u00d5"+
		"\2\2\u039b\u0412\7O\2\2\u039c\u039d\7\u00d5\2\2\u039d\u0412\7\u00c7\2"+
		"\2\u039e\u039f\7N\2\2\u039f\u03a0\7\u00ae\2\2\u03a0\u0412\7x\2\2\u03a1"+
		"\u03a2\7c\2\2\u03a2\u03a3\7\u00ae\2\2\u03a3\u0412\7x\2\2\u03a4\u03a5\7"+
		"k\2\2\u03a5\u03a6\7O\2\2\u03a6\u03a7\5x=\2\u03a7\u03a8\7 \2\2\u03a8\u03a9"+
		"\7\u00c2\2\2\u03a9\u0412\3\2\2\2\u03aa\u03ab\7k\2\2\u03ab\u03ac\7O\2\2"+
		"\u03ac\u03ad\5x=\2\u03ad\u03ae\7\u00c2\2\2\u03ae\u03af\7\24\2\2\u03af"+
		"\u0412\3\2\2\2\u03b0\u03b1\7k\2\2\u03b1\u03b2\7O\2\2\u03b2\u03b3\5x=\2"+
		"\u03b3\u03b4\7 \2\2\u03b4\u03b5\7\u00c3\2\2\u03b5\u0412\3\2\2\2\u03b6"+
		"\u03b7\7k\2\2\u03b7\u03b8\7O\2\2\u03b8\u03b9\5x=\2\u03b9\u03ba\7\u00b4"+
		"\2\2\u03ba\u03bb\7\24\2\2\u03bb\u0412\3\2\2\2\u03bc\u03bd\7k\2\2\u03bd"+
		"\u03be\7O\2\2\u03be\u03bf\5x=\2\u03bf\u03c0\7 \2\2\u03c0\u03c1\7\u00b4"+
		"\2\2\u03c1\u0412\3\2\2\2\u03c2\u03c3\7k\2\2\u03c3\u03c4\7O\2\2\u03c4\u03c5"+
		"\5x=\2\u03c5\u03c6\7 \2\2\u03c6\u03c7\7\u00b5\2\2\u03c7\u03c8\7\17\2\2"+
		"\u03c8\u03c9\7\u00b6\2\2\u03c9\u0412\3\2\2\2\u03ca\u03cb\7k\2\2\u03cb"+
		"\u03cc\7O\2\2\u03cc\u03cd\5x=\2\u03cd\u03ce\7q\2\2\u03ce\u03cf\7\u00b4"+
		"\2\2\u03cf\u03d0\7\u00b7\2\2\u03d0\u0412\3\2\2\2\u03d1\u03d2\7k\2\2\u03d2"+
		"\u03d3\7O\2\2\u03d3\u03d4\5x=\2\u03d4\u03d5\7\u00b8\2\2\u03d5\u03d6\7"+
		"A\2\2\u03d6\u0412\3\2\2\2\u03d7\u03d8\7k\2\2\u03d8\u03d9\7O\2\2\u03d9"+
		"\u03da\5x=\2\u03da\u03db\7\u00b9\2\2\u03db\u03dc\7A\2\2\u03dc\u0412\3"+
		"\2\2\2\u03dd\u03de\7k\2\2\u03de\u03df\7O\2\2\u03df\u03e0\5x=\2\u03e0\u03e1"+
		"\7\u00ba\2\2\u03e1\u03e2\7A\2\2\u03e2\u0412\3\2\2\2\u03e3\u03e4\7k\2\2"+
		"\u03e4\u03e5\7O\2\2\u03e5\u03e6\5x=\2\u03e6\u03e7\7\u00bc\2\2\u03e7\u0412"+
		"\3\2\2\2\u03e8\u03e9\7k\2\2\u03e9\u03ea\7O\2\2\u03ea\u03ec\5x=\2\u03eb"+
		"\u03ed\5\36\20\2\u03ec\u03eb\3\2\2\2\u03ec\u03ed\3\2\2\2\u03ed\u03ee\3"+
		"\2\2\2\u03ee\u03ef\7\u00bd\2\2\u03ef\u0412\3\2\2\2\u03f0\u03f1\7k\2\2"+
		"\u03f1\u03f2\7O\2\2\u03f2\u03f4\5x=\2\u03f3\u03f5\5\36\20\2\u03f4\u03f3"+
		"\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6\u03f7\7\u00be\2"+
		"\2\u03f7\u0412\3\2\2\2\u03f8\u03f9\7k\2\2\u03f9\u03fa\7O\2\2\u03fa\u03fc"+
		"\5x=\2\u03fb\u03fd\5\36\20\2\u03fc\u03fb\3\2\2\2\u03fc\u03fd\3\2\2\2\u03fd"+
		"\u03fe\3\2\2\2\u03fe\u03ff\7q\2\2\u03ff\u0400\7\u00bb\2\2\u0400\u0412"+
		"\3\2\2\2\u0401\u0402\7k\2\2\u0402\u0403\7O\2\2\u0403\u0405\5x=\2\u0404"+
		"\u0406\5\36\20\2\u0405\u0404\3\2\2\2\u0405\u0406\3\2\2\2\u0406\u0407\3"+
		"\2\2\2\u0407\u0408\7Q\2\2\u0408\u0409\7^\2\2\u0409\u0412\3\2\2\2\u040a"+
		"\u040b\7t\2\2\u040b\u0412\7u\2\2\u040c\u0412\7v\2\2\u040d\u0412\7w\2\2"+
		"\u040e\u0412\7\u00c9\2\2\u040f\u0410\7S\2\2\u0410\u0412\7\r\2\2\u0411"+
		"\u0367\3\2\2\2\u0411\u0369\3\2\2\2\u0411\u036b\3\2\2\2\u0411\u036f\3\2"+
		"\2\2\u0411\u0373\3\2\2\2\u0411\u0375\3\2\2\2\u0411\u037a\3\2\2\2\u0411"+
		"\u037c\3\2\2\2\u0411\u037e\3\2\2\2\u0411\u0381\3\2\2\2\u0411\u0383\3\2"+
		"\2\2\u0411\u0385\3\2\2\2\u0411\u0387\3\2\2\2\u0411\u038a\3\2\2\2\u0411"+
		"\u038c\3\2\2\2\u0411\u038e\3\2\2\2\u0411\u0390\3\2\2\2\u0411\u0392\3\2"+
		"\2\2\u0411\u0394\3\2\2\2\u0411\u0396\3\2\2\2\u0411\u0398\3\2\2\2\u0411"+
		"\u039a\3\2\2\2\u0411\u039c\3\2\2\2\u0411\u039e\3\2\2\2\u0411\u03a1\3\2"+
		"\2\2\u0411\u03a4\3\2\2\2\u0411\u03aa\3\2\2\2\u0411\u03b0\3\2\2\2\u0411"+
		"\u03b6\3\2\2\2\u0411\u03bc\3\2\2\2\u0411\u03c2\3\2\2\2\u0411\u03ca\3\2"+
		"\2\2\u0411\u03d1\3\2\2\2\u0411\u03d7\3\2\2\2\u0411\u03dd\3\2\2\2\u0411"+
		"\u03e3\3\2\2\2\u0411\u03e8\3\2\2\2\u0411\u03f0\3\2\2\2\u0411\u03f8\3\2"+
		"\2\2\u0411\u0401\3\2\2\2\u0411\u040a\3\2\2\2\u0411\u040c\3\2\2\2\u0411"+
		"\u040d\3\2\2\2\u0411\u040e\3\2\2\2\u0411\u040f\3\2\2\2\u0412\17\3\2\2"+
		"\2\u0413\u0415\7N\2\2\u0414\u0416\7\u00ae\2\2\u0415\u0414\3\2\2\2\u0415"+
		"\u0416\3\2\2\2\u0416\u0418\3\2\2\2\u0417\u0419\7\u00d0\2\2\u0418\u0417"+
		"\3\2\2\2\u0418\u0419\3\2\2\2\u0419\u041a\3\2\2\2\u041a\u041e\7O\2\2\u041b"+
		"\u041c\7z\2\2\u041c\u041d\7 \2\2\u041d\u041f\7\"\2\2\u041e\u041b\3\2\2"+
		"\2\u041e\u041f\3\2\2\2\u041f\u0420\3\2\2\2\u0420\u0421\5x=\2\u0421\21"+
		"\3\2\2\2\u0422\u0423\7\u00c2\2\2\u0423\u0424\7\24\2\2\u0424\u0428\5f\64"+
		"\2\u0425\u0426\7\u00c3\2\2\u0426\u0427\7\24\2\2\u0427\u0429\5j\66\2\u0428"+
		"\u0425\3\2\2\2\u0428\u0429\3\2\2\2\u0429\u042a\3\2\2\2\u042a\u042b\7T"+
		"\2\2\u042b\u042c\7\u00fc\2\2\u042c\u042d\7\u00b3\2\2\u042d\23\3\2\2\2"+
		"\u042e\u042f\7\u00b4\2\2\u042f\u0430\7\24\2\2\u0430\u0431\5f\64\2\u0431"+
		"\u0434\7=\2\2\u0432\u0435\5\64\33\2\u0433\u0435\5\66\34\2\u0434\u0432"+
		"\3\2\2\2\u0434\u0433\3\2\2\2\u0435\u0439\3\2\2\2\u0436\u0437\7\u00b5\2"+
		"\2\u0437\u0438\7\17\2\2\u0438\u043a\7\u00b6\2\2\u0439\u0436\3\2\2\2\u0439"+
		"\u043a\3\2\2\2\u043a\25\3\2\2\2\u043b\u043c\7\u00b7\2\2\u043c\u043d\7"+
		"\u00f7\2\2\u043d\27\3\2\2\2\u043e\u0440\5&\24\2\u043f\u043e\3\2\2\2\u043f"+
		"\u0440\3\2\2\2\u0440\u0441\3\2\2\2\u0441\u0442\5@!\2\u0442\31\3\2\2\2"+
		"\u0443\u0444\7R\2\2\u0444\u0445\7\u0094\2\2\u0445\u0446\7O\2\2\u0446\u044d"+
		"\5x=\2\u0447\u044b\5\36\20\2\u0448\u0449\7z\2\2\u0449\u044a\7 \2\2\u044a"+
		"\u044c\7\"\2\2\u044b\u0448\3\2\2\2\u044b\u044c\3\2\2\2\u044c\u044e\3\2"+
		"\2\2\u044d\u0447\3\2\2\2\u044d\u044e\3\2\2\2\u044e\u0459\3\2\2\2\u044f"+
		"\u0450\7R\2\2\u0450\u0452\7T\2\2\u0451\u0453\7O\2\2\u0452\u0451\3\2\2"+
		"\2\u0452\u0453\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u0456\5x=\2\u0455\u0457"+
		"\5\36\20\2\u0456\u0455\3\2\2\2\u0456\u0457\3\2\2\2\u0457\u0459\3\2\2\2"+
		"\u0458\u0443\3\2\2\2\u0458\u044f\3\2\2\2\u0459\33\3\2\2\2\u045a\u045c"+
		"\5\36\20\2\u045b\u045d\5\26\f\2\u045c\u045b\3\2\2\2\u045c\u045d\3\2\2"+
		"\2\u045d\35\3\2\2\2\u045e\u045f\7A\2\2\u045f\u0460\7\3\2\2\u0460\u0465"+
		"\5 \21\2\u0461\u0462\7\5\2\2\u0462\u0464\5 \21\2\u0463\u0461\3\2\2\2\u0464"+
		"\u0467\3\2\2\2\u0465\u0463\3\2\2\2\u0465\u0466\3\2\2\2\u0466\u0468\3\2"+
		"\2\2\u0467\u0465\3\2\2\2\u0468\u0469\7\4\2\2\u0469\37\3\2\2\2\u046a\u046d"+
		"\5\u00c6d\2\u046b\u046c\7{\2\2\u046c\u046e\5\u009cO\2\u046d\u046b\3\2"+
		"\2\2\u046d\u046e\3\2\2\2\u046e!\3\2\2\2\u046f\u0475\5\u00c4c\2\u0470\u0475"+
		"\7\u00f7\2\2\u0471\u0475\5\u009eP\2\u0472\u0475\5\u00a0Q\2\u0473\u0475"+
		"\5\u00a2R\2\u0474\u046f\3\2\2\2\u0474\u0470\3\2\2\2\u0474\u0471\3\2\2"+
		"\2\u0474\u0472\3\2\2\2\u0474\u0473\3\2\2\2\u0475#\3\2\2\2\u0476\u047e"+
		"\5\u00c6d\2\u0477\u047a\7\6\2\2\u0478\u047b\5\u00c6d\2\u0479\u047b\7\u00f7"+
		"\2\2\u047a\u0478\3\2\2\2\u047a\u0479\3\2\2\2\u047b\u047d\3\2\2\2\u047c"+
		"\u0477\3\2\2\2\u047d\u0480\3\2\2\2\u047e\u047c\3\2\2\2\u047e\u047f\3\2"+
		"\2\2\u047f%\3\2\2\2\u0480\u047e\3\2\2\2\u0481\u0482\7L\2\2\u0482\u0487"+
		"\5(\25\2\u0483\u0484\7\5\2\2\u0484\u0486\5(\25\2\u0485\u0483\3\2\2\2\u0486"+
		"\u0489\3\2\2\2\u0487\u0485\3\2\2\2\u0487\u0488\3\2\2\2\u0488\'\3\2\2\2"+
		"\u0489\u0487\3\2\2\2\u048a\u048c\5\u00c6d\2\u048b\u048d\7\17\2\2\u048c"+
		"\u048b\3\2\2\2\u048c\u048d\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u048f\7\3"+
		"\2\2\u048f\u0490\5\30\r\2\u0490\u0491\7\4\2\2\u0491)\3\2\2\2\u0492\u0493"+
		"\7\u0097\2\2\u0493\u0494\5\u00c4c\2\u0494+\3\2\2\2\u0495\u0496\7\3\2\2"+
		"\u0496\u049b\5.\30\2\u0497\u0498\7\5\2\2\u0498\u049a\5.\30\2\u0499\u0497"+
		"\3\2\2\2\u049a\u049d\3\2\2\2\u049b\u0499\3\2\2\2\u049b\u049c\3\2\2\2\u049c"+
		"\u049e\3\2\2\2\u049d\u049b\3\2\2\2\u049e\u049f\7\4\2\2\u049f-\3\2\2\2"+
		"\u04a0\u04a5\5\60\31\2\u04a1\u04a3\7{\2\2\u04a2\u04a1\3\2\2\2\u04a2\u04a3"+
		"\3\2\2\2\u04a3\u04a4\3\2\2\2\u04a4\u04a6\5\62\32\2\u04a5\u04a2\3\2\2\2"+
		"\u04a5\u04a6\3\2\2\2\u04a6/\3\2\2\2\u04a7\u04ac\5\u00c6d\2\u04a8\u04a9"+
		"\7\6\2\2\u04a9\u04ab\5\u00c6d\2\u04aa\u04a8\3\2\2\2\u04ab\u04ae\3\2\2"+
		"\2\u04ac\u04aa\3\2\2\2\u04ac\u04ad\3\2\2\2\u04ad\u04b1\3\2\2\2\u04ae\u04ac"+
		"\3\2\2\2\u04af\u04b1\7\u00f7\2\2\u04b0\u04a7\3\2\2\2\u04b0\u04af\3\2\2"+
		"\2\u04b1\61\3\2\2\2\u04b2\u04b7\7\u00fc\2\2\u04b3\u04b7\7\u00fd\2\2\u04b4"+
		"\u04b7\5\u00a4S\2\u04b5\u04b7\7\u00f7\2\2\u04b6\u04b2\3\2\2\2\u04b6\u04b3"+
		"\3\2\2\2\u04b6\u04b4\3\2\2\2\u04b6\u04b5\3\2\2\2\u04b7\63\3\2\2\2\u04b8"+
		"\u04b9\7\3\2\2\u04b9\u04be\5\u009cO\2\u04ba\u04bb\7\5\2\2\u04bb\u04bd"+
		"\5\u009cO\2\u04bc\u04ba\3\2\2\2\u04bd\u04c0\3\2\2\2\u04be\u04bc\3\2\2"+
		"\2\u04be\u04bf\3\2\2\2\u04bf\u04c1\3\2\2\2\u04c0\u04be\3\2\2\2\u04c1\u04c2"+
		"\7\4\2\2\u04c2\65\3\2\2\2\u04c3\u04c4\7\3\2\2\u04c4\u04c9\5\64\33\2\u04c5"+
		"\u04c6\7\5\2\2\u04c6\u04c8\5\64\33\2\u04c7\u04c5\3\2\2\2\u04c8\u04cb\3"+
		"\2\2\2\u04c9\u04c7\3\2\2\2\u04c9\u04ca\3\2\2\2\u04ca\u04cc\3\2\2\2\u04cb"+
		"\u04c9\3\2\2\2\u04cc\u04cd\7\4\2\2\u04cd\67\3\2\2\2\u04ce\u04cf\7\u00b5"+
		"\2\2\u04cf\u04d0\7\17\2\2\u04d0\u04d5\5:\36\2\u04d1\u04d2\7\u00b5\2\2"+
		"\u04d2\u04d3\7\24\2\2\u04d3\u04d5\5<\37\2\u04d4\u04ce\3\2\2\2\u04d4\u04d1"+
		"\3\2\2\2\u04d59\3\2\2\2\u04d6\u04d7\7\u00c5\2\2\u04d7\u04d8\7\u00f7\2"+
		"\2\u04d8\u04d9\7\u00c6\2\2\u04d9\u04dc\7\u00f7\2\2\u04da\u04dc\5\u00c6"+
		"d\2\u04db\u04d6\3\2\2\2\u04db\u04da\3\2\2\2\u04dc;\3\2\2\2\u04dd\u04e1"+
		"\7\u00f7\2\2\u04de\u04df\7L\2\2\u04df\u04e0\7\u0099\2\2\u04e0\u04e2\5"+
		",\27\2\u04e1\u04de\3\2\2\2\u04e1\u04e2\3\2\2\2\u04e2=\3\2\2\2\u04e3\u04e4"+
		"\5\u00c6d\2\u04e4\u04e5\7\u00f7\2\2\u04e5?\3\2\2\2\u04e6\u04e8\5\32\16"+
		"\2\u04e7\u04e6\3\2\2\2\u04e7\u04e8\3\2\2\2\u04e8\u04e9\3\2\2\2\u04e9\u04ea"+
		"\5F$\2\u04ea\u04eb\5B\"\2\u04eb\u04f3\3\2\2\2\u04ec\u04ee\5R*\2\u04ed"+
		"\u04ef\5D#\2\u04ee\u04ed\3\2\2\2\u04ef\u04f0\3\2\2\2\u04f0\u04ee\3\2\2"+
		"\2\u04f0\u04f1\3\2\2\2\u04f1\u04f3\3\2\2\2\u04f2\u04e7\3\2\2\2\u04f2\u04ec"+
		"\3\2\2\2\u04f3A\3\2\2\2\u04f4\u04f5\7\31\2\2\u04f5\u04f6\7\24\2\2\u04f6"+
		"\u04fb\5J&\2\u04f7\u04f8\7\5\2\2\u04f8\u04fa\5J&\2\u04f9\u04f7\3\2\2\2"+
		"\u04fa\u04fd\3\2\2\2\u04fb\u04f9\3\2\2\2\u04fb\u04fc\3\2\2\2\u04fc\u04ff"+
		"\3\2\2\2\u04fd\u04fb\3\2\2\2\u04fe\u04f4\3\2\2\2\u04fe\u04ff\3\2\2\2\u04ff"+
		"\u050a\3\2\2\2\u0500\u0501\7\u0092\2\2\u0501\u0502\7\24\2\2\u0502\u0507"+
		"\5\u0080A\2\u0503\u0504\7\5\2\2\u0504\u0506\5\u0080A\2\u0505\u0503\3\2"+
		"\2\2\u0506\u0509\3\2\2\2\u0507\u0505\3\2\2\2\u0507\u0508\3\2\2\2\u0508"+
		"\u050b\3\2\2\2\u0509\u0507\3\2\2\2\u050a\u0500\3\2\2\2\u050a\u050b\3\2"+
		"\2\2\u050b\u0516\3\2\2\2\u050c\u050d\7\u0093\2\2\u050d\u050e\7\24\2\2"+
		"\u050e\u0513\5\u0080A\2\u050f\u0510\7\5\2\2\u0510\u0512\5\u0080A\2\u0511"+
		"\u050f\3\2\2\2\u0512\u0515\3\2\2\2\u0513\u0511\3\2\2\2\u0513\u0514\3\2"+
		"\2\2\u0514\u0517\3\2\2\2\u0515\u0513\3\2\2\2\u0516\u050c\3\2\2\2\u0516"+
		"\u0517\3\2\2\2\u0517\u0522\3\2\2\2\u0518\u0519\7\u0091\2\2\u0519\u051a"+
		"\7\24\2\2\u051a\u051f\5J&\2\u051b\u051c\7\5\2\2\u051c\u051e\5J&\2\u051d"+
		"\u051b\3\2\2\2\u051e\u0521\3\2\2\2\u051f\u051d\3\2\2\2\u051f\u0520\3\2"+
		"\2\2\u0520\u0523\3\2\2\2\u0521\u051f\3\2\2\2\u0522\u0518\3\2\2\2\u0522"+
		"\u0523\3\2\2\2\u0523\u0525\3\2\2\2\u0524\u0526\5\u00ba^\2\u0525\u0524"+
		"\3\2\2\2\u0525\u0526\3\2\2\2\u0526\u0529\3\2\2\2\u0527\u0528\7\33\2\2"+
		"\u0528\u052a\5\u0080A\2\u0529\u0527\3\2\2\2\u0529\u052a\3\2\2\2\u052a"+
		"C\3\2\2\2\u052b\u052d\5\32\16\2\u052c\u052b\3\2\2\2\u052c\u052d\3\2\2"+
		"\2\u052d\u052e\3\2\2\2\u052e\u052f\5L\'\2\u052f\u0530\5B\"\2\u0530E\3"+
		"\2\2\2\u0531\u0532\b$\1\2\u0532\u0533\5H%\2\u0533\u053c\3\2\2\2\u0534"+
		"\u0535\f\3\2\2\u0535\u0537\t\t\2\2\u0536\u0538\5Z.\2\u0537\u0536\3\2\2"+
		"\2\u0537\u0538\3\2\2\2\u0538\u0539\3\2\2\2\u0539\u053b\5F$\4\u053a\u0534"+
		"\3\2\2\2\u053b\u053e\3\2\2\2\u053c\u053a\3\2\2\2\u053c\u053d\3\2\2\2\u053d"+
		"G\3\2\2\2\u053e\u053c\3\2\2\2\u053f\u0548\5L\'\2\u0540\u0541\7O\2\2\u0541"+
		"\u0548\5x=\2\u0542\u0548\5t;\2\u0543\u0544\7\3\2\2\u0544\u0545\5@!\2\u0545"+
		"\u0546\7\4\2\2\u0546\u0548\3\2\2\2\u0547\u053f\3\2\2\2\u0547\u0540\3\2"+
		"\2\2\u0547\u0542\3\2\2\2\u0547\u0543\3\2\2\2\u0548I\3\2\2\2\u0549\u054b"+
		"\5\u0080A\2\u054a\u054c\t\n\2\2\u054b\u054a\3\2\2\2\u054b\u054c\3\2\2"+
		"\2\u054c\u054f\3\2\2\2\u054d\u054e\7*\2\2\u054e\u0550\t\13\2\2\u054f\u054d"+
		"\3\2\2\2\u054f\u0550\3\2\2\2\u0550K\3\2\2\2\u0551\u0552\7\f\2\2\u0552"+
		"\u0553\7\u0095\2\2\u0553\u0554\7\3\2\2\u0554\u0555\5~@\2\u0555\u0556\7"+
		"\4\2\2\u0556\u055c\3\2\2\2\u0557\u0558\7n\2\2\u0558\u055c\5~@\2\u0559"+
		"\u055a\7\u0096\2\2\u055a\u055c\5~@\2\u055b\u0551\3\2\2\2\u055b\u0557\3"+
		"\2\2\2\u055b\u0559\3\2\2\2\u055c\u055e\3\2\2\2\u055d\u055f\5v<\2\u055e"+
		"\u055d\3\2\2\2\u055e\u055f\3\2\2\2\u055f\u0562\3\2\2\2\u0560\u0561\7\u009b"+
		"\2\2\u0561\u0563\7\u00f7\2\2\u0562\u0560\3\2\2\2\u0562\u0563\3\2\2\2\u0563"+
		"\u0564\3\2\2\2\u0564\u0565\7\u0097\2\2\u0565\u0572\7\u00f7\2\2\u0566\u0570"+
		"\7\17\2\2\u0567\u0571\5h\65\2\u0568\u0571\5\u00b0Y\2\u0569\u056c\7\3\2"+
		"\2\u056a\u056d\5h\65\2\u056b\u056d\5\u00b0Y\2\u056c\u056a\3\2\2\2\u056c"+
		"\u056b\3\2\2\2\u056d\u056e\3\2\2\2\u056e\u056f\7\4\2\2\u056f\u0571\3\2"+
		"\2\2\u0570\u0567\3\2\2\2\u0570\u0568\3\2\2\2\u0570\u0569\3\2\2\2\u0571"+
		"\u0573\3\2\2\2\u0572\u0566\3\2\2\2\u0572\u0573\3\2\2\2\u0573\u0575\3\2"+
		"\2\2\u0574\u0576\5v<\2\u0575\u0574\3\2\2\2\u0575\u0576\3\2\2\2\u0576\u0579"+
		"\3\2\2\2\u0577\u0578\7\u009a\2\2\u0578\u057a\7\u00f7\2\2\u0579\u0577\3"+
		"\2\2\2\u0579\u057a\3\2\2\2\u057a\u057c\3\2\2\2\u057b\u057d\5R*\2\u057c"+
		"\u057b\3\2\2\2\u057c\u057d\3\2\2\2\u057d\u0580\3\2\2\2\u057e\u057f\7\22"+
		"\2\2\u057f\u0581\5\u0082B\2\u0580\u057e\3\2\2\2\u0580\u0581\3\2\2\2\u0581"+
		"\u05af\3\2\2\2\u0582\u0586\7\f\2\2\u0583\u0585\5N(\2\u0584\u0583\3\2\2"+
		"\2\u0585\u0588\3\2\2\2\u0586\u0584\3\2\2\2\u0586\u0587\3\2\2\2\u0587\u058a"+
		"\3\2\2\2\u0588\u0586\3\2\2\2\u0589\u058b\5Z.\2\u058a\u0589\3\2\2\2\u058a"+
		"\u058b\3\2\2\2\u058b\u058c\3\2\2\2\u058c\u058e\5~@\2\u058d\u058f\5R*\2"+
		"\u058e\u058d\3\2\2\2\u058e\u058f\3\2\2\2\u058f\u0599\3\2\2\2\u0590\u0596"+
		"\5R*\2\u0591\u0593\7\f\2\2\u0592\u0594\5Z.\2\u0593\u0592\3\2\2\2\u0593"+
		"\u0594\3\2\2\2\u0594\u0595\3\2\2\2\u0595\u0597\5~@\2\u0596\u0591\3\2\2"+
		"\2\u0596\u0597\3\2\2\2\u0597\u0599\3\2\2\2\u0598\u0582\3\2\2\2\u0598\u0590"+
		"\3\2\2\2\u0599\u059d\3\2\2\2\u059a\u059c\5X-\2\u059b\u059a\3\2\2\2\u059c"+
		"\u059f\3\2\2\2\u059d\u059b\3\2\2\2\u059d\u059e\3\2\2\2\u059e\u05a2\3\2"+
		"\2\2\u059f\u059d\3\2\2\2\u05a0\u05a1\7\22\2\2\u05a1\u05a3\5\u0082B\2\u05a2"+
		"\u05a0\3\2\2\2\u05a2\u05a3\3\2\2\2\u05a3\u05a5\3\2\2\2\u05a4\u05a6\5T"+
		"+\2\u05a5\u05a4\3\2\2\2\u05a5\u05a6\3\2\2\2\u05a6\u05a9\3\2\2\2\u05a7"+
		"\u05a8\7\32\2\2\u05a8\u05aa\5\u0082B\2\u05a9\u05a7\3\2\2\2\u05a9\u05aa"+
		"\3\2\2\2\u05aa\u05ac\3\2\2\2\u05ab\u05ad\5\u00ba^\2\u05ac\u05ab\3\2\2"+
		"\2\u05ac\u05ad\3\2\2\2\u05ad\u05af\3\2\2\2\u05ae\u055b\3\2\2\2\u05ae\u0598"+
		"\3\2\2\2\u05afM\3\2\2\2\u05b0\u05b1\7\7\2\2\u05b1\u05b8\5P)\2\u05b2\u05b4"+
		"\7\5\2\2\u05b3\u05b2\3\2\2\2\u05b3\u05b4\3\2\2\2\u05b4\u05b5\3\2\2\2\u05b5"+
		"\u05b7\5P)\2\u05b6\u05b3\3\2\2\2\u05b7\u05ba\3\2\2\2\u05b8\u05b6\3\2\2"+
		"\2\u05b8\u05b9\3\2\2\2\u05b9\u05bb\3\2\2\2\u05ba\u05b8\3\2\2\2\u05bb\u05bc"+
		"\7\b\2\2\u05bcO\3\2\2\2\u05bd\u05cb\5\u00c6d\2\u05be\u05bf\5\u00c6d\2"+
		"\u05bf\u05c0\7\3\2\2\u05c0\u05c5\5\u008eH\2\u05c1\u05c2\7\5\2\2\u05c2"+
		"\u05c4\5\u008eH\2\u05c3\u05c1\3\2\2\2\u05c4\u05c7\3\2\2\2\u05c5\u05c3"+
		"\3\2\2\2\u05c5\u05c6\3\2\2\2\u05c6\u05c8\3\2\2\2\u05c7\u05c5\3\2\2\2\u05c8"+
		"\u05c9\7\4\2\2\u05c9\u05cb\3\2\2\2\u05ca\u05bd\3\2\2\2\u05ca\u05be\3\2"+
		"\2\2\u05cbQ\3\2\2\2\u05cc\u05cd\7\r\2\2\u05cd\u05d2\5\\/\2\u05ce\u05cf"+
		"\7\5\2\2\u05cf\u05d1\5\\/\2\u05d0\u05ce\3\2\2\2\u05d1\u05d4\3\2\2\2\u05d2"+
		"\u05d0\3\2\2\2\u05d2\u05d3\3\2\2\2\u05d3\u05d8\3\2\2\2\u05d4\u05d2\3\2"+
		"\2\2\u05d5\u05d7\5X-\2\u05d6\u05d5\3\2\2\2\u05d7\u05da\3\2\2\2\u05d8\u05d6"+
		"\3\2\2\2\u05d8\u05d9\3\2\2\2\u05d9S\3\2\2\2\u05da\u05d8\3\2\2\2\u05db"+
		"\u05dc\7\23\2\2\u05dc\u05dd\7\24\2\2\u05dd\u05e2\5\u0080A\2\u05de\u05df"+
		"\7\5\2\2\u05df\u05e1\5\u0080A\2\u05e0\u05de\3\2\2\2\u05e1\u05e4\3\2\2"+
		"\2\u05e2\u05e0\3\2\2\2\u05e2\u05e3\3\2\2\2\u05e3\u05f6\3\2\2\2\u05e4\u05e2"+
		"\3\2\2\2\u05e5\u05e6\7L\2\2\u05e6\u05f7\7\30\2\2\u05e7\u05e8\7L\2\2\u05e8"+
		"\u05f7\7\27\2\2\u05e9\u05ea\7\25\2\2\u05ea\u05eb\7\26\2\2\u05eb\u05ec"+
		"\7\3\2\2\u05ec\u05f1\5V,\2\u05ed\u05ee\7\5\2\2\u05ee\u05f0\5V,\2\u05ef"+
		"\u05ed\3\2\2\2\u05f0\u05f3\3\2\2\2\u05f1\u05ef\3\2\2\2\u05f1\u05f2\3\2"+
		"\2\2\u05f2\u05f4\3\2\2\2\u05f3\u05f1\3\2\2\2\u05f4\u05f5\7\4\2\2\u05f5"+
		"\u05f7\3\2\2\2\u05f6\u05e5\3\2\2\2\u05f6\u05e7\3\2\2\2\u05f6\u05e9\3\2"+
		"\2\2\u05f6\u05f7\3\2\2\2\u05f7U\3\2\2\2\u05f8\u0601\7\3\2\2\u05f9\u05fe"+
		"\5\u0080A\2\u05fa\u05fb\7\5\2\2\u05fb\u05fd\5\u0080A\2\u05fc\u05fa\3\2"+
		"\2\2\u05fd\u0600\3\2\2\2\u05fe\u05fc\3\2\2\2\u05fe\u05ff\3\2\2\2\u05ff"+
		"\u0602\3\2\2\2\u0600\u05fe\3\2\2\2\u0601\u05f9\3\2\2\2\u0601\u0602\3\2"+
		"\2\2\u0602\u0603\3\2\2\2\u0603\u0606\7\4\2\2\u0604\u0606\5\u0080A\2\u0605"+
		"\u05f8\3\2\2\2\u0605\u0604\3\2\2\2\u0606W\3\2\2\2\u0607\u0608\7>\2\2\u0608"+
		"\u060a\7P\2\2\u0609\u060b\7\66\2\2\u060a\u0609\3\2\2\2\u060a\u060b\3\2"+
		"\2\2\u060b\u060c\3\2\2\2\u060c\u060d\5\u00c4c\2\u060d\u0616\7\3\2\2\u060e"+
		"\u0613\5\u0080A\2\u060f\u0610\7\5\2\2\u0610\u0612\5\u0080A\2\u0611\u060f"+
		"\3\2\2\2\u0612\u0615\3\2\2\2\u0613\u0611\3\2\2\2\u0613\u0614\3\2\2\2\u0614"+
		"\u0617\3\2\2\2\u0615\u0613\3\2\2\2\u0616\u060e\3\2\2\2\u0616\u0617\3\2"+
		"\2\2\u0617\u0618\3\2\2\2\u0618\u0619\7\4\2\2\u0619\u0625\5\u00c6d\2\u061a"+
		"\u061c\7\17\2\2\u061b\u061a\3\2\2\2\u061b\u061c\3\2\2\2\u061c\u061d\3"+
		"\2\2\2\u061d\u0622\5\u00c6d\2\u061e\u061f\7\5\2\2\u061f\u0621\5\u00c6"+
		"d\2\u0620\u061e\3\2\2\2\u0621\u0624\3\2\2\2\u0622\u0620\3\2\2\2\u0622"+
		"\u0623\3\2\2\2\u0623\u0626\3\2\2\2\u0624\u0622\3\2\2\2\u0625\u061b\3\2"+
		"\2\2\u0625\u0626\3\2\2\2\u0626Y\3\2\2\2\u0627\u0628\t\f\2\2\u0628[\3\2"+
		"\2\2\u0629\u062d\5r:\2\u062a\u062c\5^\60\2\u062b\u062a\3\2\2\2\u062c\u062f"+
		"\3\2\2\2\u062d\u062b\3\2\2\2\u062d\u062e\3\2\2\2\u062e]\3\2\2\2\u062f"+
		"\u062d\3\2\2\2\u0630\u0631\5`\61\2\u0631\u0632\7\64\2\2\u0632\u0634\5"+
		"r:\2\u0633\u0635\5b\62\2\u0634\u0633\3\2\2\2\u0634\u0635\3\2\2\2\u0635"+
		"\u063c\3\2\2\2\u0636\u0637\7<\2\2\u0637\u0638\5`\61\2\u0638\u0639\7\64"+
		"\2\2\u0639\u063a\5r:\2\u063a\u063c\3\2\2\2\u063b\u0630\3\2\2\2\u063b\u0636"+
		"\3\2\2\2\u063c_\3\2\2\2\u063d\u063f\7\67\2\2\u063e\u063d\3\2\2\2\u063e"+
		"\u063f\3\2\2\2\u063f\u0654\3\2\2\2\u0640\u0654\7\65\2\2\u0641\u0643\7"+
		"8\2\2\u0642\u0644\7\66\2\2\u0643\u0642\3\2\2\2\u0643\u0644\3\2\2\2\u0644"+
		"\u0654\3\2\2\2\u0645\u0646\78\2\2\u0646\u0654\79\2\2\u0647\u0649\7:\2"+
		"\2\u0648\u064a\7\66\2\2\u0649\u0648\3\2\2\2\u0649\u064a\3\2\2\2\u064a"+
		"\u0654\3\2\2\2\u064b\u064d\7;\2\2\u064c\u064e\7\66\2\2\u064d\u064c\3\2"+
		"\2\2\u064d\u064e\3\2\2\2\u064e\u0654\3\2\2\2\u064f\u0651\78\2\2\u0650"+
		"\u064f\3\2\2\2\u0650\u0651\3\2\2\2\u0651\u0652\3\2\2\2\u0652\u0654\7\u00e5"+
		"\2\2\u0653\u063e\3\2\2\2\u0653\u0640\3\2\2\2\u0653\u0641\3\2\2\2\u0653"+
		"\u0645\3\2\2\2\u0653\u0647\3\2\2\2\u0653\u064b\3\2\2\2\u0653\u0650\3\2"+
		"\2\2\u0654a\3\2\2\2\u0655\u0656\7=\2\2\u0656\u0664\5\u0082B\2\u0657\u0658"+
		"\7\u0097\2\2\u0658\u0659\7\3\2\2\u0659\u065e\5\u00c6d\2\u065a\u065b\7"+
		"\5\2\2\u065b\u065d\5\u00c6d\2\u065c\u065a\3\2\2\2\u065d\u0660\3\2\2\2"+
		"\u065e\u065c\3\2\2\2\u065e\u065f\3\2\2\2\u065f\u0661\3\2\2\2\u0660\u065e"+
		"\3\2\2\2\u0661\u0662\7\4\2\2\u0662\u0664\3\2\2\2\u0663\u0655\3\2\2\2\u0663"+
		"\u0657\3\2\2\2\u0664c\3\2\2\2\u0665\u0666\7i\2\2\u0666\u067c\7\3\2\2\u0667"+
		"\u0668\t\r\2\2\u0668\u067d\7\u008d\2\2\u0669\u066a\5\u0080A\2\u066a\u066b"+
		"\7C\2\2\u066b\u067d\3\2\2\2\u066c\u067d\7\u00fb\2\2\u066d\u066e\7\u008e"+
		"\2\2\u066e\u066f\7\u00fc\2\2\u066f\u0670\7\u008f\2\2\u0670\u0671\7\u0090"+
		"\2\2\u0671\u067a\7\u00fc\2\2\u0672\u0678\7=\2\2\u0673\u0679\5\u00c6d\2"+
		"\u0674\u0675\5\u00c4c\2\u0675\u0676\7\3\2\2\u0676\u0677\7\4\2\2\u0677"+
		"\u0679\3\2\2\2\u0678\u0673\3\2\2\2\u0678\u0674\3\2\2\2\u0679\u067b\3\2"+
		"\2\2\u067a\u0672\3\2\2\2\u067a\u067b\3\2\2\2\u067b\u067d\3\2\2\2\u067c"+
		"\u0667\3\2\2\2\u067c\u0669\3\2\2\2\u067c\u066c\3\2\2\2\u067c\u066d\3\2"+
		"\2\2\u067d\u067e\3\2\2\2\u067e\u067f\7\4\2\2\u067fe\3\2\2\2\u0680\u0681"+
		"\7\3\2\2\u0681\u0682\5h\65\2\u0682\u0683\7\4\2\2\u0683g\3\2\2\2\u0684"+
		"\u0689\5\u00c6d\2\u0685\u0686\7\5\2\2\u0686\u0688\5\u00c6d\2\u0687\u0685"+
		"\3\2\2\2\u0688\u068b\3\2\2\2\u0689\u0687\3\2\2\2\u0689\u068a\3\2\2\2\u068a"+
		"i\3\2\2\2\u068b\u0689\3\2\2\2\u068c\u068d\7\3\2\2\u068d\u0692\5l\67\2"+
		"\u068e\u068f\7\5\2\2\u068f\u0691\5l\67\2\u0690\u068e\3\2\2\2\u0691\u0694"+
		"\3\2\2\2\u0692\u0690\3\2\2\2\u0692\u0693\3\2\2\2\u0693\u0695\3\2\2\2\u0694"+
		"\u0692\3\2\2\2\u0695\u0696\7\4\2\2\u0696k\3\2\2\2\u0697\u0699\5\u00c6"+
		"d\2\u0698\u069a\t\n\2\2\u0699\u0698\3\2\2\2\u0699\u069a\3\2\2\2\u069a"+
		"m\3\2\2\2\u069b\u069c\7\3\2\2\u069c\u06a1\5p9\2\u069d\u069e\7\5\2\2\u069e"+
		"\u06a0\5p9\2\u069f\u069d\3\2\2\2\u06a0\u06a3\3\2\2\2\u06a1\u069f\3\2\2"+
		"\2\u06a1\u06a2\3\2\2\2\u06a2\u06a4\3\2\2\2\u06a3\u06a1\3\2\2\2\u06a4\u06a5"+
		"\7\4\2\2\u06a5o\3\2\2\2\u06a6\u06a9\5\u00c6d\2\u06a7\u06a8\7p\2\2\u06a8"+
		"\u06aa\7\u00f7\2\2\u06a9\u06a7\3\2\2\2\u06a9\u06aa\3\2\2\2\u06aaq\3\2"+
		"\2\2\u06ab\u06ad\5x=\2\u06ac\u06ae\5d\63\2\u06ad\u06ac\3\2\2\2\u06ad\u06ae"+
		"\3\2\2\2\u06ae\u06b3\3\2\2\2\u06af\u06b1\7\17\2\2\u06b0\u06af\3\2\2\2"+
		"\u06b0\u06b1\3\2\2\2\u06b1\u06b2\3\2\2\2\u06b2\u06b4\5\u00c8e\2\u06b3"+
		"\u06b0\3\2\2\2\u06b3\u06b4\3\2\2\2\u06b4\u06dd\3\2\2\2\u06b5\u06b6\7\3"+
		"\2\2\u06b6\u06b7\5@!\2\u06b7\u06b9\7\4\2\2\u06b8\u06ba\5d\63\2\u06b9\u06b8"+
		"\3\2\2\2\u06b9\u06ba\3\2\2\2\u06ba\u06bf\3\2\2\2\u06bb\u06bd\7\17\2\2"+
		"\u06bc\u06bb\3\2\2\2\u06bc\u06bd\3\2\2\2\u06bd\u06be\3\2\2\2\u06be\u06c0"+
		"\5\u00c8e\2\u06bf\u06bc\3\2\2\2\u06bf\u06c0\3\2\2\2\u06c0\u06dd\3\2\2"+
		"\2\u06c1\u06c2\7\3\2\2\u06c2\u06c3\5\\/\2\u06c3\u06c5\7\4\2\2\u06c4\u06c6"+
		"\5d\63\2\u06c5\u06c4\3\2\2\2\u06c5\u06c6\3\2\2\2\u06c6\u06cb\3\2\2\2\u06c7"+
		"\u06c9\7\17\2\2\u06c8\u06c7\3\2\2\2\u06c8\u06c9\3\2\2\2\u06c9\u06ca\3"+
		"\2\2\2\u06ca\u06cc\5\u00c8e\2\u06cb\u06c8\3\2\2\2\u06cb\u06cc\3\2\2\2"+
		"\u06cc\u06dd\3\2\2\2\u06cd\u06dd\5t;\2\u06ce\u06cf\5\u00c6d\2\u06cf\u06d8"+
		"\7\3\2\2\u06d0\u06d5\5\u0080A\2\u06d1\u06d2\7\5\2\2\u06d2\u06d4\5\u0080"+
		"A\2\u06d3\u06d1\3\2\2\2\u06d4\u06d7\3\2\2\2\u06d5\u06d3\3\2\2\2\u06d5"+
		"\u06d6\3\2\2\2\u06d6\u06d9\3\2\2\2\u06d7\u06d5\3\2\2\2\u06d8\u06d0\3\2"+
		"\2\2\u06d8\u06d9\3\2\2\2\u06d9\u06da\3\2\2\2\u06da\u06db\7\4\2\2\u06db"+
		"\u06dd\3\2\2\2\u06dc\u06ab\3\2\2\2\u06dc\u06b5\3\2\2\2\u06dc\u06c1\3\2"+
		"\2\2\u06dc\u06cd\3\2\2\2\u06dc\u06ce\3\2\2\2\u06dds\3\2\2\2\u06de\u06df"+
		"\7M\2\2\u06df\u06e4\5\u0080A\2\u06e0\u06e1\7\5\2\2\u06e1\u06e3\5\u0080"+
		"A\2\u06e2\u06e0\3\2\2\2\u06e3\u06e6\3\2\2\2\u06e4\u06e2\3\2\2\2\u06e4"+
		"\u06e5\3\2\2\2\u06e5\u06ee\3\2\2\2\u06e6\u06e4\3\2\2\2\u06e7\u06e9\7\17"+
		"\2\2\u06e8\u06e7\3\2\2\2\u06e8\u06e9\3\2\2\2\u06e9\u06ea\3\2\2\2\u06ea"+
		"\u06ec\5\u00c6d\2\u06eb\u06ed\5f\64\2\u06ec\u06eb\3\2\2\2\u06ec\u06ed"+
		"\3\2\2\2\u06ed\u06ef\3\2\2\2\u06ee\u06e8\3\2\2\2\u06ee\u06ef\3\2\2\2\u06ef"+
		"u\3\2\2\2\u06f0\u06f1\7K\2\2\u06f1\u06f2\7W\2\2\u06f2\u06f3\7\u0098\2"+
		"\2\u06f3\u06f7\7\u00f7\2\2\u06f4\u06f5\7L\2\2\u06f5\u06f6\7\u0099\2\2"+
		"\u06f6\u06f8\5,\27\2\u06f7\u06f4\3\2\2\2\u06f7\u06f8\3\2\2\2\u06f8\u0722"+
		"\3\2\2\2\u06f9\u06fa\7K\2\2\u06fa\u06fb\7W\2\2\u06fb\u0705\7\u009c\2\2"+
		"\u06fc\u06fd\7\u009d\2\2\u06fd\u06fe\7\u009e\2\2\u06fe\u06ff\7\24\2\2"+
		"\u06ff\u0703\7\u00f7\2\2\u0700\u0701\7\u00a2\2\2\u0701\u0702\7\24\2\2"+
		"\u0702\u0704\7\u00f7\2\2\u0703\u0700\3\2\2\2\u0703\u0704\3\2\2\2\u0704"+
		"\u0706\3\2\2\2\u0705\u06fc\3\2\2\2\u0705\u0706\3\2\2\2\u0706\u070c\3\2"+
		"\2\2\u0707\u0708\7\u009f\2\2\u0708\u0709\7\u00a0\2\2\u0709\u070a\7\u009e"+
		"\2\2\u070a\u070b\7\24\2\2\u070b\u070d\7\u00f7\2\2\u070c\u0707\3\2\2\2"+
		"\u070c\u070d\3\2\2\2\u070d\u0713\3\2\2\2\u070e\u070f\7n\2\2\u070f\u0710"+
		"\7\u00a1\2\2\u0710\u0711\7\u009e\2\2\u0711\u0712\7\24\2\2\u0712\u0714"+
		"\7\u00f7\2\2\u0713\u070e\3\2\2\2\u0713\u0714\3\2\2\2\u0714\u0719\3\2\2"+
		"\2\u0715\u0716\7\u00a3\2\2\u0716\u0717\7\u009e\2\2\u0717\u0718\7\24\2"+
		"\2\u0718\u071a\7\u00f7\2\2\u0719\u0715\3\2\2\2\u0719\u071a\3\2\2\2\u071a"+
		"\u071f\3\2\2\2\u071b\u071c\7\'\2\2\u071c\u071d\7\u00d1\2\2\u071d\u071e"+
		"\7\17\2\2\u071e\u0720\7\u00f7\2\2\u071f\u071b\3\2\2\2\u071f\u0720\3\2"+
		"\2\2\u0720\u0722\3\2\2\2\u0721\u06f0\3\2\2\2\u0721\u06f9\3\2\2\2\u0722"+
		"w\3\2\2\2\u0723\u0724\5\u00c6d\2\u0724\u0725\7\6\2\2\u0725\u0727\3\2\2"+
		"\2\u0726\u0723\3\2\2\2\u0726\u0727\3\2\2\2\u0727\u0728\3\2\2\2\u0728\u0729"+
		"\5\u00c6d\2\u0729y\3\2\2\2\u072a\u072b\5\u00c6d\2\u072b\u072c\7\6\2\2"+
		"\u072c\u072e\3\2\2\2\u072d\u072a\3\2\2\2\u072d\u072e\3\2\2\2\u072e\u072f"+
		"\3\2\2\2\u072f\u0730\5\u00c6d\2\u0730{\3\2\2\2\u0731\u0739\5\u0080A\2"+
		"\u0732\u0734\7\17\2\2\u0733\u0732\3\2\2\2\u0733\u0734\3\2\2\2\u0734\u0737"+
		"\3\2\2\2\u0735\u0738\5\u00c6d\2\u0736\u0738\5f\64\2\u0737\u0735\3\2\2"+
		"\2\u0737\u0736\3\2\2\2\u0738\u073a\3\2\2\2\u0739\u0733\3\2\2\2\u0739\u073a"+
		"\3\2\2\2\u073a}\3\2\2\2\u073b\u0740\5|?\2\u073c\u073d\7\5\2\2\u073d\u073f"+
		"\5|?\2\u073e\u073c\3\2\2\2\u073f\u0742\3\2\2\2\u0740\u073e\3\2\2\2\u0740"+
		"\u0741\3\2\2\2\u0741\177\3\2\2\2\u0742\u0740\3\2\2\2\u0743\u0744\5\u0082"+
		"B\2\u0744\u0081\3\2\2\2\u0745\u0746\bB\1\2\u0746\u0747\7 \2\2\u0747\u074f"+
		"\5\u0082B\7\u0748\u0749\7\"\2\2\u0749\u074a\7\3\2\2\u074a\u074b\5\30\r"+
		"\2\u074b\u074c\7\4\2\2\u074c\u074f\3\2\2\2\u074d\u074f\5\u0084C\2\u074e"+
		"\u0745\3\2\2\2\u074e\u0748\3\2\2\2\u074e\u074d\3\2\2\2\u074f\u0758\3\2"+
		"\2\2\u0750\u0751\f\4\2\2\u0751\u0752\7\36\2\2\u0752\u0757\5\u0082B\5\u0753"+
		"\u0754\f\3\2\2\u0754\u0755\7\35\2\2\u0755\u0757\5\u0082B\4\u0756\u0750"+
		"\3\2\2\2\u0756\u0753\3\2\2\2\u0757\u075a\3\2\2\2\u0758\u0756\3\2\2\2\u0758"+
		"\u0759\3\2\2\2\u0759\u0083\3\2\2\2\u075a\u0758\3\2\2\2\u075b\u075d\5\u008c"+
		"G\2\u075c\u075e\5\u0086D\2\u075d\u075c\3\2\2\2\u075d\u075e\3\2\2\2\u075e"+
		"\u0085\3\2\2\2\u075f\u0761\7 \2\2\u0760\u075f\3\2\2\2\u0760\u0761\3\2"+
		"\2\2\u0761\u0762\3\2\2\2\u0762\u0763\7#\2\2\u0763\u0764\5\u008cG\2\u0764"+
		"\u0765\7\36\2\2\u0765\u0766\5\u008cG\2\u0766\u0789\3\2\2\2\u0767\u0769"+
		"\7 \2\2\u0768\u0767\3\2\2\2\u0768\u0769\3\2\2\2\u0769\u076a\3\2\2\2\u076a"+
		"\u076b\7\37\2\2\u076b\u076c\7\3\2\2\u076c\u0771\5\u0080A\2\u076d\u076e"+
		"\7\5\2\2\u076e\u0770\5\u0080A\2\u076f\u076d\3\2\2\2\u0770\u0773\3\2\2"+
		"\2\u0771\u076f\3\2\2\2\u0771\u0772\3\2\2\2\u0772\u0774\3\2\2\2\u0773\u0771"+
		"\3\2\2\2\u0774\u0775\7\4\2\2\u0775\u0789\3\2\2\2\u0776\u0778\7 \2\2\u0777"+
		"\u0776\3\2\2\2\u0777\u0778\3\2\2\2\u0778\u0779\3\2\2\2\u0779\u077a\7\37"+
		"\2\2\u077a\u077b\7\3\2\2\u077b\u077c\5\30\r\2\u077c\u077d\7\4\2\2\u077d"+
		"\u0789\3\2\2\2\u077e\u0780\7 \2\2\u077f\u077e\3\2\2\2\u077f\u0780\3\2"+
		"\2\2\u0780\u0781\3\2\2\2\u0781\u0782\t\16\2\2\u0782\u0789\5\u008cG\2\u0783"+
		"\u0785\7&\2\2\u0784\u0786\7 \2\2\u0785\u0784\3\2\2\2\u0785\u0786\3\2\2"+
		"\2\u0786\u0787\3\2\2\2\u0787\u0789\7\'\2\2\u0788\u0760\3\2\2\2\u0788\u0768"+
		"\3\2\2\2\u0788\u0777\3\2\2\2\u0788\u077f\3\2\2\2\u0788\u0783\3\2\2\2\u0789"+
		"\u0087\3\2\2\2\u078a\u078b\7\u00eb\2\2\u078b\u0089\3\2\2\2\u078c\u078d"+
		"\t\17\2\2\u078d\u008b\3\2\2\2\u078e\u078f\bG\1\2\u078f\u0790\5\u0090I"+
		"\2\u0790\u0791\7\u0080\2\2\u0791\u0792\5\u00ccg\2\u0792\u07b1\3\2\2\2"+
		"\u0793\u0794\5\u0090I\2\u0794\u0795\7\u00f2\2\2\u0795\u0796\5\u00ccg\2"+
		"\u0796\u07b1\3\2\2\2\u0797\u0798\5\u0096L\2\u0798\u0799\7\u00f2\2\2\u0799"+
		"\u079a\5\u00ccg\2\u079a\u07b1\3\2\2\2\u079b\u079c\5\u008eH\2\u079c\u079d"+
		"\7\37\2\2\u079d\u079e\7\u00f5\2\2\u079e\u079f\7\3\2\2\u079f\u07a0\5\u0092"+
		"J\2\u07a0\u07a1\7\5\2\2\u07a1\u07a2\5\u0092J\2\u07a2\u07a3\7\4\2\2\u07a3"+
		"\u07b1\3\2\2\2\u07a4\u07a5\5\u008eH\2\u07a5\u07a6\7\37\2\2\u07a6\u07a7"+
		"\7\u00f6\2\2\u07a7\u07a8\7\3\2\2\u07a8\u07a9\5\u0092J\2\u07a9\u07aa\7"+
		"\5\2\2\u07aa\u07ab\5\u00ccg\2\u07ab\u07ac\7\4\2\2\u07ac\u07b1\3\2\2\2"+
		"\u07ad\u07b1\5\u008eH\2\u07ae\u07af\t\20\2\2\u07af\u07b1\5\u008cG\t\u07b0"+
		"\u078e\3\2\2\2\u07b0\u0793\3\2\2\2\u07b0\u0797\3\2\2\2\u07b0\u079b\3\2"+
		"\2\2\u07b0\u07a4\3\2\2\2\u07b0\u07ad\3\2\2\2\u07b0\u07ae\3\2\2\2\u07b1"+
		"\u07c7\3\2\2\2\u07b2\u07b3\f\b\2\2\u07b3\u07b4\t\21\2\2\u07b4\u07c6\5"+
		"\u008cG\t\u07b5\u07b6\f\7\2\2\u07b6\u07b7\t\22\2\2\u07b7\u07c6\5\u008c"+
		"G\b\u07b8\u07b9\f\6\2\2\u07b9\u07ba\7\u008a\2\2\u07ba\u07c6\5\u008cG\7"+
		"\u07bb\u07bc\f\5\2\2\u07bc\u07bd\7\u008c\2\2\u07bd\u07c6\5\u008cG\6\u07be"+
		"\u07bf\f\4\2\2\u07bf\u07c0\7\u008b\2\2\u07c0\u07c6\5\u008cG\5\u07c1\u07c2"+
		"\f\3\2\2\u07c2\u07c3\5\u009eP\2\u07c3\u07c4\5\u008cG\4\u07c4\u07c6\3\2"+
		"\2\2\u07c5\u07b2\3\2\2\2\u07c5\u07b5\3\2\2\2\u07c5\u07b8\3\2\2\2\u07c5"+
		"\u07bb\3\2\2\2\u07c5\u07be\3\2\2\2\u07c5\u07c1\3\2\2\2\u07c6\u07c9\3\2"+
		"\2\2\u07c7\u07c5\3\2\2\2\u07c7\u07c8\3\2\2\2\u07c8\u008d\3\2\2\2\u07c9"+
		"\u07c7\3\2\2\2\u07ca\u07cb\bH\1\2\u07cb\u0839\t\23\2\2\u07cc\u07ce\7/"+
		"\2\2\u07cd\u07cf\5\u00b8]\2\u07ce\u07cd\3\2\2\2\u07cf\u07d0\3\2\2\2\u07d0"+
		"\u07ce\3\2\2\2\u07d0\u07d1\3\2\2\2\u07d1\u07d4\3\2\2\2\u07d2\u07d3\7\62"+
		"\2\2\u07d3\u07d5\5\u0080A\2\u07d4\u07d2\3\2\2\2\u07d4\u07d5\3\2\2\2\u07d5"+
		"\u07d6\3\2\2\2\u07d6\u07d7\7\63\2\2\u07d7\u0839\3\2\2\2\u07d8\u07d9\7"+
		"/\2\2\u07d9\u07db\5\u0080A\2\u07da\u07dc\5\u00b8]\2\u07db\u07da\3\2\2"+
		"\2\u07dc\u07dd\3\2\2\2\u07dd\u07db\3\2\2\2\u07dd\u07de\3\2\2\2\u07de\u07e1"+
		"\3\2\2\2\u07df\u07e0\7\62\2\2\u07e0\u07e2\5\u0080A\2\u07e1\u07df\3\2\2"+
		"\2\u07e1\u07e2\3\2\2\2\u07e2\u07e3\3\2\2\2\u07e3\u07e4\7\63\2\2\u07e4"+
		"\u0839\3\2\2\2\u07e5\u07e6\7[\2\2\u07e6\u07e7\7\3\2\2\u07e7\u07e8\5\u0080"+
		"A\2\u07e8\u07e9\7\17\2\2\u07e9\u07ea\5\u00aeX\2\u07ea\u07eb\7\4\2\2\u07eb"+
		"\u0839\3\2\2\2\u07ec\u07ed\7o\2\2\u07ed\u07f6\7\3\2\2\u07ee\u07f3\5|?"+
		"\2\u07ef\u07f0\7\5\2\2\u07f0\u07f2\5|?\2\u07f1\u07ef\3\2\2\2\u07f2\u07f5"+
		"\3\2\2\2\u07f3\u07f1\3\2\2\2\u07f3\u07f4\3\2\2\2\u07f4\u07f7\3\2\2\2\u07f5"+
		"\u07f3\3\2\2\2\u07f6\u07ee\3\2\2\2\u07f6\u07f7\3\2\2\2\u07f7\u07f8\3\2"+
		"\2\2\u07f8\u0839\7\4\2\2\u07f9\u07fa\7H\2\2\u07fa\u07fb\7\3\2\2\u07fb"+
		"\u07fe\5\u0080A\2\u07fc\u07fd\7y\2\2\u07fd\u07ff\7*\2\2\u07fe\u07fc\3"+
		"\2\2\2\u07fe\u07ff\3\2\2\2\u07ff\u0800\3\2\2\2\u0800\u0801\7\4\2\2\u0801"+
		"\u0839\3\2\2\2\u0802\u0803\7J\2\2\u0803\u0804\7\3\2\2\u0804\u0807\5\u0080"+
		"A\2\u0805\u0806\7y\2\2\u0806\u0808\7*\2\2\u0807\u0805\3\2\2\2\u0807\u0808"+
		"\3\2\2\2\u0808\u0809\3\2\2\2\u0809\u080a\7\4\2\2\u080a\u0839\3\2\2\2\u080b"+
		"\u0839\5\u009cO\2\u080c\u0839\7\u0085\2\2\u080d\u080e\5\u00c4c\2\u080e"+
		"\u080f\7\6\2\2\u080f\u0810\7\u0085\2\2\u0810\u0839\3\2\2\2\u0811\u0812"+
		"\7\3\2\2\u0812\u0815\5|?\2\u0813\u0814\7\5\2\2\u0814\u0816\5|?\2\u0815"+
		"\u0813\3\2\2\2\u0816\u0817\3\2\2\2\u0817\u0815\3\2\2\2\u0817\u0818\3\2"+
		"\2\2\u0818\u0819\3\2\2\2\u0819\u081a\7\4\2\2\u081a\u0839\3\2\2\2\u081b"+
		"\u081c\7\3\2\2\u081c\u081d\5\30\r\2\u081d\u081e\7\4\2\2\u081e\u0839\3"+
		"\2\2\2\u081f\u0820\5\u00c4c\2\u0820\u082c\7\3\2\2\u0821\u0823\5Z.\2\u0822"+
		"\u0821\3\2\2\2\u0822\u0823\3\2\2\2\u0823\u0824\3\2\2\2\u0824\u0829\5\u0080"+
		"A\2\u0825\u0826\7\5\2\2\u0826\u0828\5\u0080A\2\u0827\u0825\3\2\2\2\u0828"+
		"\u082b\3\2\2\2\u0829\u0827\3\2\2\2\u0829\u082a\3\2\2\2\u082a\u082d\3\2"+
		"\2\2\u082b\u0829\3\2\2\2\u082c\u0822\3\2\2\2\u082c\u082d\3\2\2\2\u082d"+
		"\u082e\3\2\2\2\u082e\u0831\7\4\2\2\u082f\u0830\7@\2\2\u0830\u0832\5\u00be"+
		"`\2\u0831\u082f\3\2\2\2\u0831\u0832\3\2\2\2\u0832\u0839\3\2\2\2\u0833"+
		"\u0839\5\u00c6d\2\u0834\u0835\7\3\2\2\u0835\u0836\5\u0080A\2\u0836\u0837"+
		"\7\4\2\2\u0837\u0839\3\2\2\2\u0838\u07ca\3\2\2\2\u0838\u07cc\3\2\2\2\u0838"+
		"\u07d8\3\2\2\2\u0838\u07e5\3\2\2\2\u0838\u07ec\3\2\2\2\u0838\u07f9\3\2"+
		"\2\2\u0838\u0802\3\2\2\2\u0838\u080b\3\2\2\2\u0838\u080c\3\2\2\2\u0838"+
		"\u080d\3\2\2\2\u0838\u0811\3\2\2\2\u0838\u081b\3\2\2\2\u0838\u081f\3\2"+
		"\2\2\u0838\u0833\3\2\2\2\u0838\u0834\3\2\2\2\u0839\u0844\3\2\2\2\u083a"+
		"\u083b\f\6\2\2\u083b\u083c\7\t\2\2\u083c\u083d\5\u008cG\2\u083d\u083e"+
		"\7\n\2\2\u083e\u0843\3\2\2\2\u083f\u0840\f\4\2\2\u0840\u0841\7\6\2\2\u0841"+
		"\u0843\5\u00c6d\2\u0842\u083a\3\2\2\2\u0842\u083f\3\2\2\2\u0843\u0846"+
		"\3\2\2\2\u0844\u0842\3\2\2\2\u0844\u0845\3\2\2\2\u0845\u008f\3\2\2\2\u0846"+
		"\u0844\3\2\2\2\u0847\u0848\5\u008aF\2\u0848\u0849\7\3\2\2\u0849\u084a"+
		"\5\u008eH\2\u084a\u084b\7\5\2\2\u084b\u084c\5\u008eH\2\u084c\u084d\7\4"+
		"\2\2\u084d\u085d\3\2\2\2\u084e\u084f\5\u008aF\2\u084f\u0850\7\3\2\2\u0850"+
		"\u0851\5\u0094K\2\u0851\u0852\7\5\2\2\u0852\u0853\5\u008eH\2\u0853\u0854"+
		"\7\4\2\2\u0854\u085d\3\2\2\2\u0855\u0856\5\u008aF\2\u0856\u0857\7\3\2"+
		"\2\u0857\u0858\5\u008eH\2\u0858\u0859\7\5\2\2\u0859\u085a\5\u0094K\2\u085a"+
		"\u085b\7\4\2\2\u085b\u085d\3\2\2\2\u085c\u0847\3\2\2\2\u085c\u084e\3\2"+
		"\2\2\u085c\u0855\3\2\2\2\u085d\u0091\3\2\2\2\u085e\u085f\7\u00f4\2\2\u085f"+
		"\u0860\7\3\2\2\u0860\u0865\5\u00ccg\2\u0861\u0862\7\5\2\2\u0862\u0864"+
		"\5\u00ccg\2\u0863\u0861\3\2\2\2\u0864\u0867\3\2\2\2\u0865\u0863\3\2\2"+
		"\2\u0865\u0866\3\2\2\2\u0866\u0868\3\2\2\2\u0867\u0865\3\2\2\2\u0868\u0869"+
		"\7\4\2\2\u0869\u0093\3\2\2\2\u086a\u086b\7\u00f3\2\2\u086b\u086c\7\3\2"+
		"\2\u086c\u0871\5\u0092J\2\u086d\u086e\7\5\2\2\u086e\u0870\5\u0092J\2\u086f"+
		"\u086d\3\2\2\2\u0870\u0873\3\2\2\2\u0871\u086f\3\2\2\2\u0871\u0872\3\2"+
		"\2\2\u0872\u0874\3\2\2\2\u0873\u0871\3\2\2\2\u0874\u0875\7\4\2\2\u0875"+
		"\u0095\3\2\2\2\u0876\u0877\5\u0088E\2\u0877\u0878\7\3\2\2\u0878\u0879"+
		"\5\u008eH\2\u0879\u087a\7\5\2\2\u087a\u087b\5\u008eH\2\u087b\u087c\7\4"+
		"\2\2\u087c\u088c\3\2\2\2\u087d\u087e\5\u0088E\2\u087e\u087f\7\3\2\2\u087f"+
		"\u0880\5\u009aN\2\u0880\u0881\7\5\2\2\u0881\u0882\5\u008eH\2\u0882\u0883"+
		"\7\4\2\2\u0883\u088c\3\2\2\2\u0884\u0885\5\u0088E\2\u0885\u0886\7\3\2"+
		"\2\u0886\u0887\5\u008eH\2\u0887\u0888\7\5\2\2\u0888\u0889\5\u009aN\2\u0889"+
		"\u088a\7\4\2\2\u088a\u088c\3\2\2\2\u088b\u0876\3\2\2\2\u088b\u087d\3\2"+
		"\2\2\u088b\u0884\3\2\2\2\u088c\u0097\3\2\2\2\u088d\u088e\7\u00ec\2\2\u088e"+
		"\u088f\7\3\2\2\u088f\u0894\5\u00ccg\2\u0890\u0891\7\5\2\2\u0891\u0893"+
		"\5\u00ccg\2\u0892\u0890\3\2\2\2\u0893\u0896\3\2\2\2\u0894\u0892\3\2\2"+
		"\2\u0894\u0895\3\2\2\2\u0895\u0897\3\2\2\2\u0896\u0894\3\2\2\2\u0897\u0898"+
		"\7\4\2\2\u0898\u0099\3\2\2\2\u0899\u089a\7\u0108\2\2\u089a\u089b\7\3\2"+
		"\2\u089b\u08a0\5\u0098M\2\u089c\u089d\7\5\2\2\u089d\u089f\5\u0098M\2\u089e"+
		"\u089c\3\2\2\2\u089f\u08a2\3\2\2\2\u08a0\u089e\3\2\2\2\u08a0\u08a1\3\2"+
		"\2\2\u08a1\u08a3\3\2\2\2\u08a2\u08a0\3\2\2\2\u08a3\u08a4\7\4\2\2\u08a4"+
		"\u009b\3\2\2\2\u08a5\u08b2\7\'\2\2\u08a6\u08b2\5\u00a6T\2\u08a7\u08a8"+
		"\5\u00c6d\2\u08a8\u08a9\7\u00f7\2\2\u08a9\u08b2\3\2\2\2\u08aa\u08b2\5"+
		"\u00ccg\2\u08ab\u08b2\5\u00a4S\2\u08ac\u08ae\7\u00f7\2\2\u08ad\u08ac\3"+
		"\2\2\2\u08ae\u08af\3\2\2\2\u08af\u08ad\3\2\2\2\u08af\u08b0\3\2\2\2\u08b0"+
		"\u08b2\3\2\2\2\u08b1\u08a5\3\2\2\2\u08b1\u08a6\3\2\2\2\u08b1\u08a7\3\2"+
		"\2\2\u08b1\u08aa\3\2\2\2\u08b1\u08ab\3\2\2\2\u08b1\u08ad\3\2\2\2\u08b2"+
		"\u009d\3\2\2\2\u08b3\u08b4\t\24\2\2\u08b4\u009f\3\2\2\2\u08b5\u08b6\t"+
		"\25\2\2\u08b6\u00a1\3\2\2\2\u08b7\u08b8\t\26\2\2\u08b8\u00a3\3\2\2\2\u08b9"+
		"\u08ba\t\27\2\2\u08ba\u00a5\3\2\2\2\u08bb\u08bf\7.\2\2\u08bc\u08be\5\u00a8"+
		"U\2\u08bd\u08bc\3\2\2\2\u08be\u08c1\3\2\2\2\u08bf\u08bd\3\2\2\2\u08bf"+
		"\u08c0\3\2\2\2\u08c0\u00a7\3\2\2\2\u08c1\u08bf\3\2\2\2\u08c2\u08c3\5\u00aa"+
		"V\2\u08c3\u08c6\5\u00c6d\2\u08c4\u08c5\7h\2\2\u08c5\u08c7\5\u00c6d\2\u08c6"+
		"\u08c4\3\2\2\2\u08c6\u08c7\3\2\2\2\u08c7\u00a9\3\2\2\2\u08c8\u08ca\t\22"+
		"\2\2\u08c9\u08c8\3\2\2\2\u08c9\u08ca\3\2\2\2\u08ca\u08cb\3\2\2\2\u08cb"+
		"\u08ce\t\r\2\2\u08cc\u08ce\7\u00f7\2\2\u08cd\u08c9\3\2\2\2\u08cd\u08cc"+
		"\3\2\2\2\u08ce\u00ab\3\2\2\2\u08cf\u08d3\7H\2\2\u08d0\u08d1\7I\2\2\u08d1"+
		"\u08d3\5\u00c6d\2\u08d2\u08cf\3\2\2\2\u08d2\u08d0\3\2\2\2\u08d3\u00ad"+
		"\3\2\2\2\u08d4\u08d5\7m\2\2\u08d5\u08d6\7\177\2\2\u08d6\u08d7\5\u00ae"+
		"X\2\u08d7\u08d8\7\u0081\2\2\u08d8\u08f7\3\2\2\2\u08d9\u08da\7n\2\2\u08da"+
		"\u08db\7\177\2\2\u08db\u08dc\5\u00aeX\2\u08dc\u08dd\7\5\2\2\u08dd\u08de"+
		"\5\u00aeX\2\u08de\u08df\7\u0081\2\2\u08df\u08f7\3\2\2\2\u08e0\u08e7\7"+
		"o\2\2\u08e1\u08e3\7\177\2\2\u08e2\u08e4\5\u00b4[\2\u08e3\u08e2\3\2\2\2"+
		"\u08e3\u08e4\3\2\2\2\u08e4\u08e5\3\2\2\2\u08e5\u08e8\7\u0081\2\2\u08e6"+
		"\u08e8\7}\2\2\u08e7\u08e1\3\2\2\2\u08e7\u08e6\3\2\2\2\u08e8\u08f7\3\2"+
		"\2\2\u08e9\u08f4\5\u00c6d\2\u08ea\u08eb\7\3\2\2\u08eb\u08f0\7\u00fc\2"+
		"\2\u08ec\u08ed\7\5\2\2\u08ed\u08ef\7\u00fc\2\2\u08ee\u08ec\3\2\2\2\u08ef"+
		"\u08f2\3\2\2\2\u08f0\u08ee\3\2\2\2\u08f0\u08f1\3\2\2\2\u08f1\u08f3\3\2"+
		"\2\2\u08f2\u08f0\3\2\2\2\u08f3\u08f5\7\4\2\2\u08f4\u08ea\3\2\2\2\u08f4"+
		"\u08f5\3\2\2\2\u08f5\u08f7\3\2\2\2\u08f6\u08d4\3\2\2\2\u08f6\u08d9\3\2"+
		"\2\2\u08f6\u08e0\3\2\2\2\u08f6\u08e9\3\2\2\2\u08f7\u00af\3\2\2\2\u08f8"+
		"\u08fd\5\u00b2Z\2\u08f9\u08fa\7\5\2\2\u08fa\u08fc\5\u00b2Z\2\u08fb\u08f9"+
		"\3\2\2\2\u08fc\u08ff\3\2\2\2\u08fd\u08fb\3\2\2\2\u08fd\u08fe\3\2\2\2\u08fe"+
		"\u00b1\3\2\2\2\u08ff\u08fd\3\2\2\2\u0900\u0901\5\u00c6d\2\u0901\u0904"+
		"\5\u00aeX\2\u0902\u0903\7p\2\2\u0903\u0905\7\u00f7\2\2\u0904\u0902\3\2"+
		"\2\2\u0904\u0905\3\2\2\2\u0905\u00b3\3\2\2\2\u0906\u090b\5\u00b6\\\2\u0907"+
		"\u0908\7\5\2\2\u0908\u090a\5\u00b6\\\2\u0909\u0907\3\2\2\2\u090a\u090d"+
		"\3\2\2\2\u090b\u0909\3\2\2\2\u090b\u090c\3\2\2\2\u090c\u00b5\3\2\2\2\u090d"+
		"\u090b\3\2\2\2\u090e\u090f\5\u00c6d\2\u090f\u0910\7\13\2\2\u0910\u0913"+
		"\5\u00aeX\2\u0911\u0912\7p\2\2\u0912\u0914\7\u00f7\2\2\u0913\u0911\3\2"+
		"\2\2\u0913\u0914\3\2\2\2\u0914\u00b7\3\2\2\2\u0915\u0916\7\60\2\2\u0916"+
		"\u0917\5\u0080A\2\u0917\u0918\7\61\2\2\u0918\u0919\5\u0080A\2\u0919\u00b9"+
		"\3\2\2\2\u091a\u091b\7?\2\2\u091b\u0920\5\u00bc_\2\u091c\u091d\7\5\2\2"+
		"\u091d\u091f\5\u00bc_\2\u091e\u091c\3\2\2\2\u091f\u0922\3\2\2\2\u0920"+
		"\u091e\3\2\2\2\u0920\u0921\3\2\2\2\u0921\u00bb\3\2\2\2\u0922\u0920\3\2"+
		"\2\2\u0923\u0924\5\u00c6d\2\u0924\u0925\7\17\2\2\u0925\u0926\5\u00be`"+
		"\2\u0926\u00bd\3\2\2\2\u0927\u0952\5\u00c6d\2\u0928\u094b\7\3\2\2\u0929"+
		"\u092a\7\u0092\2\2\u092a\u092b\7\24\2\2\u092b\u0930\5\u0080A\2\u092c\u092d"+
		"\7\5\2\2\u092d\u092f\5\u0080A\2\u092e\u092c\3\2\2\2\u092f\u0932\3\2\2"+
		"\2\u0930\u092e\3\2";
	private static final String _serializedATNSegment1 =
		"\2\2\u0930\u0931\3\2\2\2\u0931\u094c\3\2\2\2\u0932\u0930\3\2\2\2\u0933"+
		"\u0934\t\30\2\2\u0934\u0935\7\24\2\2\u0935\u093a\5\u0080A\2\u0936\u0937"+
		"\7\5\2\2\u0937\u0939\5\u0080A\2\u0938\u0936\3\2\2\2\u0939\u093c\3\2\2"+
		"\2\u093a\u0938\3\2\2\2\u093a\u093b\3\2\2\2\u093b\u093e\3\2\2\2\u093c\u093a"+
		"\3\2\2\2\u093d\u0933\3\2\2\2\u093d\u093e\3\2\2\2\u093e\u0949\3\2\2\2\u093f"+
		"\u0940\t\31\2\2\u0940\u0941\7\24\2\2\u0941\u0946\5J&\2\u0942\u0943\7\5"+
		"\2\2\u0943\u0945\5J&\2\u0944\u0942\3\2\2\2\u0945\u0948\3\2\2\2\u0946\u0944"+
		"\3\2\2\2\u0946\u0947\3\2\2\2\u0947\u094a\3\2\2\2\u0948\u0946\3\2\2\2\u0949"+
		"\u093f\3\2\2\2\u0949\u094a\3\2\2\2\u094a\u094c\3\2\2\2\u094b\u0929\3\2"+
		"\2\2\u094b\u093d\3\2\2\2\u094c\u094e\3\2\2\2\u094d\u094f\5\u00c0a\2\u094e"+
		"\u094d\3\2\2\2\u094e\u094f\3\2\2\2\u094f\u0950\3\2\2\2\u0950\u0952\7\4"+
		"\2\2\u0951\u0927\3\2\2\2\u0951\u0928\3\2\2\2\u0952\u00bf\3\2\2\2\u0953"+
		"\u0954\7B\2\2\u0954\u0964\5\u00c2b\2\u0955\u0956\7C\2\2\u0956\u0964\5"+
		"\u00c2b\2\u0957\u0958\7B\2\2\u0958\u0959\7#\2\2\u0959\u095a\5\u00c2b\2"+
		"\u095a\u095b\7\36\2\2\u095b\u095c\5\u00c2b\2\u095c\u0964\3\2\2\2\u095d"+
		"\u095e\7C\2\2\u095e\u095f\7#\2\2\u095f\u0960\5\u00c2b\2\u0960\u0961\7"+
		"\36\2\2\u0961\u0962\5\u00c2b\2\u0962\u0964\3\2\2\2\u0963\u0953\3\2\2\2"+
		"\u0963\u0955\3\2\2\2\u0963\u0957\3\2\2\2\u0963\u095d\3\2\2\2\u0964\u00c1"+
		"\3\2\2\2\u0965\u0966\7D\2\2\u0966\u096d\t\32\2\2\u0967\u0968\7G\2\2\u0968"+
		"\u096d\7K\2\2\u0969\u096a\5\u0080A\2\u096a\u096b\t\32\2\2\u096b\u096d"+
		"\3\2\2\2\u096c\u0965\3\2\2\2\u096c\u0967\3\2\2\2\u096c\u0969\3\2\2\2\u096d"+
		"\u00c3\3\2\2\2\u096e\u0973\5\u00c6d\2\u096f\u0970\7\6\2\2\u0970\u0972"+
		"\5\u00c6d\2\u0971\u096f\3\2\2\2\u0972\u0975\3\2\2\2\u0973\u0971\3\2\2"+
		"\2\u0973\u0974\3\2\2\2\u0974\u00c5\3\2\2\2\u0975\u0973\3\2\2\2\u0976\u0986"+
		"\5\u00c8e\2\u0977\u0986\7\u00e5\2\2\u0978\u0986\7;\2\2\u0979\u0986\7\67"+
		"\2\2\u097a\u0986\78\2\2\u097b\u0986\79\2\2\u097c\u0986\7:\2\2\u097d\u0986"+
		"\7<\2\2\u097e\u0986\7\64\2\2\u097f\u0986\7\65\2\2\u0980\u0986\7=\2\2\u0981"+
		"\u0986\7d\2\2\u0982\u0986\7g\2\2\u0983\u0986\7e\2\2\u0984\u0986\7f\2\2"+
		"\u0985\u0976\3\2\2\2\u0985\u0977\3\2\2\2\u0985\u0978\3\2\2\2\u0985\u0979"+
		"\3\2\2\2\u0985\u097a\3\2\2\2\u0985\u097b\3\2\2\2\u0985\u097c\3\2\2\2\u0985"+
		"\u097d\3\2\2\2\u0985\u097e\3\2\2\2\u0985\u097f\3\2\2\2\u0985\u0980\3\2"+
		"\2\2\u0985\u0981\3\2\2\2\u0985\u0982\3\2\2\2\u0985\u0983\3\2\2\2\u0985"+
		"\u0984\3\2\2\2\u0986\u00c7\3\2\2\2\u0987\u098b\7\u0100\2\2\u0988\u098b"+
		"\5\u00caf\2\u0989\u098b\5\u00ceh\2\u098a\u0987\3\2\2\2\u098a\u0988\3\2"+
		"\2\2\u098a\u0989\3\2\2\2\u098b\u00c9\3\2\2\2\u098c\u098d\7\u0101\2\2\u098d"+
		"\u00cb\3\2\2\2\u098e\u0990\7\u0084\2\2\u098f\u098e\3\2\2\2\u098f\u0990"+
		"\3\2\2\2\u0990\u0991\3\2\2\2\u0991\u09ab\7\u00fd\2\2\u0992\u0994\7\u0084"+
		"\2\2\u0993\u0992\3\2\2\2\u0993\u0994\3\2\2\2\u0994\u0995\3\2\2\2\u0995"+
		"\u09ab\7\u00fc\2\2\u0996\u0998\7\u0084\2\2\u0997\u0996\3\2\2\2\u0997\u0998"+
		"\3\2\2\2\u0998\u0999\3\2\2\2\u0999\u09ab\7\u00f8\2\2\u099a\u099c\7\u0084"+
		"\2\2\u099b\u099a\3\2\2\2\u099b\u099c\3\2\2\2\u099c\u099d\3\2\2\2\u099d"+
		"\u09ab\7\u00f9\2\2\u099e\u09a0\7\u0084\2\2\u099f\u099e\3\2\2\2\u099f\u09a0"+
		"\3\2\2\2\u09a0\u09a1\3\2\2\2\u09a1\u09ab\7\u00fa\2\2\u09a2\u09a4\7\u0084"+
		"\2\2\u09a3\u09a2\3\2\2\2\u09a3\u09a4\3\2\2\2\u09a4\u09a5\3\2\2\2\u09a5"+
		"\u09ab\7\u00fe\2\2\u09a6\u09a8\7\u0084\2\2\u09a7\u09a6\3\2\2\2\u09a7\u09a8"+
		"\3\2\2\2\u09a8\u09a9\3\2\2\2\u09a9\u09ab\7\u00ff\2\2\u09aa\u098f\3\2\2"+
		"\2\u09aa\u0993\3\2\2\2\u09aa\u0997\3\2\2\2\u09aa\u099b\3\2\2\2\u09aa\u099f"+
		"\3\2\2\2\u09aa\u09a3\3\2\2\2\u09aa\u09a7\3\2\2\2\u09ab\u00cd\3\2\2\2\u09ac"+
		"\u09ad\t\33\2\2\u09ad\u00cf\3\2\2\2\u0144\u00e7\u00ec\u00ef\u00f4\u0101"+
		"\u0105\u010c\u0111\u0116\u0119\u011c\u0120\u0123\u0126\u012d\u0131\u0139"+
		"\u013c\u013f\u0142\u0145\u0148\u014c\u014f\u0152\u0159\u015f\u0165\u016d"+
		"\u018d\u0195\u0199\u019e\u01a4\u01ac\u01b2\u01bf\u01c4\u01cd\u01d2\u01e2"+
		"\u01e9\u01ed\u01f5\u01fc\u0203\u0212\u0216\u021c\u0222\u0225\u0228\u022e"+
		"\u0232\u0236\u023b\u023f\u0247\u024a\u0253\u0258\u025e\u0264\u0270\u0273"+
		"\u0277\u027c\u0281\u0288\u028b\u028e\u0295\u029a\u02a0\u02a9\u02b1\u02b7"+
		"\u02bb\u02bf\u02c3\u02c5\u02ce\u02d4\u02d9\u02dc\u02e0\u02e3\u02ec\u02f1"+
		"\u02f6\u02f9\u02ff\u0307\u030c\u0312\u0318\u0323\u032b\u0332\u0362\u0365"+
		"\u036d\u0371\u0378\u03ec\u03f4\u03fc\u0405\u0411\u0415\u0418\u041e\u0428"+
		"\u0434\u0439\u043f\u044b\u044d\u0452\u0456\u0458\u045c\u0465\u046d\u0474"+
		"\u047a\u047e\u0487\u048c\u049b\u04a2\u04a5\u04ac\u04b0\u04b6\u04be\u04c9"+
		"\u04d4\u04db\u04e1\u04e7\u04f0\u04f2\u04fb\u04fe\u0507\u050a\u0513\u0516"+
		"\u051f\u0522\u0525\u0529\u052c\u0537\u053c\u0547\u054b\u054f\u055b\u055e"+
		"\u0562\u056c\u0570\u0572\u0575\u0579\u057c\u0580\u0586\u058a\u058e\u0593"+
		"\u0596\u0598\u059d\u05a2\u05a5\u05a9\u05ac\u05ae\u05b3\u05b8\u05c5\u05ca"+
		"\u05d2\u05d8\u05e2\u05f1\u05f6\u05fe\u0601\u0605\u060a\u0613\u0616\u061b"+
		"\u0622\u0625\u062d\u0634\u063b\u063e\u0643\u0649\u064d\u0650\u0653\u065e"+
		"\u0663\u0678\u067a\u067c\u0689\u0692\u0699\u06a1\u06a9\u06ad\u06b0\u06b3"+
		"\u06b9\u06bc\u06bf\u06c5\u06c8\u06cb\u06d5\u06d8\u06dc\u06e4\u06e8\u06ec"+
		"\u06ee\u06f7\u0703\u0705\u070c\u0713\u0719\u071f\u0721\u0726\u072d\u0733"+
		"\u0737\u0739\u0740\u074e\u0756\u0758\u075d\u0760\u0768\u0771\u0777\u077f"+
		"\u0785\u0788\u07b0\u07c5\u07c7\u07d0\u07d4\u07dd\u07e1\u07f3\u07f6\u07fe"+
		"\u0807\u0817\u0822\u0829\u082c\u0831\u0838\u0842\u0844\u085c\u0865\u0871"+
		"\u088b\u0894\u08a0\u08af\u08b1\u08bf\u08c6\u08c9\u08cd\u08d2\u08e3\u08e7"+
		"\u08f0\u08f4\u08f6\u08fd\u0904\u090b\u0913\u0920\u0930\u093a\u093d\u0946"+
		"\u0949\u094b\u094e\u0951\u0963\u096c\u0973\u0985\u098a\u098f\u0993\u0997"+
		"\u099b\u099f\u09a3\u09a7\u09aa";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}