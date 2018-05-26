//時間表示
function showClock() {
var now = new Date();
var nowYear = now.getYear() + 1900;
var nowMonth = ("0" + (now.getMonth() + 1)).slice(-2);
var nowDate = ("0" + (now.getDate())).slice(-2);
var nowDay = now.getDay();
var nowWeek = new Array("日","月","火","水","木","金","土");
var msg1 = nowYear + "年" + nowMonth + "月" + nowDate + "日" + nowWeek[nowDay] + "曜日";
document.getElementById("RealtimeClockArea1").innerHTML = msg1;
var msg2 = [
  ("0" + now.getHours()).slice(-2),
  ("0" + now.getMinutes()).slice(-2),
  ("0" + now.getSeconds()).slice(-2)
  ].join(':');
document.getElementById("RealtimeClockArea2").innerHTML = msg2;
}
setInterval('showClock()',1000);
//出社退社コマンド
function func(MyCommand){
document.MyForm.MySubmit.value=MyCommand;
document.MyForm.submit();
}
//ログアウトメッセージ
function logout() {
    myRet = confirm("ログアウトします。よろしいですか？");
    if ( myRet == true ){
    	location.href='http://localhost:8080/Time-card/logout'
    }
}