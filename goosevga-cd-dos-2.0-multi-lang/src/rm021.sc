;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use n411)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm021 0
)

(local
	[local0 47] = [2 0 0 0 -14287 155 62 143 19 136 19 118 32 96 56 95 40 108 49 113 109 121 154 112 196 122 198 117 197 100 146 100 146 -32768 -14107 0 229 100 209 101 223 112 228 132 256 -32615 0]
	local47
)

(instance rm021 of Rm
	(properties
		picture 21
		style 0
		south 28
	)

	(method (init)
		(Load rsVIEW 128)
		(super init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(south
				(gEgo posn: (proc0_13 54 (gEgo x:) 249) 150)
				(self setScript: gStdWalkIn)
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
		(proc0_8)
		(if (and global130 (<= global130 47) (== gPrevRoomNum 44))
			(global129 posn: 189 116)
		)
		(if (not ((gGoals at: 11) egoReturned:))
			(mother init:)
			(kid0 init:)
			(kid1 init:)
			(kid2 init:)
			(kid3 init:)
			(kid4 init:)
			(self cue:)
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
				(HandsOff)
				(self setScript: openDoorScript)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
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
			((not ((gGoals at: 11) egoReturned:))
				(event claimed: 1)
				(self setScript: converse)
			)
		)
	)

	(method (cue)
		(Timer set60ths: self (DoAudio audPLAY 18))
	)

	(method (dispose &tmp temp0)
		(if (= temp0 (self timer:))
			(temp0 dispose:)
			(temp0 delete:)
		)
		(DoAudio audSTOP)
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
				(DoAudio audPLAY 38)
			)
			(2
				(gEgo setMotion: MoveTo 196 86 self)
			)
			(3
				(gEgo setMotion: MoveTo 182 86 self)
			)
			(4
				(HandsOn)
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
				(HandsOff)
				(gEgo setMotion: MoveTo 196 86 self)
			)
			(1
				(gEgo setMotion: MoveTo 203 100 self)
			)
			(2
				(door setCycle: Beg self)
				(= cycles 4)
			)
			(3
				(DoAudio audPLAY 36)
			)
			(4
				(gEgo setMotion: MoveTo 210 118 self)
				(door stopUpd:)
			)
			(5
				(HandsOn)
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
					setAvoider: (Avoid new:)
					setMotion: MoveTo 194 132 self
				)
			)
			(1
				(gEgo setAvoider: 0 ignoreControl: 4)
				(proc0_7 gEgo mother)
				((gCurRoom timer:) dispose:)
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
		y 125
		x 231
		yStep 1
		view 79
		loop 5
		cel 3
		cycleSpeed 4
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

(instance kid0 of Act
	(properties
		y 68
		x 92
		view 79
		priority 10
		signal 16
		cycleSpeed 3
		illegalBits 0
		moveSpeed 1
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
)

(instance hole of View
	(properties
		y 148
		x 67
		view 79
		loop 10
		signal 16384
	)
)

(instance kid1 of Act
	(properties
		y 148
		x 75
		view 79
		loop 1
		cycleSpeed 3
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
		(= global111 self)
	)
)

(instance kid2 of Act
	(properties
		y 69
		x 129
		view 79
		loop 2
		signal 8192
		cycleSpeed 3
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
)

(instance kid3 of Act
	(properties
		y 122
		x 45
		view 79
		loop 3
		priority 12
		signal 10242
		cycleSpeed 2
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
		(= global113 self)
	)
)

(instance kid4 of Act
	(properties
		y 38
		x 199
		view 79
		loop 4
		priority 12
		signal 8208
		cycleSpeed 3
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
)

(instance door of Prop
	(properties
		y 90
		x 211
		view 128
		priority 6
		signal 16385
		cycleSpeed 1
	)

	(method (init)
		(self setCel: (if (== gPrevRoomNum 44) 5 else 0))
		(super init:)
		(= global122 self)
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
		(= temp0 (gGoals at: 11))
		(proc0_20)
		(cond
			(local47
				(self setScript: converse2 self local47)
			)
			((temp0 egoHas:)
				(self setScript: converse5 self 326)
				(temp0 egoReturned: 1)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 322)
				(= local47 325)
			)
			(else
				(self setScript: converse1 self 314)
				(temp0 egoTold: 1)
				(= local47 321)
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
				(if (== global123 14)
					(= global123 0)
				)
				(self dispose:)
			)
		)
	)
)

