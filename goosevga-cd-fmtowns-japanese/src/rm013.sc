;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm013 0
)

(local
	[local0 50] = [3 0 0 0 0 -14272 155 83 133 51 121 17 118 23 -32679 -14224 75 112 87 102 93 96 100 113 105 107 113 107 118 128 120 136 115 143 102 174 -32704 -14079 118 154 128 145 123 143 117 155 102 211 -32677 0]
	local50
)

(instance rm013 of Rm
	(properties
		picture 13
		style 0
		north 6
		east 14
		south 20
		west 12
	)

	(method (init)
		(proc0_1)
		(super init:)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(39
				(gEgo loop: 1 posn: 143 107 init:)
			)
			(north
				(gEgo posn: 70 79)
				(self setScript: global145)
			)
			(east
				(gEgo posn: 244 (proc0_13 114 (gEgo y:) global61))
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 70 (gEgo x:) global62) 150)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 124 138 init:)
			)
		)
		(proc0_8)
		(if (not ((gGoals at: 4) egoReturned:))
			(mary init:)
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
			((not ((gGoals at: 4) egoReturned:))
				(event claimed: 1)
				(proc0_2)
				(proc0_7 gEgo mary)
				(self setScript: converse)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((gEgo inRect: 139 100 161 106)
				(gCurRoom newRoom: 39)
			)
			((== (gEgo onControl:) 4)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(DisposeScript 313)
		(DisposeScript 983)
		(super dispose:)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mary setCel: 0)
				(theHead init: mary)
				(= cycles 2)
			)
			(1
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
				(theHead dispose:)
				(mary setCel: 1)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance mary of CDActor
	(properties
		y 143
		x 63
		yStep 1
		view 69
		cel 1
		signal 16384
		cycleSpeed 3
		illegalBits 0
		xStep 1
	)

	(method (init)
		(super init:)
		(self stopUpd:)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		view 69
		loop 2
		moveHead 0
	)

	(method (init param1)
		(super init: param1)
		(self stopUpd:)
	)

	(method (doit)
		(self
			setLoop:
				(cond
					((< (gEgo y:) (client y:)) 2)
					((> (gEgo y:) (+ (client y:) 10)) 1)
					(else 3)
				)
		)
		(super doit:)
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
		(proc0_3)
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (gGoals at: 4))
		(proc0_20)
		(cond
			(local50
				(switch local50
					(1
						(self setScript: converse2 self 219)
					)
					(2
						(self setScript: converse2 self 225)
					)
				)
			)
			((temp0 egoHas:)
				(self setScript: converse5 self 226)
				(temp0 egoReturned: 1)
				(if (== global123 9)
					(= global123 0)
				)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 220)
				(= global123 9)
				(= local50 2)
			)
			(else
				(self setScript: converse1 self 213)
				(temp0 egoTold: 1)
				(= global123 9)
				(= local50 1)
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
				(mary say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(mary say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(mary say: (++ register) self)
			)
			(7
				(= global131 (+ (mary x:) 13))
				(= global132 (- (mary y:) 52))
				(= global128 103)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(8
				(self setScript: atEaseScript self)
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
				(mary say: register self)
			)
			(2
				(= global131 (+ (mary x:) 13))
				(= global132 (- (mary y:) 52))
				(= global128 103)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(= global123 9)
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
				(mary say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(mary say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(mary say: (++ register) self)
			)
			(6
				(= global131 (+ (mary x:) 13))
				(= global132 (- (mary y:) 52))
				(= global128 103)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(7
				(self setScript: atEaseScript self)
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
				(mary say: register self)
			)
			(2
				(self setScript: (ScriptID 313) self) ; rhymeScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

