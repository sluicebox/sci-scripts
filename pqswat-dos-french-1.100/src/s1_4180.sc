;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4180)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Motion)
(use Actor)
(use System)

(public
	s1_4180 0
)

(instance s1_4180 of PQRoom
	(properties
		picture 4180
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 41801)
		(self setScript: yourDead)
	)

	(method (dispose)
		(gBackMusic2 stop:)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance yourDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 41800 33 92 0 0 -1 1)
				(Lock rsAUDIO 40104 0)
				(gBackMusic2 number: 40107 loop: 1 play:)
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40104)
			)
			(1
				(playerShot init: setCycle: End self)
			)
			(2
				(gBackMusic loop: 1 stop:)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance playerShot of Prop
	(properties
		y 188
		view 41801
	)
)

