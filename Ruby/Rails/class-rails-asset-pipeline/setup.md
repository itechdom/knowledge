#### Setup

Clone Storedom

$ git clone https://github.com/turingschool-examples/storedom.git asset_pipeline

bundle & setup the database

$ bundle && rake db:setup

create a texts directory

$ mkdir app/assets/texts

create a hello.txt file

$ touch app/assets/texts/hello.txt

start the server and visit this path

http://localhost:3000/assets/hello.txt

move the hello.txt file to  the javascripts folder

$ mv app/assets/texts/text.txt 
app/assets/javascripts/text.txt

visit / reload this path again

http://localhost:3000/assets/hello.txt

create a hello.js file

$ touch app/assets/stylesheets/hello.js

put this into hello.js

Hello, is it me you are looking for?

visit this path

http://localhost:3000/assets/hello.js

