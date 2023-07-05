;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5302)
(include sci.sh)
(use Main)
(use ExitButton)
(use rm5300)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Motion)
(use System)

(public
	keepSalesmanBusy 0
	knockOnTownHallDoor 1
	firstDoorKnock 2
	getWoodenNickel 3
	enterFauxShop 4
	exitToGate 5
	enterChinaShop 6
	tryToGetMoon 7
	genericEnterScript 8
	moveEgoIntoPosition 9
	firstAttemptToGetBird 10
	secondAttemptToGetBird 11
	takeBird 12
	giveStatue 13
	escortedOutOfTownHall 14
	readFauxDoorSign 15
	enterTownHall 16
	dukeStopsVal 17
	egoBackOff 18
	fromAssembly 19
	removeValsMask 20
	putOnMask 21
	chickenTimerScript 22
	switchMusic 23
	talkToDuke 24
	sayHmmm 25
	putChickenOnTree 26
	getChickenDown 27
	replaceTheMoon 28
	getFeather 29
	tryAndThrowMoonUp 30
	showTownHallSign 31
	openTownHallDoor 32
	snakeDoVerbElse 33
	snakeDoVerbDo 34
	snakeDoVerbComb 35
	haveSalesmanPoint 36
)

(local
	local0
	local1
)

(instance keepSalesmanBusy of Script
	(properties)

	(method (doit)
		(if (and seconds (or register next))
			(= seconds 0)
			(= cycles 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= state 1)
				((ScriptID 5300 59) ; snakeSalesman
					view: 5325
					setLoop: 5
					cel: 7
					posn: 497 129
					setPri: 95
					setCycle: Beg self
				)
			)
			(1
				(= seconds (Random 2 5))
			)
			(2
				(if (and (not next) (not register))
					(if (Random 0 1)
						(self changeState: 8)
					else
						(self changeState: 4)
					)
				else
					((ScriptID 5300 59) ; snakeSalesman
						setLoop: 5
						setPri: 95
						posn: 497 129
						setCycle: End self
					)
				)
			)
			(3
				(= register 0)
				(if next
					(next caller: caller)
					(= caller 0)
				)
				(self dispose:)
			)
			(4
				((ScriptID 5300 59) ; snakeSalesman
					setLoop: 4
					cel: 0
					setPri: 92
					posn: 529 95
					setCycle: CT 6 1 self
				)
			)
			(5
				(if (and (not register) (Random 0 1))
					(-- state)
					((ScriptID 5300 59) setCycle: ROsc 1 6 14 self) ; snakeSalesman
				else
					(= cycles 1)
				)
			)
			(6
				((ScriptID 5300 59) setCycle: CT 18 1 self) ; snakeSalesman
			)
			(7
				(= state 0)
				((ScriptID 5300 59) ; snakeSalesman
					setLoop: 5
					cel: 3
					setPri: 95
					posn: 497 129
					setCycle: End self
				)
			)
			(8
				((ScriptID 5300 59) ; snakeSalesman
					setLoop: 3
					cel: 0
					setPri: 92
					posn: 496 129
					setCycle: End self
				)
			)
			(9
				(= seconds 3)
			)
			(10
				((ScriptID 5300 59) setCycle: Beg self) ; snakeSalesman
			)
			(11
				(= state 0)
				((ScriptID 5300 59) ; snakeSalesman
					setLoop: 5
					setPri: 95
					posn: 497 129
					cel: 3
					setCycle: End self
				)
			)
		)
	)
)

(instance knockOnTownHallDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 5305)
				(Load rsVIEW 5306)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 5306
					loop: 0
					cel: 0
					posn: 231 104
					setScale: 0
					setCycle: CT 2 1 self
				)
				(gKqSound1 number: 808 loop: 1 play:)
			)
			(2
				(gKqSound1 number: 808 loop: 1 play:)
				(gEgo setCycle: CT 4 1 self)
			)
			(3
				(gKqSound1 number: 801 setLoop: 1 play:)
				((ScriptID 5300 6) setCycle: CT 4 1 self) ; townHallDoor
			)
			(4
				(if (not (IsFlag 421))
					(gEgo
						view: 5306
						setLoop: 3
						cel: 0
						posn: 236 100
						setCycle: End
					)
				else
					(gEgo normalize: 7 setScaler: Scaler 83 53 98 78)
				)
				((ScriptID 5300 19) ; badger
					view: 5306
					setLoop: 2
					cel: 0
					posn: 226 97
					setPri: 86
					init:
					setCycle: End self
				)
			)
			(5
				(cond
					((not (SetFlag 421))
						(self setScript: (ScriptID 5302 2) self) ; firstDoorKnock
					)
					((not (SetFlag 420))
						(gMessager say: 3 8 9 0 self) ; "(TRYING TO BE PATIENT)Sir, I'm not trying to interrupt the party. All I want is--"
					)
					(else
						(gMessager say: 3 8 10 0 self) ; "GO AWAY! No mask, no party!"
					)
				)
			)
			(6
				((ScriptID 5300 19) ; badger
					view: 5305
					setLoop: 3
					posn: 217 93
					cel: 0
					setCycle: End self
				)
			)
			(7
				((ScriptID 5300 19) dispose:) ; badger
				((ScriptID 5300 6) setCycle: Beg self) ; townHallDoor
			)
			(8
				(gKqSound1 number: 802 setLoop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance firstDoorKnock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 8 8 1 self) ; "(BELLIGERANT)What do you want?"
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo
					normalize: 7
					posn:
						((ScriptID 5300 6) approachX:) ; townHallDoor
						((ScriptID 5300 6) approachY:) ; townHallDoor
					setScaler: Scaler 83 53 98 78
				)
				(UpdateScreenItem gEgo)
				(FrameOut)
				(= cycles 2)
			)
			(3
				(gMessager sayRange: 3 8 8 2 3 self) ; "Well, I'm trying to find my daughter Rosella, and--"
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance getWoodenNickel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 5317
					loop: 0
					cel: 0
					x: 371
					y: 89
					setScale: 0
					cycleSpeed: 6
					setPri: 108
					setCycle: End self
				)
			)
			(1
				(gEgo
					loop: 1
					cel: 0
					posn: 372 82
					setPri: 150
					setCycle: CT 6 1 self
				)
			)
			(2
				((ScriptID 5300 26) dispose:) ; nickel
				(gEgo get: 44) ; Wooden_Nickel
				(gEgo setCycle: End self)
			)
			(3
				(gEgo setCycle: CT 7 -1 self)
			)
			(4
				(gEgo
					loop: 0
					cel: 15
					x: 371
					y: 89
					setPri: -1
					setCycle: Beg self
				)
			)
			(5
				(gEgo
					normalize: 5
					posn:
						((ScriptID 5300 26) approachX:) ; nickel
						((ScriptID 5300 26) approachY:) ; nickel
					setScaler: Scaler 83 53 98 78
					setHeading: 180 self
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFauxShop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= gValOrRoz -3) ; Roz
					(gEgo view: 8121 loop: 0 cel: 0 setCycle: CT 2 1 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gKqSound1 number: 801 loop: 1 play:)
				((ScriptID 5300 10) setCycle: End self) ; fauxDoor
				(if (!= gValOrRoz -3) ; Roz
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2 0)
			(3
				(gEgo normalize: 0 setMotion: MoveTo 450 69 self)
			)
			(4
				(gCurRoom newRoom: 5000)
			)
		)
	)
)

(instance exitToGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqSound1 number: 801 loop: 1 play:)
				((ScriptID 5300 53) setCycle: End self) ; littleDoor
			)
			(1
				(gEgo setMotion: MoveTo 27 113 self)
			)
			(2
				(gEgo setHeading: 315 self)
			)
			(3
				(if (== gValOrRoz -4) ; Val
					(gEgo
						view: 8065
						loop: 1
						cel: 0
						priority: 109
						fixPriority: 1
						setCycle: CT 4 1 self
					)
				else
					(= cycles 1)
				)
			)
			(4
				(gCurRoom newRoom: 5400)
			)
		)
	)
)

(instance enterChinaShop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= gValOrRoz -3) ; Roz
					(gEgo
						view: 8123
						setLoop: 1 1
						cel: 0
						setCycle: CT 14 1 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(gKqSound1 number: 801 setLoop: 1 play:)
				((ScriptID 5300 12) setCycle: End self) ; chinaDoor
			)
			(2
				(gCurRoom newRoom: 5050)
			)
		)
	)
)

(instance tryToGetMoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8075 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(1
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 12 8 18 2 self 1100) ; "Blast. I can't reach it."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 8295 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(4
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 1 8 3 0 self 1250) ; "Hmmm."
			)
			(5
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance genericEnterScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(gEgo mover:)
				((gCurRoom obstacles:)
					firstTrue: #onMe (gEgo x:) (gEgo y:)
				)
			)
			(gEgo setMotion: 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 802) ; WAVE
				(register init:)
				(gEgo posn: (register approachX:) (register approachY:))
				(= cycles 1)
			)
			(1
				(register cel: (register lastCel:) setCycle: Beg self)
			)
			(2
				(gKqSound1 number: 802 setLoop: 1 play:)
				(gEgo setHeading: 180 self)
			)
			(3
				(if
					(not
						((gCurRoom obstacles:)
							firstTrue: #onMe (gEgo x:) (gEgo y:)
						)
					)
					(gEgo setMotion: MoveTo (gEgo x:) 150)
				else
					(= cycles 1)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance moveEgoIntoPosition of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 482 91 self)
			)
			(1
				(gCurRoom centerScreen: -318 self)
				(gEgo setHeading: 225 self)
			)
			(2 0)
			(3
				(gCurRoom setScript: (ScriptID 5300 70)) ; theMoonFalls
			)
		)
	)
)

(instance firstAttemptToGetBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 (gEgo x:))
				(= local1 (gEgo y:))
				(gMessager sayRange: 7 8 29 1 3 self) ; "(GENTLY)Hello there."
			)
			(1
				(gEgo
					setScale: 0
					view: 5329
					loop: 0
					cel: 0
					x: 550
					y: 109
					setCycle: End self
				)
			)
			(2
				((ScriptID 5300 21) ; chinaBird
					view: 5329
					loop: 1
					cel: 0
					x: 571
					y: 97
					setCycle: End self
				)
			)
			(3
				((ScriptID 5300 35) hide_mouth: 1) ; chinaBirdTalker
				(gMessager say: 7 8 29 4 self) ; "(TERRIFIED, STARTS TO SCREAM)Don't TOUCH me! I don't know you! HELP! HEEEEELP!"
			)
			(4
				((ScriptID 5300 59) hide:) ; snakeSalesman
				(= seconds 2)
			)
			(5
				((ScriptID 5300 35) hide_mouth: 0) ; chinaBirdTalker
				((ScriptID 5300 59) ; snakeSalesman
					setScript: 0
					view: 5329
					loop: 2
					cel: 0
					x: 522
					y: 96
					setPri: 88
					show:
					setCycle: CT 6 1 self
				)
			)
			(6
				((ScriptID 5300 59) setPri: 121 setCycle: End self) ; snakeSalesman
			)
			(7
				(gMessager say: 7 8 29 5 self) ; "(MENACING)Shoplifters are not welcome at this wagon, lady. The lasst one I encountered is for sale, in that little jar in the back."
			)
			(8
				(ClearFlag 138)
				((ScriptID 5300 59) ; snakeSalesman
					view: 5329
					loop: 3
					cel: 0
					x: 519
					y: 105
					setCycle: CT 2 1 self
				)
			)
			(9
				((ScriptID 5300 32) dispose:) ; cageCover
				((ScriptID 5300 59) cel: 3 setCycle: CT 10 1 self) ; snakeSalesman
			)
			(10
				(gKqSound1 number: 5331 loop: 1 play:)
				((ScriptID 5300 47) ; cageDoor
					cel: ((ScriptID 5300 47) lastCel:) ; cageDoor
					setCycle: Beg self
				)
				((ScriptID 5300 59) setCycle: CT 24 1 self) ; snakeSalesman
			)
			(11
				((ScriptID 5300 32) init:) ; cageCover
				((ScriptID 5300 59) cel: 25 setCycle: End self) ; snakeSalesman
				((ScriptID 5300 21) setCycle: Beg) ; chinaBird
			)
			(12
				((ScriptID 5300 59) ; snakeSalesman
					view: 5329
					setLoop: 8
					cel: 4
					posn: 554 108
					setCycle: CT 13 1 self
				)
			)
			(13
				((ScriptID 5300 59) setPri: 80 setCycle: End self) ; snakeSalesman
			)
			(14
				((ScriptID 5300 59) hide:) ; snakeSalesman
				(= seconds 2)
			)
			(15
				((ScriptID 5300 59) ; snakeSalesman
					view: 5323
					loop: 1
					cel: 0
					posn: 531 90
					setPri: 90
					show:
					setScript: (ScriptID 5302 0) ; keepSalesmanBusy
				)
				(gEgo
					posn: local0 local1
					normalize:
					setScaler: Scaler 83 53 98 78
				)
				(self dispose:)
			)
		)
	)
)

(instance secondAttemptToGetBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 (gEgo x:))
				(= local1 (gEgo y:))
				(gEgo
					setScale: 0
					view: 5329
					loop: 0
					cel: 0
					x: 550
					y: 109
					setCycle: End self
				)
			)
			(1
				((ScriptID 5300 21) ; chinaBird
					view: 5329
					loop: 1
					cel: 0
					x: 571
					y: 97
					setCycle: End self
				)
			)
			(2
				((ScriptID 5300 35) hide_mouth: 1) ; chinaBirdTalker
				(gMessager say: 7 8 31 1 self) ; "NO! NO! HELP! HELP!"
			)
			(3
				((ScriptID 5300 59) hide:) ; snakeSalesman
				(= seconds 2)
			)
			(4
				((ScriptID 5300 35) hide_mouth: 0) ; chinaBirdTalker
				((ScriptID 5300 59) ; snakeSalesman
					setScript: 0
					view: 5329
					loop: 2
					cel: 0
					x: 522
					y: 96
					setPri: 88
					show:
					setCycle: CT 6 1 self
				)
			)
			(5
				((ScriptID 5300 59) setPri: 121 setCycle: End self) ; snakeSalesman
			)
			(6
				(gMessager say: 7 8 31 2 self) ; "(VERY MENACING)I wouldn't do that if I were you, madam. No indeed!"
			)
			(7
				(ClearFlag 138)
				((ScriptID 5300 59) ; snakeSalesman
					view: 5329
					loop: 3
					cel: 0
					x: 519
					y: 105
					setCycle: CT 2 1 self
				)
			)
			(8
				((ScriptID 5300 32) dispose:) ; cageCover
				((ScriptID 5300 59) cel: 3 setCycle: CT 10 1 self) ; snakeSalesman
			)
			(9
				(gKqSound1 number: 5331 loop: 1 play:)
				((ScriptID 5300 47) ; cageDoor
					cel: ((ScriptID 5300 47) lastCel:) ; cageDoor
					setCycle: Beg self
				)
				((ScriptID 5300 59) setCycle: CT 24 1 self) ; snakeSalesman
			)
			(10
				((ScriptID 5300 32) init:) ; cageCover
				((ScriptID 5300 59) cel: 25 setCycle: End self) ; snakeSalesman
			)
			(11
				((ScriptID 5300 59) ; snakeSalesman
					view: 5329
					setLoop: 8
					cel: 4
					posn: 554 108
					setCycle: CT 13 1 self
				)
			)
			(12
				((ScriptID 5300 59) setPri: 80 setCycle: End self) ; snakeSalesman
			)
			(13
				((ScriptID 5300 59) ; snakeSalesman
					view: 5323
					loop: 1
					cel: 0
					posn: 531 90
					setPri: 90
					setScript: (ScriptID 5302 0) ; keepSalesmanBusy
				)
				(gEgo
					posn: local0 local1
					normalize:
					setScaler: Scaler 83 53 98 78
				)
				(self dispose:)
			)
		)
	)
)

(instance takeBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 (gEgo x:))
				(= local1 (gEgo y:))
				(gEgo
					setScale: 0
					view: 5329
					loop: 0
					cel: 0
					x: 550
					y: 109
					setCycle: End self
				)
			)
			(1
				((ScriptID 5300 21) ; chinaBird
					view: 5329
					loop: 1
					cel: 0
					x: 571
					y: 97
					setCycle: End self
				)
			)
			(2
				((ScriptID 5300 35) hide_mouth: 1) ; chinaBirdTalker
				(gMessager say: 7 8 32 1 self) ; "AAAAH! HELP! HELP!"
			)
			(3
				((ScriptID 5300 35) hide_mouth: 0) ; chinaBirdTalker
				((ScriptID 5300 59) ; snakeSalesman
					setScript: 0
					view: 5329
					loop: 2
					cel: 0
					x: 522
					y: 96
					setPri: 88
					setCycle: CT 6 1 self
				)
			)
			(4
				((ScriptID 5300 59) setPri: 121 setCycle: End self) ; snakeSalesman
			)
			(5
				(ClearFlag 138)
				((ScriptID 5300 59) ; snakeSalesman
					view: 5329
					loop: 3
					cel: 0
					x: 519
					y: 105
					setCycle: CT 2 1 self
				)
			)
			(6
				((ScriptID 5300 32) dispose:) ; cageCover
				((ScriptID 5300 59) cel: 3 setCycle: CT 10 1 self) ; snakeSalesman
			)
			(7
				(gKqSound1 number: 5331 loop: 1 play:)
				((ScriptID 5300 47) ; cageDoor
					cel: ((ScriptID 5300 47) lastCel:) ; cageDoor
					setCycle: Beg self
				)
				((ScriptID 5300 59) setCycle: CT 24 1 self) ; snakeSalesman
			)
			(8
				((ScriptID 5300 32) init:) ; cageCover
				((ScriptID 5300 59) cel: 25 setCycle: End self) ; snakeSalesman
			)
			(9
				((ScriptID 5300 34) hide_mouth: 1 clientCel: -2) ; snakeTalker
				(gMessager say: 7 8 32 2 self) ; "(VERY MENACING)Don't say I didn't warn you!"
			)
			(10
				(gEgo hide:)
				((ScriptID 5300 59) ; snakeSalesman
					view: 5329
					loop: 5
					cel: 0
					x: 552
					y: 112
					setCycle: CT 14 1 self
				)
			)
			(11
				(gKqSound1 number: 831 loop: 1 play:)
				((ScriptID 5300 59) setCycle: End self) ; snakeSalesman
			)
			(12
				((ScriptID 5300 59) ; snakeSalesman
					view: 5329
					loop: 6
					cel: 0
					x: 576
					y: 113
					setCycle: CT 11 1 self
				)
			)
			(13
				(gKqSound1 number: 825 loop: 1 play:)
				((ScriptID 5300 59) setCycle: CT 34 1 self) ; snakeSalesman
			)
			(14
				((ScriptID 5300 34) hide_mouth: 1) ; snakeTalker
				(gMessager say: 7 8 32 3 self) ; "(NASTY LAUGH)Oh well. I've always liked my ladies...statuesque!"
			)
			(15
				((ScriptID 5300 34) hide_mouth: 0) ; snakeTalker
				((ScriptID 5300 59) setCycle: End self) ; snakeSalesman
			)
			(16
				(EgoDead 45 self)
			)
			(17
				((ScriptID 5300 59) ; snakeSalesman
					view: 5323
					loop: 1
					cel: 0
					posn: 531 90
					setPri: 90
					setScript: (ScriptID 5302 0) ; keepSalesmanBusy
				)
				(gEgo
					show:
					normalize:
					posn: local0 local1
					setScaler: Scaler 83 53 98 78
				)
				(gEgo setHeading: 180 self)
			)
			(18
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveStatue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 6 61 0 1 self) ; "Here you are. The magic statuette."
			)
			(1
				(if ((ScriptID 5300 59) script:) ; snakeSalesman
					(keepSalesmanBusy caller: self register: 1)
				else
					(= cycles 1)
				)
			)
			(2
				((ScriptID 5300 59) hide:) ; snakeSalesman
				((ScriptID 5300 56) dispose:) ; wagon
				(gEgo
					view: 5338
					setLoop: 1 1
					cel: 0
					posn: 515 107
					setScale: 0
					setCycle: CT 9 1 self
				)
			)
			(3
				(SetFlag 204)
				(gEgo put: 47 setCycle: CT 11 1 self) ; Magic_Statue
			)
			(4
				(gEgo
					normalize: 6
					posn: 494 108
					setPri: 111
					setScaler: Scaler 83 53 98 78
				)
				((ScriptID 5300 59) ; snakeSalesman
					view: 5338
					setLoop: 1 1
					posn: 515 107
					cel: 12
					show:
					setPri: 110
					setCycle: End self
				)
			)
			(5
				((ScriptID 5300 59) setLoop: 2 1 cel: 0 setCycle: End self) ; snakeSalesman
			)
			(6
				((ScriptID 5300 59) setLoop: 3 1 cel: 0 setCycle: CT 6 1 self) ; snakeSalesman
				(gEgo view: 8075 setLoop: 0 1 cel: 0 setCycle: End self)
			)
			(7 0)
			(8
				((ScriptID 5300 59) setCycle: End self) ; snakeSalesman
				(gEgo setCycle: Beg self)
			)
			(9
				(gEgo normalize: 6 posn: 494 108)
				((ScriptID 13 0) ; aEgoTalker
					client: gEgo
					view: -1
					loop: -1
					clientCel: -2
				)
				((ScriptID 5300 34) view: 5338 loop: 24 clientCel: -2) ; snakeTalker
				(gMessager sayRange: 6 61 0 2 6 self) ; "And here is your were-beasst salve, my Lady Valanice."
			)
			(10
				(gKqSound1 number: 5333 loop: 1 play:)
				((ScriptID 5300 59) setLoop: 4 1 cel: 0 setCycle: End self) ; snakeSalesman
			)
			(11
				(gKqSound1 stop:)
				((ScriptID 5300 20) init:) ; curtain
				((ScriptID 5300 59) dispose:) ; snakeSalesman
				(= global377 0)
				(gEgo get: 65) ; Were-beast_Salve
				(SetFlag 198)
				(= cycles 1)
			)
			(12
				(gEgo setHeading: 180 self)
			)
			(13
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance escortedOutOfTownHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 5300 6) cel: 4 setPri: 10) ; townHallDoor
				((ScriptID 5300 19) ; badger
					view: 5306
					loop: 2
					cel: 0
					x: 226
					y: 98
					priority: 83
					fixPriority: 1
					init:
					setCycle: End self
				)
				(gEgo
					normalize: 4
					posn: 220 97
					setMotion: MoveTo 240 103 self
				)
			)
			(1
				(proc11_3 gEgo (ScriptID 5300 19)) ; badger
			)
			(2
				((ScriptID 5300 19) ; badger
					view: 5305
					setLoop: 3
					posn: 217 93
					cel: 0
					setCycle: End self
				)
			)
			(3
				((ScriptID 5300 19) dispose:) ; badger
				((ScriptID 5300 6) setCycle: Beg self) ; townHallDoor
			)
			(4
				(gKqSound1 number: 802 loop: 1 play:)
				(gEgo setHeading: 180 self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance readFauxDoorSign of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(gMessager say: 8 8 register 0)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterTownHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 232 100
					view: 5307
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setScale: 0
				)
				(UpdateScreenItem gEgo)
				(FrameOut)
				(= cycles 1)
			)
			(1
				(gKqSound1 number: 808 setLoop: 1 play:)
				(= ticks 20)
			)
			(2
				(gEgo setCycle: CT 2 1 self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gKqSound1 play:)
				(gEgo setCycle: CT 2 1 self)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gKqSound1 play:)
				(gEgo setCycle: CT 3 1 self)
			)
			(7
				(gKqSound1 number: 801 loop: 1 play:)
				((ScriptID 5300 6) setPri: 80 setCycle: CT 4 1 self) ; townHallDoor
			)
			(8
				((ScriptID 5300 19) ; badger
					view: 5306
					loop: 2
					cel: 0
					x: 226
					y: 98
					priority: 83
					fixPriority: 1
					init:
					setCycle: End self
				)
			)
			(9
				(gEgo cel: 5 posn: 221 103 setPri: 83 setCycle: CT 6 1 self)
			)
			(10
				((ScriptID 5300 19) hide:) ; badger
				(gEgo cel: 7 setCycle: End self)
			)
			(11
				((ScriptID 5300 31) client: gEgo) ; guardTalker
				(gMessager say: 3 8 11 0 self) ; "Welcome, my lady."
			)
			(12
				(gEgo posn: 240 101 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(13
				(gEgo
					posn: 242 100
					setLoop: 2
					setCel: 0
					setCycle: CT 12 1 self
				)
			)
			(14
				(gEgo setPri: 88 setCycle: End self)
			)
			(15
				(gCurRoom newRoom: 5100)
			)
		)
	)
)

(instance dukeStopsVal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo (ScriptID 5300 5)) ; archDuke
				((ScriptID 5300 5) ; archDuke
					posn: 160 111
					setLoop: 4
					setCel: 0
					setCycle: End self
				)
			)
			(1
				((ScriptID 5300 29) modeless: 2) ; archTalker
				(gMessager say: 0 0 2 0 self) ; "HALT! YIPYIPYIPYIPYIPYIPYIP!"
				(self setScript: (ScriptID 5302 18) self) ; egoBackOff
			)
			(2 0)
			(3
				((ScriptID 5300 29) modeless: 1) ; archTalker
				((ScriptID 5300 5) setCycle: Beg self) ; archDuke
			)
			(4
				((ScriptID 5300 5) posn: 225 112 setLoop: 2) ; archDuke
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoBackOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 5301
					setLoop: 5
					setCel: 0
					setScale: 0
					setCycle: End self
				)
			)
			(1
				(gEgo normalize: 0 setScaler: Scaler 83 53 98 78)
				(self dispose:)
			)
		)
	)
)

(instance fromAssembly of Script
	(properties)

	(method (changeState newState)
		(= cycles 0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 4)
			)
			(1
				(gEgo
					setLoop: (gEgo loop:) 1
					setMotion: MoveTo 229 99 self
				)
			)
			(2
				((ScriptID 5300 6) setCycle: Beg self) ; townHallDoor
			)
			(3
				(gKqSound1 number: 802 loop: 1 play:)
				(gEgo setHeading: 225 self)
			)
			(4
				(if (== gChapter 3)
					(self setScript: (ScriptID 5302 20) self) ; removeValsMask
				else
					(= cycles 1)
				)
			)
			(5
				(gEgo normalize: 5 setScaler: Scaler 83 53 98 78)
				(gEgo setHeading: 180 self)
			)
			(6
				(if (not next)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance removeValsMask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 5309
					setLoop: 0
					setCel: 21
					setScale: 0
					cycleSpeed: 6
					setCycle: Beg self
				)
			)
			(1
				(gEgo setLoop: 2 cel: 27 setCycle: Beg self)
			)
			(2
				(gEgo get: 43) ; Mask
				(ClearFlag 137)
				(self dispose:)
			)
		)
	)
)

(instance putOnMask of Script
	(properties)

	(method (handleEvent event &tmp temp0)
		(if
			(or
				(and
					(& (event type:) evMOUSEBUTTON)
					(= temp0 1)
					(or (event localize: gThePlane) 1)
					(gThePlane onMe: event)
					(not ((ScriptID 5300 6) onMe: event)) ; townHallDoor
				)
				(& (event type:) evMOVE)
			)
			(event claimed: 1)
			(self changeState: 4)
		)
		(if temp0
			(event globalize:)
		)
		(event claimed:)
	)

	(method (dispose)
		(if (gWalkHandler contains: self)
			(gWalkHandler delete: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 237 98 self)
			)
			(1
				(gEgo
					view: 5309
					setLoop: 2
					setCel: 0
					setScale: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(2
				(gEgo view: 5309 setLoop: 0 1 setCel: 0 setCycle: End self)
				(SetFlag 137)
				(gEgo put: 43) ; Mask
			)
			(3
				(gWalkHandler add: self)
				(gMouseDownHandler add: self)
				(gGame handsOn:)
			)
			(4
				(gGame handsOff:)
				(gWalkHandler delete: self)
				(gMouseDownHandler delete: self)
				(gEgo
					view: 5309
					setLoop: 0
					setCel: 21
					setScale: 0
					setCycle: Beg self
				)
				(ClearFlag 137)
				(gEgo get: 43) ; Mask
			)
			(5
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(6
				(gGame handsOn:)
				(gEgo normalize: 5 setScaler: Scaler 83 53 98 78)
				(self dispose:)
			)
		)
	)
)

(instance chickenTimerScript of Script
	(properties)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp1 0)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(= temp1 1)
				(or (event localize: gThePlane) 1)
				((ScriptID 5300 1) onMe: event) ; chickenPetite
			)
			(event globalize:)
			(self dispose:)
			(return 0)
		)
		(if temp1
			(event globalize:)
		)
		(if
			(and
				(gThePlane onMe: event)
				(or (& (event type:) evMOVE) (& (event type:) evMOUSEBUTTON))
			)
			(event claimed: 1)
			(self seconds: 0 cycles: 1)
		)
		(event claimed:)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gWalkHandler add: self)
				(gMouseDownHandler add: self)
				((ScriptID 5300 1) setHotspot: 8 10) ; chickenPetite, Do, Exit
				(= seconds (+ register 1))
			)
			(1
				((ScriptID 5300 1) setHotspot: 0) ; chickenPetite
				(gCurRoom setScript: (ScriptID 5300 61)) ; chickenRunsOff
				(self dispose:)
			)
		)
	)
)

(instance switchMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqMusic1 fade: 30 25 20 1 self)
			)
			(1
				(= ticks 60)
			)
			(2
				(gKqMusic1 number: register loop: -1 play: setVol: 30)
				(gKqMusic1 fade: 127 25 20 0)
				(= ticks 60)
			)
			(3
				(= global378 (= register 0))
				(self dispose:)
			)
		)
	)
)

(instance talkToDuke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo (ScriptID 5300 5) self) ; archDuke
			)
			(1
				(if (not (SetFlag 410))
					(gMessager say: 1 8 3 0 self) ; "Please, noble Arch-Duke, you must let me by. I am on an errand of great importance."
				else
					(gMessager say: 1 8 4 0 self) ; "Sir--"
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sayHmmm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8295 setLoop: 0 setCel: 0 setCycle: End self)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(1
				(gMessager say: 1 8 3 0 self 1250) ; "Hmmm."
			)
			(2
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putChickenOnTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScale: 0
					view: 5330
					loop: 0
					cel: 0
					x: 269
					y: 103
					setCycle: End self
				)
			)
			(1
				(gEgo loop: 1 cel: 0 x: 269 y: 103 setCycle: End self)
			)
			(2
				(SetFlag 273)
				(gEgo put: 46) ; Rubber_Chicken
				((ScriptID 5300 28) init:) ; rubChicken
				(gEgo
					normalize: 6
					posn: 283 102
					setScaler: Scaler 83 53 98 78
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getChickenDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 5332
					loop: 0
					cel: 0
					x: 269
					y: 103
					setScale: 0
					setCycle: End self
				)
				(gEgo get: 46) ; Rubber_Chicken
				(ClearFlag 273)
				((ScriptID 5300 28) dispose:) ; rubChicken
				((ScriptID 5300 27) init:) ; yBranch
			)
			(1
				(gEgo
					normalize: 3
					posn:
						((ScriptID 5300 28) approachX:) ; rubChicken
						((ScriptID 5300 28) approachY:) ; rubChicken
					setScaler: Scaler 83 53 98 78
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance replaceTheMoon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 5405) ; WAVE
				(Load rsSOUND 854)
				(Load 140 5404) ; WAVE
				(gEgo
					view: 5331
					loop: 0
					cel: 0
					x: 282
					y: 99
					setScale: 0
					setCycle: End self
				)
			)
			(1
				((ScriptID 5300 28) hide:) ; rubChicken
				(gKqSound1 number: 5404 loop: 1 play:)
				(gEgo
					view: 5331
					loop: 1
					cel: 0
					x: 281
					y: 103
					setCycle: End self
				)
			)
			(2
				(= cycles 60)
			)
			(3
				(if (and (not (IsFlag 136)) (not (gEgo has: 41))) ; Feather
					((ScriptID 5300 45) init:) ; feather
				)
				(gKqSound1 number: 854 loop: 1 play:)
				(gEgo
					view: 5331
					loop: 2
					cel: 0
					x: 280
					y: 103
					setCycle: End self
				)
			)
			(4
				(gEgo
					put: 48 ; Moon
					normalize: 6
					posn: 278 102
					setScaler: Scaler 83 53 98 78
				)
				(gKqSound1 number: 5405 loop: 1 play:)
				((ScriptID 5300 28) ; rubChicken
					show:
					view: 5331
					loop: 3
					cel: 0
					x: 296
					y: 96
					setCycle: End self
				)
			)
			(5
				(= temp0 (+ (Abs ((gCurRoom plane:) left:)) 330))
				((ScriptID 5300 28) ; rubChicken
					setLoop: 6 1
					cel: 0
					posn: 327 94
					setCycle: Walk
					setPri: -1
					setMotion: PolyPath temp0 94 self
				)
			)
			(6
				(ClearFlag 273)
				((ScriptID 5300 28) dispose:) ; rubChicken
				((ScriptID 5300 54) init:) ; littleDoorExit
				((ScriptID 5300 52) dispose:) ; bigGate
				(SetFlag 202)
				(proc5300_17)
				((ScriptID 5300 29) clientCel: -2) ; archTalker
				(gCurRoom setScript: (ScriptID 5301 1)) ; congrats
			)
		)
	)
)

(instance getFeather of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 (gEgo x:))
				(= local1 (gEgo y:))
				(= cycles 3)
			)
			(1
				(gEgo view: 8075 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				((ScriptID 5300 45) dispose:) ; feather
				(gEgo get: 41 setCycle: Beg self) ; Feather
			)
			(3
				(gEgo
					normalize: 6
					posn: local0 local1
					setScaler: Scaler 83 53 98 78
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tryAndThrowMoonUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo view: 5336 setLoop: 0 1 cel: 0 setCycle: CT 10 1 self)
			)
			(2
				(gKqSound1 number: 824 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo setLoop: 1 1 cel: 0 setCycle: CT 6 1 self)
			)
			(4
				(gKqSound1 number: 856 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(6
				(gEgo normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showTownHallSign of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom setInset: (ScriptID 5300 50) self) ; iSign
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance openTownHallDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gValOrRoz -4) ; Val
					(gEgo
						view: 8125
						loop: 1
						cel: 0
						posn: 228 100
						setPri: 88
						setCycle: CT 5 1 self
					)
				else
					(gEgo
						view: 8485
						setLoop: 1
						cel: 0
						setPri: 88
						setCycle: CT 5 1 self
					)
				)
			)
			(1
				(if register
					(gKqSound1 number: 803 loop: 1 play: self)
				else
					(= cycles 1)
				)
			)
			(2
				(if register
					((ScriptID 13 0) hide_mouth: 1 clientCel: -2) ; aEgoTalker
					(gMessager say: 0 0 47 0 self) ; "It's Locked"
				else
					(gKqSound1 number: 801 loop: 1 play:)
					((ScriptID 5300 6) setPri: 10 setCycle: End self) ; townHallDoor
					(gEgo setCycle: End self)
				)
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(if register
					(gEgo setCycle: Beg self)
				)
			)
			(4
				(if register
					(gEgo
						normalize: 7
						posn:
							((ScriptID 5300 6) approachX:) ; townHallDoor
							((ScriptID 5300 6) approachY:) ; townHallDoor
					)
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo
						normalize: 3
						posn: 222 101
						setPri: 20
						setMotion: MoveTo 177 75 self
					)
				)
			)
			(5
				(gCurRoom newRoom: 5100)
			)
		)
	)
)

(instance snakeDoVerbElse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if ((ScriptID 5300 59) script:) ; snakeSalesman
					((ScriptID 5302 0) caller: self register: 1) ; keepSalesmanBusy
				else
					(= cycles 1)
				)
			)
			(1
				(if (or (IsFlag 116) (IsFlag 95))
					(gMessager say: 6 0 45 0 self) ; "No substitutions, my lady. I will take only the magic sstatuette for the were beast ssalve."
				else
					(gMessager say: 6 98 5 0 self) ; "(SNOTTY)This is not a pawn shop, madam. I deal in cash and PRECIOUSS objects."
				)
			)
			(2
				((ScriptID 13 0) hide_mouth: 0 modeless: 1) ; aEgoTalker
				(gGame handsOn:)
				((ScriptID 5300 59) setScript: (ScriptID 5302 0)) ; snakeSalesman, keepSalesmanBusy
				(self dispose:)
			)
		)
	)
)

(instance snakeDoVerbDo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if ((ScriptID 5300 59) script:) ; snakeSalesman
					((ScriptID 5302 0) caller: self register: 1) ; keepSalesmanBusy
				else
					(= cycles 1)
				)
			)
			(1
				(cond
					((or (IsFlag 116) (IsFlag 95))
						(if (or (not (IsFlag 123)) (== gChapter 5))
							(cond
								((and (not (IsFlag 95)) (not (SetFlag 416)))
									(gMessager say: 6 8 22 0 self) ; "(HOPEFULLY BUT UNSURE ABOUT THE SALESMAN)Sir, I was told of a merchant who sells an item which can get me through the Wood of the Were folk. Would that be you?"
								)
								((not (SetFlag 417))
									(gMessager say: 6 8 23 0 self) ; "(SUSPICIOUS)Sir, may I ask you why you want this magic statuette? What are its powers?"
								)
								(else
									(gMessager say: 6 8 24 0 self) ; "(SLICK AND UNPLEASANT)I am a very busy man, my lady. come back here when you have the magic sstatuette, yess?"
								)
							)
						else
							(gMessager say: 6 8 24 0 self) ; "(SLICK AND UNPLEASANT)I am a very busy man, my lady. come back here when you have the magic sstatuette, yess?"
						)
					)
					((or (not (IsFlag 123)) (== gChapter 5))
						(cond
							((not (SetFlag 418))
								(gMessager say: 6 8 25 0 self) ; "Good day, sir. I wonder if you might be able to help me?"
							)
							((not (SetFlag 419))
								(gMessager say: 6 8 26 0 self) ; "(CAUTIOUSLY)Good merchant, I really would appreciate a moment of your time."
							)
							(else
								((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
								(gMessager say: 6 8 27 0 self) ; "(THINKS TO HERSELF)I've had about as much of that fellow as I can stand for the moment."
							)
						)
					)
					(else
						((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
						((ScriptID 5300 59) setScript: (ScriptID 5302 0)) ; snakeSalesman, keepSalesmanBusy
						(gMessager say: 6 8 27 0 self) ; "(THINKS TO HERSELF)I've had about as much of that fellow as I can stand for the moment."
					)
				)
			)
			(2
				((ScriptID 13 0) hide_mouth: 0 modeless: 1) ; aEgoTalker
				(gGame handsOn:)
				(if (not ((ScriptID 5300 59) script:)) ; snakeSalesman
					((ScriptID 5300 59) setScript: (ScriptID 5302 0)) ; snakeSalesman, keepSalesmanBusy
				)
				(self dispose:)
			)
		)
	)
)

(instance snakeDoVerbComb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if ((ScriptID 5300 59) script:) ; snakeSalesman
					((ScriptID 5302 0) caller: self register: 1) ; keepSalesmanBusy
				else
					(= cycles 1)
				)
			)
			(1
				(cond
					((IsFlag 116)
						(gMessager say: 6 5 22 0 self) ; "(SADLY)This comb belongs to my daughter, who was taken from me by dark magic. Have you heard anything about a beautiful girl with hair of gold?"
						(SetFlag 349)
					)
					((not (SetFlag 461))
						(SetFlag 95)
						(self setScript: (ScriptID 5302 36)) ; haveSalesmanPoint
					)
					((not (SetFlag 417))
						(gMessager say: 6 5 26 0 self) ; "(SUSPICIOUS)Sir, may I ask why do you want this magic statuette? What are its powers?"
					)
					(else
						(SetFlag 349)
						(gMessager say: 6 5 27 0 self) ; "(SLICK AND UNPLEASANT)I am a very bussy man, my lady. Come back when you have the magic statuette, yess?"
					)
				)
			)
			(2
				((ScriptID 13 0) hide_mouth: 0 modeless: 1) ; aEgoTalker
				(gGame handsOn:)
				((ScriptID 5300 59) setScript: (ScriptID 5302 0)) ; snakeSalesman, keepSalesmanBusy
				(self dispose:)
			)
		)
	)
)

(instance haveSalesmanPoint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 6 5 25 1 self) ; "(SAD, DESPERATE)Please, sir, you must help me. This comb belongs to my daughter, and she is missing. She is a beautiful girl, with sky-blue eyes and golden hair. Have you heard of her?"
			)
			(1
				(if ((ScriptID 5300 59) script:) ; snakeSalesman
					((ScriptID 5302 0) caller: self register: 1) ; keepSalesmanBusy
				else
					(= cycles 1)
				)
			)
			(2
				(gMessager sayRange: 6 5 25 2 4 self) ; "(SLY)Indeed I have, lady. I have just recently heard she is to be married to the Troll King in the Vulcanix Underground in a few days. It'ss too bad you can't possibly go there and ssave her."
			)
			(3
				(if (not (gEgo has: 47)) ; Magic_Statue
					(gMessager say: 6 5 25 5 self) ; "(DETERMINED)Just were can I find this magic statuette?"
				else
					(gGame handsOn:)
					((ScriptID 5300 59) setScript: (ScriptID 5302 0)) ; snakeSalesman, keepSalesmanBusy
					(self dispose:)
				)
			)
			(4
				(gEgo hide:)
				(= register ((ScriptID 5300 59) priority:)) ; snakeSalesman
				((ScriptID 5300 59) ; snakeSalesman
					view: 5325
					setLoop: 2 1
					cel: 0
					posn: 491 134
					setPri: 150
					setCycle: CT 8 1 self
				)
			)
			(5
				((ScriptID 5300 59) cel: 9) ; snakeSalesman
				(UpdateScreenItem (ScriptID 5300 59)) ; snakeSalesman
				(FrameOut)
				(= cycles 1)
			)
			(6
				(gMessager say: 6 5 25 6 self) ; "(WHISPERING IN HER EAR)I cannot be ssure, but last I heard, the Arch-Duke had it."
			)
			(7
				((ScriptID 5300 59) setCycle: Beg self) ; snakeSalesman
			)
			(8
				(gEgo show:)
				((ScriptID 5300 59) ; snakeSalesman
					setLoop: 5
					cel: 7
					setPri: register
					posn: 497 129
				)
				(UpdateScreenItem (ScriptID 5300 59)) ; snakeSalesman
				(FrameOut)
				(= cycles 3)
			)
			(9
				(gMessager sayRange: 6 5 25 7 9 self) ; "(INDIGNANT)I can't just take something from the Arch-Duke!"
			)
			(10
				(gGame handsOn:)
				((ScriptID 5300 59) setScript: (ScriptID 5302 0)) ; snakeSalesman, keepSalesmanBusy
				(self dispose:)
			)
		)
	)
)

