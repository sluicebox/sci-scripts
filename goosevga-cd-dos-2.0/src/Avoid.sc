;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 985)
(include sci.sh)
(use System)

(class Avoid of Obj
	(properties
		client 0
		heading -1000
		bumpTurn 0
		lastBumped 0
		thisTurn 1
		escaping 0
		escapes 0
		escapeTurn 1
		nearestDist 32000
		counter 0
		nonBumps 10
		targetX 0
		targetY 0
		motionInited 0
		outOfTouch 0
		offScreenOK 0
	)

	(method (init aClient allowOff)
		(if (>= argc 1)
			(= client aClient)
		)
		(if (>= argc 2)
			(= offScreenOK allowOff)
		)
		(= heading (client heading:))
		(= counter 0)
		(= nonBumps 10)
		(= escaping 0)
	)

	(method (incClientPos)
		(client
			x:
				(+
					(client x:)
					(* (sign (SinMult heading 100)) (client xStep:))
				)
			y:
				(-
					(client y:)
					(* (sign (CosMult heading 100)) (client yStep:))
				)
			heading: heading
		)
	)

	(method (pickLoop angle)
		(client heading: angle)
		(if (client looper:)
			((client looper:) doit: client angle)
		else
			(DirLoop client angle)
		)
	)

	(method (canBeHere theX theY &tmp oldX oldY result)
		(= oldX (client x:))
		(= oldY (client y:))
		(if argc
			(client x: theX y: theY)
		)
		(= result
			(if (client canBeHere:)
				(or
					offScreenOK
					(and (<= 0 (client x:) 257) (<= 0 (client y:) 155))
				)
			)
		)
		(client x: oldX y: oldY)
		(return result)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(if (= temp6 (client mover:))
			(temp6 setTarget:)
		)
		(cond
			((not (= temp6 (client mover:)))
				(= heading -1000)
				(return)
			)
			(
				(not
					(or
						(self
							canBeHere: (= temp4 (temp6 x:)) (= temp5 (temp6 y:))
						)
						(temp6 respondsTo: #distance)
					)
				)
				(temp6 doit:)
				(return)
			)
			((temp6 onTarget:)
				(or motionInited (InitBresen temp6))
				(temp6 doit:)
				(return)
			)
			((== heading -1000)
				(self init:)
			)
		)
		(= temp13 0)
		(= temp12 (<= nonBumps 3))
		(temp6 setTarget:)
		(= temp4 (temp6 x:))
		(= temp5 (temp6 y:))
		(= temp2 (client x:))
		(= temp3 (client y:))
		(= temp7 (GetAngle temp2 temp3 temp4 temp5))
		(= temp1 (GetDistance temp2 temp3 temp4 temp5))
		(= temp0 (= heading (umod (* 45 (/ heading 45)) 360)))
		(self pickLoop: temp0)
		(cond
			((not (or escaping (= temp12 (<= nonBumps 2))))
				(if (not motionInited)
					(= motionInited 1)
					(InitBresen temp6)
				)
				(temp6 doit:)
				(if (or (!= temp2 (client x:)) (!= temp3 (client y:)))
					(self pickLoop: temp7)
					(++ nonBumps)
					(return)
				else
					(= nonBumps 0)
					(= temp13 1)
					(= motionInited 0)
				)
			)
			((< (= temp9 (temp6 b-moveCnt:)) (client moveSpeed:))
				(temp6 b-moveCnt: (++ temp9))
				(return)
			)
			(else
				(temp6 b-moveCnt: 0)
			)
		)
		(cond
			(
				(or
					(!= targetX (= targetX temp4))
					(!= targetY (= targetY temp5))
					(and
						escaping
						(or
							(<= (-- counter) 0)
							(and (< temp1 nearestDist) (< counter 40))
						)
					)
				)
				(= motionInited (= escaping 0))
				(= nearestDist 32000)
				(= counter 0)
			)
			(escaping 1)
			((< temp1 nearestDist)
				(= nearestDist temp1)
				(= counter 0)
			)
			((= escaping (>= (++ counter) 50))
				(= counter (Random 40 80))
				(= escapeTurn (- escapeTurn))
			)
		)
		(cond
			((<= (-= temp7 temp0) -180)
				(+= temp7 360)
			)
			((> temp7 180)
				(-= temp7 360)
			)
		)
		(= temp11 (<= (= temp8 (Abs temp7)) 90))
		(= thisTurn
			(or
				(cond
					(escaping
						(sign temp7)
					)
					(temp11
						(sign temp7)
					)
					(bumpTurn bumpTurn)
					(lastBumped lastBumped)
					(else
						(sign temp7)
					)
				)
				escapeTurn
			)
		)
		(if (and (> temp8 22) (or 0 (not escaping)))
			(+= heading (* thisTurn 45))
		)
		(if escaping
			(= thisTurn escapeTurn)
		)
		(self incClientPos:)
		(if (self canBeHere:)
			(++ nonBumps)
			(= bumpTurn 0)
			(if (not escaping)
				(return)
			)
		else
			(= lastBumped bumpTurn)
			(= bumpTurn thisTurn)
			(= nonBumps 0)
		)
		(if escaping
			(= temp0 (* 45 (/ heading 45)))
			(for
				((= temp10 0))
				(and (< temp10 8) (self canBeHere:))
				((++ temp10))
				
				(= heading (umod (+ temp0 (* 45 temp10 escapeTurn)) 360))
				(client x: temp2 y: temp3)
				(self incClientPos:)
			)
			(if (== temp10 8)
				(+= heading (* escapeTurn 45))
			)
			(= temp0 heading)
		)
		(for
			((= temp10 (= temp9 1)))
			(and (not (self canBeHere:)) (< temp9 8))
			(
				(= temp10
					(cond
						(escaping
							(++ temp9)
						)
						(temp13
							(- (++ temp9))
						)
						((> temp10 0)
							(- temp10)
						)
						(else
							(++ temp9)
						)
					)
				)
			)
			
			(client x: temp2 y: temp3)
			(= heading (- temp0 (* 45 temp10 thisTurn)))
			(self incClientPos:)
		)
		(if (not (self canBeHere:))
			(client findPosn:)
		)
		(self pickLoop: heading)
	)
)

