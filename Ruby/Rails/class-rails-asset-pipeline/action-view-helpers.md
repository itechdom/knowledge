#### ActionView Helpers

<%= stylesheet_link_tag "application", :media => "all" %>
<%= javascript_include_tag "application" %>  

You’ve probably seen this.
ActionView gives you a set of helper methods that you can use in your views to include assets.

audio_path("horse.wav")  # /audios/horse.wav
audio_tag("sound")       # <audio src="/audios/sound"/>
font_path("font.ttf")    # /fonts/font.ttf
image_path("edit.png")   # "/images/edit.png"
image_tag("dog.png")     # <img src="/images/dog.png" alt="Dog"/>
video_path("hd.avi")     # /videos/hd.avi
video_tag("trailer.ogg") # <video src="/videos/trailer.ogg"/>

See ActionView::Helpers::AssetTagHelper documentation for more information.
The sass-rails gem also has a set of helpers that allow you to reference other assets without having to know their exact location. This should help you resist the temptation of using ERB in your .scss assets.