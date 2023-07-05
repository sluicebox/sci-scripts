;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	pentagonFront 0
)

(instance pentagonFront of Rm
	(properties
		picture 18
		north 19
	)

	(method (init)
		(super init:)
		(self setRegions: 302) ; washington
		(LoadMany rsVIEW 18)
		(if (== gPrevRoomNum 19) ; pentagonLobby
			(gIceKeyDownHandler add: self)
			(gIceMouseDownHandler add: self)
			(gIceGlobalSound number: (proc0_5 70) priority: 1 loop: 1 play:)
			(gCurRoom setScript: departScript)
		else
			(gIceGlobalSound number: (proc0_5 67) priority: 1 loop: -1 play:)
			(gCurRoom setScript: arriveScript)
		)
		(gAddToPics add: cars1Pic cars2Pic jimsCarPic doit:)
	)

	(method (cue)
		(self newRoom: 19) ; pentagonLobby
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/building,pentagon]')
				(Print 18 0) ; "The Pentagon is a very impressive edifice, containing a mammoth 600,000 square feet of office space."
			)
			((Said 'look[<at]/driver,man')
				(Print 18 1) ; "The driver is a stern looking man. All business, his attention is devoted to driving. Every few seconds he glances in the rearview mirror, making sure that no one is following."
			)
			((Said 'look[<at]/car')
				(Print 18 2) ; "The inside of the car is very comfortable. There is a glass partition which separates you from the driver."
			)
			((Said 'talk')
				(Print 18 3) ; "You cannot be heard by the driver."
			)
		)
	)

	(method (dispose)
		(if (gIceKeyDownHandler contains: self)
			(gIceKeyDownHandler delete: self)
		)
		(if (gIceMouseDownHandler contains: self)
			(gIceMouseDownHandler delete: self)
		)
		(super dispose:)
	)
)

(instance arriveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(littleLimo
					init:
					setLoop:
					posn: 360 112
					setPri: 11
					setMotion: MoveTo 200 112 self
				)
			)
			(1
				(littleLimo xStep: 1 setMotion: MoveTo 163 112 self)
			)
			(2
				(littleLimo stopUpd:)
				(Print 18 4) ; "You arrive at the Pentagon in a timely manner."
				(limoProp init: setPri: 10 setCycle: End self)
				(User canInput: 1)
			)
			(3
				(limoProp dispose:)
				(gEgo
					view: 18
					setLoop: 2
					posn: 174 103
					yStep: 1
					xStep: 1
					moveSpeed: 2
					cycleSpeed: 2
					init:
					setMotion: MoveTo 163 93 self
				)
			)
			(4
				(gEgo
					view: 204
					setLoop: -1
					moveSpeed: 0
					cycleSpeed: 0
					xStep: 3
					yStep: 2
					setCycle: Walk
				)
				(gCurRoom cue:)
				(HandsOn)
			)
		)
	)
)

(instance littleLimo of Act
	(properties
		view 18
		xStep 2
	)
)

(instance limoProp of Prop
	(properties
		y 110
		x 163
		view 18
		loop 1
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self setPri: (+ (littleLimo priority:) 1))
	)
)

(instance departScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(littleLimo init: posn: 163 112 xStep: 2 setCel: setLoop:)
				(gEgo
					view: 18
					setLoop: 2
					posn: 163 93
					yStep: 1
					xStep: 1
					moveSpeed: 2
					cycleSpeed: 2
					init:
					setMotion: MoveTo 174 103 self
				)
			)
			(1
				(gEgo dispose:)
				(limoProp init: setCel: (limoProp lastCel:) setCycle: Beg self)
			)
			(2
				(limoProp dispose:)
				(littleLimo setPri: 11 setMotion: MoveTo -40 112 self)
			)
			(3
				(gIceGlobalSound fade:)
				(gCurRoom newRoom: 44) ; inPlane
			)
		)
	)
)

(instance cars1Pic of PV
	(properties
		y 136
		x 107
		view 18
		loop 4
		priority 9
	)
)

(instance cars2Pic of PV
	(properties
		y 135
		x 263
		view 18
		loop 4
		cel 1
		priority 9
	)
)

(instance jimsCarPic of PV
	(properties
		y 169
		x 189
		view 18
		loop 3
		priority 13
	)
)

(instance limmoPic of PV ; UNUSED
	(properties
		y 113
		x 174
		view 18
		priority 7
	)
)

