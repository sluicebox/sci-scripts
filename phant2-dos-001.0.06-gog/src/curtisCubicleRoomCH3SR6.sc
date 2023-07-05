;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4063)
(include sci.sh)
(use Main)
(use WynIniFile)

(public
	curtisCubicleRoomCH3SR6 0
)

(instance curtisCubicleRoomCH3SR6 of WynPostalWare
	(properties
		exitRoom 4023
		docuStoreRm 4053
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

