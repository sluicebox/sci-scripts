;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Main)
(use Interface)
(use KQ5Room)
(use LoadMany)
(use RFeature)
(use Motion)
(use System)

(public
	rm082 0
)

(instance rm082 of KQ5Room
	(properties
		picture 82
		west 83
	)

	(method (init)
		(super init:)
		(HandsOff)
		(LoadMany rsVIEW 792)
		(gEgo normal: 0 view: 792 setStep: 3 2 init:)
		(switch gPrevRoomNum
			(81
				(gEgo posn: 345 46 setLoop: 1)
				(self setScript: enterScreen)
			)
			(83
				(gEgo posn: -35 178 setStep: 3 2 setLoop: 2)
				(self setScript: enterScreenAgain)
			)
		)
		((gEgo head:) hide:)
		(if (not (IsFlag 46))
			(SetFlag 46)
			(SetScore 2)
		)
		(if (!= (gGlobalSound number:) 87)
			(gGlobalSound number: 87 loop: -1 playBed:)
		)
		(self setFeatures: room)
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
	)
)

(instance enterScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 165 55 self)
			)
			(1
				(gEgo setMotion: MoveTo 144 59 self)
			)
			(2
				(gEgo setMotion: MoveTo 121 69 self)
			)
			(3
				(gEgo setLoop: 0 posn: 117 60 setMotion: MoveTo 54 131 self)
			)
			(4
				(gEgo setMotion: MoveTo 30 152 self)
			)
			(5
				(gEgo setMotion: MoveTo 23 158 self)
			)
			(6
				(gEgo setLoop: 1 posn: 25 168 setMotion: MoveTo -22 168 self)
			)
			(7
				(gGlobalSound fade:)
				(if (== ((gInventory at: 33) owner:) 83) ; Elf_Shoes
					(gCurRoom newRoom: 681) ; cdElfToon
				else
					(gCurRoom newRoom: 83)
				)
			)
		)
	)
)

(instance enterScreenAgain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 19 164 self)
			)
			(1
				(gEgo setLoop: 3 setMotion: MoveTo 36 142 self)
			)
			(2
				(gEgo setMotion: MoveTo 45 133 self)
			)
			(3
				(gEgo posn: 48 133 setLoop: 3 setMotion: MoveTo 83 90 self)
			)
			(4
				(gEgo setMotion: MoveTo 117 67 self)
			)
			(5
				(gEgo setMotion: MoveTo 122 65 self)
			)
			(6
				(gEgo setLoop: 2 posn: 126 59 setMotion: MoveTo 159 51 self)
			)
			(7
				(gEgo setMotion: MoveTo 340 43 self)
			)
			(8
				(gGlobalSound fade:)
				(gCurRoom newRoom: 81)
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
					(Say 710)
					(event claimed: 1)
				)
			)
		)
	)
)

