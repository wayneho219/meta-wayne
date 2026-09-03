SUMMARY = "Hello world script executed at boot via systemd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ba2a2c7e15e3002ce95867d9d41b8a5b"

SRC_URI = "git://github.com/wayneho219/hello-world.git;branch=main;protocol=https"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit allarch systemd

SYSTEMD_SERVICE:${PN} = "hello-world.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/hello-world.sh ${D}${bindir}/hello-world.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/hello-world.service ${D}${systemd_system_unitdir}/hello-world.service
}

FILES:${PN} += "${systemd_system_unitdir}/hello-world.service"
