;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use n411)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm021 0
)

(local
	local0
	local1
	local2
)

(instance rm021 of Rm
	(properties
		picture 21
		style 0
		south 28
	)

	(method (init)
		(= global345 outCode)
		(Load rsVIEW 128)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 52 146 38 155 38 196 -1 196 0 0 315 0 315 196 258 196 257 156 215 124 225 111 211 99 204 87 190 87 195 99 194 105 195 117 185 116 155 108 109 119 44 108 58 88 34 86 11 118 11 139
					yourself:
				)
		)
		(gCurRoom
			addObstacle:
				(= local2
					((Polygon new:)
						type: PBarredAccess
						init: 63 112 63 126 29 126 30 112
						yourself:
					)
				)
		)
		(gCurRoom
			addObstacle:
				(= local1
					((Polygon new:)
						type: PBarredAccess
						init: 72 143 100 143 100 152 49 152 56 143
						yourself:
					)
				)
		)
		(proc0_1)
		(switch gPrevRoomNum
			(south
				(gEgo posn: (proc0_13 54 (gEgo x:) 249) 139)
				(self setScript: gStdWalkIn 1 11)
			)
			(44
				(gEgo posn: 182 86 init:)
				(self setScript: closeDoorScript)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 193 136 init:)
			)
		)
		(if (not ((gGoals at: 11) egoReturned:))
			(mother init:)
			(kid0 init:)
			(kid1 init:)
			(kid2 init:)
			(kid3 init:)
			(kid4 init:)
			(= global341 converse)
			(self cue:)
		)
		(proc0_8)
		(if (and global130 (<= global130 47) (== gPrevRoomNum 44))
			(global129 posn: 189 116)
		)
		(door init:)
		(hole addToPic:)
		(if global172
			(self setScript: converse)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $0004)
				(proc0_2)
				(self setScript: openDoorScript)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (cue)
		(if global157
			(Timer set60ths: self (DoAudio audPLAY 18))
		)
	)

	(method (dispose &tmp temp0)
		(if (= temp0 (self timer:))
			(temp0 dispose:)
			(temp0 delete:)
		)
		(= global341 0)
		(if global157
			(DoAudio audSTOP)
		)
		(super dispose:)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 203 100 self)
			)
			(1
				(door setCycle: End self)
				(gSfx number: 38 play:)
			)
			(2
				(gEgo setMotion: MoveTo 196 86 self)
			)
			(3
				(gEgo setMotion: MoveTo 182 86 self)
			)
			(4
				(proc0_3)
				(gCurRoom newRoom: 44)
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
				(gEgo setMotion: MoveTo 196 86 self)
			)
			(1
				(gEgo setMotion: MoveTo 203 100 self)
			)
			(2
				(door cycleSpeed: 5 setCycle: Beg self)
				(= ticks 30)
			)
			(3
				(gSfx number: 36 play:)
			)
			(4
				(gEgo cycleSpeed: 12 setMotion: MoveTo 210 118 self)
				(door stopUpd:)
			)
			(5
				(proc0_3)
				(if (not ((gGoals at: 11) egoReturned:))
					(gCurRoom cue:)
				)
				(self dispose:)
			)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					observeControl: 4
					setAvoider: PAvoider
					setMotion: PolyPath 194 132 self
				)
			)
			(1
				(gEgo setAvoider: 0 ignoreControl: 4)
				(proc0_7 gEgo mother)
				(if (gCurRoom timer:)
					((gCurRoom timer:) dispose:)
				)
				(mother setLoop: 6 signal: (& (mother signal:) $feff) startUpd:)
				(theHead init: mother)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance atEaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc411_1)
				(theHead dispose:)
				(mother setLoop: 5)
				(if (<= global170 110)
					(mother setCel: 3 signal: (| (mother signal:) $0101))
				)
				(= cycles 2)
			)
			(1
				(= global131 (+ (mother x:) -20))
				(= global132 (- (mother y:) 72))
				(= global128 110)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(2
				(gCurRoom cue:)
				(self dispose:)
			)
		)
	)
)

(instance mother of CDActor
	(properties
		x 231
		y 125
		yStep 1
		view 79
		loop 5
		cel 3
		cycleSpeed 12
		illegalBits 0
		xStep 1
	)

	(method (init)
		(if (> global170 110)
			(self setCycle: Fwd)
		else
			(|= signal $0101)
		)
		(super init:)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		view 79
		loop 7
		signal 2048
		moveHead 0
	)

	(method (init param1)
		(self stopUpd:)
		(super init: param1)
	)

	(method (doit)
		(self
			setLoop:
				(cond
					((< (gEgo x:) (- (client x:) 20)) 9)
					((> (gEgo x:) (+ (client x:) 20)) 8)
					(else 7)
				)
		)
		(super doit:)
	)
)

(instance kid0 of Actor
	(properties
		x 92
		y 68
		view 79
		priority 10
		signal 16
		cycleSpeed 9
		illegalBits 0
		moveSpeed 9
	)

	(method (init)
		(if (> global170 90)
			(self setCycle: Fwd)
		else
			(|= signal $0101)
		)
		(super init:)
		(= global110 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance hole of View
	(properties
		x 67
		y 148
		view 79
		loop 10
		signal 16384
	)
)

(instance kid1 of Actor
	(properties
		x 75
		y 148
		view 79
		loop 1
		signal 16384
		cycleSpeed 9
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
		(= global111 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance kid2 of Actor
	(properties
		x 129
		y 69
		view 79
		loop 2
		signal 8192
		cycleSpeed 9
		illegalBits 0
		xStep 2
	)

	(method (init)
		(if (> global170 70)
			(self setCycle: Fwd)
		else
			(|= signal $0101)
		)
		(super init:)
		(= global112 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance kid3 of Actor
	(properties
		x 45
		y 122
		view 79
		loop 3
		priority 12
		signal 26626
		cycleSpeed 12
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
		(= global113 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance kid4 of Actor
	(properties
		x 199
		y 38
		view 79
		loop 4
		priority 12
		signal 8208
		cycleSpeed 9
		illegalBits 0
	)

	(method (init)
		(if (!= global130 54)
			(if (> global170 120)
				(self setCycle: Fwd)
			else
				(|= signal $0101)
			)
			(super init:)
		)
		(= global120 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door of Prop
	(properties
		x 211
		y 90
		view 128
		priority 6
		signal 16385
		cycleSpeed 12
	)

	(method (init)
		(self setCel: (if (== gPrevRoomNum 44) 5 else 0))
		(super init:)
		(= global122 self)
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
				(global172 1)
				(((gGoals at: 11) egoReturned:)
					(return)
				)
			)
			(proc0_2)
			(= temp0 (gGoals at: 11))
			(proc0_20)
			(cond
				(local0
					(self setScript: converse2 self local0)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 326)
					(temp0 egoReturned: 1)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 322)
					(= local0 325)
				)
				(else
					(self setScript: converse1 self 314)
					(temp0 egoTold: 1)
					(= local0 321)
				)
			)
		else
			(client setScript: 0)
			(DoSound sndMASTER_VOLUME global125)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(proc0_5)
			(proc0_3)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(mother say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(mother say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(mother say: (++ register) self)
			)
			(6
				(gEgo say: (++ register) self)
			)
			(7
				(mother say: (++ register) self)
			)
			(8
				(self setScript: atEaseScript self)
			)
			(9
				(= global123 14)
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
				(self setScript: attentionScript self)
			)
			(1
				(mother say: register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global123 14)
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
				(self setScript: attentionScript self)
			)
			(1
				(mother say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(mother say: (++ register) self)
			)
			(4
				(self setScript: atEaseScript self)
			)
			(5
				(= global123 14)
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
				(self setScript: attentionScript self)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(mother say: (++ register) self)
			)
			(3
				(proc411_1)
				(theHead dispose:)
				(mother setLoop: 5)
				(= cycles 2)
			)
			(4
				(self setScript: (ScriptID 321) self) ; rhymeScript
			)
			(5
				((gCurRoom obstacles:) delete: local2)
				((gCurRoom obstacles:) delete: local1)
				(local2 dispose:)
				(local1 dispose:)
				(if (== global123 14)
					(= global123 0)
				)
				(= global341 0)
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
				(= temp0 (proc0_13 35 (gEgo x:) 205))
				(= temp1 77)
			)
			(2
				(= temp0 253)
				(= temp1 (proc0_13 105 (gEgo y:) 151))
			)
			(3
				(= temp0 (proc0_13 38 (gEgo x:) 250))
				(= temp1 158)
			)
			(4
				(= temp0 8)
				(= temp1 (proc0_13 114 (gEgo y:) 140))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

