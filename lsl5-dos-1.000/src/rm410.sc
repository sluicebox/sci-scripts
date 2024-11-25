;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm410 0
)

(local
	seenMsg
)

(instance rm410 of LLRoom
	(properties
		picture 410
		east 400
		south 415
		west 420
	)

	(method (init)
		(gEgo init: normalize: 411)
		(LoadMany rsVIEW 410 411 412)
		(LoadMany rsSOUND 410 420)
		(switch gPrevRoomNum
			(south
				(gEgo x: 157 y: 125 setLoop: 3 setCel: 0 setCycle: 0)
				(reflection
					init:
					x: 157
					y: 125
					setLoop: 4
					setCel: 0
					setCycle: 0
				)
				(desmond
					init:
					x: 130
					y: 125
					setLoop: 4
					setCel: 0
					setCycle: 0
					signal: 16384
				)
				(self setScript: sCartoon2)
			)
			(else
				(desmond init: setCycle: Fwd)
				(self setScript: sCartoon)
			)
		)
		(super init:)
		(steam init: setCycle: Fwd)
		(arrow init: setCycle: Fwd)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 415)
			(gTheMusic fade: 0 15 12 1 self)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance steam of Prop
	(properties
		x 133
		y 162
		view 410
		cel 4
		cycleSpeed 12
		detailLevel 3
	)
)

(instance desmond of Actor
	(properties
		x 31
		y 121
		view 412
		loop 2
	)
)

(instance arrow of Prop
	(properties
		x 286
		y 75
		view 410
		loop 1
		cel 1
		priority 15
		signal 16
		detailLevel 4
	)
)

(instance reflection of Actor
	(properties
		view 411
		loop 2
		priority 1
		signal 16
	)

	(method (doit)
		(= x (gEgo x:))
		(= y (+ 125 (- 125 (gEgo y:))))
		(= cel (gEgo cel:))
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x: 262
					y: 111
					cycleSpeed: 6
					moveSpeed: 6
					setLoop: 0
					setMotion: MoveTo 226 125 self
				)
				(reflection init:)
				(gTheMusic number: 410 flags: 1 setLoop: -1 play:)
			)
			(1
				(TPrint 410 0 #at -1 15 #width 280) ; "Entering the brisk night air, you notice a dark figure leaning against the far wall."
				(gEgo setLoop: 0 setMotion: MoveTo 157 125 self)
				(desmond setScript: sDesmondCartoon)
				(= cycles 20)
			)
			(2
				(TPrint 410 1 #at -1 20) ; "Evidently, he has noticed you, too."
				(TPrint 410 2 #at -1 15 #width 280) ; "You aren't afraid. You've handled rough situations before. After all, think of all you went through back in "Leisure Suit Larry 3!""
			)
			(3
				(gEgo setLoop: 3 setCel: 0 setCycle: 0)
				(reflection setLoop: 4 setCel: 0 setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance sDesmondCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(desmond setLoop: 3 setCel: 0 setCycle: End self)
			)
			(1
				(desmond
					setLoop: 0
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 130 125 self
				)
			)
			(2
				(desmond setLoop: 4 setCel: 0 setCycle: 0)
				(= seconds 3)
			)
			(3
				(gCurRoom newRoom: 415)
			)
		)
	)
)

(instance sCartoon2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic number: 420 flags: 1 setLoop: -1 play:)
				(= ticks 123)
			)
			(1
				(reflection loop: 2)
				(gEgo
					cycleSpeed: 6
					moveSpeed: 6
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 139 125 self
				)
				(desmond
					setLoop: 1
					setCel: 0
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					setCycle: Walk
					setMotion: MoveTo -10 138
				)
			)
			(2
				(reflection dispose:)
				(gEgo setMotion: MoveTo 0 145 self)
			)
			(3
				(steam dispose:)
				(arrow dispose:)
				(desmond dispose:)
				(gEgo dispose:)
				(DrawPic 1 -32761)
				(CenterDisplay 4 gColWhite 410 3)
				(= seconds 7)
			)
			(4
				(gCurRoom newRoom: 420)
			)
		)
	)
)

