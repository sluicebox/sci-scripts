;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 535)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Game)
(use System)

(public
	rm535 0
)

(instance rm535 of Room
	(properties
		noun 10
		picture 535
	)

	(method (doRemap)
		(gGame doRemap: 2 243 85)
		(gGame doRemap: 2 244 75)
	)

	(method (init)
		(gGame handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 217 106 217 104 112 104 112 106 150 106 125 152 210 152 188 106
					yourself:
				)
		)
		(super init: &rest)
		(wall init:)
		(floor init:)
		(hallMap init:)
		(self setScript: sEnter)
	)

	(method (doit)
		(super doit:)
		(if (not script)
			(cond
				((<= (gEgo x:) 126)
					(gCurRoom newRoom: 525)
				)
				((>= (gEgo x:) 213)
					(gPqFlags set: 31)
					(gCurRoom newRoom: 525)
					(gGlobalSound0 fade: 0 4 2 1)
				)
				((>= (gEgo y:) 131)
					(gGlobalSound0 fade: 127 4 2 0)
					(gCurRoom newRoom: 540)
				)
			)
		)
	)
)

(instance floor of Feature
	(properties
		noun 5
		x 180
		y 147
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 141 102 192 102 221 147 113 147
					yourself:
				)
		)
	)
)

(instance hallMap of Feature
	(properties
		noun 4
		nsLeft 155
		nsTop 42
		nsRight 180
		nsBottom 49
		x 167
		y 49
	)
)

(instance wall of Feature
	(properties
		noun 2
		nsLeft 47
		nsRight 294
		nsBottom 148
		x 159
		y 1
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== gPrevRoomNum 540)
						(gEgo heading: 0 y: 130 x: 166)
					)
					((gPqFlags test: 31)
						(gPqFlags clear: 31)
						(gEgo y: 105 x: 212 heading: 270)
					)
					(else
						(gEgo y: 105 x: 127 heading: 90)
					)
				)
				(gEgo
					normalize: 0
					setScaler: Scaler 124 60 147 101
					init:
					setMotion: PolyPath 165 120
				)
				(= cycles 2)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

