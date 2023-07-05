;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64933)
(include sci.sh)
(use Main)
(use System)

(class PseudoMouse of Code
	(properties
		prevDir 0
		cursorInc 2
		joyInc 5
		maxInc 20
		minInc 2
	)

	(method (handleEvent event &tmp eType eMsg eMod)
		(= eType (event type:))
		(= eMsg (event message:))
		(= eMod (event modifiers:))
		(if (& eType $0010) ; direction
			(= prevDir eMsg)
			(= cursorInc
				(if (& eType evKEYBOARD)
					(if (& eMod emSHIFT) minInc else maxInc)
				else
					joyInc
				)
			)
			(cond
				((& eType evKEYBOARD)
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

	(method (doit &tmp theX theY)
		(= theX (gLastEvent x:))
		(= theY (gLastEvent y:))
		(switch prevDir
			(1
				(-= theY cursorInc)
			)
			(2
				(+= theX cursorInc)
				(-= theY cursorInc)
			)
			(3
				(+= theX cursorInc)
			)
			(4
				(+= theX cursorInc)
				(+= theY cursorInc)
			)
			(5
				(+= theY cursorInc)
			)
			(6
				(-= theX cursorInc)
				(+= theY cursorInc)
			)
			(7
				(-= theX cursorInc)
			)
			(8
				(-= theX cursorInc)
				(-= theY cursorInc)
			)
		)
		(gGame setCursor: gTheCursor 1 theX theY)
	)
)

