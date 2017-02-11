jQuery(document).ready(function () {
    // При выборе значения в select определяет расчетная цена или нет
    // затем проверяет цену, которая уже есть у продукта, является ли она базовой к выбранной в select
    // и умножает значение базовой цены на множитель цены в select
    $('#priceId').change(function () {
        var mult = parseInt($('option:selected', this).attr('multipler'));
        var baseId = $('option:selected', this).attr('baseId');
        if (baseId != null) {
            $('#pricesOfProduct [productPriceId]').each(function () {
                var productPriceId = $(this).attr('productPriceId');
                var productPriceValue = parseInt($(this).text());
                if (baseId == productPriceId) {
//                            console.log(productPriceId);
                    $('#priceValue').val(productPriceValue * (mult / 100));
                }
            });
        } else {
            $('#priceValue').val('');
        }
    });
});