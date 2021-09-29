const nunjucks = require('nunjucks')
const setup = require('./setup')

nunjucks.configure({
    autoescape: false,
    tags: {
        blockStart: '{{{%',
        blockEnd: '%}}}',
        variableStart: '{{{',
        variableEnd: '}}}',
        commentStart: '{{{#',
        commentEnd: '#}}}'
    }
})

const config = {
    apiVersion: setup.apiVersion,
    apiDepVersion: setup.apiDepVersion,
    apiDepRelease: setup.apiDepRelease,
    apiMinVersion: setup.apiMinVersion,
    qwcontrolVersion: setup.qwcontrolVersion,
    qwcontrolVersionFull: setup.qwcontrolVersionFull,

    javaDocBase: `https://static.javadoc.io/org.qwcontrol/qwcontrol-core/` + setup.qwcontrolVersionFull,
    javaDocStorageApiBase: `https://static.javadoc.io/org.qwcontrol/qwcontrol-storage-api/` + setup.qwcontrolVersionFull
}

module.exports = function (source) {
    const isProd = process.env.NODE_ENV === 'production'
    const isServer = this.target === 'node'

    const rendered = nunjucks.renderString(source, config)
    return rendered
}