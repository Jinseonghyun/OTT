rootProject.name = "OTT"

include("ott-adapters:adapter-http")
include("ott-adapters:adapter-persistence")

include("ott-apps:app-api")
include("ott-apps:app-batch")

include("ott-commons")

include("ott-core:core-domain")
include("ott-core:core-port")
include("ott-core:core-service")
include("ott-core:core-usecase")