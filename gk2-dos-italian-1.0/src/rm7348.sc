;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7348)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm7348 0
)

(instance rm7348 of ExitRoom
	(properties
		picture 7348
		south 7301 ; rm7301
	)

	(method (init)
		(dudes init:)
		(super init: &rest)
	)
)

(instance dudes of GKFeature
	(properties
		noun 24
		modNum 730
		nsRight 640
		nsBottom 300
	)
)

