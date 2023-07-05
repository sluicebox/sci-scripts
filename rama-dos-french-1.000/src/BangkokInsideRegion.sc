;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 213)
(include sci.sh)
(use Main)
(use RamaRegion)
(use SoundManager)

(public
	BangkokInsideRegion 0
)

(instance BangkokInsideRegion of RamaRegion
	(properties)

	(method (init)
		(if (and (not initialized) (or (== gPrevRoomNum 4000) (== gPrevRoomNum 4002))) ; bkPorch, bkPorchDoor
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 8000)
		)
		(super init: &rest)
		(= global190 1)
	)

	(method (dispose)
		(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 1020)
		(super dispose:)
	)

	(method (setKeep)
		(= keep (or (<= 4003 gNewRoomNum 4230) (== gNewRoomNum 108))) ; bkPuzPorchDoor, bk3MusNWCU3, matrixPuzzle
	)
)

