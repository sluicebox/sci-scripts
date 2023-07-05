;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 79)
(include sci.sh)
(use Motion)

(class TryToMoveTo of Motion
	(properties
		distance 20
		lastDistance 0
	)

	(method (init theClient args &tmp argix)
		(if (> argc 0)
			(= client theClient)
			(= caller 0)
			(-- argc)
			(= argix 0)
			(if (IsObject [args 0])
				(= x ([args argix] x:))
				(= y ([args argix] y:))
			else
				(= x [args argix])
				(= y [args (++ argix)])
			)
			(if (<= (++ argix) argc)
				(= distance [args argix])
			)
			(if (<= (++ argix) argc)
				(= caller [args argix])
			)
			(super init: client x y caller)
		else
			(super init:)
		)
		(= lastDistance 32767)
	)

	(method (onTarget &tmp thisDistance rc)
		(= rc
			(or
				(and (== (client x:) x) (== (client y:) y))
				(and
					(<= (= thisDistance (client distanceTo: self)) distance)
					(>= thisDistance lastDistance)
				)
			)
		)
		(= lastDistance thisDistance)
		(return rc)
	)

	(method (doit &tmp [temp0 2])
		(if (self onTarget:)
			(self moveDone:)
		else
			(super doit:)
		)
	)
)

