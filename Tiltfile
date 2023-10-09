TILTFILE_VERSION = "0.0.7"
SERVICE_NAME = "edge-guard"
MAIN_CLASS = "com.dell.dtc.edge.guard.Application"
DEVELOPMENT_CLUSTER_CONTEXT_NAME = 'dev'
SNAPSHOT_SUFFIX = "-SNAPSHOT"

# Allow dev context so we can bootstrap the DTCTiltfile using local(...)
allow_k8s_contexts(DEVELOPMENT_CLUSTER_CONTEXT_NAME)

# Bootstrap common configuration
repository = "libs-snapshot-local" if TILTFILE_VERSION.endswith(SNAPSHOT_SUFFIX) else "libs-release-local"
tiltfile_url = "https://artifacts.dell.com/artifactory/{repository}/com/dell/dtc/dtc-tiltfile/{version}/dtc-tiltfile-{version}.zip".format(
    version=TILTFILE_VERSION, repository=repository)

local("curl {url} --output DTCTiltfile.zip".format(url=tiltfile_url))
local("unzip -p DTCTiltfile.zip Tiltfile > DTCTiltfile.tmp")
# Avoid a file-changed loop (on DTCTiltfile) in case this Tiltfile changes and we re-download the tmp Tiltfile
local("rsync --inplace --checksum -r DTCTiltfile.tmp DTCTiltfile")
load('DTCTiltfile', 'start_dtc_service')
# Done bootstrapping, load the service

start_dtc_service(SERVICE_NAME, MAIN_CLASS)
