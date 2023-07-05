;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8240)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8240 0
)

(instance rm8240 of ExitRoom
	(properties
		picture 8240
	)

	(method (init)
		(super init: &rest)
		(painting init:)
		(plate init:)
		(plaque init:)
		(s1 init:)
		(s2 init:)
	)
)

(instance painting of GKFeature
	(properties
		noun 11
		modNum 820
		nsLeft 104
		nsTop 28
		nsRight 526
		nsBottom 300
	)
)

(instance plaque of GKFeature
	(properties
		nsLeft 10
		nsTop 271
		nsRight 66
		nsBottom 304
		nextRoomNum 8250 ; rm8250
	)
)

(instance plate of GKFeature
	(properties
		noun 12
		modNum 820
		nsLeft 274
		nsTop 303
		nsRight 339
		nsBottom 321
	)
)

(instance s1 of ExitFeature
	(properties
		nsLeft -1
		nsTop 303
		nsRight 274
		nsBottom 341
		nextRoomNum 820 ; rm820
		exitDir 4
	)
)

(instance s2 of ExitFeature
	(properties
		nsLeft 339
		nsTop 303
		nsRight 640
		nsBottom 341
		nextRoomNum 820 ; rm820
		exitDir 4
	)
)

