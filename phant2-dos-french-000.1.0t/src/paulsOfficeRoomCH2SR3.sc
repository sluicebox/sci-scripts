;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4632)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)
(use Feature)
(use System)

(public
	paulsOfficeRoomCH2SR3 0
)

(local
	local0 = 10
)

(instance paulsOfficeRoomCH2SR3 of P2Room
	(properties
		picture 330
		east 4612
		west 4622
	)

	(method (init)
		(Lock rsPIC 330 1)
		(Lock rsVIEW 13303 1)
		(Lock rsVIEW 13300 1)
		(Lock rsVIEW 13302 1)
		(Lock rsVIEW 330 1)
		(Lock rsPIC 361 1)
		(Lock rsVIEW 361 1)
		(if (gCast contains: sAnagramTalk)
			(gCast delete: sAnagramTalk)
		)
		(if (not (IsFlag 228))
			(theCop init:)
			(= east (= west 0))
		else
			(if (gRoboGary isPlaying:)
				(gRoboGary stop: 1)
			)
			(gP2SongPlyr fadeIn: 4602)
			(compATP init: isHot: 0)
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
		(paperV init:)
		(curtis init:)
		(= local0 10)
		(weasel init: gThePlane 1 502 0 639 90)
		(gGame handsOn: 1)
	)

	(method (dispose &tmp temp0)
		(= temp0 (super dispose: &rest))
		(if (and (not (IsFlag 228)) (== gNewRoomNum 4662)) ; anagramCURoomCH2
			(sAnagramTalk init:)
			(return 0)
		else
			(sAnagramTalk dispose:)
			(Lock rsPIC 330 0)
			(Lock rsVIEW 13303 0)
			(Lock rsVIEW 13300 0)
			(Lock rsVIEW 13302 0)
			(Lock rsVIEW 330 0)
			(Lock rsPIC 361 0)
			(Lock rsVIEW 361 0)
			(return temp0)
		)
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

(instance compATP of P2View
	(properties
		x 441
		y 296
		view 13303
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

(instance deskFeat of P2Feature
	(properties
		readyFlag 228
		nextRoom 4642
	)
)

(instance doorFeat of ExitFeature
	(properties)

	(method (init)
		(= exitScene
			(cond
				((IsFlag 228) 6846)
				((== global207 0) 4391)
				(else 4395)
			)
		)
		(= nextRoom (if (IsFlag 228) 3322 else 3372))
		(if (not (IsFlag 228))
			(= sceneScored 1)
		)
		(super init: &rest)
	)

	(method (handleEvent &tmp temp0 temp1)
		(= temp0 global212)
		(= global212 0)
		(if (not (= temp1 (super handleEvent: &rest)))
			(= global212 temp0)
		)
		(return temp1)
	)
)

(instance theCop of P2Fidget
	(properties
		x 484
		y 338
		view 13302
		initStart 0
		initFinish 1
		cycleStart 2
		cycleFinish 3
	)

	(method (cue)
		(if time
			(copTalk doit:)
		)
		(super cue: &rest)
	)

	(method (dispose)
		(if
			(and
				(!= (copTalk scratch:) -1)
				(!= (DoAudio audPOSITION 4600 0 0 8 (copTalk scratch:)) -1)
				(!= gNewRoomNum 4662) ; anagramCURoomCH2
			)
			(DoAudio audSTOP 4600 0 0 8 (copTalk scratch:))
		)
		(super dispose: &rest)
	)
)

(instance copTalk of Code
	(properties
		scratch -1
	)

	(method (doit)
		(if (or (== scratch -1) (== (DoAudio audPOSITION 4600 0 0 8 scratch) -1))
			(+= scratch (Random 2 5))
			(if (>= scratch 7)
				(-= scratch 6)
			)
			(DoAudio audPLAY 4600 0 0 8 scratch)
		)
	)
)

(instance sAnagramTalk of Script
	(properties)

	(method (cue)
		(if state
			(copTalk doit:)
		else
			(= state 1)
		)
		(= seconds (Random 2 3))
	)
)

(instance paperV of P2View
	(properties
		x 265
		y 275
		view 330
		nextRoom 4662
	)

	(method (init)
		(if (not (IsFlag 253))
			(super init: &rest)
		)
	)
)

