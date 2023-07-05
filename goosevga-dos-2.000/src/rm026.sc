;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm026 0
)

(instance rm026 of Rm
	(properties
		picture 26
		style 0
		north 19
		east 27
		south 33
		west 25
	)

	(method (init &tmp [temp0 3])
		(Load rsVIEW 130)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 237 114 230 113 197 120 168 118 147 108 145 100 163 91 159 60 151 50 142 55 144 89 128 95 103 87 113 80 142 50 300 15 288 141 0 141 0 128 256 128 256 113
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 30 111 70 112 77 75 91 25 97 0 96
					yourself:
				)
		)
		(door init:)
		(mailBox init: stopUpd:)
		(proc0_1)
		(switch gPrevRoomNum
			(43
				(= global345 outCode1)
				(gEgo posn: 135 96 loop: 13 cel: 2 init:)
				(self setScript: closeDoorScript)
			)
			(north
				(= global345 outCode1)
				(gEgo posn: 98 86)
				(self setScript: gStdWalkIn)
			)
			(south
				(= global345 outCode2)
				(gEgo posn: (proc0_13 global61 (gEgo x:) global60) 139)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo
					posn:
						26
						(proc0_13 95 (proc0_14 131 (gEgo y:) 138) global59)
				)
				(if (<= (gEgo y:) 131)
					(= global345 outCode1)
				else
					(= global345 outCode2)
				)
				(if (and global130 (<= global130 47))
					(if (< (gEgo y:) 131)
						(global129 observeControl: 256)
					else
						(global129 observeControl: 128)
					)
				)
				(self setScript: gStdWalkIn)
			)
			(east
				(= global345 outCode2)
				(gEgo posn: 231 (proc0_13 137 (gEgo y:) global59))
				(if (and global130 (<= global130 47))
					(global129 observeControl: 128)
				)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(= global345 outCode1)
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8 72 100)
		(smoke init: setCycle: Fwd)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			(script
				(script doit:)
			)
			((== gScore gPossibleScore)
				(++ gScore)
				(self setScript: (ScriptID 205)) ; walkTo
			)
			((& (gEgo onControl:) $0004)
				(gCurRoom newRoom: north)
			)
			((& (gEgo onControl:) $4000)
				(self setScript: openDoorScript)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(door setCycle: End)
				(gSfx number: 38 play: self)
			)
			(1
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
				(proc0_2)
				(door setCycle: Beg self)
				(= cycles 4)
			)
			(1
				(gSfx number: 36 play:)
			)
			(2
				(door stopUpd:)
				(if (== gScore gPossibleScore)
					(proc0_2)
				else
					(proc0_3)
				)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 158
		y 92
		view 130
		signal 26625
		cycleSpeed 2
	)

	(method (init)
		(if (== gPrevRoomNum 43)
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

	(method (onMe)
		(return 0)
	)
)

(instance smoke of Prop
	(properties
		x 237
		y 11
		view 130
		loop 1
		cycleSpeed 12
	)
)

(instance mailBox of View
	(properties
		x 22
		y 111
		view 130
		loop 2
		priority 12
		signal 16400
	)
)

(instance outCode1 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 97 (gEgo x:) 121))
				(= temp1 56)
			)
			(2
				(= temp0 258)
				(= temp1 (proc0_13 113 (gEgo y:) 127))
			)
			(3
				(= temp0 (proc0_13 8 (gEgo x:) 254))
				(= temp1 130)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 97 (gEgo y:) 127))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

(instance outCode2 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 4 (gEgo x:) 252))
				(= temp1 140)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 141 (gEgo y:) 156))
			)
			(3
				(= temp0 (proc0_13 5 (gEgo x:) 253))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 143 (gEgo y:) 154))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

