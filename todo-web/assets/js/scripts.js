$('#addTask').on('keypress', function() {
	var addTask = $(this),
		textLength = addTask.val().length;

	if(textLength > 46) {
		addTask.css('font-size', '18px');
	} else if(textLength > 36) {
		addTask.css('font-size', '22px');
	} else if(textLength > 26) {
		addTask.css('font-size', '28px');
	} else {
		addTask.css('font-size', '36px');
	}
});