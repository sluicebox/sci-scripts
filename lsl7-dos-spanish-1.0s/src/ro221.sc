;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 221)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use System)

(public
	ro221 0
)

(instance ro221 of L7Room
	(properties)

	(method (init)
		(super init:)
		(gOMusic1 setMusic: 0)
		(gGame handsOn:)
		(gCurRoom setScript: soOpera)
	)

	(method (gimme))
)

(instance soOpera of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(PlayVMD 0 {14.vmd}) ; Open
				(if (< global294 1600)
					(PlayVMD 1 0 0 21 18 0 10000) ; Put
				else
					(PlayVMD 1 0 0 1) ; Put
				)
				(PlayVMD 14 1) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 3)
			)
			(1
				(gCurRoom newRoom: 222) ; ro222
			)
		)
	)
)

