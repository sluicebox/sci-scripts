;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3032)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use VMDMovie)
(use Feature)

(public
	london_Elevator_Cntrl 0
)

(instance london_Elevator_Cntrl of CloseupLocation
	(properties
		heading 270
	)

	(method (init)
		(self edgeW: 0 edgeE: 0)
		(= plane global116)
		(if (proc1111_24 113)
			(super init: 3220)
		else
			(super init: 3262)
		)
		(elevSensor init:)
	)
)

(instance elevSensor of Feature
	(properties
		nsLeft 263
		nsTop 109
		nsRight 330
		nsBottom 180
	)

	(method (init)
		(super init:)
		(self setHotspot: 140)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(140
				(if (proc1111_24 113)
					(lightFlashing play:)
					(elevatorUp play:)
					(SetFlag 113)
				else
					(lightFlashing2 play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elevatorUp of VMDMovie
	(properties
		movieName 3202
		frameRate 15
		endPic 3262
	)
)

(instance lightFlashing2 of VMDMovie
	(properties
		movieName 3204
		frameRate 15
	)
)

(instance lightFlashing of VMDMovie
	(properties
		movieName 3203
		frameRate 15
	)
)

