;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8250)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8250 0
)

(instance rm8250 of ExitRoom
	(properties
		picture 8250
		south 8240 ; rm8240
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		noun 26
		modNum 820
		nsLeft 28
		nsTop 48
		nsRight 620
		nsBottom 304
	)
)

