;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 385)
(include sci.sh)
(use Main)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use System)

(public
	rm385 0
)

(local
	local0
)

(instance rm385 of Room
	(properties
		picture 385
	)

	(method (init)
		(if (not (gPqFlags test: 100))
			(proc0_4 1)
		)
		(gGame handsOff:)
		(super init: &rest)
		(theDoor init:)
		(theWindow init:)
		(theSign init:)
		(if (gPqFlags test: 100)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 68 148 241 148 210 130 98 130
						yourself:
					)
			)
		)
		(gEgo
			view: 0
			setHeading: 0
			normalize: 0
			posn: 154 146
			setScaler: Scaler 86 69 147 132
			init:
		)
		(if (gPqFlags test: 100)
			(gGame handsOn:)
		else
			(self setScript: showIntScript)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(OneOf (gEgo view:) 0 1 2)
				(OneOf (gEgo cel:) 4 12)
			)
			(walkSound number: 975 loop: 1 play:)
		)
		(cond
			(script 0)
			((> (gEgo y:) 147)
				(self newRoom: 17) ; MapRoom
			)
		)
	)
)

(instance showIntScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 154 132 self)
			)
			(1
				(gCurRoom newRoom: 395)
			)
		)
	)
)

(instance theDoor of Feature
	(properties
		noun 2
		nsLeft 118
		nsTop 40
		nsRight 189
		nsBottom 126
		x 159
		y 45
	)

	(method (doVerb theVerb)
		(if (== theVerb 22) ; handgun
			(if local0
				((ScriptID 32 0) doit: 2 22 1 385) ; ShootHandgun, "Destroying City property is a crime, and most unbecoming to an officer! You're dismissed!"
			else
				(++ local0)
				(gMessager say: 2 22 0 1) ; "Holster your weapon! There are innocent citizens everywhere!"
			)
		)
	)
)

(instance theWindow of Feature
	(properties
		noun 1
		x 64
		y 62
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 62 10 77 10 76 103 62 107 yourself:)
		)
	)
)

(instance theSign of Feature
	(properties
		noun 3
		nsLeft 127
		nsTop 62
		nsRight 149
		nsBottom 90
		x 137
		y 76
	)
)

(instance walkSound of Sound
	(properties)
)

