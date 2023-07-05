;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Interface)
(use n411)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm015 0
)

(local
	local0
	local1
)

(instance rm015 of Rm
	(properties
		picture 15
		style 0
		horizon 60
		north 8
		east 16
		south 22
	)

	(method (init)
		(= global345 outCode)
		(Load rsVIEW 127)
		(proc0_1)
		(super init:)
		(door init: stopUpd:)
		(switch gPrevRoomNum
			(40
				(gEgo loop: 0 cel: 1 x: 146 y: 107 edgeHit: 0 init:)
				(self setScript: outDoor)
			)
			(north
				(gEgo posn: 230 (+ horizon 5))
				(self setScript: gStdWalkIn 1 15)
			)
			(east
				(gEgo
					posn: 231 (proc0_13 (+ horizon 1) (gEgo y:) global59)
				)
				(self setScript: gStdWalkIn 1 15)
			)
			(south
				(gEgo posn: (gEgo x:) 139 setPri: -1)
				(self setScript: gStdWalkIn 1 15)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 190 132 init:)
			)
		)
		(= global341 converse)
		(proc0_8)
		(if (and global129 (== gPrevRoomNum 40))
			(global129 posn: 129 127)
		)
		(if (not ((gGoals at: 15) egoReturned:))
			(man ignoreActors: 1 init:)
			(gCurRoom
				addObstacle:
					((= local1 (Polygon new:))
						type: PBarredAccess
						init: 0 179 0 7 223 7 225 43 210 97 232 97 237 109 196 119 196 127 167 127 154 103 145 102 127 102 142 107 153 125 139 130 118 120 96 128 53 120 5 135 23 155 25 179
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 155 0 0 221 24 219 73 234 88 237 109 196 119 181 119 168 120 154 103 145 102 127 102 142 107 153 125 139 130 118 120 96 128 53 120 5 135 23 155
						yourself:
					)
			)
		)
		(if global172
			(self setScript: converse)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo onControl: 0) 5)
				(self setScript: inDoor)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance inDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo illegalBits: 0 setMotion: MoveTo 146 107 self)
			)
			(1
				(gSfx number: 38 play: self)
				(door setCycle: End)
			)
			(2
				(gCurRoom newRoom: 40)
			)
		)
	)
)

(instance outDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= cycles 20)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(gSfx number: 36 play:)
				(= cycles 10)
			)
			(3
				(gEgo illegalBits: 0 setMotion: MoveTo 156 125 self)
			)
			(4
				(proc0_3)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance gestScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 8 30))
				(client setCel: (- (Random 1 (NumCels client)) 1))
				(= state -1)
			)
		)
	)

	(method (dispose)
		(client setCel: 0)
		(super dispose:)
	)
)

(instance man of CDActor
	(properties
		x 180
		y 124
		yStep 1
		view 83
		loop 5
		cycleSpeed 2
		illegalBits 0
		xStep 1
		moveSpeed 2
	)

	(method (init)
		(super init: gestScr)
		(= global109 self)
		(theHead init: self)
	)
)

(instance theHead of Head
	(properties)

	(method (init param1)
		(self moveHead: 0 view: 83 setLoop: 2)
		(super init: param1)
	)

	(method (doit)
		(if (not script)
			(self
				setLoop:
					(cond
						((< (gEgo x:) (- (client x:) 30)) 4)
						((> (gEgo x:) (+ (client x:) 30)) 2)
						(else 3)
					)
			)
		)
		(super doit:)
	)
)

(instance door of Prop
	(properties
		x 127
		y 101
		view 127
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(if (== gPrevRoomNum 40)
			(= cel 3)
		)
		(= global110 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(cond
				((not global172) 1)
				((not (gCast contains: man))
					(return)
				)
			)
			(proc0_2)
			(= temp0 (gGoals at: 15))
			(proc0_20)
			(cond
				((temp0 egoReturned:)
					(gSystemWindow speakingObj: gEgo)
					(Print 900 (+ 524 (Random 0 49)))
					(self cue:)
				)
				(local0
					(self setScript: converse2 self local0)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 134)
					(if (== global123 5)
						(= global123 0)
					)
					(temp0 egoReturned: 1)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 130)
					(= global123 5)
					(= local0 133)
				)
				(else
					(self setScript: converse1 self 124)
					(temp0 egoTold: 1)
					(= local0 129)
					(= global123 5)
				)
			)
		else
			(client setScript: 0)
			(DoSound sndMASTER_VOLUME global125)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(proc0_5)
			(if (== gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			else
				(proc0_3)
			)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					observeControl: 16384
					setAvoider: PAvoider
					setMotion: PolyPath 205 136 self
				)
			)
			(1
				(gEgo setAvoider: 0)
				(proc0_7 gEgo man)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(2
				(man say: register self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(man say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(man say: (++ register) self)
			)
			(7
				(proc411_1)
				(= global131 (+ (man x:) -23))
				(= global132 (- (man y:) 66))
				(= global128 114)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance converse2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					observeControl: 16384
					setAvoider: PAvoider
					setMotion: PolyPath 205 136 self
				)
			)
			(1
				(gEgo setAvoider: 0)
				(proc0_7 gEgo man)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(2
				(man say: register self)
			)
			(3
				(proc411_1)
				(= global131 (+ (man x:) -23))
				(= global132 (- (man y:) 66))
				(= global128 114)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(= global123 5)
				(self dispose:)
			)
		)
	)
)

(instance converse3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					observeControl: 16384
					setAvoider: PAvoider
					setMotion: PolyPath 205 136 self
				)
			)
			(1
				(gEgo setAvoider: 0)
				(proc0_7 gEgo man)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(2
				(man say: register self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(man say: (++ register) self)
			)
			(5
				(proc411_1)
				(= global131 (+ (man x:) -23))
				(= global132 (- (man y:) 66))
				(= global128 114)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance converse5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo
					observeControl: 16384
					setAvoider: PAvoider
					setMotion: PolyPath 205 136 self
				)
			)
			(2
				(gEgo setAvoider: 0)
				(proc0_7 gEgo man)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(3
				(gEgo say: register self)
			)
			(4
				(man say: (++ register) self)
			)
			(5
				(proc411_1)
				(= cycles 2)
			)
			(6
				(man ignoreActors: 0)
				(self setScript: (ScriptID 315) self) ; rhymeScript
			)
			(7
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 155 0 0 222 32 210 97 232 97 237 109 196 119 181 119 168 120 154 103 145 102 127 102 142 107 153 125 139 130 118 120 96 128 53 120 5 135 23 155
							yourself:
						)
				)
				(self dispose:)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 226 (gEgo x:) 252))
				(= temp1 46)
			)
			(2
				(= temp0 261)
				(= temp1 (proc0_13 67 (gEgo y:) 154))
			)
			(3
				(= temp0 (proc0_13 24 (gEgo x:) 257))
				(= temp1 158)
			)
			(4
				(= temp0 3)
				(= temp1 (proc0_13 128 (gEgo y:) 144))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

