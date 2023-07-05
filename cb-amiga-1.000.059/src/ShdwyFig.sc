;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 408)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	ShdwyFig 0
)

(instance ShdwyFig of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 408)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(DrawPic 11 7)
				(gAddToPics dispose:)
				(gFeatures dispose:)
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(1
				(Print 408 0 #at 50 10 #dispose) ; "Someone's walking outside on the second story veranda! Who could it be?"
				(figure
					x: 330
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo -10 140 self
					init:
				)
			)
			(2
				(cls)
				(figure dispose: delete:)
				(DrawPic gCurRoomNum 6)
				(SetFlag 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance figure of Act
	(properties
		y 140
		view 507
		illegalBits 0
		xStep 5
	)
)

