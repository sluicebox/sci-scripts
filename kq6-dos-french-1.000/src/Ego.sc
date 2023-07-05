;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 988)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
(use Actor)

(class Ego of Actor
	(properties
		signal 8192
		edgeHit 0
	)

	(method (init)
		(super init:)
		(if (not cycler)
			(self setCycle: Walk)
		)
	)

	(method (facingMe)
		(return 1)
	)

	(method (doit)
		(super doit:)
		(= edgeHit
			(cond
				((<= x 0) 4)
				((>= x 319) 2)
				((>= y 189) 3)
				((<= y (gCurRoom horizon:)) 1)
				(else 0)
			)
		)
	)

	(method (get what &tmp i)
		(for ((= i 0)) (< i argc) ((++ i))
			((gInventory at: [what i]) moveTo: self)
		)
	)

	(method (put what recipient &tmp theItem)
		(if (self has: what)
			((= theItem (gInventory at: what))
				moveTo: (if (== argc 1) -1 else recipient)
			)
			(if (and gTheIconBar (== (gTheIconBar curInvIcon:) theItem))
				(gTheIconBar
					curInvIcon: 0
					disable: ((gTheIconBar useIconItem:) cursor: 999 yourself:)
				)
			)
		)
	)

	(method (has what &tmp theItem)
		(if (= theItem (gInventory at: what))
			(theItem ownedBy: self)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(= temp3 0)
		(= temp1 (event type:))
		(= temp2 (event message:))
		(cond
			((and script (script handleEvent: event)) 1)
			((& temp1 $0040) ; direction
				(if (and (== (= temp0 temp2) JOY_NULL) (& temp1 evKEYBOARD))
					(event claimed:)
					(return)
				)
				(if
					(and
						(& temp1 evKEYBOARD)
						(== temp0 (gUser prevDir:))
						(IsObject mover)
					)
					(= temp0 JOY_NULL)
				)
				(gUser prevDir: temp0)
				(self setDirection: temp0)
				(= temp3 1)
			)
			((& temp1 evVERB)
				(if (& temp1 evMOVE)
					(switch gUseObstacles
						(0
							(self
								setMotion: MoveTo (event x:) (+ (event y:) z)
							)
						)
						(1
							(self
								setMotion:
									PolyPath
									(event x:)
									(+ (event y:) z)
							)
						)
						(2
							(self
								setMotion:
									PolyPath
									(event x:)
									(+ (event y:) z)
									0
									0
							)
						)
					)
					(gUser prevDir: 0)
					(= temp3 1)
				else
					(= temp3 (super handleEvent: event))
				)
			)
			(else
				(= temp3 (super handleEvent: event))
			)
		)
		(return temp3)
	)
)

