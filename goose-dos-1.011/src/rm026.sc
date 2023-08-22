;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm026 0
)

(local
	local0
)

(instance rm026 of Rm
	(properties
		picture 26
		style 0
		horizon 100
		north 19
		west 25
		picAngle 75
	)

	(method (init)
		(Load rsVIEW 130)
		(Load rsVIEW 300)
		(Load rsSOUND 17)
		(Load rsSOUND 43)
		(Load rsSOUND 44)
		(super init:)
		(aFlower1 init: setPri: 7 addToPic:)
		(aFlower2 init: setPri: 7 addToPic:)
		(aFlower3 init: setPri: 7 addToPic:)
		(aFlower4 init: setPri: 10 addToPic:)
		(aFlower5 init: setPri: 10 addToPic:)
		(aFlower6 init: setPri: 10 addToPic:)
		(= global207 0)
		(= global125 -1)
		(door init: stopUpd:)
		(switch gPrevRoomNum
			(19
				(gEgo posn: 42 104)
			)
			(20
				(gEgo x: (+ (/ (* (- (gEgo x:) 22) 41) 51) 277) y: 122)
			)
			(25
				(if (< (gEgo y:) 123)
					(gEgo x: 17)
				else
					(gEgo x: 10)
				)
			)
			(33
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 105) 64) 1))
			)
			(27
				(if (< (gEgo y:) 175)
					(gEgo y: (+ (/ (* (- (gEgo y:) 101) 18) 42) 121))
				)
			)
			(43
				(gEgo loop: 1 x: 75 y: 116)
				(self setScript: closeDoorScript)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10 74 136)
		(gAddToPics
			add:
				flower
				cornstalk
				((Clone cornstalk) loop: 2 x: 38 y: 82)
				((Clone cornstalk) loop: 2 x: 48 y: 82)
				((Clone cornstalk) loop: 2 x: 28 y: 82)
				((Clone flower) loop: 1 cel: 2 x: 112 y: 180)
				((Clone flower) loop: 1 cel: 1 x: 179 y: 180)
			eachElementDo: #init
			doit:
		)
		(if global131
			(smoke init:)
		else
			(smoke init: addToPic:)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(
				(and
					(gEgo inRect: 76 110 89 123)
					(!= script openDoorScript)
					(not local0)
				)
				(= local0 1)
				(gEgo ignoreActors: 1 illegalBits: 0)
				(HandsOff)
				(self setScript: openDoorScript)
			)
			((== (gEgo onControl: 1) 8)
				(gCurRoom newRoom: 20)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(if (== global111 55)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 33)
			)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(if (== global111 46)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 27)
			)
		)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalMGSound stop:)
				(doorSound number: 17 loop: 1 play: self)
				(door setCycle: End)
			)
			(1
				(NormalEgo)
				(gCurRoom newRoom: 43)
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
					(gEgo setMotion: MoveTo -1 (gEgo y:))
				else
					(HandsOn)
					(gCurRoom setScript: 0)
				)
				(gGlobalMGSound loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
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
			view: 130
			ignoreActors: 1
			setLoop: 0
			setCel: (if (== gPrevRoomNum 43) species else 0)
			cycleSpeed: 1
			posn: 88 111
		)
	)
)

(instance smoke of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 130 setLoop: 1 cycleSpeed: 3 setCycle: Fwd posn: 215 12)
	)
)

(instance flower of PV
	(properties
		y 180
		x 166
		view 300
	)
)

(instance cornstalk of PV
	(properties
		y 82
		x 58
		view 130
		loop 2
	)
)

(instance aFlower1 of Prop
	(properties
		y 97
		x 72
		view 300
		loop 1
	)
)

(instance aFlower2 of Prop
	(properties
		y 100
		x 77
		view 300
		loop 1
	)
)

(instance aFlower3 of Prop
	(properties
		y 104
		x 80
		view 300
		loop 1
	)
)

(instance aFlower4 of Prop
	(properties
		y 138
		x 114
		view 300
		loop 1
	)
)

(instance aFlower5 of Prop
	(properties
		y 129
		x 103
		view 300
		loop 1
	)
)

(instance aFlower6 of Prop
	(properties
		y 133
		x 108
		view 300
		loop 1
	)
)

