;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4631)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use Feature)

(public
	paulsOfficeRoomCH1SR3 0
)

(local
	local0 = 10
)

(instance paulsOfficeRoomCH1SR3 of P2Room
	(properties
		picture 330
		east 4611
		west 4621
	)

	(method (init)
		(if (== gPrevRoomNum 3321) ; mainOfficeRoomCH1SR2
			(if (gRoboGary isPlaying:)
				(gRoboGary stop: 1)
			else
				(gP2SongPlyr fadeOut: 0)
			)
			(gP2SongPlyr fadeIn: 4601 40)
		)
		(super init: &rest)
		(doorFeat
			init:
				(proc63002_10
					293
					7
					339
					13
					352
					87
					370
					98
					364
					210
					316
					225
					299
					226
				)
		)
		(deskFeat
			init:
				(proc63002_10
					336
					333
					403
					248
					412
					206
					473
					202
					508
					257
					577
					305
					584
					333
				)
		)
		(= local0 10)
		(weasel init: gThePlane 1 502 0 639 90)
		(curtis init:)
		(gGame handsOn: 1)
	)
)

(instance weasel of Feature
	(properties)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (not (-- local0)))
			(= local0 10)
			(proc63002_7 6802)
			(eggAMatic add: 4630 1 7)
		)
	)
)

(instance deskFeat of P2Feature
	(properties
		nextRoom 4641
	)
)

(instance doorFeat of ExitFeature
	(properties
		nextRoom 3321
		exitScene 6846
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(ClearFlag 5)
		)
	)
)

(instance curtis of P2Fidget
	(properties
		x 152
		y 340
		view 13300
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 6
		zone1aRight 11
		zone1bLeft 12
		zone1bRight 18
		zone2aLeft 19
		zone2aRight 23
		zone2bLeft 24
		zone2bRight 28
		origin 267
	)
)

