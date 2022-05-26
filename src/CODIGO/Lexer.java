// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: src/CODIGO/lexer.flex

import compilerTools.Token;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
class Lexer {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\2\1\1\2\2\1\22\0\1\3\1\4\1\0"+
    "\1\5\2\4\1\6\1\7\2\10\1\4\1\11\1\12"+
    "\1\11\1\13\1\14\12\15\1\16\1\17\1\10\1\20"+
    "\1\10\1\4\1\0\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\6\27\1\30\1\31\3\27\1\32\1\33\1\34"+
    "\1\27\1\35\4\27\4\0\1\4\1\0\1\36\1\37"+
    "\1\40\1\41\1\42\1\27\1\43\1\27\1\44\1\45"+
    "\1\27\1\46\1\47\1\50\1\51\1\52\1\27\1\53"+
    "\1\54\1\55\1\56\1\57\3\27\1\60\1\10\1\61"+
    "\1\10\7\0\1\2\33\0\1\4\35\0\1\4\u0168\0"+
    "\2\2\326\0\u0100\2";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\1\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\15\14\1\15\1\14"+
    "\1\16\1\14\3\0\1\17\1\20\1\0\2\21\1\20"+
    "\1\21\2\22\25\14\1\15\1\16\1\23\1\14\1\11"+
    "\2\22\25\14\4\0\1\24\31\14";

  private static int [] zzUnpackAction() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\62\0\62\0\144\0\226\0\310\0\62"+
    "\0\62\0\62\0\372\0\62\0\62\0\u012c\0\u015e\0\u0190"+
    "\0\u01c2\0\u01f4\0\u0226\0\u0258\0\u028a\0\u02bc\0\u02ee\0\u0320"+
    "\0\u0352\0\u0384\0\u03b6\0\u03e8\0\u041a\0\u044c\0\u047e\0\u04b0"+
    "\0\u04e2\0\62\0\u0514\0\u0546\0\u0578\0\u05aa\0\62\0\u05dc"+
    "\0\u060e\0\u0640\0\u0672\0\u06a4\0\u06d6\0\u0708\0\u073a\0\u076c"+
    "\0\u079e\0\u07d0\0\u0802\0\u0834\0\u0866\0\u0898\0\u08ca\0\u08fc"+
    "\0\u092e\0\u0960\0\u0992\0\u09c4\0\u09f6\0\u0a28\0\u0a5a\0\u0a8c"+
    "\0\u0abe\0\62\0\62\0\u05dc\0\u0af0\0\u0b22\0\u0b54\0\u0b86"+
    "\0\u0bb8\0\u0bea\0\u0c1c\0\u0c4e\0\u0c80\0\u0cb2\0\u0ce4\0\u0d16"+
    "\0\u0d48\0\u0d7a\0\u0dac\0\u0dde\0\u0e10\0\u0e42\0\u0e74\0\u0ea6"+
    "\0\u0ed8\0\u0f0a\0\u0f3c\0\u0a8c\0\u0abe\0\u0af0\0\u0b22\0\u06a4"+
    "\0\u0f6e\0\u0fa0\0\u0fd2\0\u1004\0\u1036\0\u1068\0\u109a\0\u10cc"+
    "\0\u10fe\0\u1130\0\u1162\0\u1194\0\u11c6\0\u11f8\0\u122a\0\u125c"+
    "\0\u128e\0\u12c0\0\u12f2\0\u1324\0\u1356\0\u1388\0\u13ba\0\u13ec"+
    "\0\u141e";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\0\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\2\1\4\1\13\1\2\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\23\24\1\3"+
    "\66\0\3\33\1\0\11\33\40\34\1\33\4\0\3\35"+
    "\1\0\11\35\40\36\1\35\1\0\1\37\1\0\1\40"+
    "\3\41\1\42\5\41\1\43\3\41\40\43\1\40\3\0"+
    "\1\44\1\45\2\46\1\47\3\46\1\50\1\46\1\13"+
    "\43\46\1\45\3\0\1\44\1\51\2\52\1\47\5\52"+
    "\1\53\3\52\37\54\1\55\1\51\3\0\1\44\1\51"+
    "\2\52\1\47\5\52\1\53\3\52\25\54\1\56\12\54"+
    "\1\51\3\0\1\44\1\51\2\52\1\47\5\52\1\53"+
    "\3\52\15\54\1\57\5\54\1\60\4\54\1\61\4\54"+
    "\1\62\2\54\1\51\3\0\1\44\1\51\2\52\1\47"+
    "\5\52\1\53\3\52\21\54\1\63\1\54\1\64\14\54"+
    "\1\51\3\0\1\44\1\51\2\52\1\47\5\52\1\53"+
    "\3\52\27\54\1\65\10\54\1\51\3\0\1\44\1\51"+
    "\2\52\1\47\5\52\1\53\3\52\23\54\1\66\14\54"+
    "\1\51\3\0\1\44\1\51\2\52\1\47\5\52\1\53"+
    "\3\52\40\54\1\51\3\0\1\44\1\51\2\52\1\47"+
    "\5\52\1\53\3\52\21\54\1\67\6\54\1\70\4\54"+
    "\1\71\2\54\1\51\3\0\1\44\1\51\2\52\1\47"+
    "\5\52\1\53\3\52\21\54\1\72\16\54\1\51\3\0"+
    "\1\44\1\51\2\52\1\47\5\52\1\53\3\52\21\54"+
    "\1\73\6\54\1\74\7\54\1\51\3\0\1\44\1\51"+
    "\2\52\1\47\5\52\1\53\3\52\35\54\1\75\2\54"+
    "\1\51\3\0\1\44\1\51\2\52\1\47\5\52\1\53"+
    "\3\52\32\54\1\76\5\54\1\51\3\0\1\44\1\51"+
    "\2\52\1\47\5\52\1\53\3\52\21\54\1\77\16\54"+
    "\1\51\4\0\3\33\1\0\52\33\4\0\3\100\1\0"+
    "\5\100\1\34\3\100\40\34\1\100\4\0\3\35\1\0"+
    "\52\35\4\0\3\101\1\0\5\101\1\36\3\101\40\36"+
    "\1\101\1\0\1\37\1\0\1\37\3\0\1\42\51\0"+
    "\1\37\1\0\1\37\1\0\1\40\3\41\1\102\51\41"+
    "\1\40\3\0\4\41\1\102\52\41\3\0\1\43\1\41"+
    "\2\43\1\103\51\43\1\41\3\0\1\44\1\0\2\44"+
    "\1\47\51\44\5\0\3\45\1\0\52\45\3\0\1\44"+
    "\1\45\2\46\1\47\51\46\1\45\3\0\1\44\1\45"+
    "\2\46\1\47\5\46\1\104\43\46\1\45\4\0\3\51"+
    "\1\0\52\51\3\0\1\44\1\51\2\52\1\47\51\52"+
    "\1\51\3\0\1\44\1\51\2\52\1\47\5\52\1\53"+
    "\3\52\40\53\1\51\3\0\1\44\1\105\2\106\1\47"+
    "\5\106\1\54\3\106\40\54\1\105\3\0\1\44\1\105"+
    "\2\106\1\47\5\106\1\54\3\106\35\54\1\107\2\54"+
    "\1\105\3\0\1\44\1\105\2\106\1\47\5\106\1\54"+
    "\3\106\15\54\1\110\22\54\1\105\3\0\1\44\1\105"+
    "\2\106\1\47\5\106\1\54\3\106\20\54\1\111\17\54"+
    "\1\105\3\0\1\44\1\105\2\106\1\47\5\106\1\54"+
    "\3\106\32\54\1\112\5\54\1\105\3\0\1\44\1\105"+
    "\2\106\1\47\5\106\1\54\3\106\25\54\1\113\12\54"+
    "\1\105\3\0\1\44\1\105\2\106\1\47\5\106\1\54"+
    "\3\106\15\54\1\114\22\54\1\105\3\0\1\44\1\105"+
    "\2\106\1\47\5\106\1\54\3\106\17\54\1\115\20\54"+
    "\1\105\3\0\1\44\1\105\2\106\1\47\5\106\1\54"+
    "\3\106\36\54\1\116\1\54\1\105\3\0\1\44\1\105"+
    "\2\106\1\47\5\106\1\54\3\106\34\54\1\117\3\54"+
    "\1\105\3\0\1\44\1\105\2\106\1\47\5\106\1\54"+
    "\3\106\22\54\1\120\15\54\1\105\3\0\1\44\1\105"+
    "\2\106\1\47\5\106\1\54\3\106\34\54\1\121\3\54"+
    "\1\105\3\0\1\44\1\105\2\106\1\47\5\106\1\54"+
    "\3\106\33\54\1\122\4\54\1\105\3\0\1\44\1\105"+
    "\2\106\1\47\5\106\1\54\3\106\25\54\1\123\12\54"+
    "\1\105\3\0\1\44\1\105\2\106\1\47\5\106\1\54"+
    "\3\106\22\54\1\124\15\54\1\105\3\0\1\44\1\105"+
    "\2\106\1\47\5\106\1\54\3\106\17\54\1\125\13\54"+
    "\1\126\4\54\1\105\3\0\1\44\1\105\2\106\1\47"+
    "\5\106\1\54\3\106\24\54\1\127\1\54\1\130\11\54"+
    "\1\105\3\0\1\44\1\105\2\106\1\47\5\106\1\54"+
    "\3\106\26\54\1\131\11\54\1\105\3\0\1\44\1\105"+
    "\2\106\1\47\5\106\1\54\3\106\23\54\1\132\14\54"+
    "\1\105\3\0\1\44\1\105\2\106\1\47\5\106\1\54"+
    "\3\106\32\54\1\133\5\54\1\105\4\0\3\100\1\0"+
    "\11\100\40\134\1\100\4\0\3\101\1\0\11\101\40\135"+
    "\1\101\4\0\3\105\1\0\11\105\40\136\1\105\3\0"+
    "\1\44\1\105\2\106\1\47\11\106\40\137\1\105\3\0"+
    "\1\44\1\105\2\106\1\47\5\106\1\54\3\106\25\54"+
    "\1\140\12\54\1\105\3\0\1\44\1\105\2\106\1\47"+
    "\5\106\1\54\3\106\27\54\1\141\10\54\1\105\3\0"+
    "\1\44\1\105\2\106\1\47\5\106\1\54\3\106\21\54"+
    "\1\142\16\54\1\105\3\0\1\44\1\105\2\106\1\47"+
    "\5\106\1\54\3\106\17\54\1\143\20\54\1\105\3\0"+
    "\1\44\1\105\2\106\1\47\5\106\1\54\3\106\30\54"+
    "\1\144\7\54\1\105\3\0\1\44\1\105\2\106\1\47"+
    "\5\106\1\54\3\106\20\54\1\145\17\54\1\105\3\0"+
    "\1\44\1\105\2\106\1\47\5\106\1\54\3\106\23\54"+
    "\1\146\14\54\1\105\3\0\1\44\1\105\2\106\1\47"+
    "\5\106\1\54\3\106\23\54\1\147\14\54\1\105\3\0"+
    "\1\44\1\105\2\106\1\47\5\106\1\54\3\106\21\54"+
    "\1\124\16\54\1\105\3\0\1\44\1\105\2\106\1\47"+
    "\5\106\1\54\3\106\35\54\1\150\2\54\1\105\3\0"+
    "\1\44\1\105\2\106\1\47\5\106\1\54\3\106\30\54"+
    "\1\151\7\54\1\105\3\0\1\44\1\105\2\106\1\47"+
    "\5\106\1\54\3\106\34\54\1\152\3\54\1\105\3\0"+
    "\1\44\1\105\2\106\1\47\5\106\1\54\3\106\34\54"+
    "\1\153\3\54\1\105\3\0\1\44\1\105\2\106\1\47"+
    "\5\106\1\54\3\106\32\54\1\127\5\54\1\105\3\0"+
    "\1\44\1\105\2\106\1\47\5\106\1\54\3\106\34\54"+
    "\1\132\3\54\1\105\3\0\1\44\1\105\2\106\1\47"+
    "\5\106\1\54\3\106\34\54\1\131\1\154\2\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\30\54\1\140\7\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\16\54\1\127\21\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\15\54\1\144\22\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\15\54\1\155\22\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\20\54\1\156\17\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\17\54\1\127\20\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\27\54\1\157\10\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\35\54\1\160\2\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\32\54\1\140\5\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\32\54\1\161\5\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\26\54\1\162\11\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\20\54\1\163\17\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\32\54\1\157\5\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\20\54\1\127\17\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\32\54\1\131\5\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\23\54\1\164\14\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\25\54\1\165\12\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\27\54\1\166\10\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\21\54\1\140\16\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\15\54\1\140\22\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\25\54\1\127\12\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\15\54\1\151\22\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\15\54\1\107\22\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\23\54\1\144\14\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\31\54\1\167\6\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\34\54\1\161\3\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\22\54\1\143\15\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\25\54\1\170\12\54\1\105"+
    "\3\0\1\44\1\105\2\106\1\47\5\106\1\54\3\106"+
    "\23\54\1\171\14\54\1\105\3\0\1\44\1\105\2\106"+
    "\1\47\5\106\1\54\3\106\17\54\1\131\20\54\1\105";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5200];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\3\11\3\1\3\11\1\1\2\11\21\1\3\0"+
    "\1\11\1\1\1\0\2\1\1\11\32\1\2\11\30\1"+
    "\4\0\32\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return token(yytext(), "ERROR #", yyline, yycolumn);
            }
            // fall through
          case 21: break;
          case 2:
            { /*Ignorar*/
            }
            // fall through
          case 22: break;
          case 3:
            { return token(yytext(), "ERROR 0", yyline, yycolumn);
            }
            // fall through
          case 23: break;
          case 4:
            { return token(yytext(), "ERROR 6", yyline, yycolumn);
            }
            // fall through
          case 24: break;
          case 5:
            { return token(yytext(), "ERROR 8", yyline, yycolumn);
            }
            // fall through
          case 25: break;
          case 6:
            { return token(yytext(), "Signo De Agrupacion", yyline, yycolumn);
            }
            // fall through
          case 26: break;
          case 7:
            { return token(yytext(), "Operador Aritmetico", yyline, yycolumn);
            }
            // fall through
          case 27: break;
          case 8:
            { return token(yytext(), "Separador", yyline, yycolumn);
            }
            // fall through
          case 28: break;
          case 9:
            { return token(yytext(), "Numero", yyline, yycolumn);
            }
            // fall through
          case 29: break;
          case 10:
            { return token(yytext(), "Delimitador De Sentencia", yyline, yycolumn);
            }
            // fall through
          case 30: break;
          case 11:
            { return token(yytext(), "Operador De Asignacion", yyline, yycolumn);
            }
            // fall through
          case 31: break;
          case 12:
            { return token(yytext(), "Identificador", yyline, yycolumn);
            }
            // fall through
          case 32: break;
          case 13:
            { return token(yytext(), "ERROR 5", yyline, yycolumn);
            }
            // fall through
          case 33: break;
          case 14:
            { return token(yytext(), "ERROR 7", yyline, yycolumn);
            }
            // fall through
          case 34: break;
          case 15:
            { return token(yytext(), "ERROR 3", yyline, yycolumn);
            }
            // fall through
          case 35: break;
          case 16:
            { return token(yytext(), "ERROR 4", yyline, yycolumn);
            }
            // fall through
          case 36: break;
          case 17:
            { return token(yytext(), "ERROR 9", yyline, yycolumn);
            }
            // fall through
          case 37: break;
          case 18:
            { return token(yytext(), "ERROR 1", yyline, yycolumn);
            }
            // fall through
          case 38: break;
          case 19:
            { return token(yytext(), "ERROR 2", yyline, yycolumn);
            }
            // fall through
          case 39: break;
          case 20:
            { return token(yytext(), "Palabra Reservada", yyline, yycolumn);
            }
            // fall through
          case 40: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
