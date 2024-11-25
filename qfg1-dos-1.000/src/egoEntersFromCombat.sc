;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 274)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	egoEntersFromCombat 0
)

(instance egoEntersFromCombat of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 274)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 181 158 self)
				((ScriptID 93 1) ; minotaur
					ignoreActors:
					setPri: 9
					cycleSpeed: 4
					setCycle: End
				)
			)
			(1
				(gEgo loop: 2)
				(= cycles 2)
			)
			(2
				(gEgo
					view: 519
					setLoop: 0
					setCel: 0
					posn: (- (gEgo x:) 3) (+ (gEgo y:) 8)
				)
				(TimePrint 4 274 0) ; "I'M BAAD!"
				(= seconds 4)
			)
			(3
				((ScriptID 93 0) notify: 0) ; rm93
				(NormalEgo)
				(HandsOn)
				(gEgo loop: 2 posn: (+ (gEgo x:) 3) (- (gEgo y:) 8))
				(if (IsFlag 238)
					(gEgo illegalBits: $c000)
				else
					(gEgo illegalBits: $e000)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

