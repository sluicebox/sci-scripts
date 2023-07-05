;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64024)
(include sci.sh)
(use TPPolyPath)

(class TPWander of TPPolyPath
	(properties
		distance 30
	)

	(method (newTarget &tmp diam)
		(= finalX
			(+ (client x:) (- distance (Random 0 (= diam (* distance 2)))))
		)
		(= finalY (+ (client y:) (- distance (Random 0 diam))))
	)

	(method (setArgs actor)
		(if (> argc 2)
			(= distance [actor 1])
		)
		(if (> argc 3)
			(= caller [actor 2])
		)
	)

	(method (setDefault)
		(super setDefault:)
		(= distance 30)
	)
)

