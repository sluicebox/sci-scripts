;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use n011)
(use northExit)

(public
	policeRm 0
)

(instance policeRm of ExitRoom ; "Polizei Station Lobby"
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(PlayScene 113 0 200) ; MunichMapRm
	)
)

