<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="js/jquery-easyui-1.5.3/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.5.3/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.5.3/themes/color.css">
<script type="text/javascript"
	src="js/jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var url1="";
function fun() {
	
		$("#userTable").datagrid({
			idField : 'id',//只要写数据表格一定要加idField
			title : '用户列表',
			width : 632,
			height : 400,
			url : 'userServlet?method=queryAllUser',
			loadMsg : '数据正在加载中，请等待....',
			rownumbers : true,//行号
			singleSelect : true,
			striped : true,//奇偶行颜色不一样
			columns : [ [{
				field : 'u_id',
				title : '用户id',
				width : 100
			}, {
				field : 'u_name',
				title : '用户姓名',
				width : 100
			}, {
				field : 'u_loginName',
				title : '登陆名',
				width : 100
			} , {
				field : 'u_password',
				title : '密码',
				width : 100
			}, {
				field : 'u_age',
				title : '年龄',
				width : 100
			}, {
				field : 'u_sex',
				title : '性别',
				width : 100,
				styler: function(value,row,index){
					if (value == '男'){
						return 'background-color:#ffee00;color:red;';
					}
				}
			}] ],
			pagination:true,
			pageSize:5,
			pageList:[5,10,15,20],
			toolbar : [ {
				text : '新增用户',
				iconCls : 'icon-add',
				handler : function() {
					$('#addUserDialog').dialog('open');
					 $("#btnsave").click(function(){
						 
					if($('#addform').form('validate')){
						$.ajax({
							type:'post',
							url:'userServlet?method=addUser',
							cache:false,
							data:$('#addform').serialize(),
							dataType:'json',
							success:function(){
								fun();
								//提交成功关闭窗口
								$('#addUserDialog').dialog('close');
								//提示保存成功
								$.messager.show({
									title:result.status,
									msg:result.message
								});  
							},
							error:function(result){
								$.messager.show({
									title:result.status,
									msg:result.message
								});
							} 
									
						});
					}else{
						$.messager.show({
							title:'提示信息',
							msg:'数据验证未通过，不能保存！'
						});
					} 
					 })
				}
			}, {
				text : '修改用户',
				iconCls : 'icon-edit',
				handler : function() {
					/*  $('#addUserDialog').dialog('open').dialog('setTitle','修改'); */
					 var row = $('#userTable').datagrid('getSelected');
			          if (row){
			                $('#addUserDialog').dialog('open').dialog('setTitle','修改');
			                $('#addform').form('load',row);
			                url1 = 'userServlet?method=updateUser'; 
			           } 
			          $("#btnsave").click(function(){
			        	  if($('#addform').form('validate')){
			      			$.ajax({
			      				type:'post',
			      				url:url1,
			      				cache:false,
			      				data:$('#addform').serialize(),
			      				dataType:'json',
			      				success:function(){
			      					//提交成功关闭窗口
			      					fun();
			      					$('#addUserDialog').dialog('close');
			      					//提示保存成功
			      					$.messager.show({
			      						title:result.status,
			      						msg:result.message
			      					});  
			      				},
			      				error:function(result){
			      					$.messager.show({
			      						title:result.status,
			      						msg:result.message
			      					});
			      				} 
			      						
			      			});
			      		}else{
			      			$.messager.show({
			      				title:'提示信息',
			      				msg:'数据验证未通过，不能保存！'
			      			});
			      		} 
			          })
				}
			}, {
				text : '删除用户',
				iconCls : 'icon-remove',
				handler : function() {
					var row = $('#userTable').datagrid('getSelected');
		            if (row){
		                 $.messager.confirm('确认','您确定要删除吗？',function(r){
		                    if (r){
		                    	$.ajax({
		            				type:'post',
		            				url:'userServlet?method=deleteUser',
		            				data:"u_id="+row.u_id,
		            				dataType:'json',
		            				success:function(){
		            					fun();
		            					$.messager.show({
		            						title:result.status,
		            						msg:result.message
		            					});  
		            				},
		            				error:function(result){
		            					$.messager.show({
		            						title:result.status,
		            						msg:result.message
		            					});
		            				} 
		            						
		            			});
		                    }
		                });
		            }
				}
			}, {
				text : '查询用户',
				iconCls : 'icon-search',
				handler : function() {
				}
			} ],
		});
}
	$(function() {
		fun();
	});
/* 	$('#btnsave').click(function() {
	
		
	}); */
	/* $('#btnclose').click(function() {
		$('#addDialog').dialog('close');
	}); */
</script>
</head>
<body style="margin:20px 200px">
<table id="userTable"></table>
<div id="addUserDialog" modal="true" title="新增用户" draggable="false"
		class="easyui-dialog" closed="true" style="width: 320px">
		<form id="addform" action="" method="post">
			<table>
				<tr>
					<td><input type="hidden" name="u_id" style="width: 155px;"
						class="easyui-validatebox"  
						value="" /></td>
				</tr>
				<tr>
					<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
					<td><input type="text" name="u_name" style="width: 155px;"
						class="easyui-validatebox" required=true
						value="" /></td>
				</tr>
				<tr>
					<td>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
					<td><input type="text" name="u_loginName" style="width: 155px;"
						class="easyui-validatebox" required=true
						value="" /></td>
				</tr>
				<tr>
					<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
					<td><input type="text" name="u_password" style="width: 155px;"
						class="easyui-validatebox" required=true
						value="" /></td>
				</tr>
				<tr>
					<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
					<td>男<input type="radio" checked="checked" name="u_sex"
						value="男" /> 女 <input type="radio" name="u_sex" value="女" />
					</td>
				</tr>
				<tr>
					<td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:</td>
					<td><input id="age" style="width: 159px;" type="text"
						name="u_age" value="" /></td>
				</tr>
				<tr align="center">
					<td colspan="2"><a id="btnsave" class="easyui-linkbutton" >确认保存</a>
						<a id="btnclose" class="easyui-linkbutton">放弃保存</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>