// 初期年月パラメータ設定
function param() {
	// ボックス
	var now = new Date();
	var nowYear = now.getYear() + 1900;
	var nowMonth = now.getMonth() + 1;
	// 開いているページURLに'MONTH'が含まれているかチェック
	if (document.URL.match('MONTH')) {
		// 含まれている場合
		nowYear = decodeURIComponent(location.search.match(/YEAR=(.*?)(&|$)/)[1]);
		nowMonth = decodeURIComponent(location.search.match(/MONTH=(.*?)(&|$)/)[1]);
	} else {
		// 含まれていない場合、指定の文字列を付け足してリダイレクト
		location.href = document.URL + '?YEAR=' + nowYear + '&MONTH='
				+ nowMonth;
	}
	// プルダウン月の表示
	document.getElementById('select').value = 'http://localhost:8080/Time-card/ListAction.do?YEAR='
			+ nowYear + '&MONTH=' + nowMonth;
}