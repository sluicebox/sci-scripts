;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use eRS)
(use MCyc)
(use Sound)
(use Actor)
(use System)

(public
	rm006 0
)

(local
	[local0 50] = [1 0 114 70 1 0 116 70 1 0 118 70 1 1 119 70 1 1 123 70 1 2 133 70 1 2 142 70 1 3 162 71 1 4 197 71 1 5 239 71 1 6 314 72 0 0 -100 -100 -32768 0]
	[local50 8] = [0 1 3 2 4 5 6 99]
)

(procedure (localproc_0 param1 &tmp temp0)
	(Animate (gCast elements:) 0)
	(if param1
		(for ((= temp0 0)) (<= temp0 100) ((+= temp0 2))
			(Palette palSET_INTENSITY 8 15 temp0)
		)
	else
		(for ((= temp0 100)) (>= temp0 0) ((-= temp0 2))
			(Palette palSET_INTENSITY 8 15 temp0)
		)
	)
)

(instance rm006 of SQRoom
	(properties
		picture 6
		style 2
	)

	(method (init)
		(Load rsPIC 600)
		(Load rsVIEW 1)
		(Load rsSOUND 110)
		(Load rsSCRIPT 942)
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
				(= register 0)
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
				(gCurRoom overlay: 600 3)
				(proc0_12 6 0 70 300 67 10 180 30 1)
				(= seconds 8)
			)
			(4
				(gCurRoom drawPic: 6 4)
				(Palette palSET_INTENSITY 8 15 0)
				(= seconds 1)
			)
			(5
				(credits init: loop: [local50 register] cel: 0)
				(credits
					x:
						(/
							(-
								320
								(CelWide
									(credits view:)
									(credits loop:)
									(credits cel:)
								)
							)
							2
						)
					y:
						(/
							(-
								190
								(CelHigh
									(credits view:)
									(credits loop:)
									(credits cel:)
								)
							)
							2
						)
				)
				(localproc_0 1)
				(= cycles 1)
			)
			(6
				(= seconds 3)
			)
			(7
				(localproc_0 0)
				(= cycles 4)
			)
			(8
				(if (== [local50 (++ register)] 99)
					(= cycles 1)
				else
					(= start 5)
					(self init:)
				)
			)
			(9
				(credits dispose:)
				(= cycles 2)
			)
			(10
				(Palette palSET_INTENSITY 8 15 100)
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

(instance credits of Prop
	(properties
		view 710
	)
)

(instance soundFX of Sound
	(properties)
)

