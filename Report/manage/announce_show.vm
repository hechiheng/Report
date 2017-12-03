<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel='stylesheet' type="text/css" href="$link.setRelative('/manage/css1/style.css')" />
<script type="text/javascript" src="$link.setRelative('/manage/ueditor/ueditor.parse.min.js')"></script>
<style type="text/css">
.biaoti{font-size:2.2em; font-family: Microsoft YaHei;font-weight:500; color:#000; line-height:1.5; text-align:center;}
.biaoti_sub{font-size: 9pt;color:#888;text-align:center;margin-bottom:10px;}
.lh{font-size:14px;line-height:28px;}
.wzzw{min-height: 200px;padding:10px;line-height:21px;}

</style>
</head>
<body>
<div class="main">
	<div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">公告</a></li>
        </ul>
    </div>
	<div class="formbody">
		#set($announce = $request.getAttribute("announce"))
		<div class="biaoti" align="center">$!announce.title</div>
		<div class="biaoti_sub">
			<span>$!announce.publishtime</span>
		</div>
		<div class="wzzw lh" id="content">
			$!announce.content
		</div>
	</div>
</div>
<script type="text/javascript">
	uParse('#content', {
        rootPath: '../'
    });

</script>

</body>
</html>