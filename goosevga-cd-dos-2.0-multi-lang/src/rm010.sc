;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm010 0
)

(local
	[local0 35] = [2 0 0 0 -14220 155 110 141 113 132 130 112 85 112 85 -32768 -14185 155 161 140 148 139 147 131 153 125 141 120 138 112 207 112 207 -32768 0]
)

(instance rm010 of Rm
	(properties
		picture 10
		style 0
		south 17
	)

	(method (init)
		(super init:)
		(door init:)
		(gAddToPics add: signPlate doit:)
		(proc0_1)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(south
				(gEgo posn: 133 151)
				(self setScript: gStdWalkIn)
			)
			(36
				(self setScript: closeDoorScript)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 135 130 init:)
			)
		)
		(proc0_8 222 152 136 110)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo onControl: 1) 16384)
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
				(proc0_2)
				(Timer set60ths: self (DoAudio audPLAY 38))
				(door setCycle: End)
			)
			(1
				(gCurRoom newRoom: 36)
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
				(gEgo posn: 136 125 init: setMotion: MoveTo 136 127 self)
				(if global129
					(global129 setMotion: NewFollow gEgo 5)
				)
			)
			(1
				(door setCycle: Beg)
				(= cycles 4)
			)
			(2
				(Timer set60ths: self (DoAudio audPLAY 36))
			)
			(3
				(door stopUpd:)
				(if (== gScore gPossibleScore)
					(gEgo setMotion: MoveTo 133 175)
				else
					(if global129
						(global129 setMotion: NewFollow gEgo 30)
					)
					(proc0_3)
				)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		y 118
		x 125
		view 124
		signal 26625
		cycleSpeed 1
	)

	(method (init)
		(if (== gPrevRoomNum 36)
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

(instance signPlate of PV
	(properties
		y 129
		x 169
		view 124
		loop 1
		priority 12
		signal 16384
	)
)

