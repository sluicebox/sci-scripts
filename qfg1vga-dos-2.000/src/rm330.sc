;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use Door)
(use n814)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm330 0
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
)

(procedure (localproc_0) ; UNUSED
	(gMessager say: 12 1 6 1) ; "There is a sign on the door which says: "Gone Fishing"."
)

(instance rm330 of Rm
	(properties
		picture 330
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 12 1 0 0) ; "You have come to the northwest corner of town. There is a butcher's sign over the door of the butcher's shop (amazing coincidence!). You can see a bakery sign over the door of the other shop."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(SetFlag 97)
		(cond
			((IsFlag 117)
				(ClearFlag 117)
			)
			((IsFlag 118)
				(ClearFlag 118)
			)
		)
		(super dispose:)
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 30 147 0 159 318 188 319 189 0 189 0 0 319 0 319 147 308 154 249 149 249 144 242 144 233 149 145 143 169 123 156 125 131 143
					yourself:
				)
		)
		(gCurRoom setRegions: 811 801) ; Street, Town
		(super init:)
		(LoadMany rsVIEW 300 330 515)
		(if (IsFlag 117)
			(LoadMany rsVIEW 503 338)
			(LoadMany rsSOUND 9 66)
		)
		(rm330
			style:
				(switch gPrevRoomNum
					(0 2)
					(320 11)
					(331 -32761)
					(332 -32761)
					(else 0)
				)
		)
		(if (IsFlag 118)
			(Load rsVIEW 503)
		)
		(gFeatures
			add:
				onPots
				onWorkDoor
				onAlley
				butcherWindow
				breadWindow
				onBakeryDoor
				onButcherDoor
				onWorkShop
				onTavern
				onButcherShop
				onBakery
			eachElementDo: #init
		)
		(onBakeryDoor
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
		(onButcherDoor
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
		(onWorkDoor
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
		(butcherSign init:)
		(bakerySign init:)
		(if (and (not (IsFlag 117)) (not (IsFlag 118)))
			(NormalEgo)
			(gEgo init:)
		else
			(gEgo view: 503 init: hide:)
		)
		(if (not (IsFlag 117))
			(tDoor
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
		)
		(cond
			((== gPrevRoomNum 320)
				(NormalEgo)
				(gEgo posn: 289 174)
			)
			((IsFlag 117)
				(gEgo view: 503 posn: 94 114)
			)
			((IsFlag 118)
				(gEgo view: 503 posn: 62 146 setLoop: 2)
			)
			(else
				(NormalEgo)
				(gEgo posn: 269 170)
			)
		)
		(cond
			((== gPrevRoomNum 0)
				(NormalEgo)
				(gEgo posn: 269 170 setMotion: MoveTo 300 174)
			)
			((== gPrevRoomNum 64)
				(gEgo posn: 63 168 setMotion: MoveTo 123 168)
			)
			((and (or (== gPrevRoomNum 331) (== gPrevRoomNum 332)) (= local5 1))
				(cond
					((IsFlag 117)
						(gEgo setScript: kickOutScript)
					)
					((IsFlag 118)
						(tDoor cel: 0 doorState: 0)
						((gInventory at: 38) amount: 0) ; gold
						((gInventory at: 0) amount: 1) ; silver
						(gEgo use: 0 1) ; silver
						(gEgo setScript: gotDrunkScript)
					)
					(else
						(gEgo
							loop: 2
							posn: 88 133
							setScript: outOfTavernScript
						)
					)
				)
			)
			((== gPrevRoomNum 320)
				(NormalEgo)
				(gEgo init: posn: 289 174 setMotion: MoveTo 280 174)
			)
			((== gPrevRoomNum 999)
				((gInventory at: 38) amount: 0) ; gold
				((gInventory at: 0) amount: 1) ; silver
				(gEgo use: 0 1) ; silver
				(gEgo
					view: 951
					posn: 159 168
					setLoop: 1
					cel: 5
					init:
					setScript: 0
				)
				(gCurRoom setScript: egoWakes)
			)
			(else
				(gEgo loop: 2 posn: 145 137 setMotion: MoveTo 148 144)
			)
		)
	)

	(method (doit)
		(cond
			((and gNight (not local4))
				(= local4 1)
				(glint ignoreActors: 1 cycleSpeed: 12 setCycle: Fwd init:)
			)
			((not (>= gTimeOfDay 4))
				(glint dispose:)
			)
		)
		(cond
			(
				(or
					(== local5 1)
					(== (gEgo script:) kickOutScript)
					(== (gEgo script:) gotDrunkScript)
					(== (gEgo script:) outOfTavernScript)
				)
				0
			)
			((< (gEgo y:) 132)
				(= local5 1)
				(gEgo setScript: toTheAlley)
			)
			((> (gEgo x:) 310)
				(= local5 1)
				(= style 12)
				(gEgo setScript: to320)
			)
		)
		(super doit:)
	)

	(method (notify param1)
		(cond
			((!= param1 1))
			((not (TrySkill 9 10 global175)) ; pick locks
				(gMessager say: 12 0 4) ; "You haven't been practicing very much."
			)
			(else
				(gMessager say: 12 0 3) ; "That was the easiest lock you've ever encountered. It's now unlocked."
				(gEgo setScript: enterToTavern)
			)
		)
	)
)

(instance onWorkDoor of Feature
	(properties
		x 12
		y 122
		noun 15
		nsTop 100
		nsLeft 3
		nsBottom 145
		nsRight 22
		sightAngle 40
		approachX 32
		approachY 153
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 15 1) ; "Looks like this door has been closed for a long time."
			)
			(4 ; Do
				(if gNight
					(gMessager say: 15 4 1) ; "The workshop is securely locked."
				else
					(gMessager say: 15 4) ; "The door has been barred and nailed shut. The workshop has long since been abandoned."
				)
			)
			(17 ; lockPick
				((ScriptID 811 0) doVerb: theVerb &rest) ; Street
			)
			(18 ; thiefKit
				((ScriptID 811 0) doVerb: theVerb &rest) ; Street
			)
			(16 ; dagger
				(gMessager say: 15 16) ; "The workshop is mightier than the dagger."
			)
			(26 ; brassKey
				(gMessager say: 15 26 0 1) ; "The key doesn't seem to work."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onPots of Feature
	(properties
		y 36
		noun 11
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 11 1) ; "The pots appear to be just junk."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onWorkShop of Feature
	(properties
		y 36
		noun 16
		nsTop 36
		nsBottom 148
		nsRight 48
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if gNight
					(gMessager say: 16 1 1) ; "The workshop is securely locked."
				else
					(gMessager say: 16 1 0 1) ; "This looks like an abandoned workshop."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onTavern of Feature
	(properties
		x 188
		y 1
		noun 14
		nsLeft 47
		nsBottom 133
		nsRight 127
		sightAngle 40
		onMeCheck 2
	)
)

(instance onAlley of Feature
	(properties
		x 140
		y 83
		noun 1
		nsTop 29
		nsLeft 123
		nsBottom 137
		nsRight 158
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if gNight
					(gMessager say: 1 1 1) ; "It's very dark, but you can see something shining on the ground at the far end of the alley."
				else
					(gMessager say: 1 1 0) ; "It's dark, but there seems to be someone in there."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onButcherShop of Feature
	(properties
		x 186
		y 1
		noun 7
		nsTop -1
		nsLeft 155
		nsBottom 140
		nsRight 254
		sightAngle 40
		onMeCheck 8
	)
)

(instance onButcherDoor of Feature
	(properties
		x 179
		y 109
		noun 6
		nsTop 75
		nsLeft 163
		nsBottom 143
		nsRight 196
		sightAngle 40
		onMeCheck 32
		approachX 172
		approachY 151
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1) ; "The shop seems to be closed. There is a sign on the door which says, 'Gone Fishing'."
			)
			(4 ; Do
				(gMessager say: 6 4) ; "You can't seem to open the door. It might be locked."
			)
			(17 ; lockPick
				((ScriptID 811 0) doVerb: theVerb &rest) ; Street
			)
			(18 ; thiefKit
				((ScriptID 811 0) doVerb: theVerb &rest) ; Street
			)
			(16 ; dagger
				(gMessager say: 6 16) ; "Don't -- you'll dull the dagger."
			)
			(26 ; brassKey
				(gMessager say: 6 26) ; "The key doesn't seem to work."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onBakery of Feature
	(properties
		x 302
		y 1
		noun 3
		onMeCheck 256
	)
)

(instance onBakeryDoor of Feature
	(properties
		x 266
		y 141
		z 49
		noun 2
		nsTop 77
		nsLeft 254
		nsBottom 107
		nsRight 278
		sightAngle 40
		onMeCheck 16
		approachX 255
		approachY 151
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 2 1) ; "The shop seems to be closed although there are some dried-up cupcakes in the window. There is a sign on the door which says, 'Gone Fishing'."
			)
			(4 ; Do
				(gMessager say: 2 4) ; "You can't seem to open the door. It might be locked."
			)
			(17 ; lockPick
				((ScriptID 811 0) doVerb: theVerb &rest) ; Street
			)
			(18 ; thiefKit
				((ScriptID 811 0) doVerb: theVerb &rest) ; Street
			)
			(16 ; dagger
				(gMessager say: 2 16) ; "Sorry, that's a dagger, not a fire axe."
			)
			(26 ; brassKey
				(gMessager say: 2 26) ; "The key doesn't work."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance butcherWindow of Feature
	(properties
		x 210
		y 142
		z 37
		noun 9
		nsTop 90
		nsLeft 199
		nsBottom 121
		nsRight 222
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if gNight
					(gMessager say: 9 1 1) ; "It is too dark to make out anything."
				else
					(gMessager say: 9 1) ; "The Butcher's shop seems to be closed. Through the window, you see what appears a layer of dust over most of the interior."
				)
			)
			(4 ; Do
				(gMessager say: 9 4) ; "You can't seem to open the window."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance breadWindow of Feature
	(properties
		x 299
		y 146
		z 52
		noun 5
		nsTop 87
		nsLeft 293
		nsBottom 102
		nsRight 305
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not gNight)
					(gMessager say: 5 1) ; "The bakery seems to be closed, although there are some dried-up cupcakes in the window."
				else
					(gMessager say: 5 1 1) ; "Other than the sorry-looking goods in the window, it is too dark to make out much of anything."
				)
			)
			(4 ; Do
				(gMessager say: 5 4 1) ; "You can't seem to open the window."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance butcherSign of Feature
	(properties
		x 61
		y 93
		noun 8
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 8 1) ; "A butcher shop."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bakerySign of Feature
	(properties
		x 264
		y 44
		noun 4
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 4 1) ; "The bakery shop."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance glint of Prop
	(properties
		x 158
		y 136
		noun 10
		approachX 141
		approachY 140
		view 330
		loop 4
		priority 5
	)
)

(instance tDoor of Door
	(properties
		x 103
		y 133
		noun 13
		approachX 88
		approachY 136
		view 330
		priority 9
		entranceTo 331
		doorControl 16384
		facingLoop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (> gTimeOfDay 6)
					(gMessager say: 13 1 1) ; "The door is locked."
				else
					(gMessager say: 13 1) ; "Looks like the door to a tavern."
				)
			)
			(4 ; Do
				(if (> gTimeOfDay 6)
					(gMessager say: 13 4 1) ; "The door appears to be locked."
				else
					(gEgo setScript: enterToTavern)
				)
			)
			(17 ; lockPick
				((ScriptID 811 0) doVerb: theVerb &rest) ; Street
			)
			(18 ; thiefKit
				((ScriptID 811 0) doVerb: theVerb &rest) ; Street
			)
			(16 ; dagger
				(gMessager say: 13 16 1) ; "That's a dagger, not a fire axe!"
			)
			(26 ; brassKey
				(gMessager say: 13 26 1) ; "The key doesn't seem to work."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance kickOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(tDoor init:)
				(gEgo
					setLoop: 2
					setCel: 0
					illegalBits: 0
					ignoreActors:
					setPri: 8
					show:
				)
				(self cue:)
			)
			(1
				(fallSound play:)
				(= local2 (gEgo moveSpeed:))
				(= local3 (gEgo cycleSpeed:))
				(= ticks 60)
			)
			(2
				(gEgo
					setPri: 11
					moveSpeed: 0
					cycleSpeed: 6
					setCycle: 0
					setMotion: JumpTo 74 146 self
				)
			)
			(3
				(fallSound number: 66 play: 90)
				(gEgo setCel: -1 setCycle: End self)
			)
			(4
				(ShakeScreen 5)
				(tDoor close: stopUpd:)
				(= seconds 2)
			)
			(5
				(= seconds 5)
			)
			(6
				(gEgo setLoop: 4 setCel: 0 setCycle: End self)
			)
			(7
				(if (not (TakeDamage 5))
					(TakeDamage -5)
				)
				(= local5 0)
				(HandsOn)
				(NormalEgo)
				(EgoGait 0) ; walking
				(gEgo moveSpeed: local2 cycleSpeed: local3 loop: 2 cel: 2)
				(self dispose:)
			)
		)
	)
)

(instance gotDrunkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local3 (gEgo cycleSpeed:))
				(gEgo setCel: 3 illegalBits: 0 setPri: 8 show:)
				(= seconds 7)
			)
			(1
				(gMessager say: 13 26 1 2 self) ; "You regain consciousness."
			)
			(2
				(gMessager say: 12 0 0 0 self) ; "After dusting yourself off, you check to make sure you're still in one piece."
			)
			(3
				(gEgo setLoop: 4 setCel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(4
				(= local5 0)
				(EgoGait 0) ; walking
				(gEgo cycleSpeed: local3)
				(NormalEgo)
				(HandsOn)
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
				(gMessager say: 12 0 0 4 self) ; "However, this was not a good place to sleep. You're stiff and sore all over and your wallet feels very light."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance to320 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 340 175 self)
			)
			(1
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance enterToTavern of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(tDoor stopUpd:)
				(gEgo setMotion: MoveTo 93 134 self)
			)
			(1
				(gEgo setCycle: 0 setMotion: 0)
				(self cue:)
			)
			(2
				(gCurRoom newRoom: 331)
			)
		)
	)
)

(instance outOfTavernScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 30)
			)
			(1
				(gEgo setMotion: MoveTo 85 151 self)
			)
			(2
				(tDoor close:)
				(= local5 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toTheAlley of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 1)
			)
			(1
				(if gNight
					(gCurRoom newRoom: 334)
				else
					(gCurRoom newRoom: 333)
				)
			)
		)
	)
)

(instance fallSound of Sound
	(properties
		number 9
	)
)

