;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use n065)
(use TargActor)
(use n095)
(use Interface)
(use rasGuard)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm400 0
	fightScript 1
	eunuch 2
	holler 3
	rGuard1 4
	rGuard2 5
	leftDr 6
	rightDr 7
)

(local
	whichPost
	I
	J
	[str 100]
	[ropey 39]
	[guardy 6]
	[guarder 5]
	roperY = 27
	triedToLeave
	backToRoom
	isInRoom
	g1Down
	g2Down
	guardSees
	guardCalm
	guardDazzd
	guardRushTimer
	djinniTimer
	listenCount
	startX = 147
	endX = 122
	[guardX 12] = [311 317 322 330 338 342 348 353 356 361 365 373]
	[guardY 12] = [51 52 50 49 51 52 50 49 51 52 50 49]
	[gateMsg 6] = [{Guards to the gate!!} {The gate is being attacked!} {Somebody HELP!!!!} {Defend the gate!!} {All guards, to the gate!!!} {Guards!  Guards!  Guards!  Guards!}]
	gateCount
	[guardReply 3] = [{Interference with a guard in his duties is a punishable offense.} {Loitering is forbidden.  Move on.} {Questioning a guard constitutes interference.  Leave before it becomes an offense. }]
	[pts1 8] = [67 137 76 119 124 119 119 139]
	[pts2 8] = [198 140 196 117 246 118 257 137]
	[pts3 8] = [61 136 18 135 35 117 67 119]
	[pts4 8] = [262 137 251 119 287 118 303 139]
	replyCount
	rasGuy
	egoGuy
	fighting
	numOfGuards
	dazTimer
	hollerCount
	objType
	caughtOnce
	oneChance
)

(procedure (eunuchPrint)
	(HighPrint &rest 80 {Eunuch:} 35 eWin)
)

(procedure (makeRope)
	(for ((= I 0)) (< I 38) ((++ I))
		(= [ropey I] (aRopette new:))
		([ropey I] y: roperY x: ((ScriptID 61 0) x:) init:) ; rope
		(+= roperY 3)
	)
)

(procedure (houseGuards)
	(for ((= J 0)) (< J numOfGuards) ((++ J))
		(= [guarder J] (aGuard new:))
		([guarder J]
			x: [guardX J]
			y: [guardY J]
			loop: 1
			priority: 6
			init:
			setCycle: Walk
			setMotion: MoveTo 70 [guardY J]
		)
	)
)

(procedure (showGuards)
	(for ((= I 0)) (< I 5) ((++ I))
		(= [guardy I] (bGuard new:))
		([guardy I]
			x: (- startX 10)
			y: 112
			loop: 2
			priority: 8
			signal: -32735
		)
		(+= startX 13)
		(InitAddToPics [guardy I])
	)
)

(procedure (disposeGuards)
	(for ((= I 0)) (< I 12) ((++ I))
		(if (gCast contains: [guardy I])
			([guardy I] dispose:)
		)
		(if (gCast contains: [guarder I])
			([guarder I] dispose:)
		)
	)
)

(procedure (manyGuards)
	(for ((= I 0)) (< I 5) ((++ I))
		(= [guardy I] (aGuard new:))
		([guardy I]
			x: startX
			y: 100
			loop: 2
			priority: 8
			init:
			setCycle: Walk
			setMotion: MoveTo endX 140
		)
		(+= startX 7)
		(+= endX 19)
	)
)

(procedure (talkGuards)
	(if (== replyCount 3)
		(EgoDead
			1
			{The guards, tiring of your chatter, grab you and call other guards to their assistance.  You are dragged into prison and remain there for a long, long, long time. }
			#title
			{Curiosity Killed the Hero}
		)
	else
		(HighPrint
			(Format @str 400 0 [guardReply replyCount]) ; "%s"
			80
			{Guard:}
			103
			25
			6
		)
		(++ replyCount)
	)
)

(instance eWin of SysWindow
	(properties
		back 13
	)
)

(instance aRopette of View
	(properties
		view 8
		loop 4
		priority 11
		signal 24592
	)
)

(instance disposeRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if [ropey I]
					([ropey I] dispose:)
					(= [ropey I] 0)
				)
				(self cue:)
			)
			(1
				(-- I)
				(= cycles 1)
			)
			(2
				(if (> I -1)
					(self changeState: 0)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance aGuard of Actor
	(properties
		view 382
		signal 24592
		illegalBits 0
	)
)

(instance bGuard of PicView
	(properties
		view 382
		signal 24592
	)
)

(instance rm400 of Rm
	(properties
		picture 240
	)

	(method (init)
		(LoadMany rsSCRIPT 401 381)
		(LoadMany rsVIEW 0 6 4 533 31 532 47 83 382 381 383 410 460)
		(if (IsFlag 96) ; fTeleFromIblis
			(= gDay 30)
			(FixTime 21 0)
		)
		(if gNight
			(= global61 3)
		else
			(= global61 2)
		)
		((ScriptID 32 1) x: 170 y: 114) ; spellObj
		(= global76 1)
		(super init:)
		(poly2 points: @pts2 size: 4)
		(poly1 points: @pts1 size: 4)
		(poly4 points: @pts4 size: 4)
		(poly3 points: @pts3 size: 4)
		(gCurRoom addObstacle: poly1 poly2 poly3 poly4)
		(if (<= gMachineSpeed 40)
			(= numOfGuards 2)
		else
			(= numOfGuards 8)
		)
		(if (and (== gDay 30) gNight)
			(= gSpellChecker gAllChecker)
		)
		(= gLevScript levitateMe)
		(= gRopeScript ropeMe)
		(= gLevHighY 40)
		(= gRopeHighY 40)
		(leftDr init: stopUpd:)
		(rightDr init: stopUpd:)
		(rGuard1 view: 383 loop: 5 cel: 0 posn: 124 111 init:)
		(rGuard2 init:)
		(cond
			((and (== gDay 30) gNight)
				(eunuch init: setScript: (ScriptID 401 6)) ; eunuchPace
				(if (IsFlag 138) ; fVisitedHaremGirl
					(scarf init: setCycle: Fwd)
				)
			)
			((<= 0 gTimeODay 4)
				(rGuard3 init:)
				(rGuard4 init: setScript: guardPace)
			)
		)
		(NormalEgo)
		(gEgo posn: (- 320 (gEgo x:)) 224 loop: 3 init:)
		(self setScript: comeIn)
	)

	(method (doit)
		(if (== hollerCount 12)
			(= guardRushTimer 3)
		)
		(if
			(and
				(gCast contains: rGuard1)
				(not guardDazzd)
				(== (leftDr cel:) 3)
			)
			(= guardDazzd 1)
			(HighPrint 400 1 80 {Gate Guard:} 25 3) ; "Hey, what are the gates doing open?"
			(= guardRushTimer 4)
		)
		(cond
			((not dazTimer))
			((-- dazTimer))
			(else
				(if (gCast contains: rGuard1)
					(rGuard1 loop: 5 setScript: 0)
				)
				(if (gCast contains: rGuard2)
					(rGuard2 loop: 6)
				)
				(= guardDazzd 0)
				(if (or g1Down g2Down)
					(HighPrint 400 2 80 {Blind guard:} 103 25 3) ; "I can see .......!"
				else
					(HighPrint 400 2 80 {Both guards in unison:} 103 25 3) ; "I can see .......!"
				)
			)
		)
		(cond
			((not guardRushTimer))
			((-- guardRushTimer))
			(else
				(HighPrint 400 3 80 {Guard:}) ; "Guards! To the gates!!"
				(gEgo setScript: guardsRushIn)
			)
		)
		(if djinniTimer
			(-- djinniTimer)
		)
		(cond
			(
				(and
					(gEgo inRect: 131 109 188 118)
					(not (gEgo script:))
					(== (leftDr cel:) 3)
					(or
						guardDazzd
						(and
							(not (gCast contains: rGuard1))
							(not (gCast contains: rGuard2))
						)
					)
				)
				(gEgo setMotion: MoveTo (gEgo x:) (- (gEgo y:) 10))
				(gCurRoom newRoom: 470)
			)
			(
				(and
					(& (gEgo onControl: 1) $0004)
					(not guardSees)
					(not guardDazzd)
					gNight
				)
				(= guardSees 1)
				(cond
					((and (== gDay 27) (not oneChance))
						(= oneChance 1)
						(self setScript: (ScriptID 401 9)) ; backToInn
					)
					((or (and g1Down g2Down) fighting)
						(return)
					)
					(guardCalm
						(HighPrint 400 4 80 {Guard:}) ; "Hey, what are you doing there? Don't you know it's against the law?"
						(djinniPrint 400 5) ; "Well, since they know we're here, what do you do now, Master?"
					)
					(else
						(= guardRushTimer 50)
						(= djinniTimer 50)
						(gEgo setMotion: 0)
						(HighPrint 400 6 80 {Guard:}) ; "Halt, In the name of the Law!"
					)
				)
			)
			(
				(and
					(or
						(and (== (eunuch loop:) 0) (< (eunuch x:) (gEgo x:)))
						(and (== (eunuch loop:) 1) (> (eunuch x:) (gEgo x:)))
						(< (gEgo distanceTo: eunuch) 45)
					)
					(gCast contains: eunuch)
					(< (gEgo y:) 60)
					(> (eunuch x:) 19)
					(< (eunuch x:) 314)
					(not caughtOnce)
				)
				(= caughtOnce 1)
				(eunuchPrint 400 7) ; "You there! Halt!!"
				(eunuch setScript: (ScriptID 401 4)) ; eunuchBust
			)
			((and (> (gEgo x:) 320) (< (gEgo y:) 90))
				(gEgo setScript: guardHouse)
			)
			((and (< (gEgo x:) 0) (< (gEgo y:) 90))
				(if (gEgo has: 16) ; Rope
					(gCurRoom newRoom: 480)
				else
					(gCurRoom newRoom: 470)
				)
			)
			(
				(and
					isInRoom
					(> (gEgo y:) 188)
					(IsFlag 96) ; fTeleFromIblis
					(not script)
					triedToLeave
					(== backToRoom 0)
				)
				(= backToRoom 1)
				(= guardRushTimer 0)
				(gEgo setScript: toPalace)
			)
			(
				(and
					isInRoom
					(> (gEgo y:) 188)
					(IsFlag 96) ; fTeleFromIblis
					(not script)
					(not triedToLeave)
				)
				(= guardRushTimer 0)
				(gEgo setMotion: 0 posn: (gEgo x:) (- (gEgo y:) 5))
				(= triedToLeave 1)
				(djinniPrint 400 8) ; "Hey, where do you think you are going, Master? Iblis is over in the Palace. We haven't got much time. He's getting more powerful."
			)
			((and (== isInRoom 1) (> (gEgo y:) 189))
				(= gRoomExitDir 2)
				(gCurRoom newRoom: 460)
			)
		)
		(if (and djinniTimer (gEgo script:))
			(= djinniTimer 0)
			(= guardRushTimer 0)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/courtyard')
				)
				(HighPrint 400 9) ; "This Plaza faces the front of the Emir's Palace. It is well guarded."
			)
			(
				(or
					(Said 'lockpick[/lock]')
					(Said 'use/(lockpick[<lock]),lockpick')
					(Said 'unlock')
				)
				(cond
					((not (CanPickLocks 1)))
					(
						(or
							(gCast contains: rGuard1)
							(gCast contains: rGuard2)
						)
						(HighPrint 400 10) ; "You need to do something about the guards first."
					)
					(else
						(gEgo setScript: (ScriptID 401 7)) ; doorPicker
					)
				)
			)
			((Said 'force,break,hit/gate,door')
				(if (or (gCast contains: rGuard1) (gCast contains: rGuard2))
					(HighPrint 400 10) ; "You need to do something about the guards first."
				else
					(gEgo setScript: (ScriptID 401 8)) ; doorBuster
				)
			)
			((Said 'cast/levitate,fly,(spell<levitate,fly)')
				(cond
					((and (< (gEgo y:) 130) (> (gEgo y:) 100))
						(HighPrint 400 11) ; "Move out in front of the balcony first."
					)
					((and (== gDay 30) gNight (< (gEgo y:) 90))
						(djinniPrint 400 12) ; "Master, we must hurry onward."
					)
					(
						(and
							guardSees
							guardCalm
							(> (eunuch x:) 19)
							(< (eunuch x:) 314)
							(gCast contains: rGuard1)
						)
						(eunuch setScript: badLevitate)
					)
					(
						(not
							(or
								(gEgo inRect: 22 133 47 150)
								(gEgo inRect: 81 133 109 150)
								(gEgo inRect: 211 133 241 150)
								(gEgo inRect: 270 133 302 150)
							)
						)
						(HighPrint 400 13) ; "Move up to a pillar first."
					)
					((TrySpell 28)
						(gEgo setScript: (ScriptID 62 0)) ; levitate
					)
				)
			)
			((or (Said 'throw/dagger') (Said 'cast'))
				(if (and (== gDay 30) gNight (< (gEgo y:) 90))
					(djinniPrint 400 14) ; "No, Master. You don't need to do that now, let's go."
					(event claimed: 1)
				else
					(event claimed: 0)
				)
			)
			((and (== gDay 30) gNight (Said 'hop[<down]'))
				(if (> (gEgo y:) 90)
					(djinniPrint 400 15) ; "Master, you don't need to jump down here."
				else
					(djinniPrint 400 16) ; "Master, don't go back down there. We must hurry."
				)
			)
			((Said 'cast,drop,use,throw,climb,climb/rope[<magic]')
				(if (not (and (== gDay 30) gNight))
					(HighPrint 400 17) ; "Now would not be a good time for that."
				else
					(gEgo setScript: (ScriptID 61 2)) ; ropeClimb
				)
			)
			((Said 'attack[/guard]')
				(cond
					((< (gEgo y:) 90)
						(djinniPrint 400 18) ; "No Master! You don't have to fight them. We must stop Iblis!"
					)
					(
						(and
							(not (gCast contains: rGuard1))
							(not (gCast contains: rGuard2))
						)
						(HighPrint 400 19) ; "There are no guards to fight."
					)
					((<= 0 gTimeODay 4)
						(HighPrint 400 20) ; "There are too many guards for that."
					)
					((and (== gDay 30) gNight)
						(= guardRushTimer 0)
						(= fighting 1)
						(cond
							(g1Down
								(rGuard2 setScript: letsFight)
							)
							(g2Down
								(rGuard1 setScript: letsFight)
							)
							(else
								(rGuard1 setScript: 0)
								(rGuard2 setScript: 0)
								(self setScript: fightScript)
							)
						)
						(if (gCast contains: eunuch)
							(eunuch setScript: (ScriptID 401 5)) ; centerMe
						)
					)
					(else
						(HighPrint 400 21) ; "Don't fight them tonight!"
					)
				)
			)
			((Said 'climb,climb')
				(HighPrint 400 22) ; "The pillars are too slick to climb."
			)
			((and (Said 'look,look<at/djinn') (IsFlag 96)) ; fTeleFromIblis
				(HighPrint 400 23) ; "If you could see him, you would."
			)
			((Said 'open,open/gate,door')
				(cond
					((> (gEgo distanceTo: leftDr) 40)
						(HighPrint 400 24) ; "You're not near the gate."
					)
					((not (and g1Down g2Down))
						(HighPrint 400 25) ; "You will have to deal with the guards first."
					)
					(else
						(HighPrint 400 26) ; "You find the gate has been secured on the other side."
					)
				)
			)
			((Said 'ask/djinn')
				(cond
					((IsFlag 96) ; fTeleFromIblis
						(djinniPrint 400 27) ; "Silly Master. We don't have time for that now. We need to hurry."
					)
					((and (== gDay 30) gNight)
						(djinniPrint 400 28) ; "Master, just hurry and get inside the palace. We don't have much time."
					)
				)
			)
			((Said 'ask[/guard]')
				(if (<= 0 gTimeODay 4)
					(talkGuards)
				else
					(= guardRushTimer 4)
				)
			)
			((Said 'look,look<up')
				(if gNight
					(HighPrint 400 29) ; "The Raseirian sky is ablaze with stars."
				else
					(HighPrint 400 30) ; "The sky is so bright that it hurts your eyes."
				)
			)
			((Said 'look,look<down')
				(HighPrint 400 31) ; "The plaza in front of the palace gates is kept much cleaner than all the others."
			)
		)
	)

	(method (notify which)
		(switch which
			(59
				(djinniPrint 400 32) ; "No Master, we must get through."
				(return 0)
			)
			(60
				(HighPrint 400 33 80 {Too Tired to Win}) ; "As you fall in defeat, you hear the Djinni cry "No!  Iblis is loose!" You dimly hear noise in the background as Iblis rises above the Palace."
				(gCurRoom newRoom: 790)
				(return 1)
			)
			(61
				(HighPrint 400 34 80 {Alas, Poor Hero}) ; "As you fall in defeat, you hear the Djinni cry, "No! Iblis is loose!" You dimly hear noise in the background as Iblis rises above the Palace."
				(gCurRoom newRoom: 790)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)

	(method (dispose)
		(= gLevScript (= gRopeScript 0))
		(disposeGuards)
		(DisposeScript 401)
		(ClearFlag 96) ; fTeleFromIblis
		(= global61 0)
		(super dispose:)
	)
)

(instance eunuch of TargActor
	(properties
		x 15
		y 58
		noun '/(man[<fat]),eunuch'
		description {the eunuch walking the parapet}
		lookStr {A eunuch patrols the parapet.}
		view 532
		priority 2
		cycleSpeed 1
		illegalBits 0
		xStep 2
	)

	(method (hurtMe)
		(self setScript: (ScriptID 401 2)) ; eunuchDie
		(return 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(= guardRushTimer 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rGuard1 of TargActor
	(properties
		noun '/guard[<left]'
		description {the guard at the gates}
		lookStr {The guards stand motionless at the gates.}
	)

	(method (cue)
		(= g1Down 1)
		(super cue:)
	)

	(method (hurtMe amount whatHurt)
		(= objType (whatHurt type:))
		(if (not g1Down)
			(if dazTimer
				(HighPrint 400 35) ; "The other guard can suddenly see again."
			)
			(if
				(and
					(gCast contains: eunuch)
					(> (eunuch x:) 19)
					(< (eunuch x:) 314)
				)
				(eunuch setScript: holler)
			)
			(if (== script guardAttack)
				(DontMove 0)
			)
			(self setScript: guardZapped self)
		)
		(if (not g2Down)
			(if (== objType 5)
				(= guardSees 1)
				(rGuard2 setScript: letsFight)
			else
				(rGuard2 setScript: guardAttack)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (dazzleMe)
		(cond
			(dazTimer
				(return 0)
			)
			((not g1Down)
				(self setScript: (ScriptID 401 3)) ; theDaz
				(= dazTimer 400)
				(= guardDazzd 1)
				(return 1)
				(if
					(and
						(gCast contains: eunuch)
						(> (eunuch x:) 19)
						(< (eunuch x:) 314)
					)
					(eunuch setScript: holler)
				)
			)
			(else
				(return 0)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(if (<= 0 gTimeODay 4)
				(talkGuards)
			else
				(= guardRushTimer 4)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (calmMe)
		(HighPrint 400 36) ; "The guards look more relaxed."
		(= guardCalm 1)
		(return 1)
	)
)

(instance rGuard2 of TargActor
	(properties
		x 205
		y 111
		noun '/guard<right'
		description {the guard at the gates}
		lookStr {The guards stand motionless at the gates.}
		view 383
		loop 6
		illegalBits 0
	)

	(method (cue)
		(= g2Down 1)
		(super cue:)
	)

	(method (hurtMe amount whatHurt)
		(= objType (whatHurt type:))
		(if (not g2Down)
			(if dazTimer
				(HighPrint 400 35) ; "The other guard can suddenly see again."
			)
			(if
				(and
					(gCast contains: eunuch)
					(> (eunuch x:) 19)
					(< (eunuch x:) 314)
				)
				(eunuch setScript: holler)
			)
			(if (== script guardAttack)
				(DontMove 0)
			)
			(self setScript: guardZapped self)
		)
		(if (not g1Down)
			(if (== objType 5)
				(= guardSees 1)
				(rGuard1 setScript: letsFight)
			else
				(rGuard1 setScript: guardAttack)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(if (<= 0 gTimeODay 4)
				(talkGuards)
			else
				(= guardRushTimer 4)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance leftDr of TargActor
	(properties
		x 133
		y 109
		noun '/door'
		description {the gate}
		lookStr {The doors are massive.}
		view 460
		loop 1
		priority 7
		signal 16
	)

	(method (init)
		(if gNight
			(= palette 4)
		else
			(= palette 3)
		)
		(super init:)
	)

	(method (hurtMe)
		(if (gCast contains: rGuard1)
			(if (or guardDazzd guardCalm)
				(return 0)
			else
				(= guardRushTimer 5)
			)
		else
			(return 0)
		)
	)

	(method (openMe)
		(if
			(or
				guardDazzd
				(and
					(not (gCast contains: rGuard1))
					(not (gCast contains: rGuard2))
				)
			)
			(leftDr setCycle: End)
			(rightDr setCycle: End)
			(return 1)
		else
			(HighPrint 400 37) ; "That wouldn't be useful while the guards are active."
		)
	)

	(method (detectMe)
		(Print 400 38) ; "There is a strong sense of Magic beyond the Palace walls."
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cond
					((> (gEgo distanceTo: self) 40)
						(HighPrint 400 24) ; "You're not near the gate."
					)
					(
						(or
							(gCast contains: rGuard1)
							(gCast contains: rGuard2)
						)
						(HighPrint 400 10) ; "You need to do something about the guards first."
					)
					(else
						(HighPrint 400 39) ; "You find that the gate has been secured on the other side."
						(gEgo setScript: (ScriptID 401 8)) ; doorBuster
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightDr of TargActor
	(properties
		x 189
		y 109
		noun '/gate'
		description {the gate}
		lookStr {The doors are massive.}
		view 460
		loop 2
		priority 7
		signal 16
	)

	(method (init)
		(if gNight
			(= palette 4)
		else
			(= palette 3)
		)
		(super init:)
	)

	(method (detectMe)
		(leftDr detectMe: &rest)
	)

	(method (hurtMe)
		(leftDr hurtMe: &rest)
	)

	(method (openMe)
		(leftDr openMe: &rest)
	)

	(method (doVerb)
		(leftDr doVerb: &rest)
	)
)

(instance rGuard3 of Actor
	(properties
		x 45
		y 160
		description {the marching guard in front of the gates}
		lookStr {The guards march ceaselessly before the gates to the Palace.}
		view 382
		illegalBits 0
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(talkGuards)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rGuard4 of Actor
	(properties
		x 290
		y 153
		description {the pacing guard in front of the gates}
		lookStr {The guards march ceaselessly before the gates to the Palace.}
		view 382
		loop 1
		illegalBits 0
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(talkGuards)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance scarf of Actor
	(properties
		x 57
		y 54
		noun '/scarf'
		description {the scarf}
		lookStr {It's a scarf left by the harem girl to show the way.}
		view 460
		priority 10
		signal 16
		cycleSpeed 1
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance toPalace of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 15) self
				)
				(djinniPrint 400 40) ; "You can't stop now. Iblis is starting to awaken!"
			)
			(1
				(= backToRoom 0)
				(self dispose:)
			)
		)
	)
)

(instance comeIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 181 self)
			)
			(1
				(= isInRoom 1)
				(self dispose:)
			)
		)
	)
)

(instance guardPace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rGuard3 setCycle: Walk)
				(rGuard4 setCycle: Walk)
				(= cycles 1)
			)
			(1
				(rGuard3 setMotion: MoveTo 290 160)
				(rGuard4 setMotion: MoveTo 45 153 self)
			)
			(2
				(rGuard3 setMotion: MoveTo 45 160)
				(rGuard4 setMotion: MoveTo 290 153 self)
			)
			(3
				(self changeState: 1)
			)
		)
	)
)

(instance ropeMe of Script
	(properties)

	(method (doit)
		(if (== (gEgo z:) 57)
			(gEgo setScript: overWall)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and g1Down g2Down)
					(gEgo setMotion: PolyPath 27 147 self)
				else
					(HighPrint 400 41 103 25 3) ; "You move deeper into the shadows to avoid the guards."
					(cond
						((> (gEgo x:) 219)
							(gEgo setMotion: MoveTo 242 184 self)
						)
						((> (gEgo x:) 77)
							(gEgo setMotion: MoveTo 67 184 self)
						)
						(else
							(gEgo setMotion: MoveTo 9 170 self)
						)
					)
				)
			)
			(1
				(cond
					((and g1Down g2Down)
						(gEgo setHeading: 45 self)
					)
					((> (gEgo x:) 13)
						(gEgo setMotion: MoveTo 9 170 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(if (and g1Down g2Down)
					(self changeState: 4)
				else
					(gEgo setMotion: MoveTo 27 147 self)
				)
			)
			(3
				(gEgo loop: 6)
				(= cycles 1)
			)
			(4
				(caller cue:)
			)
		)
	)
)

(instance overWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: climbPost self)
			)
			(1
				(HandsOff)
				(if (> (gEgo x:) 160)
					(NormalEgo)
					(gEgo setCycle: Walk setMotion: MoveTo 271 57 self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (> (gEgo x:) 160)
					(gEgo setLoop: 4)
				else
					(gEgo setLoop: 5)
				)
				(makeRope)
				(= seconds 1)
			)
			(3
				(gEgo
					view: 31
					setLoop: (if (> (gEgo x:) 160) 0 else 1)
					cel: 0
					setPri: 2
					cycleSpeed: 1
					setCycle: CT 5 1
				)
				((ScriptID 61 1) hide:) ; coil
				(= cycles 1)
			)
			(4
				((ScriptID 61 1) ; coil
					posn: ((ScriptID 61 0) x:) 24 ; rope
					cel: 5
					setPri: 13
					show:
				)
				((ScriptID 61 0) dispose:) ; rope
				(= cycles 1)
			)
			(5
				((ScriptID 61 1) setCycle: Beg) ; coil
				(gCurRoom setScript: disposeRope self)
			)
			(6
				(gEgo cycleSpeed: 1 setCycle: Beg)
				((ScriptID 61 1) dispose:) ; coil
				(= cycles 6)
			)
			(7
				(HandsOn)
				(NormalEgo)
				(gEgo loop: 4 illegalBits: -32768)
				(self dispose:)
			)
		)
	)
)

(instance guardAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontMove 1)
				(client view: 382 loop: 2 illegalBits: 0)
				(if (< (client x:) (gEgo x:))
					(client
						setCycle: Walk
						setMotion:
							PolyPath
							(- (gEgo x:) 20)
							(- (gEgo y:) 15)
							self
					)
				else
					(client
						setCycle: Walk
						setMotion:
							PolyPath
							(+ (gEgo x:) 20)
							(- (gEgo y:) 15)
							self
					)
				)
			)
			(1
				(Face client gEgo)
				(= seconds (- 5 gArcadeLevel))
			)
			(2
				(if (gCast contains: eunuch)
					(eunuchPrint 400 42) ; "Now! Guards, get that intruder!!"
				)
				(gEgo setMotion: 0)
				(gCurRoom setScript: guardsRushIn)
			)
		)
	)
)

(instance guardHouse of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 0 setMotion: MoveTo 50 (gEgo y:))
				(if (gCast contains: eunuch)
					(eunuch setMotion: 0 setCycle: 0 setLoop: 0)
				)
				(= cycles 9)
			)
			(1
				(houseGuards)
				(= seconds 4)
			)
			(2
				(gEgo setMotion: 0)
				(if (IsFlag 138) ; fVisitedHaremGirl
					(EgoDead
						1
						{By golly, you discovered the tower guard house.  Guess you should have tried the side with the scarf. }
						#title
						{Yikes!!!}
					)
				else
					(EgoDead
						1
						{By golly, you discovered the tower guard house.}
						#title
						{Yikes!!!}
					)
				)
			)
		)
	)
)

(instance guardZapped of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: 0 setMotion: 0)
				(client
					illegalBits: 0
					setPri: 8
					signal: 16384
					view: 381
					setLoop: 2
					cel: 1
					posn: (- (client x:) 10) (+ (client y:) 10)
				)
				(= cycles 1)
			)
			(1
				(client cel: 2 posn: (- (client x:) 8) (- (client y:) 13))
				(= cycles 1)
			)
			(2
				(client cel: 3 posn: (- (client x:) 16) (+ (client y:) 14))
				(= cycles 1)
			)
			(3
				(MakeGuardPoly client)
				(client ignoreActors: 0 addToPic:)
				(self dispose:)
			)
		)
	)
)

(instance guardsRushIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(> (gEgo x:) 119)
						(< (gEgo x:) 203)
						(> (gEgo y:) 110)
						(< (gEgo y:) 142)
					)
					(gEgo setMotion: MoveTo 159 144)
				else
					(gEgo setMotion: 0 setCycle: 0)
				)
				(= guardDazzd 1)
				(eunuch setMotion: 0 setCycle: 0)
				(= cycles 6)
			)
			(1
				(if (== (leftDr cel:) 0)
					(leftDr setCycle: End)
					(rightDr setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if (>= gMachineSpeed 40)
					(manyGuards)
					(= seconds 6)
				else
					(showGuards)
					(= seconds 2)
				)
			)
			(3
				(HighPrint 400 43) ; "A swarm of five guards come storming out of the palace after you. You fight valiantly and desperately against overwhelming odds."
				(= cycles 2)
			)
			(4
				(Print 400 44) ; "Suddenly, the Djinni cries "No! Iblis is loose!" You and the guards turn as you hear a rumbling and crashing from inside the Palace."
				(= cycles 2)
			)
			(5
				(DontMove 0)
				(gCurRoom newRoom: 790)
				(self dispose:)
			)
		)
	)
)

(instance badLevitate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HighPrint 400 45 80 {Guard:}) ; "Hey, this guy knows Magic."
				(= cycles 2)
			)
			(1
				(if (> (eunuch x:) 316)
					(eunuch
						view: 533
						loop: 0
						cel: 0
						mover: 0
						setCycle: End self
					)
				else
					(Face eunuch gEgo)
					(= cycles 2)
				)
			)
			(2
				(if (== (eunuch view:) 533)
					(eunuch loop: 1 setCycle: Fwd)
				else
					(eunuch setMotion: 0 setCycle: 0)
				)
				(eunuchPrint 400 46 25 5) ; "Guards, To me!"
				(= seconds 1)
			)
			(3
				(gEgo setScript: guardsRushIn)
				(self dispose:)
			)
		)
	)
)

(instance holler of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eunuch setMotion: 0)
				(Face eunuch gEgo)
				(= seconds 2)
			)
			(1
				(eunuchPrint 400 47) ; "What is going on? Guards! The gate!!"
				(= cycles 2)
			)
			(2
				(self changeState: 4)
			)
			(3
				(eunuchPrint
					(Format @str 400 0 [gateMsg gateCount]) ; "%s"
					(++ hollerCount)
				)
				(= seconds 4)
			)
			(4
				(if (< gateCount 5)
					(++ gateCount)
				else
					(= gateCount 0)
				)
				(++ gGateGuards)
				(self changeState: 3)
			)
		)
	)
)

(instance climbPost of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= whichPost
					(cond
						((<= 23 (gEgo x:) 40) 0)
						((<= 83 (gEgo x:) 106) 1)
						((<= 214 (gEgo x:) 247) 2)
						((<= 278 (gEgo x:) 309) 3)
					)
				)
				(gEgo
					view: 6
					setLoop: (if (== whichPost 3) 7 else 6)
					cel: 0
					illegalBits: 0
					setPri: 10
					x:
						(switch whichPost
							(0 43)
							(1 102)
							(2 232)
							(3 281)
						)
					y:
						(switch whichPost
							(0 83)
							(1 83)
							(2 83)
							(3 83)
						)
					z: 0
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 410
					loop: 0
					cel: 6
					x:
						(switch whichPost
							(0 62)
							(1 128)
							(2 258)
							(3 260)
						)
					y:
						(switch whichPost
							(0 84)
							(1 84)
							(2 84)
							(3 84)
						)
				)
				(= cycles 3)
			)
			(2
				(gEgo
					cel: 5
					x:
						(switch whichPost
							(0 60)
							(1 125)
							(2 254)
							(3 254)
						)
					y:
						(switch whichPost
							(0 87)
							(1 87)
							(2 87)
							(3 87)
						)
				)
				(= cycles 3)
			)
			(3
				(gEgo
					cel: 4
					setPri: 8
					x:
						(switch whichPost
							(0 60)
							(1 125)
							(2 255)
							(3 255)
						)
					y:
						(switch whichPost
							(0 85)
							(1 85)
							(2 85)
							(3 85)
						)
				)
				(= cycles 3)
			)
			(4
				(gEgo
					cel: 3
					x:
						(switch whichPost
							(0 56)
							(1 121)
							(2 250)
							(3 250)
						)
					y:
						(switch whichPost
							(0 86)
							(1 86)
							(2 86)
							(3 86)
						)
				)
				(= cycles 3)
			)
			(5
				(gEgo
					view: 0
					loop: 5
					cel: 3
					x:
						(switch whichPost
							(0 48)
							(1 113)
							(2 241)
							(3 241)
						)
					y:
						(switch whichPost
							(0 56)
							(1 56)
							(2 56)
							(3 56)
						)
				)
				(= cycles 3)
			)
			(6
				(HandsOn)
				(NormalEgo)
				(if
					(and
						(!= client overWall)
						(or
							(and
								(== (eunuch loop:) 1)
								(> (eunuch x:) (gEgo x:))
							)
							(gCast contains: eunuch)
						)
						(< (gEgo distanceTo: eunuch) 40)
					)
					(eunuch setScript: (ScriptID 401 4)) ; eunuchBust
				)
				(self dispose:)
			)
		)
	)
)

(instance levitateMe of Script
	(properties)

	(method (doit)
		(if (== (gEgo z:) 63)
			(= guardRushTimer 0)
			(gEgo illegalBits: 0 setScript: climbPost)
		)
		(super doit:)
	)

	(method (changeState)
		(caller cue:)
	)
)

(instance fightScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gCast contains: rGuard2))
					(rGuard1
						view: 382
						loop: 0
						illegalBits: 0
						setCycle: Walk
						setMotion: MoveTo 177 141 self
					)
				else
					(rGuard2
						view: 382
						loop: 2
						setCycle: Walk
						setMotion: MoveTo 177 141 self
					)
					(HighPrint 400 48 80 {Other Guard:} 103 25 4) ; "Go get him, Elija-One! I'll watch you make short work of this hero."
					(= gRasGuardLeft 1)
				)
				(if (gCast contains: rGuard2)
					(gEgo setMotion: MoveTo 145 159 self)
				)
			)
			(1
				(if (not (gCast contains: rGuard2))
					(self cue:)
				)
			)
			(2
				(if (not (gCast contains: rGuard2))
					(Face rGuard1 gEgo)
				else
					(Face gEgo rGuard2 1)
				)
				(= cycles 6)
			)
			(3
				(if (gCast contains: rGuard2)
					(gEgo
						view:
							(if (or (gEgo has: 4) (gEgo has: 24)) ; Sword, FineSword
								83
							else
								84
							)
						loop: 0
						cel: 0
						cycleSpeed: 2
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(4
				(if (not (gCast contains: rGuard2))
					(rGuard1 dispose:)
					((ScriptID 401 0) show:) ; rasGuard
					(self dispose:)
				else
					((= rasGuy (ScriptID 401 0)) ; rasGuard
						barMessage: 0
						posn: 175 142
						opponent: (= egoGuy (ScriptID 32 0)) ; warrior
					)
					(egoGuy
						barMessage: 0
						posn: 145 152
						setPri: 11
						opponent: rasGuy
						initCombat:
						loop: 8
						cel: 3
						setCycle: Beg self
					)
					(gEgo hide:)
				)
				(self cue:)
			)
			(5
				(if (not (gCast contains: rGuard2))
					(rGuard1 dispose:)
				else
					(rGuard2 dispose:)
				)
				(rasGuy initCombat:)
				(self dispose:)
			)
		)
	)
)

(instance letsFight of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 382
					loop: 0
					ignoreActors:
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 177 141 self
				)
			)
			(1
				(HighPrint 400 49 80 {Guard:}) ; "Come out and fight me like a man!"
				(= cycles 6)
			)
			(2
				(HighPrint 400 50) ; "You have no choice but to fight."
				(gEgo setMotion: MoveTo 145 159 self)
			)
			(3
				(Face gEgo client 1)
				(= cycles 2)
			)
			(4
				(gEgo
					view:
						(if (or (gEgo has: 4) (gEgo has: 24)) 83 else 84) ; Sword, FineSword
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(5
				((= rasGuy (ScriptID 401 0)) ; rasGuard
					barMessage: 0
					posn: 175 142
					opponent: (= egoGuy (ScriptID 32 0)) ; warrior
				)
				(egoGuy
					barMessage: 0
					posn: 145 152
					setPri: 11
					opponent: rasGuy
					initCombat:
					loop: 8
					cel: 3
					setCycle: Beg self
				)
				(gEgo hide:)
			)
			(6
				(= gRasGuardLeft 0)
				(client hide:)
				(rasGuy initCombat:)
				(self dispose:)
			)
		)
	)
)

