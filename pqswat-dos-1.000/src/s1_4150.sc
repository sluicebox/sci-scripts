;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4150)
(include sci.sh)
(use Main)
(use PQRoom)
(use Motion)
(use Actor)
(use System)

(public
	s1_4150 0
)

(instance s1_4150 of PQRoom
	(properties
		picture 4150
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 4170) ; s1_4170
			(Load rsAUDIO 16)
			(self setScript: bothLooksRight)
		else
			(Lock rsAUDIO 40104 0)
			(Load rsAUDIO 41500)
			(self setScript: yourDead)
		)
	)
)

(instance yourDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shootingLucy setPri: 1 init: setCycle: CT 8 1 self)
				(= cycles 2)
			)
			(1
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40104)
			)
			(2
				(shootingLucy setCycle: End self)
				(gFxSound number: 41500 loop: 1 play:)
			)
			(3
				(gBackMusic number: 0 stop:)
				(gBackMusic number: 40109 loop: 1 play: self)
			)
			(4
				(gBackMusic number: 0 stop:)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance bothLooksRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(carmichael init: setCycle: End)
				(pacmeyer init: setCycle: CT 35 1 self)
			)
			(1
				(pacmeyer setCycle: End self)
				(gFxSound number: 16 loop: 1 play:)
			)
			(2
				(gCurRoom newRoom: 4160) ; s1_4160
			)
		)
	)
)

(instance shootingLucy of Prop
	(properties
		x 305
		y 290
		view 41500
	)
)

(instance carmichael of Prop
	(properties
		x 152
		y 417
		view 41501
	)
)

(instance pacmeyer of Prop
	(properties
		x 440
		y 430
		view 41502
	)
)

