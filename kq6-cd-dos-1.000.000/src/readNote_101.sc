;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use System)

(public
	readNote 0
)

(instance readNote of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 101)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 29 5 0 0 self 907) ; "Alexander opens the letter. It is addressed to Alhazred from the Wizard Shadrack. It reads:"
			)
			(1
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

