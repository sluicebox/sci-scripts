;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Interface)
(use Waters2)
(use n411)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm005 0
)

(local
	local0
	[local1 15] = [203 108 80 118 88 80 112 95 80 23 87 80 236 118 80]
)

(instance rm005 of Rm
	(properties
		picture 5
		style 0
		east 6
		west 4
	)

	(method (init)
		(Load rsVIEW 70)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 309 0 310 130 229 131 238 155 315 157 261 161 312 194 0 196 0 137 38 137 15 152 217 152 211 140 190 137 158 127 149 117 128 117 120 124 101 124 88 115 0 117
					yourself:
				)
		)
		(if ((gGoals at: 16) egoHas:)
			(Load rsSCRIPT 305)
		)
		(switch gPrevRoomNum
			(west
				(= global345 outCode1)
				(gEgo posn: 38 130)
				(= global341 converse)
				(self setScript: gStdWalkIn 1 16)
			)
			(east
				(= global345 outCode2)
				(gEgo posn: 229 131)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
				(= global341 converse)
			)
			(else
				(= global345 outCode1)
				(gEgo posn: 150 120 init:)
				(= global341 converse)
				(if global172
					(self setScript: converse)
				)
			)
		)
		(= global111 water)
		(water init:)
		(proc0_8)
		(humpty init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 1) $0002)
				(gStdWalkOut register: 4)
				(self setScript: gStdWalkOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(DisposeScript 402)
		(super dispose:)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(humpty setScript: faceEgoScript setCycle: 0 cel: 0)
				(if
					(and
						global129
						(<= global130 47)
						(< (global129 nsTop:) (humpty nsBottom:))
						(or
							(<
								(humpty nsLeft:)
								(global129 nsLeft:)
								(humpty nsRight:)
							)
							(<
								(humpty nsLeft:)
								(global129 nsRight:)
								(humpty nsRight:)
							)
						)
					)
					(if (< (gEgo x:) (global129 x:))
						(global129
							setMotion:
								MoveTo
								(+ (humpty x:) 20)
								(+ (global129 y:) 10)
								self
						)
					else
						(global129
							setMotion:
								MoveTo
								(- (humpty x:) 20)
								(+ (global129 y:) 10)
								self
						)
					)
					(= register 1)
				else
					(= cycles 1)
					(= register 0)
				)
			)
			(1
				(if register
					(proc0_7 global129 humpty)
				)
				(= cycles 2)
			)
			(2
				(humpty setCycle: 0)
				(proc411_0 (gEgo head:) humpty)
				(= cycles 2)
			)
			(3
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
				(humpty setScript: 0 setLoop: 0 setCycle: Fwd)
				(= cycles 2)
			)
			(1
				(proc411_1)
				(if (and global129 (<= global130 47))
					(global129 setMotion: NewFollow gEgo 30)
				)
				(self dispose:)
			)
		)
	)
)

(instance faceEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setCel: 0
					setLoop:
						(cond
							((< (gEgo x:) (- (client x:) 20)) 2)
							((> (gEgo x:) (+ (client x:) 20)) 4)
							(else 3)
						)
				)
				(= ticks 20)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance gestureScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setLoop:
						(cond
							((< (gEgo x:) (- (client x:) 20)) 2)
							((> (gEgo x:) (+ (client x:) 20)) 4)
							(else 3)
						)
				)
				(if (== 2 (Random 1 3))
					(client setCel: (Random 0 (- (NumCels client) 1)))
				)
				(= ticks 20)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance humpty of CDActor
	(properties
		x 108
		y 116
		yStep 1
		view 70
		signal 16384
		cycleSpeed 6
		illegalBits 0
		xStep 1
	)

	(method (init)
		(if ((gGoals at: 16) egoReturned:)
			(= view 920)
			(= y 101)
			(super init:)
			(theHead init: self)
			(ladder init:)
		else
			(super init: &rest)
		)
		(self setCycle: Fwd)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		x 108
		y 101
		z 15
		view 920
		loop 1
		signal 16384
		moveHead 0
	)

	(method (init param1)
		(super init: param1)
		(= z 15)
	)
)

(instance water of Waters2
	(properties
		view 132
		priority 1
		signal 24624
		cycleSpeed 5
	)

	(method (getLoop)
		(= x [local1 pos])
		(= y [local1 (++ pos)])
		(= cel [local1 (++ pos)])
	)

	(method (saveLoop)
		(= [local1 pos] cel)
		(++ pos)
	)
)

(instance ladder of View
	(properties
		x 108
		y 115
		view 59
		loop 1
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(cond
			((= state newState)
				(DoSound sndMASTER_VOLUME global125)
				(client setScript: 0)
				(if global172
					(gCurRoom newRoom: 45) ; mapRoom
				)
				(RedrawCast)
				(HandsOn)
			)
			((not (and (not (& (gEgo onControl: 0) $4000)) (!= local0 3)))
				(gSystemWindow speakingObj: gEgo)
				(Print 900 (+ 524 (Random 0 49)))
				(self cue:)
			)
			(else
				(HandsOff)
				(proc0_7 gEgo humpty)
				(= temp0 (gGoals at: 16))
				(proc0_20)
				(cond
					(local0
						(switch local0
							(1
								(self setScript: converse2 self 143)
							)
							(2
								(self setScript: converse2 self 149)
							)
							(else
								(self cue:)
							)
						)
					)
					((temp0 egoReturned:)
						(self setScript: converse6 self 152)
					)
					((temp0 egoHas:)
						(self setScript: converse5 self 150)
						(if (== global123 6)
							(= global123 0)
						)
						(= local0 3)
					)
					((temp0 egoTold:)
						(= global123 6)
						(self setScript: converse3 self 144)
						(= local0 2)
					)
					(else
						(self setScript: converse1 self 137)
						(temp0 egoTold: 1)
						(= global123 6)
						(= local0 1)
					)
				)
			)
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
				(gEgo say: register self)
			)
			(2
				(humpty say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(humpty say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(humpty say: (++ register) self)
			)
			(7
				(self setScript: atEaseScript self)
			)
			(8
				(= global131 (+ (humpty x:) 13))
				(= global132 (- (humpty y:) 54))
				(= global128 115)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(9
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
				(humpty say: register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (humpty x:) 13))
				(= global132 (- (humpty y:) 54))
				(= global128 115)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(= global123 6)
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
				(gEgo say: register self)
			)
			(2
				(humpty say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(humpty say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(self setScript: atEaseScript self)
			)
			(7
				(= global131 (+ (humpty x:) 13))
				(= global132 (- (humpty y:) 54))
				(= global128 115)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(8
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
				(humpty say: (++ register) self)
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(= global110 ladder)
				(self setScript: (ScriptID 305) self) ; rhymeScript
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(humpty say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(humpty say: (++ register) self)
			)
			(5
				(proc411_1)
				(humpty setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance outCode1 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 11 (gEgo x:) 156))
				(= temp1 104)
			)
			(2
				(= temp0 219)
				(= temp1 (proc0_13 133 (gEgo y:) 152))
			)
			(3
				(= temp0 (proc0_13 15 (gEgo x:) 217))
				(= temp1 155)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 118 (gEgo y:) 138))
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
				(= temp0 (proc0_13 230 (gEgo x:) 256))
				(= temp1 127)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 132 (gEgo y:) 155))
			)
			(3
				(= temp0 (proc0_13 239 (gEgo x:) 259))
				(= temp1 158)
			)
			(4
				(= temp0 228)
				(= temp1 (proc0_13 131 (gEgo y:) 154))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

