<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel='stylesheet' type="text/css" href="$link.setRelative('/manage/css/style.css')" />
<script type="text/javascript" src="$link.setRelative('/manage/js/jquery-1.7.2.min.js')"></script>
<script type="text/javascript" src="$link.setRelative('/manage/js/common.js')"></script>
<script type="text/javascript">
jQuery(function(){
	jQuery("input[name='menu.name']").focus();
	
	jQuery("#form_do").submit(function(){
		var name = jQuery("input[name='menu.name']");
		var sort = jQuery("input[name='menu.sort']");
		if(jQuery.trim(name.val())==''){
			name.parent().find("span").remove().end().append("<span class='error'>菜单名称不能为空</span>");
			name.focus();
			return false;			
		}else {
			name.parent().find("span").remove().end();
		}
		if(jQuery.trim(sort.val())==''){
			sort.parent().find("span").remove().end().append("<span class='error'>排序不能为空</span>");
			sort.focus();
			return false;			
		}else {
			sort.parent().find("span").remove().end();
		}
	});
	
});
</script>
</head>
<body>
	<div class="main">
    	<div class="pos">添加菜单</div>
		<div class="form">
			<form method='post' id="form_do" name="form_do" action="$link.setAction('addMenu')">
				<div id="div_setting_1">
					<dl>
						<dt> 父级菜单：</dt>
						<dd>
							<select name="menu.pid">
								<option value="0">顶级菜单</option>
								#set($menuList = $request.getAttribute("menuList"))
								#foreach($menu in $menuList)
									#if($!menu.id==$!addMenuForm.menu.pid)
										<option value="$!menu.id" selected="selected">$!menu.name</option>
									#else
										<option value="$!menu.id">$!menu.name</option>
									#end
								#end
							</select>
						</dd>
					</dl>		
					<dl>
						<dt> 菜单名称：</dt>
						<dd>
							<input type="text" name="menu.name" class="inp_large" value="$!addMenuForm.menu.name" />
							<span style="color: red;">*</span>
						</dd>
					</dl>
					<dl>
						<dt>路径：</dt>
						<dd>
							<input type="text" name="menu.url" class="inp_large" value="$!addMenuForm.menu.url"/>
						</dd>
					</dl>		
					<dl>
						<dt> 排序：</dt>
						<dd>
							<input type="text" name="menu.sort" class="inp_one" value="$!addMenuForm.menu.sort" />
							<span style="color: red;">*</span>
						</dd>
					</dl>
					<dl>
						<dt> 显示：</dt>
						<dd>
							<label><input type="radio" name="menu.isshow" value="1" checked="checked"/>显示&nbsp;</label>
							<label><input type="radio" name="menu.isshow" value="0"/>隐藏</label>
						</dd>
					</dl>
				</div>
				<div class="form_b">
					<input type="submit" class="btn_blue" id="submit" value="保存">
					<input type="button" class="btn_blue" id="back" value="返 回" onclick="javascript:history.back();" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>