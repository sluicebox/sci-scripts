;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9110)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Actor)

(public
	neuEntryRm3 0
)

(instance neuEntryRm3 of ExitRoom
	(properties
		picture 9110
		south 910 ; rm910
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(super init: &rest)
		(smallDoor init:)
		(bigDoor init:)
		(rightPic init:)
	)
)

(instance smallDoor of GKFeature
	(properties
		modNum 910
		x 179
		y 155
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 265 114 89 144 40 177 34 212 40 244 90 241 277
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(= noun
			(cond
				((== gChapter 6) 21)
				((not (IsFlag 628)) 9)
				((IsFlag 644) 11)
				(else 10)
			)
		)
		(super doVerb: &rest)
	)
)

(instance bigDoor of ExitFeature
	(properties
		x 486
		y 144
		nextRoomNum 920 ; rm920
		exitDir 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 380 18 593 8 593 281 381 266
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightPic of GKFeature
	(properties
		x 55
		y 74
		nextRoomNum 9141 ; neuEntryRm2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 151 112 150 109 -1 -1 -1
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tourTapeButton of View
	(properties
		noun 24
		modNum 910
		x 10
		y 290
		view 141
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 628)
		)
		(super doVerb: theVerb)
	)
)

