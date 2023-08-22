;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Waters2)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm030 0
)

(local
	[local0 38] = [3 0 0 0 0 -14336 90 96 91 133 88 148 93 105 -32657 -14220 113 161 93 175 97 183 116 201 125 258 -32643 -14078 118 228 118 225 111 228 98 258 -32686 0]
	[local38 18] = [72 114 80 73 128 80 113 143 80 117 126 80 240 148 80 182 142 80]
)

(instance rm030 of Rm
	(properties
		picture 30
		style 0
		north 23
		east 31
		west 29
	)

	(method (init)
		(Load rsVIEW 163)
		(super init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 150 (gEgo x:) global62) 40)
				(self setScript: global145)
			)
			(west
				(gEgo posn: 10 (proc0_13 66 (gEgo y:) 96))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo
					posn: 250 (proc0_13 54 (proc0_14 92 (gEgo y:) 115) 131)
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
		(proc0_8 167 80)
		(water30 init:)
		(if (!= [global200 gCurRoomNum] 45)
			(cric init:)
		)
	)

	(method (doit &tmp temp0)
		(cric doit:)
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

	(method (dispose &tmp temp0)
		(if (cric timer:)
			(= temp0 (cric timer:))
			(temp0 dispose:)
			(temp0 delete:)
		)
		(DisposeScript 402)
		(super dispose:)
	)
)

(instance water30 of Waters2
	(properties
		view 163
		priority 14
		signal 24624
	)

	(method (getLoop)
		(= x [local38 pos])
		(= y [local38 (++ pos)])
		(= cel [local38 (++ pos)])
	)

	(method (saveLoop)
		(= [local38 pos] cel)
		(++ pos)
	)
)

(instance cric of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 9 22))
			)
			(1
				(if (or (not (User controls:)) (gCurRoom script:))
					(= cycles 1)
				else
					(Timer
						set60ths:
							self
							(+
								4
								(DoAudio
									audPLAY
									(if (Random 0 1)
										35
									else
										(Random 574 577)
									)
								)
							)
					)
				)
				(= state -1)
			)
		)
	)
)

