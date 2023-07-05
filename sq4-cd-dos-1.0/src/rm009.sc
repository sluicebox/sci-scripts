;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Feature)
(use MCyc)
(use Sound)
(use System)

(public
	rm009 0
)

(local
	[local0 53] = [0 0 126 37 0 1 129 37 0 2 131 41 0 3 136 47 0 4 144 60 0 5 154 71 0 6 159 80 0 6 162 88 0 6 166 96 0 6 169 104 0 6 173 113 0 6 177 124 0 0 -100 -100 -32768]
)

(instance rm009 of SQRoom
	(properties
		picture 9
	)

	(method (init)
		(Load rsVIEW 111)
		(super init:)
		(self setScript: mallardScript setRegions: 707) ; intro
	)
)

(instance mallardScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(gNarrator ; "We rejoin our friend and semi-hero Roger Wilco as he rockets back toward his home planet, Xenon, which he hasn't seen since Space Quest II. Having successfully rescued those two ingrates from Andromeda, he decides a pit stop on Magmetheus is in order."
					modeless: 1
					returnVal: 0
					nMsgType: 3
					say:
						1
						self
						2
						64
						2
						5
						67
						315
						25
						global135
						26
						global129
						27
						1
						30
						310
				)
			)
			(2
				(soundFX init: loop: 1 number: 110 play:)
				(= seconds 2)
			)
			(3
				(mallard init: cycleSpeed: 3 setCycle: MCyc @local0 self)
			)
			(4
				(mallard dispose:)
				(gLongSong fade: 0 3 2 1)
				(= seconds 4)
			)
			(5
				(gCurRoom newRoom: 10)
			)
		)
	)
)

(instance mallard of Sq4Prop
	(properties
		view 111
	)

	(method (doit)
		(self cycleSpeed: (self cel:))
		(super doit:)
	)
)

(instance soundFX of Sound
	(properties)
)

