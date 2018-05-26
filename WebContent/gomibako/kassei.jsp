<%@ page contentType="text/html;charset=Shift_JIS"%>
<html>
<head>
<title></title>
</head>
	<style type="text/css">
#box {
	width: 150px;
	height: 80px;
	border: 1px solid #4c4c4c;
	padding: 12px;
	text-align: center;
}

.red {
	background-color: #ff0000;
}

.gray {
	background-color: #cccccc;
}
</style>
<body>
	<div id="box" class="gray">
		<div>ボタンを押すと、ボックスの背景色が変わります。</div>
		<div>
			<input type="button" name="btn" value="背景色変更" onclick="classChange()" />
		</div>
	</div>
	<script type="text/javascript">
		function classChange() {
			/*本来の書き方*/
			document.getElementById('box').setAttribute('class', 'red');
			/*Internet Explorer用*/
			document.getElementById('box').setAttribute('className', 'red');
		}
	</script>
</body>
</html>