#### Create jobs with Sidekiq:

* Create a folder app/workers
* Create a file named hard_worker.rb
* All folders under the app are included automatically by Rails.
* Convention to add _worker at the end, but not mandatory.
```
 class HardWorker 
      include Sidekiq::Worker 
       def perform(name, count) 
           sleep(5) 
           puts 'Doing hard work' 
       end 
  end
```


#### Sidekiq

* A Sidekiq job is any Ruby class or module with a perform class method.
* Sidekiq will dedicate a worker to handle the job.


#### Sidekiq: Controller Side

Modify the controller to call your background job.

```
class ArticlesController < ApplicationController
  def create
    @article = Article.new(params[:article])
    if @article.save
    
      HardWorker.perform_async('bob', 5)
     
      flash[:notice] = "Article was created."
      redirect_to articles_path
    else
      render :new
    end
  end
end
```

* When a job is created it gets appended to a list data structure in Redis. A Sidekiq worker will then try to process the job.


#### Monitoring Sidekiq

* Sidekiq has a web interface to monitor the status of your queues & workers.
* It is a Sinatra app.
* The front-end application is not loaded by default, but we can load it in our routes file.

```rb
require 'sidekiq/web' 
mount Sidekiq::Web => '/sidekiq'
```


#### Starting the workers:

* From your root directory run:

```
bundle exec sidekiq
```