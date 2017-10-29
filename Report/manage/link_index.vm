<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel='stylesheet' type="text/css" href="$link.setRelative('/manage/css/style.css')" />
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery-1.7.2.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/common.js')"></script>
</head>
<body>
<div class="main">
    <div class="pos">
    	<a href="$link.setAction('load4LinkIndex')">友情链接</a>
    </div>
    <div class="operate">
        <div class="left">
			<input type="button" onclick="goUrl('$link.setAction('load4LinkAdd')')" class="btn_blue" value="添加链接" />
        </div>
		<div class="left_pad">
            <form method="get" action="$link.setAction('load4LinkIndex')">
            	<span style='font-size: 14px;vertical-align: middle;'>网站名称：</span>
                <input type="text" name="link.name" title="关键字" class="inp_default" value="$!queryLinkForm.link.name">
                <input type="submit" class="btn_blue" value="查  询">
            </form>
        </div>
    </div>
    <div class="list">    
        <table width="100%">
            <tr>
                <th>编号</th>
                <th class="aleft" width="20%">网站名称</th>
                <th class="aleft" width="30%">链接位置</th>
                <th>更新时间</th>
                <th>顺序</th>
                <th>操作</th>
            </tr>
			#set($linkList = $request.getAttribute("linkList"))
			#foreach($linkInfo in $linkList)
			<tr>
				<td>$!linkInfo.id</td>
				<td class='aleft'>$!linkInfo.name</td>
				<td class='aleft'>$!linkInfo.url</td>
				<td>$!linkInfo.updatetime</td>
				<td>$!linkInfo.sort</td>
				<td>
					<a href="$link.setAction('load4LinkModify').addQueryData('id',$!linkInfo.id)">编辑</a>
					<a href="javascript:;" onclick="toConfirm('$link.setAction('trashLink').addQueryData('id',$!linkInfo.id)','确实要删除吗？')">删除</a>
                </td>
            </tr>
			#end
        </table>
        <div class="page" style="clear: both;">
        </div>
    </div>
</div>
</body>
</html>
