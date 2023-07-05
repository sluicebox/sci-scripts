;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6510)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	mirmicatHall1 0
)

(instance mirmicatHall1 of Location
	(properties
		noun 46
	)

	(method (init)
		(super init:)
		(= plane global116)
		(self setPicObj: elevatorShaft)
	)
)

(instance elevatorShaft of CameraAngle
	(properties
		picture 6550
		edgeW 0
		edgeE 0
		edgeS 0
		edgeN 0
	)

	(method (init)
		(ropeExit init: setHotspot: 2 144)
		(exitOutOfShaft init:)
		(gCurRoom exitN: exitOutOfShaft)
		(super init:)
		(myrmHead_0 init:)
		(if (SetFlag 153)
			(proc1111_31 40 13)
		)
	)
)

(instance exitOutOfShaft of ExitFeature
	(properties
		nextRoom 6511
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 209 3 187 179 296 249 387 238 408 217 373 5
					yourself:
				)
		)
	)
)

(instance ropeExit of Feature
	(properties
		noun 45
		nsBottom 182
		nsLeft 164
		nsRight 194
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 13)
				(gCurRoom newRoom: 6606) ; avianSchool07
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance myrmHead_0 of Feature
	(properties
		noun 27
		x 291
		y 117
		nsBottom 158
		nsLeft 254
		nsRight 329
		nsTop 76
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

