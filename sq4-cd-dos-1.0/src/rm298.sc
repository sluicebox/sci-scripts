;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 298)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Feature)
(use Motion)
(use System)

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
		(nest init:)
		(theEyes init:)
		(hair init: setCycle: Fwd)
		(Roger init:)
		(theView init:)
		(bird init:)
		(self setScript: sRm298)
	)
)

(instance sRm298 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(nest setMotion: MoveTo 130 252 self)
			)
			(2
				(gCurRoom newRoom: 297)
			)
		)
	)
)

(instance nest of Sq4Actor
	(properties
		x -51
		y 177
		yStep 1
		view 299
		moveSpeed 12
		lookStr 2 ; "You see a huge nest in the distance below you."
	)
)

(instance hair of Sq4Prop
	(properties
		x 174
		y 61
		view 298
		priority 6
		signal 16
		lookStr 1 ; "Your hair is the last thing on your mind right now (even though it's on top of your head)!"
	)
)

(instance theEyes of Sq4Prop
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

(instance bird of Sq4Feature
	(properties
		nsBottom 189
		nsRight 319
		onMeCheck 128
		lookStr 3 ; "Wow! This bird could use some skin lotion on those talons."
	)
)

(instance Roger of Sq4Feature
	(properties
		noun 7
		nsBottom 189
		nsRight 319
		onMeCheck 16
		lookStr 4 ; "You look pretty pathetic hanging under the pterodactyl."
	)
)

(instance theView of Sq4Feature
	(properties
		x 159
		z -94
		nsBottom 189
		nsRight 319
		sightAngle 90
		lookStr 5 ; "Wow! What an incredible view!"
	)
)

