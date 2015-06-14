/**
 * define my plugin
 */
(function(window){
	var 
	Utils = function(){
		//do...
	};
	Utils.prototype = {
		constructor : Utils,
		ajaxError : function(jqXHR, textStatus, errorThrown){
			alert("status:" + jqXHR.status + ", textStatus:" + textStatus + ", errorThrown:" + errorThrown);
		}
	};
	
	window.Utils = new Utils();
})(window);