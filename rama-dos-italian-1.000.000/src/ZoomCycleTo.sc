;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 136)
(include sci.sh)
(use Motion)

(class ZoomCycleTo of CT
	(properties
		xLast 0
		yLast 0
		yStep 0
		xStep 0
	)

	(method (init param1 param2 param3 param4 param5 &tmp temp0)
		(super
			init:
				param1
				param2
				(if (> param2 (param1 cel:)) 1 else -1)
				(if (> argc 4) param5 else 0)
		)
		(if (!= param2 (param1 cel:))
			(= temp0 (Abs (- endCel (client cel:))))
			(= xLast param3)
			(= yLast param4)
			(= xStep (/ (- xLast (client x:)) temp0))
			(= yStep (/ (- yLast (client y:)) temp0))
		)
	)

	(method (doit &tmp temp0 temp1)
		(if (!= (= temp1 (client cel:)) (= temp0 (self nextCel:)))
			(if (== temp1 endCel)
				(self cycleDone:)
			else
				(client cel: temp0)
				(if (== temp0 endCel)
					(client x: xLast y: yLast)
				else
					(client x: (+ (client x:) xStep) y: (+ (client y:) yStep))
				)
			)
		)
	)
)

