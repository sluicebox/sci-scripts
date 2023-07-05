;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm900 0
)

(instance rm900 of ExitRoom
	(properties
		picture 9000
		south 800 ; bavMapRm
	)

	(method (init)
		(super init: &rest)
		(gSoundManager play: 0 900 901 902)
		(castle init:)
	)

	(method (dispose)
		(gEgo put: 39) ; invTourTapeDeck
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 800) ; bavMapRm
			(gSoundManager stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance castle of GKFeature
	(properties
		BAD_SELECTOR 910
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 92 104 72 159 77 286 376 253 534 270 531 194 450 195 446 220 418 220 411 111 381 112 377 191 339 183 323 156 303 174 278 109 164 107 141 11 126 106
					yourself:
				)
		)
		(super init: &rest)
	)
)

