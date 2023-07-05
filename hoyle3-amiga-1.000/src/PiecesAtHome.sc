;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Interface)
(use Path)
(use Motion)
(use Actor)
(use System)

(local
	local0
	[local1 19] = [-40 -2 -38 -2 -31 -2 -28 -2 -25 -2 -22 -2 -20 -2 -18 -2 -16 -2 -32768]
	[local20 15] = [-14 -2 -12 -2 -10 -2 -9 -2 -7 -2 -4 -2 -2 0 -32768]
	[local35 33] = [-53 -2 -50 -2 -42 -2 -28 -2 -23 -2 -18 -2 -22 -2 -10 -2 -14 -2 -8 -2 -3 -2 -4 -2 -7 -2 -6 -2 -4 -2 -2 0 -32768]
	[local68 32] = [148 23 134 23 120 23 106 23 272 68 272 55 272 42 272 29 218 172 232 172 248 172 262 172 95 127 95 140 95 153 95 166]
	[local100 32] = [175 84 181 84 187 84 193 84 199 89 199 95 199 101 199 107 175 111 181 111 187 111 193 111 167 89 167 95 167 101 167 107]
	[local132 16] = [139 79 155 79 213 79 229 79 213 129 229 129 139 129 155 129]
	[local148 48] = [154 58 150 60 152 57 147 60 159 55 144 54 220 56 219 60 217 55 224 58 215 58 216 60 221 111 213 114 214 109 222 109 219 115 216 110 156 110 155 115 151 112 158 110 149 113 154 117]
	[local196 12] = [193 75 5 173 75 4 173 122 6 193 122 7]
	[local208 13] = [2 11 12 13 14 15 16 6 5 4 3 2 1]
	[local221 2]
	[local223 2]
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp0 ((param1 curSquare:) order:))
	(= temp3 ((param1 curSquare:) type:))
	(= temp2 (+ (= temp4 (((param1 owner:) homeStart:) order:)) 6))
	(= temp5 0)
	(if (== global414 TheShells)
		(cond
			((and (== temp3 6) (== param2 3))
				(= param2 1)
			)
			(
				(and
					(== param2 2)
					(== temp3 (param1 color:))
					(== temp0 (+ 5 temp4))
				)
				(= param2 1)
			)
		)
	)
	(if (> (= temp1 (+ temp0 param2)) (+ temp4 52))
		(+= temp4 52)
		(+= temp2 52)
	)
	(if
		(or
			(and (!= temp3 6) (<= temp0 temp4) (< temp4 temp1))
			(== temp3 (param1 color:))
		)
		(if (<= temp1 temp2)
			(= temp5 1)
		else
			(= temp1 0)
		)
	)
	(if temp1
		(if temp5
			(if (!= temp1 temp2)
				(= temp1
					(+
						(gTheGameSquares indexOf: ((param1 owner:) homePath:))
						(- temp1 (((param1 owner:) homePath:) order:))
					)
				)
			else
				(= temp1 76)
			)
		else
			(= temp1 (mod (- temp1 1) 52))
		)
		(return (gTheGameSquares at: temp1))
	else
		(return 0)
	)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(= temp0
		(cond
			((== (= temp1 (global178 skill:)) 0)
				(localproc_3 param1)
			)
			((== temp1 1)
				(localproc_4 param1)
			)
			((== temp1 2)
				(localproc_5 param1)
			)
		)
	)
	(if (param1 child:)
		(+= temp0 ((param1 child:) rank:))
	)
	(param1 rank: temp0)
)

(procedure (localproc_2 param1 param2 &tmp temp0)
	(if (== (= temp0 (mod (- (param2 order:) (param1 order:)) 52)) 0)
		(= temp0 52)
	)
	(return temp0)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp1 (param1 aSquare:))
	(= temp2 (param1 piece:))
	(= temp3 (param1 captive:))
	(cond
		((== ((temp2 curSquare:) type:) 6)
			(= temp0 529)
		)
		(temp3
			(= temp0 521)
		)
		(else
			(cond
				((== (temp1 type:) 7)
					(= temp0 (localproc_2 ((temp2 owner:) homeStart:) temp1))
				)
				((== (temp1 type:) (temp2 color:))
					(= temp0
						(- (temp1 order:) (((temp2 owner:) homeStart:) order:))
					)
					(if (== ((temp2 curSquare:) type:) 7)
						(= temp0 (+ 52 temp0))
					)
				)
				(else
					(= temp0 6)
				)
			)
			(if (< temp0 27)
				(= temp0 (Random 1 26))
			)
			(*= temp0 10)
		)
	)
	(return temp0)
)

(procedure (localproc_4 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp1 (param1 aSquare:))
	(= temp2 (param1 piece:))
	(= temp3 (param1 captive:))
	(cond
		((== ((temp2 curSquare:) type:) 6)
			(= temp0 5299)
		)
		(temp3
			(= temp0
				(+
					(= temp0 5200)
					(localproc_2 ((temp3 owner:) homeStart:) temp1)
				)
			)
		)
		(else
			(cond
				((== (temp1 type:) 7)
					(= temp0 (localproc_2 ((temp2 owner:) homeStart:) temp1))
				)
				((== (temp1 type:) (temp2 color:))
					(= temp0
						(- (temp1 order:) (((temp2 owner:) homeStart:) order:))
					)
					(if (== ((temp2 curSquare:) type:) 7)
						(= temp0 (+ 52 temp0))
					)
				)
				(else
					(= temp0 6)
					(if (== ((temp2 curSquare:) type:) 7)
						(= temp0 (+ 52 temp0))
					)
				)
			)
			(*= temp0 100)
			(if (== (temp1 type:) 7)
				(= temp4 (if (== global414 TheDice) 36 else 64))
				(= temp5 (localproc_6 temp2 temp1))
				(= temp0
					(= temp6
						(+
							(= temp6 (* (= temp6 (/ temp0 temp4)) temp5))
							(/ (* temp5 (mod temp0 temp4)) temp4)
						)
					)
				)
				(param1 PS: temp5)
				(if (== temp0 0)
					(= temp0 100)
				)
			)
		)
	)
	(return temp0)
)

(procedure (localproc_5 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
	(= temp0 (param1 aSquare:))
	(= temp1 (param1 piece:))
	(= temp2 (param1 captive:))
	(cond
		((== (temp0 type:) 7)
			(= temp3 (localproc_2 ((temp1 owner:) homeStart:) temp0))
		)
		((== (temp0 type:) (temp1 color:))
			(= temp3 (- (temp0 order:) (((temp1 owner:) homeStart:) order:)))
			(if (== ((temp1 curSquare:) type:) 7)
				(= temp3 (+ 52 temp3))
			)
		)
		(else
			(= temp3 6)
			(if (== ((temp1 curSquare:) type:) 7)
				(= temp3 (+ 52 temp3))
			)
		)
	)
	(*= temp3 100)
	(cond
		((== ((temp1 curSquare:) type:) 6)
			(= temp3 5201)
		)
		(temp2
			(= temp3 (+ (= temp3 5200) ((temp2 owner:) percentHome:)))
		)
		(
			(and
				(== (temp0 whoIsOn:) (temp1 owner:))
				(!= (temp0 type:) (temp1 color:))
				(or (not (param1 child:)) (!= temp0 ((param1 child:) pSquare:)))
				(localproc_7 temp1 temp0)
			)
			(= temp3 5200)
		)
	)
	(if
		(and
			(<
				(- (= temp9 ((localproc_8) percentHome:)) 49)
				((temp1 owner:) percentHome:)
				temp9
			)
			(== (temp0 type:) 7)
		)
		(= temp4 (if (== global414 TheDice) 36 else 64))
		(= temp5 (localproc_6 temp1 temp0))
		(param1 PS: temp5)
		(= temp3
			(= temp6
				(+
					(= temp6 (* (= temp6 (/ temp3 temp4)) temp5))
					(/ (* temp5 (mod temp3 temp4)) temp4)
				)
			)
		)
		(= temp7 (temp1 curSquare:))
		(if (!= (temp7 type:) 6)
			(= temp8 (* 100 (localproc_2 ((temp1 owner:) homeStart:) temp7)))
			(= temp5 (localproc_6 temp1 temp7))
			(= temp8
				(= temp6
					(+
						(= temp6 (* (= temp6 (/ temp8 temp4)) temp5))
						(/ (* temp5 (mod temp8 temp4)) temp4)
					)
				)
			)
			(+= temp3 (- temp3 temp8))
		)
		(if (<= temp3 0)
			(= temp3 100)
		)
	)
	(return temp3)
)

(procedure (localproc_6 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp1 0)
	(= temp5 (gTheGamePieces size:))
	(for ((= temp0 0)) (< temp0 temp5) ((++ temp0))
		(= temp3 (gTheGamePieces at: temp0))
		(= temp2 (temp3 curSquare:))
		(cond
			(
				(and
					(!= (param1 color:) (temp3 color:))
					(!= (temp2 type:) (temp3 color:))
				)
				(= temp4 (localproc_2 temp2 param2))
				(if (and (== (temp2 type:) 6) (== global414 TheDice))
					(cond
						((< 1 temp4 8)
							(= temp4 0)
						)
						((> temp4 7)
							(= temp4 99)
						)
					)
				)
				(if
					(or
						(and (== global414 TheDice) (< temp4 13))
						(and (== global414 TheShells) (< temp4 26))
					)
					(+= temp1 (global414 findFrequency: temp4))
				)
			)
			((and (== (param1 color:) (temp3 color:)) (== param2 temp2))
				(= temp1 0)
				(break)
			)
		)
	)
	(if (< (= temp1 (- (if (== global414 TheDice) 36 else 64) temp1)) 0)
		(= temp1 0)
	)
	(return temp1)
)

(procedure (localproc_7 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(= temp7 (gTheGamePieces size:))
	(= temp1 0)
	(for ((= temp0 0)) (< temp0 temp7) ((++ temp0))
		(= temp3 (gTheGamePieces at: temp0))
		(= temp2 (temp3 curSquare:))
		(= temp4 ((temp3 owner:) homeStart:))
		(= temp5 (localproc_2 temp2 temp4))
		(= temp6 (localproc_2 param2 temp4))
		(if (and (!= (temp2 type:) (temp3 color:)) (> temp5 temp6))
			(cond
				((!= (param1 color:) (temp3 color:))
					(if (> ((temp3 owner:) percentHome:) 50)
						(+= temp1 2)
					else
						(+= temp1 1)
					)
				)
				((and (< (- temp5 temp6) 2) (!= (temp2 type:) 6))
					(return 0)
				)
			)
		)
	)
	(return temp1)
)

(procedure (localproc_8 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp2 ((ScriptID 400 7) at: 0)) ; pachisiPlayerList
	(= temp5 ((ScriptID 400 7) size:)) ; pachisiPlayerList
	(= temp1 (temp2 percentHome:))
	(for ((= temp0 1)) (< temp0 temp5) ((++ temp0))
		(= temp3 ((ScriptID 400 7) at: temp0)) ; pachisiPlayerList
		(= temp4 (temp3 percentHome:))
		(if (< temp1 temp4)
			(= temp2 temp3)
			(= temp1 temp4)
		)
	)
	(return temp2)
)

(class PiecesAtHome of EventHandler
	(properties)
)

(class Updates of List
	(properties)
)

(class Garbage of List
	(properties)
)

(class Shell of DragableActor
	(properties
		view 405
		dragable 0
		pipValue 0
		startTop 0
		startLeft 0
		startBottom 0
		startRight 0
		rolling 0
		rollScript 0
		taken 0
		last 0
		offset 0
	)

	(method (track &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 temp7 temp8)
		(= temp5 (List new:))
		(if global181
			(global181 dim:)
			(temp5 add: global181)
			(Animate (temp5 elements:) 0)
			(temp5 release:)
		)
		(if associatedObj
			(if (associatedObj isKindOf: Collect)
				(for ((= temp8 0)) (< temp8 (associatedObj size:)) ((++ temp8))
					(temp5 add: (associatedObj at: temp8))
				)
			else
				(temp5 add: associatedObj)
			)
		)
		(= temp6 priority)
		(self setPri: 14)
		(= temp0 (- x (gMouseCursor x:)))
		(= temp1 (- y (gMouseCursor y:)))
		(self saveData: hilite:)
		(self prevSignal: signal)
		(Animate (temp5 elements:) 0)
		(if draggingCode
			(draggingCode init: self)
		)
		(= temp7 1)
		(while (!= evMOUSERELEASE ((= temp2 (Event new:)) type:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(= gMouseX (temp2 x:))
			(= gMouseY (temp2 y:))
			(cond
				(dragable
					(self x: (+ (temp2 x:) temp0) y: (+ (temp2 y:) temp1))
				)
				(
					(and
						(<= nsLeft gMouseX (- nsRight 1))
						(<= nsTop gMouseY (- nsBottom 1))
					)
					(= temp7 1)
					(self hilite: 1)
				)
				(else
					(= temp7 0)
					(self dim: 1)
				)
			)
			(if draggingCode
				(draggingCode doit: self)
			)
			(Animate (temp5 elements:) 0)
			(temp2 dispose:)
		)
		(if dragable
			(= gMouseX (temp2 x:))
			(= gMouseY (temp2 y:))
		)
		(if draggingCode
			(draggingCode dispose: self)
		)
		(temp2 dispose:)
		(self setPri: temp6)
		(self dim:)
		(temp5 release: dispose:)
		(return temp7)
	)

	(method (throw)
		(= pipValue (Random 0 1))
		(self
			setLoop:
				(switch pipValue
					(0 1)
					(1 0)
				)
			cel: 0
			rolling: 1
		)
		(if (== gHowFast 0)
			(self cel: (self lastCel:))
			(self
				ignoreActors:
				ignoreControl:
				moveSpeed: 0
				setStep: 500 500
				cycleSpeed: 2
				setMotion:
					MoveTo
					(- (Random startLeft startRight) 294)
					(- (Random startTop startBottom) 30)
					self
			)
		else
			(self
				posn:
					(Random startLeft startRight)
					(Random startTop startBottom)
				ignoreActors:
				ignoreControl:
				moveSpeed: 2
				setStep: 50 50
				cycleSpeed: 2
				setCycle: End
				setMotion: ShellRoll self
			)
		)
	)

	(method (pickup)
		(self posn: 400 400 setLoop: -1 setCel: -1)
	)

	(method (cue)
		(self setCycle: 0)
		(if (== global508 self)
			(rollScript cue:)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(<= nsLeft (event x:) (- nsRight 1))
				(<= nsTop (event y:) (- nsBottom 1))
				(or (& (event type:) evMOUSEBUTTON) (proc0_2 event))
			)
			(event claimed: (self processEvent: event))
		)
		(event claimed:)
	)

	(method (goToStart param1 &tmp temp0 temp1)
		(= temp0 (if (and last (IsObject param1)) param1 else 0))
		(= temp1 (+ (global178 shellPos:) offset))
		(self
			setLoop:
			setCel:
			setStep: 10 10
			setMotion: MoveTo [local148 temp1] [local148 (+ temp1 1)] temp0
		)
	)
)

(class TheShells of EventHandler
	(properties
		total 0
		doubles 0
	)

	(method (tally)
		(self
			total:
				(+
					((self at: 0) pipValue:)
					((self at: 1) pipValue:)
					((self at: 2) pipValue:)
					((self at: 3) pipValue:)
					((self at: 4) pipValue:)
					((self at: 5) pipValue:)
				)
		)
		(cond
			((== total 1)
				(self total: 10 doubles: (+ (self doubles:) 1))
			)
			((== total 0)
				(self total: 25 doubles: (+ (self doubles:) 1))
			)
			((== total 6)
				(self doubles: (+ (self doubles:) 1))
			)
			(else
				(self doubles: 0)
			)
		)
	)

	(method (calcMove param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 (param1 curSquare:))
		(= temp2 (param2 type:))
		(cond
			((== (temp1 type:) 6)
				(= temp0 3)
			)
			((or (== temp2 7) (== temp2 (param1 color:)))
				(= temp0 (mod (- (param2 order:) (temp1 order:)) 52))
			)
			(
				(and
					(== temp2 5)
					(==
						(= temp0
							(mod
								(-
									(+ (((param1 owner:) homePath:) order:) 5)
									(temp1 order:)
								)
								52
							)
						)
						1
					)
				)
				(= temp0 2)
			)
		)
		(if
			(and
				(== (temp1 type:) 7)
				(!= temp1 ((param1 owner:) homeStart:))
				(or (== temp2 (param1 color:)) (== temp2 5))
				(> (localproc_2 temp1 ((param1 owner:) homeStart:)) 25)
			)
			(+= temp0 52)
		)
		(return temp0)
	)

	(method (account param1 param2 &tmp temp0)
		(= temp0 (self calcMove: param1 param2))
		(self eachElementDo: #taken 1)
		(self eachElementDo: #hilite 1)
	)

	(method (checkMove param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp1 0)
		(cond
			(
				(or
					(and
						(== ((param2 curSquare:) type:) 7)
						(or
							(== (param1 type:) 7)
							(== (param1 type:) (param2 color:))
							(== (param1 type:) 5)
						)
					)
					(and
						(== ((param2 curSquare:) type:) (param2 color:))
						(or
							(== (param1 type:) (param2 color:))
							(== (param1 type:) 5)
						)
					)
					(and
						(== ((param2 curSquare:) type:) 6)
						(== param1 ((param2 owner:) enter:))
					)
				)
				(cond
					(
						(==
							(= temp0 (self calcMove: param2 param1))
							(global414 total:)
						)
						(= temp3 (param2 curSquare:))
						(= temp2 0)
						(= temp4 0)
						(= temp5 0)
						(while (and (not temp4) (!= temp2 param1))
							(= temp2
								(NodeValue
									(gTheGameSquares
										next: (gTheGameSquares contains: temp3)
									)
								)
							)
							(cond
								((== ((param2 curSquare:) type:) 6)
									(= temp2 param1)
								)
								((== (param1 type:) 7)
									(if
										(and
											(== (temp3 type:) 7)
											(!= (temp2 type:) 7)
										)
										(= temp2 (NodeValue (gTheGameSquares first:)))
									)
									(if (== temp3 ((param2 owner:) homeStart:))
										(Format @local221 499 3) ; "No"
										(Format @local223 499 2) ; "Yes"
										(= temp4
											(Print ; "Do you really want to go past home?"
												499
												1
												#button
												@local221
												1
												#button
												@local223
												0
											)
										)
									)
								)
								((== temp3 ((param2 owner:) homeStart:))
									(= temp2 ((param2 owner:) homePath:))
								)
								((!= (temp2 type:) (temp3 type:))
									(= temp2 (NodeValue (gTheGameSquares last:)))
								)
							)
							(if
								(and
									(== (temp2 howManyOn:) 2)
									(!= temp2 (NodeValue (gTheGameSquares last:)))
								)
								(= temp5 1)
							)
							(= temp3 temp2)
						)
						(cond
							((not (or temp5 temp4))
								(= temp1 1)
							)
							((and temp5 param3)
								(gSound play: 905)
								(Characters say: (Random 0 2) -32768 442 2)
							)
						)
					)
					(param3
						(gSound play: 905)
						(Characters say: (Random 6 8) -32768)
					)
				)
			)
			(param3
				(gSound play: 905)
				(Characters say: (Random 30 32) -32768)
			)
		)
		(return temp1)
	)

	(method (findFrequency param1)
		(return
			(switch param1
				(25 1)
				(10 6)
				(2 15)
				(1 20)
				(3 20)
				(4 15)
				(5 6)
				(6 1)
				(else 0)
			)
		)
	)
)

(class Die of DragableActor
	(properties
		dragable 0
		pipValue 0
		startTop 0
		startLeft 0
		startBottom 0
		startRight 0
		rolling 0
		firstPath 0
		secondPath 0
		nextView 0
		nextLoop 0
		rollScript 0
		taken 0
		last 0
		offset 0
	)

	(method (rollDie)
		(= pipValue (Random 1 6))
		(= taken 0)
	)

	(method (throw)
		(= pipValue (Random 1 6))
		(self choosePath: rolling: 1)
		(self
			posn: (Random startLeft startRight) (Random startTop startBottom)
			view: 301
			ignoreActors:
			ignoreControl:
			moveSpeed: 2
			cycleSpeed: 2
			setStep: 50 50
			setMotion: firstPath self
		)
	)

	(method (pickup)
		(self posn: 400 400 setLoop: -1 setCel: -1)
	)

	(method (cue)
		(switch (++ rolling)
			(2
				(self setMotion: secondPath self)
			)
			(3
				(self setCycle: 0)
				(if (== global508 self)
					(rollScript cue:)
				)
			)
		)
	)

	(method (choosePath)
		(switch (Random 0 1)
			(0
				(= firstPath Rolla)
				(= secondPath Rollb)
				(= nextView 302)
				(= nextLoop (- (* pipValue 2) 2))
				(self setLoop: 0 cel: 0)
				(= hiView 302)
				(= hiLoop 13)
				(= hiCel (- pipValue 1))
			)
			(1
				(= firstPath Rolla)
				(= secondPath Rollb)
				(= nextView 302)
				(= nextLoop (- (* pipValue 2) 1))
				(self setLoop: 1 cel: 0)
				(= hiView 302)
				(= hiLoop 12)
				(= hiCel (- pipValue 1))
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(<= nsLeft (event x:) (- nsRight 1))
				(<= nsTop (event y:) (- nsBottom 1))
				(or (& (event type:) evMOUSEBUTTON) (proc0_2 event))
			)
			(event claimed: (self processEvent: event))
		)
		(event claimed:)
	)

	(method (goToStart param1 &tmp temp0 temp1)
		(= temp0 (if last param1 else 0))
		(= temp1 (+ (global178 dicePos:) offset))
		(self
			dim: 1
			setLoop:
			setCel:
			setStep: 10 10
			setMotion: MoveTo [local132 temp1] [local132 (+ temp1 1)] temp0
		)
	)
)

(class PachisiPlayer of Set
	(properties
		color 0
		homePath 0
		type 0
		skill 0
		start 0
		enter 0
		homeStart 0
		playerName 0
		dicePos 0
		piecePos 0
		shellPos 0
		turnPos 0
		howManyHome 0
		percentHome 0
		character 0
	)

	(method (checkStart)
		(if
			(and
				(!= (start howManyOn:) 0)
				(!= (enter howManyOn:) 2)
				(or
					(and
						(== global414 TheDice)
						(or
							(and
								(== ((TheDice at: 0) pipValue:) 1)
								(not ((TheDice at: 0) taken:))
							)
							(and
								(== ((TheDice at: 1) pipValue:) 1)
								(not ((TheDice at: 1) taken:))
							)
						)
					)
					(and (== global414 TheShells) (== (TheShells total:) 3))
				)
			)
			(Characters say: (Random 9 11) -32768 443 4)
		)
	)

	(method (initPawns param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 param11 param12 param13)
		(self
			color: param1
			start: param2
			enter: param3
			homeStart: param4
			homePath: param5
			dicePos: param11
			piecePos: param10
			shellPos: param12
			turnPos: param13
			add: param6 param7 param8 param9
		)
		(gTheGamePieces add: param6 param7 param8 param9)
		(param6
			init:
			owner: self
			curSquare: param2
			x: [local68 (+ param10 0)]
			y: [local68 (+ param10 1)]
		)
		(param7
			init:
			owner: self
			curSquare: param2
			x: [local68 (+ param10 2)]
			y: [local68 (+ param10 3)]
		)
		(param8
			init:
			owner: self
			curSquare: param2
			x: [local68 (+ param10 4)]
			y: [local68 (+ param10 5)]
		)
		(param9
			init:
			owner: self
			curSquare: param2
			x: [local68 (+ param10 6)]
			y: [local68 (+ param10 7)]
		)
	)

	(method (calcScore &tmp temp0 temp1 temp2 temp3)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= temp2 (self at: temp0))
			(= temp3 (temp2 curSquare:))
			(+=
				temp1
				(cond
					((== (temp3 type:) 7)
						(localproc_2 ((temp2 owner:) start:) temp3)
					)
					((== (temp3 type:) 5) 58)
					((== (temp3 type:) (temp2 color:))
						(+
							52
							(-
								(temp3 order:)
								(((temp2 owner:) homeStart:) order:)
							)
						)
					)
				)
			)
		)
		(self percentHome: (/ (* temp1 100) 232))
	)

	(method (cue &tmp [temp0 25])
		(if (not (global414 allTrue: 663))
			(if (!= howManyHome 4)
				(cond
					((or local0 global413)
						(if local0
							(gSound play: 400)
						)
						(= local0 0)
						(proc0_3)
					)
					((self findMove: 1)
						(global414 eachElementDo: #stopUpd)
						(proc0_3)
					)
					(else
						(gSound2 play: 902)
						(if (== type 2)
							(character say: (Random 57 59) 0 443 2)
						else
							(Characters say: (Random 54 56) -32768 441 2)
						)
						(global414 eachElementDo: #taken 1)
					)
				)
			else
				(global414 eachElementDo: #taken 1)
			)
		)
		(self eachElementDo: #stopUpd)
	)

	(method (isOn param1)
		(self firstTrue: #isOn param1)
	)

	(method (findMove &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 28])
		(= temp5 0)
		(if (== global414 TheShells)
			(= [temp6 0] (TheShells total:))
			(= temp2 1)
		else
			(= temp2 0)
			(if (not ((TheDice at: 0) taken:))
				(++ temp2)
				(= [temp6 (- temp2 1)] ((TheDice at: 0) pipValue:))
			)
			(if (not ((TheDice at: 1) taken:))
				(++ temp2)
				(= [temp6 (- temp2 1)] ((TheDice at: 1) pipValue:))
			)
		)
		(for ((= temp0 0)) (< temp0 temp2) ((++ temp0))
			(for ((= temp1 0)) (< temp1 4) ((++ temp1))
				(if
					(and
						(!= 5 (((= temp3 (self at: temp1)) curSquare:) type:))
						(= temp4 (localproc_0 temp3 [temp6 temp0]))
						(global414 checkMove: temp4 temp3 0)
					)
					(= temp5 1)
					(break 2)
				)
			)
		)
		(if temp5
			(return 1)
		)
	)

	(method (findBestMove param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 29])
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= temp1 (self at: temp0))
			(= [temp8 temp0] 0)
			(= temp5 0)
			(if
				(and
					(!= ((temp1 curSquare:) type:) 5)
					(= temp2 (localproc_0 temp1 param1))
					(global414 checkMove: temp2 temp1 0)
				)
				((= [temp8 temp0] (MoveObj new:))
					piece: temp1
					aSquare: temp2
					pSquare: (temp1 curSquare:)
				)
				(if (and (= temp6 (temp2 whoIsOn:)) (!= self temp6))
					([temp8 temp0] captive: (= temp5 (temp6 isOn: temp2)))
				)
				(if (and param2 (!= (global178 skill:) 0))
					(= temp7 (temp1 curSquare:))
					(temp7 howManyOn: (- (temp7 howManyOn:) 1))
					(if (not (temp7 howManyOn:))
						(temp7 whoIsOn: 0)
					)
					(temp1 curSquare: temp2)
					(= global401 temp2)
					(temp2 whoIsOn: self)
					(if temp5
						(temp5 curSquare: ((temp5 owner:) start:))
					else
						(temp2 howManyOn: (+ (temp2 howManyOn:) 1))
					)
					([temp8 temp0] child: (self findBestMove: param2 0))
					(temp1 curSquare: temp7)
					(temp7
						howManyOn: (+ (temp7 howManyOn:) 1)
						whoIsOn: (temp1 owner:)
					)
					(if temp5
						(temp5 curSquare: temp2)
					else
						(temp2 howManyOn: (- (temp2 howManyOn:) 1))
					)
					(temp2 whoIsOn: temp6)
					(= global401 0)
				)
				(localproc_1 [temp8 temp0])
			)
		)
		(= temp3 0)
		(= temp4 0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(if [temp8 temp0]
				(if (> ([temp8 temp0] rank:) temp3)
					(if temp4
						(temp4 dispose:)
					)
					(= temp3 ([temp8 temp0] rank:))
					(= temp4 [temp8 temp0])
				else
					([temp8 temp0] dispose:)
				)
			)
		)
		(if (not temp4)
			(return 0)
		else
			(return temp4)
		)
	)

	(method (findBestDiceMove &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 0)
		(= temp1 0)
		(= temp5 (TheDice at: 0))
		(= temp2
			(if (not (temp5 taken:))
				(temp5 pipValue:)
			else
				0
			)
		)
		(= temp5 (TheDice at: 1))
		(= temp3
			(if (not (temp5 taken:))
				(temp5 pipValue:)
			else
				0
			)
		)
		(if temp2
			(= temp0 (self findBestMove: temp2 temp3 0))
		)
		(if temp3
			(= temp1 (self findBestMove: temp3 temp2 0))
		)
		(cond
			((and temp0 temp1 (< (temp0 rank:) (temp1 rank:)))
				(temp0 dispose:)
				(= temp4 temp1)
			)
			(temp0
				(if temp1
					(temp1 dispose:)
				)
				(= temp4 temp0)
			)
			(temp1
				(= temp4 temp1)
			)
			(else
				(= temp4 0)
			)
		)
		(return temp4)
	)
)

(class PachisiRect of KMRect
	(properties
		whoIsOn 0
		howManyOn 0
		type 0
		order 0
		neighborN 0
		neighborE 0
		neighborS 0
		neighborW 0
	)

	(method (addPiece param1)
		(if (!= type 5)
			(self whoIsOn: (param1 owner:) howManyOn: (+ howManyOn 1))
		else
			((param1 owner:) howManyHome: (+ ((param1 owner:) howManyHome:) 1))
		)
		(if (and (!= type 6) (!= type 5))
			(self adjust:)
		)
	)

	(method (deletePiece)
		(self howManyOn: (- howManyOn 1))
		(if (== howManyOn 0)
			(self whoIsOn: 0)
		else
			(self adjust:)
		)
	)

	(method (becomeActive)
		((KeyMouse objList:) release:)
		(if neighborN
			((KeyMouse objList:) add: neighborN)
		)
		(if neighborE
			((KeyMouse objList:) add: neighborE)
		)
		(if neighborS
			((KeyMouse objList:) add: neighborS)
		)
		(if neighborW
			((KeyMouse objList:) add: neighborW)
		)
	)

	(method (canTake param1)
		(if (!= self (param1 curSquare:))
			(return (global414 checkMove: self param1 1))
		else
			(return 1)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (and (event type:) (self containsXYOf: event))
			(cond
				((& (event type:) evMOUSEBUTTON)
					(event claimed: 1)
					(self becomeActive:)
				)
				((and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(event claimed: 1)
					(cond
						(global181
							(if (self canTake: global181)
								(if (!= self (global181 curSquare:))
									(global181 changeSquare: self)
								else
									(global181 dim: 1)
									(= global181 0)
								)
							)
						)
						((and (= temp0 (global178 isOn: self)) (!= type 5))
							(= global181 temp0)
							(global181 hilite: 1)
						)
					)
					(self becomeActive:)
				)
			)
		)
		(event claimed:)
	)

	(method (containsXYOf param1)
		(return
			(and
				(<= nsLeft (param1 x:) nsRight)
				(<= nsTop (param1 y:) nsBottom)
			)
		)
	)

	(method (adjust &tmp [temp0 4] [temp4 4] temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15)
		(cond
			((== type 6)
				(= temp14 (whoIsOn piecePos:))
				(= temp13 whoIsOn)
				(= temp15 howManyOn)
				(for ((= temp10 0)) (<= temp10 3) ((++ temp10))
					(= [temp0 temp10] [local68 (+ temp14 (* 2 temp10))])
					(= [temp4 temp10] [local68 (+ temp14 (* 2 temp10) 1)])
				)
			)
			((== type 5)
				(= temp14 (global178 piecePos:))
				(= temp13 global178)
				(= temp15 (global178 howManyHome:))
				(for ((= temp10 0)) (<= temp10 3) ((++ temp10))
					(= [temp0 temp10] [local100 (+ temp14 (* 2 temp10))])
					(= [temp4 temp10] [local100 (+ temp14 (* 2 temp10) 1)])
				)
			)
			(else
				(= temp8 (- nsRight nsLeft))
				(= temp9 (- nsBottom nsTop))
				(= temp13 whoIsOn)
				(= temp15 howManyOn)
				(cond
					((== howManyOn 1)
						(= [temp0 0] (+ nsLeft (/ temp8 2)))
						(= [temp4 0] (+ nsTop (/ temp9 2)))
					)
					((> temp8 temp9)
						(= [temp4 0] (= [temp4 1] (+ nsTop (/ temp9 2))))
						(= [temp0 0] (+ nsLeft (/ temp8 3)))
						(= [temp0 1] (- nsRight (/ temp8 3)))
					)
					(else
						(= [temp0 0] (= [temp0 1] (+ nsLeft (/ temp8 2))))
						(= [temp4 0] (+ nsTop (/ temp9 3)))
						(= [temp4 1] (- nsBottom (/ temp9 3)))
					)
				)
			)
		)
		(= temp10 0)
		(= temp11 0)
		(while (!= temp11 temp15)
			(if ((= temp12 (temp13 at: temp10)) isOn: self)
				(temp12 posn: [temp0 temp11] [temp4 temp11] stopUpd:)
				(++ temp11)
			)
			(++ temp10)
		)
		(proc0_1)
	)
)

(class TheDice of EventHandler
	(properties
		doubles 0
		total 0
	)

	(method (calcMove param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 (param1 curSquare:))
		(= temp2 (param2 type:))
		(cond
			((== (temp1 type:) 6)
				(= temp0 1)
			)
			((or (== temp2 7) (== temp2 (param1 color:)))
				(= temp0 (mod (- (param2 order:) (temp1 order:)) 52))
			)
			((== temp2 5)
				(= temp0
					(mod
						(-
							(+ (((param1 owner:) homePath:) order:) 5)
							(temp1 order:)
						)
						52
					)
				)
			)
		)
		(if
			(and
				(== (temp1 type:) 7)
				(!= temp1 ((param1 owner:) homeStart:))
				(or (== temp2 (param1 color:)) (== temp2 5))
				(> (localproc_2 temp1 ((param1 owner:) homeStart:)) 12)
			)
			(+= temp0 52)
		)
		(return temp0)
	)

	(method (account param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 ((self at: 0) pipValue:))
		(= temp2 ((self at: 1) pipValue:))
		(= temp3 ((self at: 0) taken:))
		(= temp4 ((self at: 1) taken:))
		(= temp0 (self calcMove: param1 param2))
		(cond
			((and (not temp3) (== temp0 temp1))
				((self at: 0) taken: 1)
				((self at: 0) hilite: 1)
			)
			((and (not temp4) (== temp0 temp2))
				((self at: 1) taken: 1)
				((self at: 1) hilite: 1)
			)
		)
	)

	(method (tally)
		(if (== ((self at: 0) pipValue:) ((self at: 1) pipValue:))
			(self doubles: (+ (self doubles:) 1))
		else
			(self doubles: 0)
		)
		(self total: (+ ((self at: 0) pipValue:) ((self at: 1) pipValue:)))
	)

	(method (checkMove param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= temp1 ((self at: 0) pipValue:))
		(= temp2 ((self at: 1) pipValue:))
		(= temp3 ((self at: 0) taken:))
		(= temp4 ((self at: 1) taken:))
		(= temp5 0)
		(cond
			(
				(or
					(and
						(== ((param2 curSquare:) type:) 7)
						(or
							(== (param1 type:) 7)
							(== (param1 type:) (param2 color:))
							(== (param1 type:) 5)
						)
					)
					(and
						(== ((param2 curSquare:) type:) (param2 color:))
						(or
							(== (param1 type:) (param2 color:))
							(== (param1 type:) 5)
						)
					)
					(and
						(== ((param2 curSquare:) type:) 6)
						(== param1 ((param2 owner:) enter:))
					)
				)
				(= temp0 (self calcMove: param2 param1))
				(cond
					(
						(or
							(and (not temp3) (== temp0 temp1))
							(and (not temp4) (== temp0 temp2))
						)
						(cond
							(
								(not
									(and
										(self doubles:)
										(== param1 global401)
										(!= param1 ((param2 owner:) enter:))
									)
								)
								(= temp7 (param2 curSquare:))
								(= temp6 0)
								(= temp8 0)
								(= temp9 0)
								(while (and (not temp8) (!= temp6 param1))
									(= temp6
										(NodeValue
											(gTheGameSquares
												next:
													(gTheGameSquares contains: temp7)
											)
										)
									)
									(cond
										((== ((param2 curSquare:) type:) 6)
											(= temp6 param1)
										)
										((== (param1 type:) 7)
											(if
												(and
													(== (temp7 type:) 7)
													(!= (temp6 type:) 7)
												)
												(= temp6
													(NodeValue
														(gTheGameSquares first:)
													)
												)
											)
											(if
												(==
													temp7
													((param2 owner:) homeStart:)
												)
												(Format @local221 499 3) ; "No"
												(Format @local223 499 2) ; "Yes"
												(= temp8
													(Print ; "Do you really want to go past home?"
														499
														1
														#button
														@local221
														1
														#button
														@local223
														0
													)
												)
											)
										)
										((== temp7 ((param2 owner:) homeStart:))
											(= temp6
												((param2 owner:) homePath:)
											)
										)
										((!= (temp6 type:) (temp7 type:))
											(= temp6
												(NodeValue (gTheGameSquares last:))
											)
										)
									)
									(if
										(and
											(== (temp6 howManyOn:) 2)
											(!=
												temp6
												(NodeValue (gTheGameSquares last:))
											)
										)
										(= temp9 1)
									)
									(= temp7 temp6)
								)
								(cond
									((not (or temp9 temp8))
										(= temp5 1)
									)
									((and temp9 param3)
										(gSound play: 905)
										(Characters
											say: (Random 0 2) -32768 442 2
										)
									)
								)
							)
							(param3
								(gSound play: 905)
								(Characters say: (Random 3 5) -32768)
							)
						)
					)
					(param3
						(gSound play: 905)
						(Characters say: (Random 6 8) -32768)
					)
				)
			)
			(param3
				(gSound play: 905)
				(Characters say: (Random 30 32) -32768)
			)
		)
		(return temp5)
	)

	(method (findFrequency param1)
		(return (if (<= param1 12) [local208 param1] else 0))
	)
)

(class PachisiPiece of DragableActor
	(properties
		view 400
		cel 1
		priority 8
		signal 16401
		moveSpeed 5
		hiView 400
		hiCel 0
		color 0
		curSquare 0
		owner 0
	)

	(method (canGoHere &tmp temp0)
		(if
			(and
				(= temp0 (gTheGameSquares firstTrue: #containsXYOf self))
				(not (temp0 canTake: self))
			)
			(= temp0 0)
		)
		(return temp0)
	)

	(method (isOn param1)
		(return (== param1 curSquare))
	)

	(method (changeSquare param1)
		(global414 account: self param1)
		(= global401 param1)
		(self
			cycleSpeed: 2
			setStep: 5 5
			setScript:
				moveScript
				(if (== (owner type:) 1)
					owner
				else
					(ScriptID 402 22) ; computerScript
				)
				param1
		)
	)

	(method (jumpTo param1 param2 &tmp temp0 temp1)
		(proc0_4)
		(if (IsObject param1)
			(= temp0
				(+
					(param1 nsLeft:)
					(/ (- (param1 nsRight:) (param1 nsLeft:)) 2)
				)
			)
			(= temp1
				(+ (param1 nsTop:) (/ (- (param1 nsBottom:) (param1 nsTop:)) 2))
			)
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(= local0 1)
		(self
			cycleSpeed: 2
			setStep: 5 5
			setLoop:
			setCel:
			setMotion: MoveTo temp0 temp1 owner
		)
	)

	(method (handleEvent event &tmp temp0)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(<= nsLeft (event x:) (- nsRight 1))
				(<= nsTop (event y:) (- nsBottom 1))
			)
			(event claimed: 1)
			(if (not global413)
				(if (== global178 (self owner:))
					(if (!= (curSquare type:) 5)
						(if
							(and
								(== (curSquare howManyOn:) 2)
								(!= (curSquare type:) 6)
							)
							(owner delete: self)
							(Updates add: (owner isOn: curSquare))
							(owner add: self)
						)
						(Reminder
							posn: (self x:) (self y:)
							setLoop: (self loop:)
							show:
							stopUpd:
						)
						(Updates add: Reminder)
						(self associatedObj: Updates)
						(proc0_1)
						(self track:)
						(self associatedObj: 0)
						(Reminder hide:)
						(Updates release:)
						(if
							(and
								(= temp0 (self canGoHere:))
								(!= temp0 curSquare)
							)
							(self changeSquare: temp0)
							(temp0 becomeActive:)
						else
							(gSound play: 904)
							(self jumpTo: prevX prevY)
						)
						(= global181 0)
					else
						(Characters say: {That piece is already home.} -32768)
					)
				else
					(Characters say: {Move your own pieces, please.} -32768)
				)
			else
				(Characters say: {You must roll the dice first.} -32768)
			)
		)
		(event claimed:)
	)
)

(class Indicator of Prop
	(properties
		x 400
		y 350
		view 850
		cel 1
		priority 8
		signal 20496
	)

	(method (changePlayer param1 &tmp temp0)
		(= temp0 (param1 turnPos:))
		(self
			posn: [local196 temp0] [local196 (+ temp0 1)]
			setLoop: [local196 (+ temp0 2)]
			hide:
		)
	)
)

(class Reminder of View
	(properties
		x 400
		y 375
		view 400
		cel 2
		priority 8
		signal 20496
	)
)

(class MoveObj of Obj
	(properties
		piece 0
		aSquare 0
		pSquare 0
		rank 0
		PS 0
		captive 0
		child 0
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(Garbage add: temp0)
		(return temp0)
	)

	(method (dispose)
		(if child
			(child dispose:)
		)
		(Garbage delete: self)
		(super dispose:)
	)
)

(class Rolla of RelPath
	(properties)

	(method (at param1)
		(return [local1 param1])
	)

	(method (doit)
		(if (super doit:)
			(client cel: (+ (client cel:) 1))
			(if (> (client cel:) (client lastCel:))
				(client cel: (client lastCel:))
			)
		)
	)
)

(class Rollb of RelPath
	(properties)

	(method (at param1)
		(return [local20 param1])
	)

	(method (doit)
		(if (super doit:)
			(if (!= (client view:) 302)
				(client
					view: 302
					cel: -1
					loop: (- (* (client pipValue:) 2) (+ (client loop:) 1))
				)
			)
			(client cel: (+ (client cel:) 1))
			(if (> (client cel:) (client lastCel:))
				(client cel: (client lastCel:))
			)
		)
	)
)

(class ShellRoll of RelPath
	(properties)

	(method (at param1)
		(return [local35 param1])
	)
)

(instance moveScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 [temp3 25] temp28 temp29 temp30 temp31)
		(switch (= state newState)
			(0
				(proc0_4)
				(cond
					(
						(or
							(== (= temp30 (register type:)) 7)
							(== temp30 (client color:))
						)
						(= temp28
							(+
								(register nsLeft:)
								(/ (- (register nsRight:) (register nsLeft:)) 2)
							)
						)
						(= temp29
							(+
								(register nsTop:)
								(/ (- (register nsBottom:) (register nsTop:)) 2)
							)
						)
					)
					((== temp30 6)
						(= temp28
							[local68
								(= temp31
									(+
										((client owner:) piecePos:)
										(* (register howManyOn:) 2)
									)
								)
							]
						)
						(= temp29 [local68 (+ temp31 1)])
					)
					((== temp30 5)
						(= temp0 (client owner:))
						(= temp28
							[local100
								(= temp31
									(+
										(temp0 piecePos:)
										(* (temp0 howManyHome:) 2)
									)
								)
							]
						)
						(= temp29 [local100 (+ temp31 1)])
					)
				)
				(client setLoop: setCel: setMotion: MoveTo temp28 temp29 self)
			)
			(1
				(gSound play: 400)
				(= seconds 1)
			)
			(2
				(= temp1 (register whoIsOn:))
				(= temp0 (client owner:))
				(if (!= 0 temp1 temp0)
					(gSound2 priority: 15 play: 907)
					(cond
						((== (temp1 type:) 2)
							(if (Random 0 2)
								((temp1 character:) frown:)
							else
								((temp1 character:) say: (Random 39 41) 0 443 2)
							)
							(if (== (temp0 type:) 2)
								(if (Random 0 2)
									((temp0 character:) smile:)
								else
									((temp0 character:) laugh:)
								)
							)
						)
						((and (== (temp0 type:) 2) (== (temp1 type:) 1))
							(if (Random 0 2)
								((temp0 character:) laugh:)
							else
								((temp0 character:) say: (Random 42 44) 0 442 2)
							)
						)
					)
					((temp1 isOn: register)
						setScript: (self new:) self (temp1 start:)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if (== (register type:) 5)
					(gSound2 priority: 14 play: 202)
					(gTheGamePieces delete: client)
					(PiecesAtHome add: client)
					(= ticks 180)
				else
					(= cycles 1)
				)
			)
			(4
				(= temp2 (client curSquare:))
				(client setLoop: -1 setCel: -1 curSquare: register)
				(temp2 deletePiece:)
				(register addPiece: client)
				((client owner:) calcScore:)
				(self dispose:)
			)
		)
	)
)

