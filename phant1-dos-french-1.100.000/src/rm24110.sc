;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24110)
(include sci.sh)
(use Main)
(use n1111)
(use WalkieTalkie)
(use Actor)
(use System)

(public
	rm24110 0
)

(local
	local0
)

(instance rm24110 of ScaryRoom
	(properties
		picture 24470
	)

	(method (notify)
		(proc1111_6)
		(gCurRoom newRoom: 24100)
	)

	(method (init)
		(proc1111_6)
		(super init: &rest)
		(SetFlag 104)
		(if (not (IsFlag 165))
			(nail init: setHotspot: 4 3 11 setPri: 20) ; Do, Move, invHammer
		)
		((ScriptID 0 14) init:) ; exitButt
		(gEgo init: posn: 0 1000)
		(SetFlag 297)
		(WalkieTalkie showFrame: 3430 1 -26 -11)
		(gGame handsOn:)
		(gUser canControl: 0)
	)

	(method (newRoom newRoomNumber)
		(ClearFlag 297)
		(super newRoom: newRoomNumber)
	)
)

(instance reachForNail of Script
	(properties)

	(method (dispose)
		((ScriptID 0 14) init:) ; exitButt
		(WalkieTalkie showFrame: 3430 1 -26 -11)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					((ScriptID 0 14) dispose:) ; exitButt
					(proc1111_6)
					(proc1111_7 3430 -26 -11 gEgo 25 1)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance pullNail of Script
	(properties)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(gEgo get: 2) ; invNail
			(SetFlag 165)
			(nail dispose:)
			(= global115 0)
			(gCurRoom newRoom: 24100)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(Load rsVIEW 9651)
					(Load rsVIEW 9652)
					(gGame handsOff:)
					((ScriptID 0 14) dispose:) ; exitButt
					(SetFlag 165)
					(proc1111_6)
					(proc1111_7 3442 -25 -7 gEgo -1 1)
				)
				(1
					(nail dispose:)
				)
				(2
					(gEgo get: 2) ; invNail
					(gCurRoom newRoom: 24100)
					(self dispose:)
				)
			)
		)
	)
)

(instance nail of View
	(properties
		nsLeft 78
		nsTop 104
		nsRight 88
		nsBottom 114
		x 93
		y 113
		view 24471
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: reachForNail)
			)
			(11 ; invHammer
				(gCurRoom setScript: pullNail)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

