;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4391)
(include sci.sh)
(use Main)
(use n63002)
(use Array)

(public
	justTalkedToBob 0
)

(local
	local0 = 9
)

(instance justTalkedToBob of IntArray
	(properties)

	(method (init)
		(if data
			(KArray 4 data) ; ArrayFree
		)
		(= data (KArray 0 1 type)) ; ArrayNew
		(self at: 0 gCurRoomNum)
		(gCast add: self)
		(SetFlag 47)
	)

	(method (doit)
		(cond
			((> (self size:) local0)
				(ClearFlag 47)
			)
			((== -1 (self indexOf: gCurRoomNum))
				(self at: (+ (self size:) 1) gCurRoomNum)
			)
		)
	)
)

