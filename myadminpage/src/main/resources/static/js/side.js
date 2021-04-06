function $(selector) {
	return document.querySelector(selector)
}

function find(el, selector) {
	let finded
	return (finded = el.querySelector(selector)) ? finded : null
}

function siblings(el) {
	const siblings = []
	for (let sibling of el.parentNode.children) {
		if (sibling !== el) {
			siblings.push(sibling)
		}
	}
	return siblings
}

const memberList = $('.member-list')
const adminManage = $('.admin-manage')
const wrapper = $('#wrapper')

/* ============= 사이드바 카테고리 동작  =============== */
memberList.addEventListener('click', function(){
    window.location.href="/member/memberList";
})

adminManage.addEventListener('click', function(){
    window.location.href="/admin";
})

// dropdown menu in the side nav
var slideNavDropdown = $('.sidebar-dropdown');

$('.sidebar .categories').addEventListener('click', function (event) {
	event.preventDefault()

	const item = event.target.closest('.has-dropdown')

	if (item) {
		item.classList.toggle('opened')

		siblings(item).forEach(sibling => {
			sibling.classList.remove('opened')
		})

		if (item.classList.contains('opened')) {
			const toOpen = find(item, '.sidebar-dropdown')

			if (toOpen) {
				toOpen.classList.add('active')
			}

			siblings(item).forEach(sibling => {
				const toClose = find(sibling, '.sidebar-dropdown')

				if (toClose) {
					toClose.classList.remove('active')
				}
			})
		} else {
			find(item, '.sidebar-dropdown').classList.toggle('active')
		}
	}
})

$('.sidebar .close-aside').addEventListener('click', function () {
	$(`#${this.dataset.close}`).classList.add('show-sidebar')
	wrapper.classList.remove('margin')
})


