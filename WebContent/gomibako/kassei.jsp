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
		<div>�{�^���������ƁA�{�b�N�X�̔w�i�F���ς��܂��B</div>
		<div>
			<input type="button" name="btn" value="�w�i�F�ύX" onclick="classChange()" />
		</div>
	</div>
	<script type="text/javascript">
		function classChange() {
			/*�{���̏�����*/
			document.getElementById('box').setAttribute('class', 'red');
			/*Internet Explorer�p*/
			document.getElementById('box').setAttribute('className', 'red');
		}
	</script>
</body>
</html>