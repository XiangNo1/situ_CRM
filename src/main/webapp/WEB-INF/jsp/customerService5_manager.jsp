<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>
$(function(){
	/*展示数据的datagrid表格*/
	$("#datagrid").datagrid({
		url:'${ctx}/customerService5/findAll.action',
		method:'get',
		fit:true,
		singleSelect:false,
		toolbar:'#toolbar',
		rownumbers:true,
		fitColumns:true,
		pagination:true,
		columns:[[    
		     {field:'cb',checkbox:true,align:'center'},    
		     {field:'id',title:'编号',width:80,align:'center'},    
		     {field:'customer',title:'客户',width:100,align:'center'},    
		     {field:'overview',title:'概要',width:80,align:'center'},    
		     {field:'serviceType',title:'服务类型',width:80,align:'center'},    
		     {field:'createPeople',title:'创建人',width:100,align:'center'},    
		     {field:'createTime',title:'创建日期',width:100,align:'center'}   
		]]  
	});
	/*添加和修改弹出的dialog */
	/* $("#dialog").dialog({
		closed:'true',
		buttons:[
			{
				text:'保存',
				iconCls:'icon-ok',
				handler:function(){
					doSave();
				}
			},
			{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog("close");
				}
			}
			
		]
		
	}); */
});


var url;
/* 打开添加dialog */
function openAddDialog() {
	$("#dialog").dialog("open").dialog("setTitle","添加信息");
	url = "${ctx}/customerService5/addCustomerService5.action";
	$('#form').form("clear");
	
}
/* 打开修改dialog */
function openUpdateDialog() {
	var selections = $("#datagrid").datagrid("getSelections");
	if(selections.length == 0) {
		$.messager.alert("系统提示", "请选择要查看的客户");
		return;
	}
	var row = selections[0];
	$("#dialog").dialog("open").dialog("setTitle","客户服务详情");
	url = "${ctx}/customerService5/updateCustomerService5.action";
	$('#form').form("load", row);
}

function closeDialog(){
	 $("#dialog").dialog("close");
}

function doSave(){
	$.messager.progress();	// 显示进度条
	$('#form').form('submit', {    
	    url:url,    
	    onSubmit: function(){    
	        if($("#assigner").combobox("getValue") == "") {
	        	$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
	        	$.messager.alert("系统提示", "请选择分配对象");
	        	return false;
	        }
	        //validate none 做表单字段验证，当所有字段都有效的时候返回true。该方法使用validatebox(验证框)插件。 
	        // return false to prevent submit;  
	    },    
	    success:function(data){//正常返回ServerResponse
	    	$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
	    	var data = eval('(' + data + ')');
	    	if(data.status == Util.SUCCESS) {
	    		$.messager.show({
					title:'系统提示',
					msg:data.msg,
					timeout:3000,
					showType:'fade'
				});
	    		$("#dialog").dialog("close");
	    		$("#datagrid").datagrid("reload");
	    	}
	    	else {
				$.messager.alert('系统提示',data.msg);
			}
	    }    
	});  
}


function doSearch(){
	$("#datagrid").datagrid("load",{
		'customer' : $("#customerSearch").val(),
		'overview' : $("#overviewSearch").val(),
		'serviceType' : $("#serviceTypeSearch").val(),
		'startTime':$("#startTime").val(),
		'endTime':$("#endTime").val()
	})
};

function doDelete() {
	$.messager.progress();	// 显示进度条
	var ids = Util.getSelectionsIds("#datagrid");
	if(ids.length == 0) {
		$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
		$.messager.alert('系统提示','请选择要删除的数据！');
		return;
	}
	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	    if (r){    
	    	$.post(
					"${ctx}/customerService5/delete.action",
					{ids:ids}, 
					function(data) {
						$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
						if(data.status == 0) {
							$.messager.show({
								title:'系统提示',
								msg:data.msg,
								timeout:3000,
								showType:'fade'
							});
							$("#datagrid").datagrid("reload");
						}
						else{
							$.messager.alert(data.msg);
						}
					},
					"json"
				);
	    }
	    else{
	    	$.messager.progress('close');
	    }
	}); 
}
$(function(){
	$("#serviceDealPeople").combobox({
		onSelect:function(record){
			if(record.trueName!=''){
				$("#serviceFealTime").val(Util.getCurrentDateTime());
			}else{
				$("#serviceFealTime").val("");
			}
		}
	}); 
 });

</script>

</head>
<body>
	<table id="datagrid"></table>
	
	<!-- toolbar 开始 -->
	<div id="toolbar">
		<a class="easyui-linkbutton" href="javascript:openUpdateDialog()" iconCls="icon-fwgd">查看客户服务详情</a>
		<div>
		      客户名称：<input style="width: 100px;" type="text" id="customerSearch"></input>
		      概要：<input style="width: 100px;" type="text" id="overviewSearch"></input>
		       服务类型：<select style="width: 100px;" editable="false" panelHeight='auto' id="serviceTypeSearch" class="easyui-combobox" >
		       		<option value="">请选择</option>
					<option value="咨询">咨询</option>
					<option value="建议">建议</option>
					<option value="投诉">投诉</option>
				</select>
			创建时间范围：
				<input id="startTime" name="startTime" class="easyui-datebox" data-options="sharedCalendar:'#cc'">
				<input id="endTime" name="endTime" class="easyui-datebox" data-options="sharedCalendar:'#cc'"> 	
		  <a href="javascript:doSearch();" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		</div>
	</div>
	<!-- toolbar 结束 -->
	<!-- 日历 -->
	<div id="cc" class="easyui-calendar"></div>
	<!-- 添加和修改的dialog 开始 -->
	<div id="dialog" class="easyui-dialog" closed="true" modal="true"
		style="width:690;height:270,padding: 10px 20px" buttons="#dialog-button">
		<form action="" id="form" method="post">
			<input type="hidden" id="id" name="id"/>
			<table cellspacing="8px">
		   		<tr>
		   			<td>服务类型：</td>
					<td>
						<select readonly="readonly" style="width: 160px;" class="easyui-combobox" id="serviceType" panelHeight='auto' name="serviceType" editable="false">
							<option value=""></option>
							<option value="咨询">咨询</option>
							<option value="建议">建议</option>
							<option value="投诉">投诉</option>
						</select>
						<font color="red">*</font>
					</td>
		   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td>客户：</td>
		   			<td><input readonly="readonly" type="text" id="customer" name="customer" /></td>
		   		</tr>
		   		<tr>
		   			<td>概要：</td>
		   			<td colspan="4"><input readonly="readonly" type="text" id="overview" name="overview" style="width: 420px"/></td>
		   		</tr>
		   		<tr>
		   			<td>服务请求：</td>
		   			<td colspan="4">
		   				<textarea rows="5" readonly="readonly" cols="50" id="serviceRequest" name="serviceRequest"></textarea>
		   			</td>
		   		</tr>
		   		<tr>
		   			<td>创建人：</td>
		   			<td><input type="text" readonly="readonly" editable="false" id="createPeople" name="createPeople" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
		   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td>创建时间：</td>
		   			<td><input type="text" readonly="true" id="createTime" name="createTime"/>&nbsp;<font color="red">*</font></td>
		   		</tr>
		   		<tr>
		   			<td>分配给：</td>
		   			<td>
		   				<input class="easyui-combobox" readonly="readonly" id="assigner" name="assigner" data-options="panelHeight:'auto',editable:false,valueField:'trueName',textField:'trueName',url:'${ctx}/user/getCustomerManagerList.action'"/>
		   			</td>
		   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td>分配时间：</td>
		   			<td><input type="text" id="assignTime" name="assignTime" readonly="readonly"/></td>
	   			</tr>
	   			<tr>
		   			<td>服务处理：</td>
		   			<td colspan="4">
		   				<textarea rows="5" readonly="readonly" cols="50" id="serviceDeal" name="serviceDeal"></textarea>
		   			</td>
		   		</tr>
	   			<tr>
		   			<td>处理人：</td>
		   			<td>
		   				<input class="easyui-combobox" readonly="readonly" id="serviceDealPeople" name="serviceDealPeople" data-options="panelHeight:'auto',editable:false,valueField:'trueName',textField:'trueName',url:'${ctx}/user/getCustomerManagerList.action'"/>
		   			</td>
		   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td>处理时间：</td>
		   			<td><input type="text" id="serviceFealTime" name="serviceFealTime" readonly="readonly"/></td>
	   			</tr>
	   			<tr>
		   			<td>处理结果：</td>
		   			<td><input type="text" readonly="readonly" id="serviceDealResult" name="serviceDealResult" required="true" /></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>客户满意度：</td>
					<td><select class="easyui-combobox" readonly="readonly" panelHeight='auto' id="satisfy" name="satisfy" editable="false">
							<option value="">请选择</option>
							<option value="☆">☆</option>
							<option value="☆☆">☆☆</option>
							<option value="☆☆☆">☆☆☆</option>
							<option value="☆☆☆☆">☆☆☆☆</option>
							<option value="☆☆☆☆☆">☆☆☆☆☆</option>
						</select>
						<font color="red">*</font>
					</td>
				</tr>
		   	</table>
		</form>
	</div>
	<!-- 添加和修改的dialog 结束 -->
	

</body>
</html>