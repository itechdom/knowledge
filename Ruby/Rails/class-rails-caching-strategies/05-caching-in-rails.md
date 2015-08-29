#### Caching in Rails

* Page Caching: cache static pages.

* Action Caching: Page caching isn't realistic. This would run the before filters and cache the rest of the page.

* The previous two were taken out of Rails 4 core and put in a separate gem.

* Fragment Caching: 
    * Action caching isn't ideal since we can't always cache the whole page. 
    * It's more practical to cache parts of the page.
    
    
#### Caching in Rails: Cont

* http://guides.rubyonrails.org/caching_with_rails.html#fragment-caching
* Let's look at:

    * Caching one action.
    * Caching All actions
    * Expiring the cache: Manually, Automatically using a helper