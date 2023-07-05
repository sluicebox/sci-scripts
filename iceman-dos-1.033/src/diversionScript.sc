;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 337)
(include sci.sh)
(use Interface)
(use System)

(public
	diversionScript 0
)

(instance diversionScript of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'talk')
				(switch state
					(0
						(Print 337 0) ; "Looks like you've got your hands full, Johnny."
					)
					(1
						(Print 337 1) ; "Looks like we're going to have to create a diversion."
					)
					(2
						(Print 337 2) ; "You'd better get going, you've got a big mission ahead of you."
					)
					(else
						(Print 337 3) ; "Get going! Now!"
					)
				)
				(= cycles 1)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 337)
	)
)

