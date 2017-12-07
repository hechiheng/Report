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
            <li><a href="$link.setAction('load4MatchinfoIndex')">参赛项目管理</a></li>
        </ul>
    </div>
    <div class="formbody">
		<form method="get" action="$link.setAction('load4MatchinfoIndex')">
		<ul class="seachform">
    		#if($istrash=="1")
    			&nbsp;
    		#else
    		<li>
            	<label>参赛项目名称：</label>
                <input type="text" name="matchinfo.name" title="关键字" class="scinput" style="width: 150px;" value="$!queryMatchinfoForm.matchinfo.name">
    		</li>
            <li>
    			<label>&nbsp;</label>
    			<input name="" type="submit" class="scbtn" value="查询"/>
    		</li>
			#end
			<li>
				#set($istrash = $request.getAttribute("istrash"))
        		#if($istrash=="1")
        			<input type="button" onclick="goUrl('$link.setAction('load4MatchinfoIndex')')"  class="scbtn" value="返回" />
        		#else
        			<input type="button" style="width: 110px;" onclick="goUrl('$link.setAction('load4MatchinfoAdd')')" class="scbtn" value="添加参赛项目" />
                    <input type="button" onclick="goUrl('$link.setAction('load4MatchinfoIndex').addQueryData('istrash','1')')" class="scbtn" value="回收站" />
        		#end
            </li>
		</ul>
		</form>
    </div>
    <table class="tablelist">
        <tr>
            <th>编号</th>
			<th>参赛年度</th>
			<th width="30%">参赛项目名称</th>
			<th>报名开始时间</th>
			<th>报名截止时间</th>
            <th>更新时间</th>
            <th>操作</th>
        </tr>
		<tbody>
		#set($matchinfoList = $request.getAttribute("matchinfoList"))
		#foreach($matchinfo in $matchinfoList)
		<tr>
			<td>$!matchinfo.id</td>
			<td>$!matchinfo.annualmatch</td>
			<td>$!matchinfo.name</td>
			<td>$!matchinfo.begindate</td>
			<td>$!matchinfo.enddate</td>
			<td>$!matchinfo.updatetime</td>
			<td>
				<a class="tablelink" href="$link.setAction('load4Matchinfo').addQueryData('id',$!matchinfo.id)">查看</a>
			#if($istrash=="1")
				<a class="tablelink" href="javascript:;" onclick="toConfirm('$link.setAction('restoreMatchinfo').addQueryData('id',$!matchinfo.id)','确实要还原吗？')">还原</a>
				<a class="tablelink" href="javascript:;" onclick="toConfirm('$link.setAction('removeMatchinfo').addQueryData('id',$!matchinfo.id)','该操作不可恢复，确实要删除吗？')">彻底删除</a>
			#else
				<a class="tablelink" href="$link.setAction('load4MatchinfoModify').addQueryData('id',$!matchinfo.id)">编辑</a>
				<a class="tablelink" href="javascript:;" onclick="toConfirm('$link.setAction('trashMatchinfo').addQueryData('id',$!matchinfo.id)','确实要删除吗？')">删除</a>
			#end
            </td>
        </tr>
		#end
		</tbody>
    </table>
    <div class="page" style="clear: both;">
		#parse("/home/include/page.vm")
    </div>
	<script type="text/javascript">
    	jQuery('.tablelist tbody tr:odd').addClass('odd');
    </script>
</div>
</body>
</html>
