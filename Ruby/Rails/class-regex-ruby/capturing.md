### capturing

* We can specify variables in regex that we can refer to later
* The exampel below stores month, day and year when given a date.

```ruby

(?<month>\d{1,2})\/(?<day>\d{1,2})\/(?<year>\d{4})
```

Then we can do something like this:
```ruby
date_string = "06/11/1985"
pattern = /(?<month>\d{1,2})\/(?<day>\d{1,2})\/(?<year>\d{4})/
result = date_string.match(pattern)
# we can now access the days, month and year
result[:day] #11
result[:month] #06
result[:year] #1985

```


### exercise

* Write a pattern that will take a decimal number (ie: 3.4)
* It captures the number in dollars and cents
* display the dollars and cents in that number
* You should modify the previous example
```ruby
(?<month>\d{1,2})\/(?<day>\d{1,2})\/(?<year>\d{4})
```