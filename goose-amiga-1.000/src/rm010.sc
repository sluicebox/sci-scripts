;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm010 0
)

(local
	local0
	local1
	local2
)

(instance rm010 of Rm
	(properties
		picture 10
		style 0
		horizon 100
		east 11
		south 17
		west 9
		picAngle 75
	)

	(method (init)
		(Load rsSOUND 17)
		(Load rsSOUND 43)
		(Load rsSOUND 44)
		(Load rsVIEW 124)
		(Load rsVIEW 300)
		(super init:)
		(= global207 0)
		(if (and (> (gEgo x:) 172) (!= gPrevRoomNum 36))
			(= global125 15)
		else
			(= global125 -1)
		)
		(door init: stopUpd:)
		(switch gPrevRoomNum
			(2
				(gEgo x: (+ (/ (* (- (gEgo x:) 275) 23) 43) 1) y: 119)
			)
			(3
				(gEgo x: 31 y: 119)
			)
			(9
				(gEgo y: (+ (/ (* (- (gEgo y:) 101) 16) 68) 118))
			)
			(11
				(gEgo
					setPri: 15
					y: (+ (/ (* (- (gEgo y:) 135) 47) 54) 142)
				)
			)
			(17
				(cond
					((< (gEgo x:) 103)
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 35) 18) 33) 1)
							y: 133
						)
					)
					((> (gEgo x:) 275)
						(gEgo posn: 300 184 setPri: 15)
					)
					(else
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 117) 36) 15) 83)
							y: 184
							edgeHit: 0
						)
					)
				)
			)
			(36
				(gEgo
					loop: 2
					x: (+ (/ (* (- (gEgo x:) 134) 14) 51) 92)
					y: 143
					edgeHit: 0
				)
				(self setScript: closeDoorScript)
			)
			(else
				(gEgo posn: 160 165)
			)
		)
		(gEgo init:)
		(proc0_10 222 152)
		(gAddToPics
			add:
				(fountain priority: 10)
				flower
				((Clone flower) loop: 5 cel: 0 x: 129 y: 124 priority: 10)
				((Clone flower) loop: 5 cel: 0 x: 65 y: 119 priority: 10)
				((Clone flower) loop: 5 cel: 0 x: 75 y: 123 priority: 10)
				((Clone flower) loop: 5 cel: 2 x: 145 y: 126 priority: 10)
				((Clone flower) loop: 5 cel: 1 x: 56 y: 126 priority: 10)
			eachElementDo: #init
			doit:
		)
		(if global131
			(smoke init:)
		else
			(smoke init: addToPic:)
		)
		(= local2 (Random 0 4))
		(if (or (== 0 local2) (== 3 local2))
			(bird init: setScript: birdScript)
		)
	)

	(method (doit)
		(if (!= (= local0 (gEgo onControl: 1)) local1)
			(= local1 local0)
			(switch local0
				(2
					(gCurRoom newRoom: 17)
				)
				(8
					(gCurRoom newRoom: 2)
				)
				(2048
					(gCurRoom newRoom: 3)
				)
				(16384
					(self setScript: openDoorScript)
				)
				(else 0)
			)
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
				(gGlobalMGSound stop:)
				(doorSound number: 17 loop: 1 play:)
				(door setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 36)
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
				(gGlobalMGSound stop:)
				(door setCycle: Beg self)
				(doorSound number: 43 loop: 1 play:)
			)
			(1
				(door stopUpd:)
				(doorSound number: 44 loop: 1 play: self)
			)
			(2
				(HandsOn)
				(gGlobalMGSound loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(if (== gScore gPossibleScore)
					(proc0_14 116 170)
				else
					(gCurRoom setScript: 0)
				)
			)
		)
	)
)

(instance birdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 9))
			)
			(1
				(bird
					setPri: 10
					setLoop: 3
					setCycle: Fwd
					illegalBits: 0
					ignoreHorizon: 1
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 50 55 self
				)
			)
			(2
				(bird setMotion: MoveTo 100 60 self)
			)
			(3
				(bird setMotion: MoveTo 150 75 self)
			)
			(4
				(bird setMotion: MoveTo 203 115 self)
			)
			(5
				(bird setLoop: 4 setCycle: End self)
			)
			(6
				(= seconds (Random 1 5))
			)
			(7
				(bird
					setCel: 0
					setLoop: 2
					cycleSpeed: 3
					moveSpeed: 3
					setCycle: End self
				)
			)
			(8
				(bird setCycle: Beg self)
			)
			(9
				(= seconds (Random 1 5))
			)
			(10
				(bird
					setLoop: 3
					setCycle: Fwd
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 350 40 self
				)
			)
			(11
				(bird stopUpd:)
				(= cycles 1)
			)
			(12
				(self dispose:)
			)
		)
	)
)

(instance doorSound of Sound
	(properties
		priority 10
	)
)

(instance bird of Actor
	(properties
		x -25
		y 35
		view 124
	)
)

(instance smoke of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 124 setLoop: 6 posn: 206 16 cycleSpeed: 2 setCycle: Fwd)
	)
)

(instance door of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 124
			setLoop: 0
			setCel: (if (== gPrevRoomNum 36) species else 0)
			cycleSpeed: 1
			posn: 108 135
		)
	)
)

(instance flower of PicView
	(properties
		x 240
		y 154
		view 300
		loop 1
	)
)

(instance fountain of PicView
	(properties
		x 210
		y 126
		view 124
		loop 5
	)
)

