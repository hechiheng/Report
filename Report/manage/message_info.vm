<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel='stylesheet' type="text/css" href="$link.setRelative('/manage/css1/style.css')" />
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery-1.7.2.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/common.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery.form.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/ueditor/ueditor.config.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/ueditor/ueditor.all.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/jBox.config.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/calendar.config.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/jq_plugins/iColorPicker/iColorPicker.js')"></script>

</head>
<body>
<div class="main">
	<div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="$link.setAction('load4AnnounceIndex')">通知管理</a></li>
            <li><a href="#">查看通知</a></li>
        </ul>
    </div>
	<div class="formbody">
		<ul class="forminfo">
			#set($message = $request.getAttribute("message"))
			<li>
    			<label> 通知标题：</label>
				<span>$!message.title</span>
    		</li>
    		<li>
                <label> 作者：</label>
				<span>$!message.author</span>
            </li>
    		<li>
    			<label> 通知内容：</label>
				<label><textarea name="message.content" id="content" readonly="readonly">$!message.content</textarea></label>
    		</li>	
			<li>
                <label> 发布状态：</label>
				<span>
					#if($!message.ispublish==0) 
                    <span style='color: blue;'>未发布</span> 
					#else 
                    <span style='color: green;'>已发布</span> 
					#end
				</span>
            </li>	
    		<li>
                <label> 发布时间：</label>
				<span>$!message.publishtime</span>
            </li>	
			<li>
				<label>&nbsp;</label>
				<input type="button" class="btn" value="返 回" onclick="javascript:history.back();" />
			</li>
        </ul>
	</div>
</div>
<script type="text/javascript">
	var ue = UE.getEditor('content', {
		toolbars: [
            ['fullscreen']
        ],
        initialFrameWidth : 800,
        initialFrameHeight: 400
    });
	ue.ready(function() {
	    ue.setDisabled('fullscreen');
	});
</script>

</body>
</html>