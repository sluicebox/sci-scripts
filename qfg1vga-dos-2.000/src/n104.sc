;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use n814)
(use Sound)
(use Motion)
(use System)

(public
	CastCalm 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (CastCalm param1 param2)
	(if (not global102)
		(= local5 1)
	)
	(switch argc
		(0
			(gEgo setScript: castCalm)
		)
		(1
			(param1 setScript: castCalm)
		)
		(else
			(param1 setScript: castCalm param2)
		)
	)
)

(instance castCalm of Script
	(properties)

	(method (dispose)
		(local4 stop: dispose:)
		(NormalEgo)
		(if local5
			(HandsOn)
		)
		(gEgo
			loop: (if (== (gEgo loop:) 2) 5 else 4)
			priority: local1
			illegalBits: local2
			cycleSpeed: local3
			signal: local0
		)
		(super dispose:)
		(DisposeScript 104)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 10)
			)
			(1
				((= local4 (Sound new:))
					number: (SoundFX 39)
					priority: 6
					init:
				)
				(= local0 (gEgo signal:))
				(= local1 (gEgo priority:))
				(= local2 (gEgo illegalBits:))
				(= local3 (gEgo cycleSpeed:))
				(HandsOff)
				(NormalEgo)
				(gGame setCursor: gWaitCursor 1)
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
					setLoop: (if (== (gEgo loop:) 5) 2 else 3)
					setCel: 0
					setPri: (gEgo priority:)
					cycleSpeed: 12
					setCycle: End self
				)
				(local4 play:)
			)
			(3
				(gMessager say: 1 0 0 0 0 558) ; "Suddenly a feeling of peace and tranquility permeates the area."
				(= ticks 12)
			)
			(4
				(self dispose:)
			)
		)
	)
)

