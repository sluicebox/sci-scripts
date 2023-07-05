;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use SQRoom)
(use MCyc)
(use Sound)
(use Actor)
(use System)

(public
	rm009 0
)

(local
	local0
	[local1 53] = [0 0 126 37 0 1 129 37 0 2 131 41 0 3 136 47 0 4 144 60 0 5 154 71 0 6 159 80 0 6 162 88 0 6 166 96 0 6 169 104 0 6 173 113 0 6 177 124 0 0 -100 -100 -32768]
)

(instance rm009 of SQRoom
	(properties
		picture 9
	)

	(method (init)
		(Load rsVIEW 1)
		(super init:)
		(self setScript: mallardScript setRegions: 707) ; intro
	)
)

(instance mallardScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0
					(proc0_12
						{As we rejoin our friend and semi-hero Roger Wilco we find him rocketing back toward his home planet of Xenon which he hasn't seen since Space Quest 2. Having worked hard to rescue those two ingrates from Andromeda he decides a pit stop at a little watering hole on the planet Magmetheus is in order.}
						67
						2
						5
						70
						315
						28
						global135
						29
						global129
						30
						1
						33
						310
					)
				)
				(= seconds 15)
			)
			(1
				(soundFX init: loop: 1 number: 110 play:)
				(= seconds 1)
				(proc0_12 local0)
				(mallard init: setCycle: MCyc @local1 self)
				(= seconds 2)
			)
			(2
				(mallard dispose:)
				(= seconds 2)
			)
			(3
				(gCurRoom newRoom: 10)
			)
		)
	)
)

(instance mallard of Prop
	(properties
		view 1
	)
)

(instance soundFX of Sound
	(properties)
)

