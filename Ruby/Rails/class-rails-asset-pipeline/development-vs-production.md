#### Debugging Assets

As we mentioned in the beginning, the whole idea of the asset pipeline is to concatenate everything into one file, because performance. But, we'll notice that when we spin up our application in development, we'll see many files listed in the resources tab of the Chrome Developer Tools.

Open config/environments/development.rb

config.assets.debug = true

This is because this functionality is disabled in config/environments/development.rb:
Debug mode disables concatenation and preprocessing of assets. This option causes significant delays in view rendering with a large number of complex assets. However it is useful for debugging.
This option is turned off in production.

#### Precompile assets

If you request an asset in development, Rails will check public/assets first. If your asset is not there, it will hit up the asset pipeline and compile it on the fly. This is useful in development because you're likely to be making frequent changes and edits to those files. But, it would also be a performance bottleneck in production if Rails had to compile those files on every request.

Your assets have to be either required in your asset pipeline or precompiled

To do so, you can either include them in the manifest or indicate your app to precompile it.

In app/assets/stylesheets/application.css

// = require_self
// = require 'site'


Let's say you had a stylesheet called site.css.scss. You could simply require it in application.css.

In config/initializers/assets.rb

config.assets.precompile += %w( site.css )

Alternatively, you can add it to the precompile list similar to the way we added a load path earlier.
However, in practice, by establishing the require_tree ., Rails got you covered.

#### What happens when we precompile?

When you run rake assets:precompile, Rails goes through your assets and copies everything over to public/assets. It then creates application.js and application.css by reading the manifests. It does not look at any other file unless you explicitly tell it to.
When using config.assets.precompile, the file extension of the target file matters. config.assets.precompile += %w( site ) will not work.
JavaScripts and stylesheets must either be included in a manifest or explicitly added to the config.assets.precompile directive.

Rails copies all the assets into  public/assets
Rails then creates an application.js and application.css by reading the manifests
When using config.assets.precompile, the file extension matters. 

When you run rake assets:precompile, Rails goes through your assets and copies everything over to public/assets. It then creates application.js and application.css by reading the manifests. 
When using config.assets.precompile, that the file extension matters. config.assets.precompile += %w( site ) will not work.
JavaScripts and stylesheets must either be included in a manifest or explicitly added to the config.assets.precompile directive.

