;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use MGRoom)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm025 0
)

(local
	local0
)

(instance rm025 of MGRoom
	(properties
		picture 25
		north 18
		east 26
		south 32
		west 24
		edgeN 83
	)

	(method (init)
		(= picture 25)
		(= global305 outCode)
		(super init:)
		(if (or (== gLanguage 2) (== gLanguage 3))
			(self picture: (+ 25 (* 100 gLanguage)))
			(gCurRoom drawPic: (+ 25 (* 100 gLanguage)))
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 358 96 200 101 193 98 198 90 190 77 164 77 162 85 152 92 123 95 95 87 -100 84 -100 130 115 130 109 141 -100 141 -100 186 358 186 358 141 160 145 153 131 358 131
					yourself:
				)
		)
		(proc0_1)
		(if (!= (gGame printLang:) 33)
			(sparkle init:)
		)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 181 83)
				(self setScript: gStdClimbIn)
			)
			(south
				(gEgo posn: 130 145)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo
					posn:
						26
						(proc0_13
							96
							(proc0_14 125 (gEgo y:) 143)
							(gCurRoom edgeS:)
						)
				)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo
					posn:
						231
						(proc0_13
							101
							(proc0_14 125 (gEgo y:) 145)
							(gCurRoom edgeS:)
						)
				)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo posn: global173 global174 init:)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 150 120 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8 56 102)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== gScore gPossibleScore)
				(self setScript: (ScriptID 205)) ; walkTo
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		x 132
		y 72
		priority 111
		view 148
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self setCycle: End self)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance outCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 170 (gEgo x:) 189))
				(= temp1 83)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 101 (proc0_14 125 param2 141) 145))
			)
			(3
				(= temp0 (proc0_13 3 (gEgo x:) 255))
				(= temp1 158)
			)
			(4
				(= temp0 0)
				(= temp1 (proc0_13 90 (proc0_14 125 param2 141) 145))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 2)
	)
)

