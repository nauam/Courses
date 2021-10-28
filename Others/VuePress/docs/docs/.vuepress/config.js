// sidebars
const sidebarIntroduction = require('./sidebar-menus/introduction')
const sidebarIntroductionEn = require('./sidebar-menus/en/introduction')
// navbars
const navbarIntroduction = require('./navbar-menus/introduction')
const navbarIntroductionEn = require('./navbar-menus/en/introduction')

module.exports = {
    base: `/docs/`,
    title: 'VuePress',
    locales: {
        '/': {
            lang: 'pt-BR',
            description: 'Descrição.',
        },
        '/en/': {
            lang: 'en-US',
            description: 'Description.',
        },
    },
    head: [['link', { rel: 'icon', href: '/assets/img/logo.png' }]],
    themeConfig: {
        locales: {
            '/': {
                label: 'Português',
                selectText: 'Linguagens',
                ariaLabel: 'Linguagens',
                nav: [
                    {
                        text: 'Introdução',
                        items: navbarIntroduction
                    }
                ],
                sidebarDepth: 2,
                sidebar: {
                    '/introduction/': sidebarIntroduction,
                }
            },
            '/en/': {
                label: 'English',
                selectText: 'Languages',
                ariaLabel: 'Languages',
                nav: [
                    {
                        text: 'Introduction',
                        items: navbarIntroductionEn
                    }
                ],
                sidebarDepth: 2,
                sidebar: {
                    '/en/introduction/': sidebarIntroductionEn,
                },
            },
        },
    }
}
