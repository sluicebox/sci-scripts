;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use Teller)
(use buy)
(use Door)
(use n814)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm320 0
	hildeTalker 1
)

(local
	local0
	local1
	local2
	local3
	[local4 2]
	[local6 6] = [0 -16 -11 -22 -8 999]
	[local12 7] = [0 12 14 13 15 10 999]
	[local19 6] = [0 12 14 13 15 999]
	[local25 7] = [0 7 9 19 17 21 999]
	[local32 4] = [0 18 20 999]
	[local36 8]
	[local44 6] = [0 -16 -11 -22 -8 999]
)

(procedure (localproc_0) ; UNUSED
	(gMessager say: 7 0 0 10) ; "You reach for your money but come up empty-handed. Unable to pay for your goods, you put the merchandise back."
)

(instance rm320 of Rm
	(properties
		noun 7
		picture 320
	)

	(method (init)
		(self setRegions: 811 801) ; Street, Town
		(= [local36 0] @local6)
		(= [local36 1] @local12)
		(= [local36 2] @local19)
		(= [local36 3] @local25)
		(= [local36 4] @local32)
		(= [local36 5] 999)
		(if (== gPrevRoomNum 330)
			(= style 12)
		else
			(= style 0)
		)
		(super init:)
		(gEgo init: setScript: 0)
		(hildeTeller init: centaur @local6 @local36 @local44)
		(if (not gNight)
			(centaur
				setPri: 6
				cycleSpeed: 1
				init:
				actions: hildeTeller
				approachVerbs: 4 10 ; Do, silver
				stopUpd:
			)
			(centaurBody
				setPri: 3
				init:
				actions: hildeTeller
				stopUpd:
				approachVerbs: 4 10 ; Do, silver
				addToPic:
			)
			(theApples setPri: 4 init: stopUpd: addToPic:)
			(scales setPri: 11 init: stopUpd: addToPic:)
			((= local0 (Prop new:))
				view: 325
				loop: 1
				cel: 0
				posn: 281 133
				setPri: (centaurBody priority:)
				init:
				actions: hildeTeller
				cycleSpeed: 1
				stopUpd:
				setScript: tailScript
			)
		)
		(= global111 0)
		(NormalEgo)
		(switch gPrevRoomNum
			(0
				(gEgo posn: 226 182 setMotion: MoveTo 250 184)
			)
			(330
				(gEgo x: 21 setCycle: Walk setScript: comeIn)
			)
			(300
				(NormalEgo)
				(gEgo posn: 275 250 setScript: comeFromTown)
			)
			(321
				(gEgo posn: 78 122 setMotion: PolyPath 40 170)
				(sheriffDoor close:)
			)
			(322
				(gEgo posn: 158 145 setScript: outOfStore)
			)
			(999
				(gEgo view: 515 setLoop: 3 cel: 5 setScript: egoWakes)
			)
			(else
				(NormalEgo)
				(gEgo posn: 275 188 setMotion: MoveTo 250 184)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 298 189 159 174 160 154 124 151 102 164 48 158 59 141 80 140 80 136 43 136 42 140 55 141 43 157 0 157
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 109 187 109 189 0 189 0 187
					yourself:
				)
		)
		(LoadMany rsVIEW 515 320 322 325)
		(if (and gNight [gEgoStats 9]) ; pick locks
			(Load rsSOUND (SoundFX 35))
		)
		(gFeatures
			add:
				onBarrels
				sky
				leftFence
				rightFence
				roundStones
				squareStones
				aWindow
				rtWindow
				onSheriffHouse
				onStand
				onStable
				onGoodsStore
			eachElementDo: #init
		)
		(storeDoor
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
			locked: (if gNight 1 else 0)
		)
		(sheriffDoor
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
			locked: 1
		)
		(if (not (gEgo script:))
			(HandsOn)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 7 0 0 1) ; "You are in the northeast section of town.  The buildings are all brightly painted and the air is filled with the fragrance of apples. This appears to be a market street."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(cond
			(
				(and
					(< (gEgo x:) 3)
					(not (== (gEgo script:) comeIn))
					(not (== (gEgo script:) to330))
				)
				(= global110 0)
				(= style 11)
				(gEgo setScript: to330)
			)
			(
				(and
					(> (gEgo y:) 188)
					(not (== (gEgo script:) comeFromTown))
					(not (== (gEgo script:) backToTown))
					(not (== (centaur script:) centaurScript))
				)
				(= global110 0)
				(gEgo setScript: backToTown)
			)
			((gEgo script:) 0)
			((and (not (gEgo inRect: 210 130 319 185)) local1)
				(= local1 0)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(= global451 0)
		(SetFlag 94)
		(super dispose:)
	)

	(method (notify param1)
		(cond
			((!= param1 1))
			((not (sheriffDoor locked:))
				(self setScript: inToSheriff)
			)
			((not (TrySkill 9 50 global175)) ; pick locks
				(gMessager say: 7 0 0 3) ; "Picking locks looked a lot easier in the instruction book."
			)
			((and (IsFlag 95) (< global107 gDay))
				(gMessager say: 7 0 0 4) ; "The owners seem to have been made nervous by the recent rash of house burglaries. The door is barred from the inside. But you do get some valuable lock-picking practice."
			)
			(else
				(lockSound number: (SoundFX 35) init: play:)
				(gMessager say: 7 0 0 5) ; "You hear a "Snick!". The lock is open!"
				(sheriffDoor locked: 0)
				(self setScript: inToSheriff)
			)
		)
	)
)

(instance sky of Feature
	(properties
		x 279
		y 122
		z 112
		noun 9
		nsLeft 240
		nsBottom 20
		nsRight 318
		sightAngle 40
	)
)

(instance leftFence of Feature
	(properties
		x 22
		y 144
		z 14
		noun 4
		nsTop 115
		nsLeft 1
		nsBottom 146
		nsRight 43
		sightAngle 40
	)
)

(instance rightFence of Feature
	(properties
		x 90
		y 149
		z 14
		noun 4
		nsTop 126
		nsLeft 70
		nsBottom 145
		nsRight 110
		sightAngle 40
	)
)

(instance roundStones of Feature
	(properties
		x 152
		y 151
		noun 12
		nsTop 144
		nsLeft 137
		nsBottom 158
		nsRight 168
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 12 0 0 1) ; "Round stones have been set in the ground to make a walkway."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance squareStones of Feature
	(properties
		x 56
		y 139
		noun 12
		nsTop 132
		nsLeft 45
		nsBottom 147
		nsRight 68
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 12 0 0 2) ; "Square stones make up the walkway."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aWindow of Feature
	(properties
		x 41
		y 121
		z 41
		noun 14
		nsTop 67
		nsLeft 29
		nsBottom 94
		nsRight 53
		sightAngle 40
	)
)

(instance rtWindow of Feature
	(properties
		x 106
		y 127
		z 40
		noun 14
		nsTop 74
		nsLeft 99
		nsBottom 100
		nsRight 114
		sightAngle 40
	)
)

(instance onGoodsStore of Feature
	(properties
		y 36
		noun 13
		nsTop 9
		nsLeft 99
		nsBottom 135
		nsRight 212
		sightAngle 40
		onMeCheck 2
	)
)

(instance onSheriffHouse of Feature
	(properties
		y 36
		noun 6
		nsTop 3
		nsLeft 2
		nsBottom 114
		nsRight 95
		sightAngle 40
		onMeCheck 4
	)
)

(instance onStable of Feature
	(properties
		x 278
		y 94
		noun 10
		nsTop 36
		nsLeft 237
		nsBottom 153
		nsRight 319
		sightAngle 40
		onMeCheck 16
	)
)

(instance onBarrels of Feature
	(properties
		x 247
		y 160
		noun 2
		nsTop 135
		nsLeft 177
		nsBottom 185
		nsRight 317
		sightAngle 40
		onMeCheck 8
	)
)

(instance onStand of Feature
	(properties
		noun 11
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (>= gTimeOfDay 4)
					(gMessager say: 11 0 1) ; "There is no one around. The markets are closed for the night."
				else
					(gMessager say: 11 0 0 1) ; "The selection is meagre and the appearance is not of the best, but the aromas are strangely enticing. A barrel contains some small apples, and there are several types of vegetables on the counter."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance storeDoor of Door
	(properties
		x 170
		y 146
		noun 3
		approachX 160
		approachY 156
		view 320
		priority 9
		entranceTo 322
		facingLoop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if gNight
					(gMessager say: 3 0 0 3) ; "The store is locked."
				else
					(gMessager say: 3 0 0 2) ; "You see a dry goods store through the window."
				)
			)
			(4 ; Do
				(if gNight
					(gMessager say: 3 0 1 2) ; "There is no response. The lock is of a simple type."
				else
					(gCurRoom setScript: enterToStore)
				)
			)
			(17 ; lockPick
				((ScriptID 811 0) doVerb: theVerb) ; Street
			)
			(18 ; thiefKit
				((ScriptID 811 0) doVerb: theVerb) ; Street
			)
			(16 ; dagger
				(gMessager say: 3 16 0 1) ; "You'd probably get arrested if you carved your initials in the door."
			)
			(26 ; brassKey
				(gMessager say: 3 26 0 1) ; "The key doesn't seem to work."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sheriffDoor of Door
	(properties
		x 89
		y 127
		noun 3
		approachX 75
		approachY 136
		view 320
		loop 1
		priority 9
		entranceTo 321
		facingLoop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (< gTimeOfDay 4)
					(gMessager say: 3 0 1 4) ; "You see a nicely furnished living room through the window."
				else
					(gMessager say: 3 0 1 3) ; "The door is bolted."
				)
			)
			(4 ; Do
				(if (< gTimeOfDay 4)
					(gMessager say: 3 0 1 2) ; "There is no response. The lock is of a simple type."
				else
					(gMessager say: 3 0 0 1) ; "The door is locked."
				)
			)
			(17 ; lockPick
				((ScriptID 811 0) doVerb: theVerb) ; Street
			)
			(18 ; thiefKit
				((ScriptID 811 0) doVerb: theVerb) ; Street
			)
			(16 ; dagger
				(gMessager say: 3 16 0 1) ; "You'd probably get arrested if you carved your initials in the door."
			)
			(26 ; brassKey
				(gMessager say: 3 26 0 1) ; "The key doesn't seem to work."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theApples of View
	(properties
		x 230
		y 159
		noun 1
		view 320
		loop 4
	)
)

(instance scales of View
	(properties
		x 233
		y 89
		noun 8
		view 320
		loop 5
	)
)

(instance centaurBody of Prop
	(properties
		x 272
		y 141
		noun 5
		approachX 228
		approachY 186
		view 325
	)

	(method (init)
		(super init:)
	)

	(method (doVerb theVerb)
		(centaur doVerb: theVerb &rest)
	)
)

(instance hildeTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 0 0 2) ; "You see a charming young centaur with the upper torso of a teenager and the body of a filly."
			)
			(4 ; Do
				(gMessager say: 5 4) ; "My father won't let me date strangers."
			)
			(2 ; Talk
				(SolvePuzzle 729 1)
				(super doVerb: theVerb &rest)
			)
			(10 ; silver
				((= gList (List new:))
					add:
						((Clone Ware) name: {Apples} price: {1})
						((Clone Ware) name: {Vegetables} price: {1})
				)
				(switch ((ScriptID 551 0) doit:) ; buy
					(-1
						(gMessager say: 7 0 23) ; "You're a little short on cash. Perhaps you can find work somewhere."
					)
					(1
						(SolvePuzzle 728 3)
						(gEgo setScript: buyFruit)
					)
					(2
						(SolvePuzzle 728 3)
						(gEgo setScript: buyVeg)
					)
				)
			)
			(36 ; flowers
				(gMessager say: 5 36) ; "I'm sorry, but my Father won't allow me to accept flowers from strangers."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance centaur of Prop
	(properties
		x 268
		y 136
		noun 5
		approachX 228
		approachY 186
		view 325
		loop 2
	)

	(method (init)
		(super init:)
		(self setScript: centaurScript)
	)
)

(instance lockSound of Sound
	(properties
		number 35
	)
)

(instance tailScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 40 100))
			)
			(1
				(local0 setCycle: End)
				(= state -1)
			)
		)
	)
)

(instance centaurScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				(if (not (IsFlag 94))
					(User canControl: 0)
					(gMessager say: 7 0 24 0 self) ; "You can smell apples as you approach this corner."
				else
					(= cycles 2)
				)
			)
			(2
				(if (not (IsFlag 94))
					(gMessager say: 5 0 0 3 self) ; "Good day, and welcome to Spielburg. Would you like to buy some of my nice fresh fruits or vegetables?"
					(User canControl: 1)
					(= local1 1)
				else
					(= ticks 30)
				)
			)
			(3
				(if (not (gEgo script:))
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoWakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 7)
			)
			(1
				(HandsOff)
				(gEgo setCycle: Beg self)
			)
			(2
				(NormalEgo)
				(gMessager say: 7 0 0 11 self) ; "However, this was not a good place to sleep. You're stiff and sore all over and your wallet feels very light."
			)
			(3
				(if local3
					(gMessager say: 5 0 5 17 self) ; MISSING MESSAGE
				else
					(self cue:)
				)
			)
			(4
				(HandsOn)
				((gInventory at: 0) amount: 1) ; silver
				((gInventory at: 38) amount: 0) ; gold
				(gEgo use: 0 1) ; silver
				(= ticks 30)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance to330 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -20 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance backToTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 275 self)
			)
			(1
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 45 174 self)
			)
			(1
				(= seconds 1)
			)
			(2
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterToStore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(storeDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: PolyPath 167 140 self)
			)
			(2
				(gCurRoom newRoom: 322)
			)
		)
	)
)

(instance inToSheriff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sheriffDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 89 120 self)
			)
			(2
				(gCurRoom newRoom: 321)
			)
		)
	)
)

(instance outOfStore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 158 170 self)
			)
			(1
				(storeDoor close:)
				(= ticks 30)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance comeFromTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 250 184 self)
			)
			(1
				(= seconds 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance buyFruit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 7 0 26 1 self) ; "You carefully select ten of the best apples from the barrel, and pay Hilde a silver piece."
			)
			(1
				(HandsOn)
				(gEgo get: 22 10) ; fruit
				(= ticks 30)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance buyVeg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 7 0 25 1 self) ; "You pick out the freshest-looking vegetables you can find, and pay the lady a silver piece."
			)
			(1
				(HandsOn)
				(gEgo get: 23 5) ; vegetables
				(= ticks 30)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance hildeTalker of Talker
	(properties
		x 10
		y 10
		view 1320
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= global451 2320)
		(PalVary pvCHANGE_TARGET 2320)
		(AssertPalette 1320)
		(= font gUserFont)
		(super init: hildeBust hildeEye hildeMouth &rest)
	)
)

(instance hildeBust of Prop
	(properties
		view 1320
	)
)

(instance hildeMouth of Prop
	(properties
		nsTop 43
		nsLeft 41
		view 1320
		loop 1
	)
)

(instance hildeEye of Prop
	(properties
		nsTop 30
		nsLeft 36
		view 1320
		loop 2
	)
)

