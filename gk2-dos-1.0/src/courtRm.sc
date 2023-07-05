;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	courtRm 0
)

(instance courtRm of ExitRoom ; "Rittersberg Rathaus"
	(properties
		noun 19
		picture 7110
		east 700 ; sqRm
		south 700 ; sqRm
		west 700 ; sqRm
	)

	(method (init)
		(archDoor init:)
		(dungeonDoor init:)
		(super init: &rest)
	)
)

(instance archDoor of Feature
	(properties
		nsLeft 92
		nsTop 127
		nsRight 276
		nsBottom 273
		sightAngle 40
		approachX 188
		approachY 278
		x 184
		y 199
	)

	(method (doVerb)
		(gCurRoom newRoom: 7122)
	)
)

(instance dungeonDoor of Feature
	(properties
		nsLeft 392
		nsTop 64
		nsRight 532
		nsBottom 187
		sightAngle 40
		approachX 460
		approachY 194
		x 456
		y 124
	)

	(method (doVerb)
		(gCurRoom newRoom: 7133)
	)
)

