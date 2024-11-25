;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 277)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	climbWestCliff 0
)

(local
	local0
)

(instance climbWestCliff of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 277)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 93 0) notify: 2) ; rm93
				(HandsOff)
				(= local0 1)
				(gEgo illegalBits: 0 setPri: 6 setMotion: MoveTo 78 99 self)
			)
			(1
				(gEgo setLoop: 1 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: MoveTo 71 96 self)
			)
			(3
				(gEgo setMotion: MoveTo 64 90 self)
			)
			(4
				(gEgo setMotion: MoveTo 57 84 self)
			)
			(5
				(gEgo setMotion: MoveTo 54 78 self)
			)
			(6
				(gEgo setMotion: MoveTo 76 99 self)
			)
			(7
				(if local0
					(= local0 0)
					(self changeState: 2)
				else
					(self changeState: 8)
				)
			)
			(8
				(HighPrint 277 0) ; "The dirt is too loose for climbing here."
				(gEgo setMotion: MoveTo 86 99 self)
			)
			(9
				(NormalEgo)
				(gEgo loop: 2)
				(if (IsFlag 238)
					(gEgo illegalBits: $8000)
				else
					(gEgo illegalBits: $9000)
				)
				(HandsOn)
				((ScriptID 93 0) notify: 3) ; rm93
				(self dispose:)
			)
		)
	)
)

