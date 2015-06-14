/**
 * do some coding about Object 
 */

//create a object in prototype pattern

/*function Person(){}

Person.prototype.name = 'lam';
Person.prototype.age = 100;
Person.prototype.job = 'Software Engineer';
Person.prototype.sayName = function(){
	alert(this.name);
};*/

function Person(age,job){
	this.age = age;
	this.job = job;
	this.increInstanceCount();
}

Person.prototype = {
		name : new String('defaultName'),
		friends : ['first friend'],
		instanceCount : new Number(0),
		constructor : Person,
		sayName : function(){
			alert(this.name);
		},
		sayAge : function(){
			alert(this.age);
		},
		sayJob : function(){
			alert(this.job);
		},
		increInstanceCount : function(){
			var count = this.instanceCount.valueOf();
			count = count+1;
			this.instanceCount = new Number(count);
			alert(this.instanceCount);
		},
		newFriend : function(friendName){
			this.friends.push(friendName);
		}
};

function Man(name){this.name = name;}

Man.prototype = {
		name : 'lam',
		age : 99,
		job : 'Software Engineer',
		constructor : Man,
		sayName : function(){
			alert(this.name);
		},
		sayAge : function(){
			alert(this.age);
		},
		sayJob : function(){
			alert(this.job);
		},
		ageIncrement : function(age_){
			this.age += age_;
		}
		
};

var Obj = {
	currentObj : '',
	objArray : [],
	createObj : function(currentObj){
		this.currentObj = currentObj;
		this.objArray.push(currentObj);
	},
	deleteObj : function(){
		this.objId = '';
	},
	getObjArray : function(){
		return this.objArray;
	}
};

//anonymous function
var application  = function(){
	//private variable and function
	var components = new Array();
	
	components.push(new BaseComponent());
	
	function BaseComponent(){}
	
	return {
		getComponentCount : function(){
			return components.length;
		},
		registerComponent : function(component){
			components.push(component);
		}	
	};
	
}();