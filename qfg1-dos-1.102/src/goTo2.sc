;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 228)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use System)

(public
	goTo2 0
	goTo6 1
	goTo12 2
	goTo15 3
)

(procedure (localproc_0)
	(switch (++ global114)
		(1
			(HighPrint 228 0) ; "You feel disoriented."
		)
		(2
			(HighPrint 228 1) ; "How does he DO this?"
		)
		(3
			(HighPrint 228 2) ; "There's an ECHO IN HERE...Echo In Here...echo in here..."
		)
		(4
			(HighPrint 228 3) ; "M. C. Escher would LOVE this place."
		)
		(5
			(HighPrint 228 4) ; "OK, enough fooling around!"
		)
		(6
			(HighPrint 228 5) ; "This is getting old!"
		)
		(7
			(HighPrint 228 6) ; "A person COULD get used to this."
		)
	)
)

(instance goTo2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 228)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(localproc_0)
				(= cycles 10)
			)
			(2
				(gEgo
					setPri: 7
					illegalBits: 0
					posn: 22 73
					setMotion: MoveTo 37 73 self
				)
			)
			(3
				(HandsOn)
				(gEgo illegalBits: -32768)
				(ClearFlag 263)
				(client setScript: 0)
			)
		)
	)
)

(instance goTo6 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 228)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setLoop: 3
					setMotion: MoveTo 215 97 self
				)
			)
			(1
				(gEgo setPri: 3 setMotion: MoveTo 194 83 self)
			)
			(2
				((ScriptID 96 9) setCycle: Beg self) ; door11
			)
			(3
				(localproc_0)
				(NormalEgo)
				((ScriptID 96 9) stopUpd:) ; door11
				(gEgo posn: 49 102 setMotion: MoveTo 87 102 self)
			)
			(4
				(HandsOn)
				(User canInput: 1)
				(ClearFlag 263)
				(client setScript: 0)
			)
		)
	)
)

(instance goTo12 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 228)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (- (gEgo x:) 25) (gEgo y:) self
				)
			)
			(1
				(localproc_0)
				((ScriptID 96 10) setCycle: Beg self) ; door12
			)
			(2
				(gEgo
					view: 296
					setLoop: 8
					cel: 0
					posn: 265 102
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 234 102 self
				)
			)
			(3
				(gEgo setLoop: 9 setCel: 0 posn: 231 101)
				(= cycles 3)
			)
			(4
				(gEgo setLoop: 1)
				(NormalEgo)
				((ScriptID 96 10) setCycle: End self) ; door12
			)
			(5
				(HandsOn)
				(SetFlag 267)
				(ClearFlag 263)
				(client setScript: 0)
			)
		)
	)
)

(instance goTo15 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 228)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (- (gEgo x:) 15) (gEgo y:) self
				)
			)
			(1
				(localproc_0)
				(gEgo posn: 325 129 setMotion: MoveTo 281 129 self)
			)
			(2
				(if (IsFlag 259)
					(SetFlag 267)
				)
				(NormalEgo)
				(HandsOn)
				(ClearFlag 263)
				(client setScript: 0)
			)
		)
	)
)

