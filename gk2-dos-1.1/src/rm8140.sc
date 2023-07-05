;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8140)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8140 0
)

(instance rm8140 of ExitRoom
	(properties
		picture 8140
	)

	(method (init)
		(plq init:)
		(super init: &rest)
		(lizPic init:)
		(nameTag init:)
		(s1 init:)
		(s2 init:)
	)
)

(instance lizPic of Feature
	(properties
		noun 16
		modNum 810
		nsLeft 210
		nsTop 28
		nsRight 402
		nsBottom 271
	)
)

(instance nameTag of Feature
	(properties
		noun 17
		modNum 810
		nsLeft 291
		nsTop 275
		nsRight 325
		nsBottom 304
	)
)

(instance plq of GKFeature
	(properties
		nsLeft 243
		nsTop 306
		nsRight 362
		nsBottom 341
		nextRoomNum 8150 ; rm8150
	)
)

(instance s1 of ExitFeature
	(properties
		nsLeft -1
		nsTop 306
		nsRight 243
		nsBottom 341
		nextRoomNum 810 ; rm810
		exitDir 4
	)
)

(instance s2 of ExitFeature
	(properties
		nsLeft 362
		nsTop 306
		nsRight 640
		nsBottom 341
		nextRoomNum 810 ; rm810
		exitDir 4
	)
)

