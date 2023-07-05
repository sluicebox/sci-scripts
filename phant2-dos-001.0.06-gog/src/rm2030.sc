;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42030)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)

(public
	rm2030 0
)

(instance rm2030 of P2Room
	(properties
		picture 2031
		north 42020
		south 42020
		east 42020
		west 42020
	)

	(method (init)
		(cond
			((or (not (IsFlag 725)) (IsFlag 715))
				(= picture 2031)
			)
			((and (IsFlag 713) (IsFlag 724))
				(screen init: 151 137 420 276)
				(if (== gPrevRoomNum 42032)
					(gP2SongPlyr fadeIn: 10505)
					((ScriptID 0 6) start: 3 1) ; thunderTimer
				)
				(= picture 2030)
			)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance screen of P2Feature
	(properties
		nextRoom 42032
	)
)

