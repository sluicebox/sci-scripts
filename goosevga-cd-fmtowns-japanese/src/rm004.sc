;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Waters2)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm004 0
)

(local
	[local0 49] = [4 0 0 0 0 0 -14336 122 98 123 101 94 111 65 100 65 100 -32768 -14078 120 179 121 169 120 164 112 165 102 160 81 147 64 160 64 160 -32768 -14078 139 222 139 214 -32613 -14302 155 34 145 0 -32628 0]
	local49 = 1
	[local50 6] = [216 96 80 53 97 80]
)

(instance rm004 of Rm
	(properties
		picture 4
		style 0
		horizon 66
		east 5
		south 11
		west 3
	)

	(method (init)
		(super init:)
		(Load rsVIEW 123)
		(gEgo setMotion: Freeway (= global75 @local0))
		(pools init: nLoops: 2)
		(rightSquirt init:)
		(leftSquirt init:)
		(if (== gPrevRoomNum 37)
			(door setScript: closeDoorScript)
		)
		(proc0_1)
		(switch gPrevRoomNum
			(37
				(gEgo posn: 132 66)
				(gAddToPics add: doorFame doit:)
				(self setScript: global145)
			)
			(south
				(gEgo posn: (proc0_13 51 (gEgo x:) 152) 152)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 232 (proc0_13 118 (gEgo y:) 132))
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 58 (proc0_13 119 (gEgo y:) 138))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 130 140 init:)
			)
		)
		(proc0_8 86 137)
	)

	(method (doit &tmp temp0 temp1)
		(if
			(and
				(gEgo mover:)
				(!=
					(= temp1
						(cond
							((& (gEgo onControl: 1) $0200) 4)
							((& (gEgo onControl: 1) $0020) 3)
							(else 2)
						)
					)
					(gEgo yStep:)
				)
			)
			(gEgo yStep: temp1)
			(InitBresen (gEgo mover:))
		)
		(cond
			(script
				(script doit:)
			)
			((== gScore gPossibleScore)
				(++ gScore)
				(self setScript: (ScriptID 205)) ; walkTo
			)
			((& (gEgo onControl: 1) $0002)
				(gStdWalkOut register: 2)
				(self setScript: gStdWalkOut)
			)
			((& (gEgo onControl: 1) $0008)
				(gStdWalkOut register: 4)
				(self setScript: gStdWalkOut)
			)
			((== 1 (gEgo edgeHit:))
				(self setScript: openDoor)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
		(if (and local49 (not script) (not (door script:)))
			(self cue:)
		)
		(= local49 (| script (door script:)))
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
			(else
				(event claimed: 1)
				(proc0_2)
				(self setScript: converse)
			)
		)
	)

	(method (cue)
		(Timer set60ths: self (DoAudio audPLAY 27))
	)

	(method (setScript &tmp temp0)
		(if (= temp0 (self timer:))
			(temp0 dispose:)
		)
		(super setScript: &rest)
	)

	(method (dispose &tmp temp0)
		(if (= temp0 (self timer:))
			(temp0 dispose:)
			(temp0 delete:)
		)
		(DoAudio audSTOP)
		(DisposeScript 402)
		(super dispose:)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo say: (Random 524 573) self)
			)
			(1
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setPri: 2 setLoop: 3 setMotion: MoveTo 131 78 self)
				(= cycles 70)
			)
			(1
				(DoAudio audPLAY 580)
				(= cycles 10)
			)
			(2
				(doorFame loop: 5)
				(gAddToPics add: doorFame doit:)
				(door init: setCel: 0 setCycle: End self)
			)
			(3
				(gCurRoom newRoom: 37)
			)
		)
	)
)

(instance closeDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door init: setCel: 255 setCycle: CT 1 -1 self)
			)
			(1
				(doorFame loop: 4)
				(gAddToPics add: doorFame doit:)
				(door dispose:)
				(Timer set60ths: self (DoAudio audPLAY 581))
			)
			(2
				(if (== gScore gPossibleScore)
					(proc0_11 160 143)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance door of Prop
	(properties
		y 36
		x 131
		z -30
		view 123
		loop 4
		signal 16400
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCel: (if (== gPrevRoomNum 37) --UNKNOWN-PROPERTY-- else 0))
	)
)

(instance pools of Waters2
	(properties
		view 123
		priority 4
		signal 24624
		cycleSpeed 1
	)

	(method (getLoop)
		(= x [local50 pos])
		(= y [local50 (++ pos)])
		(= cel [local50 (++ pos)])
	)

	(method (saveLoop)
		(= [local50 pos] cel)
		(++ pos)
	)
)

(instance rightSquirt of Prop
	(properties
		y 66
		x 218
		view 123
		loop 2
		priority 4
		signal 16400
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance leftSquirt of Prop
	(properties
		y 68
		x 45
		view 123
		loop 3
		cel 3
		priority 4
		signal 16400
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance doorFame of PV
	(properties
		y 66
		x 131
		view 123
		loop 5
		priority 0
		signal 16384
	)
)

