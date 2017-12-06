<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel='stylesheet' type="text/css" href="$link.setRelative('/manage/css1/style.css')" />
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery-1.7.2.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/common.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery.form.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/calendar.config.js')"></script>
<script type="text/javascript">
jQuery(function () {
     jQuery("input[name='user.password_old']").focus();
	 
     jQuery("#form_do").submit(function(){
		var password_old = jQuery("input[name='user.password_old']");
		var password = jQuery("input[name='user.password']");
		var password_re = jQuery("input[name='user.password_re']");
		if(jQuery.trim(password_old.val())==''){
			password_old.parent().find("span").remove().end().append("<span class='errorcolor'>当前密码不能为空</span>");
			password_old.focus();
			return false;			
		}else {
			password_old.parent().find("span").remove().end();
		}
		if(jQuery.trim(password.val())==''){
			password.parent().find("span").remove().end().append("<span class='errorcolor'>新密码不能为空</span>");
			password.focus();
			return false;			
		}else {
			password.parent().find("span").remove().end();
		}
		if(jQuery.trim(password_re.val())==''){
			password_re.parent().find("span").remove().end().append("<span class='errorcolor'>确认密码不能为空</span>");
			password_re.focus();
			return false;			
		}else {
			password_re.parent().find("span").remove().end();
		}
		if(password.val()!=password_re.val()){
			password_re.parent().find("span").remove().end().append("<span class='errorcolor'>两次输入的密码不一致</span>");
			password_re.focus();
			return false;			
		}else {
			password_re.parent().find("span").remove().end();
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
            <li><a href="$link.setAction('load4UserIndex')">用户管理</a></li>
            <li><a href="#">修改密码</a></li>
        </ul>
    </div>
	<div class="formbody">
		<form method='post' id="form_do" name="form_do" action="$link.setAction('modifyUserPwd')">
		<ul class="forminfo">
            <li>
				<label>当前密码：<b>*</b></label>
				<input type="password" name="user.password_old" class="dfinput" style="width:300px;" />
			</li>
			<li>
				<label>新密码：<b>*</b></label>
				<input type="password" name="user.password" class="dfinput" style="width:300px;" />
			</li>
			<li>
				<label>确认新密码：<b>*</b></label>
				<input type="password" name="user.password_re" class="dfinput" style="width:300px;" />
			</li>
			<li>
				<span class='errorcolor'>#errorMarkup()</span>
            </li>
			<li>
				<input type="hidden" name="user.id" value="$!modifyUserPwdForm.user.id" />
    			<input type="hidden" name="user.isself" value="$!modifyUserPwdForm.user.isself" />
    			<input type="submit" class="btn" id="submit" value="保存">
    			#if($!modifyUserPwdForm.user.isself==0)
    			<input type="button" class="btn" id="back" value="返 回" onclick="javascript:history.back();" />
    			#end
            </li>
        </ul>
	   </form>
	</div>
</div>


</body>
</html>