;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 681)
(include sci.sh)
(use Main)
(use n013)
(use Monastery)
(use RTEyeCycle)
(use PolyPath)
(use Sound)
(use System)

(public
	talky 0
	youGotIeiunus 1
	youGotIneptus 2
	youGotCogito 3
	youGotMalitia 4
	youGotVocalis 5
	youGotHilaris 6
	youGotDeformis 7
)

(local
	[local0 4] = [1680 0 1 0]
)

(instance talky of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 120)
			)
			(1
				(Converse @local0 (Monastery tFULK:) 0 self) ; "I'd given you up for dead! Are we going to escape or is this your strange idea of a good time?"
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 681)
	)
)

(instance youGotIeiunus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 87 126 self)
			)
			(1
				(secretSound play: self)
			)
			(2
				(Say 1680 2 self) ; "Thank the Virgin it didn't bite my fingers, though I almost thought I felt it move at my touch."
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(secretSound dispose:)
		(super dispose:)
		(DisposeScript 681)
	)
)

(instance youGotIneptus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 69 134 self)
			)
			(1
				(Say 1680 40 self) ; "Odd, this gargoyle's tongue feels a trifle loose, but nothing happens when I pull upon it."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 681)
	)
)

(instance youGotCogito of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 69 134 self)
			)
			(1
				(secretSound play: self)
			)
			(2
				(Say 1680 52 self) ; "This gargoyle may have shifted slightly at my touch, but it may have been a trick of the water."
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(secretSound dispose:)
		(super dispose:)
		(DisposeScript 681)
	)
)

(instance youGotMalitia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 69 134 self)
			)
			(1
				(Say 1680 50 self 67 160 142) ; "It was as unpleasant to touch as to look upon."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 681)
	)
)

(instance youGotVocalis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 87 126 self)
			)
			(1
				(Say 1680 53 self) ; "The topmost gargoyle is beyond my reach."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 681)
	)
)

(instance youGotHilaris of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 126 131 self)
			)
			(1
				(Say 1680 54 self) ; "It did nothing to my touch."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 681)
	)
)

(instance youGotDeformis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 126 131 self)
			)
			(1
				(Say 1680 51 self) ; "The stone is slimy from the fens water."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 681)
	)
)

(instance secretSound of Sound
	(properties
		flags 1
		number 21
	)
)

