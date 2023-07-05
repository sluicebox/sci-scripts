;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 315)
(include sci.sh)
(use Motion)

(class Zero of Motion
	(properties)

	(method (init)
		(super init: &rest)
	)

	(method (doit)
		(if (not (client moveSpeed:))
			(return)
		)
		(super doit: &rest)
	)

	(method (onTarget)
		(return
			(and
				(<= (Abs (- (client x:) x)) (client xStep:))
				(<= (Abs (- (client y:) y)) (client yStep:))
			)
		)
	)
)

