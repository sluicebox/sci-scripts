;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 933)
(include sci.sh)
(use Main)
(use System)

(class PseudoMouse of Code
	(properties
		cursorInc 2
		minInc 2
		maxInc 20
		prevDir 0
		joyInc 5
	)

	(method (handleEvent event)
		(if (and (gUser canInput:) (& (event type:) $0040)) ; direction
			(= prevDir
				(if (or (not gTheIconBar) (!= ((gTheIconBar curIcon:) message:) 1))
					(= prevDir (event message:))
				else
					(return)
				)
			)
			(= cursorInc
				(if (& (event type:) evKEYBOARD)
					(if (& (event modifiers:) emSHIFT) minInc else maxInc)
				else
					joyInc
				)
			)
			(cond
				((& (event type:) evKEYBOARD)
					(if prevDir
						(self doit:)
					else
						(event claimed: 0)
						(return)
					)
				)
				(prevDir
					(self start:)
				)
				(else
					(self stop:)
				)
			)
			(event claimed: 1)
			(return)
		)
	)

	(method (start dir)
		(if argc
			(= prevDir dir)
		)
		(gTheDoits add: self)
	)

	(method (stop)
		(= prevDir 0)
		(gTheDoits delete: self)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if (IsObject gLastEvent)
			(= temp0 (gLastEvent x:))
			(= temp1 (gLastEvent y:))
		)
		(switch prevDir
			(1
				(-= temp1 cursorInc)
			)
			(2
				(+= temp0 cursorInc)
				(-= temp1 cursorInc)
			)
			(3
				(+= temp0 cursorInc)
			)
			(4
				(+= temp0 cursorInc)
				(+= temp1 cursorInc)
			)
			(5
				(+= temp1 cursorInc)
			)
			(6
				(-= temp0 cursorInc)
				(+= temp1 cursorInc)
			)
			(7
				(-= temp0 cursorInc)
			)
			(8
				(-= temp0 cursorInc)
				(-= temp1 cursorInc)
			)
		)
		(gGame setCursor: gTheCursor 1 temp0 temp1)
	)
)

