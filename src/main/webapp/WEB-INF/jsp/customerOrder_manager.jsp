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
	$.post("${ctx}/customer/findById.action", 
			{id : '${param.id}'}, 
			function(result) {
					$("#num").val(result.num);
					$("#name").val(result.name);
				
			}, 
			"json");
	
		/*展示数据的datagrid表格*/
		$("#datagrid").edatagrid({
			url:'${ctx}/customerOrder/findAll.action?id=${param.id}',//只查询已分配咨询师的
			saveUrl:'${ctx}/customerOrder/add.action?customerId=${param.id}',
			updateUrl:'${ctx}/customerOrder/update.action?id=${param.id}',
			destroyUrl:'${ctx}/customerOrder/deleteById.action',
			title:'客户历史订单',
			singleSelect:true,
			toolbar:'#toolbar',
			rownumbers:true,
			fitColumns:true,
			columns:[[    
			     {field:'id',title:'编号',width:50,align:'center'},    
			     {field:'orderNo',title:'订单号',width:80,align:'center',editor:{type:'validatebox',options:{required:true}}},    
			     {field:'orderDate',title:'订单日期',width:100,align:'center',editor:{type:'datebox',options:{required:true}}},    
			     {field:'address',title:'送货地址',width:80,align:'center',editor:{type:'validatebox',options:{required:true}}},  
			     {field:'status',title:'状态',width:80,align:'center',formatter:function(value,row,index){
			    	 if(value==0){
			    		 return "未回款";
			    	 }else if(value==1){
			    		 return "已回款";
			    	 }
			     }},{field:'a',title:'操作',width:80,align:'center',formatter:function(value,row,index){
			    		 return "<a href='javascript:openOrderInfoTab("+row.id+")'>查看订单明细</a>";
			     }}
			]]
		});
	});
/* 打开修改dialog */
function openOrderInfoTab(id) {
	$("#dialog").dialog("open").dialog("setTitle","查看订单明细");
	$.ajax({
        url:"${ctx}/customerOrder/findItemById.action",
        type: "POST",
        /* data的类型是json字符串 */
        data:"orderId="+id,
        dataType:"json",
        success: function(data) {
        	$('#productName').val(data.productName);
        	$('#productNum').val(data.productNum);
        	$('#unit').val(data.unit);
        	$('#price').val(data.price);
        	$('#sum').val(data.sum);
        }
    });
}	

</script>
</head>
<body>
	<!-- 联系人信息面板  开始 -->
	<div id="p" class="easyui-panel" title="客户基本信息" style="width: 700px;height: 120px">
	 	<table cellspacing="8px">
	   		<tr>
	   			<td>客户编号：</td>
	   			<td><input type="text" id="num" name="num" readonly="readonly"/></td>
	   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	   			<td>客户名称：</td>
	   			<td><input type="text" id="name" name="name" readonly="readonly"/></td>
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
	
	
<!-- 添加和修改的dialog 开始 -->
	<div id="dialog" class="easyui-dialog" closed="true" modal="true"
		style="width:650;height:280,padding: 10px 20px" buttons="#dialog-button">
		<form action="" id="form" method="post">
			<input type="hidden" id="id" name="id"/>
			<table cellspacing="8px">
				<tr>
					<td>商品名称：</td>
					<td><input type="text" id="productName" name="productName" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
					<td>&nbsp;</td>
					<td>商品数量：</td>
					<td><input type="text" id="productNum" name="productNum" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td>单位：</td>
					<td><input type="text" id="unit" name="unit" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
					<td>&nbsp;</td>
					<td>价格：</td>
					<td><input type="text" id="price" name="price" class="easyui-validatebox" required="true" validType="email"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td>总金额：</td>
					<td><input type="text" id="sum" name="sum" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 添加和修改的dialog 结束 -->
		

</body>
</html>