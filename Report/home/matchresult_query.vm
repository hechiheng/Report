<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
#parse("/home/include/webtitle.vm")
<link rel="shortcut icon" href="$link.setRelative('favicon.png')" />
<script type="text/javascript" src="$link.setRelative('/home/js/jquery-1.7.2.min.js')" ></script>
<link href="$link.setRelative('/home/theme/default/css/css.css')" rel="stylesheet" type="text/css" />
<script type="text/javascript">
jQuery(function () {
	jQuery("#annualmatch").focus();
	
});
</script>
</head>

<body>
<!--top -->
<div id="top">
<div class="warp" id="herd">
	<div id="top_fla">
	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="998" height="159">
	  <param name="movie" value="$link.setRelative('/home/theme/default/images/top.swf')" />
	  <param name="quality" value="high" />
	  <PARAM NAME=wmode value="transparent">
	  <embed src="$link.setRelative('/home/theme/default/images/top.swf')" quality="high" wmode="transparent" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="998" height="159"></embed>
	</object>
	</div>
	<div id="top_member">
		#parse("/home/include/top_member.vm")
	</div>
	<div id="top_logo"></div>
</div>

<!--menu -->
<div id="menu">
	<ul>
		#parse("/home/include/menu.vm")
	</ul>
</div>

<div class="warp1 mt">
	#parse("/home/include/announce.vm")
</div>
<div class="clear"></div>

</div>

<div class="content">
	<div class="warp1 mt">
	<div class="left f_l">
		<h3 class="flbt">参赛报名</h3>
		<div class="xbox">
			<ul class="fllb">
			<li><a href="$link.setAction('load4MatchapplyAdd')">参赛报名</a></li>
			<li><a href="$link.setAction('load4MatchapplyIndex')">报名列表</a></li>
			</ul>
		</div>		
	</div>
<div class="right f_r">
<h3 class="nybt"><span>参赛结果查询</span></h3>
<div class="form">
	<form method='post' id="form_do" name="form_do" action="$link.setAction('load4MatchresultIndex')">
		<dl>
			<dt>参赛年度：</dt>
			<dd>
				<input type="text" id="annualmatch" name="matchapply.annualmatch" class="inp_one"/>
				<span style="color: red;">(格式：YYYY)</span>
			</dd>
		</dl>
		<dl>
			<dt>参赛项目：</dt>
			<dd>
				<select name="matchapply.matchid">
					<option value="0">--请选择--</option>
					#set($matchinfoList = $request.getAttribute("matchinfoList"))
					#foreach($matchinfo in $matchinfoList)
						<option value="$!matchinfo.id">$!matchinfo.name</option>
					#end
				</select>
			</dd>
		</dl>
		<dl>
			<dt>作品名称：</dt>
			<dd>
				<input type="text" name="matchapply.name" class="inp_large"/>
			</dd>
		</dl>
		<div class="form_b">
			<input type="submit" class="btn_blue" id="submit" value="查询">		
		</div>
	</form>
	</div>

</div>
<div class=" clear"></div>
</div>
</div>

<div class="warp1 mt" id="bottom">
	#parse("/home/include/bottom.vm")
</div>

</body>
</html>
