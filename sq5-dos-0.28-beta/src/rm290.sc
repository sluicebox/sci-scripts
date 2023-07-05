;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use Scaler)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm290 0
)

(local
	[local0 26] = [339 333 327 324 318 309 299 289 277 265 249 233 220 199 177 154 136 119 99 80 61 43 20 -23 -50 -93]
	[local26 26] = [60 63 65 68 71 75 79 83 87 91 96 100 104 108 113 120 122 124 123 122 118 117 113 109 105 100]
	[local52 26] = [84 89 93 97 97 102 106 110 115 119 122 122 111 119 119 119 119 119 119 119 108 108 121 121 121 121]
	[local78 26] = [0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 2 2 2 3 3 4 4 4 4 4 4]
)

(instance rm290 of Rm
	(properties
		picture 54
		style 10
	)

	(method (init)
		(gCurRoom setRegions: 210) ; eureka
		(LoadMany rsVIEW 274 276)
		(gCurRoom setScript: sTrashPickup)
		(super init:)
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance sTrashPickup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(garbageBag init:)
				(gSq5Music2 number: 21 loop: -1 play: 0 fade: 127 10 10 0)
				(= seconds 2)
			)
			(1
				(theMusic3 number: 224 loop: -1 play:)
				(garbageBag setMotion: MoveTo 150 143 self)
				(= register 0)
			)
			(2
				(shipEureka init:)
				(gSq5Music1 number: 225 loop: -1 play: 40 fade: 127 5 25 0)
				(= cycles 1)
			)
			(3
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
					(theMusic3 number: 227 loop: 1 play:)
				)
				(= ticks 4)
			)
			(4
				(gSq5Music1 fade:)
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
			(5
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
			(6
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
			(7
				(gSq5Music2 fade:)
				(theMusic3 dispose:)
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
			cycleSpeed: 12
			scaleSignal: 1
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

