#### Setup: sidekiq

* sidekiq is a Redis-backed library for creating background jobs, placing those jobs on multiple queues, and processing them later.


#### Setup: Repos

* Clone this repo.
* git clone -b bootstrap https://github.com/JumpstartLab/blogger_advanced.git
```
gem 'sidekiq'
```
* Add gem ‘sidekiq’ to your Gemfile
* run bundle


#### Setup: Redis

* install Redis:

```
brew install redis
```

* run 

```
redis-server
```


#### Fake delay:

We are going to put our application to sleep.
```rb
class ArticlesController < ApplicationController
  def create
    @article = Article.new(params[:article])
    if @article.save     
      flash[:notice] = "Article was created."
      redirect_to articles_path
    else
      render :new
    end
  end
end
```
```rb
class ArticlesController < ApplicationController
  def create
    @article = Article.new(params[:article])
    if @article.save
      sleep(5)
     
      flash[:notice] = "Article was created."
      redirect_to articles_path
    else
      render :new
    end
  end
end
```