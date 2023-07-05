;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use eRS)
(use Sound)
(use System)

(public
	rm001 0
)

(instance rm001 of PQRoom
	(properties
		picture 205
	)

	(method (init)
		(super init:)
		(gGame setCursor: 69)
		(introSong play:)
		(self setRegions: 127 setScript: introScript) ; intro
	)
)

(instance introScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 6)
			)
			(1
				(gCurRoom drawPic: 98 10)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 2)
			)
		)
	)
)

(instance introSong of Sound
	(properties
		number 705
	)
)

