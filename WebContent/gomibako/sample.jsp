<%@ page contentType="text/html; charset=Windows-31J" pageEncoding="Windows-31J" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<style type="text/css">
    .error {
        background-color:#ffaaaa;
    }
</style>

<html:errors />

<html:form action="/sample">

    ���͂`�F<html:text property="inputA" errorStyleClass="error" />�i�K�{�j<br />
    <br />

    ���͂a�F<html:text property="inputB" errorStyleClass="error" />�i�Œᕶ�����F3�����ȏ�łȂ��ƃG���[�j<br />
    <br />

    ���͂b�F<html:text property="inputC" errorStyleClass="error" />�i�ō��������F5�����ȉ��łȂ��ƃG���[�j<br />
    <br />

    ���͂c�F<html:text property="inputD" errorStyleClass="error" />�i���K�\���F�X�֔ԍ��`���j<br />
    <br />

    ���͂d�F<html:text property="inputE" errorStyleClass="error" />�i���l�FInteger�ɕϊ��\�łȂ��ƃG���[�j<br />
    <br />

    ���͂e�F<html:text property="inputF" errorStyleClass="error" />�i���t�Fyyyy/M/d�`���łȂ��ƃG���[�j<br />
    <br />

    ���͂f�F<html:text property="inputG" errorStyleClass="error" />�i���l�͈́F10�`20�̐��l�łȂ��ƃG���[�j<br />
    <br />

    ���͂g�F<html:text property="inputH" errorStyleClass="error" />�iE���[���j<br />
    <br />

    ���͂h�F<html:text property="inputI" errorStyleClass="error" />�iURL�j<br />
    <br />

    <html:submit />

</html:form>