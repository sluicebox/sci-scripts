;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 860)
(include sci.sh)
(use Main)
(use Feature)
(use Actor)
(use System)

(class FairFeature of Feature
	(properties)

	(method (onMe param1 &tmp [temp0 2])
		(return
			(if
				(or
					(OneOf (param1 message:) 2 5)
					(and (> (gEgo y:) 100) (> y 100))
					(and (< (gEgo y:) 95) (< y 95))
				)
				(super onMe: param1)
			else
				0
			)
		)
	)
)

(class FairActor of Actor
	(properties)

	(method (onMe param1 &tmp [temp0 2])
		(return
			(if
				(or
					(OneOf (param1 message:) 2 5)
					(and (> (gEgo y:) 100) (> y 100))
					(and (< (gEgo y:) 95) (< y 95))
				)
				(super onMe: param1)
			else
				0
			)
		)
	)
)

(class FairProp of Prop
	(properties)

	(method (onMe param1 &tmp [temp0 2])
		(return
			(if
				(or
					(OneOf (param1 message:) 2 5)
					(and (> (gEgo y:) 100) (> y 100))
					(and (< (gEgo y:) 95) (< y 95))
				)
				(super onMe: param1)
			else
				0
			)
		)
	)
)

(class FairView of View
	(properties)

	(method (onMe param1 &tmp [temp0 2])
		(return
			(if
				(or
					(OneOf (param1 message:) 2 5)
					(and (> (gEgo y:) 100) (> y 100))
					(and (< (gEgo y:) 95) (< y 95))
				)
				(super onMe: param1)
			else
				0
			)
		)
	)
)

