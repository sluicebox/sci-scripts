;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 298)
(include sci.sh)
(use Main)
(use eRS)
(use Feature)
(use Motion)
(use Actor)

(public
	rm298 0
)

(local
	local0
	local1
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
		(eyes init:)
		(hair init: setCycle: Fwd)
		(bird init:)
		(Roger init:)
		(nest init:)
		(theView init:)
	)
)

(instance hair of Prop
	(properties
		x 174
		y 61
		description {your hair}
		lookStr {Your hair is the last thing on your mind right now (even though it is on top of your head)!}
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

	(method (init)
		(= local1 (Random 10 20))
		(super init: &rest)
		(self doit:)
	)

	(method (doit)
		(super doit:)
		(if (== (-- local1) 0)
			(= local1 (Random 10 20))
			(self setCel: (Random 0 2))
		)
	)
)

(instance nest of View
	(properties
		x -15
		y 189
		description {nest}
		lookStr {You see a huge nest in the distance below you.}
		yStep 1
		view 299
		signal 4096
	)

	(method (init)
		(= local0 0)
		(super init: &rest)
		(self doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			((or (<= x 130) (<= y 252))
				(self x: (+ x --UNKNOWN-PROPERTY--) y: (+ y yStep))
			)
			((>= (++ local0) 30)
				(gCurRoom newRoom: 297)
			)
		)
	)
)

(instance bird of Feature
	(properties
		nsBottom 189
		nsRight 319
		description {bird}
		onMeCheck 128
		lookStr {Wow! This bird could use some skin lotion on those talons.}
	)
)

(instance Roger of Feature
	(properties
		nsBottom 189
		nsRight 319
		description {roger}
		onMeCheck 16
		lookStr {You look pretty pathetic hanging under the pterodactyl.}
	)
)

(instance theView of Feature
	(properties
		x 159
		z -94
		nsBottom 189
		nsRight 319
		description {view}
		sightAngle 90
		lookStr {Wow what an incredible view!}
	)
)

