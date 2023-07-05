;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 97)
(include sci.sh)
(use Main)
(use n1111)
(use System)

(public
	shiftToRed 0
)

(instance shiftToRed of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (!= register -1) (== (PalVary 2) register)) ; PalVaryInfo
			(= register -1)
			(self cue:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= scratch
					(switch gCurRoomNum
						(2070 ; encounterCloseup
							(switch global411
								(2 39510)
								(3 39210)
							)
						)
						(6005 39510) ; avianLeftShaft3
						(else 39210)
					)
				)
				(Load rsPIC scratch)
				(Load rsPALETTE 95)
				(PalVary 0 95 2 100 0 192) ; PalVaryStart
				(= register 100)
			)
			(1
				(proc1111_6)
				(if global117
					(global117 eachElementDo: #dispose)
				)
				(gCurRoom drawPic: scratch)
				(= cycles 2)
			)
			(2
				(PalVary 1 2 0) ; PalVaryReverse
				(= ticks 120)
			)
			(3
				(gCurRoom newRoom: 95) ; morgue
			)
		)
	)
)

