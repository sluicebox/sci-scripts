;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 804)
(include sci.sh)
(use System)

(class BeltWay of Code
	(properties
		who 0
		xStep 0
		yStep 0
		xOff 0
		yOff 0
		xTweak 0
		yTweak 0
		key 0
		head 0
		xDir 0
		yDir 0
		onCon 0
		cnt 0
	)

	(method (doit &tmp temp0 temp1)
		(if (not onCon)
			(who setMotion: 0 setHeading: head)
			(= onCon 1)
			(= cnt xOff)
		)
		(cond
			((and (== (who heading:) key) (who mover:))
				(= cnt xOff)
				(= temp0 xTweak)
				(= temp1 yTweak)
			)
			((not cnt)
				(= cnt xOff)
				(= temp0 xStep)
				(= temp1 yOff)
			)
			(else
				(-- cnt)
				(= temp0 xStep)
				(= temp1 yStep)
			)
		)
		(who x: (+ (who x:) (* temp0 xDir)) y: (+ (who y:) (* temp1 yDir)))
	)
)

