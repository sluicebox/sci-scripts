;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4025)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)

(public
	curtisCubicleRoomCH5SR2 0
)

(instance curtisCubicleRoomCH5SR2 of CloseupRoom
	(properties
		picture 233
		exitRoom 4015
	)

	(method (init)
		(super init: &rest)
		(gP2SongPlyr fadeIn: 3051)
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
		nextRoom 4035
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
		sceneScored 1
		doneFlag 760
		nextRoom 4045
		exitScene 6060
	)

	(method (handleEvent)
		(= global212 0)
		(if (not (super handleEvent: &rest))
			(= global212 1)
			(return 0)
		)
	)
)

