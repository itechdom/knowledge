#### Writing seed files: the manual way

* Setting up everything up by hand, which includes

    * Entering data in multiple lines instead of loops:
```
user_1  = User.create(name: "Richard", email: "richard@example.com", password: "asdf")
user_2  = User.create(name: "Sam", email: "sam@example.com", password: "asdf")
user_3  = User.create(name: "Sam", email: "sam@example.com", password: "asdf")
```

    * You set up relationships by hand:
```
order_2 = user_2.orders.create(amount: 10.00)
order_2.items << item_2
puts "Created Order For: #{order_2.user.name}"
```