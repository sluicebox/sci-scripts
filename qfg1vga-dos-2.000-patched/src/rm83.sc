;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 83)
(include sci.sh)
(use Main)
(use n007)
(use Teller)
(use n814)
(use Print)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm83 0
	hermitTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 9] = [0 12 -9 5 -10 -1 -3 -16 999]
	[local14 4] = [0 2 6 999]
	[local18 4] = [0 -4 -17 999]
	[local22 3] = [0 -19 999]
	[local25 4] = [0 7 8 999]
	[local29 3] = [0 -18 999]
	[local32 3] = [0 11 999]
	[local35 5] = [0 -15 -13 -14 999]
	[local40 10]
	[local50 9] = [0 -9 -10 -1 -4 -17 -19 -18 999]
)

(instance rm83 of Rm
	(properties
		noun 17
		picture 83
		style 8
		horizon 80
	)

	(method (doit)
		(if (and (not (IsFlag 360)) (> (Abs (- gGameTime local2)) 2))
			(= local2 gGameTime)
			(Palette palANIMATE 232 238 -1 239 244 -1 245 251 -1)
		)
		(super doit:)
		(cond
			((or local0 global102)
				(if (User canControl:)
					(User canControl: 0)
				)
			)
			((not (User canControl:))
				(User canControl: 1)
			)
		)
		(return
			(if
				(and
					(& (gEgo onControl: 1) $0002)
					(!= (gCurRoom script:) doorScript)
					(!= (gCurRoom script:) sLeaving)
				)
				(if (not (IsFlag 73))
					(self setScript: sLeaving)
				else
					(self setScript: doorScript)
				)
			else
				0
			)
		)
	)

	(method (init)
		(gWalkHandler add: self)
		(= [local40 0] @local5)
		(= [local40 1] @local14)
		(= [local40 2] @local18)
		(= [local40 3] @local22)
		(= [local40 4] @local25)
		(= [local40 5] @local29)
		(= [local40 6] @local32)
		(= [local40 7] @local35)
		(= [local40 8] 999)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 0 189 0 0 96 0 96 75 84 103 129 106 158 118 162 123 158 138 135 149 162 154 183 145 249 142 195 110 150 108 135 94 137 77 133 77 134 0 319 0
					yourself:
				)
		)
		(super init:)
		(NormalEgo)
		(Load rsSOUND 41)
		(SolvePuzzle 699 5)
		(gEgo loop: 2 posn: 116 94 init:)
		(onSeat init: approachVerbs: 4) ; Do
		(gFeatures
			add:
				straw
				theFire
				pot1
				pot2
				pot3
				pot4
				pot5
				pot6
				pot7
				table
				chair
				cot
				bows
				water
				skull
		)
		(glowCoals init: setPri: 15 setCycle: Fwd)
		(waterFallSplash init: cycleSpeed: 6 setCycle: Fwd)
		(caveDoor init:)
		(candle init: setPri: 14 cycleSpeed: 8 setCycle: Fwd)
		(hermitTeller init: hermit @local5 @local40 @local50)
		(hermit init: actions: hermitTeller setPri: 10)
		(gLongSong number: 71 loop: -1 play: 90)
		(hermitSound init: play:)
		(pfSnd number: 28)
		(self setScript: introToHenry)
	)

	(method (dispose)
		(= global451 0)
		(hermitSound fade:)
		(gWalkHandler delete: self)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if local0
					(gEgo setScript: standUp)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(1 ; Look
				(gMessager say: 17 1) ; "The cave is cold and clammy and it smells like mildew and wet dog hair in here! The walls are covered with phosphorescent fungus. The fungus glows eerily in the cave's dim light."
			)
			(4 ; Do
				(if local0
					(gEgo setScript: standUp)
				else
					(gMessager say: 17 4) ; "You should wait until the hermit is asleep to check his place out."
				)
			)
			(51 ; openSpell
				(gMessager say: 17 51) ; "There is no need to use magic to open anything here."
			)
			(50 ; detectMagicSpell
				(gMessager say: 17 50) ; "You can detect a faint aura of magic here."
			)
			(52 ; Sleep
				(cond
					(local0
						(gMessager say: 17 52) ; "You can't sleep in this old rickety chair. Get up and sleep on the bed of straw."
					)
					((not (or (IsFlag 338) (>= ((gInventory at: 1) amount:) 1))) ; rations
						(gCurRoom setScript: sNoSleep)
					)
					((not (CanSleep))
						(EgoSleeps 5)
					)
					(else
						(if (not (IsFlag 338))
							(gEgo use: 1 1) ; rations
						)
						(ClearFlag 338)
						(gCurRoom setScript: sGoSleep)
					)
				)
			)
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(self setScript: TPego)
			)
			(77 ; triggerSpell or Pickup Inventory
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(self setScript: TPego)
			)
			(50 ; detectMagicSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(self setScript: TPego)
			)
			(78 ; dazzleSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(self setScript: TPego)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoOnChair of Feature
	(properties
		x 65
		y 142
		z 100
		nsTop 96
		nsLeft 130
		nsBottom 140
		nsRight 155
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gEgo setScript: standUp)
		else
			(chair doVerb: theVerb &rest)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (== (event message:) JOY_NULL))
				(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
				(& (event type:) $0040) ; direction
			)
			(gCurRoom setScript: standUp)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)

	(method (init)
		(super init: &rest)
		(gDirectionHandler add: self)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(super dispose:)
	)
)

(instance onSeat of Feature
	(properties
		x 134
		y 121
		noun 9
		nsTop 121
		nsLeft 132
		nsBottom 137
		nsRight 153
		approachX 152
		approachY 152
		_approachVerbs 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(if local0
					(= local0 0)
					(gEgo setScript: standUp)
				else
					(gEgo setScript: sitDown)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance table of Feature
	(properties
		x 96
		y 100
		noun 21
		nsTop 100
		nsLeft 92
		nsBottom 143
		nsRight 127
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
			(SetFlag 240)
			(gCurRoom setScript: TPego)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance skull of Feature
	(properties
		x 200
		y 100
		z 68
		noun 19
		nsTop 27
		nsLeft 196
		nsBottom 38
		nsRight 205
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
			(SetFlag 240)
			(gCurRoom setScript: TPego)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theFire of Feature
	(properties
		x 239
		y 148
		noun 7
		nsTop 142
		nsLeft 211
		nsBottom 155
		nsRight 267
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(gMessager say: 19 4) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance straw of Feature
	(properties
		x 171
		y 140
		noun 20
		nsTop 134
		nsLeft 152
		nsBottom 146
		nsRight 190
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
			(SetFlag 240)
			(gCurRoom setScript: TPego)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance chair of Feature
	(properties
		x 159
		y 133
		noun 4
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(gMessager say: 19 4) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cot of Feature
	(properties
		x 227
		y 168
		noun 6
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gMessager say: 19 4) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pot1 of Feature
	(properties
		x 154
		y 91
		noun 10
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(gMessager say: 19 4) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pot2 of Feature
	(properties
		x 154
		y 111
		noun 11
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(gMessager say: 19 4) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pot3 of Feature
	(properties
		x 154
		y 91
		noun 12
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(gMessager say: 19 4) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pot4 of Feature
	(properties
		x 154
		y 91
		noun 13
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(gMessager say: 19 4) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pot5 of Feature
	(properties
		x 154
		y 91
		noun 14
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(gMessager say: 19 4) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pot6 of Feature
	(properties
		x 154
		y 91
		noun 15
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(gMessager say: 19 4) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pot7 of Feature
	(properties
		x 154
		y 91
		noun 16
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(gMessager say: 19 4) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bows of Feature
	(properties
		x 167
		y 45
		noun 1
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(gMessager say: 19 4) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance water of Feature
	(properties
		x 22
		y 36
		noun 22
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
			(SetFlag 240)
			(gCurRoom setScript: TPego)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance niteOutside of Actor
	(properties
		x 117
		y 75
		view 83
		loop 9
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb &rest)
	)
)

(instance caveDoor of Prop
	(properties
		x 144
		y 83
		noun 3
		view 83
		loop 8
		signal 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(local0
						(gMessager say: 3 4) ; "You'll have to get up first."
					)
					((not (IsFlag 73))
						(gCurRoom setScript: sLeaving)
					)
					(else
						(gCurRoom setScript: doorScript)
					)
				)
			)
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poof of Prop
	(properties
		view 83
		loop 5
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb &rest)
	)
)

(instance scroll of Prop
	(properties
		x 114
		y 116
		noun 18
		view 83
		loop 7
		cel 9
		priority 10
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 18 1) ; "It's on the table."
			)
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(if (IsFlag 242)
					(scroll dispose:)
					(gMessager say: 18 4 42) ; "The scroll vanishes even as you read the magical runes upon it. You now have the knowledge to cast a "Trigger" spell."
					(SetFlag 262)
					(gEgo learn: 19 10) ; triggerSpell
					(SolvePuzzle 619 4 1)
				else
					(gCurRoom setScript: sAskScroll)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance candle of Prop
	(properties
		x 101
		y 124
		noun 2
		view 83
		loop 4
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 2 4) ; "It's not polite to steal from your 'airy little 'ost. You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hermit of Prop
	(properties
		x 78
		y 134
		noun 8
		view 83
		loop 3
		signal 16401
	)
)

(instance hermitTeller of Teller
	(properties)

	(method (showDialog &tmp temp0)
		(if
			(==
				(= temp0
					(super
						showDialog:
							-3
							(IsFlag 73)
							-16
							(IsFlag 73)
							-15
							(and (not (IsFlag 262)) (not (IsFlag 242)))
							-13
							(and (IsFlag 242) (not (IsFlag 262)))
							-14
							(IsFlag 262)
					)
				)
				-16
			)
			(= temp0 (Abs temp0))
		)
		(if (== temp0 -3)
			(= temp0 (Abs temp0))
		)
		(if (== temp0 -14)
			(= temp0 (Abs temp0))
		)
		(return temp0)
	)

	(method (doChild)
		(switch query
			(-3
				(return 1)
			)
			(-16
				(return 1)
			)
			(-15
				(gCurRoom setScript: sAskScroll)
			)
			(-13
				(gCurRoom setScript: sAskScroll)
			)
			(else
				(super doChild: query)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(SolvePuzzle 700 2)
				(super doVerb: theVerb &rest)
			)
			(81 ; flameDartSpell
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(gCurRoom setScript: TPego)
			)
			(4 ; Do
				(hermit setScript: sMisc)
			)
			(11 ; rations
				(cond
					(local0
						(gMessager say: 17 52 23) ; "Try sleeping in the bed or on the floor -- this chair just doesn't make it."
					)
					((and (IsFlag 338) gNight)
						(gEgo setScript: sGoSleep)
					)
					((not (gEgo has: 1 1)) ; rations
						(gMessager say: 8 11 22) ; "You can't share what you don't have."
					)
					(gNight
						(gMessager say: 8 11 21) ; "Me guest bed is the straw in the corner over there. You're welcome to stay the night since you've shared your rations. When you want to sleep, just say so."
						(SetFlag 338)
					)
					(else
						(gMessager say: 8 11 20) ; "'Enry is wide awake, and that makes it impossible for you to sleep."
					)
				)
			)
			(16 ; dagger
				(if local0
					(gEgo hide:)
				)
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(hermit setScript: TPego)
			)
			(20 ; rock
				(if local0
					(gEgo hide:)
				)
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(hermit setScript: TPego)
			)
			(12 ; sword
				(if local0
					(gEgo hide:)
				)
				(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
				(SetFlag 240)
				(hermit setScript: TPego)
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
					(gMessager say: 8 34) ; "No thanks. I'm not much o' one for those tree snacks."
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
		(return 1)
	)
)

(instance glowCoals of Prop
	(properties
		x 238
		y 155
		noun 5
		view 83
		priority 12
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
			(SetFlag 240)
			(self setScript: TPego)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance waterFallSplash of Prop
	(properties
		x 41
		y 95
		noun 22
		view 83
		loop 1
		priority 7
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 8 16) ; "You seem to have made the 'ermit un'appy."
			(SetFlag 240)
			(self setScript: TPego)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance dummy of Script ; UNUSED
	(properties)
)

(instance introToHenry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(= cycles 6)
			)
			(1
				(if (IsFlag 73)
					(= state 4)
					(gMessager say: 17 0 26 1 self) ; "Come in, come in. Good to see you again. Get's kind o' tiresome sitten here an' thinken by meself all the time."
				else
					(gMessager say: 17 0 25 1 self) ; "Ello. 'Ow are you? 'Ave we met before?"
				)
			)
			(2
				(gMessager say: 17 0 36 1 self) ; "I'm 'Enry the 'ermit, that's me. Me farther was an 'ermit and me murther was an 'ermit so's I come by me job rightly."
			)
			(3
				(gMessager say: 17 0 37 1 self) ; "Don't 'ave too many visitors. 'Ermits don't, you know. (Part o' the job description.) I likes to see a new face, though."
			)
			(4
				(gMessager say: 17 0 38 1 self) ; "Good to 'ear anurther's speaking besides meself. Sos wot can I do for you?"
			)
			(5
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(egoOnChair init:)
				(self cue:)
			)
			(1
				(gEgo
					view: 504
					setLoop: 0
					setCel: 0
					ignoreActors: 1
					illegalBits: 0
					setCycle: End self
				)
				(= local0 1)
			)
			(2
				(HandsOn)
				(gEgo stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(egoOnChair dispose:)
				(= ticks 6)
			)
			(1
				(gEgo
					view: 504
					setLoop: 0
					setCel: 5
					startUpd:
					ignoreActors: 1
					illegalBits: 0
					setCycle: Beg self
				)
				(= local0 0)
			)
			(2
				(NormalEgo)
				(gEgo setCycle: Walk setMotion: MoveTo 155 146 self)
			)
			(3
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance TPego of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 73)
				(HandsOff)
				(gEgo hide:)
				(poof
					posn: (gEgo x:) (gEgo y:)
					setCycle: CT 6 1 self
					cycleSpeed: 4
					init:
				)
			)
			(1
				(gEgo dispose:)
				(pfSnd init: play:)
				(poof setCycle: End self)
			)
			(2
				(= cycles 10)
			)
			(3
				(poof dispose:)
				(gCurRoom newRoom: 82)
			)
		)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(caveDoor startUpd:)
				(if (and (== (gEgo x:) 80) (== (gEgo y:) 90))
					(self cue:)
				else
					(gEgo setMotion: MoveTo 80 90 self)
				)
				(if gNight
					(niteOutside setPri: (- (caveDoor priority:) 1) init:)
				)
			)
			(1
				(caveDoor ignoreActors: 1 setCycle: End self)
			)
			(2
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) 30)
						(- (gEgo y:) 10)
						self
				)
			)
			(3
				(gCurRoom newRoom: 82)
			)
		)
	)
)

(instance sLeaving of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 73)
				(HandsOff)
				(gEgo setMotion: PolyPath 109 89 self)
			)
			(1
				(gMessager say: 17 0 31 1 self) ; "If you be ever needen a place to stay the night and you're in the area, I could be willen to put you up for the night for sum rations and a couple o' games o' cribbage."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sGoSleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 17 0 29 1 self) ; "After having traded a ration, which the hermit promptly swallowed, and spending a rather boring hour of cribbage and listening to 'Enry chatter, you hit the hay."
			)
			(1
				(gEgo use: 1 1) ; rations
				(gEgo illegalBits: 0 setMotion: MoveTo 204 134 self)
			)
			(2
				(gEgo view: 510 setLoop: 1 setCycle: End self)
			)
			(3
				(gEgo
					view: 523
					setLoop: 0
					setCel: 0
					posn: 191 153
					setPri: 13
					stopUpd:
				)
				(hermit setLoop: 3 setCycle: Fwd)
				(= seconds 6)
			)
			(4
				(gMessager say: 17 0 28 1 self) ; "Unfortunately, since the fungus on the walls shines at night so the room doesn't get dark, and the fact the hermit talks most of the night, you only get five hours rest."
				(SetFlag 73)
			)
			(5
				(EgoSleeps 5)
				(gEgo view: 510 posn: 204 134 setLoop: 1 setCycle: Beg self)
			)
			(6
				(NormalEgo)
				(gEgo setMotion: PolyPath 180 90 self)
			)
			(7
				(Face gEgo hermit self)
				(hermit setCycle: 0)
				(ClearFlag 338)
			)
			(8
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sNoSleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 17 0 33 1 self) ; "You can't sleep here, you got's no rations to give me."
			)
			(1
				(SetFlag 241)
				(client setScript: TPego)
			)
		)
	)
)

(instance sAskScroll of Script
	(properties)

	(method (changeState newState)
		(if client
			(switch (= state newState)
				(0
					(HandsOff)
					(= seconds 3)
				)
				(1
					(cond
						((IsFlag 242)
							(client setScript: sNixScroll)
						)
						([gEgoStats 12] ; magic
							(SetFlag 242)
							(= local3 1)
							(= ticks 60)
						)
						(else
							(gMessager say: 17 0 34) ; "I think you be 'avin too little magic for it to be any use to you."
							(HandsOn)
							(client setScript: 0)
						)
					)
				)
				(2
					(switch
						(Print
							addText: 17 0 24 1 0 0 83 ; "Do you want it?"
							addButton: 1 17 0 35 1 0 30 83 ; "Yes"
							addButton: 2 17 0 35 2 0 48 83 ; "No"
							init:
						)
						(1
							(gCurRoom setScript: sGetScroll)
						)
						(2
							(gCurRoom setScript: sNoScroll)
						)
					)
				)
				(3
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance sNoScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 17 0 32 1 self) ; "Oh well, maybe sumone else can use it sumtime."
			)
			(1
				(HandsOn)
			)
		)
	)
)

(instance sNixScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 262)
					(gMessager say: 17 0 30 1 self) ; "You already 'ave me only scroll."
				else
					(self cue:)
				)
			)
			(1
				(if (IsFlag 262)
					(HandsOn)
					(self dispose:)
				else
					(switch
						(Print
							addText: 17 0 24 1 0 0 83 ; "Do you want it?"
							addButton: 1 17 0 35 1 0 30 83 ; "Yes"
							addButton: 2 17 0 35 2 0 48 83 ; "No"
							init:
						)
						(1
							(gCurRoom setScript: sGetScroll)
						)
						(2
							(gCurRoom setScript: sNoScroll)
						)
					)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
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
				(if (== local4 1)
					(self changeState: 4)
				else
					(= local4 1)
					(gMessager say: 17 0 27 1 self) ; "Let's see. 'Ow does Erasmus do it? Oh, yes."
				)
			)
			(1
				(gMessager say: 17 0 40 1 self) ; "'E summons it with a Trigger. 'Ere goes!"
			)
			(2
				(scroll
					loop: 7
					setPri: 14
					init:
					cycleSpeed: 1
					setCycle: End self
				)
				(pfSnd init: play:)
			)
			(3
				(scroll setLoop: 2 setCel: 1)
				(gMessager say: 17 0 41 1 self) ; "There you 'as it."
			)
			(4
				(HandsOn)
				(if local0
				)
				(self dispose:)
			)
		)
	)
)

(instance sMisc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 21 4 0 1 self) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
			)
			(1
				(HandsOn)
			)
		)
	)
)

(instance getUpSleep of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: standUp self)
			)
			(1
				(self setScript: sGoSleep)
			)
		)
	)
)

(instance hermitSound of Sound
	(properties
		flags -1
		number 41
		loop -1
	)
)

(instance pfSnd of Sound
	(properties
		number 28
	)
)

(instance hermitTalker of Talker
	(properties
		x 10
		y 10
		view 1086
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: hermitBust hermitEye hermitMouth &rest)
	)
)

(instance hermitBust of Prop
	(properties
		view 1086
	)
)

(instance hermitMouth of Prop
	(properties
		nsTop 58
		nsLeft 50
		view 1086
		loop 1
	)
)

(instance hermitEye of Prop
	(properties
		nsTop 28
		nsLeft 50
		view 1086
		loop 2
	)
)

