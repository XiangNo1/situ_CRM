<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	//查询指定id的销售机会
	$.post("${ctx}/customerLoss/findById.action", 
			{id : '${param.id}'}, 
			function(result) {
					$("#customerNo").val(result.customerNo);
					$("#customerName").val(result.customerName);
					$("#customerManager").val(result.customerManager);
					$("#lastOrderTime").val(result.lastOrderTime);
			}, 
			"json");
	
		/*展示数据的datagrid表格*/
		$("#datagrid").edatagrid({
			url:'${ctx}/customerLossMeasure/findAll.action?id=${param.id}',//只查询已分配咨询师的
			saveUrl:'${ctx}/customerLossMeasure/add.action?lossId=${param.id}',
			updateUrl:'${ctx}/customerLossMeasure/update.action?id=${param.id}',
			destroyUrl:'${ctx}/customerLossMeasure/deleteById.action',
			title:'客户流失暂缓措施管理',
			singleSelect:true,
			toolbar:'#toolbar',
			rownumbers:true,
			fitColumns:true,
			columns:[[    
			     {field:'id',title:'编号',width:50,align:'center'},    
			     {field:'measure',title:'暂缓措施',width:100,align:'center',editor:{type:'validatebox',options:{required:true}}},    
			]]
		});
	});
	
</script>
</head>
<body>
	<!-- 联系人信息面板  开始 -->
	<div id="p" class="easyui-panel" title="客户流失基本信息" style="width: 700px;height: 120px">
	 	<table cellspacing="8px">
	   		<tr>
	   			<td>客户编号：</td>
	   			<td><input type="text" id="customerNo" name="customerNo" readonly="readonly"/></td>
	   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	   			<td>客户名称：</td>
	   			<td><input type="text" id="customerName" name="customerName" readonly="readonly"/></td>
	   		</tr>
	   		<tr>
	   			<td>客户经理：</td>
	   			<td><input type="text" id="customerManager" name="customerManager" readonly="readonly"/></td>
	   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	   			<td>上次下单时间：</td>
	   			<td><input type="text" id="lastOrderTime" name="lastOrderTime" readonly="readonly"/></td>
	   		</tr>
	   	</table>
	 </div>
	 <!-- 联系人信息面板  结束  -->
	 
	 <br/>
	 
	<!-- 客户开发计划项table -->
	<table id="datagrid" style="width:700px;height:250px"></table>
	
	<!-- toolbar 开始 -->
	 <div id="toolbar">
	 	<c:if test="${param.show!='true' }">
		 	<a href="javascript:$('#datagrid').edatagrid('addRow')" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加计划</a>
		 	<a href="javascript:$('#datagrid').edatagrid('destroyRow')" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除计划</a>
		 	<a href="javascript:$('#datagrid').edatagrid('cancelRow')" class="easyui-linkbutton" iconCls="icon-undo" plain="true">撤销行</a>
		 	<a href="javascript:$('#datagrid').edatagrid('saveRow');$('#datagrid').edatagrid('reload')" class="easyui-linkbutton" iconCls="icon-save" plain="true">保存计划</a>
	 	</c:if>
	 </div>
	<!-- toolbar 结束 -->
	
	


</body>
</html>