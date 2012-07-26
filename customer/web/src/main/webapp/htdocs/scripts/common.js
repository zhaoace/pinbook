/**
 * 获取对象，可传如n个参数
 */
function ge(){
	var ea;
	for(var i=0;i<arguments.length;i++){
		var e=arguments[i];
		if(typeof e=='string')
			e=document.getElementById(e);
		if(arguments.length==1)
			return e;
		if(!ea)
			ea=new Array();
		ea[ea.length]=e;
	}
	return ea;
}
function PopPage(strURL, name, width, height, left, top)
{
    if(width==null) width=990;
    if(height==null) height=500;
    if(left==null) left = ( screen.width - width ) / 2;
    if(top==null) top  = ( screen.height - height ) / 2;
    var temp = "width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=1,toolbar=no,location=no,directories=no,status=no,resizable=yes";
    var w = window.open(strURL,name,temp);
    w.focus();
}
function GetCookie(cookiename)
{
    var thebigcookie = document.cookie;
    var firstchar = thebigcookie.indexOf(cookiename);
    if (firstchar != -1) {
        firstchar += cookiename.length + 1;
        lastchar = thebigcookie.indexOf(";",firstchar);
        if(lastchar == -1) lastchar = thebigcookie.length;
        return unescape(thebigcookie.substring(firstchar, lastchar));
    }
    return "";
}
function setCookie(cookiename,cookievalue,cookieexpdate,domainname)
{
    document.cookie = cookiename + "=" + cookievalue
    + "; domain=" + domainname
    + "; path=" + "/"
    + "; expires=" + cookieexpdate.toGMTString();

}
function setCheckboxes(theForm, elementName, isChecked)
{
    var chkboxes = document.forms[theForm].elements[elementName];
    var count = chkboxes.length;

    if (count)
    {
        for (var i = 0; i < count; i++)
        {
            chkboxes[i].checked = isChecked;
        }
    }
    else
    {
        chkboxes.checked = isChecked;
    }
    return true;
}
function reverseCheckbox(formName, eleName) {
	if(eleName==null||eleName==''){
		var o = document.forms[0];
		if(formName != null && formName != ''){
			o = document.forms[formName];
		}
	    if (!o) return;
	    var e = o.elements;
	    for (i = 0; i < e.length; i++) {
	        if (e[i].type == 'checkbox') {
	            if (e[i].checked) {
	                e[i].checked = false;
	            }else {
	                e[i].checked = true;
	            }
	        }
	    }
    }else{
    	eles = document.getElementsByName(eleName);
    	if(eles!=null){
    		for(i=0;i<eles.length;i++){
    			eles[i].checked = !eles[i].checked
    		}
    	}
    }
}
function refresh(page){
  window.location.href=page;
}
function format(money){
  var sum = document.getElementById(money).value;
  if(sum.match(",")!=null||sum.match("，")!=null){
    sum = sum.replace(/，/g, "");
    sum = sum.replace(/,/g, "");
    document.getElementById(money).value=sum;
  }
  return true;
}
/**
 * 显示对象
 */
function show(){
	for(var i=0;i<arguments.length;i++){
		var element=ge(arguments[i]);
		if(element&&element.style)
			element.style.display='';
	}
	return false;
}

/**
 * 隐藏对象
 */
function hide(){
	for(var i=0;i<arguments.length;i++){
		var element=ge(arguments[i]);
		if(element&&element.style)
			element.style.display='none';
	}
	return false;
}

/**
 * 开关窗口
 */
function switchWindow(){
	for(var i=0;i<arguments.length;i++){
		var element=ge(arguments[i]);
		if(element&&element.style)
			element.style.display = element.style.display=="none"?"block":"none"; 
	}
	return false;
}
/** 对象 X 轴位置 **/
function elementX(obj){
	var curleft=0;
	if(obj.offsetParent){
		while(obj.offsetParent){
			curleft+=obj.offsetLeft;
			obj=obj.offsetParent;
		}
	}
	else if(obj.x)
		curleft+=obj.x;
	return curleft;
}

/** 对象 Y 轴位置 **/
function elementY(obj){
	var curtop=0;
	if(obj.offsetParent){
		while(obj.offsetParent){
			curtop+=obj.offsetTop;
			obj=obj.offsetParent;
		}
	}
	else if(obj.y)
		curtop+=obj.y;return curtop;
}
/**
 * 获取视窗宽度
 */
function getViewportWidth(){
	var width=0;
	if(document.documentElement&&document.documentElement.clientWidth){
		width=document.documentElement.clientWidth;
	}else if(document.body&&document.body.clientWidth){
		width=document.body.clientWidth;
	}else if(window.innerWidth){
		width=window.innerWidth-18;
	}
	return width;
};

/**
 * 获取视窗高度
 */
function getViewportHeight(){
	var height=0;if(window.innerHeight){
		height=window.innerHeight-18;
	}else if(document.documentElement&&document.documentElement.clientHeight){
		height=document.documentElement.clientHeight;
	}else if(document.body&&document.body.clientHeight){
		height=document.body.clientHeight;
	}
	return height;
};
/**
 * 获取页面宽度
 */
function getPageWidth(){   
  var xScroll;   
  if (window.innerHeight && window.scrollMaxY) {   
    xScroll = document.body.scrollWidth; 
  } else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac 
    xScroll = document.body.scrollWidth; 
  } else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari 
    xScroll = document.body.offsetWidth; 
  } 
  var windowWidth; 
  if (self.innerHeight) {  // all except Explorer 
    windowWidth = self.innerWidth; 
  } else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode 
    windowWidth = document.documentElement.clientWidth; 
  } else if (document.body) { // other Explorers 
    windowWidth = document.body.clientWidth; 
  }   
  // for small pages with total height less then height of the viewport 
  var pageWidth = 0;
  if(xScroll < windowWidth){   
    pageWidth = windowWidth; 
  } else { 
    pageWidth = xScroll; 
  } 
  
  return pageWidth;
}
/**
 * 获取页面高度
 */
function getPageHeight(){
	var yScroll = 0;
	if (window.innerHeight && window.scrollMaxY) {
	    yScroll = window.innerHeight + window.scrollMaxY; 
	} else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac 
	    yScroll = document.body.scrollHeight; 
	} else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
	    yScroll = document.body.offsetHeight; 
	} 
	
	var windowHeight;
	if (self.innerHeight) {  // all except Explorer 
	    windowHeight = self.innerHeight; 
	} else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode 
	    windowHeight = document.documentElement.clientHeight; 
	} else if (document.body) { // other Explorers 
	    windowHeight = document.body.clientHeight; 
	}
	
	var pageHeight = 0;
	if(yScroll < windowHeight){ 
	    pageHeight = windowHeight; 
	} else {  
	    pageHeight = yScroll; 
	}
	return pageHeight;
}
/** 
 * 定位对象位置
 * positionId： 定位对象id
 * dependId： 依赖对象id
 * xoffset   横向偏移量
 * yoffset   纵向偏移量
 **/
function initPosition(positionId, dependId,xoffset,yoffset){
	var positionObj = ge(positionId);
	var dependObj = ge(dependId);
	if(yoffset == undefined){
		yoffset = 22;
	}
	if(xoffset == undefined){
		xoffset = 0;
	}
	positionObj.style.left = elementX(dependObj)+xoffset;
	positionObj.style.top = elementY(dependObj) +yoffset;
}
/**
 * 定位到页面中间
 * @param positionId: 定位对象id
 * @param dependId: 依赖对象id
 * @param offset: 偏移量
 */
function initPositionCenter(positionId, dependId, yoffset, xoffset){
	var positionObj = ge(positionId);
	var dependObj = ge(dependId);
	if(yoffset == undefined){
		yoffset = 22;
	}
	if(xoffset == undefined){
		xoffset = 0;
	}
	if(dependObj){
		positionObj.style.top = elementY(dependObj) + yoffset;
	}else{
		positionObj.style.top = (getViewportHeight() - positionObj.offsetHeight)/2
	}
	positionObj.style.left = (getViewportWidth() - 600)/2 + xoffset;
}

/**
 * 给对象写值
 */
function fillField(objId, valueStr, hideObjId){
	ge(objId).value = valueStr;
	hide(hideObjId);
}
/**
 * 清空字段值
 */
function cleanField(objId, hideObjId){
	ge(objId).value = "";
	hide(hideObjId);
}
/**
 * 填写innerHTML
 */
function fillInnerHTML(objId, valueStr, hideObjId){
	ge(objId).innerHTML = valueStr;
	hide(hideObjId);
}
/**
 * 清空innerHTML
 */
function cleanInnerHTML(objId, hideObjId){
	ge(objId).innerHTML = "";
	hide(hideObjId);
}
/**
 * 设置对象style
 */
function set_div_style(obj,id,top,left,width,height,position,border,cursor,background) {
    var obj = obj;
    obj.id = id?id:null;
    obj.style.top = top?top:'0px';
    obj.style.left = left?left:'0px';
    obj.style.width = width?width:'0px';
    obj.style.height = height?height:'0px';
    obj.style.position = position?position:"static";
    obj.style.border = border?border:"1px #000 solid";
    obj.style.cursor = cursor?cursor:"default";
    obj.style.background = background?background:"";
    return obj
}
/**
 * 创建遮罩图层
 */
function buildGlobalDiv(){
	var globalDiv=document.createElement('div');
	globalDiv.id='globalDiv';
	globalDiv.style.display='none';
	globalDiv.style.zIndex='98';
	globalDiv = set_div_style(globalDiv,'globalDiv','0px','0px',bodyScrollWidth+'px',bodyScrollHeight+'px',"absolute"," #333333 0px solid","default","darkgray");
	
	if ( 1 == exp ) {
		globalDiv.style.filter="alpha(opacity=40)";
	}
	else {
		globalDiv.style.opacity=40/100;
	}
	document.body.appendChild(globalDiv);
}


/**
 * 遮罩
 */
function deck(){
	reCalBodySize();
	if(!ge('globalDiv')){
		buildGlobalDiv();
	}
	show('globalDiv');
	if ( 1 == exp ) {
		hideElementAll();
	}
}
/**
 * 去除遮罩
 */
function disDeck(){
	if ( 1 == exp ) {
		showElementAll();
	}
	hide("globalDiv");
}
/**
 * 获取单选框选择序号
 */
 function getRadioValue(radioName, unselectMessage){
 	var selectedIndex = -1;
	var radioArray = document.getElementsByName(radioName);
	for (i = 0; i < radioArray.length; i++){
		if (radioArray[i].checked){
			selectedIndex = i;
			break;
		}
	}
	if(selectedIndex < 0){
		alert(unselectMessage);
		return "";
	}
	
	return radioArray[selectedIndex].value;;
 }
 /**
 * 获取下拉框所有值
 */
 function getAllSelectValue(selectId){
	var allValue = "";
	for(var i = 0; i < ge(selectId).length; i++){
		allValue = allValue + ge(selectId).options[i].value + ',';
	}
	
	return allValue.substring(0, allValue.length - 1);
}
/**
 * 跳转到页面
 */
function gotoPage(formName, pageNum){
	var pageInputName = "currentPage";
	var pageInput = null;
	var form = document.getElementsByName(formName)[0];
	
	if(document.getElementsByName(pageInputName).length != 0){
		pageInput = document.getElementsByName(pageInputName)[0];
		pageInput.value = pageNum;
	}else{
		pageInput = document.createElement("input");
		pageInput.type = "hidden";
	    pageInput.name = "currentPage";
	    pageInput.value = pageNum;
	    
	    form.appendChild(pageInput);
	}
	
	form.submit();
}

/**
 * 获取checkBox选择序号
 */
 function getCheckboxValue(checkboxName, unselectMessage){
 	var selectedIndex = -1;
 	var checkboxValue = '';
	var checkboxArray = document.getElementsByName(checkboxName);
	for (i = 0; i < checkboxArray.length; i++){
		if (checkboxArray[i].checked){
			selectedIndex = i;
			checkboxValue = checkboxValue + checkboxArray[i].value + ';';
		}
	}
	if(selectedIndex < 0){
		alert(unselectMessage);
		return "";
	}
	
	return checkboxValue;;
 }
 
 /**
  * checkBox全选
  */
function selectAll(checkboxName){
	var checkboxArray = document.getElementsByName(checkboxName);
 	for (i = 0; i < checkboxArray.length; i++){
 		if (!checkboxArray[i].checked){
 			checkboxArray[i].checked = true;
 		}
 	}
 	return true;
}
  
  /**
   * checkBox反选
   */
function reverseAll(checkboxName){
	var checkboxArray = document.getElementsByName(checkboxName);
  	for (i = 0; i < checkboxArray.length; i++){
  		if (checkboxArray[i].checked){
  			checkboxArray[i].checked = false;
  		}else{
  			checkboxArray[i].checked = true;
  		}
  	}
  	return true;
}
function cleanAll(){
	var ids = null;
	ids = document.forms[0].elements;

	for(i = 0; i < ids.length; i++){
		if(ids[i].type == "checkbox"){
        ids[i].checked = false;
    }else if(ids[i].type == "text" || ids[i].type =="hidden"){
    	if(ids[i].getAttribute("resetable") == "false"){
    		continue;
    	}
    	
        ids[i].value = "";
    }else if(ids[i].tagName == "SELECT"){
			ids[i].selectedIndex = 0;
		}
    }
}
function trimAll(){
	jQuery("input:text", document.forms[0]).each(function(){
	var value = jQuery.trim(jQuery(this).val());
	jQuery(this).val(value);
	}); 
}
function getFileSize(filePath){
   var image = new Image();
   image.dynsrc = filePath;
   
   return image.fileSize;
}
function fileExist(filePath){
	var size = getFileSize(filePath);
	if(size > 0){
		return true;
	}
	
	return false;
}
function disableButton(button){
	var waitHint = document.createElement("label");
	waitHint.innerHTML = "提交中，请稍等...";
	waitHint.className = "OrgTip";
	
	button.style.display='none';
	button.parentNode.insertBefore(waitHint, button);
}
function autoFill(name){
	
	j(document).ready(function() {
		var escapeWrapper = window.encodeURIComponent || escape;
		var ename = 'input#' + name;
		j(ename).autocomplete("http://uam.sdo.com/service/uuipv2/GetUserMatchInfo.ashx?JsonpCallback=?" , {
		     multiple: false, 
		     width:150, 
		     max:50,  
		     max:50, 
		     multipleSeparator: ' ',
		     matchContains: false,
		     dataType: 'json',  
		     extraParams: { keyword: function(){return  j(ename).val() }}, 
		     parse: function(data) {
		     if(typeof data === 'undefined' ){
		        return ;
		     }  
		      var rows = [];
		       for(var i=0; i<data.length; i++){
		        rows[rows.length] = {
		          data: data[i],
		          value:data[i].UserID,
		          result:data[i].UserID
		          };
		        }
		     return rows;
		       },

		     formatItem: function(row, i, n) {
		         return row.UserID + '\r\n' + row.UserName + '-' + row.DeptName;     
		    }
		    
		  });
		   j(ename).result(function(event, data, formatted) {

		     j(ename).val(data.UserID);

		});
 
		});
	
	
}
/**
* 修正时间。
* 去掉str两侧的空白字符。
* 如果str是符合yyyy-MM-dd hh:mm:ss的时间字符串,则返回该字符串；
* 如果str是符合yyyy-MM-dd的日期字符串,则以00:00:00补足时间部分，并返回
* 否则返回false
*/
function getDateTime(str)  
{   
	str = jQuery.trim(str);
	
	// 检查yyyy-MM-dd hh:mm:ss
    var reg = /^(\d{4})\-(\d{2})\-(\d{2}) (\d{2}):(\d{2}):(\d{2})$/;   
    var r = str.match(reg);   
    if(r == null) {
    	//检查yyyy-MM-dd
    	reg = /^(\d{4})\-(\d{2})\-(\d{2})$/;   
    	r = str.match(reg);
    	if (r == null){
			return false;   
    	} else {
    		r[4] = 0;
    		r[5] = 0;
    		r[6] = 0;
    		str = str + " 00:00:00";
    	}
	}

    r[2]=r[2]-1;   
    var d= new Date(r[1],r[2],r[3],r[4],r[5],r[6]);   
    if(d.getFullYear()!=r[1])return false;   
    if(d.getMonth()!=r[2])return false;   
    if(d.getDate()!=r[3])return false;   
    if(d.getHours()!=r[4])return false;   
    if(d.getMinutes()!=r[5])return false;   
    if(d.getSeconds()!=r[6])return false;   

    return str;   
} 


/**
 * 字符类型日期转换为DATE对象
 */
function parseStrDate(strDate){
   strDate = strDate.replace("-","/");//替换字符，变成标准格式
   var resultDate = new Date(Date.parse(strDate));//转换成DATE对象
   return resultDate;
} 
 /**
  * 将DATE对象转换为字符日期
  */
function parseDate(date){
 var year = date.getFullYear();  
 var month = date.getMonth()+1; 
 var date = date.getDate(); 
 return year+'-'+month+'-'+date;
}
/**
 * 验证日期,判断时间隔间
 */
function validateDate(startDate,endDate){
   if(startDate==''|| endDate==''){
         alert("开始/结束日期不允许为空.");
         return false;
  }
   var newEndDate = parseStrDate(endDate);
   newEndDate.setDate(newEndDate.getDate()-15);//减去15天
   if(parseStrDate(startDate) < newEndDate){
     alert('查询条件:开始结束日期间隔不允许超过15天');
     return false;
   }
   return true;
}