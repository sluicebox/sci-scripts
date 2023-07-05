;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4614)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)

(public
	paulsOfficeRoomCH4SR1 0
)

(instance paulsOfficeRoomCH4SR1 of P2Room
	(properties
		picture 360
		east 4624
		west 4634
	)

	(method (init)
		(gP2SongPlyr fadeIn: 3041)
		(super init: &rest)
		(deskFeat
			init:
				(proc63002_10
					1
					186
					96
					182
					106
					286
					345
					257
					347
					224
					331
					221
					332
					207
					436
					167
					512
					171
					527
					225
					547
					139
					635
					140
					635
					333
					1
					333
				)
		)
		(gGame handsOn: 1)
	)
)

(instance deskFeat of P2Feature
	(properties
		nextRoom 4644
	)
)

