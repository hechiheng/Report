<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel='stylesheet' type="text/css" href="$link.setRelative('/manage/css/style.css')" />
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery-1.7.2.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/common.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery.form.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/calendar.config.js')"></script>
<script type="text/javascript">
jQuery(function () {
     jQuery("input[name='link.name']").focus();
	 
     jQuery("#form_do").submit(function(){
		var name = jQuery("input[name='link.name']");
		var url = jQuery("input[name='link.url']");
		var endtime = jQuery("input[name='link.endtime']");
		if(jQuery.trim(name.val())==''){
			name.parent().find("span").remove().end().append("<span class='error'>网站名称不能为空</span>");
			name.focus();
			return false;			
		}else {
			name.parent().find("span").remove().end();
		}
		if(jQuery.trim(url.val())==''){
			url.parent().find("span").remove().end().append("<span class='error'>链接位置不能为空</span>");
			url.focus();
			return false;			
		}else {
			url.parent().find("span").remove().end();
		}
	});
	
});


</script>
</head>
<body>
<div class="main">
    <div class="pos">添加友情链接</div>
	<div class="form">
		<form method='post' id="form_do" name="form_do" action="$link.setAction('addLink')">
		<dl>
			<dt> 网站名称：</dt>
			<dd>
				<input type="text" name="link.name" class="inp_large" value="$!addLinkForm.link.name"/>
				<span style="color: red;">*</span>
			</dd>
		</dl>
		<dl>
			<dt> 网站地址：</dt>
			<dd>
				<input type="text" name="link.url" class="inp_large" value="#if($!addLinkForm.link.url)http://#else $!addLinkForm.link.name #end" />
				<span style="color: red;">*</span>
			</dd>
		</dl>
		<dl>
			<dt> 排序：</dt>
			<dd>
				<input type="text" name="link.sort" class="inp_small" value="$!addLinkForm.link.sort" />
			</dd>
		</dl>
		<dl>
			<dt> 网站简况：</dt>
			<dd>
				<textarea name="link.description" class="tarea_default">$!addLinkForm.link.description</textarea>
			</dd>
		</dl>
		<dl>
			<span class='error'>#errorMarkup()</span>
        </dl>
		<div class="form_b">		
			<input type="submit" class="btn_blue" id="submit" value="提 交">
			<input type="button" class="btn_blue" id="back" value="返 回" onclick="javascript:history.back();" />
		</div>
	   </form>
	</div>
</div>


</body>
</html>