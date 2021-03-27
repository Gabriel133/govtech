lexer grammar JavaCommentLexer;

options {
  filter=true;
}

SingleLineComment
  : FSlash FSlash Whitespace Todo ~('\r' | '\n')* 
  ;

MultiLineComment
  :  FSlash Star Whitespace Todo .* Star FSlash
  ;

StringLiteral
  :  DQuote .* DQuote {skip();}
  ;

TemplateStringLiteral
  : TemplateStringSymbol .* TemplateStringSymbol {skip();}
  ;

CharLiteral
  :  SQuote . SQuote {skip();}
  ;

fragment FSlash
  :  '/' | '\\' ('u002f' | 'u002F')
  ;

fragment Star
  :  '*' | '\\' ('u002a' | 'u002A')
  ;

fragment DQuote
  :  '"' 
  |  '\\u0022'
  ;

fragment SQuote
  :  '\'' 
  |  '\\u0027'
  ;

fragment Whitespace
  : (' ' | '\n' | '\t' | '\r')*
  ;

fragment Todo
  : ('TODO' | 'Todo' | 'todo')
  ;

fragment TemplateStringSymbol
  : '`'
  ;