;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use Teller)
(use buy)
(use n814)
(use Print)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm55 0
	healerTalker 1
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10 = 1
	[local11 7] = [0 -25 -34 -39 -13 -12 999]
	[local18 4] = [0 -33 -37 999]
	[local22 8] = [0 26 -43 28 -42 -16 -29 999]
	[local30 7] = [0 -11 -21 -14 20 30 999]
	[local37 5] = [0 10 38 15 999]
	[local42 4] = [0 19 27 999]
	[local46 3] = [0 35 999]
	[local49 3] = [0 36 999]
	[local52 3] = [0 41 999]
	[local55 4] = [0 44 40 999]
	[local59 7] = [0 17 22 9 24 31 999]
	[local66 4] = [0 18 23 999]
	[local70 3] = [0 32 999]
	[local73 18]
	[local91 14] = [0 -25 -34 -39 -13 -12 -33 -37 -43 -42 -16 -29 -21 999]
)

(procedure (localproc_0) ; UNUSED
	(cond
		((IsFlag 224)
			(gMessager say: 13 0 0 1) ; "I cannot make you another Dispel Potion unless you can convince the Dryad to give you another magic acorn. I do not think that is likely."
		)
		((IsFlag 223)
			(gMessager say: 13 0 60 1) ; "Please leave me to make the potion, and when you return I shall have it for you."
		)
		((IsFlag 334)
			(localproc_1)
		)
		(else
			(gMessager say: 13 0 60 2) ; "If you know the ingredients for a Dispel Potion and bring them here, I can make you such a potion."
		)
	)
)

(procedure (localproc_1 &tmp [temp0 40] [temp40 11] [temp51 11] [temp62 20] [temp82 11] [temp93 211])
	(if (and (not (IsFlag 223)) (not (IsFlag 224)))
		(cond
			(
				(and
					(IsFlag 218)
					(IsFlag 219)
					(IsFlag 220)
					(IsFlag 221)
					(IsFlag 222)
				)
				(gCurRoom setScript: waitForHealer)
				(SetFlag 223)
				(ClearFlag 224)
				(ClearFlag 218)
				(ClearFlag 219)
				(ClearFlag 220)
				(ClearFlag 222)
			)
			((IsFlag 334)
				(Message msgGET 55 5 0 7 1 @temp0) ; "Let's see, to make the Dispel Potion I still need: %s %s %s %s %s"
				(Message msgGET 55 5 0 4 1 @temp40) ; "Fairy Dust"
				(Message msgGET 55 5 0 5 1 @temp51) ; "Green Fur"
				(Message msgGET 55 5 0 6 1 @temp62) ; "Flowers from Erana's Peace"
				(Message msgGET 55 5 0 3 1 @temp82) ; "Magic Acorn"
				(Message msgGET 55 5 0 8 1 @temp93) ; "Flying Water"
				(Print
					addTextF:
						@temp0
						(if (IsFlag 218) {} else @temp40)
						(if (IsFlag 219) {} else @temp51)
						(if (IsFlag 220) {} else @temp62)
						(if (IsFlag 222) {} else @temp93)
						(if (IsFlag 221) {} else @temp82)
					init:
				)
			)
		)
	)
)

(instance rm55 of Rm
	(properties
		noun 13
		picture 55
		style 8
	)

	(method (dispose)
		(gLongSong fade:)
		(SetFlag 45)
		(super dispose:)
	)

	(method (init)
		(= [local73 0] @local11)
		(= [local73 1] @local18)
		(= [local73 2] @local22)
		(= [local73 3] @local30)
		(= [local73 4] @local37)
		(= [local73 5] @local42)
		(= [local73 6] @local46)
		(= [local73 7] @local49)
		(= [local73 8] @local52)
		(= [local73 9] @local55)
		(= [local73 10] @local59)
		(= [local73 11] @local66)
		(= [local73 12] @local70)
		(= [local73 13] 999)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 319 133 179 122 270 143 234 168 115 152 75 164 0 140 0 189
					yourself:
				)
		)
		(LoadMany rsVIEW 57 56 523 525)
		(Load rsSOUND 2042)
		(super init:)
		(= global240 0)
		(barrel init: setOnMeCheck: 26505)
		(cheeseCloth init: setOnMeCheck: 26505)
		(bed init: setOnMeCheck: 26505)
		(woodTable init: setOnMeCheck: 26505)
		(litterBox init: setOnMeCheck: 26505)
		(healerWindow init: setOnMeCheck: 26505)
		(ladder init: setOnMeCheck: 26505)
		(ingredients init: setOnMeCheck: 26505)
		(onThings init: setOnMeCheck: 26505)
		(pots init: setOnMeCheck: 1 4)
		(stoneTable init: setOnMeCheck: 1 2)
		(fire init: setCycle: Fwd)
		(kettle init: setCycle: Fwd)
		(bottles
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
		(NormalEgo)
		(bird init: setScript: preening)
		(gEgo init: posn: 137 243)
		(healerTeller init: healer @local11 @local73 @local91)
		(gLongSong number: 122 loop: -1 init: play:)
		(gCurRoom setScript: egoEnters)
	)

	(method (doit)
		(cond
			(script)
			(
				(or
					(== (gEgo edgeHit:) EDGE_BOTTOM)
					(< (gEgo x:) 3)
					(> (gEgo x:) 318)
				)
				(HandsOff)
				(gCurRoom setScript: sExitSouth)
			)
		)
		(if (and (== gNight 1) (== local10 1))
			(PalVary pvUNINIT)
			(= local10 0)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 13 4) ; "You can buy potions, get information, or sell ingredients here."
			)
			(52 ; Sleep
				(gMessager say: 13 52) ; "Come back in the morning, please."
			)
			(1 ; Look
				(gMessager say: 13 1) ; "You see a clean but very cluttered little hut filled with bottles and potions. The Healer is busy puttering around with her potions."
			)
			(50 ; detectMagicSpell
				(gMessager say: 13 50) ; "There is an aura of magic throughout this small cabin."
			)
			(81 ; flameDartSpell
				(gMessager say: 13 81) ; "You don't really think that is the correct way to win this game, do you?"
			)
			(78 ; dazzleSpell
				(gMessager say: 13 81) ; "You don't really think that is the correct way to win this game, do you?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance healerWin of SysWindow ; UNUSED
	(properties
		color 1
	)

	(method (open &tmp temp0)
		(= temp0 (- 188 bottom))
		(+= top temp0)
		(+= bottom temp0)
		(super open:)
	)
)

(instance cheeseCloth of Feature
	(properties
		x 19
		y 128
		nsTop 123
		nsBottom 133
		nsRight 38
	)
)

(instance bed of Feature
	(properties
		x 156
		y 104
		noun 2
		nsTop 89
		nsLeft 112
		nsBottom 119
		nsRight 200
	)
)

(instance litterBox of Feature
	(properties
		x 121
		y 117
		z 65
		noun 10
		nsTop 44
		nsLeft 105
		nsBottom 61
		nsRight 138
	)
)

(instance healerWindow of Feature
	(properties
		x 130
		y 77
		noun 17
		nsTop 70
		nsLeft 120
		nsBottom 84
		nsRight 141
	)
)

(instance ingredients of Feature
	(properties
		x 249
		y 83
		noun 7
		nsTop 78
		nsLeft 215
		nsBottom 89
		nsRight 284
	)
)

(instance woodTable of Feature
	(properties
		x 81
		y 147
		noun 15
		nsTop 124
		nsLeft 39
		nsBottom 147
		nsRight 123
	)
)

(instance ladder of Feature
	(properties
		x 70
		y 92
		noun 9
		nsTop 55
		nsLeft 54
		nsBottom 129
		nsRight 86
	)
)

(instance stoneTable of Feature
	(properties
		x 195
		y 159
		noun 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 14 1) ; "You see bottles and flasks of a wide variety of different potions."
			)
			(4 ; Do
				(cond
					((IsFlag 226)
						(gMessager say: 14 4 68) ; "You're getting greedy. She'll notice if you take any more."
					)
					(local2
						(gMessager say: 14 4 66) ; "You carefully grab a couple of Healing Potions and conceal them under your cape."
						(bottles hide:)
						(SetFlag 226)
						(= local9 3)
						(gEgo setScript: cueItScript)
					)
					(else
						(gMessager say: 14 4 67) ; "If you're going to steal, at least wait until the Healer is not looking."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pots of Feature
	(properties
		x 219
		y 135
		noun 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 11 1) ; "Amelia uses a wide variety of pots to make her magical potions."
			)
			(4 ; Do
				(gMessager say: 11 4) ; "Do you want to burn yourself? Those pots are hot!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onThings of Feature
	(properties
		x 18
		y 144
		z 50
		noun 16
		nsTop 73
		nsBottom 116
		nsRight 36
	)
)

(instance barrel of Feature
	(properties
		x 7
		y 131
		z 93
		noun 1
		nsTop 24
		nsBottom 53
		nsRight 15
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (not local7)
				(gMessager say: 1 1 1) ; "It's a barrel."
				(= local7 1)
			else
				(gMessager say: 1 1 2) ; "It's just a wooden barrel."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bottles of View
	(properties
		x 145
		y 135
		noun 14
		approachX 144
		approachY 162
		view 56
		loop 1
		priority 11
		signal 17
	)

	(method (doVerb theVerb)
		(stoneTable doVerb: theVerb &rest)
	)
)

(instance kettle of Prop
	(properties
		x 203
		y 120
		noun 8
		nsTop 111
		nsLeft 190
		nsBottom 126
		nsRight 207
		view 56
		loop 7
		priority 9
		signal 16
		cycleSpeed 20
	)
)

(instance fire of Prop
	(properties
		x 199
		y 146
		noun 4
		nsTop 111
		nsLeft 190
		nsBottom 146
		nsRight 199
		view 56
		priority 10
		signal 16
		cycleSpeed 4
	)

	(method (doVerb theVerb)
		(pots doVerb: theVerb &rest)
	)
)

(instance bird of Prop
	(properties
		x 45
		y 52
		noun 12
		nsTop 73
		nsLeft 65
		nsBottom 82
		nsRight 87
		view 56
		loop 2
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 20) ; rock
			(gMessager say: 6 16) ; "Please, show some respect."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance healer of Actor
	(properties
		noun 6
		approachX 105
		approachY 157
		view 57
		loop 2
		illegalBits 0
	)

	(method (doit)
		(if (and local4 (!= script healerKisses))
			(= local4 0)
			(healer setScript: healerKisses)
		)
		(super doit:)
	)
)

(instance healerTeller of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-37
				(and (or (IsFlag 91) (IsFlag 45)) (not (IsFlag 230)))
				-16
				(gEgo has: 24) ; acorn
		)
	)

	(method (doChild)
		(switch query
			(-14
				(SetFlag 350)
			)
			(-11
				(SetFlag 308)
			)
			(-12
				(if (or (IsFlag 94) (IsFlag 43))
					(super doChild: query)
				else
					(return 1)
				)
			)
			(-29
				(if (or (IsFlag 60) (IsFlag 66))
					(super doChild: query)
				else
					(return 1)
				)
			)
			(else
				(super doChild: query)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 4 0 1) ; "She is a rather motherly-looking woman with a look of vagueness that belies her shrewdness. She wears an apron over her dress and a scarf wrapped around her head."
			)
			(4 ; Do
				(if (IsFlag 230)
					(gMessager say: 6 4 37 2) ; "I have already given you your reward for the return of my ring."
				else
					(gMessager say: 6 4 37 1) ; "My ring is shaped in gold like a braid of the herb Athelas with entwined leaves. I will give six golds to the person who returns my ring."
				)
			)
			(2 ; Talk
				(SolvePuzzle 668 2)
				(super doVerb: theVerb &rest)
			)
			(10 ; silver
				((= gList (List new:))
					add:
						((Clone Ware) name: {Stamina} price: {20})
						((Clone Ware) name: {Healing} price: {40})
						((Clone Ware) name: {Mana} price: {60})
						((Clone Ware) name: {Undead} price: {100})
				)
				(switch ((ScriptID 551 0) doit:) ; buy
					(-1
						(gMessager say: 6 10 52) ; "You find that you have less money than you thought, and can't afford to buy a potion."
					)
					(1
						(gMessager say: 6 10 56) ; "I hope this will help you."
						(= local9 4)
						(gEgo setScript: cueItScript)
					)
					(2
						(gMessager say: 6 10 56) ; "I hope this will help you."
						(= local9 5)
						(gEgo setScript: cueItScript)
					)
					(3
						(gMessager say: 6 10 56) ; "I hope this will help you."
						(= local9 6)
						(gEgo setScript: cueItScript)
					)
					(4
						(gMessager say: 6 10 56) ; "I hope this will help you."
						(= local9 7)
						(gEgo setScript: cueItScript)
					)
				)
			)
			(28 ; ring
				(SetFlag 230)
				(SolvePuzzle 669 10)
				(gMessager say: 6 28 37) ; "Oh, thank you for finding my ring. How I've missed this. Here are six golds and two Healing Potions for your reward!"
				((gInventory at: 38) amount: (+ ((gInventory at: 38) amount:) 6)) ; gold, gold
				(= local9 1)
				(gEgo setScript: cueItScript)
				(= local4 1)
				(if (<= (+ (* (gEgo y:) 3) (gEgo x:) -615) 0)
					(= local5 20)
					(healer setScript: healerPleased)
				)
			)
			(36 ; flowers
				(if (> global240 2)
					(gMessager say: 6 36 45) ; "Thank you, but I have all the flowers I need."
				else
					(gEgo setScript: flowersScript)
				)
			)
			(37 ; greenFur
				(gEgo setScript: giveGreenFur)
			)
			(34 ; acorn
				(gEgo setScript: giveAcorn)
			)
			(35 ; seed
				(gMessager say: 6 35 51) ; "I wouldn't know what to do with that."
			)
			(40 ; mushroom
				(gEgo setScript: giveMushroom)
			)
			(46 ; cheetaurClaw
				(gEgo setScript: giveClaws)
			)
			(47 ; trollBeard
				(gEgo setScript: giveBeard)
			)
			(38 ; fairyDust
				(gEgo setScript: giveDust)
			)
			(39 ; flyingWater
				(cond
					((not (gEgo has: 29)) ; flyingWater
						(DontHave)
					)
					(global242
						(gMessager say: 6 39 16) ; "I don't need any more Flying Water. Thank you anyway."
					)
					((not (IsFlag 334))
						(gMessager say: 6 39 47) ; "Thank you for the offer, but I really don't need any water."
					)
					((not (IsFlag 329))
						(gMessager say: 6 39 48) ; "The Healer makes some sort of arcane gesture over the flask of water, then looks surprised."
					)
					(else
						(gEgo setScript: giveWater)
					)
				)
			)
			(20 ; rock
				(gMessager say: 6 16) ; "Please, show some respect."
			)
			(21 ; flask
				(= local5 6)
				(healer setScript: healerPleased)
				(gMessager say: 6 21) ; "Thank you, I always need flasks."
				(= local9 2)
				(gEgo setScript: cueItScript)
			)
			(16 ; dagger
				(gMessager say: 6 16) ; "Please, show some respect."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 185 self)
				(healer
					loop: 9
					init:
					posn: 151 142
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
						2 ; Talk
					setCycle: Fwd
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(cond
					((not (IsFlag 225))
						(gMessager say: 13 0 63 1 self) ; "The fragrances of herbs mingle with some rather unpleasant odors as you step into the healer's house."
					)
					(
						(and
							(not (IsFlag 223))
							(or (not (IsFlag 201)) (IsFlag 334))
						)
						(gMessager say: 13 0 62 1 self) ; "Well, what can I do for you this time?"
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(if (not (IsFlag 225))
					(gMessager say: 13 0 65 0 self) ; "Lovely day, isn't it? My, you look very healthy for an adventurer. You must be new."
				else
					(self cue:)
				)
			)
			(4
				(if (and (IsFlag 201) (gEgo has: 24) (not (IsFlag 334))) ; acorn
					(gMessager say: 13 0 57 1 self) ; "You tell the healer that you have been to visit the Dryad of the Woods, and that she gave you a Magic Acorn and told you the formula for a potion to dispel enchantments."
				else
					(self cue:)
				)
			)
			(5
				(if (and (IsFlag 201) (gEgo has: 24) (not (IsFlag 334))) ; acorn
					(gMessager say: 6 34 0 1 self) ; "So you helped the Dryad; that's nice. She does keep the forest around here healthy. So that's how to make a Dispel Potion, is it? Thanks for letting me know."
					(SetFlag 334)
				else
					(self cue:)
				)
			)
			(6
				(if (IsFlag 223)
					(gCurRoom setScript: giveDispel)
				else
					(self cue:)
				)
			)
			(7
				(healer setMotion: MoveTo 92 139 self)
			)
			(8
				(healer setLoop: 5 setCycle: End self)
			)
			(9
				(healer setLoop: 5 setCycle: Fwd setScript: healerPuttering)
				(HandsOn)
				(gCurRoom setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance preening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lizSound play: 50)
				(bird cel: 2 setCycle: End self)
			)
			(1
				(= cycles (Random 9 27))
			)
			(2
				(lizSound play: 50)
				(bird setCycle: Beg self)
			)
			(3
				(= cycles (Random 100 200))
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance healerPuttering of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 90 200))
			)
			(1
				(healer setLoop: 4 cel: 2 setCycle: Beg self)
			)
			(2
				(= local2 1)
				(healer loop: 1 setCycle: Walk setMotion: MoveTo 87 138 self)
			)
			(3
				(healer loop: 3)
				(= seconds 3)
			)
			(4
				(= local2 0)
				(healer
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 151 142 self
				)
			)
			(5
				(healer setLoop: 1 setCycle: Walk setMotion: MoveTo 90 139 self)
			)
			(6
				(healer setLoop: 4 cel: 0 setCycle: End self)
			)
			(7
				(healer setLoop: 5 cel: 0 setCycle: Fwd)
				(self changeState: 0)
			)
		)
	)
)

(instance healerPleased of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(healer setMotion: 0 loop: 2)
				(= cycles 2)
			)
			(1
				(healer setLoop: 6 cel: 0 setCycle: End self)
			)
			(2
				(= cycles local5)
			)
			(3
				(switch local3
					(0
						(healer
							setLoop: -1
							setCycle: Walk
							setMotion: MoveTo 164 130 self
						)
					)
					(1
						(healer
							setLoop: -1
							setCycle: Walk
							setMotion: MoveTo 164 130 self
						)
					)
				)
			)
			(4
				(healer setLoop: 5 setCycle: End self)
			)
			(5
				(healer setLoop: 5 setCycle: Fwd setScript: healerPuttering)
			)
		)
	)
)

(instance healerKisses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(healer setLoop: 6 setCel: 0 setCycle: End self)
			)
			(1
				(if
					(not
						(and (<= 138 (healer x:) 140) (<= 138 (healer y:) 140))
					)
					(switch local3
						(0
							(healer
								setLoop: -1
								setCycle: Walk
								illegalBits: 0
								setMotion: MoveTo 139 139 self
							)
						)
						(1
							(healer
								setLoop: 2
								setCycle: Walk
								setMotion: MoveTo 139 139 self
							)
						)
					)
				else
					(= cycles 2)
				)
			)
			(2
				(healer setLoop: 2 setMotion: MoveTo 121 152)
				(gEgo illegalBits: 0 setMotion: MoveTo 146 154 self)
			)
			(3
				(gEgo setLoop: 1 ignoreActors:)
				(= cycles 2)
			)
			(4
				(healer setLoop: 7 cel: 0 ignoreActors: setCycle: CT 2 1 self)
			)
			(5
				(gEgo hide:)
				(healer
					setLoop: 7
					posn: (+ (healer x:) 2) (+ (healer y:) 5)
					setCycle: CT 6 1 self
				)
			)
			(6
				(kiss init: play:)
				(= seconds 1)
			)
			(7
				(healer setLoop: 7 setCycle: CT 3 -1 self)
			)
			(8
				(gEgo show:)
				(healer setLoop: 7 setCycle: CT 0 -1 self)
			)
			(9
				(gEgo
					view: 525
					loop: 2
					cel: 0
					posn: (+ (gEgo x:) 5) (+ (gEgo y:) 3)
					setPri: 11
					setCycle: Fwd
					setMotion: MoveTo 137 175 self
				)
			)
			(10
				(gMessager say: 13 0 64 1 self) ; "You put the reward away, and tell her she is welcome, as you leave to avoid being kissed again."
			)
			(11
				(healer
					setLoop: -1
					setCycle: Walk
					setPri: 12
					moveSpeed: 12
					setMotion: MoveTo 135 210 self
				)
				(NormalEgo)
				(gEgo
					view: 0
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 155 210 self
				)
			)
			(12
				(self dispose:)
			)
		)
	)
)

(instance waitForHealer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gMessager say: 13 0 61) ; "The Dispel Potion will take a while to make. Why don't you come back later?"
				(= seconds 3)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 243 self)
			)
			(1
				(if (and (not (IsFlag 225)) (not (IsFlag 230)))
					(gMessager say: 13 0 58 1 self) ; "Oh, by the way, if you happen to find a ring on your adventures, I lost my favorite gold ring. I will give a reward to the one who returns it."
				else
					(self cue:)
				)
			)
			(2
				(SetFlag 225)
				(gCurRoom newRoom: 54)
			)
		)
	)
)

(instance flowersScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local5 10)
				(gMessager say: 6 36 46 1 self) ; "Thank you. I can always use flowers from Erana's Peace in potion making. Here are your silvers."
			)
			(1
				(SetFlag 220)
				(++ global240)
				(gEgo use: 26 5) ; flowers
				(SolvePuzzle 673 1)
				(localproc_1)
				(= seconds 2)
			)
			(2
				(HandsOn)
				(gEgo get: 0 5) ; silver
				(healer setScript: healerPleased)
			)
		)
	)
)

(instance giveGreenFur of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local5 10)
				(gEgo use: 27) ; greenFur
				(SetFlag 219)
				(SolvePuzzle 676 2)
				(healer setScript: healerPleased)
				(= ticks 60)
			)
			(1
				(if (IsFlag 334)
					(gMessager say: 6 37 16 1 self) ; "Those Meeps sound so interesting. I'd like to meet them sometime. I'll get to work on that potion of yours."
				else
					(gMessager say: 6 37 0 1 self) ; "Thank you. I'll save this for a later use."
				)
			)
			(2
				(localproc_1)
				(= seconds 2)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveAcorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 334)
				(= local5 10)
				(healer setScript: healerPleased)
				(gMessager say: 6 34 0 1 self) ; "So you helped the Dryad; that's nice. She does keep the forest around here healthy. So that's how to make a Dispel Potion, is it? Thanks for letting me know."
			)
			(1
				(SetFlag 221)
				(SolvePuzzle 675 5)
				(localproc_1)
				(= seconds 2)
			)
			(2
				(HandsOn)
				(gEgo use: 24) ; acorn
				(self dispose:)
			)
		)
	)
)

(instance giveMushroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((> global241 2)
						(gMessager say: 6 40 45 1) ; "Thank you, but I have enough mushrooms."
						(HandsOn)
						(self dispose:)
					)
					((IsFlag 148)
						(gMessager say: 6 40 50 1 self) ; "You have ruined the mushrooms with toadstools. I can not buy your mushrooms."
					)
					(else
						(= local5 10)
						(healer setScript: healerPleased)
						(gMessager say: 6 40 46 1 self) ; "These are very nice. I'll dry them and grind them into a powder."
						(++ global241)
					)
				)
			)
			(1
				(if (not (IsFlag 148))
					(gEgo get: 38 1) ; gold
					(gEgo use: 30 3) ; mushroom
				)
				(self cue:)
			)
			(2
				(HandsOn)
				(if (and (> global241 2) (not (IsFlag 148)))
					(SolvePuzzle 670 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance giveClaws of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local5 10)
				(healer setScript: healerPleased)
				(= ticks 60)
			)
			(1
				(if (== local8 1)
					(self cue:)
				else
					(= local8 1)
					(gMessager say: 6 46 0 1 self) ; "Do you mean to tell me that you actually managed to kill a Cheetaur? You're quite a hero, aren't you?"
				)
			)
			(2
				(gMessager say: 6 46 0 2 self) ; "Here is your money. You might think about purchasing a Healing Potion in case you have to fight such monsters again."
			)
			(3
				(SolvePuzzle 671 2)
				(= ticks 30)
			)
			(4
				(HandsOn)
				(gEgo get: 0 5 use: 36) ; silver, cheetaurClaw
				(self dispose:)
			)
		)
	)
)

(instance giveBeard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local5 10)
				(healer setScript: healerPleased)
				(= ticks 60)
			)
			(1
				(gMessager say: 6 47 0 0 self) ; "Don't tell me you actually killed a Troll? Why, you are really amazing. I haven't had any Troll's Beard for a long time. There are two healing potions for the beard."
			)
			(2
				(gEgo use: 37) ; trollBeard
				(= ticks 60)
			)
			(3
				(HandsOn)
				(gEgo get: 12) ; healingPotion
				(gEgo get: 12) ; healingPotion
				(SolvePuzzle 672 2)
				(self dispose:)
			)
		)
	)
)

(instance giveDust of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local5 10)
				(healer setScript: healerPleased)
				(= ticks 30)
			)
			(1
				(if (and (not (IsFlag 223)) (IsFlag 334))
					(gMessager say: 6 38 16 1 self) ; "So, you say this is one of the ingredients for the Dispel Potion. Well, I had better get started making it."
				else
					(gMessager say: 6 38 16 2 self) ; "Thank you. I'm sure that I'll find a good use for Fairy Dust."
				)
			)
			(2
				(SetFlag 218)
				(SolvePuzzle 677 2)
				(localproc_1)
				(= seconds 2)
			)
			(3
				(gEgo use: 28) ; fairyDust
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 6 39 49 0 self) ; "The Healer makes some sort of arcane gesture over the flask of water, then smiles."
			)
			(1
				(= local5 10)
				(healer setScript: healerPleased)
				(++ global242)
				(SetFlag 222)
				(SolvePuzzle 674 2)
				(localproc_1)
				(= ticks 60)
			)
			(2
				(gEgo use: 29) ; flyingWater
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveDispel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(healer setMotion: MoveTo 92 139 self)
			)
			(1
				(gEgo get: 15) ; disenchant
				(ClearFlag 223)
				(SetFlag 224)
				(SolvePuzzle 678 7)
				(healer setLoop: 5 setCycle: End self)
			)
			(2
				(gEgo setMotion: PolyPath 105 157 self)
			)
			(3
				(gMessager say: 13 0 59 1 self) ; "Here is the potion of Dispel!"
			)
			(4
				(healer setLoop: 5 setCycle: Fwd setScript: healerPuttering)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cueItScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local9
					(1
						(gEgo use: 18) ; ring
						(gEgo get: 12) ; healingPotion
						(gEgo get: 12) ; healingPotion
					)
					(2
						(gEgo use: 11) ; flask
						(gEgo get: 0 1) ; silver
					)
					(3
						(gEgo get: 12 2) ; healingPotion
					)
					(4
						(gEgo get: 14) ; staminaPotion
					)
					(5
						(gEgo get: 12) ; healingPotion
					)
					(6
						(gEgo get: 13) ; manaPotion
					)
					(7
						(gEgo get: 19) ; ghostOil
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance lizSound of Sound
	(properties
		number 2074
		vol 45
	)
)

(instance kiss of Sound
	(properties
		number 2042
		priority 5
	)
)

(instance healerTalker of Talker
	(properties
		x 10
		y 10
		view 1055
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: healerBust healerEye healerMouth &rest)
	)
)

(instance healerBust of Prop
	(properties
		view 1055
	)
)

(instance healerMouth of Prop
	(properties
		nsTop 52
		nsLeft 40
		view 1055
		loop 1
	)
)

(instance healerEye of Prop
	(properties
		nsTop 41
		nsLeft 39
		view 1055
		loop 2
	)
)

