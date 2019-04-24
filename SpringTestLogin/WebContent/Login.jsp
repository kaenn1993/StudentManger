
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
<script src="https://raw.github.com/carhartl/jquery-cookie/master/jquery.cookie.js"></script>
<title>色と位置をクッキーに保存できる付箋</title>
<script>
$(function() {
  $('#new').click(function() {
    make();
    save();
  });

  $('#del').click(function() {
    $('.selected').remove();
    save();
  });

  function make() {
    var sticky = $('<div class="sticky">Drag & Double Click!</div>');
    sticky.appendTo('body')
      .css('background-color', $('#color').val())
      .draggable({stop: save})
      .dblclick(function() {
        $(this).html('<textarea>' + $(this).html() + '</textarea>')
          .children()
          .focus()
          .blur(function() {
            $(this).parent().html($(this).val());
            save();
          });
      }).mousedown(function() {
        $('.sticky').removeClass('selected');
        $(this).addClass('selected');
      });
    return sticky;
  }

  function save() {
    var items = [];
    $('.sticky').each(function() {
      items.push(
        $(this).css('left'),
        $(this).css('top'),
        $(this).css('background-color'),
        $(this).html()
      );
    });
    $.cookie('sticky', items.join('\t'), {expires: 100});
  }

  function load() {
    if (!$.cookie('sticky')) return;
    var items = $.cookie('sticky').split('\t');
    for (var i = 0; i < items.length; i += 4) {
      make().css({
        left: items[i],
        top: items[i + 1],
        backgroundColor: items[i + 2]
      }).html(items[i + 3]);
    }
  }
  load();
});
</script>
<style>
.sticky {
  width: 250px;
  height: 50px;
  position: absolute;
  cursor: pointer;
  border: 1px solid #aaa;
}
textarea {
  width: 100%;
  height: 100%;
}
.selected {border-color: #f44;}
</style>
</head>
<body>
<select id="color">
<option value="#ffc">黄色</option>
<option value="#fcc">赤色</option>
<option value="#cfc">緑色</option>
</select>
<input id="new" type="button" value="new">
<input id="del" type="button" value="del">


</body>

</html>

