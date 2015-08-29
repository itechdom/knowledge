#### Asset Organization

Pipeline assets can be placed inside an application in one of three locations: app/assets, lib/assets or vendor/assets.


#### Main Folders

app/assets
lib/assets
vendor/assets

app/assets is for assets that are owned by the application, such as custom images, JavaScript files or stylesheets.
lib/assets is for your own libraries' code that doesn't really fit into the scope of the application or those libraries which are shared across applications.
vendor/assets is for assets that are owned by outside entities, such as code for JavaScript plugins and CSS frameworks. Keep in mind that third party code with references to other files also processed by the asset Pipeline (images, stylesheets, etc.), will need to be rewritten to use helpers like asset_path.


#### Asset directories are arbitrary

By default, Rails places three sub-directories in your app/assets directory. These are completely arbitrary. You can name these directories whatever you want or add other directories.
Rails will pick up new files in your app/assets directory, but you have to reset the server if you add a new directory to the app/assets.
Anything in the pipeline will be available at the /assets URL. So, the app/assets/javascripts/application.js in your asset pipeline will be available in development at http://localhost:3000/assets/application.js. app/assets/stylesheets/application.css will also be available at the root of your asset directory. 
The asset pipeline will completely flatten your directory structure when you spin up your development server or precompile your assets.


#### Example

app/assets/javascripts/home.js
lib/assets/javascripts/moovinator.js
vendor/assets/tino_cochino/slider.js
vendor/assets/barbie_hair/phonebox.js

Let’s say that you have these files under your assets. Rails doesn’t care the subfolders that you use. It will flatten them all and put them under the assets url.

http://localhost:3000/assets/home.js 
http://localhost:3000/assets/moovinator.js 
http://localhost:3000/assets/slider.js 
http://localhost:3000/assets/phonebox.js

This will be referenced like this.




