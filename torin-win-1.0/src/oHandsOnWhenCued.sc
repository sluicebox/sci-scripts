;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64020)
(include sci.sh)
(use Main)
(use ClickThrough)
(use CueMe)
(use Game)
(use System)

(public
	oHandsOnWhenCued 0
)

(class TPRoom of Room
	(properties
		oBoogleFeatures 0
		oExtraPlanes 0
		oMainPlane 0
	)

	(method (init)
		(if gCuees
			(gCuees release: dispose:)
			(= gCuees 0)
		)
		(super init: &rest)
		(Palette 1 999) ; PalLoad
		(switch gnChapter
			(1
				(Palette 1 10000) ; PalLoad
			)
			(2
				(Palette 1 20000) ; PalLoad
			)
			(3
				(Palette 1 30000) ; PalLoad
			)
			(4
				(Palette 1 40000) ; PalLoad
			)
			(5
				(Palette 1 50000) ; PalLoad
			)
		)
		(Palette 2 0 235 100) ; PalIntensity
		(RemapColors 2 238 25) ; ByPercent
		(RemapColors 2 237 45) ; ByPercent
		(RemapColors 2 236 75) ; ByPercent
		(RemapColors 2 240 150) ; ByPercent
		(= gtTorin 0)
		(= gtArchivist 0)
		(= gtSmetana 0)
		(= gtLeenah 0)
		(= gtViscera 0)
		(= gtTripe 0)
		(= gtSam 0)
		(= gtMax 0)
		(= gtVeder 0)
		(= gtKurtzwell 0)
		(= gtSoldier 0)
		(= gtPecand 0)
		(= gtLycentia 0)
		(= gtDreep 0)
		(= gtCop 0)
		(= gtArcher 0)
		(= gtCarpenter 0)
		(= gtMrsBitter 0)
		(= gtBobbyBitter 0)
		(= gtKing 0)
		(= gtQueen 0)
		(= gtQueenToKing 0)
		(= gtKingDi 0)
		(= gtPhace 0)
		(= gtZippy 0)
		(= gtTree 0)
	)

	(method (dispose &tmp oPlaneTmp)
		(if oBoogleFeatures
			(oBoogleFeatures dispose:)
			(= oBoogleFeatures 0)
		)
		(if oExtraPlanes
			(while (oExtraPlanes size:)
				(= oPlaneTmp (oExtraPlanes at: 0))
				(self deleteRoomPlane: oPlaneTmp)
			)
			(oExtraPlanes dispose:)
			(= oExtraPlanes 0)
		)
		((ScriptID 64002 4) disable: setScript: 0) ; oRewind
		((ScriptID 64002 6) disable: setScript: 0) ; oFastForward
		(super dispose: &rest)
	)

	(method (addRoomPlane oPlane &tmp oOldPlane nOldPri)
		(if (or (not argc) (not oPlane))
			(return)
		)
		(= oOldPlane plane)
		(= nOldPri (plane priority:))
		(gCurRoom plane: oPlane)
		(if (not oExtraPlanes)
			(= oExtraPlanes (Set new:))
		)
		(oExtraPlanes addToEnd: oPlane)
		(if (not oMainPlane)
			(= oMainPlane oOldPlane)
		)
		(oOldPlane disable:)
		(oPlane init: setPri: (++ nOldPri))
	)

	(method (deleteRoomPlane oPlane)
		(if (or (not argc) (not oPlane) (not oExtraPlanes) (not oMainPlane))
			(return)
		)
		(oExtraPlanes delete: oPlane)
		(if (== oPlane plane)
			(if (oExtraPlanes size:)
				(= plane (KList 8 (oExtraPlanes last:))) ; NodeValue
			else
				(= plane oMainPlane)
				(= oMainPlane 0)
			)
			(plane enable:)
		)
		(oPlane dispose:)
	)

	(method (addBoogleFeature)
		(if (not oBoogleFeatures)
			(= oBoogleFeatures (Set new:))
		)
		(oBoogleFeatures add: &rest)
	)

	(method (delBoogleFeature)
		(if oBoogleFeatures
			(oBoogleFeatures delete: &rest)
			(if (== (oBoogleFeatures size:) 0)
				(oBoogleFeatures dispose:)
				(= oBoogleFeatures 0)
			)
		)
	)

	(method (gimme))

	(method (showHelp)
		(ClickHelp)
	)
)

(instance oHandsOnWhenCued of CueMe
	(properties)

	(method (cue)
		(gGame handsOn:)
	)
)

