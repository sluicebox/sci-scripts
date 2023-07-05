;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64036)
(include sci.sh)
(use Main)
(use n64896)
(use Str)
(use File)

(public
	SetVersionString 0
)

(procedure (SetVersionString &tmp oFileName oVersionFile)
	(if gVersion
		(StringDispose gVersion)
		(= gVersion 0)
	)
	(= oFileName (Str new:))
	(oFileName format: {%s%s} gCurSaveDir {version})
	(if (= oVersionFile (File new:))
		(oVersionFile name: (oFileName data:))
		(if (oVersionFile open: 1)
			(if (= gVersion (Str newWith: 200 {}))
				(oVersionFile readString: gVersion 199)
			)
			(oVersionFile close:)
		)
		(oFileName dispose:)
		(oVersionFile dispose:)
	)
	(if (or (not gVersion) (not (gVersion size:)))
		(= gVersion (Str with: {devel}))
	)
	(DisposeScript 64036)
)

