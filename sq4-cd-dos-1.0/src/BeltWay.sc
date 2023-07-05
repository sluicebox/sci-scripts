;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 804)
(include sci.sh)
(use Main)
(use System)

(local
	local0 = 1
)

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
		tixCnt 0
		cnt 0
	)

	(method (doit &tmp temp0 temp1)
		(if (not onCon)
			(if (and (gUser canControl:) (not (== gCurRoom 400)))
				(switch (who loop:)
					(0
						(who x: (+ (who x:) 5))
					)
					(1
						(who x: (- (who x:) 5))
					)
					(2
						(who y: (+ (who y:) 5))
					)
					(3
						(who y: (- (who y:) 5))
					)
					(4
						(who y: (+ (who y:) 5) x: (+ (who x:) 5))
					)
					(5
						(who y: (+ (who y:) 5) x: (- (who x:) 5))
					)
					(6
						(who y: (- (who y:) 5) x: (+ (who x:) 5))
					)
					(7
						(who y: (- (who y:) 5) x: (- (who x:) 5))
					)
				)
			)
			(who setMotion: 0 setHeading: head)
			(= onCon 1)
			(= cnt xOff)
			(who moveSpeed: gGameSpeed)
		)
		(if
			(or
				(and
					(who mover:)
					(>=
						(Abs (- gGameTime ((who mover:) b-moveCnt:)))
						(who moveSpeed:)
					)
				)
				(and
					(not (who mover:))
					(>= (Abs (- gGameTime tixCnt)) gGameSpeed)
				)
			)
			(if (not (who mover:))
				(= tixCnt gGameTime)
			else
				(= tixCnt ((who mover:) b-moveCnt:))
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
)

