;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 215)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use RFeature)
(use Motion)
(use System)

(public
	rm215 0
)

(instance rm215 of KQ5Room
	(properties
		picture 215
		east 8
	)

	(method (init)
		(super init:)
		(Load rsVIEW 792)
		(HandsOff)
		(if (== gPrevRoomNum 8)
			(gEgo
				normal: 0
				view: 792
				setLoop: 2
				setStep: 3 2
				setCycle: KQ5SyncWalk
				posn: 340 -35
				init:
			)
			(self setScript: fromRoom8)
		else
			(gEgo
				normal: 0
				view: 792
				setLoop: 1
				setStep: 3 2
				setCycle: KQ5SyncWalk
				illegalBits: 0
				ignoreHorizon: 1
				posn: -30 139
				init:
			)
			(self setScript: enterScreen)
		)
		((gEgo head:) hide:)
		(self setFeatures: room)
		(if (IsFlag 113)
			(ClearFlag 113)
			(self setRegions: 763) ; cartoonRegion
		)
		(gGlobalSound number: 87 loop: -1 playBed:)
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gGlobalSound fade:)
	)
)

(instance enterScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 2 setMotion: MoveTo 130 139 self)
			)
			(1
				(gEgo setMotion: MoveTo 188 124 self)
			)
			(2
				(gEgo setMotion: MoveTo 216 110 self)
			)
			(3
				(gEgo setMotion: MoveTo 231 102 self)
			)
			(4
				(gEgo setLoop: 3 posn: 236 102 setMotion: MoveTo 263 72 self)
			)
			(5
				(gEgo setMotion: MoveTo 282 33 self)
			)
			(6
				(gEgo setMotion: MoveTo 315 -25 self)
			)
			(7
				(gCurRoom newRoom: 8)
			)
		)
	)
)

(instance fromRoom8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 0 setMotion: MoveTo 264 73 self)
			)
			(1
				(gEgo setMotion: MoveTo 222 111 self)
			)
			(2
				(gEgo setMotion: MoveTo 212 113 self)
			)
			(3
				(gEgo
					posn: 218 125
					setLoop: 1
					setMotion: MoveTo 165 136 self
				)
			)
			(4
				(gEgo setMotion: MoveTo -30 141 self)
			)
			(5
				(gCurRoom newRoom: 83)
			)
		)
	)
)

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 215 0) ; "A narrow tunnel has been dug down into the ground. Weak sunlight brightens one end while a dim, eerie light beckons from the other end."
					(event claimed: 1)
				)
			)
		)
	)
)

