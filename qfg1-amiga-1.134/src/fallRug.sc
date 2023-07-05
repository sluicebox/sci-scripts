;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	fallRug 0
)

(instance fallRug of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 190)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (gEgo loop:) 3)
					(gEgo setLoop: 1)
				)
				(= cycles 5)
			)
			(1
				(gEgo setLoop: 2)
				(= cycles 5)
			)
			(2
				(gEgo
					view: 537
					setLoop: 0
					cel: 0
					setPri: 9
					yStep: 6
					posn: (gEgo x:) (+ (gEgo y:) 3)
				)
				((ScriptID 94 12) setCel: 1) ; rug
				(= cycles 5)
			)
			(3
				((ScriptID 94 12) dispose:) ; rug
				((ScriptID 94 0) notify: 8) ; rm94
				(gEgo
					setPri: 9
					cycleSpeed: 5
					posn: (gEgo x:) (+ (gEgo y:) 3)
					setCycle: End self
				)
			)
			(4
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 5))
				(= cycles 1)
			)
			(5
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 8))
				(= cycles 1)
			)
			(6
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 12))
				(= cycles 1)
			)
			(7
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 13))
				(= cycles 1)
			)
			(8
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 13))
				(= cycles 1)
			)
			(9
				(if ((ScriptID 94 0) notify: 0) ; rm94
					((ScriptID 94 1) setScript: (ScriptID 94 5)) ; archer1, archer1Start
					((ScriptID 94 2) setScript: (ScriptID 94 6)) ; archer2, archer2Start
					((ScriptID 94 3) setScript: (ScriptID 94 7)) ; archer3, archer3Start
					((ScriptID 94 4) setScript: (ScriptID 94 8)) ; archer4, archer4Start
				)
				(= cycles 20)
			)
			(10
				(EgoDead ; "There is a small sign which reads "Booby Trap". You are now in a pitiful situation as you hear the brigands approach to see the booby they've caught. You think to yourself, "If it looks like a trap, and it feels like a trap, then maybe it IS a trap"."
					190
					0
					82
					536
					0
					2
					80
					{The old "rug over the pit" trick.}
				)
				(self dispose:)
			)
		)
	)
)

