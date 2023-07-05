;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 391)
(include sci.sh)
(use Main)
(use Interface)
(use Rev)
(use Motion)
(use System)

(public
	egoDownLadderScript 0
	captainfallsScript 1
)

(instance egoDownLadderScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setScript: 0
					view: 238
					posn: 298 42
					setLoop: 0
					heading: 0
					setCycle: Rev
					setMotion: MoveTo 298 91 self
				)
			)
			(1
				(gEgo
					observeControl: -32768
					view: 232
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 253 102 self
				)
			)
			(2
				(HandsOn)
				(gEgo setScript: (ScriptID 25 3)) ; egosControlScript
			)
		)
	)
)

(instance captainfallsScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setScript: egoDownLadderScript self)
			)
			(1
				((ScriptID 25 1) ; captain
					view: 425
					init:
					illegalBits: 0
					posn: 302 87
					setLoop: 0
					heading: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(Print 391 0) ; "The captain falls!"
				(Print 391 1) ; "You call for a medic."
				((ScriptID 25 1) dispose:) ; captain
				(gCast eachElementDo: #hide)
				(= temp0 gAddToPics)
				(= gAddToPics 0)
				(gCurRoom drawPic: 101)
				(Print 391 2) ; "The Captain has sustained a serious concussion."
				(Print 391 3) ; "The Blackhawk's medical officer and assistant perform emergency medical treatment."
				(Print 391 4) ; "After stabilizing him, they move him to his cabin."
				(Print 391 5) ; "Time is running out as the Russian war ship continues to bear down on your position."
				(Print 391 6) ; "Being the second in command, the fate of the USS Blackhawk rests on your shoulders."
				(Print 391 7) ; "Your actions and decisions will determine the outcome."
				(gCurRoom drawPic: (gCurRoom picture:))
				(= gAddToPics temp0)
				(gAddToPics doit:)
				(gCast eachElementDo: #show)
				(HandsOn)
				(gEgo
					view: 232
					setCycle: Walk
					posn: 204 111
					setLoop: -1
					loop: 1
					illegalBits: -32768
				)
				(gEgo setScript: (ScriptID 25 3)) ; egosControlScript
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 391)
	)
)

