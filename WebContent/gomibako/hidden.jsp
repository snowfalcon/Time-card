<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
<HEAD>
<TITLE>
表示非表示
</TITLE>
<!--ここまで-->
</HEAD>
<BODY>
<div id="disp">この文章を表示したり消したりします。</div>
<form>
<input type="button" value="表示" onclick="hyoji1(0)">
<input type="button" value="非表示" onclick="hyoji1(1)">
</form>
<script>

function hyoji1(num)
{
  if (num == 0)
  {
    document.getElementById("disp").style.display="block";
  }
  else
  {
    document.getElementById("disp").style.display="none";
  }
}

</script>
</BODY>
</HTML>
