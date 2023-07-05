;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 972)
(include sci.sh)
(use Motion)

(class MoveFwd of MoveTo
	(properties)

	(method (init param1 param2 param3)
		(super
			init:
				param1
				(+ (param1 x:) (SinMult (param1 heading:) param2))
				(- (param1 y:) (CosMult (param1 heading:) param2))
				(and (>= argc 3) param3)
		)
	)
)

