;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Waters2)
(use n411)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm004 0
)

(local
	local0 = 1
	[local1 6] = [216 96 80 53 97 80]
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
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 296 119 166 119 166 95 154 61 292 61
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 145 36 145 37 177 0 175
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 223 138 284 138 289 179 217 186
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 73 108 60 92 121 0 121
					yourself:
				)
		)
		(Load rsVIEW 123)
		(pools init: nLoops: 2)
		(rightSquirt init:)
		(leftSquirt init:)
		(door init: stopUpd:)
		(if (== gPrevRoomNum 37)
			(door setScript: closeDoorScript)
		else
			(RedrawCast)
			(if global157
				(fountainS play:)
			)
		)
		(NormalEgo)
		(switch gPrevRoomNum
			(37
				(gEgo posn: 132 66)
				(self setScript: global145)
			)
			(south
				(gEgo posn: (proc0_13 51 (gEgo x:) 152) 139)
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
		(= local0 (| script (door script:)))
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
				(HandsOff)
				(self setScript: converse)
			)
		)
	)

	(method (dispose &tmp temp0)
		(DoAudio audSTOP)
		(fountainS stop:)
		(DisposeScript 402)
		(super dispose: &rest)
	)
)

(instance fountainS of Sound
	(properties
		flags 1
		number 27
		loop -1
	)

	(method (stop)
		(if handle
			(gLongSong play:)
			(super stop: &rest)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo loop: 13 cel: 1)
				((gEgo head:) loop: 8 doit:)
				(proc411_0 (gEgo head:))
				(= cycles 1)
			)
			(1
				(gEgo say: (Random 524 573) self)
			)
			(2
				(proc411_1)
				(HandsOn)
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
				(HandsOff)
				(gEgo setPri: 2 setLoop: 3 setMotion: MoveTo 131 78 self)
				(= cycles 70)
			)
			(1
				(gSfx number: 38 play:)
				(= cycles 10)
			)
			(2
				(door startUpd: setCycle: End self)
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
				(door startUpd: setCel: 255 setCycle: Beg self)
				(gSfx number: 36 play:)
			)
			(1
				(if global157
					(fountainS play:)
				)
				(door stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 131
		y 36
		z -30
		view 123
		loop 4
		signal 16400
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(self setCel: (if (== gPrevRoomNum 37) --UNKNOWN-PROPERTY-- else 0))
	)

	(method (onMe)
		(return 0)
	)
)

(instance pools of Waters2
	(properties
		view 123
		priority 4
		signal 24624
		cycleSpeed 7
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

(instance rightSquirt of Prop
	(properties
		x 218
		y 66
		view 123
		loop 2
		priority 4
		signal 16400
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance leftSquirt of Prop
	(properties
		x 45
		y 68
		view 123
		loop 3
		cel 3
		priority 4
		signal 16400
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 108 (gEgo x:) 154))
				(= temp1 54)
			)
			(2
				(= temp0 263)
				(= temp1 (proc0_13 119 (gEgo y:) 137))
			)
			(3
				(= temp0 (proc0_13 36 (gEgo x:) 222))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 122 (gEgo y:) 144))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

