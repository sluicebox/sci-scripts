;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Wander)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm032 0
)

(local
	[local0 67] = [4 0 0 0 0 0 -14336 0 0 123 40 125 75 120 75 104 17 104 17 -32768 -14202 0 134 104 87 104 87 120 94 124 121 126 200 119 216 106 216 73 175 -32768 -14078 73 236 73 236 120 242 124 258 125 258 -32668 -14336 133 74 145 96 149 144 147 168 137 195 133 259 -32636 0]
)

(instance rm032 of Rm
	(properties
		picture 32
		style 16
		horizon 80
		north 25
		east 33
		west 31
	)

	(method (init &tmp [temp0 50])
		(super init:)
		(NormalEgo)
		(Load rsVIEW 16)
		(door init:)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(west
				(gEgo posn: 24 128)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 244 129)
				(self setScript: gStdWalkIn)
			)
			(north
				(gEgo posn: 225 83)
				(self setScript: gStdWalkIn)
			)
			(42
				(self setScript: exitHouse)
			)
			(104 ; night
				(= global109 goose)
				(= global110 gooseCage)
				(= global111 door)
				(self setScript: (ScriptID 95)) ; landing
			)
			(45 ; mapRoom
				(gEgo init:)
				(HandsOn)
			)
			(else
				(gEgo
					view: global114
					observeControl: -32768
					posn: 150 124
					init:
				)
				(HandsOn)
			)
		)
		(if (!= gPrevRoomNum 104) ; night
			(goose init:)
		)
		(if (> global170 70)
			(water init: setCycle: Fwd)
		)
		(if (< gScore gPossibleScore)
			(proc0_8)
		)
		(if (and global129 (== gPrevRoomNum 42))
			(global129 posn: 60 124)
		)
	)

	(method (dispose)
		(DisposeScript 95)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((gEgo inRect: 76 107 92 118)
				(self setScript: doorScript)
			)
			((== 1 (gEgo edgeHit:))
				(self newRoom: north)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance goose of Act
	(properties
		y 141
		x 134
		view 18
		loop 1
		moveSpeed 3
	)

	(method (init)
		(super init:)
		(gooseCage init:)
		(self
			setCycle: Walk
			setMotion: Wander 200
			observeBlocks: gooseCage
			setScript: gooseScript
		)
	)

	(method (handleEvent event)
		(if (proc0_18 self event)
			(event claimed: 1)
			(script changeState: 1)
		)
	)
)

(instance gooseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 8 18))
			)
			(1
				(if (or (rm032 script:) (not (User controls:)))
					(= state -1)
					(= cycles 1)
				else
					(DoAudio audPLAY 40)
					(switch (/ (goose loop:) 2)
						(0
							(goose setLoop: (+ (goose loop:) 4))
						)
						(1
							(goose setLoop: (Random 4 5))
						)
					)
					(goose
						setCel: 0
						setMotion: 0
						cycleSpeed: 5
						setCycle: CT 2 1 self
					)
				)
			)
			(2
				(goose setCel: 3 setCycle: CT 4 1 self)
			)
			(3
				(if (and (not (rm032 script:)) (User controls:))
					(DoAudio audPLAY 40)
				)
				(goose setCel: 4 setCycle: CT 6 1 self)
			)
			(4
				(goose setCel: 7 setCycle: End self)
			)
			(5
				(goose
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 0
					setMotion: Wander 200
				)
				(= cycles 15)
			)
			(6
				(clr)
				(= state -1)
				(= cycles 1)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (and (== (event type:) evVERB) (not state))
			(= cycles 0)
			(= seconds 3)
		)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(door
					signal: (& (door signal:) $feff)
					startUpd:
					setCycle: End self
				)
				(Timer set60ths: self (DoAudio audPLAY 38))
			)
			(1)
			(2
				(gEgo
					illegalBits: 0
					setMotion: MoveTo 82 (- (gEgo y:) 7) self
				)
			)
			(3
				(gCurRoom newRoom: 42)
			)
		)
	)
)

(instance exitHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: posn: 82 110)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 82 120 self)
			)
			(2
				(DoAudio audWPLAY 36)
				(door
					signal: (& (door signal:) $feff)
					startUpd:
					setCycle: Beg self
				)
				(= cycles 8)
			)
			(3
				(DoAudio audPLAY 36)
			)
			(4
				(door signal: (| (door signal:) $0101))
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance door of Prop
	(properties
		y 113
		x 70
		view 131
		priority 7
		signal 16657
		cycleSpeed 2
	)

	(method (init)
		(if (== gPrevRoomNum 42)
			(= cel (- (NumCels self) 1))
		)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(self addToPic:)
	)

	(method (delete)
		(&= signal $ffdf)
		(super delete:)
	)
)

(instance water of Prop
	(properties
		y 155
		x 223
		view 131
		loop 1
		priority 15
		signal 16
		cycleSpeed 3
	)
)

(instance gooseCage of Cage
	(properties
		top 115
		left 40
		bottom 170
		right 255
	)
)

