FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-create-led-to-dts.patch\
    file://0002-feat-add-SHT30-sensor-on-I2C1-to-stm32mp215f-dk-dts.patch \
    "

