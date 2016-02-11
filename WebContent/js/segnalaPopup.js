$(document).ready(function() {
var dialog = $('#signal-dialog').dialog(
	    {
	    autoOpen: false,
	    height: 350,
	    width: 550,
	    resizable: false,
	    draggable: true,
	    title: "Segnala",
	    show: { effect: "blind", duration: 800 },
	    open: function () {        
	            $('.signal-dialog').show();
	        },
	    });

    
    //enable the button to open and re-open the country choice dialog box 
    $(".Segnala").click(function ()
    {
        dialog.dialog("open");
        return false;
    });
});