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
		url:'${ctx}/cusDevPlan/findAll.action',
		method:'get',
		fit:true,
		singleSelect:false,
		toolbar:'#toolbar',
		rownumbers:true,
		fitColumns:true,
		pagination:true,
		columns:[[    
				     {field:'cb',checkbox:true,align:'center'},    
				     {field:'id',title:'编号',width:50,align:'center'},    
				     {field:'customerName',title:'客户名称',width:100,align:'center'},    
				     {field:'overview',title:'概要',width:80,align:'center'},    
				     {field:'linkMan',title:'联系人',width:80,align:'center'},    
				     {field:'createMan',title:'创建人',width:80,align:'center'},    
				     {field:'createTime',title:'创建时间',width:100,align:'center'},    
				     {field:'assignMan',title:'指派人',width:80,align:'center'},    
				     {field:'assignTime',title:'指派时间',width:100,align:'center'},    
				     {field:'devResult',title:'客户开发状态',width:80,align:'center',formatter:function(value,row,index){
				    	 //客户开发状态 0 未开发 1 开发中 2 开发成功 3 开发失败
				    	 if(value==0){
				    		 return "未开发";
				    	 }else if(value==1){
				    		 return "开发中";
				    	 }else if(value==2){
				    		 return "开发成功";
				    	 }else if(value==3){
				    		 return "开发失败";
				    	 }
				     }},    
				     {field:'a',title:'操作',width:80,align:'center',formatter:function(value,row,index){
				    	 if(row.devResult==0||row.devResult==1){
				    		 return "<a href='javascript:openCusDevPlanTab("+row.id+")'>开发</a>";
				    	 }else{
				    		 return "<a href='javascript:openCusDevPlanInfoTab("+row.id+")'>查看详细信息</a>";
				    	 }
				     }},    
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
//如果分配指派人，指派时间为当前时间
$(function(){
	$("#assignMan").combobox({
		onSelect:function(record){
			if(record.trueName!=''){
				$("#assignTime").val(Util.getCurrentDateTime());
			}else{
				$("#assignTime").val("");
			}
		}
	}); 
 });

var url;
/* 打开添加dialog */
function openAddDialog() {
	$("#dialog").dialog("open").dialog("setTitle","添加信息");
	$('#form').form("clear");
	$("#createMan").val('${currentUser.name}');
	$("#createTime").val(Util.getCurrentDateTime());
	url = "${ctx}/saleChance/addSaleChance.action";
	
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
	url = "${ctx}/saleChance/updateSaleChance.action";
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
	        if(!$(this).form("validate")){
	        	$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
	       		 return $(this).form("validate");
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
		'customerName' : $("#customerNameSearch").val(),
		'assignMan' : $("#assignManSearch").val(),
		'devResult' : $("#devResultSearch").val(),
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
					"${ctx}/saleChance/delete.action",
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

</script>

</head>
<body>
	<table id="datagrid"></table>
	
	<!-- toolbar 开始 -->
	<div id="toolbar">
		<div>
		      客户名称：<input style="width: 100px;" type="text" id="customerNameSearch"></input>
		       指派人：<input style="width: 100px;" type="text" id="assignManSearch"></input>
		       开发状态：<select style="width: 100px;" editable="false" panelHeight='auto' id="devResultSearch" class="easyui-combobox" >
		       		<option value="">请选择</option>
					<option value="0">未开发</option>
					<option value="1">开发中</option>
					<option value="2">开发成功</option>
					<option value="3">开发失败</option>
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
	<div id="dialog" style="width:650;height:280,padding: 10px 20px">
		<form action="" id="form" method="post">
			<input type="hidden" id="id" name="id"/>
			<table cellspacing="8px">
		   		<tr>
		   			<td>客户名称：</td>
		   			<td><input type="text" id="customerName" name="customerName" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
		   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td>机会来源</td>
		   			<td><input type="text" id="chanceSource" name="chanceSource" /></td>
		   		</tr>
		   		<tr>
		   			<td>联系人：</td>
		   			<td><input type="text" id="linkMan" name="linkMan" /></td>
		   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td>联系电话：</td>
		   			<td><input type="text" id="linkPhone" name="linkPhone" /></td>
		   		</tr>
		   		<tr>
		   			<td>成功几率(%)：</td>
		   			<td><input type="text" id="successRate" name="successRate" class="easyui-numberbox" data-options="min:0,max:100" required="true"/>&nbsp;<font color="red">*</font></td>
		   			<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   		</tr>
		   		<tr>
		   			<td>概要：</td>
		   			<td colspan="4"><input type="text" id="overview" name="overview" style="width: 420px"/></td>
		   		</tr>
		   		<tr>
		   			<td>机会描述：</td>
		   			<td colspan="4">
		   				<textarea rows="5" cols="50" id="description" name="description"></textarea>
		   			</td>
		   		</tr>
		   		<tr>
		   			<td>创建人：</td>
		   			<td><input type="text" editable="false" id="createMan" name="createMan" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
		   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td>创建时间：</td>
		   			<td><input type="text" readonly="true" id="createTime" name="createTime"/>&nbsp;<font color="red">*</font></td>
		   		</tr>
		   		<tr>
		   			<td>指派给：</td>
		   			<td><input class="easyui-combobox" id="assignMan" name="assignMan" data-options="panelHeight:'auto',editable:false,valueField:'trueName',textField:'trueName',url:'${ctx}/user/getCustomerManagerList.action'"/></td>
		   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td>指派时间：</td>
		   			<td><input type="text" id="assignTime" name="assignTime" readonly="readonly"/></td>
		   		</tr>
		   	</table>
		</form>
	</div>
	<!-- 添加和修改的dialog 结束 -->

	

</body>
</html>