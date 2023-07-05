;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 212)
(include sci.sh)
(use Main)
(use RamaRegion)
(use SoundManager)
(use RegionSFX)
(use n1111)

(public
	londonInsideRegion 0
)

(instance londonInsideRegion of RamaRegion
	(properties)

	(method (init)
		(if (not initialized)
			(SoundManager
				fadeMusic: 0 20 10 1 0
				playMusic: 0 -1 3010 3000
				playSounds:
					(sTrashCart_1
						setProx:
							3020
							50
							335
							3027
							50
							335
							3021
							90
							0
							3022
							127
							0
							3030
							127
							270
							108
							127
							45
						yourself:
					)
					(sTrashCart_2
						setProx:
							3020
							50
							335
							3027
							50
							335
							3021
							90
							0
							3022
							127
							0
							3030
							127
							270
							108
							127
							45
						yourself:
					)
					(sTrashCart_3
						setProx:
							3020
							50
							335
							3027
							50
							335
							3021
							90
							0
							3022
							127
							0
							3030
							127
							270
							108
							127
							45
						yourself:
					)
				addSFXLocs:
					(sTrashPit
						owner: self
						setProx: 3033 75 210 3040 127 270
						yourself:
					)
					(sSpider
						owner: self
						setProx: 3067 90 170 3068 90 200 3069 90 135 3062 90 180
						yourself:
					)
			)
		)
		(cond
			((and (== gCurRoomNum 3041) (== gPrevRoomNum 3040)) ; london_21, london_20
				(sTrashPitNoProx owner: self play: 127)
			)
			((and (== gPrevRoomNum 3041) (== gCurRoomNum 3040)) ; london_21, london_20
				(sTrashPitNoProx dispose:)
			)
		)
		(super init: &rest)
		(= global190 5)
	)

	(method (setKeep)
		(= keep
			(or
				(and (not (== gNewRoomNum 3009)) (<= 3002 gNewRoomNum 3071)) ; london_Door_1, london_2, london_Attack
				(== gNewRoomNum 108) ; matrixPuzzle
			)
		)
	)
)

(instance sTrashCart_1 of RegionSFX
	(properties
		number 3200
	)

	(method (pan)
		(super pan: &rest)
		(cond
			((and (== gCurRoomNum 3022) (== ((gCurRoom picObj:) heading:) 0)) ; london_12
				(self setVol: 0)
			)
			((and (== gCurRoomNum 108) (!= gPrevRoomNum 3022)) ; matrixPuzzle, london_12
				(self setVol: 0)
			)
		)
	)
)

(instance sTrashCart_2 of RegionSFX
	(properties
		number 3201
	)

	(method (pan)
		(super pan: &rest)
		(cond
			((and (== gCurRoomNum 3022) (== ((gCurRoom picObj:) heading:) 0)) ; london_12
				(self setVol: 0)
			)
			((and (== gCurRoomNum 108) (!= gPrevRoomNum 3022)) ; matrixPuzzle, london_12
				(self setVol: 0)
			)
		)
	)
)

(instance sTrashCart_3 of RegionSFX
	(properties
		number 3202
	)

	(method (pan)
		(super pan: &rest)
		(cond
			((and (== gCurRoomNum 3022) (== ((gCurRoom picObj:) heading:) 0)) ; london_12
				(self setVol: 0)
			)
			((and (== gCurRoomNum 108) (!= gPrevRoomNum 3022)) ; matrixPuzzle, london_12
				(self setVol: 0)
			)
		)
	)
)

(instance sTrashPit of RegionSFX
	(properties
		number 3203
	)
)

(instance sTrashPitNoProx of RegionSFX
	(properties
		number 3203
		flags 5
	)
)

(instance sSpider of RegionSFX
	(properties
		number 3304
	)

	(method (play)
		(if (proc1111_24 114)
			(super play: &rest)
			(if (== ((gCurRoom picObj:) heading:) 180)
				(self setVol: 0)
			else
				(self setVol: 127)
			)
		)
	)

	(method (pan)
		(super pan: &rest)
		(if (== ((gCurRoom picObj:) heading:) 180)
			(self setVol: 0)
		else
			(self setVol: 127)
		)
	)
)

