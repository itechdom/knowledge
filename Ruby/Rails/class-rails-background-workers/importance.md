#### A world with no Background Workers

* Imagine your rails app as a post office employee, let's call your rails app Jimmy.
* Jimmy processes customers one by one.
* Jimmy's job is to process customer shipments and deliver them to their destination all at once.
* What's wrong with that? What would Jimmy do to avoid this problem?


#### Solution?

* When building websites, it’s important to keep your response times down.
  Long-running requests not only degrade user perception of your site, but also tie up server resources.
* Return a successful response and schedule the computation for later.