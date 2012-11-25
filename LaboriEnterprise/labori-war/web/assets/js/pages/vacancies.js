$('document').ready(function(){

    $('a.details').click(function(){
        var $el = $(this);
        var currRow = $el.closest('tr');

        if ($el.hasClass('open')) {
            $el.removeClass('open').addClass('active');
            $('.detail-info', currRow).show('fast');
        }
        else if ($el.hasClass('active')) {
            $el.removeClass('active').addClass('open');
            $('.detail-info', currRow).hide('fast');
        }
    });

    $('a.apply').click(function(){
        $(this).hide('fast', function() {$(this).remove()});
        $('.apply-success', $(this).closest('tr')).show('fast');
    });

});