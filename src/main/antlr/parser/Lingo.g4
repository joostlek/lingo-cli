grammar Lingo;

command: addcommand;
addcommand: addwordcommand | adddictionarycommand;
addwordcommand: 'add' 'word' DICTIONARY WORD #CommandAddWord;
adddictionarycommand: 'add' 'dictionary' DICTIONARY #CommandAddDictionary;

WORD: ([a-z])+;
DICTIONARY: ('a'..'z'|'0'..'9')('a'..'z'|'0'..'9')*;
WHITESPACE: [ \t\r\n]+ -> skip;