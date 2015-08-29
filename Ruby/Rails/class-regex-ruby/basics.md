### Regex Basics

* [abc] A single character: a, b or c 
* [^abc] Any single character but a, b, or c 
* [a-z] Any single character in the range a-z 
* [a-zA-Z] Any single character in the range a-z or A-Z 
* [1-9] any number between 1 and 9
* ^ Start of line 
* $ End of line 
* \A Start of string 
* \z End of string


### Shortcuts (meta characters)

* . Any single character 
* \s Any whitespace character 
* \S Any non-whitespace character 
* \d Any digit 
* \D Any non-digit 
* \w Any word character (letter, number, underscore) 
* \W Any non-word character 
* \b Any word boundary character


### Groups
* (...) Capture everything enclosed
* (a|b) a or b 
* ? Zero or one of a 
* \* Zero or more of a 
* \+ One or more of a 
* {3} Exactly 3 of a 
* {3,} 3 or more of a 
* a{3,6} Between 3 and 6 of a


### Characters that needs to be escaped.
* They are escaped with a backward slash \\\
* Characters are:

```
. | ( ) [ ] { } + \ ^ $ * ?
```