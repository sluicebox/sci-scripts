;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use Scaler)
(use MoveFwd)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm280 0
)

(local
	[local0 26] = [339 333 327 324 318 309 299 289 277 265 249 233 220 199 177 154 136 119 99 80 61 43 20 -23 -50 -93]
	[local26 26] = [60 63 65 68 71 75 79 83 87 91 96 100 104 108 113 120 122 124 123 122 118 117 113 109 105 100]
	[local52 26] = [84 89 93 97 97 102 106 110 115 119 122 122 111 119 119 119 119 119 119 119 108 108 121 121 121 121]
	[local78 26] = [0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 2 2 2 3 3 4 4 4 4 4 4]
)

(instance rm280 of Rm
	(properties
		picture 53
		style 10
	)

	(method (init)
		(gCurRoom setRegions: 210) ; eureka
		(LoadMany rsVIEW 274 275 276)
		(garbageBag init:)
		(gCurRoom setScript: sTrashPickup)
		(super init:)
	)

	(method (dispose)
		(PalVary pvUNINIT)
		(super dispose: &rest)
	)
)

(instance sTrashPickup of Script
	(properties)

	(method (doit)
		(switch state
			(1
				(if (== (PalVary pvGET_CURRENT_STEP) 64)
					(self cue:)
				)
			)
			(2
				(if (>= (PalVary pvGET_CURRENT_STEP) 32)
					(self cue:)
				)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music2 number: 21 loop: -1 play: 0 fade: 127 10 10 0)
				(= seconds 2)
			)
			(1
				(PalVary pvUNINIT)
				(PalVary pvINIT 532 4)
			)
			(2
				(PalVary pvUNINIT)
				(PalVary pvINIT 533 4)
			)
			(3
				(starBurst init: cel: 0 cycleSpeed: 15 setCycle: CT 6 1 self)
			)
			(4
				(starBurst setCycle: CT 8 1 self)
			)
			(5
				(if (< (PalVary pvGET_CURRENT_STEP) 64)
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(PalVary pvUNINIT)
				(PalVary pvINIT 534 4)
				(= cycles 6)
			)
			(7
				(starBurst
					setCel: 9
					x: 109
					y: 125
					heading: 45
					setStep: 1 1
					setMotion: MoveFwd 245
				)
				(= seconds 2)
			)
			(8
				(garbageBag setMotion: MoveTo 150 143 self)
				(= register 0)
			)
			(9
				(shipEureka init:)
				(gSq5Music1 number: 225 loop: -1 play: 40 fade: 127 5 20 0)
				(= cycles 1)
			)
			(10
				(shipEureka
					cel: [local78 register]
					x: [local0 register]
					y: [local26 register]
					scaleX: [local52 register]
					scaleY: [local52 register]
				)
				(if (< (++ register) 15)
					(-- state)
				else
					(gSq5Music1 number: 227 loop: 1 play:)
				)
				(= ticks 4)
			)
			(11
				(shipEureka
					cel: [local78 register]
					x: [local0 register]
					y: [local26 register]
					scaleX: [local52 register]
					scaleY: [local52 register]
				)
				(garbageBag dispose:)
				(= ticks 4)
				(++ register)
			)
			(12
				(shipEureka
					cel: [local78 register]
					x: [local0 register]
					y: [local26 register]
					scaleX: [local52 register]
					scaleY: [local52 register]
				)
				(++ register)
				(= ticks 4)
			)
			(13
				(shipEureka
					cel: [local78 register]
					x: [local0 register]
					y: [local26 register]
					scaleX: [local52 register]
					scaleY: [local52 register]
				)
				(++ register)
				(if (< register 26)
					(-- state)
				)
				(= ticks 4)
			)
			(14
				(gSq5Music1 fade:)
				(gSq5Music2 fade:)
				(gCurRoom newRoom: 201)
				(self dispose:)
			)
		)
	)
)

(instance shipEureka of View
	(properties
		x 319
		y 60
		view 276
		priority 6
		signal 24592
	)
)

(instance garbageBag of Actor
	(properties
		x -25
		y 198
		view 274
		priority 8
		signal 16400
	)

	(method (init)
		(self
			setLoop: 0
			cel: 0
			scaleSignal: 1
			moveSpeed: 6
			cycleSpeed: 10
			setStep: 1 1
			setCycle: End self
			setScale: Scaler 100 35 169 143
		)
		(super init: &rest)
	)

	(method (cue)
		(switch loop
			(0
				(self setLoop: 1 cel: 0 setCycle: End self)
			)
			(1
				(self setLoop: 0 cel: 0 setCycle: End self)
			)
		)
	)
)

(instance starBurst of Actor
	(properties
		x 100
		y 134
		view 275
		priority 2
		signal 24592
	)
)

