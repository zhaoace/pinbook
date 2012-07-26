/* $Id: jquery.popup.js 67 2008-01-22 08:54:37Z Bolik@xjgc.com $ */

(function($) {
  function Popup(el, content) {
    this.input = $(el);
   
    this.popupContent = content;
    
    this.input.attr("readonly", "readonly");
    
    this.input.attr("autocomplete","off");
    
    this.bindMethodsToObj("show", "hide", "hideIfClickOutside", "selectItem");
    
    this.build();
    //this.selectItem();
    this.show();
   // this.hide();
//    
  };
  function t(obj){
	  var info ="";
	  for(var m in obj){
		  info += " "+m;
	  }
	  alert(info);
  }
  Popup.prototype = {
    build: function() {
      this.ClearController = $('<a href="#">清除选择</a>').click(this.bindToObj(function(event) {
        this.selectItem("", "");
        this.hide();
        return false;
      })); 
        
      $(".popupPanel").remove();
//      if($("#popupPanel"+this.input.attr("plugin")).length<1){
	      this.popupController = $('<div class="popupController" id="popupController'+this.input.attr("plugin")+'"></div>').append(this.ClearController); 
	      this.popupContent = $('<div class="popupContent" id="popupContent'+this.input.attr("plugin")+'"></div>').append(this.popupContent); 
	     
	      this.popupPanel = this.rootLayers = $('<div class="popupPanel" id="popupPanel'+this.input.attr("plugin")+'"></div>')
	        .css({ display: "none", position: "absolute", zIndex: 2001 })
	        .append(this.popupController, this.popupContent)
	        .appendTo(document.body);

	      $(".treeview-popup").treeview({});
//     }else{
//    	  this.popupController =  $("#popupController"+this.input.attr("plugin"));
//    	  this.popupContent=$("#popupContent"+this.input.attr("plugin"));
//    	  this.popupPanel = this.rootLayers =$("#popupPanel"+this.input.attr("plugin"));
//     }
     
      if ($.browser.msie && $.browser.version < 7) {
	        this.ieframe = $('<iframe class="popupPanel_ieframe" frameborder="0" src="#"></iframe>')
	          .css({ position: "absolute", display: "none", zIndex: 1800 })
	          .insertBefore(this.popupPanel);
	        this.rootLayers = this.rootLayers.add(this.ieframe);
	  };

      $("a", this.popupContent).click(this.bindToObj(function(event) {
	        //this.selectItem($(event.target).attr("id"), $(event.target).attr("innerHTML"));
	        this.selectItem($(event.target).attr("id"), $(event.target).parent().attr("id"));
	        this.hide();
	        return false;
	      }));

      //this.input.change(this.bindToObj(function() { this.selectItem(); }));
    }, 
    
    selectItem: function(item, text) {  
      this.selectedItem = item;
      this.input.attr("SelectedItem", item);
      this.input.val(text);      
    },
    
    show: function() {
      this.setPosition();
      this.rootLayers.css("display", "block");
      //this.input.unbind("focus", this.show);
      $(document.body).click(this.hideIfClickOutside);
    },
    
    hide: function() {
      this.rootLayers.css("display", "none");
      $(document.body).unbind("click", this.hideIfClickOutside);
      //this.input.focus(this.show);
    },
    
    hideIfClickOutside: function(event) {
      if (event.target != this.input[0] && !this.insideSelector(event)) {
        this.hide();
      };
    }, 
     
    setPosition: function() {
      var offset = this.input.offset();
      this.rootLayers.css({
        top: offset.top + this.input.outerHeight(),
        left: offset.left
      });
      
      if (this.ieframe) {
        this.ieframe.css({
          width: this.popupPanel.outerWidth(),
          height: this.popupPanel.outerHeight()
        });
      };
    },  
     
    insideSelector: function(event) {
      var offset = this.popupPanel.offset();
      offset.right = offset.left + this.popupPanel.outerWidth();
      offset.bottom = offset.top + this.popupPanel.outerHeight();
      
      return event.pageY < offset.bottom &&
             event.pageY > offset.top &&
             event.pageX < offset.right &&
             event.pageX > offset.left;
    },
    
    bindToObj: function(fn) {
      var self = this;
      return function() { return fn.apply(self, arguments) };
    },
    
    bindMethodsToObj: function() {
      for (var i = 0; i < arguments.length; i++) {
        this[arguments[i]] = this.bindToObj(this[arguments[i]]);
      };
    } 
    
  };

  $.fn.popup = function(content) {
    return this.each(function() { 
      new Popup(this, content); 
    });
  };
})(jQuery);