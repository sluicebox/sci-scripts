;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use n411)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm012 0
)

(local
	local0
	[local1 42] = [105 196 0 196 0 0 315 0 315 196 162 196 168 150 216 149 200 128 188 127 157 128 157 111 157 86 133 86 132 111 107 112 100 120 78 123 36 123 40 145 107 145]
	[local43 36] = [108 155 0 155 0 0 258 0 258 155 167 155 168 150 216 149 200 128 188 127 166 123 155 114 127 112 111 119 78 123 36 123 40 145 107 145]
	local79
)

(instance rm012 of Rm
	(properties
		picture 12
		style 0
		south 19
	)

	(method (init)
		(= global345 outCode)
		(Load rsVIEW 125)
		(super init:)
		(gCurRoom
			addObstacle:
				(= local79
					((Polygon new:) type: PBarredAccess points: @local1 size: 21 yourself:)
				)
		)
		(if ((gGoals at: 10) egoReturned:)
			(local79 points: @local43 size: 18)
		)
		(NormalEgo)
		(door init:)
		(= global111 wifeBareFoot)
		(switch gPrevRoomNum
			(38
				(gEgo loop: 13 cel: 1 posn: 144 117 init:)
				(self setScript: closeDoor)
			)
			(south
				(if (== global130 41)
					(gEgo posn: 170 130)
				else
					(gEgo posn: 138 139)
				)
				(self setScript: gStdWalkIn 1 10)
			)
			(else
				(gEgo posn: 138 145 init:)
			)
		)
		(= global341 converse)
		(proc0_8)
		(peter init:)
		(if global172
			(self setScript: converse)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo inRect: 125 96 161 116)
					(not ((gGoals at: 10) egoReturned:))
				)
				(self setScript: openDoor)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(DisposeScript 312)
		(super dispose:)
	)
)

(instance doConverse of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 7)
			)
			(1
				(gCurRoom setScript: converse)
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gSfx number: 38 play: self)
				(door setCycle: End self)
			)
			(1)
			(2
				(gCurRoom newRoom: 38)
			)
		)
	)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door setCycle: CT 2 -1 self)
			)
			(1
				(door setCycle: Beg self)
				(gSfx number: 36 play:)
			)
			(2
				(door stopUpd:)
				(if global133
					(gCurRoom setScript: converse)
				else
					(HandsOn)
					(gCurRoom setScript: 0)
				)
			)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(peter setCycle: CT 4 1 self)
			)
			(1
				(peter setCel: 255)
				(theHead init: peter)
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
				(peter setCel: 4)
				(= cycles 2)
			)
			(1
				(peter setCycle: CT 0 -1 self)
			)
			(2
				(= global131 (+ (peter x:) 33))
				(= global132 (- (peter y:) 52))
				(= global128 97)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance atten2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(peter setLoop: 10)
				(theHead init: peter z: 35)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance atEase2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc411_1)
				(theHead dispose:)
				(peter setLoop: 7 setCel: 5)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance peter of CDActor
	(properties
		x 174
		y 123
		view 77
		signal 16384
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init:)
		(if ((gGoals at: 10) egoReturned:)
			(peter posn: 107 112 setLoop: 7 setCel: 5)
			(wifeBareFoot init:)
		)
		(= global109 self)
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance theHead of Head
	(properties
		loop 2
		moveHead 0
	)

	(method (doit)
		(self
			setLoop:
				(cond
					((< (gEgo x:) (- (client x:) 20)) 1)
					((> (gEgo x:) (+ (client x:) 20)) 3)
					(else 2)
				)
		)
		(super doit:)
	)
)

(instance door of Prop
	(properties
		x 132
		y 108
		view 125
		loop 1
		signal 1
	)

	(method (init)
		(super init:)
		(self setCel: (if (== gPrevRoomNum 38) 255 else 0))
		(= global110 door)
	)

	(method (dispose)
		(super dispose:)
		(self addToPic:)
	)

	(method (handleEvent)
		(return 0)
	)

	(method (delete)
		(&= signal $ffdf)
		(super delete:)
	)
)

(instance wifeBareFoot of CDActor
	(properties
		x 142
		y 100
		z 12
		view 77
		loop 9
		signal 1
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(HandsOff)
			(proc0_7 gEgo peter)
			(= temp0 (gGoals at: 10))
			(proc0_20)
			(cond
				(local0
					(switch local0
						(1
							(self setScript: converse2 self 296)
						)
						(2
							(self setScript: converse2 self 301)
						)
						(else
							(self setScript: converse6 self 304)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse7 self 305)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 302)
					((gGoals at: 18) egoReturned: 1)
					(temp0 egoReturned: 1)
					(if (== global123 13)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 297)
					(= global123 13)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 287)
					(temp0 egoTold: 1)
					(= global123 13)
					(= local0 1)
				)
			)
		else
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(HandsOn)
			(RedrawCast)
			(DoSound sndMASTER_VOLUME global125)
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
				(peter say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(peter say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(peter say: (++ register) self)
			)
			(7
				(gEgo say: (++ register) self)
			)
			(8
				(peter say: (++ register) self)
			)
			(9
				(gEgo say: (++ register) self)
			)
			(10
				(self setScript: atEaseScript self)
			)
			(11
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
				(peter say: register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global123 13)
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
				(peter say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(peter say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(self setScript: atEaseScript self)
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
				(peter setLoop: 4 setCycle: CT 4 1 self)
				(global129
					setMotion:
						MoveTo
						(- (global129 x:) 20)
						(- (global129 y:) 13)
						self
				)
			)
			(1)
			(2
				(global129
					setMotion: MoveTo (global129 x:) (- (global129 y:) 5) self
				)
			)
			(3
				(peter setCel: 255)
				(theHead init: peter)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(4
				(gEgo say: register self)
			)
			(5
				(peter say: (++ register) self)
			)
			(6
				(proc411_1)
				(self setScript: (ScriptID 312) self) ; rhymeScript
			)
			(7
				(local79 points: @local43 size: 18)
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
				(self setScript: atten2 self)
			)
			(1
				(peter say: register self)
			)
			(2
				(self setScript: atEase2 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance converse7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: atten2 self)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(peter say: (++ register) self)
			)
			(3
				((Head new:) moveHead: 0 init: wifeBareFoot setLoop: 11 z: 16)
				(global247 add: (wifeBareFoot head:))
				(= cycles 2)
			)
			(4
				(wifeBareFoot say: (++ register) self)
			)
			(5
				((wifeBareFoot head:) dispose:)
				(self setScript: atEase2 self)
			)
			(6
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
				(= temp0 (proc0_13 133 (gEgo x:) 157))
				(= temp1 80)
			)
			(2
				(= temp0 219)
				(= temp1 (proc0_13 126 (gEgo y:) 148))
			)
			(3
				(= temp0 (proc0_13 108 (gEgo x:) 166))
				(= temp1 158)
			)
			(4
				(= temp0 30)
				(= temp1 (proc0_13 123 (gEgo y:) 144))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

