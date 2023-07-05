;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 97)
(include sci.sh)
(use Main)
(use n814)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm97 0
	elsa97Talker 1
	yorick97Talker 2
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm97 of Rm
	(properties
		noun 14
		picture 97
	)

	(method (dispose)
		(SetFlag 87)
		(= gUseSortedFeatures local5)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 97 465 503)
		(LoadMany rsSOUND 88 2066)
		(gLongSong fade:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 93 212 107 220 128 220 131 100 131 105 110 90 109 49 158 223 163 236 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 282 189 232 117 319 99
					yourself:
				)
		)
		(super init:)
		(= local5 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(desk init: setOnMeCheck: 26505)
		(rug init: setOnMeCheck: 1 4)
		(SolvePuzzle 711 12)
		(door init: ignoreActors: 1 stopUpd:)
		(goldChest addToPic:)
		(torchL setCycle: Fwd init:)
		(theEyes setCycle: Fwd init: setPri: 1 setScript: blinkScript)
		(liteOffOrnament setCycle: Fwd init: ignoreActors: 1)
		(liteOffDragon setCycle: Fwd init: ignoreActors: 1)
		(yorick init:)
		(potion1 init: stopUpd:)
		(potion2 init: stopUpd:)
		(mirror ignoreActors: init: stopUpd:)
		(switch gPrevRoomNum
			(172 ; rmBrig
				(HandsOff)
				(door setCel: 0)
				(gEgo init: loop: 1 posn: 204 154)
				(potion1
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
				(potion2
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
				(mirror
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
				(EgoGait 0 0) ; walking
				(NormalEgo)
				(= local3 1)
				(leader
					init:
					setLoop: 5
					cel: 0
					setPri: 9
					posn: 151 155
					setScript: elsaIsBack
				)
			)
			(else
				(= local2 1)
				(liteOffBird setCycle: Fwd init: ignoreActors: 1)
				(liteOffShield setCycle: Fwd init: ignoreActors: 1)
				(liteOffChest setCycle: Fwd init: ignoreActors: 1)
				(gemChest1 setCycle: Fwd init:)
				(gemChest2 setCycle: Fwd init:)
				(gEgo init: hide: actions: egoActions setScript: egoEnters)
				(leader init: setPri: 12 illegalBits: 0 setScript: leaderVaults)
				(elsaSong init:)
			)
		)
	)

	(method (doit)
		(if (== (gEgo onControl: 1) 128)
			(if (gEgo has: 20) ; magicMirror
				(gCurRoom newRoom: 84)
			else
				(gCurRoom newRoom: 600) ; EndGame
			)
		)
		(if
			(and
				local6
				(== (leader script:) leaderVaults)
				(< (leaderVaults state:) 7)
			)
			(leaderVaults changeState: 7)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(78 ; dazzleSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(79 ; zapSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(50 ; detectMagicSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(77 ; triggerSpell or Pickup Inventory
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(80 ; calmSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(51 ; openSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(82 ; fetchSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(25 ; disenchant
				(if local2
					(HandsOff)
					(gEgo setScript: spilledIt)
					(leader setScript: 0)
					(leaderVaults dispose:)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance potion1 of View
	(properties
		x 118
		y 111
		noun 13
		approachX 132
		approachY 141
		view 97
		loop 11
		cel 1
		priority 8
		signal 16400
	)

	(method (init)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if local2
					(= local6 1)
				else
					(gEgo setScript: getPotions)
				)
			)
			(1 ; Look
				(gMessager say: 13 1) ; "It's a healing potion."
			)
			(25 ; disenchant
				(SetFlag 273)
				(gEgo use: 15) ; disenchant
				(SolvePuzzle 713 35)
				(leader setScript: leaderChanges)
			)
			(16 ; dagger
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(20 ; rock
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(12 ; sword
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance potion2 of View
	(properties
		x 122
		y 110
		noun 13
		approachX 132
		approachY 141
		view 97
		loop 11
		cel 1
		priority 8
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(potion1 doVerb: theVerb invItem)
	)
)

(instance mirror of View
	(properties
		x 134
		y 112
		noun 12
		approachX 155
		approachY 141
		view 97
		loop 11
		priority 8
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(25 ; disenchant
				(if local2
					(HandsOff)
					(gEgo setScript: spilledIt)
					(leader setScript: 0)
					(leaderVaults dispose:)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(if local2
					(= local6 1)
				else
					(gEgo setScript: getMirror)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theEyes of Prop
	(properties
		x 166
		y 62
		view 97
		loop 1
		cel 3
		detailLevel 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(if local2
				(HandsOff)
				(gEgo setScript: spilledIt)
				(leader setScript: 0)
				(leaderVaults dispose:)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance torchL of Prop
	(properties
		x 227
		y 55
		noun 16
		view 97
		loop 2
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(if local2
				(HandsOff)
				(gEgo setScript: spilledIt)
				(leader setScript: 0)
				(leaderVaults dispose:)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance liteOffOrnament of Prop
	(properties
		x 245
		y 88
		noun 10
		view 98
		loop 1
		cel 2
		priority 7
		signal 16
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(if local2
				(HandsOff)
				(gEgo setScript: spilledIt)
				(leader setScript: 0)
				(leaderVaults dispose:)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance liteOffBird of Prop
	(properties
		x 72
		y 72
		noun 7
		view 98
		loop 2
		cel 1
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(if local2
				(HandsOff)
				(gEgo setScript: spilledIt)
				(leader setScript: 0)
				(leaderVaults dispose:)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance liteOffChest of Prop
	(properties
		x 191
		y 89
		noun 8
		view 98
		loop 3
		cel 2
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(if local2
				(HandsOff)
				(gEgo setScript: spilledIt)
				(leader setScript: 0)
				(leaderVaults dispose:)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance liteOffDragon of Prop
	(properties
		x 156
		y 78
		noun 9
		view 98
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(if local2
				(HandsOff)
				(gEgo setScript: spilledIt)
				(leader setScript: 0)
				(leaderVaults dispose:)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance liteOffShield of Prop
	(properties
		x 100
		y 48
		noun 11
		view 98
		loop 4
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(if local2
				(HandsOff)
				(gEgo setScript: spilledIt)
				(leader setScript: 0)
				(leaderVaults dispose:)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of Prop
	(properties
		x 235
		y 189
		noun 2
		view 97
		loop 8
	)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(if local2
				(HandsOff)
				(gEgo setScript: spilledIt)
				(leader setScript: 0)
				(leaderVaults dispose:)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance goldChest of View
	(properties
		x 189
		y 105
		noun 5
		view 97
		cel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(if local2
				(HandsOff)
				(gEgo setScript: spilledIt)
				(leader setScript: 0)
				(leaderVaults dispose:)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance gemChest1 of Prop
	(properties
		x 263
		y 133
		noun 3
		view 97
		loop 9
		detailLevel 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(if local2
				(HandsOff)
				(gEgo setScript: spilledIt)
				(leader setScript: 0)
				(leaderVaults dispose:)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance gemChest2 of Prop
	(properties
		x 102
		y 177
		noun 4
		view 97
		loop 10
		cel 2
		priority 15
		signal 16
		detailLevel 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(if local2
				(HandsOff)
				(gEgo setScript: spilledIt)
				(leader setScript: 0)
				(leaderVaults dispose:)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance leader of Actor
	(properties
		x 148
		y 123
		noun 6
		view 97
		loop 4
		priority 9
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					(local2
						(gMessager say: 6 1) ; "The brigand leader wears a sword, and it looks well used."
					)
					(local3
						(gMessager say: 6 1 5 0) ; "Elsa looks much better in a dress."
					)
					(else
						(gMessager say: 6 1 6) ; "Everybody else is gone."
					)
				)
			)
			(25 ; disenchant
				(SetFlag 273)
				(gEgo use: 15) ; disenchant
				(SolvePuzzle 713 35)
				(self setScript: leaderChanges)
			)
			(81 ; flameDartSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(82 ; fetchSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(78 ; dazzleSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(79 ; zapSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(50 ; detectMagicSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(77 ; triggerSpell or Pickup Inventory
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(80 ; calmSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(51 ; openSpell
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(16 ; dagger
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(20 ; rock
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(12 ; sword
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
			(2 ; Talk
				(if local2
					(gMessager say: 6 2) ; "The Brigand Leader stares at you coldly. It seems he's not interested in chatter."
				else
					(gMessager say: 6 2 6) ; "We've no time to talk. I'll meet you at the castle."
				)
			)
			(else
				(if local2
					(= local6 1)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance yorick of Actor
	(properties
		x 276
		y 114
		noun 17
		view 97
		loop 6
	)
)

(instance brig1 of Actor
	(properties
		view 465
	)
)

(instance brig2 of Actor
	(properties
		view 465
	)
)

(instance brig3 of Actor
	(properties
		view 465
	)
)

(instance desk of Feature
	(properties
		x 169
		y 130
		z 13
		noun 1
		nsTop 107
		nsLeft 129
		nsBottom 127
		nsRight 209
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (gEgo inRect: 100 108 233 145)
					(cond
						((and (gEgo has: 20) local1) ; magicMirror
							(gMessager say: 1 4 2) ; "You find nothing more."
						)
						(local1
							(gMessager say: 1 4 3) ; "You see a mirror."
						)
						((gEgo has: 20) ; magicMirror
							(gMessager say: 1 4 4) ; "You find two Healing Potions."
						)
						(else
							(gMessager say: 1 4) ; "A quick but thorough search of the desk discloses two Healing Potions and a mirror."
						)
					)
				else
					(gMessager say: 1 4 1) ; "You're not close enough."
				)
			)
			(25 ; disenchant
				(if local2
					(HandsOff)
					(gEgo setScript: spilledIt)
					(leader setScript: 0)
					(leaderVaults dispose:)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rug of Feature
	(properties
		x 10
		y 160
		noun 15
		nsBottom 189
		nsRight 319
	)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(if local2
				(HandsOff)
				(gEgo setScript: spilledIt)
				(leader setScript: 0)
				(leaderVaults dispose:)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance elsaSong of Sound
	(properties
		number 88
		priority 1
	)
)

(instance tromp of Sound
	(properties
		number 2066
		priority 3
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 25) ; disenchant
			(HandsOff)
			(gEgo setScript: spilledIt)
			(leader setScript: 0)
			(leaderVaults dispose:)
			(return 1)
		else
			(HandsOff)
			(= local6 1)
			(return 0)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(EgoGait 0 0) ; walking
				(NormalEgo)
				(door setCycle: End self)
			)
			(1
				(gEgo
					posn: 261 240
					show:
					illegalBits: 0
					setMotion: MoveTo 261 176 self
				)
				(gMessager say: 14 0 9 1) ; "You finally made it through Yorick's room."
			)
			(2
				(gEgo setMotion: MoveTo 227 160 self)
			)
			(3
				(leaderVaults cue:)
				(gEgo setMotion: MoveTo 198 143 self)
				(door setCycle: Beg)
			)
			(4
				(NormalEgo 1)
				(self dispose:)
			)
		)
	)
)

(instance getPotions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo get: 12) ; healingPotion
				(gEgo get: 12) ; healingPotion
				(= local1 1)
				(potion1 hide:)
				(potion2 hide:)
				(potion1 dispose:)
				(potion2 dispose:)
				(self cue:)
			)
			(1
				(gMessager say: 13 4 0 0 self) ; "You place the two Healing Potions into your pack."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo get: 20) ; magicMirror
				(mirror hide:)
				(mirror dispose:)
				(self cue:)
			)
			(1
				(gMessager say: 12 4 0 0 self) ; "You pick up the mirror and store it away."
				(SolvePuzzle 715 10)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance spilledIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (or (!= (gEgo x:) 198) (!= (gEgo y:) 143))
					(gEgo setMotion: PolyPath 198 143 self)
					(gMessager say: 14 25 0 1) ; "After hours of hard and dangerous labor collecting the components to make the dispel potion, in a moment of sudden genius, you throw the potion away. It's a brilliant and unexpected strategem."
				else
					(gMessager say: 14 25 0 1 self) ; "After hours of hard and dangerous labor collecting the components to make the dispel potion, in a moment of sudden genius, you throw the potion away. It's a brilliant and unexpected strategem."
				)
			)
			(1
				(gEgo setLoop: 1)
				(if (== (leader cel:) 7)
					(self changeState: 5)
				else
					(= ticks 60)
				)
			)
			(2
				(if (== (leader cel:) 7)
					(self changeState: 5)
				else
					(= ticks 90)
				)
			)
			(3
				(if (== (leader cel:) 7)
					(self changeState: 5)
				else
					(= ticks 90)
				)
			)
			(4
				(if (== (leader cel:) 7)
					(self changeState: 5)
				else
					(= ticks 90)
				)
			)
			(5
				(gEgo setMotion: 0 setCycle: 0)
				(gMessager say: 14 25 0 2 self) ; "Unfortunately, it is also a very bad idea. You no longer have the Dispel Potion."
			)
			(6
				(client setScript: elsaKillsEgo)
			)
		)
	)
)

(instance leaderChanges of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 6 25 0 1 self) ; "You throw the Dispel Potion on the brigand leader."
			)
			(1
				(gCurRoom newRoom: 172) ; rmBrig
			)
		)
	)
)

(instance leaderVaults of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leader setLoop: 4 cel: 0)
			)
			(1
				(elsaSong play:)
				(= ticks 90)
			)
			(2
				(leader setCycle: End self)
				(if (!= (gEgo script:) spilledIt)
					(HandsOn)
					(gTheIconBar disable: 1)
				)
			)
			(3
				(if (or (IsFlag 273) (== local6 1))
					(self changeState: 7)
				else
					(= ticks (+ 60 (* 60 (- 3 gHowFast))))
				)
			)
			(4
				(if (or (IsFlag 273) (== local6 1))
					(self changeState: 7)
				else
					(= ticks (+ 400 (* 300 (- 3 gHowFast))))
				)
			)
			(5
				(if (or (IsFlag 273) (== local6 1))
					(self changeState: 7)
				else
					(gMessager say: 14 0 9 2 self) ; "The brigand leader taunts you with his stillness. You're sure that at the first wrong move, you'll become an ex-hero."
				)
			)
			(6
				(if (or (IsFlag 273) (== local6 1))
					(self changeState: 7)
				else
					(= ticks (+ 50 (* 150 (- 4 gHowFast))))
				)
			)
			(7
				(if (IsFlag 273)
					(client setScript: leaderChanges)
				else
					(HandsOff)
					(self cue:)
				)
			)
			(8
				(client setScript: elsaKillsEgo)
			)
		)
	)
)

(instance elsaKillsEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leader setLoop: 3 cycleSpeed: 1 setPri: 9 setCycle: End self)
				(gEgo setMotion: 0 setCycle: 0)
			)
			(1
				(= ticks 36)
			)
			(2
				(leader cycleSpeed: 1 setCycle: Beg self)
			)
			(3
				(gEgo view: 503 setLoop: 0 setCel: 0 cycleSpeed: 4 y: 141)
				(= ticks 60)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(yorick
					setLoop: 6
					cel: 0
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 230 114 self
				)
			)
			(6
				(gMessager say: 14 0 8 0 self) ; "Elsa, my dear, there's a problem I fear. To our dismay, that spell's here to stay, for alas you did slay your hero today."
			)
			(7
				(EgoDead 62 63) ; "The brigand leader is deadly with a sword. The magic spell that possesses her makes her an invincible warrior."
			)
		)
	)
)

(instance blinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 100 300))
			)
			(1
				(theEyes setCycle: Fwd)
				(= ticks (Random 12 72))
			)
			(2
				(theEyes setCycle: Beg self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance elsaIsBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc814_32 3)
				(= ticks 120)
			)
			(1
				(gMessager say: 14 0 7 1 self) ; "You can't imagine how good it feels to know who I am again. After all these years, to remember my name is Elsa von Spielburg!"
			)
			(2
				(gMessager say: 14 0 7 2 self) ; "I used to wish I was not a brigand's child but actually an enchanted princess. Now I know that I really was enchanted, and I don't have to be a brigand any more!"
			)
			(3
				(gMessager say: 14 0 7 3 self) ; "Thank you so much for freeing me."
			)
			(4
				(gMessager say: 14 0 7 4 self) ; "I've got to hurry home to father and get his guards to capture the rest of the brigands before they manage to escape with the treasure. It must be returned to the rightful owners."
			)
			(5
				(gMessager say: 14 0 7 5 self) ; "Yorick! Yorick! I'm me again!"
			)
			(6
				(yorick
					setLoop: 6
					cel: 0
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 230 114 self
				)
				(= local4 1)
			)
			(7
				(gMessager say: 14 0 7 6 self) ; "Sorry I took so long. I got lost."
			)
			(8
				(gMessager say: 14 0 7 7 self) ; "Will your Dad be glad that your spell's been repelled! We need to go before the brigands know or they'll spoil our show."
			)
			(9
				(gMessager say: 14 0 7 8 self) ; "C'mon! We'd better make our getaway before they get in our way."
			)
			(10
				(gMessager say: 14 0 7 9 self) ; "Yorick and I can return to the castle with the amulet I wear, but I'm afraid you'll have to get there on your own."
			)
			(11
				(gMessager say: 14 0 7 10 self) ; "There are two Healing Potions on my desk that you may take with you."
			)
			(12
				(gMessager say: 14 0 7 11 self) ; "You should use this secret passage and escape while they are arguing over the treasure. If they find you in here, you'll be overwhelmed and killed."
			)
			(13
				(gMessager say: 14 0 7 12 self) ; "Thank you again, and good luck! I'll make sure you are richly rewarded for your bravery."
			)
			(14
				(tromp number: 2066 init: loop: 4 play:)
				(gMessager say: 14 0 7 13 self) ; "If you decide to counter the curser, then mind the mirror over mere minds. So tip the canoe and toodleloo! Elsa, if you do the honors, I'll honor your due."
			)
			(15
				(leader setLoop: 5 cel: 0 setCycle: End self)
				(= local3 0)
				(liteOffBird setCycle: Fwd init: ignoreActors: 1)
				(liteOffShield setCycle: Fwd init: ignoreActors: 1)
				(liteOffChest setCycle: Fwd init: ignoreActors: 1)
				(gemChest1 setCycle: Fwd init:)
				(gemChest2 setCycle: Fwd init:)
			)
			(16
				(yorick setLoop: 7 cel: 0 setCycle: End self)
				(HandsOn)
				(proc814_32 3)
				(tromp number: 2066 loop: 4 play:)
				(= local4 0)
			)
			(17
				(gMessager say: 14 0 7 14 self) ; "The brigands are trying to break into the room."
			)
			(18
				(yorick dispose:)
				(gEgo ignoreActors: 1)
				(tromp loop: 6 play:)
				(= ticks (* 800 (- 5 gHowFast)))
			)
			(19
				(tromp loop: 6 play:)
				(= ticks (* 700 (- 5 gHowFast)))
			)
			(20
				(HandsOff)
				(if (and (> (gEgo x:) 280) (< (gEgo y:) 130))
					(gEgo setMotion: MoveTo 340 (gEgo y:))
				else
					(self cue:)
				)
			)
			(21
				(door setCycle: End)
				(brig1
					init:
					setCycle: Walk
					posn: 259 230
					setMotion: MoveTo 259 190
				)
				(brig2
					init:
					setCycle: Walk
					posn: 265 240
					setMotion: MoveTo 265 199
				)
				(brig3
					init:
					setCycle: Walk
					posn: 259 255
					setMotion: MoveTo 259 214 self
				)
			)
			(22
				(EgoDead 60 61) ; "Thinking about all that treasure cost you time and more. Some folks just don't know when to leave."
			)
		)
	)
)

(instance elsa97Talker of Talker
	(properties
		x 10
		y 10
		view 1097
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(self modeless: 0)
		(super init: elsaBust elsaEye elsaMouth &rest)
	)
)

(instance elsaBust of Prop
	(properties
		view 1097
	)
)

(instance elsaMouth of Prop
	(properties
		nsTop 50
		nsLeft 61
		view 1097
		loop 1
	)
)

(instance elsaEye of Prop
	(properties
		nsTop 32
		nsLeft 53
		view 1097
		loop 2
	)
)

(instance yorick97Talker of Talker
	(properties
		x 186
		y 10
		view 1096
		talkWidth 260
		textX -161
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(self modeless: 0)
		(super init: yorickBust yorickEye yorickMouth &rest)
	)
)

(instance yorickBust of Prop
	(properties
		view 1096
		cel 2
	)
)

(instance yorickMouth of Prop
	(properties
		nsTop 39
		nsLeft 34
		view 1096
		loop 1
	)
)

(instance yorickEye of Prop
	(properties
		nsTop 26
		nsLeft 33
		view 1096
		loop 2
	)
)

