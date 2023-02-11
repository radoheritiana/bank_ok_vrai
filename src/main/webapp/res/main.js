const demandeCompte = document.querySelector(".demande-compte")
const listCompte = document.querySelector(".list-compte")
const clientContainer = document.querySelector(".client-container")
const listClientContainer = document.querySelector(".list-client-container")
const indicator = document.createElement('span')
const menu = document.querySelector('.menu')
const menuItems = Array.from(document.querySelectorAll('.li'))
let selected = document.querySelector('[aria-selected]')

indicator.classList.add('indicator')
menu.appendChild(indicator)

function onItemeClick(e) {
    if (e.currentTarget === selected) {
        return
    }
    if (selected) {
        console.log(selected)
        selected.removeAttribute('aria-selected')
    }
    e.currentTarget.setAttribute('aria-selected', 'true')

    indicator.animate([
        { transform: getTranform(e.currentTarget) }
    ], {
        fill: "both",
        duration: 600,
        easing: 'cubic-bezier(.45,1.55, .28,1)'
    })
    selected = e.currentTarget
}

function getTranform(element) {
    const Transform = {
        x: element.offsetLeft,
        scale: element.offsetWidth / 100
    }
    return `translateX(${Transform.x}px) scaleX(${Transform.scale})`
}

menuItems.forEach((iteme) => {
    iteme.addEventListener('click', onItemeClick)
})


demandeCompte.addEventListener("click", () => {
    clientContainer.classList.toggle("contenair-not-active")
    listClientContainer.classList.toggle("contenair-not-active")
})

listCompte.addEventListener("click", () => {
    clientContainer.classList.toggle("contenair-not-active")
    listClientContainer.classList.toggle("contenair-not-active")
})