;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 143)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(public
	catchIt 0
	missIt 1
)

(local
	local0
)

(instance catchIt of Script
	(properties)

	(method (dispose)
		(ClearFlag 103)
		((ScriptID 140 0) dispose: delete:) ; lizard
		(super dispose:)
		(DisposeScript 143)
		(DisposeScript 140)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (gEgo cycler:))
				(gEgo cycler: 0)
				((ScriptID 140 0) ; lizard
					setMotion:
						MoveTo
						(+ (gEgo x:) 38)
						(- (gEgo y:) 3)
						self
				)
			)
			(1
				(gEgo view: 39 setLoop: 0 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(= cycles 5)
			)
			(3
				((ScriptID 140 0) hide:) ; lizard
				(gEgo setLoop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(4
				(gEgo cel: 3)
				((ScriptID 140 0) ; lizard
					view: 39
					setLoop: 1
					posn: (+ (gEgo x:) 11) (- (gEgo y:) 27)
					setPri: (+ (gEgo priority:) 1)
					show:
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= cycles 10)
			)
			(5
				((ScriptID 140 0) setCycle: 0 hide:) ; lizard
				(gEgo setLoop: 3 cel: 0 setCycle: CT 1 1 self)
			)
			(6
				(gEgo cel: 2)
				((ScriptID 140 0) ; lizard
					setLoop: 4
					setPri: (+ (gEgo priority:) 1)
					posn: (+ (gEgo x:) 4) (- (gEgo y:) 45)
					show:
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(7
				((ScriptID 140 0) hide:) ; lizard
				(gEgo setLoop: 5 cel: 0 setCycle: End self)
			)
			(8
				(gEgo view: 57 setLoop: -1 cycleSpeed: 0 cycler: local0)
				(+= global204 2000)
				(= cycles 2)
			)
			(9
				(if (IsFlag 97)
					(Print 143 0) ; "Survival is more important than good taste, Arthur."
				else
					(Print 143 1) ; "That was rather revolting, but at least the lizard's blood has revived you a tiny bit."
				)
				(ClearFlag 85)
				(ClearFlag 98)
				(SetFlag 97)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance missIt of Script
	(properties)

	(method (dispose)
		(ClearFlag 103)
		((ScriptID 140 0) dispose: delete:) ; lizard
		(super dispose:)
		(DisposeScript 143)
		(DisposeScript 140)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (gEgo cycler:))
				(gEgo cycler: 0)
				((ScriptID 140 0) ; lizard
					setMotion:
						MoveTo
						(+ (gEgo x:) 11)
						(- (gEgo y:) 13)
						self
				)
			)
			(1
				((ScriptID 140 0) setMotion: MoveTo 325 ((ScriptID 140 0) y:)) ; lizard, lizard
				(gEgo view: 39 setLoop: 0 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(Print 143 2) ; "The lizard slipped past you."
				(= cycles 5)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 57 setLoop: -1 cycleSpeed: 0 cycler: local0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

