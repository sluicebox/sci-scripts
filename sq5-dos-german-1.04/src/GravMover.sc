;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(local
	[local0 8] = [7 9 11 13 0 2 3 5]
)

(class GravMover of Motion
	(properties
		curHeading 0
		b-moveCnt2 0
		theSpeed 0
	)

	(method (init param1 param2 param3)
		(if argc
			(= client param1)
			(if (> argc 1)
				(if (== argc 2)
					(= curHeading param2)
					(self setTarget:)
					(= theSpeed
						(/ (GetDistance x y (client x:) (client y:)) 10)
					)
				else
					(= curHeading
						(GetAngle (client x:) (client y:) param2 param3)
					)
					(= x param2)
					(= y param3)
					(= theSpeed (GetDistance x y (client x:) (client y:)))
					(self setTarget:)
				)
			else
				(= curHeading (client heading:))
				(self setTarget:)
				(= theSpeed (/ (GetDistance x y (client x:) (client y:)) 10))
			)
		)
		(= b-moveCnt2 (+ 1 theSpeed gGameTime))
		(super init:)
	)

	(method (onTarget)
		(return 0)
	)

	(method (doit &tmp [temp0 8])
		(if (>= (Abs (- gGameTime b-moveCnt2)) theSpeed)
			(= b-moveCnt2 gGameTime)
			(if dx
				(if (> dx 0)
					(-- dx)
				else
					(++ dx)
				)
			else
				(= dx (- (Random 1 3) 2))
			)
			(if dy
				(if (> dy 0)
					(-- dy)
				else
					(++ dy)
				)
			else
				(= dy (- (Random 1 3) 2))
			)
		)
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(DoBresen self)
		)
	)

	(method (setTarget)
		(= x (+ (client x:) (SinMult curHeading 500)))
		(= y (- (client y:) (CosMult curHeading 500)))
	)
)

(class SpecialLooper of Code
	(properties
		oldDir -1
		client 0
		oldMover 0
	)

	(method (init param1)
		(= client param1)
		(client looper: self)
	)

	(method (doit param1 param2)
		(= client param1)
		(if (!= param2 oldDir)
			(client heading: param2)
			(if (< [local0 (/ param2 45)] [local0 (/ oldDir 45)])
				(client setCycle: CT [local0 (/ param2 45)] -1)
			else
				(client setCycle: CT [local0 (/ param2 45)] 1)
			)
			(= oldDir param2)
		)
	)

	(method (dispose)
		(if client
			(client looper: 0)
		)
		(super dispose:)
	)
)

(class SpecialCycler of Cycle
	(properties
		theCycleSpeed 6
		isMover 0
	)

	(method (nextCel)
		(return
			(if (< (Abs (- gGameTime cycleCnt)) theCycleSpeed)
				(client cel:)
			else
				(= cycleCnt gGameTime)
				(+ (client cel:) cycleDir)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(
				(and
					(not isMover)
					(client mover:)
					(< (+ ((client mover:) dx:) ((client mover:) dy:)) 3)
				)
				(= isMover 1)
				(= cycleDir (if (Random 0 1) 1 else -1))
				(= theCycleSpeed (Random 3 15))
			)
			(
				(and
					(client mover:)
					(>= (+ ((client mover:) dx:) ((client mover:) dy:)) 3)
				)
				(= theCycleSpeed
					(- 15 (+ ((client mover:) dx:) ((client mover:) dy:)))
				)
				(= isMover 0)
			)
		)
		(if (or (> (= temp0 (self nextCel:)) (client lastCel:)) (< temp0 0))
			(self cycleDone: temp0)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone param1)
		(if (> param1 (client lastCel:))
			(client cel: 0)
		else
			(client cel: (client lastCel:))
		)
	)
)

