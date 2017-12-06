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
<script type="text/javascript">
	window.UEDITOR_HOME_URL = "ueditor/";
	window.onload = function() {
		UE.getEditor('content', {
            initialFrameWidth : 800,
            initialFrameHeight: 400
        });
    }


</script>

<script type="text/javascript">
jQuery(function () {
     jQuery("input[name='message.title']").focus();
	 
	 jQuery("input[name='message.ispublish']").click(function(){
	   var v=jQuery(this).val();
	   var publishtime = jQuery("input[name='message.publishtime']");
	   if(v=='1'){
	   		publishtime.parent().find("span").remove().end().append("<span class='errorcolor'>*</span>");
	   }else{
	   		publishtime.parent().find("span").remove();
	   }
     });
     
     jQuery("#form_do").submit(function(){
		var title = jQuery("input[name='message.title']");
		var content = jQuery("#content");
		var ispublish = jQuery("input[name='message.ispublish']:checked");
		var publishtime = jQuery("input[name='message.publishtime']");
		if(jQuery.trim(title.val())==''){
			title.parent().find("span").remove().end().append("<span class='errorcolor'>通知标题不能为空</span>");
			title.focus();
			return false;			
		}else {
			title.parent().find("span").remove().end();
		}
		if(!UE.getEditor('content').hasContents()){
			content.parent().find("span").remove().end().append("<span class='errorcolor'>通知内容不能为空</span>");
			content.focus();
			return false;			
		}else {
			content.parent().find("span").remove().end();
		}
		if(ispublish.val()=='1'){
			if(jQuery.trim(publishtime.val())==''){
				publishtime.parent().find("span").remove().end().append("<span class='errorcolor'>发布时间不能为空</span>");
				return false;	
			}else {
    			publishtime.parent().find("span").remove().end();
    		}
		}
	});
	
});


</script>
</head>
<body>
<div class="main">
	<div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="$link.setAction('load4MessageIndex')">通知管理</a></li>
            <li><a href="#">新增通知</a></li>
        </ul>
    </div>
	<div class="formbody">
		<form method='post' id="form_do" name="form_do" action="$link.setAction('addMessage')">
		<ul class="forminfo">
			<li>
				<label>通知标题：<b>*</b></label>
				<input type="text" name="message.title" class="dfinput" style="width:600px;" value="$!addMessageForm.message.title"/>
			</li>
			<li>
				<label>作者：</label>
				<input type="text" name="message.author" class="dfinput" style="width:300px;" value="$!addMessageForm.message.author"/>
			</li>
			<li>
				<label>通知内容：<b>*</b></label>
                <label><textarea name="message.content" id="content">$!addMessageForm.message.content</textarea></label>
			</li>
			<li>
				<label>是否发布：<b>*</b></label>
				<label><input type="radio" name="message.ispublish" value="1" checked="checked" />立即发布&nbsp;</label>
				<label><input type="radio" name="message.ispublish" value="0" />暂不发布</label>
			</li>
			<li>
				<label>发布时间：</label>
				<input type="text" class="dfinput" style="width:200px;" name="message.publishtime" id="publishtime" readonly="readonly" value="$!addMessageForm.message.publishtime"/>
                <script type="text/javascript">
                    Calendar.setup({
                        weekNumbers: true,
                        inputField : "publishtime",
                        trigger    : "publishtime",
                        dateFormat: "%Y-%m-%d %H:%M:%S",
                        showTime: true,
                        minuteStep: 1,
                        onSelect   : function() {this.hide();}
                    });
                </script>
			</li>
			<li>
				<span class='errorcolor'>#errorMarkup()</span>
            </li>
			<li>
				<label>&nbsp;</label>
				<input name="" type="submit" class="btn" value="提交"/>
				<input type="button" class="btn" value="返 回" onclick="javascript:history.back();" />
			</li>
        </ul>
	   </form>
	</div>
</div>


</body>
</html>