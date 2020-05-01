SUMMARY = "Mqtt and Sqlite3 application for Unisal IoT class"
AUTHOR = "Lucas Tamborrino"
HOMEPAGE = "https://github.com/LucasTambor/mqtt-db"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=642b99295ac56e292d8f19b0c8ca6b0c"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

inherit setuptools systemd

S = "${WORKDIR}/git"
# DEPENDS = "python3 python3-paho-mqtt mosquitto"
RDEPENDS_${PN} += " python3-core ${PYTHON_PN}-paho-mqtt"

PR = "r0"

SRC_URI = "git://github.com/LucasTambor/mqtt-db;branch=master \
        file://mqtt-db.service"

SRCREV = "c4c0fad3e057d4c818ce74dfad61aa95a8c98a15"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "mqtt-db.service"

FILES_${PN} += "opt/mqttApp/* ${systemd_system_unitdir}/*"
FILES_${PN} += "${systemd_system_unitdir}/*"

do_install_append () {
    install -d ${D}${base_prefix}/opt/mqttApp/
    install -m 0775 app.py ${D}${base_prefix}/opt/mqttApp/
    install -m 600 persister.py ${D}${base_prefix}/opt/mqttApp/
    install -m 600 mqttHandler.py ${D}${base_prefix}/opt/mqttApp/
    install -m 600 AzureHubIoT.py ${D}${base_prefix}/opt/mqttApp/

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/mqtt-db.service ${D}${systemd_system_unitdir}
}
# SYSTEMD_SERVIVE_${PN} = "mqtt-db.service"