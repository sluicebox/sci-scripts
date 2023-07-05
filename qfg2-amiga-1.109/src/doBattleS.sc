;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 501)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use Talker)
(use ProjClient)
(use TargActor)
(use Full)
(use n095)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	HowHeLost 0
	doBattleS 1
	LoadMage 2
	LoadFighter 3
	iblisIsFreeS 4
	InitTargs 5
	comeAndGoS 6
	backInS 7
	getCandleS 8
	kickCandleS 9
	fightHurtS 10
	djS 11
)

(procedure (HowHeLost reason)
	(switch reason
		(0
			(HighPrint 501 0 80 {Statue of Limitations}) ; "What a bust. That chiseler gave you no relief. Next time, remember not to stand your ground so long with a stone statue."
		)
		(1
			(EgoDead 1 501 1 #title {Rocky}) ; "What a beating. You might've gone another round if you'd been healthier when you came in."
		)
		(2
			(EgoDead 1 501 2 #title {Standing Aground?}) ; "You sure got a charge from that lightning. Perhaps you should have been galvanized into action instead."
		)
		(3
			(HighPrint 501 3 80 {MisSpelling}) ; "Some wizard you are. How do you Spell relief? M-A-G-I-C!"
		)
		(4
			(EgoDead 1 501 4 #title {See? We Know Some Big Words!}) ; "Your transmogrification by incantation presages your expiration, but your instigation prevented devastation by Iblis's domination. That is, you saved the world, but all you got for it was saurus breath. Next time, take a moment to reflect before you enter this situation."
		)
		(5
			(EgoDead 1 501 5 #title {Indirectly Dead}) ; "Unable to penetrate your reversal spell, Ad Avis caused the floor around you to begin to burn. Next time, take a tip from Ad Avis himself. If your spell rebounds from its target, then find another target."
		)
		(6
			(EgoDead 1 501 6 #title {Role Reversal}) ; "Ad Avis seems to have turned the tables (and your own spells) on you."
		)
	)
)

(procedure (LoadMage)
	(LoadMany rsVIEW 22 465 504 508 511 556 31 32)
	(LoadMany rsSOUND 13 14 15 16 17 18 31 34 35)
	(LoadMany rsSCRIPT 63 64 65)
)

(procedure (LoadFighter)
	(LoadMany rsVIEW 80 41 509)
	(LoadMany rsSOUND 54 55 23)
	(LoadMany rsSCRIPT 30 31 32 24)
)

(procedure (InitTargs)
	(floor init: stopUpd:)
	(wall init: stopUpd:)
	(iblisStatue init:)
	(InitAddToPics moon)
)

(instance doBattleS of Script
	(properties)

	(method (changeState newState &tmp opp theLoop dmg clientLoop)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(switch gArcadeLevel
					(1
						(= cycles (Random 12 15))
					)
					(2
						(= cycles (Random 8 11))
					)
					(3
						(= cycles (Random 4 7))
					)
				)
			)
			(2
				(if
					(= theLoop
						(switch (= clientLoop ((client opponent:) loop:))
							(0
								(Random 2 3)
							)
							(1 0)
							(2 0)
							(3 2)
							(4 2)
							(5 2)
							(6 2)
							(7 2)
							(8 2)
							(9
								(Random 2 3)
							)
							(10
								(Random 2 3)
							)
							(11 3)
						)
					)
					(client setLoop: theLoop cel: 0 setCycle: End self)
				else
					(self changeState: 5)
				)
			)
			(3
				(switch ((client opponent:) loop:)
					(0
						(= register 3)
					)
					(1
						(= register 0)
					)
					(2
						(= register 0)
					)
					(3
						(= register 3)
					)
					(4
						(= register 3)
					)
					(5
						(= register 3)
					)
					(6
						(= register 7)
					)
					(7
						(= register 7)
					)
					(8
						(= register 3)
					)
					(9
						(= register 0)
					)
					(10
						(= register 0)
					)
					(11
						(= register 3)
					)
				)
				(= opp (client opponent:))
				(= dmg (if (== register 7) 20 else 50))
				(if register
					(client doDamage: opp dmg 1)
				)
				(= cycles 2)
			)
			(4
				(client setCycle: CT 3 -1 self)
			)
			(5
				(client setLoop: 0 setCycle: Fwd)
				(self changeState: 0)
			)
		)
	)
)

(instance iblisIsFreeS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(djinniPrint 501 7) ; "The last candle! Iblis is free!!"
				(= seconds 3)
			)
			(1
				(ShakeScreen 2 ssLEFTRIGHT)
				(iblisSmoke init: cel: 0 setCycle: End self)
			)
			(2
				(HowHeLost register)
				(gCurRoom newRoom: 790)
			)
		)
	)
)

(instance floor of TargActor
	(properties
		view 501
		loop 11
		signal 16400
	)

	(method (onMe what)
		(return (& (OnControl CONTROL (what x:) (what y:)) $0400))
	)

	(method (hurtMe amount whatHurt &tmp moveScript)
		(if (== (whatHurt type:) 25)
			(HighPrint 501 8) ; "Your tiny flame spell can't ignite these floors. You need fire from another source to stop Ad Avis. (Of course, if you had stayed at WIT, they would have taught you a floor burning spell.)"
		)
	)
)

(instance wall of TargActor
	(properties
		view 501
		loop 11
		signal 16400
	)

	(method (onMe what)
		(return (& (OnControl CONTROL (what x:) (what y:)) $2000))
	)

	(method (hurtMe amount whatHurt &tmp moveScript)
		(switch (whatHurt type:)
			(25
				(HighPrint 501 9) ; "Flame darts don't bounce. But force bolts do."
			)
			(27
				(if (> (gEgo x:) 170)
					(djinniPrint 501 10) ; "Your force bolt lost its energy by the time it struck the wall, Master. Perhaps you'd better get closer."
				else
					((= moveScript (Projectile new:))
						type: (whatHurt type:)
						damage: amount
						xStart: hitX
						yStart: hitY
						x: 124
						y:
							(if (> (gEgo y:) 130)
								102
							else
								(gEgo y:)
							)
					)
					(SetFlag 147)
					(self setScript: moveScript self 0)
				)
				(return 0)
			)
		)
	)
)

(instance comeAndGoS of Script
	(properties)

	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0
				(client show: posn: (gEgo x:) (gEgo y:) setCycle: Fwd)
				(gEgo loop: 3 heading: 0)
				(= cycles (if register register else 9))
			)
			(1
				(client hide:)
				(self dispose:)
			)
		)
	)
)

(instance backInS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(djinniPrint 501 11) ; "Master, I am sorry, but I cannot allow you to leave without Iblis!"
				(if register
					(gEgo setMotion: MoveTo 230 180 self)
				else
					(gEgo setMotion: MoveTo (+ gEgoX 20) gEgoY self)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance getCandleS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo register 0 self)
			)
			(1
				(gEgo
					view: 47
					cel: 0
					loop: (> (gEgo x:) (register x:))
					setCycle: End self
				)
			)
			(2
				(if (> (register xStep:) (gCurRoom notify:))
					(register hide: posn: -10 -10)
					(gCurRoom notify: -2)
					(= register 1)
				else
					(djinniPrint 501 12) ; "You must get an unlit candle to break the spell, Master.  Please stop that man!"
					(= register 0)
				)
				(gEgo setCycle: Beg self)
			)
			(3
				(if register
					(gCurRoom notify: -1)
				)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance kickCandleS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (register x:) (+ (register y:) 3) self
				)
			)
			(1
				(gEgo
					cel: 1
					setMotion:
						MoveTo
						(- (register x:) 18)
						(+ (register y:) 6)
						self
				)
				(cond
					((== (gCurRoom notify:) 5)
						(djinniPrint 501 13) ; "You're too late, Master. We've failed"
						(self dispose:)
					)
					((> (register xStep:) (gCurRoom notify:))
						(register
							setStep: 6 4
							setMotion:
								MoveTo
								(- (register x:) 30)
								(- (register y:) 10)
							setCycle: End
						)
						(= register 1)
						(gCurRoom notify: -2)
					)
					(else
						(gCurRoom notify: -3)
						(= register 0)
					)
				)
			)
			(2
				(if register
					(gCurRoom notify: -1)
				)
				(self dispose:)
			)
		)
	)
)

(instance fightHurtS of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 32 0) ; warrior
					canFight: 0
					action: 7
					setCycle: 0
					setMotion: 0
					setLoop: -1
					loop: 2
					cel: 0
					setCycle: End self
				)
				(if (client respondsTo: #nextMove)
					(client nextMove: 0)
				)
			)
			(1
				(client setCel: 1)
				(= cycles
					(switch gHowFast
						(0 2)
						(1 4)
						(2 6)
						(3 8)
					)
				)
			)
			(2
				((ScriptID 32 0) loop: 1 cel: 1 setCycle: End self) ; warrior
			)
			(3
				((ScriptID 32 0) canFight: 1 action: 0 loop: 0) ; warrior
				(self dispose:)
			)
		)
	)
)

(instance djS of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(dj
					init:
					setLoop: 1
					cel: 0
					setPri: 12
					posn: (+ gEgoX 22) (- gEgoY 23)
					setCycle: End self
				)
			)
			(1
				(dj setLoop: 2 setCycle: Fwd setMotion: MoveTo 159 135 self)
			)
			(2
				(iblisStatue dispose:)
				(Face gEgo dj)
				(Say dj self 501 14) ; "Thank you, Master. Now I can take Iblis back to his tomb where he will be safe for another thousand years and a year."
			)
			(3
				(dj setLoop: 6 cel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(4
				(= seconds 3)
			)
			(5
				(dj setCycle: Beg self)
			)
			(6
				(Say dj self 501 15 501 16 501 17 501 18) ; "I knew I would remember it. The real prophecy is:"
			)
			(7
				(Say dj self 501 19) ; "Bye, bye, Master. It's been fun!"
			)
			(8
				(dj setCycle: End self)
			)
			(9
				(gEgo view: 50 cel: 0 setCycle: End self)
			)
			(10
				(gCurRoom newRoom: 820) ; rmEndCartoon
			)
		)
	)
)

(instance iblisStatue of TargActor
	(properties
		x 159
		y 133
		view 613
	)

	(method (cue)
		(super cue:)
		(djinniPrint 501 20) ; "You are wasting your energies, Master. The Statue of Iblis was created by Suleiman to absorb and contain magic more powerful than yours."
	)

	(method (hurtMe howMuch whatHurt)
		(if (OneOf (whatHurt type:) 25 27)
			(self cue:)
			(self setCycle: Full 1)
			(return 0)
		else
			(djinniPrint 501 21) ; "The statue of Iblis is protected from harm by the Power of Suleiman."
		)
		(return 0)
	)

	(method (detectMe)
		(HighPrint 501 22) ; "You are nearly overwhelmed by the amount of magic in the area."
	)

	(method (fetchMe)
		(self cue:)
		(return 0)
	)

	(method (openMe)
		(self cue:)
	)

	(method (triggerMe)
		(self cue:)
	)
)

(instance iblisSmoke of Prop
	(properties
		x 159
		y 117
		view 502
		priority 9
		signal 16400
		cycleSpeed 3
	)
)

(instance dj of Talker
	(properties
		x 174
		y 120
		description {the djinni}
		lookStr {Do you mind if I'm smoke?}
		view 612
		loop 1
		priority 12
		signal 18448
		cycleSpeed 3
		illegalBits 0
		tLoop 3
		talkSpeed 1
		myName '//djinn'
		title {Djinni:}
		color 1
		back 13
	)
)

(instance moon of PicView
	(properties
		x 158
		y 46
		noun '/moon'
		description {the moon}
		lookStr {The moon is brighter than you have ever seen it.}
		view 507
	)
)

