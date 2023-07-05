;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 298)
(include sci.sh)
(use Main)
(use SQRoom)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm298 0
)

(instance rm298 of SQRoom
	(properties
		picture 298
	)

	(method (init &tmp [temp0 50])
		(= gUseSortedFeatures 0)
		(HandsOn)
		(Load rsVIEW 298)
		(Load rsVIEW 299)
		(self setRegions: 703) ; butte
		(super init:)
		(eyes setScript: eyeScript init:)
		(hair init: setCycle: Fwd)
		(nest init:)
		(theView init:)
		(self setScript: rmScript)
	)
)

(instance eyeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 2))
			)
			(1
				(eyes setCel: (Random 0 2))
				(= cycles 1)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(nest setMotion: MoveTo 130 252 self)
			)
			(2
				(= cycles 30)
			)
			(3
				(gCurRoom newRoom: 297)
			)
		)
	)
)

(instance hair of Prop
	(properties
		x 174
		y 61
		description {your hair}
		lookStr {*** Worrying about your hair is about the last thing on your mind right now!}
		view 298
		priority 6
		signal 16
	)
)

(instance eyes of Prop
	(properties
		x 198
		y 83
		view 298
		loop 1
		priority 5
		signal 16
	)
)

(instance nest of Actor
	(properties
		x -15
		y 189
		description {nest}
		lookStr {*** You see a huge nest in the distance below you.}
		yStep 1
		view 299
		signal 4096
		xStep 1
	)
)

(instance theView of Feature
	(properties
		x 159
		y 94
		nsBottom 189
		nsRight 319
		description {view}
		sightAngle 90
		lookStr {*** Wow what an incredible view!}
	)
)

