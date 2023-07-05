;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 937)
(include sci.sh)
(use Main)
(use n951)

(public
	flyThrough 0
)

(instance flyThrough of ShiversRoom
	(properties)

	(method (init &tmp [temp0 4])
		(super init: &rest)
		(if (> (gGame detailLevel:) 5)
			(ClearFlag 35)
			(ClearFlag 38)
		else
			(SetFlag 35)
			(SetFlag 38)
		)
		(self playVMD: 900 self)
		(gCurRoom newRoom: 910) ; shiversLogo
	)
)

