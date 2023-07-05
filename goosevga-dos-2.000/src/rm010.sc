;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm010 0
)

(instance rm010 of Rm
	(properties
		picture 10
		style 0
		south 17
	)

	(method (init)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 117 155 118 196 0 196 0 0 315 3 315 196 151 194 153 155 165 140 148 137 150 126 163 126 162 122 145 121 142 108 131 108 119 121 108 136
					yourself:
				)
		)
		(door init:)
		(signPlate init: stopUpd:)
		(proc0_1)
		(switch gPrevRoomNum
			(south
				(gEgo posn: 133 139)
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
				(gSfx number: 38 play:)
				(door setCycle: End self)
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
				(door setCycle: Beg self)
				(gSfx number: 36 play:)
			)
			(2
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
		x 125
		y 118
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

	(method (onMe)
		(return 0)
	)
)

(instance signPlate of View
	(properties
		x 169
		y 129
		view 124
		loop 1
		priority 12
		signal 16384
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 117 (gEgo x:) 146))
				(= temp1 99)
			)
			(2
				(= temp0 175)
				(= temp1 (proc0_13 122 (gEgo y:) 144))
			)
			(3
				(= temp0 (proc0_13 118 (gEgo x:) 153))
				(= temp1 158)
			)
			(4
				(= temp0 99)
				(= temp1 (proc0_13 127 (gEgo y:) 141))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

