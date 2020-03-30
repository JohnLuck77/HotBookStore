// 장바구니 추가
$('a.addToCart').click(function() {
	let book_id = $(this).parent().parent().prev().val();
	let qty = 1;

	$.ajax({
		type: 'post',
		url: '/hotSalt/cart',
		data: {	'book_id': book_id,
				'qty': qty},
		dataType:'text',
		success: function(data) {
			if(data!='error'){
				if(confirm("장바구니에 상품이 담겼습니다. 바로 확인하시겠습니까?")){
					location.href="/hotSalt/cart"
				}
			}else{
				alert('서버와 통신 중 오류가 발생했습니다.')
			}
		}
	})
})

$('#btn-search').click(function() {
	let keyword = $('#titleOrAuthor').val();
//	let cate1 = $('#cate1').val();
//	if (cate1 == '' || cate1 == '전체'){
//		cate1 = 'all';
//	}
	let cate1 = 'all'
	
	if(keyword ==''){
		alert('검색어를 입력해주세요.')
	}else{
		location.href="/hotSalt/search?cate1=" + cate1 + "&titleOrAuthor=" + keyword;
	}
})

$('.wedget__title').next().find('li').click(function() {
	let cate1 = $(this).text();
	if(cate1.trim() == '전체'){
		cate1 = 'all';
	}
	location.href="/hotSalt/search?cate1=" + cate1;
})

$('#price-filter').click(function() {
	let cate1 = $('#cate1').val();
	if(cate1.trim() == '전체'){
		cate1 = 'all';
	}
	location.href="/hotSalt/search?cate1=" + cate1 + "&min=" + $('#slider-range').slider('values', 0) + "&max=" + $('#slider-range').slider('values', 1);
})

$('i.bi.bi-search').click(function() {
	var $p = $(this).parent().parent().parent().parent().parent().parent().parent();
	$('#modal-img').attr('src',($p.find('.first__img img').attr('src')));
	$('#modal-title').text($p.find('.product__content a').text());
	$('#modal-d_price').text($p.find('.product__content .prize li:eq(0)').text());
	$('#modal-price').text($p.find('.product__content .prize li:eq(1)').text());
	$('#modal-info').text()
})


