$('document').ready(function(data){
    
    jsf.ajax.addOnEvent(function(data){
        if (data.status == 'success') {
            /*
             * Move the 'error' class from error message to div.control-group, it is
             * needed for correct display of error messages in Bootstrap
             */
            $('.control-group .help-inline.error').each(function(index){
                $(this).removeClass('error').closest('.control-group').addClass('error');                        
            });

            /*
             * Remove 'error' class from control-groups which don't have
             * error msgs in messages tags
             */
            $('.control-group.error').each(function(index){
                if (!$('.help-inline', this).text().length)
                    $(this).removeClass('error');
            })


        }
    });
});