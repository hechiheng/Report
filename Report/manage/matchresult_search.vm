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
            <li><a href="$link.setAction('load4MatchresultSearch')">参赛结果查询</a></li>
        </ul>
    </div>
    <div class="formbody">
		<form method="get" action="$link.setAction('load4MatchresultSearch')">
		<ul class="seachform">
			<li>
				<label>参赛年度：</label>
				<input type="text" id="annualmatch" name="matchapply.annualmatch" class="scinput" style="width: 80px;" value="$!queryMatchapplyForm.matchapply.annualmatch">
            </li>
			<li>
    			<label>参赛项目：</label>
    			<select name="matchapply.matchid" class="dfinput" style="width:120px;">
    				<option value="0">--请选择--</option>
    				#set($matchinfoList = $request.getAttribute("matchinfoList"))
    				#foreach($matchinfo in $matchinfoList)
    					#if($!matchinfo.id==$!queryMatchapplyForm.matchapply.matchid)
    						<option value="$!matchinfo.id" selected="selected">$!matchinfo.name</option>
    					#else
    						<option value="$!matchinfo.id">$!matchinfo.name</option>
    					#end
    				#end
    			</select>
			</li>
			<li>
            	<label>作品名称：</label>
                <input type="text" name="matchapply.name" title="关键字" class="scinput" value="$!queryMatchapplyForm.matchapply.name">
			</li>
            <li>
				<label>&nbsp;</label>
				<input name="" type="submit" class="scbtn" value="查询"/>
			</li>
		</ul>
        </form>
    </div>
    <table class="tablelist">
        <tr>
            <th>编号</th>
			<th width="35%">作品名称</th>
			<th>学校</th>
			<th>作者</th>
			<th>参赛结果</th>
            <th>审核时间</th>
            <th>操作</th>
        </tr>
		<tbody>
		#set($matchapplyList = $request.getAttribute("matchapplyList"))
		#foreach($matchapply in $matchapplyList)
		<tr>
			<td>$!matchapply.id</td>
			<td>$!matchapply.name</td>
			<td>$!matchapply.unitname</td>
			<td>$!matchapply.authors</td>
			<td>
				#if($matchapply.matchresultid==0)
					未录入
				#elseif($matchapply.ispublish==0)
					未发布
				#elseif($matchapply.ispublish==1)
					已发布
				#end
			</td>
			<td>$!matchapply.checktime</td>
			<td>
				<a class="tablelink" href="$link.setAction('load4MatchapplyInfo').addQueryData('id',$!matchapply.id)">查看</a>
            </td>
        </tr>
		#end
		</tbody>
    </table>
    <div class="page" style="clear: both;">
		#parse("/home/include/page.vm")
    </div>
</div>
</body>
</html>
