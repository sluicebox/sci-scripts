;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 106)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	intro7 0
)

(instance intro7 of Rm
	(properties
		picture 73
	)

	(method (init)
		(User canInput: 0 controls: 0)
		(gEgo
			view: 750
			setLoop: 3
			posn: 292 180
			setStep: 1 1
			cycleSpeed: 2
			normal: 0
			init:
		)
		((gEgo head:) hide:)
		(myWater init: setCycle: Fwd)
		(owl init: setStep: 1 1 posn: 207 181)
		(self setScript: egoFlyingScript)
		(super init:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (not global327)
			(= temp0 (Event new:))
			(if (or (== (temp0 type:) evKEYBOARD) (== (temp0 type:) evMOUSEBUTTON))
				(temp0 dispose:)
				(gGlobalSound stop:)
				(gGame restart:)
			)
			(temp0 dispose:)
		)
	)

	(method (newRoom newRoomNumber)
		(gEgo setStep: -1 -1)
		(owl setStep: -1 -1)
		(super newRoom: newRoomNumber)
	)
)

(instance owlFlyingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(owl
					setLoop: 6
					cycleSpeed: 2
					setCycle: Fwd
					setMotion: MoveTo 184 70 self
				)
			)
			(2
				(owl setCycle: End self)
			)
			(3
				(owl setLoop: 7 setCycle: End self setMotion: MoveTo 140 70)
			)
			(4
				(client dispose:)
			)
		)
	)
)

(instance owl of Act
	(properties
		view 760
	)
)

(instance egoFlyingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(owl setScript: owlFlyingScript)
				(= cycles 20)
			)
			(1
				(gEgo setCycle: Fwd setMotion: MoveTo 280 176 self)
			)
			(2
				(gEgo
					setCel: 0
					setCycle: Fwd
					setLoop: 4
					setMotion: MoveTo 210 80 self
				)
			)
			(3
				(gEgo
					setCel: 0
					setLoop: 5
					setMotion: MoveTo 140 70
					setCycle: End self
				)
			)
			(4
				(gCurRoom newRoom: 107) ; intro8
			)
		)
	)
)

(instance myWater of Prop
	(properties
		y 148
		x 157
		view 751
		cycleSpeed 5
	)
)

