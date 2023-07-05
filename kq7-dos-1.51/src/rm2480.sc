;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2480)
(include sci.sh)
(use Main)
(use skipCartoon)
(use Print)
(use System)

(public
	rm2480 0
)

(instance rm2480 of KQRoom
	(properties
		picture 2480
	)

	(method (init)
		(super init:)
		(gEgo x: 150 y: 100 view: 900 init: loop: 0 cel: 0)
		(self setScript: tmpScript)
	)
)

(instance tmpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(Prints {Reverse angle of mirror.})
				(= ticks 1)
			)
			(2)
		)
	)
)

