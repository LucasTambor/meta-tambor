# Base this image on rapi0-core-image-base
include recipes-base/images/rpi0-core-image-base.bb

# Include modules in rootfs
IMAGE_INSTALL += " \
	mosquitto \
	"
