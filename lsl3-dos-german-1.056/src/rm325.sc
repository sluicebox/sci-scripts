;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 325)
(include sci.sh)
(use Main)
(use rm71)
(use Interface)
(use Game)
(use System)

(public
	rm325 0
)

(instance rm325 of Rm
	(properties
		picture 325
	)

	(method (init)
		(super init:)
		(self setRegions: 71 setLocales: 70 setScript: RoomScript) ; rm71
		(Notify 71 1 103 63)
		(Notify 71 2 184 60)
		(Notify 71 3 106 65)
		(Notify 71 4 181 65)
		(Notify 71 5 143 107)
		(Notify 71 6 141 152)
		(HandsOff)
	)
)

(instance RoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 11)
			)
			(1
				(React 2 20)
				(= cycles 33)
			)
			(2
				(Print 325 0) ; "Now you can see why Suzi Cheatem is known as the "Queen of Torts!""
				(= cycles 11)
			)
			(3
				(gCurRoom newRoom: 323)
			)
		)
	)
)

