;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 207)
(include sci.sh)
(use Main)
(use RamaRegion)
(use VidmailChoices)
(use InvInitialize)
(use SoundManager)
(use RegionSFX)
(use n1111)
(use System)

(public
	beamRegion 0
)

(instance beamRegion of RamaRegion
	(properties)

	(method (init)
		(if
			(or
				(IsFlag 67)
				(and
					(== (proc70_9 21) -1)
					(not (proc55_5 22))
					(not (IsFlag 121))
				)
			)
			(SetFlag 64)
		)
		(cond
			((not initialized)
				(if (not (IsFlag 119))
					(sSpiderBiot
						owner: self
						setProx:
							2042
							27
							45
							2055
							27
							45
							2045
							27
							90
							2046
							34
							110
							2047
							64
							180
							2052
							80
							180
							2053
							100
							180
							2054
							127
							180
					)
					(SoundManager addSFXLocs: sSpiderBiot)
				)
				(sSharkBiot
					owner: self
					setProx: 2052 60 165 2053 90 135 2054 127 90
				)
				(SoundManager
					addSFXLocs: sSharkBiot
					playSounds:
						((RegionSFX new:) number: 1050 setVol: 40 yourself:)
						((RegionSFX new:) number: 1051 setVol: 50 yourself:)
						((RegionSFX new:) number: 1052 setVol: 50 yourself:)
					fadeMusic: 0 10 8 1 0
					playMusic: 0 -1 1020
				)
			)
			((and (== gCurRoomNum 2052) (== gPrevRoomNum 2047)) ; BiotHanger1, BeamRgn8
				(SoundManager stopSounds:)
			)
			((and (== gCurRoomNum 2047) (== gPrevRoomNum 2052)) ; BeamRgn8, BiotHanger1
				(SoundManager
					playSounds:
						((RegionSFX new:) number: 1050 setVol: 40 yourself:)
						((RegionSFX new:) number: 1051 setVol: 50 yourself:)
						((RegionSFX new:) number: 1052 setVol: 50 yourself:)
				)
			)
		)
		(super init: &rest)
		(= global190 3)
	)

	(method (setKeep)
		(= keep (<= 2040 gNewRoomNum 2055)) ; BeamRgn1, trashBin
	)
)

(instance sSharkBiot of RegionSFX
	(properties
		number 2050
	)

	(method (pan)
		(super pan: &rest)
		(if (OneOf gCurRoomNum 2054) ; BiotHanger3
			(self pause: (== ((gCurRoom picObj:) heading:) 90))
		)
	)
)

(instance sSpiderBiot of RegionSFX
	(properties
		number 2040
	)

	(method (pan)
		(super pan: &rest)
		(if (OneOf gCurRoomNum 2052 2053 2054 2047) ; BiotHanger1, BiotHanger2, BiotHanger3, BeamRgn8
			(self pause: (== ((gCurRoom picObj:) heading:) 180))
		)
	)
)

