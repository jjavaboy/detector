/**
 * do some coding about Array 
 */

//defined a instance of Array

var array = [];

function compareValue(name){
	return function(array1,array2){
		if(array1[name] > array2[name]){
			return 1;
		}else if(array1[name] < array2[name]){
			return -1;
		}else{
			return 0;
		}
	};
}
