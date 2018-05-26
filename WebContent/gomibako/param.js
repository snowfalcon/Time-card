
//初期年月パラメータ設定
function param() {
	var now = new Date();
	var nowYear = now.getYear() + 1900;
	var nowMonth = now.getMonth() + 1;
	// 開いているページURLに'MONTH'が含まれているかチェック
	if (document.URL.match('MONTH')) {
		// 含まれていない場合、指定の文字列を付け足してリダイレクト
	} else {
		location.href = document.URL + '?YEAR=' + nowYear + '&MONTH='
				+ nowMonth;
	}
}