;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 188)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	egoTripsNorth 0
)

(instance egoTripsNorth of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 188)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 536
					setLoop: 0
					cel: 0
					setPri: 3
					cycleSpeed: 0
					illegalBits: 0
					ignoreActors:
					setCycle: End
					setMotion: MoveTo (- (gEgo x:) 3) (+ (gEgo y:) 2) self
				)
			)
			(1
				((ScriptID 94 10) ; antwerp
					view: 590
					setLoop: 2
					setCel: 2
					setPri: 4
					illegalBits: 0
					ignoreActors:
					ignoreHorizon:
					x: (+ (gEgo x:) 3)
					y: 20
					yStep: 4
					init:
				)
				((ScriptID 94 10) ; antwerp
					setMotion:
						MoveTo
						((ScriptID 94 10) x:) ; antwerp
						(- (gEgo y:) 8)
						self
				)
			)
			(2
				((ScriptID 94 10) moveSpeed: 1 cycleSpeed: 1 setCycle: Fwd) ; antwerp
				(= cycles 20)
			)
			(3
				(if ((ScriptID 94 0) notify: 0) ; rm94
					((ScriptID 94 1) setScript: (ScriptID 94 5)) ; archer1, archer1Start
					((ScriptID 94 2) setScript: (ScriptID 94 6)) ; archer2, archer2Start
					((ScriptID 94 3) setScript: (ScriptID 94 7)) ; archer3, archer3Start
					((ScriptID 94 4) setScript: (ScriptID 94 8)) ; archer4, archer4Start
				)
				(= cycles 20)
			)
			(4
				(EgoDead 188 0 82 536 0 6 80 {This is a ridiculous way to die}) ; "How embarrassing, to get this far and then fail to see the trip rope. How did they get that Antwerp up there?"
				(self dispose:)
			)
		)
	)
)

