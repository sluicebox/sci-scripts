;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use n814)
(use Print)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Chase)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm16 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 = 99
	local7
	local8
	local9
	local10
	local11
	[local12 4]
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	[local28 25] = [2 0 138 83 2 1 150 91 2 4 160 100 2 5 169 107 2 5 172 123 2 5 173 139 -32768]
)

(procedure (localproc_0)
	(gMessager say: 9 0 0 1) ; "You've already made a mess of that flower."
)

(procedure (localproc_1)
	(gMessager say: 9 0 0 2) ; "There's not much point in that, now that you've already done what you came here to do."
)

(procedure (localproc_2)
	(cond
		((IsFlag 192)
			(gMessager say: 9 0 4) ; "You don't need a rock for anything."
		)
		((== local3 0)
			(gEgo setScript: getRock)
		)
		(else
			(gMessager say: 9 0 14) ; "Not now!"
		)
	)
)

(procedure (localproc_3)
	(if local2
		(return)
	else
		(= local2 1)
		(if (!= ([local12 0] loop:) 3)
			([local12 0] setLoop: 2 setCycle: End)
		)
		(if (!= ([local12 1] loop:) 3)
			([local12 1] setLoop: 2 setCycle: End)
		)
		(if (!= ([local12 2] loop:) 3)
			([local12 2] setLoop: 2 setCycle: End)
		)
		(if (!= ([local12 3] loop:) 3)
			([local12 3] setLoop: 2 setCycle: End)
		)
	)
)

(procedure (localproc_4)
	([local12 0] stopUpd:)
	([local12 1] stopUpd:)
	([local12 2] stopUpd:)
	([local12 3] stopUpd:)
)

(class Script_ of Script
	(properties
		register2 -1
	)
)

(instance rm16 of Rm
	(properties
		noun 9
		picture 16
		style 8
		east 17
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 151 278 151 236 141 186 139 170 126 140 139 64 123 42 157 111 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 193 189 237 171 319 165 319 189
					yourself:
				)
		)
		(Load rsSCRIPT 991)
		(LoadMany rsVIEW 16 518 517 510)
		(if (gEgo knows: 24) ; fetchSpell
			(Load rsVIEW 520)
		)
		(LoadMany rsSOUND (SoundFX 18) (SoundFX 27))
		(super init:)
		(spitSound number: (SoundFX 18) init:)
		(gulpSound number: (SoundFX 27) init:)
		(if gNight
			(= local0 1)
			(if (IsFlag 136)
				(SetFlag 192)
			)
		)
		(= local19 2)
		(NormalEgo)
		(flyingRock
			setLoop: 4
			setStep: 70 30
			posn: 0 1000
			hide:
			ignoreActors: 1
			illegalBits: 0
			setCycle: Fwd
			init:
		)
		(switch gPrevRoomNum
			(17
				(gEgo init: posn: 318 165 setMotion: MoveTo 275 165)
			)
			(else
				(self setScript: sEnterFromSouth)
			)
		)
		(if (IsFlag 139)
			(flower0 setLoop: 3 cel: 4)
		)
		(if (IsFlag 137)
			(flower1 setLoop: 3 cel: 4)
		)
		(if (IsFlag 138)
			(flower3 setLoop: 3 cel: 4)
		)
		((= [local12 0] flower0) init: stopUpd:)
		((= [local12 1] flower1) init: stopUpd:)
		((= [local12 2] flower2) init: stopUpd:)
		((= [local12 3] flower3) init: stopUpd:)
		(leaf0 addToPic:)
		(leaf1 addToPic:)
		(leaf2 addToPic:)
		(leaf3 addToPic:)
		(if
			(and
				(not (IsFlag 136))
				(not (IsFlag 137))
				(not (IsFlag 138))
				(not (IsFlag 139))
			)
			(flyingSeed init: setScript: spitIt)
			(= local1 1)
		)
		(cliff init:)
		(grass init:)
		(trees init:)
		(theRoom init:)
		(yellowRock init:)
	)

	(method (dispose)
		(SetFlag 6)
		(ClearFlag 192)
		(DisposeScript 942)
		(super dispose:)
	)

	(method (cue)
		(if (not (IsFlag 192))
			(gMessager say: 1 1 1) ; "They are spitting what seems to be some kind of seed."
		)
	)

	(method (doit)
		(if (and local16 (not local0))
			(flyingSeed setScript: spitIt)
		)
		(super doit:)
		(cond
			(script)
			((> (gEgo y:) 185)
				(gCurRoom setScript: sExitSouth)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (== local3 1)
					(gCurRoom setScript: fallDown)
				)
			)
			(51 ; openSpell
				(cond
					((IsFlag 136)
						(localproc_1)
					)
					((!= (gEgo script:) 0)
						(gMessager say: 9 51 29) ; "Not now!"
					)
					((!= local3 0)
						(gMessager say: 9 51 30) ; "You lose your concentration."
						(gEgo setScript: fallDown)
					)
					((< [gEgoStats 17] 35) ; openSpell
						(gMessager say: 9 51 8) ; "Your skill with the Open spell is not great enough to affect the plants."
					)
					((CastSpell 17)
						(SetFlag 192)
						(gCurRoom setScript: openUp)
					)
				)
			)
			(82 ; fetchSpell
				(cond
					(local0
						(CantDo)
					)
					((IsFlag 136)
						(localproc_1)
					)
					((IsFlag 192)
						(gMessager say: 9 82 27) ; "You might have tried to cast a spell at the seed, but it's too late now."
					)
					((== local3 0)
						(= local21 1)
						(gCurRoom setScript: throwIt)
					)
					(else
						(gMessager say: 9 82 28) ; "You lose your concentration."
						(gEgo setScript: fallDown)
					)
				)
			)
			(81 ; flameDartSpell
				(if (not (IsFlag 136))
					(gMessager say: 9 81 6) ; "That spell would damage the seed. You don't want to do that."
				else
					(gMessager say: 9 81 5) ; "There is no need to be so destructive."
				)
			)
			(78 ; dazzleSpell
				(if (== local3 1)
					(gMessager say: 9 82 28) ; "You lose your concentration."
					(gEgo setScript: fallDown)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance grass of Feature
	(properties
		x 171
		y 146
		noun 4
		nsTop 104
		nsLeft 24
		nsBottom 189
		nsRight 319
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (> local3 1) (== local5 0)))
					((>= local3 1)
						(gEgo setScript: climbDown)
					)
					(else
						(localproc_2)
					)
				)
			)
			(1 ; Look
				(gMessager say: 4 1 0) ; "The meadow clearing in which you stand is grassy and littered with blown pine needles and small mossy rocks."
			)
			(81 ; flameDartSpell
				(gMessager say: 9 81 5) ; "There is no need to be so destructive."
			)
			(else
				(super doVerb: theVerb)
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
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 9 81 5) ; "There is no need to be so destructive."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cliff of Feature
	(properties
		x 159
		y 1
		noun 1
		nsBottom 155
		nsRight 319
	)

	(method (doVerb theVerb)
		(if
			(and
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
				(< (Abs (- gMouseX (flyingSeed x:))) 10)
				(< (Abs (- gMouseY (flyingSeed y:))) 10)
			)
			(flyingSeed doVerb: theVerb)
		else
			(switch theVerb
				(4 ; Do
					(cond
						((not local10)
							(gMessager say: 1 4 0) ; "The cliff walls are very steep, and they look difficult to climb."
							(= local10 1)
						)
						((>= local3 1)
							(if
								(and
									(< (Abs (- gMouseX (flyingSeed x:))) 10)
									(< (Abs (- gMouseY (flyingSeed y:))) 10)
								)
								(flyingSeed doVerb: theVerb)
							else
								(gEgo setScript: climbDown)
							)
						)
						((IsFlag 136)
							(localproc_1)
						)
						((TrySkill 11 35 0) ; climbing
							(gEgo setScript: goodClimb)
						)
						(else
							(gCurRoom setScript: badClimb)
						)
					)
				)
				(1 ; Look
					(gMessager say: 1 1 0 0 gCurRoom) ; "To the south and east is the forest from which you came. To the north and west are steep cliffs. There are some unusual plants growing out of the side of the cliffs."
				)
				(81 ; flameDartSpell
					(gMessager say: 9 81 5) ; "There is no need to be so destructive."
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance leaf0 of View
	(properties
		x 142
		y 93
		noun 5
		view 16
	)
)

(instance leaf1 of View
	(properties
		x 35
		y 118
		noun 6
		view 16
	)
)

(instance leaf2 of View
	(properties
		x 67
		y 58
		noun 7
		view 16
		cel 1
	)
)

(instance leaf3 of View
	(properties
		x 230
		y 103
		noun 8
		view 16
	)
)

(instance flower0 of Prop
	(properties
		x 112
		y 83
		noun 2
		view 16
		loop 1
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== local6 99)
			(= local6 0)
		)
		(switch theVerb
			(51 ; openSpell
				(cond
					((IsFlag 136)
						(localproc_1)
					)
					((!= (gEgo script:) 0))
					((!= local3 0)
						(gMessager say: 2 51 7) ; "You lose your concentration."
						(gEgo setScript: fallDown)
					)
					((< [gEgoStats 17] 35) ; openSpell
						(gMessager say: 2 51 8) ; "Your skill with the Open spell is not great enough to affect the plants."
					)
					((CastSpell 17)
						(SetFlag 192)
						(gCurRoom setScript: openUp)
					)
				)
			)
			(81 ; flameDartSpell
				(if (not (IsFlag 136))
					(gMessager say: 2 81 6) ; "That spell would damage the seed. You don't want to do that."
				else
					(gMessager say: 2 81 5) ; "There is no need to be so destructive."
				)
			)
			(12 ; sword
				(switch local3
					(1
						(gMessager say: 2 12 12) ; "As you attempt to draw your weapon, you lose your balance momentarily."
						(gEgo setScript: fallDown)
					)
					(3)
					(4)
					(0
						(gCurRoom setScript: smashIt)
						(if (!= local6 2)
							(SetFlag 192)
						)
					)
				)
			)
			(4 ; Do
				(cond
					((or (not local11) (IsFlag 136))
						(gMessager say: 2 4 3) ; "You have no need to take the flowers."
						(= local11 1)
					)
					((IsFlag 192)
						(gMessager say: 2 4 4) ; "Since the flowers have stopped spitting, the seed might be a little harder to get to."
					)
					((== local3 1)
						(= local3 2)
						(gEgo setScript: catchIt)
					)
					(else
						(gMessager say: 2 4 2) ; "You'd like to do that, wouldn't you?"
					)
				)
			)
			(35 ; seed
				(gMessager say: 2 35 9) ; "Playing catch with the Spirea plants would certainly be fun, but this seed has a future elsewhere."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flower1 of Prop
	(properties
		x 21
		y 106
		view 16
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(= local6 1)
		(flower0 doVerb: theVerb)
	)
)

(instance flower2 of Prop
	(properties
		x 41
		y 61
		view 16
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(= local6 2)
		(flower0 doVerb: theVerb)
	)
)

(instance flower3 of Prop
	(properties
		x 215
		y 90
		view 16
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(= local6 3)
		(flower0 doVerb: theVerb)
	)
)

(instance flyingSeed of Actor
	(properties
		noun 3
		view 16
		signal 18432
		illegalBits 0
	)

	(method (init)
		(self
			ignoreActors: 1
			setLoop: 4
			setPri: 15
			posn: 0 1000
			hide:
			setCycle: Fwd
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 192)
						(gMessager say: 3 4 4) ; "There's not much point to that now."
					)
					((IsFlag 136)
						(localproc_1)
					)
					((== local3 1)
						(= local3 2)
						(gEgo setScript: catchIt)
					)
					((or (== local3 2) (== local3 3))
						(gMessager say: 3 4 10) ; "Why do you think you're standing like this. Trying to catch Flying Water?"
					)
					(else
						(gMessager say: 3 4 13) ; "You can't catch the seed from down on the ground."
					)
				)
			)
			(16 ; dagger
				(gMessager say: 3 16 0) ; "Perhaps it would be better to find something else to throw."
			)
			(20 ; rock
				(cond
					((IsFlag 136)
						(localproc_1)
					)
					((IsFlag 192)
						(gMessager say: 3 20 4) ; "You might have tried to throw a rock at the seed, but it's too late now."
					)
					((== local3 1)
						(gCurRoom setScript: fallDown)
					)
					((== local3 0)
						(if (gEgo has: 10) ; rock
							(gCurRoom setScript: throwIt)
						else
							(gMessager say: 3 20 17) ; "You need a good rock to throw."
						)
					)
					(else
						(gMessager say: 3 20 15) ; "Not now!"
					)
				)
			)
			(1 ; Look
				(if (IsFlag 192)
					(gMessager say: 3 1 4) ; "You can't see it."
				else
					(gMessager say: 3 1 14) ; "The large seed spins as it travels through the air."
				)
			)
			(81 ; flameDartSpell
				(gMessager say: 9 81 5) ; "There is no need to be so destructive."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance magicLasso of Actor
	(properties
		view 520
	)
)

(instance flyingRock of Actor
	(properties
		view 510
	)
)

(instance lassoSeed of Script
	(properties)

	(method (doit)
		(if (== (lassoSeed state:) 3)
			(flyingSeed
				setPri: 7
				setStep: 6 4
				posn: (magicLasso x:) (magicLasso y:)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 192)
				(magicLasso
					ignoreActors: 1
					illegalBits: 0
					setMotion:
						MoveTo
						([local12 local5] x:)
						(- ([local12 local5] y:) 30)
						self
				)
			)
			(1
				(ClearFlag 192)
				(= local16 1)
				(= local25 1)
			)
			(2
				(flyingSeed
					setScript: 0
					setStep: 1 1
					setMotion: MoveTo (flyingSeed x:) (- (magicLasso y:) 2) self
				)
				(spitSound play:)
				([local12 local4] setCycle: Beg)
			)
			(3
				(magicLasso
					setPri: 7
					setStep: 6 4
					setMotion: MoveTo 234 117 self
				)
				(gEgo setCycle: End)
			)
			(4
				(= seconds 3)
			)
			(5
				(magicLasso hide:)
				(flyingSeed dispose:)
				(= local5 2)
				(= local4 2)
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(6
				(gMessager say: 9 0 23 1 self) ; "You place the seed into your pack."
				(SetFlag 136)
				(SolvePuzzle 651 8)
				(NormalEgo)
				(gEgo x: (+ (gEgo x:) 10) get: 25 loop: 1) ; seed
				(HandsOn)
			)
			(7
				(localproc_3)
				(= seconds 3)
			)
			(8
				(localproc_4)
				(magicLasso dispose:)
			)
		)
	)
)

(instance youMissed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(flyingRock
					setStep: 30 20
					setMotion: MoveTo 0 (- (flyingRock y:) 100) self
				)
			)
			(1
				(flyingRock
					setMotion: JumpTo (Random 130 160) (Random 145 160) self
				)
			)
			(2
				(flyingRock hide:)
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
				(= ticks 10)
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 60) self
				)
			)
			(2
				(gCurRoom newRoom: 24)
			)
		)
	)
)

(instance sEnterFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo init: posn: 170 240 setMotion: MoveTo 170 180 self)
			)
			(2
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance fallDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(= local3 0)
				(= ticks 6)
			)
			(1
				(gEgo view: 517 setLoop: 2 setCel: 0 posn: 134 80)
				(= ticks 6)
			)
			(2
				(gEgo setCycle: MCyc @local28 self)
			)
			(3
				(gEgo
					view: 517
					setLoop: 6
					setCel: 0
					posn: 187 146
					setCycle: 0
				)
				(= cycles 2)
			)
			(4
				(ShakeScreen 2)
				(catchingFeat dispose:)
				(= seconds 2)
			)
			(5
				(if (not (TakeDamage 5))
					(EgoDead 68 69 2 5 517) ; "Had you been healthier, you probably could have survived that fall. In your weakened condition, however, you succumbed to your injuries."
				else
					(gMessager say: 9 0 22 1 self) ; "Ohhhhhhh!"
				)
			)
			(6
				(gMessager say: 9 0 21 1 self) ; "You remain unconscious on the ground for an indeterminate amount of time. As you finally revive, you realize that you've caused yourself a fair amount of damage."
				(NormalEgo)
				(gEgo loop: 2 posn: 164 136)
				(HandsOn)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance badClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(= register (gEgo cycleSpeed:))
				(if (not (IsFlag 190))
					(gMessager say: 9 0 19) ; "It looks difficult. You look around for a good place to climb."
				)
				(cond
					((> gMouseX 219)
						(gEgo setMotion: PolyPath 258 144 self)
					)
					((> gMouseX 131)
						(gEgo setMotion: PolyPath 168 125 self)
					)
					(else
						(gEgo setMotion: PolyPath 73 122 self)
					)
				)
			)
			(2
				(gEgo setHeading: 360 self)
			)
			(3
				(if (not (IsFlag 190))
					(SetFlag 190)
					(gMessager say: 9 0 0 3) ; "This looks like a good place to you."
				)
				(gEgo
					view: 517
					setMotion: 0
					setLoop: 0
					x: (+ (gEgo x:) 6)
					y: (- (gEgo y:) 38)
					cel: 0
				)
				(= ticks 10)
			)
			(4
				(gEgo setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(gMessager say: 9 0 0 4) ; "You valiantly scrabble against the cliff wall, but it looks like your climbing skill could stand some improvement."
				(gEgo
					view: 0
					setCycle: Walk
					setLoop: 2
					x: (- (gEgo x:) 6)
					y: (+ (gEgo y:) 38)
				)
				(= ticks 12)
			)
			(6
				(gEgo
					cycleSpeed: register
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self
				)
			)
			(7
				(NormalEgo)
				(= ticks 12)
			)
			(8
				(gMessager say: 9 0 0 5 self) ; "Perhaps there is some other way to get to your objective."
			)
			(9
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goodClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(catchingFeat init:)
				(= local8 (gEgo cycleSpeed:))
				(= local7 (gEgo moveSpeed:))
				(gEgo setMotion: PolyPath 143 134 self)
				(if (not (IsFlag 190))
					(gMessager say: 9 0 0 6) ; "You look for an appropriate place to climb."
					(SetFlag 190)
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo
					view: 517
					setLoop: 0
					setCel: 0
					posn: (- (gEgo x:) 1) (- (gEgo y:) 38)
					ignoreActors: 1
					setCycle: End self
				)
			)
			(3
				(gEgo
					setLoop: 1
					setCel: 0
					posn: (- (gEgo x:) 2) (- (gEgo y:) 12)
					setCycle: End self
				)
			)
			(4
				(gEgo view: 0 setLoop: 2 setPri: 1 posn: 134 85)
				(= ticks 10)
			)
			(5
				(gEgo view: 4)
				(= local3 1)
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance getRock of Script
	(properties)

	(method (changeState newState &tmp [temp0 40])
		(switch (= state newState)
			(0
				(HandsOff)
				(= local8 (gEgo cycleSpeed:))
				(gEgo
					setMotion:
						MoveTo
						(gEgo x:)
						(if (> (gEgo y:) 175)
							(- (gEgo y:) 5)
						else
							(+ (gEgo y:) 5)
						)
				)
				(= ticks 30)
			)
			(1
				(= register (Random 0 1))
				(gEgo
					view: 510
					setLoop: register
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(2
				(Message msgGET 16 9 4 25 1 @temp0) ; "You pick up a few small rocks."
				(Print addText: @temp0 init: self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo)
				(if register
					(gEgo cycleSpeed: local8 setHeading: 270 self)
				else
					(gEgo cycleSpeed: local8 setHeading: 90 self)
				)
			)
			(5
				(HandsOn)
				(gEgo get: 10 10) ; rock
				(self dispose:)
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
				(if (== local3 4)
					(flyingSeed dispose:)
				)
				(gEgo
					view: 0
					setLoop: 0
					setCel: 0
					illegalBits: 0
					setPri: 7
					ignoreActors: 1
					posn: 142 83
					setMotion: 0
				)
				(catchingFeat dispose:)
				(= ticks 30)
			)
			(1
				(gEgo
					view: 517
					posn: 137 83
					setLoop: 1
					setCel: 9
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					setLoop: 0
					setCel: 7
					posn: 137 83
					setCycle: Beg
					setMotion: MoveTo 137 101 self
				)
			)
			(3
				(= local3 0)
				(NormalEgo)
				(gEgo
					posn: 136 134
					loop: 3
					setPri: -1
					cycleSpeed: local8
					moveSpeed: local7
					setHeading: 180 self
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance spitSound of Sound
	(properties
		number 18
		priority 3
	)
)

(instance gulpSound of Sound
	(properties
		number 27
		priority 3
	)
)

(instance catchIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo)
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors: 1 setHeading: 270 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					posn: (gEgo x:) (- (gEgo y:) 5)
					setHeading: 180 self
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(if local0
					(CantDo)
					(NormalEgo)
					(gEgo loop: 7)
					(HandsOn)
					(self dispose:)
					(= local3 3)
				else
					(= local3 3)
					(HandsOff)
					(gEgo
						view: 16
						setLoop: 5
						setCel: 0
						posn: 140 81
						setCycle: 0
					)
					(self dispose:)
				)
			)
		)
	)
)

(instance heCaughtIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				([local12 local4] setCycle: Beg)
				(gEgo setCel: 1)
				(flyingSeed posn: (- (gEgo x:) 12) (- (gEgo y:) 49))
				(= ticks 10)
			)
			(1
				(gEgo setCel: 2)
				(flyingSeed posn: (- (gEgo x:) 4) (- (gEgo y:) 44))
				(= ticks 10)
			)
			(2
				(gEgo setCel: 3)
				(flyingSeed posn: (+ (gEgo x:) 3) (- (gEgo y:) 30))
				(= ticks 10)
			)
			(3
				(gEgo setCel: 4)
				(flyingSeed hide:)
				(= ticks 20)
			)
			(4
				(gEgo setCel: 5)
				(= ticks 20)
			)
			(5
				(gEgo view: 4 setLoop: 2 setCel: 0)
				(= local5 2)
				(= local4 2)
				(= cycles 2)
			)
			(6
				(gMessager say: 9 0 20 0 self) ; "You put the seed into your pack and climb down."
			)
			(7
				(localproc_3)
				(= local6 99)
				(SolvePuzzle 651 8)
				(SetFlag 136)
				(SetFlag 192)
				(gEgo get: 25 setScript: climbDown) ; seed
			)
		)
	)
)

(instance smashIt of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 40])
		(switch (= state newState)
			(0
				(= local20 0)
				(switch local6
					(0
						(if (IsFlag 139)
							(localproc_0)
							(self dispose:)
						else
							(HandsOff)
							(= local19 0)
							(gEgo setMotion: PolyPath 117 130 self)
						)
					)
					(1
						(if (IsFlag 137)
							(localproc_0)
							(self dispose:)
						else
							(HandsOff)
							(= local19 1)
							(gEgo setMotion: PolyPath 53 142 self)
						)
					)
					(3
						(if (IsFlag 138)
							(localproc_0)
							(self dispose:)
						else
							(HandsOff)
							(= local19 3)
							(gEgo setMotion: PolyPath 220 140 self)
						)
					)
					(else
						(gMessager say: 9 0 0 9) ; "Unless you just took a kangaroo potion, that plant is too far up the cliff to jump for."
						(self dispose:)
					)
				)
				(= local6 99)
			)
			(1
				(SolvePuzzle 603 -10)
				(gEgo
					view: 518
					setCel: 0
					setLoop: (if (== local19 1) 2 else 0)
				)
				(= ticks 6)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(++ local20)
				(gEgo
					setLoop: (if (== local19 1) 3 else 1)
					setCycle: End self
				)
			)
			(4
				(if (< local20 2)
					(switch local19
						(0
							([local12 0] setCel: 2)
						)
						(1
							([local12 1] setCel: 2)
						)
						(3
							([local12 3] setCel: 2)
						)
					)
				)
				(switch local20
					(2
						(switch local19
							(0
								([local12 0]
									setLoop: 3
									cel: 0
									cycleSpeed: 6
									setCycle: End self
								)
								(= register 0)
								(SetFlag 139)
							)
							(1
								([local12 1]
									setLoop: 3
									cel: 0
									cycleSpeed: 6
									setCycle: End self
								)
								(= register 1)
								(SetFlag 137)
							)
							(3
								([local12 3]
									setLoop: 3
									cel: 0
									cycleSpeed: 6
									setCycle: End self
								)
								(= register 3)
								(SetFlag 138)
							)
							(else
								(= ticks 60)
							)
						)
					)
					(3
						(= local20 0)
						(= ticks 30)
					)
					(else
						(-= state 2)
						(= ticks 12)
					)
				)
			)
			(5
				(if (< local20 2)
					(= temp0 (if local2 3 else 0))
					(switch local19
						(0
							([local12 0] setCel: temp0)
						)
						(1
							([local12 1] setCel: temp0)
						)
						(3
							([local12 3] setCel: temp0)
						)
					)
				)
				(gEgo setLoop: (if (== local19 1) 2 else 0) cel: 3)
				(= ticks 12)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo loop: (if (== local19 1) 1 else 3))
				(NormalEgo)
				(if (and (== local19 local5) (not local24) (not (IsFlag 136)))
					(self cue:)
				else
					(HandsOn)
					(self dispose:)
				)
				(= local19 2)
			)
			(8
				(flyingSeed
					init:
					show:
					posn: ([local12 register] x:) (- ([local12 register] y:) 8)
					setScript: 0
					setPri: 15
				)
				(= local16 0)
				(= local1 1)
				(= ticks 60)
			)
			(9
				(gMessager say: 9 0 0 10 self) ; "You see the seed floating above the shattered remains of the plant."
			)
			(10
				(= ticks 10)
			)
			(11
				(flyingSeed
					setPri: (- (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 30) self
				)
			)
			(12
				(flyingSeed dispose:)
				(= ticks 2)
			)
			(13
				(gMessager say: 9 0 0 11 self) ; "You take the seed."
			)
			(14
				(SolvePuzzle 651 8)
				(SetFlag 136)
				(localproc_3)
				(gEgo
					get: 25 ; seed
					setMotion:
						MoveTo
						(if (< (gEgo x:) 60)
							90
						else
							(gEgo x:)
						)
						(if (< (gEgo x:) 60)
							(+ (gEgo y:) 25)
						else
							(gEgo y:)
						)
						self
				)
			)
			(15
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance rockHitsIt of Script
	(properties)

	(method (doit)
		(if
			(and
				(not local24)
				(== (flyingSeed y:) 150)
				(== (flyingRock y:) 160)
			)
			(= local24 1)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(= local8 (gEgo cycleSpeed:))
				(= local7 (gEgo moveSpeed:))
				(flyingRock setMotion: Chase flyingSeed 5 self)
			)
			(2
				(SetFlag 192)
				(= local16 0)
				(flyingSeed setScript: 0 setMotion: 0)
				(flyingRock
					setMotion: MoveTo (+ (flyingSeed x:) 3) (flyingSeed y:) self
				)
				(if (!= ([local12 local5] cel:) 0)
					([local12 local5] setCel: 0)
				)
			)
			(3
				(flyingRock setMotion: JumpTo 150 160 self)
				(flyingSeed
					show:
					setStep: 3 15
					setMotion: MoveTo (flyingSeed x:) 150
				)
			)
			(4
				(= local5 2)
				(= local4 2)
				(flyingSeed setMotion: 0 setCycle: 0 ignoreActors: 1)
				(flyingRock hide:)
				(= ticks 12)
			)
			(5
				(localproc_3)
				(= seconds 3)
			)
			(6
				(localproc_4)
				(flyingRock hide:)
				(= ticks 6)
			)
			(7
				(flyingSeed setCycle: 0 stopUpd:)
				(NormalEgo)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion:
						MoveTo
						(if (< (flyingSeed x:) (gEgo x:))
							(+ (flyingSeed x:) 16)
						else
							(- (flyingSeed x:) 16)
						)
						149
						self
				)
			)
			(8
				(gEgo
					view: 510
					setLoop: (if (< (flyingSeed x:) (gEgo x:)) 1 else 0)
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(9
				(flyingSeed dispose:)
				(gEgo setCycle: Beg self)
			)
			(10
				(SolvePuzzle 651 8)
				(SetFlag 136)
				(gEgo get: 25 cycleSpeed: local8 moveSpeed: local7) ; seed
				(self dispose:)
			)
		)
	)
)

(instance spitIt of Script_
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local16 0)
				(= seconds (Random 3 5))
			)
			(1
				(if (or gNight (IsFlag 192))
					(self changeState: 8)
				else
					(= local4 local5)
					(= local5 (Random 0 3))
					(if (== local26 local5)
						(while (== local26 local5)
							(if (<= (++ local27) 3)
								(= local27 0)
								(break)
							)
							(if (== local5 1)
								(= local5 2)
							else
								(= local5 1)
							)
						)
					else
						(= local27 0)
					)
					(= local26 local5)
					([local12 local4] setLoop: 1 startUpd: setCycle: End self)
					(if (and (!= local5 3) (!= local4 local5) local17)
						(throwIt cue:)
					)
				)
			)
			(2
				(flyingSeed
					show:
					yStep: 10
					posn:
						(switch local4
							(0 110)
							(1 20)
							(2 40)
							(3 213)
						)
						(switch local4
							(0 48)
							(1 69)
							(2 24)
							(3 54)
						)
				)
				(if local25
					(lassoSeed cue:)
				else
					(self cue:)
				)
			)
			(3
				(spitSound play:)
				(= local9 0)
				(flyingSeed
					setMotion:
						MoveTo
						(flyingSeed x:)
						(-
							(flyingSeed y:)
							(if (and (== local4 local5) (!= local4 2))
								30
							else
								5
							)
						)
						self
				)
				(= ticks 7)
			)
			(4
				([local12 local4] setCel: 0)
			)
			(5
				(switch local5
					(0
						(= register 111)
						(= register2 62)
					)
					(1
						(= register 20)
						(= register2 85)
					)
					(2
						(= register 41)
						(= register2 40)
					)
					(3
						(= register 214)
						(= register2 69)
					)
				)
				(if (and (== local3 3) (== local5 0))
					(self changeState: 20)
				else
					(flyingSeed
						yStep: 2
						moveSpeed: 3
						setMotion: JumpTo register register2 self
					)
				)
				(= ticks 5)
			)
			(6
				([local12 local5] setLoop: 2 setCycle: End)
				(flyingSeed setPri: (+ ([local12 local5] priority:) 1))
			)
			(7
				(= local9 1)
				(gulpSound play:)
				(flyingSeed hide:)
				([local12 local5] setCycle: Beg self)
			)
			(8
				([local12 local5] stopUpd:)
				([local12 local4] stopUpd:)
				(if (or (not (IsFlag 192)) (not local18))
					(= local16 1)
				)
				(if gNight
					(= local0 1)
					(SetFlag 192)
				)
				(self dispose:)
			)
			(20
				(= local3 4)
				(flyingSeed
					yStep: 6
					setMotion:
						JumpTo
						(- (gEgo x:) 12)
						(- (gEgo y:) 49)
						self
				)
			)
			(21
				(gEgo setScript: heCaughtIt)
				(self dispose:)
			)
		)
	)
)

(instance theRoom of Feature
	(properties
		x 159
		y 1
		z 94
		nsBottom 189
		nsRight 319
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 9 81 5) ; "There is no need to be so destructive."
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance openUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) 145 self)
			)
			(2
				(gEgo view: 521 setLoop: 0 cycleSpeed: 6 setCycle: End)
				(= ticks 150)
			)
			(3
				(localproc_3)
				(flyingSeed
					setPri: (+ ([local12 local5] priority:) 1)
					posn:
						(- ([local12 local5] x:) 1)
						(- ([local12 local5] y:) 21)
					show:
				)
				(= seconds 3)
			)
			(4
				(localproc_4)
				(flyingSeed setMotion: MoveTo (flyingSeed x:) 145 self)
			)
			(5
				(flyingSeed setCycle: 0 stopUpd:)
				(NormalEgo)
				(gEgo
					setMotion:
						MoveTo
						(if (< (flyingSeed x:) (gEgo x:))
							(+ (flyingSeed x:) 16)
						else
							(- (flyingSeed x:) 16)
						)
						144
						self
				)
			)
			(6
				(gEgo
					view: 510
					setLoop: (if (< (flyingSeed x:) (gEgo x:)) 1 else 0)
					cel: 0
					cycleSpeed: 6
					setCycle: End
				)
				(= ticks 48)
			)
			(7
				(gMessager say: 9 0 18) ; "You take the seed."
				(flyingSeed dispose:)
				(gEgo setCycle: Beg self)
			)
			(8
				(NormalEgo)
				(SolvePuzzle 651 8)
				(gEgo get: 25 setScript: 0) ; seed
				(SetFlag 136)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance throwIt of Script_
	(properties)

	(method (doit)
		(super doit:)
		(if (!= gTheCursor gWaitCursor)
			(gGame setCursor: gWaitCursor)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register (gEgo cycleSpeed:))
				(= register2 (gEgo moveSpeed:))
				(= ticks 10)
			)
			(1
				(cond
					((and local21 (not local23))
						(gMessager say: 9 82 26 0 self) ; "You get into a good position."
					)
					((and (not local21) (not local22))
						(gMessager say: 3 20 16 0 self) ; "You get in position for a good throw."
					)
					(else
						(= ticks 5)
					)
				)
			)
			(2
				(gEgo
					setMotion: MoveTo (Random 242 258) (Random 160 175) self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(gEgo
					view: (if local21 520 else 510)
					setCycle: 0
					setLoop: 2
					cel: (if local21 5 else 2)
					x:
						(if local21
							(- (gEgo x:) 10)
						else
							(gEgo x:)
						)
				)
				(= local17 1)
			)
			(5
				(= local17 0)
				(if local21
					(gEgo cycleSpeed: 6 setCycle: Beg self)
				else
					(gEgo setCycle: CT 4 1 self)
				)
			)
			(6
				(if local21
					(magicLasso
						ignoreActors: 1
						posn: (- (gEgo x:) 10) (- (gEgo y:) 44)
						setLoop: 4
						setStep: 5 5
						setCycle: Fwd
						init:
					)
					(if (> [gEgoStats 24] 20) ; fetchSpell
						(magicLasso setScript: lassoSeed)
					else
						(magicLasso setScript: lassoFailed)
					)
					(gEgo
						cycleSpeed: register
						moveSpeed: register2
						setLoop: 0
						setCel: 6
						setCycle: 0
					)
					(= local23 1)
					(= local21 0)
					(self dispose:)
				else
					(flyingRock
						posn: (- (gEgo x:) 13) (- (gEgo y:) 34)
						show:
					)
					(gEgo setCycle: End)
					(if (TrySkill 10 0 -10) ; throwing
						(flyingRock setScript: rockHitsIt self)
					else
						(flyingRock setScript: youMissed self)
					)
					(= local22 1)
				)
			)
			(7
				(gEgo use: 10 1) ; rock
				(= local21 0)
				(NormalEgo)
				(gEgo loop: 1 cycleSpeed: register moveSpeed: register2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lassoFailed of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 192)
				(= temp0 ([local12 local5] x:))
				(= temp1 (- ([local12 local5] y:) 30))
				(= ticks 10)
			)
			(1
				(magicLasso
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo temp0 temp1 ; UNINIT, UNINIT
				)
				(= ticks 100)
			)
			(2
				(magicLasso hide:)
				(= cycles 2)
			)
			(3
				(gMessager say: 9 0 24 0 self) ; "You lose concentration, and the spell fades. You will have to practice some more."
			)
			(4
				(NormalEgo)
				(gEgo x: (+ (gEgo x:) 10) loop: 7)
				(= ticks 10)
			)
			(5
				(HandsOn)
				(= local16 1)
				(ClearFlag 192)
				(client dispose:)
			)
		)
	)
)

(instance yellowRock of Feature
	(properties
		x 71
		y 161
		nsTop 134
		nsLeft 32
		nsBottom 189
		nsRight 111
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 9 81 5) ; "There is no need to be so destructive."
		else
			(cliff doVerb: theVerb &rest)
		)
	)
)

(instance catchingFeat of Feature
	(properties
		x 135
		y 164
		z 100
		nsTop 37
		nsLeft 119
		nsBottom 91
		nsRight 152
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gCurRoom setScript: fallDown)
		else
			(return 0)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (== (event message:) JOY_NULL))
				(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
				(& (event type:) $0040) ; direction
			)
			(gCurRoom setScript: fallDown)
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

