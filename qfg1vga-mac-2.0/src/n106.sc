;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 106)
(include sci.sh)
(use Main)
(use n814)
(use Sound)
(use Motion)
(use System)

(public
	CastDazzle 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (CastDazzle param1 param2)
	(if (not global102)
		(= local5 1)
	)
	(cond
		((< 1 argc)
			(param1 setScript: clientCastDazz param2)
		)
		(argc
			(param1 setScript: clientCastDazz)
		)
		(else
			(gEgo setScript: clientCastDazz)
		)
	)
)

(instance clientCastDazz of Script
	(properties)

	(method (dispose)
		(local4 stop: dispose:)
		(NormalEgo)
		(if local5
			(HandsOn)
		)
		(gEgo
			loop: (if (== (gEgo loop:) 4) 5 else 4)
			priority: local1
			illegalBits: local2
			signal: local0
			cycleSpeed: local3
		)
		(super dispose:)
		(DisposeScript 106)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 30)
			)
			(1
				(= local0 (gEgo signal:))
				(= local1 (gEgo priority:))
				(= local2 (gEgo illegalBits:))
				(= local3 (gEgo cycleSpeed:))
				(gEgo
					setMotion: 0
					setHeading:
						(if (OneOf (gEgo loop:) 2 4 0 6) 135 else 225)
						self
				)
			)
			(2
				(gGame setCursor: gWaitCursor 1)
				(gEgo
					view: 521
					setLoop: (if (== (gEgo loop:) 5) 4 else 5)
					cel: 0
					cycleSpeed: 4
					setCycle: End self
				)
				((= local4 (Sound new:)) number: 2017 priority: 6 init: play:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

