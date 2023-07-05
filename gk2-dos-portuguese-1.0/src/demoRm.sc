;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use Print)
(use Motion)
(use Actor)
(use System)

(public
	demoRm 0
)

(local
	local0
	local1
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 100)) (> temp0 0) ((-= temp0 1))
		(Palette 2 0 255 temp0) ; PalIntensity
		(gGame doit:)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 100) ((+= temp0 1))
		(Palette 2 0 255 temp0) ; PalIntensity
		(gGame doit:)
	)
)

(procedure (localproc_2 param1 &tmp [temp0 3])
	(PlayVMDFile param1)
)

(instance demoRm of GK2Room
	(properties)

	(method (init)
		(Load rsPIC 108 (if local1 10 else 1000))
		(Load rsVIEW 108 111)
		(if (= local1 (== (CD 0) 1)) ; Check
			(Lock rsAUDIO 34 1)
		)
		(super init: &rest)
		(self setScript: sStartLogo)
	)
)

(instance sStartLogo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local0 0)
				(Palette 2 0 255 0) ; PalIntensity
				(if local1
					(gGk2Sound number: 34 setLoop: 1 play: 0 0 fade: 63 12 10 0)
				)
				(gCurRoom drawPic: 108)
				(localproc_1)
				(= cycles 1)
			)
			(1
				(= ticks 120)
			)
			(2
				(pSierraLogo init: setCycle: End self)
			)
			(3
				(= ticks 120)
			)
			(4
				(pSierraLogo setCycle: Beg self)
			)
			(5
				(pSierraLogo dispose:)
				(= ticks 60)
			)
			(6
				(localproc_0)
				(= cycles 1)
			)
			(7
				(gCurRoom drawPic: (if local1 10 else 1000))
				(= cycles 1)
			)
			(8
				(if (not local0)
					(= local0 1)
					(localproc_1)
				)
				(= cycles 1)
			)
			(9
				(if local1
					(repeat
						(= temp0 0)
						(breakif
							(= temp0
								((Print new:)
									addBitmap: 111 4 0
									addButtonBM: 111 0 0 1000 {} 7 3
									addButtonBM: 111 1 0 1002 {} 134 3
									addButtonBM: 111 2 0 1001 {} 261 3
									addButtonBM: 111 3 0 1003 {} 388 3
									posn: 66 309
									modeless: 1
									init:
								)
							)
						)
					)
				else
					(repeat
						(= temp0 0)
						(breakif
							(= temp0
								((Print new:)
									addBitmap: 111 7 0
									addButtonBM: 111 5 0 1001 {} -3 -3
									addButtonBM: 111 6 0 1003 {} 123 -3
									y: 314
									modeless: 1
									init:
								)
							)
						)
					)
				)
				(switch temp0
					(1000
						(if (and local1 (!= (DoAudio audPOSITION) -1))
							(gGk2Sound fade: 0 6 6 1)
						)
						(localproc_0)
						(gCurRoom drawPic: -1)
						(FrameOut)
						(Palette 2 0 255 100) ; PalIntensity
						(localproc_2 10010)
						(Palette 2 0 255 0) ; PalIntensity
						(= local0 0)
						(self changeState: 7)
					)
					(1002
						(if (and local1 (!= (DoAudio audPOSITION) -1))
							(gGk2Sound fade: 0 6 10 1)
						)
						(localproc_0)
						(Palette 2 0 255 0) ; PalIntensity
						(gGame BAD_SELECTOR:)
						(Lock rsAUDIO 34 0)
						(InitChapter 1)
					)
					(1001
						(gGame restore:)
						(self changeState: 7)
					)
					(1003
						(gGame quitGame:)
						(if (not gQuit)
							(self changeState: 7)
						)
					)
				)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance pSierraLogo of Prop
	(properties
		x 218
		y 85
		view 108
	)
)

