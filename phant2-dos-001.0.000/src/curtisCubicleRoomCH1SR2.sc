;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4021)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)

(public
	curtisCubicleRoomCH1SR2 0
)

(instance curtisCubicleRoomCH1SR2 of CloseupRoom
	(properties
		picture 233
		exitRoom 4011
	)

	(method (init)
		(super init: &rest)
		(cond
			((IsFlag 45) 0)
			((and (IsFlag 46) (== gPrevRoomNum 4051)) ; curtisCubicleRoomCH1SR5
				(gP2SongPlyr fadeOut: 0)
				(gRoboGary setScore: 4 3012 2 10 20 3 start:)
			)
			((and (IsFlag 26) (not (IsFlag 46)))
				(gP2SongPlyr fadeIn: 3012 80)
			)
		)
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: 80)
		else
			(gP2SongPlyr fadeTo: 80)
		)
		(blobPicFeature
			init: (proc63002_10 5 195 128 150 159 248 101 259 49 302)
		)
		(phoneListFeature init: (proc63002_10 245 257 313 288 278 326 202 287))
		(if (not (IsFlag 70))
			(phoneFeature init: (proc63002_10 512 177 562 179 584 234 527 233))
		)
		(or
			(firstComputerFeature init:)
			(afterHectMomComputerFeature init:)
			(usualComputerFeature init:)
		)
		(gGame handsOn: 1)
	)
)

(instance blobPicFeature of P2Feature
	(properties
		nextRoom 4050
	)
)

(instance phoneListFeature of P2Feature
	(properties
		nextRoom 4060
	)
)

(instance phoneFeature of ExitFeature
	(properties
		nextRoom 4031
	)

	(method (handleEvent event)
		(if (and (super handleEvent: event &rest) (not (SetFlag 116)))
			(= global209 5050)
		)
		(event claimed:)
	)
)

(instance firstComputerFeature of ExitFeature
	(properties
		doneFlag 72
		nextRoom 4041
		exitScene 5030
	)

	(method (init)
		(if (super init: &rest)
			(self
				addTarget:
					(proc63002_10
						304
						66
						406
						57
						461
						65
						464
						180
						528
						243
						340
						265
						325
						215
						304
						146
					)
					0
			)
		)
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(ClearFlag 72)
		)
	)
)

(instance afterHectMomComputerFeature of ExitFeature
	(properties
		readyFlag 46
		doneFlag 74
		nextRoom 4041
		fullLVDM 1
	)

	(method (init)
		(if (and (IsFlag 46) (not (IsFlag 45)))
			(return 1)
		)
		(if (super init: &rest)
			(self
				addTarget:
					(proc63002_10
						304
						66
						406
						57
						461
						65
						464
						180
						528
						243
						340
						265
						325
						215
						304
						146
					)
					0
			)
		)
	)
)

(instance usualComputerFeature of ExitFeature
	(properties
		readyFlag 72
		nextRoom 4041
	)

	(method (init)
		(if
			(and
				(or
					(proc63002_4 46 45)
					(and (proc63002_4 26 73 49) (not (IsFlag 46)))
					(not (IsFlag 26))
				)
				(super init: &rest)
			)
			(self
				addTarget:
					(proc63002_10
						304
						66
						406
						57
						461
						65
						464
						180
						528
						243
						340
						265
						325
						215
						304
						146
					)
					0
			)
		)
	)
)

