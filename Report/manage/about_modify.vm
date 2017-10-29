<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel='stylesheet' type="text/css" href="$link.setRelative('/manage/css/style.css')" />
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery-1.7.2.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/common.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery.form.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/ueditor/ueditor.config.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/ueditor/ueditor.all.min.js')"></script>
<script type="text/javascript">
	
	window.UEDITOR_HOME_URL = "ueditor/";
	window.onload = function() {
		UE.getEditor('description', {
    		toolbars: [
                ['fullscreen', 'source', 'undo', 'redo']
            ],
            initialFrameWidth : 600,
            initialFrameHeight: 100
        });
		
		UE.getEditor('content', {
            initialFrameWidth : 600,
            initialFrameHeight: 300
        });
    }



</script>
<script type="text/javascript">
jQuery(function () {
     jQuery("textarea[name='about.description']").focus();
     
     jQuery("#form_do").submit(function(){
		var description = jQuery("textarea[name='about.description']");
		var content = jQuery("#content");
		if(!UE.getEditor('description').hasContents()){
			description.parent().find("span").remove().end().append("<span class='error'>摘要不能为空</span>");
			description.focus();
			return false;			
		}else {
			description.parent().find("span").remove().end();
		}
		if(!UE.getEditor('content').hasContents()){
			content.parent().find("span").remove().end().append("<span class='error'>内容不能为空</span>");
			content.focus();
			return false;			
		}else {
			content.parent().find("span").remove().end();
		}
	});
	
});


</script>
</head>
<body>
<div class="main">
    <div class="pos">联系我们</div>
	<div class="form">
		<form method='post' id="form_do" name="form_do" action="$link.setAction('modifyAbout')">
		<dl>
			<dt> 摘要：</dt>
			<dd>
				<textarea name="about.description" id="description">$!aboutForm.about.description</textarea>
			</dd>
		</dl>
		<dl>
			<dt> 内容：</dt>
			<dd>
				<textarea name="about.content" id="content">$!aboutForm.about.content</textarea>
			</dd>
		</dl>		
		<dl>
			<span class='error'>#errorMarkup()</span>
        </dl>
		<div class="form_b">		
			<input type="submit" class="btn_blue" id="submit" value="提 交">
		</div>
	   </form>
	</div>
</div>


</body>
</html>