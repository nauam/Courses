const QWCONTROL_VERSION = '3.4.2'
const QWCONTROL_VERSION_FULL = '3.4.2-SNAPSHOT'
const API_VERSION = '39'
const API_DEP_REL = '3.4.0'
const API_DEP_VER = '11'
const API_MIN_VER = '11'

const REPO_BRANCH = '3.4.x'

const setup = {
    base: process.env.DOC_BASE,
    branch: process.env.DOC_BRANCH || REPO_BRANCH,
    apiVersion: API_VERSION,
    apiDepVersion: API_DEP_VER,
    apiDepRelease: API_DEP_REL,
    apiMinVersion: API_MIN_VER,
    qwcontrolVersion: process.env.QWCONTROL_VERSION || QWCONTROL_VERSION,
    qwcontrolVersionFull: process.env.QWCONTROL_VERSION_FULL || QWCONTROL_VERSION_FULL
}

module.exports = setup
