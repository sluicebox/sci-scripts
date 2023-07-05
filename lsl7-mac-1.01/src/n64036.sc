;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64036)
(include sci.sh)
(use Main)
(use soFlashCyberSniff)
(use Str)
(use File)

(public
	proc64036_0 0
)

(procedure (proc64036_0 &tmp temp0 temp1) ; UNUSED
	(if gVersion
		(proc64896_7 gVersion)
		(= gVersion 0)
	)
	(= temp0 (Str new:))
	(temp0 format: {%s%s} gCurSaveDir {version})
	(if (= temp1 (File new:))
		(temp1 name: (temp0 data:))
		(if (temp1 open: 1)
			(if (= gVersion (Str newWith: 200 {}))
				(temp1 readString: gVersion 199)
			)
			(temp1 close:)
		)
		(temp0 dispose:)
		(temp1 dispose:)
	)
	(if (or (not gVersion) (not (gVersion size:)))
		(= gVersion (Str with: {devel}))
	)
	(DisposeScript 64036)
)

