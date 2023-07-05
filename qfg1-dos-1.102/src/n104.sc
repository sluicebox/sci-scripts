;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
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
)

(procedure (CastCalm param1 param2)
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
		(local3 stop: dispose:)
		(NormalEgo)
		(HandsOn)
		(gEgo loop: 2 priority: local1 illegalBits: local2 signal: local0)
		(super dispose:)
		(DisposeScript 104)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local3 (Sound new:)) number: (SoundFX 39) priority: 6 init:)
				(= local0 (gEgo signal:))
				(= local1 (gEgo priority:))
				(= local2 (gEgo illegalBits:))
				(HandsOff)
				(NormalEgo)
				(gEgo setLoop: 2)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 521
					setLoop: 1
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(local3 play:)
			)
			(2
				(TimePrint 6 104 0) ; "Suddenly a feeling of peace and tranquility permeates the area."
				(= seconds 6)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

