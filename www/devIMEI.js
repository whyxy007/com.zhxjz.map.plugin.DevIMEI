var cordova = require('cordova');

var devIMEI = {

	"getIMEI" : function(onSuccessFn, onErrorFn){
		cordova.exec(onSuccessFn, onErrorFn, 'DevIMEIPlugin', 'getIMEI', []); 
	}

};

module.exports = devIMEI;

