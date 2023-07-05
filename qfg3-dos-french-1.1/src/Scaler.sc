;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 935)
(include sci.sh)
(use Print)
(use System)

(class Scaler of Code
	(properties
		client 0
		frontY 190
		backY 0
		frontSize 100
		backSize 0
		slopeNum 0
		slopeDen 0
		const 0
	)

	(method (init who fs bs fy by)
		(if argc
			(= client who)
			(= frontSize fs)
			(= backSize bs)
			(= frontY fy)
			(= backY by)
		)
		(= slopeNum (- frontSize backSize))
		(if (not (= slopeDen (- frontY backY)))
			(Prints {<Scaler> frontY cannot be equal to backY})
			(return 0)
		)
		(= const (- backSize (/ (* slopeNum backY) slopeDen)))
		(self doit:)
	)

	(method (doit &tmp Y scale)
		(cond
			((< (= Y (client y:)) backY)
				(= scale backSize)
			)
			((> Y frontY)
				(= scale frontSize)
			)
			(else
				(= scale (+ (/ (* slopeNum Y) slopeDen) const))
			)
		)
		(= scale (/ (* scale 128) 100))
		(client scaleX: scale scaleY: scale)
	)
)

