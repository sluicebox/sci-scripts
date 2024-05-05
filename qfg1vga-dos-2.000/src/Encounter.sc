;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use n101)
(use n102)
(use n104)
(use n106)
(use TargActor)
(use n814)
(use n816)
(use Print)
(use PChase)
(use PolyPath)
(use Motion)
(use Game)
(use User)
(use System)

(public
	Encounter 0
	smallMonster 1
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
	local13
	[local14 30]
	[local44 12] = [500 40 40 40 60 50 30 35 40 50 30 40]
	[local56 12] = [10000 133 186 53 86 113 60 140 93 186 60 100]
	local68
	local69
	local70
)

(procedure (localproc_0 param1 &tmp temp0)
	(if (<= 420 param1 470)
		(return (+ 1 (/ (- param1 420) 5)))
	else
		(return 0)
	)
)

(procedure (localproc_1)
	(cond
		((> global103 310)
			(= local1 2)
		)
		((< global103 10)
			(= local1 4)
		)
		((< global104 100)
			(= local1 1)
		)
		(else
			(= local1 3)
		)
	)
)

(procedure (localproc_2 param1)
	(ClearFlag 351)
	(= local7 1)
	(= local8 1)
	(if (or (not local4) (not (gCast contains: local4)))
		((= local4 smallMonster) init:)
	)
	(= local5 (+ global279 1))
	(SkillUsed 4 (/ [local56 (localproc_0 global279)] 12)) ; luck
	(if param1
		(local4 setLoop: 1)
		(cond
			((OneOf gCurRoomNum 19 43 75 92)
				(gEgo posn: 164 108)
				(if (!= global279 435)
					(local4 posn: 88 112)
				else
					(local4 posn: 150 100)
				)
			)
			((== gCurRoomNum 79)
				(gEgo posn: 120 120)
				(local4 posn: 220 120)
			)
			((and (OneOf gCurRoomNum 19 43 86) (== global279 465))
				(gEgo posn: 140 120)
				(local4 posn: 60 120)
			)
			((== global279 435)
				(gEgo posn: 150 120)
				(local4 posn: 150 100)
			)
			((== global279 460)
				(gEgo posn: 120 120)
				(local4 posn: 293 128)
			)
			((== global279 440)
				(gEgo posn: 150 120)
				(local4 posn: 235 134)
			)
			(else
				(gEgo posn: 150 122)
				(local4 posn: 220 137)
			)
		)
	)
	(gEgo
		loop: 1
		illegalBits: (gCurRoom illBits:)
		ignoreControl: -32768
		ignoreActors:
		init:
	)
	(NormalEgo)
	(EgoGait 0 0) ; walking
	(local4 setScript: killTheMonster)
)

(procedure (localproc_3 param1)
	(param1
		illegalBits: 0
		setMotion: PChase gEgo [local44 (localproc_0 global279)] Encounter
	)
	(= local68 1)
	(param1 setScript: 0)
)

(procedure (localproc_4 param1 &tmp temp0 temp1)
	(if (and argc param1)
		(= temp1 param1)
	else
		(cond
			((< [gEgoStats 13] 1000) ; experience
				(= temp0 (Random 0 3))
			)
			((< [gEgoStats 13] 2000) ; experience
				(= temp0 (Random 0 6))
			)
			(else
				(= temp0 (Random 2 6))
			)
		)
		(if gNight
			(+= temp0 2)
		)
		(= temp1
			(switch temp0
				(0 445)
				(1 430)
				(2 445)
				(3 465)
				(4 435)
				(5 440)
				(6 460)
				(else 450)
			)
		)
	)
	(if (OneOf gCurRoomNum 85 86 92)
		(if (or (<= temp0 4) (not gNight))
			(= temp1 465)
		else
			(= temp1 450)
		)
	)
	(= global262 0)
	(cond
		((== temp1 445)
			(= global262 (Random 1 10))
		)
		((== temp1 465)
			(= global262 (Random 5 25))
		)
		((== temp1 450)
			(= global262 (Random 20 50))
		)
		((== temp1 425)
			(= global262 50)
		)
	)
	(|= global425 $0008)
	(return temp1)
)

(procedure (localproc_5 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 40])
	(= temp2 (& (gCurRoom entrances:) $000a))
	(= temp4 (& (gCurRoom entrances:) $0008))
	(= temp3 (& (gCurRoom entrances:) $0002))
	(param2 view: param1)
	(if (!= param1 435)
		(param2 xStep: 6 yStep: 4 cel: 0)
		(switch param1
			(430
				(param2 xStep: 5 yStep: 3 setCycle: Fwd)
			)
			(450
				(param2 xStep: 5 yStep: 3 setCycle: Walk)
			)
			(440
				(param2 xStep: 6 yStep: 3 setCycle: Fwd)
			)
			(445
				(param2 xStep: 4 yStep: 2 setCycle: Walk)
			)
			(465
				(param2 xStep: 3 yStep: 2 setCycle: Walk)
			)
			(460
				(param2 xStep: 8 yStep: 5 setCycle: Fwd)
			)
		)
		(if global186
			(param2 xStep: (* (param2 xStep:) 2) yStep: (* (param2 yStep:) 2))
		)
	)
	(cond
		(local2
			(proc814_32 1)
			(if (== param1 435)
				(local4
					setCycle: Walk
					z: 25
					xStep: (Random 4 8)
					yStep: (Random 3 5)
				)
			)
			(= local68 1)
			(switch local1
				(1
					(if
						(or
							(== param1 445)
							(== param1 450)
							(== param1 465)
							(== param1 455)
						)
						(gEgo setMotion: MoveTo global103 (- global104 2))
						(local4
							posn:
								(+ (gEgo x:) (Random 20 40))
								(+
									(gEgo y:)
									[local44 (localproc_0 param1)]
									(Random 20 30)
								)
							setCel: -1
							setLoop: 3
						)
						(local4 setScript: runDelay)
					else
						(gEgo setMotion: MoveTo 320 global104)
						(local4
							posn:
								(-
									(gEgo x:)
									(+
										[local44 (localproc_0 param1)]
										(Random 25 40)
									)
								)
								(gEgo y:)
							setLoop: 0
							setCel: -1
						)
						(local4 setScript: runDelay)
					)
				)
				(3
					(if
						(or
							(== param1 445)
							(== param1 450)
							(== param1 465)
							(== param1 455)
						)
						(gEgo setMotion: MoveTo global103 (+ global104 2))
						(switch (gCurRoom picture:)
							(704
								(local4 posn: 209 87 setLoop: 2)
							)
							(705
								(local4 posn: 61 78 setLoop: 2)
							)
							(else
								(local4
									setLoop: 2
									posn:
										(- (gEgo x:) 10)
										(-
											(gEgo y:)
											(+
												[local44 (localproc_0 param1)]
												(Random 20 30)
											)
										)
								)
							)
						)
						(local4 setCel: -1)
						(local4 setScript: runDelay)
					else
						(gEgo setMotion: MoveTo 0 global104)
						(local4
							posn:
								(+
									(gEgo x:)
									[local44 (localproc_0 param1)]
									(Random 25 40)
								)
								(gEgo y:)
							setLoop: 1
							setCel: -1
						)
						(local4 setScript: runDelay)
					)
				)
				(2
					(gEgo setMotion: MoveTo 320 global104)
					(local4
						posn:
							(-
								(gEgo x:)
								(+
									[local44 (localproc_0 param1)]
									(Random 25 40)
								)
							)
							(gEgo y:)
						setLoop: 0
						setCel: -1
					)
					(local4 setScript: runDelay)
				)
				(4
					(gEgo setMotion: MoveTo 0 global104)
					(local4
						posn:
							(+
								(gEgo x:)
								[local44 (localproc_0 param1)]
								(Random 25 40)
							)
							(gEgo y:)
						setLoop: 1
						setCel: -1
					)
					(local4 setScript: runDelay)
				)
			)
			(User canControl: 1)
		)
		(local3
			(if (== param1 435)
				(local4
					setCycle: Walk
					z: 25
					xStep: (Random 4 8)
					yStep: (Random 3 5)
				)
			)
			(= local68 1)
			(switch local1
				(1
					(= local68 0)
					(gEgo setMotion: MoveTo global103 190)
					(if
						(or
							(== param1 445)
							(== param1 450)
							(== param1 465)
							(== param1 455)
						)
						(local4 setScript: northDelay)
					else
						(= param1 (= global280 0))
						(local4 dispose:)
						(= global279 0)
						(= local68 0)
					)
				)
				(3
					(gEgo setMotion: MoveTo global103 0)
					(if
						(or
							(== param1 445)
							(== param1 450)
							(== param1 465)
							(== param1 455)
						)
						(local4 setScript: southDelay)
					else
						(= global279 (= global280 0))
						(local4 dispose:)
						(= global279 0)
						(= local68 0)
					)
				)
				(2
					(gEgo setMotion: MoveTo 0 global104)
					(local4
						posn: (- global103 global114) (+ global104 global115)
						loop: 1
						setCel: -1
						setLoop: -1
						setMotion:
							PChase
							gEgo
							[local44 (localproc_0 param1)]
							Encounter
					)
				)
				(4
					(gEgo setMotion: MoveTo 320 global104)
					(local4
						posn: (- global103 global114) (+ global104 global115)
						loop: 0
						setCel: -1
						setLoop: -1
						setMotion:
							PChase
							gEgo
							[local44 (localproc_0 param1)]
							Encounter
					)
				)
			)
		)
		((== param1 435)
			(local4 setScript: (ScriptID 436 2)) ; startup
		)
		((== temp2 10)
			(switch (= temp2 (if (< (Random 0 1000) 500) 8 else 2))
				(2
					(param2 setScript: inEast)
				)
				(8
					(param2 setScript: inWest)
				)
			)
		)
		(temp3
			(param2 setScript: inEast)
		)
		(temp4
			(param2 setScript: inWest)
		)
		(else
			(= temp0 (gCurRoom ambushX:))
			(= temp1 (gCurRoom ambushY:))
			(param2
				posn: temp0 temp1
				setMotion:
					PChase
					gEgo
					[local44 (localproc_0 param1)]
					Encounter
			)
		)
	)
)

(procedure (localproc_6 &tmp [temp0 120] [temp120 70])
	(switch global262
		(0
			(gMessager say: 2 0 13 0 0 210) ; "What a waste! No treasure!"
		)
		(1
			(proc921_0
				{You find a single silver coin, carefully polish it, and place it in your pouch.__What a way to make a living!}
			)
			(gEgo get: 0 1) ; silver
		)
		(else
			(proc921_1
				@temp120
				{You find %d silver coins, and carefully place them in your pouch.}
				global262
			)
			(gEgo get: 0 global262) ; silver
		)
	)
	(= global262 0)
)

(class EncRoom of Rm
	(properties
		encChance 0
		entrances 15
		ambushX 160
		ambushY 100
		illBits -32768
	)
)

(instance smallMonster of TargActor
	(properties
		noun 3
		modNum 210
		view 435
		signal 24576
		illegalBits 0
	)

	(method (init)
		(if (!= global279 465)
			(= global451 (+ global279 1000))
			(PalVary pvCHANGE_TARGET (+ global279 1000))
			(AssertPalette global279)
		)
		(cond
			((== global279 435))
			(
				(or
					(== global279 455)
					(== global279 450)
					(== global279 465)
					(== global279 445)
				)
				(self looper: aLooper4)
			)
			(else
				(self looper: aLooper2)
			)
		)
		(switch global279
			(425
				(self targDeltaY: -35)
			)
			(430
				(self targDeltaX: 5)
				(self targDeltaY: -32)
			)
			(435
				(self targDeltaX: -40)
			)
			(440
				(self targDeltaX: 7)
				(self targDeltaY: -22)
			)
			(445
				(self targDeltaX: -3)
				(self targDeltaY: -19)
			)
			(450
				(self targDeltaX: -5)
				(self targDeltaY: -32)
			)
			(455
				(self targDeltaY: -30)
			)
			(460
				(self targDeltaX: 7)
				(self targDeltaY: -28)
			)
			(465
				(self targDeltaY: -27)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; sword
				(if local7
					(AlreadyDone)
				else
					(gCurRoom newRoom: global279)
				)
			)
			(20 ; rock
				(if local7
					(AlreadyDone)
				else
					(ThrowRock smallMonster)
				)
			)
			(16 ; dagger
				(if local7
					(AlreadyDone)
				else
					(ThrowKnife smallMonster)
				)
			)
			(1 ; Look
				(if local7
					(gMessager say: 3 1 20 0 0 210) ; "It's dead, of course."
				else
					(switch global279
						(445
							(gMessager say: 3 1 19 0 0 210) ; "It's an ugly little Goblin."
						)
						(465
							(gMessager say: 3 1 16 0 0 210) ; "Uh oh, this looks like one of the brigands that have been terrorizing the Valley. Better hope his friends aren't around."
						)
						(430
							(gMessager say: 3 1 24 0 0 210) ; "Don't worry, it's just a little purple Saurus. Watch out for those teeth though."
						)
						(460
							(gMessager say: 3 1 18 0 0 210) ; "Oh, no! It's a fierce (and hungry) looking Saurus Rex (smarter than your average Saurus)."
						)
						(440
							(gMessager say: 3 1 18 0 0 210) ; "Oh, no! It's a fierce (and hungry) looking Saurus Rex (smarter than your average Saurus)."
						)
						(455
							(gMessager say: 3 1 22 0 0 210) ; "It's an Ogre, big, mean, and ugly. Ogres are said to eat human flesh."
						)
						(450
							(gMessager say: 3 1 15 0 0 210) ; "It's a Troll, hard as stone."
						)
						(435
							(gMessager say: 3 1 21 0 0 210) ; "It's a Mantray, a former sea creature that took flight many generations ago and moved to the mountains. Don't get stung!"
						)
						(else
							(gMessager say: 3 1 21 0 0 210) ; "It's a Mantray, a former sea creature that took flight many generations ago and moved to the mountains. Don't get stung!"
						)
					)
				)
			)
			(48 ; Smell [ REMOVED ]
				(gMessager say: 3 48 0 0 0 210) ; "You can't help but smell it."
			)
			(4 ; Do
				(if local7
					(if local0
						(AlreadyDone)
					else
						(gEgo setScript: searchIt 0 local4)
					)
				else
					(gCurRoom newRoom: global279)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if local13
			(= local13 0)
			(localproc_6)
		)
	)

	(method (getHurt param1)
		(= local69 1)
		(= local70 0)
		(-= global280 param1)
	)
)

(instance Encounter of Rgn
	(properties
		modNum 210
		noun 1
	)

	(method (init &tmp temp0 temp1)
		(= local12 1)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(HandsOn)
		(ScriptID 930) ; MISSING EXPORT
		(Load rsSCRIPT 816)
		(super init: &rest)
		(= local3 (= local2 (= local69 0)))
		(= local4 0)
		(cond
			(
				(not
					(OneOf
						gPrevRoomNum
						420 ; bearArena
						425 ; minotaurArena
						430 ; saurusArena
						435 ; mantrayArena
						440 ; cheetaurArena
						445 ; goblinArena
						455 ; ogreArena
						450 ; trollArena
						460 ; dragonArena
						465 ; brigandArena
						470
					)
				)
				(if global279
					(if (and (== global279 450) (not gNight))
						(gEgo illegalBits: (gCurRoom illBits:) init:)
						(= global279 (= global280 0))
						(Animate (gCast elements:) 0)
						(gMessager say: 1 0 1 1 0 210) ; "As the sun begins to rise, the Troll runs off to some dark hole."
					else
						(= local3 1)
						(gEgo illegalBits: (gCurRoom illBits:) init:)
						(= local6 (= local7 0))
						(localproc_4 global279)
					)
				else
					(= temp0 (gCurRoom encChance:))
					(if gNight
						(*= temp0 2)
					)
					(if (IsFlag 87)
						(*= temp0 2)
					)
					(if (== gPrevRoomNum 45)
						(= temp0 0)
					)
					(cond
						((> (Random100) temp0))
						(
							(and
								(== gEgoGait 2) ; sneaking
								(TrySkill 8 temp0) ; stealth
								(TrySkill 4 0 0) ; luck
							)
							(Animate (gCast elements:) 0)
							(gMessager say: 1 0 3 2 0 210) ; "A monster just wandered by. You hid in the bushes until it passed."
						)
						(else
							(= global279 (localproc_4 0))
							(= global280 [local56 (localproc_0 global279)])
							(= local6 (= local7 0))
						)
					)
					(gEgo illegalBits: (gCurRoom illBits:))
				)
			)
			((<= global280 0)
				(localproc_2 1)
			)
			(else
				(= local6 (= local7 0))
				(EgoGait 1 0) ; running
				(= local2 1)
				(NormalEgo)
				(gEgo illegalBits: (gCurRoom illBits:) posn: 160 140 init:)
				(localproc_4 global279)
			)
		)
		(localproc_1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; calmSpell
				(if (or local68 (== global279 435))
					(local4 setScript: spellDelay 0 22)
					(return 1)
				else
					(gMessager say: 1 58 0 1 0 210) ; "Although that spell is not useful here, you at least had a chance to practice it."
					(return 1)
				)
			)
			(51 ; openSpell
				(gMessager say: 1 58 0 2 0 210) ; "You don't see anything closed around here."
				(return 1)
			)
			(50 ; detectMagicSpell
				(gMessager say: 1 58 0 3 0 210) ; "You sense no magic here."
				(return 1)
			)
			(78 ; dazzleSpell
				(if (or local68 (== global279 435))
					(local4 setScript: spellDelay 0 20)
				else
					(gMessager say: 1 58 0 4 0 210) ; "Although that spell is not useful here, you at least had a chance to practice it."
				)
				(return 1)
			)
			(79 ; zapSpell
				(= global229 (+ 5 (/ [gEgoStats 21] 10))) ; zapSpell
				(if (or (gEgo has: 6) (gEgo has: 2)) ; dagger, sword
					(gMessager say: 1 58 0 5 0 210) ; "Your weapon is now magically charged."
				else
					(gMessager say: 1 58 0 6 0 210) ; "You don't seem to have a weapon to charge."
				)
				(return 1)
			)
			(82 ; fetchSpell
				(if local6
					(gMessager say: 1 58 0 7 0 210) ; "Certainly you don't want to Fetch THAT!"
				else
					(gMessager say: 1 58 0 8 0 210) ; "Good practice, but there's nothing worth Fetching here."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(= global451 0)
		(= global425 0)
		(DisposeScript 930)
		(DisposeScript 816)
		(DisposeScript 436)
		(super dispose: &rest)
		(DisposeScript 210)
	)

	(method (newRoom newRoomNumber)
		(HandsOff)
		(if local6
			(= global114 (- (gEgo x:) (local4 x:)))
			(= global115 (- (gEgo y:) (local4 y:)))
		)
		(if
			(or
				local7
				(> global114 250)
				(> global115 180)
				(and
					(not
						(OneOf
							newRoomNumber
							420 ; bearArena
							425 ; minotaurArena
							430 ; saurusArena
							435 ; mantrayArena
							440 ; cheetaurArena
							445 ; goblinArena
							455 ; ogreArena
							450 ; trollArena
							460 ; dragonArena
							465 ; brigandArena
							470
						)
					)
					(not
						(OneOf
							newRoomNumber
							11
							12
							17
							18
							19
							23
							24
							25
							26
							27
							33
							34
							35
							36
							42
							43
							44
							51
							52
							56
							57
							61
							62
							63
							69
							71
							72
							74
							75
							79
							80
							81
							85
							86
							92
						)
					)
				)
			)
			(= global279 (= global280 0))
			(= global243 0)
		)
		(ClearFlag 351)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doit)
		(cond
			(
				(and
					(not local6)
					(not local7)
					global279
					(or local3 (gEgo inRect: 40 40 260 160))
				)
				(= local6 1)
				((= local4 smallMonster) posn: 0 1000 init:)
				(localproc_5 global279 local4)
			)
			((and (== global279 435) (IsFlag 351))
				(localproc_2 0)
			)
			(
				(and
					local6
					global279
					(not local8)
					(<= global280 0)
					(not (IsFlag 351))
				)
				(localproc_2 0)
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		(if (and local12 global279 (> global280 0))
			(= local12 0)
			(EgoGait 0 0) ; walking
			(if (and local12 (or local2 local3))
				(self setScript: checkProject 0 0)
			else
				(self setScript: checkProject 0 1)
			)
		)
	)
)

(instance checkProject of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and global279 (> global280 0))
					(HandsOff)
					(if (not register)
						(gEgo setMotion: 0)
						(smallMonster setMotion: 0)
						(gMessager say: 1 0 2 3 self 210) ; "You could not escape. The battle is on."
					else
						(gEgo setMotion: 0)
						(smallMonster setMotion: 0)
						(gMessager say: 1 0 4 4 self 210) ; "Hostile intent is evident. You prepare for battle."
					)
				else
					(= ticks 1)
				)
			)
			(1
				(HandsOff)
				(= ticks 20)
			)
			(2
				(cond
					((IsObject global426)
						(-- state)
						(global426 dispose:)
						(= cycles 2)
					)
					((and global279 (> global280 0))
						(if (IsObject gNarrator)
							(gNarrator dispose:)
						)
						(if (IsObject gFastCast)
							(gFastCast dispose:)
						)
						(gCurRoom newRoom: global279)
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

(instance inWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 0 posn: -100 106 setMotion: MoveTo 0 106 self)
			)
			(1
				(localproc_3 client)
			)
		)
	)
)

(instance inEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 1 posn: 400 106 setMotion: MoveTo 310 106 self)
			)
			(1
				(localproc_3 client)
			)
		)
	)
)

(instance northDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 90)
			)
			(1
				(local4
					posn:
						global103
						(cond
							((> (gCurRoom horizon:) (- global104 global115))
								(- (gCurRoom horizon:) 20)
							)
							((== global279 435) -10)
							(else
								(- global104 global115)
							)
						)
					setCel: -1
					setLoop: -1
					setMotion:
						PChase
						gEgo
						[local44 (localproc_0 global279)]
						Encounter
				)
				(= local68 1)
				(client setScript: 0)
			)
		)
	)
)

(instance southDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 90)
			)
			(1
				(local4
					posn:
						global103
						(if (== global279 435)
							235
						else
							(- global104 global115)
						)
					setCel: -1
					setLoop: -1
					setMotion:
						PChase
						gEgo
						[local44 (localproc_0 global279)]
						Encounter
				)
				(= local68 1)
				(client setScript: 0)
			)
		)
	)
)

(instance runDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: 0)
				(= ticks 90)
			)
			(1
				(client
					setCycle: Fwd
					setMotion:
						PChase
						gEgo
						[local44 (localproc_0 global279)]
						Encounter
				)
				(client setScript: 0)
			)
		)
	)
)

(instance spellDelay of Script
	(properties)

	(method (doit)
		(if (and seconds local69 (not local70))
			(= seconds 0)
			(= cycles 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local68 0)
				(local4 setCycle: 0 setMotion: 0 ignoreActors: 0)
				(if (== register 22)
					(if (not (CastCalm self self))
						(self changeState: 4)
					)
				else
					(self changeState: 2)
				)
			)
			(1
				(= state 3)
				(cond
					((== global279 435)
						(proc921_0
							{Unfortunately, the Mantray appears not to have been affected by your spell.}
						)
						(= ticks 1)
					)
					(local69
						(proc921_0
							{The monster doesn't seem very calm.__Maybe it didn't like you hurting it.}
						)
						(= ticks 1)
					)
					(else
						(= seconds (+ 5 (/ [gEgoStats 22] 10))) ; calmSpell
					)
				)
			)
			(2
				(= local70 1)
				(if (not (CastDazzle self self))
					(self changeState: 4)
				)
			)
			(3
				(if (== global279 435)
					(proc921_0
						{Unfortunately, the Mantray appears not to have been affected by your spell.}
					)
					(= ticks 1)
				else
					(= seconds (+ 3 (/ [gEgoStats 22] 10))) ; calmSpell
				)
			)
			(4
				(if (not local8)
					(if
						(or
							(== global279 445)
							(== global279 450)
							(== global279 465)
							(== global279 455)
							(< -15 (- (gEgo x:) (local4 x:)) 15)
						)
						(local4 setLoop: -1 setCycle: Walk)
					else
						(local4 setCycle: Fwd)
					)
					(local4
						ignoreActors:
						setMotion:
							PChase
							gEgo
							[local44 (localproc_0 global279)]
							Encounter
					)
					(= local68 1)
				)
				(= local70 0)
				(self dispose:)
			)
		)
	)
)

(instance searchIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 register)
				(local4 ignoreActors:)
				(= local10
					(switch global279
						(430 -1)
						(440 1)
						(460 71)
						(445 -26)
						(435 33)
						(465 19)
						(425 38)
						(455 -34)
						(450 11)
						(else 13)
					)
				)
				(= local11
					(switch global279
						(430 -7)
						(440 -17)
						(460 -20)
						(445 -15)
						(435 -7)
						(465 -10)
						(425 -16)
						(455 -17)
						(450 -17)
						(else -14)
					)
				)
				(if (and (== global279 460) (local4 loop:))
					(= local10 -58)
				)
				(HandsOff)
				(gEgo
					ignoreActors:
					setMotion:
						PolyPath
						(+ (local4 x:) local10)
						(+ (local4 y:) local11)
						self
				)
			)
			(1
				(gEgo
					view: 510
					setLoop:
						(cond
							((== global279 445) 0)
							((== global279 465) 1)
							(else
								(mod (gEgo loop:) 2)
							)
						)
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gMessager say: 2 0 0 1 self 210) ; "You search your opponent."
			)
			(4
				(cond
					((== global279 450)
						(if (IsFlag 308)
							(gEgo get: 37) ; trollBeard
							(= local13 1)
							(gMessager say: 2 0 6 2 smallMonster 210) ; "You remove as much of the Troll's beard as you can and put it away in your pack."
						else
							(localproc_6)
						)
					)
					((== global279 440)
						(if (IsFlag 350)
							(gMessager say: 2 60 14 1 0 210) ; "Some of the Cheetaur's claws have been broken off or damaged, apparently in battle. You remove the remaining claws and put them away in your pack."
							(gEgo get: 36 (Random 4 10)) ; cheetaurClaw
						else
							(localproc_6)
						)
					)
					(else
						(localproc_6)
					)
				)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					setMotion:
						PolyPath
						185
						(if (< (gEgo x:) (local4 x:)) 140 else 160)
						self
				)
			)
			(5
				(if (and (== global279 450) (not (IsFlag 308)))
					(gMessager say: 2 60 15 1 0 210) ; "You thought that the Troll might have concealed some of its treasure in that thick beard, but you didn't find any there."
				)
				(= local0 1)
				(NormalEgo 2 4)
				(gEgo illegalBits: (gCurRoom illBits:))
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance killTheMonster of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global425 0)
				(if (!= global279 435)
					(local4
						view: local5
						setLoop:
							(if (> (local4 loop:) 1)
								0
							else
								(local4 loop:)
							)
						cel: 0
						ignoreActors:
						setMotion: 0
						cycleSpeed: 8
					)
					(if (== local4 450)
						(local4 setLoop: 0)
					)
					(if (!= global279 445)
						(local4 setCycle: End self)
					else
						(= ticks 1)
					)
				else
					(self setScript: (ScriptID 436 3) self local4) ; killMantray
				)
			)
			(1
				(= temp0 (local4 x:))
				(= temp1 (local4 y:))
				(local4 stopUpd:)
				(gEgo ignoreActors:)
				(HandsOn)
				(switch global279
					(445
						(if (not (local4 loop:))
							(= [local14 0] (+ temp0 31))
							(= [local14 1] (- temp1 17))
							(= [local14 2] (+ temp0 11))
							(= [local14 3] (+ temp1 4))
							(= [local14 4] (- temp0 20))
							(= [local14 5] (+ temp1 5))
							(= [local14 6] (- temp0 26))
							(= [local14 7] (- temp1 15))
							(= [local14 8] temp0)
							(= [local14 9] (- temp1 30))
							(= [local14 10] 30583)
							(= [local14 11] 0)
							(proc816_0 @local14 2)
						else
							(= [local14 0] (+ temp0 4))
							(= [local14 1] (- temp1 20))
							(= [local14 2] (+ temp0 31))
							(= [local14 3] (- temp1 14))
							(= [local14 4] (+ temp0 27))
							(= [local14 5] (- temp1 5))
							(= [local14 6] (- temp0 17))
							(= [local14 7] (+ temp1 5))
							(= [local14 8] (- temp0 27))
							(= [local14 9] (- temp1 16))
							(= [local14 10] (- temp0 13))
							(= [local14 11] (- temp1 28))
							(= [local14 12] 30583)
							(= [local14 13] 0)
							(proc816_0 @local14 2)
						)
					)
					(435
						(if (== (local4 loop:) 6)
							(= [local14 0] (- temp0 8))
							(= [local14 1] (- temp1 8))
							(= [local14 2] (- temp0 16))
							(= [local14 3] (+ temp1 12))
							(= [local14 4] (- temp0 26))
							(= [local14 5] (+ temp1 25))
							(= [local14 6] (- temp0 48))
							(= [local14 7] (+ temp1 20))
							(= [local14 8] (- temp0 56))
							(= [local14 9] (- temp1 5))
							(= [local14 10] 30583)
							(= [local14 11] 0)
							(proc816_0 @local14 2)
						else
							(= [local14 0] (+ temp0 8))
							(= [local14 1] (- temp1 8))
							(= [local14 2] (+ temp0 66))
							(= [local14 3] (- temp1 5))
							(= [local14 4] (+ temp0 49))
							(= [local14 5] (+ temp1 19))
							(= [local14 6] (+ temp0 27))
							(= [local14 7] (+ temp1 25))
							(= [local14 8] (+ temp0 17))
							(= [local14 9] (+ temp1 13))
							(= [local14 10] 30583)
							(= [local14 11] 0)
							(proc816_0 @local14 2)
						)
					)
					(430
						(if (not (local4 loop:))
							(= [local14 0] (- temp0 28))
							(= [local14 1] (- temp1 11))
							(= [local14 2] (+ temp0 24))
							(= [local14 3] (- temp1 11))
							(= [local14 4] (+ temp0 38))
							(= [local14 5] (- temp1 4))
							(= [local14 6] (+ temp0 33))
							(= [local14 7] (+ temp1 8))
							(= [local14 8] (+ temp0 4))
							(= [local14 9] (+ temp1 8))
							(= [local14 10] (+ temp0 4))
							(= [local14 11] (+ temp1 5))
							(= [local14 12] (- temp0 15))
							(= [local14 13] (+ temp1 5))
							(= [local14 14] (- temp0 15))
							(= [local14 15] (+ temp1 11))
							(= [local14 16] (- temp0 34))
							(= [local14 17] (+ temp1 11))
							(= [local14 18] (- temp0 34))
							(= [local14 19] (+ temp1 4))
							(= [local14 20] (- temp0 58))
							(= [local14 21] (+ temp1 6))
							(= [local14 22] (- temp0 60))
							(= [local14 23] temp1)
							(= [local14 24] 30583)
							(= [local14 25] 0)
							(proc816_0 @local14 2)
						else
							(= [local14 0] (- temp0 25))
							(= [local14 1] (- temp1 11))
							(= [local14 2] (+ temp0 30))
							(= [local14 3] (- temp1 11))
							(= [local14 4] (+ temp0 61))
							(= [local14 5] (+ temp1 1))
							(= [local14 6] (+ temp0 59))
							(= [local14 7] (+ temp1 5))
							(= [local14 8] (+ temp0 35))
							(= [local14 9] (+ temp1 4))
							(= [local14 10] (+ temp0 34))
							(= [local14 11] (+ temp1 10))
							(= [local14 12] (+ temp0 16))
							(= [local14 13] (+ temp1 10))
							(= [local14 14] (+ temp0 15))
							(= [local14 15] (+ temp1 5))
							(= [local14 16] (- temp0 4))
							(= [local14 17] (+ temp1 5))
							(= [local14 18] (- temp0 3))
							(= [local14 19] (+ temp1 8))
							(= [local14 20] (- temp0 32))
							(= [local14 21] (+ temp1 8))
							(= [local14 22] (- temp0 37))
							(= [local14 23] (- temp1 4))
							(= [local14 24] 30583)
							(= [local14 25] 0)
							(proc816_0 @local14 2)
						)
					)
					(440
						(if (not (local4 loop:))
							(= [local14 0] (+ temp0 32))
							(= [local14 1] (- temp1 17))
							(= [local14 2] (+ temp0 48))
							(= [local14 3] (- temp1 12))
							(= [local14 4] (+ temp0 28))
							(= [local14 5] (+ temp1 4))
							(= [local14 6] (- temp0 6))
							(= [local14 7] (+ temp1 4))
							(= [local14 8] (- temp0 12))
							(= [local14 9] (+ temp1 1))
							(= [local14 10] (- temp0 31))
							(= [local14 11] (+ temp1 1))
							(= [local14 12] (- temp0 31))
							(= [local14 13] (- temp1 3))
							(= [local14 14] (- temp0 21))
							(= [local14 15] (- temp1 15))
							(= [local14 16] 30583)
							(= [local14 17] 0)
							(proc816_0 @local14 2)
						else
							(= [local14 0] (- temp0 24))
							(= [local14 1] (- temp1 19))
							(= [local14 2] (+ temp0 20))
							(= [local14 3] (- temp1 15))
							(= [local14 4] (+ temp0 31))
							(= [local14 5] (+ temp1 1))
							(= [local14 6] (+ temp0 11))
							(= [local14 7] (+ temp1 1))
							(= [local14 8] (+ temp0 7))
							(= [local14 9] (+ temp1 4))
							(= [local14 10] (- temp0 28))
							(= [local14 11] (+ temp1 3))
							(= [local14 12] (- temp0 47))
							(= [local14 13] (- temp1 12))
							(= [local14 14] 30583)
							(= [local14 15] 0)
							(proc816_0 @local14 2)
						)
					)
					(465
						(if (not (local4 loop:))
							(= [local14 0] (- temp0 22))
							(= [local14 1] (- temp1 18))
							(= [local14 2] (- temp0 7))
							(= [local14 3] (- temp1 23))
							(= [local14 4] (+ temp0 15))
							(= [local14 5] (- temp1 10))
							(= [local14 6] (+ temp0 43))
							(= [local14 7] (- temp1 16))
							(= [local14 8] (+ temp0 54))
							(= [local14 9] (- temp1 9))
							(= [local14 10] (+ temp0 57))
							(= [local14 11] (- temp1 2))
							(= [local14 12] (+ temp0 33))
							(= [local14 13] (+ temp1 5))
							(= [local14 14] (- temp0 1))
							(= [local14 15] (+ temp1 9))
							(= [local14 16] (- temp0 26))
							(= [local14 17] (- temp1 9))
							(= [local14 18] 30583)
							(= [local14 19] 0)
							(proc816_0 @local14 2)
						else
							(= [local14 0] (- temp0 42))
							(= [local14 1] (- temp1 16))
							(= [local14 2] (- temp0 15))
							(= [local14 3] (- temp1 10))
							(= [local14 4] (+ temp0 8))
							(= [local14 5] (- temp1 22))
							(= [local14 6] (+ temp0 22))
							(= [local14 7] (- temp1 18))
							(= [local14 8] (+ temp0 27))
							(= [local14 9] (- temp1 9))
							(= [local14 10] (+ temp0 3))
							(= [local14 11] (+ temp1 8))
							(= [local14 12] (- temp0 56))
							(= [local14 13] (- temp1 2))
							(= [local14 14] 30583)
							(= [local14 15] 0)
							(proc816_0 @local14 2)
						)
					)
					(460
						(if (not (local4 loop:))
							(= [local14 0] (- temp0 7))
							(= [local14 1] (- temp1 13))
							(= [local14 2] (+ temp0 25))
							(= [local14 3] (- temp1 21))
							(= [local14 4] (+ temp0 124))
							(= [local14 5] (- temp1 21))
							(= [local14 6] (+ temp0 142))
							(= [local14 7] (- temp1 2))
							(= [local14 8] (+ temp0 132))
							(= [local14 9] (+ temp1 8))
							(= [local14 10] (+ temp0 35))
							(= [local14 11] (+ temp1 7))
							(= [local14 12] (+ temp0 30))
							(= [local14 13] (+ temp1 1))
							(= [local14 14] (- temp0 7))
							(= [local14 15] (+ temp1 1))
							(= [local14 16] 30583)
							(= [local14 17] 0)
							(proc816_0 @local14 2)
						else
							(= [local14 0] (- temp0 123))
							(= [local14 1] (- temp1 20))
							(= [local14 2] (- temp0 24))
							(= [local14 3] (- temp1 20))
							(= [local14 4] (+ temp0 8))
							(= [local14 5] (- temp1 14))
							(= [local14 6] (+ temp0 8))
							(= [local14 7] (+ temp1 1))
							(= [local14 8] (- temp0 30))
							(= [local14 9] (+ temp1 1))
							(= [local14 10] (- temp0 35))
							(= [local14 11] (+ temp1 7))
							(= [local14 12] (- temp0 131))
							(= [local14 13] (+ temp1 7))
							(= [local14 14] (- temp0 141))
							(= [local14 15] (- temp1 2))
							(= [local14 16] 30583)
							(= [local14 17] 0)
							(proc816_0 @local14 2)
						)
					)
					(450
						(= [local14 0] (- temp0 8))
						(= [local14 1] (- temp1 30))
						(= [local14 2] (+ temp0 25))
						(= [local14 3] (- temp1 13))
						(= [local14 4] (+ temp0 26))
						(= [local14 5] (- temp1 3))
						(= [local14 6] (+ temp0 1))
						(= [local14 7] (+ temp1 6))
						(= [local14 8] (- temp0 16))
						(= [local14 9] (- temp1 9))
						(= [local14 10] (- temp0 22))
						(= [local14 11] (- temp1 7))
						(= [local14 12] (- temp0 32))
						(= [local14 13] (- temp1 14))
						(= [local14 14] (- temp0 32))
						(= [local14 15] (- temp1 26))
						(= [local14 16] 30583)
						(= [local14 17] 0)
						(proc816_0 @local14 2)
					)
				)
			)
		)
	)
)

(instance aLooper4 of Code
	(properties)

	(method (doit param1 param2)
		(param1
			setLoop:
				(cond
					((<= 30 param2 150) 0)
					((<= 151 param2 210) 2)
					((<= 211 param2 330) 1)
					(else 3)
				)
		)
	)
)

(instance aLooper2 of Code
	(properties)

	(method (doit param1 param2)
		(param1 setLoop: (if (<= 0 param2 180) 0 else 1))
	)
)

