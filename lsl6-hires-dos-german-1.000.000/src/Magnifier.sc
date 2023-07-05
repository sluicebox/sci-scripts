;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64979)
(include sci.sh)
(use System)

(class Magnifier of Obj
	(properties
		x 0
		y 0
		view -1
		loop 0
		cel 0
		power 0
		skip 0
		client 0
	)

	(method (init who v l c thePower theSkip)
		(= client who)
		(if (> argc 1)
			(= view v)
			(if (> argc 2)
				(= loop l)
				(if (> argc 3)
					(= cel c)
					(if (> argc 4)
						(= power thePower)
						(if (> argc 5)
							(= skip theSkip)
						)
					)
				)
			)
		)
		(AddMagnify self)
	)

	(method (dispose)
		(DeleteMagnify self)
		(client magnifier: 0)
		(= client 0)
		(super dispose:)
	)
)

