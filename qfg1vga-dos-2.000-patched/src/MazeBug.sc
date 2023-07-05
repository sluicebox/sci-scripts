;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 238)
(include sci.sh)
(use Motion)
(use Actor)

(procedure (localproc_0 param1 param2)
	(switch param1
		(0
			(= param2 0)
		)
		(4
			(= param2 0)
		)
		(5
			(= param2 (- param2))
		)
		(6
			(= param2 (- param2))
		)
		(7
			(= param2 (- param2))
		)
	)
	(return param2)
)

(procedure (localproc_1 param1 param2)
	(switch param1
		(0
			(= param2 (- param2))
		)
		(1
			(= param2 (- param2))
		)
		(2
			(= param2 0)
		)
		(6
			(= param2 0)
		)
		(7
			(= param2 (- param2))
		)
	)
	(return param2)
)

(class MazeBug of Actor
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

	(method (changeForm &tmp temp0)
		(= temp0 (+ loop 1))
		(if (> (++ form) 2)
			(= form 0)
			(-= temp0 3)
		)
		(self setLoop: temp0 fixState:)
		(if (and (!= form 1) (== (self onControl: 1) 4))
			(self die:)
		)
		(if (and (<= priority 4) (== form 0) (== (self onControl: 1) 32))
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
				(= moveSpeed (= cycleSpeed 6))
			)
			(1
				(|= illegalBits $2000)
				(= moveSpeed (= cycleSpeed 12))
			)
			(2
				(|= illegalBits $2004)
				(= moveSpeed (= cycleSpeed 18))
			)
		)
	)

	(method (doit &tmp temp0)
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

	(method (canBeHere &tmp temp0 temp1)
		(if (not (self cantBeHere:))
			(= temp0 1)
			(if
				(or
					(and
						(& (= temp1 (self onControl: 0)) $1000)
						(self nearRock: 20)
					)
					(and (& temp1 $0800) (not (self nearBridge: 20)))
					(and (& temp1 $0004) (not (self nearLadder: 20)))
				)
				(= temp0 0)
			)
		else
			(= temp0 0)
		)
		(return temp0)
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

	(method (init param1 param2 param3 param4 &tmp temp0 temp1)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= x param2)
				(if (>= argc 3)
					(= y param3)
					(if (>= argc 4)
						(= caller param4)
					)
				)
			)
		)
		(client heading: (= temp1 (GetAngle (client x:) (client y:) x y)))
		(= prevDir (= curDir (self calcDir: temp1)))
		(= b-moveCnt 0)
		(if (= temp0 (client cycler:))
			(temp0 cycleCnt: 0)
		)
	)

	(method (calcDir param1)
		(return
			(cond
				((or (<= param1 22) (> param1 337)) 0)
				((<= param1 67) 1)
				((<= param1 112) 2)
				((<= param1 157) 3)
				((<= param1 202) 4)
				((<= param1 247) 5)
				((<= param1 292) 6)
				((<= param1 337) 7)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if ditherTime
			(-- ditherTime)
			(return)
		)
		(if (> (++ b-moveCnt) (client moveSpeed:))
			(= b-moveCnt 0)
			(= temp0 (client form:))
			(if
				(and
					(!= (= temp1 (client onControl: 1)) prevControl)
					(< (client priority:) 4)
				)
				(client setPri: 4)
			)
			(switch temp1
				(256
					(client lowPri:)
				)
				(512
					(client highPri:)
				)
				(4
					(if (not (client nearLadder: 20))
						(client die:)
					)
				)
				(2048
					(if (not (client nearBridge: 20))
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
			(= prevControl temp1)
			(self doMove:)
		)
		(if (and (<= (Abs (- x (client x:))) 2) (<= (Abs (- y (client y:))) 2))
			(client posn: x y)
			(self moveDone:)
			(return)
		)
	)

	(method (doMove &tmp temp0 temp1 [temp2 2] temp4 temp5 temp6)
		(if (and (== self (ScriptID 32 2)) (== (Random 1 10) 7)) ; wizBug
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

	(method (tryStep param1 param2 param3 &tmp temp0 temp1)
		(= temp0 (client xStep:))
		(= temp1 (client yStep:))
		(if (== (++ altMove) 2)
			(= altMove 0)
			(if (& curDir $0001)
				(<<= temp0 $0001)
				(<<= temp1 $0001)
			)
		)
		(= temp0 (localproc_0 param3 temp0))
		(= temp1 (localproc_1 param3 temp1))
		(client x: (+ param1 temp0) y: (+ param2 temp1))
		(BaseSetter client)
		(if (client canBeHere:)
			(return 1)
		else
			(if (== (++ altMove) 2)
				(= altMove 0)
			)
			(client x: param1 y: param2)
			(BaseSetter client)
			(client signal: (| (client signal:) $0400) forceUpd:)
			(return 0)
		)
	)

	(method (chooseRoute param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= temp1 curDir)
		(if (or (== (Random 1 3) 2) (!= self (ScriptID 32 2))) ; wizBug
			(= temp0 (GetAngle (client x:) (client y:) x y))
			(= temp1 (self calcDir: temp0))
		)
		(= temp8 (client otherBug:))
		(if (< (= temp10 (client distanceTo: temp8)) 30)
			(cond
				((== (= temp9 (- (client form:) (temp8 form:))) -1)
					(= temp0
						(GetAngle (temp8 x:) (temp8 y:) (client x:) (client y:))
					)
					(= temp1 (self calcDir: temp0))
				)
				(
					(and
						(< temp10 20)
						(== temp9 1)
						(<= (Abs (- (client priority:) (temp8 priority:))) 2)
					)
					(temp8 die:)
				)
				((or (== temp9 1) (and (== temp9 0) (not (Random 0 3))))
					(= temp0
						(GetAngle (client x:) (client y:) (temp8 x:) (temp8 y:))
					)
					(= temp1 (self calcDir: temp0))
				)
			)
		)
		(= temp7 temp1)
		(for ((= temp2 (= temp5 0))) (<= temp2 4) ((++ temp2))
			(= temp6 (self checkRoute: (= temp3 (mod (+ temp1 temp2) 8))))
			(if (== temp3 (mod (+ curDir 4) 8))
				(-= temp6 4)
			)
			(if (> temp6 temp5)
				(= temp5 temp6)
				(= temp7 temp3)
			)
			(= temp6 (self checkRoute: (= temp3 (mod (- (+ temp1 8) temp2) 8))))
			(if (== temp3 (mod (+ curDir 4) 8))
				(-= temp6 4)
			)
			(if (> temp6 temp5)
				(= temp5 temp6)
				(= temp7 temp3)
			)
		)
		(for
			((= temp1 temp7))
			(and param1 (== curDir temp1))
			((= temp1 (Random 0 7)))
		)
		(self setHeading: temp1)
		(client forceUpd:)
		(return curDir)
	)

	(method (checkRoute param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp2 (= temp0 (client x:)))
		(= temp3 (= temp1 (client y:)))
		(= temp4 (/ (client smarts:) 2))
		(for ((= temp5 0)) (< temp5 temp4) ((++ temp5))
			(if (not (self tryStep: temp2 temp3 param1))
				(break)
			)
		)
		(client x: temp0 y: temp1)
		(BaseSetter client)
		(return temp5)
	)

	(method (setHeading param1)
		(= prevDir curDir)
		(= curDir param1)
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

