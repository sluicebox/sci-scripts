;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use PQRoom)
(use Motion)
(use System)

(public
	rm205 0
)

(instance rm205 of PQRoom
	(properties
		picture 205
	)

	(method (init)
		(super init: &rest)
		(if (== (gGame printLang:) 1)
			(Load rsAUDIO 20500)
			(gBackMusic number: 20500 loop: -1 play:)
		)
		(gEgo view: 2050 loop: 0 cel: 0 setPri: 100 posn: 33 297 init:)
		(self setScript: enterRange)
	)
)

(instance enterRange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gCurRoom newRoom: 210)
			)
		)
	)
)

