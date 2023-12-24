;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use Combatant)
(use Chase)
(use Avoid)
(use Sound)
(use Motion)
(use System)

(public
	battleSound 0
)

(procedure (walkView whose &tmp theView)
	(return (+ (= theView (- (= theView (whose view:)) (mod theView 5))) 1))
)

(class Monster of Combatant
	(properties
		barX 240
		mode 0
		ateEgo 0
		chaseDelay 0
		attackRange 60
		battleMusic 50
		endMusic 51
		ambushScript 0
		chaseScript 0
	)

	(method (init)
		(if (not (= health gMonsterHealth))
			(= gMonsterHealth (= health (self calcHealth:)))
			(= stamina (self calcStamina:))
			(= mana (self calcMana:))
		)
		(super init: &rest)
		(if (not deathScript)
			(= deathScript dftDeath)
		)
	)

	(method (doit)
		(cond
			((<= health 0)
				(super doit:)
			)
			(dazzleTimer
				(-- dazzleTimer)
				(= calmTimer 0)
			)
			(calmTimer
				(-- calmTimer)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (initCombat)
		(= mode 55)
		(= opponent (ScriptID 32 0)) ; warrior
		(if battleMusic
			(battleSound number: battleMusic loop: -1 priority: 2 playBed:)
		)
		(super initCombat: &rest)
	)

	(method (initAmbush)
		(= mode 52)
		(if (not ambushScript)
			(= ambushScript dftAmbush)
		)
		(self init: &rest setScript: ambushScript)
	)

	(method (initChase monDistance)
		(= mode 53)
		(if (not chaseScript)
			(= chaseScript dftChase)
		)
		(self init: &rest setScript: chaseScript 0 monDistance self)
	)

	(method (dispose)
		(= gMonsterHealth health)
		(if (gSounds contains: battleSound)
			(battleSound stop: dispose:)
			(if (not (IsFlag 159)) ; fPracticeFight
				(gMiscSound
					number: (if (<= health 0) endMusic else 23)
					priority: 6
					loop: 0
					play:
				)
			else
				(ClearFlag 159) ; fPracticeFight
			)
		)
		(super dispose:)
	)

	(method (cue)
		(if (or (== mode 52) (== mode 53))
			(gCurRoom notify: 54)
		else
			(super cue: &rest)
		)
	)

	(method (setStamina amount)
		(super setStamina: amount)
		(if (<= stamina 0)
			(gCurRoom notify: 57)
		)
	)

	(method (die)
		(= mode 58)
		(if opponent
			(opponent canFight: 0)
		)
		(if (and (== gCurRoomNum 665) (!= gMonsterNum 655)) ; desert
			(self setScript: dieInCombat)
		else
			(super die:)
		)
	)

	(method (searchMe)
		(HighPrint 31 0) ; "Sorry about that. The monster is dead broke."
		(return 0)
	)

	(method (calmMe)
		(if (== mode 55)
			(+= calmTimer (/ [gEgoStats 24] 2)) ; calmSpell
		else
			(+= calmTimer [gEgoStats 24]) ; calmSpell
		)
	)

	(method (dazzleMe)
		(if (== mode 55)
			(+= dazzleTimer (/ [gEgoStats 22] 4)) ; dazzleSpell
		else
			(+= dazzleTimer (/ (* [gEgoStats 22] 2) 3)) ; dazzleSpell
		)
	)
)

(instance battleSound of Sound
	(properties
		priority 5
		loop -1
	)
)

(instance dftAmbush of Script
	(properties)

	(method (changeState newState &tmp monX monY)
		(switch (= state newState)
			(0
				(client hide:)
				(if gCantMove
					(= cycles 10)
				else
					(self changeState: 2)
				)
			)
			(1
				(self changeState: 0)
			)
			(2
				(= cycles 1)
			)
			(3
				(= monX (if (< (gEgo x:) 160) 350 else -30))
				(= monY 165)
				(client
					view: (walkView client)
					posn: monX monY
					setCycle: Walk
					show:
					setAvoider: Avoid
					setMotion: Chase gEgo (client attackRange:) client
				)
				(self dispose:)
			)
		)
	)
)

(instance dftChase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: (walkView client) illegalBits: 0 ignoreActors:)
				(if register
					(client
						posn:
							(if (> (gEgo x:) 160) -30 else 350)
							(gEgo y:)
						hide:
						setMotion: 0
					)
					(= cycles (* 6 (+ (client chaseDelay:) (/ register 40))))
				else
					(= cycles 8)
				)
			)
			(1
				(client
					show:
					illegalBits: -32768
					ignoreActors: 0
					setCycle: Walk
				)
				(= cycles 1)
			)
			(2
				(client
					setCycle: Walk
					setAvoider: Avoid
					setMotion: Chase gEgo (client attackRange:) client
				)
				(self dispose:)
			)
		)
	)
)

(instance dftDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					canFight: 0
					action: 0
					setLoop: 2
					setCel: 0
					cycleSpeed: 0
				)
				(= cycles 2)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(self dispose:)
				(gCurRoom notify: 58)
			)
		)
	)
)

(instance dieInCombat of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo script:)
					(= cycles 1)
				else
					(= gMonsterHealth 0)
					(gCurRoom newRoom: 666) ; rmCombat
				)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

