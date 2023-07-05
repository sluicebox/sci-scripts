;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 106)
(include sci.sh)
(use Main)
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
)

(procedure (CastDazzle param1 param2)
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
		(HandsOn)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (gEgo signal:))
				(= local1 (gEgo priority:))
				(= local2 (gEgo illegalBits:))
				(HandsOff)
				(gEgo
					view: 521
					setLoop:
						(if (or (== (gEgo loop:) 1) (== (gEgo loop:) 3))
							2
						else
							3
						)
				)
				((= local3 (Sound new:))
					number: (SoundFX 17)
					priority: 6
					init:
					play:
				)
				(gEgo cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(1
				(= cycles 2)
			)
			(2
				(local3 stop: dispose:)
				(NormalEgo)
				(gEgo
					loop: 2
					priority: local1
					illegalBits: local2
					signal: local0
				)
				(self dispose:)
			)
		)
	)
)

