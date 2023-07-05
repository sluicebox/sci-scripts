;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 525)
(include sci.sh)
(use Main)
(use brain)
(use SQRoom)
(use PolyPath)
(use System)

(public
	rm525 0
)

(instance rm525 of SQRoom
	(properties
		picture 525
		style 30
		north 510
		south 541
		west 520
		vanishingX -200
		vanishingY -280
	)

	(method (init)
		(switch gPrevRoomNum
			(north
				(self setScript: enterScript 0 (brain level:))
			)
			(541
				(self setScript: enterScript 0 0)
			)
			(else
				(HandsOn)
			)
		)
		(gEgo init:)
		(self setRegions: 704) ; brain
		(super init:)
		(switch (brain level:)
			(2
				(brain makePolygon: 0 132 57 132 91 189 0 189)
				(brain makePolygon: 0 43 44 112 0 112)
				(brain makePolygon: 7 1 144 189 319 189 319 0)
			)
			(3
				(brain makePolygon: 0 21 117 21 102 0 0 0)
				(brain makePolygon: 127 0 149 22 234 22 318 79 318 1)
				(brain makePolygon: 0 37 223 37 390 164 217 164 135 74 0 74)
				(brain makePolygon: 0 99 115 99 184 183 319 183 319 189 0 189)
			)
		)
		((ScriptID 704 4) ; terminal2
			x: 6
			y: 106
			nsLeft: 2
			nsTop: 103
			nsBottom: 109
			nsRight: 11
			sightAngle: 90
			init:
		)
		((ScriptID 704 5) ; terminal3
			x: 70
			y: 63
			nsLeft: 63
			nsTop: 58
			nsBottom: 69
			nsRight: 77
			sightAngle: 90
			init:
		)
	)

	(method (doit)
		(super doit:)
		(if (== (brain level:) 3)
			(if (gEgo inRect: 0 0 64 40)
				(gEgo setPri: 4)
			else
				(gEgo setPri: -1)
			)
		)
		(cond
			(script)
			((StepOn gEgo 4)
				(self setScript: oSS 0 4)
			)
			((StepOn gEgo 16)
				(self setScript: oSS 0 16)
			)
			((and (StepOn gEgo 32) (== (brain level:) 2))
				(self setScript: exitScript)
			)
			((StepOn gEgo 8)
				(brain exitDir: 135)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath -8 -1 self)
			)
			(1
				(gCurRoom newRoom: 510)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2 temp3 temp4 temp5)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch register
					(0
						(= temp2 150)
						(= temp3 240)
						(= temp4 113)
						(= temp5 174)
					)
					(3
						(= temp2 95)
						(= temp3 -8)
						(= temp4 134)
						(= temp5 24)
					)
					(else
						(= temp2 -8)
						(= temp3 -1)
						(= temp4 32)
						(= temp5 48)
					)
				)
				(gEgo x: temp2 y: temp3 setMotion: PolyPath temp4 temp5 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance oSS of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 ((gEgo mover:) x:))
				(= temp1 ((gEgo mover:) y:))
				(HandsOff)
				(if (> temp0 319)
					(if (== register 16)
						(gEgo setMotion: PolyPath 294 173 self)
					else
						(gEgo setMotion: PolyPath 308 87 self)
					)
				else
					(gEgo setMotion: PolyPath temp0 temp1 self)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

