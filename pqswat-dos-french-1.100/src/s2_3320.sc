;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3320)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Motion)
(use Actor)
(use System)

(public
	s2_3320 0
)

(instance s2_3320 of PQRoom
	(properties
		picture 3320
	)

	(method (init)
		(super init: &rest)
		(self setScript: egoDies)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance egoDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(allen init:)
				(proc4_6 33200 96 -19 0 0 1 1)
				(= cycles 4)
			)
			(1
				(allen setPri: 1 setCycle: End)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(3
				(gFxSound number: 2992 loop: 1 play: self)
			)
			(4
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 0 stop:)
				(gBackMusic2 number: 29808 loop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance allen of Prop
	(properties
		x -18
		y 416
		view 33201
	)
)

