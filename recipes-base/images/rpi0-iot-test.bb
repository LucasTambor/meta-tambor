# Base this image on rapi0-core-image-base
include recipes-base/images/rpi0-core-image-base.bb

# Include modules in rootfs
IMAGE_INSTALL += " \
	mosquitto \
	mosquitto-clients \
	python3 \
	python3-paho-mqtt \
	tzdata \
	bash \
	sqlite3 \
	libsqlite3-dev \
	python3-azure-iot-device \
	"
