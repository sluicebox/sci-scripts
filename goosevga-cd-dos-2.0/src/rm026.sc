;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm026 0
)

(local
	[local0 54] = [3 0 0 0 0 -14103 131 233 116 174 119 158 115 146 107 145 95 159 91 258 -32668 -14079 40 137 77 159 90 140 95 129 96 116 91 102 90 101 82 258 -32767 -14336 61 92 65 107 78 85 88 70 93 25 99 0 -32669 0]
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
		(door init:)
		(gAddToPics add: mailBox doit:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(43
				(gEgo posn: 135 96 loop: 13 cel: 2 init:)
				(self setScript: closeDoorScript)
			)
			(north
				(gEgo posn: 98 86)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 global63 (gEgo x:) global62) 150)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo
					posn:
						10
						(proc0_13 95 (proc0_14 131 (gEgo y:) 138) global61)
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
				(gEgo posn: 250 (proc0_13 137 (gEgo y:) global61))
				(if (and global130 (<= global130 47))
					(global129 observeControl: 128)
				)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
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
				(HandsOff)
				(Timer set60ths: self (DoAudio audPLAY 38))
				(door setCycle: End)
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
				(HandsOff)
				(door setCycle: Beg self)
				(= cycles 4)
			)
			(1
				(DoAudio audPLAY 36)
			)
			(2
				(door stopUpd:)
				(if (== gScore gPossibleScore)
					(HandsOff)
				else
					(HandsOn)
				)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance door of Prop
	(properties
		y 92
		x 158
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
)

(instance smoke of Prop
	(properties
		y 11
		x 237
		view 130
		loop 1
		cycleSpeed 3
	)
)

(instance mailBox of PV
	(properties
		y 111
		x 22
		view 130
		loop 2
		priority 12
		signal 16384
	)
)

