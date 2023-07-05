;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Extra)
(use Motion)
(use Game)
(use Actor)

(public
	rm74 0
)

(instance rm74 of Rm
	(properties
		picture 74
		horizon 116
		north 73
		west 75
	)

	(method (init)
		(Load rsVIEW 274)
		(self
			style:
				(switch gPrevRoomNum
					(north 7)
					(west 3)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 3 (proc0_17 175 (gEgo y:) 149))
			)
			(else
				(gEgo
					posn:
						(cond
							((<= (gEgo x:) 181) 234)
							((>= (gEgo x:) 235) 276)
							(else 249)
						)
						(+ horizon 2)
				)
			)
		)
		(gEgo init:)
		(proc0_1)
		(torchLight setPri: 4 init: stopUpd:)
		(if (>= global101 1)
			(torchLight setCycle: Fwd)
			(d1 setPri: 14 init:)
			(d2 setPri: 14 init:)
			(d3 setPri: 15 init:)
		)
		(light init:)
		(stalactite1 init:)
		(stalactite2 init:)
		(stalactite3 init:)
		(stalactite4 init:)
		(stalactite5 init:)
	)
)

(instance torchLight of Prop
	(properties
		x 146
		y 115
		description {torch}
		view 274
		loop 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(
				(or
					(MousedOn self event)
					(Said 'look,look/torch,candle,light,flame,fire')
				)
				(Print 74 0) ; "There is a single torch on the wall, illuminating this shadowy cave."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,cave]')
						(Print 74 1) ; "The farther you get from the light, the mustier it becomes."
					)
					((Said '/drip')
						(Print 74 2) ; "Brackish water drips slowly from the stalactites on the ceiling."
					)
				)
			)
			((Said 'get,get,get/torch')
				(Print 74 3) ; "The torch is too hot to touch."
			)
			(
				(and
					(== (event type:) evMOUSEBUTTON)
					(& (event modifiers:) emSHIFT)
					(== (OnControl PRIORITY (event x:) (event y:)) -32768)
				)
				(Print 74 4) ; "These rock formations were slowly created over thousands of years."
			)
			((Said '/stalactite,stalactite>')
				(cond
					((Said 'get,bend')
						(Print 74 5) ; "These are of no use to you, Sir Graham."
					)
					((Said 'look,look')
						(Print 74 4) ; "These rock formations were slowly created over thousands of years."
					)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance d1 of Extra
	(properties
		x 9
		y 81
		description {drip}
		view 274
		loop 2
		cycleType 1
		minPause 30
		maxPause 34
		minCycles 1
		maxCycles 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 74 2) ; "Brackish water drips slowly from the stalactites on the ceiling."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance d2 of Extra
	(properties
		x 87
		y 87
		description {drip}
		view 274
		loop 2
		cycleType 1
		minPause 20
		maxPause 24
		minCycles 1
		maxCycles 1
	)

	(method (doVerb theVerb)
		(d1 doVerb: theVerb &rest)
	)
)

(instance d3 of Extra
	(properties
		x 258
		y 62
		description {drip}
		view 274
		loop 2
		cycleType 1
		minPause 50
		maxPause 54
		minCycles 1
		maxCycles 1
	)

	(method (doVerb theVerb)
		(d1 doVerb: theVerb &rest)
	)
)

(instance light of NewFeature
	(properties
		x 245
		y 52
		noun '/light,sunlight'
		nsTop 30
		nsLeft 240
		nsBottom 74
		nsRight 251
		description {light}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {To the north, you can still see the light shining through the hole in the ceiling.}
	)
)

(instance stalactite1 of NewFeature
	(properties
		x 102
		y 36
		noun '/stalactite'
		nsTop 26
		nsLeft 46
		nsBottom 46
		nsRight 159
		description {stalactite}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These rock formations were slowly created over thousands of years.}
	)
)

(instance stalactite2 of NewFeature
	(properties
		x 87
		y 66
		noun '/stalactite'
		nsTop 46
		nsLeft 81
		nsBottom 87
		nsRight 93
		description {stalactite}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These rock formations were slowly created over thousands of years.}
	)
)

(instance stalactite3 of NewFeature
	(properties
		x 60
		y 57
		noun '/stalactite'
		nsTop 46
		nsLeft 56
		nsBottom 69
		nsRight 64
		description {stalactite}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These rock formations were slowly created over thousands of years.}
	)
)

(instance stalactite4 of NewFeature
	(properties
		x 10
		y 61
		noun '/stalactite'
		nsTop 41
		nsBottom 81
		nsRight 20
		description {stalactite}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These rock formations were slowly created over thousands of years.}
	)
)

(instance stalactite5 of NewFeature
	(properties
		x 119
		y 57
		noun '/stalactite'
		nsTop 46
		nsLeft 115
		nsBottom 68
		nsRight 124
		description {stalactite}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These rock formations were slowly created over thousands of years.}
	)
)

