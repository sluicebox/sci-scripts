;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Print)
(use System)

(class XScaler of Code
	(properties
		client 0
		maxX 319
		minX 0
		maxSize 100
		minSize 0
		slopeNum 0
		slopeDen 0
		const 0
	)

	(method (init param1 param2 param3 param4 param5)
		(if argc
			(= client param1)
			(= maxSize param2)
			(= minSize param3)
			(= maxX param4)
			(= minX param5)
		)
		(= slopeNum (- maxSize minSize))
		(if (not (= slopeDen (- maxX minX)))
			(Prints {<Scaler> maxX cannot be equal to minX})
			(return 0)
		)
		(= const (- minSize (/ (* slopeNum minX) slopeDen)))
		(self doit:)
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (client x:))
		(cond
			(
				(or
					(and (< maxX minX) (< temp0 maxX))
					(and (> maxX minX) (> temp0 maxX))
				)
				(= temp1 maxSize)
			)
			(
				(or
					(and (< maxX minX) (> temp0 minX))
					(and (> maxX minX) (< temp0 minX))
				)
				(= temp1 minSize)
			)
			(else
				(= temp1 (+ (/ (* slopeNum temp0) slopeDen) const))
			)
		)
		(= temp1 (/ (* temp1 128) 100))
		(client scaleX: temp1 scaleY: temp1)
	)
)

