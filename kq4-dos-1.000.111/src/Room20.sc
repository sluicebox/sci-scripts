;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	Room20 0
)

(instance Room20 of Rm
	(properties
		picture 20
	)

	(method (init)
		(= north 14)
		(= south 26)
		(= east 21)
		(= west 19)
		(= horizon 68)
		(= gIndoors 0)
		(if gNight
			(= picture 120)
		)
		(gEgo view: 2 init:)
		(super init:)
		(self setRegions: 506 518) ; meadReg, regUnicorn
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				(== (event type:) evSAID)
				(or (Said 'look/room') (Said 'look[<around][/!*]'))
			)
			(Print 20 0) ; "A green meadowland, filled with beautiful wildflowers, surrounds you."
		)
	)
)

