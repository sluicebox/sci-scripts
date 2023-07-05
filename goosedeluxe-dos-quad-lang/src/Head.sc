;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 404)
(include sci.sh)
(use Main)
(use Actor)

(class Head of Prop
	(properties
		syncMouth 0
		client 0
		cycleCnt 0
		moveHead 0
		height 0
	)

	(method (init param1 param2)
		(= view (param1 view:))
		(self
			client: param1
			height: param2
			ignoreActors: 1
			posn: (param1 x:) (param1 y:) (- (+ (param1 z:) param2) 1)
		)
		(super init: &rest)
	)

	(method (doit)
		(if moveHead
			(self look:)
			(= x (client x:))
			(= y (client y:))
			(= z
				(-
					(+
						(client z:)
						(CelHigh (client view:) (client loop:) (client cel:))
					)
					1
				)
			)
		)
		(super doit:)
	)

	(method (look)
		(if (>= (client loop:) 13)
			(if (not (gCurRoom script:))
				(= loop (+ 4 (* (client cel:) 2) (client lookingDir:)))
			)
		else
			(= loop (+ 4 (* (client loop:) 2) (client lookingDir:)))
		)
	)

	(method (onMe)
		(if (!= gTheCursor gNormalCursor)
			(return 0)
		else
			(super onMe: &rest)
		)
	)
)

