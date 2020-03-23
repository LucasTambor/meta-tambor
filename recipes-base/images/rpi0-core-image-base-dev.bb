SUMMARY = "A console-only image that fully supports the target device \
hardware - BUT DEV."

IMAGE_FEATURES += "splash dev-pkgs ssh-server-openssh"

LICENSE = "MIT"


inherit core-image
