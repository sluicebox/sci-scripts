;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use FwdCount)
(use Goods)
(use n109)
(use DialogScript)
(use n115)
(use Interface)
(use KeyMouse)
(use DCIcon)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	room1 0
	tempList 1
	players 2
	player1 3
	player2 4
	player3 5
	player4 6
	marble 7
	proc1_8 8
	proc1_9 9
)

(local
	local0
)

(procedure (proc1_8)
	(gCalc erase:)
	(proc0_16 (global302 whichBody:))
	(outline init: addToPic:)
	(picPatch init: addToPic:)
	(number1 init: addToPic:)
	(number2 init: addToPic:)
	(number3 init: addToPic:)
	(number4 init: addToPic:)
	(proc0_1)
)

(procedure (proc1_9)
	(if (== global323 60)
		(gASong stop:)
		(gTheWalker posn: 500 500 cel: 0)
		(players doit:)
		(marble setStep: 12 12)
		(= global459 marble)
		(= global460 1)
		(if (== (global302 livesAt:) 0)
			(marble setMotion: MoveTo 144 37 marbleMoved)
		else
			(marble setMotion: MoveTo 29 45 marbleMoved)
		)
	)
)

(instance door of Prop
	(properties
		view 751
		cycleSpeed 1
	)
)

(instance marbleMoved of Script
	(properties)

	(method (cue)
		(= global458 ((ScriptID 101) index:)) ; marblePath
		(= local0 1)
	)
)

(class Place of Obj
	(properties
		placeNum 0
		index 0
		topR 0
		leftR 0
		bottomR 0
		rightR 0
		sNumber 0
		placeX 0
		placeY 0
		doorLoop 0
		doorX 0
		doorY 0
		keyMouseX 0
		keyMouseY 0
		offsetX 0
		offsetY 0
	)

	(method (init)
		(gPlaces add: self)
		(gMainKeyMouseList add: self)
	)

	(method (openDoor)
		(door loop: doorLoop posn: doorX doorY)
		(door setCel: 0 startUpd:)
		(proc0_1)
		(Wait 6)
		(door setCel: 1)
		(proc0_1)
		(Wait 6)
		(door setCel: 2)
		(proc0_1)
		(Wait 6)
		(door setCel: 3)
		(proc0_1)
	)

	(method (closeDoor)
		(door setCel: -1 startUpd: setCycle: Beg)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(User controls:)
				global474
				(or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD))
				(<= leftR (event x:) rightR)
				(<= topR (event y:) bottomR)
				(or (< global323 60) (not global460) (not (marble mover:)))
			)
			(= global433 -2)
			(= global449 (event x:))
			(= global450 (event y:))
			(cond
				((or (marble mover:) (!= global457 placeNum))
					(if (not (marble mover:))
						((ScriptID 101) index: global458) ; marblePath
					)
					(= global459 self)
					(if (and (not global446) (not (gCurRoom script:)))
						(gASoundEffect play: 23)
						(marble
							setMotion:
								(ScriptID 101) ; marblePath
								global457
								placeNum
								marbleMoved
						)
						(= global457 placeNum)
					)
				)
				((and (not global502) (not global446) (not (gCurRoom script:)))
					(gASoundEffect play: 23)
					(self cue:)
				)
			)
			(return 1)
		)
		(return 0)
	)

	(method (cue)
		(= global516 1)
		(if
			(or
				(and (== placeNum 0) (== (global302 livesAt:) 0))
				(and (== placeNum 2) (== (global302 livesAt:) 2))
				(and
					(== placeNum 1)
					(or
						(== (global302 worksAt:) 1)
						(not (mod global372 4))
						(global302 leaveOpen:)
					)
				)
				(and (!= placeNum 0) (!= placeNum 2) (!= placeNum 1))
			)
			(self openDoor:)
		else
			(= global516 0)
		)
		(gTheWalker stopUpd: setCycle: 0)
		(marble setMotion: 0)
		(proc0_1)
		(= gBoughtItem (= global424 0))
		(= global515 (KeyMouse curItem:))
		(User canControl: 0)
		(gTheWalker hide:)
		(proc0_1)
		(Palette palUNSET_FLAG 8 16 1)
		(Palette palUNSET_FLAG 144 255 1)
		(gASong fade:)
		(SetMenu 773 112 0)
		((= global526 (ScriptID sNumber 0)) init: room1)
		(SetMenu 773 112 1)
		(= gItems 0)
		(Palette palUNSET_FLAG 8 16 1)
		(Palette palUNSET_FLAG 144 255 1)
		(proc1_8)
		(if (< global323 60)
			(gTheWalker show:)
		)
		(proc0_1)
		(KeyMouse curItem: global515)
		(if (not global521)
			(switch global446
				(1
					(proc0_13 -3)
					(User canControl: 0)
					(gCurRoom setScript: (ScriptID 114 0) 0 self) ; muggedByMarket
					(= global473 0)
					(= global446 0)
					(return)
				)
				(2
					(proc0_13 -3)
					(User canControl: 0)
					(gCurRoom setScript: (ScriptID 114 1) 0 self) ; muggedByBank
					(= global473 0)
					(= global446 0)
					(return)
				)
			)
		)
		(self endCue:)
	)

	(method (endCue &tmp temp0)
		(= global479 0)
		(if (and global447 (!= (global302 playing:) 29))
			(SetCursor gTheCursor 1 global449 global450)
			(KeyMouse prevCursorX: global449 prevCursorY: global450)
		)
		(= temp0
			(switch (global302 whichBody:)
				(0 280)
				(1 284)
				(2 290)
				(3 294)
			)
		)
		(if (== (global302 playing:) 29)
			(= temp0 274)
		)
		(gTheWalker
			view:
				(if (not (global302 weeksOfClothing:))
					(+ temp0 3)
				else
					(+ temp0 (- (global302 wearing:) 34))
				)
		)
		(gTheWalker forceUpd:)
		(proc0_1)
		(proc1_9)
		(if global516
			(self closeDoor:)
		)
		((global302 consumables:) pack:)
		((global302 durables:) pack:)
		((global302 education:) pack:)
		(if (< global323 60)
			(gASong loop: -1 play: 5)
		)
	)
)

(instance places of EventHandler
	(properties)
)

(instance mainKeyMouseList of Set
	(properties)
)

(instance apartmentsP of Place
	(properties
		index 1
		topR 10
		leftR 130
		bottomR 43
		rightR 190
		sNumber 200
		placeX 134
		placeY 2
		doorX 144
		doorY 30
		keyMouseX 160
		keyMouseY 25
	)
)

(instance rentOfficeP of Place
	(properties
		placeNum 1
		index 164
		topR 10
		leftR 68
		bottomR 43
		rightR 129
		sNumber 201
		placeX 85
		placeY 3
		doorLoop 1
		doorX 105
		doorY 29
		keyMouseX 98
		keyMouseY 25
	)
)

(instance securityP of Place
	(properties
		placeNum 2
		index 151
		topR 10
		leftR 7
		bottomR 43
		rightR 67
		sNumber 202
		placeX 9
		placeY 2
		doorLoop 2
		doorX 29
		doorY 44
		keyMouseX 37
		keyMouseY 25
	)
)

(instance marketP of Place
	(properties
		placeNum 3
		index 134
		topR 69
		leftR 24
		bottomR 114
		rightR 67
		sNumber 203
		placeX 26
		placeY 70
		doorLoop 3
		doorX 46
		doorY 105
		keyMouseX 44
		keyMouseY 89
	)
)

(instance bankP of Place
	(properties
		placeNum 4
		index 120
		topR 119
		leftR 7
		bottomR 154
		rightR 67
		sNumber 204
		placeX 11
		placeY 92
		doorLoop 4
		doorX 20
		doorY 147
		keyMouseX 37
		keyMouseY 139
	)

	(method (init)
		(super init: &rest)
		(if (not global535)
			(= doorX 21)
			(= doorY 146)
		)
	)
)

(instance factoryP of Place
	(properties
		placeNum 5
		index 107
		topR 155
		leftR 7
		bottomR 192
		rightR 67
		sNumber 205
		placeX 25
		placeY 134
		doorLoop 5
		doorX 50
		doorY 181
		keyMouseX 37
		keyMouseY 182
	)
)

(instance employmentP of Place
	(properties
		placeNum 6
		index 99
		topR 168
		leftR 68
		bottomR 192
		rightR 128
		sNumber 206
		placeX 79
		placeY 151
		doorLoop 6
		doorX 97
		doorY 183
		keyMouseX 98
		keyMouseY 182
	)

	(method (init)
		(super init: &rest)
		(if (not global535)
			(= doorY 182)
		)
	)
)

(instance universityP of Place
	(properties
		placeNum 7
		index 75
		topR 158
		leftR 190
		bottomR 192
		rightR 250
		sNumber 207
		placeX 190
		placeY 141
		doorLoop 7
		doorX 220
		doorY 179
		keyMouseX 220
		keyMouseY 182
	)
)

(instance applianceP of Place
	(properties
		placeNum 8
		index 66
		topR 133
		leftR 251
		bottomR 192
		rightR 311
		sNumber 208
		placeX 256
		placeY 133
		doorLoop 8
		doorX 277
		doorY 183
		keyMouseX 281
		keyMouseY 182
	)

	(method (init)
		(super init: &rest)
		(if (not global535)
			(= doorY 184)
		)
	)
)

(instance clothingP of Place
	(properties
		placeNum 9
		index 47
		topR 82
		leftR 251
		bottomR 118
		rightR 311
		sNumber 209
		placeX 257
		placeY 80
		doorLoop 9
		doorX 277
		doorY 113
		keyMouseX 281
		keyMouseY 97
	)
)

(instance fastFoodP of Place
	(properties
		placeNum 10
		index 35
		topR 44
		leftR 251
		bottomR 81
		rightR 311
		sNumber 210
		placeX 264
		placeY 32
		doorLoop 10
		doorX 288
		doorY 75
		keyMouseX 281
		keyMouseY 64
	)

	(method (init)
		(super init: &rest)
		(if (not global535)
			(= doorX 289)
			(= doorY 76)
		)
	)
)

(instance discountP of Place
	(properties
		placeNum 11
		index 24
		topR 10
		leftR 251
		bottomR 43
		rightR 311
		sNumber 211
		placeX 258
		placeY 2
		doorLoop 11
		doorX 282
		doorY 34
		keyMouseX 281
		keyMouseY 25
	)
)

(instance pawnShopP of Place
	(properties
		placeNum 12
		index 14
		topR 10
		leftR 191
		bottomR 43
		rightR 250
		sNumber 212
		placeX 201
		placeY 4
		doorLoop 12
		doorX 221
		doorY 34
		keyMouseX 221
		keyMouseY 25
	)

	(method (init)
		(super init: &rest)
		(if (not global535)
			(= doorY 33)
		)
	)
)

(class I of Obj
	(properties
		shares 0
		basePrice 0
		indexNum 0
	)

	(method (init param1)
		((param1 investments:) add: self)
	)
)

(class Player of Obj
	(properties
		actualName {}
		playing 0
		gender 0
		monGoal 50
		hapGoal 50
		eduGoal 50
		carGoal 50
		monStat 0
		hapStat 0
		eduStat 0
		carStat 0
		monR 0
		hapR 0
		eduR 0
		carR 0
		finishStatus 0
		cash 200
		cashHi 0
		netWorth 200
		netWorthHi 0
		lqAss 200
		lqAssHi 0
		invAss 0
		invAssHi 0
		bankBal 0
		bankBalHi 0
		livesAt 0
		relax 25
		worksAt 0
		jobKey 0
		wage 0
		baseWage 0
		occupation 0
		raisesGiven 0
		uniform 36
		wearing 36
		rentOwed 0
		curRent 325
		rentExt 0
		triedExt 0
		leaveOpen 0
		loanBal 0
		latePayments 0
		paySched 0
		madePayment 0
		enrollments 0
		extraCredits 0
		needEd1 0
		needEd2 0
		consumables 0
		durables 0
		education 0
		dependibility 20
		minDepend 0
		experience 10
		maxExperience 10
		notEnoughEd 0
		investments 0
		tBillS 0
		goldS 0
		silverS 0
		porkS 0
		blueS 0
		pennyS 0
		script 0
		eduCredit 0
		expCredit 0
		jobT -1
		nakedCount 0
		turnedOver 0
		whichBody 0
		whichNumber 0
		playingAsJones 0
		coursesDone 0
	)

	(method (init)
		(if playing
			(self cash: 200 cashHi: 0)
			((= consumables (Consumables new:)) add:)
			((= durables (Durables new:)) add:)
			((= education (Education new:)) add:)
			((= investments (List new:)) add:)
			((= tBillS (I new:)) init: self basePrice: 100 indexNum: 65)
			((= goldS (I new:)) init: self basePrice: 413 indexNum: 66)
			((= silverS (I new:)) init: self basePrice: 14 indexNum: 67)
			((= porkS (I new:)) init: self basePrice: 20 indexNum: 68)
			((= blueS (I new:)) init: self basePrice: 49 indexNum: 69)
			((= pennyS (I new:)) init: self basePrice: 7 indexNum: 70)
			((consumables recieve: 40 3) pricePaid: 325 indexNum: 40)
			((consumables recieve: 36 6) pricePaid: 30 indexNum: 36)
		)
	)

	(method (dressedForWork &tmp [temp0 3] temp3)
		(= [temp0 0] (consumables objectAtIndex: 36))
		(= [temp0 1] (consumables objectAtIndex: 35))
		(= [temp0 2] (consumables objectAtIndex: 34))
		(= temp3 2)
		(= wearing 0)
		(while (>= temp3 0)
			(if (and [temp0 temp3] ([temp0 temp3] quantity:))
				(= wearing ([temp0 temp3] indexNum:))
				(break)
			)
			(-- temp3)
		)
		(if (or (not wearing) (< uniform wearing))
			(return 0)
		)
		(return 1)
	)

	(method (weeksOfClothing &tmp temp0 [temp1 3] temp4)
		(= [temp1 0] (consumables objectAtIndex: 36))
		(= [temp1 1] (consumables objectAtIndex: 35))
		(= [temp1 2] (consumables objectAtIndex: 34))
		(= temp0 0)
		(for ((= temp4 2)) (>= temp4 0) ((-- temp4))
			(if (and [temp1 temp4] (> ([temp1 temp4] quantity:) temp0))
				(= temp0 ([temp1 temp4] quantity:))
			)
		)
		(return temp0)
	)

	(method (doit)
		(if script
			(script doit:)
		)
		(if global448
			(players doit:)
			(if (and (not gQuit) (not global528))
				(gASong stop:)
				(marble setStep: 12 12)
				(= global459 marble)
				(= global460 1)
				(if (== (global302 livesAt:) 0)
					(marble setMotion: MoveTo 144 37 marbleMoved)
				else
					(marble setMotion: MoveTo 29 45 marbleMoved)
				)
			)
		)
	)

	(method (handleEvent event)
		(if script
			(script handleEvent: event)
		)
	)

	(method (startTurn)
		(timeKeep init:)
		(proc0_1)
		(= global457 livesAt)
		(= global473 0)
		((ScriptID 107) doit:) ; economicIndex
		((= script (ScriptID 111)) init: self) ; startTrn
	)

	(method (endTurn &tmp temp0 temp1 temp2 temp3)
		(-= dependibility 3)
		(if (< dependibility 0)
			(= dependibility 0)
		)
		(global302
			carStat:
				(if (global302 wage:)
					(* (/ (global302 dependibility:) 8) 10)
				else
					0
				)
		)
		(if (> (global302 carStat:) 100)
			(global302 carStat: 100)
		)
		(for ((= temp0 0)) (< temp0 (durables size:)) ((++ temp0))
			(if (= temp1 (& ((durables at: temp0) attributes:) $0018))
				(= temp2
					(switch temp1
						(24 16)
						(16 8)
						(8 0)
					)
				)
				((durables at: temp0)
					attributes:
						(| (& ((durables at: temp0) attributes:) $ffe7) temp2)
				)
				(if (not temp2)
					((durables at: temp0)
						attributes: (| ((durables at: temp0) attributes:) $0020)
					)
				)
			)
		)
		(= temp3 (if (== livesAt 0) 40 else 41))
		(if (not (mod global372 4))
			(if loanBal
				(-- paySched)
				(if (not madePayment)
					(++ latePayments)
				)
			)
			(if
				(and
					(consumables objectAtIndex: temp3)
					(not ((consumables objectAtIndex: temp3) quantity:))
					(!= triedExt 1)
					(not turnedOver)
				)
				(= turnedOver 1)
				(+= rentOwed curRent)
			)
			(= leaveOpen (== triedExt 1))
			(= triedExt (= madePayment 0))
		else
			(if
				(and
					(consumables objectAtIndex: temp3)
					(not ((consumables objectAtIndex: temp3) quantity:))
					(!= triedExt 1)
					(not rentOwed)
					(not turnedOver)
				)
				(= turnedOver 1)
				(+= rentOwed curRent)
			)
			(= leaveOpen (== triedExt 1))
			(= triedExt (= madePayment 0))
		)
	)

	(method (doScandal param1)
		(if playing
			(if (== param1 1)
				(= bankBal 0)
			)
			(if (and wage (not (Random 0 (- param1 1))))
				(= wage (= worksAt (= occupation 0)))
				(return 1)
			)
			(if wage
				(= wage (/ (* wage (+ 4 (* param1 2))) 10))
				(if (< wage 1)
					(= wage 1)
				)
				(return -1)
			)
		)
		(return 0)
	)

	(method (calcNetWorth &tmp temp0)
		(self calcLiquidAssets:)
		(for
			((= temp0 (= netWorth (= netWorthHi 0))))
			(< temp0 (durables size:))
			((++ temp0))
			
			(+=
				netWorth
				(*
					((durables at: temp0) pricePaid:)
					((durables at: temp0) quantity:)
				)
			)
		)
		(proc0_12 netWorthHi netWorth lqAssHi lqAss)
		(= netWorth global455)
		(= netWorthHi global454)
	)

	(method (calcLiquidAssets &tmp temp0 temp1 temp2 temp3)
		(= lqAss (= lqAssHi 0))
		(proc115_1 (investments at: 0) ((investments at: 0) basePrice:))
		(= temp2 global454)
		(= temp1 global455)
		(self addLiquid: temp2 temp1)
		(for ((= temp0 1)) (< temp0 (investments size:)) ((++ temp0))
			(proc115_1
				(investments at: temp0)
				(proc109_0
					[global310 (- temp0 1)]
					((investments at: temp0) basePrice:)
				)
			)
			(= temp2 global454)
			(= temp1 global455)
			(self addLiquid: temp2 temp1)
		)
		(= invAss lqAss)
		(= invAssHi lqAssHi)
		(proc0_12 cashHi cash bankBalHi bankBal)
		(self addLiquid: global454 global455)
		(= temp3 (- 0 (+ rentOwed loanBal)))
		(self addLiquid: 0 temp3)
	)

	(method (addLiquid param1 param2)
		(proc0_12 lqAssHi lqAss param1 param2)
		(= lqAss global455)
		(= lqAssHi global454)
	)

	(method (numDegrees &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 (education size:)) ((++ temp0))
			(if
				(>=
					((education at: temp0) quantity:)
					((education at: temp0) unitsToGraduate:)
				)
				(++ temp1)
			)
		)
		(return temp1)
	)

	(method (hasDegree param1 &tmp temp0 temp1)
		(if (not param1)
			(return 1)
		)
		(if (education size:)
			(for ((= temp0 0)) (< temp0 (education size:)) ((++ temp0))
				(if
					(and
						(== ((education at: temp0) indexNum:) param1)
						(>=
							((education at: temp0) quantity:)
							((education at: temp0) unitsToGraduate:)
						)
					)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (courseActive param1 &tmp temp0 temp1)
		(if (education size:)
			(for ((= temp0 0)) (< temp0 (education size:)) ((++ temp0))
				(if
					(and
						(== ((education at: temp0) indexNum:) param1)
						((education at: temp0) quantity:)
						(<
							((education at: temp0) quantity:)
							((education at: temp0) unitsToGraduate:)
						)
					)
					(return 1)
				)
			)
		)
		(return 0)
	)
)

(instance players of List
	(properties)

	(method (init &tmp temp0)
		(for ((= temp0 (- size 1))) (>= temp0 0) ((-- temp0))
			(if (not ((self at: temp0) playing:))
				(self delete: (self at: temp0))
			)
		)
		(for ((= temp0 0)) (<= temp0 (- size 1)) ((++ temp0))
			((players at: temp0) whichNumber: temp0)
			(if (== ((players at: temp0) playing:) 29)
				((players at: temp0) whichNumber: 4)
			)
		)
		(self eachElementDo: #init)
		(= global374 size)
		(= global302 (self at: 0))
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(if global448
			(= global448 0)
			(global302 playing: 3)
		else
			(global302 endTurn:)
		)
		(if (== (players size:) 1)
			(marble
				cel:
					(if (== ((players at: 0) playing:) 29)
						4
					else
						((players at: 0) whichBody:)
					)
			)
		)
		(= temp3 global302)
		(for ((= temp2 0)) (< temp2 size) ((++ temp2))
			(= temp0 (= temp1 (self indexOf: global302)))
			(if (== temp1 (- size 1))
				(= temp0 0)
			else
				(++ temp0)
			)
			(= global302 (self at: temp0))
			(if (!= ((self at: temp0) playing:) 3)
				(if global505
					(= global505 0)
				)
				(if (== temp3 global521)
					(++ global522)
					(if (!= (= temp0 (self indexOf: temp3)) (- size 1))
						(= global523 1)
					)
					(self delete: temp3)
					(= global521 0)
				)
				(return)
			)
		)
		(User canControl: 1)
		(if (Print 1 0 70 150 81 {Restart} 1 81 {Quit} 0 311) ; "Thank You for playing `Jones In The Fast Lane'. Would you like to play another game?"
			(gASoundEffect play: 23)
			(= global528 1)
		else
			(gASoundEffect play: 23)
			(= gQuit 1)
		)
	)
)

(instance player1 of Player
	(properties
		actualName {Player 1}
		playing 1
	)
)

(instance player2 of Player
	(properties
		actualName {Player 2}
	)
)

(instance player3 of Player
	(properties
		actualName {Player 3}
		gender 1
	)
)

(instance player4 of Player
	(properties
		actualName {Player 4}
		gender 1
	)
)

(instance theWalker of Act
	(properties
		y 146
		x 160
		priority 4
		ticksToDo 10
	)

	(method (init)
		(super init:)
		(= gTheWalker self)
		(self setPri: priority)
	)

	(method (show)
		(if (or (== global534 1) (== global534 3))
			(return)
		)
		(super show: &rest)
	)
)

(instance marble of Act
	(properties
		y 37
		x 144
		loop 2
		priority 8
		ticksToDo 1
		moveSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: priority)
	)

	(method (cue &tmp temp0 temp1 temp2 temp3)
		(gASong fade:)
		(= global323 (= global324 (= global460 0)))
		(gTimeKeep doit:)
		(gTheWalker posn: 160 146 setCycle: 0 forceUpd:)
		(if (== (global302 livesAt:) 0)
			((ScriptID 101) x: 144 y: 37 index: 1) ; marblePath
			(= global458 1)
		else
			((ScriptID 101) x: 29 y: 45 index: 151) ; marblePath
			(= global458 151)
		)
		(= global400 (global302 livesAt:))
		(= temp0 (players indexOf: global302))
		(= temp2 0)
		(for ((= temp3 0)) (< temp3 (players size:)) ((++ temp3))
			(cond
				((== (players at: temp3) global302)
					(= temp2 1)
					(break)
				)
				((!= ((players at: temp3) playing:) 3)
					(break)
				)
			)
		)
		(if (and (not global523) temp2)
			(++ global372)
		else
			(= global523 0)
		)
		(marble
			cel:
				(if (== ((players at: temp0) playing:) 29)
					4
				else
					((players at: temp0) whichBody:)
				)
		)
		(= temp1
			(switch (global302 whichBody:)
				(0 280)
				(1 284)
				(2 290)
				(3 294)
			)
		)
		(if (== (global302 playing:) 29)
			(= temp1 274)
			(= temp0 4)
		)
		(gTheWalker
			view:
				(if (not (global302 weeksOfClothing:))
					(+ temp1 3)
				else
					(+ temp1 (- (global302 wearing:) 34))
				)
		)
		(Palette palUNSET_FLAG 8 16 1)
		(Palette palUNSET_FLAG 144 255 1)
		(gTheWalker show:)
		(gTheWalker forceUpd:)
		(proc0_16 (global302 whichBody:))
		(number1 cel: (global302 whichNumber:) addToPic:)
		(number2 cel: (global302 whichNumber:) addToPic:)
		(number3 cel: (global302 whichNumber:) addToPic:)
		(number4 cel: (global302 whichNumber:) addToPic:)
		(proc0_1)
		(Display
			(Format @global100 1 1 global372) ; "Week #%2d"
			dsCOLOR
			0
			dsBACKGROUND
			(if global535 86 else 7)
			dsCOORD
			140
			184
			dsFONT
			10
		)
		(global302 startTurn:)
	)
)

(instance room1 of Rm
	(properties
		picture 11
		style 2
	)

	(method (init &tmp temp0 temp1)
		(if (not global533)
			(super init:)
			(= gDoor door)
			(proc0_2 130 102 101 104 100 107 108 109 967 110 103)
			(Load rsSOUND 23)
			(MenuBar init: state: 1)
			(ScriptID 104) ; WButton
			(= temp0 DCIcon)
			(= temp0 DialogScript)
			(= temp0 FwdCount)
			(= temp0 KeyMouse)
			((= gMainKeyMouseList mainKeyMouseList) add:)
			((= gPlaces places) add:)
			(players add:)
			(tempList add:)
			(= gCalc calc)
			(apartmentsP init:)
			(rentOfficeP init:)
			(securityP init:)
			(marketP init:)
			(bankP init:)
			(factoryP init:)
			(employmentP init:)
			(universityP init:)
			(applianceP init:)
			(clothingP init:)
			(fastFoodP init:)
			(discountP init:)
			(pawnShopP init:)
			(door init: setPri: 6)
			(User canControl: 1)
			(gGame setCursor: 999 1)
			(proc0_1)
			(players add: player1 player2 player3 player4)
			(= global374 0)
			(proc0_2 130 233 239 235 236)
			(proc0_2 128 501 250 10 500 499)
			(Palette palUNSET_FLAG 8 16 1)
			(Palette palUNSET_FLAG 144 255 1)
		)
		(= global533 0)
		((ScriptID 233 0) init:) ; select1
		(if global531
			((ScriptID 239 0) init:) ; select1b
		)
		(if (or global528 gQuit)
			(return)
		)
		(if global374
			(proc0_2 128 499)
			((ScriptID 235 0) init:) ; select2
			(if (or global528 gQuit)
				(return)
			)
			(if (== global374 1)
				((ScriptID 237 0) init:) ; select4
				(if (or global528 gQuit)
					(return)
				)
				(if (== ((players at: 1) playing:) 29)
					((ScriptID 236 0) init: 0 1) ; select3
				)
			)
		)
		(proc0_2 128 0 250 270)
		(proc0_2 130 990 997 987)
		(proc0_2 136 997 999)
		(Lock rsFONT 0 1)
		(Lock rsFONT 1 1)
		(Lock rsFONT 3 1)
		(Lock rsFONT 4 1)
		(Lock rsFONT 10 1)
		(Lock rsFONT 14 1)
		(Lock rsVIEW 0 1)
		(Lock rsVIEW 250 1)
		(Lock rsVIEW 270 1)
		(Lock rsSCRIPT 990 1)
		(Lock rsSCRIPT 997 1)
		(Lock rsSCRIPT 987 1)
		(Lock rsTEXT 115 1)
		(Lock rsTEXT 108 1)
		(Lock rsSCRIPT 115 1)
		(Lock rsSCRIPT 108 1)
		(Lock rsCURSOR 997 1)
		(Lock rsCURSOR 999 1)
		(if (or global527 (== ((players at: 1) playing:) 29))
			(proc0_2 128 274 275 276 277)
			(Lock rsVIEW 274 1)
			(Lock rsVIEW 275 1)
			(Lock rsVIEW 276 1)
			(Lock rsVIEW 277 1)
		)
		(if (or global528 global529 gQuit)
			(return)
		)
		(gASong fade:)
		(players init:)
		(Palette palUNSET_FLAG 8 16 1)
		(Palette palUNSET_FLAG 144 255 1)
		(proc0_16 ((players at: 0) whichBody:))
		(if (== (global302 playing:) 29)
			(number1 cel: 4)
			(number2 cel: 4)
			(number3 cel: 4)
			(number4 cel: 4)
		)
		(number1 setPri: 7 init: addToPic:)
		(number2 setPri: 7 init: addToPic:)
		(number3 setPri: 7 init: addToPic:)
		(number4 setPri: 7 init: addToPic:)
		(proc0_1)
		((= gTimeKeep timeKeep) init:)
		(controls add: calc)
		(proc0_1)
		(KeyMouse setList: gMainKeyMouseList)
		(= global401 -1)
		(marble
			view: 0
			cel:
				(if (== ((players at: 0) playing:) 29)
					4
				else
					((players at: 0) whichBody:)
				)
			init:
		)
		(SetMenu 771 112 1)
		(SetMenu 513 112 1)
		(SetMenu 515 112 1)
		(SetMenu 1025 112 1)
		(SetMenu 1026 112 1)
		(picPatch init: addToPic:)
		(= temp1
			(switch (global302 whichBody:)
				(0 282)
				(1 286)
				(2 292)
				(3 296)
			)
		)
		(if (== (global302 playing:) 29)
			(= temp1 276)
		)
		(theWalker view: temp1 init: stopUpd:)
		(if (or (== global534 1) (== global534 3))
			(theWalker hide:)
		)
		(proc0_1)
		(global302 startTurn:)
		(= global475 (* (marble moveSpeed:) 14))
		(Display
			(Format @global100 1 1 global372) ; "Week #%2d"
			dsCOLOR
			0
			dsBACKGROUND
			(if global535 86 else 7)
			dsCOORD
			140
			184
			dsFONT
			10
		)
		(if (== (players size:) 1)
			(SetMenu 771 112 0)
		)
		(UnLoad 132 6)
		(= global439 1)
	)

	(method (handleEvent event)
		(if global533
			(return global533)
		)
		(if controls
			(controls handleEvent: event)
		)
		(if script
			(script handleEvent: event)
		)
		(global302 handleEvent: event)
		(if (and (== (event type:) $0040) (<= JOY_UP (event message:) JOY_UPLEFT)) ; direction
			(KeyMouse handleEvent: event)
		)
		(if (not (event claimed:))
			(event localize: global80)
			(if (places firstTrue: #handleEvent event)
				(return -1)
			)
		)
		(return 0)
	)

	(method (doit)
		(if (not global439)
			(return)
		)
		(if global479
			(global479 endCue:)
		)
		(if local0
			(= local0 0)
			(DisposeScript 101)
			(global459 cue:)
		)
		(cond
			((marble mover:)
				(gTimeKeep doit:)
			)
			((and (== (global302 playing:) 29) global473)
				(if (== global401 -1)
					(= global400 (if (== (global302 livesAt:) 0) 0 else 2))
					(= global401 ((ScriptID 300) doit: global302)) ; WhereShouldIGo
				)
				((ScriptID 101) index: global458) ; marblePath
				(= global459 (gPlaces at: global401))
				(cond
					(
						(and
							(not global446)
							(== global400 global401)
							(not (gCurRoom script:))
						)
						(marble
							setMotion:
								(ScriptID 101) ; marblePath
								global457
								global401
								marbleMoved
						)
					)
					((and (not global446) (not (gCurRoom script:)))
						(marble
							setMotion:
								(ScriptID 101) ; marblePath
								global457
								global401
								marbleMoved
						)
					)
				)
				(= global457 global401)
			)
		)
		(User canControl: 1)
		(players eachElementDo: #doit)
		(super doit:)
	)
)

(instance calc of DIcon
	(properties
		state 64
		nsTop 160
		nsLeft 252
		loop 4
	)

	(method (draw)
		(super draw:)
		(self doit:)
	)

	(method (doit &tmp [temp0 7] temp7)
		(if (or (!= value (global302 cash:)) (!= global456 (global302 cashHi:)))
			(= temp7 (GetPort))
			(SetPort 0)
			(= value (global302 cash:))
			(= global456 (global302 cashHi:))
			(Display
				(Format @temp0 1 2 (proc115_0 global456 value)) ; "%6s"
				dsCOORD
				(+ nsLeft 22)
				(+ nsTop 6)
				dsCOLOR
				0
				dsBACKGROUND
				(cond
					(global535 101)
					(global552 15)
					(else 7)
				)
				dsFONT
				14
			)
			(SetPort temp7)
		)
		(global302 calcNetWorth:)
	)
)

(instance tempList of List
	(properties)
)

(instance timeKeep of View
	(properties
		y 180
		x 159
		view 270
		priority 10
	)

	(method (init &tmp temp0)
		(self setLoop: 0 setCel: 0 setPri: priority posn: x y)
		(super init:)
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(= temp2 (GetPort))
		(SetPort 0)
		(= temp1 0)
		(cond
			(argc
				(if param1
					(+= global323 param1)
					(= temp1 1)
				)
			)
			((> (++ global324) global475)
				(++ global323)
				(= global324 0)
				(= temp1 1)
			)
		)
		(if (> global323 60)
			(= global323 60)
		)
		(if (and (not global478) (== global323 60))
			(= global478 1)
			(gASong stop:)
			(gASoundEffect play: 29)
		)
		(if temp1
			(= cel (mod global323 10))
			(= loop (/ global323 10))
			(DrawCel
				view
				loop
				cel
				(- x (/ (CelWide view loop cel) 2))
				(+ (- y (CelHigh view loop cel)) 1)
				priority
			)
			(if (and (== global323 60) (not global460) (marble mover:))
				(proc1_9)
			)
		)
		(SetPort temp2)
	)
)

(instance number1 of View
	(properties
		y 67
		x 80
		loop 3
	)
)

(instance number2 of View
	(properties
		y 67
		x 238
		loop 3
	)
)

(instance number3 of View
	(properties
		y 155
		x 80
		loop 3
	)
)

(instance number4 of View
	(properties
		y 155
		x 238
		loop 3
	)
)

(instance picPatch of View
	(properties
		y 155
		x 159
		loop 1
		priority 9
	)
)

(instance outline of View
	(properties
		y 155
		x 159
		cel 4
		priority 8
	)
)

