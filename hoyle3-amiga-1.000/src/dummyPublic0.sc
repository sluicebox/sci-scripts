;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 303)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Interface)
(use LeapTo)
(use RandCycle)
(use Path)
(use Motion)
(use Actor)
(use System)

(public
	dummyPublic0 0
	proc303_1 1
	proc303_2 2
	proc303_3 3
	point1 4
	point2 5
	point3 6
	point4 7
	point5 8
	point6 9
	point7 10
	point8 11
	point9 12
	point10 13
	point11 14
	point12 15
	point13 16
	point14 17
	point15 18
	point16 19
	point17 20
	point18 21
	point19 22
	point20 23
	point21 24
	point22 25
	point23 26
	point24 27
)

(local
	[local0 19] = [39 -2 38 -2 35 -2 33 -2 27 -2 22 -2 18 -2 14 -2 10 -2 -32768]
	[local19 15] = [7 -2 6 -2 5 -2 4 -2 3 -2 2 -2 2 0 -32768]
	local34
)

(procedure (proc303_2 &tmp [temp0 50] temp50 temp51)
	(= temp50 (gSystemWindow color:))
	(= temp51 (gSystemWindow back:))
	(gSystemWindow color: 16 back: 21)
	(proc0_1)
	(if (and (== (global178 type:) 1) (!= global179 2))
		(gSong play: 802 setLoop: -1)
	)
	(Format @global550 399 2 (global303 playerName:) (global304 playerName:)) ; "SCORECARD  %10s  %10s"
	(StrCat @global550 (Format @temp0 399 3)) ; "------------------------------------"
	(StrCat
		@global550
		(Format @temp0 399 4 (global303 totalPts:) (global304 totalPts:)) ; "Total Points %10d  %10d"
	)
	(StrCat
		@global550
		(Format @temp0 399 5 (global303 gamesWon:) (global304 gamesWon:)) ; "Games Won  %10d  %10d"
	)
	(StrCat
		@global550
		(Format @temp0 399 6 (global303 gammons:) (global304 gammons:)) ; "Gammons   %10d  %10d"
	)
	(StrCat
		@global550
		(Format @temp0 399 7 (global303 backgammons:) (global304 backgammons:)) ; "Backgammons %10d  %10d"
	)
	(StrCat
		@global550
		(Format @temp0 399 8 (global303 count:) (global304 count:)) ; "Pip Count  %10d  %10d"
	)
	(Print @global550 33 500 70 216 179 gDoAbsCode)
	(gSystemWindow color: temp50 back: temp51)
	(gSong fade:)
)

(procedure (proc303_3 &tmp [temp0 2])
	(if global323
		(gTheDiceList eachElementDo: #dim eachElementDo: #pickup 0)
	)
	(= global323 0)
	(= global336 global315)
	(gTheDoubleCube reset:)
	(global303 moveAllToBar:)
	(global304 moveAllToBar:)
	(global303 setupPlayer:)
	(global304 setupPlayer:)
	(proc0_1)
	(= global305 0)
	(= global325 1)
)

(procedure (proc303_1)
	(switch (Print 303 4 #button { Play Game } 1 #button { Setup Board } 2) ; "Backgammon"
		(1
			(if global338
				(switch (Print 303 5 #button { No } 1 #button { Yes } 2) ; "Show generated moves?"
					(1
						(= global340 0)
					)
					(2
						(= global340 1)
					)
				)
			)
		)
		(2
			(= global337 1)
			(return)
		)
	)
)

(instance dummyPublic0 of Code
	(properties)
)

(class Point of List
	(properties
		blot 0
		closed 0
		whose 2
		number 0
		altNum 0
		hit 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		dir 0
		tempSize 0
		blotNum 0
		hitNum 0
		hitProb 0
		hitStore 0
	)

	(method (init)
		(super init: &rest)
		(= tempSize size)
		(self addKeyMouse:)
	)

	(method (cue &tmp temp0)
		(if (== (gCurRoom picture:) 350)
			(if (Random 0 1)
				(gSound play: 300)
			else
				(gSound play: 301)
			)
		else
			(gSound play: 302)
		)
		(if (>= (= temp0 (self indexOf: global181)) 0)
			(global181
				signal: (| (global181 signal:) $0810)
				loop:
					(+
						(global181 color:)
						(if
							(and
								(!= self (ScriptID 300 1)) ; off1
								(!= self (ScriptID 300 2)) ; off2
							)
							0
						else
							3
						)
					)
				priority: (+ 12 (/ temp0 5))
			)
		)
		(global181 moveSpeed: 3 xStep: 9 yStep: 6 stopUpd:)
		(= global181 0)
		(if (or (== (global178 type:) 1) global337)
			(proc0_3)
		)
		(gGamePlayScript cycles: 1)
	)

	(method (getAssocPt param1 param2 &tmp temp0 temp1 temp2)
		(gAssocPoint release:)
		(for ((= temp2 0)) (< temp2 size) ((++ temp2))
			(if (!= param2 (= temp0 (self at: temp2)))
				(gAssocPoint add: temp0)
			)
		)
	)

	(method (moveToPoint &tmp temp0)
		((= global181 (NodeValue (self last:))) movePos: self (- size 1))
		(global181 setPri: 15)
		(if (!= global305 1)
			(= temp0 (* global326 384))
			(if global326
				(global181 setMotion: LeapTo global306 global307 0 self temp0)
			else
				(global181
					xStep: (* (global181 xStep:) 2)
					yStep: (* (global181 yStep:) 2)
					setMotion: MoveTo global306 global307 self
				)
			)
		else
			(global181
				xStep: (* (global181 xStep:) 2)
				yStep: (* (global181 yStep:) 2)
				setMotion: MoveTo global306 global307 self
			)
		)
		(if global305
			(-- global305)
		)
	)

	(method (adjustPoint &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			((= temp1 (self at: temp0)) movePos: self temp0)
			(temp1 x: global306 y: global307 stopUpd:)
			(gACast add: temp1)
		)
	)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((== argc 2)
				(= temp0 [event 1])
				(if
					(and
						(<=
							nsLeft
							(>> (+ (temp0 nsLeft:) (temp0 nsRight:)) $0001)
							nsRight
						)
						(<=
							nsTop
							(>> (+ (temp0 nsTop:) (temp0 nsBottom:)) $0001)
							nsBottom
						)
					)
					(event claimed: 1)
					(return self)
				)
			)
			(
				(and
					(<= nsLeft (event x:) nsRight)
					(<= nsTop (event y:) nsBottom)
				)
				(event claimed: 1)
				(return self)
			)
		)
		(return 0)
	)
)

(class Dies of Actor
	(properties
		cycleSpeed 2
		moveSpeed 2
		pipValue 0
		oldPoint 0
		newPoint 0
		startTop 0
		startLeft 0
		startBottom 0
		startRight 0
		rolling 0
		initX 0
		initY 0
	)

	(method (reset)
		(self
			dim:
			pickup: 1
			setPri: 12
			moveSpeed: 2
			cycleSpeed: 2
			setCycle: RandCycle
		)
	)

	(method (throw &tmp temp0)
		(= temp0 (Random 0 1))
		(self
			view: 301
			startUpd:
			setPri: 15
			setLoop: temp0
			cel: 0
			rolling: -1
			posn:
				(-
					(+
						(Random startLeft startRight)
						(if (== global178 global303) 112 else 0)
					)
				)
				(Random startTop startBottom)
			ignoreControl:
			setMotion: Roll1 self
		)
	)

	(method (cue)
		(switch (++ rolling)
			(0
				(self setMotion: Roll2 self)
			)
			(1
				(if (== self gTheDice2)
					(gTheDice1 stopRoll:)
					(gTheDice2 stopRoll:)
					(if (== (global178 type:) 1)
						(proc0_3)
					)
					(gSound flags: 1)
					(local34 cue:)
				)
			)
		)
	)

	(method (init)
		(self
			view: 302
			ignoreActors:
			ignoreHorizon:
			ignoreControl:
			setStep: 50 50
			startUpd:
		)
		(= initX x)
		(= initY y)
		(super init: &rest)
	)

	(method (rollDie)
		(= pipValue (Random 1 6))
	)

	(method (clearDie)
		(= oldPoint (= newPoint 0))
	)

	(method (setPip param1)
		(if param1
			(= loop (+ (* (- pipValue 1) 2) (Random 0 1)))
		else
			(= loop (+ (* (- pipValue 1) 2) (mod loop 2)))
		)
		(= cel (- (NumCels self) 1))
	)

	(method (dim)
		(self view: 302 setLoop: (+ 12 (mod loop 2)) cel: (- pipValue 1))
	)

	(method (pickup param1)
		(self moveDie:)
		(if param1
			(proc0_1)
		)
		(self stopUpd:)
	)

	(method (stopRoll)
		(self setPri: 12 setCycle: 0 stopUpd:)
	)

	(method (moveDie)
		(if (or (== self gTheDice1) (== self gTheDice2))
			(if (== global332 global178)
				(self
					posn:
						initX
						(if (== self gTheDice2)
							(gTheDice1 initY:)
						else
							(gTheDice2 initY:)
						)
				)
			else
				(self posn: initX initY)
			)
		)
	)
)

(class DieList of List
	(properties
		doubles 1
		numberUsed 0
	)

	(method (movePick param1 param2 &tmp temp0)
		(if (not doubles)
			((self at: param1) dim: pickup: param2)
		else
			((= temp0 (self at: (>> param1 $0001))) dim:)
			(if (mod numberUsed 2)
				(temp0 pickup: param2)
			)
		)
		(++ numberUsed)
	)

	(method (pickupAll)
		(self numberUsed: size eachElementDo: #dim eachElementDo: #pickup 1)
	)

	(method (clearAll &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			((self at: temp0) clearDie:)
		)
	)

	(method (actualRoll param1 &tmp [temp0 3])
		(= numberUsed 0)
		(if doubles
			(self delete: gTheDice3 gTheDice4)
		)
		(if (and (== (NodeValue (self first:)) gTheDice2) (not global339))
			(self delete: gTheDice2 add: gTheDice2)
		)
		(if (not global339)
			(self eachElementDo: #clearDie)
			(if (not argc)
				(self eachElementDo: #rollDie)
			else
				(gTheDice1 pipValue: [param1 0])
				(gTheDice2 pipValue: [param1 0])
			)
		)
		(if global338
			(Format @temp0 303 0 (gTheDice1 pipValue:)) ; "%d"
			(Print 303 1 #edit @temp0 2) ; "Die 1"
			(gTheDice1 pipValue: (ReadNumber @temp0))
			(Format @temp0 303 0 (gTheDice2 pipValue:)) ; "%d"
			(Print 303 2 #edit @temp0 2) ; "Die 2"
			(gTheDice2 pipValue: (ReadNumber @temp0))
		)
		(= doubles (== (gTheDice1 pipValue:) (gTheDice2 pipValue:)))
	)

	(method (sortDice &tmp temp0)
		(if (< (gTheDice1 pipValue:) (gTheDice2 pipValue:))
			(= temp0 (gTheDice1 pipValue:))
			(gTheDice1 pipValue: (gTheDice2 pipValue:))
			(gTheDice2 pipValue: temp0)
		)
	)

	(method (rollDice param1 &tmp temp0 temp1)
		(proc0_4)
		(if (not global339)
			(if (> argc 1)
				(self actualRoll: &rest)
			else
				(self actualRoll:)
			)
		)
		(if doubles
			(self add: gTheDice3 gTheDice4)
			(gTheDice3 clearDie: pipValue: (= temp0 (gTheDice1 pipValue:)))
			(gTheDice4 clearDie: pipValue: temp0)
		else
			(self sortDice:)
		)
		(= local34 param1)
		(gSound play: 504 setLoop: 1 flags: 0)
		(for ((= temp1 0)) (< temp1 2) ((++ temp1))
			((gTheDiceList at: temp1) throw:)
		)
		(= temp0 (Random 2 6))
		(while (-- temp0)
			(gTheDice1 doit:)
			(proc0_1)
		)
	)

	(method (calcUsed param1 &tmp temp0 temp1 temp2)
		(= temp1 (>> argc $0001))
		(for ((= temp2 (= temp0 0))) (< temp2 temp1) ((++ temp2))
			(+=
				temp0
				(- ([param1 temp2] number:) ([param1 (+ temp1 temp2)] number:))
			)
		)
		(return temp0)
	)

	(method (whoFirst &tmp temp0)
		(self eachElementDo: #init)
		(proc0_1)
		(proc0_4)
		(repeat
			(self actualRoll:)
			(if (or (not doubles) global338)
				(break)
			)
		)
		(self eachElementDo: #reset)
		(if (and doubles global338)
			(self add: gTheDice3 gTheDice4)
			(gTheDice3 clearDie: pipValue: (gTheDice1 pipValue:))
			(gTheDice4 clearDie: pipValue: (gTheDice1 pipValue:))
			(switch (Print 303 3 #button {Player 1} 1 #button {Player 2} 2) ; "Current Player :"
				(1
					(= global178 global303)
				)
				(2
					(= global178 global304)
				)
			)
		)
		(if (not doubles)
			(= global178
				(if (> (gTheDice1 pipValue:) (gTheDice2 pipValue:))
					global303
				else
					global304
				)
			)
		)
		(if (not global337)
			(= temp0 90)
			(gSound play: 303 setLoop: -1)
			(while (-- temp0)
				(= gGameTime (+ gTickOffset (GetTime)))
				(Wait 1)
				(Animate (self elements:) 1)
				(Random 1 6)
			)
			(gSound setLoop: 1 stop:)
		)
		(self sortDice:)
		(gTheDice1 moveDie:)
		(gTheDice2 moveDie:)
		(self eachElementDo: #setPip 1 eachElementDo: #stopRoll)
		(proc0_1)
		(proc0_3)
		(gTheArrow init:)
		(if (!= global179 2)
			(if (== (global178 type:) 2)
				(gChar1 say: (Random 0 2) 0 441 1)
			else
				(gChar1 say: (Random 3 5) 0 443 1)
			)
		else
			(Print (Format @global550 399 1 (global178 playerName:))) ; "%s wins the dice roll."
		)
		(if (and (not global337) (== (global178 type:) 2))
			(proc0_4 30)
		)
	)
)

(class Roll1 of RelPath
	(properties)

	(method (at param1)
		(return [local0 param1])
	)

	(method (doit)
		(if (super doit:)
			(client cel: (+ (client cel:) 1))
		)
	)
)

(class Roll2 of RelPath
	(properties)

	(method (at param1)
		(return [local19 param1])
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

(class DiceCup of TrackingView
	(properties
		x 20
		y 111
		view 300
		loop 5
	)

	(method (init)
		(self stopUpd: ignoreActors: setPri: 11)
		(super init: &rest)
		(self addKeyMouse:)
		(= associatedObj gTheDiceList)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(self stopUpd:)
			(if (== (global178 type:) 2)
				(return 0)
			)
			(if (!= (gTheDiceList numberUsed:) (gTheDiceList size:))
				(gSound play: 905)
				(gChar1 say: (Random 6 8) -32768)
				(return 0)
			)
			(event claimed: 1)
			(proc0_4)
			(gTheDiceList rollDice: gGamePlayScript)
		)
		(event claimed:)
	)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)
)

(class DoubleCube of TrackingView
	(properties
		view 300
		whose 0
		value 1
		present 1
		prevOwn 0
	)

	(method (changeCubeState)
		(if present
			(= present 0)
			(self hide: deleteKeyMouse:)
		else
			(= present 1)
			(self show: addKeyMouse:)
		)
		(proc0_1)
	)

	(method (reset)
		(self
			loop: 6
			posn: 300 109
			whose: 0
			prevOwn: 0
			value: 1
			stopUpd:
			ignoreActors:
			setPri: 11
		)
	)

	(method (init)
		(super init: &rest)
		(self reset:)
		(= present global324)
		(if (not present)
			(self hide:)
		)
		(self addKeyMouse:)
	)

	(method (make &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= global327
			(/
				(*
					(= temp0
						(-
							((= temp1 (global178 otherPlayer:)) count:)
							(global178 count:)
						)
					)
					100
				)
				(temp1 count:)
			)
		)
		(if (or (== loop 12) (not present) (== whose global178))
			(return)
		)
		(= temp2 (>> (+ global329 1) $0001))
		(= temp3 (>> (+ (- 15 ((global178 off:) size:)) 1) $0001))
		(for ((= temp7 1)) (< temp7 6) ((++ temp7))
			(if
				(and
					((= temp6 (global178 at: temp7)) closed:)
					(== (temp6 whose:) (global178 myColor:))
				)
				(++ temp5) ; UNINIT
			)
		)
		(= temp4
			(cond
				((not prevOwn)
					(if (<= global327 25)
						(or
							(and
								(< (global178 count:) 100)
								(== whose 0)
								(or (>= temp0 30) (>= global327 8))
								(== whose temp1)
								(or (>= temp0 37) (>= global327 10))
							)
							(and (!= whose global178) (>= temp0 15))
						)
					)
				)
				((and (<= global327 25) (== whose temp1))
					(or (>= temp0 37) (>= global327 20))
				)
			)
		)
		(if
			(and
				(or
					(and (or global331 global330) temp4)
					(and
						(== (global178 skill:) 2)
						(not global322)
						(or
							global331
							(>= temp3 (>> (+ (- 15 global334) 1) $0001))
						)
						(or (< temp3 temp2) (and temp4 (== temp3 temp2)))
					)
				)
				(or
					(!= (global178 skill:) 2)
					(and
						global322
						(not
							(or
								(and
									(>= (temp1 bigPrime:) 6)
									(or
										(< (global178 bigPrime:) 6)
										(>=
											(- 25 (temp1 endPrime:))
											(global178 endPrime:)
										)
									)
								)
								(and ((global178 bar:) size:) (>= global334 3))
							)
						)
						(or
							(< (global178 count:) 110)
							(>= (global178 bigPrime:) 3)
						)
					)
				)
				(or
					global331
					global330
					(not
						(and
							(== (global178 skill:) 2)
							(not global322)
							(>=
								((global178 whichPoints:) size:)
								(- ((temp1 whichPoints:) size:) 1)
							)
							(== temp3 temp2)
						)
					)
				)
			)
			(self flash:)
			(self accept:)
		)
	)

	(method (moveCube)
		(self
			prevOwn: whose
			posn: 21 (if (== (= whose global178) global303) 84 else 160)
			loop: (+ loop 1)
			value: (* value 2)
		)
		(proc0_1)
	)

	(method (decline)
		(proc0_4)
		(gTheDiceList numberUsed: (gTheDiceList size:))
		(global178 count: 0)
		(= global323 1)
		(gGamePlayScript state: 2 cycles: 1)
	)

	(method (accept &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 [temp10 10] [temp20 10] temp30)
		(if (!= ((= temp2 (global178 otherPlayer:)) type:) 2)
			(gChar1 say: (Random 12 14) 0 441 2)
			(switch
				(Print
					(Format @global550 399 9 (temp2 playerName:)) ; "%s, do you accept the double?"
					81
					(Format @temp10 399 26) ; "Yes"
					1
					81
					(Format @temp20 399 27) ; "No"
					2
					179
					gDoAbsCode
				)
				(1
					(self moveCube:)
					(return 1)
				)
				(2
					(self decline:)
					(return 0)
				)
			)
		else
			(= temp0
				(/
					(* (= temp1 (- (global178 count:) (temp2 count:))) 100)
					(temp2 count:)
				)
			)
			(= temp3 (>> (+ global329 1) $0001))
			(= temp4 (>> (+ (- 15 ((global178 off:) size:)) 1) $0001))
			(= temp6 (= temp7 0))
			(for ((= temp30 1)) (< temp30 6) ((++ temp30))
				(cond
					((not (global178 validMove: temp30))
						(++ temp6)
					)
					(((global178 at: temp30) closed:)
						(++ temp7)
					)
				)
			)
			(for ((= temp30 1)) (< temp30 25) ((++ temp30))
				(if
					(and
						(==
							((= temp8 (temp2 at: temp30)) whose:)
							(global178 myColor:)
						)
						(temp8 blot:)
						(> (temp8 hitProb:) 6)
					)
					(++ temp9) ; UNINIT
				)
			)
			(if
				(and
					(= temp5
						(or
							(and (not global322) (>= temp1 -56) (>= temp0 -15))
							(and global322 (>= temp1 -94) (>= temp0 -25))
						)
					)
					(or
						global322
						(and
							(<= (- temp3 (/ temp3 6)) temp4)
							(or (> temp3 1) (> (temp2 count:) 6))
						)
					)
					(not
						(and
							((global178 otherBar:) size:)
							(>= temp7 3)
							(not temp6)
							temp9 ; UNINIT
						)
					)
				)
				(gChar1 say: (Random 15 17) 0 441 1)
				(self moveCube:)
				(return 1)
			else
				(gChar1 say: (Random 18 20) 0 443 -32768)
				(self decline:)
				(return 0)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 10] [temp10 10])
		(if (and (== (global178 type:) 1) (super handleEvent: event))
			(if (not present)
				(return 0)
			)
			(self stopUpd:)
			(if (!= whose global178)
				(if (!= (gTheDiceList numberUsed:) (gTheDiceList size:))
					(gSound play: 905)
					(gChar1 say: (Random 24 26) -32768)
					(return 0)
				)
			else
				(gSound play: 905)
				(gChar1 say: (Random 21 23) -32768)
				(return 0)
			)
			(if (== loop 12)
				(gSound play: 905)
				(gChar1 say: (Random 27 29) -32768)
				(return 0)
			)
			(event claimed: 1)
			(switch
				(Print
					(Format @global550 399 10 (global178 playerName:)) ; "%s, do you want to Double?"
					81
					(Format @temp0 399 26) ; "Yes"
					1
					81
					(Format @temp10 399 27) ; "No"
					2
					67
					-1
					(if (== global179 2)
						(if (== global178 global303) 160 else 10)
					else
						160
					)
					179
					gDoAbsCode
				)
				(1
					(self accept:)
				)
			)
		)
		(event claimed:)
	)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)

	(method (deleteKeyMouse)
		((KeyMouse objList:) delete: self)
	)
)

(instance point1 of Point
	(properties
		nsTop 104
		nsLeft 256
		nsBottom 188
		nsRight 271
		dir -1
	)
)

(instance point2 of Point
	(properties
		nsTop 104
		nsLeft 240
		nsBottom 188
		nsRight 255
		dir -1
	)
)

(instance point3 of Point
	(properties
		nsTop 104
		nsLeft 224
		nsBottom 188
		nsRight 239
		dir -1
	)
)

(instance point4 of Point
	(properties
		nsTop 104
		nsLeft 208
		nsBottom 188
		nsRight 223
		dir -1
	)
)

(instance point5 of Point
	(properties
		nsTop 104
		nsLeft 192
		nsBottom 188
		nsRight 207
		dir -1
	)
)

(instance point6 of Point
	(properties
		nsTop 104
		nsLeft 176
		nsBottom 188
		nsRight 191
		dir -1
	)
)

(instance point7 of Point
	(properties
		nsTop 104
		nsLeft 143
		nsBottom 188
		nsRight 157
		dir -1
	)
)

(instance point8 of Point
	(properties
		nsTop 104
		nsLeft 127
		nsBottom 188
		nsRight 142
		dir -1
	)
)

(instance point9 of Point
	(properties
		nsTop 104
		nsLeft 111
		nsBottom 188
		nsRight 126
		dir -1
	)
)

(instance point10 of Point
	(properties
		nsTop 104
		nsLeft 95
		nsBottom 188
		nsRight 110
		dir -1
	)
)

(instance point11 of Point
	(properties
		nsTop 104
		nsLeft 79
		nsBottom 188
		nsRight 94
		dir -1
	)
)

(instance point12 of Point
	(properties
		nsTop 104
		nsLeft 63
		nsBottom 188
		nsRight 78
		dir -1
	)
)

(instance point13 of Point
	(properties
		nsTop 5
		nsLeft 63
		nsBottom 89
		nsRight 78
		dir 1
	)
)

(instance point14 of Point
	(properties
		nsTop 5
		nsLeft 79
		nsBottom 89
		nsRight 94
		dir 1
	)
)

(instance point15 of Point
	(properties
		nsTop 5
		nsLeft 95
		nsBottom 89
		nsRight 110
		dir 1
	)
)

(instance point16 of Point
	(properties
		nsTop 5
		nsLeft 111
		nsBottom 89
		nsRight 126
		dir 1
	)
)

(instance point17 of Point
	(properties
		nsTop 5
		nsLeft 127
		nsBottom 89
		nsRight 142
		dir 1
	)
)

(instance point18 of Point
	(properties
		nsTop 5
		nsLeft 143
		nsBottom 89
		nsRight 157
		dir 1
	)
)

(instance point19 of Point
	(properties
		nsTop 5
		nsLeft 176
		nsBottom 89
		nsRight 191
		dir 1
	)
)

(instance point20 of Point
	(properties
		nsTop 5
		nsLeft 192
		nsBottom 89
		nsRight 207
		dir 1
	)
)

(instance point21 of Point
	(properties
		nsTop 5
		nsLeft 208
		nsBottom 89
		nsRight 223
		dir 1
	)
)

(instance point22 of Point
	(properties
		nsTop 5
		nsLeft 224
		nsBottom 89
		nsRight 239
		dir 1
	)
)

(instance point23 of Point
	(properties
		nsTop 5
		nsLeft 240
		nsBottom 89
		nsRight 255
		dir 1
	)
)

(instance point24 of Point
	(properties
		nsTop 5
		nsLeft 256
		nsBottom 89
		nsRight 271
		dir 1
	)
)

