;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7700)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	octoPitRoom 0
)

(instance octoPitRoom of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7211 ; octoMeeniePit
				(self addPicObj: faceWest facePit faceEast faceTunnels faceWest)
			)
			(7112 ; octoEeniePit
				(self addPicObj: faceEast faceTunnels faceWest facePit faceEast)
			)
			(7701 ; octoPitPad
				(self
					addPicObj: faceTunnels faceWest facePit faceEast faceTunnels
				)
				(gCurRoom setScript: (ScriptID 7903 1)) ; sPadUp
			)
			(else
				(self addPicObj: facePit faceEast faceTunnels faceWest facePit)
			)
		)
	)
)

(instance faceEast of CameraAngle
	(properties
		picture 7702
		heading 90
		edgeN 0
		edgeS 0
	)
)

(instance faceWest of CameraAngle
	(properties
		picture 7704
		heading 270
		edgeN 0
		edgeS 0
	)
)

(instance facePit of CameraAngle
	(properties
		picture 7701
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (== global259 global260)
			(self picture: 7708)
		else
			(self picture: 7701)
		)
		(super init: &rest)
		(SPIKEPAD_0 init:)
		(pitRoom_0 init:)
		(exitToPit init:)
		(gCurRoom exitN: exitToPit)
	)
)

(instance faceTunnels of CameraAngle
	(properties
		picture 7703
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToEenie init:)
		(gCurRoom exitNW: exitToEenie)
		(exitToMeenie init:)
		(gCurRoom exitNE: exitToMeenie)
		(eenie init: global117)
		(meenie init: global117)
		(super init: &rest)
		(eenieTunnel_180 init:)
		(meenieTunnel_180 init:)
	)
)

(instance exitToPit of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 7701
	)
)

(instance exitToEenie of ExitFeature
	(properties
		nsLeft 390
		nsTop 124
		nsRight 591
		nsBottom 216
		nextRoom 7112
		exitStyle 256
	)
)

(instance exitToMeenie of ExitFeature
	(properties
		nsLeft 1
		nsTop 113
		nsRight 197
		nsBottom 204
		nextRoom 7211
		exitStyle 256
	)
)

(instance eenie of View
	(properties
		x 573
		y 143
		view 7701
		cel 1
	)

	(method (init)
		(if (proc1111_24 193)
			(super init: global117 &rest)
		)
	)
)

(instance meenie of View
	(properties
		y 143
		view 7701
	)

	(method (init)
		(if (proc1111_24 184)
			(super init: global117 &rest)
		)
	)
)

(instance SPIKEPAD_0 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 152 196 208 186 285 183 383 183 443 201 378 212 214 215
					yourself:
				)
		)
	)
)

(instance pitRoom_0 of Feature
	(properties
		noun 32
		nsLeft 64
		nsTop 17
		nsRight 550
		nsBottom 190
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance meenieTunnel_180 of Feature
	(properties
		noun 53
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 134 132 133 176 207 -3 213 -1 128
					yourself:
				)
		)
	)
)

(instance eenieTunnel_180 of Feature
	(properties
		noun 53
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 471 135 427 202 590 213 591 134 469 137
					yourself:
				)
		)
	)
)

