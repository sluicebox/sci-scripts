;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use System)

(public
	egoCalm 0
)

(instance egoCalm of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 150)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HighPrint 150 0) ; "Confidently, you cast the Calm spell."
				(EgoDead 150 1 80 {You should have studied harder} 82 521 1 4) ; "Why, how cute! You cast the Calm spell, and the monster visibly relaxed. Why, now it's calmly and relaxedly ripping you to shreds and eating you."
			)
		)
	)
)

