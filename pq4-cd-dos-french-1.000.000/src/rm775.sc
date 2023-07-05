;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 775)
(include sci.sh)
(use Main)
(use Polygon)
(use Feature)
(use Game)
(use Actor)
(use System)

(public
	rm775 0
)

(procedure (localproc_0 param1)
	(return (and (<= 36 (param1 x:) 283) (<= 0 (param1 y:) 148)))
)

(instance rm775 of Room
	(properties
		noun 4
		picture 778
		style 0
	)

	(method (doRemap)
		(gGame doRemap: 2 253 85)
		(gGame doRemap: 2 254 75)
	)

	(method (init)
		(gTheIconBar disable: 3 7 show: 0)
		(roomSqr init:)
		(closeUpRug init:)
		(shoe init:)
		(if (gPqFlags test: 144)
			(trapdoor init:)
			(shovedRug init:)
		)
		(super init: &rest)
		(gWalkHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gGame handsOn:)
	)

	(method (handleEvent event)
		(cond
			((and (not (event modifiers:)) (& (event type:) evMOVE))
				(self newRoom: (if (gPqFlags test: 144) 755 else 776))
				(event claimed: 1)
				(return)
			)
			(
				(and
					(not (event modifiers:))
					(& (event type:) evVERB)
					(not (localproc_0 event))
				)
				(self newRoom: (if (gPqFlags test: 144) 755 else 776))
				(event claimed: 1)
				(return)
			)
			(else
				(event claimed: 0)
				(return)
			)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance closeUpRug of Feature
	(properties
		noun 5
		modNum 775
		sightAngle 360
		x 181
		y 65
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 124 37 246 83 234 116 215 148 77 88 102 58
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gPqFlags set: 144)
			(gGame points: 3 87)
			(trapdoor init:)
			(shovedRug init:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance shoe of Feature
	(properties
		noun 6
		modNum 775
		sightAngle 360
		x 82
		y 28
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 59 25 70 27 85 24 97 24 100 27 97 32 86 40 85 40 86 33 81 33 76 35 67 35 59 31 56 24
					yourself:
				)
		)
	)
)

(instance trapdoor of View
	(properties
		noun 2
		modNum 775
		x 138
		y 109
		view 778
		cel 1
		signal 4096
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gPqFlags set: 124)
			(gGame points: 4)
			(gCurRoom newRoom: 690)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance shovedRug of View
	(properties
		noun 5
		modNum 775
		x 138
		y 110
		z 1
		view 778
		signal 4096
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1) ; Do, Look
			(gMessager say: noun theVerb 2 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance roomSqr of Feature
	(properties
		noun 4
		nsLeft 36
		nsRight 283
		nsBottom 148
		y 1
	)
)

