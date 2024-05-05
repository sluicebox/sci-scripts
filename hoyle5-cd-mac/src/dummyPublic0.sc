;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1303)
(include sci.sh)
(use Main)
(use KeyMouse)
(use TrackingView)
(use Str)
(use Print)
(use RandCycle)
(use Path)
(use Motion)
(use Actor)
(use System)

(public
	dummyPublic0 0
	proc1303_1 1
	proc1303_2 2
	proc1303_3 3
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
	[local0 5] = [145 215 285 360 430]
	[local5 5] = [180 250 395 465 180]
	local10
	local11
)

(procedure (proc1303_2 &tmp [temp0 52]) ; UNUSED
	(RedrawCast)
	(if (and (== (global800 type:) 0) (!= global876 2)) 1)
	(gSong fade:)
)

(procedure (proc1303_3 &tmp [temp0 2])
	(if global773
		(gTheDiceList eachElementDo: #dim eachElementDo: #pickup 0)
	)
	(= global773 0)
	(= global786 global765)
	(gTheDoubleCube reset:)
	(global753 moveAllToBar:)
	(global754 moveAllToBar:)
	(global753 setupPlayer:)
	(global754 setupPlayer:)
	(RedrawCast)
	(= global755 0)
	(= global769 0)
	(= global775 1)
)

(procedure (proc1303_1)
	(switch
		(Print
			addText: {____________________Backgammon}
			addButton: { Play Game } 1
			addButton: { Setup Board } 2
			init:
		)
		(1
			(if global788
				(switch
					(Print
						addText: {Show generated moves?}
						addButton: { No } 1
						addButton: { Yes } 2
					)
					(1
						(= global790 0)
					)
					(2
						(= global790 1)
					)
				)
			)
		)
		(2
			(= global787 1)
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
			(if (Random 0 1) 1 else 1)
		else
			1
			(gSound play: 808)
		)
		(if (>= (= temp0 (self indexOf: global189)) 0)
			(global189 signal: (| (global189 signal:) $0001))
		)
		(if global189
			(global189 moveSpeed: global898 xStep: 38 yStep: 14)
			(global189 setPri: global291)
			(= global189 0)
		)
		(if (or (== (global800 type:) 0) global787)
			(EnableCursor)
		)
		(gGamePlayScript cycles: 1)
	)

	(method (getAssocPt param1 param2 &tmp temp0 temp1 temp2)
		(if (gAssocPoint size:)
			(gAssocPoint release:)
		)
		(for ((= temp2 0)) (< temp2 size) ((++ temp2))
			(if (!= param2 (= temp0 (self at: temp2)))
				(gAssocPoint add: temp0)
			)
		)
	)

	(method (moveToPoint &tmp temp0)
		((= global189 (KList 8 (self last:))) movePos: self (- size 1)) ; NodeValue
		(= global291 (global189 priority:))
		(global189 setPri: 500)
		(global189 fixPriority: 1)
		(if (!= global755 1)
			(= temp0 (* global776 384))
			(if global776
				(global189 setMotion: MoveTo global756 global757 self)
			else
				(global189
					xStep: (* (global189 xStep:) 2)
					yStep: (* (global189 yStep:) 2)
					setMotion: MoveTo global756 global757 self
				)
			)
		else
			(global189
				xStep: (* (global189 xStep:) 2)
				yStep: (* (global189 yStep:) 2)
				setMotion: MoveTo global756 global757 self
			)
		)
		(if global755
			(-- global755)
		)
	)

	(method (adjustPoint &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			((= temp1 (self at: temp0)) movePos: self temp0)
			(temp1 x: global756 y: global757)
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
						(<= nsLeft (temp0 x:) nsRight)
						(<= nsTop (temp0 y:) nsBottom)
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

	(method (add)
		(super add: &rest)
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
			moveSpeed: global898
			cycleSpeed: global898
			setCycle: RandCycle
		)
	)

	(method (throw &tmp temp0)
		(if (== self gTheDice1)
			(= local11 0)
			(= temp0 [local0 (Random 0 4)])
		else
			(= temp0 [local5 (Random 0 4)])
		)
		(self
			view: 1301
			moveSpeed: global898
			cycleSpeed: global898
			setPri: 200
			fixPriority: 1
			setLoop: 0
			cel: 0
			rolling: -1
			posn:
				(-
					(+
						(Random startLeft startRight)
						(if (== global800 global753) 224 else 0)
					)
				)
				(Random startTop startBottom)
			ignoreControl:
			setCycle: Fwd
			setMotion: MoveTo temp0 (Random 220 250) self
		)
	)

	(method (cue)
		(if (< local11 2)
			(++ local11)
		)
		(self stopRoll:)
		(if (== local11 2)
			(if (== (global800 type:) 0)
				(EnableCursor)
			)
			(gSound flags: 1)
			(= local11 0)
			(local10 cue:)
		)
	)

	(method (init)
		(self
			view: 1302
			ignoreActors:
			ignoreHorizon:
			ignoreControl:
			setStep: 100 100
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
		(self view: 1302 setLoop: (+ 12 (mod loop 2)) cel: (- pipValue 1))
	)

	(method (pickup)
		(self moveDie:)
	)

	(method (stopRoll)
		(if (!= (self view:) 1302)
			(self
				view: 1302
				cel: 0
				setLoop: (- (* (self pipValue:) 2) (+ (self loop:) 1))
			)
		)
		(self setPri: 12 setCycle: 0)
	)

	(method (moveDie)
		(if (or (== self gTheDice1) (== self gTheDice2))
			(if (== global782 global800)
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

	(method (actualRoll param1 &tmp temp0)
		(= temp0 (Str new:))
		(= numberUsed 0)
		(if doubles
			(self delete: gTheDice3 gTheDice4)
		)
		(if (and (== (KList 8 (self first:)) gTheDice2) (not global789)) ; NodeValue
			(self delete: gTheDice2 add: gTheDice2)
		)
		(if (not global789)
			(self eachElementDo: #clearDie)
			(if (not argc)
				(self eachElementDo: #rollDie)
			else
				(gTheDice1 pipValue: [param1 0])
				(gTheDice2 pipValue: [param1 0])
			)
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
		(DisableCursor)
		(if (not global789)
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
		(= local10 param1)
		(gSound play: 810 setLoop: 1 flags: 0)
		(for ((= temp1 0)) (< temp1 2) ((++ temp1))
			((gTheDiceList at: temp1) throw:)
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
		(RedrawCast)
		(DisableCursor)
		(repeat
			(self actualRoll:)
			(if (or (not doubles) global788)
				(break)
			)
		)
		(self eachElementDo: #reset)
		(if (and doubles global788)
			(self add: gTheDice3 gTheDice4)
			(gTheDice3 clearDie: pipValue: (gTheDice1 pipValue:))
			(gTheDice4 clearDie: pipValue: (gTheDice1 pipValue:))
			(switch
				(Print
					addText: {Current Player :}
					addButton: {Player 1} 1
					addButton: {Player 2} 2
					init:
				)
				(1
					(= global800 global753)
				)
				(2
					(= global800 global754)
				)
			)
		)
		(if (not doubles)
			(= global800
				(if (> (gTheDice1 pipValue:) (gTheDice2 pipValue:))
					global753
				else
					global754
				)
			)
		)
		(if (not global787)
			(= temp0 90)
			(gSound play: 809 setLoop: -1)
			(while (-- temp0)
				(= gGameTime (+ gTickOffset (GetTime)))
				(proc0_9 (self elements:) 1)
				(Random 1 6)
			)
			(gSound setLoop: 1 stop:)
		)
		(self sortDice:)
		(gTheDice1 moveDie:)
		(gTheDice2 moveDie:)
		(self eachElementDo: #setPip 1 eachElementDo: #stopRoll)
		(RedrawCast)
		(gTheArrow init:)
		(if (!= global876 2)
			(cond
				((== (global800 type:) 1)
					(if gAttitudeSetting
						(gChar1
							sayReg:
								1300
								(+ (gChar1 view:) 1)
								88
								0
								(Random 1 2)
								0
								0
						)
					else
						(= global920 1)
						(gChar1 say: 1300 1 88 0 2 0 0)
					)
				)
				(gAttitudeSetting
					(gChar1
						sayReg:
							1300
							(+ (gChar1 view:) 1)
							89
							0
							(Random 1 2)
							0
							0
					)
				)
				(else
					(= global920 1)
					(gChar1 say: 1300 1 89 0 2 0 0)
				)
			)
		else
			(Printf {%s wins the dice roll.} (global800 playerName:))
		)
		(if (and (not global787) (== (global800 type:) 1))
			(DisableCursor)
		else
			(EnableCursor)
		)
	)
)

(class Roll1 of RelPath
	(properties)

	(method (at param1)
		(return [local0 param1])
	)

	(method (doit)
		(client cel: (+ (client cel:) 1))
		(super doit:)
	)
)

(class Roll2 of RelPath
	(properties)

	(method (at param1)
		(return [local5 param1])
	)

	(method (doit)
		(if (self atEnd:)
			(if (!= (client view:) 1302)
				(client
					view: 1302
					cel: 0
					setLoop: (- (* (client pipValue:) 2) (+ (client loop:) 1))
				)
			)
			(client cel: (+ (client cel:) 1))
			(if (> (client cel:) (client lastCel:))
				(client cel: (client lastCel:))
			)
		)
		(super doit:)
	)
)

(class DiceCup of TrackingView
	(properties
		x 85
		y 266
		view 1300
		loop 5
	)

	(method (init)
		(self ignoreActors: setPri: 11)
		(super init: &rest)
		(self addKeyMouse:)
		(= associatedObj gTheDiceList)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(if (== (global800 type:) 1)
				(return 0)
			)
			(if (!= (gTheDiceList numberUsed:) (gTheDiceList size:))
				(proc0_12 905)
				(return 0)
			)
			(event claimed: 1)
			(DisableCursor)
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
		view 1300
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
		(RedrawCast)
	)

	(method (reset)
		(self
			loop: 6
			nsLeft: 520
			nsRight: 580
			nsTop: 190
			nsBottom: 250
			posn: 560 230
			whose: 0
			prevOwn: 0
			value: 1
			ignoreActors:
			setPri: 11
		)
	)

	(method (init)
		(super init: &rest)
		(self reset:)
		(= present global774)
		(if (not present)
			(self hide:)
		)
		(self addKeyMouse:)
	)

	(method (make &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= global777
			(/
				(*
					(= temp0
						(-
							((= temp1 (global800 otherPlayer:)) count:)
							(global800 count:)
						)
					)
					100
				)
				(temp1 count:)
			)
		)
		(if (or (== loop 12) (not present) (== whose global800))
			(return)
		)
		(= temp2 (>> (+ global779 1) $0001))
		(= temp3 (>> (+ (- 15 ((global800 off:) size:)) 1) $0001))
		(for ((= temp7 1)) (< temp7 6) ((++ temp7))
			(if
				(and
					((= temp6 (global800 at: temp7)) closed:)
					(== (temp6 whose:) (global800 myColor:))
				)
				(++ temp5) ; UNINIT
			)
		)
		(= temp4
			(cond
				((not prevOwn)
					(if (<= global777 25)
						(or
							(and
								(< (global800 count:) 100)
								(== whose 0)
								(or (>= temp0 30) (>= global777 8))
								(== whose temp1)
								(or (>= temp0 37) (>= global777 10))
							)
							(and (!= whose global800) (>= temp0 15))
						)
					)
				)
				((and (<= global777 25) (== whose temp1))
					(or (>= temp0 37) (>= global777 20))
				)
			)
		)
		(if
			(and
				(or
					(and (or global781 global780) temp4)
					(and
						(== (global800 skill:) 2)
						(not global772)
						(or
							global781
							(>= temp3 (>> (+ (- 15 global784) 1) $0001))
						)
						(or (< temp3 temp2) (and temp4 (== temp3 temp2)))
					)
				)
				(or
					(!= (global800 skill:) 2)
					(and
						global772
						(not
							(or
								(and
									(>= (temp1 bigPrime:) 6)
									(or
										(< (global800 bigPrime:) 6)
										(>=
											(- 25 (temp1 endPrime:))
											(global800 endPrime:)
										)
									)
								)
								(and ((global800 bar:) size:) (>= global784 3))
							)
						)
						(or
							(< (global800 count:) 110)
							(>= (global800 bigPrime:) 3)
						)
					)
				)
				(or
					global781
					global780
					(not
						(and
							(== (global800 skill:) 2)
							(not global772)
							(>=
								((global800 whichPoints:) size:)
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
			posn: 82 (if (== (= whose global800) global753) 191 else 384)
			nsLeft: 62
			nsRight: 102
			nsTop: (if (== (= whose global800) global753) 151 else 344)
			nsBottom: (if (== (= whose global800) global753) 191 else 384)
			loop: (+ loop 1)
			value: (* value 2)
		)
		(RedrawCast)
	)

	(method (decline)
		(gTheDiceList numberUsed: (gTheDiceList size:))
		(global800 count: 0)
		(= global773 1)
		(gGamePlayScript state: 2 cycles: 1)
	)

	(method (accept &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 [temp10 20] temp30)
		(if (!= ((= temp2 (global800 otherPlayer:)) type:) 1)
			(gChar1
				sayReg: 1300 (+ (gChar1 view:) 1) 90 0 (Random 1 2) 0 0
			)
			(= global748 0)
			((ScriptID 930 0) init: 1372) ; yesNo
			(DisposeScript 930)
			(if global748
				(self moveCube:)
				(return 1)
			else
				(self decline:)
				(return 0)
			)
		else
			(= temp0
				(/
					(* (= temp1 (- (global800 count:) (temp2 count:))) 100)
					(temp2 count:)
				)
			)
			(= temp3 (>> (+ global779 1) $0001))
			(= temp4 (>> (+ (- 15 ((global800 off:) size:)) 1) $0001))
			(= temp6 (= temp7 0))
			(for ((= temp30 1)) (< temp30 6) ((++ temp30))
				(cond
					((not (global800 validMove: temp30))
						(++ temp6)
					)
					(((global800 at: temp30) closed:)
						(++ temp7)
					)
				)
			)
			(for ((= temp30 1)) (< temp30 25) ((++ temp30))
				(if
					(and
						(==
							((= temp8 (temp2 at: temp30)) whose:)
							(global800 myColor:)
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
							(and (not global772) (>= temp1 -56) (>= temp0 -15))
							(and global772 (>= temp1 -94) (>= temp0 -25))
						)
					)
					(or
						global772
						(and
							(<= (- temp3 (/ temp3 6)) temp4)
							(or (> temp3 1) (> (temp2 count:) 6))
						)
					)
					(not
						(and
							((global800 otherBar:) size:)
							(>= temp7 3)
							(not temp6)
							temp9 ; UNINIT
						)
					)
				)
				(gChar1
					sayReg: 1300 (+ (gChar1 view:) 1) 91 0 (Random 1 2) 0 0
				)
				(self moveCube:)
				(return 1)
			else
				(gChar1
					sayReg: 1300 (+ (gChar1 view:) 1) 92 0 (Random 1 2) 0 0
				)
				(self decline:)
				(return 0)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 20])
		(if (and (== (global800 type:) 0) (super handleEvent: event))
			(if (not present)
				(return 0)
			)
			(if (!= whose global800)
				(if (!= (gTheDiceList numberUsed:) (gTheDiceList size:))
					(proc0_12 905)
					(if (== gAttitudeSetting 0)
						(= global920 1)
						(gChar1 say: 1300 15 164 0 2)
					else
						(= global920 1)
						(gChar1 sayReg: 1300 15 164 0 (Random 1 2))
					)
					(return 0)
				)
			else
				(proc0_12 905)
				(if (== gAttitudeSetting 0)
					(= global920 1)
					(gChar1 say: 1300 15 165 0 2)
				else
					(= global920 1)
					(gChar1 sayReg: 1300 15 165 0 (Random 1 2))
				)
				(return 0)
			)
			(if (== loop 12)
				(proc0_12 905)
				(if (== gAttitudeSetting 0)
					(= global920 1)
					(gChar1 say: 1300 15 160 0 2)
				else
					(= global920 1)
					(gChar1 sayReg: 1300 15 160 0 (Random 1 2))
				)
				(return 0)
			)
			(event claimed: 1)
			(= global748 0)
			((ScriptID 930 0) init: 1371) ; yesNo
			(DisposeScript 930)
			(if global748
				(if (== global800 global753) 160 else 10)
				(self accept:)
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
		nsTop 230
		nsLeft 500
		nsBottom 425
		nsRight 530
		dir -1
	)
)

(instance point2 of Point
	(properties
		nsTop 230
		nsLeft 468
		nsBottom 425
		nsRight 498
		dir -1
	)
)

(instance point3 of Point
	(properties
		nsTop 230
		nsLeft 436
		nsBottom 425
		nsRight 466
		dir -1
	)
)

(instance point4 of Point
	(properties
		nsTop 230
		nsLeft 404
		nsBottom 425
		nsRight 434
		dir -1
	)
)

(instance point5 of Point
	(properties
		nsTop 230
		nsLeft 372
		nsBottom 425
		nsRight 402
		dir -1
	)
)

(instance point6 of Point
	(properties
		nsTop 230
		nsLeft 340
		nsBottom 425
		nsRight 370
		dir -1
	)
)

(instance point7 of Point
	(properties
		nsTop 230
		nsLeft 286
		nsBottom 425
		nsRight 314
		dir -1
	)
)

(instance point8 of Point
	(properties
		nsTop 230
		nsLeft 254
		nsBottom 425
		nsRight 284
		dir -1
	)
)

(instance point9 of Point
	(properties
		nsTop 230
		nsLeft 222
		nsBottom 425
		nsRight 252
		dir -1
	)
)

(instance point10 of Point
	(properties
		nsTop 230
		nsLeft 190
		nsBottom 425
		nsRight 220
		dir -1
	)
)

(instance point11 of Point
	(properties
		nsTop 230
		nsLeft 158
		nsBottom 425
		nsRight 188
		dir -1
	)
)

(instance point12 of Point
	(properties
		nsTop 230
		nsLeft 126
		nsBottom 425
		nsRight 156
		dir -1
	)
)

(instance point13 of Point
	(properties
		nsTop 2
		nsLeft 126
		nsBottom 200
		nsRight 156
		dir 1
	)
)

(instance point14 of Point
	(properties
		nsTop 2
		nsLeft 158
		nsBottom 200
		nsRight 188
		dir 1
	)
)

(instance point15 of Point
	(properties
		nsTop 2
		nsLeft 190
		nsBottom 200
		nsRight 220
		dir 1
	)
)

(instance point16 of Point
	(properties
		nsTop 2
		nsLeft 222
		nsBottom 200
		nsRight 252
		dir 1
	)
)

(instance point17 of Point
	(properties
		nsTop 2
		nsLeft 254
		nsBottom 200
		nsRight 284
		dir 1
	)
)

(instance point18 of Point
	(properties
		nsTop 2
		nsLeft 286
		nsBottom 200
		nsRight 314
		dir 1
	)
)

(instance point19 of Point
	(properties
		nsTop 2
		nsLeft 340
		nsBottom 200
		nsRight 370
		dir 1
	)
)

(instance point20 of Point
	(properties
		nsTop 2
		nsLeft 372
		nsBottom 200
		nsRight 402
		dir 1
	)
)

(instance point21 of Point
	(properties
		nsTop 2
		nsLeft 404
		nsBottom 200
		nsRight 434
		dir 1
	)
)

(instance point22 of Point
	(properties
		nsTop 2
		nsLeft 436
		nsBottom 200
		nsRight 466
		dir 1
	)
)

(instance point23 of Point
	(properties
		nsTop 2
		nsLeft 468
		nsBottom 200
		nsRight 498
		dir 1
	)
)

(instance point24 of Point
	(properties
		nsTop 2
		nsLeft 500
		nsBottom 200
		nsRight 530
		dir 1
	)
)

