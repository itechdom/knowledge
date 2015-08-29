### Ways to Use Regex in Ruby

* Match
* Scan
* =~
* Gsub
* Split

```ruby

a = /a/

a.class # Regexp

myString = "A woman once said. A man once said. A child once said"

match = myString.match(a) #this will return a

match = myString.scan(a) #this will return ["a", "a", "a", "a", "a"]

match = myString.gsub(a,"b") #this will replace all a(s) with b, leaving behind capital A

myString =~ a #return the index of the first occurance 

match = myString.split(a) # split a string by a(s)

```
