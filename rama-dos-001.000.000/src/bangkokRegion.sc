;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 206)
(include sci.sh)
(use Main)
(use RamaRegion)
(use SoundManager)

(public
	bangkokRegion 0
)

(instance bangkokRegion of RamaRegion
	(properties)

	(method (init)
		(super init: &rest)
		(if (or (== gPrevRoomNum 2000) (<= 4003 gPrevRoomNum 4230)) ; cplains, bkPuzPorchDoor, bk3MusNWCU3
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 1020)
		)
		(= global190 14)
	)

	(method (setKeep)
		(= keep
			(or
				(<= 2080 gNewRoomNum 2082) ; CPBangkok1, CPBangkok3
				(== gNewRoomNum 4000) ; bkPorch
				(== gNewRoomNum 4002) ; bkPorchDoor
				(== gNewRoomNum 108) ; matrixPuzzle
			)
		)
	)
)

