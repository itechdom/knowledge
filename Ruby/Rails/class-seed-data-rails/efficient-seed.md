#### Writing seed files: the better way

* Let's go back to our example and look at how we can improve the way we write seed files:

    * Use loops instead of writing things in multiple lines:
```ruby
    10.times do |i|
      user  = User.create(name: "user ##{i}", email: "email#{i}@example.com", password: "123")
      puts "Created User: #{user.name}"
    end
```

    * Setup Relationships using:
    
```ruby
  def generate_orders
    100.times do |i|
      user  = User.order("RANDOM()").limit(1).first
      user.orders.create(amount: i*2) do |order|
        rand(1..10).times do
          order.items << Item.order("RANDOM()").limit(1).first
        end
      end
      puts "Created Orders For: #{user.name}"
    end
  end
```