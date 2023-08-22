;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use Waters)
(use NameFind)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm029 0
)

(local
	[local0 31] = [2 0 0 0 -14078 102 202 100 126 103 81 100 52 93 57 81 93 -32702 -14214 65 158 83 166 85 196 80 220 81 240 -32710 0]
	[local31 12] = [150 111 0 153 123 0 140 139 0 107 119 0]
)

(instance rm029 of Rm
	(properties
		picture 29
		style 0
		north 22
		east 30
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(Load rsSCRIPT 974)
		(gEgo setMotion: Freeway (= global75 @local0))
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
				(gEgo posn: 250 (proc0_13 72 (gEgo y:) 105))
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
		(DisposeScript 974)
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
		(= x [local31 pos])
		(= y [local31 (++ pos)])
		(= cel [local31 (++ pos)])
	)

	(method (saveLoop)
		(= [local31 pos] cel)
		(++ pos)
	)
)

(instance frogy of Act
	(properties
		y 208
		x 31
		yStep 1
		view 804
		priority 14
		signal 26640
		cycleSpeed 1
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
				(frogy setMotion: LeapTo 31 155 0 setCycle: End self)
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
					(DoAudio audPLAY 39)
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
				(frogy cel: 0 setLoop: 2 cycleSpeed: 3 setCycle: CT 3 1 self)
			)
			(13
				(frogy yStep: 3 setMotion: MoveTo 61 111)
				(= cycles 9)
			)
			(14
				(frogy
					cel: 4
					cycleSpeed: 9
					setCycle: End
					posn: (+ (frogy x:) 21) (- (frogy y:) 38)
					yStep: 3
					setMotion: LeapTo 148 127 0 self 60
				)
				(if (and (not (gCurRoom script:)) (User controls:))
					(DoAudio audWPLAY 29)
				)
			)
			(15
				(if (and (not (gCurRoom script:)) (User controls:))
					(DoAudio audPLAY 29)
				)
				(frogy
					posn: 149 129
					setLoop: 3
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(16
				(frogy dispose:)
				(DisposeScript 974)
			)
		)
	)
)

