;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3440)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Motion)
(use Actor)
(use System)

(public
	s2_3440 0
)

(instance s2_3440 of PQRoom
	(properties
		picture 3440
	)

	(method (init)
		(Load rsAUDIO 6006)
		(Lock rsAUDIO 6006 1)
		(super init: &rest)
		(if (global112 leftEarly:)
			(Load rsAUDIO 29808)
			(self setScript: gunAtLowReady)
		else
			(gBackMusic number: 6006 loop: 0 play:)
			(self setScript: captureAllen)
		)
	)

	(method (dispose)
		(proc4_5)
		(Lock rsAUDIO 6006 0)
		(super dispose: &rest)
	)
)

(instance captureAllen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 34401 25 81 0 0 350 1)
			)
			(1
				(gEgo awardMedal: 36)
				(SetFlag 90)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sPlayMusic of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBackMusic number: 29808 loop: 0 play: self)
			)
			(1
				(gBackMusic number: 6007 loop: 0 play: self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance gunAtLowReady of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBackMusic number: 29808 loop: 0 play:)
				(allen view: 34400 loop: 0 cel: 0 posn: 36 126 setPri: 1 init:)
				(swatGuys
					view: 34402
					loop: 0
					cel: 0
					posn: 136 109
					setPri: 300
					init:
				)
				(gEgo
					view: 34403
					loop: 0
					cel: 0
					posn: 420 103
					setPri: 300
					init:
				)
				(= ticks 30)
			)
			(1
				(allen setCycle: CT 8 1 self)
			)
			(2
				(gFxSound number: 35 loop: 1 play:)
				(gEgo setCycle: End)
				(allen setCycle: CT 10 1 self)
			)
			(3
				(gFxSound play:)
				(allen setCycle: CT 13 1 self)
			)
			(4
				(gFxSound play:)
				(allen setCycle: CT 15 1 self)
			)
			(5
				(gFxSound play:)
				(allen setCycle: CT 18 1 self)
			)
			(6
				(gFxSound play:)
				(allen setCycle: CT 20 1 self)
			)
			(7
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound play: self)
			)
			(8
				(gFxSound play: self)
			)
			(9
				(gFxSound play: self)
			)
			(10
				(gEgo view: 0 loop: 0 cel: 0 dispose:)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance allen of Prop
	(properties)
)

(instance swatGuys of Prop
	(properties)
)

