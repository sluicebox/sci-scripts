;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8242)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8242 0
)

(instance rm8242 of ExitRoom
	(properties
		picture 8242
		south 8202 ; rm8202
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		modNum 820
		nsLeft 274
		nsTop 180
		nsRight 410
		nsBottom 249
		BAD_SELECTOR 8253
	)
)

