;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1140)
(include sci.sh)
(use Main)
(use n1111)
(use Feature)
(use WalkieTalkie)
(use Actor)
(use System)

(public
	rm1140 0
)

(instance rm1140 of ScaryRoom
	(properties
		picture 1140
		south 1200
	)

	(method (init)
		(gEgo init: normalize: z: 1000 hide:)
		(stuff init:)
		(matches init: setHotspot: 4 3) ; Do, Move
		(handles init: setHotspot: 4 3) ; Do, Move
		(gGame handsOn:)
		(SetFlag 297)
		(WalkieTalkie showFrame: 162 0 54 -9 120)
		(super init: &rest)
		((ScriptID 0 14) init:) ; exitButt
	)

	(method (newRoom newRoomNumber)
		(gEgo z: 0)
		((ScriptID 0 14) dispose:) ; exitButt
		(ClearFlag 297)
		(super newRoom: newRoomNumber)
	)

	(method (notify)
		(gCurRoom newRoom: 1200)
	)
)

(instance matches of View
	(properties
		x 177
		y 61
		priority 100
		fixPriority 1
		view 164
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetMatches)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stuff of View
	(properties
		x 160
		y 83
		view 1141
	)
)

(instance handles of Feature
	(properties
		nsLeft 197
		nsTop 57
		nsRight 223
		nsBottom 71
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 1200)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sGetMatches of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 2)
					(DoRobot 162 54 -9 gEgo 120 1)
				)
				(1
					(matches dispose:)
				)
				(2
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(= global115 0)
		(gCurRoom newRoom: 1200)
		(super dispose: &rest)
	)
)

