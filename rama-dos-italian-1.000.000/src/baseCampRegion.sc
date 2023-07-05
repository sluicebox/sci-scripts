;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 211)
(include sci.sh)
(use Main)
(use RamaRegion)
(use SoundManager)
(use RegionSFX)

(public
	baseCampRegion 0
)

(instance baseCampRegion of RamaRegion
	(properties)

	(method (init)
		(if (not initialized)
			(sFridge
				owner: self
				setProx:
					2006
					100
					180
					2007
					100
					100
					2004
					70
					160
					2005
					40
					110
					2003
					35
					170
					2008
					70
					90
			)
			(SoundManager
				addSFXLocs: sFridge
				playSounds:
					((RegionSFX new:) number: 1050 setVol: 40 yourself:)
					((RegionSFX new:) number: 1051 setVol: 50 yourself:)
					((RegionSFX new:) number: 1052 setVol: 50 yourself:)
			)
		)
		(super init: &rest)
		(= global190 2)
	)

	(method (setKeep)
		(= keep (<= 2001 gNewRoomNum 2009)) ; baseCampTent1, baseCampTable
	)
)

(instance sFridge of RegionSFX
	(properties
		number 2010
	)
)

