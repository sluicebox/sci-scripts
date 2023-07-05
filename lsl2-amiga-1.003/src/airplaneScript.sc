;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Motion)
(use Actor)
(use System)

(public
	airplaneScript 0
)

(class Airplane of Act
	(properties
		view 511
		illegalBits 0
		moveSpeed 1
		startX -60
		startY 22
		endX 380
		endY 22
		delayMin 20
		delayMax 66
	)

	(method (init)
		(super init:)
		(self
			setLoop: -1
			setCel:
			ignoreActors:
			ignoreHorizon:
			setScript: (airplaneScript new:)
		)
	)
)

(instance airplaneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random (client delayMin:) (client delayMax:)))
			)
			(1
				(client
					posn: (client startX:) (client startY:)
					show:
					setMotion: MoveTo (client endX:) (client endY:) self
				)
			)
			(2
				(client hide:)
				(self changeState: 0)
			)
		)
	)
)

