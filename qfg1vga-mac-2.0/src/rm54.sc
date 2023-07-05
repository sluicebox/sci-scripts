;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use dartScript)
(use n101)
(use n102)
(use n106)
(use TargActor)
(use n814)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm54 0
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
)

(procedure (localproc_0)
	(cond
		((and (not local0) (IsFlag 278))
			(gCurRoom setScript: sFallOutOfTree)
		)
		((IsFlag 278)
			(gMessager say: 9 4 26) ; "You can't do that while you're up in the tree!"
		)
		(else
			(= local2 1)
			(ThrowRock 0)
		)
	)
)

(instance roomTimer of Timer
	(properties)
)

(instance ringTimer of Timer
	(properties)
)

(instance rm54 of Rm
	(properties
		noun 9
		picture 54
		style 8
		horizon 1
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 120 0 319 0 319 55 160 149 103 120 129 102 120 94
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 135 30 135 95 148 116 167 116 172 92 172 92 184 56 184 50 176 38 176 22 189 0 189
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 0 0 91 0 91 112 0 112 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 249 189 218 163 319 146 319 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 140 190 154 180 151 319 71
					yourself:
				)
		)
		(LoadMany rsVIEW 55 510)
		(super init:)
		(SL enable:)
		(door cycleSpeed: 2 setPri: 8 init: approachVerbs: 4 stopUpd:) ; Do
		(if (not (IsFlag 210))
			(theRing init: setCel: 0 setPri: 15)
			(ringTimer setReal: theRing (Random 10 20))
		)
		(if (== global277 0)
			(nest init: stopUpd:)
		)
		(if (not (IsFlag 212))
			(bird
				ignoreActors:
				init:
				cycleSpeed: 1
				stopUpd:
				setScript: sFlutter
			)
			(birdFeature init:)
		)
		(switch gPrevRoomNum
			(37
				(self setScript: sEnterFrom37)
			)
			(53
				(self setScript: sEnterFromWest)
			)
			(55
				(gCurRoom setScript: sFromInsideHouse)
			)
			(56
				(self setScript: sEnterFromEast)
			)
			(else
				(self setScript: sEnterFromSouth)
			)
		)
		(theSign init:)
		(theRock init: hide:)
		(tree init: approachVerbs: 4 setOnMeCheck: 1 4) ; Do
		(hut init: approachVerbs: 4 setOnMeCheck: 1 2) ; Do
		(gardenR init: setOnMeCheck: 1 16384)
		(gardenL init: setOnMeCheck: 1 16384)
		(castle init: setOnMeCheck: 1 8)
		(ground init: setOnMeCheck: 1 32)
		(pathRight init: setOnMeCheck: 1 8)
		(pathLeft init: setOnMeCheck: 1 8)
		(gardenR approachVerbs: 4) ; Do
		(gardenL approachVerbs: 4) ; Do
	)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((gEgo script:) 0)
			((== (gEgo onControl: 1) 16)
				(self setScript: sEnter37)
			)
			((gEgo edgeHit:)
				(switch (gEgo edgeHit:)
					(4
						(self setScript: sExitWest)
					)
					(2
						(self setScript: sExitEast)
					)
				)
			)
			((> (gEgo y:) 185)
				(self setScript: sExitSouth)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gEgo actions: 0)
		(roomTimer dispose: delete:)
		(if (== global277 2)
			(= global277 3)
		)
	)

	(method (cue)
		(if (not (IsFlag 44))
			(SetFlag 44)
			(gMessager say: 9 0 19) ; "The bright smell of fresh herbs mingles with the aroma of wood smoke as you come up to a hut by the side of the road."
		else
			(switch local11
				(1
					(gMessager say: 3 4 2 2) ; "I don't like thievery. Go away!"
				)
				(2
					(if (== global277 0)
						(gMessager say: 12 1 29) ; "There is a nest on the limb that stretches toward the hut."
					)
				)
				(3
					(gMessager say: 9 0 15 2) ; "You place the ring into your pack and the nest on the ground."
				)
				(4
					(gMessager say: 9 0 0 6) ; "You take the ring and move carefully back along the limb."
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(3 ; Walk
				(if (IsFlag 278)
					(gCurRoom setScript: sFallOutOfTree)
				)
			)
			(78 ; dazzleSpell
				(cond
					((IsFlag 278)
						(gMessager say: 9 78 11) ; "As you try to cast a spell from your high perch on the tree, you lose your concentration, and..."
						(gCurRoom setScript: sFallOutOfTree)
					)
					((!= global277 3)
						(CastDazzle gEgo)
						(if (not (IsFlag 212))
							(bird setScript: 0 cue:)
						)
					)
				)
			)
			(82 ; fetchSpell
				(cond
					((IsFlag 278)
						(gMessager say: 9 82 11) ; "As you try to cast a spell from your high perch on the tree, you lose your concentration, and..."
						(gCurRoom setScript: sFallOutOfTree)
					)
					((and (== global277 0) (not (IsFlag 210)))
						(gCurRoom setScript: sThrowLasso)
					)
					(else
						(Print addText: 9 82 12 1 0 0 54 y: 10 ticks: -1 init:) ; "That spell is no longer useful here (but you did get some practice)."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tree of Feature
	(properties
		x 91
		y 4
		z 90
		noun 12
		nsTop -1
		nsBottom 189
		nsRight 183
		approachX 45
		approachY 176
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(1 ; Look
				(= local11 2)
				(gMessager say: 12 1 0 1 gCurRoom) ; "The tree is a large oak."
			)
			(4 ; Do
				(if (IsFlag 278)
					(gCurRoom setScript: sClimbDown)
				else
					(gCurRoom setScript: sClimbUpTree)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance castle of Feature
	(properties
		x 120
		y 32
		noun 2
		nsTop 15
		nsLeft 80
		nsBottom 50
		nsRight 160
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(16 ; dagger
				(if (not (IsFlag 212))
					(bird setScript: 0 cue:)
				)
				(ThrowKnife 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hut of Feature
	(properties
		x 229
		y 76
		noun 5
		nsLeft 140
		nsBottom 152
		nsRight 319
		approachX 196
		approachY 138
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(1 ; Look
				(gMessager say: 5 1 5) ; "The house looks cheery and well-kept. It has the sign of the Healer above the entrance."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ground of Feature
	(properties
		x 163
		y 139
		noun 4
		nsTop 90
		nsLeft 63
		nsBottom 189
		nsRight 263
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(1 ; Look
				(gMessager say: 4 1) ; "The road leads north to a castle in the distance and south to the crossroads. To the west you can see a farmer's fields."
			)
			(4 ; Do
				(cond
					((and (not local0) (IsFlag 278))
						(gCurRoom setScript: sFallOutOfTree)
					)
					((IsFlag 278)
						(gMessager say: 9 4 26) ; "You can't do that while you're up in the tree!"
					)
					(else
						(gCurRoom setScript: sGetRock)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pathRight of Feature
	(properties
		x 268
		y 151
		noun 8
		nsTop 132
		nsLeft 218
		nsBottom 171
		nsRight 319
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pathLeft of Feature
	(properties
		x 23
		y 118
		noun 7
		nsTop 103
		nsBottom 134
		nsRight 47
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theWindow of Feature ; UNUSED
	(properties
		x 311
		y 82
		noun 11
		nsTop 71
		nsLeft 303
		nsBottom 93
		nsRight 319
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(1 ; Look
				(if gNight
					(gMessager say: 11 1 1) ; "You can see nothing in the dark."
				else
					(gMessager say: 11 1 28) ; "The curtains obscure your vision. You can only make out a clutter of bottles, jars, and pots on the sill."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theSign of Feature
	(properties
		x 205
		y 36
		noun 10
		nsTop 29
		nsLeft 195
		nsBottom 44
		nsRight 216
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 195
		y 117
		noun 3
		approachX 195
		approachY 135
		view 55
		loop 1
		signal 24576
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(4 ; Do
				(cond
					((and (not local0) (IsFlag 278))
						(gCurRoom setScript: sFallOutOfTree)
					)
					((IsFlag 278)
						(gMessager say: 9 4 26) ; "You can't do that while you're up in the tree!"
					)
					(
						(and
							(not (gEgo mover:))
							(!= (gEgo x:) approachX)
							(!= (gEgo y:) approachY)
						)
						(= local5 98)
						(gEgo setMotion: PolyPath approachX approachY self)
					)
					(gNight
						(gMessager say: 3 4 1) ; "There is no answer."
					)
					((and (IsFlag 226) (!= gPrevRoomNum 55))
						(= local11 1)
						(gMessager say: 3 4 2 1 gCurRoom) ; "You hear the voice of the healer saying: "The last time you were here, I found I was missing some potions.""
					)
					((not (gCurRoom script:))
						(gCurRoom setScript: sKnockDoor self)
					)
				)
			)
			(17 ; lockPick
				(if (TrySkill 9 10 0) ; pick locks
					(gMessager say: 3 17 4) ; "Your lock-picking skill will do you no good here. The door is barred from the inside."
				else
					(gMessager say: 3 17 3) ; "The door appears to be barred on the inside."
				)
			)
			(18 ; thiefKit
				(if (TrySkill 9 10 0) ; pick locks
					(gMessager say: 3 17 4) ; "Your lock-picking skill will do you no good here. The door is barred from the inside."
				else
					(gMessager say: 3 17 3) ; "The door appears to be barred on the inside."
				)
			)
			(1 ; Look
				(gMessager say: 3 1) ; "The door seems to be barred on the inside. Perhaps you should knock."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance magicLasso of Actor
	(properties
		view 520
		signal 18448
		illegalBits 0
	)
)

(instance theRock of Actor
	(properties
		yStep 4
		view 510
		loop 4
		priority 10
		signal 18448
		illegalBits 0
		xStep 4
		moveSpeed 1
	)
)

(instance nest of TargActor
	(properties
		x 111
		y 59
		noun 6
		view 55
		priority 12
		signal 18448
		cycleSpeed 1
		targDeltaY 30
	)

	(method (getHurt)
		(if (or local1 local2)
			(cond
				((> (+ [gEgoStats 4] [gEgoStats 10]) 50) ; luck, throwing
					(gCurRoom setScript: nestDown)
				)
				(local1
					(gMessager say: 6 16 7) ; "Your dagger misses the nest and falls to the ground; you'll have to keep practicing."
				)
			)
		else
			(gCurRoom setScript: burnUp)
		)
		(ClearFlag 281)
		(= local2 0)
		(= local1 0)
	)

	(method (cue)
		(super cue:)
		(switch (++ local9)
			(1
				(self setCycle: CT 4 1 self)
			)
			(2
				(roomTimer setCycle: self 2)
			)
			(3
				(self setCycle: CT 2 -1 self)
			)
			(4
				(= local9 0)
				(roomTimer setCycle: self 2)
			)
			(99
				(if (IsFlag 278)
					(if (not (IsFlag 210))
						(gMessager say: 6 1 14) ; "In the nest is an object which appears to be a ring, glinting in the sunlight."
						(SetFlag 209)
					else
						(gMessager say: 6 1 15) ; "It is empty now."
					)
				)
				(= local9 0)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(cond
					((IsFlag 278)
						(gCurRoom setScript: sFallOutOfTree)
					)
					((== global277 0)
						(gCurRoom setScript: sThrowRock)
					)
					(else
						(gMessager say: 6 20 0) ; "You don't need to do that now."
					)
				)
			)
			(4 ; Do
				(switch global277
					(0
						(cond
							((and (IsFlag 278) (not (IsFlag 210)))
								(gCurRoom setScript: outOnALimb)
							)
							((IsFlag 278)
								(gMessager say: 6 4 11) ; "It would be too messy to stow in your pack, and it doesn't appear to be good for anything."
							)
							(else
								(gMessager say: 6 4 12) ; "Perhaps you can do that."
							)
						)
					)
					(1
						(gMessager say: 6 4 10) ; "It's a mess, and you don't need it, anyway."
					)
					(2
						(if (not (IsFlag 210))
							(= local8 1)
							(gCurRoom setScript: sPickItUp)
						else
							(switch (Random 1 2)
								(1
									(gMessager say: 6 4 8) ; "You see nothing in the remains of the nest."
								)
								(2
									(gMessager say: 6 4 9) ; "There's not enough left to bother with."
								)
							)
						)
					)
				)
			)
			(1 ; Look
				(cond
					((== global277 1)
						(gMessager say: 6 1 17) ; "The remnants of the nest are scattered on the ground."
					)
					((not (IsFlag 212))
						(gMessager say: 6 1 13) ; "It is made of twigs, leaves, and herbs, probably stolen from the healer's garden."
					)
					((== global277 0)
						(gMessager say: 6 1 18 0 self) ; "The nest sits on the branch."
						(= local9 98)
					)
					((== global277 2)
						(gMessager say: 6 1 16) ; "What's left of the nest is charred beyond recognition."
					)
				)
			)
			(16 ; dagger
				(if (and (not (IsFlag 278)) (== global277 0))
					(= local1 1)
					(ThrowKnife self)
				else
					(gMessager say: 6 20 0) ; "You don't need to do that now."
				)
			)
			(81 ; flameDartSpell
				(cond
					((IsFlag 278)
						(gCurRoom setScript: sFallOutOfTree)
					)
					((!= global277 3)
						(CastDart self)
						(if (not (IsFlag 212))
							(bird setScript: 0 cue:)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
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
				(gEgo
					init:
					posn: 200 246
					actions: egoActions
					setMotion: MoveTo 200 180 self
				)
			)
			(2
				(NormalEgo)
				(HandsOn)
				(= ticks 10)
			)
			(3
				(gCurRoom cue:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo
					init:
					actions: egoActions
					posn: -25 117
					setMotion: PolyPath 95 129 self
				)
			)
			(2
				(NormalEgo)
				(HandsOn)
				(= ticks 10)
			)
			(3
				(gCurRoom cue:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFrom37 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo
					init:
					posn: 104 98
					actions: egoActions
					setMotion: PolyPath 90 130 self
				)
			)
			(2
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGetRock of Script
	(properties)

	(method (changeState newState &tmp [temp0 40])
		(switch (= state newState)
			(0
				(HandsOff)
				(= local3 (gEgo cycleSpeed:))
				(= local4 (gEgo moveSpeed:))
				(= ticks 10)
			)
			(1
				(gEgo setMotion: PolyPath 172 172 self)
			)
			(2
				(= register (Random 0 1))
				(gEgo
					view: 510
					setLoop: register
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(Message msgGET 54 9 4 27 1 @temp0) ; "You pick up a few small rocks."
				(Print addText: @temp0 init:)
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo)
				(if register
					(gEgo setHeading: 270 self)
				else
					(gEgo setHeading: 90 self)
				)
			)
			(5
				(HandsOn)
				(gEgo cycleSpeed: local3 moveSpeed: local4 get: 10 10) ; rock
				(self dispose:)
			)
		)
	)
)

(instance sFlutter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 120 300))
			)
			(1
				(lizSound play:)
				(if (not (bird cel:))
					(bird cycleSpeed: (Random 6 12) setCycle: End self)
				else
					(bird cycleSpeed: (Random 6 12) setCycle: Beg self)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance rockHitsIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theRock setMotion: MoveTo (nest x:) (nest y:) self)
			)
			(1
				(theRock setMotion: MoveTo -10 (- (nest y:) 40) self)
			)
			(2
				(gCurRoom setScript: nestDown)
				(theRock dispose:)
			)
		)
	)
)

(instance sPickItUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(NormalEgo)
				(gEgo setMotion: PolyPath (+ (nest x:) 15) 164 self)
			)
			(2
				(gEgo view: 510 setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(if (not (IsFlag 210))
					(gMessager say: 9 0 0 2) ; "You pick up a shiny gold ring."
					(theRing dispose:)
				)
				(if (== (nest loop:) 7)
					(nest setCel: 1)
				else
					(nest hide:)
				)
				(gEgo setCycle: Beg self)
			)
			(4
				(if (not (IsFlag 210))
					(gEgo get: 18) ; ring
					(SetFlag 210)
					(SolvePuzzle 667 3)
				)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance burnUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global277 2)
				(= ticks 10)
			)
			(1
				(if (not (IsFlag 212))
					(bird setScript: 0 cue:)
				)
				(= ticks 30)
			)
			(2
				(nest
					setPri: 15
					setLoop: 0
					setCel: 2
					moveSpeed: 1
					cycleSpeed: 0
					setMotion: MoveTo 114 164 self
					cue:
				)
			)
			(3
				(= local9 5)
				(nest setCel: 0 cycleSpeed: 6 setCycle: End self cue:)
			)
			(4
				(nest setLoop: 7 setCel: 255 setPri: -1 addToPic:)
				(= cycles 2)
			)
			(5
				(if (IsFlag 210)
					(NormalEgo)
					(HandsOn)
					(self dispose:)
				else
					(theRing
						posn: (nest x:) (nest y:)
						setPri: 15
						setCycle: End self
					)
					(burntNest init:)
				)
			)
			(6
				(gMessager say: 6 1 16 0 self) ; "What's left of the nest is charred beyond recognition."
			)
			(7
				(gCurRoom setScript: sPickItUp)
			)
		)
	)
)

(instance sEnter37 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 1)
			)
			(1
				(gEgo
					illegalBits: 0
					setPri: 4
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) 115 self
				)
			)
			(2
				(gCurRoom newRoom: 37)
			)
		)
	)
)

(instance sFromInsideHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(Load rsSOUND 2091)
				(door ignoreActors: 1 setCel: 255)
				(= cycles 2)
			)
			(2
				(gEgo
					init:
					illegalBits: 0
					actions: egoActions
					posn: 257 105
					setLoop: 5
					setMotion: PolyPath 160 163 self
				)
			)
			(3
				(gEgo setLoop: -1)
				(slamDoor play:)
				(door ignoreActors: 0 setCycle: Beg self)
			)
			(4
				(door stopUpd:)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sClimbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo
					view: 517
					setLoop: 1
					setCel: 255
					setStep: 3 2
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					setLoop: 0
					posn: 58 84
					setCel: 4
					setCycle: Rev
					setMotion: MoveTo 50 140 self
				)
				(egoInTree dispose:)
			)
			(3
				(gEgo setCycle: 0)
				(NormalEgo)
				(HandsOn)
				(gEgo posn: (tree approachX:) (tree approachY:) loop: 3)
				(ClearFlag 278)
				(self dispose:)
			)
		)
	)
)

(instance sExitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo setMotion: MoveTo -25 (gEgo y:) self)
			)
			(2
				(gCurRoom newRoom: 53)
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
				(gEgo setMotion: MoveTo (gEgo x:) 246 self)
			)
			(2
				(gCurRoom newRoom: 65)
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
				(= ticks 10)
			)
			(1
				(gEgo setMotion: MoveTo 349 134 self)
			)
			(2
				(gCurRoom newRoom: 56)
			)
		)
	)
)

(instance sEnterFromEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo
					init:
					posn: 349 134
					actions: egoActions
					setMotion: PolyPath 160 163 self
				)
			)
			(2
				(NormalEgo)
				(HandsOn)
				(= ticks 10)
			)
			(3
				(gCurRoom cue:)
				(self dispose:)
			)
		)
	)
)

(instance outOnALimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo view: 55 setLoop: 8 setCel: 0 setPri: 14 setStep: 1 1)
				(= register 10)
				(= cycles 2)
			)
			(2
				(gEgo
					setCel: 0
					setCycle: End self
					setMotion: MoveTo (+ (gEgo x:) 3) (gEgo y:) self
				)
			)
			(3)
			(4
				(if (not (-- register))
					(= cycles 2)
				else
					(= state 1)
					(= ticks 20)
				)
			)
			(5
				(if (TrySkill 2 30) ; agility
					(gEgo setCycle: Fwd setMotion: MoveTo 100 63 self)
				else
					(= local10 1)
					(gCurRoom setScript: sFallOutOfTree)
				)
			)
			(6
				(gEgo setCycle: 0)
				(= ticks 20)
			)
			(7
				(gMessager say: 9 0 0 4) ; "You carefully bend down and reach into the nest."
				(gEgo setLoop: 9 setCel: 0 setCycle: End self)
			)
			(8
				(= ticks 20)
			)
			(9
				(= local11 4)
				(gMessager say: 9 0 0 5 gCurRoom) ; "In the nest, you find a gold ring."
				(SetFlag 210)
				(gEgo setCycle: Beg self)
				(SolvePuzzle 667 3)
			)
			(10
				(gEgo get: 18) ; ring
				(= ticks 20)
			)
			(11
				(gEgo setLoop: 8 setCycle: Rev setMotion: MoveTo 64 64 self)
			)
			(12
				(gMessager say: 9 0 0 7) ; "Made it! Now back down the tree."
				(gEgo setCycle: 0)
				(self dispose:)
				(gEgo setScript: sClimbDown)
			)
		)
	)
)

(instance closingDoor of Sound
	(properties
		number 2089
	)
)

(instance lizSound of Sound
	(properties
		number 2074
	)
)

(instance slamDoor of Sound
	(properties
		number 2091
	)
)

(instance knockSound of Sound
	(properties
		number 2078
	)
)

(instance fallSound of Sound
	(properties
		number 2009
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(else
				(if (and (== theVerb 3) (IsFlag 278)) ; Walk
					(gCurRoom setScript: sFallOutOfTree)
					(return 1)
				else
					(return 0)
				)
			)
		)
	)
)

(instance burntNest of Feature
	(properties
		x 112
		y 158
		nsTop 140
		nsLeft 98
		nsBottom 171
		nsRight 130
		sightAngle 40
		approachX 112
		approachY 158
	)

	(method (doVerb theVerb)
		(nest doVerb: theVerb &rest)
	)
)

(instance sKnockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: 6)
				(= cycles 1)
			)
			(1
				(knockSound play:)
				(= ticks 60)
			)
			(2
				(knockSound play:)
				(= ticks 60)
			)
			(3
				(knockSound play:)
				(= ticks 60)
			)
			(4
				(= ticks 60)
			)
			(5
				(gMessager say: 3 72 0 0 self) ; "You politely knock on the door."
			)
			(6
				(closingDoor init: play:)
				(door ignoreActors: 1 setCycle: End self)
			)
			(7
				(gCurRoom newRoom: 55)
				(self dispose:)
			)
		)
	)
)

(instance gardenL of Feature
	(properties
		x 152
		y 119
		nsTop 100
		nsLeft 119
		nsBottom 139
		nsRight 186
		sightAngle 40
		approachX 196
		approachY 138
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(1 ; Look
				(gMessager say: 5 1 6) ; "In front of the hut is a small garden in which grow the kinds of plants and herbs that are used for making potions."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gardenR of Feature
	(properties
		x 246
		y 140
		nsTop 122
		nsLeft 208
		nsBottom 158
		nsRight 284
		sightAngle 40
		approachX 196
		approachY 138
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(1 ; Look
				(gMessager say: 5 1 6) ; "In front of the hut is a small garden in which grow the kinds of plants and herbs that are used for making potions."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance birdFeature of Feature
	(properties
		x 113
		y 54
		nsTop 37
		nsLeft 96
		nsBottom 71
		nsRight 131
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(localproc_0)
			)
			(81 ; flameDartSpell
				(bird setScript: 0 cue:)
			)
			(16 ; dagger
				(bird setScript: 0 cue:)
				(ThrowKnife 0)
			)
			(1 ; Look
				(if (< gMouseY 60)
					(castle doVerb: theVerb &rest)
				else
					(gMessager say: 6 1 13 2) ; "There is a birdlike creature sitting in the nest."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theRing of Prop
	(properties
		x 112
		y 57
		view 55
		loop 5
		signal 18448
	)

	(method (doVerb theVerb)
		(nest doVerb: theVerb &rest)
	)

	(method (cue)
		(super cue:)
		(if (and (== global277 0) (not (IsFlag 210)) (not local7))
			(= local7 1)
			(self show: setCel: 0 setCycle: End self)
		else
			(self hide:)
			(= local7 0)
			(ringTimer setReal: self (Random 8 16))
		)
	)
)

(instance sFallOutOfTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local3 (gEgo cycleSpeed:))
				(= local4 (gEgo moveSpeed:))
				(= local0 1)
				(= ticks 10)
			)
			(1
				(ClearFlag 278)
				(gEgo
					view: 517
					setLoop: 2
					cycleSpeed: 8
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(fallSound number: 2009 play:)
				(gEgo
					posn: (+ (gEgo x:) 30) (gEgo y:)
					setLoop: 4
					setCycle: Fwd
					setStep: 4 4
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 127 160 self
				)
			)
			(3
				(gEgo setLoop: 6 setCel: 0 setCycle: End self)
			)
			(4
				(ShakeScreen 2)
				(fallSound number: 2010 play:)
				(= seconds 4)
			)
			(5
				(if (not (TakeDamage 8))
					(EgoDead 68 69 5 2 517) ; "Had you been healthier, you probably could have survived that fall. In your weakened condition, however, you succumbed to your injuries."
				else
					(switch (Random 1 5)
						(1
							(gMessager say: 9 0 5) ; "Experience is the best teacher."
						)
						(2
							(gMessager say: 9 0 6) ; "Practice makes perfect."
						)
						(3
							(gMessager say: 9 0 25) ; "Try, try again, etc..."
						)
						(4
							(gMessager say: 9 0 21) ; "Take a break. It's Mueller time."
						)
						(5
							(gMessager say: 9 0 20) ; "Remember what happened to Humpty Dumpty."
						)
					)
					(gEgo view: 517 setLoop: 8 setCel: 6)
					(= ticks 30)
				)
			)
			(6
				(gEgo setCel: 7)
				(egoInTree dispose:)
				(= ticks 30)
			)
			(7
				(if local10
					(= local10 0)
					(gMessager say: 9 0 23) ; "That's what happens sometimes when you go out on a limb."
				)
				(NormalEgo)
				(HandsOn)
				(gEgo cycleSpeed: local3 moveSpeed: local4 loop: 2)
				(self dispose:)
			)
		)
	)
)

(instance bird of Actor
	(properties
		x 112
		y 151
		z 100
		noun 1
		view 55
		loop 6
		priority 13
		signal 18448
		illegalBits 0
	)

	(method (cue)
		(super cue:)
		(switch (++ local6)
			(1
				(bird
					cycleSpeed: 6
					setLoop: 3
					setCel: 0
					z: 0
					posn: 133 41
					setPri: 15
				)
				(roomTimer setCycle: self 2)
			)
			(2
				(lizSound loop: -1 play:)
				(bird setCycle: End self)
			)
			(3
				(lizSound stop:)
				(SetFlag 212)
				(= local6 0)
				(birdFeature dispose:)
				(self dispose:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(gCurRoom setScript: sThrowRock)
			)
			(16 ; dagger
				(self setScript: 0 cue:)
				(SetFlag 281)
				(= local1 1)
				(ThrowKnife 0)
			)
			(1 ; Look
				(gMessager say: 1 1) ; "The creature looks more like a small flying lizard than a bird."
			)
			(4 ; Do
				(gMessager say: 1 4) ; "You can't reach the birdlike creature from here."
			)
			(else
				(nest doVerb: theVerb &rest)
			)
		)
	)
)

(instance nestDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(nest
					setLoop: 4
					setStep: 5 5
					setCycle: Fwd
					cycleSpeed: 3
					illegalBits: 0
					ignoreActors: 1
					moveSpeed: 1
					setMotion: MoveTo 114 164 self
				)
			)
			(2
				(nest setLoop: 7 setCel: 0 setCycle: End self)
				(= global277 1)
			)
			(3
				(if (IsFlag 210)
					(gMessager say: 9 0 24) ; "You see nothing in the nest."
					(NormalEgo)
					(HandsOn)
					(self dispose:)
				else
					(theRing
						posn: (nest x:) (nest y:)
						setPri: 15
						setCycle: End self
						ignoreActors: 1
					)
					(gMessager say: 9 0 22) ; "You see a glinting object in the remains of the nest."
				)
			)
			(4
				(gCurRoom setScript: sPickItUp)
			)
		)
	)
)

(instance sThrowRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 1)
				(= ticks 10)
			)
			(1
				(if (and (!= (gEgo y:) 155) (!= (gEgo x:) 217))
					(gEgo setMotion: PolyPath 217 155 self)
				else
					(= cycles 2)
				)
			)
			(2
				(gEgo setHeading: 270 self)
			)
			(3
				(if (not (IsFlag 212))
					(bird setScript: 0 cue:)
				)
				(gEgo view: 510 setLoop: 2 setCel: 0 setCycle: CT 7 1 self)
			)
			(4
				(theRock show: posn: (+ (gEgo x:) 1) (- (gEgo y:) 41))
				(= ticks 5)
			)
			(5
				(gEgo setCel: 8)
				(theRock posn: (- (gEgo x:) 14) (- (gEgo y:) 39))
				(= ticks 5)
			)
			(6
				(gEgo setCel: 9)
				(theRock posn: (- (gEgo x:) 35) (- (gEgo y:) 55))
				(= ticks 5)
			)
			(7
				(cond
					((> (+ [gEgoStats 4] [gEgoStats 10]) 50) ; luck, throwing
						(= global277 1)
						(theRock setScript: rockHitsIt)
					)
					((> [gEgoStats 10] 25) ; throwing
						(= global277 1)
						(theRock setScript: rockHitsIt)
					)
					(else
						(TrySkill 10) ; throwing
						(theRock setCycle: Fwd setMotion: MoveTo 0 0)
					)
				)
				(= seconds 3)
			)
			(8
				(NormalEgo)
				(HandsOn)
				(gEgo use: 10 1 loop: 1) ; rock
				(= local2 0)
				(self dispose:)
			)
		)
	)
)

(instance sThrowLasso of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(if (and (!= (gEgo y:) 155) (!= (gEgo x:) 217))
					(gEgo setMotion: PolyPath 217 155 self)
				else
					(= cycles 2)
				)
			)
			(2
				(gEgo setHeading: 270 self)
			)
			(3
				(gEgo view: 520 setLoop: 0 setCel: 0)
				(= cycles 2)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(if (not (IsFlag 212))
					(bird setScript: 0 cue:)
				)
				(theRing dispose:)
				(magicLasso
					init:
					posn: 207 109
					setLoop: 5
					setStep: 4 4
					setCycle: Fwd
					setPri: 15
					setMotion: MoveTo 113 57 self
				)
			)
			(6
				(magicLasso setStep: 6 4 setMotion: MoveTo 207 109 self)
				(nest setPri: 14 setStep: 6 4 setMotion: MoveTo 207 115 self)
			)
			(7)
			(8
				(magicLasso hide:)
				(nest hide:)
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(9
				(if (IsFlag 210)
					(gMessager say: 9 0 14) ; "You place the nest on the ground. It is of no use to you."
				else
					(= local11 3)
					(gMessager say: 9 0 15 1 gCurRoom) ; "You take a lovely gold ring from the nest."
					(SetFlag 210)
					(theRing dispose:)
					(SolvePuzzle 667 3)
				)
				(magicLasso dispose:)
				(gEgo
					view: 510
					setLoop: 1
					setCel: 0
					posn: (+ (gEgo x:) 2) (gEgo y:)
					setCycle: End self
				)
			)
			(10
				(gEgo get: 18) ; ring
				(nest
					setLoop: 7
					setCel: 255
					posn: (- (gEgo x:) 14) (+ (gEgo y:) 6)
					setPri: -1
					show:
					stopUpd:
				)
				(gEgo setCycle: Beg self)
			)
			(11
				(= global277 1)
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance sClimbUpTree of Script
	(properties)

	(method (dispose)
		(gEgo cycleSpeed: local3 moveSpeed: local4)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local3 (gEgo cycleSpeed:))
				(= local4 (gEgo moveSpeed:))
				(= ticks 10)
			)
			(1
				(if
					(and
						(!= (gEgo x:) (tree approachX:))
						(!= (gEgo y:) (tree approachY:))
					)
					(gEgo
						setMotion:
							PolyPath
							(tree approachX:)
							(tree approachY:)
							self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo
					view: 517
					setLoop: 0
					setCel: 0
					setPri: 15
					posn: 50 140
					setCycle: Fwd
				)
				(if (TrySkill 11 30 0) ; climbing
					(+= state 3)
					(gEgo setMotion: MoveTo 58 84 self)
				else
					(gEgo setMotion: MoveTo 58 115 self)
				)
			)
			(3
				(gEgo setCel: 255 setMotion: MoveTo 50 140 self)
			)
			(4
				(NormalEgo)
				(gEgo posn: (tree approachX:) (tree approachY:) loop: 3)
				(= cycles 2)
			)
			(5
				(gMessager say: 9 0 0 3) ; "It takes a lot of skill and practice to climb this tree."
				(SkillUsed 11 1) ; climbing
				(HandsOn)
				(self dispose:)
			)
			(6
				(gEgo setLoop: 1 setCel: 0 posn: 64 64 setCycle: End self)
			)
			(7
				(gEgo view: 4 setPri: 15 setLoop: 2)
				(if (not (IsFlag 212))
					(bird setScript: 0 cue:)
				)
				(egoInTree init:)
				(= ticks 60)
			)
			(8
				(HandsOn)
				(User canControl: 0)
				(SetFlag 278)
				(gTheIconBar disable: 6)
				(self dispose:)
			)
		)
	)
)

(instance egoInTree of Feature
	(properties
		x 65
		y 142
		z 100
		nsTop 13
		nsLeft 47
		nsBottom 71
		nsRight 83
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gCurRoom setScript: sFallOutOfTree)
		else
			(tree doVerb: theVerb &rest)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (== (event message:) JOY_NULL))
				(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
				(& (event type:) $0040) ; direction
			)
			(gCurRoom setScript: sFallOutOfTree)
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

