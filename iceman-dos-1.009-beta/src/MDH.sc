;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 979)
(include sci.sh)
(use Interface)
(use System)

(instance COn of Code
	(properties)

	(method (doit who)
		(MousedOn who &rest)
	)
)

(class MDH of EventHandler
	(properties
		x 0
		y 0
		modifiers 0
		targetObj 0
		shiftParser 0
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(= x (event x:))
		(= y (event y:))
		(= modifiers (event modifiers:))
		(if (& modifiers $000c) ; emALT | emCTRL
			(super handleEvent: event)
		else
			(for
				((= temp0 (FirstNode elements)))
				(and temp0 (= targetObj (NodeValue temp0)))
				((= temp0 (NextNode temp0)))
				
				(if
					(= targetObj
						(cond
							((targetObj isKindOf: Collect)
								(targetObj firstTrue: #perform COn event)
							)
							((MousedOn targetObj event) targetObj)
						)
					)
					(if (& modifiers emSHIFT)
						(event type: evSAID)
						(shiftParser doit: targetObj event)
						(targetObj handleEvent: event)
						(event type: evMOUSEBUTTON)
						(event claimed:)
						(return)
					)
					(super handleEvent: event)
					(break)
				)
			)
			(if (== targetObj 0)
				(super handleEvent: event)
			)
		)
	)
)

