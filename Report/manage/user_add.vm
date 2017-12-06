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
     jQuery("input[name='user.username']").focus();
	 
	 //验证用户名是否存在
	jQuery("input[name='user.username']").blur(function(){
		var username = jQuery("input[name='user.username']");
		if(jQuery.trim(username.val())==''){
			username.parent().find("span").remove().end().append("<span class='errorcolor'>用户名不能为空</span>");
			return ;
		}
		jQuery.post("$link.setAction('verifyUser')",{username:jQuery.trim(username.val())},
			function(msg){
				if(msg != ""){
					username.focus();
					username.parent().find("span").remove().end().append("<span style='color: red;'>"+msg+"</span>");
				}else{
					username.parent().find("span").remove().end().append("<span style='color: green;'>用户名可用</span>");
				}
			}
		);
	});
     
     jQuery("#form_do").submit(function(){
		var username = jQuery("input[name='user.username']");
		var password = jQuery("input[name='user.password']");
		var password_re = jQuery("input[name='user.password_re']");
		var factname = jQuery("input[name='user.factname']");
		if(jQuery.trim(username.val())==''){
			username.parent().find("span").remove().end().append("<span class='errorcolor'>用户名不能为空</span>");
			username.focus();
			return false;			
		}else {
			username.parent().find("span").remove().end();
		}
		if(jQuery.trim(password.val())==''){
			password.parent().find("span").remove().end().append("<span class='errorcolor'>登录密码不能为空</span>");
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
		if(jQuery.trim(factname.val())==''){
			factname.parent().find("span").remove().end().append("<span class='errorcolor'>姓名不能为空</span>");
			factname.focus();
			return false;			
		}else {
			factname.parent().find("span").remove().end();
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
            <li><a href="#">添加用户</a></li>
        </ul>
    </div>
	<div class="formbody">
		<form method='post' id="form_do" name="form_do" action="$link.setAction('addUser')">
		<ul class="forminfo">
            <li>
				<label>用户名：<b>*</b></label>
				<input type="text" name="user.username" class="dfinput" style="width:300px;" value="$!addUserForm.user.username"/>
			</li>
			<li>
				<label>登录密码：<b>*</b></label>
				<input type="password" name="user.password" class="dfinput" style="width:300px;" value=""/>
			</li>
			<li>
				<label>确认密码：<b>*</b></label>
				<input type="password" name="user.password_re" class="dfinput" style="width:300px;" value=""/>
			</li>
			<li>
				<label>姓名：<b>*</b></label>
				<input type="text" name="user.factname" class="dfinput" style="width:300px;" value="$!addUserForm.user.factname"/>
			</li>
			<li>
				<label>性别：<b>*</b></label>
				<label style="width: 50px;"><input type="radio" name="user.sex" value="1" checked="checked"/>男&nbsp;</label>
				<label style="width: 50px;"><input type="radio" name="user.sex" value="2" />女</label>
			</li>
			<li>
				<label>邮箱：</label>
				<input type="text" name="user.email" class="dfinput" style="width:300px;" value="$!addUserForm.user.email"/>
			</li>
			<li>
				<label>QQ：</label>
				<input type="text" name="user.qq" class="dfinput" style="width:300px;" value="$!addUserForm.user.qq"/>
			</li>
			<li>
				<label>电话：</label>
				<input type="text" name="user.tel" class="dfinput" style="width:300px;" value="$!addUserForm.user.tel"/>
			</li>
			<li>
				<label>岗位：</label>
				<select name="user.roleid" class="dfinput" style="width:300px;">
					#set($roleList = $request.getAttribute("roleList"))
					#foreach($role in $roleList)
						#if($!role.id==$!addUserForm.user.roleid)
							<option value="$!role.id" selected="selected">$!role.name</option>
						#else
							<option value="$!role.id">$!role.name</option>
						#end
					#end
				</select>
			</li>
			<li>
				<span class='errorcolor'>#errorMarkup()</span>
            </li>
            <li>
				<input name="" type="submit" class="btn" value="保存"/>
				<input type="button" class="btn" value="返 回" onclick="javascript:history.back();" />
			</li>
        </ul>
	   </form>
	</div>
</div>


</body>
</html>