;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 408)
(include sci.sh)
(use Main)
(use rLab)
(use n402)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	rm408 0
)

(instance rm408 of LabRoom
	(properties
		north 400
		south 400
	)

	(method (init)
		(proc402_0)
		(super init: &rest)
		(if (== ((gInventory at: 43) owner:) 408) ; shield
			(theShield init:)
		)
		(gCurRoom setScript: (ScriptID 30 1)) ; walkIn
		((ScriptID 30 7) addToPic:) ; topDoor
		((ScriptID 30 0) initCrypt: 2) ; rLab
	)

	(method (notify)
		((ScriptID 30 7) addToPic:) ; topDoor
		((ScriptID 30 3) show:) ; theTorch
	)
)

(instance theShield of View
	(properties
		x 66
		y 150
		z 40
		noun 15
		modNum 400
		view 400
		loop 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: getShield)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance getShield of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 84 149 self)
			)
			(1
				(theShield hide:)
				(gEgo
					normal: 0
					view: 401
					setLoop: 0
					posn: 75 152
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gMessager say: 15 5 0 1 self 400) ; "Alexander takes the shield from the wall."
			)
			(3
				(gGame givePoints: 1)
				(theShield dispose:)
				(gEgo posn: 84 149 get: 43 reset: 1) ; shield
				(= cycles 2)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

