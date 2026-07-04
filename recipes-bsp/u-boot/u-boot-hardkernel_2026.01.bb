# Modern u-boot for ODROID XU4 (Exynos5422). Replaces the stale
# Hardkernel 2017.05 fork that would not build on wrynose's gcc-14 toolchain.
# Uses mainline u-boot 2026.01 with odroid-xu3_defconfig (the mainline config
# advertises "ODROID-XU3/XU4/HC1/HC2" so it covers all Exynos5422 Hardkernel
# boards).
#
# Migrated to the wrynose 6.0 U-Boot configuration flow:
#   - UBOOT_CONFIG[name] flag syntax (multi-config flow)
#   - UBOOT_CONFIG_BINARY[name] for the deployed u-boot image name
#   - UBOOT_CONFIG_IMAGE_FSTYPES[name] for artifacts pulled into the image

require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

SUMMARY = "U-Boot bootloader for Hardkernel ODROID XU3/XU4/HC1/HC2 boards"
DESCRIPTION = "Modern mainline U-Boot for the Hardkernel Exynos5422 family. \
Replaces the 2017.05 vendor fork whose build chain is broken on gcc-14 / \
glibc 2.41. Identifies as 'ODROID-XU3/XU4/HC1/HC2' upstream."

SRC_URI:append = " file://CVE-2026-33243.patch"

PROVIDES += "virtual/bootloader u-boot"
PE = "1"

# --- Modern U-Boot configuration flow (wrynose 6.0) ---
UBOOT_CONFIG ??= "odroid-xu4"
UBOOT_CONFIG[odroid-xu4] = "odroid-xu3_defconfig"
UBOOT_CONFIG_BINARY[odroid-xu4] = "u-boot-dtb.bin"
UBOOT_CONFIG_IMAGE_FSTYPES[odroid-xu4] = "ext4"
