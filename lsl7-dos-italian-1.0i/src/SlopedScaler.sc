;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64886)
(include sci.sh)
(use Main)
(use Print)
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

	(method (init param1 param2 param3 param4 param5 param6 param7 &tmp temp0 temp1)
		(if argc
			(= client param1)
			(= frontSize param2)
			(= frontX param3)
			(= frontY param4)
			(= backSize param5)
			(= backX param6)
			(= backY param7)
		)
		(if (or (== param3 param6) (== param4 param7) (== param2 param5))
			(Printf
				{SlopedScaler, bad args %d %d %d   %d %d %d}
				param2
				param3
				param4
				param5
				param6
				param7
			)
			(return 0)
		)
		(= temp0 (- backY frontY))
		(= temp1 (- backX frontX))
		(= sb (- frontY (MulDiv temp0 frontX temp1)))
		(= slopeNum (- param2 param5))
		(= slopeDen (GetDistance param3 param4 param6 param7))
		(= mn (- temp1))
		(for ((= md temp0)) (or (> (Abs mn) 128) (> (Abs md) 128)) ((/= md 2))
			(/= mn 2)
		)
		(= m_sm (/ (+ (* mn mn) (* md md)) (* md mn)))
		(self doit:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp1 (client scaleX:))
		(= temp2 (client scaleY:))
		(= temp3 (- (gEgo y:) (MulDiv (gEgo x:) mn md)))
		(= temp5 (/ (- sb temp3) m_sm))
		(= temp6 (+ (MulDiv mn temp5 md) temp3))
		(= temp4 (GetDistance frontX frontY temp5 temp6))
		(= temp4 (GetDistance backX backY temp5 temp6))
		(= temp0 (+ backSize (MulDiv temp4 slopeNum slopeDen)))
		(PrintDebug {Ego @ %d %d, scale = %d} (gEgo x:) (gEgo y:) temp0)
		(if (or (!= temp1 temp0) (!= temp2 temp0))
			(client scaleX: temp0 scaleY: temp0)
		)
	)
)

