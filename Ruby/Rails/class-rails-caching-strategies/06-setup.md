#### Setup: Fragment Caching

* Repository
```
git clone https://github.com/turingschool-examples/storedom.git caching_strategies
```
Procedure

Go to site and explore the app. Show how to read the output in the console for the items/index page.
Turn on caching in development.
Restart the server.
Add “cache do” to cache all the items in items/index.
Refresh items/index and check the response time.
Add a second “cache do” for items count.
Explain inconsistencies.
Add “action” and “action_sufix” in “cache do” to fix the problem.

-> Workshop 1.
__
 Create a new item via the console and show how it was not updated in the page.
 Use after_create, after_update, after_destroy callbacks to invalidate the cache. Show how this fixes it.
 
 -> Workshop 2.
__
 Use a CacheInvalidator concern to reduce duplication.
 Explain what are the pros and cons of the concern technique.
 Create “cache_key_for(model)” helper in ApplicationController.
 Refactor views to use Russian doll caching: “cache(record) do”.
 Add an a new item and check that it is added in the view.
 -> Workshop 3.
__
 Change the name of an item that is contained in the first order via the terminal.
 Verify that this is changed in the orders view.
 Go to order in which the updated item should appear and check that the old name is still there.
 Use “after_create”, “after_update” and “after_destroy” callbacks to update the orders associated with the item.
 Modify another item belonging to the first order and check that the order was updated.
__
 Install redis via homebrew (“brew install redis”).
 Start redis (“redis-server”).
 Add “redis-rails” to Gemfile.
 Modify configuration file to use redis instead of memory caching.  “config.cache_store = :redis_store, ‘redis://localhost:6379/0/cache”.
 Restart the server.
 Check the logs and compare the speed.
 Show how to access the keys in redis via the redis-cli (KEYS *).
 BONUS: Refactor callbacks using a ManyToManyAssociationsUpdater concern

Workshops

Add caching to order count and order details.
Go to /orders and check the response times in your logs.
Add “cache do” to all the orders.
Add “cache do” to the orders count.
Add “action” and “action_suffix”.
Check /users and see the difference in response times.
Update orders cache.
Create a new order from the console. It has to have a user_id.
Go to the orders page and see that the new order hasn’t appeared.
Add callbacks (after_create, after_update, after_destroy) to invalidate cache.
Create a new order and verify that it appears in the page.
Refactor the orders view.
Add Russian doll caching to the order record.
Use the cache_key_for(model) helper to create a new fragment that encompasses all the view.
Create a new record and verify that it is still working.


Implementation

app/views/items/index.html.erb

<% cache(cache_key_for(Item)) do %>
  <div class="container">
    <div class="row">
      <div class="col-sm-12">
        <h1><%= @items.count %> Items</h1>
      </div>
    </div>
    <div class="row"></div>>
    <% @items.each do |item| %>
      <div class="col-sm-3">
        <% cache(item) do %>
          <h5><%= item.name %></h5>
          <%= link_to(image_tag(item.image_url), item_path(item)) %>
          <p><%= item.description %></p>
        <% end %>
      </div>
    <% end %>
  </div>
<% end %>

app/helpers/application_helper.rb

module ApplicationHelper
  def cache_key_for(model)
    prefix         = model.to_s.downcase.pluralize
    count          = model.count
    max_updated_at = model.maximum(:updated_at).try(:utc).try(:to_s, :number)
 
    "#{prefix}/all-#{count}-#{max_updated_at}"
  end
end

app/models/item.rb

class Item < ActiveRecord::Base
  # include CacheInvalidator
  # include ManyToManyAssociationsUpdater
 
  has_many :order_items
  has_many :orders, through: :order_items
 
  after_create  :update_orders
  after_update  :update_orders
  after_destroy :update_orders
 
  def update_orders
    orders.each do |order|
      order.updated_at = Time.now
      order.save
    end
  end
end

app/models/concerns/cache_invalidator.rb

module CacheInvalidator
  extend ActiveSupport::Concern
 
  included do
    after_create :invalidate_cache
    after_update :invalidate_cache
    after_destroy :invalidate_cache
 
    def invalidate_cache
      Rails.cache.clear
    end
  end
end

app/models/concerns/many_to_many_associations_updater.rb

module ManyToManyAssociationsUpdater
  extend ActiveSupport::Concern
 
  included do
    after_create  :update_associations
    after_update  :update_associations
    after_destroy :update_associations
 
    def associations
      self.class.reflect_on_all_associations(:has_many).map(&:name)
    end
    
    def update_associations
      associations.each { |association| update_association(association) }
    end
    
    def update_association(association)
      send(association).each { |record| record.update_attributes(updated_at: Time.now) }
    end
  end
end