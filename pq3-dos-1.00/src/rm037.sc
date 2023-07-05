;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm037 0
)

(local
	local0 = 1
	local1 = 1
	local2
)

(instance rm037 of PQRoom
	(properties
		picture 37
		north -1
		south -1
		west -1
	)

	(method (init)
		(LoadMany rsVIEW 5 435 436 437)
		(super init:)
		(if (or (>= global105 18) (<= global105 6))
			(gAddToPics add: darkWindow darkFloor eachElementDo: #init doit:)
		)
		(switch gDay
			(1
				(= global105 20)
				(= global106 45)
			)
			(2
				(= global105 15)
			)
			(4
				(= global105 20)
			)
			(5
				(= global105 16)
			)
			(6
				(proc0_17 15)
			)
		)
		(if (== gPrevRoomNum 36)
			(gEgo view: 5 loop: 6 cel: 0 posn: 300 167)
			(partner posn: -10 105)
			(= local2 0)
		else
			(gEgo view: 5 loop: 5 posn: 144 77 setPri: -1)
			(= local2 1)
		)
		(if (IsFlag 195)
			(receptionist loop: 4 x: 111 y: 188 setPri: 14 cycleSpeed: 11 init:)
			(receptionist setScript: animateReceptAtComp)
			(= local0 0)
			(= local1 0)
		else
			(= local0 1)
			(= local1 1)
		)
		(receptionist init:)
		(gEgo cel: 0 init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 173 189 0 189 0 131 0 115 24 132 79 121 104 135 137 130 176 181
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 196 0 319 -1 266 50 133 64 124 75 96 74 45 84 22 55 6 56 19 86 0 91
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 278 54 319 0 319 189 284 189 227 144 217 142 193 134 183 121 183 104 183 96 153 84 201 73
					yourself:
				)
		)
		(if (not (and (== gPrevRoomNum 30) (== gDay 1)))
			(elevatorUpper cycleSpeed: 10 stopUpd: init:)
			(elevatorLower cycleSpeed: 10 stopUpd: init:)
		)
		(gAddToPics add: chair eachElementDo: #init doit:)
		(frontEntrance init:)
		(flowerShop init:)
		(frontDesk init:)
		(computer init:)
		(carpet init:)
		(aisle init:)
		(insideHospital init:)
		(elevatorButton init:)
		(if (== global134 1)
			(partner
				setStep: 3 2
				moveSpeed: 3
				cycleSpeed: 9
				setCycle: SyncWalk
				init:
			)
		)
		(pagingMusic fade: 127 play:)
		(if (== gPrevRoomNum 36)
			(HandsOff)
			(gCurRoom setScript: exitElevatorUpper)
		else
			(gCurRoom setScript: egoEntersHospital)
			(if (== global134 1)
				(partner setScript: partnerEnter)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			(
				(and
					(not (gCast contains: florist))
					(& (gEgo onControl: 1) $0010)
				)
				(HandsOff)
				(gCurRoom setScript: approachFlorist self)
			)
			((& (gEgo onControl: 1) $0008)
				(HandsOff)
				(gCurRoom setScript: outHospital)
			)
		)
		(super doit:)
	)
)

(instance egoEntersHospital of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Walk setMotion: PolyPath 118 83 self)
			)
			(1
				(NormalEgo 5 5)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance outHospital of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 213 67 self)
				(cond
					((and (== global134 1) (partner script:))
						(partner setScript: wait4me)
					)
					((== global134 1)
						(partner setMotion: PolyPath 133 92)
					)
				)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom newRoom: 33)
			)
		)
	)
)

(instance wait4me of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(partner loop: 0)
				(= cycles 1)
			)
			(1
				(if (> (gEgo distanceTo: partner) 90)
					(partner setMotion: 0)
					(= save1 1)
					(Say partner 37 0) ; "Wait up Boss..."
					(= seconds 3)
				else
					(partner setMotion: PolyPath 133 92 self)
				)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom newRoom: 33)
			)
		)
	)
)

(instance partnerEnter of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(partner loop: -1 setMotion: PolyPath 135 92 self)
			)
			(1
				(= save1 1)
				(Say partner 37 1) ; "Yo, Sonny, I think I'll make a phone call while you're upstairs."
				(= seconds 8)
			)
			(2
				(partner setMotion: PolyPath -10 105 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoInElevatorUpper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Walk setMotion: PolyPath 240 172 self)
			)
			(1
				(Face gEgo elevatorButton)
				(= cycles 2)
			)
			(2
				(= seconds 2)
			)
			(3
				(soundFX number: 919 loop: 1 play:)
				(elevatorUpper setCycle: End self)
			)
			(4
				(pagingMusic fade:)
				(gEgo setMotion: PolyPath 228 152 self)
			)
			(5
				(gEgo setMotion: MoveTo 256 142 self)
			)
			(6
				(elevatorUpper setCycle: Beg self)
				(soundFX number: 920 loop: 1 play:)
			)
			(7
				(= cycles 10)
			)
			(8
				(if (IsFlag 195)
					(gCurRoom newRoom: 36)
				else
					(Print 37 2) ; "While contemplating the elevator buttons, you realize that you have no idea what room they moved Marie to."
					(= seconds 1)
				)
			)
			(9
				(client setScript: exitElevatorUpper)
			)
		)
	)
)

(instance egoInElevatorLower of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 269 183 self)
			)
			(1
				(gEgo setHeading: 90)
				(elevatorLower setCycle: End self)
				(soundFX number: 919 loop: 1 play:)
				(pagingMusic fade:)
			)
			(2
				(gEgo setMotion: MoveTo 300 167 self)
			)
			(3
				(elevatorLower setCycle: Beg self)
				(soundFX number: 920 loop: 1 play:)
			)
			(4
				(= cycles 5)
			)
			(5
				(if (IsFlag 195)
					(gCurRoom newRoom: 36)
				else
					(Print 37 2) ; "While contemplating the elevator buttons, you realize that you have no idea what room they moved Marie to."
					(= seconds 1)
				)
			)
			(6
				(client setScript: exitElevatorLower)
			)
		)
	)
)

(instance exitElevatorUpper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 258 y: 142 setHeading: 270)
				(= cycles 3)
			)
			(1
				(elevatorUpper setCycle: End self)
				(soundFX number: 919 loop: 1 play:)
				(pagingMusic play:)
			)
			(2
				(gEgo setMotion: MoveTo 228 152 self)
			)
			(3
				(elevatorUpper setCycle: Beg self)
				(soundFX number: 920 loop: 1 play:)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitElevatorLower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 300 y: 167 setHeading: 270)
				(= cycles 3)
			)
			(1
				(elevatorLower setCycle: End self)
				(soundFX number: 919 loop: 1 play:)
				(pagingMusic play:)
			)
			(2
				(gEgo setMotion: MoveTo 269 183 self)
			)
			(3
				(elevatorLower setCycle: Beg self)
				(soundFX number: 920 loop: 1 play:)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkWithReceptionist of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or local0 local1)
					(gEgo setMotion: PolyPath 112 136 self)
				else
					(gEgo setMotion: PolyPath 176 185 self)
				)
			)
			(1
				(gEgo setHeading: 180)
				(cond
					(local0
						(= state 2)
					)
					(local1
						(= state 5)
					)
					(else
						(= state 11)
					)
				)
				(= cycles 1)
			)
			(2
				(= cycles 1)
			)
			(3
				(= save1 1)
				(Say receptionist 37 3) ; "May I help you, Sir?"
				(= local0 0)
				(= seconds 3)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= state 13)
				(= cycles 1)
			)
			(5
				(= cycles 1)
			)
			(6
				(iEgo init:)
				(= cycles 1)
			)
			(7
				(= save1 1)
				(Say iEgo 37 4) ; "I'm looking for my wife, Marie Bonds. Could you tell me what room she's in, please?"
				(= seconds 8)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iEgo dispose:)
				(= save1 1)
				(Say receptionist 37 5) ; "Oh, yes. Your wife has been moved to room 307."
				(receptionist cycleSpeed: 11 setCycle: End self)
				(= local1 0)
				(SetFlag 195)
			)
			(9
				(SetScore 133 1)
				(= seconds 4)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(client setScript: recpGoToComputer)
			)
			(11
				(= cycles 1)
			)
			(12
				(= save1 1)
				(Print 37 6) ; "The receptionist looks at you blankly."
				(Say receptionist 37 7) ; "Is there something else that you need."
				(= seconds 5)
			)
			(13
				(= cycles 1)
			)
			(14
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance recpGoToComputer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(receptionist
					x: 99
					setLoop: 1
					cycleSpeed: 9
					moveSpeed: 9
					setCycle: End self
				)
			)
			(1
				(receptionist setLoop: 2 cel: 0 x: 100 y: 160)
				(= cycles 1)
			)
			(2
				(receptionist
					setPri: 10
					setCycle: Walk
					setMotion: MoveTo 118 195 self
				)
			)
			(3
				(receptionist
					loop: 3
					cel: 0
					x: 110
					y: 184
					setPri: 12
					cycleSpeed: 11
					setCycle: End self
				)
			)
			(4
				(receptionist loop: 4 x: 111 y: 188 cycleSpeed: 11 setPri: 13)
				(= cycles 1)
			)
			(5
				(client setScript: animateReceptAtComp)
			)
		)
	)
)

(instance animateReceptAtComp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 7))
			)
			(1
				(if (== 0 (Random 0 6))
					(receptionist cel: 0 setCycle: End self)
				else
					(receptionist cel: 10 setCycle: CT 1 1 self)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance approachFlorist of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(florist init:)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say florist 37 8) ; "Can I get you something, Sir?"
				(florMouth setCycle: RandCycle 8 self)
			)
			(2
				(florMouth cel: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance t1 of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(iEgo init:)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say iEgo 37 9) ; "I'm visiting my wife."
				(= seconds 4)
			)
			(2
				(iEgo dispose:)
				(= cycles 1)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(Say florist 37 10) ; "Ah! I'm sorry she's ill. Perhaps a nice fresh flower would cheer her up?"
				(florMouth setCycle: RandCycle 20 self)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(florMouth cel: 0)
				(rose show:)
				(= cycles 1)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local2 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance t2 of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Say florist 37 11) ; "We have lovely roses today. Ladies do like roses."
				(florMouth setCycle: RandCycle 20 self)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(florMouth cel: 0)
				(rose show:)
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance takeRose of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(iEgo init:)
				(Say iEgo 37 12) ; "I think I'd like a rose, please."
				(= seconds 4)
			)
			(1
				(iEgo dispose:)
				(= save1 1)
				(Say florist 37 13) ; "Good choice. Our roses are particularly fresh and beautiful today."
				(florMouth setCycle: RandCycle 22 self)
			)
			(2
				(florMouth cel: 0)
				(= cycles 1)
			)
			(3
				(= save1 1)
				(Say florist 37 14) ; "Here you are, Sir. That'll be $2.50."
				(florMouth setCycle: RandCycle 14 self)
			)
			(4
				(rose cycleSpeed: 11 setCycle: End self)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(florist hide:)
				(= cycles 2)
			)
			(6
				(if
					(and
						(>= ((gInventory at: 19) state:) 1) ; wallet
						(<= ((gInventory at: 19) state:) 4) ; wallet
					)
					(Print 37 15) ; "You pay the florist and take the rose."
					(gEgo get: 36) ; rose
					((gInventory at: 19) state: (- ((gInventory at: 19) state:) 1)) ; wallet, wallet
					(SetScore 134 5)
				else
					(Print 37 16) ; "You realize that you have no money. Red faced, you leave the flower shop without the rose."
				)
				(= seconds 7)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance anotherRose of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(Print 37 17) ; "You buy ANOTHER rose. You note that you're getting very low on cash."
				(= cycles 1)
			)
			(2
				(gEgo get: 36) ; rose
				((gInventory at: 19) state: (- ((gInventory at: 19) state:) 1)) ; wallet, wallet
				(florist hide:)
				(= cycles 1)
			)
			(3
				(if (== ((gInventory at: 19) state:) 0) ; wallet
					(Print 37 18) ; "Geez, you've spent all your money. You hope there's nothing that you need money for later on today."
					(= cycles 1)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance randomTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(switch (Random 0 3)
					(0
						(Say florist 37 19) ; "Too bad it's not Easter. Lilies are wonderful at Easter."
						(florMouth setCycle: RandCycle 23 self)
					)
					(1
						(Say florist 37 20) ; "Of course, buttercups are nice. I'm a sucker for wildflowers."
						(florMouth setCycle: RandCycle 23 self)
					)
					(2
						(Say florist 37 21) ; "Daisies aren't in season right now, or I would have suggested daisies."
						(florMouth setCycle: RandCycle 23 self)
					)
					(3
						(Say florist 37 22) ; "You know, your eyes are the nicest cornflower blue."
						(florMouth setCycle: RandCycle 23 self)
					)
				)
			)
			(1
				(florMouth cel: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance partner of Actor
	(properties
		x 162
		y 80
		lookStr {It's Officer Pat Morales, your partner.}
		view 20
		loop 1
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 37 23) ; "Not now Bonds, I need to make a phone call."
			)
			(5 ; Talk
				(Print 37 23) ; "Not now Bonds, I need to make a phone call."
			)
			(4 ; Inventory
				(switch invItem
					(19 ; wallet
						(Print 37 24) ; "Blow it out your ear, Bonds."
					)
					(else
						(Print 37 25) ; "You hang on to that stuff. I'm not interested in it!"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance doctor of Actor ; UNUSED
	(properties
		x 249
		y 220
		view 402
		loop 1
	)
)

(instance florist of View
	(properties
		x 60
		y 72
		description {the florist}
		lookStr {The florist is a chipper sort, eager to make a sale.}
		view 435
		priority 14
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 37 26) ; "If you want something from the florist, you must pay for it."
			)
			(4 ; Inventory
				(switch invItem
					(19 ; wallet
						(cond
							((gEgo has: 36) ; rose
								(Print 37 27) ; "You already have a rose."
							)
							((== ((gInventory at: 36) state:) 0) ; rose
								(HandsOff)
								(gCurRoom setScript: takeRose)
							)
							(else
								(HandsOff)
								(gCurRoom setScript: anotherRose)
							)
						)
					)
					(2 ; handcuff
						(Print 37 28) ; "Selling flowers isn't a criminal offense!"
					)
					(1 ; gun
						(Print 37 28) ; "Selling flowers isn't a criminal offense!"
					)
					(36 ; rose
						(Print 37 29) ; "The florist already has PLENTY of roses."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(5 ; Talk
				(HandsOff)
				(cond
					((gEgo has: 36) ; rose
						(gCurRoom setScript: randomTalk)
					)
					(local2
						(gCurRoom setScript: t1)
					)
					(else
						(gCurRoom setScript: t2)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (init)
		(self stopUpd:)
		(florMouth x: (self x:) y: (self y:) cycleSpeed: 14 init:)
		(gCast addToFront: rose)
		(rose x: (- (self x:) 21) y: (+ (self y:) 48) init: hide: stopUpd:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(florMouth dispose:)
		(rose dispose:)
		(super dispose:)
	)

	(method (hide)
		(florMouth hide:)
		(rose hide:)
		(super hide:)
	)

	(method (doit)
		(if
			(and
				(gCast contains: florist)
				(not (& (gEgo onControl: 1) $0010))
			)
			(florist dispose:)
		)
		(super doit:)
	)
)

(instance florMouth of Prop
	(properties
		view 435
		loop 1
		priority 14
		signal 16
	)

	(method (doVerb theVerb invItem)
		(florist doVerb: theVerb invItem)
	)
)

(instance rose of Prop
	(properties
		lookStr {It's a rose.}
		view 435
		loop 2
		priority 15
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(19 ; wallet
						(cond
							((gEgo has: 36) ; rose
								(Print 37 27) ; "You already have a rose."
							)
							((== ((gInventory at: 36) state:) 0) ; rose
								(HandsOff)
								(gCurRoom setScript: takeRose)
							)
							(else
								(HandsOff)
								(gCurRoom setScript: anotherRose)
							)
						)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(3 ; Do
				(Print 37 26) ; "If you want something from the florist, you must pay for it."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance iEgo of View
	(properties
		x 207
		y 126
		view 25
		priority 14
		signal 16
	)

	(method (init)
		(self stopUpd:)
		(iEgoMouth x: (iEgo x:) y: (iEgo y:) setCycle: RandCycle init:)
		(iEgoClothes x: (+ (iEgo x:) 3) y: (+ (iEgo y:) 61) init:)
		(iEgoEyes x: (iEgo x:) y: (iEgo y:) init: setScript: egoEyesBlink)
		(super init:)
	)

	(method (dispose)
		(iEgoMouth dispose:)
		(iEgoClothes dispose:)
		(iEgoEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance iEgoMouth of Prop
	(properties
		view 25
		loop 1
		priority 15
		signal 16400
		cycleSpeed 10
	)
)

(instance iEgoClothes of View
	(properties
		view 25
		cel 1
		priority 15
		signal 17
	)
)

(instance iEgoEyes of Prop
	(properties
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(iEgoEyes cel: 1)
				(= cycles 2)
			)
			(2
				(iEgoEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance chitChat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 176 185 self)
			)
			(1
				(Print 37 30) ; "Hi, Sargeant Bonds. Your wife's in room 307."
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance receptionist of Actor
	(properties
		x 98
		y 157
		description {the receptionist}
		lookStr {The receptionist looks friendly enough.}
		view 437
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 37 31) ; "If you want something from the receptionist, just ask her."
			)
			(5 ; Talk
				(HandsOff)
				(if (> gDay 3)
					(self setScript: chitChat)
				else
					(self setScript: talkWithReceptionist)
				)
			)
			(4 ; Inventory
				(switch invItem
					(19 ; wallet
						(if (IsFlag 195)
							(Print 37 32) ; "The receptionist stonily ignores you. You gather that she's used to ignoring people."
						else
							(Print 37 3) ; "May I help you, Sir?"
						)
					)
					(1 ; gun
						(Print 37 33) ; "That's right! Torture Marie's room number out of her!"
					)
					(2 ; handcuff
						(Print 37 33) ; "That's right! Torture Marie's room number out of her!"
					)
					(else
						(Print 37 34) ; "The receptionist isn't interested in that."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chair of PicView
	(properties
		x 108
		y 188
		view 437
		loop 5
		priority 11
		signal 16400
	)
)

(instance elevatorUpper of Prop
	(properties
		x 229
		y 136
		description {the elevator}
		lookStr {It looks like an elevator.}
		view 436
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 37 35) ; "Just press the button. Trying to pry those doors open with your hands will only give you a hernia."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elevatorLower of Prop
	(properties
		x 267
		y 165
		description {the elevator}
		lookStr {It looks like an elevator.}
		view 436
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 37 35) ; "Just press the button. Trying to pry those doors open with your hands will only give you a hernia."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elevatorButton of Feature
	(properties
		x 253
		y 136
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: egoInElevatorUpper)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance frontEntrance of Feature
	(properties
		x 146
		y 54
		description {the front entrance}
		onMeCheck 8
		lookStr {That's the door you came in from.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 37 36) ; "Just walk there."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flowerShop of Feature
	(properties
		x 28
		y 53
		description {the flower shop}
		onMeCheck 4
		lookStr {You notice a flower shop off the lobby.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 37 36) ; "Just walk there."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance computer of Feature
	(properties
		x 91
		y 163
		description {computer}
		onMeCheck 256
		lookStr {It's a computer.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 37 37) ; "If you want something why don't you ask the receptionist?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance frontDesk of Feature
	(properties
		x 91
		y 163
		description {the front desk}
		onMeCheck 32
		lookStr {It's the front desk.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 37 37) ; "If you want something why don't you ask the receptionist?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carpet of Feature
	(properties
		x 179
		y 90
		description {the carpet}
		onMeCheck 2048
		lookStr {The hospital floor is kept spotless.}
	)
)

(instance aisle of Feature
	(properties
		x 79
		y 92
		description {the aisle}
		onMeCheck 2
		lookStr {The hospital floor is waxed and gleaming.}
	)
)

(instance insideHospital of Feature
	(properties
		description {the hospital}
		onMeCheck 16448
		lookStr {The hospital's architecture is stark and modern - a far cry from the dank corridors of the old hospital.}
	)
)

(instance darkWindow of PicView
	(properties
		x 141
		y 90
		view 440
		priority 1
		signal 16401
	)
)

(instance darkFloor of PicView
	(properties
		x 86
		y 116
		view 440
		loop 1
		priority 1
		signal 16401
	)
)

(instance soundFX of Sound
	(properties)
)

(instance pagingMusic of Sound
	(properties
		flags 1
		number 371
		vol 10
		loop -1
	)
)

