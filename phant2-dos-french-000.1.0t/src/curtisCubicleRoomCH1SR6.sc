;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4061)
(include sci.sh)
(use Main)
(use WynIniFile)

(public
	curtisCubicleRoomCH1SR6 0
)

(instance curtisCubicleRoomCH1SR6 of WynPostalWare
	(properties
		exitRoom 4021
		docuStoreRm 4051
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

