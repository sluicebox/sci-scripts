;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 87)
(include sci.sh)
(use Main)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm87 0
)

(local
	local0
	local1
	local2
)

(instance rm87 of Rm
	(properties
		noun 7
		picture 87
		style 0
		horizon 50
		north 81
	)

	(method (dispose)
		(SetFlag 77)
		(super dispose:)
	)

	(method (doit)
		(if (> (Abs (- gGameTime local0)) 2)
			(= local0 gGameTime)
			(Palette palANIMATE 237 244 -1 245 252 -1)
		)
		(if
			(and
				(< (gEgo x:) 104)
				(< (gEgo y:) 70)
				(not (gEgo script:))
			)
			(gEgo edgeHit: EDGE_TOP)
			(gCurRoom newRoom: 81)
		)
		(super doit:)
	)

	(method (init)
		(if (and (IsFlag 77) (not (IsFlag 246)))
			(Load rsSOUND (SoundFX 66))
		)
		(Load rsVIEW 87)
		(= local2 0)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 111 76 87 103 57 103 53 112 114 112 123 91 264 93 242 89 144 85 0 31 0 0 319 0 319 189 0 189 0 35
					yourself:
				)
		)
		(super init:)
		(self setFeatures: water rocks trees deadTree formation falls)
		(SolvePuzzle 703 1)
		(gEgo init: setPri: 4 posn: 77 59 setScript: comeOnIn)
		(if (== gEgoGait 2) ; sneaking
			(EgoGait 0) ; walking
			(gMessager say: 7 0 1) ; "You don't want to do that. A walking pace is more appropriate for enjoying the majestic beauty of this scene."
		)
		(if (IsFlag 77)
			(switch (Random 1 2)
				(1
					(if (not (IsFlag 246))
						(periscope setLoop: 7 init: setScript: nessieScript)
						(SetFlag 246)
					)
				)
				(2
					(if (not (IsFlag 288))
						(flipper init: setScript: flippinOut)
					)
					(SetFlag 288)
				)
			)
		)
		(reflection
			ignoreActors: 1
			ignoreHorizon: 1
			setPri: 1
			posn: (gEgo x:) (gEgo y:)
			init:
		)
	)
)

(instance rocks of Feature
	(properties
		x 179
		y 65
		noun 8
		onMeCheck 4
	)
)

(instance formation of Feature
	(properties
		x 268
		noun 4
		onMeCheck 32
	)
)

(instance trees of Feature
	(properties
		x 40
		y 38
		noun 9
		onMeCheck 8
	)
)

(instance deadTree of Feature
	(properties
		x 287
		y 181
		noun 1
		onMeCheck 16
	)
)

(instance water of Feature
	(properties
		x 268
		y 60
		noun 10
		onMeCheck 2
		approachX 262
		approachY 70
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(switch (++ local2)
					(1
						(gEgo setScript: drinkWater)
					)
					(2
						(gMessager say: 10 4 0) ; "Swimming in the Spiegelsee is a bad idea. The lake is fed from mountain run-off, and the water is ice cold."
					)
				)
				(if (== local2 2)
					(= local2 0)
				)
			)
			(21 ; flask
				(gEgo setScript: fillFlask)
			)
			(else
				(if
					(OneOf
						theVerb
						34 ; acorn
						42 ; candelabra
						44 ; candleSticks
						46 ; cheetaurClaw
						16 ; dagger
						38 ; fairyDust
						21 ; flask
						36 ; flowers
						39 ; flyingWater
						32 ; fruit
						29 ; ghostOil
						37 ; greenFur
						22 ; healingPotion
						26 ; brassKey
						14 ; leather
						17 ; lockPick
						27 ; magicGem
						23 ; manaPotion
						31 ; mandrake
						30 ; magicMirror
						40 ; mushroom
						43 ; musicBox
						45 ; pearls
						53 ; paper
						11 ; rations
						28 ; ring
						20 ; rock
						35 ; seed
						15 ; shield
						10 ; silver
						24 ; staminaPotion
						12 ; sword
						18 ; thiefKit
						19 ; thiefLicense
						47 ; trollBeard
						41 ; vase
						33 ; vegetables
					)
					(gMessager say: 10 0 0) ; "That has no effect on the water, try something else."
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance falls of Feature
	(properties
		x 268
		y 60
		noun 2
		onMeCheck 16384
		approachX 262
		approachY 93
	)
)

(instance flipper of Prop
	(properties
		x 291
		y 130
		noun 3
		view 87
		loop 5
	)
)

(instance reflection of Actor
	(properties
		noun 6
		view 87
	)

	(method (doit)
		(self
			loop:
				(cond
					((== (gEgo view:) 510) 4)
					(
						(or
							(== (gEgo loop:) 1)
							(== (gEgo loop:) 5)
							(== (gEgo loop:) 7)
						)
						1
					)
					((== (gEgo loop:) 2) 2)
					((== (gEgo loop:) 3) 3)
					(else 0)
				)
			cel: (gEgo cel:)
			x: (gEgo x:)
			y: (gEgo y:)
			forceUpd:
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 6 1 0) ; "You see your own reflection in the crystal-clear waters."
		else
			(water doVerb: theVerb &rest)
		)
	)
)

(instance periscope of Actor
	(properties
		x 376
		y 72
		noun 5
		view 87
		loop 6
		illegalBits 0
	)
)

(instance comeOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 123 76 self)
			)
			(1
				(gEgo setMotion: MoveTo 114 103 self)
			)
			(2
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance drinkWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (!= (gEgo x:) 262) (!= (gEgo y:) 92))
					(gEgo setMotion: PolyPath 262 93 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo view: 510 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(gMessager say: 7 0 0 1 self) ; "The lake water tastes pretty good, if a bit flat."
				(if (IsFlag 201)
					(gMessager say: 7 0 0 2 self) ; "... but this is not the water you want."
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 0)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fillFlask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (!= (gEgo x:) 262) (!= (gEgo y:) 92))
					(gEgo setMotion: PolyPath 262 93 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo view: 510 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(SetFlag 330)
				(gMessager say: 7 0 0 3 self) ; "You fill a flask with the clear lake water."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 0)
				(NormalEgo)
				(gEgo get: 29 use: 11 1) ; flyingWater, flask
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance nessieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(client setLoop: 6 setCel: 0 setMotion: MoveTo 319 72 self)
				(ShakeScreen 4)
			)
			(2
				(= seconds 6)
			)
			(3
				(client setLoop: 6 setCel: 0 setMotion: MoveTo 376 72 self)
				(ShakeScreen 2)
			)
			(4
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance flippinOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(flipper cycleSpeed: 8 setCycle: CT 1 1 self)
			)
			(2
				(flipper setCel: 1 setCycle: End self)
			)
			(3
				(flipper setCel: 0 setCycle: End self)
			)
			(4
				(flipper dispose:)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance tromp of Sound ; UNUSED
	(properties
		number 66
		priority 1
	)
)

