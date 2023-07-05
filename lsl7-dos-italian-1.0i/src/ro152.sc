;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 152)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use NewUser)
(use System)

(public
	ro152 0
)

(instance ro152 of L7Room
	(properties)

	(method (init)
		(super init:)
		(gCurRoom setScript: soEndMovie)
	)
)

(instance soEndMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PlayVMD 0 {13.vmd}) ; Open
				(if (< global294 1600)
					(PlayVMD 1 0 0 21 18 0 10000) ; Put
				else
					(PlayVMD 1 0 0 1) ; Put
				)
				(PlayVMD 14 1) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 1)
			)
			(1
				(Palette 1 100) ; PalLoad
				(Palette 1 999) ; PalLoad
				((ScriptID 64000 6) doSelect:) ; moScore
				(= cycles 1)
			)
			(2
				(gOEventHandler registerGlobalHandler: oEventHandler)
				(gCurRoom drawPic: 16000)
				(= ticks 600)
			)
			(3
				(gCurRoom drawPic: 16500)
				(= ticks 180)
			)
			(4
				(= gQuit 1)
				(self dispose:)
			)
		)
	)
)

(instance oEventHandler of EventCode
	(properties)

	(method (handleEvent event)
		(if (or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD))
			(event claimed: 1)
			(gOEventHandler unregisterGlobalHandler: self)
			(soEndMovie ticks: 0 cue:)
		)
		(event claimed:)
	)
)

