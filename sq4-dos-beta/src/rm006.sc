;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use SQRoom)
(use MCyc)
(use Sound)
(use Actor)
(use System)

(public
	rm006 0
)

(local
	[local0 49] = [1 0 114 70 1 0 116 70 1 0 118 70 1 1 119 70 1 1 123 70 1 2 133 70 1 2 142 70 1 3 162 71 1 4 197 71 1 5 239 71 1 6 314 72 0 0 -100 -100 -32768]
)

(instance rm006 of SQRoom
	(properties
		picture 6
		style 2
	)

	(method (init &tmp [temp0 50])
		(Load rsPIC 600)
		(super init:)
		(soundFX init:)
		(falcon init: z: 1000)
		(self setRegions: 707 setScript: falconScript) ; intro
	)
)

(instance falconScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 2) (== (gLongSong prevSignal:) 20))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(soundFX loop: 1 number: 110 play:)
				(falcon setPri: 8 z: 0 setCycle: MCyc @local0 self)
			)
			(2
				(falcon dispose:)
			)
			(3
				(gCurRoom overlay: 600 5)
				(= seconds 10)
			)
			(4
				(gCurRoom newRoom: 9)
			)
		)
	)
)

(instance falcon of Prop
	(properties
		view 1
	)
)

(instance soundFX of Sound
	(properties)
)

