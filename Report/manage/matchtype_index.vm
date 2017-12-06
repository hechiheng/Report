<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel='stylesheet' type="text/css" href="$link.setRelative('/manage/css1/style.css')" />
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery-1.7.2.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/common.js')"></script>
</head>
<body>
<div class="main">
	<div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="$link.setAction('load4MatchtypeIndex')">赛事类型管理</a></li>
        </ul>
    </div>
    <div class="formbody">
		<form method="get" action="$link.setAction('load4MatchtypeIndex')">
		<ul class="seachform">
			<li>
				<label>赛事类型名称：</label>
				<input type="text" name="matchtype.name" title="关键字" class="scinput" style="width: 200px;" value="$!queryMatchtypeForm.matchtype.name">
            </li>
			<li>
				<label>&nbsp;</label>
				<input name="" type="submit" class="scbtn" value="查询"/>
			</li>
			<li>
				<input type="button" onclick="goUrl('$link.setAction('load4MatchtypeAdd')')" class="scbtn" style="width: 110px;" value="添加赛事类型" />
			</li>
        </ul>
        </form>
    </div>
    <table class="tablelist">
        <tr>
            <th>编号</th>
			<th>赛事类型名称</th>
			<th width="40%">赛事类型描述</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
		<tbody>
		#set($matchtypeList = $request.getAttribute("matchtypeList"))
		#foreach($matchtype in $matchtypeList)
		<tr>
			<td>$!matchtype.id</td>
			<td>$!matchtype.name</td>
			<td>$!matchtype.description</td>
			<td>
				#if($!matchtype.isdisabled==0)
                    <span style='color: green;'>正常</span> 
				#else
					<span style='color: red;'>禁用</span>
				#end
			</td>
			<td>
				<a class="tablelink" href="$link.setAction('load4MatchtypeModify').addQueryData('id',$!matchtype.id)">编辑</a>
				#if($!matchtype.isdisabled==0)
				<a class="tablelink" href="javascript:;" onclick="toConfirm('$link.setAction('disabledMatchtype').addQueryData('id',$!matchtype.id)','确实要禁用吗？')">禁用</a>
				#else
				<a class="tablelink" href="javascript:;" onclick="toConfirm('$link.setAction('enableMatchtype').addQueryData('id',$!matchtype.id)','确实要启用吗？')">启用</a>
				#end
				<a class="tablelink" href="javascript:;" onclick="toConfirm('$link.setAction('trashMatchtype').addQueryData('id',$!matchtype.id)','确实要删除吗？')">删除</a>
            </td>
        </tr>
		#end
		</tbody>
    </table>
    <div class="page" style="clear: both;">
    </div>
	<script type="text/javascript">
    	jQuery('.tablelist tbody tr:odd').addClass('odd');
    </script>
</div>
</body>
</html>
