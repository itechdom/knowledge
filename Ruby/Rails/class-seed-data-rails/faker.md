#### How to use Faker

* We saw earlier that we are adding names by using "i" in our loops.
```ruby
    10.times do |i|
      user  = User.create(name: "user ##{i}", email: "email#{i}@example.com", password: "123")
      puts "Created User: #{user.name}"
    end
```
* There's a nice gem called Faker which allows us to generate, randomly, different values for different columns.
* https://github.com/stympy/faker
* Adds more flavor to your seed file.


#### Let's Faker it

* In our previous example, let's convert our seed file to use Faker

    * Let's use Faker to generate user's names:
    
```ruby
  def generate_users
    10.times do
      user  = User.create(name: Faker::Name.name, email: Faker::Internet.email, password: "asdf")
      puts "Created User: #{user.name}"
    end
  end
```

    * Setup Relationships using Faker:
    
```ruby
  def generate_orders
    100.times do
      user  = User.order("RANDOM()").limit(1).first
      user.orders.create(amount: Faker::Commerce.price) do |order|
        rand(1..10).times do
          order.items << Item.order("RANDOM()").limit(1).first
        end
      end
      puts "Created Orders For: #{user.name}"
    end
  end
```