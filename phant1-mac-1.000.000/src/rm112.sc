;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 112)
(include sci.sh)
(use Main)
(use n1111)
(use Str)
(use Print)
(use System)

(public
	rm112 0
)

(local
	local0
)

(instance rm112 of ScaryRoom
	(properties)

	(method (init &tmp temp0 temp1)
		(= temp0 (Str new:))
		(gEgo z: 1000 init:)
		(= local0 (Str new:))
		(self setScript: playScr)
	)
)

(instance playScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register
					((= temp0 (Print new:))
						font: gUserFont
						addText: {robot number to play?} 5 0
						addEdit: local0 5 10 10
						addButton: 1 {PLAY} 6 25
						addButton: 0 {DONE} 6 40
						init:
					)
				)
				(= cycles 2)
			)
			(1
				(if register
					(DoRobot (local0 asInteger:) 20 20)
				else
					(gGame quitGame:)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

