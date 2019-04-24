<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
<title>１ラインオセロ</title>
<script>
$(function() {
  var round = 0;
  var remain;
  var field = [
    [1, "●○●○○"],
    [1, "●○○○●○●"],
    [2, "●○●○●○●○●"],
    [2, "●○●●○●●●○"],
    [2, "●●○●●○○●●●○●○●●"]
  ];

  // 面の開始
  function start() {
    remain = field[round][0];
    $('#field')
    .html($.map(field[round][1].split(''), function(i) {
      return '<div>' + i + '</div>';
    }).join(''));

    $('#round').text(round + 1);
    $('#remain').text(remain);
  }
  start();

  $('#field').sortable({
    axis: 'x',
    update: function(e, u) {
      // 裏返す
      var color = u.item.text();
      $.each(['prev', 'next'], function(i, dir) {
        var rev = false;
        (function (item) {
          if (item.length < 1) return;
          if (item.text() == color) rev = true;
          else arguments.callee(item[dir]());
          if (rev) item.text(color);
        })(u.item[dir]());
      });

      // クリアチェック
      $('#remain').text(--remain);
      if (!$('#field div').is(':contains("○")')) {
        if (++round >= field.length) {
          alert("オールクリア！");
        } else {
          alert("クリア！");
          start();
        }
      }

      // ゲームオーバーチェック
      if (remain <= 0) {
        $('#field').sortable('destroy');
        alert("ゲームオーバー");
      }
    }
  });
});
</script>
<style>
div {
  float: left;
  cursor: pointer;
}
</style>
</head>
<body>
<p>全て●にせよ！　第<span id="round"></span>面　残り<span id="remain"></span>手</p>
<div id="field"></div>
</body>
</html>