## Setup

* Clone this repo:
```
git clone https://github.com/turingschool-examples/storedom.git
```

* checkout branch: heroku-ready

* run:
```
heroku create && 
git push heroku heroku-ready:master &&
heroku run rake db:setup 
```

* Create an Account on Skylight

* Add gem 'skylight'

* bundle install

* bundle exec skylight setup "copy this part from skylight"

* Deploy your app to Heroku

* Navigate to the first page, then go and check Skylight's Dashboard.