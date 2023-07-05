;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
(include sci.sh)
(use Main)
(use PuzzleBar)
(use Array)
(use Motion)
(use Actor)
(use System)

(public
	maze 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
)

(procedure (localproc_0 &tmp temp0 temp1 [temp2 2])
	(= local21 0)
	(ant hide:)
	(local7 at: 0 30687)
	(local7 at: 1 5460)
	(local7 at: 2 32119)
	(local7 at: 3 16705)
	(local7 at: 4 24437)
	(local7 at: 5 20741)
	(local7 at: 6 32223)
	(local7 at: 7 1104)
	(local7 at: 8 32637)
	(local7 at: 9 4357)
	(local7 at: 10 22391)
	(local7 at: 11 20561)
	(local7 at: 12 24031)
	(local7 at: 13 20800)
	(local7 at: 14 32639)
	(mazeIcon cel: 0)
	(= local16 14)
	(= local17 10)
	(= local10 14)
	(= local11 0)
	(mykey x: (localproc_4 14) y: (localproc_6 0) cel: 0)
	(local8 at: 0 4)
	(local9 at: 0 2)
	(local8 at: 1 4)
	(local9 at: 1 4)
	(local8 at: 2 6)
	(local9 at: 2 6)
	(local8 at: 3 10)
	(local9 at: 3 10)
	(local8 at: 4 10)
	(local9 at: 4 14)
	(local8 at: 5 0)
	(local9 at: 5 0)
	(local8 at: 6 8)
	(local9 at: 6 0)
	(local8 at: 7 14)
	(local9 at: 7 8)
	(local8 at: 8 12)
	(local9 at: 8 10)
	(= local5 0)
	(= local4 14)
	(if (ant mover:)
		((ant mover:) caller: 0)
	)
	(= local26 1)
	(for ((= temp1 0)) (< temp1 local6) ((++ temp1))
		((local30 at: temp1)
			x: (localproc_5 (local8 at: temp1))
			y: (localproc_7 (local9 at: temp1))
		)
	)
	(maze setScript: antOut)
)

(procedure (localproc_1)
	(= local10 14)
	(= local11 0)
	(mykey x: (localproc_4 14) y: (localproc_6 0) setLoop: 9 1 cel: 0 show:)
	(= local16 14)
	(= local17 10)
	(local8 at: 0 4)
	(local9 at: 0 2)
	(local8 at: 1 4)
	(local9 at: 1 4)
	(local8 at: 2 6)
	(local9 at: 2 6)
	(local8 at: 3 10)
	(local9 at: 3 10)
	(local8 at: 4 10)
	(local9 at: 4 14)
	(local8 at: 5 0)
	(local9 at: 5 0)
	(local8 at: 6 8)
	(local9 at: 6 0)
	(local8 at: 7 14)
	(local9 at: 7 8)
	(local8 at: 8 12)
	(local9 at: 8 10)
	(= local5 0)
	(= local4 14)
)

(procedure (localproc_2)
	(mykey cel: (mazeIcon cel:))
	(switch (mazeIcon cel:)
		(0
			(local7 at: 0 30687)
			(local7 at: 1 5460)
			(local7 at: 2 32119)
			(local7 at: 3 16705)
			(local7 at: 4 24437)
			(local7 at: 5 20741)
			(local7 at: 6 32223)
			(local7 at: 7 1104)
			(local7 at: 8 32637)
			(local7 at: 9 4357)
			(local7 at: 10 22391)
			(local7 at: 11 20561)
			(local7 at: 12 24031)
			(local7 at: 13 20800)
			(local7 at: 14 32639)
		)
		(1
			(local7 at: 0 24445)
			(local7 at: 1 20757)
			(local7 at: 2 30581)
			(local7 at: 3 16709)
			(local7 at: 4 30173)
			(local7 at: 5 5201)
			(local7 at: 6 32223)
			(local7 at: 7 16644)
			(local7 at: 8 32631)
			(local7 at: 9 17489)
			(local7 at: 10 30165)
			(local7 at: 11 5445)
			(local7 at: 12 30591)
			(local7 at: 13 20801)
			(local7 at: 14 24415)
		)
		(2
			(local7 at: 0 32639)
			(local7 at: 1 325)
			(local7 at: 2 32221)
			(local7 at: 3 17669)
			(local7 at: 4 30581)
			(local7 at: 5 20549)
			(local7 at: 6 24447)
			(local7 at: 7 1296)
			(local7 at: 8 32223)
			(local7 at: 9 20549)
			(local7 at: 10 22397)
			(local7 at: 11 16705)
			(local7 at: 12 30559)
			(local7 at: 13 5460)
			(local7 at: 14 32247)
		)
		(else
			(local7 at: 0 32125)
			(local7 at: 1 16709)
			(local7 at: 2 32631)
			(local7 at: 3 20820)
			(local7 at: 4 21975)
			(local7 at: 5 17681)
			(local7 at: 6 30591)
			(local7 at: 7 4161)
			(local7 at: 8 32223)
			(local7 at: 9 17684)
			(local7 at: 10 24023)
			(local7 at: 11 20801)
			(local7 at: 12 22391)
			(local7 at: 13 21573)
			(local7 at: 14 24445)
		)
	)
)

(procedure (localproc_3 param1 &tmp temp0 temp1)
	(if param1
		(for ((= temp0 0)) (< temp0 local6) ((++ temp0))
			(= temp1 (local8 at: temp0))
			(local8 at: temp0 (local9 at: temp0))
			(local9 at: temp0 (- 14 temp1))
		)
		(= temp1 local10)
		(= local10 local11)
		(= local11 (- 14 temp1))
		(= temp1 local16)
		(= local16 local17)
		(= local17 (- 14 temp1))
	else
		(for ((= temp0 0)) (< temp0 local6) ((++ temp0))
			(= temp1 (local9 at: temp0))
			(local9 at: temp0 (local8 at: temp0))
			(local8 at: temp0 (- 14 temp1))
		)
		(= temp1 local11)
		(= local11 local10)
		(= local10 (- 14 temp1))
		(= temp1 local17)
		(= local17 local16)
		(= local16 (- 14 temp1))
	)
	(mykey x: (localproc_4 local10) y: (localproc_6 local11))
)

(procedure (localproc_4 param1)
	(return (+ 31 (* 14 (/ param1 2))))
)

(procedure (localproc_5 param1)
	(return (+ 29 (* 14 (/ param1 2))))
)

(procedure (localproc_6 param1)
	(return (+ 36 (* 10 (/ param1 2))))
)

(procedure (localproc_7 param1)
	(return (+ 33 (* 10 (/ param1 2))))
)

(procedure (localproc_8 &tmp temp0 temp1 temp2)
	(= local24 0)
	(= temp1 0)
	(while
		(and
			(>= (= temp0 (- local4 (++ temp1))) 0)
			(& (local7 at: local5) (<< $0001 temp0))
		)
	)
	(= temp2 0)
	(while
		(and
			(< (= temp0 (+ local4 (++ temp2))) 15)
			(& (local7 at: local5) (<< $0001 temp0))
		)
	)
	(if (== temp1 0)
		(return 0)
	else
		(if (> temp1 6)
			(= temp1 4)
		)
		(if (== (/ temp1 2) 1)
			(= local24 -3)
		else
			(= local24 -4)
		)
		(return (* (/ temp1 2) 9))
	)
)

(procedure (localproc_9 &tmp temp0)
	(= local13 0)
	(while
		(and
			(< (= temp0 (+ local4 (++ local13))) 15)
			(& (local7 at: local5) (<< $0001 temp0))
		)
	)
	(if (-- local13)
		(return 0)
	else
		(return (localproc_6 local4))
	)
)

(procedure (localproc_10 &tmp [temp0 2] temp2 temp3 temp4 temp5)
	(= local21 0)
	(= local15 0)
	(while
		(and
			(< (= temp2 (+ local4 (++ local15))) 15)
			(& (local7 at: local5) (<< $0001 temp2))
		)
		(if (and (== local5 local10) (== (+ local4 local15) local11))
			(= local20 1)
			(return 2)
		)
		(for ((= temp3 0)) (< temp3 local6) ((++ temp3))
			(if
				(and
					(== local5 (local8 at: temp3))
					(== (+ local4 local15) (local9 at: temp3))
				)
				(= local21 1)
				(return 1)
			)
		)
	)
	(= local15 0)
	(= local14 0)
	(localproc_9)
	(if local13
		(= temp4 (+ local4 local13))
	else
		(= temp4 local4)
	)
	(while
		(and
			(< local14 4)
			(>= (= temp2 (- temp4 (++ local14))) 0)
			(& (local7 at: local5) (<< $0001 temp2))
		)
		(if (and (== local5 local10) (== (- temp4 local14) local11))
			(= local20 1)
			(return 2)
		)
		(for ((= temp3 0)) (< temp3 local6) ((++ temp3))
			(if
				(and
					(== local5 (local8 at: temp3))
					(== (- temp4 local14) (local9 at: temp3))
				)
				(= local21 1)
				(return 1)
			)
		)
	)
	(return 0)
)

(instance maze of PuzzleBar
	(properties)

	(method (init &tmp temp0)
		(= local31 1)
		(= local27 (gTheCursor view:))
		(= local28 (gTheCursor loop:))
		(= local29 (gTheCursor cel:))
		(gGlory
			setCursor:
				((gTheIconBar getCursor:) view: 999 loop: 0 cel: 0 yourself:)
		)
		(= local8 (IntArray new:))
		(= local9 (IntArray new:))
		(= local30 (IntArray new:))
		(= local7
			(IntArray
				with:
					30687
					5460
					32119
					16705
					24437
					20741
					32223
					1104
					32637
					4357
					22391
					20561
					24031
					20800
					32639
			)
		)
		(localproc_1)
		(super init:)
		(puzzleCast
			add: (ant init: self yourself:) (mykey init: self yourself:)
		)
		(= local6
			(switch global439
				(3 9)
				(2 5)
				(else 0)
			)
		)
		(for ((= temp0 0)) (< temp0 local6) ((++ temp0))
			(local30
				at:
					temp0
					((holeIcon new:)
						x: (localproc_5 (local8 at: temp0))
						y: (localproc_7 (local9 at: temp0))
						init: self
						yourself:
					)
			)
			(puzzleCast add: (local30 at: temp0))
		)
		(self add: mazeIcon leftSide rightSide bottomSide rotateL rotateR)
		(self eachElementDo: #init self)
	)

	(method (setPlane)
		(= usePlane 1)
		(plane bitmap: 0)
		(plane
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 82 40 250 182
			setBitmap: 935 0 0 1
			addCast: puzzleCast
		)
	)

	(method (resetPuzzle)
		(= local18 0)
		(= local12 0)
		(= local20 0)
		(self setScript: antOut)
	)

	(method (giveYou)
		(gMessager say: 21 4 24) ; "You're not yet carrying anything that would be useful here."
	)

	(method (dispose)
		(local7 dispose:)
		(local8 dispose:)
		(local9 dispose:)
		(local30 dispose:)
		(gGlory
			setCursor:
				((gTheIconBar getCursor:)
					view: local27
					loop: local28
					cel: local29
					yourself:
				)
		)
		(super dispose:)
	)

	(method (hide)
		(if local18
			(if (not (gEgo has: 58)) ; lab-key
				(gEgo solvePuzzle: 409 6 get: 58) ; lab-key
			)
			(gMessager say: 18 6 20) ; "Congratulations! You've used the Baby Antwerp to get Dr. Cranium's laboratory key from the maze! You add the key to your key ring."
		)
		(super hide: &rest)
	)

	(method (helpYou)
		(gMessager say: 18 9 0 local31)
		(if (< local31 5)
			(++ local31)
		else
			(gEgo get: 58) ; lab-key
			(self hide:)
		)
	)
)

(instance antOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(maze noHands: 1)
				(cond
					(local26
						(= local26 0)
						(gMessager say: 18 6 29 0 self) ; "The Antwerp has found a hole in the space-time continuum and slipped back to the beginning of the maze."
					)
					((not (IsFlag 409))
						(gMessager say: 18 6 19 0 self) ; "This is the Antwerp maze. Antwerps are naturally bouncy, so all you have to do is continually rotate the maze until the Baby Antwerp bounces over to the key, then out through the exit."
					)
					(else
						(= ticks 1)
					)
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(ant
					x: (= temp1 (localproc_4 local5))
					y: (= temp2 (+ (localproc_6 local4) 1))
					setLoop: 12 1
					cel: 0
					cycleSpeed: 12
					setCycle: End self
					show:
				)
			)
			(3
				(= temp0 (localproc_8))
				(ant
					x: (= temp1 (localproc_4 local5))
					y: (= temp2 (localproc_6 local4))
					setLoop: 1 1
					cel: 0
					moveSpeed: (/ (+ (gEgo moveSpeed:) 1) 2)
					setMotion: (bounceTo new:) temp1 (- (- temp2 temp0) 2)
				)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(maze noHands: 0)
		(super dispose:)
	)
)

(instance ant of Actor
	(properties
		priority 254
		fixPriority 1
		view 382
		loop 1
		yStep 1
		signal 16385
		illegalBits 0
	)

	(method (onMe)
		(return 0)
	)

	(method (setMotion)
		(if local24
			(= local23 local24)
		)
		(self setLoop: 1 1)
		(ant cel: 0)
		(super setMotion: &rest)
	)

	(method (cue)
		(maze noHands: 0)
		(+= local4 local13)
		(self
			moveSpeed: (/ (+ (gEgo moveSpeed:) 1) 2)
			setCycle: 0
			setMotion: (bounceTo new:) x (- (- y (localproc_8)) 2)
		)
	)
)

(instance mykey of View
	(properties
		priority 254
		fixPriority 1
		view 382
		loop 9
		signal 16384
	)

	(method (onMe)
		(return 0)
	)
)

(instance holeIcon of View
	(properties
		priority 254
		fixPriority 1
		view 382
		loop 8
		signal 16384
	)

	(method (onMe)
		(return 0)
	)
)

(instance mazeIcon of TextIcon
	(properties
		priority 189
		fixPriority 1
		view 382
		cel 0
	)

	(method (highlight))

	(method (select))

	(method (onMe)
		(return 0)
	)

	(method (init)
		(= nsLeft (= x (+ (- 77 (/ (CelWide 382 0 0) 2)) 3)))
		(= nsTop (= y 30))
		(super init: &rest)
	)
)

(instance rotateL of TextIcon
	(properties
		view 382
		loop 3
	)

	(method (init)
		(= nsLeft (= x 8))
		(= nsTop (= y (- (+ 30 (CelHigh 382 0 0)) 12)))
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(if (super select: &rest)
			(if (< (+ (mazeIcon cel:) 1) 4)
				(mazeIcon cel: (+ (mazeIcon cel:) 1))
			else
				(mazeIcon cel: 0)
			)
			(if (= temp0 (ant mover:))
				(if (and (> (- (temp0 y:) local2) 0) (!= local19 0))
					(-= local4 (* (/ (- (temp0 y:) (ant y:)) 8) 2))
				else
					(-= local4 (* (/ (- local2 (ant y:)) 8) 2))
				)
			)
			(localproc_2)
			(localproc_3 1)
			(for ((= temp3 0)) (< temp3 local6) ((++ temp3))
				((local30 at: temp3)
					x: (localproc_5 (local8 at: temp3))
					y: (localproc_7 (local9 at: temp3))
				)
			)
			(= temp0 local5)
			(= local5 local4)
			(= local4 (- 14 temp0))
			(localproc_10)
			(= temp1 (localproc_4 local5))
			(if (not (= temp2 (localproc_9 local4)))
				(= temp2 (localproc_6 local4))
				(ant
					x: temp1
					y: temp2
					setCycle: 0
					setMotion:
						(myMoveTo new:)
						temp1
						(localproc_6 (+ local4 local13))
						ant
				)
			else
				(= temp0 (localproc_8))
				(ant x: temp1 y: temp2)
				(cond
					(temp0
						(ant
							moveSpeed: (/ (+ (gEgo moveSpeed:) 1) 2)
							setCycle: 0
							setMotion:
								(bounceTo new:)
								temp1
								(- (- temp2 temp0) 2)
						)
					)
					((and local12 (== local5 local16) (== local4 local17))
						(ant
							setCycle: 0
							setMotion:
								goOut
								temp1
								(localproc_6
									(if (> (+ local4 2) 14)
										(+ local4 2)
									else
										(- local4 2)
									)
								)
						)
					)
					(else
						(ant
							y: (+ (ant y:) 1)
							setMotion: 0
							setLoop: 13 1
							cycleSpeed: 6
							setCycle: Fwd
						)
					)
				)
			)
		)
	)
)

(instance rotateR of TextIcon
	(properties
		view 382
		loop 2
	)

	(method (init)
		(= nsLeft
			(= x
				(-
					(-
						154
						(CelWide (rotateR view:) (rotateR loop:) (rotateR cel:))
					)
					2
				)
			)
		)
		(= nsTop (= y (- (+ 30 (CelHigh 382 0 0)) 12)))
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(if (super select: &rest)
			(if (> (- (mazeIcon cel:) 1) -1)
				(mazeIcon cel: (- (mazeIcon cel:) 1))
			else
				(mazeIcon cel: 3)
			)
			(if (= temp0 (ant mover:))
				(if (and (> (- (temp0 y:) local2) 0) (!= local19 0))
					(-= local4 (* (/ (- (temp0 y:) (ant y:)) 8) 2))
				else
					(-= local4 (* (/ (- local2 (ant y:)) 8) 2))
				)
			)
			(localproc_2)
			(localproc_3 0)
			(for ((= temp3 0)) (< temp3 local6) ((++ temp3))
				((local30 at: temp3)
					x: (localproc_5 (local8 at: temp3))
					y: (localproc_7 (local9 at: temp3))
				)
			)
			(= temp0 local4)
			(= local4 local5)
			(= local5 (- 14 temp0))
			(localproc_10)
			(= temp1 (localproc_4 local5))
			(if (not (= temp2 (localproc_9 local4)))
				(= temp2 (localproc_6 local4))
				(ant
					x: temp1
					y: temp2
					setCycle: 0
					setMotion:
						(myMoveTo new:)
						temp1
						(localproc_6 (+ local4 local13))
						ant
				)
			else
				(= temp0 (localproc_8))
				(ant x: temp1 y: temp2 cel: 0)
				(cond
					(temp0
						(ant
							moveSpeed: (/ (+ (gEgo moveSpeed:) 1) 2)
							setCycle: 0
							setMotion:
								(bounceTo new:)
								temp1
								(- (- temp2 temp0) 2)
						)
					)
					((and local12 (== local5 local16) (== local4 local17))
						(ant
							setCycle: 0
							setMotion:
								goOut
								temp1
								(localproc_6
									(if (> (+ local4 2) 14)
										(+ local4 2)
									else
										(- local4 2)
									)
								)
						)
					)
					(else
						(ant
							y: (+ (ant y:) 1)
							setMotion: 0
							setLoop: 13 1
							cycleSpeed: 6
							setCycle: Fwd
						)
					)
				)
			)
		)
	)
)

(instance leftSide of TextIcon
	(properties
		x 8
		y 30
		view 382
		loop 4
		cel 0
	)

	(method (onMe)
		(return 0)
	)
)

(instance rightSide of TextIcon
	(properties
		x 140
		y 30
		view 382
		loop 4
		cel 0
	)

	(method (onMe)
		(return 0)
	)
)

(instance bottomSide of TextIcon
	(properties
		view 382
		loop 4
		cel 1
	)

	(method (init)
		(= x (+ (- 77 (/ (CelWide 382 4 1) 2)) 3))
		(= y (+ 35 (CelHigh 382 0 0)))
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance myMoveTo of MoveTo
	(properties)

	(method (init)
		(maze noHands: 1)
		(super init: &rest)
		(^= local22 local22)
		(= local1 (client x:))
		(= local2 (client y:))
		(= local19 0)
	)

	(method (doit)
		(if (> (++ local22) 3)
			(= local22 0)
			(if (> local2 y)
				(if dy
					(-- dy)
				)
			else
				(++ dy)
			)
		)
		(super doit:)
	)

	(method (moveDone)
		(cond
			(local20
				(= local12 1)
				(mykey hide:)
			)
			((and local21 local15)
				(= caller 0)
				(localproc_0)
			)
		)
		(super moveDone: &rest)
	)
)

(instance bounceTo of MoveTo
	(properties)

	(method (init)
		(super init: &rest)
		(client cel: 0)
		(if local23
			(= dy local23)
		)
		(^= local22 local22)
		(= local1 (client x:))
		(= local2 (client y:))
		(= local19 1)
	)

	(method (doit)
		(if (> (++ local22) 3)
			(= local22 0)
			(if (+ dy 1)
				(++ dy)
			)
		)
		(super doit:)
	)

	(method (moveDone)
		(if local21
			(super moveDone: &rest)
			(localproc_0)
		else
			(cond
				((> local2 y)
					(= local23 (- 0 dy))
				)
				(local24
					(= local23 local24)
				)
			)
			(self init: client local1 local2)
		)
	)
)

(instance bounceCycle of CT ; UNUSED
	(properties)

	(method (doit &tmp temp0)
		(if (> (= temp0 (self nextCel:)) 4)
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (motionCue)
		(super motionCue:)
		(client setLoop: 1 1 cel: 0)
		((client mover:) init: client local1 local2)
	)
)

(instance goOut of MoveTo
	(properties)

	(method (init)
		(maze noHands: 1)
		(super init: &rest)
		(= local19 3)
	)

	(method (moveDone)
		(super moveDone: &rest)
		(client hide:)
		(= local18 1)
		(maze state: (& (maze state:) $ffdf))
	)
)

