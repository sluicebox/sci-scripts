;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 776)
(include sci.sh)
(use Main)
(use Polygon)
(use Feature)
(use Game)

(public
	rm776 0
)

(local
	local0
)

(instance rm776 of Room
	(properties
		modNum 775
		noun 4
		picture 775
	)

	(method (init)
		(super init: &rest)
		(gEgo
			view: 9125
			setLoop: 3
			posn: 152 132
			modNum: 7
			signal: (| (gEgo signal:) $1000)
			init:
		)
		(rug init:)
		(floor init:)
		(shelf init:)
		(theDoor init:)
		(gWalkHandler addToFront: self)
		(gGame handsOn:)
	)

	(method (handleEvent event)
		(if (and (not (event modifiers:)) (& (event type:) evMOVE))
			(self newRoom: 755)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance rug of Feature
	(properties
		noun 1
		modNum 775
		sightAngle 360
		x 153
		y 103
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 177 104 169 113 130 106 140 98
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb 0 1 0 775) ; "You move the rug to discover..."
				(gGame points: 3 87)
				(gPqFlags set: 144)
				(gCurRoom newRoom: 775)
			)
			(1 ; Look
				(gCurRoom newRoom: 775)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance floor of Feature
	(properties
		noun 3
		modNum 775
		sightAngle 360
		x 153
		y 90
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 115 92 180 104 180 125 205 147 100 147 100 130 105 130 115 109
					yourself:
				)
		)
	)
)

(instance shelf of Feature
	(properties
		noun 7
		modNum 775
		sightAngle 360
		x 153
		y 20
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 116 9 180 9 180 32 116 32
					yourself:
				)
		)
	)
)

(instance theDoor of Feature
	(properties
		noun 8
		modNum 775
		sightAngle 360
		x 153
		y 100
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 182 7 210 0 212 1 209 146 206 147 181 124
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 105 3 114 9 114 111 105 128 102 128
					yourself:
				)
		)
	)
)

