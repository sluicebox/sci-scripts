;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Array)
(use System)

(public
	sndCode 0
)

(local
	local0
	local1
)

(instance sndCode of Code
	(properties)

	(method (doit)
		(= local0 (IntArray newWith: 4 330 331 332 -1))
		(gGame setScript: soundScr)
	)

	(method (dispose)
		(soundScr dispose:)
		(local0 dispose:)
		(DisposeScript 40)
	)
)

(instance soundScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not state) (== (gGlobalSound0 prevSignal:) 10))
			(gGlobalSound0 prevSignal: 0)
			(if (> (++ local1) 2)
				(= local1 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound0
					number: (local0 at: register)
					loop: -1
					play:
					setVol: 90
				)
			)
			(1
				(gGlobalSound0 fade: 0 10 10 1 self)
			)
			(2
				(if (== (local0 at: (++ register)) -1)
					(= register 0)
				)
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

