$(document).ready(function () {

    $('#priceId').change(function () {
        var mult = $('option:selected', this).attr('myTag');
        var basePriceId = $('#basePriceId').val();
        var basePriceValue = $('#basePriceValue').val();
        if (basePriceId != null &amp;&amp; basePriceId != 0) {

            $('#priceValue').value = basePriceValue * (mult / 100);
        }
    });
});