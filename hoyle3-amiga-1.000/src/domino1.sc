;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use KeyMouse)
(use dominoes_opt)
(use Interface)
(use RandCycle)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	domino1 0
	proc100_1 1
	proc100_2 2
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
	[local14 49]
	[local63 48] = [0 0 0 0 0 0 3 3 3 3 3 3 3 1 1 1 1 1 1 1 1 1 1 1 1 2 2 0 0 0 0 0 0 0 0 0 2 2 1 1 1 1 1 1 1 1 1 1]
	[local111 48] = [1 1 1 1 1 1 2 2 2 2 2 2 2 0 0 0 0 0 0 0 0 0 0 0 0 3 3 1 1 1 1 1 1 1 1 1 3 3 0 0 0 0 0 0 0 0 0 0]
)

(procedure (proc100_1 &tmp temp0 temp1 temp2)
	(if global132
		(= temp0 (= temp1 -1))
		(if (= temp2 (global118 highestDouble:))
			(= temp0 (temp2 pips1:))
		)
		(if (= temp2 (global119 highestDouble:))
			(= temp1 (temp2 pips1:))
		)
		(= global145
			(= global111 (if (> temp0 temp1) global118 else global119))
		)
		(gTheArrow init:)
		(global145 doProbs:)
	)
	(= local13 (gSystemWindow back:))
	(gSystemWindow back: 21)
	(Print (Format @global550 199 6 (global111 playerName:)) #at -1 17 #dispose) ; "%s's play first."
	(gSystemWindow back: local13)
	(proc0_1)
)

(procedure (proc100_2 param1)
	(proc101_0 param1)
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(localproc_3)
	(= temp3 (if (== global111 global118) global119 else global118))
	(= temp2 (+ (temp3 size:) (BoneYard size:)))
	(for ((= temp0 0)) (< temp0 49) ((++ temp0))
		(if [local14 temp0]
			(if (BoneYard size:)
				(= [local14 temp0]
					(/ (* (temp3 size:) 100) (+ (BoneYard size:) (temp3 size:)))
				)
			else
				(= [local14 temp0] 100)
			)
		)
	)
)

(procedure (localproc_1 param1 param2)
	(return (+ (localproc_6 param1) (localproc_6 param2)))
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1)
	(for ((= temp1 (= temp0 0))) (< temp1 (global111 size:)) ((++ temp1))
		(if
			(and
				(!= (global111 at: temp1) param2)
				(or
					(== ((global111 at: temp1) pips1:) param1)
					(== ((global111 at: temp1) pips2:) param1)
				)
			)
			(++ temp0)
		)
	)
	(return temp0)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2)
	(= temp2 (if (== global111 global118) global119 else global118))
	(for ((= temp0 0)) (< temp0 49) ((++ temp0))
		(= [local14 temp0] 100)
	)
	(for ((= temp0 0)) (< temp0 (global111 size:)) ((++ temp0))
		(localproc_5 (global111 at: temp0) 0)
	)
	(for ((= temp0 0)) (< temp0 (theForks size:)) ((++ temp0))
		(for ((= temp1 0)) (< temp1 ((theForks at: temp0) size:)) ((++ temp1))
			(localproc_5 ((theForks at: temp0) at: temp1) 0)
		)
	)
	(localproc_4 (temp2 outOf1:) 0)
	(localproc_4 (temp2 outOf2:) 0)
	(localproc_4 (temp2 outOf3:) 0)
	(localproc_4 (temp2 outOf4:) 0)
)

(procedure (localproc_4 param1 param2 param3 &tmp temp0)
	(if (>= param1 0)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(if (!= param2 -1)
				(= [local14 (+ (* param1 7) temp0)] param2)
			)
			(if (>= argc 3)
				(= [local14 (+ (* param1 7) temp0)]
					(+ [local14 (+ (* param1 7) temp0)] param3)
				)
			)
		)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(if (!= param2 -1)
				(= [local14 (+ (* temp0 7) param1)] param2)
			)
			(if (and (>= argc 3) (!= temp0 param1))
				(= [local14 (+ (* param1 7) temp0)]
					(+ [local14 (+ (* param1 7) temp0)] param3)
				)
			)
		)
	)
)

(procedure (localproc_5 param1 param2 &tmp temp0)
	(= [local14 (+ (* (param1 pips1:) 7) (param1 pips2:))] param2)
	(= [local14 (+ (* (param1 pips2:) 7) (param1 pips1:))] param2)
)

(procedure (localproc_6 param1 &tmp temp0 temp1 temp2)
	(for ((= temp1 (= temp2 0))) (< temp1 7) ((++ temp1))
		(if [local14 (+ (* param1 7) temp1)]
			(++ temp2)
		)
	)
	(return temp2)
)

(class Domino of KMActor
	(properties
		view 100
		pips1 0
		pips2 0
		oldX 0
		oldY 0
		facing 2
		numPlayableLeftFork 0
		numPlayableRightFork 0
		numReplayableLeftFork 0
		numReplayableRightFork 0
		freeEnd 0
		inTree 0
	)

	(method (setNumPlayable)
		(= numPlayableLeftFork (self testPips: leftFork))
		(= numPlayableRightFork (self testPips: rightFork))
	)

	(method (testPips param1 &tmp temp0)
		(if (not (param1 size:))
			(return 28)
		)
		(if (!= (self pips1:) (param1 pipValue:))
			(if (!= (self pips2:) (param1 pipValue:))
				(return 999)
			)
			(= temp0 (self pips1:))
		else
			(= temp0 (self pips2:))
		)
		(return
			(localproc_1
				(if (== param1 leftFork)
					temp0
				else
					(leftFork pipValue:)
				)
				(if (== param1 rightFork)
					temp0
				else
					(rightFork pipValue:)
				)
			)
		)
	)

	(method (setNumReplayable)
		(= numReplayableLeftFork (self replayable: leftFork))
		(= numReplayableRightFork (self replayable: rightFork))
	)

	(method (replayable param1 &tmp temp0)
		(if (not (param1 size:))
			(return
				(if (!= pips1 pips2)
					(+ (localproc_2 pips1 self) (localproc_2 pips2 self))
				else
					(localproc_2 pips1 self)
				)
			)
		)
		(if (!= pips1 (param1 pipValue:))
			(if (!= pips2 (param1 pipValue:))
				(return 0)
			)
			(= temp0 pips1)
		else
			(= temp0 pips2)
		)
		(return (localproc_2 temp0 self))
	)

	(method (flip)
		(self setLoop: pips1 cel: pips2)
	)

	(method (rectInRect param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (not param2)
			(return 1)
		)
		(= temp2 (param2 nsLeft:))
		(= temp3 (param2 nsRight:))
		(= temp0 (param2 nsTop:))
		(= temp1 (param2 nsBottom:))
		(= temp4
			(+
				temp2
				(/ (CelWide (param2 view:) (param2 loop:) (param2 cel:)) 2)
			)
		)
		(= temp5
			(+
				temp0
				(/ (CelHigh (param2 view:) (param2 loop:) (param2 cel:)) 2)
			)
		)
		(return
			(or
				(and
					(<= temp0 nsTop)
					(>= temp1 nsTop)
					(<= temp2 nsLeft)
					(>= temp3 nsLeft)
				)
				(and
					(<= temp0 nsTop)
					(>= temp1 nsTop)
					(<= temp2 nsRight)
					(>= temp3 nsRight)
				)
				(and
					(<= temp0 nsBottom)
					(>= temp1 nsBottom)
					(<= temp2 nsLeft)
					(>= temp3 nsLeft)
				)
				(and
					(<= temp0 nsBottom)
					(>= temp1 nsBottom)
					(<= temp2 nsRight)
					(>= temp3 nsRight)
				)
				(and
					(>= temp0 nsTop)
					(<= temp1 nsBottom)
					(or
						(and (<= temp2 nsLeft) (>= temp3 nsLeft))
						(and (<= temp2 nsRight) (>= temp3 nsRight))
						(and (>= temp2 nsLeft) (<= temp3 nsRight))
					)
				)
				(and
					(>= temp2 nsLeft)
					(<= temp3 nsRight)
					(or
						(and (<= temp0 nsTop) (>= temp1 nsTop))
						(and (<= temp0 nsBottom) (>= temp1 nsBottom))
						(and (>= temp0 nsTop) (<= temp1 nsBottom))
					)
				)
				(and (<= nsLeft temp4 nsRight) (<= nsTop temp5 nsBottom))
			)
		)
	)

	(method (inRect param1)
		(return
			(and
				(<= nsLeft (param1 x:) nsRight)
				(<= nsTop (param1 y:) nsBottom)
				(not (& signal $0080))
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event &rest)
		(if
			(and
				(== (BoneYard mode:) 0)
				(not (BoneYard contains: self))
				(self inRect: event)
			)
			(= local11 self)
			(event claimed: 1)
			(event claimed:)
			(return)
		)
		(if
			(and
				(not (event claimed:))
				(not (event modifiers:))
				(or (proc0_2 event) (& (event type:) evMOUSEBUTTON))
				(self inRect: event)
				(not (global111 moving:))
			)
			(event claimed: 1)
			(if (not (dominoHand2 contains: self))
				(= global110 self)
				(if (and (== (BoneYard mode:) 1) (< (domino1Script state:) 6))
					(cond
						((& (event type:) evMOUSEBUTTON)
							(if (global118 contains: self)
								(global118 dim:)
								(= temp0 (self track:))
								(= global115 0)
								(gTheInputList handleEvent: temp0)
								(if (not (temp0 claimed:))
									(gSound play: 904)
									(self
										setStep: 30 30
										setMotion: MoveTo oldX oldY self
									)
								)
								(temp0 dispose:)
							)
						)
						((proc0_2 event)
							(global111 highlight: self)
						)
					)
				)
			)
		)
		(event claimed:)
	)

	(method (track &tmp temp0 temp1 temp2 temp3 temp4)
		(= local1 0)
		(self setPri: 15)
		(= gDomino self)
		(= oldX x)
		(= oldY y)
		(= temp0 (- x (gMouseCursor x:)))
		(= temp1 (- y (gMouseCursor y:)))
		(tightCast add: self)
		(self startUpd:)
		(self view: 102)
		(for ((= temp3 0)) (< temp3 (theForks size:)) ((++ temp3))
			((theForks at: temp3) showDummy: self)
		)
		(Animate (tightCast elements:) 0)
		(proc0_1)
		(while (!= evMOUSERELEASE ((= temp2 (Event new:)) type:))
			(self x: (+ (temp2 x:) temp0) y: (+ (temp2 y:) temp1))
			(Animate (tightCast elements:) 0)
			(temp2 dispose:)
		)
		(self view: 100)
		(self stopUpd:)
		(tightCast release:)
		(return temp2)
	)

	(method (cue)
		(gSound play: 300)
		(if (== (BoneYard mode:) 0)
			(if (not global120)
				(= global145
					(= global111
						(if
							(==
								(if global111 global111 else global145)
								(players at: 0)
							)
							(players at: 1)
						else
							(players at: 0)
						)
					)
				)
				(global145 doProbs:)
			)
			(if (<= (BoneYard size:) (- 28 (* (BoneYard number:) 2)))
				((gCurRoom script:) cue:)
			)
		)
		(= global120 0)
		(= gDomino 0)
		(self setPri: 1 stopUpd:)
		(= global115 0)
	)
)

(class DominoHand of EventHandler
	(properties
		x 0
		y 0
		facing 2
		addDir 2
		type 0
		playOn 0
		theFork 0
		highlighted 0
		playerName 0
		outOf1 -1
		outOf2 -1
		outOf3 -1
		outOf4 -1
		skill 0
	)

	(method (setOutOf param1 &tmp temp0 temp1 temp2)
		(if (and argc param1)
			(= outOf1 (= outOf2 (= outOf3 (= outOf4 -1))))
			(return)
		)
		(for ((= temp0 0)) (< temp0 (theForks size:)) ((++ temp0))
			(if
				(and
					(!= (= temp2 ((theForks at: temp0) pipValue:)) outOf1)
					(!= temp2 outOf2)
					(!= temp2 outOf3)
					(!= temp2 outOf4)
				)
				(cond
					((== outOf1 -1)
						(= outOf1 temp2)
					)
					((== outOf2 -1)
						(= outOf2 temp2)
					)
					((== outOf3 -1)
						(= outOf3 temp2)
					)
					((== outOf4 -1)
						(= outOf4 temp2)
					)
				)
			)
		)
	)

	(method (doProbs)
		(localproc_0)
		(self eachElementDo: #setNumPlayable)
		(self eachElementDo: #setNumReplayable)
	)

	(method (highlight param1)
		(if highlighted
			(highlighted forceUpd: view: 100)
		)
		(if (!= param1 highlighted)
			(param1 forceUpd: view: 102)
			(= highlighted param1)
		else
			(= highlighted 0)
		)
		(Animate (self elements:) 0)
	)

	(method (dim)
		(if highlighted
			(highlighted forceUpd: view: 100)
			(= highlighted 0)
			(Animate (self elements:) 0)
		)
	)

	(method (count &tmp temp0 temp1)
		(= temp0 0)
		(if size
			(for ((= temp1 0)) (< temp1 size) ((++ temp1))
				(= temp0
					(+
						(+= temp0 ((self at: temp1) pips1:))
						((self at: temp1) pips2:)
					)
				)
			)
		)
		(return temp0)
	)

	(method (handleEvent event)
		(if (== (BoneYard mode:) 0)
			(if (super handleEvent: event)
				(gSound play: 905)
				(if (dominoHand2 contains: local11)
					(gChar1 say: (Random 6 8) 0 443)
				else
					(gChar1 say: (Random 9 11) 0 443)
				)
			)
			(return)
		)
		(cond
			((== global111 self)
				(super handleEvent: event)
			)
			((super handleEvent: event)
				(gSound play: 905)
				(gChar1 say: (Random 6 8) 0 443)
			)
		)
	)

	(method (moving &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (not (& ((self at: temp0) signal:) $0004))
				(return 1)
			)
		)
		(return 0)
	)

	(method (cue &tmp temp0 temp1 temp2 temp3)
		(= global537 0)
		(if (>= (domino1Script state:) 2)
			(if (== (domino1Script state:) 2)
				(for ((= temp0 0)) (< temp0 (theForks size:)) ((++ temp0))
					((theForks at: temp0) add: global110)
				)
				(= global120 0)
				((gCurRoom script:) cue:)
			)
			(if (!= global111 global118)
				(if (== (global110 pips1:) (global110 pips2:))
					(= temp1 7)
				)
				(if (>= (global110 pips1:) (global110 pips2:))
					(= temp2 (global110 pips1:))
					(= temp3 (global110 pips2:))
				else
					(= temp2 (global110 pips2:))
					(= temp3 (global110 pips1:))
				)
				(global110 setLoop: (+ temp3 temp1) cel: temp2)
			)
			(global110 view: 100 ignoreActors: facing: 2 cue:)
			(if (not (theFork contains: global110))
				(theFork add: global110)
			)
			(if global111
				(global111 delete: global110)
			)
		)
		(= global110 0)
		(if (not global120)
			(= global145
				(= global111
					(if
						(==
							(if global111 global111 else global145)
							(players at: 0)
						)
						(players at: 1)
					else
						(players at: 0)
					)
				)
			)
			(gTheArrow init:)
			(global145 doProbs:)
		else
			(= global120 0)
		)
		(= global115 0)
		(if (and (>= (domino1Script state:) 3) (not size))
			(domino1Script cue:)
		)
		(proc0_1)
		(proc0_3)
	)

	(method (setNextPosn &tmp temp0 temp1 temp2 temp3)
		(= temp3 (if (== addDir 2) -13 else 13))
		(for ((= temp1 1)) (<= temp1 size) ((++ temp1))
			(= global121
				(if (& temp1 $0001)
					x
				else
					(+ x 28)
				)
			)
			(= temp0 (/ (- temp1 1) 2))
			(= global122 (+ y (* temp0 temp3)))
			(for ((= temp2 0)) (< temp2 (- size 1)) ((++ temp2))
				(if
					(and
						(== ((self at: temp2) x:) global121)
						(== ((self at: temp2) y:) global122)
					)
					(continue 2)
				)
			)
			(break)
		)
	)

	(method (add param1)
		(if (not argc)
			(super add:)
			(return)
		)
		(super add: param1)
		(self setNextPosn:)
		(param1
			view: 100
			cel:
				(if (== facing 2)
					(param1 pips2:)
				else
					0
				)
			setLoop:
				(if (== facing 2)
					(param1 pips1:)
				else
					14
				)
			facing: facing
			setPri: 15
			setStep: 30 30
			ignoreActors:
			setMotion: MoveTo global121 global122 param1
			init:
		)
		(if (and (== (BoneYard mode:) 1) (< (domino1Script state:) 6))
			(if (== (global111 type:) 1)
				(if (== local2 4)
					(gChar1 frown:)
				)
			else
				(if (== local2 2)
					(gChar1 smile:)
				)
				(if (== local2 4)
					(gChar1 laugh:)
				)
			)
		)
	)

	(method (flip &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) facing:) 3)
				((self at: temp0) facing: 2)
			else
				((self at: temp0) facing: 3)
			)
			((self at: temp0)
				cel:
					(if (== facing 2)
						((self at: temp0) pips2:)
					else
						0
					)
				setLoop:
					(if (== facing 2)
						((self at: temp0) pips1:)
					else
						14
					)
			)
		)
	)

	(method (highestDouble &tmp temp0 temp1)
		(= temp1 0)
		(if size
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(if
					(and
						(== ((self at: temp0) pips1:) ((self at: temp0) pips2:))
						(or
							(not temp1)
							(and
								temp1
								(> ((self at: temp0) pips1:) (temp1 pips1:))
							)
						)
					)
					(= temp1 (self at: temp0))
				)
			)
		)
		(return temp1)
	)

	(method (validPlay param1 param2 &tmp temp0 temp1 temp2)
		(if (== argc 0)
			(if (and global134 global132)
				(= playOn ((= theFork (theForks at: 0)) theDummy:))
				(return (self highestDouble:))
			)
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(for ((= temp1 0)) (< temp1 (theForks size:)) ((++ temp1))
					(if ((theForks at: temp1) validPlay: (self at: temp0))
						(= playOn ((= theFork (theForks at: temp1)) theDummy:))
						(return (self at: temp0))
					)
				)
			)
		else
			(= theFork param2)
			(= playOn (theFork theDummy:))
			(return (param2 validPlay: param1))
		)
		(return 0)
	)

	(method (think &tmp temp0 temp1)
		(switch type
			(0
				(= temp0 0)
				(return)
			)
			(1
				(= temp0 (self calcMove:))
				(return)
			)
		)
	)

	(method (calcMove &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(proc0_4 30)
		(Wait 1)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(= temp3 (= temp4 0))
		(self doProbs:)
		(if (= temp2 (self validPlay:))
			(if (and global132 (not (leftFork size:)))
				(return temp2)
			)
			(if (== (global111 skill:) 0)
				(return (self chooseRandomPlay:))
			)
			(if (== (global111 skill:) 2)
				(if (and (not (BoneYard size:)) (self endGame:))
					(= playOn ((= theFork local4) theDummy:))
					(return local5)
				)
				(if (self closeOut:)
					(= playOn ((= theFork local4) theDummy:))
					(return local5)
				)
				(if (and (BoneYard size:) (self privateEnd:))
					(= playOn ((= theFork local4) theDummy:))
					(return local5)
				)
			)
			(= temp0 0)
			(= temp1 999)
			(while (< temp0 size)
				(= temp6 ((self at: temp0) numPlayableLeftFork:))
				(= temp7 ((self at: temp0) numPlayableRightFork:))
				(= temp8 ((self at: temp0) numReplayableLeftFork:))
				(= temp9 ((self at: temp0) numReplayableRightFork:))
				(= temp5
					(+ ((self at: temp0) pips1:) ((self at: temp0) pips2:))
				)
				(if
					(or
						(< (- temp6 temp8) temp1)
						(and (== (- temp6 temp8) temp1) (> temp5 temp3))
					)
					(= temp4 temp5)
					(= temp1
						(-
							((self at: temp0) numPlayableLeftFork:)
							((self at: temp0) numReplayableLeftFork:)
						)
					)
					(= playOn ((= theFork leftFork) theDummy:))
					(= temp2 (self at: temp0))
				)
				(if
					(or
						(< (- temp7 temp9) temp1)
						(and (== (- temp7 temp9) temp1) (> temp5 temp4))
					)
					(= temp4 temp5)
					(= temp1
						(-
							((self at: temp0) numPlayableRightFork:)
							((self at: temp0) numReplayableRightFork:)
						)
					)
					(= playOn ((= theFork rightFork) theDummy:))
					(= temp2 (self at: temp0))
				)
				(++ temp0)
			)
			(return temp2)
		else
			(return 0)
		)
	)

	(method (chooseRandomPlay &tmp temp0 temp1)
		(= temp0 1)
		(while temp0
			(= temp1 (self at: (Random 0 (- size 1))))
			(switch (Random 0 1)
				(0
					(cond
						((leftFork validPlay: temp1)
							(global111 playOn: ((= theFork leftFork) theDummy:))
							(= temp0 0)
						)
						((rightFork validPlay: temp1)
							(global111
								playOn: ((= theFork rightFork) theDummy:)
							)
							(= temp0 0)
						)
					)
				)
				(1
					(cond
						((rightFork validPlay: temp1)
							(global111
								playOn: ((= theFork rightFork) theDummy:)
							)
							(= temp0 0)
						)
						((leftFork validPlay: temp1)
							(global111 playOn: ((= theFork leftFork) theDummy:))
							(= temp0 0)
						)
					)
				)
			)
		)
		(return temp1)
	)

	(method (endGame &tmp temp0 temp1)
		(dominoHand2 eachElementDo: #inTree 0)
		(tempLeftFork add: (leftFork at: (- (leftFork size:) 1)))
		(tempRightFork add: (rightFork at: (- (rightFork size:) 1)))
		(= local3 0)
		(= local5 0)
		(= local4 0)
		(= local6 0)
		(= local7 0)
		(= local10 0)
		(= local9 0)
		(= local8 0)
		((leftFork at: (- (leftFork size:) 1)) freeEnd: (leftFork pipValue:))
		((rightFork at: (- (rightFork size:) 1)) freeEnd: (rightFork pipValue:))
		(self endTree:)
		(if (== local3 0)
			(= local6 -1)
			(for ((= temp1 0)) (< temp1 size) ((++ temp1))
				(= temp0 (self at: temp1))
				(if
					(and
						(or
							(leftFork validPlay: temp0)
							(rightFork validPlay: temp0)
						)
						(< local6 (+ (temp0 pips1:) (temp0 pips2:)))
					)
					(= local6 (+ (temp0 pips1:) (temp0 pips2:)))
					(= local5 temp0)
					(= local4
						(if (leftFork validPlay: temp0) leftFork else rightFork)
					)
				)
			)
		)
		(if (== local4 tempLeftFork)
			(= local4 leftFork)
		)
		(if (== local4 tempRightFork)
			(= local4 rightFork)
		)
		(tempLeftFork release:)
		(tempRightFork release:)
		(= local12 0)
		(return local5)
	)

	(method (endTree &tmp temp0 temp1 temp2)
		(proc0_6)
		(if (self notAllUsed:)
			(for ((= temp0 0)) (< temp0 (dominoHand2 size:)) ((++ temp0))
				(= temp2 (dominoHand2 at: temp0))
				(if (not (temp2 inTree:))
					(= temp1 tempLeftFork)
					(while (!= temp1 0)
						(if (self validPlayEndGame: temp2 temp1)
							(temp2 freeEnd: (self otherEnd: temp2 temp1))
							(temp1 add: temp2)
							(if (not (self canOpponentPlay:))
								(if (== (++ local7) 1)
									(= local8 temp1)
									(= local9 temp2)
									(if (== (temp2 pips1:) (temp2 pips2:))
										(= local4 local8)
										(= local5 local9)
										(temp1 delete: temp2)
										(= local3 99)
										(return)
									)
								)
								(if (and (not local12) (> local7 4))
									(= local12 100)
								)
								(if
									(>
										(+=
											local10
											(+ (temp2 pips1:) (temp2 pips2:))
										)
										local6
									)
									(= local6 local10)
									(= local3 local7)
									(= local4 local8)
									(= local5 local9)
								)
								(temp2 inTree: 1)
								(if local12
									(if (> (++ local12) 107)
										(= local12 100)
									)
									(if (not (HaveMouse))
										(gGame setCursor: local12 1 305 185)
									else
										(gGame setCursor: local12 1)
									)
								)
								(if (< local7 5)
									(self endTree:)
								)
								(-- local7)
								(-= local10 (+ (temp2 pips1:) (temp2 pips2:)))
							)
							(temp1 delete: temp2)
							(temp2 inTree: 0)
						)
						(if (== temp1 tempRightFork)
							(= temp1 0)
						)
						(if (== temp1 tempLeftFork)
							(= temp1 tempRightFork)
						)
					)
				)
			)
		)
	)

	(method (validPlayEndGame param1 param2)
		(return
			(or
				(==
					(param1 pips1:)
					((param2 at: (- (param2 size:) 1)) freeEnd:)
				)
				(==
					(param1 pips2:)
					((param2 at: (- (param2 size:) 1)) freeEnd:)
				)
			)
		)
	)

	(method (notAllUsed &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (dominoHand2 size:)) ((++ temp0))
			(if (not ((dominoHand2 at: temp0) inTree:))
				(= temp1 (dominoHand2 at: temp0))
				(if
					(or
						(==
							(temp1 pips1:)
							((tempLeftFork at: (- (tempLeftFork size:) 1))
								freeEnd:
							)
						)
						(==
							(temp1 pips1:)
							((tempRightFork at: (- (tempRightFork size:) 1))
								freeEnd:
							)
						)
						(==
							(temp1 pips2:)
							((tempLeftFork at: (- (tempLeftFork size:) 1))
								freeEnd:
							)
						)
						(==
							(temp1 pips2:)
							((tempRightFork at: (- (tempRightFork size:) 1))
								freeEnd:
							)
						)
					)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (canOpponentPlay &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (dominoHand1 size:)) ((++ temp0))
			(= temp1 (dominoHand1 at: temp0))
			(if
				(or
					(==
						(temp1 pips1:)
						((tempLeftFork at: (- (tempLeftFork size:) 1)) freeEnd:)
					)
					(==
						(temp1 pips1:)
						((tempRightFork at: (- (tempRightFork size:) 1))
							freeEnd:
						)
					)
					(==
						(temp1 pips2:)
						((tempLeftFork at: (- (tempLeftFork size:) 1)) freeEnd:)
					)
					(==
						(temp1 pips2:)
						((tempRightFork at: (- (tempRightFork size:) 1))
							freeEnd:
						)
					)
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (otherEnd param1 param2 param3)
		(cond
			((and argc param3)
				(if (== (param1 pips1:) (param2 pipValue:))
					(param1 pips2:)
					(return)
				else
					(param1 pips1:)
					(return)
				)
			)
			((== (param1 pips1:) ((param2 at: (- (param2 size:) 1)) freeEnd:))
				(param1 pips2:)
				(return)
			)
			(else
				(param1 pips1:)
				(return)
			)
		)
	)

	(method (privateEnd &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if (< (+ (leftFork size:) (rightFork size:)) 6)
			(return 0)
		)
		(= local4 0)
		(= local5 0)
		(= local6 -1)
		(for ((= temp2 0)) (< temp2 (dominoHand2 size:)) ((++ temp2))
			(= temp0 (dominoHand2 at: temp2))
			(= temp1 leftFork)
			(while (!= temp1 0)
				(if (temp1 validPlay: temp0)
					(= temp3 (self otherEnd: temp0 temp1 1))
					(temp0 inTree: 1)
					(= temp4 1)
					(for
						((= temp7 0))
						(< temp7 (dominoHand1 size:))
						((++ temp7))
						
						(if
							(or
								(== ((dominoHand1 at: temp7) pips1:) temp3)
								(== ((dominoHand1 at: temp7) pips2:) temp3)
							)
							(= temp4 0)
						)
					)
					(for ((= temp7 0)) (< temp7 (BoneYard size:)) ((++ temp7))
						(if
							(or
								(== ((BoneYard at: temp7) pips1:) temp3)
								(== ((BoneYard at: temp7) pips2:) temp3)
							)
							(= temp4 0)
						)
					)
					(if temp4
						(= temp5 0)
						(= temp6 0)
						(for
							((= temp7 0))
							(< temp7 (dominoHand2 size:))
							((++ temp7))
							
							(if
								(and
									(not ((dominoHand2 at: temp7) inTree:))
									(or
										(==
											((dominoHand2 at: temp7) pips1:)
											temp3
										)
										(==
											((dominoHand2 at: temp7) pips2:)
											temp3
										)
									)
								)
								(++ temp5)
								(if
									(==
										((dominoHand2 at: temp7) pips1:)
										((dominoHand2 at: temp7) pips2:)
									)
									(= temp6 1)
								)
							)
						)
						(if
							(and
								(or (>= temp5 2) (and temp5 (not temp6)))
								(> (+ (temp0 pips1:) (temp0 pips2:)) local6)
							)
							(= local6 (+ (temp0 pips1:) (temp0 pips2:)))
							(= local5 temp0)
							(= local4 temp1)
						)
					)
					(temp0 inTree: 0)
				)
				(if (== temp1 rightFork)
					(= temp1 0)
				)
				(if (== temp1 leftFork)
					(= temp1 rightFork)
				)
			)
		)
		(return local5)
	)

	(method (closeOut &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(if (< (+ (leftFork size:) (rightFork size:)) 6)
			(return 0)
		)
		(= local4 0)
		(= local5 0)
		(= local6 10)
		(for ((= temp5 0)) (< temp5 (dominoHand2 size:)) ((++ temp5))
			(= temp0 (dominoHand2 at: temp5))
			(= temp1 leftFork)
			(while (!= temp1 0)
				(if (temp1 validPlay: temp0)
					(= temp2 (self otherEnd: temp0 temp1 1))
					(= temp6
						(if (== temp1 leftFork)
							(rightFork pipValue:)
						else
							(leftFork pipValue:)
						)
					)
					(= temp9 1)
					(if (== (temp0 pips1:) (temp0 pips2:))
						(++ temp9)
					)
					(= temp11 (if (== temp1 leftFork) rightFork else leftFork))
					(if
						(and
							(!= (temp0 pips1:) (temp0 pips2:))
							(== (temp1 pipValue:) (temp11 pipValue:))
						)
						(++ temp9)
					)
					(if (== temp2 temp6)
						(*= temp9 2)
					)
					(for ((= temp4 0)) (< temp4 (leftFork size:)) ((++ temp4))
						(if (== ((leftFork at: temp4) pips1:) temp2)
							(++ temp9)
						)
						(if (== ((leftFork at: temp4) pips2:) temp2)
							(++ temp9)
						)
						(if (== ((leftFork at: temp4) pips1:) temp6)
							(++ temp9)
						)
						(if (== ((leftFork at: temp4) pips2:) temp6)
							(++ temp9)
						)
					)
					(for ((= temp4 1)) (< temp4 (rightFork size:)) ((++ temp4))
						(if (== ((rightFork at: temp4) pips1:) temp2)
							(++ temp9)
						)
						(if (== ((rightFork at: temp4) pips2:) temp2)
							(++ temp9)
						)
						(if (== ((rightFork at: temp4) pips1:) temp6)
							(++ temp9)
						)
						(if (== ((rightFork at: temp4) pips2:) temp6)
							(++ temp9)
						)
					)
					(if (== temp9 16)
						(= temp8 0)
						(for
							((= temp10 0))
							(< temp10 (dominoHand1 size:))
							((++ temp10))
							
							(= temp8
								(+
									(+= temp8 ((dominoHand1 at: temp10) pips1:))
									((dominoHand1 at: temp10) pips2:)
								)
							)
						)
						(for
							((= temp10 0))
							(< temp10 (BoneYard size:))
							((++ temp10))
							
							(= temp8
								(+
									(+= temp8 ((BoneYard at: temp10) pips1:))
									((BoneYard at: temp10) pips2:)
								)
							)
						)
						(= temp7 0)
						(for
							((= temp10 0))
							(< temp10 (dominoHand2 size:))
							((++ temp10))
							
							(= temp7
								(+
									(+= temp7 ((dominoHand2 at: temp10) pips1:))
									((dominoHand2 at: temp10) pips2:)
								)
							)
						)
						(if
							(and
								(<
									(= temp7
										(-
											(-= temp7 (temp0 pips1:))
											(temp0 pips2:)
										)
									)
									temp8
								)
								(> (- temp8 temp7) local6)
							)
							(= local6 (- temp8 temp7))
							(= local5 temp0)
							(= local4 temp1)
						)
					)
				)
				(if (== temp1 rightFork)
					(= temp1 0)
				)
				(if (== temp1 leftFork)
					(= temp1 rightFork)
				)
			)
		)
		(return local5)
	)
)

(instance tempLeftFork of List
	(properties)
)

(instance tempRightFork of List
	(properties)
)

(class BoneYard of EventHandler
	(properties
		top 60
		left 70
		bottom 140
		right 250
		color 12
		priority 14
		underBits 0
		mode 1
		drawButton 0
		limit 0
		number 7
		showAtEnd 0
	)

	(method (init &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(for ((= temp1 temp0)) (< temp1 7) ((++ temp1))
				(self
					add:
						((Domino new:)
							pips1: temp0
							pips2: temp1
							facing: 3
							ignoreControl: -1
							moveSpeed: 1
							yourself:
						)
				)
			)
		)
	)

	(method (swap param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) pips1:) ((self at: temp0) pips2:))
				(= temp1 (param1 pips1:))
				(= temp2 (param1 pips2:))
				(param1
					pips1: ((self at: temp0) pips1:)
					pips2: ((self at: temp0) pips2:)
				)
				((self at: temp0) pips1: temp1 pips2: temp2)
				(return)
			)
		)
	)

	(method (shuffle &tmp temp0 temp1)
		(for ((= temp0 200)) (>= temp0 0) ((-- temp0))
			(self delete: (= temp1 (self at: (Random 0 (- size 1)))))
			(self add: temp1)
		)
	)

	(method (give &tmp temp0)
		(= temp0 0)
		(if (> size limit)
			(= temp0 (self at: (Random 0 (- size 1))))
			(self delete: temp0)
		)
		(remaining
			cel:
				(if (> size 14)
					(- size 15)
				else
					size
				)
			setLoop: (if (> size 14) 8 else 3)
			forceUpd:
		)
		(if (<= size limit)
			(remaining hide:)
			(drawButton setLoop: 5)
		)
		(return temp0)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (not (event claimed:))
			(cond
				((== mode 0)
					(super handleEvent: event)
					(if (and (event claimed:) (not (global111 moving:)))
						(if (and (== (event type:) evMOUSEBUTTON) (== global111 global118))
							(global110 startUpd:)
							(global110 cel: 1)
							((= temp1 (List new:)) add: global110)
							(Animate (temp1 elements:) 0)
							(while (!= evMOUSERELEASE ((= temp0 (Event new:)) type:))
								(global110
									cel: (if (global110 inRect: temp0) 1 else 0)
								)
								(Animate (temp1 elements:) 0)
								(temp0 dispose:)
							)
							(temp1 delete: global110)
							(temp1 dispose:)
							(temp0 dispose:)
							(if (== (global110 cel:) 1)
								(global110 cel: 0)
								(self delete: global110)
								(global110 deleteKeyMouse:)
								(if
									(and
										(<= size (- 28 (* number 2)))
										global132
										(not (global118 highestDouble:))
										(not (global119 highestDouble:))
										(!=
											(global110 pips1:)
											(global110 pips2:)
										)
									)
									(self swap: global110)
								)
								(global111 add: global110)
							)
						else
							(self delete: global110)
							(global110 deleteKeyMouse:)
							(global111 add: global110)
						)
					)
				)
				(
					(and
						drawButton
						(drawButton handleEvent: event)
						(not (global111 moving:))
					)
					(proc0_1)
					(cond
						((and (global111 validPlay:) global130)
							(if (> size limit)
								(Print 199 0) ; "You cannot draw another Domino since you have a valid play."
							else
								(Print 199 1) ; "You cannot pass since you have a valid play."
							)
						)
						((= global110 (self give:))
							(if (> (++ local2) 1)
								(global111 setOutOf: 1)
							)
							(global111 setOutOf:)
							(global110
								posn:
									(+ (boneYardDraw x:) 10)
									(+ (boneYardDraw y:) 10)
								setPri: 1
								show:
							)
							(global111 add: global110)
							(if (== global111 global118)
								(global110 addKeyMouse:)
							)
							(= global120 1)
						)
						(else
							(global111 setOutOf:)
							(= local13 (gSystemWindow back:))
							(gSystemWindow back: 21)
							(Print 199 3 3 25 3) ; "PASS"
							(gSystemWindow back: local13)
							(= global145 (= global111 global119))
							(gTheArrow init:)
							(global145 doProbs:)
							(if (== (++ global127) 2)
								(= global145 global111)
								(global145 doProbs:)
								(= global111 0)
								((gCurRoom script:) cue:)
							)
						)
					)
				)
			)
		)
		(event claimed:)
	)

	(method (show &tmp temp0 temp1 temp2)
		(for ((= temp0 (= mode 0))) (< temp0 7) ((++ temp0))
			(for ((= temp1 0)) (< temp1 4) ((++ temp1))
				(= temp2 (self at: (+ (* temp0 4) temp1)))
				(temp2
					cel: 0
					setLoop: 15
					posn: (+ 100 (* temp0 17)) (+ 50 (* temp1 25))
					setPri: (temp2 priority:)
					ignoreActors:
					init:
					stopUpd:
				)
			)
		)
		(self eachElementDo: #show)
	)
)

(instance domino1Script of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= global117 0)
				(= global133 -1)
				(= global139 (= global140 (= global141 0)))
				(= global129 0)
				(players add: dominoHand1 dominoHand2)
				(theForks add: leftFork rightFork)
				(theForks eachElementDo: #init)
				(= global118 (players at: 0))
				(= global119 (players at: 1))
				(= global123 (= global124 0))
				(global118 playerName: @global150)
				(global119 playerName: @global157)
				(BoneYard drawButton: boneYardDraw init:)
				(= global145 (= global111 (players at: (Random 0 1))))
				(if (== global111 global118)
					(= global128 0)
				else
					(= global128 3)
				)
				(= cycles 1)
			)
			(1
				(++ global129)
				(= global117 0)
				(if global135
					(BoneYard number: global135)
					(= global135 0)
				)
				(BoneYard mode: 0 shuffle: show: eachElementDo: #addKeyMouse)
				(= global126 (= global125 0))
				(= local13 (gSystemWindow back:))
				(gSystemWindow back: 21)
				(Print
					(Format @global550 199 4 (BoneYard number:)) ; "Select %d Dominoes each"
					#mode
					1
					#at
					-1
					17
					#dispose
				)
				(User canControl: 1)
				(gSystemWindow back: local13)
				(= local0 (= global127 0))
			)
			(2
				(= global110 0)
				(= global134 1)
				(BoneYard mode: 1)
				(BoneYard eachElementDo: #hide eachElementDo: #deleteKeyMouse)
				(boneYardDraw init: addKeyMouse:)
				(remaining
					cel:
						(if (> (BoneYard size:) 14)
							(- (BoneYard size:) 15)
						else
							(BoneYard size:)
						)
					setLoop: (if (> (BoneYard size:) 14) 8 else 3)
					init:
				)
				(global118 eachElementDo: #addKeyMouse)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(for ((= temp0 0)) (< temp0 (theForks size:)) ((++ temp0))
					(gTheInputList add: (theForks at: temp0))
					(((theForks at: temp0) theDummy:)
						view: 103
						setLoop: 4
						cel: 0
						ignoreActors:
						posn: 147 94
						show:
						addKeyMouse:
					)
				)
				(global118 setOutOf: 1)
				(global119 setOutOf: 1)
				(= local2 0)
				(proc100_1)
				(if (and (== global111 global119) (== global119 dominoHand2))
					(Wait 1)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
				)
				(gTheArrow init:)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
			)
			(4
				(gTheArrow hide:)
				(= global117 1)
				(proc0_1)
				(for ((= temp0 0)) (< temp0 (theForks size:)) ((++ temp0))
					(((theForks at: temp0) theDummy:) hide: deleteKeyMouse:)
				)
				(global118 eachElementDo: #deleteKeyMouse)
				(= global145 global111)
				(= global111 0)
				(if (global119 size:)
					(global119 eachElementDo: #flip)
				)
				(= global137
					(cond
						((not (global118 size:)) 0)
						((not (global119 size:)) 1)
						(else -1)
					)
				)
				(showBoneYard init: global137)
				(+= global126 (global118 count:))
				(if (>= (+= global125 (global119 count:)) global126)
					(-= global125 global126)
					(= global126 0)
				else
					(-= global126 global125)
					(= global125 0)
				)
				(+= global123 global125)
				(+= global124 global126)
				(proc0_1)
				(= global133 (if global125 global125 else global126))
				(proc0_3)
				(proc100_2 1)
				(= global133 -1)
				(self cue:)
			)
			(5
				(if
					(and
						(or (>= global123 global148) (>= global124 global148))
						(!= global123 global124)
					)
					(proc0_3)
					(= global539
						(if (> global123 global124)
							(global118 playerName:)
						else
							(global119 playerName:)
						)
					)
					(gSong setLoop: -1 play: 906)
					(= local13 (gSystemWindow back:))
					(gSystemWindow back: 21)
					(Print
						(Format ; "%s WON THE GAME  FINAL SCORE: %s: %d, %s: %d"
							@global550
							199
							5
							global539
							(global118 playerName:)
							global123
							(global119 playerName:)
							global124
						)
						#mode
						1
					)
					(gSystemWindow back: local13)
					(gSong fade:)
					(if (> global123 global124)
						(gChar1 say: (Random 27 29))
					else
						(gChar1 say: (Random 30 32))
					)
					(= global123
						(= global124
							(= global129
								(= global139 (= global140 (= global141 0)))
							)
						)
					)
				)
				(self cue:)
			)
			(6
				(remaining hide:)
				((BoneYard drawButton:) setLoop: 6)
				(= global145 (= global111 global118))
				(if (not global129)
					((BoneYard drawButton:) hide:)
					(self cue:)
				)
			)
			(7
				(showBoneYard hide:)
				(proc0_1)
				(for ((= temp0 0)) (< temp0 (theForks size:)) ((++ temp0))
					(if ((theForks at: temp0) size:)
						(for
							((= temp1 0))
							(< temp1 ((theForks at: temp0) size:))
							((++ temp1))
							
							(BoneYard
								add:
									(((theForks at: temp0) at: temp1)
										hide:
										view: 100
										ignoreActors:
										facing: 3
										yourself:
									)
							)
						)
						((theForks at: temp0) release:)
					)
				)
				(if (global118 size:)
					(for ((= temp0 0)) (< temp0 (global118 size:)) ((++ temp0))
						(BoneYard
							add:
								((global118 at: temp0)
									hide:
									view: 100
									ignoreActors:
									facing: 3
									yourself:
								)
						)
					)
					(global118 release:)
				)
				(if (global119 size:)
					(for ((= temp0 0)) (< temp0 (global119 size:)) ((++ temp0))
						(BoneYard
							add:
								((global119 at: temp0)
									hide:
									view: 100
									ignoreActors:
									facing: 3
									yourself:
								)
						)
					)
					(global119 release:)
				)
				(gTheInputList release:)
				(proc0_1)
				(= global120 0)
				(= state 0)
				(if (== global128 0)
					(= global128 3)
					(= global145 (= global111 global119))
				else
					(= global145 (= global111 global118))
					(= global128 0)
				)
				(self cue:)
			)
		)
	)

	(method (doit &tmp [temp0 2])
		(super doit: &rest)
		(if
			(and
				(or (== state 3) (== state 2))
				(== global111 global119)
				(not (global111 moving:))
			)
			(cond
				((= global110 (global111 think:))
					(gSound play: 100)
					(global110
						setPri: 9
						setMotion:
							JumpTo
							((global111 playOn:) x:)
							((global111 playOn:) y:)
							global111
					)
					(global111 delete: global110)
					(= global145 global111)
					(= global111 0)
				)
				((> (BoneYard size:) (BoneYard limit:))
					(if (> (++ local2) 1)
						(global111 setOutOf: 1)
					)
					(global111 setOutOf:)
					(= global120 1)
					(proc0_6)
					(boneYardDraw flash:)
					(= global110 (BoneYard give:))
					(global110
						setLoop: 14
						posn: (+ (boneYardDraw x:) 10) (+ (boneYardDraw y:) 10)
						setPri: 1
						show:
					)
					(global111 add: global110)
					(if (== global111 global118)
						(global110 addKeyMouse:)
					)
				)
				(else
					(Wait 1)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(boneYardDraw flash:)
					(global111 setOutOf:)
					(proc0_3)
					(gChar1 say: (Random 0 2))
					(= global145 (= global111 global118))
					(gTheArrow init:)
					(global145 doProbs:)
					(if (== (++ global127) 2)
						(= global145 global111)
						(global145 doProbs:)
						(= global111 0)
						((gCurRoom script:) cue:)
					)
				)
			)
		)
	)
)

(instance tightCast of List
	(properties)
)

(instance domino1 of Rm
	(properties
		picture 100
		style 10
	)

	(method (init)
		(Load rsVIEW 100)
		(Load rsVIEW 103)
		(Load rsVIEW 102)
		(Load rsVIEW 110)
		(Load rsCURSOR 100)
		(Load rsCURSOR 101)
		(Load rsCURSOR 102)
		(Load rsCURSOR 103)
		(Load rsCURSOR 104)
		(Load rsCURSOR 105)
		(Load rsCURSOR 106)
		(Load rsCURSOR 107)
		(Load rsVIEW 997)
		Jump
		RandCycle
		(ScriptID 110) ; thed1Code
		(Load rsCURSOR 29)
		(gChar1 posn: 289 29 show: init:)
		(Load rsTEXT (+ (* (+ (gChar1 view:) 1) 1000) global187))
		(Characters init:)
		(super init:)
		(gSong fade:)
		((= gDominoes_opt (ScriptID 101 1)) doit: 2) ; dominoes_opt
		(proc0_1)
		(BoneYard add:)
		(players add:)
		(theForks add:)
		(leftFork add:)
		(rightFork add:)
		(tightCast add:)
		(dominoHand1 add: skill: global190 playerName: @global150)
		(dominoHand2 add: skill: global191 playerName: @global157)
		(self setScript: domino1Script)
		(= gShowBoneYard showBoneYard)
		(= gTheArrow theArrow)
		(proc0_3)
	)

	(method (doit &tmp temp0 temp1)
		(if
			(and
				(== (BoneYard mode:) 0)
				(== global111 global119)
				(or
					(and
						(== global128 0)
						(< (global119 size:) (global118 size:))
					)
					(and
						(== global128 3)
						(== (global119 size:) (global118 size:))
					)
				)
			)
			(= temp1 (BoneYard at: (Random 0 (- (BoneYard size:) 1))))
			((User curEvent:) x: (temp1 x:) y: (temp1 y:) type: evMOUSEBUTTON claimed: 0)
			(BoneYard handleEvent: (User curEvent:))
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (== global111 global118)
			(BoneYard handleEvent: event)
		)
		(players handleEvent: event)
		(if (or (proc0_2 event) (& (event type:) evMOUSEBUTTON))
			(theForks eachElementDo: #handleEvent event)
		)
	)

	(method (dispose)
		(DisposeScript 110)
		(DisposeScript 991)
		(DisposeScript 101)
		(DisposeScript 941)
		(DisposeScript 9)
		(tempLeftFork release: dispose:)
		(tempRightFork release: dispose:)
		(tightCast release: dispose:)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		((KeyMouse objList:) release:)
		(players release: dispose:)
		(gTheInputList release:)
		(theForks dispose:)
		(dominoHand1 release: dispose:)
		(dominoHand2 release: dispose:)
		(BoneYard release: dispose:)
		(showBoneYard dispose:)
		(remaining dispose:)
		(boneYardDraw dispose:)
		(super dispose:)
	)
)

(instance players of EventHandler
	(properties)
)

(class Fork of EventHandler
	(properties
		pipValue 0
		doublets 0
		halves 0
		doubletDir 2
		previousDir 0
		dir1 0
		dir2 0
		top 0
		left 0
		bottom 0
		right 0
		theDummy 0
	)

	(method (init)
		(= theDummy
			((Domino new:)
				view: 103
				setLoop: 4
				cel: 0
				setPri: 1
				ignoreControl: -1
				ignoreActors:
				posn: 500 500
				init:
				stopUpd:
				yourself:
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (not (event claimed:))
			(cond
				(
					(and
						global110
						(& (event type:) evMOUSERELEASE)
						(theDummy rectInRect: event global110)
					)
					(cond
						((self validPlay: global110)
							(event claimed: 1)
							(global111 theFork: self)
							(global111 cue:)
						)
						((and global132 (not size))
							(if (not local1)
								(Print 199 7) ; "You must play your highest doublet."
								(= local1 1)
							else
								(= local1 0)
							)
						)
						((not local1)
							(gSound play: 905)
							(gChar1 say: (Random 24 26) 0 443)
							(= local1 1)
						)
						(else
							(= local1 0)
						)
					)
				)
				((and (& (event type:) evMOUSEBUTTON) (theDummy inRect: event))
					(event claimed: 1)
					(gSound play: 905)
					(gChar1 say: (Random 12 14) 0 441)
				)
				(
					(and
						(proc0_2 event)
						(== global111 global118)
						(theDummy inRect: event)
					)
					(event claimed: 1)
					(cond
						((global111 validPlay: (global111 highlighted:) self)
							(if (global111 highlighted:)
								(= global537 1)
								(gSound play: 100)
								((global111 highlighted:)
									setMotion:
										MoveTo
										((global111 playOn:) x:)
										((global111 playOn:) y:)
										global111
								)
								(global111 delete: global110)
								(= global145 global111)
								(global111 highlighted: 0)
								(= global111 0)
							)
						)
						((global111 highlighted:)
							(if (and global132 (not size))
								(Print 199 7) ; "You must play your highest doublet."
							else
								(gSound play: 905)
								(gChar1 say: (Random 24 26) 0 443)
							)
						)
						(else
							(gSound play: 905)
							(gChar1 say: (Random 12 14) 0 441)
						)
					)
				)
			)
		)
		(event claimed:)
	)

	(method (add param1 &tmp temp0)
		(if (not argc)
			(super add:)
			(return)
		)
		(gSound2 play: 300)
		(= local2 0)
		(= global127 0)
		(= global134 0)
		(param1 deleteKeyMouse:)
		(if size
			(self doit: param1)
			(if (== (param1 pips1:) (param1 pips2:))
				(++ doublets)
				(++ halves)
				(self setDoublet: param1)
			else
				(= doubletDir 0)
				(+= halves 2)
			)
		else
			(= doubletDir (= halves (= doublets 0)))
			(cond
				((== (param1 pips1:) (param1 pips2:))
					(= doublets 1)
					(= pipValue (param1 pips1:))
					(= doubletDir 2)
				)
				((== self (theForks at: 0))
					(= pipValue
						(if (> (param1 pips1:) (param1 pips2:))
							(param1 pips1:)
						else
							(param1 pips2:)
						)
					)
				)
				(else
					(= pipValue
						(if (> (param1 pips1:) (param1 pips2:))
							(param1 pips2:)
						else
							(param1 pips1:)
						)
					)
				)
			)
			(global110
				view: 100
				ignoreActors:
				setLoop:
					(if doublets
						(+ pipValue 7)
					else
						(global110 loop:)
					)
				posn: (if doublets 153 else 147) (if doublets 89 else 94)
			)
		)
		(super add: param1)
		(self showDummy:)
	)

	(method (showDummy)
		(if size
			(theDummy pips1: pipValue pips2: (+ pipValue 1))
			(if (== (+ pipValue 1) 7)
				(theDummy pips2: 0)
			)
			(self doit: theDummy)
			(theDummy show:)
		)
	)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(= temp13 (if (== (param1 pips1:) (param1 pips2:)) 1 else 0))
		(= temp0 (self at: (- size 1)))
		(= temp1 (CelWide (temp0 view:) (temp0 loop:) (temp0 cel:)))
		(= temp2 (CelHigh (temp0 view:) (temp0 loop:) (temp0 cel:)))
		(= temp11 (= temp9 (temp0 x:)))
		(= temp12 (= temp10 (temp0 y:)))
		(= temp3 0)
		(if (== size 1)
			(if (== self leftFork)
				(= previousDir 0)
			else
				(= previousDir 1)
			)
		)
		(switch dir1
			(0
				(if temp13
					(= temp11 (- temp9 14))
					(= temp12 (- temp10 5))
					(= temp3 1)
					(= temp5 2)
					(if (== previousDir 3)
						(+= temp12 10)
					)
				else
					(switch dir2
						(0
							(= temp5 1)
							(= temp11 (- temp9 26))
							(switch previousDir
								(0
									(if (== doubletDir 2)
										(= temp12 (+ temp10 5))
									)
								)
								(3
									(if (not doubletDir)
										(= temp12 (+ temp10 10))
									)
								)
							)
						)
						(2
							(= temp5 3)
							(= temp3 1)
							(= temp11 (- temp9 14))
							(= temp12
								(if doubletDir
									(- temp10 5)
								else
									(- temp10 10)
								)
							)
						)
						(3
							(= temp5 2)
							(= temp3 1)
							(= temp11 (- temp9 14))
							(if doubletDir
								(= temp12 (+ temp10 5))
							)
						)
					)
				)
			)
			(1
				(if temp13
					(= temp11 (+ temp9 temp1))
					(= temp12 (- temp10 5))
					(= temp3 1)
					(= temp5 2)
					(if (== previousDir 3)
						(+= temp12 10)
					)
				else
					(switch dir2
						(1
							(= temp5 0)
							(= temp11 (+ temp9 temp1))
							(switch previousDir
								(1
									(if (== doubletDir 2)
										(= temp12 (+ temp10 5))
									)
								)
								(3
									(if (not doubletDir)
										(= temp12 (+ temp10 10))
									)
								)
							)
						)
						(2
							(= temp5 3)
							(= temp3 1)
							(= temp11 (+ temp9 temp1))
							(= temp12
								(if doubletDir
									(- temp10 5)
								else
									(- temp10 10)
								)
							)
						)
						(3
							(= temp5 2)
							(= temp3 1)
							(= temp11 (+ temp9 temp1))
							(if doubletDir
								(= temp12 (+ temp10 5))
							)
						)
					)
				)
			)
			(2
				(if temp13
					(= temp11 (- temp9 6))
					(= temp12 (- temp10 12))
					(= temp3 0)
					(= temp5 0)
					(if (== previousDir 1)
						(+= temp11 12)
					)
				else
					(switch dir2
						(2
							(= temp5 3)
							(= temp3 1)
							(= temp12 (- temp10 22))
							(switch previousDir
								(2
									(if (== doubletDir 1)
										(= temp11 (+ temp9 6))
									)
								)
								(1
									(if (not doubletDir)
										(= temp11 (+ temp9 12))
									)
								)
							)
						)
						(0
							(= temp5 1)
							(= temp12 (- temp10 12))
							(= temp11
								(if doubletDir
									(- temp9 6)
								else
									(- temp9 12)
								)
							)
						)
						(1
							(= temp5 0)
							(= temp12 (- temp10 12))
							(if doubletDir
								(= temp11 (+ temp9 6))
							)
						)
					)
				)
			)
			(3
				(if temp13
					(= temp11 (- temp9 6))
					(= temp12 (+ temp10 temp2))
					(= temp3 0)
					(= temp5 0)
					(if (== previousDir 1)
						(+= temp11 12)
					)
				else
					(switch dir2
						(3
							(= temp5 2)
							(= temp3 1)
							(= temp12 (+ temp10 temp2))
							(switch previousDir
								(3
									(if (== doubletDir 1)
										(= temp11 (+ temp9 6))
									)
								)
								(1
									(if (not doubletDir)
										(= temp11 (+ temp9 12))
									)
								)
							)
						)
						(0
							(= temp5 1)
							(= temp12 (+ temp10 temp2))
							(= temp11
								(if doubletDir
									(- temp9 6)
								else
									(- temp9 12)
								)
							)
						)
						(1
							(= temp5 0)
							(= temp12 (+ temp10 temp2))
							(if doubletDir
								(= temp11 (+ temp9 6))
							)
						)
					)
				)
			)
		)
		(param1 x: temp11 y: temp12)
		(= temp4 (if (== temp3 0) 0 else 7))
		(= temp8
			(if (== pipValue (param1 pips1:))
				(param1 pips2:)
			else
				(param1 pips1:)
			)
		)
		(switch temp5
			(0
				(= temp6 pipValue)
				(= temp7 temp8)
			)
			(1
				(= temp7 pipValue)
				(= temp6 temp8)
			)
			(2
				(= temp6 pipValue)
				(= temp7 temp8)
			)
			(3
				(= temp7 pipValue)
				(= temp6 temp8)
			)
		)
		(+= temp7 temp4)
		(param1 loop: temp7 cel: temp6)
		(if (!= param1 theDummy)
			(= pipValue temp8)
		else
			(theDummy setLoop: 4 cel: (if temp4 1 else 0) show: stopUpd:)
		)
	)

	(method (setDoublet))

	(method (validPlay param1 &tmp temp0)
		(= temp0 0)
		(if param1
			(cond
				((not size)
					(if global132
						(if (== (global111 highestDouble:) param1)
							(= temp0 1)
						)
					else
						(= temp0 1)
					)
				)
				(
					(or
						(== (param1 pips1:) pipValue)
						(== (param1 pips2:) pipValue)
					)
					(= temp0 1)
				)
			)
		)
		(return temp0)
	)
)

(instance dominoHand1 of DominoHand
	(properties
		x 3
		y 170
	)
)

(instance dominoHand2 of DominoHand
	(properties
		x 263
		y 60
		facing 3
		addDir 3
		type 1
	)
)

(instance leftFork of Fork
	(properties)

	(method (setDoublet)
		(= doubletDir
			(if (or (== [local63 halves] 0) (== [local63 halves] 1)) 2 else 1)
		)
	)

	(method (doit param1)
		(= previousDir [local63 (- halves 1)])
		(= dir1 [local63 halves])
		(= dir2 [local63 (+ halves 1)])
		(super doit: param1)
	)
)

(instance rightFork of Fork
	(properties)

	(method (setDoublet)
		(= doubletDir
			(if (or (== [local111 halves] 0) (== [local111 halves] 1)) 2 else 1)
		)
	)

	(method (doit param1)
		(= previousDir [local111 (- halves 1)])
		(= dir1 [local111 halves])
		(= dir2 [local111 (+ halves 1)])
		(super doit: param1)
	)
)

(instance theForks of EventHandler
	(properties)
)

(instance showBoneYard of KMView
	(properties)

	(method (init param1 &tmp temp0 temp1 temp2 temp3)
		(if (and (BoneYard showAtEnd:) (BoneYard size:))
			(self
				view: 103
				ignoreActors:
				setLoop: 7
				cel: (if (== param1 -1) 1 else 0)
				posn:
					(if (or (== param1 0) (== param1 -1)) 3 else 261)
					(cond
						((== param1 -1) 3)
						((== param1 0) 26)
						(else 60)
					)
				setPri: 1
				stopUpd:
				setPri: 5
				show:
			)
			(super init: &rest)
			(for ((= temp0 0)) (< temp0 (BoneYard size:)) ((++ temp0))
				(= temp1 (BoneYard at: temp0))
				(= temp2
					(if (& temp0 $0001)
						(+ x 29)
					else
						(+ x 2)
					)
				)
				(= temp3 (+ (* (/ temp0 2) 11) 14 y))
				(temp1
					view: 100
					ignoreActors:
					posn: temp2 temp3
					setPri: 7
					show:
				)
				(if (> (temp1 pips1:) (temp1 pips2:))
					(temp1 setLoop: (temp1 pips2:) cel: (temp1 pips1:))
				else
					(temp1 setLoop: (temp1 pips1:) cel: (temp1 pips2:))
				)
			)
		)
	)

	(method (hide)
		(super hide:)
		(BoneYard eachElementDo: #hide)
	)
)

(instance boneYardDraw of TrackingView
	(properties)

	(method (init)
		(self
			view: 103
			ignoreActors:
			setLoop: 2
			cel: 0
			posn: 257 178
			setPri: 10
			associatedObj: remaining
			show:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(not global537)
				(not (global111 moving:))
				(super handleEvent: event)
			)
			(event claimed: 1)
			(gSound play: 101)
			(global111 dim:)
			(if (== (domino1Script state:) 6)
				(self posn: 500 500 stopUpd:)
				(domino1Script cue:)
				(event claimed: 0)
			)
		)
		(event claimed:)
	)

	(method (flash)
		(super flash:)
		(gSound play: 101)
	)
)

(instance remaining of KMView
	(properties
		view 103
		loop 3
		cel 14
		priority 11
	)

	(method (init)
		(self
			setLoop: loop
			ignoreActors:
			posn: (+ (boneYardDraw x:) 4) (+ (boneYardDraw y:) 11)
			setPri: priority
			show:
		)
		(super init: &rest)
	)
)

(instance theArrow of Actor
	(properties
		x 31
		y 15
		view 850
		cel 1
	)

	(method (init)
		(self
			ignoreActors:
			stopUpd:
			setLoop: (if (== global111 dominoHand1) 2 else 0)
			show:
		)
		(super init: &rest)
	)
)

