;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use TargFeature)
(use DeathIcon)
(use Str)
(use Array)
(use Talker)
(use PChase)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	forest 0
	enterRoomScr 1
	egoDies 2
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
	local10 = 1
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
)

(procedure (localproc_0)
	(cond
		(gNight
			(if (and (!= (gLongSong number:) 556) (!= (gLongSong number:) 557))
				(gLongSong number: 556 setLoop: 1 play: forest)
			)
		)
		((!= (gLongSong number:) 558)
			(gLongSong number: 558 setLoop: -1 play:)
		)
	)
)

(procedure (localproc_1)
	(for
		((= global475 0))
		(or (not global475) (== global475 gPrevRoomNum))
		((= global475 (local16 at: (Random 0 3))))
	)
	(return global475)
)

(class ForestView of Prop
	(properties
		sightAngle 44
		signal 20480
	)

	(method (handleEvent event)
		(= local7 x)
		(= local8 y)
		(= approachX (event x:))
		(= approachY (event y:))
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(= noun
			(switch view
				(410
					(if (< loop 2) 1 else 41)
				)
				(411
					(switch cel
						(0 2)
						(else 3)
					)
				)
				(412
					(switch cel
						(0 4)
						(else 2)
					)
				)
				(413
					(switch cel
						(0 4)
						(else 2)
					)
				)
				(414
					(if (< loop 2)
						(switch cel
							(0 1)
							(1 1)
							(2 5)
							(3 6)
							(4 2)
							(5 6)
							(else 7)
						)
					else
						40
					)
				)
				(415
					(switch cel
						(0 1)
						(1 4)
						(2 16)
						(3 9)
						(else 7)
					)
				)
				(416
					(switch cel
						(0 6)
						(3 7)
						(4 4)
						(else 1)
					)
				)
				(420
					(if (< loop 2) 1 else 40)
				)
				(421
					(if (< loop 2) 4 else 42)
				)
				(424
					(cond
						((< loop 2)
							(switch cel
								(3 5)
								(4 11)
								(else 1)
							)
						)
						((< loop 4)
							(switch cel
								(2 9)
								(4 1)
								(else 8)
							)
						)
						(else 40)
					)
				)
				(429 6)
				(430
					(switch cel
						(0 4)
						(else 1)
					)
				)
				(434
					(cond
						((< loop 2)
							(switch cel
								(0 9)
								(1 1)
								(2 8)
								(else 6)
							)
						)
						((< loop 6)
							(switch cel
								(0 5)
								(1 9)
								(else 3)
							)
						)
						(else 40)
					)
				)
				(439 6)
				(else 4)
			)
		)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb 0 0 0 50)
			)
			(4 ; Do
				(cond
					((or (== noun 8) (== noun 16))
						(gEgo get: 40 1) ; theFlowers
						(gMessager say: noun theVerb 0 0 0 50)
					)
					((or (== noun 6) (== noun 27) (== noun 1))
						(if [gEgoStats 11] ; climbing
							(gEgo trySkill: 11 300) ; climbing
							(gMessager say: 12 6 7 0 0 50) ; "You get in some climbing practice, but you really can't see any more from up the tree than from the ground. (In fact, you can scarcely see the forest for the trees.)"
						else
							(gMessager say: 12 6 8 0 0 50) ; "The trees in this part of the forest feel particularly wooden."
						)
					)
					((Message msgSIZE 50 noun theVerb 0 1)
						(gMessager say: noun theVerb 0 0 0 50)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(24 ; theFlask
				(if (== noun 40)
					(gEgo drop: 9 1 get: 10) ; theFlask, theWater
					(gMessager say: 5 24 0 0 0 50) ; "You fill your flask with cold, clear stream water."
				else
					(forest doVerb: theVerb)
				)
			)
			(else
				(forest doVerb: theVerb)
			)
		)
		(= x local7)
		(= y local8)
	)
)

(class it of TargActor
	(properties
		view 0
		signal 28673
		monStartX 0
		monStartY 0
		dead 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if dead
					(gMessager say: noun 1 6 0 0 50)
				else
					(gMessager say: noun 1 0 0 0 50)
				)
			)
			(4 ; Do
				(if dead
					(gCurRoom setScript: sSearchMonster)
				else
					(gMessager say: noun 4 0 0 0 50)
				)
			)
			(else
				(forest doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(cond
			((and (< y local14) (< z 1000))
				(+= z 1000)
			)
			((and (> y local14) (>= z 1000))
				(-= z 1000)
			)
		)
		(if (and (!= gCombatMonsterNum 830) (!= moveSpeed (+ (gEgo moveSpeed:) 1))) ; revenant
			(self setSpeed: (+ (gEgo moveSpeed:) 1))
		)
		(super doit: &rest)
	)

	(method (init)
		(super init: &rest)
		(gLongSong client: 0)
		(self setScaler: gEgo)
		(switch gCombatMonsterNum
			(820
				(self view: 820 setStep: 5 3 setLooper: Grooper noun: 43)
				(if (!= (gLongSong number:) 870)
					(gLongSong number: 870 setLoop: -1 play:)
				)
			)
			(825 ; badder
				(self
					view: 825
					setStep: 5 3
					x: (- (+ x 30) (Random 0 60))
					cel: (Random 0 5)
					z: (Random 20 40)
					noun: 31
				)
				(if (!= (gLongSong number:) 870)
					(gLongSong number: 870 setLoop: -1 play:)
				)
			)
			(830 ; revenant
				(self
					view: 830
					setStep: 3 2
					setLooper: Grooper
					setSpeed: global433
					noun: 32
				)
			)
			(835 ; wyvern
				(self view: 835 setStep: 5 3 noun: 33 z: 20)
				(if (!= (gLongSong number:) 870)
					(gLongSong number: 870 setLoop: -1 play:)
				)
			)
			(870 ; nectar
				(self view: 870 setStep: 8 4 setLooper: Grooper noun: 37)
				(if (!= (gLongSong number:) 870)
					(gLongSong number: 870 setLoop: -1 play:)
				)
			)
			(840 ; chernovy
				(self view: 840 setStep: 3 2 noun: 34 z: 10)
				(if (!= (gLongSong number:) 870)
					(gLongSong number: 870 setLoop: -1 play:)
				)
			)
		)
	)

	(method (runChasing)
		(switch gCombatMonsterNum
			(820
				(self view: 820 setStep: 5 3)
			)
			(825 ; badder
				(self view: 825 setStep: 5 3)
			)
			(830 ; revenant
				(self view: 830 setStep: 3 2)
			)
			(835 ; wyvern
				(self view: 835 setStep: 5 3)
			)
			(870 ; nectar
				(self view: 870 setStep: 8 4)
			)
		)
		(if (!= gPrevRoomNum 810) ; combat
			(= x (if (Random 0 1) 50 else 270))
		)
		(self y: 136 setCycle: Walk setSpeed: (+ (gEgo moveSpeed:) 1))
		(cond
			((and global462 (== self local11))
				(local11
					x: (- (+ x 30) (Random 0 60))
					cel: (Random 0 5)
					setScript: (sChaseHim new:)
				)
			)
			((and global463 (== self local12))
				(local11
					x: (- (+ x 30) (Random 0 60))
					cel: (Random 0 5)
					setScript: (sChaseHim new:)
				)
			)
			((and global464 (== self local13))
				(local11
					x: (- (+ x 30) (Random 0 60))
					cel: (Random 0 5)
					setScript: (sChaseHim new:)
				)
			)
			(else
				(self setScript: (sChaseHim new:))
			)
		)
		(= monStartX x)
		(= monStartY y)
	)

	(method (startChasing)
		(switch global475
			((gCurRoom north:)
				(self x: (gCurRoom topX:) y: (gCurRoom horizon:))
			)
			((gCurRoom south:)
				(self x: 160 y: 280)
			)
			((gCurRoom east:)
				(self x: 375 y: 90)
			)
			((gCurRoom west:)
				(self x: -55 y: 90)
			)
			(else
				(= global475 gPrevRoomNum)
				(self x: 160 y: 110)
			)
		)
		(cond
			((and global462 (== self local11))
				(local11
					x: (+ x (Random -30 30))
					cel: (Random 0 5)
					setCycle: Walk
					setScript: (sChaseHim new:)
				)
			)
			((and global463 (== self local12))
				(local12
					x: (+ x (Random -30 30))
					cel: (Random 0 5)
					setCycle: Walk
					setScript: (sChaseHim new:)
				)
			)
			((and global464 (== self local13))
				(local13
					x: (+ x (Random -30 30))
					cel: (Random 0 5)
					setCycle: Walk
					setScript: (sChaseHim new:)
				)
			)
			((== gCombatMonsterNum 830) ; revenant
				(self
					view: 833
					x: 160
					y: 135
					setLoop: 0
					setCel: 0
					setScript: sRevenant
				)
			)
			(else
				(self setCycle: Walk setScript: (sChaseHim new:))
			)
		)
		(= monStartX x)
		(= monStartY y)
	)

	(method (keepChasing)
		(switch gPrevRoomNum
			((gCurRoom north:)
				(self x: (gCurRoom topX:) y: (- (gCurRoom horizon:) 50))
			)
			((gCurRoom south:)
				(self x: 160 y: 290)
			)
			((gCurRoom east:)
				(self x: 385 y: 90)
			)
			((gCurRoom west:)
				(self x: -65 y: 90)
			)
			(else
				(self x: 250 y: 120)
			)
		)
		(switch gCombatMonsterNum
			(820
				(self view: 820 setStep: 3 2)
			)
			(825 ; badder
				(self view: 825 setStep: 3 2)
			)
			(830 ; revenant
				(self view: 830 setStep: 3 2)
			)
			(835 ; wyvern
				(self view: 835 setStep: 5 3)
			)
			(870 ; nectar
				(self view: 870 setStep: 8 4)
			)
			(840 ; chernovy
				(self view: 840 setStep: 3 2)
			)
		)
		(cond
			((and global462 (== self local11))
				(+= x (Random -20 20))
				(= cel (Random 0 5))
				(local11 setCycle: Walk setScript: (sChaseHim new:))
			)
			((and global463 (== self local12))
				(+= x (Random -20 20))
				(= cel (Random 0 5))
				(local12 setCycle: Walk setScript: (sChaseHim new:))
			)
			((and global464 (== self local13))
				(+= x (Random -20 20))
				(= cel (Random 0 5))
				(local13 setCycle: Walk setScript: (sChaseHim new:))
			)
			(else
				(self setCycle: Walk setScript: sChaseHim)
			)
		)
		(= monStartX x)
		(= monStartY y)
	)

	(method (getHurt param1 param2)
		(if
			(or
				(and (== self it) (not (self dead:)))
				(and (== self local11) (not (local11 dead:)))
				(and (== self local12) (not (local12 dead:)))
				(and (== self local13) (not (local13 dead:)))
			)
			(switch gCombatMonsterNum
				(820
					(monsterRoar number: 822 play:)
				)
				(825 ; badder
					(monsterRoar number: 828 play:)
				)
				(830 ; revenant
					(monsterRoar number: 837 play:)
				)
				(835 ; wyvern
					(monsterRoar number: 837 play:)
				)
				(870 ; nectar
					(monsterRoar number: 873 play:)
				)
				(840 ; chernovy
					(monsterRoar number: 843 play:)
				)
			)
			(switch self
				(local11
					(if (and (> global462 0) (< (-= global462 param2) 1))
						(= global462 0)
						(local11 setScript: monsterDies2)
					)
				)
				(local12
					(if (and (> global463 0) (< (-= global463 param2) 1))
						(= global463 0)
						(local12 setScript: monsterDies3)
					)
				)
				(local13
					(if (and (> global464 0) (< (-= global464 param2) 1))
						(= global464 0)
						(local13 setScript: monsterDies4)
					)
				)
				(it
					(if (> global156 0)
						(if
							(and
								local0
								(it script:)
								((it script:) isKindOf: sChaseHim)
							)
							((it script:) seconds: 0 cue:)
						)
						(if
							(and
								local0
								(it script:)
								(not ((it script:) isKindOf: sChaseHim))
							)
							(= local0 0)
						)
						(if (< (-= global156 param2) 1)
							(= global156 0)
							(it setScript: monsterDies)
						)
					)
				)
			)
		)
	)
)

(instance combatMonster of Prop
	(properties
		view 0
		signal 28673
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun 1 6 0 0 50)
			)
			(4 ; Do
				(gCurRoom setScript: sSearchMonster)
			)
			(else
				(forest doVerb: theVerb)
			)
		)
	)
)

(instance forest of Rgn
	(properties
		modNum 50
	)

	(method (cue)
		(if (== (gLongSong number:) 556)
			(gLongSong number: 557 setLoop: -1 play:)
		)
	)

	(method (init &tmp temp0 temp1)
		(= local15 (IntArray with: 0 6 4 2))
		(= local16 (IntArray with: 0 0 0 0))
		(= local18 (IntArray with: 0 60 63 80))
		(= local17
			(IntArray
				with:
					551
					178
					46
					30
					554
					99
					155
					45
					555
					174
					81
					23
					558
					217
					56
					14
					560
					88
					52
					80
					561
					262
					39
					29
					563
					273
					125
					20
					564
					205
					34
					44
					565
					261
					8
					92
					566
					95
					155
					45
					567
					143
					21
					53
					569
					101
					32
					75
					571
					166
					51
					23
					574
					22
					18
					170
					578
					267
					32
					80
					579
					126
					40
					71
					580
					298
					61
					44
					583
					192
					71
					46
					585
					168
					33
					78
					586
					210
					28
					50
					588
					274
					80
					40
					590
					89
					52
					82
					592
					28
					138
					42
			)
		)
		(= local14 (local18 at: (/ (- (gCurRoom picture:) 400) 10)))
		(local16 at: 0 (gCurRoom north:))
		(local16 at: 1 (gCurRoom south:))
		(local16 at: 2 (gCurRoom east:))
		(local16 at: 3 (gCurRoom west:))
		(if (OneOf gCurRoomNum 575 593 588 551)
			(= global475 -1)
		else
			(= global475 (localproc_1))
		)
		(gEgo init: setScaler: Scaler 100 40 147 61)
		(if (!= gCombatResult 1)
			(gEgo normalize:)
		)
		(super init: &rest)
		(if (!= gPrevRoomNum 810) ; combat
			(cond
				((IsFlag 35)
					(if (or (== gCurRoomNum 568) (== gPrevRoomNum 480))
						(localproc_0)
					)
				)
				((== gCombatMonsterNum 850)) ; wraith
				(gCombatMonsterNum
					(if (and (!= gCombatMonsterNum 870) (> (++ global470) (Random 3 6))) ; nectar
						(= global470 (= gCombatMonsterNum (= global366 0)))
						(= global462 (= global463 (= global464 0)))
						(localproc_0)
					else
						(if (> global462 0)
							((= local11 (it new:)) init: keepChasing:)
						)
						(if (> global463 0)
							((= local12 (it new:)) init: keepChasing:)
						)
						(if (> global464 0)
							((= local13 (it new:)) init: keepChasing:)
						)
						(if (> global156 0)
							(it init: keepChasing:)
						)
					)
				)
				(else
					(++ global366)
					(= global470 0)
					(if
						(and
							(> global366 (local15 at: global439))
							(<
								(Random 0 100)
								(*
									(if gNight 10 else 5)
									(- global366 (local15 at: global439))
								)
							)
						)
						(if
							(and
								(== gEgoGait 2) ; sneaking
								(> (Random 0 [gEgoStats 8]) 200) ; stealth
							)
							(= local9 1)
						else
							(SetFlag 380)
							(= local3 1)
							(= global344 [gEgoStats 17]) ; health
							(= temp0 (Random 0 100))
							(cond
								(gNight
									(cond
										((< temp0 30)
											(= gCombatMonsterNum 825) ; badder
											(= global156 50)
										)
										((< temp0 60)
											(= gCombatMonsterNum 830) ; revenant
											(= global156 250)
										)
										((< temp0 80)
											(= gCombatMonsterNum 840) ; chernovy
											(= global156 300)
										)
										(else
											(= gCombatMonsterNum 870) ; nectar
											(= global156 350)
										)
									)
								)
								((> gDay 10)
									(cond
										((< temp0 25)
											(= gCombatMonsterNum 820)
											(= global156 100)
										)
										((< temp0 60)
											(= gCombatMonsterNum 835) ; wyvern
											(= global156 300)
										)
										(else
											(= gCombatMonsterNum 870) ; nectar
											(= global156 350)
										)
									)
								)
								((< temp0 60)
									(= gCombatMonsterNum 820)
									(= global156 100)
								)
								((< temp0 90)
									(= gCombatMonsterNum 835) ; wyvern
									(= global156 300)
								)
								(else
									(= gCombatMonsterNum 870) ; nectar
									(= global156 350)
								)
							)
							(if (== gCombatMonsterNum 825) ; badder
								((= local11 (it new:)) init: startChasing:)
								((= local12 (it new:)) init: startChasing:)
								((= local13 (it new:)) init: startChasing:)
								(= global462 50)
								(= global463 50)
								(= global464 50)
								(= global156 50)
							)
							(it init: startChasing:)
						)
					else
						(localproc_0)
					)
				)
			)
		)
		(switch gPrevRoomNum
			((gCurRoom west:)
				(gEgo posn: -15 136 setHeading: 90)
				(= local1 (+ 7 (if gCombatMonsterNum 1 else 21)))
				(= local2 136)
				(gCurRoom setScript: enterRoomScr)
			)
			((gCurRoom east:)
				(gEgo posn: 335 136 setHeading: 270)
				(= local1 (- 313 (if gCombatMonsterNum 1 else 21)))
				(= local2 136)
				(gCurRoom setScript: enterRoomScr)
			)
			((gCurRoom north:)
				(gEgo posn: 160 (- (gCurRoom horizon:) 1) setHeading: 180)
				(= local1 160)
				(= local2 (+ (gCurRoom horizon:) (if gCombatMonsterNum 1 else 21)))
				(enterRoomScr start: 0)
				(gCurRoom setScript: enterRoomScr)
			)
			((gCurRoom south:)
				(gEgo posn: 160 240 setHeading: 0)
				(= local1 160)
				(= local2 (- 182 (if gCombatMonsterNum 1 else 21)))
				(gCurRoom setScript: enterRoomScr)
			)
			(810 ; combat
				(if (!= gCombatMonsterNum 850) ; wraith
					(gEgo x: 160 y: 130)
					(switch gCombatResult
						(1
							(gCurRoom setScript: egoDies)
						)
						(2
							(it dead: 1)
							(gCurRoom setScript: combatMonsterDies)
						)
						(3
							(= global470 0)
							(gEgo changeGait: 1) ; running
							(switch global475
								((gCurRoom east:)
									(gEgo
										setMotion:
											((ScriptID 17) new:) ; pOffMover
											335
											(gEgo y:)
									)
									(it x: 30)
								)
								((gCurRoom west:)
									(gEgo
										setMotion:
											((ScriptID 17) new:) ; pOffMover
											-15
											(gEgo y:)
									)
									(it x: 290)
								)
								((gCurRoom south:)
									(gEgo
										setMotion:
											((ScriptID 17) new:) ; pOffMover
											(gEgo x:)
											240
									)
									(it x: (if (Random 0 1) 290 else 30))
								)
								((gCurRoom north:)
									(gEgo
										setMotion:
											((ScriptID 17) new:) ; pOffMover
											(gEgo x:)
											(- (gCurRoom horizon:) 1)
									)
									(it x: (if (Random 0 1) 290 else 30))
								)
							)
							(if (== gCombatMonsterNum 825) ; badder
								(if (> global462 0)
									((= local11 (it new:)) init: runChasing:)
								)
								(if (> global463 0)
									((= local12 (it new:)) init: runChasing:)
								)
								(if (> global464 0)
									((= local13 (it new:)) init: runChasing:)
								)
							)
							(if (> global156 0)
								(it init: runChasing:)
							)
							(gGlory handsOn:)
						)
					)
				)
			)
			(else
				(gEgo posn: 160 120)
				(enterRoomScr start: 2)
				(gCurRoom setScript: enterRoomScr)
			)
		)
		(if
			(and
				(not gNight)
				(not (IsFlag 35))
				(not gCombatMonsterNum)
				(< (Random 0 100) 30)
			)
			(bird init:)
		)
		(if (== (gLongSong number:) 556)
			(gLongSong client: self)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Jump
				(gCurRoom setScript: sJumpUp)
			)
			(21 ; theRocks
				(gCurRoom setScript: (ScriptID 32) 0 21) ; project
			)
			(4 ; Do
				(if (> ((User curEvent:) y:) (gCurRoom horizon:))
					(gCurRoom setScript: getRocks)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(37 ; theThrowdagger
				(if (> ((gInventory at: 5) amount:) 1) ; theThrowdagger
					(gCurRoom setScript: (ScriptID 32) 0 37) ; project
					(++ global478)
				else
					(gMessager say: 12 6 9 0 0 50) ; "You are down to your last dagger. You'd better hold on to it."
				)
			)
			(86 ; flameDartSpell
				(if (>= [gEgoStats 19] [global367 6]) ; mana
					(gCurRoom setScript: (ScriptID 32) 0 86) ; project
				)
				(return 1)
			)
			(88 ; forceBoltSpell
				(if (>= [gEgoStats 19] [global367 8]) ; mana
					(gCurRoom setScript: (ScriptID 32) 0 88) ; project
				)
				(return 1)
			)
			(93 ; lightningBallSpell
				(if (>= [gEgoStats 19] [global367 13]) ; mana
					(gCurRoom setScript: (ScriptID 32) 0 93) ; project
				)
				(return 1)
			)
			(79 ; frostSpell
				(if (>= [gEgoStats 19] [global367 14]) ; mana
					(gCurRoom setScript: (ScriptID 32) 0 79) ; project
				)
				(return 1)
			)
			(80 ; openSpell
				(gMessager say: 0 80 0 0 0 50) ; "You can't open anything there."
				(return 1)
			)
			(82 ; triggerSpell
				(gMessager say: 0 82 0 0 0 50) ; "Your spell does nothing. It only works upon magically enchanted objects."
				(return 1)
			)
			(94 ; ritualSpell
				(gMessager say: 0 94 0 0 0 50) ; "This is not the time nor the place to perform the Ritual of Release. Didn't the Faerie Queen say something about a staff?"
				(return 1)
			)
			(83 ; dazzleSpell
				(if (>= [gEgoStats 19] [global367 3]) ; mana
					(gCurRoom setScript: (ScriptID 12) 0 83) ; castAreaScript
					(if
						(and
							(gCast contains: it)
							(it script:)
							((it script:) isKindOf: sChaseHim)
							(!= gCombatMonsterNum 830) ; revenant
							(!= gCombatMonsterNum 825) ; badder
						)
						((it script:) register: theVerb changeState: 1)
					)
				)
				(return 1)
			)
			(87 ; fetchSpell
				(if (>= [gEgoStats 19] [global367 7]) ; mana
					(gCurRoom setScript: (ScriptID 37)) ; castFetchScript
				)
				(return 1)
			)
			(89 ; levitateSpell
				((ScriptID 31 0) ; leviCode
					init:
						(gEgo x:)
						(gEgo y:)
						(/ (* (gEgo scaleY:) 80) 100)
				)
			)
			(85 ; calmSpell
				(if
					(and
						(gCast contains: it)
						((it script:) isKindOf: sChaseHim)
						(!= gCombatMonsterNum 830) ; revenant
						(!= gCombatMonsterNum 825) ; badder
					)
					((it script:) register: theVerb changeState: 1)
				else
					(gMessager say: 0 85 0 0 0 50) ; "A feeling of peace and tranquility permeates the area."
				)
			)
			(else
				(Glory pragmaFail:)
				(return 1)
			)
		)
	)

	(method (dispose)
		(local15 dispose:)
		(local16 dispose:)
		(local18 dispose:)
		(local17 dispose:)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 810) ; combat
			(if
				(and
					gCombatMonsterNum
					(not
						(or
							(> global156 0)
							(> global462 0)
							(> global463 0)
							(> global464 0)
						)
					)
				)
				(localproc_0)
				(= global470 (= gCombatMonsterNum (= global366 0)))
				(= global462 (= global463 (= global464 0)))
			)
		else
			(gLongSong client: 0)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance enterRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 3)
			)
			(1
				(if local9
					(gMessager say: 0 0 5 0 0 50) ; "Wheeeeewwwww! A gruesome, horribly-slathering monster just wandered by without seeing you, and did he look hungry!"
				)
				(gEgo setMotion: PolyPath local1 local2 self)
			)
			(2
				(if (and gCombatMonsterNum (not local3))
					(switch gPrevRoomNum
						((gCurRoom west:)
							(if (gCurRoom east:)
								(gEgo
									setMotion:
										((ScriptID 17) new:) ; pOffMover
										335
										(gEgo y:)
								)
							)
						)
						((gCurRoom east:)
							(if (gCurRoom west:)
								(gEgo
									setMotion:
										((ScriptID 17) new:) ; pOffMover
										-15
										(gEgo y:)
								)
							)
						)
						((gCurRoom north:)
							(if (gCurRoom south:)
								(gEgo
									setMotion:
										((ScriptID 17) new:) ; pOffMover
										(gEgo x:)
										240
								)
							)
						)
						((gCurRoom south:)
							(if (gCurRoom north:)
								(gEgo
									setMotion:
										((ScriptID 17) new:) ; pOffMover
										(gEgo x:)
										(- (gCurRoom horizon:) 1)
								)
							)
						)
					)
				)
				(gGlory handsOn:)
				(self start: 0 dispose:)
			)
		)
	)
)

(instance egoDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(combatMonster y: 130)
				(switch gCombatMonsterNum
					(825 ; badder
						(combatMonster
							view: 825
							loop: 3
							setCycle: Fwd
							cel: 2
							x: 195
							y: 100
							init:
						)
					)
					(840 ; chernovy
						(combatMonster
							view: 840
							loop: 1
							setCycle: Fwd
							x: 205
							y: 120
							init:
						)
					)
					(870 ; nectar
						(combatMonster view: 870 loop: 1 cel: 6 x: 210 init:)
					)
					(820
						(combatMonster view: 820 loop: 1 x: 185 init:)
					)
					(830 ; revenant
						(combatMonster
							view: 830
							loop: 1
							cel: 5
							x: 185
							y: 128
							init:
						)
					)
					(835 ; wyvern
						(combatMonster view: 835 loop: 1 x: 190 y: 130 init:)
					)
					(850 ; wraith
						(combatMonster
							view: 850
							loop: 3
							x: 180
							y: 140
							loop: 5
							init:
						)
					)
				)
				(gEgo
					view: 43
					setLoop: 2
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(switch gCombatMonsterNum
					(825 ; badder
						(EgoDead 11 50) ; "Badly bruised, beaten, and battered by the badders, you gruesomely give up the ghost."
					)
					(840 ; chernovy
						(EgoDead 12 50) ; "Chernovy Wizards are not to be taken lightly. This one's magic has "spelled" doom for you."
					)
					(870 ; nectar
						(EgoDead 13 50) ; "And all this time, you thought Necrotaurs were vegetarians. Your final battle certainly ruled out THAT theory!"
					)
					(820
						(EgoDead 14 50) ; "Aw, the cute little bunny has ripped out your throat and is hopping up and down on your dead body. Maybe you should treat gentle woodland creatures with more respect."
					)
					(830 ; revenant
						(EgoDead 15 50) ; "Apparently, the Revenant was a little lonely. Now it has company in death."
					)
					(835 ; wyvern
						(EgoDead 16 50) ; "Technically, a Wyvern isn't a true Dragon. In practice, it's nearly as deadly. In fact, in your case, it was QUITE as deadly."
					)
					(850 ; wraith
						(EgoDead 17 50) ; "The Wraith has sucked your life force right out of you. Should you return here (in another life), you will need to be properly protected and strike quickly."
					)
					(else
						(EgoDead) ; "It's all over for now. Please try again."
					)
				)
			)
		)
	)
)

(instance combatMonsterDies of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch gCombatMonsterNum
					(820
						(combatMonster view: 822 noun: 43)
						(it noun: 43)
					)
					(825 ; badder
						(combatMonster view: 827 noun: 31)
						(it noun: 31)
					)
					(830 ; revenant
						(combatMonster view: 832 noun: 32)
						(it noun: 32)
					)
					(835 ; wyvern
						(combatMonster view: 837 noun: 33)
						(it noun: 33)
					)
					(870 ; nectar
						(combatMonster view: 872 noun: 37)
						(it noun: 37)
					)
					(840 ; chernovy
						(combatMonster view: 842 noun: 34)
						(it noun: 34)
					)
				)
				(combatMonster setCel: 0 setLoop: 0 1 x: 160 y: 135 init:)
				(= local21 (gEgo cycleSpeed:))
				(gEgo
					x: 160
					y: 130
					view: 13
					setCel: 0
					setLoop: 1
					cycleSpeed: global433
				)
				(= cycles 1)
			)
			(1
				(gLongSong number: 107 setLoop: 1 play:)
				(combatMonster setCycle: End)
				(= cycles 5)
			)
			(2
				(= temp0
					(/
						(CelWide
							(combatMonster view:)
							(combatMonster loop:)
							(combatMonster cel:)
						)
						2
					)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init:
								(- (- (combatMonster x:) temp0) 6)
								(- (combatMonster y:) 5)
								(+ 6 temp0 (combatMonster x:))
								(- (combatMonster y:) 5)
								(+ 6 temp0 (combatMonster x:))
								(+ 3 (combatMonster y:))
								(- (- (combatMonster x:) temp0) 6)
								(+ 3 (combatMonster y:))
							yourself:
						)
				)
				(combatMonster
					approachX: (combatMonster x:)
					approachY: (- (combatMonster y:) 5)
					approachVerbs: 4 ; Do
				)
				(gEgo setCycle: End)
				(= ticks 240)
			)
			(3
				(switch gCombatMonsterNum
					(825 ; badder
						(gEgo solvePuzzle: 480 2 1)
					)
					(820
						(gEgo solvePuzzle: 481 2 1)
					)
					(830 ; revenant
						(gEgo solvePuzzle: 482 2 1)
					)
					(835 ; wyvern
						(gEgo solvePuzzle: 483 2 1)
					)
					(840 ; chernovy
						(gEgo solvePuzzle: 484 2 1)
					)
					(870 ; nectar
						(gEgo solvePuzzle: 486 2 1)
					)
				)
				(if
					(not
						(or
							(> global156 0)
							(> global462 0)
							(> global463 0)
							(> global464 0)
						)
					)
					(if gNight
						(gLongSong number: 557 setLoop: -1 play:)
					else
						(gLongSong number: 558 setLoop: -1 play:)
					)
					(= global470 (= gCombatMonsterNum (= global366 0)))
					(= global462 (= global463 (= global464 0)))
				)
				(gEgo setSpeed: local21 normalize: 2 addHonor: 5)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance monsterDies of Script
	(properties)

	(method (doit &tmp [temp0 3])
		(super doit: &rest)
		(if
			(and
				(not state)
				(< (gEgo distanceTo: it) 25)
				(< (client z:) 1000)
				(== (gEgo z:) 0)
			)
			(if (< global156 1)
				(= global156 1)
			)
			(gCurRoom newRoom: 810) ; combat
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(it setCycle: Walk setMotion: PolyPath 160 135 self)
			)
			(1
				(if (!= gCombatMonsterNum 825) ; badder
					(= temp0 (/ (CelWide (it view:) (it loop:) (it cel:)) 2))
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init:
									(- (- (it x:) temp0) 6)
									(- (it y:) 5)
									(+ 6 temp0 (it x:))
									(- (it y:) 5)
									(+ 6 temp0 (it x:))
									(+ 3 (it y:))
									(- (- (it x:) temp0) 6)
									(+ 3 (it y:))
								yourself:
							)
					)
				)
				(it
					view: (+ (it view:) 2)
					approachX: (it x:)
					approachY: (- (it y:) 5)
					approachVerbs: 4 ; Do
					setCel: 0
					setLoop: 0
					setCycle: End self
					z: 0
					dead: 1
				)
			)
			(2
				(switch gCombatMonsterNum
					(825 ; badder
						(gEgo solvePuzzle: 480 2 1)
					)
					(820
						(gEgo solvePuzzle: 481 2 1)
					)
					(830 ; revenant
						(gEgo solvePuzzle: 482 2 1)
					)
					(835 ; wyvern
						(gEgo solvePuzzle: 483 2 1)
					)
					(840 ; chernovy
						(gEgo solvePuzzle: 484 2 1)
					)
					(870 ; nectar
						(gEgo solvePuzzle: 486 2 1)
					)
				)
				(if
					(not
						(or
							(> global156 0)
							(> global462 0)
							(> global463 0)
							(> global464 0)
						)
					)
					(= global470 (= gCombatMonsterNum (= global366 0)))
					(= global462 (= global463 (= global464 0)))
					(localproc_0)
				)
				(gEgo addHonor: 5)
				(self dispose:)
			)
		)
	)
)

(instance monsterDies2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: PolyPath 155 125 self)
			)
			(1
				(client
					view: (+ (client view:) 2)
					approachX: (client x:)
					approachY: (client y:)
					approachVerbs: 4 ; Do
					setCel: 0
					setLoop: 0
					setCycle: End self
					z: 0
					dead: 1
				)
			)
			(2
				(if
					(not
						(or
							(> global156 0)
							(> global462 0)
							(> global463 0)
							(> global464 0)
						)
					)
					(= global470 (= gCombatMonsterNum (= global366 0)))
					(= global462 (= global463 (= global464 0)))
					(localproc_0)
				)
				(gEgo addHonor: 5)
				(self dispose:)
			)
		)
	)
)

(instance monsterDies3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: PolyPath 165 140 self)
			)
			(1
				(client
					view: (+ (client view:) 2)
					approachX: (client x:)
					approachY: (client y:)
					approachVerbs: 4 ; Do
					setCel: 0
					setLoop: 0
					setCycle: End self
					z: 0
					dead: 1
				)
			)
			(2
				(if
					(not
						(or
							(> global156 0)
							(> global462 0)
							(> global463 0)
							(> global464 0)
						)
					)
					(= global470 (= gCombatMonsterNum (= global366 0)))
					(= global462 (= global463 (= global464 0)))
					(localproc_0)
				)
				(gEgo addHonor: 5)
				(self dispose:)
			)
		)
	)
)

(instance monsterDies4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: PolyPath 158 138 self)
			)
			(1
				(client
					view: (+ (client view:) 2)
					approachX: (client x:)
					approachY: (client y:)
					approachVerbs: 4 ; Do
					setCel: 0
					setLoop: 0
					setCycle: End self
					z: 0
					dead: 1
				)
			)
			(2
				(if
					(not
						(or
							(> global156 0)
							(> global462 0)
							(> global463 0)
							(> global464 0)
						)
					)
					(= global470 (= gCombatMonsterNum (= global366 0)))
					(= global462 (= global463 (= global464 0)))
					(localproc_0)
				)
				(gEgo addHonor: 5)
				(self dispose:)
			)
		)
	)
)

(instance getRocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
					(gEgo looper: 0)
				)
				(gEgo
					setMotion: 0
					view: 4
					loop: (mod (gEgo loop:) 2)
					setCycle: End self
				)
				(= register (Narrator y:))
			)
			(1
				(Narrator y: 20)
				(if global478
					(gMessager say: 12 6 2 0 self 50) ; "You pick up your daggers."
				else
					(gMessager say: 12 6 1 0 self 50) ; "You grab a handful of rocks."
				)
			)
			(2
				(Narrator y: register)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize:)
				(if global478
					(gEgo get: 5 global478) ; theThrowdagger
					(= global478 0)
				else
					(gEgo get: 6 (Random 2 5)) ; theRocks
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bird of TargActor
	(properties
		noun 10
		modNum 50
		view 910
		signal 24577
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(screechFX play:)
			)
			((Message msgSIZE 50 noun theVerb 0 1)
				(gMessager say: noun theVerb 0 0 0 50)
			)
			(else
				(forest doVerb: theVerb)
			)
		)
	)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (<= temp0 88) ((+= temp0 4))
			(if (== gCurRoomNum (local17 at: temp0))
				(= local4 (local17 at: (+ temp0 1)))
				(= local5
					(+ (local17 at: (+ temp0 2)) (local17 at: (+ temp0 3)))
				)
				(= local6 (local17 at: (+ temp0 3)))
			)
		)
		(if local4
			(super init: &rest)
			(self x: -100 y: local5 z: local6 setStep: 8 2 setScript: sBird)
		)
	)

	(method (getHurt)
		(screechFX play:)
		(sBird register: 1)
		(if (and (>= (sBird state:) 3) (< (sBird state:) 7))
			(sBird changeState: 7)
		)
	)
)

(instance sBird of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				0
				(= seconds 1)
			)
			(1
				1
				(client y: (- (+ local5 25) (Random 0 50)) setScaler: gEgo)
				(= seconds (Random 1 12))
			)
			(2
				2
				(if (Random 0 1)
					(client x: -20 setLoop: 0)
					(= temp0 (- (/ (client scaleX:) 8)))
				else
					(client x: 340 setLoop: 1)
					(= temp0 (/ (client scaleX:) 8))
				)
				(if (Random 0 1)
					(= register 1)
					(screechFX play:)
				)
				(client
					setCycle: Fwd
					setMotion:
						MoveTo
						(+ local4 temp0)
						(+ local5 (/ (client scaleX:) 18))
						self
				)
			)
			(3
				3
				(client
					setLoop: (+ (client loop:) 2)
					setCel: 0
					setCycle: End self
				)
			)
			(4
				4
				(= seconds (Random 3 6))
			)
			(5
				5
				(client posn: local4 local5)
				(if (< (Random 0 100) 30)
					(self cue:)
				else
					(if (< (client loop:) 6)
						(client setLoop: (+ (client loop:) 4))
					)
					(client setCel: 0 setCycle: End)
					(self changeState: (-- state))
				)
			)
			(6
				6
				(= temp0 (Random 4 5))
				(client setLoop: temp0 setCycle: End self)
			)
			(7
				7
				(if (not register)
					(screechFX play:)
				else
					(= register 0)
				)
				(client
					setLoop: (if (mod (client loop:) 2) 1 else 0)
					setCycle: Fwd
					setMotion:
						MoveTo
						(if (mod (client loop:) 2) -20 else 340)
						(- (+ (client y:) (Random 0 30)) 15)
						self
				)
			)
			(8
				8
				(self dispose:)
			)
		)
	)
)

(instance sChaseHim of Script
	(properties)

	(method (init)
		(= ticks 0)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 3])
		(super doit: &rest)
		(cond
			(
				(and
					(< (gEgo distanceTo: client) 25)
					(< (client z:) 1000)
					(== (gEgo z:) 0)
				)
				(gCurRoom newRoom: 810) ; combat
			)
			((and (not (gEgo isNotHidden:)) (!= gCombatMonsterNum 825)) ; badder
				(client setScript: sLookAround)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client setCycle: Walk setMotion: PChase gEgo 20)
			)
			(1
				(client setMotion: 0)
				(switch gCombatMonsterNum
					(820
						(client setCycle: End)
					)
					(835 ; wyvern
						(client setCycle: Fwd)
					)
				)
				(switch register
					(85
						(= seconds (+ 2 (/ [gEgoStats 25] 20))) ; calmSpell
						(= register 0)
						(= local0 1)
					)
					(83
						(= seconds (+ 2 (/ [gEgoStats 23] 30))) ; dazzleSpell
						(= register 0)
					)
				)
			)
			(2
				(= local0 0)
				(self changeState: 0)
			)
		)
	)
)

(instance sRevenant of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== (gEgo z:) 0) (< (gEgo distanceTo: client) 25))
			(gCurRoom newRoom: 810) ; combat
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client
					setLoop: (+ (client loop:) 2)
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gLongSong number: 831 setLoop: -1 play:)
				(client
					view: 830
					setCycle: Walk
					setLooper: Grooper
					setScript: sChaseHim
				)
			)
		)
	)
)

(instance sLookAround of Script
	(properties)

	(method (doit &tmp [temp0 3])
		(super doit: &rest)
		(if (and (gEgo isNotHidden:) (< state 3))
			(client setScript: sChaseHim)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: 0)
				(switch gCombatMonsterNum
					(820
						(monsterRoar number: 822 play: self)
					)
					(830 ; revenant
						(monsterRoar number: 832 play: self)
					)
					(835 ; wyvern
						(monsterRoar number: 837 play: self)
						(client setCycle: Fwd)
					)
					(870 ; nectar
						(monsterRoar number: 873 play: self)
					)
					(840 ; chernovy
						(monsterRoar number: 843 play: self)
					)
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(client
					setCycle: Walk
					setMotion:
						PolyPath
						(client monStartX:)
						(client monStartY:)
						self
				)
			)
			(3
				(if (== gCombatMonsterNum 830) ; revenant
					(= local22 1)
					(client setHeading: 225 self)
				else
					(self cue:)
				)
				(localproc_0)
				(= global470 (= gCombatMonsterNum (= global366 0)))
			)
			(4
				(if local22
					(client view: 833 setLoop: 3 setCel: 12 setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(5
				(if local22
					(client setLoop: 1 setCel: 8 setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(6
				(client hide:)
				(= caller client)
				(self dispose:)
			)
		)
	)
)

(instance sJumpUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= register (gEgo loop:))
				(gEgo
					useStamina: 8
					useSkill: 15 ; acrobatics
					view: 30
					setLoop:
						(switch register
							(0 2)
							(1 3)
							(2 2)
							(3 4)
							(else
								(- register 2)
							)
						)
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo normalize: register)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSearchMonster of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gEgo view: 4 setCel: 0 setLoop: 2 1 setCycle: End self)
			)
			(1
				(if local20
					(gMessager say: 29 4 4 0 self 50) ; "You don't find anything except blood, gore, and gross body parts."
				else
					(= local20 1)
					(switch (it noun:)
						(34
							(= local19 (Str new:))
							(Message msgGET 50 (it noun:) 4 4 1 (local19 data:))
							(= temp0 (+ 3 (Random 0 5)))
							(= temp1 (+ 10 (Random 0 15)))
							(local19 format: (local19 data:) temp0 temp1)
							(+= global395 temp1)
							(gEgo get: 0 temp0) ; thePurse
							(if (& gMsgType $0002)
								(= temp2 (IntArray with: 0 0 0 0 0))
								(Message 9 (temp2 data:)) ; msgLAST_MESSAGE
							)
							(gNarrator say: local19 self temp2)
						)
						(32
							(= local19 (Str new:))
							(Message msgGET 50 (it noun:) 4 4 1 (local19 data:))
							(= temp1 (+ 15 (Random 25)))
							(local19 format: (local19 data:) temp1)
							(+= global395 temp1)
							(if (& gMsgType $0002)
								(= temp2 (IntArray with: 0 0 0 0 0))
								(Message 9 (temp2 data:)) ; msgLAST_MESSAGE
							)
							(gNarrator say: local19 self temp2)
						)
						(else
							(gMessager say: (it noun:) 4 4 0 self 50)
						)
					)
				)
			)
			(2
				(if local19
					(local19 dispose:)
					(= local19 0)
				)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 4)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance monsterRoar of Sound
	(properties)
)

(instance screechFX of Sound
	(properties
		number 976
	)
)

