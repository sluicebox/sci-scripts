;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4023)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)

(public
	curtisCubicleRoomCH3SR2 0
)

(instance curtisCubicleRoomCH3SR2 of P2Room
	(properties
		picture 233
		south 4013
	)

	(method (init)
		(super init: &rest)
		(if (not (gRoboGary isPlaying:))
			(gRoboGary setScore: 4 3031 2 6 12 4 3032 2 6 12 3 start:)
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
		(phoneFeature init: (proc63002_10 512 177 562 179 584 234 527 233))
		(computerFeature
			init:
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
		nextRoom 4033
	)

	(method (handleEvent event)
		(if (and (super handleEvent: event &rest) (not (SetFlag 116)))
			(= global209 5050)
		)
		(event claimed:)
	)
)

(instance computerFeature of ExitFeature
	(properties
		nextRoom 4043
	)
)

