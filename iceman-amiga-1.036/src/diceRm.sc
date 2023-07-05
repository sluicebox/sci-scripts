;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use Main)
(use Interface)
(use ForwardCounter)
(use LoadMany)
(use Count)
(use Sort)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	diceRm 0
	proc39_1 1
	johnnyDice 2
	oldSaltDice 3
	johnnyRArmP 4
	johnnyLArmP 5
	saltRArmP 6
	saltLArmP 7
	johnnyMouth 8
	saltMouth 9
	objList 10
	cButton 11
	rButton 12
	nButton 13
	johnnyMoney 14
	oldSaltMoney 15
	johnTwitch 16
	smokeCigar 17
	greenTumble 18
	greenTable 19
	redTumble 20
	redTable 21
	proc39_22 22
	soundDice 23
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 = 1
	[local7 9] = [180 0 45 90 135 180 225 270 315]
	local16
	local17
	local18
	local19
	local20
	local21
)

(procedure (proc39_1)
	(if (> (oldSaltDice diceScore:) 500)
		(oldSaltDice selected: 0)
	else
		(oldSaltDice selected: 1)
		(cond
			((> (oldSaltDice diceScore:) 400)
				(if (== ((oldSaltDice at: 0) cel:) ((oldSaltDice at: 2) cel:))
					((oldSaltDice at: 4) select: 1)
				else
					((oldSaltDice at: 0) select: 1)
				)
			)
			((> (oldSaltDice diceScore:) 200)
				(cond
					((== ((oldSaltDice at: 0) cel:) ((oldSaltDice at: 2) cel:))
						((oldSaltDice at: 3) select: 1)
						((oldSaltDice at: 4) select: 1)
					)
					((== ((oldSaltDice at: 4) cel:) ((oldSaltDice at: 2) cel:))
						((oldSaltDice at: 0) select: 1)
						((oldSaltDice at: 1) select: 1)
					)
					(else
						((oldSaltDice at: 0) select: 1)
						((oldSaltDice at: 4) select: 1)
					)
				)
			)
			((> (oldSaltDice diceScore:) 100)
				(cond
					((== ((oldSaltDice at: 0) cel:) ((oldSaltDice at: 1) cel:))
						((oldSaltDice at: 2) select: 1)
						((oldSaltDice at: 3) select: 1)
						((oldSaltDice at: 4) select: 1)
					)
					((== ((oldSaltDice at: 1) cel:) ((oldSaltDice at: 2) cel:))
						((oldSaltDice at: 0) select: 1)
						((oldSaltDice at: 3) select: 1)
						((oldSaltDice at: 4) select: 1)
					)
				)
			)
			((> (oldSaltDice diceScore:) 0)
				(cond
					((== ((oldSaltDice at: 0) cel:) ((oldSaltDice at: 1) cel:))
						((oldSaltDice at: 2) select: 1)
						((oldSaltDice at: 3) select: 1)
						((oldSaltDice at: 4) select: 1)
					)
					((== ((oldSaltDice at: 1) cel:) ((oldSaltDice at: 2) cel:))
						((oldSaltDice at: 0) select: 1)
						((oldSaltDice at: 3) select: 1)
						((oldSaltDice at: 4) select: 1)
					)
					((== ((oldSaltDice at: 2) cel:) ((oldSaltDice at: 3) cel:))
						((oldSaltDice at: 0) select: 1)
						((oldSaltDice at: 1) select: 1)
						((oldSaltDice at: 4) select: 1)
					)
					(else
						((oldSaltDice at: 0) select: 1)
						((oldSaltDice at: 1) select: 1)
						((oldSaltDice at: 2) select: 1)
					)
				)
			)
			(else
				((oldSaltDice at: 1) select: 1)
				((oldSaltDice at: 2) select: 1)
				((oldSaltDice at: 3) select: 1)
				((oldSaltDice at: 4) select: 1)
			)
		)
	)
)

(procedure (localproc_0 param1 &tmp temp0)
	(for ((= temp0 210)) (< temp0 300) ((+= temp0 20))
		(objList add: ((CursorCoords new:) cursorX: temp0 cursorY: 17))
	)
	(objList add: ((CursorCoords new:) cursorX: 250 cursorY: 33))
	(if param1
		(objList add: ((CursorCoords new:) cursorX: 230 cursorY: 33))
		(objList add: ((CursorCoords new:) cursorX: 270 cursorY: 33))
	)
)

(procedure (proc39_22 param1 &tmp temp0 temp1 temp2)
	(= temp2 0)
	(for ((= temp0 (FirstNode (param1 elements:)))) temp0 ((= temp0 temp1))
		(= temp1 (NextNode temp0))
		(if ((NodeValue temp0) selected:)
			(++ temp2)
		)
	)
	(return temp2)
)

(instance dieBox of View
	(properties
		view 39
		loop 2
	)
)

(instance rollDieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: (Random 0 (client lastCel:)) rolling: 1)
				(client hide: select: 0)
			)
			(1
				(= seconds 2)
			)
			(2
				(client rolling: 0 setScript: 0)
			)
		)
	)
)

(class Die of Prop
	(properties
		selected 0
		mousable 1
		box 0
		rolling 0
	)

	(method (init)
		(super init:)
		((= box (Clone dieBox)) x: (self x:) y: (self y:) stopUpd: init:)
		(self select: selected)
		(self stopUpd:)
	)

	(method (roll)
		(if selected
			(self setScript: (Clone rollDieScript))
		)
	)

	(method (select param1)
		(if
			(= selected
				(if argc
					param1
				else
					(not selected)
				)
			)
			(box show:)
		else
			(box hide:)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and mousable (MousedOn self event))
				(self select:)
				(event claimed: 1)
			)
		)
	)
)

(class DiceGame of List
	(properties
		selected 0
		view 0
		loop 0
	)

	(method (cue)
		(self eachElementDo: #cue &rest)
	)

	(method (init param1 &tmp temp0 temp1)
		(if argc
			(for ((= temp0 0)) (<= temp0 (- argc 2)) ((++ temp0))
				((= temp1 (Die new:))
					posn: [param1 temp0] [param1 (++ temp0)]
					view: view
					loop: loop
					init:
					hide:
				)
				(temp1 setCel: (Random 0 (temp1 lastCel:)))
				(self add: temp1)
			)
		)
		(super init:)
	)

	(method (dispose)
		(self release:)
		(super dispose:)
	)
)

(class oldSaltDice of DiceGame
	(properties
		diceScore 0
		highPair 0
	)

	(method (dScore &tmp temp0 temp1 temp2 temp3)
		(= highPair 0)
		(Sort self reverseLT)
		(= temp0 (Count self diceCount (self at: 2)))
		(= temp2 (+ ((self at: 2) cel:) 1))
		(switch temp0
			(5
				(= diceScore (+ 500 (* 10 temp2)))
			)
			(4
				(= diceScore (+ 400 (* 10 temp2)))
			)
			(else
				(= temp0 (Count self diceCount (self at: 1)))
				(= temp1 (Count self diceCount (self at: 3)))
				(= temp2 (+ ((self at: 1) cel:) 1))
				(= temp3 (+ ((self at: 3) cel:) 1))
				(switch temp0
					(3
						(if (== temp1 2)
							(= diceScore (+ 300 (* 10 temp2) temp3))
						else
							(= diceScore (+ 200 (* 10 temp2)))
						)
					)
					(2
						(cond
							((== temp1 3)
								(= diceScore (+ 300 (* 10 temp3) temp2))
							)
							((== temp1 2)
								(= diceScore (+ 100 (* 10 temp2) temp3))
								(= highPair temp2)
							)
							(else
								(= diceScore (* 10 temp2))
								(= highPair temp2)
							)
						)
					)
					(else
						(cond
							((== temp1 3)
								(= diceScore (+ 200 (* 10 temp3)))
							)
							((== temp1 2)
								(= diceScore (* 10 temp3))
								(= highPair temp3)
							)
							(else
								(= diceScore 0)
							)
						)
					)
				)
			)
		)
	)
)

(instance reverseLT of Code
	(properties)

	(method (doit param1 param2)
		(return (> (param1 cel:) (param2 cel:)))
	)
)

(instance diceCount of Code
	(properties)

	(method (doit param1 param2)
		(return (== (param1 cel:) (param2 cel:)))
	)
)

(class CursorCoords of Obj
	(properties
		cursorX 0
		cursorY 0
	)
)

(class InputList of Set
	(properties)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(if (== (event type:) $0040) ; direction
			(= temp7 [local7 (event message:)])
			(= temp3 60)
			(= temp4 400)
			(= temp10 (event x:))
			(= temp11 (event y:))
			(for ((= temp5 (= temp2 0))) (< temp5 size) ((++ temp5))
				(= temp1 (self at: temp5))
				(= temp12 (temp1 cursorX:))
				(= temp13 (temp1 cursorY:))
				(if (or (!= temp10 temp12) (!= temp11 temp13))
					(= temp8 (GetAngle temp10 temp11 temp12 temp13))
					(= temp0 (GetDistance temp10 temp11 temp12 temp13))
					(if (> (= temp9 (Abs (- temp7 temp8))) 180)
						(= temp9 (- 360 temp9))
					)
					(= temp6 (<= temp9 (+ temp3 10)))
					(if
						(or
							(<= temp9 (- temp3 10))
							(and temp6 (< (+ temp9 temp0) (+ temp3 temp4)))
							(and
								temp6
								(== (+ temp9 temp0) (+ temp3 temp4))
								(< temp9 temp3)
							)
						)
						(= temp3 temp9)
						(= temp4 temp0)
						(= temp2 temp1)
					)
				)
			)
			(if temp2
				(SetCursor gTheCursor 1 (temp2 cursorX:) (temp2 cursorY:))
			)
		)
	)

	(method (empty &tmp temp0)
		(if size
			(for ((= temp0 (- size 1))) (>= temp0 0) ((-- temp0))
				((self at: temp0) dispose:)
				(self delete: (self at: temp0))
			)
		)
	)
)

(instance diceRm of Rm
	(properties
		picture 39
	)

	(method (init)
		(super init:)
		(LoadMany rsSCRIPT 375 376 377 378 379 380 381 382)
		(LoadMany rsVIEW 39 239 439 539 139)
		(LoadMany rsSOUND 76 77 75)
		(= global54 0)
		(self setRegions: 314) ; subMarine
		(oldSaltDice view: 39 loop: 0 init: 30 20 50 20 70 20 90 20 110 20)
		(johnnyDice init: 210 20 230 20 250 20 270 20 290 20)
		(saltRArmP stopUpd: init:)
		(redTumble setCel: (redTumble lastCel:) init:)
		(redTable setCel: 0 init:)
		(greenTumble setCel: (greenTumble lastCel:) setPri: 9 init:)
		(greenTable setCel: 0 setPri: 9 init:)
		(cigarSmoke init: hide:)
		(saltLArmP stopUpd: init:)
		(saltMouth setPri: 8 init: cel: 1)
		(saltEyes setPri: 9 init: cel: 1)
		(johnnyLArmP init:)
		(johnnyRArmP stopUpd: init:)
		(johnnyMouth setPri: 6 init: hide:)
		(johnnyEyes setPri: 7 init: cel: 1)
		(johnnyFingers init: hide:)
		(rumBottle init: stopUpd:)
		(gAddToPics add: johnnyPV oldSaltV eachElementDo: #init doit:)
		(oldSaltMoney init:)
		(johnnyMoney init:)
		(= local0 4)
		(= local1 0)
		(= local2 3)
		(= local3 0)
		(gCurRoom
			setScript:
				(if global55
					(ScriptID 375 0) ; newRoundScript
				else
					(ScriptID 376 0) ; startScript
				)
		)
		(oldSaltDice eachElementDo: #mousable 0)
		(gIceDirectionHandler addToFront: self)
		(objList init: add:)
		(localproc_0 1)
		(gIceGlobalSound stop:)
		(soundDice number: (proc0_5 76) init:)
		(if (= global132 2)
			(saltLArmP setScript: smokeCigar)
			(saltEyes setScript: blinkerScript)
			(johnnyLArmP setScript: johnTwitch)
			(johnnyEyes setScript: (Clone blinkerScript))
		)
	)

	(method (replay)
		(if (< 2 (++ local21))
			(Print 39 0) ; "The old salt looks you in the eye and says, "Now lad I won't be playin' with ye restorin' every time you lose. That be cheatin'!""
			(if (not (gEgo has: 4)) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
				((gInventory at: 4) owner: gCurRoomNum) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
			)
			(SetCursor gTheCursor 1 310 180)
			(gCurRoom newRoom: 32) ; galleyRm
		else
			(switch local21
				(1
					(Print 39 1) ; "The old salt says, "well do ye think your little rest has changed your luck?""
				)
				(2
					(Print 39 2) ; "You wouldn't be saving the game just to avoid losing would ye?"
				)
			)
		)
	)

	(method (notify param1 param2)
		(switch param1
			(0
				(if (< 1 argc)
					(= local4 param2)
				else
					(return local4)
				)
			)
			(1
				(if (< 1 argc)
					(= local3 param2)
				else
					(return local3)
				)
			)
			(2
				(if (< 1 argc)
					(= local1 param2)
				else
					(return local1)
				)
			)
			(3
				(if (< 1 argc)
					(= local2 param2)
				else
					(return local2)
				)
			)
			(4
				(if (< 1 argc)
					(= local0 param2)
				else
					(return local0)
				)
			)
			(5
				(if (< 1 argc)
					(= local5 param2)
				else
					(return local5)
				)
			)
			(6
				(if (< 1 argc)
					(= local17 param2)
				else
					(return local17)
				)
			)
			(7
				(if (< 1 argc)
					(= local18 param2)
				else
					(return local18)
				)
			)
			(8
				(if (< 1 argc)
					(= local19 param2)
				else
					(return local19)
				)
			)
			(9
				(if (< 1 argc)
					(= local20 param2)
				else
					(return local20)
				)
			)
			(10
				(= local16 1)
			)
			(11
				(= local16 2)
			)
			(12
				(= local16 3)
			)
			(13
				(= local16 4)
			)
		)
	)

	(method (doit)
		(switch local16
			(0)
			(1
				(self setScript: (ScriptID 375 0)) ; newRoundScript
			)
			(2
				(self setScript: (ScriptID 377 0)) ; johnnyBoss
			)
			(3
				(self setScript: (ScriptID 378 0)) ; oldSaltBoss
			)
			(4
				(johnnyRArmP setScript: (ScriptID 382 0)) ; checkScores2
			)
		)
		(= local16 0)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'stop,stand[<up]')
				(SetCursor gTheCursor 1 310 180)
				(gCurRoom newRoom: 32) ; galleyRm
			)
			((Said 'bet/bottle')
				(if (gEgo has: 4) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
					(Print 39 3) ; "You need the bottle."
				else
					(Print 39 4) ; "You have to win the bottle first."
				)
			)
			((Said 'drink/rum')
				(if (gEgo has: 4) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
					(Print 39 5) ; "A good naval officer would never drink while on an important mission."
				else
					(Print 39 4) ; "You have to win the bottle first."
				)
			)
			((Said 'look>')
				(cond
					((Said '[<around][/room]')
						(Print 39 6) ; "You look around the small cafeteria called a "galley"."
						(Print 39 7) ; "This is the place where the crewmen of the Blackhawk stuff themselves with tender morsels."
					)
					((Said '/table')
						(Print 39 8) ; "You see the galley table that you are playing Boss Dice on."
					)
				)
			)
			((Said 'talk')
				(Print 39 9) ; "Just play."
			)
			((Said 'count/money')
				(Print 39 10) ; "You never count your money while you're sitting at the table. There'll be plenty of time for counting when the rolling's done."
			)
		)
	)

	(method (dispose)
		(gIceDirectionHandler delete: self)
		(johnnyDice dispose:)
		(oldSaltDice dispose:)
		(objList dispose:)
		(proc0_3)
		(= global54 1)
		(soundDice dispose:)
		(LoadMany 0 375 376 377 378 379 380 381 382)
		(super dispose:)
	)
)

(instance blinkerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 40 100))
			)
			(1
				(client cel: 0)
				(= cycles 2)
			)
			(2
				(client cel: 1)
				(= cycles 2)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance smokeCigar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 70 150))
			)
			(1
				(if local18
					(self init:)
				else
					(= register 1)
					(saltLArmP setLoop: 5 setCycle: End self)
				)
			)
			(2
				(= cycles 10)
			)
			(3
				(saltLArmP setCycle: Beg self)
			)
			(4
				(= register 0)
				(saltMouth loop: 9 cel: 0)
				(cigarSmoke show: setCycle: End self)
			)
			(5
				(saltMouth loop: 1 cel: 1 setCycle: 0)
				(cigarSmoke hide:)
				(self init:)
			)
		)
	)
)

(instance johnTwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 50 100))
			)
			(1
				(cond
					(local17
						(self init:)
					)
					((Random 0 1)
						(= register 1)
						(johnnyLArmP loop: 4 setCycle: ForwardCounter 3 self)
					)
					(else
						(= register 2)
						(johnnyFingers show: setCycle: ForwardCounter 3 self)
					)
				)
			)
			(2
				(switch register
					(1
						(johnnyLArmP loop: 5 cel: 0)
					)
					(2
						(johnnyFingers hide:)
					)
				)
				(= register 0)
				(self init:)
			)
		)
	)
)

(instance johnnyDice of oldSaltDice
	(properties
		view 39
		loop 1
	)
)

(instance oldSaltV of View
	(properties
		y 162
		x 49
		view 239
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[/man]')
				(Print 39 11) ; "Sitting across from you is Jacob Flanagan."
			)
			((Said 'kiss/man')
				(Print 39 12) ; "Maybe Jacob has been at sea a long time, but you haven't!"
			)
		)
	)

	(method (init)
		(super init:)
		(self setPri: 7)
	)
)

(instance johnnyPV of PV
	(properties
		y 176
		x 261
		view 39
		loop 3
		priority 5
	)
)

(instance cButton of Prop
	(properties
		y 36
		x 230
		view 439
		loop 7
		priority 5
	)
)

(instance rButton of Prop
	(properties
		y 36
		x 250
		view 439
		loop 8
		priority 5
	)
)

(instance nButton of Prop
	(properties
		y 36
		x 270
		view 439
		loop 9
		priority 5
	)
)

(instance oldSaltMoney of View
	(properties
		y 122
		x 139
		view 539
		loop 6
		cel 3
	)
)

(instance johnnyMoney of View
	(properties
		y 168
		x 198
		view 539
		loop 7
		cel 3
	)
)

(instance rumBottle of View
	(properties
		y 168
		x 150
		view 439
		loop 6
		priority 13
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/bottle]')
				(Print 39 13) ; "You see a bottle of smooth Alonzo rum on the table."
			)
			((Said 'get[/bottle]')
				(if (gEgo has: 4) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
					(proc0_35) ; "You already took that."
				else
					(Print 39 14) ; ""Don't be taken me bottle, laddie." the old seaman says."
				)
			)
		)
	)
)

(instance johnnyLArmP of Prop
	(properties
		y 93
		x 274
		view 39
		loop 5
	)

	(method (init)
		(super init:)
		(self setPri: 10 stopUpd:)
	)
)

(instance johnnyRArmP of Prop
	(properties
		y 87
		x 227
		view 39
		loop 7
	)

	(method (init)
		(super init:)
		(self setPri: 8 stopUpd:)
	)
)

(instance saltLArmP of Prop
	(properties
		y 113
		x 98
		view 239
		loop 4
	)

	(method (init)
		(super init:)
		(self setPri: 10 stopUpd:)
	)
)

(instance saltRArmP of Prop
	(properties
		y 95
		x 45
		view 239
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 8 stopUpd:)
	)
)

(instance redTumble of Prop
	(properties
		y 125
		x 120
		view 539
		loop 5
	)

	(method (init)
		(self stopUpd:)
		(super init:)
	)
)

(instance redTable of View
	(properties
		y 125
		x 120
		view 539
	)

	(method (init)
		(self stopUpd:)
		(super init:)
	)
)

(instance greenTumble of Prop
	(properties
		y 143
		x 213
		view 439
		loop 5
	)

	(method (init)
		(self stopUpd:)
		(super init:)
	)
)

(instance greenTable of View
	(properties
		y 143
		x 213
		view 439
	)

	(method (init)
		(self stopUpd:)
		(super init:)
	)
)

(instance cigarSmoke of Prop
	(properties
		y 82
		x 91
		view 239
		loop 7
	)
)

(instance johnnyFingers of Prop
	(properties
		y 144
		x 235
		view 39
		loop 8
	)
)

(instance saltMouth of Prop
	(properties
		y 79
		x 85
		view 139
		loop 1
	)
)

(instance saltEyes of Prop
	(properties
		y 74
		x 76
		view 139
		loop 4
	)
)

(instance johnnyMouth of Prop
	(properties
		y 78
		x 235
		view 139
		loop 6
	)
)

(instance johnnyEyes of Prop
	(properties
		y 69
		x 246
		view 139
		loop 5
	)
)

(instance soundDice of Sound
	(properties
		number 76
		priority 2
	)
)

(instance objList of InputList
	(properties)
)

