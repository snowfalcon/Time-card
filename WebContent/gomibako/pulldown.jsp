<%@ page contentType="text/html;charset=Shift_JIS"%>
<head>
  <title>年月日表示の練習</title>
</head>
<body>
<select name="year" id="id_year">
</select>
<select name="month" id="id_month">
</select>
<select name="day" id="id_day">
</select>
<script>
(function() {
  'use strict';

  /*
    今日の日付データを変数todayに格納
   */
  var optionLoop, this_day, this_month, this_year, today;
  today = new Date();
  this_year = today.getFullYear();
  this_month = today.getMonth() + 1;
  this_day = today.getDate();

  /*
    ループ処理（スタート数字、終了数字、表示id名、デフォルト数字）
   */
  optionLoop = function(start, end, id, this_day) {
    var i, opt;

    opt = null;
    for (i = start; i <= end ; i++) {
      if (i === this_day) {
        opt += "<option value='" + i + "' selected>" + i + "</option>";
      } else {
        opt += "<option value='" + i + "'>" + i + "</option>";
      }
    }
    return document.getElementById(id).innerHTML = opt;
  };


  /*
    関数設定（スタート数字[必須]、終了数字[必須]、表示id名[省略可能]、デフォルト数字[省略可能]）
   */
  optionLoop(1950, this_year, 'id_year', this_year);
  optionLoop(1, 12, 'id_month', this_month);
  optionLoop(1, 31, 'id_day', this_day);
})();

</script>
</body>
</html>