DEPENDS:append = " ${PREFERRED_PROVIDER_virtual/gpu}"

RDEPENDS:${PN} = "${PREFERRED_PROVIDER_virtual/gpu}"
RDEPENDS:cairo-script-interpreter = "${PREFERRED_PROVIDER_virtual/gpu}"
RDEPENDS:cairo-gobject = "${PREFERRED_PROVIDER_virtual/gpu}"

# cairo 1.18.4 (wrynose 6.0) dropped the 'glesv2' PACKAGECONFIG.
# See meta-radxazero3w/recipes-graphics/cairo/cairo_%.bbappend for
# the full rationale. Surrogate to keep dependencies via virtual/gpu.