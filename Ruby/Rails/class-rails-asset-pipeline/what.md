#### What

The asset pipeline provides a framework to concatenate and minify or compress JavaScript and CSS assets. It also adds the ability to write these assets in other languages and pre-processors such as CoffeeScript, Sass and ERB.
The asset pipeline is technically no longer a core feature of Rails 4, it has been extracted out of the framework into the sprockets-rails gem that is included in your Rails projects.
The asset pipeline is enabled by default.

#### Main Features

Asset concatenation
Asset minification
Precompilation

The first feature of the pipeline is to concatenate assets, which can reduce the number of requests that a browser makes to render a web page. Fewer requests can mean faster loading for your application.
Sprockets concatenates all JavaScript files into one master .js file and all CSS files into one master .css file. You can customize this strategy to group files any way you like.
In production, Rails inserts an MD5 fingerprint into each filename so that the file is cached by the web browser. You can invalidate the cache by altering this fingerprint, which happens automatically whenever you change the file contents.
The second feature of the asset pipeline is asset minification or compression. For CSS files, this is done by removing whitespace and comments. For JavaScript, more complex processes can be applied. You can choose from a set of built in options or specify your own.
The third feature of the asset pipeline is it allows coding assets via a higher-level language, with precompilation down to the actual assets. Supported languages include Sass for CSS, CoffeeScript for JavaScript, and ERB for both by default.

#### Fingerprinting

Fingerprinting is a technique that makes the name of a file dependent on the contents of the file. When the file contents change, the filename is also changed. For content that is static or infrequently changed, this provides an easy way to tell whether two versions of a file are identical, even across different servers or deployment dates.
When a filename is unique and based on its content, HTTP headers can be set to encourage caches everywhere (whether at CDNs, at ISPs, in networking equipment, or in web browsers) to keep their own copy of the content. When the content is updated, the fingerprint will change. This will cause the remote clients to request a new copy of the content. This is generally known as cache busting.
The technique sprockets uses for fingerprinting is to insert a hash of the content into the name, usually at the end. For example a CSS file global.css


#### Fingerprinting Example

global.css

global-908e25f4bf641868d8683022a5b62f54.css


This is the how Rails names an asset file with MD5 fingerprinting. Every time that the contents of the file change, Rails create a new filename forcing the browser to load it’s contents again.
Rails used to attach a date at the end of the filename, but that strategy had three problems:
	- Not all caches reliably cached filenames when used a date parameter
	- If different nodes had different time stamps, then you could get many different asset names per node.
	- If you deployed, it didn’t matter whether the contents had change, the cache was going to be invalidated therefore loading all the assets again.
	
global.css

/stylesheets/global.css?1309495796

This is how the asset file looked before in Rails.


