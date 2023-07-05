;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 191)
(include sci.sh)
(use Main)
(use System)

(public
	fallRugs 0
)

(instance fallRugs of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 191)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: 1)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 3
					setLoop: 1
					setCel: 0
					illegalBits: 0
					setPri: 10
					posn: (- (gEgo x:) 7) (+ (gEgo y:) 1)
				)
				((ScriptID 94 13) setCel: 1) ; rugs
				(= cycles 3)
			)
			(2
				(gEgo setCel: 1 posn: (- (gEgo x:) 7) (+ (gEgo y:) 0))
				(= cycles 3)
			)
			(3
				(gEgo setCel: 2 posn: (- (gEgo x:) 10) (+ (gEgo y:) 6))
				(= cycles 3)
			)
			(4
				((ScriptID 94 12) setCel: 1) ; rug
				(gEgo setCel: 3 posn: (- (gEgo x:) 13) (+ (gEgo y:) 0))
				(= cycles 3)
			)
			(5
				(gEgo setCel: 4 posn: (- (gEgo x:) 0) (+ (gEgo y:) 0))
				(= cycles 3)
			)
			(6
				((ScriptID 94 12) dispose:) ; rug
				(gEgo posn: (- (gEgo x:) 0) (+ (gEgo y:) 5))
				(= cycles 3)
			)
			(7
				(gEgo posn: (- (gEgo x:) 0) (+ (gEgo y:) 6))
				(= cycles 3)
			)
			(8
				(gEgo posn: (- (gEgo x:) 0) (+ (gEgo y:) 7))
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
				(EgoDead 191 0 82 536 0 2 80 {A travelling man.}) ; "You seem to be having a rugged time of it. You've had a terrible ca-tapestry."
				(self dispose:)
			)
		)
	)
)

