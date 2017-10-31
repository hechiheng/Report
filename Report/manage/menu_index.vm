<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel='stylesheet' type="text/css" href="$link.setRelative('/manage/css/style.css')" />
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery-1.7.2.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/common.js')"></script>
<script type="text/javascript">

</script>
</head>
<body>
<div class="main">
    <div class="pos">菜单管理</div>    
    <div class="operate">
        <div class="left">
    		<input type="button" onclick="goUrl('$link.setAction('load4MenuAdd')')" class="btn_blue" value="添加菜单">
    	</div>
    	<div class="left_pad">
            <form method="get" action="$link.setAction('load4MenuIndex')">
    			<span style='font-size: 14px;vertical-align: middle;'>菜单名称：</span>
                <input type="text" name="menu.keyword" title="关键字" class="inp_default" value="$!queryMenuForm.menu.keyword">
                <input type="submit" class="btn_blue" value="查  询">
            </form>
        </div>
    </div>
    <div class="list">   
        <table width="100%">
            <tr>
                <th>编号</th>
                <th class="aleft">菜单名称</th>
    			<th class="aleft">路径</th>
                <th>显示</th>
                <th>排序</th>
    			<th>更新时间</th>
                <th>操作</th>
            </tr>
			#set($menuList = $request.getAttribute("menuList"))
			#foreach($menu in $menuList)
			#set($subMenuList = $menu.subMenuList)
			<tr>
                <td>$!menu.id</td>
				<td class="aleft">$!menu.name</td>
				<td class="aleft"></td>
				<td>
					#if($!menu.isshow==1) 是 #else 否 #end
				</td>
				<td>$!menu.sort</td>
				<td>$!menu.updatetime</td>
				<td>
					<a href="$link.setAction('load4MenuAdd').addQueryData('pid',$!menu.id)">添加子菜单</a>
                    <a href="$link.setAction('load4MenuModify').addQueryData('id',$!menu.id)">修改</a>
                    <a href="javascript:;" onclick="toConfirm('$link.setAction('trashMenu').addQueryData('id',$!menu.id).addQueryData('pid',$!menu.pid)','确实要删除吗？')">删除</a>
                </td>
            </tr>
			#foreach($subMenu in $subMenuList)
			<tr>
                <td>$!subMenu.id</td>
				<td class="aleft">&nbsp;&nbsp;├─$!{subMenu.name}</td>
				<td class="aleft">$!subMenu.url</td>
				<td>
					#if($!subMenu.isshow==1) 是 #else 否 #end
				</td>
				<td>$!subMenu.sort</td>
				<td>$!subMenu.updatetime</td>
				<td>
                    <a href="$link.setAction('load4MenuModify').addQueryData('id',$!subMenu.id)">修改</a>
                    <a href="javascript:;" onclick="toConfirm('$link.setAction('trashMenu').addQueryData('id',$!subMenu.id).addQueryData('pid',$!subMenu.pid)','确实要删除吗？')">删除</a>
                </td>
            </tr>
			#end
			#end
        </table>
        <div class="page" style="clear: both;"></div>
    </div>
</div>
</body>
</html>
