<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
#parse("/manage/include/webtitle.vm")
<link rel="shortcut icon" href="$link.setRelative('favicon.png')" />
<link type="text/css" rel="stylesheet" href="$link.setRelative('/manage/css1/style.css')" />
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery-1.7.2.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery.cookie.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/common.js')"></script>
##<script type="text/javascript" src="$link.setRelative('/manage/js1/cloud.js')"></script>

<style type="text/css">
.systemlogo1{
	background:url("images1/logo.png") no-repeat left;
	width:100%; 
	height:71px; 
	margin-top:10px;
	margin-left: 20px;
	display:block;
}
.gonggao {
    background: #fff;
    padding: 16px 34px 37px;
    width: 80%;
	min-height:200px;
    margin-top: 10px;
}
.gonggao .hd {
    border-bottom: 1px solid #ccc;
    height: 72px;
    margin-bottom: 20px;
}
.gonggao .hd li.on {
    color: #2b9fd0;
}
.gonggao .hd li {
    font: 20px/71px "微软雅黑";
    color: #2b9fd0;
    float: left;
    color: #666;
    width: 80%;
}
.biaoti {
    font-size: 2.2em;
    font-family: Microsoft YaHei;
    font-weight: 500;
    color: #000;
    line-height: 1.5;
    text-align: center;
}
.biaoti_sub {
    font-size: 9pt;
    color: #888;
    text-align: center;
    margin-bottom: 10px;
}
.content {
    min-height: 200px;
    padding: 10px;
    line-height: 21px;
}
</style>
</head>

<body style="background-color:#1c77ac; background-image:url(images1/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  

    <div class="loginbody">
		<span class="systemlogo1"></span> 
		<div class="gonggao" style="margin: 0 auto;">
			<ul class="hd">
                <li class="on">公告内容</li>
            </ul>
			#set($announce = $request.getAttribute("announce"))
    		<div class="biaoti" align="center">$!announce.title</div>
    		<div class="biaoti_sub">
    			<span>$!announce.publishtime</span>
    		</div>
    		<div class="content" id="content">
    			$!announce.content
    		</div>
        </div>
    </div>
    
    <div class="loginbm">#parse("/manage/include/copyright.vm")</div>
</body>
</html>
