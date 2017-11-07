//删除左右两端的空格
function trim(str){ 
    return str.replace(/(^\s*)|(\s*$)/g, "");
}
//转跳网址
function goUrl(url) {
    if (!url) {
        return false;
    }
    location.href  = url;
}

//设置Checkbox状态
function setCheckbox(flag){
    flag = flag? true : false;
    var checkbox = document.getElementsByName("key[]");
    for(var i=0;i<checkbox.length;i++){
        if (!checkbox[i].disabled) {        
            checkbox[i].checked = flag;
        }
    }
}

//获取Checkbox被选择个数
function getCheckboxNum(){
   var checkbox = document.getElementsByName("key[]");
   var j = 0; // 用户选中的选项个数
   for(var i=0;i<checkbox.length;i++){
      if(checkbox[i].checked){
          j++;
      }
   }
   return j;
}

function getCheckValues(){
	var obj = document.getElementsByName('key[]');
	var result ='';
	var j= 0;
	for (var i=0;i<obj.length;i++){
            if (obj[i].checked===true){
                result += obj[i].value+",";
                j++;
            }
	}
	return result.substring(0, result.length-1);
}



//确认,跳转网址
function toConfirm(url, str){
    if (window.confirm(str)){
        location.href = url;
    }
}

$(function(){
    //选中列表行变色
    $(".list tr").mouseover(function(){
        $(this).addClass("currow");
    }).mouseout(function(){
        $(this).removeClass("currow");
    });
    //全选/取消
    $("#check").click(function(){
        if($(this).attr("checked")=="checked"){
            setCheckbox(true);
        }else{
            setCheckbox(false);
        }

    });
    
    
});