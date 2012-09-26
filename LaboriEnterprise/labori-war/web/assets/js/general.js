$('document').ready(function(data){

    /* add placeholder to password field in form login - not possible with JSF 2.0 */
    $('.login-data #j_idt12\\:password').attr('placeholder', 'senha');

    function fixErrorMessages() {
        /*
        * Move the 'error' class from error message to div.control-group, it is
        * needed for correct display of error messages in Bootstrap
        */
        $('.control-group .help-inline.error').each(function(index){
            $(this).removeClass('error').closest('.control-group').addClass('error');
        });
        $('.control-group .help-block.error').each(function(index){
            $(this).removeClass('error').closest('.control-group').addClass('error');
        });

        /*
        * Remove 'error' class from control-groups which don't have
        * error msgs in messages tags
        */
        $('.control-group.error').each(function(index){
            if (!$('.help-inline', this).text().length && !$('.help-block', this).text().length)
                $(this).removeClass('error');
        });
    }

    fixErrorMessages();



    if (typeof jsf != "undefined") {

        jsf.ajax.addOnEvent(function(data){
            if (data.status == 'success') {
                fixErrorMessages();
            }
        });
    }
});