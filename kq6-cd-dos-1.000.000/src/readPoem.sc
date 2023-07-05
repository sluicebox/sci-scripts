;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 97)
(include sci.sh)
(use Main)
(use System)

(public
	readPoem 0
)

(instance readPoem of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 97)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 30 5 0 0 self 907) ; "Alexander reads the love poem...."
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

