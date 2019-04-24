<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/all.css" />

<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script type="text/javascript" src=jquery-3.3.1.js></script>
<title>SCHOOL管理SYSTEM</title>
<script type="text/javascript">

<meta charset="utf-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
<title>おばけ</title>
<script>
$(function() {
  $('p').click(function() {$(this).fadeOut('slow');});
});
</script>


	$(function(){
	$("#addbutton").click(function(){
		$("#addForm").submit();

	})
})
</script>
</head>
<body>
<h1 align="center">SCHOOL管理</h1>
	<div id="all_comm" class="all">
		<h2 align="center">SCHOOL信息一覧</h2>
	<table  border="4"  align="center">
			<thead>
				<tr align="center">
					<td>ID</td>
					<td>校名</td>
					<td>地址</td>
					<td>建成日期	</td>
					<td>国家</td>
				</tr>
			</thead>
			<c:forEach items="${schools}" var="school">
				<tr align="center">
					<td id="${school.id }">${school.id}</td>
					<td id="${school.id }">${school.schoolname}</td>
					<td id="${school.id}">${school.address}</td>
					<td id="${school.id }">${school.buildtime}</td>
					<td id="${school.id}">${school.countryname}</td>

				</tr>
			</c:forEach>
		</table>
					<div id="add_comm" class="teaall" align="center">
	<h2>schoolnameの検索</h2>
	<form action=queryByschName method="post">
		<input type="text" placeholder="schoolname" name="schoolname">
		<input type="submit" value="schoolnameの検索">

	</form>
</div>
<div id="add_comm" class="teaall" align="center">
	<h2>schoolidの検索</h2>
	<form action=queryByschId method="post">
		<input type="text" placeholder="id" name="id">
		<input type="submit" value="schoolidの検索">
	</form>
</div>
<div id="add_comm" class="all" align="center">
		<h2 id="edit_title">schoolの追加</h2>
		<form id="addForm" action="addschool" method="post" class="checkform">
			<input id="addname" type="text" placeholder="schoolname" name="schoolname" />
			<input id="addbirthday" type="text" placeholder="address" name="address" />
			<input id="addclassid" type="text" placeholder="buildtime" name="buildtime" />
			<input id="addclassid" type="text" placeholder="countryname" name="countryname" />
			<button id="addbutton" type="button">
			<p>添加</p>
			</button>
		</form>
	</div>
</body>
</html>

