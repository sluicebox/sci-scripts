;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Interface)
(use SoundSyncWave)
(use n824)
(use n954)
(use LoadMany)
(use RFeature)
(use Game)
(use Actor)

(public
	beachHuts3 0
)

(instance beachHuts3 of Rm
	(properties
		picture 12
		east 13
		south 16
		west 2
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 12 112)
		(gAddToPics add: beachLayer1 beachLayer2 eachElementDo: #init doit:)
		(self
			setRegions: 301 300 ; Water, tahiti
			setFeatures:
				jungleFeat
				palmTree
				hutDoor
				eastWindowFeat
				middleWindowFeat
				westWindowFeat
		)
		((Clone wave) x: 277 y: 177 init:)
		((Clone wave) x: 231 y: 182 loop: 1 init:)
		((Clone wave) x: 290 y: 151 loop: 2 init:)
		((Clone wave) x: 205 y: 168 loop: 2 init:)
		((Clone wave) x: 107 y: 189 loop: 2 init:)
		(wave init:)
		(gEgo init:)
		(switch gPrevRoomNum
			(west
				(gEgo x: 10)
			)
			(east
				(gEgo x: 310)
			)
			(9 ; hotelEntrance
				(gEgo x: 10 y: 105)
			)
			(south
				(gEgo y: 187)
			)
			(else
				(gEgo posn: 160 100)
			)
		)
		(proc824_0)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<around,at][/room,beach]')
				(Print 12 0) ; "You see a beautiful stretch of beach with one hut."
			)
			((Said 'look[<at]/building')
				(Print 12 1) ; "You see a hut on the beach."
			)
			((Said 'look[<at]/people')
				(Print 12 2) ; "Many people come to this island paradise for relaxation."
			)
		)
	)
)

(instance hutDoor of RFeature
	(properties
		y 52
		x 150
		nsTop 29
		nsLeft 139
		nsBottom 75
		nsRight 162
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 12 3) ; "This is the door to hut #2."
					)
					((GoToIfSaid self event 148 82 0 12 4))
					((Said 'open')
						(Print 12 5) ; "This door is locked."
					)
					((Said 'unlock')
						(if (gEgo has: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
							(Print 12 6) ; "You try to unlock the door, but your key doesn't work."
						else
							(Print 12 7) ; "You don't have a key."
						)
					)
					((Said 'knock')
						(Print 12 8) ; "There is no answer."
					)
				)
			)
		)
	)
)

(instance beachLayer1 of RPicView
	(properties
		y 147
		x 138
		view 12
		loop 1
		cel 2
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/woman]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 12 9) ; "You didn't know they made them like that any more."
					)
					((Said 'talk')
						(Print 12 10) ; "She seems to be asleep."
					)
					((Said 'wake,kick')
						(Print 12 11) ; "She wouldn't appreciate that."
					)
					((Said 'kiss')
						(Print 12 12) ; "Buzz off!"
					)
				)
			)
			((Said 'look/towel')
				(Print 12 13) ; "A beach towel."
			)
			((Said 'kick/sand')
				(Print 12 14) ; "Only beach brutes do that."
			)
		)
	)
)

(instance beachLayer2 of RPicView
	(properties
		y 147
		x 114
		view 12
		loop 1
		cel 1
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/man,people]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 12 15) ; "He's just lying there."
					)
					((Said 'talk')
						(Print 12 16) ; "He doesn't seem to hear you."
					)
					((Said 'wake,kick')
						(Print 12 17) ; "Why would you do that?"
					)
					((Said 'kiss')
						(Print 12 12) ; "Buzz off!"
					)
				)
			)
		)
	)
)

(instance wave of SoundSyncWave
	(properties
		y 167
		x 315
		view 112
		cycleSpeed 3
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/wave]')
				(Print 12 18) ; "These are gentle waves."
			)
		)
	)

	(method (init)
		(super init:)
		(self sound: gIceGlobalSound)
	)
)

(instance westWindowFeat of RFeature
	(properties
		y 34
		x 180
		z 21
		heading 240
		nsTop 33
		nsLeft 170
		nsBottom 54
		nsRight 190
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 12 19) ; "A hut window."
					)
					((Said 'look<in')
						(Print 12 20) ; "The reflection on the window prevents you from looking in."
					)
				)
			)
		)
	)
)

(instance middleWindowFeat of RFeature
	(properties
		y 65
		x 220
		z 21
		heading 150
		nsTop 34
		nsLeft 205
		nsBottom 55
		nsRight 235
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 12 19) ; "A hut window."
					)
					((Said 'look<in')
						(Print 12 20) ; "The reflection on the window prevents you from looking in."
					)
				)
			)
		)
	)
)

(instance eastWindowFeat of RFeature
	(properties
		y 65
		x 268
		z 27
		heading 150
		nsTop 34
		nsLeft 250
		nsBottom 55
		nsRight 285
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 12 19) ; "A hut window."
					)
					((Said 'look<in')
						(Print 12 20) ; "The reflection on the window prevents you from looking in."
					)
				)
			)
		)
	)
)

(instance jungleFeat of Feature
	(properties
		y 70
		x 70
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/bush,palm]')
				(Print 12 21) ; "You see a dense jungle."
			)
		)
	)
)

(instance palmTree of RFeature
	(properties
		y 123
		x 13
		nsTop 10
		nsLeft 7
		nsBottom 125
		nsRight 21
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/palm]')
				(Print 12 22) ; "The palm tree is of no interest to you."
			)
		)
	)
)

