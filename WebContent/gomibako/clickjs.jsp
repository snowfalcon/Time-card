<%@ page contentType="text/html;charset=Shift_JIS"%>
<script type="text/javascript" src="../Time-card/js/list.js"
	charset="UTF-8"></script>
<html>
<form>
<input type="button" id="ev" value="イベント発動" onclick="fnc1()">
</form>

<script>
var obj = document.getElementById("ev");

function fnc1(){ alert("関数１が呼び出されました"); }
function fnc2(){ alert("関数２が呼び出されました"); }

obj.onclick = fnc2;

</script>
<form>
<input type="button" id="ev2" value="イベント発動" onclick="fnc1()">
</form>

<script>
var obj2 = document.getElementById("ev2");

//既存の関数をイベントリスナに登録する
obj2.addEventListener( "click" , fnc2 , false );

//直接関数を記述して登録する
obj2.addEventListener( "click" , function () {
  alert("イベント３の追加")
} , false );
</script>
</body>
</html>