;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Array)
(use Print)
(use PolyPath)
(use System)

(class DuneMover of PolyPath
	(properties
		realPoints 0
		initialized 0
		ptIndex 0
		walkDir 0
		myObstaclesList 0
		backside 0
		curDune 0
		moveToDune 0
		curDuneObj 0
		moveToDuneObj 0
		useDune 0
		doScale 0
		slopeNum 0
		slopeDen 0
		const 0
		oldLooper 0
	)

	(method (init param1 param2 param3)
		(= useDune (gWalkHandler respondsTo: #curDune))
		(if (and (not initialized) useDune)
			(= backside (= curDuneObj (= moveToDune 0)))
			(= client param1)
			(cond
				((= moveToDuneObj (gWalkHandler getMoveToDune: param2 param3))
					(= moveToDune (moveToDuneObj duneNumber:))
				)
				(gDebugging
					(Printf
						{DuneMover ERROR: Point going to not on a dune. %d %d}
						param2
						param3
					)
				)
			)
			(cond
				((== client gEgo)
					(if (not (gWalkHandler curDune:))
						(gWalkHandler setup: gEgo)
					)
					(cond
						((= curDuneObj (gWalkHandler curDune:))
							(= curDune (curDuneObj duneNumber:))
							(= backside
								(if curDuneObj
									(curDuneObj egoOnBackside:)
								else
									0
								)
							)
						)
						(gDebugging
							(Prints {Ego is not currently on a dune.})
						)
					)
				)
				(
					(= curDuneObj
						(gWalkHandler firstTrue: #onMe (client x:) (client y:))
					)
					(= curDune (curDuneObj duneNumber:))
				)
				(gDebugging
					(Printf
						{%s is not currently on a dune.}
						(client -name-:)
					)
				)
			)
			(if (or (not curDune) (not moveToDune))
				(if gDebugging
					(Prints
						{DuneMover Alert: curDune or moveToDune set to 0}
					)
				)
				(if (> argc 3)
					(= caller [param1 3])
				)
				(= completed 1)
				(client mover: 0)
				(super motionCue:)
				(return)
			)
			(self createPoints: param2 param3)
			(curDuneObj switchDune: client walkDir backside)
			(= x (realPoints at: ptIndex))
			(= y (realPoints at: (++ ptIndex)))
			(++ ptIndex)
			(self setObstacles:)
			(if backside
				(self oldLooper: (client looper:) scalerInit:)
				(client looper: 0)
			)
		)
		(= initialized 1)
		(super init: param1 x y &rest)
	)

	(method (dispose)
		(if realPoints
			(realPoints dispose:)
		)
		(if oldLooper
			(client looper: oldLooper)
		)
		(super dispose: &rest)
	)

	(method (doit &tmp [temp0 6] temp6)
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(if useDune
				(cond
					(backside
						(if (!= (= temp6 (self checkLoop:)) (client loop:))
							(client setLoop: temp6 1)
						)
						(self scalerDoit:)
					)
					((& (client signal:) $0800)
						(client setLoop: -1)
					)
				)
			)
			(DoBresen self)
		)
	)

	(method (moveDone &tmp [temp0 2])
		(if (== (points at: value) 30583)
			(if (or (<= (realPoints size:) ptIndex) (not useDune))
				(obstacles release:)
				(obstacles dispose:)
				(= obstacles 0)
				(super moveDone:)
			else
				(= completed 0)
				(= xLast (client x:))
				(= yLast (client y:))
				(= value 2)
				(if obstacles
					(obstacles release:)
				)
				(= x (realPoints at: ptIndex))
				(= y (realPoints at: (++ ptIndex)))
				(++ ptIndex)
				(= backside (not backside))
				(if
					(or
						(and backside (== walkDir 1))
						(and (not backside) (== walkDir 2))
					)
					(+= curDune (- (* (== walkDir 2) 2) 1))
					(= curDuneObj (gWalkHandler at: (- curDune 1)))
				)
				(curDuneObj switchDune: client walkDir backside)
				(if (== client gEgo)
					(gWalkHandler
						curDune: (curDuneObj egoOnBackside: backside yourself:)
					)
				)
				(self setObstacles:)
				(if backside
					(self oldLooper: (client looper:) scalerInit:)
					(client looper: 0)
				else
					(client looper: oldLooper)
					(= oldLooper 0)
				)
				(super init: client x y)
			)
		else
			(self setTarget:)
			(super init:)
		)
	)

	(method (createPoints param1 param2 &tmp [temp0 3])
		(cond
			((> curDune moveToDune)
				(self walkDir: 1 headSouth: param1 param2)
			)
			((< curDune moveToDune)
				(self walkDir: 2 headNorth: param1 param2)
			)
			(backside
				(self walkDir: 1 headSouth: param1 param2)
			)
			(else
				(= walkDir 0)
				(= realPoints (IntArray with: param1 param2))
			)
		)
	)

	(method (headSouth param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 (client x:))
		(= temp1 (client y:))
		(= temp2 (> param1 (client x:)))
		(= temp4 (* (= temp3 (Abs (- curDune moveToDune))) 2))
		(++ temp4)
		(if backside
			(++ temp4)
		)
		(if realPoints
			(realPoints dispose:)
		)
		(= realPoints (IntArray new: (* temp4 2)))
		(= temp5
			(* (= temp5 (/ (Abs (- temp0 param1)) temp4)) (- (* temp2 2) 1))
		)
		(if backside
			(+= temp0 temp5)
			(= temp1 (curDuneObj findRidge: temp0))
			(realPoints at: ptIndex temp0 temp1)
			(+= ptIndex 2)
		)
		(for ((= temp6 (- curDune 2))) (>= temp6 (- moveToDune 1)) ((-- temp6))
			(+= temp0 temp5)
			(realPoints
				at: ptIndex temp0 ((gWalkHandler at: temp6) findValley: temp0)
			)
			(+= ptIndex 2)
			(+= temp0 temp5)
			(realPoints
				at: ptIndex temp0 ((gWalkHandler at: temp6) findRidge: temp0)
			)
			(+= ptIndex 2)
		)
		(realPoints at: ptIndex param1 param2)
		(= ptIndex 0)
	)

	(method (headNorth param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp2 (client x:))
		(= temp4 (> param1 (client x:)))
		(= temp1 0)
		(= temp0 (Abs (- curDune moveToDune)))
		(if backside
			(-- temp0)
			(++ temp1)
		)
		(+= temp1 (* temp0 2))
		(++ temp1)
		(if realPoints
			(realPoints dispose:)
		)
		(= realPoints (IntArray new: (* temp1 2)))
		(= temp3
			(* (= temp3 (/ (Abs (- temp2 param1)) temp1)) (- (* temp4 2) 1))
		)
		(= temp5 (- curDune 1))
		(if backside
			(+= temp2 temp3)
			(realPoints at: 0 temp2 (curDuneObj findValley: temp2))
			(+= ptIndex 2)
			(= temp5 (+ (- curDune 1) 1))
		)
		(for ((= temp6 temp5)) (< temp6 (- moveToDune 1)) ((++ temp6))
			(+= temp2 temp3)
			(realPoints
				at: ptIndex temp2 ((gWalkHandler at: temp6) findRidge: temp2)
			)
			(+= ptIndex 2)
			(+= temp2 temp3)
			(realPoints
				at: ptIndex temp2 ((gWalkHandler at: temp6) findValley: temp2)
			)
			(+= ptIndex 2)
		)
		(realPoints at: ptIndex param1 param2)
		(= ptIndex 0)
	)

	(method (setObstacles &tmp temp0 temp1 temp2)
		(if obstacles
			(obstacles release:)
		)
		(if backside
			(return)
		)
		(if (not obstacles)
			(= obstacles (List new:))
		)
		(if (curDuneObj roomPoly:)
			(cond
				(((curDuneObj roomPoly:) isKindOf: List)
					(= temp0 ((curDuneObj roomPoly:) size:))
					(for ((= temp2 0)) (< temp2 temp0) ((++ temp2))
						(= temp1 ((curDuneObj roomPoly:) at: temp2))
						(if (not (obstacles contains: temp1))
							(obstacles add: temp1)
						)
					)
				)
				((not (obstacles contains: (curDuneObj roomPoly:)))
					(obstacles add: (curDuneObj roomPoly:))
				)
			)
		)
		(if (and (not walkDir) (curDuneObj onMeCheck:))
			(cond
				(((curDuneObj onMeCheck:) isKindOf: List)
					(= temp0 ((curDuneObj onMeCheck:) size:))
					(for ((= temp2 0)) (< temp2 temp0) ((++ temp2))
						(= temp1 ((curDuneObj onMeCheck:) at: temp2))
						(if (not (obstacles contains: temp1))
							(obstacles add: temp1)
						)
					)
				)
				((not (obstacles contains: (curDuneObj onMeCheck:)))
					(obstacles add: (curDuneObj onMeCheck:))
				)
			)
		)
	)

	(method (checkLoop &tmp temp0)
		(= temp0
			(cond
				((or (< (client heading:) 15) (< 345 (client heading:)))
					(if (== walkDir 2) 3 else 2)
				)
				((<= 15 (client heading:) 80)
					(if (== walkDir 2) 6 else 4)
				)
				((<= 81 (client heading:) 99) 0)
				((<= 100 (client heading:) 170)
					(if (== walkDir 2) 6 else 4)
				)
				((<= 171 (client heading:) 189)
					(if (== walkDir 2) 3 else 2)
				)
				((<= 190 (client heading:) 260)
					(if (== walkDir 2) 7 else 5)
				)
				((<= 261 (client heading:) 279) 1)
				((<= 280 (client heading:) 345)
					(if (== walkDir 2) 7 else 5)
				)
			)
		)
	)

	(method (scalerInit &tmp temp0)
		(client scaleSignal: (| (client scaleSignal:) $0001))
		(= temp0
			(if (== walkDir 2)
				((gWalkHandler at: (+ (- curDune 1) 1)) duneScaleSize:)
			else
				(curDuneObj duneScaleSize:)
			)
		)
		(= slopeNum (- (client scaleX:) temp0))
		(= slopeDen (GetDistance (client x:) (client y:) x y))
		(if (not slopeDen)
			(= slopeDen 1)
		)
		(= const temp0)
		(self scalerDoit:)
	)

	(method (scalerDoit &tmp temp0 temp1)
		(if
			(<=
				(= temp1 (GetDistance x y (client x:) (client y:)))
				(client xStep:)
			)
			(= temp0 const)
		else
			(= temp0 (+ (/ (* slopeNum temp1) slopeDen) const))
		)
		(client scaleX: temp0 scaleY: temp0)
	)
)

