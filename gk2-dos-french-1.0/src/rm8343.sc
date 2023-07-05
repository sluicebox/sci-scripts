;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8343)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8343 0
)

(instance rm8343 of ExitRoom
	(properties
		picture 8343
		south 830 ; rm830
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of Feature
	(properties
		noun 9
		modNum 740
		nsLeft 224
		nsTop 48
		nsRight 400
		nsBottom 304
	)
)

