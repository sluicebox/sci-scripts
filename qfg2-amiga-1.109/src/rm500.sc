;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use battleSound)
(use ProjClient)
(use TargActor)
(use Flame)
(use n095)
(use doBattleS)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Rev)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	[candles 6]
	[flames 6]
	lastLit = -1
	egoGuy
	mage
	egoLoop
	hitCandle
	adAvisMad
	adAvisGone
	waitCntr
	hitCntr
	reversalMsg
	spellReturning
	runThruFlamesOK
	[candleXY 13] = [160 117 206 125 223 146 160 158 94 146 108 125 -1]
)

(procedure (CandlesLit howMany)
	(for ((= lastLit 0)) (< lastLit howMany) ((++ lastLit))
		([flames lastLit] show: loop: 1 setCycle: Fwd)
		([candles lastLit] stopUpd:)
		(switch lastLit
			(2
				(line02 init:)
				(gAddToPics add: line02)
			)
			(3
				(line13 init:)
				(gAddToPics add: line13)
			)
			(4
				(line24 init:)
				(line40 init:)
				(gAddToPics add: line24 line40)
			)
		)
	)
	(-- lastLit)
	(gAddToPics doit:)
)

(procedure (Fight)
	(gEgo hide:)
	(egoGuy
		posn: gEgoX gEgoY
		opponent: dococ
		barMessage: 0
		hurtScript: (ScriptID 501 10) ; fightHurtS
		initCombat:
	)
	(dococ setHealth: gMonsterHealth opponent: egoGuy initCombat:)
)

(instance rm500 of Rm
	(properties
		picture 500
		style 8
	)

	(method (init &tmp i theX theY)
		(LoadMany rsSCRIPT 501 78)
		(LoadMany rsSOUND 500 821)
		(LoadMany rsVIEW 1 4 41 500 501 502 503 505 510 612 613)
		(SetFlag 140) ; fEndGame
		(SolvePuzzle 691 7 1)
		(super init: &rest)
		(gCSound number: 500 loop: -1 playBed:)
		(= egoGuy (ScriptID 32 0)) ; warrior
		(if (= mage (gEgo knows: 29)) ; invisibility
			(rev init: hide:)
			(LoadMage)
		else
			(LoadFighter)
			(= [gEgoStats 29] 0) ; invisibility
		)
		(= gEgoGait 0) ; walking
		(NormalEgo)
		(gEgo posn: 197 173 heading: 0 loop: 3 hurtScript: egoGetHurtS init:)
		(InitTargs)
		(thark init: stopUpd:)
		(dococ init: setCycle: Fwd)
		(adAvis init: setCycle: Fwd)
		(shieldSpell init: hide:)
		(iblis init:)
		(for ((= i 0)) (!= [candleXY (* i 2)] -1) ((++ i))
			(= theX [candleXY (+ (* i 2) 0)])
			(= theY [candleXY (+ (* i 2) 1)])
			((= [candles i] (candle new:))
				view: 500
				loop: 2
				x: theX
				y: theY
				xStep: i
				init:
				stopUpd:
			)
			((= [flames i] (Flame new:))
				view: 500
				loop: 1
				x: theX
				y: theY
				z: 15
				cycleSpeed: 1
				init:
				hide:
			)
		)
		(CandlesLit 3)
		(brazier init: stopUpd:)
		(brazFire init:)
		(if (> gHowFast 1)
			(brazFire setCycle: Fwd)
		else
			(brazFire stopUpd:)
		)
		(= gMonsterNum 1000)
		(= gMonsterHealth 1000)
		(= gSpellChecker theSpellChecker)
		(self setScript: enterRoomS)
	)

	(method (doit &tmp thisControl i foundIt)
		(= gEgoX (gEgo x:))
		(= gEgoY (gEgo y:))
		(= thisControl (gEgo onControl: 1))
		(cond
			(mage
				(if
					(and
						(not hitCandle)
						(< gEgoX 171)
						(< lastLit 5)
						(not adAvisGone)
						(not (adAvis script:))
					)
					(adAvis setScript: lightNextCandleS)
				)
			)
			(adAvisGone)
			((and (< gEgoY 129) (not runThruFlamesOK))
				(gCurRoom setScript: fighterFlameS)
			)
			((and (< lastLit 4) (< gEgoY 145) (not (adAvis script:)))
				(adAvis setScript: lightNextCandleS)
			)
			((and (not (gEgo script:)) (& thisControl $0008))
				(= i 0)
				(= foundIt 0)
				(while (and (<= i 5) (not foundIt))
					(if
						(and
							(not ([candles i] cel:))
							(< (gEgo distanceTo: [candles i]) 16)
						)
						(gEgo setScript: (ScriptID 501 9) 0 [candles i]) ; kickCandleS
						(= foundIt 1)
					)
					(++ i)
				)
			)
			((and (& thisControl $0020) (!= script pushAvisS))
				(self setScript: pushAvisS)
			)
			(script)
			((and (& thisControl $1000) (not gCantMove) (not (dococ script:)))
				(dococ setScript: hitEgoS)
			)
		)
		(cond
			(gCantMove)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(gEgo edgeHit: EDGE_NONE posn: gEgoX (- gEgoY 2))
				((ScriptID 501 7) register: 1) ; backInS
				(gCurRoom setScript: (ScriptID 501 7)) ; backInS
			)
			((== thisControl 2)
				(gEgo posn: (+ gEgoX 4) gEgoY)
				((ScriptID 501 7) register: 0) ; backInS
				(gCurRoom setScript: (ScriptID 501 7)) ; backInS
			)
			((and (> gEgoX 202) (not (dococ cycler:)) (not (dococ script:)))
				(dococ setCycle: Fwd)
			)
			((not (& (dococ signal:) $0004))
				(dococ stopUpd:)
			)
		)
		(super doit:)
	)

	(method (dispose &tmp I)
		(DisposeScript 501)
		(flameT dispose: delete:)
		(super dispose:)
	)

	(method (notify which)
		(if (not argc)
			(return lastLit)
		else
			(switch which
				(-2
					(= hitCandle 1)
				)
				(-3
					(if hitCandle
						(djinniPrint 500 0) ; "You've already broken the spell, Master."
					else
						(djinniPrint 500 1) ; "You must move an unlit candle to break the spell, Master.  Please stop that human!"
					)
				)
				(-1
					(if (not adAvisMad)
						(= adAvisMad 1)
						(self
							setScript:
								(if mage angryAtMageS else angryAtFighterS)
						)
					)
				)
				(59
					(= gBattleResult 59)
					(EgoGait 1 0) ; running
					(gEgo show: x: 214 setMotion: MoveTo 183 166)
					(adAvis setScript: lightNextCandleS)
					(egoGuy dispose:)
					(dococ endCombat: stopUpd:)
					(return 1)
				)
				(else
					(= gBattleResult 0)
					(return 0)
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 500 2) ; "This room is high atop the palace and far above Raseir.  Wind whips through the pillars and the moonlight, brighter than you have ever seen it, washes over the eerie scene."
			)
			((Said 'force/ad')
				(if runThruFlamesOK
					(gCurRoom setScript: pushAvisS)
				else
					(HighPrint 500 3) ; "Good idea, but he's too far away."
				)
			)
			((Said 'duck,(get,get<down)')
				(if (== (gEgo view:) 47)
					(HighPrint 500 4) ; "You are already ducking as much as you can."
				else
					(gEgo setScript: duckS)
				)
			)
			((Said 'stand,(get,get<up)')
				(if (== (gEgo view:) 47)
					(duckS cue:)
				else
					(HighPrint 500 5) ; "You're already standing up."
				)
			)
		)
	)
)

(instance egoGetHurtS of HandsOffScript
	(properties)

	(method (changeState newState &tmp i moveScript)
		(switch (= state newState)
			(0
				(if (IsFlag 86) ; fReversal
					((= moveScript (Projectile new:))
						type: (register type:)
						xStart: gEgoX
						yStart: (- gEgoY 30)
						x: (Random 90 244)
						y: (Random 50 80)
					)
					(rev setScript: (ScriptID 501 6)) ; comeAndGoS
					(client setScript: moveScript)
				else
					(self cue:)
				)
			)
			(1
				(= egoLoop (gEgo loop:))
				(gEgo
					view: 41
					cel: 0
					setMotion: 0
					setCycle: End self
					setLoop:
						(cond
							((= register (TakeDamage 10))
								(if (< (gEgo heading:) 180) 2 else 3)
							)
							((< (gEgo heading:) 180) 0)
							(else 1)
						)
				)
			)
			(2
				(if register
					(gEgo setCycle: Beg self)
				else
					(HowHeLost
						(if (== (gCurRoom script:) angryAtFighterS) 2 else 6)
					)
				)
			)
			(3
				(NormalEgo)
				(gEgo loop: egoLoop)
				(if (and spellReturning (not reversalMsg))
					(= reversalMsg 1)
					(djinniPrint 500 6) ; "Everything just bounces off that human, Boss. You better try something else, quick!"
				)
				(= spellReturning 0)
				(self dispose:)
			)
		)
	)
)

(instance enterRoomS of HandsOffScript
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(gEgo
					posn: 233 198
					setMotion: MoveTo 234 (if mage 174 else 168) self
				)
			)
			(1
				(djinniPrint 500 7) ; "You seem to have triggered a magical spell on that statue, Master."
				(gEgo setHeading: 45 self)
				(adAvis setScript: lightNextCandleS)
			)
			(2
				(if mage
					(client setScript: hitEgoS)
				else
					(Fight)
					(self dispose:)
				)
			)
		)
	)
)

(instance hitEgoS of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and mage (gEgo mover:) (not (IsFlag 87)) (not spellReturning)) ; fCastingSpell
				(= cycles 0)
				(self changeState: 0)
			)
			((and (== (gEgo view:) 47) (== state 5) (gEgo cel:))
				(self cue:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'attack,attack')
				(Fight)
				(self dispose:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register (== (gEgo view:) 47))
				(dococ
					setLoop: (if (< gEgoY 175) 2 else 3)
					cel: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(1
				(gEgo view: 22 setLoop: 0 cel: 0 setCycle: End self)
				(if mage
					(gEgo setMotion: 0)
				else
					(gEgo
						x: (- gEgoX 4)
						setMotion: MoveTo (- gEgoX 10) gEgoY
					)
				)
				(++ hitCntr)
			)
			(2
				(cond
					(register
						(EgoDead 1 500 8 #title {Brainless and Painless}) ; "Ducking a low blow is a quick way to go."
					)
					((TakeDamage 60)
						(self cue:)
					)
					(else
						(HowHeLost 1)
					)
				)
			)
			(3
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
				(dococ cycleSpeed: 2 setLoop: 0 setCycle: Fwd)
			)
			(4
				(NormalEgo)
				(gEgo view: 4 heading: 0 loop: 3 setHeading: 45 self)
				(HandsOn)
				(if (and (OneOf hitCntr 2 4) (not (adAvis script:)))
					(adAvis setScript: lightNextCandleS)
				)
			)
			(5
				(if mage
					(= cycles 22)
				else
					(self dispose:)
				)
			)
			(6
				(if (or (IsFlag 87) spellReturning) ; fCastingSpell
					(self changeState: 5)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance lightNextCandleS of Script
	(properties)

	(method (changeState newState &tmp lastOne)
		(switch (= state newState)
			(0
				(if (== lastLit 4)
					(if hitCandle
						(self dispose:)
					else
						(djinniPrint 500 9) ; "DO something, Master! He's about to light the final candle, and then Iblis will be FREE!"
						(= lastOne 1)
					)
				)
				(adAvis
					setLoop: 0
					cel: 0
					cycleSpeed: (if lastOne 3 else 1)
					setCycle: End self
				)
			)
			(1
				(if hitCandle
					(self dispose:)
				else
					([flames (++ lastLit)] show: setCycle: Fwd)
					(switch lastLit
						(2
							(line02 init: stopUpd:)
						)
						(3
							(line13 init: stopUpd:)
						)
						(4
							(line24 init: stopUpd:)
							(line40 init: stopUpd:)
						)
						(5
							(line35 init: stopUpd:)
							(line51 init: stopUpd:)
						)
					)
					(if (== lastLit 5)
						(flameT dispose: delete:)
						(adAvis setLoop: 0 cel: 0 setCycle: Fwd)
						(client setScript: (ScriptID 501 4)) ; iblisIsFreeS
					else
						(flameT setCycle: flameT 80)
						(djinniPrint 500 10) ; "Another candle! Master, hurry!"
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance stopTharkS of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(gEgo illegalBits: -16384)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thark startUpd:)
				(= cycles 4)
			)
			(1
				(thark dispose:)
				(dococ
					view: 511
					posn: 254 162
					setLoop: 0
					cel: 0
					setMotion: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(dococ setPri: 11 stopUpd: addToPic:)
				(NormalEgo)
				(if (not hitCandle)
					(if (!= lastLit 5)
						(djinniPrint 500 11) ; "That's got it, Boss! Now stop those candles!"
					)
					(if (and (< lastLit 4) (not (adAvis script:)))
						(adAvis setScript: lightNextCandleS)
					)
					((ScriptID 501 4) register: 3) ; iblisIsFreeS
				)
				(self dispose:)
			)
		)
	)
)

(instance angryAtMageS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 8)
			)
			(1
				(adAvis tLoop: 0)
				(Say adAvis self 500 12 500 13 500 14) ; "You! You will pay!"
				(gEgo
					setMotion: 0
					setHeading:
						(cond
							((IsFlag 86) 0) ; fReversal
							((< gEgoX (adAvis x:)) 45)
							(else 315)
						)
				)
			)
			(2
				(adAvis cel: 0 setCycle: CT 5 1 self)
				(if (not (IsFlag 141)) ; fKhaveenDead
					(khav init: setCycle: Walk setMotion: MoveTo 44 176)
				)
			)
			(3
				(trans
					init:
					setPri: (- (gEgo priority:) 1)
					posn: 158 84
					setCycle: Fwd
					setMotion: MoveTo gEgoX (- gEgoY 35) self
				)
			)
			(4
				(if (IsFlag 86) ; fReversal
					(rev setScript: (ScriptID 501 6)) ; comeAndGoS
					(client setScript: transKhavS)
				else
					(gEgo
						view: 556
						setLoop: (< (gEgo heading:) 180)
						cel: 0
						cycleSpeed: 0
						setCycle: End self
					)
					(trans dispose:)
				)
			)
			(5
				(Say adAvis self 500 15 500 16) ; "Khaveen will enjoy having you for his very own, but I doubt that you will live very long. You will pay for preventing me from releasing Iblis."
			)
			(6
				(HowHeLost 4)
				(self dispose:)
			)
		)
	)
)

(instance transKhavS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: -16384)
				(trans setMotion: MoveTo (+ (khav x:) 7) (- (khav y:) 30) self)
				(khav setMotion: 0)
			)
			(1
				(trans dispose:)
				(if (IsFlag 141) ; fKhaveenDead
					(self changeState: 5)
				else
					(khav
						view: 506
						setLoop: 1
						cel: 0
						cycleSpeed: 0
						setCycle: End self
					)
				)
			)
			(2
				(= cycles 4)
			)
			(3
				(khav
					setLoop: 2
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo -18 176 self
				)
			)
			(4
				(khav dispose:)
				(Say adAvis self 500 17) ; "Fool!"
			)
			(5
				(adAvis setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(6
				(adAvis cel: 4)
				(flameBolt
					init:
					ignoreHorizon: 1
					setLoop: 2
					setPri: (- (gEgo priority:) 1)
					posn: 156 88
					setCycle: Fwd
					setMotion: MoveTo gEgoX (- gEgoY 30) self
				)
			)
			(7
				(rev setScript: (ScriptID 501 6)) ; comeAndGoS
				(adAvis cel: 2 setCycle: Beg)
				(flameBolt setLoop: 5 setMotion: MoveTo 60 84 self)
			)
			(8
				(flameBolt setLoop: 3 cel: 0 setCycle: End self)
				(HandsOn)
			)
			(9
				(flameBolt dispose:)
				(client setScript: bigBadSpellS)
			)
		)
	)
)

(instance bigBadSpellS of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (< gEgoY 129) (< state 6))
			(= cycles (= seconds 0))
			(adAvis setCycle: 0)
			(self changeState: 6)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say adAvis self 500 18) ; "So! The hero has a reversal spell. Well, there's a way around that!"
			)
			(1
				(adAvis cycleSpeed: 1 setCycle: Rev)
				(= seconds 3)
			)
			(2
				(djinniPrint 500 19) ; "Stop him, Master! Don't let him cast that spell!"
				(adAvis setLoop: 0 cycleSpeed: 0)
				(= waitCntr 6)
				(= seconds 10)
			)
			(3
				(adAvis setCycle: Rev)
				(djinniPrint 500 20) ; "The spell is about to go off! It'll get you for sure!"
				(= seconds 2)
			)
			(4
				(= cycles 6)
			)
			(5
				(if (and (IsFlag 87) (-- waitCntr)) ; fCastingSpell
					(self changeState: 4)
				else
					(adAvis setCycle: Beg self)
				)
			)
			(6
				(HandsOff)
				(gEgo
					view: 504
					setLoop: 0
					cycleSpeed: 3
					setScript: 0
					setCycle: End
				)
				(trans
					view: 504
					setLoop: 1
					cel: 10
					init:
					setPri: -1
					posn: gEgoX (+ gEgoY 3)
					setCycle: Beg self
				)
			)
			(7
				(gEgo hide:)
				(trans setCycle: End self)
			)
			(8
				(HowHeLost 5)
			)
		)
	)
)

(instance angryAtFighterS of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(flameBolt dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(Say adAvis self 500 21) ; "You! My spell is broken! You will die!"
			)
			(2
				(if (IsFlag 87) ; fCastingSpell
					(self changeState: 7)
				else
					(adAvis setLoop: 0 cel: 0 setCycle: CT 2 1 self)
				)
			)
			(3
				(adAvis cel: 4)
				(flameBolt
					init:
					ignoreHorizon: 0
					setLoop: 2
					posn: 148 84
					setCycle: Fwd
					setMotion: MoveTo gEgoX (- gEgoY 30)
				)
			)
			(4
				(if (== (gEgo view:) 47)
					(flameBolt
						ignoreHorizon: 1
						setPri: (+ (gEgo priority:) 1)
						setMotion: MoveFwd 50 self
					)
				else
					(flameBolt setLoop: 3 cel: 0 setCycle: End self)
					(avisSpellSound number: 14 loop: 1 priority: 6 init: play:)
					(gEgo hurtMe: 25 25)
				)
			)
			(5
				(adAvis cel: 2 setCycle: Beg self)
				(flameBolt dispose:)
				(if (== (gEgo view:) 47)
					(duckS cue:)
				)
			)
			(6
				(adAvis setLoop: 1 setCycle: Fwd)
				(= cycles 8)
			)
			(7
				(= cycles 4)
			)
			(8
				(self changeState: 2)
			)
		)
	)
)

(instance burnAvisUpS of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(gEgo illegalBits: -16384)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(brazier setCycle: CT 3 1 self)
				(brazFire dispose:)
			)
			(1
				(gCSound number: 821 playBed:)
				(brazier setCycle: End)
				(adAvis
					view: 508
					setLoop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(gEgo setHeading: 45)
			)
			(2
				(= adAvisGone 1)
				(if (or (== gHeroType 0) (== gHeroType 3)) ; Fighter, Paladin
					(SolvePuzzle 667 15)
				)
				(SolvePuzzle 692 25 1)
				(adAvis dispose:)
				(Face gEgo iblis 0 self)
			)
			(3
				(if (== lastLit 5)
					(self dispose:)
				else
					(brazier stopUpd:)
					(if (gCast contains: brazFire)
						(brazFire setCycle: End self)
					else
						(= cycles 2)
					)
				)
			)
			(4
				(brazFire dispose:)
				(djinniPrint 500 22) ; "We did it! Hurray!"
				(client setScript: (ScriptID 501 11)) ; djS
			)
		)
	)
)

(instance fighterFlameS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= runThruFlamesOK 1)
				(gEgo setMotion: 0)
				(adAvis setLoop: 0 cel: 0 cycleSpeed: 0 setCycle: CT 4 1 self)
			)
			(1
				(brazFire
					setPri: -1
					view: 504
					posn: 117 118
					z: 0
					setLoop: 1
					cel: 10
					setCycle: Beg self
				)
			)
			(2
				(brazier dispose:)
				(brazFire setScript: fireCycleS)
				(adAvis setScript: lightNextCandleS)
				(self dispose:)
			)
		)
	)
)

(instance fireCycleS of Script
	(properties)

	(method (changeState newState)
		(if (== newState 2)
			(= newState 0)
		)
		(switch (= state newState)
			(0
				(client setCycle: CT 3 1 self)
			)
			(1
				(client setCycle: Beg self)
			)
		)
	)
)

(instance pushAvisS of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(gEgo illegalBits: -16384)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(EgoGait 1 0) ; running
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 127 116 self
				)
			)
			(1
				(adAvis view: 509 setLoop: 0 cel: 0 cycleSpeed: 1 setCycle: End)
				(gEgo setMotion: MoveTo 145 111)
				(= cycles 10)
			)
			(2
				(gCSound number: 821 playBed:)
				(adAvis setLoop: 1 cel: 1 setCycle: End)
				(gEgo setMotion: 0)
				(= cycles 10)
			)
			(3
				(adAvis
					setPri: 3
					setCel: 4
					setStep: 3 5
					setMotion: MoveTo 174 133 self
				)
			)
			(4
				(burnAvisUpS start: 2)
				(client setScript: burnAvisUpS)
			)
		)
	)
)

(instance duckS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 47 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(DontTalk 0)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo)
				(HandsOn 1)
				(self dispose:)
			)
		)
	)
)

(instance adAvis of Talker
	(properties
		x 157
		y 108
		description {Ad Avis}
		lookStr {Ad Avis stands, glaring sternly, his black robes blowing in the wind.}
		view 501
		loop 1
		signal 16384
		illegalBits 0
		myName '//ad,man'
		title {Ad Avis:}
		color 13
		back 0
	)

	(method (handleEvent event)
		(if (Said 'ask')
			(djinniPrint 500 23) ; "Don't be such a Chatty Cathy. Get moving."
		else
			(super handleEvent: event)
		)
	)

	(method (hurtMe amount whatHurt &tmp moveScript)
		(if (and (OneOf (whatHurt type:) 4 5) (not script))
			(adAvis setLoop: 8 cel: 0 setCycle: CT 3 1)
		else
			(shieldSpell posn: hitX (- hitY 6) setScript: adShieldUp show:)
			((= moveScript (Projectile new:))
				type: (whatHurt type:)
				damage: amount
				xStart: hitX
				yStart: hitY
				x: gEgoX
				y: (- gEgoY 35)
			)
			(= spellReturning 1)
			(gEgo setPri: 15)
			(brazier setScript: moveScript)
			(return 0)
		)
	)

	(method (cue)
		(shieldSpell hide:)
	)

	(method (doit)
		(if (not (or cycler mover runThruFlamesOK))
			(= loop 1)
			(self setCycle: Fwd)
		)
		(super doit:)
	)
)

(instance flameBolt of Actor
	(properties
		yStep 10
		view 505
		loop 2
		signal 18448
		illegalBits 0
		xStep 12
	)

	(method (doit &tmp s)
		(cond
			((& signal $2000))
			(
				(and
					(== loop 2)
					(< (- gEgoX 7) x (+ gEgoX 7))
					(> gEgoY y (- gEgoY 40))
				)
				(if (= s (gCurRoom script:))
					(s cue:)
				)
			)
			((self mover:)
				((self mover:) x: gEgoX y: (- gEgoY 30) init:)
				(= priority (- (gEgo priority:) 1))
			)
			(else
				(self setMotion: MoveTo gEgoX (- gEgoY 30))
			)
		)
		(super doit:)
	)

	(method (setMotion)
		(gSpareSound number: 15 loop: 1 play:)
		(super setMotion: &rest)
	)

	(method (dispose)
		(gSpareSound number: 16 loop: 1 play:)
		(super dispose: &rest)
	)
)

(instance trans of Actor
	(properties
		yStep 18
		view 505
		loop 4
		signal 18448
		illegalBits 0
		xStep 22
	)

	(method (setMotion)
		(gSpareSound number: 13 loop: 1 play:)
		(super setMotion: &rest)
	)

	(method (dispose)
		(gSpareSound number: 14 loop: 1 play:)
		(super dispose: &rest)
	)
)

(instance rev of Prop
	(properties
		view 506
		signal 16384
	)
)

(instance avisSpellSound of Sound
	(properties)
)

(instance shieldSpell of Prop
	(properties
		x 152
		y 86
		view 505
		signal 16
	)
)

(instance adShieldUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					show:
					loop: 0
					cel: 0
					priority: (+ (adAvis priority:) 1)
					setCycle: End self
				)
			)
			(1
				(client loop: 1 init: setCycle: Fwd)
				(= cycles 4)
			)
			(2
				(client loop: 0 cel: 3 setCycle: Beg self)
			)
			(3
				(client hide:)
				(self dispose:)
			)
		)
	)
)

(instance thark of TargActor
	(properties
		x 264
		y 135
		view 510
		loop 1
		priority 12
		signal 16400
		cycleSpeed 2
		illegalBits 0
		moveSpeed 2
	)

	(method (cue)
		(super cue:)
		(HighPrint 500 24) ; "Good idea! He does look top-heavy with all those arms, doesn't he? Unfortunately, his mass is far too great for that spell to have any effect."
	)

	(method (hurtMe)
		(self cue:)
	)

	(method (fetchMe)
		(self cue:)
		(return 0)
	)

	(method (triggerMe)
		(gCurRoom setScript: stopTharkS)
		(return 1)
	)
)

(instance dococ of Monster
	(properties
		x 264
		y 135
		yStep 5
		view 510
		priority 12
		signal 16400
		cycleSpeed 2
		illegalBits 0
		xStep 5
		strength 300
		intell 125
		agil 125
		vit 125
		luck 125
		weap 125
		parry 125
		dodge 125
		armorValue 900
		armorEnc 20
		weapValue 10
		battleMusic 0
		endMusic 0
	)

	(method (initCombat)
		(= combatScript (ScriptID 501 1)) ; doBattleS
		(super initCombat: &rest)
	)

	(method (fetchMe)
		(HighPrint 500 25) ; "You've got to be kidding! That statue must weigh a thousand pounds!"
		(return 0)
	)

	(method (hurtMe)
		(return 1)
	)

	(method (triggerMe)
		(gCurRoom setScript: stopTharkS)
		(return 1)
	)
)

(instance candle of TargActor
	(properties
		x 123
		y 103
		noun '/candle'
		description {a candle}
		closeRangeDist 20
		lookStr {The candles are positioned at the six apexes of the hexagram.}
		view 500
		signal 6144
	)

	(method (fetchMe)
		(cond
			(adAvisGone
				(return 0)
			)
			(hitCandle
				(djinniPrint 500 26) ; "You've already broken the spell, Master. Stop that human!"
				(return (> xStep lastLit))
			)
			((> xStep lastLit)
				(= hitCandle 1)
				(= adAvisMad 1)
				(gCurRoom
					setScript: (if mage angryAtMageS else angryAtFighterS)
				)
				(return 1)
			)
			(else
				(djinniPrint 500 27) ; "You must hit an unlit candle to break the spell, Master.  Please stop that human!"
				(return 0)
			)
		)
	)

	(method (hurtMe)
		(cond
			((== lastLit 5)
				(djinniPrint 500 28) ; "You're too late, Master. We've failed"
				(return 0)
			)
			((> xStep lastLit)
				(self setStep: 6 4 setMotion: MoveTo 84 114 setCycle: End)
				(cond
					(adAvisGone)
					(hitCandle
						(djinniPrint 500 26) ; "You've already broken the spell, Master. Stop that human!"
					)
					(else
						(= hitCandle 1)
						(= adAvisMad 1)
						(gCurRoom
							setScript:
								(if mage angryAtMageS else angryAtFighterS)
						)
					)
				)
				(return 1)
			)
			(else
				(cond
					(adAvisGone
						(return 1)
					)
					(hitCandle
						(djinniPrint 500 26) ; "You've already broken the spell, Master. Stop that human!"
					)
					(else
						(djinniPrint 500 27) ; "You must hit an unlit candle to break the spell, Master.  Please stop that human!"
					)
				)
				(return 0)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(cond
					(hitCandle
						(djinniPrint 500 26) ; "You've already broken the spell, Master. Stop that human!"
					)
					((== lastLit 5)
						(djinniPrint 500 29) ; "You're too late, Master. We've failed!"
					)
					((gCurRoom script:)
						(HighPrint 500 30) ; "You're too busy right now."
					)
					(else
						(gCurRoom setScript: (ScriptID 501 8) 0 self) ; getCandleS
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'hit,move,knock/candle')
				(cond
					(hitCandle
						(djinniPrint 500 26) ; "You've already broken the spell, Master. Stop that human!"
					)
					((gCurRoom script:)
						(HighPrint 500 30) ; "You're too busy right now."
					)
					(else
						(HighPrint 500 31) ; "Just run up to one and do it."
					)
				)
			)
		)
	)
)

(instance iblis of Feature
	(properties
		x 159
		y 133
	)
)

(instance brazier of TargActor
	(properties
		x 136
		y 117
		view 500
		loop 4
	)

	(method (hurtMe amount whatHurt)
		(cond
			(cel
				(return 1)
			)
			((== (whatHurt type:) 25)
				(HighPrint 500 32) ; "The brazier is already lit. Your spell has no effect."
				(return 1)
			)
			((> hitY 106)
				(djinniPrint 500 33) ; "Aim a little higher, Master. Maybe you can tip it over onto him."
			)
			((or (< gEgoX 92) (IsFlag 147)) ; fBouncedBolt
				(gCurRoom setScript: burnAvisUpS)
			)
			(else
				(self loop: 5 posn: 119 115 cel: 0 setCycle: End self)
				(brazFire dispose:)
			)
		)
		(return 1)
	)

	(method (fetchMe)
		(HighPrint 500 34) ; "The brazier is too heavy to fetch."
		(return 0)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance brazFire of Prop
	(properties
		x 123
		y 115
		z 12
		view 500
		priority 9
		signal 16400
	)
)

(instance line02 of View
	(properties
		x 158
		y 134
		view 503
		cel 2
		priority 5
		signal 16400
	)
)

(instance line13 of View
	(properties
		x 159
		y 134
		view 503
		cel 5
		priority 5
		signal 16400
	)
)

(instance line24 of View
	(properties
		x 158
		y 134
		view 503
		cel 1
		priority 5
		signal 16400
	)
)

(instance line35 of View
	(properties
		x 158
		y 134
		view 503
		cel 4
		priority 5
		signal 16400
	)
)

(instance line51 of View
	(properties
		x 159
		y 134
		view 503
		cel 3
		priority 5
		signal 16400
	)
)

(instance line40 of View
	(properties
		x 157
		y 134
		view 503
		priority 5
		signal 16400
	)
)

(instance khav of TargActor
	(properties
		x -10
		y 176
		description {Khaveen}
		lookStr {The Calm spell must have worn off of Khaveen.  He seems confused, but very angry.}
		view 465
		signal 16384
		illegalBits 0
	)
)

(instance flameT of Timer
	(properties)

	(method (cue)
		(super cue: &rest)
		(if (not (or hitCandle (== lastLit 5) (adAvis script:)))
			(adAvis setScript: lightNextCandleS)
		)
	)
)

(instance theSpellChecker of Code
	(properties)

	(method (doit theSpell)
		(if (OneOf theSpell 28 6)
			(djinniPrint 500 35) ; "No, Master! You need to keep your feet on the ground."
			(return 0)
		else
			(return 1)
		)
	)
)

