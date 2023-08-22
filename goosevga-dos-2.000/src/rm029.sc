;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use LeapTo)
(use Waters)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm029 0
)

(local
	[local0 12] = [150 111 0 153 123 0 140 139 0 107 119 0]
)

(instance rm029 of Rm
	(properties
		picture 29
		style 0
		north 22
		east 30
	)

	(method (init)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 315 196 0 196 0 0 86 70 51 79 51 94 88 105 315 105
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 142 33 227 31 233 60 217 78 165 81 130 68
					yourself:
				)
		)
		(NormalEgo)
		(Load rsSCRIPT 106)
		(switch gPrevRoomNum
			(north
				(if (> (gEgo x:) 160)
					(gEgo posn: 244 59)
				else
					(gEgo posn: 107 65)
				)
				(self setScript: global145)
			)
			(east
				(gEgo posn: 231 (proc0_13 72 (gEgo y:) 105))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8 153 97)
		(water init:)
		(frogy init:)
	)

	(method (doit &tmp temp0)
		(water doit:)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $0004)
				(self setScript: gStdClimbOut 0 1)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (dispose)
		(DisposeScript 106)
		(DisposeScript 401)
		(super dispose:)
	)
)

(instance water of Waters
	(properties
		priority 13
		view 176
	)

	(method (getLoop)
		(= x [local0 pos])
		(= y [local0 (++ pos)])
		(= cel [local0 (++ pos)])
	)

	(method (saveLoop)
		(= [local0 pos] cel)
		(++ pos)
	)
)

(instance frogy of Actor
	(properties
		x 31
		y 208
		yStep 1
		view 804
		priority 14
		signal 26640
		cycleSpeed 4
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init:)
		(self setScript: frogScript)
	)
)

(instance frogScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 12 25))
			)
			(1
				(frogy setMotion: MoveTo 31 155 self)
			)
			(2
				(= seconds (Random 2 4))
			)
			(3
				(frogy setCycle: End self)
			)
			(4
				(frogy setCycle: Beg self)
			)
			(5
				(= seconds (Random 1 3))
			)
			(6
				(frogy cel: 0 setCycle: End self)
			)
			(7
				(frogy setCycle: Beg self)
			)
			(8
				(= seconds (Random 1 3))
			)
			(9
				(if (and (not (gCurRoom script:)) (User controls:))
					(if global157
						(DoAudio audPLAY 39)
					else
						(gSfx number: 39 play:)
					)
				)
				(frogy cel: 0 setLoop: 1 setCycle: End self)
			)
			(10
				(frogy setCycle: Beg self)
			)
			(11
				(= seconds (Random 1 3))
			)
			(12
				(frogy cel: 0 setLoop: 2 cycleSpeed: 9 setCycle: CT 3 1 self)
			)
			(13
				(frogy yStep: 3 setMotion: MoveTo 61 111)
				(= ticks 26)
			)
			(14
				(frogy
					cel: 4
					cycleSpeed: 36
					setCycle: End
					posn: (+ (frogy x:) 21) (- (frogy y:) 38)
					yStep: 3
					setMotion: LeapTo 148 127 0 self 60
				)
				(if (and (not (gCurRoom script:)) (User controls:) global157)
					(DoAudio audWPLAY 29)
				)
			)
			(15
				(if (and (not (gCurRoom script:)) (User controls:))
					(if global157
						(DoAudio audPLAY 29)
					else
						(gSfx number: 29 play:)
					)
				)
				(frogy
					posn: 149 129
					setLoop: 3
					cel: 0
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(16
				(frogy dispose:)
				(DisposeScript 106)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 71 (proc0_14 133 (gEgo x:) 232) 253))
				(= temp1 44)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 64 (gEgo y:) 103))
			)
			(3
				(= temp0 (proc0_13 89 (gEgo x:) 249))
				(= temp1 110)
			)
			(4
				(= temp0 45)
				(= temp1 (proc0_13 76 (gEgo y:) 98))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

