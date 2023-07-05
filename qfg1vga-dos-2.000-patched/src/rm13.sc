;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use n008)
(use dartScript)
(use n101)
(use n102)
(use n104)
(use n105)
(use n106)
(use TargActor)
(use n814)
(use n816)
(use PChase)
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
	rm13 0
)

(local
	[local0 14]
	local14
)

(instance rm13 of Rm
	(properties
		noun 4
		picture 13
		style 8
	)

	(method (dispose)
		(= global451 0)
		(SetFlag 3)
		(= global425 0)
		(DisposeScript 816)
		(DisposeScript 930)
		(if (!= gNewRoomNum 455) ; ogreArena
			(= global279 0)
		)
		(super dispose:)
	)

	(method (init)
		(if (and (IsFlag 331) (not (IsFlag 341)))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 320 0 320 189 1 189 0 186 196 176 272 133 275 97 250 97 235 76 214 70 207 101 180 111 164 109 121 131 97 131 82 124 81 110 91 103 0 102 0 0
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 189 0 189 0 186 195 176 272 133 275 97 250 98 234 76 214 70 209 105 181 113 122 102 0 102
						yourself:
					)
			)
		)
		(Load rsSCRIPT 816 930)
		(if (IsFlag 294)
			(cond
				((IsFlag 333)
					(= local14 4)
				)
				((IsFlag 332)
					(= local14 4)
				)
				(else
					(= local14 3)
				)
			)
		else
			(= local14 0)
		)
		(ogre posn: 145 110)
		(if (not (IsFlag 3))
			(= global412 112)
		)
		(if (== gPrevRoomNum 455) ; ogreArena
			(if (<= (= global412 global280) 0)
				(SetFlag 331)
			)
		else
			(= global280 global412)
		)
		(cond
			((not (IsFlag 331))
				(LoadMany rsVIEW 455 456 510)
				(Load rsSCRIPT 972)
				(= global279 455)
			)
			((> gDay global413)
				(SetFlag 341)
			)
		)
		(gLongSong fade:)
		(super init:)
		(gFeatures add: cave rocks trees)
		(ClearFlag 160)
		(NormalEgo)
		(gEgo init:)
		(cond
			((== gPrevRoomNum 455) ; ogreArena
				(if (<= global280 0)
					(ogre posn: 97 124)
					(gEgo view: 4 posn: 66 123 loop: 0 cel: 0 setHeading: 90)
					(self setScript: ogreDies)
					(= global279 0)
				else
					(gEgo
						posn: 170 170
						loop: 1
						setMotion: PolyPath 30 160
						cel: 4
					)
					(|= global425 $0008)
					(EgoGait 1 0) ; running
					(ogre init: posn: 176 123 setScript: ogreVSego)
				)
			)
			((IsFlag 331)
				(if (not (IsFlag 341))
					(ogre
						view: 456
						loop: 0
						setCel: 7
						posn: 97 124
						init:
						stopUpd:
					)
					(cond
						((IsFlag 332)
							(aChest
								setCel: 2
								posn: (+ (ogre x:) 30) (- (ogre y:) 3)
								setPri: 8
								ignoreActors:
								init:
							)
						)
						((IsFlag 294)
							(aChest
								setCel: 0
								posn: (+ (ogre x:) 30) (- (ogre y:) 3)
								setPri: 8
								ignoreActors:
								init:
							)
						)
						(else
							(aChest
								setCel: 0
								posn: (+ (ogre x:) 30) (- (ogre y:) 3)
								setPri: 8
								ignoreActors:
								hide:
							)
						)
					)
				)
			)
			(else
				(cond
					((== global265 gDay)
						(if (== global266 gTimeOfDay)
							(ogre posn: 145 110)
						)
					)
					((> (+= global412 (* (- gDay global265) 25)) 112)
						(= global412 112)
					)
				)
				(= global280 global412)
				(|= global425 $0008)
				(ogre init: setScript: ogreVSego)
			)
		)
		(switch gPrevRoomNum
			(14
				(gEgo posn: 227 85 setScript: goOutside)
			)
			(171 ; rmBear
				(gEgo posn: 227 85 setScript: goOutside)
			)
			(else
				(if (not (== gPrevRoomNum 455)) ; ogreArena
					(gEgo posn: 2 140 setScript: goOnIn)
				)
			)
		)
	)

	(method (doit)
		(cond
			((and (== (gEgo onControl: 1) 8) (< (gEgo y:) 85))
				(gCurRoom newRoom: 14)
			)
			((and (<= (gEgo x:) 10) (not (gEgo script:)))
				(gEgo setScript: moveOnOut)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 4 1) ; "The ground shows the beginning of new spring grass."
			)
			(52 ; Sleep
				(if (IsFlag 331)
					(EgoRests 10 1)
				else
					(gMessager say: 4 52) ; "You're kidding, right?"
				)
			)
			(50 ; detectMagicSpell
				(gMessager say: 4 50) ; "A magical aura emanates from the cave's entrance."
			)
			(78 ; dazzleSpell
				(cond
					((IsFlag 341)
						(gMessager say: 4 78 6) ; "You've wasted a spell."
					)
					((IsFlag 331)
						(gMessager say: 4 78 5) ; "Ok, he'll be a dazzled cadaver."
					)
					(else
						(ogre setScript: ogreDazzled)
					)
				)
			)
			(81 ; flameDartSpell
				(if (IsFlag 331)
					(CastDart 0)
				else
					(CastDart ogre)
				)
			)
			(80 ; calmSpell
				(cond
					((IsFlag 341)
						(gMessager say: 4 80 6) ; "You've wasted a spell."
					)
					((IsFlag 331)
						(gMessager say: 4 80 5) ; "How much more calm can he get?"
					)
					(else
						(ogre setScript: ogreCalmed)
					)
				)
			)
			(51 ; openSpell
				(cond
					((and (IsFlag 331) (not (IsFlag 332)))
						(self setScript: doTheOpen)
					)
					((not (IsFlag 331))
						(gMessager say: 4 51 5) ; "Don't open the Ogre -- it's all gucky and squishy inside."
					)
					((IsFlag 333)
						(gMessager say: 4 51 9) ; "The dead Ogre's chest lies open and empty."
					)
					(else
						(gMessager say: 4 51 4) ; "The dead Ogre's chest lies open, its contents glittering brightly."
					)
				)
			)
			(82 ; fetchSpell
				(if (not (IsFlag 341))
					(gMessager say: 4 82 6) ; "You want to fetch THAT?"
				else
					(gMessager say: 4 82 22) ; "I don't know what you want to fetch."
				)
			)
			(79 ; zapSpell
				(= global229 (+ 5 (/ [gEgoStats 21] 10))) ; zapSpell
				(if (or (gEgo has: 6) (gEgo has: 2)) ; dagger, sword
					(gMessager say: 4 79 24) ; "Your weapon is now magically charged."
				else
					(gMessager say: 4 79 23) ; "You don't seem to have a weapon to charge."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cave of Feature
	(properties
		x 50
		y 100
		noun 1
		onMeCheck 8
	)
)

(instance rocks of Feature
	(properties
		x 190
		y 100
		noun 5
		onMeCheck 2
	)
)

(instance trees of Feature
	(properties
		x 90
		y 90
		noun 6
		onMeCheck 4
	)
)

(instance aChest of Prop
	(properties
		noun 2
		view 456
		loop 1
		cel 1
		signal 20480
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 332)
					(if (IsFlag 333)
						(gMessager say: 2 1 1) ; "The dead Ogre's chest lies open and empty."
					else
						(gMessager say: 2 1 4) ; "The dead Ogre's chest lies open, its contents glittering brightly."
					)
				else
					(gMessager say: 2 1 3) ; MISSING MESSAGE
				)
			)
			(4 ; Do
				(gEgo setScript: egoSearch)
			)
			(18 ; thiefKit
				(cond
					((IsFlag 332)
						(gMessager say: 2 18 1) ; "The chest is already open."
					)
					((not (IsFlag 331))
						(gMessager say: 2 18 5) ; MISSING MESSAGE
					)
					((not [gEgoStats 9]) ; pick locks
						(gMessager say: 2 18 2) ; "It's locked -- you'll have to use another skill to open this."
					)
					((TrySkill 9 0 global175) ; pick locks
						(= local14 1)
						(gEgo setScript: egoSearch)
					)
				)
			)
			(17 ; lockPick
				(cond
					((IsFlag 332)
						(gMessager say: 2 17 1) ; "The chest is already open."
					)
					((not (IsFlag 331))
						(gMessager say: 2 17 5) ; MISSING MESSAGE
					)
					((not [gEgoStats 9]) ; pick locks
						(gMessager say: 2 17 2) ; "It's locked -- you'll have to use another skill to open this."
					)
					((TrySkill 9 0 global175) ; pick locks
						(= local14 1)
						(gEgo setScript: egoSearch)
					)
				)
			)
			(26 ; brassKey
				(cond
					((IsFlag 332)
						(gMessager say: 2 26 1) ; "The chest is already open."
					)
					((not (IsFlag 331))
						(gMessager say: 2 26 5) ; MISSING MESSAGE
					)
					(else
						(gMessager say: 2 26 2) ; "You don't have the right tools -- you'll have to find another way to open it."
					)
				)
			)
			(20 ; rock
				(if (IsFlag 332)
					(gMessager say: 2 20) ; "It's already unlocked."
				else
					(= local14 2)
					(gEgo setScript: egoSearch)
				)
			)
			(12 ; sword
				(if (IsFlag 332)
					(gMessager say: 2 12) ; "It's already unlocked."
				else
					(= local14 2)
					(gEgo setScript: egoSearch)
				)
			)
			(16 ; dagger
				(if (IsFlag 332)
					(gMessager say: 2 12) ; "It's already unlocked."
				else
					(= local14 2)
					(gEgo setScript: egoSearch)
				)
			)
			(42 ; candelabra
				(cond
					((IsFlag 332)
						(gMessager say: 2 42 1) ; "It's already unlocked."
					)
					((not (IsFlag 331))
						(gMessager say: 2 42 5) ; MISSING MESSAGE
					)
					(else
						(= local14 2)
						(gEgo setScript: egoSearch)
					)
				)
			)
			(56 ; ???
				(cond
					((IsFlag 332)
						(gMessager say: 2 44 1) ; "It's already unlocked."
					)
					((not (IsFlag 331))
						(gMessager say: 2 44 5) ; MISSING MESSAGE
					)
					(else
						(= local14 2)
						(gEgo setScript: egoSearch)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ogre of TargActor
	(properties
		noun 3
		yStep 3
		view 455
		loop 1
		cel 6
		cycleSpeed 24
		xStep 5
		moveSpeed 24
		targDeltaX -12
		targDeltaY -5
	)

	(method (init)
		(= global451 1455)
		(PalVary pvCHANGE_TARGET 1455)
		(super init:)
	)

	(method (getHurt param1)
		(if (not (IsFlag 331))
			(if (<= (-= global280 param1) 0)
				(SetFlag 331)
				(HandsOff)
				(self setScript: ogreDies)
			else
				(= global412 global280)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 331)
						(if (gCast contains: aChest)
							(if (IsFlag 332)
								(if (IsFlag 333)
									(gMessager say: 3 1 9) ; "The dead Ogre's chest lies open and empty."
								else
									(gMessager say: 3 1 4) ; "The dead Ogre's chest lies open, its contents glittering brightly."
								)
							else
								(gMessager say: 3 1 5) ; "There is a big, ugly, dead Ogre here."
							)
						else
							(gMessager say: 3 1 5 1) ; "There is a big, ugly, dead Ogre here."
						)
					)
					((not (IsFlag 331))
						(gMessager say: 3 1 8 0 self) ; "The Ogre is carrying a chest in his massive arms."
					)
				)
			)
			(4 ; Do
				(if (IsFlag 331)
					(gEgo setScript: egoSearch)
				else
					(gMessager say: 3 4 8) ; "You're kidding, right?"
				)
			)
			(11 ; rations
				(if (IsFlag 331)
					(gMessager say: 3 11 5) ; "This Ogre will never eat again."
				else
					(gMessager say: 3 11 10) ; "This Ogre looks like it would rather eat you."
				)
			)
			(16 ; dagger
				(= global229 0)
				(cond
					((IsFlag 331)
						(gMessager say: 3 16 7) ; "The Ogre is already dead. It would do no good to kill him again."
					)
					((not (gEgo has: 6)) ; dagger
						(gMessager say: 3 16) ; "You don't have a knife."
					)
					((not (IsFlag 331))
						(Face gEgo ogre)
						(ThrowKnife ogre)
					)
					(else
						(ThrowKnife 0)
					)
				)
			)
			(18 ; thiefKit
				(cond
					((IsFlag 332)
						(gMessager say: 3 18 1) ; "The chest is already open."
					)
					((not (IsFlag 331))
						(gMessager say: 3 18 5) ; MISSING MESSAGE
					)
					((not [gEgoStats 9]) ; pick locks
						(gMessager say: 3 18 2) ; "It's locked -- you'll have to use another skill to open this."
					)
					((TrySkill 9 0 global175) ; pick locks
						(= local14 1)
						(gEgo setScript: egoSearch)
					)
				)
			)
			(17 ; lockPick
				(cond
					((IsFlag 332)
						(gMessager say: 3 17 1) ; "The chest is already open."
					)
					((not (IsFlag 331))
						(gMessager say: 3 17 5) ; MISSING MESSAGE
					)
					((not [gEgoStats 9]) ; pick locks
						(gMessager say: 3 17 2) ; "It's locked -- you'll have to use another skill to open this."
					)
					((TrySkill 9 0 global175) ; pick locks
						(= local14 1)
						(gEgo setScript: egoSearch)
					)
				)
			)
			(26 ; brassKey
				(cond
					((IsFlag 332)
						(gMessager say: 3 26 1) ; "The chest is already open."
					)
					((not (IsFlag 331))
						(gMessager say: 3 26 5) ; MISSING MESSAGE
					)
					(else
						(gMessager say: 3 26) ; "You don't have the right tools -- you'll have to find another way to open it."
					)
				)
			)
			(20 ; rock
				(cond
					((IsFlag 331)
						(gMessager say: 3 16 7) ; "The Ogre is already dead. It would do no good to kill him again."
					)
					((IsFlag 332)
						(gMessager say: 3 20) ; "It's already unlocked."
					)
					((not (IsFlag 331))
						(if (TrySkill 10 25) ; throwing
							(ThrowRock ogre)
						else
							(ThrowRock 0)
						)
					)
					(else
						(= local14 2)
						(gEgo setScript: egoSearch)
					)
				)
			)
			(12 ; sword
				(cond
					((IsFlag 332)
						(gMessager say: 3 12 1) ; "It's already unlocked."
					)
					((not (IsFlag 331))
						(gCurRoom newRoom: 455) ; ogreArena
					)
					(else
						(= local14 2)
						(gEgo setScript: egoSearch)
					)
				)
			)
			(54 ; ???
				(cond
					((IsFlag 332)
						(gMessager say: 3 42 1) ; "It's already unlocked."
					)
					((not (IsFlag 331))
						(gMessager say: 3 42 5) ; MISSING MESSAGE
					)
					(else
						(= local14 2)
						(gEgo setScript: egoSearch)
					)
				)
			)
			(55 ; ???
				(cond
					((IsFlag 332)
						(gMessager say: 3 56 1) ; "It's already unlocked."
					)
					((not (IsFlag 331))
						(gMessager say: 3 56 5) ; MISSING MESSAGE
					)
					(else
						(= local14 2)
						(gEgo setScript: egoSearch)
					)
				)
			)
			(78 ; dazzleSpell
				(cond
					((IsFlag 341)
						(gMessager say: 3 78 1) ; MISSING MESSAGE
					)
					((IsFlag 331)
						(gMessager say: 3 78 5) ; "Ok, he'll be a dazzled cadaver."
					)
					(else
						(ogre setScript: ogreCalmed)
					)
				)
			)
			(81 ; flameDartSpell
				(if (IsFlag 331)
					(CastDart 0)
				else
					(CastDart ogre)
				)
			)
			(80 ; calmSpell
				(cond
					((IsFlag 341)
						(gMessager say: 3 80 6) ; "You've wasted a spell."
					)
					((IsFlag 331)
						(gMessager say: 3 80 5) ; "How much more calm can he get?"
					)
					(else
						(ogre setScript: ogreCalmed)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ogreVSego of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global265 gDay)
				(= global266 gTimeOfDay)
				(= cycles 12)
			)
			(1
				(if (== (gEgo view:) 6)
					(ogre setCycle: Walk setMotion: PChase gEgo 20 self)
				else
					(ogre
						setCycle: Walk
						moveSpeed: 16
						cycleSpeed: 16
						setMotion: PChase gEgo 20 self
					)
				)
			)
			(2
				(if (not (IsFlag 331))
					(HandsOff)
					(gMessager say: 4 0 0 1 self) ; "Hostile intent is evident. You prepare for battle."
				else
					(self cue:)
				)
			)
			(3
				(HandsOff)
				(if (IsFlag 331)
					(self dispose:)
				)
				(= seconds 2)
			)
			(4
				(cond
					((IsObject global426)
						(-- state)
						(= ticks 5)
						(global426 dispose:)
					)
					((not (IsFlag 331))
						(= global410 (ogre x:))
						(= global411 (ogre y:))
						(gCurRoom newRoom: 455) ; ogreArena
					)
					(else
						(HandsOn)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance ogreDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 30)
			)
			(1
				(if (gEgo inRect: 72 94 153 132)
					(NormalEgo)
					(gGame setCursor: gWaitCursor)
					(gEgo
						setMotion:
							PolyPath
							(- (gEgo x:) 30)
							(+ (gEgo y:) 30)
					)
				)
				(= ticks 30)
			)
			(2
				(HandsOff)
				(if (> (gEgo x:) 105)
					(gEgo setHeading: 270)
				else
					(gEgo setHeading: 90)
				)
				(= global413 gDay)
				(if (not (and (== (ogre x:) 97) (== (ogre y:) 124)))
					(ogre setMotion: PolyPath 97 124 self)
				else
					(self cue:)
				)
			)
			(3
				(ogre setMotion: 0)
				(ogre
					view: 456
					setLoop: 0
					setCel: 0
					illegalBits: 0
					init:
					setPri: 7
					setCycle: CT 3 1 self
				)
			)
			(4
				(ShakeScreen 1)
				(ogre setCel: 4)
				(= ticks 15)
			)
			(5
				(ogre setCel: 5)
				(= ticks 15)
			)
			(6
				(crash number: (SoundFX 66) init: play:)
				(ShakeScreen 1)
				(= [local0 0] 134)
				(= [local0 1] 98)
				(= [local0 2] 158)
				(= [local0 3] 108)
				(= [local0 4] 147)
				(= [local0 5] 117)
				(= [local0 6] 96)
				(= [local0 7] 130)
				(= [local0 8] 81)
				(= [local0 9] 111)
				(= [local0 10] 115)
				(= [local0 11] 103)
				(= [local0 12] 30583)
				(= [local0 13] 0)
				(= seconds 1)
			)
			(7
				(proc816_0 @local0 2)
				(HandsOn)
				(SetFlag 331)
				(= local14 0)
				(= global410 (ogre x:))
				(= global411 (ogre y:))
				(ogre stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance egoSearch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 294)
				(if (gEgo inRect: 151 19 222 79)
					(self dispose:)
				else
					(HandsOff)
					(ogre illegalBits: 0 ignoreActors: 1)
					(gEgo
						ignoreActors: 1
						ignoreControl: -32768
						illegalBits: 0
					)
					(self cue:)
				)
			)
			(1
				(if (or (>= (ogre x:) 184) (>= (ogre y:) 157))
					(gEgo
						setMotion:
							PolyPath
							(- (ogre x:) 1)
							(- (ogre y:) 19)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(+ (ogre x:) 41)
							(+ (ogre y:) 6)
							self
					)
				)
			)
			(2
				(Face gEgo ogre)
				(if (or (>= (ogre x:) 184) (>= (ogre y:) 157))
					(gEgo
						view: 510
						setPri: (+ (ogre priority:) 4)
						setLoop: 0
						setCycle: End self
					)
				else
					(gEgo
						view: 510
						setPri: (+ (ogre priority:) 4)
						setLoop: 1
						setCycle: End self
					)
				)
			)
			(3
				(switch local14
					(0
						(if
							(and
								(== gCurRoomNum global252)
								(or global250 global251 [global340 6])
							)
							(gMessager say: 4 0 19) ; "You retrieve your daggers."
						)
						(= [global340 6]
							(= global251 (= global250 (= global252 0)))
						)
						(gMessager say: 4 0 13 0 self) ; "A search of the dead Ogre's body produces no treasure."
						(if (IsFlag 332)
							(= local14 4)
						else
							(= local14 3)
						)
						(if (not (gCast contains: aChest))
							(aChest
								setCel: 0
								posn: (+ (ogre x:) 30) (- (ogre y:) 3)
								setPri: (+ (ogre priority:) 1)
								ignoreActors:
								init:
							)
						else
							(aChest show:)
						)
					)
					(1
						(gEgo get: 38 1 get: 0 43) ; gold, silver
						(gMessager say: 4 0 21 1 self) ; "The lock on the Ogre's chest clicks open. The dead Ogre's chest contains 1 gold and 43 silver, which you take and put away."
						(SetFlag 332)
						(SetFlag 333)
						(= local14 4)
						(aChest setCel: 2 stopUpd:)
					)
					(2
						(gEgo get: 38 1 get: 0 43) ; gold, silver
						(gMessager say: 4 0 14 0 self) ; "You force the Ogre's chest open."
						(SetFlag 332)
						(SetFlag 333)
						(aChest setCel: 2 stopUpd:)
						(= local14 4)
					)
					(3
						(gMessager say: 4 0 15 1 self) ; "The chest is locked."
					)
					(4
						(if (IsFlag 333)
							(gMessager say: 4 0 9 1 self) ; "The dead Ogre's chest is empty."
						else
							(gEgo get: 38 1 get: 0 43) ; gold, silver
							(gMessager say: 4 0 14 2 self) ; "The dead Ogre's chest contains 1 gold and 43 silver, which you take and put away."
							(SetFlag 333)
						)
					)
				)
			)
			(4
				(switch local14
					(0
						(if
							(and
								(== gCurRoomNum global252)
								(or global250 global251 [global340 6])
							)
							(gEgo
								get: 6 (+ global250 global251 [global340 6]) ; dagger
							)
							(self cue:)
						)
					)
					(1
						(gEgo get: 38 1 get: 0 43) ; gold, silver
						(self cue:)
					)
					(2
						(gEgo get: 38 1 get: 0 43) ; gold, silver
						(self cue:)
					)
					(4
						(if (not (IsFlag 333))
							(gEgo get: 38 1 get: 0 43) ; gold, silver
						)
						(self cue:)
					)
					(else
						(self cue:)
					)
				)
			)
			(5
				(gEgo setPri: (+ (ogre priority:) 4) setCycle: Beg self)
			)
			(6
				(NormalEgo)
				(if (and (>= (ogre x:) 184) (>= (ogre y:) 157))
					(gEgo
						setCycle: Walk
						setPri: (+ (ogre priority:) 4)
						setMotion: MoveTo (- (gEgo x:) 15) (gEgo y:) self
					)
				else
					(gEgo
						setCycle: Walk
						setPri: (+ (ogre priority:) 4)
						setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:) self
					)
				)
			)
			(7
				(Face gEgo ogre)
				(= seconds 2)
			)
			(8
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance doTheOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo ogre)
				(= seconds 4)
			)
			(1
				(CastOpen)
				(= seconds 5)
			)
			(2
				(cond
					((not (gCast contains: aChest))
						(gMessager say: 4 0 11 1 self) ; "There is nothing here to open."
					)
					((IsFlag 341)
						(gMessager say: 4 0 6 0 self) ; "You're wasting a spell."
					)
					((IsFlag 331)
						(cond
							((IsFlag 332)
								(gMessager say: 4 0 20 0 self) ; MISSING MESSAGE
							)
							((> [gEgoStats 17] 10) ; openSpell
								(aChest setPri: 9 setCycle: End self)
								(= local14 4)
								(SetFlag 332)
							)
							(else
								(gMessager say: 4 0 16 1 self) ; "Your spell is too weak to open the Ogre's chest."
							)
						)
					)
					(else
						(gMessager say: 4 0 10 1 self) ; "The chest is held shut by the Ogre's massive arms."
					)
				)
			)
			(3
				(Face gEgo ogre)
				(= seconds 1)
			)
			(4
				(if (and (> [gEgoStats 17] 10) (IsFlag 332)) ; openSpell
					(gMessager say: 4 0 17 1 self) ; "Your spell unlocks the Ogre's chest."
				else
					(self cue:)
				)
			)
			(5
				(HandsOn)
				(if (IsFlag 332)
					(aChest setPri: 9 setCel: 2 stopUpd:)
				)
				(self dispose:)
			)
		)
	)
)

(instance ogreDazzled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(CastDazzle)
				(ogre setMotion: 0 cel: 2)
				(= seconds 3)
			)
			(1
				(RedrawCast)
				(= seconds 1)
			)
			(2
				(gMessager say: 4 0 12 1 self) ; "The Ogre is dazzled by your spell."
			)
			(3
				(= seconds 14)
			)
			(4
				(gMessager say: 4 0 18) ; "The Ogre appears to have recovered from your spell."
				(client setScript: ogreVSego)
			)
		)
	)
)

(instance ogreCalmed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(CastCalm)
				(= ticks 6)
			)
			(1
				(ogre setMotion: 0 cel: 2)
				(RedrawCast)
				(= seconds 14)
			)
			(2
				(gMessager say: 4 0 18) ; "The Ogre appears to have recovered from your spell."
				(client setScript: ogreVSego)
			)
		)
	)
)

(instance moveOnOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -20 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 12)
			)
		)
	)
)

(instance goOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 20 140 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goOutside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 224 121 self)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(client setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance crash of Sound
	(properties
		priority 14
	)
)

