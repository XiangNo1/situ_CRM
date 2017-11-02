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
		url:'${ctx}/customer/findAll.action',
		method:'get',
		fit:true,
		singleSelect:false,
		toolbar:'#toolbar',
		rownumbers:true,
		fitColumns:true,
		pagination:true,
		columns:[[    
		     {field:'cb',checkbox:true,align:'center'},    
		     {field:'id',title:'编号',width:30,align:'center'},    
		     {field:'num',title:'客户编号',width:80,align:'center'},    
		     {field:'name',title:'客户名称',width:100,align:'center'},    
		     {field:'managerName',title:'客户经理',width:80,align:'center'},    
		     {field:'level',title:'客户等级',width:80,align:'center'},    
		     {field:'phone',title:'联系电话',width:100,align:'center'},    
		     {field:'address',title:'客户地区',width:100,align:'center'},    
		     {field:'satisfy',title:'客户满意度',width:100,align:'center'},    
		     {field:'credit',title:'客户信用度',width:100,align:'center'}    
		]]  
	});
	/*添加和修改弹出的dialog */
	$("#dialog").dialog({
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
		
	});
});


var url;
/* 打开添加dialog */
function openAddDialog() {
	$("#dialog").dialog("open").dialog("setTitle","添加信息");
	url = "${ctx}/customer/addCustomer.action";
	$('#form').form("clear");
	
}
/* 打开修改dialog */
function openUpdateDialog() {
	var selections = $("#datagrid").datagrid("getSelections");
	if(selections.length == 0) {
		$.messager.alert("系统提示", "请选择要修改的数据");
		return;
	}
	var row = selections[0];
	$("#dialog").dialog("open").dialog("setTitle","修改信息");
	url = "${ctx}/customer/updateCustomer.action";
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
	        // do some check  
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
		'name' : $("#nameSearch").val(),
		'num' : $("#numSearch").val()
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
					"${ctx}/customer/delete.action",
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

//联系人管理
function lxr(id){
	var selections = $("#datagrid").datagrid("getSelections");
	if(selections.length == 0) {
		$.messager.alert("系统提示", "请选择要查看的联系人数据");
		return;
	}
	var row = selections[0];
	 window.parent.openTab('联系人管理','${ctx}/customerLinkman/index.action?id='+row.id,'icon-lxr');
}
//交往记录管理
function jwjl(id){
	var selections = $("#datagrid").datagrid("getSelections");
	if(selections.length == 0) {
		$.messager.alert("系统提示", "请选择要查看的联系人数据");
		return;
	}
	var row = selections[0];
	 window.parent.openTab('交往记录管理','${ctx}/customerContact/index.action?id='+row.id,'icon-jwjl');
}
//历史订单管理
function lsdd(id){
	var selections = $("#datagrid").datagrid("getSelections");
	if(selections.length == 0) {
		$.messager.alert("系统提示", "请选择要查看的联系人数据");
		return;
	}
	var row = selections[0];
	 window.parent.openTab('历史订单查看','${ctx}/customerOrder/index.action?id='+row.id,'icon-lsdd');
}
</script>

</head>
<body>
	<table id="datagrid"></table>
	
	<!-- toolbar 开始 -->
	<div id="toolbar">
		<a class="easyui-linkbutton" href="javascript:openAddDialog()" iconCls="icon-add">添加</a>
		<a class="easyui-linkbutton" href="javascript:openUpdateDialog()" iconCls="icon-edit">修改</a>
		<a class="easyui-linkbutton" href="javascript:doDelete()" iconCls="icon-remove">删除</a>
		<a class="easyui-linkbutton" href="javascript:lxr()" iconCls="icon-lxr">联系人管理</a>
		<a class="easyui-linkbutton" href="javascript:jwjl()" iconCls="icon-jwjl">交往记录管理</a>
		<a class="easyui-linkbutton" href="javascript:lsdd()" iconCls="icon-lsdd">历史订单查看</a>
		<div>
		      客户编号：<input type="text" id="numSearch"></input>
		       客户名称：<input type="text" id="nameSearch"></input>
		  <a href="javascript:doSearch();" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		</div>
	</div>
	<!-- toolbar 结束 -->
	
	<!-- 添加和修改的dialog 开始 -->
	<div id="dialog" class="easyui-dialog" closed="true" modal="true"
		style="width:780;height:480;padding: 10px 20px" buttons="#dialog-button">
		<form action="" id="form" method="post">
			<input type="hidden" id="id" name="id"/>
			<table cellspacing="8px">
				<tr>
					<td>客户名称：</td>
					<td><input type="text" id="name" name="name" class="easyui-validatebox"/><font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>地区：</td>
					<td><input type="text" id="region" name="region" class="easyui-validatebox"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td>客户经理：</td>
		   			<td><input class="easyui-combobox" id="managerName" name="managerName" data-options="panelHeight:'auto',valueField:'trueName',textField:'trueName',url:'${ctx}/user/getCustomerManagerList.action'"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>客户等级：</td>
					<td>
						<select class="easyui-combobox" id="level" name="level" editable="false" panelHeight='auto'>
							<option value="">请选择</option>
							<option value="战略合作伙伴">战略合作伙伴</option>
							<option value="大客户">大客户</option>
							<option value="普通客户">普通客户</option>
							<option value="合作伙伴">合作伙伴</option>
						</select>
						<font color="red">*</font>
					</td>				
				</tr>
				<tr>
					<td>客户满意度：</td>
					<td><select class="easyui-combobox" panelHeight='auto' id="satisfy" name="satisfy" editable="false">
							<option value="">请选择</option>
							<option value="☆">☆</option>
							<option value="☆☆">☆☆</option>
							<option value="☆☆☆">☆☆☆</option>
							<option value="☆☆☆☆">☆☆☆☆</option>
							<option value="☆☆☆☆☆">☆☆☆☆☆</option>
						</select>
						<font color="red">*</font>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>客户信用度：</td>
					<td><select class="easyui-combobox" panelHeight='auto' id="credit" name="credit" editable="false">
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
				<tr>
					<td>邮政编码：</td>
					<td><input type="text" id="postCode" name="postCode" class="easyui-validatebox"/><font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>联系电话：</td>
					<td><input type="text" id="phone" name="phone" class="easyui-validatebox"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td>传真：</td>
					<td><input type="text" id="fax" name="fax" class="easyui-validatebox"/><font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>网址：</td>
					<td><input type="text" id="webSite" name="webSite" class="easyui-validatebox"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td>客户地址：</td>
		   			<td colspan="4"><input type="text" id="address" name="address" style="width: 420px"/></td>
				</tr>
				<tr>
					<td>营业执照注册号：</td>
					<td><input type="text" id="licenceNo" name="licenceNo" class="easyui-validatebox"/><font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>法人：</td>
					<td><input type="text" id="legalPerson" name="legalPerson" class="easyui-validatebox"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td>注册资金(万元)：</td>
					<td><input type="text" id="bankroll" name="bankroll" class="easyui-validatebox"/><font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>年营业额(万元)：</td>
					<td><input type="text" id="turnover" name="turnover" class="easyui-validatebox"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td>开户银行：</td>
					<td><input type="text" id="bankName" name="bankName" class="easyui-validatebox"/><font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>开户账号：</td>
					<td><input type="text" id="bankAccount" name="bankAccount" class="easyui-validatebox"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td>地税登记号：</td>
					<td><input type="text" id="localTaxNo" name="localTaxNo" class="easyui-validatebox"/><font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>国税登记号：</td>
					<td><input type="text" id="nationalNaxNo" name="nationalTaxNo" class="easyui-validatebox"/><font color="red">*</font></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 添加和修改的dialog 结束 -->
	

</body>
</html>