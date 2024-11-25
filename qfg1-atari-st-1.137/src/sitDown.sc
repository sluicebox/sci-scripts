;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 338)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use System)

(public
	sitDown 0
	getDown 1
)

(instance sitDown of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 338)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 254)
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (> (gEgo x:) 149)
					(gEgo setMotion: MoveTo 163 (gEgo y:) self)
				else
					(gEgo setMotion: MoveTo 134 (gEgo y:) self)
				)
			)
			(1
				(if (> (gEgo x:) 149)
					(gEgo setMotion: MoveTo 163 114 self)
				else
					(gEgo setMotion: MoveTo 134 114 self)
				)
			)
			(2
				(gEgo
					view: 504
					loop: (if (> (gEgo x:) 149) 1 else 0)
					posn: 149 111
					setPri: 9
				)
				(self cue:)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo loop: 2 cel: 0 stopUpd:)
				((ScriptID 331 5) show: setPri: 8) ; head
				(HandsOn)
				(User canControl: 0)
				((ScriptID 331 8) changeState: 6) ; bartenderScript
				(self dispose:)
			)
		)
	)
)

(instance getDown of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 338)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 331 5) hide:) ; head
				(gEgo loop: 1 cel: 7 setCycle: Beg self)
			)
			(1
				(NormalEgo)
				(gEgo
					loop: 2
					cel: 5
					illegalBits: $8000
					setCycle: Walk
					posn: 162 114
				)
				(ClearFlag 254)
				((ScriptID 331 8) changeState: 0) ; bartenderScript
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

