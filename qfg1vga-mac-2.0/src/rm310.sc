;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use Door)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm310 0
)

(local
	local0
)

(instance rm310 of Rm
	(properties
		noun 6
		picture 310
		style 8
	)

	(method (dispose)
		(SetFlag 90)
		(super dispose:)
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 190 0 190 0 0 319 0 319 171 278 157 274 149 260 144 252 148 235 140 210 144 194 121 193 116 210 111 190 106 180 106 150 99 136 104 189 120 200 149 197 153 125 129 82 137 82 150 4 160 4 187 319 187
					yourself:
				)
		)
		(if (and (>= gTimeOfDay 4) [gEgoStats 9]) ; pick locks
			(Load rsSOUND 2035)
		)
		(Load rsVIEW 310)
		(Load rsVIEW 515)
		(super init:)
		(onGuildSign init: setOnMeCheck: 26505)
		(magicShopSign init: setOnMeCheck: 26505)
		(theLock init: setOnMeCheck: 26505)
		(unknown_310_4 init: setOnMeCheck: 1 2)
		(unknown_310_3 init: setOnMeCheck: 1 16)
		(unknown_310_5 init: setOnMeCheck: 1 4)
		(self setRegions: 811 801) ; Street, Town
		(gTheIconBar enable:)
		(NormalEgo)
		(if (!= gPrevRoomNum 314)
			(gEgo illegalBits: (if (> gTimeOfDay 4) -32768 else -30720) init:)
		)
		(theEye
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
			stopUpd:
		)
		(if (< gTimeOfDay 4)
			(LOL init: cycleSpeed: 10 setCycle: Fwd startUpd:)
		)
		(LOLDoor
			init:
			locked: 1
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
		(guildDoor
			init:
			locked: (if gNight 1 else 0)
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
		(switch gPrevRoomNum
			(0
				(gEgo posn: 315 177 setMotion: MoveTo 305 170)
			)
			(300
				(gCurRoom setScript: enterFrom300)
			)
			(311
				(gEgo posn: 61 155 loop: 0)
				(guildDoor close:)
			)
			(313
				(gEgo posn: 190 110)
				(LOLDoor close:)
			)
			(314
				(gCurRoom setScript: exitTheMagicShop)
			)
			(999
				(gEgo view: 515 setLoop: 3 cel: 5 init: setScript: egoWakes)
			)
			(else
				(gEgo x: 160 y: 160)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(
				(and
					(> (gEgo x:) 310)
					(!= (gCurRoom script:) enterFrom300)
					(!= (gCurRoom script:) enter300)
				)
				(= global110 0)
				(gCurRoom setScript: enter300)
			)
			((and (== temp0 1024) (not (gCurRoom script:)))
				(gCurRoom setScript: enterMagicShop)
			)
		)
	)

	(method (notify param1)
		(cond
			((!= param1 1))
			((not (LOLDoor locked:))
				(gMessager say: 6 0 5) ; "The door isn't locked. Just turn around."
			)
			((not (TrySkill 9 30 global175)) ; pick locks
				(gMessager say: 6 0 4) ; "Picking locks looked a lot easier in the instruction book."
			)
			((and (IsFlag 92) (< global108 gDay))
				(gMessager say: 6 0 6) ; "The owners seem to have been made nervous by the recent rash of house burglaries. The door is barred from the inside. But you do get some valuable lock-picking practice."
			)
			(else
				(lockSound number: 2035 init: play:)
				(gMessager say: 6 0 7) ; "You hear a "Snick!". The lock is open!"
				(LOLDoor facingLoop: (gEgo loop:) locked: 0)
				(gCurRoom setScript: enterLOLLand)
			)
		)
	)
)

(instance guildDoor of Door
	(properties
		x 16
		y 150
		noun 1
		approachX 61
		approachY 155
		view 310
		loop 2
		priority 9
		entranceTo 311
		facingLoop 1
	)

	(method (init)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if gNight
					(gMessager say: 1 1 2) ; "The Guild Hall building appears to be dark and closed up."
				else
					(gMessager say: 1 1 1) ; "You can just see a thin thread of light under the door, so there is probably someone inside."
				)
			)
			(4 ; Do
				(if gNight
					(gMessager say: 1 4 2) ; "The door appears to be locked."
				else
					(gCurRoom setScript: enterToGuildHall)
				)
			)
			(17 ; lockPick
				((ScriptID 811 0) doVerb: theVerb) ; Street
			)
			(18 ; thiefKit
				((ScriptID 811 0) doVerb: theVerb) ; Street
			)
			(26 ; brassKey
				(gMessager say: 1 26 0) ; "That key doesn't fit this lock."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theLock of Feature
	(properties
		noun 8
		nsTop 76
		nsLeft 193
		nsBottom 89
		nsRight 208
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 8 1 0) ; "Not the sturdiest lock you've ever seen."
			)
			(else
				(LOLDoor doVerb: theVerb &rest)
			)
		)
	)
)

(instance unknown_310_3 of Feature
	(properties
		noun 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 9 1 0 1) ; "You can't see through the window."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance unknown_310_4 of Feature
	(properties
		noun 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 10 1 0 1) ; "The window is too high to look into."
			)
			(4 ; Do
				(gMessager say: 10 4 0 1) ; "You're too short... so stop trying to open the window."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance unknown_310_5 of Feature
	(properties
		noun 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 11 1 0 1) ; "It looks really dark back there."
			)
			(4 ; Do
				(gMessager say: 11 4 0 1) ; "The fence is too high to climb over."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance LOLDoor of Door
	(properties
		x 217
		y 109
		noun 3
		approachX 190
		approachY 110
		view 310
		loop 1
		priority 4
		signal 16
		entranceTo 313
		facingLoop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (< gTimeOfDay 4)
					(gMessager say: 3 1 1) ; "This looks like a nice, neat little house. There is a grandmotherly Little Old Lady rocking on the front porch."
				else
					(gMessager say: 3 1 2) ; "The house looks closed up. There is no sign of the Little Old Lady."
				)
			)
			(4 ; Do
				(cond
					((< gTimeOfDay 4)
						(gMessager say: 3 4 1) ; "The door appears to be locked, and there is no answer to your knock. The occupant is out (right in front of you, in fact)."
					)
					((== locked 0)
						(gCurRoom setScript: enterLOLLand)
					)
					(else
						(gMessager say: 3 4 2) ; "No one seems to be home, and the door is securely locked."
					)
				)
			)
			(17 ; lockPick
				((ScriptID 811 0) doVerb: theVerb) ; Street
			)
			(18 ; thiefKit
				((ScriptID 811 0) doVerb: theVerb) ; Street
			)
			(26 ; brassKey
				(gMessager say: 3 26 0) ; "The key doesn't fit."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theEye of Prop
	(properties
		x 259
		y 47
		noun 7
		view 310
		loop 3
		priority 10
		signal 16400
		cycleSpeed 10
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit: &rest)
		(= temp2 (gEgo x:))
		(= temp0 cel)
		(cond
			((<= temp2 200)
				(= temp1 0)
			)
			((<= temp2 260)
				(= temp1 1)
			)
			((<= temp2 280)
				(= temp1 2)
			)
			((<= temp2 300)
				(= temp1 3)
			)
			((<= temp2 310)
				(= temp1 4)
			)
			(else
				(= temp1 5)
			)
		)
		(if (!= temp0 temp1)
			(self cel: temp1 forceUpd:)
		)
	)
)

(instance LOL of Prop
	(properties
		x 163
		y 114
		noun 4
		view 310
		loop 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager say: 4 57 0) ; "She's really sleeping soundly and doesn't notice your presence."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance magicShopSign of Feature
	(properties
		x 260
		y 145
		z 96
		noun 5
		nsTop 37
		nsLeft 252
		nsBottom 61
		nsRight 268
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onGuildSign of Feature
	(properties
		x 90
		y 133
		z 36
		noun 2
		nsTop 85
		nsLeft 75
		nsBottom 109
		nsRight 106
	)
)

(instance lockSound of Sound
	(properties
		number 2035
	)
)

(instance enterToGuildHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 61 155 self)
			)
			(1
				(guildDoor setCycle: End self)
			)
			(2
				(gMessager say: 1 4 1 0 self) ; "You enter the Adventurers' Guild Hall."
			)
			(3
				(gEgo setMotion: MoveTo 41 130 self)
			)
			(4
				(HandsOn)
				(gCurRoom newRoom: 311)
			)
		)
	)
)

(instance enterMagicShop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 266 146 self)
			)
			(1
				(gEgo setHeading: 45 setMotion: MoveTo 272 142 self)
			)
			(2
				(HandsOn)
				(gCurRoom newRoom: 314)
			)
		)
	)
)

(instance exitTheMagicShop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(HandsOff)
				(gEgo
					init:
					show:
					illegalBits: (if (> gTimeOfDay 4) -32768 else -30720)
					posn: 256 155
					heading: 225
					setMotion: MoveTo 245 161 self
				)
			)
			(1
				1
				(HandsOn)
				(NormalEgo)
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
				(HandsOff)
				(gEgo setCycle: Beg self)
			)
			(1
				(NormalEgo)
				(gMessager say: 6 0 3) ; "However, this was not a good place to sleep. You're stiff and sore all over and your wallet feels very light."
				((gInventory at: 38) amount: 0) ; gold
				((gInventory at: 0) amount: 0) ; silver
				(HandsOn)
			)
		)
	)
)

(instance enterLOLLand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(LOLDoor setCycle: End self)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: 313)
			)
		)
	)
)

(instance enter300 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 350 180 self)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance enterFrom300 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 350 177 setMotion: MoveTo 280 170 self)
			)
			(1
				(HandsOn)
				(client setScript: 0)
				(self dispose:)
			)
		)
	)
)

