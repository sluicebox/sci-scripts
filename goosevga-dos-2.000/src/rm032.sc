;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Wander)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm032 0
)

(instance rm032 of Rm
	(properties
		picture 32
		style -32761
		horizon 81
		north 25
		east 33
		west 31
	)

	(method (init &tmp [temp0 50])
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 268 120 243 122 239 115 239 59 244 29 260 29
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 315 196 0 196 0 140 30 146 90 152 143 152 201 139 258 135 315 134
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 216 81 213 116 193 118 115 124 104 124 86 124 92 105 78 105 75 112 65 121 34 124 0 120
					yourself:
				)
		)
		(NormalEgo)
		(Load rsVIEW 16)
		(door init: stopUpd:)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 26 128)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 129)
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
				(gLongSong number: 600 loop: -1 vol: 127 play: priority: 0)
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

(instance goose of Actor
	(properties
		x 134
		y 141
		description {*** It is Mother's goose}
		view 18
		loop 1
		moveSpeed 6
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

	(method (doVerb)
		(script changeState: 1)
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
					(if global157
						(DoAudio audPLAY 40)
					else
						(gSfx number: 40 play:)
					)
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
				(goose setCel: 4 setCycle: CT 6 1 self)
			)
			(4
				(goose setCel: 7 setCycle: End self)
			)
			(5
				(goose
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 6
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
				(door startUpd: setCycle: End self)
				(gSfx number: 38 play:)
			)
			(1
				(gEgo
					illegalBits: 0
					setMotion: MoveTo 82 (- (gEgo y:) 7) self
				)
			)
			(2
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
				(door startUpd: setCycle: Beg self)
				(gSfx number: 36 play:)
			)
			(3
				(RedrawCast)
				(door stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 70
		y 113
		view 131
		priority 7
		signal 16400
		cycleSpeed 6
	)

	(method (init)
		(if (== gPrevRoomNum 42)
			(= cel (- (NumCels self) 1))
		)
		(super init:)
	)

	(method (onMe)
		(return 0)
	)

	(method (delete)
		(&= signal $ffdf)
		(super delete:)
	)
)

(instance water of Prop
	(properties
		x 223
		y 155
		view 131
		loop 1
		priority 15
		signal 16
		cycleSpeed 14
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

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 219 (gEgo x:) 237))
				(= temp1 40)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 122 (gEgo y:) 134))
			)
			(3
				(= temp0 (proc0_13 30 (gEgo x:) 246))
				(= temp1 153)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 121 (gEgo y:) 139))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

