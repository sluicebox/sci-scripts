;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use ExitArrow)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Game)
(use System)

(public
	rm620 0
)

(instance rm620 of Room
	(properties
		picture 620
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 53 146 142 155 149 148 39 137
					yourself:
				)
		)
		(super init: &rest)
		(gEgo setScaler: 0 x: 70 y: 144 setHeading: 90 init: normalize: 9120)
		(door init:)
		(farDoor init:)
		(lights init:)
		(toLeft init:)
		(gGame handsOff:)
		(self setScript: rmScript)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((< (gEgo x:) 84)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 115 148 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockScript of Script
	(properties)

	(method (doit)
		(if (and (== state 4) (== (gEgo cel:) 1))
			(sFx number: 998 loop: 1 play:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 134 147 self)
			)
			(2
				(gEgo normalize: 9120 setCycle: 0)
				(= cycles 2)
			)
			(3
				(gEgo view: 9126 loop: 3 cel: 0 x: 134 y: 147)
				(= ticks 30)
			)
			(4
				(gEgo setCycle: ForwardCounter 3 self)
			)
			(5
				(gEgo cel: 0)
				(= cycles 2)
			)
			(6
				(gMessager say: 1 4 1 0 self) ; "Knocking on the door you receive no response."
			)
			(7
				(= cycles 2)
			)
			(8
				(gCurRoom newRoom: 625)
			)
		)
	)
)

(instance door of Feature
	(properties
		noun 1
		nsLeft 113
		nsTop 16
		nsRight 163
		nsBottom 138
		sightAngle 360
		x 138
		y 77
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: knockScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lights of Feature
	(properties
		noun 3
		nsLeft 185
		nsTop 34
		nsRight 195
		nsBottom 59
		sightAngle 40
		x 190
		y 46
	)
)

(instance farDoor of Feature
	(properties
		noun 2
		nsLeft 203
		nsTop 18
		nsRight 239
		nsBottom 118
		sightAngle 40
		x 221
		y 68
	)
)

(instance toLeft of ExitArrow
	(properties
		nsBottom 145
		nsRight 79
		exitDir 4
	)
)

(instance sFx of Sound
	(properties)
)

