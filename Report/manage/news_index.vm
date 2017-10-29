<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel='stylesheet' type="text/css" href="$link.setRelative('/manage/css/style.css')" />
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery-1.7.2.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/common.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/jBox.config.js')"></script>
<script type="text/javascript">

</script>
</head>
<body>
<div class="main">
    <div class="pos">
    	<a href="$link.setAction('load4NewsIndex')">新闻管理</a>
    </div>
    <div class="operate">
        <div class="left">
		#set($istrash = $request.getAttribute("istrash"))
		#if($istrash=="1")
			<input type="button" onclick="goUrl('$link.setAction('load4NewsIndex')')"  class="btn_blue" value="返回" />
		#else
			<input type="button" onclick="goUrl('$link.setAction('load4NewsAdd')')" class="btn_blue" value="添加新闻" />
            <input type="button" onclick="goUrl('$link.setAction('load4NewsIndex').addQueryData('istrash','1')')" class="btn_green" value="回收站" />
		#end
        </div>
		#if($istrash=="1")
			&nbsp;
		#else
		<div class="left_pad">
            <form method="get" action="$link.setAction('load4NewsIndex')">
            	<span style='font-size: 14px;vertical-align: middle;'>标题：</span>
                <input type="text" name="news.title" title="关键字" class="inp_default" value="$!queryNewsForm.news.title">
                <input type="submit" class="btn_blue" value="查  询">
            </form>
        </div>
		#end
    </div>
    <div class="list">    
        <table width="100%">
            <tr>
                <th>编号</th>
                <th class="aleft">新闻标题</th>
                <th>发布状态</th>
                <th>发布时间</th>
                <th>更新时间</th>
                <th>操作</th>
            </tr>
			#set($newsList = $request.getAttribute("newsList"))
			#foreach($news in $newsList)
			<tr>
				<td>$!news.id</td>
				<td class='aleft' style="color:$!news.color">$!news.title</td>
				<td>
					#if($!news.ispublish==0) 
                    <span style='color: blue;'>未发布</span> 
					#else 
                    <span style='color: green;'>已发布</span> 
					#end
				</td>
				<td>$!news.publishtime</td>
				<td>$!news.updatetime</td>
				<td>
					<a href="$link.setRelative('/showNews.do').addQueryData('id',$!news.id)" target='_blank'>查看</a>
				#if($istrash=="1")
					<a href="javascript:;" onclick="toConfirm('$link.setAction('restoreNews').addQueryData('id',$!news.id)','确实要还原吗？')">还原</a>
					<a href="javascript:;" onclick="toConfirm('$link.setAction('removeNews').addQueryData('id',$!news.id)','该操作不可恢复，确实要删除吗？')">彻底删除</a>
				#else
					<a href="$link.setAction('load4NewsModify').addQueryData('id',$!news.id)">编辑</a>
					<a href="javascript:;" onclick="toConfirm('$link.setAction('trashNews').addQueryData('id',$!news.id)','确实要删除吗？')">删除</a>
				#end
                </td>
            </tr>
			#end
        </table>
        <div class="page" style="clear: both;">
			#parse("/home/include/page.vm")
        </div>
    </div>
</div>
</body>
</html>
