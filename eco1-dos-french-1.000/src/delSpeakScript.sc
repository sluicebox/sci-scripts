;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 127)
(include sci.sh)
(use Sound)
(use System)

(public
	delSpeakScript 0
)

(instance delSpeakScript of Script
	(properties)

	(method (dispose)
		(delSound dispose:)
		(= register 0)
		(super dispose: &rest)
		(DisposeScript 127)
	)

	(method (init)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(delSound
					number: (+ register (Random 0 1))
					loop: 1
					flags: 1
					play: self
				)
			)
			(2
				(= state -1)
				(= seconds
					(switch register
						(918
							(Random 10 16)
						)
						(920
							(Random 4 7)
						)
						(else
							(Random 6 12)
						)
					)
				)
			)
		)
	)
)

(instance delSound of Sound
	(properties)
)

