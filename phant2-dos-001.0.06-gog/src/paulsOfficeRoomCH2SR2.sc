;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4622)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use P2Fidget)
(use Feature)

(public
	paulsOfficeRoomCH2SR2 0
)

(local
	local0 = 20
)

(instance paulsOfficeRoomCH2SR2 of P2Room
	(properties
		picture 350
		east 4632
		west 4612
	)

	(method (init)
		(if (gRoboGary isPlaying:)
			(gRoboGary stop: 1)
		)
		(gP2SongPlyr fadeIn: 4602)
		(curtis init:)
		(super init: &rest)
		(deskFeat
			init: (proc63002_10 56 333 81 286 118 274 240 247 375 268 635 333)
		)
		(plaqueF init:)
		(g init: gThePlane 1 (proc63002_10 260 26 272 30 260 36))
		(compATP init: isHot: 0)
		(gGame handsOn: 1)
	)
)

(instance compATP of P2View
	(properties
		x 557
		y 300
		view 13501
	)
)

(instance curtis of P2Fidget
	(properties
		x 295
		y 339
		view 13500
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 4
		zone1aRight 8
		zone1bLeft 9
		zone1bRight 14
		zone2aLeft 15
		zone2aRight 20
		zone2bLeft 21
		zone2bRight 27
	)
)

(instance deskFeat of P2Feature
	(properties
		readyFlag 228
		nextRoom 4642
	)
)

(instance plaqueF of P2Feature
	(properties
		scene 6760
		doneFlag 95
	)

	(method (init)
		(if (super init:)
			(self
				addTarget:
					(proc63002_10 64 80 86 76 105 87 108 141 83 149 60 137)
					0
			)
			(return 1)
		)
	)
)

(instance g of Feature
	(properties)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (super handleEvent: event))
			(if local0
				(-- local0)
			else
				(gP2SoundFX play: 4622)
				(= local0 20)
				(eggAMatic add: gCurRoomNum 1 15)
			)
			(event claimed: 1)
			(return)
		)
	)
)

