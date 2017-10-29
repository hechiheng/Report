#set($map = $page.queryData)
#set($actionLink = $link.setAction($page.action))
#foreach($key in $map.keySet())
	#set($actionLink = $actionLink.addQueryData($key, $map.get($key)))
#end
#set($pageLink=$actionLink.toString())
<a href="$link.setURI($pageLink).addQueryData('p','1')">首页</a>
<a href="$link.setURI($pageLink).addQueryData('p',$!{page.prePage})">上一页</a>
<a href="$link.setURI($pageLink).addQueryData('p',$!{page.nextPage})">下一页</a>
<a href="$link.setURI($pageLink).addQueryData('p',$!{page.totalPages})">尾页</a>
第$!{page.nowPage}页/共$!{page.totalPages}页  (共 $!{page.totalRows} 条记录)