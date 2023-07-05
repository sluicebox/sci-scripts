;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use TargFeature)
(use n026)
(use MChase)
(use Dialog)
(use PAvoider)
(use Talker)
(use PChase)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Timer)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm400 0
	sleepScript 1
)

(local
	local0 = 128
	local1 = 1
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
	local14
	local15
	local16
	local17
	local18
	local19 = 340
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	[local29 2] = [400 405]
	local31
	[local32 4] = [160 -45 160 355]
	[local36 4] = [35 160 300 160]
	local40
	local41
	local42
	local43
	local44
	local45
	local46
	local47
)

(procedure (localproc_0 &tmp [temp0 2] temp2 temp3)
	(= local31
		(+
			(<<
				(^
					(= local28
						(+ local24 (* (+ local25 15) 3) (* (+ local26 30) 2))
					)
					local24
				)
				$0001
			)
			(& $0001 (+ local25 local26))
		)
	)
	(= local27 (mod (+ local24 local25 local26) 2))
	(gCurRoom picture: [local29 local27])
	(switch (mod (+ local24 local25 local26) 4)
		(0
			(= local43 1)
		)
		(1
			(= local43 0)
		)
		(2
			(= local43 1)
		)
		(3
			(= local43 0)
		)
	)
	(if gCast
		(gCast eachElementDo: #dispose eachElementDo: #delete release:)
	)
	(if gAddToPics
		(gAddToPics eachElementDo: #dispose eachElementDo: #delete release:)
	)
	(if (gCurRoom obstacles:)
		((gCurRoom obstacles:) eachElementDo: #dispose release:)
	)
	(gCurRoom curPic: (gCurRoom picture:) style: (if local43 16393 else 9))
	(if local43
		(DrawPic (gCurRoom picture:) 16393 1)
	else
		(DrawPic (gCurRoom picture:) 9 1)
	)
	(= temp2 0)
	(for ((= temp3 1)) (< temp2 8) ((<<= temp3 $0001))
		(if (& local31 temp3)
			((ScriptID 403 0) ; InitAddTos
				init: temp2 local28 local43 local25 local26 local27
			)
		)
		(++ temp2)
	)
	(DisposeScript 403)
	(if local22
		(fireWood approachVerbs: 19 4 approachX: 176 approachY: 170 init:) ; theTinderbox, Do
	)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0)
	(for
		((= temp0 1))
		(Message msgGET gCurRoomNum param1 param2 param3 temp0)
		((++ temp0))
	)
	(-- temp0)
)

(procedure (localproc_2 param1 &tmp temp0 [temp1 2] temp3 temp4)
	(= temp3 -100)
	(for ((= temp0 0)) (!= temp3 30583) ((++ temp0))
		(= temp3 (WordAt param1 (* 2 temp0)))
	)
	(-- temp0)
)

(instance BookTo of Motion
	(properties)

	(method (init param1 param2 param3 param4 &tmp [temp0 3] temp3)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= x param2)
				(if (>= argc 3)
					(= y param3)
					(if (>= argc 4)
						(= caller param4)
					)
				)
			)
		)
		(= yLast (= xLast (= completed 0)))
		(= b-moveCnt (+ 1 (client moveSpeed:) gGameTime))
		(if (= temp3 (client cycler:))
			(temp3 cycleCnt: b-moveCnt)
		)
	)

	(method (doit &tmp [temp0 6])
		(if (>= (client y:) y)
			(self moveDone:)
		else
			(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
				(= b-moveCnt gGameTime)
				(client y: (+ (client y:) (client yStep:)))
			)
			(return)
		)
	)
)

(instance controls of Controls
	(properties)
)

(instance rm400 of Rm
	(properties
		noun 17
		picture 400
		vanishingY 49
	)

	(method (init &tmp [temp0 2])
		(= number gCurRoomNum)
		(= controls controls)
		(= gPerspective picAngle)
		(if (== gPrevRoomNum 550) ; combatRm
			(= local2 1)
			(= local24 global417)
			(= local25 global415)
			(= local26 global416)
			(= gPrevRoomNum global414)
			(= local27 (& global418 $0001))
			(localproc_0)
			(gEgo
				setScale: Scaler 127 30 189 70
				x: 160
				y: 146
				normalize:
				init:
				noun: 3
			)
			(switch global155
				(0
					(self setScript: egoIsDead)
				)
				(1
					(= local15 1)
					(gLongSong setLoop: -1 changeTo: 400)
					(it x: 190 y: 158 init:)
					(it setScript: monsterIsDead)
				)
				(2
					(gEgo changeGait: 1) ; running
					(= local47 1)
					(HandsOn)
					(self setScript: encounterScript)
				)
			)
		else
			(= local47 0)
			(= local1 0)
			(cond
				((== global365 3)
					(gLongSong setLoop: -1 changeTo: 407)
				)
				((== global365 11)
					(gLongSong setLoop: -1 changeTo: 408)
				)
				(else
					(gLongSong setLoop: -1 changeTo: 400)
				)
			)
			(= global156 0)
			(= global426 0)
			(= local24 (Random 64 256))
			(= local25 (= local26 (Random 5 127)))
			(switch global365
				(2
					(= local24 90)
					(if (IsFlag 99)
						(= local25 52)
					else
						(= local25 50)
					)
					(&= global418 $fff7)
					(= local26 59)
					(localproc_0)
					(gEgo
						setScale: Scaler 127 30 189 70
						x: (if (IsFlag 99) 60 else 160)
						y: 156
						normalize:
						init:
						noun: 3
					)
					(if (IsFlag 99)
						(self setScript: beeTree)
					else
						(self setScript: encounterScript)
					)
					(HandsOn)
				)
				(74
					(= local15 1)
					((ScriptID 705 0) init: 9 6 48) ; askFire
					(switch global460
						(1
							(= local22 1)
						)
						(2 0)
					)
					(= local25 (= local26 128))
					(= local24 192)
					(= local23 0)
					(localproc_0)
					(gEgo
						setScale: Scaler 127 30 189 70
						x: 240
						y: 156
						normalize:
						init:
						noun: 3
					)
					(HandsOn)
				)
				(0
					(= local25 (= local26 128))
					(= local24 192)
					(localproc_0)
					(gEgo
						x: 160
						y: 156
						setScale: Scaler 127 30 189 70
						normalize:
						init:
						noun: 3
					)
					(HandsOn)
					(= local23 0)
					(self setScript: encounterScript)
					(gGame save: 1)
				)
				(3
					(HandsOff)
					(DrawPic 400)
					(gEgo
						view: 5
						loop: 6
						cel: 0
						x: 125
						y: 140
						setScale:
						scaleX: 155
						scaleY: 155
						setMotion: 0
						init:
					)
					(self setScript: encounterScript)
				)
				(4
					(= local15 1)
					(= local21 (localproc_1 6 1 29))
					(= local25 (= local26 128))
					(= local24 192)
					(localproc_0)
					(gEgo
						x: 160
						y: 156
						setScale: Scaler 127 30 189 70
						normalize:
						init:
						noun: 3
					)
					(= local23 0)
					(self setScript: encounterScript)
					(HandsOn)
				)
				(5
					(= local15 1)
					(= local25 (= local26 128))
					(= local24 192)
					(localproc_0)
					(gEgo
						x: 160
						y: 156
						setScale: Scaler 127 30 189 70
						setAvoider: PAvoider
						normalize:
						init:
						noun: 3
					)
					(= local23 0)
					(self setScript: encounterScript)
					(HandsOn)
				)
				(else
					(localproc_0)
					(gEgo
						setScale: Scaler 127 30 189 70
						x: 160
						y: 156
						normalize:
						init:
						noun: 3
					)
					(if (== global365 999)
						(= local15 1)
						(= local23 0)
					else
						(self setScript: encounterScript)
					)
					(HandsOn)
				)
			)
		)
		(Animate (gCast elements:) 1)
	)

	(method (doit)
		(cond
			(script 0)
			(local40
				(if (and (< 8 (gEgo x:) 315) (< 80 (gEgo y:) 184))
					(= local40 0)
					(HandsOn)
				)
			)
			((< (gEgo x:) 6)
				(if (or (not local23) (== global365 2))
					(= local25 -20)
					(= local26 (gEgo y:))
					(self setScript: sExit)
				else
					(self setScript: showNewRoom self 4)
				)
			)
			((> (gEgo y:) 183)
				(if (or (not local23) (== global365 2))
					(= local25 (gEgo x:))
					(= local26 250)
					(self setScript: sExit)
				else
					(self setScript: showNewRoom self 3)
				)
			)
			((> (gEgo x:) 313)
				(if (not local23)
					(= local25 330)
					(= local26 (gEgo y:))
					(self setScript: sExit)
				else
					(self setScript: showNewRoom self 2)
				)
			)
			((< (gEgo y:) 80)
				(if (or (not local23) (== global365 2))
					(= local25 (gEgo x:))
					(= local26 (- (gEgo y:) 10))
					(self setScript: sExit)
				else
					(self setScript: showNewRoom self 1)
				)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; Rest
				(if local23
					(gMessager say: 0 0 47) ; "No rest for the weary. At least, not now."
				else
					((ScriptID 7 5) init: global455) ; egoRests
				)
			)
			(74 ; Sleep
				(if (or (and local15 (not local23)) (== global365 74))
					(= global365 74)
					(self setScript: sleepScript 0 0)
				else
					(gMessager say: 9 6 37) ; "Now would not be a good time to go to sleep."
				)
			)
			(84 ; levitateSpell
				(if (gEgo castSpell: 28)
					((ScriptID 31 0) init: (gEgo x:) (+ (gEgo y:) 1) 80) ; leviCode
				)
			)
			(82 ; fetchSpell
				(if (gEgo castSpell: 26)
					(gEgo setScript: (ScriptID 37 0)) ; castFetchScript
					(return 1)
				)
			)
			(40 ; theHoney
				(if (and (== global365 2) (== local25 52))
					(if (& global418 $0002)
						(if (& global418 $0004)
							(super doVerb: theVerb &rest)
						else
							(gMessager say: 0 40 34) ; MISSING MESSAGE
						)
					else
						(self setScript: pourHoney)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(20 ; theDaggers
				(++ global426)
				(if (== global365 2)
					(gEgo setScale:)
				)
				(self setScript: (ScriptID 32 0) self 20) ; project
			)
			(75 ; openSpell
				(if (gEgo castSpell: 19)
					(proc0_14 ((User curEvent:) x:) ((User curEvent:) y:))
					(self setScript: (ScriptID 13)) ; castOpenScript
				)
			)
			(81 ; flameDartSpell
				(if (gEgo castSpell: 25)
					(if (== global365 2)
						(gEgo setScale:)
					)
					(self setScript: (ScriptID 32 0) self 81) ; project
				)
			)
			(83 ; forceBoltSpell
				(if (gEgo castSpell: 27)
					(if (== global365 2)
						(gEgo setScale:)
					)
					(self setScript: (ScriptID 32 0) self 83) ; project
				)
			)
			(88 ; lightningBallSpell
				(if (gEgo castSpell: 32)
					(if (== global365 2)
						(gEgo setScale:)
					)
					(self setScript: (ScriptID 32 0) self 88) ; project
				)
			)
			(80 ; calmSpell
				(if (gEgo castSpell: 24)
					((Timer new:) setReal: self (/ [gEgoStats 24] 10)) ; calmSpell
					(self setScript: (ScriptID 12 0) 0 80) ; castAreaScript
					(if local13
						(local9 setScript: 0 dispose:)
						(= local9 0)
						(= local13 0)
					)
					(= local3 1)
				)
			)
			(-77 ; triggerSpell
				(if (== global365 5)
					(if local6
						(gMessager say: 0 0 2 1 0 12) ; "Nothing seems to have been triggered."
					else
						(genericProp doVerb: 4)
					)
					(return 1)
				else
					(gMessager say: 0 0 2 1 0 12) ; "Nothing seems to have been triggered."
				)
			)
			(-76 ; detectMagicSpell
				(gMessager say: 0 0 1 1 0 12) ; "You sense no magic in this area."
			)
			(-80 ; calmSpell
				(gMessager say: 0 0 4 1 0 12) ; "A feeling of peace and tranquility fills the area."
			)
			(86 ; jugglingLightsSpell
				(if (gEgo castSpell: 30)
					(if local23
						(gMessager say: 9 6 57) ; "You don't really think the monster wants to watch a fireworks display."
					else
						(self setScript: (ScriptID 62 0)) ; castJuggle
					)
				)
			)
			(78 ; dazzleSpell
				(if (gEgo castSpell: 22)
					((Timer new:) setReal: self (/ [gEgoStats 22] 10)) ; dazzleSpell
					(self setScript: (ScriptID 12 0) 0 78) ; castAreaScript
				)
			)
			(77 ; triggerSpell
				(if (gEgo castSpell: 21)
					(if (== global365 5)
						(self setScript: (ScriptID 12 0) 0 77) ; castAreaScript
					else
						(self setScript: (ScriptID 12 0) 0 77) ; castAreaScript
					)
				)
			)
			(33 ; theRocks
				(if (== global365 2)
					(gEgo setScale:)
				)
				(self setScript: (ScriptID 32 0) 0 33) ; project
			)
			(87 ; summonStaffSpell
				(if (gEgo castSpell: 31)
					(self setScript: (ScriptID 46 0)) ; staffScript
				)
			)
			(85 ; reversalSpell
				(if (gEgo castSpell: 29)
					(sFx number: 943 play:)
					(self setScript: (ScriptID 12 0) self 85) ; castAreaScript
				)
			)
			(4 ; Do
				(if (> ((User curEvent:) y:) 100)
					(self setScript: getRocks)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if (== global365 2)
			(gEgo setScale: Scaler 127 30 189 70)
		else
			(super cue:)
		)
	)

	(method (dispose)
		(if timer
			(timer dispose: delete:)
		)
		(if (== global365 2)
			(gLongSong2 stop:)
		)
		(= global461 0)
		(= global462 0)
		(super dispose:)
	)
)

(instance egoIsDead of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 43
					setLoop: (Random 0 3)
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(switch global365
					(565
						(EgoDead 41 400 707 End 152) ; "You needed an ant acid antidote. You need to anticipate these anticlimaxes by anteing up for healing pills."
					)
					(560
						(EgoDead 42 400 633 End 158) ; "That's the saurus you've ever been. The dino-mite have left you alone, but it decided to lower the boom and blew your chances of being a hero sky high."
					)
					(585
						(EgoDead 43 400 455 End 155) ; "This overgrown lizard left you crying crocodile tears. Hero business isn't all it's croc-ed up to be."
					)
				)
			)
		)
	)
)

(instance monsterIsDead of Script
	(properties)

	(method (changeState newState &tmp [temp0 23] temp23 temp24)
		(switch (= state newState)
			(0
				(HandsOff)
				(it
					approachVerbs: 4 ; Do
					approachX: (/ (+ (it nsLeft:) (it nsRight:)) 2)
					approachY: (+ (/ (+ (it nsTop:) (it nsBottom:)) 2) 5)
				)
				(= local23 0)
				(= local15 1)
				(= global156 0)
				(= local11 (if (Random 0 1) -10 else 10))
				(Face it (it x:) (+ (it y:) local11) self)
				(switch global365
					(565
						(gEgo solvePuzzle: 293 2 9)
					)
					(585
						(gEgo solvePuzzle: 292 2 9)
					)
					(560
						(gEgo solvePuzzle: 294 2 9)
					)
				)
			)
			(1
				(= temp24
					(cond
						((== global365 565) 153)
						((== global365 585) 156)
						((== global365 560) 159)
					)
				)
				(gLongSong setLoop: 1 changeTo: temp24 self)
				(gLongSong2 number: 931 setLoop: 1 play:)
				(it
					loop: (if (< local11 0) 1 else 0)
					cel: 0
					setMotion: 0
					init:
					setCycle: End
				)
			)
			(2
				(= local41 (it x:))
				(= local42 (it y:))
				(it
					approachVerbs: 4 ; Do
					approachX: (/ (+ (it nsLeft:) (it nsRight:)) 2)
					approachY: (+ (/ (+ (it nsTop:) (it nsBottom:)) 2) 5)
					stopUpd:
				)
				(= [temp0 0] (- (it nsLeft:) 3))
				(= [temp0 1] (- (/ (+ (it nsTop:) (it nsBottom:)) 2) 4))
				(= [temp0 2] (+ 3 (it nsRight:)))
				(= [temp0 3] (- (/ (+ (it nsTop:) (it nsBottom:)) 2) 4))
				(= [temp0 4] (+ 3 (it nsRight:)))
				(= [temp0 5] (+ 4 (it nsBottom:)))
				(= [temp0 6] (- (it nsLeft:) 3))
				(= [temp0 7] (+ 4 (it nsBottom:)))
				(= [temp0 8] 30583)
				(= [temp0 9] 0)
				(if (gCurRoom obstacles:)
					(if
						(= temp23
							(MergePoly
								@temp0
								((gCurRoom obstacles:) elements:)
								((gCurRoom obstacles:) size:)
							)
						)
						((gCurRoom obstacles:)
							add:
								((Polygon new:)
									points: temp23
									size: (localproc_2 temp23)
									type: PBarredAccess
									dynamic: 1
									yourself:
								)
						)
					else
						((gCurRoom obstacles:)
							add:
								((Polygon new:)
									points: @temp0
									size: 4
									type: PBarredAccess
									dynamic: 1
									yourself:
								)
						)
					)
				else
					(gCurRoom
						addObstacle:
							((Polygon new:)
								points: @temp0
								size: 4
								type: PBarredAccess
								dynamic: 1
								yourself:
							)
					)
				)
				(= local12 1)
				(HandsOn)
				(gLongSong number: 400 setLoop: -1 play:)
				(= seconds 20)
			)
			(3
				(self dispose:)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 (gEgo y:))
		(= temp0 (gEgo x:))
		(if
			(and
				(or (< temp1 70) (> temp1 182) (< temp0 10) (> temp0 310))
				(== state 2)
			)
			(self dispose:)
		)
		(super doit:)
	)
)

(instance getRocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsObject (gEgo looper:))
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
				(gMessager say: 9 6 45 0 self) ; "You pick up a few good throwing rocks."
				(gEgo get: 23 (Random 2 5)) ; theRocks
			)
			(2
				(Narrator y: register)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance doBattle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsObject (gEgo looper:))
					((gEgo looper:) dispose:)
				)
				(gEgo setMotion: 0)
				(= seconds 2)
				(gLongSong2 client: 0)
			)
			(1
				(gMessager say: 9 6 44) ; "The battle is about to begin!"
				(= cycles 2)
			)
			(2
				(if (< global156 2)
					(= global156 2)
				)
				(gCurRoom newRoom: 550) ; combatRm
			)
		)
	)
)

(instance searchMonster of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (Random 0 1)
					(Face gEgo (+ (gEgo x:) 10) (gEgo y:) self)
				else
					(Face gEgo (- (gEgo x:) 10) (gEgo y:) self)
				)
			)
			(1
				(gEgo view: 4 setCycle: End self)
			)
			(2
				(= cycles 10)
			)
			(3
				(if register
					(if (== register -1)
						(gEgo get: 22 solvePuzzle: 261 3 9) ; theHorn
						(gMessager say: 9 6 38 0 self) ; "You remove the beast's horn."
					else
						(gEgo get: 0 register) ; theRoyals
						(Message msgGET 400 9 6 39 1 @temp0) ; "You find %d royals in its pouch."
						(gMessager sayFormat: 99 @temp0 register)
						(= cycles 1)
					)
				else
					(gMessager say: 9 6 40 0 self) ; "You don't find anything useful."
				)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance beeTree of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (not (& global418 $0004))
					(if (not (& global418 $0010))
						(it init:)
					)
					(if (& global418 $0002)
						(genericProp init:)
					)
				)
				(beeHandler init:)
				(gLongSong2 number: 405 setLoop: -1 play:)
				((= local4 (Actor new:))
					view: 402
					x: 202
					y: 13
					priority: 1
					signal: 16400
					setLoop: 2
					noun: 54
					setCycle: RandCycle
					init:
				)
				((= local5 (Actor new:))
					view: 402
					x: 213
					y: 29
					priority: 11
					signal: 16400
					setLoop: 2
					noun: 54
					setCycle: RandCycle
					init:
				)
				(self dispose:)
			)
		)
	)
)

(instance sleepScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
				(= local1 0)
			)
			(1
				(gEgo setMotion: PolyPath 165 135 self)
			)
			(2
				(gEgo
					x: (- (gEgo x:) 25)
					view: 35
					loop: 1
					cel: 0
					setCycle: End self
				)
				(gLongSong setLoop: -1 fade: 127 1 30 0 changeTo: 927)
			)
			(3
				(if (= temp2 (PalVary pvGET_CURRENT_STEP))
					(if (< temp2 64)
						(PalVary pvCHANGE_TICKS 3)
					)
				else
					(PalVary pvINIT 400 3)
				)
				(= seconds 5)
			)
			(4
				(if (not local12)
					(if (and local13 (IsFlag 32))
						(= temp3 (Random 0 3))
					else
						(= temp3 0)
					)
					(if (not temp3)
						(cond
							((and (Random 0 1) (not (IsFlag 32)))
								(SetFlag 32)
								(= global365 1)
							)
							((<= 4 gTimeOfDay 6)
								(if (< (Random 1 10) 5)
									(= global365 585)
								)
							)
							((not (Random 0 2))
								(= global365 585)
							)
						)
						(if (and (!= global365 74) (!= gTimeOfDay 7))
							(= temp1 gClock)
							((ScriptID 7 4) init: 3) ; fixTime
							(= temp0
								(/ (mod (- (+ gClock 3600) temp1) 3600) 150)
							)
							(gEgo useStamina: (- (* temp0 2)))
							(gEgo takeDamage: (- (* temp0 2)))
							(gEgo useMana: (- (* temp0 2)))
						)
					)
				)
				(self cue:)
			)
			(5
				(switch global365
					(74
						(= seconds 5)
					)
					(1
						(gLongSong number: 409 setLoop: -1 play:)
						(self setScript: (ScriptID 402 0) self) ; aardvarkEntrance
					)
					(else
						(= local22 0)
						(= local13 0)
						(if (IsFlag 150)
							(= local1 1)
							(self setScript: paladinHearsMonster self)
						else
							(= seconds 2)
						)
					)
				)
			)
			(6
				(if (!= global365 1)
					(self cue:)
				)
			)
			(7
				(cond
					((== global365 1)
						((gEgo actions:) dispose:)
						(gEgo actions: 0)
						(self cue:)
					)
					((== global365 74)
						(PalVary pvREVERSE 3)
						(ClearFlag 81)
						(= seconds 4)
					)
					(local1
						(= seconds 3)
					)
					(else
						(gEgo setCycle: Beg self)
					)
				)
			)
			(8
				(if (!= global365 74)
					(cond
						((== global365 1)
							(HandsOn)
							(self dispose:)
						)
						(local1
							(= local12 1)
							(client setScript: encounterScript)
							(self dispose:)
						)
						(else
							(= local12 1)
							(gEgo x: (+ (gEgo x:) 25))
							(client setScript: encounterScript)
							(self dispose:)
						)
					)
				else
					(self cue:)
				)
			)
			(9
				((ScriptID 7 7) init: 5 40) ; egoSleeps
				(= cycles 10)
			)
			(10
				(gEgo setCycle: Beg self)
			)
			(11
				(gEgo x: (+ (gEgo x:) 25) normalize:)
				(gLongSong setLoop: -1 number: 400 play:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and global426 (not local17))
					(gMessager say: 0 20 36 0 self) ; "You retrieve your daggers before continuing on your journey."
					(gEgo get: 10 global426) ; theDaggers
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath local25 local26 self)
			)
			(2
				(if local13
					(SetFlag 140)
					(EgoDead 48 400 415 End) ; "... can stamp out savanna fires! Your unattended campfire quickly sets the grasslands aflame and really burns you up. Smoky the Elephant sez, Put out that fire, or I'll sit on you! Tusk-tusk."
					(= cycles 10)
				else
					(self cue:)
				)
			)
			(3
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance pourHoney of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 170 160 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo view: 4 loop: 0 setCycle: End self)
			)
			(3
				(|= global418 $0008)
				(genericProp init:)
				(gMessager say: 0 40 35 0 self) ; "You pour the honey onto the ground."
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize:)
				(gEgo drop: 29 1) ; theHoney
				(|= global418 $0002)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getFeather of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo view: 4 loop: 0 setCycle: End self)
			)
			(2
				(genericProp setCycle: End self noun: 8)
				(ClearFlag 99)
				(gEgo get: 30 solvePuzzle: 260 8) ; theFeather
				(|= global418 $0004)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance paladinHearsMonster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
				(= register (Narrator y:))
			)
			(1
				(Narrator y: 20)
				(gMessager say: 9 6 51) ; "Your incredible Paladin instincts warn you of approaching danger."
				(gEgo setLoop: 5 cel: 3 setCycle: End self)
			)
			(2
				(Narrator y: register)
				(gEgo x: (+ (gEgo x:) 25) normalize:)
				(= cycles 10)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance castFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((User curEvent:) x: 146 y: 160)
				(self setScript: (ScriptID 32 0) self 81) ; project
			)
			(1
				(HandsOn)
				(gEgo normalize:)
				(= local13 1)
				((= local9 (Prop new:))
					signal: 20496
					view: 400
					loop: 6
					cel: 0
					x: 144
					y: 149
					priority: 13
					setScript: loopSound
					noun: 20
					init:
					setCycle: Fwd
				)
				(self dispose:)
			)
		)
	)
)

(instance loopSound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 120)
			)
			(1
				(gLongSong2 number: 913 setLoop: -1 play: self)
			)
			(2
				(self init:)
			)
		)
	)

	(method (doit)
		(if (and (!= (gLongSong2 number:) 913) (== state 1))
			(self cue:)
		else
			(super doit:)
		)
	)

	(method (dispose)
		(gLongSong2 client: 0 stop:)
		(super dispose:)
	)
)

(instance kindleFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 4 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(if local13
					(self cue:)
				else
					(= seconds 5)
				)
			)
			(2
				(if local13
					(= local13 0)
					(local9 setScript: 0 dispose:)
					(gMessager say: 20 48 0) ; "You put out the fire."
					(= local9 0)
				else
					(= local13 1)
					((= local9 (Prop new:))
						view: 400
						loop: 6
						cel: 0
						x: 144
						y: 149
						priority: 13
						signal: 20496
						noun: 20
						setScript: loopSound
						init:
						setCycle: Fwd
					)
				)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance it of TargActor
	(properties
		view 0
		signal 28672
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
		(if local15
			(self approachVerbs: 4) ; Do
		)
		(switch global365
			(2
				(= noun 21)
				(self approachVerbs: 4) ; Do
				(cond
					(
						(and
							(IsFlag 99)
							(> (gEgo x:) 10)
							(not (& global418 $0002))
						)
						(self
							view: 402
							setLoop: 4
							cel: 0
							y: 176
							z: 150
							x: 214
							cycleSpeed: 3
							signal: (| signal $0010)
							moveSpeed: 0
							priority: 10
						)
					)
					(
						(and
							(IsFlag 99)
							(& global418 $0002)
							(not (& global418 $0004))
						)
						(self
							view: 402
							setLoop: 0
							x: 188
							y: 180
							z: 20
							cycleSpeed: 3
							moveSpeed: 2
							setCycle: RandCycle
						)
					)
					(else
						(self
							view: 402
							setLoop: 0
							z: 0
							y: 26
							x: 50
							cycleSpeed: 3
							moveSpeed: 2
							setCycle: Walk
							signal: (| signal $0010)
							setMotion: MoveTo local19 26 self
							priority: 10
						)
					)
				)
				(= approachX x)
				(= approachY y)
			)
			(560
				(if local15
					(self
						view: 560
						setScale: 160
						cycleSpeed: (+ (gEgo cycleSpeed:) 5)
						noun: 22
						setMotion: 0
					)
				else
					(self
						view: 558
						origStep: 4622
						setScale: 160
						moveSpeed: (+ (gEgo moveSpeed:) 8)
						cycleSpeed: (+ (gEgo cycleSpeed:) 10)
						setCycle: Walk
						noun: 23
						setMotion: MChase gEgo local45 self
					)
				)
			)
			(565
				(if local15
					(self
						view: 563
						setScale: 160
						cycleSpeed: (+ (gEgo cycleSpeed:) 4)
						noun: 24
						setMotion: 0
					)
				else
					(self
						origStep: 3598
						view: 561
						setScale: 160
						moveSpeed: (+ (gEgo moveSpeed:) 7)
						cycleSpeed: (+ (gEgo cycleSpeed:) 8)
						setCycle: Walk
						noun: 25
						setMotion: MChase gEgo local45 self
					)
				)
			)
			(585
				(if local15
					(self
						view: 582
						setScale: 160
						cycleSpeed: (+ (gEgo cycleSpeed:) 4)
						noun: 26
						setMotion: 0
					)
				else
					(self
						origStep: 2570
						view: 580
						setScale: 160
						moveSpeed: (+ (gEgo moveSpeed:) 5)
						cycleSpeed: (+ (gEgo cycleSpeed:) 6)
						setCycle: Walk
						noun: 27
						setMotion: MChase gEgo local45 self
					)
				)
			)
		)
	)

	(method (cue &tmp temp0)
		(cond
			((== global365 2)
				(self loop: 4 cel: 0 y: 176 z: 150)
			)
			((< (gEgo z:) local45)
				(self setMotion: 0)
				(gEgo setMotion: 0)
				(= local23 0)
				(if (< global461 global462)
					(= global417 local24)
					(= global415 local25)
					(= global416 local26)
					(= global414 gPrevRoomNum)
					(if local27
						(&= global418 $0001)
					else
						(^= global418 $0001)
					)
					(if (not local10)
						(= local10 1)
						(= local8 10000)
						(self setScript: doBattle)
					)
				else
					(= global156 0)
					(= local13 0)
					(gMessager say: 9 6 46) ; "You got away this time."
					(= local15 1)
					(= local17 1)
					(gCurRoom setScript: 0)
					(gLongSong setLoop: -1 changeTo: 400)
					(self dispose:)
					(HandsOn)
				)
			)
			((IsObject cycler)
				(cycler dispose:)
				(= cycler 0)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== global365 2)
						(return 1)
					)
					(local23
						(super doVerb: theVerb &rest)
					)
					(else
						(switch global365
							(565
								(gEgo setScript: searchMonster 0 0)
							)
							(585
								(gEgo
									setScript:
										searchMonster
										0
										(if local16
											0
										else
											(Random 2 5)
										)
								)
							)
							(560
								(gEgo
									setScript:
										searchMonster
										0
										(if local16 0 else -1)
								)
							)
							(else
								(super doVerb: theVerb &rest)
							)
						)
						(= local16 1)
					)
				)
			)
			(1 ; Look
				(if (== global365 2)
					(if (not mover)
						(if loop
							(gMessager say: 21 1 59) ; "You see a honeybird sitting comfortably in the tree. The bees do not seem to bother it."
						else
							(gMessager say: 21 1 58) ; "The bird looks like it enjoys wallowing in the honey."
						)
					else
						(super doVerb: theVerb &rest)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (delete)
		(&= signal $ffdf)
		(super delete:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if script
			(script doit:)
		)
		(if (and local3 local2 (gCurRoom timer:) (not (gEgo script:)))
			(= local3 0)
			((gCurRoom timer:) dispose:)
			(gCurRoom timer: 0)
			(gMessager say: 9 6 56) ; "Your Calm spell doesn't seem to have had much effect."
		)
		(if (not local8)
			(|= signal $4000)
			(cond
				((and mover (gCurRoom timer:) (!= global365 2))
					(self setMotion: 0)
					(= local14
						((Polygon new:)
							type: PBarredAccess
							init:
								(- nsLeft 6)
								(- nsBottom 5)
								(+ 6 nsRight)
								(- nsBottom 5)
								(+ 6 nsRight)
								(+ 3 nsBottom)
								(- nsLeft 6)
								(+ 3 nsBottom)
							yourself:
						)
					)
					(gCurRoom addObstacle: local14)
				)
				(
					(and
						(not local15)
						(not mover)
						(not (gCurRoom timer:))
						(not local40)
						(!= global365 74)
						(!= global365 2)
					)
					(if (== global365 0)
						(if (and (== (charge state:) 6) (<= y 300))
							(if (IsObject local14)
								((gCurRoom obstacles:) delete: local14)
								(local14 dispose:)
							)
							(if (!= loop 1)
								(self setMotion: BookTo 160 300 charge)
							)
						)
					else
						(if (IsObject local14)
							((gCurRoom obstacles:) delete: local14)
							(local14 dispose:)
						)
						(self setMotion: MChase gEgo local45 self)
					)
				)
			)
			(cond
				((== global365 560)
					(if (!= cel local44)
						(= local44 cel)
						(if (or (== cel 1) (== cel 5))
							(ShakeScreen 1)
							(sFx setLoop: 1 number: 404 play:)
						)
					)
				)
				((== global365 0)
					(if (!= cel local44)
						(= local44 cel)
						(if (or (== cel 0) (== cel 2))
							(ShakeScreen 1)
							(sFx setLoop: 1 number: 404 play:)
						)
					)
					(if
						(and
							(<= nsLeft (gEgo x:) nsRight)
							(< (gEgo y:) y)
							(not local46)
						)
						(EgoDead 24 0 410) ; "Now you know how it feels to be street pizza. You've been taken out by a rhino's special delivery. I never sausage a mess! There isn't mushroom to doubt -- that was a cheesy way to go!"
					)
					(if (> y (gEgo y:))
						(= local46 1)
					)
				)
				((== global365 2)
					(cond
						(
							(and
								(IsFlag 99)
								(& global418 $0002)
								(== x 188)
								(> (gEgo x:) 160)
							)
							(self
								setCycle: Walk
								setLoop: 0
								setMotion: MoveTo 340 100
							)
							(|= global418 $0010)
							(genericProp noun: 19)
						)
						((and (> (gEgo x:) 200) (== x 214))
							(self
								setCycle: Walk
								setLoop: 0
								setMotion: MoveTo 340 y
							)
						)
					)
				)
				(else 0)
			)
			(if (& signal $8000)
				(return)
			)
			(if (and (& signal $0004) (not (& signal $0002)))
				(return)
			)
			(if scaler
				(scaler doit:)
			)
			(if (> scaleX local0)
				(= local0 scaleX)
			)
			(if (< scaleX 0)
				(= scaleY (= scaleX local0))
			)
			(if (& scaleSignal $0001)
				(= temp5 (>> origStep $0008))
				(= temp6 (& origStep $00ff))
				(if (or (< y 0) (< x -40) (> y 260) (> x 340))
					(= temp3 temp5)
					(= temp4 temp6)
				else
					(if (< y (gCurRoom vanishingY:))
						(= temp3 (/ (- (gCurRoom vanishingY:) y) temp5))
						(= temp4 (/ (- (gCurRoom vanishingY:) y) temp6))
					else
						(= temp3 (/ (* temp5 scaleX) 128))
						(= temp4 (/ (* temp6 scaleY) 128))
					)
					(if temp3
						(if (or (> temp3 temp5) (< temp3 0))
							(= temp3 temp5)
						)
					else
						(= temp3 1)
					)
					(if temp4
						(if (or (> temp4 temp6) (< temp4 0))
							(= temp4 temp6)
						)
					else
						(= temp4 1)
					)
				)
				(if (or (!= temp3 xStep) (!= temp4 yStep))
					(self setStep: temp3 temp4 1)
				)
			)
			(cond
				(avoider
					(avoider doit:)
				)
				(mover
					(mover doit:)
				)
			)
			(if cycler
				(= temp1 brLeft)
				(= temp2 brRight)
				(cycler doit:)
				(if baseSetter
					(baseSetter doit: self)
				else
					(BaseSetter self)
				)
				(if
					(and
						(or (!= temp1 brLeft) (!= temp2 brRight))
						(self cantBeHere:)
					)
					(self findPosn:)
				)
			)
			(= xLast x)
			(= yLast y)
		else
			(if (== local8 1)
				(switch global365
					(565
						(sFx setLoop: 1 number: 904 play:)
					)
					(585
						(sFx setLoop: 1 number: 907 play:)
					)
					(560
						(sFx setLoop: 1 number: 903 play:)
					)
				)
			)
			(-- local8)
		)
	)

	(method (getHurt param1 param2)
		(= local2 1)
		(if (gCurRoom timer:)
			((gCurRoom timer:) dispose: delete:)
		)
		(if (not script)
			(if (!= global365 2)
				(if (not local15)
					(= local8 10)
					(switch global365
						(565
							(-= global156 param2)
						)
						(585
							(-= global156 param2)
						)
						(560
							(-= global156 param2)
						)
					)
					(if (< global156 1)
						(= local10 0)
						(self setScript: monsterIsDead)
					)
				)
			else
				(self
					moveSpeed: 0
					cycleSpeed: 0
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 340 y
				)
			)
		)
	)
)

(instance genericProp of Prop
	(properties)

	(method (init)
		(cond
			((== global365 5)
				(= view 401)
				(= loop (Random 0 3))
				(= x 148)
				(= y 137)
				(= noun 5)
				(= approachX x)
				(= approachY 147)
			)
			((== global365 4)
				(= view 400)
				(= loop 7)
				(= cel (Random 0 3))
				(= x 106)
				(= y 114)
				(= noun 6)
				(= local20 (Random 1 local21))
			)
			(else
				(= x 188)
				(= y 160)
				(= view 402)
				(= loop 3)
				(= cel (if (& global418 $0002) 0 else 1))
				(= priority 0)
				(= signal 20496)
				(= approachX 170)
				(= approachY 160)
				(self approachVerbs: 4) ; Do
				(if (& global418 $0010)
					(= noun 19)
				else
					(= noun 8)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 173 149 203 149 203 164 173 164
							yourself:
						)
				)
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== noun 5)
						(if (or (== loop 0) (== loop 1) (== loop 3))
							(if (== cel 0)
								(= local6 1)
								(self setCycle: End self)
								(gLongSong2 setLoop: 1 number: 401 play:)
								(gEgo addHonor: 10)
							else
								(gMessager say: 5 6 31) ; "The trap is too totally entrenched to take."
							)
						else
							(super doVerb: theVerb &rest)
						)
					)
					((== noun 6)
						(gMessager say: 6 4 30) ; "It wouldn't be nice to steal the sign. Besides, someone's watching you."
					)
					((and (not (& global418 $0008)) (not (& global418 $0004)))
						(self setScript: getFeather)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(1 ; Look
				(cond
					((== noun 5)
						(if (or (== loop 0) (== loop 1) (== loop 3))
							(if (== cel 0)
								(gMessager say: 5 6 32) ; "Watch out -- it's a trap!"
							else
								(gMessager say: 5 1 31) ; "The trap is no longer dangerous."
							)
						else
							(super doVerb: theVerb &rest)
						)
					)
					((== noun 6)
						(gMessager say: 6 1 29 local20)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if (== global365 5)
			(if (or (not local6) local7)
				(self doVerb: 4)
			else
				(= local7 1)
				(gMessager say: 5 6 33) ; "You spring the trap so that it will no longer be a threat."
			)
		else
			(super cue:)
		)
	)
)

(instance eggo of Actor
	(properties
		x -10
		y 160
		noun 7
		view 417
		signal 20480
	)

	(method (init)
		(= origStep (gEgo origStep:))
		(super init:)
		(self
			setCycle: Walk
			setLoop: Grooper
			cycleSpeed: (gEgo cycleSpeed:)
			moveSpeed: (gEgo moveSpeed:)
			setScale: 140
			setMotion: PFollow gEgo 40
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local23 0)
			(if (IsFlag 3)
				(ClearFlag 3)
			else
				(ClearFlag 2)
			)
			(self dispose:)
		)
		(super doVerb: theVerb &rest)
	)

	(method (doit)
		(= approachX x)
		(= approachY (+ y 5))
		(super doit:)
	)
)

(instance fireWood of View
	(properties
		x 146
		y 160
		noun 10
		view 400
		loop 8
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 129 155 163 155 163 171 129 171
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(if (not local13)
					(= noun 20)
					(gCurRoom setScript: castFire)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(19 ; theTinderbox
				(if (not local13)
					(= noun 20)
					(gCurRoom setScript: kindleFire)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(if local13
					(= noun 10)
					(gCurRoom setScript: kindleFire)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(48 ; thePeaceWater
				(if local13
					(= noun 10)
					(gEgo drop: 37 1) ; thePeaceWater
					(gEgo get: 15 1) ; theWaterskin
					(gCurRoom setScript: kindleFire)
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

(instance encounterScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks 20)
			)
			(1
				(gEgo normalize:)
				(switch global365
					(565
						(= local45 35)
						(= global462 600)
						(if (not global156)
							(= global156 150)
						)
					)
					(585
						(= local45 30)
						(= global462 700)
						(if (not global156)
							(= global156 200)
						)
					)
					(560
						(= local45 40)
						(if (not global156)
							(= global156 320)
						)
						(= global462 1000)
					)
					(0
						(= global462 1000)
						(= local23 0)
						(= global156 1000)
						(client setScript: charge)
						(self dispose:)
					)
					(3
						(client setScript: laurelAndHardy)
						(self dispose:)
					)
					(4
						(= local23 0)
						(genericProp init:)
						(HandsOn)
						(self dispose:)
					)
					(5
						(genericProp approachVerbs: 4 init:) ; Do
						(= local23 0)
						(HandsOn)
						(self dispose:)
					)
					(11
						(eggo init: approachVerbs: 4) ; Do
						(= local23 1)
						(HandsOn)
						(self dispose:)
					)
				)
				(HandsOn)
				(self cue:)
			)
			(2
				(= local15 0)
				(cond
					((== global365 2)
						(it init:)
					)
					(local47
						(it x: 270 y: 140 init:)
						(gEgo setMotion: PolyPath -10 (gEgo y:))
					)
					(else
						(if
							(and
								(!= global365 11)
								(IsFlag 150)
								(not local1)
								(not local47)
							)
							(= local1 1)
							(gMessager say: 9 6 51) ; "Your incredible Paladin instincts warn you of approaching danger."
						)
						(= temp0 (Random 0 3))
						(it x: [local32 temp0] y: [local36 temp0] init:)
					)
				)
				(if local47
					(if (== global102 0)
						(it signal: (& (it signal:) $bfff))
						(= local8 200)
					)
				else
					(= local8 50)
				)
				(= local23 1)
				(if (and (!= (gLongSong number:) 700) (!= global365 2))
					(gLongSong setLoop: -1 number: 700 play:)
				)
				(self dispose:)
			)
		)
	)
)

(instance showNewRoom of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(HandsOff)
				(self cue:)
			)
			(1
				(switch register
					(4
						(= temp0 -15)
						(= temp1 (gEgo y:))
						(gEgo setMotion: PolyPath temp0 temp1 self)
					)
					(3
						(= temp1 220)
						(= temp0 (gEgo x:))
						(gEgo setMotion: PolyPath temp0 temp1 self)
					)
					(2
						(= temp0 330)
						(= temp1 (gEgo y:))
						(gEgo setMotion: PolyPath temp0 temp1 self)
					)
					(1
						(self cue:)
					)
				)
			)
			(2
				(= local40 1)
				(it setMotion: 0)
				(gEgo setMotion: 0)
				(= cycles 2)
			)
			(3
				(switch register
					(4
						(-- local25)
						(= temp0 0)
						(if (== global365 11)
							(eggo x: 330)
						else
							(it x: (+ 325 (- (it x:) (gEgo x:))))
						)
						(gEgo x: 325)
						(= temp1 (gEgo y:))
					)
					(3
						(++ local26)
						(= temp1 190)
						(if (== global365 11)
							(eggo y: 80)
						else
							(it y: (- (it y:) (gEgo y:)))
						)
						(gEgo y: 80)
						(= temp0 (gEgo x:))
					)
					(2
						(++ local25)
						(= temp0 320)
						(= temp1 (gEgo y:))
						(cond
							((== global365 11)
								(eggo x: -10)
							)
							((== global365 2)
								(if (== local25 52)
									(= local19 214)
									(SetFlag 99)
									(ClearFlag 83)
								)
							)
							(else
								(it x: (+ -5 (- (it x:) (gEgo x:))))
							)
						)
						(gEgo x: -5)
					)
					(1
						(-- local26)
						(= temp0 (gEgo x:))
						(= temp1 79)
						(if (== global365 11)
							(eggo y: 225)
						else
							(it y: (+ 265 (- (it y:) (gEgo y:))))
						)
						(gEgo y: 195)
					)
				)
				(localproc_0)
				(gEgo
					normalize:
					init:
					setScale: Scaler 127 30 189 70
					setMotion: PolyPath temp0 temp1
				)
				(if (== global365 11)
					(eggo init:)
				else
					(it init:)
					(if (and (== global365 2) (== local25 52))
						(= local23 0)
						(gLongSong2 number: 405 setLoop: -1 play:)
						(beeHandler init:)
						((= local4 (Actor new:))
							view: 402
							x: 202
							y: 13
							priority: 1
							signal: 16400
							setLoop: 2
							noun: 54
							setCycle: Fwd
							init:
						)
						((= local5 (Actor new:))
							view: 402
							x: 213
							y: 29
							priority: 11
							signal: 16400
							setLoop: 2
							noun: 54
							setCycle: Fwd
							init:
						)
					)
				)
				(= cycles 15)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance charge of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(it view: 497 init: loop: 1 setMotion: 0 cel: 0 x: 150 y: 59)
				(gTheIconBar curIcon: (gTheIconBar at: 1))
				(if (not (HaveMouse))
					(gGame setCursor: gTheCursor 1 310 155)
				else
					(gGame setCursor: gTheCursor 1)
				)
				(Face gEgo it self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 9 6 24 0 self) ; "Isn't that cute! You see an example of the native fauna nattily gnawing on some native flora."
			)
			(3
				(it setCycle: End self)
			)
			(4
				(gMessager say: 9 6 49 0 self) ; "Why, look. Now the rhinoceros sees you, too!"
			)
			(5
				(= seconds 2)
			)
			(6
				(it
					setLoop: 0
					origStep: 3341
					maxScale: 3200
					setScale: Scaler 150 7 180 50
					moveSpeed: 6
					cycleSpeed: 5
					setCycle: Walk
					setMotion: BookTo 160 300 self
				)
			)
			(7
				(gMessager say: 9 6 50 0 self) ; "Now isn't that special? The rhinoceros seems to have left some lovely native footprints (about a foot deep, that is) in the rock-hard native soil."
			)
			(8
				(= local23 0)
				(it dispose:)
				(self dispose:)
			)
		)
	)
)

(instance laurelAndHardy of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 401 0) self) ; ComeOnDown
			)
			(1
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance killerBees of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(= cycles 20)
			)
			(1
				(gLongSong2 number: 406 setLoop: -1 play:)
				(gMessager say: 54 6 55 0 self) ; "You bothered the bees."
			)
			(2
				(local4
					cycleSpeed: 0
					moveSpeed: 0
					priority: 14
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(- (gEgo y:) 25)
						self
				)
				(local5
					cycleSpeed: 0
					moveSpeed: 0
					priority: 14
					setMotion: MoveTo (- (gEgo x:) 7) (- (gEgo y:) 40)
				)
			)
			(3
				(gEgo view: 11 loop: 1 cycleSpeed: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(4
				(gLongSong2 stop:)
				(EgoDead 54) ; "I can't bee-lieve you bugged the bees. Bee-fore you bother the bumblebees, remember that they can bother you back."
			)
		)
	)
)

(instance beeHandler of TargFeature
	(properties
		x 210
		y 60
		noun 54
		nsTop 10
		nsLeft 193
		nsBottom 52
		nsRight 238
	)

	(method (init)
		(gTheDoits add: self)
		(super init:)
	)

	(method (getHurt)
		(local4 setScript: killerBees)
	)

	(method (doit)
		(if (and (!= (gLongSong2 number:) 405) (== (gLongSong2 prevSignal:) -1))
			(gLongSong2 number: 405 setLoop: -1 play:)
		)
		(super doit:)
	)
)

(instance sFx of Sound
	(properties)
)

