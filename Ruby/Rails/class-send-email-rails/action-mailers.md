#### Action Mailers

* Similar to controllers:
    * they inherit from ActionMailer::Base
    * they have layouts 
    * they have custom methods
    
* http://guides.rubyonrails.org/action_mailer_basics.html


#### The mailer

* How to generate mailers:
```ruby
rails generate mailer YourNameMailer
```

* Layouts are specified in:

```ruby
class ApplicationMailer < ActionMailer::Base
  layout 'mailer'
end
```

```ruby
class UserMailer < ApplicationMailer
  default from: 'notifications@example.com'
 
  def welcome_email(user)
    @user = user
    mail(to: @user.email, subject: 'Welcome to My Awesome Site')
  end
end
```


#### Connecting to a controller

* Where to call mailers
* Sending now or later?

```ruby
class UsersController < ApplicationController
  # POST /users
  # POST /users.json
  def create
    @user = User.new(params[:user])
    
      if @user.save
        # Tell the UserMailer to send a welcome email after save, hence the later
        UserMailer.welcome_email(@user).deliver_later
        
        redirect_to(@user, notice: 'User was successfully created.')
      else
        render action: 'new' 
      end
  end
end
```


#### Layouts

* Due to some email clients not accepting HTML formatted emails, we use text only emails.


#### Configuration

* We will use Mandrill
* Configuration is done in Application.rb
```ruby
     config.action_mailer.delivery_method = :smtp 
  
      config.action_mailer.smtp_settings = { 
        address:              'smtp.mandrillapp.com', 
        port:                 '587', 
        domain:               'blogger.com', 
        user_name:            YOUR_USER_NAME_HERE, 
        password:             YOUR_API_KEY_HERE, 
        authentication:       'plain', 
        enable_starttls_auto: true 
      }
```


#### Testing

http://guides.rubyonrails.org/testing.html#testing-your-mailers

* Unit testing: test your mailer separately to see if:

  * subject, from and body are correctly being sent
  
  
  
* Integration testing:

  * test the controller to make sure that the action that's sending the email is sending it correctly