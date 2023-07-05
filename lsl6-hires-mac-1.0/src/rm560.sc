;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use fileScr)
(use n082)
(use LarryRoom)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm560 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm560 of LarryRoom
	(properties
		noun 1
		picture 560
		horizon 0
		south 530
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 308 119 280 86 248 59 196 64 108 64 61 108 10 142 173 140 179 136 286 136
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 105 92 134 73 206 73 163 130 137 136 80 124
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 205 90 205 80 247 80 247 90
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 198 121 224 109 263 104 271 109 272 115 245 115 242 119 231 119 228 125 198 125
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 241 126 269 126 272 133 242 133
					yourself:
				)
		)
		(super init: &rest)
		(gEgo
			init:
			normalize:
			setScaler: Scaler 100 82 122 63
			scaleSignal: (| (gEgo scaleSignal:) $0004)
		)
		(if (OneOf gPrevRoomNum 700 570)
			(self setScript: fromDumbWaiterScr)
		else
			(self setScript: enterFromDiningRoomScr)
		)
		(dumbWaiter init:)
		(dwButtons init:)
		(fixPriPoly init:)
		(sink init:)
		(screen init:)
		(tacoTruck init:)
		(truckTire init:)
		(lowTire init:)
		(frige init:)
		(cleaver init:)
		(garbage init:)
		(frigeDoor approachVerbs: 4 5 36 init:) ; Do, Take, washCloth [ wet ]
		(projector setCycle: Fwd init:)
		(if (!= global100 560)
			(gGlobalSound1 number: 560 loop: -1 play:)
		)
		(if (>= (gGame detailLevel:) 3)
			(projectorLight init: setCycle: Fwd)
			(movieSFX number: 564 loop: -1 play:)
		else
			(projector setCycle: 0 setPri: -1)
		)
		(= local4 (gInventory at: 39)) ; washcloth
		(if (== (local4 owner:) gCurRoomNum)
			(= local2 1)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((fixPriPoly onMe: (gEgo x:) (gEgo y:))
				(if (or (not local0) (!= (gEgo priority:) 140))
					(= local0 1)
					(gEgo setPri: 140 fixPriority: 1)
				)
			)
			(local0
				(= local0 0)
				(gEgo setPri: -1 fixPriority: 0)
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		(= local2 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 6) ; Zipper
			(gEgo setScript: pissScr)
			(return 1)
		else
			(return (super doVerb: theVerb))
		)
	)

	(method (edgeToRoom param1)
		(if (== param1 3)
			(gCurRoom setScript: exitScr)
		)
		(return 0)
	)

	(method (newRoom newRoomNumber)
		(if (and (gTimers contains: local3) (local3 isKindOf: Timer))
			(local3 dispose:)
		)
		(if (== newRoomNumber 570)
			(gGlobalSound1 fade: 75 25 10 0)
		else
			(gGlobalSound1 fade:)
		)
		(gEgo scaleSignal: (& (gEgo scaleSignal:) $fffb))
		(fixPriPoly dispose:)
		(gGlobalSound1 fade:)
		(movieSFX stop: dispose:)
		(super newRoom: newRoomNumber)
	)
)

(instance intoWaiter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 219))
					(gMessager say: 14 4 0 0 self) ; "You press the green button on the dumbwaiter's control panel and see the doors slide open. Now, how are you going to fit inside that tiny chamber?"
				else
					(= cycles 2)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gGlobalSound2 number: 573 loop: 1 play:)
				(waiterDoor init: setCycle: End self)
			)
			(3
				(gEgo setSpeed: 6 setMotion: MoveTo 236 62 self)
			)
			(4
				(gEgo setHeading: 0 self)
			)
			(5
				(waiterDoor hide:)
				(gEgo
					setSpeed: 6
					setScale: 0
					view: 567
					loop: 4
					posn: 230 34
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gGame changeScore: 9 219)
				(= ticks 60)
			)
			(7
				(gCurRoom newRoom: 570)
			)
		)
	)
)

(instance useSinkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 565
					setLoop: 1
					setCel: 0
					posn: 30 62
					setSpeed: 6
					setScale: 0
					setCycle: Fwd
				)
				(gGlobalSound2 number: 634 loop: -1 play:)
				(= ticks 300)
			)
			(1
				(gGlobalSound2 stop:)
				(gEgo
					posn: (sink approachX:) (sink approachY:)
					normalize: 900 8
					setCel: 1
					setScaler: Scaler 100 82 122 63
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wetWashclothScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo
					setScale: 0
					setSpeed: 8
					view: 567
					setLoop: 1
					setCel: 0
					posn: 30 62
					setCycle: End self
				)
			)
			(2
				(= register (gEgo cel:))
				(gGlobalSound2 number: 634 loop: -1 play:)
				(gEgo view: 565 setLoop: 0 setCel: 0 setCycle: Fwd)
				(= ticks 180)
			)
			(3
				(gGlobalSound2 stop:)
				(gEgo
					view: 567
					setLoop: 1
					setCel: register
					setCycle: Beg self
				)
			)
			(4
				(= ticks 20)
			)
			(5
				((gInventory at: 39) cue:) ; washcloth
				(gEgo
					posn: (sink approachX:) (sink approachY:)
					normalize: 900 8
					setScaler: Scaler 100 82 122 63
					setCel: 1
				)
				(= cycles 2)
			)
			(6
				(gGame changeScore: 6 250)
				(gMessager say: 3 35 0 0 self) ; "There. It's soaking wet!"
			)
			(7
				(gGame handsOn:)
				((gTheIconBar curIcon:) select:)
				(self dispose:)
			)
		)
	)
)

(instance inflateBeaverScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 7 48 0 1 self) ; "Cleverly realizing the truck's tire is a source of pressurized air, you press the beaver's inflator onto the tire's valve stem."
			)
			(1
				(= ticks 10)
			)
			(2
				(gEgo
					view: 561
					loop: 1
					cel: 0
					setSpeed: 14
					setCycle: End self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(gGlobalSound2 number: 563 loop: 1 play:)
				(gEgo loop: 2 cel: 0 setCycle: CT 8 1 self)
			)
			(5
				(= ticks 30)
			)
			(6
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(7
				(= ticks 20)
			)
			(8
				(gGame changeScore: 14 223)
				((= temp0 (gInventory at: 2)) ; beaver
					noun: 16
					message: 49
					view: 51
					setCursor: 51 0 0
					yourself:
				)
				(if (not (& (temp0 signal:) $0004))
					(temp0 signal: (| (temp0 signal:) $0004))
					(DeleteScreenItem temp0)
				)
				(gInventory show:)
				(= cycles 2)
			)
			(9
				(gMessager say: 7 48 0 2 self) ; "I hope that was good for you, too!"
			)
			(10
				(gEgo normalize: 900 8 1 cel: 5)
				(gGame handsOn:)
				((gTheIconBar curIcon:) select:)
				(self dispose:)
			)
		)
	)
)

(instance cleanFilterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame changeScore: 10 220)
				(gEgo
					setScale: 0
					view: 568
					setLoop: 0
					setCel: 0
					setSpeed: 10
					setCycle: End self
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo setLoop: 2 setCel: 0 setCycle: Fwd)
				(= ticks 240)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(7
				(suckFilter init: setCycle: End self)
			)
			(8
				(suckFilter dispose:)
				(gEgo
					normalize: 900 8
					setScaler: Scaler 100 82 122 63
					setCel: 3
					put: 13 ; filter
				)
				(= cycles 2)
			)
			(9
				(gEgo setSpeed: 6 setMotion: MoveTo 73 116 self)
				(dishWasherSFX number: 562 loop: -1 play:)
				(dishwasher init: setCycle: Fwd)
				(= ticks 360)
			)
			(10
				(gEgo setHeading: 315)
			)
			(11
				((gInventory at: 13) cue:) ; filter
				(dishwasher setCycle: End self)
			)
			(12
				(dishWasherSFX stop: dispose:)
				(dishwasher dispose:)
				(shinnyFilter init: setCycle: End self)
				(gEgo setHeading: 0)
			)
			(13
				(gEgo setMotion: MoveTo 96 80 self)
			)
			(14
				(= cycles 2)
			)
			(15
				(gEgo
					view: 568
					setLoop: 5
					setCel: 0
					setCycle: 0
					setScale: 0
					setPri: 33
				)
				(shinnyFilter dispose:)
				(= cycles 2)
			)
			(16
				(gEgo get: 13 setCycle: End self) ; filter
			)
			(17
				(gEgo
					normalize: 900 8
					setCel: 2
					setScaler: Scaler 100 82 122 63
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openFrigeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 901
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: CT 3 1 self
				)
			)
			(1
				(gEgo setCycle: End self)
				(gGlobalSound2 number: 566 loop: 1 play:)
				(frigeDoor setCycle: End self)
			)
			(2 0)
			(3
				(gEgo normalize: 900 8 1 cel: 0)
				(if (and (gTimers contains: local3) (local3 isKindOf: Timer))
					(local3 dispose:)
				)
				(= local1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance digInTrashScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound2 number: 568 loop: 1 play:)
				(gEgo
					view: 567
					setLoop: 3
					cel: 0
					setSpeed: 10
					setCycle: End self
				)
			)
			(1
				(gEgo normalize: 900 8 1 cel: 6)
				(= cycles 2)
			)
			(2
				(gMessager
					say:
						9
						4
						(cond
							((IsFlag 277) 8)
							((not (SetFlag 81)) 7)
							(else 6)
						)
						0
						self
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)
)

(instance tireDeathScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 566
					setLoop: 0
					cel: 0
					posn: 205 123
					setSpeed: 12
					setScale: 0
					setPri: 200
				)
				(= ticks 30)
			)
			(1
				(gGlobalSound2 number: 563 loop: 1 play:)
				(gEgo setCycle: CT 3 1 self)
			)
			(2
				(gEgo setSpeed: 5 yStep: 2 setMotion: MoveTo 250 1 self)
				(= ticks 40)
			)
			(3
				(gEgo yStep: 3 setSpeed: 4 cel: (+ (gEgo cel:) 1))
				(= ticks 40)
			)
			(4
				(gEgo yStep: 4 setSpeed: 3 cel: (+ (gEgo cel:) 1))
				(= ticks 30)
			)
			(5
				(gEgo moveSpeed: 2 cycleSpeed: 10)
				(gEgo cel: (+ (gEgo cel:) 1))
				(= ticks 20)
			)
			(6
				(gEgo moveSpeed: 1)
				(gEgo setCycle: End)
			)
			(7
				(gEgo hide:)
				(= cycles 2)
			)
			(8
				(= ticks 120)
			)
			(9
				(gGlobalSound1 pause:)
				(EgoDead 14 self)
			)
			(10
				(gGlobalSound1 pause: 0)
				(gEgo
					show:
					normalize: 900 8 1
					cel: 1
					posn: (truckTire approachX:) (truckTire approachY:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance takeLardScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGlobalSound2 number: 568 loop: 1 play:)
				(gEgo
					view: 567
					setLoop: 3
					setCel: 0
					setSpeed: 10
					setCycle: End self
				)
			)
			(2
				(gGame changeScore: 6 277)
				(gEgo normalize: 900 8 1 cel: 6 get: 24) ; lard
				(= cycles 2)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance touchPissScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo view: 901 setCycle: 0 loop: 5 cel: 0)
				(= ticks 20)
			)
			(3
				(gEgo setCycle: CT 3 1 self)
			)
			(4
				(gMessager say: 15 0 0 0 self) ; "It's damp. It's yellow. It appeared right after you peed behind the truck..."
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo normalize: 900 8 1 cel: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pissPuddle of Prop
	(properties
		noun 15
		approachX 190
		approachY 106
		x 180
		y 100
		view 560
		loop 4
		cycleSpeed 20
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1)
	)

	(method (doVerb)
		(self setScript: touchPissScr)
	)
)

(instance pissScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 147 70 self)
			)
			(1
				(= ticks 60)
			)
			(2
				(zipperSFX play: self)
				(= ticks 60)
			)
			(3 0)
			(4
				(pissSFX play:)
				(= ticks 120)
			)
			(5
				(pissPuddle
					init:
					approachVerbs: 4 1 2 5 6 -1 ; Do, Look, Talk, Take, Zipper, ???
					setCycle: End self
				)
			)
			(6
				(pissSFX stop: dispose:)
				(= ticks 60)
			)
			(7
				(zipperSFX play: self)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 15)
						(+ (gEgo y:) 50)
						self
				)
			)
			(1
				(gCurRoom newRoom: 530)
			)
		)
	)
)

(instance fromDumbWaiterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setCycle: 0
					setSpeed: 6
					view: 567
					setLoop: 4
					setScale: 0
					posn: 230 34
				)
				(gEgo cel: (gEgo lastCel:))
				(if (IsFlag 104)
					(ClearFlag 104)
					(waiterDoor setLoop: 2 setPri: 35)
					(= ticks 180)
				else
					(gEgo setPri: 35)
					(+= state 2)
					(= cycles 2)
				)
				(waiterDoor cel: (waiterDoor lastCel:) init:)
			)
			(1
				(gGlobalSound2 number: 573 loop: 1 play:)
				(waiterDoor setCycle: Beg self)
			)
			(2
				(waiterDoor setLoop: 1 cel: (waiterDoor lastCel:) setPri: 33)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					normalize: 900 8
					cel: 3
					posn: 236 62
					setScaler: Scaler 100 82 122 62
				)
				(= ticks 20)
			)
			(5
				(gEgo setMotion: MoveTo 246 61 self)
			)
			(6
				(gEgo setHeading: 0 self)
			)
			(7
				(= ticks 45)
			)
			(8
				(gGlobalSound2 number: 574 loop: 1 play:)
				(waiterDoor setCycle: Beg self)
			)
			(9
				(waiterDoor dispose:)
				(= cycles 2)
			)
			(10
				(gEgo setHeading: 180 self)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromDiningRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 47 187 setMotion: MoveTo 77 134 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockOnWaiterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 96 0) self 1) ; knockOnDoorScr
			)
			(1
				(gMessager say: 13 4 0 0 self) ; "You bang on the door, never noticing the control panel right beside the dumbwaiter."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getWashclothScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo
					setSpeed: 8
					view: 901
					loop: 0
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(if local2
					((ScriptID 85 4) ; wTimer
						setReal:
							((gInventory at: 39) noun: 52 message: 37 yourself:) ; washcloth
							0
							15
					)
					(gGame changeScore: 3 222)
				)
				(gEgo get: 39 setCycle: End self) ; washcloth
			)
			(3
				(gEgo normalize: 900 8 1 cel: 0)
				(= cycles 2)
			)
			(4
				(if local2
					(gMessager say: 8 5 3 0 self) ; "Your washcloth is now nice and cold. How refreshing!"
				else
					(gMessager say: 8 5 4 0 self) ; "You remove the still-warm washcloth. Too bad you didn't leave it in long enough to do any good."
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance chillWashclothScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo
					setSpeed: 8
					view: 901
					loop: 0
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(gGame changeScore: 6 221)
				(gEgo put: 39 gCurRoomNum setCycle: End self) ; washcloth
			)
			(3
				(gEgo normalize: 900 8 1 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeFrigeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 901
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: CT 3 1 self
				)
			)
			(1
				(gEgo setCycle: End)
				(frigeDoor setCycle: Beg self)
			)
			(2
				(gGlobalSound2 number: 567 loop: 1 play:)
				(= cycles 2)
			)
			(3
				(gEgo normalize: 900 8 1 cel: 0)
				(frigeDoor cel: 0)
				(if
					(and
						(== (local4 owner:) gCurRoomNum)
						(!= (local4 message:) 37)
					)
					(= local3 (Timer setReal: gCurRoom 60))
				)
				(= local1 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance frigeDoor of Prop
	(properties
		approachX 268
		approachY 77
		x 280
		y 77
		view 560
		cycleSpeed 10
	)

	(method (init)
		(self setPri: 60)
		(super init:)
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if (== (param1 message:) 4)
				(if local1
					(= approachX 274)
					(= approachY 83)
					(= sightAngle 0)
				else
					(= approachX 266)
					(= approachY 76)
					(= sightAngle 40)
				)
			else
				(= approachX 268)
				(= approachY 77)
				(= sightAngle 40)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb)
		(frige doVerb: theVerb)
	)
)

(instance dishwasher of Prop
	(properties
		x 33
		y 55
		view 565
		loop 8
	)
)

(instance belt of Prop ; UNUSED
	(properties
		x 39
		y 72
		view 565
		loop 3
		cel 5
	)
)

(instance projector of Prop
	(properties
		noun 5
		x 108
		y 24
		priority 199
		fixPriority 1
		view 562
		detailLevel 3
	)
)

(instance suckFilter of Prop
	(properties
		x 39
		y 72
		view 565
		loop 3
	)
)

(instance shinnyFilter of Prop
	(properties
		x 40
		y 60
		priority 50
		fixPriority 1
		view 568
		loop 6
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1)
	)
)

(instance waiterDoor of Prop
	(properties
		x 228
		y 34
		view 564
		loop 1
		signal 16417
	)
)

(instance waiterDoor2 of Prop ; UNUSED
	(properties
		x 238
		y 45
		view 564
		loop 1
		signal 16417
	)
)

(instance projectorLight of Prop
	(properties
		x 90
		y 28
		priority 198
		fixPriority 1
		view 562
		loop 1
		cel 1
	)
)

(instance dwButtons of Feature
	(properties
		noun 14
		sightAngle 40
		approachX 246
		approachY 61
		x 246
		y 57
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 250 36 248 44 241 44 243 36
					yourself:
				)
			approachVerbs: 4 ; Do
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: intoWaiter)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance cleaver of Feature
	(properties
		noun 11
		sightAngle 40
		x 228
		y 84
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 231 56 241 56 236 73 223 73
					yourself:
				)
		)
	)
)

(instance frige of Feature
	(properties
		noun 8
		sightAngle 40
		approachX 268
		approachY 77
		x 275
		y 77
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if (== (param1 message:) 4)
				(if local1
					(= approachX 274)
					(= approachY 83)
					(= sightAngle 0)
				else
					(= approachX 266)
					(= approachY 76)
					(= sightAngle 40)
				)
			else
				(= approachX 268)
				(= approachY 77)
				(= sightAngle 40)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					init: 263 66 266 17 301 28 317 45 305 114
					yourself:
				)
			approachVerbs: 4 5 36 ; Do, Take, washCloth [ wet ]
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if local1
					(gCurRoom setScript: closeFrigeScr)
				else
					(gCurRoom setScript: openFrigeScr)
				)
			)
			((== theVerb 5) ; Take
				(cond
					((not local1)
						(gMessager say: noun theVerb 2) ; "Many humans open the refrigerator before trying to take something from it."
					)
					((== (local4 owner:) gCurRoomNum)
						(gCurRoom setScript: getWashclothScr)
					)
					(else
						(gMessager say: noun theVerb 5) ; "You just can't face taking any of this year-old food. Look somewhere else for what you need!"
					)
				)
			)
			((== theVerb 36) ; washCloth [ wet ]
				(if local1
					(gCurRoom setScript: chillWashclothScr)
				else
					(gMessager say: noun theVerb 2) ; "The refrigerator door is still closed."
				)
			)
			((OneOf theVerb 37 35 2) ; washCloth [ chilled ], washcloth, Talk
				(gMessager say: noun theVerb)
			)
			(local1
				(gMessager say: noun 0 1) ; "Four large refrigerators nearly fill the wall. Some idiot left one of the doors wide open!"
			)
			(else
				(gMessager say: noun 0 2) ; "Four large refrigerators nearly fill the wall."
			)
		)
	)
)

(instance dumbWaiter of Feature
	(properties
		noun 13
		nsLeft 228
		nsTop 28
		nsRight 240
		nsBottom 45
		sightAngle 40
		approachX 233
		approachY 61
		x 233
		y 60
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: knockOnWaiterScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance dishWasher of Feature
	(properties
		noun 2
		approachX 64
		approachY 113
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					init: 39 82 39 68 71 53 83 54 86 66 53 92 39 83
					yourself:
				)
			approachVerbs: 32 ; filter
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; filter
				(gCurRoom setScript: cleanFilterScr)
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "La Costa Lotta hasn't used this old dishwasher in years, ever since they switched to that modern closed-cell extruded polystyrene-based plate-like substitute!"
			)
			(2 ; Talk
				(gMessager say: noun theVerb) ; "There's currently no one inside the dishwasher that wants to speak to you."
			)
			(else
				(sink doVerb: theVerb)
			)
		)
	)
)

(instance sink of Feature
	(properties
		noun 3
		sightAngle 40
		approachX 64
		approachY 113
		x 28
		y 112
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if (== (param1 message:) 32)
				(self approachX: 45 approachY: 118)
			else
				(self approachX: 64 approachY: 113)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					init: 28 101 21 90 24 75 33 73 37 85 45 93 29 102
					yourself:
				)
			approachVerbs: 35 4 ; washcloth, Do
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; filter
				(dishWasher doVerb: theVerb)
			)
			(35 ; washcloth
				(gCurRoom setScript: wetWashclothScr)
			)
			(4 ; Do
				(gCurRoom setScript: useSinkScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen of Feature
	(properties
		noun 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) init: 10 74 1 0 90 0 87 31 89 38 yourself:)
		)
		(super init: &rest)
	)
)

(instance tacoTruck of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 184
		approachY 121
		x 143
		y 85
	)

	(method (onMe param1)
		(return
			(if (super onMe: param1)
				(if (== (param1 message:) 48)
					(self approachVerbs: 48) ; beaver
				else
					(= _approachVerbs 0)
				)
				1
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					init: 94 122 91 91 104 78 94 46 100 41 112 43 125 41 137 30 131 17 200 16 189 91 152 133
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 48) ; beaver
			(truckTire doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lowTire of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 195
		approachY 97
		x 184
		y 90
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					init: 189 72 191 90 179 96 177 89 175 81
					yourself:
				)
			approachVerbs: 4 1 2 5 6 48 ; Do, Look, Talk, Take, Zipper, beaver
		)
	)
)

(instance truckTire of Feature
	(properties
		noun 7
		sightAngle 40
		x 184
		y 121
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					init: 159 96 167 109 161 123 149 125 149 106
					yourself:
				)
			approachVerbs: 48 4 ; beaver, Do
		)
		(super init: &rest)
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if (== (param1 message:) 4)
				(= approachX 162)
				(= approachY 128)
			else
				(= approachX 184)
				(= approachY 121)
			)
			(return 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48 ; beaver
				(gCurRoom setScript: inflateBeaverScr)
			)
			(4 ; Do
				(gCurRoom setScript: tireDeathScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance garbage of Feature
	(properties
		noun 9
		sightAngle 40
		approachX 248
		approachY 136
		x 256
		y 130
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 4 5 1 ; Do, Take, Look
			setPolygon:
				((Polygon new:)
					init: 204 108 209 102 231 92 255 96 267 107 257 138 220 138 208 124
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: digInTrashScr)
			)
			(1 ; Look
				(gMessager
					say:
						noun
						theVerb
						(cond
							((IsFlag 277) 8)
							((not (IsFlag 81)) 7)
							(else 6)
						)
				)
			)
			(5 ; Take
				(cond
					((IsFlag 277)
						(gMessager say: noun theVerb 8) ; "There's nothing else in these trash cans worth taking."
					)
					((IsFlag 81)
						(gCurRoom setScript: takeLardScr)
					)
					(else
						(gMessager say: noun theVerb 7) ; "Carrying around a trash can won't improve your "dig-ability quotient" with the babes!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fixPriPoly of Polygon
	(properties)

	(method (init)
		(super init: 158 125 170 75 207 75 191 125)
	)
)

(instance movieSFX of Sound
	(properties
		flags 1
	)
)

(instance dishWasherSFX of Sound
	(properties
		flags 1
	)
)

(instance zipperSFX of Sound
	(properties
		flags 1
		number 1035
	)
)

(instance pissSFX of Sound
	(properties
		flags 1
		number 1030
		loop -1
	)
)

