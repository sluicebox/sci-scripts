;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33300)
(include sci.sh)
(use Main)
(use movieScr)
(use n1111)
(use System)

(public
	rm33300 0
)

(instance rm33300 of ScaryRoom
	(properties
		stepSound 4
	)

	(method (init)
		(proc1111_6)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
		)
		(super init: &rest)
		(SetFlag 206)
		(gCurRoom setScript: sChap6)
	)
)

(instance sChap6 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame getDisc: 5 1)
					(PlayVMD 0 {5710.vmd} 0) ; Open
					(proc26_0 5710 self)
				)
				(1
					(= cycles 2)
				)
				(2
					(gGame getDisc: 6 1)
					(= cycles 2)
				)
				(3
					(gCurRoom newRoom: 33100)
				)
			)
		else
			(switch (= state newState)
				(0
					(SetFlag 206)
					((ScriptID 26 1) caller: 0) ; movieScr
					(= global115 0)
					(gCurRoom newRoom: 33100)
				)
			)
		)
	)
)

