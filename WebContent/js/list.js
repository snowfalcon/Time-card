//url移動
function navi(obj) {
	url = obj.options[obj.selectedIndex].value;
	if (url != "") {
		location.href = url;
	}
}

// CSVメッセージ
function csvmsg() {
	myRet = confirm("CSVを出力します。よろしいですか？");
	if (myRet == true) {
		location.href = 'http://localhost:8080/Time-card/ListAction.do'
	}
}

// 戻るメッセージ上位権限者
function returnmsg() {
	myRet = confirm("前画面に戻ります。入力した情報は失われます。");
	if (myRet == true) {
		location.href = 'http://localhost:8080/Time-card/LoginAction.do'
		session.setAttribute("CId", param.getInputId());
	}
}

// 戻るメッセージ下位権限者
function backmsg() {
	myRet = confirm("打刻画面に戻ります。よろしいですか？");
	if (myRet == true) {
		location.href = 'http://localhost:8080/Time-card/LoginAction.do'
	}
}

// ログアウトメッセージ
function logoutmsg() {
	myRet = confirm("ログアウトします。よろしいですか？");
	if (myRet == true) {
		location.href = 'http://localhost:8080/Time-card/logout'
	}
}
// プルダウン月の表示
function param() {
	var nowYear = decodeURIComponent(location.search.match(/YEAR=(.*?)(&|$)/)[1]);
	var nowMonth = decodeURIComponent(location.search.match(/MONTH=(.*?)(&|$)/)[1]);
	document.getElementById('select').value = 'http://localhost:8080/Time-card/ListAction.do?YEAR='
			+ nowYear + '&MONTH=' + nowMonth;
}

//プルダウン氏名の表示
function name(name) {
	document.getElementById('shain').value = name;
}

// 今までの年月表示
function select() {
	// 今日の日付データを変数todayに格納
	var optionLoop, this_day, this_month, this_year, today;
	today = new Date();
	this_year = today.getFullYear();
	this_month = today.getMonth() + 1;
	// ループ処理（スタート数字、終了数字、表示id名、デフォルト数字） // ループ処理（スタート数字、終了数字、表示id名、デフォルト数字）
	optionLoop = function(start, end, start2, end2, id, this_year, thismonth) {
		var i
		var j, opt;
		opt = null;
		for (i = thismonth; i >= start; i--) {
			opt += '<option value="http://localhost:8080/Time-card/ListAction.do?YEAR='
					+ end2 + '&MONTH=' + i + '">' + end2 + '年' + i + '月';
		}
		for (j = end2 - 1; j >= start2; j--) {
			for (i = end; i >= start; i--) {
				opt += '<option value="http://localhost:8080/Time-card/ListAction.do?YEAR='
						+ j + '&MONTH=' + i + '">' + j + '年' + i + '月';
			}
		}
		return document.getElementById(id).innerHTML = opt;
	};
	// 関数設定（スタート数字[必須]、終了数字[必須]、表示id名[省略可能]、デフォルト数字[省略可能]）
	optionLoop(1, 12, 2010, this_year, 'select', this_year, this_month);
}

// csv出力
var tableToCSV = {
	export : function(elm /* , delimiter */) {
		var table = elm;
		var rows = this.getRows(table);
		var lines = [];
		var delimiter = delimiter || ',';
		for (var i = 0, numOfRows = rows.length; i < numOfRows; i++) {
			var cols = this.getCols(rows[i]);
			var line = [];
			for (var j = 0, numOfCols = cols.length; j < numOfCols; j++) {
				var text = cols[j].textContent || cols[j].innerText;
				text = text.replace(/"/g, '""');
				line.push(text);
			}
			lines.push(line.join(delimiter));
		}
		this.saveAsFile(lines.join("\r\n"));
	},

	saveAsFile : function(csv) {
		var blob = new Blob([ csv ], {
			type : 'text/csv'
		});
		var url = URL.createObjectURL(blob);
		var a = document.createElement("a");
		a.href = url;
		a.target = '_blank';
		a.download = 'javascriptcsv.csv';
		a.click();
	},

	getRows : function(elm) {
		return Util.getNodesByName(elm, 'tr');
	},

	getCols : function(elm) {
		return Util.getNodesByName(elm, [ 'td', 'th' ]);
	}
}

var Util = {
	getNodesByName : function(elm /* , string or array */) {
		var children = elm.childNodes;
		var nodeNames = ('string' === typeof arguments[1]) ? [ arguments[1] ]
				: arguments[1];
		nodeNames = nodeNames.map(function(str) {
			return str.toLowerCase()
		});
		var results = [];
		for (var i = 0, max = children.length; i < max; i++) {
			if (nodeNames.indexOf(children[i].nodeName.toLowerCase()) !== -1) {
				results.push(children[i]);
			} else {
				results = results.concat(this.getNodesByName(children[i],
						nodeNames));
			}
		}
		return results;
	}
}

//今までの年月表示
function csv() {
var obj2 = document.getElementById("csv");
obj2.addEventListener("click", function(e) {
	myRet = confirm("CSVを出力します。よろしいですか？");
	if (myRet == true) {
		e.preventDefault();
		tableToCSV.export(document.getElementById('tbl'));
	}
}, false);
}

//修正
function popup(year,month,day) {
    window.open("RevisionAction.do","preview","width=600,height=450,scrollbars=no,resize=no");
    document.input_form.target = "preview";
    document.input_form.method = "post";
    document.input_form.action = "preview.php";
    document.input_form.submit();
}
