;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 276)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	egoClimbsUp 0
)

(instance egoClimbsUp of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 276)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 6
					illegalBits: 0
					setMotion: MoveTo 272 104 self
				)
			)
			(1
				(gEgo setLoop: 3)
				(= cycles 4)
			)
			(2
				(HighPrint 276 0) ; "You find a good purchase on the rocks to climb."
				(gEgo view: 517 setLoop: 0 setCel: 1 posn: 282 102)
				(= cycles 4)
			)
			(3
				(gEgo setCel: 2 posn: 285 103)
				(= cycles 4)
			)
			(4
				(gEgo setCel: 1 posn: 291 84)
				(= cycles 4)
			)
			(5
				(gEgo setCel: 2 posn: 293 83)
				(= cycles 4)
			)
			(6
				(gEgo setCel: 3 posn: 294 65)
				(= cycles 4)
			)
			(7
				(= cycles 1)
			)
			(8
				(gEgo setCel: 0 posn: 293 66)
				(= cycles 4)
			)
			(9
				(gEgo setLoop: 1 setCel: 0 posn: 282 34)
				(= cycles 6)
			)
			(10
				(gEgo setCel: 1 posn: 282 40)
				(= cycles 6)
			)
			(11
				(gEgo setCel: 2 posn: 281 43)
				(= cycles 6)
			)
			(12
				(gEgo setCel: 3 setPri: 5 posn: 284 40)
				(= cycles 4)
			)
			(13
				(gEgo setCel: 4 posn: 285 48)
				(= cycles 3)
			)
			(14
				(gEgo setCel: 4 posn: 285 56)
				(= cycles 3)
			)
			(15
				(gEgo setCel: 4 posn: 285 62)
				(= cycles 3)
			)
			(16
				(gEgo setCel: 4 posn: 285 68)
				(= cycles 3)
			)
			(17
				(= global332 (= global333 0))
				(gCurRoom newRoom: 94)
			)
		)
	)
)

