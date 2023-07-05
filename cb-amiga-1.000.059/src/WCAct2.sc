;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 384)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	WCAct2 0
)

(local
	local0
	local1
)

(instance WCAct2 of Rgn
	(properties)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 420 402 404)
		(CHead ignoreActors: 1 setPri: 9 init:)
		(WHead setPri: 9 init:)
		(Clarence setPri: 9 init:)
		(Wilbur init:)
	)

	(method (doit)
		(if (and (== (global374 cel:) 0) (not local1))
			(++ local1)
			(self setScript: walkThru)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (and (== (event type:) evSAID) (Said '*/c,attorney'))
			(Print 384 0) ; "Wilbur and Clarence seem to just want to get away from you."
		)
	)
)

(instance walkThru of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (not (User canControl:)) (gEgo mover:))
					(= state -1)
				)
				(= cycles 2)
			)
			(1
				(HandsOff)
				(User canControl: 1)
				(Print 384 1 #dispose) ; "No privacy here, either."
				(= local0 1)
				(CHead hide:)
				(WHead hide:)
				(Clarence
					view: 400
					setCycle: Walk
					setMotion: MoveTo 360 121 self
				)
				(Wilbur view: 420 setCycle: Walk setMotion: MoveTo 360 121)
			)
			(2
				(cls)
				(User canInput: 1)
				(= gClarenceWilburState 2)
				(= seconds 30)
			)
			(3
				(= gClarenceWilburState 3)
				(client setScript: 0)
			)
		)
	)
)

(instance Clarence of Act
	(properties
		y 121
		x 209
		view 402
		loop 1
	)
)

(instance Wilbur of Act
	(properties
		y 121
		x 184
		view 425
	)
)

(instance CHead of Prop
	(properties
		y 121
		x 207
		z 39
		view 404
		loop 2
	)
)

(instance WHead of Prop
	(properties
		y 82
		x 182
		view 425
		loop 4
	)
)

