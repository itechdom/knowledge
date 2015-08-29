#### Asset Lookup

Enter this in the rails console

> y Rails.application.config.assets.paths

At it's core, the asset pipeline is a list of load paths. You can see these load paths by firing up the Rails console.
The y method just formats the hash as YAML.

This is my load path

---
- "/Users/Jorge/Dropbox/projects/classes/storedom/app/assets/images"
- "/Users/Jorge/Dropbox/projects/classes/storedom/app/assets/javascripts"
- "/Users/Jorge/Dropbox/projects/classes/storedom/app/assets/stylesheets"
- "/Users/Jorge/Dropbox/projects/classes/storedom/vendor/assets/javascripts"
- "/Users/Jorge/Dropbox/projects/classes/storedom/vendor/assets/stylesheets"
- "/Users/Jorge/.rvm/gems/ruby-2.1.3/gems/less-rails-bootstrap-3.2.0/app/assets/fonts"
- "/Users/Jorge/.rvm/gems/ruby-2.1.3/gems/less-rails-bootstrap-3.2.0/app/assets/javascripts"
- "/Users/Jorge/.rvm/gems/ruby-2.1.3/gems/less-rails-bootstrap-3.2.0/app/assets/stylesheets"
- "/Users/Jorge/.rvm/gems/ruby-2.1.3/gems/turbolinks-2.2.2/lib/assets/javascripts"
- "/Users/Jorge/.rvm/gems/ruby-2.1.3/gems/jquery-rails-3.1.1/vendor/assets/javascripts"
- "/Users/Jorge/.rvm/gems/ruby-2.1.3/gems/coffee-rails-4.0.1/lib/assets/javascripts"

The asset pipeline works its way through your load path. The first asset with a given name wins. 
If you had an asset named app/assets/stylesheet.css.scss and another called vendor/assets/stylesheet.css.scss, the asset in your app/assets directory would win because it occurs first in the load path.

Adding to the Search Path

By default, Rails will search the first set of directories directly under app/assets, lib/assets, vendor/assets. You can add additional paths to the asset pipeline.
Let's say you're living in the future and you want to include some Adobe Flash. And you want to store your flashy Flash apps in app/flash/assets—in an effort from infecting your other assets with a case of the early 2000s. You can add that path to the asset pipeline in config/initializers/assets.rb.

Add this line to the config/initializers/assets.rb

Rails.application.config.assets.paths << Rails.root.join("app", "flash", "assets")

create a flashy.txt file

$ touch app/flash/assets/flashy.txt

put this into flashy.txt

Rockin’ like 2002

visit this path

http://localhost:3000/assets/flashy.txt

