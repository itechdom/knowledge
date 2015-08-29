### Inline Javascript

```
<a href="#" onclick="this.style.backgroundColor='#990000'">
  Paint it red
</a>
```


### Multiple Styles

```
<a href="#" onclick="this.style.backgroundColor='#009900';this.style.color='#FFFFFF';">
  Paint it green
</a>
```


### A Slight Improvement

```
<a href="#" onclick="paintIt(this, '#990000')">Paint it red</a>
```

```
<a href="#" onclick="paintIt(#009900','#FFFFFF')">
  Paint it green
</a>
```

In your Js File, you would do:
```
paintIt = function(element, backgroundColor) {
  element.style.backgroundColor = backgroundColor;
  if (textColor != null) {
    return element.style.color = textColor;
  }
};

```


### Finally: The most awesome way

```
<a href="#" data-background-color="#990000">Paint it red</a>

<a href="#" data-background-color="#009900" data-text-color=“#FFFFFF">
Paint it green</a>

// with a rails helper
<%= link_to “Paint it green”, “#”, data: { :’background-color’ => ‘#009900’} %>
```
In your Javascript file, you would do:

```
var paintIt;

paintIt = function(element, backgroundColor, textColor) {
  element.style.backgroundColor = backgroundColor;
  if (textColor != null) {
    return element.style.color = textColor;
  }
};

$(function() {
  return $("a[data-background-color]").click(function(e) {
    var backgroundColor, textColor;
    e.preventDefault();
    backgroundColor = $(this).data("background-color");
    textColor = $(this).data("text-color");
    return paintIt(this, backgroundColor, textColor);
  });
});
```
