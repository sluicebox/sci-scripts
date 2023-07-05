;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use SQRoom)
(use SpeedTest)
(use LoadMany)

(public
	speedRoom 0
)

(instance speedRoom of SQRoom
	(properties)

	(method (init)
		(LoadMany rsVIEW 64980)
		(super init:)
		(cond
			((<= (= gHowFast (SpeedTest)) 3)
				(= global158 3)
			)
			((<= gHowFast 5)
				(= global158 4)
			)
			((<= gHowFast 6)
				(= global158 3)
			)
			((<= gHowFast 7)
				(= global158 2)
			)
			((<= gHowFast 8)
				(= global158 1)
			)
			(else
				(= global158 0)
			)
		)
		(gGame
			detailLevel:
				(cond
					((> gHowFast 7) 3)
					((> gHowFast 5) 7)
					(else 14)
				)
		)
		(if (<= gHowFast 3)
			(SetFlag 202)
		)
		(gCurRoom newRoom: global300)
	)
)

