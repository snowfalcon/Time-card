<%@ page contentType="text/html;charset=Shift_JIS"%>
<head>
  <title>�N�����\���̗��K</title>
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
    �����̓��t�f�[�^��ϐ�today�Ɋi�[
   */
  var optionLoop, this_day, this_month, this_year, today;
  today = new Date();
  this_year = today.getFullYear();
  this_month = today.getMonth() + 1;
  this_day = today.getDate();

  /*
    ���[�v�����i�X�^�[�g�����A�I�������A�\��id���A�f�t�H���g�����j
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
    �֐��ݒ�i�X�^�[�g����[�K�{]�A�I������[�K�{]�A�\��id��[�ȗ��\]�A�f�t�H���g����[�ȗ��\]�j
   */
  optionLoop(1950, this_year, 'id_year', this_year);
  optionLoop(1, 12, 'id_month', this_month);
  optionLoop(1, 31, 'id_day', this_day);
})();

</script>
</body>
</html>