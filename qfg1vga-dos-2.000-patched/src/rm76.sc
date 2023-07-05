;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use dartScript)
(use n101)
(use n102)
(use n106)
(use TargActor)
(use n814)
(use Print)
(use Talker)
(use PolyPath)
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
	rm76 0
	dryadTalker 1
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

(procedure (localproc_0)
	(HandsOff)
	(if (and local1 (< (gEgo distanceTo: acorn) 80))
		(gMessager say: 7 0 8) ; "You pick up the Dryad's gift of a Magic Acorn."
	else
		(gMessager say: 7 0 12 1) ; "You find an ordinary acorn on the ground."
	)
	(gEgo setScript: pickEmUp)
)

(procedure (localproc_1)
	(gMessager say: 7 0 11) ; "That acorn tasted awfully bitter... just like an ordinary acorn."
)

(procedure (localproc_2)
	(HandsOff)
	(if (IsFlag 198)
		(gMessager say: 7 0 10) ; "Until you have done so, you are only intruding on my concentration."
	else
		(gMessager say: 7 0 16) ; "You need to become a friend of the forest. Harm not the gentle creatures or plants. See with all your senses the magic of the trees and wild places."
	)
	(dryad setScript: intoTree)
)

(procedure (localproc_3)
	(HandsOff)
	(if (IsFlag 198)
		(if (gEgo has: 25) ; seed
			(dryad setScript: hasSeed)
		else
			(gMessager say: 7 0 22 0) ; "You are forced to confess that you lied to the Dryad. You don't have the magic seed."
			(dryad setScript: intoTree)
		)
	else
		(dryad setScript: aidMeScript)
	)
)

(instance rm76 of Rm
	(properties
		noun 7
		picture 76
		style 8
	)

	(method (dispose)
		(= global451 0)
		(SetFlag 66)
		(DisposeScript 991)
		(super dispose:)
	)

	(method (init)
		(if (and (IsFlag 202) (not gNight))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 131 181 131 169 136 139 131 129 144 156 149 175 160 271 160 319 148 319 189 0 189 0 0 319 0
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 131 181 131 169 136 52 136 15 149 156 149 175 160 271 160 319 148 319 189 0 189 0 0 319 0
						yourself:
					)
			)
		)
		(if (not gNight)
			(LoadMany rsVIEW 79)
			(if (or (IsFlag 137) (IsFlag 138) (IsFlag 139))
				(LoadMany rsSOUND (SoundFX 18) (SoundFX 27))
			)
		else
			(Load rsSCRIPT 7)
		)
		(LoadMany rsVIEW 77 72 510)
		(LoadMany rsSOUND 97 98)
		(Load rsSCRIPT 991)
		(if (IsFlag 202)
			(Load rsVIEW 78)
		)
		(super init:)
		(self
			setFeatures:
				mountain
				bigGreenTree
				brokenTree
				frontRock
				backRock
				bushes
				acorns
		)
		(NormalEgo)
		(EgoGait 0 0) ; walking
		(= global111 0)
		(if (not gNight)
			(spitSound number: (SoundFX 18) init:)
			(gulpSound number: (SoundFX 27) init:)
			(seed
				illegalBits: 0
				setLoop: 4
				init:
				ignoreActors:
				setCycle: Fwd
				stopUpd:
				hide:
			)
		)
		(if (and (not gNight) (IsFlag 202))
			(stag
				view: 78
				x: 318
				y: 145
				setScript: stagEntrance
				init:
				illegalBits: 0
			)
		else
			(gEgo
				posn: 318 130
				init:
				actions: egoActions
				setMotion: MoveTo 290 130
			)
			(ClearFlag 202)
			(= local0 1)
		)
		(miscSound init: play:)
	)

	(method (doit)
		(cond
			((and local4 (not (gEgo script:)) (< (stag x:) 50))
				(= local4 0)
				(SetFlag 203)
				(HandsOff)
				(gEgo setScript: priorTo)
			)
			(
				(and
					(not (gEgo script:))
					(not (stag script:))
					(not (dryad script:))
					(not (IsFlag 201))
					(== local0 2)
					(or local3 (IsFlag 203))
				)
				(HandsOff)
				(= local3 0)
				(dryad setScript: egoToStag)
			)
		)
		(cond
			(
				(and
					(== (gEgo edgeHit:) 2)
					(>= local0 1)
					(not (== (gEgo script:) goTo77))
				)
				(ClearFlag 202)
				(gEgo setScript: goTo77)
			)
			(
				(and
					(< (gEgo x:) 280)
					(== local0 1)
					(not gNight)
					(not (IsFlag 201))
					(or
						local6
						(not (IsFlag 201))
						(IsFlag 203)
						(IsFlag 137)
						(IsFlag 138)
						(IsFlag 139)
					)
				)
				(if (gEgo script:)
					(gEgo setScript: 0)
				)
				(= local0 2)
				(dryad init: setScript: outOfTree)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(gMessager say: 7 1 0 0) ; "You are in a strange and beautiful part of the forest. There is something special about this place."
			)
			(4 ; Do
				(gMessager say: 7 4) ; "You can feel a gentle breeze wafting its way between the woods. The scent of fresh flowers and green growing things fills you with a sense of peace."
			)
			(50 ; detectMagicSpell
				(if (== local0 2)
					(gMessager say: 7 50 35) ; "The Dryad radiates magic."
				else
					(gMessager say: 7 50) ; "The oak tree radiates magic."
				)
			)
			(78 ; dazzleSpell
				(if (and (IsFlag 202) (< (stag x:) 50))
					(SetFlag 203)
					(= local4 1)
				)
				(if (== local0 2)
					(= local3 1)
				)
				(CastDazzle)
			)
			(81 ; flameDartSpell
				(gEgo setScript: castADart)
			)
			(52 ; Sleep
				(if (not gNight)
					(gMessager say: 7 52 36) ; "You just can't sleep during the daytime."
					(DisposeScript 7)
				else
					(gEgo setScript: goToSleep)
				)
			)
			(16 ; dagger
				(= temp0 (if (gCast contains: stag) stag else 0))
				(if (ThrowKnife temp0)
					(if (== local0 2)
						(= local3 1)
					)
					(if (IsFlag 202)
						(= local4 1)
						(SetFlag 203)
					)
					(if (gCast contains: stag)
						(Face gEgo stag)
						(RedrawCast)
					)
				)
			)
			(51 ; openSpell
				(gMessager say: 7 51) ; "That was interesting, but there's nothing here to open."
			)
			(20 ; rock
				(= temp0 (if (gCast contains: stag) stag else 0))
				(if (ThrowRock temp0)
					(if (== local0 2)
						(= local3 1)
					)
					(if (IsFlag 202)
						(= local4 1)
						(SetFlag 203)
					)
					(if (gCast contains: stag)
						(Face gEgo stag)
						(RedrawCast)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mountain of Feature
	(properties
		x 271
		y 129
		z 103
		noun 6
		nsTop 7
		nsLeft 224
		nsBottom 45
		nsRight 318
		sightAngle 40
	)
)

(instance bigGreenTree of Feature
	(properties
		x 131
		y 125
		noun 2
		sightAngle 40
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 2 1) ; "The large, gnarled oak seems to draw your attention."
			)
			(4 ; Do
				(gMessager say: 2 4) ; "Something about the old oak tree makes you reluctant to climb upon it."
			)
			(2 ; Talk
				(gMessager say: 2 2) ; "You'd better alder your strategy -- the trees mostly just beech about their more poplar neighbors, or pine fir the fjords. Oak-ay?"
			)
			(16 ; dagger
				(if (== local0 2)
					(gMessager say: 2 16 2) ; "As you begin to form thoughts of violence..."
					(dryad setScript: egoToStag)
				else
					(gMessager say: 2 16) ; "You needn't dull your blade playing woodsman."
				)
			)
			(12 ; sword
				(if (== local0 2)
					(gMessager say: 2 16) ; "You needn't dull your blade playing woodsman."
					(dryad setScript: egoToStag)
				else
					(gMessager say: 2 16) ; "You needn't dull your blade playing woodsman."
				)
			)
			(42 ; candelabra
				(if (== local0 2)
					(gMessager say: 2 42 2) ; MISSING MESSAGE
					(dryad setScript: egoToStag)
				)
			)
			(34 ; acorn
				(gMessager say: 2 34) ; "No thanks; the tree already has plenty of acorns."
			)
			(56 ; ???
				(if (== local0 2)
					(gMessager say: 2 42 2) ; MISSING MESSAGE
					(dryad setScript: egoToStag)
				else
					(gMessager say: 2 42) ; MISSING MESSAGE
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance brokenTree of Feature
	(properties
		x 131
		y 184
		noun 3
		sightAngle 40
		onMeCheck 2
	)
)

(instance bushes of Feature
	(properties
		x 131
		y 134
		noun 4
		sightAngle 40
		onMeCheck 32
	)
)

(instance frontRock of Feature
	(properties
		x 131
		y 180
		noun 8
		sightAngle 40
		onMeCheck 4
	)
)

(instance backRock of Feature
	(properties
		x 131
		y 44
		noun 8
		sightAngle 40
		onMeCheck 8
	)
)

(instance acorns of Feature
	(properties
		x 195
		y 130
		noun 1
		nsTop 124
		nsLeft 163
		nsBottom 140
		nsRight 227
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local1
					(gMessager say: 1 1 1) ; "There is a large, slightly glowing acorn on the ground."
				else
					(gMessager say: 1 1) ; "There are acorns here and there on the ground."
				)
			)
			(4 ; Do
				(localproc_0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theAcorn of Feature
	(properties
		x 271
		y 129
		z 103
		noun 1
		nsTop 127
		nsLeft 125
		nsBottom 134
		nsRight 136
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (gCast contains: acorn)) ; Do
			(localproc_0)
		else
			(acorns doVerb: theVerb &rest)
		)
	)
)

(instance acorn of Prop
	(properties
		x 130
		y 132
		noun 1
		view 77
		loop 1
	)

	(method (init)
		(= global451 177)
		(PalVary pvCHANGE_TARGET 177)
		(AssertPalette 77)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(localproc_0)
		else
			(acorns doVerb: theVerb &rest)
		)
	)
)

(instance stag of TargActor
	(properties
		noun 9
		view 78
	)

	(method (getHurt)
		(HandsOff)
		(+= global250 global251)
		(= global251 0)
		(gMessager say: 9) ; "The stag looks more surprised than injured."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 9 1) ; "The majestic white stag is an outstanding example of the beauty of the animal kingdom."
			)
			(4 ; Do
				(gMessager say: 9 4) ; "He's beyond your reach."
			)
			(78 ; dazzleSpell
				(if (and (IsFlag 202) (< (stag x:) 50))
					(SetFlag 203)
					(= local4 1)
				)
				(if (== local0 2)
					(= local3 1)
				)
				(CastDazzle)
			)
			(81 ; flameDartSpell
				(= local4 1)
				(SetFlag 203)
				(gEgo setScript: castADart)
			)
			(16 ; dagger
				(= local4 1)
				(if (== local0 2)
					(gMessager say: 2 16 2) ; "As you begin to form thoughts of violence..."
					(dryad setScript: egoToStag)
				else
					(SetFlag 203)
				)
			)
			(20 ; rock
				(SetFlag 203)
				(= local4 1)
				(if (== local0 2)
					(gMessager say: 2 16 2) ; "As you begin to form thoughts of violence..."
					(dryad setScript: egoToStag)
				else
					(SetFlag 203)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance seed of Actor
	(properties
		view 76
		loop 4
	)

	(method (init)
		(= global451 176)
		(PalVary pvCHANGE_TARGET 176)
		(AssertPalette 76)
		(super init:)
	)
)

(instance dryad of Actor
	(properties
		x 148
		y 128
		noun 5
		view 76
		illegalBits 0
	)

	(method (init)
		(= global451 176)
		(PalVary pvCHANGE_TARGET 176)
		(AssertPalette 76)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== local0 2)
					(gMessager say: 5 1 2) ; "The Dryad appears to be a woman made of wood and leaves."
				else
					(gMessager say: 5 1 0 0) ; "Does a Dryad bark?"
				)
			)
			(4 ; Do
				(if (IsFlag 202)
					(gMessager say: 5 4 5) ; "The stag remains out of your reach."
					(if (== local0 2)
						(gMessager say: 5 4 2) ; "She's rooted to the ground."
					)
				else
					(gMessager say: 5 4 12) ; MISSING MESSAGE
				)
			)
			(16 ; dagger
				(if (== local0 2)
					(gMessager say: 2 16 2) ; "As you begin to form thoughts of violence..."
					(dryad setScript: egoToStag)
				else
					(gMessager say: 5 16 12) ; MISSING MESSAGE
				)
			)
			(35 ; seed
				(dryad setScript: hasSeed)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stagEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(stag
					setLoop: 1
					cel: 0
					xStep: 5
					posn: 319 150
					setCycle: Fwd
					setMotion: MoveTo 200 140 self
				)
			)
			(1
				(stag setLoop: 5 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(2
				(stag setLoop: 7 setCycle: Fwd)
				(= cycles 30)
			)
			(3
				(stag setCycle: End self)
			)
			(4
				(stag setLoop: 5 cel: 7 setCycle: Beg self)
			)
			(5
				(stag
					setLoop: 1
					cel: 0
					cycleSpeed: 6
					setCycle: Fwd
					setMotion: MoveTo 190 140 self
				)
				(gEgo posn: 319 130 init: setMotion: MoveTo 290 130)
			)
			(6
				(stag
					setLoop: 9
					cel: 0
					xStep: 9
					setCycle: End
					setMotion: JumpTo 70 140 self
				)
			)
			(7
				(stag
					setLoop: 1
					cel: 0
					xStep: 5
					setCycle: Walk
					setMotion: MoveTo 30 140 self
				)
			)
			(8
				(if (not (IsFlag 66))
					(gMessager say: 7 0 14 1 self) ; "You follow the stag into this forest corner. You feel as though the eyes of the forest are watching you."
				else
					(gMessager say: 7 0 31 1 self) ; "Again, you feel a sense of closeness with nature."
				)
			)
			(9
				(if (not (IsFlag 66))
					(gMessager say: 7 0 34 1) ; "You watch the stag, fascinated with his grace and beauty. There is something special about this place."
				else
					(gMessager say: 7 0 15 1) ; "What a beautiful animal!"
				)
				(stag setLoop: 3 setCycle: End self)
				(= local0 1)
			)
			(10
				(HandsOn)
				(self cue:)
			)
			(11
				(stag setLoop: 4 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(12
				(stag loop: 6 setCycle: Fwd)
				(= cycles (Random 20 90))
			)
			(13
				(stag setCycle: End self)
			)
			(14
				(stag loop: 4 cel: 7 setCycle: Beg self)
			)
			(15
				(= cycles (Random 5 35))
			)
			(16
				(self changeState: 11)
			)
		)
	)
)

(instance outOfTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(miscSound stop: number: 98 play:)
				(dryad setLoop: 0 setCel: 0 setCycle: End)
				(gEgo setMotion: 0)
				(= cycles 25)
			)
			(1
				(gEgo setMotion: PolyPath 204 133 self)
			)
			(2
				(cond
					((or local6 (IsFlag 203))
						(dryad setLoop: 1 cel: 6 forceUpd: setScript: egoToStag)
					)
					((IsFlag 198)
						(switch
							(Print
								addText: 7 0 28 1 0 0 76 ; "Have you brought the seed I requested?"
								addButton: 1 7 0 23 1 0 30 76 ; "Yes"
								addButton: 2 7 0 23 2 0 48 76 ; "No"
								init:
							)
							(1
								(localproc_3)
							)
							(2
								(localproc_2)
							)
						)
					)
					((IsFlag 197)
						(switch
							(Print
								addText: 7 0 29 1 0 0 76 ; "Well, Hero-to-be! Are you yet a friend of the woods?"
								addButton: 1 7 0 23 1 0 34 76 ; "Yes"
								addButton: 2 7 0 23 2 0 52 76 ; "No"
								init:
							)
							(1
								(localproc_3)
							)
							(2
								(localproc_2)
							)
						)
					)
					(else
						(switch
							(Print
								addText: 7 0 30 1 0 0 76 ; "The tree-woman speaks: "I am the Dryad, keeper of the woods. Are you one with the woods?""
								addButton: 1 7 0 23 1 0 36 76 ; "Yes"
								addButton: 2 7 0 23 2 0 54 76 ; "No"
								init:
							)
							(1
								(localproc_3)
							)
							(2
								(localproc_2)
							)
						)
					)
				)
				(SetFlag 197)
			)
		)
	)
)

(instance intoTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self cue:)
			)
			(1
				(dryad
					posn: (+ (dryad x:) 1) (+ (dryad y:) 1)
					setLoop: 0
					setCel: 14
					setCycle: Beg self
				)
				(= local0 3)
			)
			(2
				(if (IsFlag 201)
					(acorn init: setCycle: End)
					(theAcorn init:)
					(= local1 1)
					(gMessager say: 7 0 6 1 self) ; "You see an acorn fall slowly to the ground."
				else
					(self cue:)
				)
			)
			(3
				(HandsOn)
				(dryad setScript: 0)
			)
		)
	)
)

(instance hasSeed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: setMotion: MoveTo 154 135 self)
			)
			(1
				(gEgo setLoop: 3 setCycle: 0)
				(= cycles 2)
			)
			(2
				(gEgo view: 72 setLoop: 0 cel: 1 setCycle: 0 forceUpd:)
				(= cycles 15)
			)
			(3
				(gEgo setCycle: CT 2 1)
				(dryad x: (+ (dryad x:) 2) setLoop: 3 setCycle: End self)
			)
			(4
				(HandsOff)
				(gMessager say: 7 0 9) ; "You drop the seed into the Dryad's limbs."
				(SolvePuzzle 694 7)
				(gEgo setCycle: End self)
			)
			(5
				(HandsOff)
				(gEgo use: 25) ; seed
				(dryad setLoop: 0 setCel: 14)
				(gEgo
					view: 0
					setCycle: Walk
					setMotion: MoveTo 210 (gEgo y:) self
				)
			)
			(6
				(gEgo setLoop: 1 setMotion: PolyPath 190 (gEgo y:) self)
			)
			(7
				(NormalEgo)
				(gGame setCursor: gWaitCursor)
				(if (or (IsFlag 137) (IsFlag 138) (IsFlag 139))
					(gMessager say: 7 0 24) ; "You tell the Dryad: "No amount of persuasion could convince the flowers to relinquish their seed easily, so I was forced to hack my way to the seed with my weapon.""
					(dryad setScript: oMyGod)
				else
					(self cue:)
				)
			)
			(8
				(gMessager say: 7 0 18 1 self) ; "Now this will boldly grow where none has grown before!"
			)
			(9
				(dryadTalker keepWindow: 1)
				(= ticks 60)
			)
			(10
				(gMessager say: 7 0 13 1 self) ; "Heed now my words, friend of the forest, and heed them well."
			)
			(11
				(gMessager say: 7 0 13 2 self) ; "Friend, you must know that there is an evil in this valley which perverts the ways of nature. The prophecy says that a hero will bring a young human from out of this darkness."
			)
			(12
				(gMessager say: 7 0 13 3 self) ; "If you are the one to accomplish this task, there is a potion to break enchantments which the Healer can make for you."
			)
			(13
				(gMessager say: 7 0 13 4 self) ; "You must gather these ingredients:"
			)
			(14
				(gMessager say: 7 0 13 5 self) ; "Flowers from Erana's Peace,"
			)
			(15
				(gMessager say: 7 0 13 6 self) ; "Green Fur,"
			)
			(16
				(gMessager say: 7 0 13 7 self) ; "Fairy Dust,"
			)
			(17
				(gMessager say: 7 0 13 8 self) ; "a Magic Acorn,"
			)
			(18
				(gMessager say: 7 0 13 9 self) ; "and Flying Water."
			)
			(19
				(gMessager say: 7 0 13 10 self) ; "Farewell, friend. I must return to my concentration. May the forest forever surround you."
				(SetFlag 201)
				(ClearFlag 198)
				(dryadTalker keepWindow: 0)
				(dryad setScript: intoTree)
			)
		)
	)
)

(instance pickEmUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and local1 (< (gEgo distanceTo: acorn) 80))
					(gEgo get: 24 setMotion: MoveTo 147 135 self) ; acorn
				else
					(self cue:)
				)
			)
			(1
				(gEgo view: 510 setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(cond
					((and local1 (< (gEgo distanceTo: acorn) 80))
						(= local1 0)
						(SolvePuzzle 695 1)
						(acorn dispose:)
						(theAcorn dispose:)
					)
					(local2
						(gMessager say: 7 0 25) ; "You pick it up and eat it."
					)
					(else
						(gMessager say: 7 0 26) ; "The acorn appears too ordinary. You drop it back on the ground."
					)
				)
				(gEgo setCycle: Beg self)
			)
			(3
				(if local2
					(= local2 0)
					(localproc_1)
				)
				(NormalEgo)
				(gEgo setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance stagBolts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self cue:)
			)
			(1
				(stag setLoop: 4 cel: 7 setCycle: Beg self)
			)
			(2
				(stag setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(stag
					setLoop: 9
					cel: 0
					xStep: 9
					setCycle: End
					setMotion: MoveTo 10 140 self
				)
			)
			(4
				(ClearFlag 202)
				(stag dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance oMyGod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 40) (gEgo y:) self
				)
			)
			(1
				(Face gEgo dryad)
				(dryad
					setLoop: 1
					cel: 0
					posn: (- (dryad x:) 1) (- (dryad y:) 3)
					forceUpd:
				)
				(self cue:)
			)
			(2
				(gMessager say: 5 0 3 1 self) ; "You did WHAT???"
			)
			(3
				(dryad setCycle: CT 3 1)
				(= seconds 3)
			)
			(4
				(dryad setCel: 3 setCycle: CT 6 1 self)
			)
			(5
				(dryad setScript: egoToPlant)
			)
		)
	)
)

(instance egoToPlant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(stag setScript: stagBolts)
				(gMessager say: 7 0 19 0 self) ; "You have destroyed the plant that was to be preserved!"
			)
			(1
				(dryad
					setLoop: 3
					cel: 0
					posn: (+ (dryad x:) 2) (+ (dryad y:) 2)
					setCycle: CT 2 1 self
				)
			)
			(2
				(gEgo view: 79 setLoop: 0 cel: 0 setCycle: End self)
				(dryad setCel: 2 setCycle: CT 5 1)
			)
			(3
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(gEgo
					view: 79
					setLoop: 3
					cel: 0
					posn: (+ (gEgo x:) 6) (+ (gEgo y:) 5)
					forceUpd:
				)
				(= seconds 2)
			)
			(5
				(++ local5)
				(gEgo setLoop: 3 setCycle: End self)
			)
			(6
				(seed
					posn: (gEgo x:) (- (gEgo y:) 29)
					yStep: 10
					startUpd:
					show:
				)
				(self cue:)
			)
			(7
				(spitSound play:)
				(gEgo setCycle: Beg)
				(seed setMotion: MoveTo (seed x:) (- (seed y:) 30) self)
			)
			(8
				(gEgo setLoop: 3 setCycle: End)
				(seed
					yStep: 10
					setMotion: MoveTo (seed x:) (+ (seed y:) 17) self
				)
			)
			(9
				(gulpSound play:)
				(seed hide:)
				(gEgo setCycle: Beg self)
			)
			(10
				(if (< local5 4)
					(self changeState: 5)
				else
					(self cue:)
				)
			)
			(11
				(EgoDead 100 101 2 6 79) ; "Well, it looks like the Dryad really made you eat dirt. You're the spitting image of a Spirea plant, and you'll be hanging around for a long, long time."
			)
		)
	)
)

(instance egoToStag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(stag setScript: stagBolts)
				(dryad
					setLoop: 1
					cel: 0
					posn: (- (dryad x:) 1) (- (dryad y:) 3)
					forceUpd:
					setCycle: End self
				)
			)
			(1
				(cond
					((IsFlag 203)
						(gMessager say: 7 0 20 0 self) ; "You have attempted to harm a free creature of the forest!"
					)
					(local6
						(gMessager say: 7 0 21 0 self) ; "You have misused your skills, oh Magician! You have used the Flame Dart on my forest."
					)
					(else
						(gMessager say: 7 0 12 2 self) ; "You dare to harm the Dryad of the forest! You must be made less dangerous."
					)
				)
				(self cue:)
			)
			(2
				(dryad
					setLoop: 3
					cel: 0
					posn: (+ (dryad x:) 2) (+ (dryad y:) 2)
					setCycle: CT 2 1 self
				)
			)
			(3
				(gEgo view: 79 setLoop: 0 setCel: 0 setCycle: End self)
				(dryad setCel: 2 setCycle: CT 5 1)
			)
			(4
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(5
				(= seconds 5)
			)
			(6
				(EgoDead 102 103 13 1 79) ; "You are staggered by the Dryad's spell. She appears to enjoy having lots of bucks."
			)
		)
	)
)

(instance goToSleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo (gEgo x:) 147 self)
			)
			(1
				(= global40 1)
				(gCurRoom drawPic: 76 6)
				(= seconds 3)
			)
			(2
				(gMessager say: 7 0 32 1) ; "You know you will sleep comfortably and well in this quiet and protected corner of the woods."
				(= seconds 4)
			)
			(3
				(self setScript: (ScriptID 88 0) self) ; SleepAllNight
			)
			(4
				(NormalEgo)
				(HandsOff)
				(self dispose:)
			)
		)
	)
)

(instance castADart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (gCast contains: stag) (not (gEgo script:)))
					(Face gEgo stag)
					(CastDart stag self)
				else
					(CastDart 0 self)
				)
			)
			(1
				(if (== local0 2)
					(= local3 1)
				)
				(if (gCast contains: stag)
					(= local4 1)
					(SetFlag 203)
				)
				(= local6 1)
				(= ticks 6)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance aidMeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SolvePuzzle 693 1)
				(gMessager say: 7 0 7 0 self) ; "Then you shall aid me, and I shall aid you in your quest."
				(SetFlag 198)
			)
			(1
				(if (gEgo has: 25) ; seed
					(switch
						(Print
							addText: 7 0 27 1 0 0 76 ; "I detect that you have in your possession such a seed. Are you willing to give me the seed?"
							addButton: 0 7 0 23 1 0 42 76 ; "Yes"
							addButton: 1 7 0 23 2 0 60 76 ; "No"
							init:
						)
						(0
							(localproc_3)
						)
						(1
							(localproc_2)
						)
					)
				else
					(dryad setScript: intoTree)
				)
			)
		)
	)
)

(instance priorTo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 30)
			)
			(1
				(gMessager say: 7 0 33 1 self) ; "The stag is startled by your action."
			)
			(2
				(stag setScript: stagBolts)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance goTo77 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 30) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 77)
			)
		)
	)
)

(instance miscSound of Sound
	(properties
		number 97
		priority 1
		loop 2
	)
)

(instance spitSound of Sound
	(properties
		number 18
		priority 1
	)
)

(instance gulpSound of Sound
	(properties
		number 27
		priority 1
	)
)

(instance dryadTalker of Talker
	(properties
		x 10
		y 10
		view 1076
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= global451 2076)
		(PalVary pvCHANGE_TARGET 2076)
		(AssertPalette 1076)
		(= font gUserFont)
		(super init: dryadBust dryadEye dryadMouth &rest)
	)
)

(instance dryadBust of Prop
	(properties
		view 1076
	)
)

(instance dryadMouth of Prop
	(properties
		nsTop 33
		nsLeft 53
		view 1076
		loop 1
	)
)

(instance dryadEye of Prop
	(properties
		nsTop 19
		nsLeft 55
		view 1076
		loop 2
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 34) ; acorn
			(SolvePuzzle 696 -5)
			(gEgo use: 24) ; acorn
			(= local2 1)
			(localproc_1)
		else
			(return 0)
		)
	)
)

