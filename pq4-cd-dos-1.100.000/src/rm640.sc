;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use ExitArrow)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use System)

(public
	rm640 0
)

(instance rm640 of Room
	(properties
		picture 640
	)

	(method (init)
		(gPqFlags set: 119)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 135 103 137 114 159 145 169 145 142 113 139 103 136 103
					yourself:
				)
		)
		(gEgo view: 0)
		(super init: &rest)
		(mens init:)
		(door init:)
		(hallway init:)
		(exitMens init:)
		(gEgo
			posn: 158 141
			setHeading: 0
			setScaler: Scaler 120 75 147 102
			init:
			normalize: 0
		)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((> (gEgo y:) 143)
				(gCurRoom newRoom: 610)
			)
			((< (gEgo y:) 130)
				(gCurRoom setScript: leaveMens)
			)
		)
	)
)

(instance mens of Feature
	(properties
		noun 2
		nsLeft 138
		nsTop 21
		nsRight 154
		nsBottom 113
		x 146
		y 67
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: intoMensScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hallway of Feature
	(properties
		noun 1
		nsLeft 104
		nsRight 215
		nsBottom 147
		sightAngle 40
		x 159
		y 20
	)
)

(instance door of Feature
	(properties
		noun 3
		nsLeft 156
		nsTop 8
		nsRight 169
		nsBottom 115
		x 162
		y 61
	)
)

(instance intoMensScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 153 127)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance exitMens of ExitArrow
	(properties
		nsTop 136
		nsLeft 133
		nsBottom 160
		nsRight 211
		exitDir 3
	)
)

(instance leaveMens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 4 0 0 self) ; "You don't want to go down there, Carey. It'll burn your eyes."
			)
			(1
				(gEgo setMotion: MoveTo 158 141 self)
			)
			(2
				(gEgo setHeading: 315 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

