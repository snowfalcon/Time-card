<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
<HEAD>
<TITLE>
プルダウンメニューによるリンク
</TITLE>
<!--別フレームにリンクしたい場合は下の※を見てください ここから-->
<script language="javascript">
<!--
function navi(obj) {
 url = obj.options[obj.selectedIndex].value;
 if(url != "") {
   location.href = url;
  }
}
//-->
</script>
<!--ここまで-->
</HEAD>
<BODY>
<form method=post>
<select onChange="navi(this)">
<!-- valueにURLを記入 -->
<option value=""> --- リンクメニュー ---
<option value="http://www.yahoo.co.jp/">Yahoo!
<option value="http://www.goo.ne.jp/">Goo
<option value="http://www.excite.co.jp">Excite
<option value="http://www.infoseek.co.jp">Infoseek
<option value="../index.html">Top Page>Top page
</select>
</form>
</BODY>
</HTML>
