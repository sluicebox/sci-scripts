;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 894)
(include sci.sh)
(use Main)
(use Interface)
(use PolyPath)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	elevator 0
	elevBut 1
)

(local
	local0
	local1
	[local2 4] = [12 15 18 24]
	[local6 4] = [3 12 11 5]
	[local10 4] = [206 120 120 196]
	[local14 4] = [109 73 75 108]
	[local18 4] = [42 108 111 55]
	[local22 4] = [92 33 33 87]
	[local26 4] = [21 65 68 33]
	[local30 4] = [84 51 54 87]
	[local34 4] = [27 144 147 89]
	[local38 4] = [115 50 50 113]
	[local42 4] = [70 139 139 88]
	[local46 4] = [87 45 47 76]
	[local50 4] = [56 140 140 73]
	[local54 4] = [106 50 50 95]
	[local58 4] = [67 157 157 91]
	local62
	local63
)

(instance elevator of Rgn
	(properties)

	(method (init &tmp temp0)
		(super init:)
		(elevSound init:)
		(for ((= temp0 0)) (<= temp0 3) ((++ temp0))
			(if (== gCurRoomNum [local2 temp0])
				(= local62 temp0)
				(break)
			)
		)
		(elevBut
			view: [local10 temp0]
			posn: [local14 temp0] [local18 temp0]
			setPri: [local6 temp0]
			init:
		)
		(if (or (== local62 0) (== local62 3))
			(elevBut setPri: -1)
		)
		(elevDoor
			view: [local10 temp0]
			posn: [local30 temp0] [local34 temp0]
			init:
		)
		(= local63 (elevDoor2 x:))
		(if (or (== local62 1) (== local62 2))
			(if (== local62 2)
				(elevDoor2 posn: (= local63 23) 148)
			)
			(elevDoor2 init:)
			(elevDoor xStep: 6)
		)
		(= local1 (Random 0 3))
		(indicator
			view: [local10 temp0]
			posn: [local22 temp0] [local26 temp0]
			cel: local1
			setPri: [local6 temp0]
			init:
		)
		(= global110 fromElevator12)
		(= global111 fromElevator15)
		(= global112 elevDoor)
	)

	(method (doit &tmp temp0)
		(if script 0)
		(super doit:)
	)
)

(instance elevatorScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not (& (gEgo onControl: 1) $2000)) (== state 7))
			(self changeState: 12)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath [local38 local62] [local42 local62] self
				)
			)
			(1
				(elevBut cel: 1 forceUpd:)
				(gEgo loop: 3)
				(= cycles 5)
			)
			(2
				(if (!= local1 local62)
					(elevSound number: 370 play:)
					(indicator loop: 2 cel: local1 forceUpd:)
					(cond
						((< local1 local62)
							(++ local1)
						)
						((> local1 local62)
							(-- local1)
						)
					)
				else
					(= state 3)
				)
				(= cycles 25)
			)
			(3
				(indicator loop: 3 forceUpd:)
				(= state 1)
				(= seconds 3)
			)
			(4
				(elevSound number: 370 play:)
				(indicator loop: 2 cel: local1 forceUpd:)
				(if (or (== local62 1) (== local62 2))
					(elevDoor setMotion: MoveTo -10 (elevDoor y:) self)
					(elevDoor2 setMotion: MoveTo -10 (elevDoor2 y:) self)
				else
					(elevDoor setCycle: End self)
					(= state 5)
				)
				(elevSound number: 919 play:)
			)
			(5)
			(6
				(elevBut cel: 0 forceUpd:)
				(elevDoor stopUpd:)
				(gEgo
					setMotion: MoveTo [local46 local62] [local50 local62] self
				)
			)
			(7
				(gEgo setPri: 1 loop: 2)
				(HandsOn)
				(if (== gCurRoomNum 24)
					(button1 x: 38)
					(button2 x: 38)
					(button3 x: 38)
					(buttonG x: 38)
					(plate x: 40)
				)
				(button1 init:)
				(button2 init:)
				(button3 init:)
				(buttonG init:)
				(plate init:)
			)
			(8
				(gEgo
					setMotion: MoveTo [local46 local62] [local50 local62] self
				)
			)
			(9
				(if (== local0 gCurRoomNum)
					(Print 894 0) ; "You boob! You're already there!"
					(buttonG cel: 0)
					(button1 cel: 0)
					(button2 cel: 0)
					(button3 cel: 0)
					(= state 6)
					(= cycles 1)
				else
					(elevSound number: 920 play:)
					(HandsOff)
					(if (or (== local62 1) (== local62 2))
						(elevDoor
							setMotion:
								MoveTo
								[local30 local62]
								(elevDoor y:)
								self
						)
						(elevDoor2
							setMotion: MoveTo local63 (elevDoor2 y:) self
						)
					else
						(elevDoor setCycle: Beg self)
						(= state 10)
					)
				)
			)
			(10)
			(11
				(gCurRoom newRoom: local0)
			)
			(12
				(HandsOff)
				(gEgo
					setMotion: PolyPath [local54 local62] [local58 local62] self
				)
			)
			(13
				(elevSound number: 920 play:)
				(if (or (== local62 1) (== local62 2))
					(elevDoor
						setMotion: MoveTo [local30 local62] (elevDoor y:) self
					)
					(elevDoor2 setMotion: MoveTo local63 (elevDoor2 y:) self)
				else
					(elevDoor setCycle: Beg self)
					(= state 14)
				)
				(gEgo setPri: -1)
				(plate dispose:)
				(button1 dispose:)
				(button2 dispose:)
				(button3 dispose:)
				(buttonG dispose:)
			)
			(14)
			(15
				(HandsOn)
				(elevDoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance fromElevator12 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(indicator cel: (= local1 local62))
				(HandsOff)
				(= cycles 5)
			)
			(1
				(elevDoor setCycle: End self)
				(elevSound number: 919 play:)
			)
			(2
				(elevDoor stopUpd:)
				(switch local62
					(0
						(gEgo setMotion: MoveTo 108 72 self)
					)
					(else
						(gEgo setPri: -1 setMotion: MoveTo 113 90 self)
					)
				)
			)
			(3
				(elevDoor setCycle: Beg self)
				(gEgo setPri: -1)
				(elevSound number: 920 play:)
			)
			(4
				(elevDoor stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fromElevator15 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(indicator cel: (= local1 local62))
				(HandsOff)
				(= cycles 5)
			)
			(1
				(elevDoor setMotion: MoveTo -10 (elevDoor y:) self)
				(elevDoor2 setMotion: MoveTo -10 (elevDoor2 y:) self)
				(elevSound number: 919 play:)
			)
			(2)
			(3
				(elevDoor stopUpd:)
				(elevDoor2 stopUpd:)
				(gEgo setMotion: MoveTo 47 164 self)
			)
			(4
				(gEgo setPri: -1)
				(elevDoor
					setMotion: MoveTo [local30 local62] (elevDoor y:) self
				)
				(elevDoor2 setMotion: MoveTo local63 (elevDoor2 y:) self)
				(elevSound number: 920 play:)
			)
			(5)
			(6
				(elevDoor stopUpd:)
				(elevDoor2 stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance elevBut of Prop
	(properties
		description {Elevator Button}
		lookStr {That's the elevator button.}
		view 206
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((and (IsObject gTrunk) (gTrunk showing:)) 0)
					((IsFlag 16)
						(Print 894 1) ; "Prisoners are not allowed upstairs."
					)
					((IsFlag 5)
						(Print 894 2) ; "Prisoners aren't allowed upstairs - especially half-naked ones!"
					)
					((& (gEgo onControl: 0) $2000)
						(Print 894 3) ; "You already have the elevator's complete attention."
					)
					(else
						(HandsOff)
						(self setScript: elevatorScript)
					)
				)
			)
			(4 ; Inventory
				(Print 894 4) ; "Its amazing how buttons - like that one - are so ideally suited to the human HAND."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elevDoor of Actor
	(properties
		description {Elevator Door}
		lookStr {The elevator provides access to the other floors of the police station.}
		view 206
		priority 2
		signal 22545
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 894 5) ; "Just press the button. Trying to pry those doors open with your hands will only give you a hernia."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elevDoor2 of Actor
	(properties
		x 20
		y 145
		description {Elevator Door}
		lookStr {That's the elevator door.}
		view 120
		cel 1
		priority 2
		signal 22545
		cycleSpeed 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 894 5) ; "Just press the button. Trying to pry those doors open with your hands will only give you a hernia."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance button1 of Prop
	(properties
		x 138
		y 80
		z 21
		description {First Floor}
		view 121
		loop 1
		priority 15
		signal 16401
		cycleSpeed 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(= local0 15)
				(self cel: 1)
				(elevatorScript cycles: 1)
				(elevSound number: 370 play:)
			)
			(4) ; Inventory
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance button2 of Prop
	(properties
		x 138
		y 80
		z 35
		description {Second Floor}
		view 121
		loop 2
		priority 15
		signal 16401
		cycleSpeed 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(= local0 18)
				(self cel: 1)
				(elevatorScript cycles: 1)
				(elevSound number: 370 play:)
			)
			(4) ; Inventory
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance button3 of Prop
	(properties
		x 138
		y 80
		z 49
		description {Third Floor}
		view 121
		loop 3
		priority 15
		signal 16401
		cycleSpeed 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(= local0 24)
				(self cel: 1)
				(elevatorScript cycles: 1)
				(elevSound number: 370 play:)
			)
			(4) ; Inventory
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buttonG of Prop
	(properties
		x 138
		y 80
		z 7
		description {Ground Floor}
		view 121
		priority 15
		signal 16401
		cycleSpeed 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(= local0 12)
				(self cel: 1)
				(elevatorScript cycles: 1)
				(elevSound number: 370 play:)
			)
			(4) ; Inventory
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance indicator of Prop
	(properties
		description {Floor Indication}
		view 120
		loop 2
		priority 14
		signal 16401
	)
)

(instance plate of Prop
	(properties
		x 140
		y 80
		description {plate}
		view 121
		loop 4
		priority 15
		signal 16401
	)
)

(instance elevSound of Sound
	(properties)
)

