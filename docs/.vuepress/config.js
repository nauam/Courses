// sidebars
const sidebarIntroduction = require('./sidebar-menus/introduction')
// navbars
const navbarIntroduction = require('./navbar-menus/introduction')

module.exports = {
    title: 'QW Control',
    description: 'Plataforma de automação e orquestração de serviços',
    base: `/QW_Control_Docs/`,
    head: [['link', { rel: 'icon', href: '/images/qwcontrollogo-black-small.png' }]],
    themeConfig: {
        nav: [
            {
                text: 'Introdução',
                items: navbarIntroduction
            },
            {
                text: 'QW Software',
                link: 'https://qwsoftware.com.br'
            }
        ],
        sidebarDepth: 2,
        sidebar: {
            '/introduction/': sidebarIntroduction,
        }
    }
}
