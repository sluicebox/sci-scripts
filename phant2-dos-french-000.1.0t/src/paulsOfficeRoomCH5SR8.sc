;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4685)
(include sci.sh)
(use Main)
(use WynIniFile)

(public
	paulsOfficeRoomCH5SR8 0
)

(instance paulsOfficeRoomCH5SR8 of WynSyscon
	(properties
		exitRoom 4645
		docuStoreRm 4665
		postalWareRm 4675
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

