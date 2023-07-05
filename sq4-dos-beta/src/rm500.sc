;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use brain)
(use SQRoom)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	rm500 0
)

(instance rm500 of SQRoom
	(properties
		picture 500
		style 30
		east 505
		south 515
		vanishingX 380
		vanishingY -75
	)

	(method (init)
		(Load rsVIEW 508)
		(if (== gPrevRoomNum 515)
			(self setScript: enterScript)
		else
			(HandsOn)
		)
		(gEgo init:)
		(self setRegions: 704) ; brain
		(super init:)
		(brain makePolygon: 0 189 0 0 319 0 319 104 165 104 59 189)
		(brain makePolygon: 110 189 174 125 319 125 319 189)
		((ScriptID 704 5) ; terminal3
			x: 237
			y: 90
			nsLeft: 230
			nsTop: 85
			nsBottom: 96
			nsRight: 244
			sightAngle: 90
			init:
		)
		(light init: setCycle: Fwd)
	)

	(method (doit)
		(super doit:)
		(if (StepOn gEgo 8)
			(brain exitDir: 225)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 52 y: 229 setMotion: PolyPath 98 183 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance light of Prop
	(properties
		x 110
		y 49
		description {light}
		lookStr {The strange light pulses toward the center structure.}
		view 508
	)
)

