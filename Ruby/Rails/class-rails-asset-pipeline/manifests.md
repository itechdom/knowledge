#### What are Manifests?

Manifests are a way to pull in other, related files. So, if I request application.js and it requires another.js in it's manifest, I will get both of them.

#### Application.js

Let’s look at the application.js

// require_tree
// require_directory .
Define the files manually

// require_tree . requires all of the files in that directory and all subdirectories.
// require_directory . loads all of the files in the directory but not the subdirectories.
Alternatively, you can manually define the files you want to include.
In this example, we're looking at application.js; so, we're using JavaScript comments. If you're in application.css then it would be in CSS comments.


//= require jquery
//= require jquery_ujs
//= require twitter/bootstrap
//= require turbolinks
//= require_tree .

This is the application.js in Storedom.
Remember that order matters.

#### Manifest Directives

require
include 
require_self
require_directory
require_tree
depend_on
stub

require grabs an asset and puts it in our bundle once.
include works a lot like require, but it will allow you to include a file more than once. (I have yet to find a practical use for this directive.)
require_self tells Sprockets to load the body of the current file before loading any of the dependencies. You would use this if you wrote any styles or JavaScript in application.css or application.js respectively and you wanted Sprockets to load that code before loading any of the required assets.
require_directory requires all of the source files of the same format in a given directory. It only goes one level deep.
require_tree works like require_directory, but it also traverses subdirectories.
depend_on announces that you depend on a file, but does not include it in the asset bundle.
stub blacklists a dependency from the bundle.


#### SASS / SCSS

Use @import instead of require