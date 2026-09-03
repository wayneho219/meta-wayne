SUMMARY = "Hello world script executed at boot via systemd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello-world.sh \
           file://hello-world.service"

S = "${WORKDIR}"

inherit allarch systemd

SYSTEMD_SERVICE:${PN} = "hello-world.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/hello-world.sh ${D}${bindir}/hello-world.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/hello-world.service ${D}${systemd_system_unitdir}/hello-world.service
}

FILES:${PN} += "${systemd_system_unitdir}/hello-world.service"