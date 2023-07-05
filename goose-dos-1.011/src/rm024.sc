;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm024 0
)

(instance rm024 of Rm
	(properties
		picture 24
		style 0
		horizon 95
		north 17
		east 25
		south 31
		west 23
		picAngle 70
	)

	(method (init)
		(Load rsVIEW 129)
		(Load rsVIEW 300)
		(Load rsSOUND 17)
		(Load rsSOUND 43)
		(Load rsSOUND 44)
		(super init:)
		(= global207 0)
		(= global125 -1)
		(door init: stopUpd:)
		(switch gPrevRoomNum
			(16
				(= global125 5)
				(gEgo
					setPri: 5
					x: (+ (/ (* (- (gEgo x:) 240) 29) 53) 1)
					y: 122
				)
			)
			(17
				(gEgo x: (+ (/ (* (- (gEgo x:) 92) 79) 146) 219))
				(if (> (gEgo x:) 273)
					(gEgo x: 273)
				)
			)
			(23
				(if (< (gEgo y:) 175)
					(gEgo
						setPri: 5
						y: (+ (/ (* (- (gEgo y:) 101) 20) 45) 121)
					)
					(= global125 5)
				else
					(= global125 14)
				)
			)
			(25)
			(31
				(gEgo x: (+ (/ (* (- (gEgo x:) 97) 158) 76) 1))
			)
			(41
				(gEgo loop: 0 x: 193 y: 127)
				(self setScript: closeDoorScript)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10 240 135)
		(clock1 init:)
		(clock2 init:)
		(gAddToPics
			add:
				roses
				(flower priority: 10)
				((Clone flower) loop: 4 cel: 0 x: 119 y: 112 priority: 10)
				((Clone flower) loop: 4 cel: 1 x: 111 y: 113 priority: 10)
				((Clone flower) loop: 5 cel: 0 x: 103 y: 112 priority: 10)
				((Clone flower) loop: 4 cel: 0 x: 93 y: 112 priority: 10)
				((Clone flower) loop: 0 cel: 0 x: 179 y: 179 priority: 14)
				((Clone flower) loop: 0 cel: 0 x: 60 y: 130 priority: 9)
				((Clone flower) loop: 0 cel: 1 x: 45 y: 133 priority: 9)
				((Clone flower) loop: 1 cel: 0 x: 53 y: 134 priority: 9)
				((Clone flower) loop: 1 cel: 1 x: 315 y: 108 priority: 7)
				((Clone flower) loop: 1 cel: 1 x: 195 y: 113 priority: 7)
			eachElementDo: #init
			doit:
		)
	)

	(method (doit)
		(if (and (gEgo inRect: 177 120 191 132) (!= script openDoorScript))
			(self setScript: openDoorScript)
		)
		(if (== (gEgo onControl: 1) 8)
			(gCurRoom newRoom: 16)
		)
		(super doit:)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGlobalMGSound number: 1 priority: 5 loop: -1 stop:)
				(doorSound number: 17 loop: 1 play:)
				(door setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 41)
			)
		)
	)
)

(instance closeDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door setCycle: Beg self)
				(doorSound number: 43 loop: 1 play:)
			)
			(1
				(door stopUpd:)
				(doorSound number: 44 loop: 1 play: self)
			)
			(2
				(if (== gScore gPossibleScore)
					(gEgo setAvoider: (Avoid new:) setMotion: MoveTo 321 116)
				else
					(NormalEgo)
					(HandsOn)
					(gCurRoom setScript: 0)
					(if (== global208 0)
						(gGlobalMGSound play:)
					)
				)
			)
		)
	)
)

(instance doorSound of Sound
	(properties
		priority 10
	)
)

(instance door of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 129
			ignoreActors: 1
			setPri: 6
			setLoop: 0
			setCel: (if (== gPrevRoomNum 41) species else 0)
			cycleSpeed: 1
			posn: 187 118
		)
	)
)

(instance clock1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 129 setPri: 12 posn: 190 64 setLoop: 1 setCel: 1 stopUpd:)
	)
)

(instance clock2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 129 posn: 213 110 setLoop: 1 setCel: 0 stopUpd:)
	)
)

(instance flower of PV
	(properties
		y 111
		x 126
		view 300
		loop 5
		cel 1
	)
)

(instance roses of PV
	(properties
		y 98
		x 292
		view 129
		loop 2
	)
)

