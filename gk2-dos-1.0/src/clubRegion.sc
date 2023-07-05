;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4599)
(include sci.sh)
(use Main)
(use n011)
(use Timer)
(use Game)

(public
	clubRegion 0
	cuckooTimer 1
	xGoneTimer 2
)

(instance clubRegion of Rgn
	(properties
		keep 1
	)
)

(instance cuckooTimer of Timer
	(properties)

	(method (cue)
		(if (not (DoAudio audWPLAY))
			(SetFlag 528)
			(switch gCurRoomNum
				(430 ; clubFrontRm
					(xGoneTimer setReal: xGoneTimer 60)
					(gCurRoom notify:)
				)
				(440 ; clubMainRm
					(PlayScene 271)
				)
				(4402
					(PlayScene 271 0 440) ; clubMainRm
				)
				(else
					(PlayScene 324)
					(PlayScene 271 0 440) ; clubMainRm
				)
			)
			(self dispose: delete:)
		else
			(self setReal: self 2)
		)
	)
)

(instance xGoneTimer of Timer
	(properties)

	(method (cue)
		(if (not (DoAudio audWPLAY))
			(gCurRoom cue:)
		else
			(self setReal: self 2)
		)
	)
)

