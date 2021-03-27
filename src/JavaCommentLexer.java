// $ANTLR 3.2 Sep 23, 2009 12:02:23 JavaCommentLexer.g 2021-03-27 13:37:02

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class JavaCommentLexer extends Lexer {
    public static final int FSlash=4;
    public static final int Todo=6;
    public static final int TemplateStringSymbol=12;
    public static final int CharLiteral=15;
    public static final int MultiLineComment=9;
    public static final int SQuote=14;
    public static final int SingleLineComment=7;
    public static final int TemplateStringLiteral=13;
    public static final int DQuote=10;
    public static final int Whitespace=5;
    public static final int StringLiteral=11;
    public static final int Star=8;
    public static final int EOF=-1;

    // delegates
    // delegators

    public JavaCommentLexer() {;} 
    public JavaCommentLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public JavaCommentLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "JavaCommentLexer.g"; }

    public Token nextToken() {
        while (true) {
            if ( input.LA(1)==CharStream.EOF ) {
                return Token.EOF_TOKEN;
            }
            state.token = null;
    	state.channel = Token.DEFAULT_CHANNEL;
            state.tokenStartCharIndex = input.index();
            state.tokenStartCharPositionInLine = input.getCharPositionInLine();
            state.tokenStartLine = input.getLine();
    	state.text = null;
            try {
                int m = input.mark();
                state.backtracking=1; 
                state.failed=false;
                mTokens();
                state.backtracking=0;

                if ( state.failed ) {
                    input.rewind(m);
                    input.consume(); 
                }
                else {
                    emit();
                    return state.token;
                }
            }
            catch (RecognitionException re) {
                // shouldn't happen in backtracking mode, but...
                reportError(re);
                recover(re);
            }
        }
    }

    public void memoize(IntStream input,
    		int ruleIndex,
    		int ruleStartIndex)
    {
    if ( state.backtracking>1 ) super.memoize(input, ruleIndex, ruleStartIndex);
    }

    public boolean alreadyParsedRule(IntStream input, int ruleIndex) {
    if ( state.backtracking>1 ) return super.alreadyParsedRule(input, ruleIndex);
    return false;
    }// $ANTLR start "SingleLineComment"
    public final void mSingleLineComment() throws RecognitionException {
        try {
            int _type = SingleLineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaCommentLexer.g:8:3: ( FSlash FSlash Whitespace Todo (~ ( '\\r' | '\\n' ) )* )
            // JavaCommentLexer.g:8:5: FSlash FSlash Whitespace Todo (~ ( '\\r' | '\\n' ) )*
            {
            mFSlash(); if (state.failed) return ;
            mFSlash(); if (state.failed) return ;
            mWhitespace(); if (state.failed) return ;
            mTodo(); if (state.failed) return ;
            // JavaCommentLexer.g:8:35: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // JavaCommentLexer.g:8:35: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SingleLineComment"

    // $ANTLR start "MultiLineComment"
    public final void mMultiLineComment() throws RecognitionException {
        try {
            int _type = MultiLineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaCommentLexer.g:12:3: ( FSlash Star Whitespace Todo ( . )* Star FSlash )
            // JavaCommentLexer.g:12:6: FSlash Star Whitespace Todo ( . )* Star FSlash
            {
            mFSlash(); if (state.failed) return ;
            mStar(); if (state.failed) return ;
            mWhitespace(); if (state.failed) return ;
            mTodo(); if (state.failed) return ;
            // JavaCommentLexer.g:12:34: ( . )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // JavaCommentLexer.g:12:34: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            mStar(); if (state.failed) return ;
            mFSlash(); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MultiLineComment"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaCommentLexer.g:16:3: ( DQuote ( . )* DQuote )
            // JavaCommentLexer.g:16:6: DQuote ( . )* DQuote
            {
            mDQuote(); if (state.failed) return ;
            // JavaCommentLexer.g:16:13: ( . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\"') ) {
                    alt3=2;
                }
                else if ( (LA3_0=='\\') ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2=='u') ) {
                        int LA3_4 = input.LA(3);

                        if ( (LA3_4=='0') ) {
                            int LA3_5 = input.LA(4);

                            if ( (LA3_5=='0') ) {
                                int LA3_6 = input.LA(5);

                                if ( (LA3_6=='2') ) {
                                    int LA3_7 = input.LA(6);

                                    if ( (LA3_7=='2') ) {
                                        alt3=2;
                                    }
                                    else if ( ((LA3_7>='\u0000' && LA3_7<='1')||(LA3_7>='3' && LA3_7<='\uFFFF')) ) {
                                        alt3=1;
                                    }


                                }
                                else if ( ((LA3_6>='\u0000' && LA3_6<='1')||(LA3_6>='3' && LA3_6<='\uFFFF')) ) {
                                    alt3=1;
                                }


                            }
                            else if ( ((LA3_5>='\u0000' && LA3_5<='/')||(LA3_5>='1' && LA3_5<='\uFFFF')) ) {
                                alt3=1;
                            }


                        }
                        else if ( ((LA3_4>='\u0000' && LA3_4<='/')||(LA3_4>='1' && LA3_4<='\uFFFF')) ) {
                            alt3=1;
                        }


                    }
                    else if ( ((LA3_2>='\u0000' && LA3_2<='t')||(LA3_2>='v' && LA3_2<='\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // JavaCommentLexer.g:16:13: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            mDQuote(); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              skip();
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "StringLiteral"

    // $ANTLR start "TemplateStringLiteral"
    public final void mTemplateStringLiteral() throws RecognitionException {
        try {
            int _type = TemplateStringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaCommentLexer.g:20:3: ( TemplateStringSymbol ( . )* TemplateStringSymbol )
            // JavaCommentLexer.g:20:5: TemplateStringSymbol ( . )* TemplateStringSymbol
            {
            mTemplateStringSymbol(); if (state.failed) return ;
            // JavaCommentLexer.g:20:26: ( . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='`') ) {
                    alt4=2;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='_')||(LA4_0>='a' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // JavaCommentLexer.g:20:26: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            mTemplateStringSymbol(); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              skip();
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TemplateStringLiteral"

    // $ANTLR start "CharLiteral"
    public final void mCharLiteral() throws RecognitionException {
        try {
            int _type = CharLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaCommentLexer.g:24:3: ( SQuote . SQuote )
            // JavaCommentLexer.g:24:6: SQuote . SQuote
            {
            mSQuote(); if (state.failed) return ;
            matchAny(); if (state.failed) return ;
            mSQuote(); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              skip();
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CharLiteral"

    // $ANTLR start "FSlash"
    public final void mFSlash() throws RecognitionException {
        try {
            // JavaCommentLexer.g:28:3: ( '/' | '\\\\' ( 'u002f' | 'u002F' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='/') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\\') ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // JavaCommentLexer.g:28:6: '/'
                    {
                    match('/'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // JavaCommentLexer.g:28:12: '\\\\' ( 'u002f' | 'u002F' )
                    {
                    match('\\'); if (state.failed) return ;
                    // JavaCommentLexer.g:28:17: ( 'u002f' | 'u002F' )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='u') ) {
                        int LA5_1 = input.LA(2);

                        if ( (LA5_1=='0') ) {
                            int LA5_2 = input.LA(3);

                            if ( (LA5_2=='0') ) {
                                int LA5_3 = input.LA(4);

                                if ( (LA5_3=='2') ) {
                                    int LA5_4 = input.LA(5);

                                    if ( (LA5_4=='f') ) {
                                        alt5=1;
                                    }
                                    else if ( (LA5_4=='F') ) {
                                        alt5=2;
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return ;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 5, 4, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return ;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 3, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 2, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // JavaCommentLexer.g:28:18: 'u002f'
                            {
                            match("u002f"); if (state.failed) return ;


                            }
                            break;
                        case 2 :
                            // JavaCommentLexer.g:28:28: 'u002F'
                            {
                            match("u002F"); if (state.failed) return ;


                            }
                            break;

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "FSlash"

    // $ANTLR start "Star"
    public final void mStar() throws RecognitionException {
        try {
            // JavaCommentLexer.g:32:3: ( '*' | '\\\\' ( 'u002a' | 'u002A' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='*') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\\') ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // JavaCommentLexer.g:32:6: '*'
                    {
                    match('*'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // JavaCommentLexer.g:32:12: '\\\\' ( 'u002a' | 'u002A' )
                    {
                    match('\\'); if (state.failed) return ;
                    // JavaCommentLexer.g:32:17: ( 'u002a' | 'u002A' )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='u') ) {
                        int LA7_1 = input.LA(2);

                        if ( (LA7_1=='0') ) {
                            int LA7_2 = input.LA(3);

                            if ( (LA7_2=='0') ) {
                                int LA7_3 = input.LA(4);

                                if ( (LA7_3=='2') ) {
                                    int LA7_4 = input.LA(5);

                                    if ( (LA7_4=='a') ) {
                                        alt7=1;
                                    }
                                    else if ( (LA7_4=='A') ) {
                                        alt7=2;
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return ;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 7, 4, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return ;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 7, 3, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 7, 2, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // JavaCommentLexer.g:32:18: 'u002a'
                            {
                            match("u002a"); if (state.failed) return ;


                            }
                            break;
                        case 2 :
                            // JavaCommentLexer.g:32:28: 'u002A'
                            {
                            match("u002A"); if (state.failed) return ;


                            }
                            break;

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "Star"

    // $ANTLR start "DQuote"
    public final void mDQuote() throws RecognitionException {
        try {
            // JavaCommentLexer.g:36:3: ( '\"' | '\\\\u0022' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\"') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\\') ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // JavaCommentLexer.g:36:6: '\"'
                    {
                    match('\"'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // JavaCommentLexer.g:37:6: '\\\\u0022'
                    {
                    match("\\u0022"); if (state.failed) return ;


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "DQuote"

    // $ANTLR start "SQuote"
    public final void mSQuote() throws RecognitionException {
        try {
            // JavaCommentLexer.g:41:3: ( '\\'' | '\\\\u0027' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\'') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\\') ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // JavaCommentLexer.g:41:6: '\\''
                    {
                    match('\''); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // JavaCommentLexer.g:42:6: '\\\\u0027'
                    {
                    match("\\u0027"); if (state.failed) return ;


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "SQuote"

    // $ANTLR start "Whitespace"
    public final void mWhitespace() throws RecognitionException {
        try {
            // JavaCommentLexer.g:46:3: ( ( ' ' | '\\n' | '\\t' | '\\r' )* )
            // JavaCommentLexer.g:46:5: ( ' ' | '\\n' | '\\t' | '\\r' )*
            {
            // JavaCommentLexer.g:46:5: ( ' ' | '\\n' | '\\t' | '\\r' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // JavaCommentLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Whitespace"

    // $ANTLR start "Todo"
    public final void mTodo() throws RecognitionException {
        try {
            // JavaCommentLexer.g:50:3: ( ( 'TODO' | 'Todo' | 'todo' ) )
            // JavaCommentLexer.g:50:5: ( 'TODO' | 'Todo' | 'todo' )
            {
            // JavaCommentLexer.g:50:5: ( 'TODO' | 'Todo' | 'todo' )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='T') ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1=='O') ) {
                    alt12=1;
                }
                else if ( (LA12_1=='o') ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA12_0=='t') ) {
                alt12=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // JavaCommentLexer.g:50:6: 'TODO'
                    {
                    match("TODO"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // JavaCommentLexer.g:50:15: 'Todo'
                    {
                    match("Todo"); if (state.failed) return ;


                    }
                    break;
                case 3 :
                    // JavaCommentLexer.g:50:24: 'todo'
                    {
                    match("todo"); if (state.failed) return ;


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "Todo"

    // $ANTLR start "TemplateStringSymbol"
    public final void mTemplateStringSymbol() throws RecognitionException {
        try {
            // JavaCommentLexer.g:54:3: ( '`' )
            // JavaCommentLexer.g:54:5: '`'
            {
            match('`'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "TemplateStringSymbol"

    public void mTokens() throws RecognitionException {
        // JavaCommentLexer.g:1:39: ( SingleLineComment | MultiLineComment | StringLiteral | TemplateStringLiteral | CharLiteral )
        int alt13=5;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // JavaCommentLexer.g:1:41: SingleLineComment
                {
                mSingleLineComment(); if (state.failed) return ;

                }
                break;
            case 2 :
                // JavaCommentLexer.g:1:59: MultiLineComment
                {
                mMultiLineComment(); if (state.failed) return ;

                }
                break;
            case 3 :
                // JavaCommentLexer.g:1:76: StringLiteral
                {
                mStringLiteral(); if (state.failed) return ;

                }
                break;
            case 4 :
                // JavaCommentLexer.g:1:90: TemplateStringLiteral
                {
                mTemplateStringLiteral(); if (state.failed) return ;

                }
                break;
            case 5 :
                // JavaCommentLexer.g:1:112: CharLiteral
                {
                mCharLiteral(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_JavaCommentLexer
    public final void synpred1_JavaCommentLexer_fragment() throws RecognitionException {   
        // JavaCommentLexer.g:1:41: ( SingleLineComment )
        // JavaCommentLexer.g:1:41: SingleLineComment
        {
        mSingleLineComment(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_JavaCommentLexer

    // $ANTLR start synpred2_JavaCommentLexer
    public final void synpred2_JavaCommentLexer_fragment() throws RecognitionException {   
        // JavaCommentLexer.g:1:59: ( MultiLineComment )
        // JavaCommentLexer.g:1:59: MultiLineComment
        {
        mMultiLineComment(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_JavaCommentLexer

    // $ANTLR start synpred3_JavaCommentLexer
    public final void synpred3_JavaCommentLexer_fragment() throws RecognitionException {   
        // JavaCommentLexer.g:1:76: ( StringLiteral )
        // JavaCommentLexer.g:1:76: StringLiteral
        {
        mStringLiteral(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_JavaCommentLexer

    public final boolean synpred2_JavaCommentLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_JavaCommentLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_JavaCommentLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_JavaCommentLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_JavaCommentLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_JavaCommentLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA2_eotS =
        "\12\uffff";
    static final String DFA2_eofS =
        "\12\uffff";
    static final String DFA2_minS =
        "\1\0\1\uffff\1\0\1\uffff\4\0\2\uffff";
    static final String DFA2_maxS =
        "\1\uffff\1\uffff\1\uffff\1\uffff\4\uffff\2\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\2\1\uffff\1\1\4\uffff\2\2";
    static final String DFA2_specialS =
        "\1\5\1\uffff\1\4\1\uffff\1\0\1\1\1\2\1\3\2\uffff}>";
    static final String[] DFA2_transitionS = {
            "\52\3\1\1\61\3\1\2\uffa3\3",
            "",
            "\165\3\1\4\uff8a\3",
            "",
            "\60\3\1\5\uffcf\3",
            "\60\3\1\6\uffcf\3",
            "\62\3\1\7\uffcd\3",
            "\101\3\1\11\37\3\1\10\uff9e\3",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "()* loopback of 12:34: ( . )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_4 = input.LA(1);

                        s = -1;
                        if ( (LA2_4=='0') ) {s = 5;}

                        else if ( ((LA2_4>='\u0000' && LA2_4<='/')||(LA2_4>='1' && LA2_4<='\uFFFF')) ) {s = 3;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_5 = input.LA(1);

                        s = -1;
                        if ( (LA2_5=='0') ) {s = 6;}

                        else if ( ((LA2_5>='\u0000' && LA2_5<='/')||(LA2_5>='1' && LA2_5<='\uFFFF')) ) {s = 3;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA2_6 = input.LA(1);

                        s = -1;
                        if ( (LA2_6=='2') ) {s = 7;}

                        else if ( ((LA2_6>='\u0000' && LA2_6<='1')||(LA2_6>='3' && LA2_6<='\uFFFF')) ) {s = 3;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA2_7 = input.LA(1);

                        s = -1;
                        if ( (LA2_7=='a') ) {s = 8;}

                        else if ( (LA2_7=='A') ) {s = 9;}

                        else if ( ((LA2_7>='\u0000' && LA2_7<='@')||(LA2_7>='B' && LA2_7<='`')||(LA2_7>='b' && LA2_7<='\uFFFF')) ) {s = 3;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA2_2 = input.LA(1);

                        s = -1;
                        if ( (LA2_2=='u') ) {s = 4;}

                        else if ( ((LA2_2>='\u0000' && LA2_2<='t')||(LA2_2>='v' && LA2_2<='\uFFFF')) ) {s = 3;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA2_0 = input.LA(1);

                        s = -1;
                        if ( (LA2_0=='*') ) {s = 1;}

                        else if ( (LA2_0=='\\') ) {s = 2;}

                        else if ( ((LA2_0>='\u0000' && LA2_0<=')')||(LA2_0>='+' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {s = 3;}

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA13_eotS =
        "\12\uffff";
    static final String DFA13_eofS =
        "\12\uffff";
    static final String DFA13_minS =
        "\1\42\1\0\4\uffff\1\0\3\uffff";
    static final String DFA13_maxS =
        "\1\140\1\0\4\uffff\1\0\3\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\1\1\2\1\3\1\5\1\uffff\1\4\1\3\1\5";
    static final String DFA13_specialS =
        "\1\uffff\1\0\4\uffff\1\1\3\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\10\4\uffff\1\11\7\uffff\1\6\54\uffff\1\1\3\uffff\1\7",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens options {k=1; backtrack=true; } : ( SingleLineComment | MultiLineComment | StringLiteral | TemplateStringLiteral | CharLiteral );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_1 = input.LA(1);

                         
                        int index13_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_JavaCommentLexer()) ) {s = 2;}

                        else if ( (synpred2_JavaCommentLexer()) ) {s = 3;}

                        else if ( (synpred3_JavaCommentLexer()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index13_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_6 = input.LA(1);

                         
                        int index13_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_JavaCommentLexer()) ) {s = 2;}

                        else if ( (synpred2_JavaCommentLexer()) ) {s = 3;}

                         
                        input.seek(index13_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}