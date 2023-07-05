;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4684)
(include sci.sh)
(use Main)
(use n63002)
(use WynIniFile)

(public
	paulsOfficeRoomCH4SR8 0
)

(instance paulsOfficeRoomCH4SR8 of WynSyscon
	(properties
		exitRoom 4644
		docuStoreRm 4664
		postalWareRm 4674
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (setLevel param1)
		(super setLevel: param1 &rest)
		(if (and (== selectedName 2) (== param1 2) (not (SetFlag 763)))
			(= global211 (= global212 1))
			(proc63002_7 6860)
		)
	)
)

