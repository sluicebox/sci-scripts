;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use n102)
(use Teller)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm60 0
)

(local
	[local0 10] = [0 10 -11 -6 4 12 -3 -2 -9 999]
	[local10 3] = [0 7 999]
	[local13 3] = [0 8 999]
	[local16 8]
	[local24 4] = [0 -11 -6 999]
	local28
	local29
	local30
	local31 = 1000
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	[local41 2]
	local43
)

(class Script_ of Script
	(properties
		register2 -1
	)
)

(class Apple of Actor
	(properties
		noun 1
		view 61
	)
)

(instance rm60 of Rm
	(properties
		noun 7
		picture 60
		style 0
	)

	(method (init)
		(= [local16 0] @local0)
		(= [local16 1] @local13)
		(= [local16 2] @local10)
		(= [local16 3] 999)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 94 226 94 193 83 115 83 68 95 43 104 43 136 85 163 300 163 300 130 319 130 319 189 0 189 0 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 139 88 169 88 169 99 139 99
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 95 106 132 106 132 114 95 114
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 55 120 89 120 89 133 56 133
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 128 116 164 116 164 127 128 127
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 193 118 227 118 227 126 193 126
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 236 99 272 99 272 109 236 109
					yourself:
				)
		)
		(super init:)
		(= local29 2)
		(NormalEgo)
		(gEgo init: posn: 318 120 setMotion: MoveTo 306 120)
		(bossRock
			init:
			approachVerbs:
				4 ; Do
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
		(rock1
			init:
			approachVerbs:
				4 ; Do
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
		(rock2
			init:
			approachVerbs:
				4 ; Do
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
		(rock3
			init:
			approachVerbs:
				4 ; Do
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
		(rock4
			init:
			approachVerbs:
				4 ; Do
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
		(rock5
			init:
			approachVerbs:
				4 ; Do
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
		(bossEyes init: setLoop: 3 z: 1000)
		(meepEyes2 init: setLoop: 3 z: 1000)
		(meepEyes3 init: setLoop: 3 z: 1000)
		(meepTeller init: bossMeep @local0 @local16 @local24)
		(bossMeep
			init:
			actions: meepTeller
			z: 1000
			approachVerbs:
				4 ; Do
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
			setScript: meepScript1
		)
		(meep2
			init:
			z: 1000
			approachVerbs:
				4 ; Do
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
			setScript: meepScript2
		)
		(meep3
			init:
			z: 1000
			approachVerbs:
				4 ; Do
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
			setScript: meepScript3
		)
		(upperRocks init:)
		(trees init:)
		(grass init:)
		(lowerRocks init:)
		(Load rsSCRIPT 991)
		(Load rsSCRIPT 160)
		(Lock rsVIEW 60 1)
	)

	(method (newRoom newRoomNumber)
		(DisposeScript 160)
		(Lock rsVIEW 60 0)
		(super newRoom: newRoomNumber)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; dagger
				(gMessager say: 7 0 24) ; "You don't need to do that."
				(= local30 1)
			)
			(2 ; Talk
				(if local30
					(gMessager say: 7 2 21) ; "You can't talk to any of the Meeps. They are all hiding deep within their holes, terrified after your vicious attack."
				)
			)
			(1 ; Look
				(cond
					(local30
						(gMessager say: 7 1 21) ; "All of the Meeps are hiding deep within their holes. Your vicious attack has them terrified."
					)
					((not (Random 0 3))
						(gMessager say: 7 1 23) ; "You are in the Meeps' Peep. The colorful, furry Meeps timidly pop out of their holes from time to time."
					)
					(else
						(gMessager say: 7 1 22) ; "You see blue Meeps, purple Meeps, and occasionally a green Meep. They seem to be very shy; whenever you approach one, it hides under its rock."
					)
				)
			)
			(20 ; rock
				(= local30 1)
				(ThrowRock 0)
			)
			(50 ; detectMagicSpell
				(gMessager say: 7 50) ; "You detect no other magic here."
			)
			(51 ; openSpell
				(gMessager say: 7 51) ; "The Open spell only works on locks and small closed things."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((== (gEgo edgeHit:) 2)
				(HandsOff)
				(gCurRoom setScript: sExitEast)
			)
		)
		(if (!= local32 (GetTime 1)) ; SysTime12
			(= local32 (GetTime 1)) ; SysTime12
			(if
				(and
					(== local43 2)
					(not local33)
					(or
						(gEgo mover:)
						(not (-- local31))
						(== (gEgo script:) getTheFur)
					)
				)
				(bossMeep setScript: sByeBoss)
			)
		)
	)
)

(instance upperRocks of Feature
	(properties
		x 150
		y 43
		noun 8
		nsBottom 86
		nsRight 301
		sightAngle 40
		onMeCheck 2
	)
)

(instance lowerRocks of Feature
	(properties
		x 159
		y 170
		noun 8
		nsTop 140
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; dagger
				(gMessager say: 7 0 24) ; "You don't need to do that."
				(= local30 1)
			)
			(1 ; Look
				(gMessager say: 8 1) ; "The mountains are very steep here."
			)
			(4 ; Do
				(= local31 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance grass of Feature
	(properties
		x 168
		y 68
		noun 5
		nsTop 68
		nsLeft 22
		nsBottom 163
		nsRight 315
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; dagger
				(gMessager say: 7 0 24) ; "You don't need to do that."
				(= local30 1)
			)
			(1 ; Look
				(gEgo setScript: lookAtGrass)
			)
			(4 ; Do
				(cond
					((== local37 1)
						(= local37 0)
						(= local38 1)
						(gEgo setScript: getTheFur)
					)
					((== local35 1)
						(= local35 0)
						(gEgo setScript: sGetScroll)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trees of Feature
	(properties
		x 159
		y 94
		noun 10
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; dagger
				(gMessager say: 7 0 24) ; "You don't need to do that."
				(= local30 1)
			)
			(1 ; Look
				(gMessager say: 10 1) ; "The trees and bushes look much like those you've seen elsewhere in the valley."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fur of View
	(properties
		x 173
		y 105
		noun 4
		view 61
		loop 8
		priority 1
		signal 26624
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; dagger
				(gMessager say: 7 0 24) ; "You don't need to do that."
				(= local30 1)
			)
			(1 ; Look
				(gMessager say: 4 1) ; "There is a wad of bright green fur on the ground."
			)
			(4 ; Do
				(gEgo setScript: getTheFur)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rock1 of Prop
	(properties
		x 74
		y 231
		z 100
		noun 8
		approachX 71
		approachY 117
		view 60
		loop 6
		priority 9
		signal 18448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; dagger
				(gMessager say: 7 0 24) ; "You don't need to do that."
				(= local30 1)
			)
			(2 ; Talk
				(if local30
					(gMessager say: 7 2 21) ; "You can't talk to any of the Meeps. They are all hiding deep within their holes, terrified after your vicious attack."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(1 ; Look
				(if local30
					(gMessager say: 7 1 21) ; "All of the Meeps are hiding deep within their holes. Your vicious attack has them terrified."
				else
					(gMessager say: 8 1) ; "The mountains are very steep here."
				)
			)
			(4 ; Do
				(HandsOff)
				(gEgo posn: 71 125)
				(= local29 2)
				(self setScript: sLiftRock)
			)
			(12 ; sword
				(if local30
					(gMessager say: 8 12) ; "No way! Those Meeps are too fast and the rocks too hard for you to want to try that again!"
				else
					(self setScript: sStabRock)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rock2 of Prop
	(properties
		x 115
		y 214
		z 100
		noun 8
		approachX 114
		approachY 100
		view 60
		loop 7
		priority 7
		signal 18448
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(HandsOff)
			(gEgo posn: 113 108)
			(= local29 3)
			(self setScript: sLiftRock)
		else
			(rock1 doVerb: theVerb &rest)
		)
	)
)

(instance rock3 of Prop
	(properties
		x 147
		y 226
		z 100
		noun 8
		approachX 145
		approachY 113
		view 60
		loop 7
		priority 8
		signal 18448
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(HandsOff)
			(gEgo posn: 145 120)
			(= local29 3)
			(self setScript: sLiftRock)
		else
			(rock1 doVerb: theVerb &rest)
		)
	)
)

(instance rock4 of Prop
	(properties
		x 211
		y 226
		z 100
		noun 8
		approachX 208
		approachY 113
		view 60
		loop 6
		priority 8
		signal 18448
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(HandsOff)
			(gEgo posn: 208 120)
			(= local29 2)
			(self setScript: sLiftRock)
		else
			(rock1 doVerb: theVerb &rest)
		)
	)
)

(instance rock5 of Prop
	(properties
		x 256
		y 207
		z 100
		noun 8
		approachX 254
		approachY 94
		view 60
		loop 7
		priority 7
		signal 18448
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(HandsOff)
			(gEgo posn: 254 101)
			(= local29 3)
			(self setScript: sLiftRock)
		else
			(rock1 doVerb: theVerb &rest)
		)
	)
)

(instance bossEyes of Prop
	(properties
		x 155
		y 182
		z 100
		noun 3
		view 60
		priority 6
		signal 18448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 3 1) ; "You keep seeing differently-colored Meeps come out of each hole. They either lead to large underground caverns, or they are all connected under the earth."
			)
			(else
				(meep3 doVerb: theVerb &rest)
			)
		)
	)
)

(instance meepEyes2 of Prop
	(properties
		x 73
		y 216
		z 100
		noun 6
		view 60
	)

	(method (doVerb theVerb)
		(bossEyes doVerb: theVerb &rest)
	)
)

(instance meepEyes3 of Prop
	(properties
		x 73
		y 216
		z 100
		view 60
	)

	(method (doVerb theVerb)
		(bossEyes doVerb: theVerb &rest)
	)
)

(instance meep2 of Prop
	(properties
		x 73
		y 231
		z 100
		noun 6
		view 60
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if local43
					(gMessager say: 6 2 13) ; "Hey, just ask me about anything you want to know."
					(return 1)
				else
					(gCurRoom setScript: sBossOut)
				)
			)
			(1 ; Look
				(gMessager say: 6 1 0 2) ; "There seems to be an abundant supply of blue and purple Meeps. If only they'd stay still for a moment, you'd be able to count them."
			)
			(4 ; Do
				(cond
					((== (gEgo x:) (rock1 approachX:))
						(rock1 doVerb: theVerb &rest)
					)
					((== (gEgo x:) (rock5 approachX:))
						(rock5 doVerb: theVerb &rest)
					)
					(else
						(gMessager say: 6 4) ; "The Meep scrambles back into its hole as you try to touch it."
					)
				)
			)
			(16 ; dagger
				(gMessager say: 7 0 24) ; "You don't need to do that."
				(= local30 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance meep3 of Prop
	(properties
		x 73
		y 231
		z 100
		noun 6
		view 60
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; dagger
				(gMessager say: 7 0 24) ; "You don't need to do that."
				(= local30 1)
			)
			(2 ; Talk
				(if local43
					(gMessager say: 6 2 13) ; "Hey, just ask me about anything you want to know."
					(return 1)
				else
					(gCurRoom setScript: sBossOut)
				)
			)
			(1 ; Look
				(gMessager say: 6 1 0 2) ; "There seems to be an abundant supply of blue and purple Meeps. If only they'd stay still for a moment, you'd be able to count them."
			)
			(4 ; Do
				(cond
					((== (gEgo x:) (rock2 approachX:))
						(rock2 doVerb: theVerb &rest)
					)
					((== (gEgo x:) (rock3 approachX:))
						(rock3 doVerb: theVerb &rest)
					)
					((== (gEgo x:) (rock4 approachX:))
						(rock4 doVerb: theVerb &rest)
					)
					(else
						(gMessager say: 6 4) ; "The Meep scrambles back into its hole as you try to touch it."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll of Actor
	(properties
		noun 9
		view 61
		loop 5
		signal 26624
	)

	(method (cue)
		(super cue:)
		(self setCycle: 0 setCel: 0 stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; dagger
				(gMessager say: 7 0 24) ; "You don't need to do that."
				(= local30 1)
			)
			(1 ; Look
				(gMessager say: 9 1) ; "It looks like a Spell Scroll."
			)
			(4 ; Do
				(gEgo setScript: sGetScroll)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance apple2 of Actor
	(properties
		y 160
		noun 6
		view 61
		loop 6
		priority 1
		signal 26640
	)

	(method (cue)
		(super cue:)
		(self setCycle: 0 ignoreActors: 1 addToPic:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 5 2) ; "Hey, like, we eat them, you know."
			)
			(16 ; dagger
				(gMessager say: 7 0 24) ; "You don't need to do that."
				(= local30 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance baby of Actor
	(properties
		y 100
		noun 2
		view 61
		loop 7
		signal 26624
	)
)

(instance bossRock of Actor
	(properties
		x 155
		y 198
		z 100
		approachX 155
		approachY 87
		view 60
		loop 5
		priority 5
		signal 18448
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local43
				(gEgo setMotion: 0)
				(bossMeep setScript: sByeBoss)
			else
				(HandsOff)
				(= local29 0)
				(gEgo posn: 154 92)
				(self setScript: sLiftRock)
			)
		else
			(rock1 doVerb: theVerb &rest)
		)
	)
)

(instance sStabRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local30 1)
				(gEgo
					setMotion:
						PolyPath
						(+ (client approachX:) 25)
						(+ (client approachY:) 10)
						self
				)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo view: 518 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(gEgo setLoop: 3 setCycle: Fwd)
				(= seconds 4)
			)
			(4
				(gEgo setLoop: 2 setCel: 6 setCycle: Beg self)
			)
			(5
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sLiftRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 180)
				(= ticks 20)
			)
			(1
				(if (& (client signal:) $0080)
					(-- state)
				)
				(= ticks 20)
			)
			(2
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 62
					setLoop: 1
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(3
				(client hide:)
				(gEgo setLoop: local29 setCel: 0 setCycle: End self)
			)
			(4
				(gEgo setLoop: 1 setCel: 1 setCycle: Beg self)
				(client show:)
			)
			(5
				(NormalEgo)
				(gEgo
					posn: (client approachX:) (client approachY:)
					setLoop: 2
					cycleSpeed: register
				)
				(= cycles 2)
			)
			(6
				(HandsOn)
				(gEgo setLoop: -1)
				(= local29 2)
				(self dispose:)
			)
		)
	)
)

(instance sThrowStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 300)
			)
			(1
				(= register 4)
				(bossMeep setCycle: CT 4 -1 self)
			)
			(2
				(bossMeep setPri: 5 setCycle: Beg self)
			)
			(3
				(= ticks 25)
			)
			(4
				(if (not (-- register))
					(= cycles 2)
				else
					(bossMeep setLoop: 0 setCel: 0)
					(cond
						((and (not local35) (not local36))
							(self changeState: 40)
						)
						((and (not local40) (not (Random 0 1)))
							(self changeState: 20)
						)
						(else
							(self changeState: 10)
						)
					)
				)
			)
			(5
				(bossMeep setLoop: 2 setCel: 1 setCycle: CT 4 1 self)
			)
			(6
				(bossMeep setPri: 6 setCycle: End self)
			)
			(7
				(HandsOn)
				(= local33 0)
				(self dispose:)
			)
			(10
				(bossMeep setCel: 1)
				(= local34 1)
				((= local28 (Apple new:))
					init:
					setLoop: 6
					ignoreActors: 1
					setCel: 0
					posn: 159 96
					setPri: 1
				)
				(= cycles 5)
			)
			(11
				(bossMeep setCel: 2)
				(local28 setCel: 1 posn: 165 87 setCycle: Fwd)
				(= cycles 2)
			)
			(12
				(local28
					setCycle: End
					setMotion: JumpTo (Random 148 230) (Random 110 114) self
				)
				(bossMeep setCel: 1)
			)
			(13
				(if (> (local28 x:) 205)
					(local28
						setMotion: JumpTo (Random 230 292) (Random 138 142) self
					)
				else
					(local28
						setMotion: JumpTo (Random 127 216) (Random 139 157) self
					)
				)
			)
			(14
				(local28 setCycle: 0 setMotion: 0)
				(self changeState: 4)
			)
			(20
				(= local40 1)
				(bossMeep setCel: 1)
				(baby init: setPri: 8 posn: 166 88)
				(= ticks 4)
			)
			(21
				(bossMeep setCel: 2)
				(baby setStep: 8 8 setMotion: MoveTo 164 57 self)
			)
			(22
				(baby setPri: -1 setMotion: MoveTo 174 119 self)
			)
			(23
				(baby setCycle: Fwd setScript: sBaby)
				(bossMeep setLoop: 2 setCel: 1 setCycle: CT 4 1 self)
			)
			(24
				(bossMeep setPri: 6 setCycle: End self)
			)
			(25
				(HandsOn)
				(= local33 0)
				(self dispose:)
			)
			(30
				(= local34 1)
				(bossMeep setCel: 1)
				(apple2 init: posn: 159 96 setPri: 1 setCel: 0)
				(= cycles 5)
			)
			(31
				(bossMeep setCel: 2)
				(apple2
					posn: 165 87
					setCycle: Fwd
					setStep: 6 6
					moveSpeed: 0
					setMotion: MoveTo 169 24 self
				)
			)
			(32
				(apple2 setMotion: MoveTo 166 117 self)
			)
			(33
				(apple2
					setMotion: JumpTo (Random 171 233) (Random 106 119) apple2
				)
			)
			(34
				(self changeState: 5)
			)
			(40
				(bossMeep setCel: 1)
				(scroll init: posn: 161 85 setPri: 1 setCel: 1)
				(= local35 1)
				(= cycles 5)
			)
			(41
				(bossMeep setCel: 2)
				(scroll
					posn: 170 81
					setCycle: Fwd
					setStep: 6 6
					moveSpeed: 0
					setMotion: JumpTo 247 139 scroll
				)
				(= ticks 20)
			)
			(42
				(scroll setCycle: 0)
				(bossMeep setLoop: 2 setCel: 1 setCycle: CT 4 1 self)
			)
			(43
				(bossMeep setPri: 6 setCycle: End self)
			)
			(44
				(HandsOn)
				(= local33 0)
				(self dispose:)
			)
		)
	)
)

(instance babySqueak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 3 8))
				(meepSound loop: 1 number: 74 play:)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance sBaby of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: babySqueak)
				(= seconds (Random 3 5))
			)
			(1
				(baby
					setStep: 2 2
					setCycle: Fwd
					setMotion: PolyPath 129 87 self
				)
			)
			(2
				(= ticks 10)
			)
			(3
				(baby setMotion: PolyPath 158 89 self)
			)
			(4
				(baby dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(DisposeScript 991)
				(gCurRoom newRoom: 61)
			)
		)
	)
)

(instance sPullFur of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local33 1)
				(= ticks 320)
			)
			(1
				(bossMeep
					setLoop: 4
					setCel: 0
					cycleSpeed: 10
					setCycle: CT 8 1 self
				)
			)
			(2
				(fur init:)
				(bossMeep setCycle: End self)
			)
			(3
				(bossMeep setLoop: 2 setCel: 255)
				(HandsOn)
				(meepTeller stuffArray: (WordAt (meepTeller arrays:) 0) 0)
				(= local37 1)
				(= local33 0)
				(self dispose:)
			)
		)
	)
)

(instance getTheFur of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				(gEgo setMotion: PolyPath 183 105 self)
			)
			(2
				(gEgo
					view: 510
					setLoop: 1
					setCel: 0
					setPri: (+ (fur priority:) 1)
					setCycle: End self
				)
			)
			(3
				(gMessager say: 7 0 15 1 self) ; "You pick up the green fur."
			)
			(4
				(SolvePuzzle 681 5)
				(gEgo get: 27) ; greenFur
				(fur dispose:)
				(self cue:)
			)
			(5
				(gEgo setPri: -1 setCycle: Beg self)
			)
			(6
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookAtGrass of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 5 1 0 1 self) ; "The meadow is covered with a light carpet of grass, broken up by the Meep holes."
			)
			(1
				(if (and (== local37 1) (not local38))
					(gMessager say: 5 1 1 1 self) ; "There is a wad of bright green fur on the ground."
				else
					(self cue:)
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bossMeep of Actor
	(properties
		x 155
		y 201
		z 100
		noun 6
		approachX 155
		approachY 87
		view 60
		loop 2
		priority 5
		signal 18448
	)
)

(instance meepSound of Sound
	(properties
		number 55
		priority 30
	)
)

(instance meepScript1 of Script
	(properties)

	(method (dispose)
		(= state 0)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local43
					(self dispose:)
				else
					(= ticks (Random 100 300))
				)
			)
			(1
				(cond
					(local43
						(self dispose:)
					)
					((or local30 (<= (gEgo distanceTo: bossRock) 130))
						(self init:)
					)
					(else
						(meepSound loop: 1 number: (+ (Random 0 2) 55) play:)
						(bossMeep
							z: 100
							setCel: 0
							cycleSpeed: (Random 5 10)
							setCycle: End self
						)
						(bossRock z: 1000)
					)
				)
			)
			(2
				(bossEyes setCycle: Fwd z: 100)
				(if local43
					(= cycles 2)
				else
					(= ticks (Random 20 40))
				)
			)
			(3
				(if local43
					(= register 3)
				else
					(= register (Random 5 10))
				)
				(bossEyes z: 1000)
				(bossMeep cycleSpeed: register setCycle: Beg self)
			)
			(4
				(bossRock z: 100)
				(bossMeep z: 1000)
				(if local43
					(= cycles 2)
				else
					(= ticks 20)
				)
			)
			(5
				(self init:)
			)
		)
	)
)

(instance meepScript3 of Script_
	(properties)

	(method (dispose)
		(= state 0)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 1 3))
				(= cycles 2)
			)
			(1
				(if local43
					(self dispose:)
				else
					(switch register
						(1
							(meep3
								setLoop: 1
								posn: 114 217
								setPri: (rock2 priority:)
							)
							(meepEyes3 posn: 114 198)
						)
						(2
							(meep3
								setLoop: 0
								posn: 210 226
								setPri: (rock4 priority:)
							)
							(meepEyes3 posn: 210 211)
						)
						(3
							(meep3
								setLoop: 1
								posn: 146 230
								setPri: (rock3 priority:)
							)
							(meepEyes3 posn: 146 211)
						)
					)
					(= ticks (Random 75 200))
				)
			)
			(2
				(switch register
					(1
						(if
							(or
								(<= (gEgo distanceTo: rock2) 130)
								(rock2 script:)
								local30
							)
							(self init:)
						else
							(meep3
								approachX: (rock2 approachX:)
								approachY: (rock2 approachY:)
							)
							(rock2 hide:)
							(self cue:)
						)
					)
					(2
						(if
							(or
								(<= (gEgo distanceTo: rock4) 130)
								(rock4 script:)
								local30
							)
							(self init:)
						else
							(meep3
								approachX: (rock4 approachX:)
								approachY: (rock4 approachY:)
							)
							(rock4 hide:)
							(self cue:)
						)
					)
					(3
						(if
							(or
								(<= (gEgo distanceTo: rock3) 130)
								(rock3 script:)
								local30
							)
							(self init:)
						else
							(meep3
								approachX: (rock3 approachX:)
								approachY: (rock3 approachY:)
							)
							(rock3 hide:)
							(self cue:)
						)
					)
				)
			)
			(3
				(if local43
					(= register2 3)
				else
					(= register2 (Random 5 10))
				)
				(meepSound loop: 1 number: (+ (Random 0 2) 55) play:)
				(meep3
					z: 100
					setCel: 0
					cycleSpeed: register2
					setCycle: End self
				)
			)
			(4
				(meepEyes3 setCycle: Fwd setPri: (+ (meep3 priority:) 1) z: 100)
				(if local43
					(= cycles 2)
				else
					(= ticks (Random 20 40))
				)
			)
			(5
				(if local43
					(= register2 3)
				else
					(= register2 (Random 5 10))
				)
				(meepEyes3 z: 1000)
				(meep3 cycleSpeed: register2 setCycle: Beg self)
			)
			(6
				(switch register
					(1
						(rock2 show:)
					)
					(2
						(rock4 show:)
					)
					(3
						(rock3 show:)
					)
				)
				(meep3 z: 1000)
				(self init:)
			)
		)
	)
)

(instance meepTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; dagger
				(gMessager say: 7 0 24) ; "You don't need to do that."
				(= local30 1)
			)
			(2 ; Talk
				(if local43
					(SolvePuzzle 680 1)
					(super doVerb: theVerb)
				else
					(bossMeep approachVerbs: 0)
					(gCurRoom setScript: sBossOut)
				)
			)
			(1 ; Look
				(if local30
					(gMessager say: 7 1 21) ; "All of the Meeps are hiding deep within their holes. Your vicious attack has them terrified."
				else
					(gMessager say: 6 1) ; "You realize that you have never seen more than one green Meep at a time. Perhaps there is only one."
				)
			)
			(4 ; Do
				(bossMeep setScript: sThrowStuff)
			)
			(else
				(bossRock doVerb: theVerb &rest)
			)
		)
		(return 1)
	)

	(method (showDialog &tmp temp0)
		(if
			(==
				(= temp0
					(super
						showDialog:
							12
							local35
							-3
							local40
							-2
							local34
							-9
							(and (not (IsFlag 228)) (not local35))
							7
							(not local37)
					)
				)
				-3
			)
			(= temp0 (Abs temp0))
		)
		(if (== temp0 -2)
			(= temp0 (Abs temp0))
		)
		(if (and (== temp0 7) (not local37) (not local38) (not (IsFlag 227)))
			(SetFlag 227)
			(bossMeep setScript: sPullFur)
		)
		(if (== temp0 -9)
			(bossMeep setScript: sThrowStuff)
			(= temp0 (Abs temp0))
		)
		(if (== temp0 -999)
			(HandsOff)
			(bossMeep setScript: sByeBoss)
		)
		(return temp0)
	)

	(method (doChild)
		(if (== query -6)
			(if local37
				(return query)
			else
				(super doChild: query)
			)
		else
			(super doChild: query)
		)
	)
)

(instance sByeBoss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local43 0)
				(if (not (== (gEgo script:) getTheFur))
					(gEgo setMotion: 0)
				)
				(bossMeep setCycle: CT 4 -1 self)
			)
			(1
				(bossMeep setPri: 5 setCycle: CT 1 -1 self)
			)
			(2
				(= ticks 10)
			)
			(3
				(bossRock z: 1000)
				(bossMeep setLoop: 9 setCel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(4
				(if (not (== (gEgo script:) getTheFur))
					(HandsOn)
				)
				(bossRock
					setLoop: 5
					posn: 155 198 100
					setCel: 0
					setPri: 5
					z: 100
				)
				(bossMeep
					view: 60
					setLoop: 2
					setPri: 5
					posn: 155 201 100
					z: 1000
					actions: 0
					approachVerbs:
						4 ; Do
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
					setScript: meepScript1
				)
				(meep2 setScript: meepScript2)
				(meep3 setScript: meepScript3)
				(self dispose:)
			)
		)
	)
)

(instance sBossOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local43 1)
				(= cycles 2)
			)
			(1
				(if
					(and
						(== (meepScript3 state:) 0)
						(== (meepScript2 state:) 0)
						(== (meepScript1 state:) 0)
					)
					(= cycles 2)
				else
					(-- state)
					(= cycles 2)
				)
			)
			(2
				(Load rsVIEW 1060)
				(meepSound number: 75 loop: -1 play:)
				(= seconds 2)
			)
			(3
				(meep2 stopUpd:)
				(meep3 stopUpd:)
				(gMessager say: 7 0 13 1 self) ; "You hear squeaky muttering from beneath the ground. It seems the Meeps are having quite a discussion about you."
			)
			(4
				(if (& (gEgo onControl: 1) $4000)
					(gMessager say: 7 0 20 1 self) ; "Hearing a rumble from the Meep hole, you quickly slip out of the way."
				else
					(= cycles 2)
				)
			)
			(5
				(if (& (gEgo onControl: 1) $4000)
					(gEgo setMotion: PolyPath 306 120 self)
				else
					(= cycles 2)
				)
			)
			(6
				(gEgo setHeading: 270 self)
			)
			(7
				(= cycles 2)
			)
			(8
				(bossMeep
					view: 61
					actions: meepTeller
					setLoop: 0
					setCel: 1
					setPri: 5
					z: 100
				)
				(bossRock
					view: 60
					setLoop: 5
					setCel: 1
					posn: 162 183
					setPri: 6
					z: 100
				)
				(= cycles 2)
			)
			(9
				(bossMeep setCel: 2)
				(bossRock
					setCycle: Fwd
					cycleSpeed: 5
					setStep: 8 8
					setMotion: MoveTo 172 140 self
				)
			)
			(10
				(= ticks 5)
			)
			(11
				(bossRock setMotion: MoveTo 183 189 self)
			)
			(12
				(meepSound loop: 1 number: 58 play:)
				(bossRock setCycle: 0 setCel: 0 posn: 181 200)
				(bossMeep setLoop: 2 setCel: 1 setCycle: CT 4 1 self)
			)
			(13
				(bossMeep setPri: 6 setCycle: End self)
			)
			(14
				(if (IsFlag 305)
					(gMessager say: 7 0 18 1 self) ; "Hiya, hiya. Nice to seeya 'gain."
				else
					(gMessager say: 7 0 19 1 self) ; "Hiya, hiya. Pleased to meetcha."
					(SetFlag 305)
				)
			)
			(15
				(= local31 20)
				(= local43 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance meepScript2 of Script_
	(properties)

	(method (dispose)
		(= state 0)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 1 2))
				(= cycles 2)
			)
			(1
				(if local43
					(self dispose:)
				else
					(switch register
						(1
							(meep2
								setLoop: 0
								posn: 73 231
								setPri: (rock1 priority:)
							)
							(meepEyes2 posn: 73 216)
						)
						(2
							(meep2
								setLoop: 1
								posn: 255 210
								setPri: (- (rock5 priority:) 1)
							)
							(meepEyes2 posn: 255 191)
						)
					)
					(= ticks (Random 75 200))
				)
			)
			(2
				(cond
					((== register 2)
						(= cycles 2)
					)
					(
						(or
							(<= (gEgo distanceTo: rock1) 130)
							(rock1 script:)
							local30
						)
						(self init:)
					)
					(else
						(++ state)
						(meep2
							approachX: (rock1 approachX:)
							approachY: (rock1 approachY:)
						)
						(if local43
							(= register2 3)
						else
							(= register2 (Random 5 10))
						)
						(meepSound loop: 1 number: (+ (Random 0 2) 55) play:)
						(meep2
							z: 100
							setCel: 0
							cycleSpeed: register2
							setCycle: End self
						)
						(rock1 z: 1000)
					)
				)
			)
			(3
				(if
					(or
						(<= (gEgo distanceTo: rock5) 130)
						(rock5 script:)
						local30
					)
					(self init:)
				else
					(meep2
						approachX: (rock5 approachX:)
						approachY: (rock5 approachY:)
					)
					(if local43
						(= register2 3)
					else
						(= register2 (Random 5 10))
					)
					(meepSound loop: 1 number: (+ (Random 0 2) 55) play:)
					(meep2
						z: 100
						setCel: 0
						cycleSpeed: register2
						setCycle: End self
					)
					(rock5 z: 1000)
				)
			)
			(4
				(meepEyes2 setCycle: Fwd setPri: (+ (meep2 priority:) 1) z: 100)
				(if local43
					(= cycles 2)
				else
					(= ticks (Random 20 40))
				)
			)
			(5
				(if local43
					(= register2 3)
				else
					(= register2 (Random 5 10))
				)
				(meepEyes2 z: 1000)
				(meep2 cycleSpeed: register2 setCycle: Beg self)
			)
			(6
				(switch register
					(1
						(rock1 z: 100)
					)
					(2
						(rock5 z: 100)
					)
				)
				(meep2 z: 1000)
				(self init:)
			)
		)
	)
)

(instance sGetScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local36 1)
				(= local35 0)
				(gEgo
					setMotion: PolyPath (+ (scroll x:) 20) (scroll y:) self
				)
			)
			(1
				(gEgo view: 510 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(scroll dispose:)
				(gEgo setCycle: Beg self)
			)
			(3
				(if (not [gEgoStats 12]) ; magic
					(gMessager say: 7 0 16 1) ; "The magical runes fade from the paper before your eyes can focus on them."
					(NormalEgo)
					(HandsOn)
					(self dispose:)
				else
					(gMessager say: 7 0 17 1 self) ; "You pick up the Spell Scroll. As the magical runes fade, you find you now know how to cast the "Detect Magic" spell."
				)
			)
			(4
				(gEgo learn: 18 10) ; detectSpell
				(SolvePuzzle 618 4)
				(SetFlag 228)
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

