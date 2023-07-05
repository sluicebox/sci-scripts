;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4675)
(include sci.sh)
(use Main)
(use WynIniFile)

(public
	paulsOfficeRoomCH5SR7 0
)

(instance paulsOfficeRoomCH5SR7 of WynPostalWare
	(properties
		exitRoom 4645
		whichComp 1
		docuStoreRm 4665
		sysconRm 4685
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

