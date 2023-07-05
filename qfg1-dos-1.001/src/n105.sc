;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use System)

(public
	CastOpen 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (CastOpen param1 param2 &tmp temp0 temp1)
	(= temp0 gEgo)
	(= temp1 0)
	(if argc
		(if (> argc 1)
			(= temp1 param2)
		)
		(= temp0 param1)
	)
	(temp0 setScript: clientCastOpen temp1)
)

(instance clientCastOpen of Script
	(properties)

	(method (dispose)
		(HandsOn)
		(super dispose:)
		(DisposeScript 105)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
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
			)
			(2
				((= local3 (Sound new:))
					number: (SoundFX 35)
					priority: 6
					init:
					play:
				)
				(= cycles 3)
			)
			(3
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

