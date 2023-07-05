;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64886)
(include sci.sh)
(use Main)
(use Scaler)

(class SlopedScaler of Scaler
	(properties
		frontX 190
		backX 0
		mn 0
		md 0
		m_sm 0
		sb 0
	)

	(method (init who fs fx fy bs bx by &tmp smn smd)
		(if argc
			(= client who)
			(= frontSize fs)
			(= frontX fx)
			(= frontY fy)
			(= backSize bs)
			(= backX bx)
			(= backY by)
		)
		(if (or (== fx bx) (== fy by) (== fs bs))
			(return 0)
		)
		(= smn (- backY frontY))
		(= smd (- backX frontX))
		(= sb (- frontY (MulDiv smn frontX smd)))
		(= slopeNum (- fs bs))
		(= slopeDen (GetDistance fx fy bx by))
		(= mn (- smd))
		(for ((= md smn)) (or (> (Abs mn) 128) (> (Abs md) 128)) ((/= md 2))
			(/= mn 2)
		)
		(= m_sm (/ (+ (* mn mn) (* md md)) (* md mn)))
		(self doit:)
	)

	(method (doit &tmp scale oldScaleX oldScaleY b dist tx ty)
		(= oldScaleX (client scaleX:))
		(= oldScaleY (client scaleY:))
		(= b (- (gEgo y:) (MulDiv (gEgo x:) mn md)))
		(= tx (/ (- sb b) m_sm))
		(= ty (+ (MulDiv mn tx md) b))
		(= dist (GetDistance frontX frontY tx ty))
		(= dist (GetDistance backX backY tx ty))
		(= scale (+ backSize (MulDiv dist slopeNum slopeDen)))
		(PrintDebug {Ego @ %d %d, scale = %d} (gEgo x:) (gEgo y:) scale)
		(if (or (!= oldScaleX scale) (!= oldScaleY scale))
			(client scaleX: scale scaleY: scale)
		)
	)
)

