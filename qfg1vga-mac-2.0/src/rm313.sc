;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 313)
(include sci.sh)
(use Main)
(use n814)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use SmoothLooper)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm313 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	[local13 2]
	local15
)

(procedure (localproc_0)
	(SolvePuzzle 629 3 2)
	(gEgo setScript: catPetOrFeed1)
)

(procedure (localproc_1)
	(if (IsFlag 132)
		(AlreadyDone)
	else
		(gMessager say: 27 0 33) ; "In the purse, you find 20 silvers and some soiled hankies. You take the silver."
		(= local15 1)
		(SetFlag 132)
		(SolvePuzzle 626 1 2)
		(gEgo setScript: cuedIt)
	)
)

(procedure (localproc_2)
	(if (IsFlag 131)
		(AlreadyDone)
	else
		(gMessager say: 27 0 31) ; "A string of pearls seems to have fallen into the bag among the knitting. You take the pearls, of course. (The knitting you can do without.)"
		(= local15 2)
		(SetFlag 131)
		(SolvePuzzle 627 1 2)
		(gEgo setScript: cuedIt)
	)
)

(procedure (localproc_3)
	(if (IsFlag 135)
		(AlreadyDone)
	else
		(gEgo setScript: birdieSings)
	)
)

(instance catTurn of SmoothLooper
	(properties
		vChangeDir 637
	)
)

(instance rm313 of Rm
	(properties
		noun 27
		picture 313
		style 2
	)

	(method (newRoom newRoomNumber)
		(SetFlag 92)
		(= global275 26)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gEgo observeControl: -32768)
		(DisposeScript 927)
		(DisposeScript 968)
		(super dispose:)
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 25 189 242 189 319 163 314 143 281 146 220 128 200 118 184 120 156 74 136 68 176 133 149 134 95 117 20 135 8 189
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 319 189 246 189 319 167 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 162 156 162 177 134 187 109 178 103 165
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 105 127 120 135 124 152 77 170 64 170 38 150
					yourself:
				)
		)
		(LoadMany rsVIEW 313 635 636 525)
		(Load rsSCRIPT 927)
		(Load rsSOUND 8)
		(Load rsSOUND 52)
		(super init:)
		(SolvePuzzle 623 5 2)
		(= local3 0)
		(onPlant init: setOnMeCheck: 26505)
		(onTable init: setOnMeCheck: 26505)
		(onDoor init: setOnMeCheck: 26505)
		(onStorageBox init: setOnMeCheck: 26505)
		(onChair init: setOnMeCheck: 1 32)
		(onStair init: setOnMeCheck: 1 128)
		(onDrawer init: setOnMeCheck: 1 2)
		(onFirePlace init: setOnMeCheck: 1 8)
		(onRug init: setOnMeCheck: 1 64)
		(onCouch init: setOnMeCheck: 1 4)
		(onTableFood init: setOnMeCheck: 1 16)
		(onCouch
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
			init:
		)
		(onPlant
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
		(gEgo
			posn: 159 189
			init:
			ignoreControl: -32768
			setAvoider: PAvoider
			setScript: enterRoom
		)
		(= global275 52)
		(cat
			init:
			setStep: 2 1
			setAvoider: PAvoider
			setCycle: Walk
			setScript: catWalk
		)
		(lamp1 cel: 0 init: setCycle: Fwd)
		(lampLight cel: 0 init: setCycle: Fwd)
		(cageStand init:)
		(theCandles init: setCycle: Fwd)
		(purse
			cel: 2
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
			init:
		)
		(birdcage cel: 5 init:)
		(drawer init:)
		(bag
			cel: 1
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
			init:
		)
		(if (not (IsFlag 133))
			(candle1 cel: 0 ignoreActors: init:)
			(candle2 cel: 0 ignoreActors: init:)
		)
		(self setRegions: 801) ; Town
		(self setScript: first313Script)
		(sillyThief init: play:)
		(Load rsSCRIPT 968)
		(Load rsSCRIPT 927)
	)

	(method (doit)
		(cond
			((gEgo script:) 0)
			(
				(and
					(& (gEgo onControl: 1) $4000)
					(< (gEgo distanceTo: cat) 25)
					(not local2)
					(not local9)
				)
				(= local2 1)
				(= local4 3)
				(gEgo setScript: gonnaGetYou)
			)
			((> (gEgo y:) 187)
				(if (not gNight)
					(EgoDead 52 53) ; "The Little Old Lady's screams finally brought the sheriff and Otto. Next time you'd better finish your "work" before dawn!"
				else
					(cat dispose:)
					(= global108 gDay)
					(gCurRoom newRoom: 310)
				)
			)
			(
				(and
					(& (gEgo onControl: 1) $2000)
					(or
						(== (gEgo loop:) 3)
						(== (gEgo loop:) 6)
						(== (gEgo loop:) 7)
					)
					(!= local1 1)
				)
				(= local1 1)
				(gEgo setMotion: 0 setScript: climbUp1)
			)
			(
				(and
					(& (gEgo onControl: 1) $1000)
					(or
						(== (gEgo loop:) 3)
						(== (gEgo loop:) 6)
						(== (gEgo loop:) 7)
					)
					(!= local1 2)
				)
				(= local1 2)
				(gEgo setMotion: 0 setScript: climbUp2)
			)
			(
				(and
					(& (gEgo onControl: 1) $0800)
					(or
						(== (gEgo loop:) 3)
						(== (gEgo loop:) 6)
						(== (gEgo loop:) 7)
					)
					(!= local1 3)
				)
				(= local1 3)
				(gEgo setMotion: 0 setScript: climbUp3)
			)
			((== (gEgo onControl: 1) 1024)
				(= local1 0)
			)
		)
		(super doit:)
	)
)

(instance onStorageBox of Feature
	(properties
		x 31
		y 115
		noun 29
		nsTop 106
		nsLeft 17
		nsBottom 125
		nsRight 45
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 29 1) ; "It's a large, wooden chest, undoubtedly filled with priceless treasures."
			)
			(4 ; Do
				(gMessager say: 12 4) ; "The chest is filled with old quilts, doilies, and sweaters five sizes too large for anyone to wear. You really don't want any of them, so you close the chest again."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onChair of Feature
	(properties
		x 223
		y 104
		noun 10
	)
)

(instance onStair of Feature
	(properties
		x 159
		y 94
		noun 19
	)
)

(instance onDoor of Feature
	(properties
		x 110
		y 38
		noun 19
		nsTop 14
		nsLeft 99
		nsBottom 63
		nsRight 121
	)
)

(instance onDrawer of Feature
	(properties
		x 61
		y 122
		z 40
		noun 20
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: SearchDesk)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onFirePlace of Feature
	(properties
		x 268
		y 115
		noun 21
	)
)

(instance onTable of Feature
	(properties
		x 134
		y 180
		z 20
		noun 31
		nsTop 153
		nsLeft 117
		nsBottom 168
		nsRight 152
	)
)

(instance onPlant of Feature
	(properties
		x 153
		y 45
		noun 24
		nsTop 21
		nsLeft 144
		nsBottom 69
		nsRight 162
		approachX 142
		approachY 72
	)
)

(instance onRug of Feature
	(properties
		x 180
		y 174
		noun 28
	)
)

(instance onCouch of Feature
	(properties
		x 85
		y 130
		noun 17
		approachX 100
		approachY 167
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 130)
					(gMessager say: 17 4 25) ; "You find nothing else by searching the couch."
				else
					(gMessager say: 17 4 24) ; "You find 3 silvers that have gotten caught in the cracks."
					(= local15 3)
					(SetFlag 130)
					(SolvePuzzle 625 1 2)
					(gEgo setScript: cuedIt)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onTableFood of Feature
	(properties
		x 307
		y 181
		noun 30
	)
)

(instance cageStand of View
	(properties
		x 209
		y 96
		noun 4
		approachX 200
		approachY 120
		view 313
		loop 3
		priority 6
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(birdcage doVerb: 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance candle1 of View
	(properties
		x 71
		y 73
		noun 5
		approachX 66
		approachY 124
		view 313
		loop 2
		priority 10
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 133)
					(AlreadyDone)
				else
					(gCurRoom setScript: toTheCandles)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance candle2 of View
	(properties
		x 55
		y 74
		noun 6
		approachX 66
		approachY 124
		view 313
		loop 2
		priority 10
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(candle1 doVerb: 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance purse of View
	(properties
		x 72
		y 134
		noun 25
		approachX 100
		approachY 167
		view 313
		loop 2
		cel 2
		priority 12
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(localproc_1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bag of View
	(properties
		x 74
		y 154
		noun 1
		approachX 100
		approachY 167
		view 313
		loop 2
		cel 1
		priority 10
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(localproc_2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance birdcage of Prop
	(properties
		x 209
		y 96
		noun 2
		approachX 200
		approachY 120
		view 313
		loop 5
		priority 6
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: removeCover)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lamp1 of Prop
	(properties
		x 262
		y 75
		noun 22
		view 313
		loop 8
		priority 7
		signal 16401
	)
)

(instance lampLight of Prop
	(properties
		x 283
		y 97
		noun 23
		view 313
		loop 6
		priority 6
		signal 16401
	)
)

(instance theCandles of Prop
	(properties
		x 245
		y 37
		noun 11
		view 313
		loop 7
		priority 14
		signal 16
	)
)

(instance drawer of Prop
	(properties
		x 64
		y 95
		noun 20
		approachX 101
		approachY 124
		view 313
		loop 1
		priority 5
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: SearchDesk)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cat of Actor
	(properties
		x 266
		y 160
		noun 9
		view 635
	)

	(method (dispose)
		(self setScript: 0 setLoop: 0 setAvoider: 0 setCycle: 0 looper: 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local7 1)
				(localproc_0)
			)
			(11 ; rations
				(= local8 1)
				(localproc_0)
			)
			(16 ; dagger
				(= local11 1)
				(gEgo setMotion: 0)
				(HandsOff)
				(cat setScript: gonnaGetYou)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance birdieSings of Script
	(properties)

	(method (changeState newState &tmp [temp0 450])
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 135)
				(= local10 1)
				(birdcage loop: 5 cel: 0 setCycle: End self startUpd:)
			)
			(1
				(birdcage loop: 4 setCel: 0 setCycle: End)
				(= cycles 2)
			)
			(2
				(gMessager say: 3 0 2 1 self) ; "CHIRP! CHIRP!"
			)
			(3
				(gMessager say: 3 0 4 1 self) ; "You hear a voice from upstairs saying, "Kitty, you'd better not be bothering the little birdie again!""
			)
			(4
				(gMessager say: 3 0 1 1 self) ; "Who would think a little birdie could be so noisy!"
			)
			(5
				(gMessager say: 3 0 3 1 self) ; "You quickly cover the cage and hope the bird shuts up."
			)
			(6
				(birdcage loop: 5 setCel: 3 setCycle: Beg self)
			)
			(7
				(birdcage stopUpd:)
				(= local10 0)
				(HandsOn)
				(gEgo ignoreControl: -32768)
				(self dispose:)
			)
		)
	)
)

(instance deskOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(drawer setCycle: End self)
			)
			(1
				(= ticks 60)
			)
			(2
				(gMessager say: 18 0 26 1 self) ; "You find a single silver in one of the desk drawers. You find nothing else of any value to you."
			)
			(3
				(gEgo get: 0 1) ; silver
				(SetFlag 134)
				(drawer setCycle: Beg self)
			)
			(4
				(HandsOn)
				(gEgo ignoreControl: -32768)
				(self dispose:)
			)
		)
	)
)

(instance first313Script of Script
	(properties)

	(method (changeState newState &tmp [temp0 400])
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (or (not (IsFlag 92)) (!= gPrevRoomNum 0))
					(gMessager say: 27 0 29 1 self) ; "The smell of lavender and dust fills your nose as you walk in. This reminds you of a great aunt's house you once visited."
				else
					(client setScript: 0)
				)
			)
			(2
				(if (or (not (IsFlag 92)) (!= gPrevRoomNum 0))
					(gMessager say: 27 0 30 1 self) ; "There is a covered birdcage near the stairs, and a knitting basket beside the couch."
				)
				(client setScript: 0)
			)
		)
	)
)

(instance catWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cat setLoop: 8 setAvoider: PAvoider setMotion: 0)
				(self cue:)
			)
			(1
				(if (not (cat looper:))
					(cat setLoop: catTurn)
				)
				(cat
					setLoop: 0
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 278 153 self
				)
			)
			(2
				(cat setLoop: 4 cel: 0 setMotion: MoveTo 229 135 self)
			)
			(3
				(cat setLoop: 2 cel: 0 setMotion: MoveTo 201 143 self)
			)
			(4
				(= state 0)
				(cat setLoop: 0 cel: 0 setMotion: MoveTo 266 160 self)
			)
		)
	)
)

(instance catPetOrFeed1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cat setMotion: 0 setScript: 0)
				(gEgo
					setMotion: PolyPath (+ (cat x:) 15) (+ (cat y:) 15) self
				)
			)
			(1
				(self cue:)
			)
			(2
				(Face gEgo cat)
				(= cycles 2)
			)
			(3
				(= local9 1)
				(if local7
					(switch local3
						(0
							(gMessager say: 8 0 13 1 self) ; "You pet the nice kitty."
							(= local3 1)
						)
						(1
							(gMessager say: 8 0 14 1 self) ; "The cat really likes being petted."
							(= local3 2)
						)
						(2
							(gMessager say: 8 0 15 1 self) ; "This is a very insistent cat."
						)
					)
				)
				(if local8
					(switch local3
						(0
							(gMessager say: 8 0 10 1 self) ; "You feed the nice kitty a crumb."
							(= local3 1)
						)
						(1
							(gMessager say: 8 0 11 1 self) ; "The cat really likes being fed. You give it a leftover morsel."
							(= local3 2)
						)
						(2
							(if (gEgo has: 1) ; rations
								(gMessager say: 8 0 9 1 self) ; "This is a very insistent cat. You give it one of your rations."
							else
								(gMessager say: 8 0 12 1 self) ; "You have nothing substantial to feed the cat."
							)
						)
					)
				)
			)
			(4
				(if (and (== local3 2) (gEgo has: 1)) ; rations
					(gEgo use: 1 1) ; rations
				)
				(= local8 0)
				(= local7 0)
				(HandsOn)
				(gEgo ignoreControl: -32768)
				(= seconds 5)
			)
			(5
				(cat setScript: catWalk)
				(= local9 0)
				(self dispose:)
			)
		)
	)
)

(instance catChasesEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 1)
				(= seconds 0)
				(if (not (cat looper:))
					(cat setLoop: catTurn)
				)
				(self cue:)
			)
			(1
				(= local2 0)
				(++ local4)
				(cat setCycle: End setMotion: 0)
				(= cycles 2)
			)
			(2
				(gMessager say: 7 0 8 1 self) ; "You have a bad feeling about the very deep, low growl emanating from the cat."
			)
			(3
				(gEgo setScript: catAttack)
			)
		)
	)
)

(instance gonnaGetYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (cat looper:))
					(cat setLoop: catTurn)
				)
				(cat setMotion: 0)
				(if gNight
					(if (== local11 1)
						(gMessager say: 26 0 27 1 self) ; "That'll teach you to play daggers with a cat!"
					else
						(gMessager say: 26 0 28 1 self) ; "Oh, Oh! Looks like you've blundered into the cat's territory."
					)
				else
					(self cue:)
				)
			)
			(1
				(gEgo
					illegalBits: 0
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 155 140 self
				)
			)
			(2
				(cat
					loop: 1
					ignoreActors:
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 189 154 self
				)
			)
			(3
				(gEgo setScript: catChasesEgo)
			)
		)
	)
)

(instance catAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 156 143 self)
			)
			(1
				(gEgo view: 525 setLoop: 4 cel: 0)
				(self cue:)
			)
			(2
				(cat
					view: 635
					illegalBits: 0
					ignoreActors:
					looper: 0
					setLoop: 7
					cel: 0
					posn: 189 154
					setCycle: End self
				)
				(gEgo setCycle: Fwd setMotion: MoveTo 126 141)
			)
			(3
				(cat
					view: 636
					loop: 0
					cel: 0
					posn: 189 154
					setPri: 10
					cycleSpeed: 12
					setCycle: CT 5 1 self
				)
			)
			(4
				(gEgo posn: 1000 1000)
				(cat setCel: 5 setCycle: CT 8 1 self)
			)
			(5
				(cat setCel: 8 setCycle: CT 10 1 self)
			)
			(6
				(cat view: 636 loop: 1 cel: 0 posn: 111 128 setCycle: Fwd)
				(= seconds 5)
			)
			(7
				(if local6
					(EgoDead 112 113 1 0 637) ; "The Little Old Lady's cries finally bring the Sheriff and Otto to her rescue. They find you pinned to the floor, unconscious, dreaming deliriously of death by sandpaper."
				else
					(EgoDead 110 111 1 0 637) ; "When the Little Old Lady awakens to see what's going on, you have to concede to her (through lips that are as raw as hamburger) that you've been licked! She summons the Sheriff and his goon, Otto."
				)
			)
		)
	)
)

(instance getReady of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (cat looper:))
					(cat setLoop: catTurn)
				)
				(cat loop: 4 setCycle: Walk setMotion: MoveTo 189 154 self)
			)
			(1
				(gEgo setScript: catAttack)
				(= seconds 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance climbUp1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local5 1)
				(gEgo setLoop: 1 illegalBits: 0)
				(self cue:)
			)
			(1
				(gEgo setLoop: -1 illegalBits: -32768)
				(gMessager say: 14 0 18 1 self) ; "SQUEEEEAK!"
			)
			(2
				(= local12 1)
				(HandsOn)
				(gEgo ignoreControl: -32768)
				(self dispose:)
			)
		)
	)
)

(instance climbUp2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setLoop: 1)
				(self cue:)
			)
			(1
				(gEgo setLoop: -1 illegalBits: -32768)
				(gMessager say: 15 0 19 1 self) ; "CREEEEAAK!"
			)
			(2
				(HandsOn)
				(gEgo ignoreControl: -32768)
				(self dispose:)
			)
		)
	)
)

(instance climbUp3 of Script
	(properties)

	(method (changeState newState &tmp [temp0 450])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setLoop: 1)
				(self cue:)
			)
			(1
				(HandsOn)
				(gEgo setLoop: -1 ignoreControl: -32768 illegalBits: -32768)
				(gMessager say: 16 0 23 1 self) ; "SCRAAAAWK!"
			)
			(2
				(gMessager say: 16 0 20 1 self) ; "The owner of the house awakens..."
			)
			(3
				(gMessager say: 16 0 22 1 self) ; "Help! Burglars! Sheriff! Help! Kitty! Kitty!"
				(= local6 1)
			)
			(4
				(gEgo setScript: climbDown)
			)
		)
	)
)

(instance climbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cat setScript: getReady)
				(= local1 0)
				(gEgo
					illegalBits: 0
					setLoop: 2
					setMotion: MoveTo 182 127 self
				)
			)
			(1
				(if local6
					(gMessager say: 13 0 16 1 self) ; "KITTY!!!"
				else
					(HandsOn)
					(gEgo
						setLoop: -1
						ignoreControl: -32768
						illegalBits: -32768
					)
					(gEgo setScript: 0)
					(cat setScript: catWalk)
				)
			)
			(2
				(if local6
					(gEgo setLoop: -1)
				)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 172 181 self)
			)
			(1
				(HandsOn)
				(gEgo ignoreControl: -32768)
				(self dispose:)
			)
		)
	)
)

(instance SearchDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (== (gEgo x:) 76) (== (gEgo y:) 130))
					(self cue:)
				else
					(gEgo
						ignoreControl: -32768
						setMotion: PolyPath 46 179 self
					)
				)
			)
			(1
				(gEgo setMotion: PolyPath 76 130 self)
			)
			(2
				(if (IsFlag 134)
					(gMessager say: 27 0 32 1 self) ; "You find nothing else of value in the desk."
				else
					(SolvePuzzle 624 1 2)
					(gEgo setScript: deskOpen)
				)
			)
			(3
				(gEgo observeControl: -32768)
				(HandsOn)
				(gEgo ignoreControl: -32768)
				(self dispose:)
			)
		)
	)
)

(instance removeCover of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 0)
				(gEgo setMotion: PolyPath 200 120 self)
			)
			(1
				(localproc_3)
				(= seconds 3)
			)
			(2
				(HandsOn)
				(gEgo ignoreControl: -32768)
				(= local2 1)
				(self dispose:)
			)
		)
	)
)

(instance toTheCandles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo get: 34 1) ; candleSticks
				(HandsOff)
				(if (and (== (gEgo x:) 76) (== (gEgo y:) 130))
					(self cue:)
				else
					(gEgo
						ignoreControl: -32768
						setMotion: PolyPath 46 179 self
					)
				)
			)
			(1
				(gEgo setMotion: PolyPath 76 130 self)
			)
			(2
				(gMessager say: 5 4 7 1 self) ; "You take the silver candlesticks and stow them in your pack."
			)
			(3
				(candle1 dispose:)
				(candle2 dispose:)
				(SetFlag 133)
				(SolvePuzzle 628 1 2)
				(= ticks 60)
			)
			(4
				(HandsOn)
				(gEgo ignoreControl: -32768)
				(self dispose:)
			)
		)
	)
)

(instance cuedIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(switch local15
					(1
						(gEgo get: 0 20) ; silver
					)
					(2
						(gEgo get: 35) ; pearls
					)
					(3
						(gEgo get: 0 3) ; silver
					)
				)
				(self cue:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sillyThief of Sound
	(properties
		number 8
		loop -1
	)
)

