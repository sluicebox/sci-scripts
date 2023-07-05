;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 425)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use System)

(public
	rm425 0
)

(instance rm425 of LLRoom
	(properties
		picture 425
		north 435
	)

	(method (init)
		(LoadMany rsSOUND 191 192)
		(gEgo init: normalize: 572 edgeHit: 0)
		(switch gPrevRoomNum
			(north 0)
			(200
				(gEgo x: (limo approachX:) y: (+ (limo approachY:) 10) hide:)
				(HandsOff)
				(self setScript: sFromLimo)
			)
			(else
				(gEgo posn: 160 160)
				(HandsOn)
			)
		)
		(super init:)
		(door init:)
		(limo init: approachVerbs: 3) ; Do
		(steinSign init:)
		(steinLabs init:)
		(gynoSign init:)
		(gynoBuilding init:)
		(woodwindSign init:)
		(woodwindBuilding init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 184 0 185 153 12 153 12 156 305 156 305 153 195 153 195 0 319 0 319 189 0 189
					yourself:
				)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 425 0) ; "You are outside the F.B.I.'s office building, which is cleverly disguised as a block of normal storefront businesses. Your limousine is waiting for you at the curb, exactly as Desmond promised."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sLimo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 150)
			)
			(1
				(soundFX number: 191 play:)
				(= ticks 50)
			)
			(2
				(= ticks 60)
			)
			(3
				(gEgo
					setCycle: 0
					setCel: (gEgo cel:)
					setLoop: (gEgo loop:)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(4
				(gEgo hide:)
				(= ticks 60)
			)
			(5
				(soundFX number: 192 play:)
				(= ticks 100)
			)
			(6
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance sFromLimo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(soundFX number: 191 play:)
				(= ticks 50)
			)
			(2
				(= ticks 60)
			)
			(3
				(gEgo
					show:
					setLoop: 3
					setCel: (gEgo cel:)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 10) self
				)
			)
			(4
				(gEgo normalize: 572 setHeading: 180 self)
			)
			(5
				(= ticks 60)
			)
			(6
				(soundFX number: 192 play:)
				(= ticks 100)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance door of Door
	(properties
		x 193
		y 151
		description {the door}
		approachX 188
		approachY 156
		view 425
		entranceTo 435
		moveToX 188
		moveToY 150
		enterType 0
		exitType 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 425 1) ; "This door leads back into the F.B... oops! This door leads to "Stein Labs!""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance limo of Feature
	(properties
		x 72
		y 158
		nsTop 146
		nsLeft 3
		nsBottom 171
		nsRight 161
		description {your limousine}
		sightAngle 40
		approachX 72
		approachY 156
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 425 2) ; "Your limousine awaits you."
			)
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sLimo)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance steinSign of Feature
	(properties
		x 133
		y 148
		z 27
		nsTop 108
		nsLeft 101
		nsBottom 134
		nsRight 166
		description {the Stein Labs sign}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 425 3) ; "The large sign identifies the F.B.I. labs as "Stein Labs--We'll Be Frank With You.""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance steinLabs of Feature
	(properties
		x 165
		y 93
		nsTop 37
		nsLeft 92
		nsBottom 150
		nsRight 238
		description {Stein Laboratories}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 425 4) ; "Don't you just love an F.B.I. with a sense of humor?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance gynoSign of Feature
	(properties
		x 63
		y 146
		z 47
		nsTop 76
		nsLeft 55
		nsBottom 123
		nsRight 71
		description {the GynoMan sign}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 425 5) ; "Dr. Phil Hopian's office is cleverly disguised as "GynoMan.""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance gynoBuilding of Feature
	(properties
		x 45
		y 102
		nsTop 58
		nsBottom 146
		nsRight 91
		description {the GynoMan building}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 425 6) ; "You wonder what sort of offices are on the upper floors of this building, above the office of Dr. Phil Hopian."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance woodwindBuilding of Feature
	(properties
		x 278
		y 98
		nsTop 45
		nsLeft 238
		nsBottom 151
		nsRight 319
		description {the Woodwind Repair Shop building}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 425 7) ; "The Woodwind Repair Shop is an unusual cover for an F.B.I. office."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance woodwindSign of Feature
	(properties
		x 286
		y 151
		z 73
		nsTop 66
		nsLeft 254
		nsBottom 91
		nsRight 319
		description {the Woodwind Repair Shop sign}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 425 8) ; "The Woodwind Repair Shop has an attractive sign out front."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

