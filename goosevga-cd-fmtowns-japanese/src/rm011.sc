;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm011 0
)

(local
	[local0 47] = [2 0 0 0 -14293 155 39 147 59 122 57 115 36 115 36 106 55 96 62 95 83 98 92 84 0 -32722 -14114 155 226 148 193 131 180 131 165 124 158 112 158 99 116 98 114 86 258 -32727 0]
)

(instance rm011 of Rm
	(properties
		picture 11
		style 0
		horizon 9
		north 4
		south 18
	)

	(method (init)
		(Load rsVIEW 138)
		(super init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 85 (gEgo x:) 120) 92)
				(self setScript: global145)
			)
			(south
				(gEgo posn: (proc0_13 95 (gEgo x:) 170) 150)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(flag1 init:)
		(flag2 init:)
		(flag3 init:)
		(flag4 init:)
		(proc0_8 73 140)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
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
)

(instance flag1 of Prop
	(properties)

	(method (init)
		(self view: 138 loop: 0 posn: 97 23 cycleSpeed: 4 setCycle: Fwd)
		(super init:)
	)
)

(instance flag2 of Prop
	(properties)

	(method (init)
		(self view: 138 loop: 1 posn: 161 21 cycleSpeed: 4 setCycle: Fwd)
		(super init:)
	)
)

(instance flag3 of Prop
	(properties)

	(method (init)
		(self view: 138 loop: 2 cel: 0 posn: 141 19 cycleSpeed: 4 setCycle: Fwd)
		(super init:)
	)
)

(instance flag4 of Prop
	(properties)

	(method (init)
		(self view: 138 loop: 2 cel: 1 posn: 99 41 cycleSpeed: 4 setCycle: Fwd)
		(super init:)
	)
)

