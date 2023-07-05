;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 992)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3)
	(if (< param5 param3)
		(= temp0 param5)
		(= temp2 param3)
	else
		(= temp0 param3)
		(= temp2 param5)
	)
	(if (< param6 param4)
		(= temp1 param6)
		(= temp3 param4)
	else
		(= temp1 param4)
		(= temp3 param6)
	)
	(return
		(and
			(<= temp0 param1)
			(>= temp2 param1)
			(<= temp1 param2)
			(>= temp3 param2)
		)
	)
)

(class Cycle of Obj
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
	)

	(method (init theObj)
		(if argc
			(= client theObj)
		)
		(= cycleCnt 0)
		(client setCel: -1)
		(client startUpd:)
	)

	(method (nextCel)
		(++ cycleCnt)
		(return
			(if (<= cycleCnt (client cycleSpeed:))
				(client cel:)
			else
				(= cycleCnt 0)
				(if (& (client signal:) $1000)
					(client cel:)
				else
					(+ (client cel:) cycleDir)
				)
			)
		)
	)

	(method (cycleDone))

	(method (motionCue)
		(client cycler: 0)
		(if (and completed (IsObject caller))
			(caller cue:)
		)
		(self dispose:)
	)
)

(class Fwd of Cycle
	(properties)

	(method (doit &tmp newCel)
		(if (> (= newCel (self nextCel:)) (client lastCel:))
			(self cycleDone:)
		else
			(client cel: newCel)
		)
	)

	(method (cycleDone)
		(client cel: 0)
	)
)

(class Walk of Fwd
	(properties
		x -1
		y -1
	)

	(method (init)
		(super init: &rest)
		(= x (client x:))
		(= y (client y:))
	)

	(method (doit &tmp newCel)
		(if (or (!= x (client x:)) (!= y (client y:)))
			(super doit:)
			(= x (client x:))
			(= y (client y:))
		)
	)
)

(class CT of Cycle
	(properties
		endCel 0
	)

	(method (init actor toCel dir whoCares &tmp last)
		(super init: actor)
		(= cycleDir dir)
		(if (== argc 4)
			(= caller whoCares)
		)
		(= last (client lastCel:))
		(= endCel (if (> toCel last) last else toCel))
	)

	(method (doit &tmp newCel last)
		(= last (client lastCel:))
		(if (> endCel last)
			(= endCel last)
		)
		(= newCel (self nextCel:))
		(client
			cel:
				(cond
					((> newCel last) 0)
					((< newCel 0) last)
					(else newCel)
				)
		)
		(if (and (== cycleCnt 0) (== endCel (client cel:)))
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(if caller
			(= global58 1)
		else
			(self motionCue:)
		)
	)
)

(class End of CT
	(properties)

	(method (init actor whoCares)
		(super init: actor (actor lastCel:) 1 (if (== argc 2) whoCares else 0))
	)
)

(class Beg of CT
	(properties)

	(method (init actor whoCares)
		(super init: actor 0 -1 (if (== argc 2) whoCares else 0))
	)
)

(class Motion of Obj
	(properties
		client 0
		caller 0
		x 0
		y 0
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
		xLast 0
		yLast 0
	)

	(method (init actor xTo yTo toCall &tmp [temp0 4])
		(if (>= argc 1)
			(= client actor)
			(if (>= argc 2)
				(= x xTo)
				(if (>= argc 3)
					(= y yTo)
					(if (>= argc 4)
						(= caller toCall)
					)
				)
			)
		)
		(= yLast (= xLast (= b-moveCnt (= completed 0))))
		(client xLast: 0 yLast: 0)
		(client heading: (GetAngle (client x:) (client y:) x y))
		(if (client looper:)
			((client looper:) doit: client (client heading:))
		else
			(DirLoop client (client heading:))
		)
		(InitBresen self)
	)

	(method (onTarget)
		(return (and (== (client x:) x) (== (client y:) y)))
	)

	(method (setTarget xTo yTo)
		(if argc
			(= x xTo)
			(= y yTo)
		)
	)

	(method (doit &tmp [temp0 6])
		(DoBresen self)
		(client xLast: xLast yLast: yLast)
	)

	(method (moveDone param1)
		(if (or (== argc 0) param1)
			(= completed 1)
			(if caller
				(= global58 1)
			else
				(self motionCue:)
			)
		)
	)

	(method (motionCue)
		(client mover: 0)
		(if (and completed (IsObject caller))
			(caller cue:)
		)
		(self dispose:)
	)
)

(class MoveTo of Motion
	(properties)

	(method (onTarget)
		(return
			(and
				(<= (Abs (- (client x:) x)) (client xStep:))
				(<= (Abs (- (client y:) y)) (client yStep:))
			)
		)
	)
)

(class NewFollow of Motion
	(properties
		who 0
		distance 30
		prevX -1
		prevY -1
		stoppedCnt 0
	)

	(method (init param1 param2 param3)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= who param2)
				(if (>= argc 3)
					(= distance param3)
				)
			)
		)
		(if (> (client distanceTo: who) distance)
			(super init: client (who x:) (who y:))
		)
	)

	(method (onTarget)
		(return (<= (client distanceTo: who) distance))
	)

	(method (setTarget)
		(cond
			(argc
				(super setTarget: &rest)
			)
			((not (self onTarget:))
				(super setTarget: (who x:) (who y:))
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(if (or (!= prevX (client x:)) (!= prevY (client y:)))
			(= prevX (client x:))
			(= prevY (client y:))
			(= stoppedCnt 0)
		else
			(++ stoppedCnt)
		)
		(if (or (client cel:) (> (client distanceTo: who) distance))
			(if (or (client isBlocked:) (> stoppedCnt (client moveSpeed:)))
				(client cel: 0)
			else
				(if (not (client cycler:))
					(client setCycle: Walk)
				)
				(super doit:)
				(if (== b-moveCnt 0)
					(super init: client (who x:) (who y:))
				)
			)
		else
			(= temp1 (GetAngle (client x:) (client y:) (who x:) (who y:)))
			(if (client looper:)
				((client looper:) doit: client temp1)
			else
				(DirLoop client temp1)
			)
		)
		(if (and (== (client view:) 45) (client inRect: 0 0 258 156))
			(= temp0
				(and (not (client cel:)) (> stoppedCnt (client moveSpeed:)))
			)
			(client ignoreActors: temp0)
		)
	)

	(method (moveDone))
)

(class AIPath of MoveTo
	(properties
		aIPath 0
		bIntoX 0
		bIntoY 0
		bAFromX 0
		bAFromY 0
		bAToX 0
		bAToY 0
		brkAway 0
		pEntry 0
		firstNode 0
		iCount 2
		lastNode 0
		pDir 2
		prevPath 0
		tried2Move 0
		pFlags 0
		origBAE 0
		dispoSelf 1
	)

	(method (init param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 [temp14 2])
		(if (not (= aIPath param2))
			(super init: param1 &rest)
			(return)
		)
		(self entryIO: (= pEntry 0) @temp14 0 4)
		(if (not [temp14 1])
			(if (= temp2 temp14)
				(+= pEntry (+ temp2 2))
				(= temp3 1)
				(while (<= temp3 temp2)
					(self entryIO: temp3 @temp14 0 2)
					(if temp14
						(Print 992 0) ; "Path array header overflow"
					else
						(= temp14 (= temp1 pEntry))
					)
					(self entryIO: temp3 @temp14 1 2)
					(self entryIO: temp1 @temp13 0 2)
					(if (= temp12 (& temp13 $2000))
						(= iCount 4)
					else
						(= iCount 2)
						(= temp0 0)
					)
					(-= pEntry (= pDir iCount))
					(repeat
						(self next: @temp8)
						(if (not (& temp8 $8000))
							(if temp12
								(= temp7
									(= temp0
										(GetDistance
											temp8
											(& temp9 $00ff)
											temp4
											temp5
										)
									)
								)
							)
							(self entryIO: (- pEntry pDir) @temp4 1 (* iCount 2))
						else
							(&= temp8 $01ff)
						)
						(= temp4 temp8)
						(= temp5 temp9)
						(= temp6 temp0)
						(breakif (& temp9 $8000))
					)
					(self entryIO: temp1 @temp4 0 (* iCount 2))
					(&= temp9 $00ff)
					(if temp12
						(= temp10 temp0)
						(= temp6
							(= temp0 (GetDistance temp8 temp9 temp4 temp5))
						)
						(= temp11 temp0)
					)
					(|= temp4 temp13)
					(self entryIO: temp1 @temp4 1 (* iCount 2))
					(self entryIO: pEntry @temp8 1 (* iCount 2))
					(++ temp3)
					(+= pEntry pDir)
				)
				(self entryIO: temp3 @temp14 0 2)
				(= temp14 pEntry)
				(self entryIO: temp3 @temp14 1 2)
			else
				(Print 992 1) ; "Path count is invalid."
			)
		)
		(if (not prevPath)
			(self setAvail:)
		)
		(cond
			((> argc 3)
				(super init: param1 &rest)
				(if (self pathsCross: 0)
					(self pathAround:)
				)
			)
			((== argc 2)
				(param1 mover: 0)
				(self dispose:)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 [temp13 60])
		(super doit:)
		(if
			(and
				(client mover:)
				(& (= temp11 (client signal:)) $0400)
				aIPath
				(not tried2Move)
				(!= brkAway -1)
			)
			(= dispoSelf 0)
			(= tried2Move 1)
			(client signal: (& temp11 $fbff))
			(= temp10 0)
			(= temp7 (client x:))
			(= temp8 (client y:))
			(cond
				((and brkAway (== x bIntoX) (== y bIntoY))
					(= temp9 pEntry)
					(if
						(= temp1
							(Intersections
								temp7
								temp8
								bAToX
								bAToY
								aIPath
								firstNode
								lastNode
								iCount
								@temp13
								1
							)
						)
						(= temp4 0)
						(= temp3 32767)
						(= temp0 -1)
						(while temp1
							(= temp5 [temp13 (++ temp0)])
							(= temp6 [temp13 (++ temp0)])
							(= pEntry [temp13 (++ temp0)])
							(if
								(and
									(or
										(and (< temp7 bAToX) (<= temp5 temp7))
										(and (> temp7 bAToX) (>= temp5 temp7))
										(and
											(== temp7 bAToX)
											(or
												(and
													(< temp8 bAToY)
													(<= temp6 temp8)
												)
												(and
													(> temp8 bAToY)
													(>= temp6 temp8)
												)
											)
										)
									)
									(<
										(= temp2
											(GetDistance
												temp7
												temp8
												temp5
												temp6
											)
										)
										temp3
									)
								)
								(= temp3 temp2)
								(= temp4 pEntry)
								(= bIntoX temp5)
								(= bIntoY temp6)
							)
							(-- temp1)
						)
						(= brkAway origBAE)
						(= temp10 1)
					)
				)
				((self pathsCross: 1)
					(self entryIO: firstNode @temp12 0 2)
					(if (& temp12 $1000)
						(= temp4 pEntry)
						(= temp3 (GetDistance temp7 temp8 bIntoX bIntoY))
						(= temp10 1)
					)
				)
			)
			(if temp10
				(self
					entryIO:
						(= pEntry (self closestNode: temp7 temp8))
						@temp5
						0
						4
				)
				(if (>= temp3 (= temp2 (GetDistance temp7 temp8 temp5 temp6)))
					(= temp4 pEntry)
					(= temp3 temp2)
					(= bIntoX temp5)
					(= bIntoY temp6)
				)
				(if (<= temp3 (client btRange:))
					(= pEntry temp4)
					(self pathAround:)
				)
			)
			(if dispoSelf
				(super moveDone:)
			)
			(= dispoSelf 1)
		)
	)

	(method (pathsCross param1 &tmp temp0 temp1 temp2 temp3 [temp4 2] temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 [temp24 120] temp144 temp145 temp146 temp147 temp148 temp149 temp150 temp151 temp152 temp153 temp154 temp155 temp156 temp157)
		(if (== brkAway -1)
			(return (= firstNode 0))
		)
		(= temp152 32767)
		(= temp148 0)
		(= temp21 (client x:))
		(= temp22 (client y:))
		(= temp145 (client xStep:))
		(= temp146 (client yStep:))
		(self entryIO: (= temp2 0) @temp4 0 4)
		(= temp3 temp4)
		(= temp0 1)
		(while temp3
			(= firstNode [temp4 temp0])
			(if (not (^= temp0 $0001))
				(self entryIO: (+= temp2 2) @temp4 0 4)
			)
			(self entryIO: (= pEntry firstNode) @temp23 0 2)
			(if (== (& temp23 $4400) 17408)
				(if (= temp8 (& temp23 $2000))
					(= iCount 4)
				else
					(= iCount 2)
				)
				(= pDir iCount)
				(= lastNode (- [temp4 temp0] pDir))
				(if
					(= temp9
						(Intersections
							temp21
							temp22
							(= bAToX x)
							(= bAToY y)
							aIPath
							firstNode
							lastNode
							iCount
							@temp24
							param1
						)
					)
					(= temp11 (= temp12 (= temp13 (= temp17 32767))))
					(= temp18 0)
					(= temp147 temp23)
					(= temp144 pDir)
					(= temp1 -1)
					(while temp9
						(= temp19 [temp24 (++ temp1)])
						(= temp20 [temp24 (++ temp1)])
						(= pEntry [temp24 (++ temp1)])
						(if
							(or
								(> (Abs (- temp11 temp19)) temp145)
								(> (Abs (- temp12 temp20)) temp146)
							)
							(if
								(<
									(= temp10
										(GetDistance
											temp21
											temp22
											temp19
											temp20
										)
									)
									temp13
								)
								(= temp11 temp19)
								(= temp12 temp20)
								(= temp13 temp10)
								(= temp14 pEntry)
							)
							(if
								(and
									(not (& temp23 $1000))
									(<
										(= temp10
											(GetDistance
												bAToX
												bAToY
												temp19
												temp20
											)
										)
										temp17
									)
								)
								(= temp15 temp19)
								(= temp16 temp20)
								(= temp17 temp10)
								(= temp18 pEntry)
							)
						)
						(-- temp9)
					)
					(if (< temp13 temp152)
						(= pFlags temp147)
						(= temp148 firstNode)
						(= temp149 lastNode)
						(= temp157 temp144)
						(= temp150 temp11)
						(= temp151 temp12)
						(= temp152 temp13)
						(= temp153 temp14)
						(= temp154 temp15)
						(= temp155 temp16)
						(= temp156 temp18)
					)
				)
			)
			(-- temp3)
		)
		(if (= firstNode temp148)
			(= lastNode temp149)
			(= pDir temp157)
			(= iCount (Abs pDir))
			(if (& pFlags $1000)
				(self entryIO: (= temp156 (self closestNode: x y)) @temp6 0 4)
				(= temp154 (& temp6 $01ff))
				(= temp155 temp7)
			)
			(= bIntoX temp150)
			(= bIntoY temp151)
			(= pEntry temp153)
			(if temp156
				(= brkAway (= origBAE temp156))
				(= bAFromX temp154)
				(= bAFromY temp155)
				(= bAToX x)
				(= bAToY y)
			)
		)
		(return temp148)
	)

	(method (entryIO param1 param2 param3 param4)
		(*= param1 2)
		(= param4 (- 0 param4))
		(switch param3
			(0
				(StrCpy param2 (+ aIPath param1) param4)
			)
			(1
				(StrCpy (+ aIPath param1) param2 param4)
			)
		)
	)

	(method (nextEntry param1 param2)
		(cond
			((and (== param1 lastNode) (> param2 0) param1)
				(= param1 firstNode)
			)
			((and (== param1 firstNode) (< param2 0) param1)
				(= param1 lastNode)
			)
			(else
				(+= param1 param2)
			)
		)
		(return param1)
	)

	(method (next param1)
		(= pEntry (self nextEntry: pEntry pDir))
		(self entryIO: pEntry param1 0 (* iCount 2))
	)

	(method (closestNode param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2] temp7)
		(= temp1 32767)
		(= temp7 pDir)
		(= pDir iCount)
		(= pEntry (- firstNode pDir))
		(repeat
			(self next: @temp3)
			(if
				(<
					(= temp2 (GetDistance (& temp3 $01ff) temp4 param1 param2))
					temp1
				)
				(= temp1 temp2)
				(= temp0 pEntry)
			)
			(breakif (== pEntry lastNode))
		)
		(= pDir temp7)
		(return temp0)
	)

	(method (pathAround &tmp temp0 temp1 temp2)
		(= prevPath firstNode)
		(cond
			((and (== (= pDir iCount) 4) (!= pEntry brkAway))
				(self shortestDir:)
			)
			((> pEntry brkAway)
				(= pDir (- 0 pDir))
			)
		)
		(if (> pDir 0)
			(self entryIO: pEntry @temp0 0 4)
			(&= temp0 $01ff)
			(if (or (!= bIntoX temp0) (!= bIntoY temp1))
				(= pEntry (self nextEntry: pEntry (- 0 pDir)))
			)
			(if (or (!= bIntoX bAFromX) (!= bIntoY bAFromY))
				(self setAvail:)
				(= brkAway (self nextEntry: brkAway (- 0 pDir)))
			else
				(= brkAway pEntry)
			)
		)
		(if (and (== bIntoX (client x:)) (== bIntoY (client y:)))
			(self moveDone: dispoSelf)
			(= dispoSelf 1)
		else
			(super init: client bIntoX bIntoY)
		)
	)

	(method (shortestDir &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp3 32767)
		(= pDir 4)
		(while (>= pDir -4)
			(= temp1 brkAway)
			(if (> pDir 0)
				(= temp0 pEntry)
			else
				(= pEntry (self nextEntry: pEntry pDir))
				(if (== temp1 firstNode)
					(= temp1 lastNode)
				else
					(+= temp1 pDir)
				)
			)
			(self entryIO: pEntry @temp5 0 (* iCount 2))
			(= temp2 (GetDistance (&= temp5 $01ff) temp6 bIntoX bIntoY))
			(repeat
				(+= temp2 (if (> pDir 0) temp8 else temp7))
				(self next: @temp5)
				(breakif (== pEntry temp1))
			)
			(if
				(<
					(-=
						temp2
						(GetDistance (&= temp5 $01ff) temp6 bAFromX bAFromY)
					)
					temp3
				)
				(= temp4 pDir)
				(= temp3 temp2)
			)
			(-= pDir 8)
			(= pEntry temp0)
		)
		(= pEntry temp0)
		(= pDir temp4)
	)

	(method (setAvail &tmp temp0 temp1 temp2 temp3)
		(self entryIO: 0 @temp0 0 2)
		(for ((= temp1 1)) temp0 ((++ temp1))
			(self entryIO: temp1 @temp2 0 2)
			(self entryIO: temp2 @temp3 0 2)
			(|= temp3 $0400)
			(self entryIO: temp2 @temp3 1 2)
			(-- temp0)
		)
	)

	(method (moveDone &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 [temp13 120])
		(if brkAway
			(= temp7 (client x:))
			(= temp8 (client y:))
			(if
				(and
					(& pFlags $0800)
					(= temp0
						(Intersections
							temp7
							temp8
							bAToX
							bAToY
							aIPath
							firstNode
							lastNode
							iCount
							@temp13
							0
						)
					)
				)
				(= temp9 (client xStep:))
				(= temp10 (client yStep:))
				(= temp2 -1)
				(for ((= temp1 temp0)) temp1 ((-- temp1))
					(= temp4 [temp13 (++ temp2)])
					(= temp5 [temp13 (++ temp2)])
					(= temp6 [temp13 (++ temp2)])
					(if
						(or
							(and
								(<= (Abs (- temp7 temp4)) temp9)
								(<= (Abs (- temp8 temp5)) temp10)
							)
							(== pEntry temp6)
						)
						(-- temp0)
					)
				)
				(if (< temp0 1)
					(= brkAway pEntry)
					(= bAFromX temp7)
					(= bAFromY temp8)
				)
			)
			(if (== pEntry brkAway)
				(if (and (== temp7 bAFromX) (== temp8 bAFromY))
					(self entryIO: firstNode @temp3 0 2)
					(&= temp3 $fbff)
					(self entryIO: firstNode @temp3 1 2)
					(= brkAway 0)
					(= iCount (= pDir 2))
					(self init: client aIPath bAToX bAToY)
				else
					(super init: client bAFromX bAFromY)
				)
			else
				(self next: @temp11)
				(super init: client (& temp11 $01ff) temp12)
			)
		else
			(super moveDone: dispoSelf)
			(= dispoSelf 1)
		)
	)
)

(class Freeway of AIPath
	(properties
		fEntry 0
		fBIEntry 0
		fBAEntry 0
		fToEntry 0
		fDir 3
		fToX 0
		fToY 0
		fPEntry 0
		fPDir 0
	)

	(method (init param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 [temp21 2] temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32)
		(if (not (= aIPath param2))
			(super init: param1 param2 &rest)
			(return)
		)
		(self entryIO: 0 @temp9 0 4)
		(if (not temp10)
			(super init: param1 param2 0)
			(self entryIO: (+ temp9 1) @temp10 0 2)
			(self entryIO: (= fEntry temp10) @temp0 0 2)
			(if temp0
				(+= fEntry (+ (* temp0 4) 1))
				(self entryIO: (= temp1 fEntry) @temp11 0 6)
				(repeat
					(if (== temp11 -1)
						(self entryIO: temp1 @temp11 1 2)
						(break)
					)
					(= temp2 (+ temp1 3))
					(+= fEntry 2)
					(repeat
						(self entryIO: fEntry @temp14 0 10)
						(= pEntry (+ (&= temp14 $0fff) 1))
						(self entryIO: pEntry @temp6 0 2)
						(self entryIO: (+ pEntry 1) @temp21 0 2)
						(self entryIO: (= pEntry temp6) @temp5 0 2)
						(if (& temp5 $2000)
							(= iCount 4)
						else
							(= iCount 2)
						)
						(= pDir (= temp25 iCount))
						(= firstNode pEntry)
						(= lastNode (- temp21 iCount))
						(-= pEntry pDir)
						(= temp23 (= brkAway 0))
						(while (< pEntry lastNode)
							(self next: @temp19)
							(&= temp19 $01ff)
							(cond
								(
									(and
										(not temp23)
										(== temp15 temp19)
										(== temp16 temp20)
									)
									(= bIntoX temp19)
									(= bIntoY temp20)
									(= temp23 pEntry)
								)
								(
									(and
										(not brkAway)
										(== temp17 temp19)
										(== (& temp18 $00ff) temp20)
									)
									(= bAFromX temp19)
									(= bAFromY temp20)
									(= brkAway pEntry)
								)
							)
							(breakif (and temp23 brkAway))
						)
						(if (or (not temp23) (not brkAway))
							(Print 992 2) ; "Unmatched route node"
							(if (not temp23)
								(Printf 992 3 temp14 temp15 temp16) ; "path: %u from x: %u from y:%u"
							)
							(if (not brkAway)
								(Printf 992 4 temp14 temp17 (& temp18 $00ff)) ; "path: %u to x: %u to y:%u"
							)
						)
						(cond
							((& temp5 $2000)
								(= pEntry (self nextEntry: temp23 pDir))
								(= temp7 bAFromX)
								(= temp8 bAFromY)
								(self
									entryIO:
										(self nextEntry: brkAway (- 0 pDir))
										@temp19
										0
										(* iCount 2)
								)
								(= bAFromX (& temp19 $01ff))
								(= bAFromY temp20)
								(self shortestDir:)
								(= temp25 pDir)
								(= bAFromX temp7)
								(= bAFromY temp8)
							)
							((> temp23 brkAway)
								(= temp25 (- 0 pDir))
							)
						)
						(= temp24 brkAway)
						(self entryIO: temp2 @temp23 1 6)
						(+= temp2 3)
						(+= fEntry 5)
						(breakif (& temp18 $8000))
					)
					(= temp13 temp2)
					(self entryIO: temp1 @temp11 1 6)
					(= temp1 temp13)
					(self entryIO: fEntry @temp11 0 4)
				)
			)
			(if (== argc 2)
				(param1 mover: 0)
				(self dispose:)
				(return)
			)
		)
		(if (not fEntry)
			(self entryIO: (+ temp9 1) @temp10 0 2)
			(self entryIO: (= fEntry temp10) @temp0 0 2)
			(if temp0
				(++ fEntry)
				(= fToX [param2 1])
				(= fToY [param2 2])
				(= temp3 0)
				(= temp24 (= temp23 -1))
				(while (< temp3 temp0)
					(self entryIO: fEntry @temp29 0 8)
					(if (& temp29 $4000)
						(if
							(and
								(= temp4
									(gEgo
										inRect:
											(& temp29 $01ff)
											temp30
											temp31
											temp32
									)
								)
								(== temp23 -1)
							)
							(= temp23 temp3)
						)
						(if
							(localproc_0
								fToX
								fToY
								(& temp29 $01ff)
								temp30
								temp31
								temp32
							)
							(if temp4
								(= temp23 (= temp24 -1))
								(break)
							)
							(if (== temp24 -1)
								(= temp24 temp3)
							)
						)
					)
					(++ temp3)
					(+= fEntry 4)
				)
				(if (and (!= temp23 -1) (!= temp24 -1))
					(= temp13 (+ temp10 (* temp0 4) 1))
					(repeat
						(self entryIO: (= fEntry temp13) @temp11 0 6)
						(breakif
							(or
								(== temp11 -1)
								(and (== temp23 temp11) (== temp24 temp12))
							)
						)
						(if (and (== temp23 temp12) (== temp24 temp11))
							(= fDir (- 0 fDir))
							(break)
						)
					)
					(if (!= temp11 -1)
						(self entryIO: (+= fEntry 3) @temp26 0 6)
						(if (> temp28 0)
							(= firstNode temp26)
							(= lastNode temp27)
						else
							(= firstNode temp27)
							(= lastNode temp26)
						)
						(= iCount (Abs temp28))
						(if (== fDir 3)
							(= fToEntry temp27)
							(= fBIEntry
								(self closestNode: (param1 x:) (param1 y:))
							)
							(= fPDir temp28)
						else
							(= fBAEntry (self closestNode: fToX fToY))
						)
						(self entryIO: (- temp13 3) @temp26 0 6)
						(if (> temp28 0)
							(= firstNode temp26)
							(= lastNode temp27)
						else
							(= firstNode temp27)
							(= lastNode temp26)
						)
						(= iCount (Abs temp28))
						(if (== fDir 3)
							(= fBAEntry (self closestNode: fToX fToY))
						else
							(= fToEntry temp26)
							(= fBIEntry
								(self closestNode: (param1 x:) (param1 y:))
							)
							(= fEntry (- temp13 3))
							(= fPDir temp28)
						)
						(if (< fDir 0)
							(= fPDir (- 0 fPDir))
						)
						(self entryIO: (= fPEntry fBIEntry) @temp19 0 4)
						(= bIntoX (= bIntoY (= brkAway 0)))
						(super init: param1 param2 (& temp19 $01ff) temp20)
						(return)
					)
				)
			)
		)
		(super init: param1 param2 &rest)
	)

	(method (getFLNodes param1 &tmp temp0 temp1 temp2)
		(= temp0 1)
		(repeat
			(self entryIO: temp0 @temp1 0 4)
			(if (< param1 temp2)
				(= firstNode temp1)
				(= lastNode (- temp2 (Abs fPDir)))
				(break)
			)
			(++ temp0)
		)
	)

	(method (moveDone &tmp temp0 temp1 [temp2 2] temp4 temp5 temp6)
		(if fPEntry
			(if fBIEntry
				(self entryIO: fBIEntry @temp0 0 4)
				(if
					(and
						(== (&= temp0 $01ff) (client x:))
						(== temp1 (client y:))
					)
					(self getFLNodes: fBIEntry)
					(= fBIEntry 0)
				)
			)
			(if (not fBIEntry)
				(cond
					((== fPEntry fBAEntry)
						(= temp0 fToX)
						(= temp1 fToY)
						(= fPEntry (= brkAway 0))
					)
					((!= fPEntry fToEntry)
						(= pEntry fPEntry)
						(= pDir fPDir)
						(= iCount (Abs pDir))
						(self next: @temp0)
						(= fPEntry pEntry)
						(= brkAway -1)
					)
					(else
						(self entryIO: (+= fEntry fDir) @temp4 0 6)
						(if (> fDir 0)
							(= fPEntry temp4)
							(= fToEntry temp5)
							(= fPDir temp6)
						else
							(= fPEntry temp5)
							(= fToEntry temp4)
							(= fPDir (- 0 temp6))
						)
						(= iCount (Abs (= pDir fPDir)))
						(self getFLNodes: fPEntry)
						(= pEntry (- fPEntry pDir))
						(self next: @temp0)
						(= brkAway -1)
					)
				)
			)
			(super init: client aIPath (& temp0 $01ff) temp1)
		else
			(super moveDone: dispoSelf)
			(= dispoSelf 1)
		)
	)
)

