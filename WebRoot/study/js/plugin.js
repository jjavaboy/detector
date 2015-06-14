(function($){
$.fn.myPlugin = function(options){
	//alert($(this).attr('id') + ' call myPlugin.');
	/*var defaults = {
			foreground : 'red',
			background : 'green'
	};*/
	debug(this);
	
	var opts = $.extend({},$.fn.myPlugin.defaults,options);
	
	
	this.each(function(){
		var $this = $(this);
		
		var o = $.meta ? $.extend({},opts,$this.data()) : opts;
		
		$(this).css({background : o.background});

		var markup = $.fn.myPlugin.format($this.html());
		
		$this.html(markup);
	});
	return this;
};

//Ë½ÓÐº¯Êý£ºdebugging    
function debug($obj) {    
  if (window.console && window.console.log)    
    window.console.log('hilight selection count: ' + $obj.size());    
}; 

$.fn.myPlugin.defaults = {
		foreground : 'red',
		background : 'yellow'
};

$.fn.myPlugin.format = function(text){
	return '<strong>' + text + '</strong>';
}

})(jQuery);