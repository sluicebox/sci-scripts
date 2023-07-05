;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3390)
(include sci.sh)
(use Main)
(use PQRoom)
(use Motion)
(use Actor)
(use System)

(public
	s2_3390 0
)

(instance s2_3390 of PQRoom
	(properties
		picture 3390
	)

	(method (init)
		(super init: &rest)
		(Load rsAUDIO 50)
		(self setScript: egoGetsShot)
	)
)

(instance egoGetsShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global112 stopPath:)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gEgo
					view: 33900
					loop: 0
					cel: 0
					posn: 88 255
					init:
					setCycle: CT 25 1 self
				)
				(swatGuys
					view: 33900
					loop: 1
					cel: 0
					posn: 108 252
					setPri: 1
					init:
				)
				(allen view: 33901 loop: 0 cel: 0 posn: 318 211 init:)
			)
			(1
				(gNarrator modeless: 2)
				(gMessager say: 0 0 1 0) ; "Pup!"
				(gEgo setCycle: CT 35 1 self)
			)
			(2
				(gNarrator modeless: 1)
				(self setScript: timeAllenShotScript self)
				(gEgo setCycle: End self)
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(if (not script)
					(= cycles 1)
				)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance timeAllenShotScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen setCycle: CT 3 1 self)
			)
			(1
				(gBackMusic2 number: 29808 loop: 1 play:)
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 7 1 self)
			)
			(2
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 11 1 self)
			)
			(3
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 13 1 self)
			)
			(4
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 16 1 self)
			)
			(5
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: CT 19 1 self)
			)
			(6
				(gFxSound number: 35 loop: 1 play:)
				(allen setCycle: End self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance swatGuys of View
	(properties)
)

(instance allen of Prop
	(properties)
)

