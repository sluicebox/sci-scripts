;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 209)
(include sci.sh)
(use Main)
(use RamaRegion)
(use SaveManager)
(use SoundManager)
(use RegionSFX)
(use n1111)
(use System)

(public
	londonRegion 0
)

(local
	[local0 21] = [100 -25 60 -20 50 -15 110 -10 40 -5 120 -30 60 -30 60 -30 60 32767 -100 32767 0]
)

(class LondonRegion of RamaRegion
	(properties
		beamStatus 1
	)

	(method (init)
		(if (not initialized)
			(sRayBarrier
				owner: self
				setProx: 2060 30 0 2061 60 0 2062 60 180 3001 30 225
			)
			(SoundManager
				addSFXLocs: sRayBarrier
				playSounds:
					((RegionSFX new:) number: 1050 setVol: 40 yourself:)
					((RegionSFX new:) number: 1051 setVol: 50 yourself:)
					((RegionSFX new:) number: 1052 setVol: 50 yourself:)
			)
			(if (== gPrevRoomNum 3002) ; london_2
				(SoundManager fadeMusic: 0 20 10 1 0)
			)
		)
		(if (and (not (IsFlag 51)) (== gPrevRoomNum 2000)) ; cplains
			(SoundManager fadeMusic:)
		)
		(if (and (IsFlag 51) (!= (SoundManager musicNum:) 1020))
			(SoundManager fadeMusic: 0 20 10 1 0 playMusic: 0 -1 1020)
		)
		(super init: &rest)
		(self setScript: beamScript)
		(= global190 15)
	)

	(method (dispose)
		(SoundManager stopSounds: deleteSFXLoc: sRayBarrier)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(137
				(sRayBarrier pause: 0)
			)
			(138
				(sRayBarrier pause: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (setKeep)
		(= keep
			(or
				(<= 2060 gNewRoomNum 2065) ; CPLondon1, CPLondon6
				(OneOf gNewRoomNum 3001 3009) ; london_1, london_Door_1
				(== gNewRoomNum 108) ; matrixPuzzle
			)
		)
	)

	(method (serialize param1)
		(if (and argc param1)
			(super serialize: param1 &rest)
			(self beamStatus: (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: beamStatus)
		)
	)
)

(instance londonRegion of LondonRegion
	(properties)
)

(instance beamScript of Script
	(properties
		register -1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(londonRegion beamStatus: 1)
				(= cycles 3)
			)
			(1
				(if (== [local0 register] 32767)
					(londonRegion beamStatus: (not (londonRegion beamStatus:)))
					(++ register)
				)
				(if (== [local0 register] 0)
					(= register 0)
				)
				(if (and gCurRoom (== gCurRoomNum gNewRoomNum) (not (IsFlag 117)))
					(if (> [local0 register] 0)
						(gCurRoom doVerb: 137)
					else
						(gCurRoom doVerb: 138)
					)
				)
				(-- state)
				(= ticks (Abs [local0 register]))
				(++ register)
			)
		)
	)
)

(instance sRayBarrier of RegionSFX
	(properties
		flags 5
		number 2060
	)

	(method (play)
		(if (IsFlag 117)
			(return)
		)
		(super play: &rest)
	)

	(method (pause param1)
		(if param1
			(self stop:)
		else
			(self play:)
		)
	)
)

