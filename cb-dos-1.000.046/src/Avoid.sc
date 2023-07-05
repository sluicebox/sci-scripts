;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 985)
(include sci.sh)
(use System)

(procedure (localproc_0 param1)
	(return
		(not (and (< 0 (param1 x:) 320) (< 0 (- (param1 y:) (param1 z:)) 200)))
	)
)

(procedure (localproc_1 param1 param2)
	(if (>= argc 2)
		(-= param1 param2)
	)
	(return
		(cond
			((<= param1 -180)
				(+ param1 360)
			)
			((> param1 180)
				(- param1 360)
			)
			(else param1)
		)
	)
)

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
			((client looper:) doit: client angle 1)
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
				(or offScreenOK (not (localproc_0 client)))
			)
		)
		(client x: oldX y: oldY)
		(return result)
	)

	(method (doit &tmp h d cx cy mx my motion ang absDiff i j facing bumping firstBump angleDelta numLoops)
		(if (= numLoops (* (/ (NumLoops client) 4) 4))
			(= angleDelta (/ 180 numLoops))
		else
			(= angleDelta 90)
		)
		(if (= motion (client mover:))
			(motion setTarget:)
		)
		(cond
			((not motion)
				(= heading -1000)
				(return)
			)
			(
				(not
					(or
						(self
							canBeHere: (= mx (motion x:)) (= my (motion y:))
						)
						(motion respondsTo: #distance)
					)
				)
				(motion doit:)
				(return)
			)
			((motion onTarget:)
				(or motionInited (InitBresen motion))
				(motion doit:)
				(return)
			)
			((== heading -1000)
				(self init:)
			)
		)
		(= firstBump 0)
		(= cx (client x:))
		(= cy (client y:))
		(= ang (umod (GetAngle cx cy mx my) 360))
		(= d (GetDistance cx cy mx my))
		(= h (= heading (umod (* angleDelta (/ heading angleDelta)) 360)))
		(cond
			((not (or escaping (= bumping (<= nonBumps 2))))
				(if (not motionInited)
					(= motionInited 1)
					(InitBresen motion)
				)
				(motion doit:)
				(if (or (!= cx (client x:)) (!= cy (client y:)))
					(self pickLoop: ang)
					(++ nonBumps)
					(return)
				)
				(= nonBumps 0)
				(= firstBump 1)
				(= motionInited 0)
			)
			((< (= i (motion b-moveCnt:)) (client moveSpeed:))
				(motion b-moveCnt: (++ i))
				(return)
			)
			(else
				(motion b-moveCnt: 0)
			)
		)
		(cond
			(
				(or
					(!= targetX (= targetX mx))
					(!= targetY (= targetY my))
					(and
						escaping
						(or
							(<= (-- counter) 0)
							(and (< d nearestDist) (< counter 40))
						)
					)
				)
				(= motionInited (= escaping 0))
				(= nearestDist 32000)
				(= counter 0)
			)
			(escaping)
			((< d nearestDist)
				(= nearestDist d)
				(= counter 0)
			)
			((= escaping (>= (++ counter) 50))
				(= counter (Random 40 80))
				(= escapeTurn (- escapeTurn))
			)
		)
		(= facing (<= (= absDiff (Abs (= ang (localproc_1 ang h)))) 90))
		(= thisTurn (or (sign ang) escapeTurn))
		(if (and (> absDiff (/ angleDelta 2)) (not escaping))
			(+= heading (* thisTurn angleDelta))
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
		(*= numLoops 2)
		(if escaping
			(= h (* angleDelta (/ heading angleDelta)))
			(for
				((= j 0))
				(and (< j numLoops) (self canBeHere:))
				((++ j))
				
				(= heading
					(umod (+ h (* angleDelta j escapeTurn)) 360)
				)
				(client x: cx y: cy)
				(self incClientPos:)
			)
			(if (== j numLoops)
				(+= heading (* escapeTurn angleDelta))
			)
			(= h heading)
		)
		(for
			((= j (= i 1)))
			(and (not (self canBeHere:)) (< i numLoops))
			(
				(= j
					(cond
						(escaping
							(++ i)
						)
						((> j 0)
							(- j)
						)
						(else
							(++ i)
						)
					)
				)
			)
			
			(client x: cx y: cy)
			(= heading (- h (* angleDelta j thisTurn)))
			(self incClientPos:)
		)
		(self pickLoop: heading)
	)
)

