<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
#parse("/home/include/webtitle.vm")
<link rel="shortcut icon" href="$link.setRelative('favicon.png')" />
<script type="text/javascript" src="$link.setRelative('/home/js/jquery-1.7.2.min.js')" ></script>
<link href="$link.setRelative('/home/theme/default/css/css.css')" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="$link.setRelative('/home/js/common.js')"></script>
<script type="text/javascript">
function change_code(obj){
	jQuery("#code").attr("src",obj.src+'?'+Math.random());
	return false;
}

jQuery(function () {
	jQuery("input[name='accountid']").focus();
});
</script>
</head>

<body>
<!--top -->
<div id="top">
<script type="text/javascript">
</script>
<div class="warp" id="herd">
	<div id="top_fla">
	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="998" height="159">
	  <param name="movie" value="$link.setRelative('/home/theme/default/images/top.swf')" />
	  <param name="quality" value="high" />
	  <PARAM NAME=wmode value="transparent">
	  <embed src="$link.setRelative('/home/theme/default/images/top.swf')" quality="high" wmode="transparent" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="998" height="159"></embed>
	</object>
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
	<div class="right f_r" style="width:980px;">
		<h3 class="nybt"><span>会员登录</span></h3>
		<div class="form">
			<form method='post' id="form_do" name="form_do" style="width: 600px;margin: 22px auto 0;" action="$link.setAction('login')">
			<dl>
				<dt>用户名：</dt>
				<dd>
					<input type="text" name="accountid" class="inp_one" value="333"/>
				</dd>
			</dl>
			<dl>
				<dt> 密码：</dt>
				<dd>
					<input type="password" name="password" class="inp_one" value="1"/>
				</dd>
			</dl>
			<dl>
				<dt>验证码：</dt>
				<dd>
					<input type="text" name="imagecode" class="inp_small" />
					<img src="$link.setAction('/manage/imageCode.do')" align="absmiddle" id="code"  class="vcode" onclick="change_code(this);"/>
				</dd>
			</dl>
            <dl>
				<span class='error'>#errorMarkup()</span>
			</dl>
			<div class="form_b">		
				<input type="submit" class="btn_blue" id="submit" value="登录">
				<input type="button" class="btn_blue" onclick="goUrl('$link.setAction('load4MemberReg')')" value="注册">
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