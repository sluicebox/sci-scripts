;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use n411)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm015 0
)

(local
	[local0 43] = [2 0 0 0 -14307 155 13 137 35 131 48 123 76 125 99 130 117 125 142 132 153 128 153 118 34 -32687 -14166 35 159 116 173 119 198 123 242 109 238 91 218 91 218 -32726 0]
	local43
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
		(Load rsVIEW 127)
		(NormalEgo)
		(super init:)
		(door init: stopUpd:)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(40
				(gEgo loop: 0 cel: 1 x: 146 y: 107 edgeHit: EDGE_NONE init:)
				(self setScript: outDoor)
			)
			(north
				(gEgo posn: 230 (+ horizon 5))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo
					posn: 248 (proc0_13 (+ horizon 1) (gEgo y:) global61)
				)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (gEgo x:) 150 setPri: -1)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 190 132 init:)
			)
		)
		(proc0_8)
		(if (and global129 (== gPrevRoomNum 40))
			(global129 posn: 129 127)
		)
		(if (not ((gGoals at: 15) egoReturned:))
			(man init:)
		)
		(if global172
			(self setScript: converse)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((!= (event type:) evVERB)
				(return)
			)
			(script
				(return)
			)
			((gCast contains: man)
				(event claimed: 1)
				(self setScript: converse)
			)
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
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 146 107 self)
			)
			(1
				(Timer set60ths: self (DoAudio audPLAY 38))
				(door setCycle: End)
			)
			(2
				(gEgo illegalBits: $8000)
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
				(HandsOff)
				(= cycles 20)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(DoAudio audPLAY 36)
				(= cycles 10)
			)
			(3
				(gEgo illegalBits: 0 setMotion: MoveTo 156 125 self)
			)
			(4
				(gEgo illegalBits: $8000)
				(HandsOn)
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
		y 124
		x 180
		yStep 1
		view 83
		loop 5
		cycleSpeed 1
		illegalBits 0
		xStep 1
		moveSpeed 1
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
		y 101
		x 127
		view 127
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(if (== gPrevRoomNum 40)
			(= cel 3)
		)
		(= global110 self)
	)
)

(instance converse of Script
	(properties)

	(method (cue)
		(client setScript: 0)
		(DoSound sndMASTER_VOLUME global125)
		(if global172
			(gCurRoom newRoom: 45) ; mapRoom
		)
		(HandsOn)
	)

	(method (init &tmp temp0)
		(HandsOff)
		(super init: &rest)
		(= temp0 (gGoals at: 15))
		(proc0_20)
		(cond
			(local43
				(self setScript: converse2 self local43)
			)
			((temp0 egoHas:)
				(self setScript: converse5 self 134)
				(if (== global123 5)
					(= global123 0)
				)
				(temp0 egoReturned: 1)
				(= local43 3)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 130)
				(= global123 5)
				(= local43 133)
			)
			(else
				(self setScript: converse1 self 124)
				(temp0 egoTold: 1)
				(= local43 129)
				(= global123 5)
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
					setAvoider: (Avoid new:)
					setMotion: MoveTo 205 136 self
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
					setAvoider: (Avoid new:)
					setMotion: MoveTo 205 136 self
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
					setAvoider: (Avoid new:)
					setMotion: MoveTo 205 136 self
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
					setAvoider: (Avoid new:)
					setMotion: MoveTo 205 136 self
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
				(self setScript: (ScriptID 315) self) ; rhymeScript
			)
			(7
				(self dispose:)
			)
		)
	)
)

