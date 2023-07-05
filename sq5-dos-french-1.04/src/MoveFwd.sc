;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 951)
(include sci.sh)
(use PolyPath)

(class MoveFwd of PolyPath
	(properties)

	(method (init actor dist toCall)
		(if argc
			(super
				init:
					actor
					(+ (actor x:) (SinMult (actor heading:) dist))
					(- (actor y:) (CosMult (actor heading:) dist))
					(and (>= argc 3) toCall)
			)
		else
			(super init:)
		)
	)
)

