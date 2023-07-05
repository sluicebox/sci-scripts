;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 186)
(include sci.sh)
(use Main)
(use System)

(public
	fallBridge 0
)

(instance fallBridge of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 186)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: 0)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 3
					setLoop: 0
					setCel: 0
					illegalBits: 0
					setPri: 7
					posn: (+ (gEgo x:) 7) (+ (gEgo y:) 1)
				)
				((ScriptID 94 9) setCel: 1) ; unSafeBridge
				(= cycles 3)
			)
			(2
				(gEgo setCel: 1 posn: (+ (gEgo x:) 7) (+ (gEgo y:) 0))
				(= cycles 3)
			)
			(3
				(gEgo setCel: 2 posn: (+ (gEgo x:) 12) (+ (gEgo y:) 6))
				(= cycles 3)
			)
			(4
				(gEgo setCel: 3 posn: (+ (gEgo x:) 15) (+ (gEgo y:) 0))
				(= cycles 3)
			)
			(5
				(gEgo setCel: 4 posn: (+ (gEgo x:) 1) (+ (gEgo y:) 0))
				(= cycles 3)
			)
			(6
				(gEgo posn: (+ (gEgo x:) 2) (+ (gEgo y:) 5))
				(= cycles 3)
			)
			(7
				(gEgo posn: (+ (gEgo x:) 0) (+ (gEgo y:) 6))
				(= cycles 3)
			)
			(8
				(gEgo posn: (+ (gEgo x:) 0) (+ (gEgo y:) 7))
				(= cycles 3)
			)
			(9
				(gEgo hide:)
				((ScriptID 94 9) setCel: 0) ; unSafeBridge
				(if ((ScriptID 94 0) notify: 0) ; rm94
					((ScriptID 94 1) setScript: (ScriptID 94 5)) ; archer1, archer1Start
					((ScriptID 94 2) setScript: (ScriptID 94 6)) ; archer2, archer2Start
					((ScriptID 94 3) setScript: (ScriptID 94 7)) ; archer3, archer3Start
					((ScriptID 94 4) setScript: (ScriptID 94 8)) ; archer4, archer4Start
				)
				(= cycles 20)
			)
			(10
				(EgoDead 186 0 82 536 0 2 80 {I wasn't ready.}) ; "I score that about a 3. Those diving lessons were a complete waste. Maybe you should have taken up bowling."
				(self dispose:)
			)
		)
	)
)

