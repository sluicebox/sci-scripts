;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 238)
(include sci.sh)
(use Motion)
(use Actor)

(procedure (setDeltaX theDir DX)
	(switch theDir
		(0
			(= DX 0)
		)
		(4
			(= DX 0)
		)
		(5
			(= DX (- DX))
		)
		(6
			(= DX (- DX))
		)
		(7
			(= DX (- DX))
		)
	)
	(return DX)
)

(procedure (setDeltaY theDir DY)
	(switch theDir
		(0
			(= DY (- DY))
		)
		(1
			(= DY (- DY))
		)
		(2
			(= DY 0)
		)
		(6
			(= DY 0)
		)
		(7
			(= DY (- DY))
		)
	)
	(return DY)
)

(class MazeBug of Act
	(properties
		xStep 2
		startX 0
		startY 0
		deadTime 0
		otherBug 0
		form 0
		smarts 5
		path 0
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4 fixState:)
	)

	(method (highPri)
		(self setPri: 7 fixState:)
	)

	(method (lowPri)
		(self setPri: 4 fixState:)
	)

	(method (changeForm &tmp newLoop)
		(= newLoop (+ loop 1))
		(if (> (++ form) 2)
			(= form 0)
			(-= newLoop 3)
		)
		(self setLoop: newLoop fixState:)
		(if (and (!= form 1) (== (self onControl: 1) 4))
			(self die:)
		)
	)

	(method (fixState)
		(= illegalBits -32768)
		(if (<= priority 4)
			(|= illegalBits $4000)
		else
			(|= illegalBits $2000)
		)
		(switch form
			(0
				(|= illegalBits $0004)
				(= moveSpeed (= cycleSpeed 0))
			)
			(1
				(|= illegalBits $2000)
				(= moveSpeed (= cycleSpeed 1))
			)
			(2
				(|= illegalBits $2004)
				(= moveSpeed (= cycleSpeed 2))
			)
		)
	)

	(method (doit &tmp whichControl)
		(if deadTime
			(if (not (-- deadTime))
				(self
					posn: startX startY
					setLoop: (- loop (- form 0))
					form: 0
					lowPri:
					fixState:
				)
			)
		else
			(super doit:)
		)
	)

	(method (canBeHere &tmp canWe ctrls)
		(if
			(and
				(= canWe (super canBeHere:))
				(or
					(and
						(& (= ctrls (self onControl: 0)) $1000)
						(self nearRock: 25)
					)
					(and (& ctrls $0800) (not (self nearBridge: 25)))
					(and (& ctrls $0004) (not (self nearLadder: 25)))
				)
			)
			(= canWe 0)
		)
		(return canWe)
	)

	(method (die)
		(= deadTime 20)
	)

	(method (nearRock)
		(return 0)
	)

	(method (nearBridge)
		(return 1)
	)

	(method (nearLadder)
		(return 1)
	)
)

(class MazeMove of Motion
	(properties
		curDir 5
		prevDir 5
		ditherTime 0
		altMove 0
		prevControl 0
	)

	(method (init actor xTo yTo toCall &tmp cy theAngle)
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
		(client heading: (= theAngle (GetAngle (client x:) (client y:) x y)))
		(= prevDir (= curDir (self calcDir: theAngle)))
		(= b-moveCnt 0)
		(if (= cy (client cycler:))
			(cy cycleCnt: 0)
		)
	)

	(method (calcDir theHeading)
		(return
			(cond
				((or (<= theHeading 22) (> theHeading 337)) 0)
				((<= theHeading 67) 1)
				((<= theHeading 112) 2)
				((<= theHeading 157) 3)
				((<= theHeading 202) 4)
				((<= theHeading 247) 5)
				((<= theHeading 292) 6)
				((<= theHeading 337) 7)
			)
		)
	)

	(method (doit &tmp clForm thisControl)
		(if ditherTime
			(-- ditherTime)
			(return)
		)
		(if (> (++ b-moveCnt) (client moveSpeed:))
			(= b-moveCnt 0)
			(= clForm (client form:))
			(if
				(and
					(!= (= thisControl (client onControl: 1)) prevControl)
					(< (client priority:) 4)
				)
				(client setPri: 4)
			)
			(switch thisControl
				(256
					(client lowPri:)
				)
				(512
					(client highPri:)
				)
				(4
					(if (not (client nearLadder: 25))
						(client die:)
					)
				)
				(2048
					(if (not (client nearBridge: 25))
						(client die:)
					)
				)
				(64
					(self chooseRoute: 0)
				)
				(8192
					(if (== (client priority:) 4)
						(client setPri: 2)
					)
				)
				(32
					(if (== (client priority:) 4)
						(client setPri: 2)
					)
				)
			)
			(= prevControl thisControl)
			(self doMove:)
		)
		(if (and (<= (Abs (- x (client x:))) 2) (<= (Abs (- y (client y:))) 2))
			(self moveDone:)
			(return)
		)
	)

	(method (doMove &tmp temp0 temp1 [temp2 2] temp4 temp5 temp6)
		(if (== (Random 1 10) 7)
			(self setHeading: (= temp4 (Random 0 7)))
		)
		(= temp0 (client x:))
		(= temp1 (client y:))
		(if (self tryStep: temp0 temp1 curDir)
			(= prevDir curDir)
		else
			(self chooseRoute: 1)
			(= temp6 (client moveSpeed:))
			(= ditherTime (+ 1 temp6 temp6))
			(client signal: (| (client signal:) $0400) forceUpd:)
			(return 0)
		)
		(client forceUpd:)
		(return 1)
	)

	(method (tryStep oldX oldY theDir &tmp DX DY)
		(= DX (client xStep:))
		(= DY (client yStep:))
		(if (== (++ altMove) 2)
			(= altMove 0)
			(if (& curDir $0001)
				(<<= DX $0001)
				(<<= DY $0001)
			)
		)
		(= DX (setDeltaX theDir DX))
		(= DY (setDeltaY theDir DY))
		(client x: (+ oldX DX) y: (+ oldY DY))
		(BaseSetter client)
		(if (client canBeHere:)
			(return 1)
		else
			(if (== (++ altMove) 2)
				(= altMove 0)
			)
			(client x: oldX y: oldY)
			(BaseSetter client)
			(client signal: (| (client signal:) $0400) forceUpd:)
			(return 0)
		)
	)

	(method (chooseRoute wasBlocked &tmp theAngle newDir incr aDir sm best cur bestDir other forms dist)
		(= newDir curDir)
		(if (== (Random 1 3) 2)
			(= theAngle (GetAngle (client x:) (client y:) x y))
			(= newDir (self calcDir: theAngle))
		)
		(= other (client otherBug:))
		(if (< (= dist (client distanceTo: other)) 30)
			(cond
				((== (= forms (- (client form:) (other form:))) -1)
					(= theAngle
						(GetAngle (other x:) (other y:) (client x:) (client y:))
					)
					(= newDir (self calcDir: theAngle))
				)
				(
					(and
						(< dist 12)
						(== forms 1)
						(== (client priority:) (other priority:))
					)
					(other die:)
				)
				((or (== forms 1) (and (== forms 0) (not (Random 0 3))))
					(= theAngle
						(GetAngle (client x:) (client y:) (other x:) (other y:))
					)
					(= newDir (self calcDir: theAngle))
				)
			)
		)
		(= bestDir newDir)
		(for ((= incr (= best 0))) (<= incr 4) ((++ incr))
			(= cur (self checkRoute: (= aDir (mod (+ newDir incr) 8))))
			(if (== aDir (mod (+ curDir 4) 8))
				(-= cur 4)
			)
			(if (> cur best)
				(= best cur)
				(= bestDir aDir)
			)
			(= cur (self checkRoute: (= aDir (mod (- (+ newDir 8) incr) 8))))
			(if (== aDir (mod (+ curDir 4) 8))
				(-= cur 4)
			)
			(if (> cur best)
				(= best cur)
				(= bestDir aDir)
			)
		)
		(for
			((= newDir bestDir))
			(and wasBlocked (== curDir newDir))
			((= newDir (Random 0 7)))
		)
		(self setHeading: newDir)
		(client forceUpd:)
		(return curDir)
	)

	(method (checkRoute theDir &tmp oldX oldY curX curY sm index)
		(= curX (= oldX (client x:)))
		(= curY (= oldY (client y:)))
		(= sm (/ (client smarts:) 2))
		(for ((= index 0)) (< index sm) ((++ index))
			(if (not (self tryStep: curX curY theDir))
				(break)
			)
		)
		(client x: oldX y: oldY)
		(BaseSetter client)
		(return index)
	)

	(method (setHeading newHeading)
		(= prevDir curDir)
		(= curDir newHeading)
		(client
			heading:
				(switch curDir
					(0 0)
					(1 45)
					(2 90)
					(3 135)
					(4 180)
					(5 225)
					(6 270)
					(7 315)
				)
		)
	)
)

