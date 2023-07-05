;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Print)
(use Actor)
(use System)

(public
	rm100 0
)

(instance rm100 of KQRoom
	(properties
		picture 99
	)

	(method (init)
		(super init:)
		(SetFlag 21)
		(= gChapter 1)
		(= gValOrRoz -4) ; Val
		(rosella init:)
		(valenice init:)
		(self setScript: showOpening)
	)
)

(instance showOpening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(gMessager sayRange: 0 0 1 1 14 self) ; "...And that's not all, mother! Then he said, 'So sorry, Princess. I never step on Mama's feet when we're dancing'!"
			)
			(2
				(Prints
					{Rosella jumps into the pool and the alternate universe.}
				)
				(rosella dispose:)
				(self cue:)
			)
			(3
				(gMessager sayRange: 0 0 1 15 17 self) ; "Won't that be nice, Rosella? You will be polite to him, won't you?"
			)
			(4
				(Prints {Valenice goes over and picks up Rosella's comb.})
				(Prints {Then jumps into the pool.})
				(self cue:)
			)
			(5
				(gCurRoom newRoom: 150)
			)
		)
	)
)

(instance valenice of Actor
	(properties
		x 250
		y 80
		view 0
	)
)

(instance rosella of Actor
	(properties
		x 50
		y 80
		view 1
	)
)

