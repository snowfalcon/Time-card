<%@ page contentType="text/html; charset=Windows-31J" pageEncoding="Windows-31J" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<style type="text/css">
    .error {
        background-color:#ffaaaa;
    }
</style>

<html:errors />

<html:form action="/sample">

    入力Ａ：<html:text property="inputA" errorStyleClass="error" />（必須）<br />
    <br />

    入力Ｂ：<html:text property="inputB" errorStyleClass="error" />（最低文字数：3文字以上でないとエラー）<br />
    <br />

    入力Ｃ：<html:text property="inputC" errorStyleClass="error" />（最高文字数：5文字以下でないとエラー）<br />
    <br />

    入力Ｄ：<html:text property="inputD" errorStyleClass="error" />（正規表現：郵便番号形式）<br />
    <br />

    入力Ｅ：<html:text property="inputE" errorStyleClass="error" />（数値：Integerに変換可能でないとエラー）<br />
    <br />

    入力Ｆ：<html:text property="inputF" errorStyleClass="error" />（日付：yyyy/M/d形式でないとエラー）<br />
    <br />

    入力Ｇ：<html:text property="inputG" errorStyleClass="error" />（数値範囲：10～20の数値でないとエラー）<br />
    <br />

    入力Ｈ：<html:text property="inputH" errorStyleClass="error" />（Eメール）<br />
    <br />

    入力Ｉ：<html:text property="inputI" errorStyleClass="error" />（URL）<br />
    <br />

    <html:submit />

</html:form>