<%@ page contentType="text/html;charset=Shift_JIS"%>
<script type="text/javascript" src="../Time-card/js/list.js"
	charset="UTF-8"></script>
<html>
<form>
<input type="button" id="ev" value="�C�x���g����" onclick="fnc1()">
</form>

<script>
var obj = document.getElementById("ev");

function fnc1(){ alert("�֐��P���Ăяo����܂���"); }
function fnc2(){ alert("�֐��Q���Ăяo����܂���"); }

obj.onclick = fnc2;

</script>
<form>
<input type="button" id="ev2" value="�C�x���g����" onclick="fnc1()">
</form>

<script>
var obj2 = document.getElementById("ev2");

//�����̊֐����C�x���g���X�i�ɓo�^����
obj2.addEventListener( "click" , fnc2 , false );

//���ڊ֐����L�q���ēo�^����
obj2.addEventListener( "click" , function () {
  alert("�C�x���g�R�̒ǉ�")
} , false );
</script>
</body>
</html>