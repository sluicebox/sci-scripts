;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use brain)
(use eRS)
(use Sq4Feature)
(use PolyPath)
(use Motion)
(use System)

(public
	rm510 0
)

(instance rm510 of SQRoom
	(properties
		picture 510
		style 10
		south 525
		west 505
		vanishingX -10
		vanishingY -30
	)

	(method (init)
		(Load rsVIEW 508)
		(gEgo init:)
		(switch gPrevRoomNum
			(south
				(self setScript: enterScript 0 (brain level:))
			)
			(else
				(HandsOn)
			)
		)
		(self setRegions: 704) ; brain
		(super init:)
		(if (== gPrevRoomNum 1)
			(gEgo x: 100 y: 100)
			(brain level: 2)
			(= gPrevRoomNum 525)
		)
		(switch (brain level:)
			(2
				(brain
					makePolygon: 0 167 91 167 109 189 0 189
					makePolygon: 0 0 319 0 319 189 154 189 119 149 0 149
				)
			)
			(3
				(brain
					makePolygon: 0 126 144 126 207 189 0 189
					makePolygon: 0 0 319 0 319 189 260 189 156 105 0 108
				)
			)
		)
		((ScriptID 704 5) ; terminal3
			x: 84
			y: 93
			nsLeft: 77
			nsTop: 88
			nsBottom: 98
			nsRight: 91
			sightAngle: 90
			init:
		)
		(light init: setCycle: Fwd)
		(roomFeature init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 8)
				(brain exitDir: 135)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch register
					(3
						(= temp1 279)
						(= temp2 227)
						(= temp3 229)
						(= temp4 183)
					)
					(else
						(= temp1 150)
						(= temp2 227)
						(= temp3 125)
						(= temp4 183)
					)
				)
				(gEgo x: temp1 y: temp2 setMotion: PolyPath temp3 temp4 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance light of Sq4Prop
	(properties
		x 209
		y 49
		view 508
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 500 say: 1) ; "The strange light pulses toward the center structure."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roomFeature of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 500 say: 2) ; "This maze of cables, ducts, pipes, and glowing panels gives the super brain computer a sense of being alive..."
			)
			(2 ; Talk
				(gNarrator modNum: 500 say: 3) ; "You'd better not. Something might answer."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

