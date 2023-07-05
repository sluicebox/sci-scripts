;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 807)
(include sci.sh)
(use Motion)
(use Actor)

(class SoundSyncWave of Prop
	(properties
		signal 16896
		sound 0
		lastPrevSignal 0
	)

	(method (init param1)
		(super init:)
		(if argc
			(= sound param1)
		)
	)

	(method (doit)
		(super doit:)
		(if (!= (sound prevSignal:) lastPrevSignal)
			(self setCycle: End self lastPrevSignal: (sound prevSignal:))
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

