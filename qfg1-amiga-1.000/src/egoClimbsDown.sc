;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 275)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	egoClimbsDown 0
)

(instance egoClimbsDown of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 275)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 517
					setLoop: 0
					setCel: 0
					setPri: 6
					illegalBits: 0
					posn: 293 67
				)
				(= cycles 4)
			)
			(1
				(gEgo setCel: 2 posn: 292 82)
				(= cycles 4)
			)
			(2
				(gEgo setCel: 0 posn: 289 96)
				(= cycles 4)
			)
			(3
				(gEgo setCel: 2 posn: 286 109)
				(= cycles 4)
			)
			(4
				(gEgo view: 0 setLoop: 3 setCel: 0 posn: 275 109)
				(= cycles 4)
			)
			(5
				(NormalEgo)
				(gEgo
					loop: 3
					illegalBits: 0
					setPri: 6
					setMotion: MoveTo 248 105 self
				)
			)
			(6
				((ScriptID 93 0) notify: 0) ; rm93
				(NormalEgo)
				(gEgo illegalBits: $9000)
				(HandsOn)
			)
		)
	)
)

